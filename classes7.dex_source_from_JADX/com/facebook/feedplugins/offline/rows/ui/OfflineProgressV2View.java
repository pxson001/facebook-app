package com.facebook.feedplugins.offline.rows.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.util.composer.OfflinePostProgress;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.CyclingTextSwitcher;
import java.util.concurrent.TimeUnit;

/* compiled from: STANDARD */
public class OfflineProgressV2View extends CustomRelativeLayout implements OfflinePostProgress {
    private CyclingTextSwitcher f23713a;
    private View f23714b = a(2131564384);

    public OfflineProgressV2View(Context context) {
        super(context);
        setContentView(2130905541);
    }

    public void setProgress(int i) {
    }

    public final void mo1590a(GraphQLStory graphQLStory) {
    }

    public final void mo1589a() {
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f23714b.setOnClickListener(onClickListener);
    }

    private void m25894c() {
        if (this.f23713a == null) {
            this.f23713a = (CyclingTextSwitcher) a(2131564389);
        }
    }

    public final void m25897a(int[] iArr, int i) {
        m25894c();
        this.f23713a.a(iArr, (long) i, TimeUnit.MILLISECONDS);
    }

    public void setAnimated(boolean z) {
        m25894c();
        this.f23713a.a = z;
    }
}
