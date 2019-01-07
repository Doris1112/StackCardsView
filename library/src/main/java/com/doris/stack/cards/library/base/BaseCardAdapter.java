package com.doris.stack.cards.library.base;

import android.view.View;
import android.view.ViewGroup;

import com.doris.stack.cards.library.widget.StackCardsView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Doris.
 * @date 2018/12/29.
 */
public class BaseCardAdapter<T extends BaseCardItem> extends StackCardsView.Adapter {

    private final List<T> mData;

    public BaseCardAdapter(){
        mData = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        return mData.get(position).getView(convertView, parent);
    }

    @Override
    public int getSwipeDirection(int position) {
        return mData.get(position).getSwipeDir();
    }

    @Override
    public int getDismissDirection(int position) {
        return mData.get(position).getDismissDir();
    }

    @Override
    public boolean isFastDismissAllowed(int position) {
        return mData.get(position).isFastDismissAllowed();
    }

    @Override
    public int getMaxRotation(int position) {
        return mData.get(position).getMaxRotation();
    }

    public void canLoop(StackCardsView stackCardsView, boolean isLoop){
        if (stackCardsView != null){
            stackCardsView.setAdapter(this);
            if (isLoop){
                stackCardsView.addOnCardSwipedListener(new StackCardsView.OnCardSwipedListener() {
                    @Override
                    public void onCardDismiss(int direction) {
                        T data = getItem(0);
                        removeDataAtIndex(0);
                        appendData(data);
                    }

                    @Override
                    public void onCardScrolled(View view, float progress, int direction) {

                    }
                });
            }
        }
    }

    public T getItem(int position){
        if (mData.size() > position){
            return mData.get(position);
        }
        return null;
    }

    public void clearData(){
        if (mData.size() > 0){
            mData.clear();
            notifyDataSetChanged();
        }
    }

    public void appendData(List<T> data){
        if (data != null && data.size() > 0){
            mData.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void appendData(T data){
        if (data != null){
            mData.add(data);
            notifyItemInserted(mData.size() - 1);
        }
    }

    public void removeDataAtIndex(int position){
        if (mData.size() > position){
            mData.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void removeDate(T data){
        int position = mData.indexOf(data);
        if (position != -1){
            removeDataAtIndex(position);
        }
    }

}
