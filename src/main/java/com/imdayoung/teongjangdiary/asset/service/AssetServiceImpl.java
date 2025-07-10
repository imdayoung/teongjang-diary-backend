package com.imdayoung.teongjangdiary.asset.service;

import com.imdayoung.teongjangdiary.asset.dto.AssetVO;
import com.imdayoung.teongjangdiary.asset.dto.AssetGroupDTO;
import com.imdayoung.teongjangdiary.asset.mapper.AssetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

@Service
@RequiredArgsConstructor
public class AssetServiceImpl implements AssetService {

    private final AssetMapper assetMapper;

    @Override
    public List<AssetGroupDTO> selectAssetList(String userId) {

        List<AssetGroupDTO> groupList = new ArrayList<>();

        List<AssetVO> assetList = assetMapper.selectAssetList(userId);

        Map<String, List<AssetVO>> grouped = assetList.stream()
                .collect(Collectors.groupingBy(
                        AssetVO::getAssetGroupNm,
                        LinkedHashMap::new,
                        Collectors.toList()
                ));

        for (Map.Entry<String, List<AssetVO>> entry : grouped.entrySet()) {
            String groupName = entry.getKey();
            List<AssetVO> assetsInGroup = entry.getValue();

            int groupAmount = assetsInGroup.stream()
                    .mapToInt(AssetVO::getAmount)
                    .sum();

            int groupPrevAmount = 0;
            if ("카드".equals(groupName)) {
                groupPrevAmount = assetsInGroup.stream()
                        .mapToInt(a -> a.getPrevAmount() != null ? a.getPrevAmount() : 0)
                        .sum();
            }

            groupList.add(AssetGroupDTO.builder()
                    .assetGroupNm(groupName)
                    .amount(groupAmount)
                    .prevAmount(groupPrevAmount)
                    .assets(assetsInGroup)
                    .build());
        }

        return groupList;
    }
}
