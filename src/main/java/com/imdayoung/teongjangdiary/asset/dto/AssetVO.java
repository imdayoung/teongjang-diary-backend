package com.imdayoung.teongjangdiary.asset.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
