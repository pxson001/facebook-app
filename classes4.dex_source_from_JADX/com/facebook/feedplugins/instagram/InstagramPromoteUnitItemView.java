package com.facebook.feedplugins.instagram;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.attachments.angora.CoverPhotoWithPlayIconView;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.fbui.widget.text.GlyphWithTextView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;

/* compiled from: null_privacy_option_type_received */
public class InstagramPromoteUnitItemView extends PagerItemWrapperLayout implements RecyclableView {
    public static final ViewType<InstagramPromoteUnitItemView> f6635a = new C03021();
    public TextView f6636b = ((TextView) c(2131563202));
    public CoverPhotoWithPlayIconView f6637c = ((CoverPhotoWithPlayIconView) c(2131563201));
    public boolean f6638d;
    public GlyphWithTextView f6639e = ((GlyphWithTextView) c(2131559198));

    /* compiled from: null_privacy_option_type_received */
    final class C03021 extends ViewType<InstagramPromoteUnitItemView> {
        C03021() {
        }

        public final View m7041a(Context context) {
            return new InstagramPromoteUnitItemView(context);
        }
    }

    public InstagramPromoteUnitItemView(Context context) {
        super(context);
        setContentView(2130904935);
        this.f6637c.setHierarchy(new GenericDraweeHierarchyBuilder(getContext().getResources()).e(ScaleType.g).u());
        TrackingNodes.a(this.f6637c, TrackingNode.PHOTO);
        TrackingNodes.a(this.f6636b, TrackingNode.USER_NAME);
    }

    public void setPhotoClickListener(OnClickListener onClickListener) {
        this.f6637c.setOnClickListener(onClickListener);
    }

    public void setInstallClickListener(OnClickListener onClickListener) {
        this.f6639e.setOnClickListener(onClickListener);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1095622510);
        super.onAttachedToWindow();
        this.f6638d = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1526128460, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1360205408);
        super.onDetachedFromWindow();
        this.f6638d = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1690206881, a);
    }

    public final boolean mo569a() {
        return this.f6638d;
    }
}
