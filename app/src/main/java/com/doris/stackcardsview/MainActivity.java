package com.doris.stackcardsview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.doris.stack.cards.library.base.BaseCardAdapter;
import com.doris.stack.cards.library.widget.StackCardsView;
import com.doris.stackcardsview.entity.ImageCardItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Doris
 * @date 2018/12/29
 **/
public class MainActivity extends AppCompatActivity {

    private static final String[] images = {
            "http://img.mp.itc.cn/upload/20170420/a450d83ff3874337b3dbac5d7c1c1871_th.jpeg",
            "http://pic1.16pic.com/00/11/45/16pic_1145688_b.jpg",
            "http://img1.3lian.com/2015/a1/5/d/125.jpg",
            "http://img1.imgtn.bdimg.com/it/u=3177563074,2062508095&fm=26&gp=0.jpg",
            "http://photo.16pic.com/00/14/61/16pic_1461398_b.jpg",
            "http://img2.imgtn.bdimg.com/it/u=262170862,104860060&fm=26&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=1299304864,276033499&fm=26&gp=0.jpg",
            "http://img05.tooopen.com/images/20150422/tooopen_sy_119787315139.jpg",
            "http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1306/20/c3/22345826_1371731042302.jpg",
            "http://pic.qjimage.com/estate001/high/estrm1315129.jpg",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StackCardsView mCardsView = findViewById(R.id.cards);

        BaseCardAdapter<ImageCardItem> mAdapter = new BaseCardAdapter<>();
        mAdapter.appendData(loadData());
        mAdapter.canLoop(mCardsView, true);
    }

    private List<ImageCardItem> loadData() {
        List<ImageCardItem> data = new ArrayList<>();
        for (int i = 0; i <= images.length - 1; i++) {
            ImageCardItem imageCardItem = new ImageCardItem(this, images[i], "图片" + (i + 1));
            imageCardItem.setDismissDir(StackCardsView.SWIPE_ALL);
            imageCardItem.setFastDismissAllowed(true);
            data.add(imageCardItem);
        }
        return data;
    }
}
