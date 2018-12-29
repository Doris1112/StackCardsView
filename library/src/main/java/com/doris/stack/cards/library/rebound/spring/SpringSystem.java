package com.doris.stack.cards.library.rebound.spring;

/**
 * @author Doris.
 * @date 2018/12/29.
 */
public class SpringSystem extends BaseSpringSystem {

    public static SpringSystem create() {
        return new SpringSystem(ChoreographerAndroidSpringLooper.create());
    }

    private SpringSystem(SpringLooper springLooper) {
        super(springLooper);
    }
}
