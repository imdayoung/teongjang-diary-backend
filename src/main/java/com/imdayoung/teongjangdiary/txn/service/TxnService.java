package com.imdayoung.teongjangdiary.txn.service;

import com.imdayoung.teongjangdiary.txn.dto.TotalSummaryVO;
import com.imdayoung.teongjangdiary.txn.dto.TxnListDTO;
import com.imdayoung.teongjangdiary.txn.dto.TxnVO;

import java.util.List;
import java.util.Map;

public interface TxnService {

    List<TxnListDTO> selectTxnList(TxnVO txnVO);
    TotalSummaryVO selectTotalSummary(TxnVO txnVO);
}
