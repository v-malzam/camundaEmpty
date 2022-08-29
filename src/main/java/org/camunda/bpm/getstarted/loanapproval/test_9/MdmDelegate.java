package org.camunda.bpm.getstarted.loanapproval.test_9;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.getstarted.loanapproval.test_9.dto.Invoice;
import org.camunda.bpm.getstarted.loanapproval.test_9.dto.Payment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MdmDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        String origin = (String) execution.getVariable("origin");
        String action = (String) execution.getVariable("action");
        Map<String, String> filterMap = (Map<String, String>) execution.getVariable("filterMap");
        String outputName = (String) execution.getVariable("outputName");

        List<Object> result = new ArrayList<>();
        String currentActivityId = execution.getCurrentActivityId();
        String uuid = filterMap.get("uuid");

        //System.out.println("");
        //System.out.println("origin = " + origin);
        //System.out.println("currentActivityId = " + currentActivityId);
        //System.out.println("uuid = " + uuid);

        if (origin.equals("paysrv_invoices") && currentActivityId.equals("load_invoices")) {

            if (uuid.equals("0")) {
                System.out.println("uuid = 0");
            }

            if (uuid.equals("1")) {
                result.add(new Invoice("3", "2025-10-02", "111-invoiceNumber", "111-amount", "111-currency", "111-currency", "111-paymentId"));
            }

            if (uuid.equals("2")) {
                result.add(new Invoice("2", "2025-10-02", null, null, null, null, null));
            }

            if (uuid.equals("3")) {
                result.add(new Invoice("2", "2025-10-02", null, null, null, null, null));
            }
        }

        if (origin.equals("paysrv_invoices") && currentActivityId.equals("load_invoices_2")) {

            if (uuid.equals("1")) {
                result.add(new Invoice("3", "333333-validityPeriod", "333333-invoiceNumber", "333333-amount", "333333-currency",
                        "333333-currency", "333333-paymentId"));
            }

            if (uuid.equals("2") || uuid.equals("3")) {
                result.add(new Invoice("2", "333333-validityPeriod", null, null, null, null, null));
            }
        }


        if (origin.equals("paysrv_payments")) {
            result.add(new Payment());
        }
        //System.out.println("result = " + result);
        execution.setVariable(outputName, result);
    }
}
