package com.imdayoung.teongjangdiary.asset.dto;

import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AssetGroupDTO {

    private String assetGroupNm;
    private Integer amount;
    private Integer prevAmount;
    private List<AssetVO> assets;
}
