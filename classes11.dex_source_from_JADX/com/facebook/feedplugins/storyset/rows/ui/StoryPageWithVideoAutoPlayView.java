package com.facebook.feedplugins.storyset.rows.ui;

import android.content.Context;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.feedplugins.video.RichVideoAttachmentView;
import com.facebook.widget.RecyclableView;

/* compiled from: answered_video_call */
public class StoryPageWithVideoAutoPlayView extends StoryPageView implements RecyclableView {
    private LinearLayout f9875a;
    private RichVideoAttachmentView f9876b;

    public StoryPageWithVideoAutoPlayView(Context context) {
        this(context, 2130907280);
    }

    private StoryPageWithVideoAutoPlayView(Context context, int i) {
        super(context, i);
        this.f9875a = (LinearLayout) c(2131562633);
        this.f9876b = (RichVideoAttachmentView) c(2131559579);
    }

    public void setWidth(int i) {
        LayoutParams layoutParams = (LayoutParams) this.f9875a.getLayoutParams();
        layoutParams.width = i;
        this.f9875a.setLayoutParams(layoutParams);
        this.f9875a.requestLayout();
    }

    public RichVideoAttachmentView getInlineVideoAttachmentView() {
        return this.f9876b;
    }
}
