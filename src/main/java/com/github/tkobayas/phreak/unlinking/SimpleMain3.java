package com.github.tkobayas.phreak.unlinking;

import java.io.IOException;

import com.github.tkobayas.phreak.unlinking.model.MyFact1;
import com.github.tkobayas.phreak.unlinking.model.MyFact2;
import com.github.tkobayas.phreak.unlinking.model.MyFact3;
import com.github.tkobayas.phreak.unlinking.model.MyFact4;
import com.github.tkobayas.phreak.unlinking.model.MyFact5;
import com.github.tkobayas.phreak.unlinking.util.ReteDumper;
import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.conf.RuleEngineOption;
import org.kie.internal.utils.KieHelper;
import org.openjdk.jmh.runner.RunnerException;

public class SimpleMain3 {

    private static final String DRL = "accumulate-unlink-100.drl";

    public static void main(String[] args) throws RunnerException, IOException {

        final KieBaseConfiguration kieBaseConfiguration = KnowledgeBaseFactory.newKnowledgeBaseConfiguration();

        kieBaseConfiguration.setOption(RuleEngineOption.PHREAK);

        final KieHelper kieHelper = new KieHelper();

        kieHelper.addResource(KieServices.Factory.get().getResources().newClassPathResource(DRL));

        KieBase kieBase = kieHelper.build(kieBaseConfiguration);

        ReteDumper.dumpRete(kieBase);

        KieSession kieSession = kieBase.newKieSession();

        MyFact1 fact1 = new MyFact1();
        fact1.setId("hoge");
        fact1.setValue1("hoge1");
        fact1.setValue2("hoge2");
        fact1.setValue3("hoge3");
        fact1.setValue4("hoge4");
        fact1.setValue5("hoge5");

        MyFact2 fact2 = new MyFact2();
        fact2.setId("hoge");
        fact2.setValue1("hoge1");
        fact2.setValue2("hoge2");
        fact2.setValue3("hoge3");
        fact2.setValue4("hoge4");
        fact2.setValue5("hoge5");

        MyFact3 fact3 = new MyFact3();
        fact3.setId("hoge");
        fact3.setValue1("hoge1");
        fact3.setValue2("hoge2");
        fact3.setValue3("hoge3");
        fact3.setValue4("hoge4");
        fact3.setValue5("hoge5");

        MyFact4 fact4 = new MyFact4();
        fact4.setId("hoge");
        fact4.setValue1("hoge1");
        fact4.setValue2("hoge2");
        fact4.setValue3("hoge3");
        fact4.setValue4("hoge4");
        fact4.setValue5("hoge5");

        MyFact5 fact5 = new MyFact5();
        fact5.setId("hoge");
        fact5.setValue1("hoge1");
        fact5.setValue2("hoge2");
        fact5.setValue3("hoge3");
        fact5.setValue4("hoge4");
        fact5.setValue5("hoge5");

        //            System.out.println("insert -> " + fact1.getValue1() + ", " + fact2.getValue1() + ", " + fact3.getValue1());

        kieSession.insert(fact1);
        kieSession.insert(fact2);
        kieSession.insert(fact3);
        kieSession.insert(fact4);
        kieSession.insert(fact5);

        int result = kieSession.fireAllRules();
        System.out.println("---- number of fired rules = " + result);

        kieSession.dispose();

    }

}
