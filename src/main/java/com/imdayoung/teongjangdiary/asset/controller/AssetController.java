package com.imdayoung.teongjangdiary.asset.controller;

import com.imdayoung.teongjangdiary.asset.dto.AssetGroupDTO;
import com.imdayoung.teongjangdiary.asset.service.AssetService;
import com.imdayoung.teongjangdiary.global.annotation.LgnUserId;
import com.imdayoung.teongjangdiary.global.response.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AssetController {

    private final AssetService assetService;

    @GetMapping("/api/v1/asset")
    public ApiResponse<List<AssetGroupDTO>> getAssetGroups(@LgnUserId String userId) {

        List<AssetGroupDTO> groupList = assetService.selectAssetList(userId);
        return ApiResponse.success(groupList);
    }
}
