package com.imdayoung.teongjangdiary.asset.service;

import com.imdayoung.teongjangdiary.asset.dto.AssetVO;
import com.imdayoung.teongjangdiary.asset.mapper.AssetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssetServiceImpl implements AssetService {

    private final AssetMapper assetMapper;

    @Override
    public List<AssetVO> selectAssetList(AssetVO vo) {
        return assetMapper.selectAssetList(vo);
    }
}
