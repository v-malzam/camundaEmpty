package org.camunda.bpm.getstarted.loanapproval.test_9;

import groovy.json.JsonSlurperClassic;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PaysrvPaymentSendMessageDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String messageName = (String) execution.getVariable("messageName");
        String variableValue = (String) execution.getVariable("uuidInvoice");
        log.info("paysrv Starting correlation: messageName = {}, uuidInvoice = {}", messageName, variableValue);

        List<MessageCorrelationResult> correlateResult = execution.getProcessEngineServices().getRuntimeService()
                .createMessageCorrelation(messageName)
                .processInstanceVariableEquals("uuidInvoice", variableValue)
                .correlateAllWithResult();

        JsonSlurperClassic slurper = new groovy.json.JsonSlurperClassic();

        //Report
        Integer numCorrelate = correlateResult.size();
        List<String> listUuidCorrelate = correlateResult.stream()
                .map(MessageCorrelationResult::getExecution)
                .map(Execution::getId)
                .collect(Collectors.toList());

        String reportCorrelate = "Количество корреляций - " + numCorrelate + ", UUID экземпляров процессов, принявших сообщение = " + listUuidCorrelate;
        execution.setVariable("sendTaskReport", reportCorrelate);

        log.info("paysrv Finished correlation: messageName = {}, uuidInvoice = {}, numCorrelate = {}, listUuidCorrelate = {}"
                , messageName, variableValue, numCorrelate, listUuidCorrelate);
    }
}
