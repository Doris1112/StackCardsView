package com.doris.stack.cards.library.rebound.listener;

import com.doris.stack.cards.library.rebound.spring.BaseSpringSystem;

/**
 * @author Doris.
 * @date 2018/12/29.
 */
public interface SpringSystemListener {

    void onBeforeIntegrate(BaseSpringSystem springSystem);

    void onAfterIntegrate(BaseSpringSystem springSystem);

}
