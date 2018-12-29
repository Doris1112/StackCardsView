package com.doris.stackcardsview.entity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.doris.stack.cards.library.base.BaseCardItem;
import com.doris.stackcardsview.R;

/**
 * @author Doris.
 * @date 2018/12/29.
 */
public class ImageCardItem extends BaseCardItem {

    private String url;
    private String label;

    public ImageCardItem(Context context, String url, String label) {
        super(context);
        this.url = url;
        this.label = label;
    }

    @Override
    public View getView(View convertView, ViewGroup parent) {
        convertView = View.inflate(mContext, R.layout.item_imagecard, null);
        ImageView imageView = convertView.findViewById(R.id.image);
        TextView textView = convertView.findViewById(R.id.label);

        Glide.with(mContext).load(url).apply(
                new RequestOptions().placeholder(R.drawable.img_dft))
                .into(imageView);
        textView.setText(label);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "点击" + label, Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

}
