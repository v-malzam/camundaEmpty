package org.camunda.bpm.getstarted.loanapproval.test_9.dto;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class Payment implements Serializable {
    String operationId = "222-operationId";
    String paymentDate = "222-paymentDate";
    String payerName = "222-payerName";
    String payerInn = "222-payerInn";
    String payerKpp = "222-payerKpp";
    String payerBankBiC = "222-payerBankBiC";
    String payerBankName = "222-payerBankName";
    String payerBankAcc = "222-payerBankAcc";
    String payerBankCorr = "222-payerBankCorr";
    String payeeName = "222-payeeName";
    String payeeInn = "222-payeeInn";
    String payeeKpp = "222-payeeKpp";
    String payeeBankBiC = "222-payeeBankBiC";
    String payeeBankName = "222-payeeBankName";
    String payeeBankAcc = "222-payeeBankAcc";
    String payeeBankCorr = "222-payeeBankCorr";
}
