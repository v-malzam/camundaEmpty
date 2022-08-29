package org.camunda.bpm.getstarted.loanapproval.test_2;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaysrvSendMessageDelegate_FieldsMap implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        String messageName = execution.getCurrentActivityName();
        String instanceId = (String) execution.getVariable("processInstanceIdtoMessage");

        Map<String, Object> variables = new HashMap<>();
        variables.put("firstName", (String) execution.getVariable("firstName"));
        variables.put("age", (Integer) execution.getVariable("age"));

        execution.getProcessEngineServices().getRuntimeService()
                .createMessageCorrelation(messageName)
                .processInstanceId(instanceId)
                .setVariables(variables)
                .correlate();
    }
}
