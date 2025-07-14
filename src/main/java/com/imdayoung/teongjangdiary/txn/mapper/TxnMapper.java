package com.imdayoung.teongjangdiary.txn.mapper;

import com.imdayoung.teongjangdiary.txn.dto.TotalSummaryVO;
import com.imdayoung.teongjangdiary.txn.dto.TxnVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TxnMapper {

    List<TxnVO> selectTxnList(TxnVO txnVO);
    TotalSummaryVO selectTotalSummary(TxnVO txnVO);
}
