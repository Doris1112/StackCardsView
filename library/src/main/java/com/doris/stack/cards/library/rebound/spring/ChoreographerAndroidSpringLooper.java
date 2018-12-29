package com.doris.stack.cards.library.rebound.spring;

import android.os.SystemClock;
import android.view.Choreographer;

/**
 * @author Doris.
 * @date 2018/12/29.
 */
public class ChoreographerAndroidSpringLooper extends SpringLooper {

    private final Choreographer mChoreographer;
    private final Choreographer.FrameCallback mFrameCallback;
    private boolean mStarted;
    private long mLastTime;

    /**
     * @return an Android spring choreographer using the system {@link Choreographer}
     */
    public static ChoreographerAndroidSpringLooper create() {
        return new ChoreographerAndroidSpringLooper(Choreographer.getInstance());
    }

    public ChoreographerAndroidSpringLooper(Choreographer choreographer) {
        mChoreographer = choreographer;
        mFrameCallback = new Choreographer.FrameCallback() {
            @Override
            public void doFrame(long frameTimeNanos) {
                if (!mStarted || mSpringSystem == null) {
                    return;
                }
                long currentTime = SystemClock.uptimeMillis();
                mSpringSystem.loop(currentTime - mLastTime);
                mLastTime = currentTime;
                mChoreographer.postFrameCallback(mFrameCallback);
            }
        };
    }

    @Override
    public void start() {
        if (mStarted) {
            return;
        }
        mStarted = true;
        mLastTime = SystemClock.uptimeMillis();
        mChoreographer.removeFrameCallback(mFrameCallback);
        mChoreographer.postFrameCallback(mFrameCallback);
    }

    @Override
    public void stop() {
        mStarted = false;
        mChoreographer.removeFrameCallback(mFrameCallback);
    }

}
