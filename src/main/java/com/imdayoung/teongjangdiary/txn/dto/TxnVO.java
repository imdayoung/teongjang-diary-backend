package com.imdayoung.teongjangdiary.txn.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TxnVO {

    @Setter
    private String userId;

    private Integer txnId;
    private String txnDt;
    private String weekday;
    private Integer txnType;
    private String txnTypeNm;
    private Integer amount;
    private Integer categoryId;
    private String categoryNm;
    private String assetId;
    private String assetNm;
    private String content;
    private String memo;

    private Integer year;
    private Integer month;
}
