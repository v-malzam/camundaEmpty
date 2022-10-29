package org.camunda.bpm.getstarted.loanapproval;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaysrvPaymentMobiPaymentInfoDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        try {
            execution.setVariable("status", "40");
            throw new Exception("test Message");
        } catch (Exception e) {

            execution.setVariable("status", "0");
            execution.setVariable("mobiErrorMessage", e.getMessage());
        }

    }
}
