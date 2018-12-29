package com.doris.stack.cards.library.rebound.spring;

/**
 * @author Doris.
 * @date 2018/12/29.
 */
public abstract class SpringLooper {

    protected BaseSpringSystem mSpringSystem;

    public void setSpringSystem(BaseSpringSystem springSystem) {
        mSpringSystem = springSystem;
    }

    public abstract void start();

    public abstract void stop();

}
