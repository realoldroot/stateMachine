package com.realoldroot.test.squirrelfoundation.untype;

import com.realoldroot.test.squirrelfoundation.EEvent;
import com.realoldroot.test.squirrelfoundation.EState;
import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;
import org.squirrelframework.foundation.fsm.UntypedStateMachineBuilder;


/**
 * 无类型状态机
 */
public class MyUntypeStateMachineTest {
    public static void main(String[] args) {

        //定义一个无类型状态机构造器，参数为继承了AbstractUntypedStateMachine.class的实现
        UntypedStateMachineBuilder builder = StateMachineBuilderFactory.create(MyUntypeStateMachine.class);

        //进入状态A时候触发方法onA
        builder.onEntry(EState.A).callMethod("onA");
        //退出状态A时候触发方法exitA
        builder.onExit(EState.A).callMethod("exitA");
        //触发事件toB，状态从A切换到B的，调用方法toB
        builder.externalTransition().from(EState.A).to(EState.B).on(EEvent.ToB).callMethod("toB");
        //触发事件toC，状态从B切换到C，调用方法toC
        builder.localTransition().from(EState.B).to(EState.C).on(EEvent.ToC).callMethod("toC");

        //构造器实例化一个无类型状态机，（builder 可复用）
        MyUntypeStateMachine myStateMachine = builder.newAnyStateMachine(EState.A);

        myStateMachine.start();

        //触发事件toB
        myStateMachine.fire(EEvent.ToB);
        //触发事件toC
        myStateMachine.fire(EEvent.ToC);


        //控制台输出
        // 执行 onA 方法
        // state null, state A event null context null
        // 执行 exitA 方法
        // state A, state null event ToB context null
        // 执行 toB 方法
        // state A, state B event ToB context null
        // 执行 toC 方法
        // state B, state C event ToC context null

    }
}
