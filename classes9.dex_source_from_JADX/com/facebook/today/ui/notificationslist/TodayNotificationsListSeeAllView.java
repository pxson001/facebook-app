package com.facebook.today.ui.notificationslist;

import android.content.Context;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.ui.touchlistener.HighlightCustomViewOnTouchListener;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: transcoding_failed */
public class TodayNotificationsListSeeAllView extends CustomFrameLayout {
    public final TextView f1378a;

    public TodayNotificationsListSeeAllView(Context context) {
        super(context);
        setContentView(2130906633);
        setBackgroundColor(getResources().getColor(2131361920));
        this.f1378a = (TextView) c(2131566657);
        ((LayoutParams) this.f1378a.getLayoutParams()).gravity = 17;
        setOnTouchListener(new HighlightCustomViewOnTouchListener(this.f1378a));
    }
}
