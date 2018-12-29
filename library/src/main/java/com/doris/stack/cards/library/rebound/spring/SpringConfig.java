package com.doris.stack.cards.library.rebound.spring;

import com.doris.stack.cards.library.rebound.BouncyConversion;
import com.doris.stack.cards.library.rebound.OrigamiValueConverter;

/**
 * @author Doris.
 * @date 2018/12/29.
 */
public class SpringConfig {

    public double friction;
    public double tension;

    public static SpringConfig defaultConfig = SpringConfig.fromOrigamiTensionAndFriction(40, 7);

    public SpringConfig(double tension, double friction) {
        this.tension = tension;
        this.friction = friction;
    }

    public static SpringConfig fromOrigamiTensionAndFriction(double qcTension, double qcFriction) {
        return new SpringConfig(
                OrigamiValueConverter.tensionFromOrigamiValue(qcTension),
                OrigamiValueConverter.frictionFromOrigamiValue(qcFriction)
        );
    }

    public static SpringConfig fromBouncinessAndSpeed(double bounciness, double speed) {
        BouncyConversion bouncyConversion = new BouncyConversion(speed, bounciness);
        return fromOrigamiTensionAndFriction(
                bouncyConversion.getBouncyTension(),
                bouncyConversion.getBouncyFriction());
    }

}
