package com.facebook.feedplugins.attachments.multimedia.ui;

import android.content.Context;
import android.graphics.Rect;
import android.view.View.MeasureSpec;
import com.facebook.feed.collage.ui.CollageAttachmentView;
import com.facebook.feedplugins.video.RichVideoAttachmentView;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: grid_width_percent */
public class MultimediaSinglePlayerAttachmentView extends CustomFrameLayout {
    private final RichVideoAttachmentView f12002a;
    private final CollageAttachmentView f12003b;
    private int f12004c = -1;

    public MultimediaSinglePlayerAttachmentView(Context context) {
        super(context);
        setContentView(2130905354);
        this.f12003b = (CollageAttachmentView) c(2131564005);
        this.f12002a = new RichVideoAttachmentView(getContext());
        this.f12002a.setId(2131558600);
        addView(this.f12002a);
    }

    public void setVideoIndex(int i) {
        this.f12004c = i;
        if (this.f12004c == -1) {
            this.f12002a.setVisibility(8);
        } else {
            this.f12002a.setVisibility(0);
        }
    }

    protected void onMeasure(int i, int i2) {
        this.f12003b.measure(i, i2);
        if (this.f12004c != -1) {
            Rect c = this.f12003b.c(this.f12004c);
            this.f12002a.measure(MeasureSpec.makeMeasureSpec(c.width(), 1073741824), MeasureSpec.makeMeasureSpec(c.height(), 1073741824));
        }
        setMeasuredDimension(this.f12003b.getMeasuredWidth(), this.f12003b.getMeasuredHeight());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f12003b.layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        if (this.f12004c != -1) {
            Rect c = this.f12003b.c(this.f12004c);
            this.f12002a.layout(this.f12003b.getPaddingLeft() + c.left, this.f12003b.getPaddingTop() + c.top, this.f12003b.getPaddingLeft() + c.right, c.bottom + this.f12003b.getPaddingTop());
        }
    }
}
