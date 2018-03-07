package com.facebook.feedplugins.offline.rows.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.NotificationTextSwitcher;

/* compiled from: SPRING */
public class OfflineRetryView extends CustomRelativeLayout implements HasOfflineHeaderView {
    public final NotificationTextSwitcher f23721a = ((NotificationTextSwitcher) a(2131564393));
    private final ImageView f23722b;
    private final ImageView f23723c;
    private final View f23724d;

    public OfflineRetryView(Context context) {
        super(context);
        setContentView(2130905542);
        this.f23721a.setText(getResources().getText(2131233515));
        this.f23724d = a(2131564391);
        this.f23723c = (ImageView) a(2131563533);
        this.f23722b = (ImageView) a(2131560414);
    }

    public final void m25901a(OnTouchListener onTouchListener, OnClickListener onClickListener) {
        this.f23722b.setOnTouchListener(onTouchListener);
        this.f23722b.setOnClickListener(onClickListener);
    }

    public final void m25902b(OnTouchListener onTouchListener, OnClickListener onClickListener) {
        this.f23723c.setOnTouchListener(onTouchListener);
        this.f23723c.setOnClickListener(onClickListener);
    }

    public View getOfflineHeaderView() {
        return this.f23724d;
    }
}
