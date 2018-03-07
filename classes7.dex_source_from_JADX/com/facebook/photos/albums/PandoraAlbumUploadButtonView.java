package com.facebook.photos.albums;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: mall_friends_nag_seen/ */
public class PandoraAlbumUploadButtonView extends CustomLinearLayout {
    public PandoraAlbumUploadButtonView(Context context) {
        super(context);
        m11352a();
    }

    public PandoraAlbumUploadButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11352a();
    }

    public PandoraAlbumUploadButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11352a();
    }

    private void m11352a() {
        LayoutParams layoutParams;
        setContentView(2130903239);
        if (VERSION.SDK_INT < 11) {
            setBackgroundColor(getResources().getColor(2131361864));
        }
        PandoraAlbumLinesHeaderView pandoraAlbumLinesHeaderView = (PandoraAlbumLinesHeaderView) findViewById(2131559558);
        pandoraAlbumLinesHeaderView.setUploadButtonLines(true);
        if (VERSION.SDK_INT < 11) {
            layoutParams = new LinearLayout.LayoutParams(pandoraAlbumLinesHeaderView.getLayoutParams());
            layoutParams.bottomMargin = getResources().getDimensionPixelSize(2131429449);
            pandoraAlbumLinesHeaderView.setLayoutParams(layoutParams);
        }
        int dimensionPixelSize = (getResources().getDisplayMetrics().widthPixels - (getResources().getDimensionPixelSize(2131429451) * 3)) / 2;
        ((LinearLayout) findViewById(2131559559)).setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        ImageView imageView = (ImageView) findViewById(2131559560);
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        imageView.setLayoutParams(layoutParams);
    }
}
