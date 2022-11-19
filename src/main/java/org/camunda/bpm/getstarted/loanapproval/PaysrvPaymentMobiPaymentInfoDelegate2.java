package org.camunda.bpm.getstarted.loanapproval;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaysrvPaymentMobiPaymentInfoDelegate2 implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        try {
            // Код, который генерирует Exception
            execution.setVariable("status", "40");
            throw new Exception("test Message");
        } catch (Exception e) {

            throw new BpmnError(e.getClass().getName(), e.getMessage());
            //log
        }

    }
}
