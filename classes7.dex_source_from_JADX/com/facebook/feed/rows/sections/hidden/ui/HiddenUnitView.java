package com.facebook.feed.rows.sections.hidden.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.feed.animation.CollapseAnimation;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: Unable to extract image. Something may be wrong with the video or decoder */
public class HiddenUnitView extends CustomFrameLayout {
    public View f21484a = c(2131561915);
    public TextView f21485b = ((TextView) c(2131561914));
    public TextView f21486c = ((TextView) c(2131561912));
    public View f21487d = c(2131561913);
    public ViewGroup f21488e = ((ViewGroup) c(2131561911));
    public CollapseAnimation f21489f;

    public HiddenUnitView(Context context) {
        super(context);
        setContentView(2130904302);
    }

    public void setContentVisibility(int i) {
        this.f21488e.setVisibility(i);
    }
}
