package com.facebook.feedplugins.attachments.multimedia.ui;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import com.facebook.attachments.videos.ui.InlineVideoAttachmentView;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.collage.ui.CollageAttachmentView;
import com.facebook.feedplugins.attachments.multimedia.MultimediaCollageAttachmentPartDefinition.1;
import com.facebook.inject.FbInjector;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

/* compiled from: group url is null for inviting users via share. */
public class MultimediaAttachmentView extends CustomFrameLayout {
    @Inject
    public QeAccessor f11996a;
    public InlineVideoAttachmentView f11997b;
    private CollageAttachmentView f11998c;
    private int f11999d = -1;
    private GestureDetectorCompat f12000e;
    public 1 f12001f;

    /* compiled from: group url is null for inviting users via share. */
    class C12851 extends SimpleOnGestureListener {
        final /* synthetic */ MultimediaAttachmentView f11995a;

        C12851(MultimediaAttachmentView multimediaAttachmentView) {
            this.f11995a = multimediaAttachmentView;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (this.f11995a.f12001f == null) {
                return false;
            }
            this.f11995a.f12001f.a.f.a(EventTriggerType.BY_NEWSFEED_OCCLUSION);
            return true;
        }
    }

    public static void m14070a(Object obj, Context context) {
        ((MultimediaAttachmentView) obj).f11996a = (QeAccessor) QeInternalImplMethodAutoProvider.a(FbInjector.get(context));
    }

    public MultimediaAttachmentView(Context context) {
        super(context);
        setContentView(2130905354);
        Class cls = MultimediaAttachmentView.class;
        m14070a(this, getContext());
        this.f11998c = (CollageAttachmentView) findViewById(2131564005);
        if (this.f11996a.a(ExperimentsForNewsFeedAbTestModule.F, false)) {
            this.f11997b = new InlineVideoAttachmentView(getContext());
            this.f11997b.setId(2131558600);
            addView(this.f11997b);
        }
        this.f12000e = new GestureDetectorCompat(getContext(), new C12851(this));
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f12000e.a(motionEvent);
        return false;
    }

    public void setVideoIndex(int i) {
        this.f11999d = i;
        if (this.f11997b == null) {
            return;
        }
        if (this.f11999d == -1) {
            this.f11997b.setVisibility(8);
        } else {
            this.f11997b.setVisibility(0);
        }
    }

    protected void onMeasure(int i, int i2) {
        this.f11998c.measure(i, i2);
        if (this.f11999d != -1) {
            Rect c = this.f11998c.c(this.f11999d);
            this.f11997b.measure(MeasureSpec.makeMeasureSpec(c.width(), 1073741824), MeasureSpec.makeMeasureSpec(c.height(), 1073741824));
        }
        setMeasuredDimension(this.f11998c.getMeasuredWidth(), this.f11998c.getMeasuredHeight());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f11998c.layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        if (this.f11999d != -1) {
            Rect c = this.f11998c.c(this.f11999d);
            this.f11997b.layout(this.f11998c.getPaddingLeft() + c.left, this.f11998c.getPaddingTop() + c.top, this.f11998c.getPaddingLeft() + c.right, c.bottom + this.f11998c.getPaddingTop());
        }
    }
}
