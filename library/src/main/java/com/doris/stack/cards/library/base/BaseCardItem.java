package com.doris.stack.cards.library.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.doris.stack.cards.library.widget.StackCardsView;

/**
 * @author Doris.
 * @date 2018/12/29.
 */
public abstract class BaseCardItem {

    private boolean fastDismissAllowed = true;
    private int swipeDir = StackCardsView.SWIPE_ALL;
    private int dismissDir = StackCardsView.SWIPE_ALL;
    private int maxRotation = 8;

    protected Context mContext;

    public BaseCardItem(Context context) {
        mContext = context;
    }

    public abstract View getView(View convertView, ViewGroup parent);

    public boolean isFastDismissAllowed() {
        return fastDismissAllowed;
    }

    public void setFastDismissAllowed(boolean fastDismissAllowed) {
        this.fastDismissAllowed = fastDismissAllowed;
    }

    public int getSwipeDir() {
        return swipeDir;
    }

    public void setSwipeDir(int swipeDir) {
        this.swipeDir = swipeDir;
    }

    public int getDismissDir() {
        return dismissDir;
    }

    public void setDismissDir(int dismissDir) {
        this.dismissDir = dismissDir;
    }

    public int getMaxRotation() {
        return maxRotation;
    }

    public void setMaxRotation(int maxRotation) {
        this.maxRotation = maxRotation;
    }

}