package com.realoldroot.test.squirrelfoundation.untype;

import org.squirrelframework.foundation.fsm.impl.AbstractUntypedStateMachine;

/**
 * 实现一个无类型状态机
 */
public class MyUntypeStateMachine extends AbstractUntypedStateMachine {


    public void onA(Object sm, Object s, Object e, Object c) {
        System.out.println("执行 onA 方法");
        String str = String.format("state %s, state %s event %s context %s", sm, s, e, c);
        System.out.println(str);
    }

    public void exitA(Object sm, Object s, Object e, Object c) {
        System.out.println("执行 exitA 方法");
        String str = String.format("state %s, state %s event %s context %s", sm, s, e, c);
        System.out.println(str);
    }


    public void toB(Object sm, Object s, Object e, Object c) {
        System.out.println("执行 toB 方法");
        String str = String.format("state %s, state %s event %s context %s", sm, s, e, c);
        System.out.println(str);
    }

    public void toC(Object sm, Object s, Object e, Object c) {
        System.out.println("执行 toC 方法");
        String str = String.format("state %s, state %s event %s context %s", sm, s, e, c);
        System.out.println(str);
    }
}

