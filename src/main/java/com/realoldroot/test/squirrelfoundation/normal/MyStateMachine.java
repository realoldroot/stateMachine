package com.realoldroot.test.squirrelfoundation.normal;

import com.realoldroot.test.squirrelfoundation.EEvent;
import com.realoldroot.test.squirrelfoundation.EState;
import com.realoldroot.test.squirrelfoundation.MyContext;
import org.squirrelframework.foundation.fsm.impl.AbstractStateMachine;

public class MyStateMachine extends AbstractStateMachine<MyStateMachine, EState, EEvent, MyContext> {



    public void onA(EState sm, EState s, EEvent e, MyContext c) {
        System.out.println("执行 onA 方法");
        String str = String.format("state %s, state %s event %s context %s", sm, s, e, c);
        System.out.println(str);
    }

    public void exitA(EState sm, EState s, EEvent e, MyContext c) {
        System.out.println("执行 exitA 方法");
        String str = String.format("state %s, state %s event %s context %s", sm, s, e, c);
        System.out.println(str);
    }


    public void toB(EState sm, EState s, EEvent e, MyContext c) {
        System.out.println("执行 toB 方法");
        String str = String.format("state %s, state %s event %s context %s", sm, s, e, c);
        System.out.println(str);
    }

    public void toC(EState sm, EState s, EEvent e, MyContext c) {
        System.out.println("执行 toC 方法");
        String str = String.format("state %s, state %s event %s context %s", sm, s, e, c);
        System.out.println(str);
    }


}
