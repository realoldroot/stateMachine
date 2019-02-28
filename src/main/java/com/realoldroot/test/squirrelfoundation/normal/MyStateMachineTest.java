package com.realoldroot.test.squirrelfoundation.normal;

import com.realoldroot.test.squirrelfoundation.EEvent;
import com.realoldroot.test.squirrelfoundation.EState;
import com.realoldroot.test.squirrelfoundation.MyContext;
import lombok.val;
import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;

public class MyStateMachineTest {

    public static void main(String[] args) {

        /**
         * 普通状态机实现约束了状态类型和事件类型
         */
        val builder = StateMachineBuilderFactory.create(MyStateMachine.class, EState.class, EEvent.class, MyContext.class);

        builder.onEntry(EState.A).callMethod("onA");
        builder.onExit(EState.A).callMethod("exitA");
        builder.externalTransition().from(EState.A).to(EState.B).on(EEvent.ToB).callMethod("toB");
        builder.localTransition().from(EState.B).to(EState.C).on(EEvent.ToC).callMethod("toC");

        val myStateMachine = builder.newStateMachine(EState.A);

        myStateMachine.start();
        myStateMachine.fire(EEvent.ToB);
        myStateMachine.fire(EEvent.ToC);
    }
}
