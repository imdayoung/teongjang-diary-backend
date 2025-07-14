package com.imdayoung.teongjangdiary.txn.dto;

import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TxnListDTO {

    private Integer month;
    private Integer date;
    private String weekday;

    @Setter
    private Integer income;

    @Setter
    private Integer expense;
    private List<TxnVO> transactions;
}
