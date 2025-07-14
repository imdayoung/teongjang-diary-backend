package com.imdayoung.teongjangdiary.txn.controller;

import com.imdayoung.teongjangdiary.global.annotation.LgnUserId;
import com.imdayoung.teongjangdiary.global.response.response.ApiResponse;
import com.imdayoung.teongjangdiary.txn.dto.TotalSummaryVO;
import com.imdayoung.teongjangdiary.txn.dto.TxnListDTO;
import com.imdayoung.teongjangdiary.txn.dto.TxnVO;
import com.imdayoung.teongjangdiary.txn.service.TxnService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TxnController {

    private final TxnService txnService;

    @GetMapping("/api/v1/txn")
    public ApiResponse<List<TxnListDTO>> getTxnList(TxnVO txnVO, @LgnUserId String userId) {

        txnVO.setUserId(userId);
        List<TxnListDTO> response = txnService.selectTxnList(txnVO);
        return ApiResponse.success(response);
    }

    @GetMapping("/api/v1/txn/summary")
    public ApiResponse<TotalSummaryVO> getTotalSummary(TxnVO txnVO, @LgnUserId String userId) {

        txnVO.setUserId(userId);
        TotalSummaryVO response = txnService.selectTotalSummary(txnVO);
        return ApiResponse.success(response);
    }
}
