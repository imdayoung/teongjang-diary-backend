package com.imdayoung.teongjangdiary.txn.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TotalSummaryVO {

    private Integer income;
    private Integer expense;
    private Integer total;
}
