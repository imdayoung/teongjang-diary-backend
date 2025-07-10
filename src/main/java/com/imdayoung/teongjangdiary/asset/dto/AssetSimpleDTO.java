package com.imdayoung.teongjangdiary.asset.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AssetSimpleDTO {

    private String name;
    private Integer amount;
    private Integer prevAmount;
}
