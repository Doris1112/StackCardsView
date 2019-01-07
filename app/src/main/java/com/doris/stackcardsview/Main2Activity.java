package com.doris.stackcardsview;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.doris.stack.cards.library.base.BaseCardAdapter;
import com.doris.stack.cards.library.widget.StackCardsView;
import com.doris.stackcardsview.entity.Card2Item;
import com.doris.stackcardsview.widget.NestedListView;

/**
 * @author Doris
 * @date 2019/1/7
 **/
public class Main2Activity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout mRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mRefreshLayout = findViewById(R.id.refresh_main2);
        mRefreshLayout.setOnRefreshListener(this);

        StackCardsView cardsView = findViewById(R.id.cards_main2);
        cardsView.setPadding(0, dp2px(155), 0,
                getResources().getDisplayMetrics().heightPixels - dp2px(155 + 180));

        BaseCardAdapter<Card2Item> adapter = new BaseCardAdapter<>();
        adapter.appendData(new Card2Item(this));
        adapter.appendData(new Card2Item(this));
        adapter.appendData(new Card2Item(this));
        adapter.appendData(new Card2Item(this));
        adapter.appendData(new Card2Item(this));
        adapter.appendData(new Card2Item(this));
        adapter.canLoop(cardsView, true);

        NestedListView listView = findViewById(R.id.lv_main2);
        listView.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_expandable_list_item_1, getStrings()));
    }

    private String[] getStrings() {
        String[] strings = new String[100];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = "item" + i;
        }
        return strings;
    }

    @Override
    public void onRefresh() {
        mRefreshLayout.setRefreshing(false);
    }

    public int dp2px(int dpValue) {
        return (int)((float)dpValue * getResources().getDisplayMetrics().density + 0.5F);
    }
}
