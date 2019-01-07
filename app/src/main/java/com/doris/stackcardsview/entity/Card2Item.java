package com.doris.stackcardsview.entity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.doris.stack.cards.library.base.BaseCardItem;
import com.doris.stackcardsview.R;

/**
 * @author Doris.
 * @date 2019/1/7.
 */
public class Card2Item extends BaseCardItem {

    public Card2Item(Context context) {
        super(context);
    }

    @Override
    public View getView(View convertView, ViewGroup parent) {
        convertView = View.inflate(mContext, R.layout.item_card2, null);
        return convertView;
    }
}
