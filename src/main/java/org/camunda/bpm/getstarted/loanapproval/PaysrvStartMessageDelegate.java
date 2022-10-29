package org.camunda.bpm.getstarted.loanapproval;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaysrvStartMessageDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        String messageName = (String) execution.getVariableLocal("messageName");
        @SuppressWarnings("unchecked")
        Map<String, Object> variables = (Map<String, Object>) execution.getVariableLocal("variablesMap");

        ProcessInstance processInstance = execution
                .getProcessEngineServices()
                .getRuntimeService()
                .startProcessInstanceByMessage(messageName, variables);

        execution.setVariableLocal("startedProcessInstanceId", processInstance.getProcessInstanceId());
    }
}
