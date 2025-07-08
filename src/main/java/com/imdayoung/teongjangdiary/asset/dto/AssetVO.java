package com.imdayoung.teongjangdiary.asset.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssetVO {

    private Integer assetId;
    private Integer assetGroupId;
    private String assetGroupNm;
    private String userId;
    private String assetNm;
    private Integer prevAmount;
    private Integer amount;
    private String memo;
    private String showYn;
    private Integer assetSeq;
    private String createdAt;
    private String updatedAt;
}
