package com.facebook.feedplugins.saved.rows.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.attachments.angora.actionbutton.SaveButton;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.ViewType;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;

/* compiled from: notification_stories_cache_IDs */
public class SavedCollectionItemView extends PagerItemWrapperLayout implements RecyclableView {
    public static final ViewType<SavedCollectionItemView> f6786a = new C03191();
    public boolean f6787b;
    private ViewStub f6788c;
    private ViewStub f6789d;
    public FbDraweeView f6790e;
    public SavedCollectionInlineVideoView f6791f;
    public TextView f6792g;
    private TextView f6793h;
    private TextView f6794i;
    private ViewGroup f6795j;
    private ViewGroup f6796k;
    private View f6797l;
    public SaveButton f6798m;
    public final View f6799n;
    private boolean f6800o;

    /* compiled from: notification_stories_cache_IDs */
    final class C03191 extends ViewType<SavedCollectionItemView> {
        C03191() {
        }

        public final View m7163a(Context context) {
            return new SavedCollectionItemView(context);
        }
    }

    public SavedCollectionItemView(Context context) {
        this(context, null);
    }

    private SavedCollectionItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6800o = false;
        setContentView(2130906940);
        this.f6788c = (ViewStub) c(2131567212);
        this.f6789d = (ViewStub) c(2131567215);
        this.f6792g = (TextView) c(2131567220);
        this.f6793h = (TextView) c(2131567221);
        this.f6794i = (TextView) c(2131567222);
        this.f6795j = (ViewGroup) c(2131567218);
        this.f6796k = (ViewGroup) c(2131567217);
        this.f6797l = c(2131567219);
        this.f6798m = (SaveButton) c(2131567223);
        this.f6799n = c(2131567214);
    }

    @VisibleForTesting
    public DraweeView getMainImageView() {
        return this.f6790e;
    }

    @VisibleForTesting
    public SavedCollectionInlineVideoView getInlineVideoView() {
        return this.f6791f;
    }

    public void setMainImageController(@Nullable DraweeController draweeController) {
        m7159f();
        this.f6790e.setVisibility(0);
        if (this.f6791f != null) {
            this.f6791f.setVisibility(8);
        }
        this.f6790e.setController(draweeController);
    }

    public final void m7161a(VideoPlayerParams videoPlayerParams, ImmutableMap<String, Object> immutableMap) {
        m7158e();
        this.f6791f.setVisibility(0);
        if (this.f6790e != null) {
            this.f6790e.setVisibility(8);
        }
        this.f6791f.a(videoPlayerParams, immutableMap);
    }

    public void setTextContainerOnClickListener(@Nullable OnClickListener onClickListener) {
        this.f6795j.setOnClickListener(onClickListener);
    }

    public void setMainImageOnClickListener(@Nullable OnClickListener onClickListener) {
        if (onClickListener != null) {
            m7159f();
        }
        if (this.f6790e != null) {
            this.f6790e.setOnClickListener(onClickListener);
        }
    }

    public void setInlineVideoOnClickListener(@Nullable OnClickListener onClickListener) {
        if (onClickListener != null) {
            m7158e();
        }
        if (this.f6791f != null) {
            this.f6791f.setOnClickListener(onClickListener);
        }
    }

    public void setSubtitleText(@Nullable CharSequence charSequence) {
        this.f6793h.setText(charSequence);
        m7157b();
    }

    public void setContextText(@Nullable CharSequence charSequence) {
        this.f6794i.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            this.f6794i.setVisibility(8);
        } else {
            this.f6794i.setVisibility(0);
        }
        m7157b();
    }

    public final void m7160a(EventTriggerType eventTriggerType, int i) {
        m7158e();
        this.f6791f.m14819a(eventTriggerType, i);
    }

    public void setFullWidth(boolean z) {
        int i;
        int i2;
        this.f6800o = z;
        if (this.f6800o) {
            i = getContext().getResources().getDisplayMetrics().widthPixels;
            i2 = (int) (((double) i) / 1.5d);
        } else {
            i = getResources().getDimensionPixelSize(2131428865);
            i2 = getResources().getDimensionPixelSize(2131428865);
        }
        if (this.f6790e != null) {
            this.f6790e.setLayoutParams(new LayoutParams(i, i2));
        }
        if (this.f6791f != null) {
            this.f6791f.setLayoutParams(new LinearLayout.LayoutParams(i, i2));
        }
        this.f6796k.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) getResources().getDimension(2131428870)));
    }

    public void setSaveButtonVisibility(int i) {
        this.f6797l.setVisibility(i);
        this.f6798m.setVisibility(i);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -698770142);
        super.onAttachedToWindow();
        this.f6787b = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1701878286, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1272717706);
        super.onDetachedFromWindow();
        this.f6787b = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1215015620, a);
    }

    public final boolean mo569a() {
        return this.f6787b;
    }

    private void m7157b() {
        if (TextUtils.isEmpty(this.f6794i.getText()) || TextUtils.isEmpty(this.f6793h.getText())) {
            this.f6792g.setMaxLines(2);
        } else {
            this.f6792g.setMaxLines(1);
        }
    }

    private void m7158e() {
        if (this.f6791f == null) {
            this.f6791f = (SavedCollectionInlineVideoView) this.f6789d.inflate();
        }
        setFullWidth(this.f6800o);
    }

    private void m7159f() {
        if (this.f6790e == null) {
            this.f6790e = (FbDraweeView) this.f6788c.inflate();
            this.f6790e.setHierarchy(new GenericDraweeHierarchyBuilder(getResources()).u());
        }
        setFullWidth(this.f6800o);
    }
}
