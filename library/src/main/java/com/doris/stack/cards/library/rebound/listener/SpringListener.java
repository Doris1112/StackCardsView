package com.doris.stack.cards.library.rebound.listener;

import com.doris.stack.cards.library.rebound.spring.Spring;

/**
 * @author Doris.
 * @date 2018/12/29.
 */
public interface SpringListener {

    void onSpringUpdate(Spring spring);

    void onSpringAtRest(Spring spring);

    void onSpringActivate(Spring spring);

    void onSpringEndStateChange(Spring spring);

}
