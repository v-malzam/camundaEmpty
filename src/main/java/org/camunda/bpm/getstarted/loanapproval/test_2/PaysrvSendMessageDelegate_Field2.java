package org.camunda.bpm.getstarted.loanapproval.test_2;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
public class PaysrvSendMessageDelegate_Field2 implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        execution.getProcessEngineServices().getRuntimeService()
                .createMessageCorrelation(execution.getCurrentActivityName())
                .processInstanceId((String) execution.getVariable("processInstanceIdtoMessage"))
                .setVariable("firstName", (String) execution.getVariable("firstName"))
                .setVariable("age", (Integer) execution.getVariable("age"))
                .correlate();
    }
}
