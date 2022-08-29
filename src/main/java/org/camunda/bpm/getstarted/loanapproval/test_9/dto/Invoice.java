package org.camunda.bpm.getstarted.loanapproval.test_9.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Invoice implements Serializable {
    String status;
    String validityPeriod;
    String invoiceNumber;
    String amount;
    String currency;
    String invoicePurpose;
    String paymentId;
}
