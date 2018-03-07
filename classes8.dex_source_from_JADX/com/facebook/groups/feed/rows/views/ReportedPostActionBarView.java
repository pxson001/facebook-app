package com.facebook.groups.feed.rows.views;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: f810d73c354f84e1d4f3e7094f216da1 */
public class ReportedPostActionBarView extends CustomLinearLayout {
    public View f14166a = a(2131564002);
    public View f14167b = a(2131564003);
    public View f14168c = a(2131564004);

    public ReportedPostActionBarView(Context context) {
        super(context);
        setContentView(2130905353);
    }

    public void setIgnoreButtonListener(OnClickListener onClickListener) {
        this.f14166a.setOnClickListener(onClickListener);
    }

    public void setRemoveButtonListener(OnClickListener onClickListener) {
        this.f14167b.setOnClickListener(onClickListener);
    }

    public void setRemoveAndBlockButtonListener(OnClickListener onClickListener) {
        this.f14168c.setOnClickListener(onClickListener);
    }
}
