package com.facebook.feed.rows.sections.hidden.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: Unable to instantiate methods getter for  */
public class FeedHiddenUnitActionItemView extends CustomFrameLayout {
    private TextView f21470a = ((TextView) c(2131561918));
    private ImageView f21471b = ((ImageView) c(2131561917));
    private ProgressBar f21472c = ((ProgressBar) c(2131561916));

    public FeedHiddenUnitActionItemView(Context context) {
        super(context);
        setContentView(2130904303);
    }

    public final FeedHiddenUnitActionItemView m24138a(boolean z) {
        int i;
        int i2 = 8;
        ProgressBar progressBar = this.f21472c;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        progressBar.setVisibility(i);
        ImageView imageView = this.f21471b;
        if (!z) {
            i2 = 0;
        }
        imageView.setVisibility(i2);
        return this;
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        m24138a(z);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f21470a.setEnabled(z);
    }

    public final FeedHiddenUnitActionItemView m24137a(String str) {
        this.f21470a.setText(str);
        return this;
    }

    public final FeedHiddenUnitActionItemView m24136a(Drawable drawable) {
        this.f21471b.setImageDrawable(drawable);
        return this;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f21470a.setOnClickListener(onClickListener);
    }
}
