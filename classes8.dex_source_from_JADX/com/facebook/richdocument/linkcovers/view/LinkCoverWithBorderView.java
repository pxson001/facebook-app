package com.facebook.richdocument.linkcovers.view;

import android.content.Context;
import android.view.View;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: place_tag_cancelled */
public class LinkCoverWithBorderView extends CustomFrameLayout {
    public LinkCoverBasicView f5449a;
    public LinkCoverSpecView f5450b;
    public boolean f5451c = true;

    public LinkCoverWithBorderView(Context context) {
        super(context);
        m5346b();
    }

    public final void m5346b() {
        removeAllViews();
        setContentView(2130905052);
        this.f5449a = (LinkCoverBasicView) c(2131563442);
        this.f5450b = null;
        this.f5451c = true;
    }

    public View getLinkCoverSpecViewFrame() {
        return findViewById(2131563439);
    }
}
