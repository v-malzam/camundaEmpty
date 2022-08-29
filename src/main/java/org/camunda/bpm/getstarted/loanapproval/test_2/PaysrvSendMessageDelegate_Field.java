package org.camunda.bpm.getstarted.loanapproval.test_2;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
public class PaysrvSendMessageDelegate_Field implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        String messageName = execution.getCurrentActivityName();
        String instanceId = (String) execution.getVariable("processInstanceIdtoMessage");
        String firstName = (String) execution.getVariable("firstName");
        Integer age = (Integer) execution.getVariable("age");

        execution.getProcessEngineServices().getRuntimeService()
                .createMessageCorrelation(messageName)
                .processInstanceId(instanceId)
                .setVariable("firstName", firstName)
                .setVariable("age", age)
                .correlate();
    }
}
