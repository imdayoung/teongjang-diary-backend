package com.imdayoung.teongjangdiary.asset.controller;

import com.imdayoung.teongjangdiary.asset.dto.AssetVO;
import com.imdayoung.teongjangdiary.asset.service.AssetService;
import com.imdayoung.teongjangdiary.global.response.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AssetController {

    private final AssetService assetService;

    @GetMapping("/api/v1/asset")
    public ApiResponse<List<AssetVO>> getAsset(@RequestBody AssetVO vo) {

        log.info("get asset : {}", vo.getUserId());
        List<AssetVO> assetList = assetService.selectAssetList(vo);
        return ApiResponse.success(assetList);
    }
}
