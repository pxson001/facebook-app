package com.facebook.feedplugins.instagram;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;

/* compiled from: null_privacy_option_received */
public class InstagramPhotosFromFriendsItemView extends PagerItemWrapperLayout implements RecyclableView {
    public static final ViewType<InstagramPhotosFromFriendsItemView> f6640a = new C03031();
    public TextView f6641b = ((TextView) c(2131563202));
    public TextView f6642c = ((TextView) c(2131563203));
    public DraweeView f6643d = ((DraweeView) c(2131563201));
    public ImageView f6644e = ((ImageView) c(2131563204));
    public boolean f6645f;

    /* compiled from: null_privacy_option_received */
    final class C03031 extends ViewType<InstagramPhotosFromFriendsItemView> {
        C03031() {
        }

        public final View m7043a(Context context) {
            return new InstagramPhotosFromFriendsItemView(context);
        }
    }

    public InstagramPhotosFromFriendsItemView(Context context) {
        super(context);
        setContentView(2130904933);
        this.f6643d.setHierarchy(new GenericDraweeHierarchyBuilder(getContext().getResources()).e(ScaleType.g).u());
        TrackingNodes.a(this.f6643d, TrackingNode.PHOTO);
        TrackingNodes.a(this.f6641b, TrackingNode.USER_NAME);
        TrackingNodes.a(this.f6642c, TrackingNode.SUBTITLE);
    }

    public void setLikeClickListener(OnClickListener onClickListener) {
        this.f6644e.setOnClickListener(onClickListener);
    }

    public void setPhotoClickListener(OnClickListener onClickListener) {
        this.f6643d.setOnClickListener(onClickListener);
    }

    public void setLikeSelected(boolean z) {
        this.f6644e.setSelected(z);
    }

    public void setInstallClickListener(OnClickListener onClickListener) {
        this.f6644e.setOnClickListener(onClickListener);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -471283089);
        super.onAttachedToWindow();
        this.f6645f = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -847007881, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 403463778);
        super.onDetachedFromWindow();
        this.f6645f = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1417988489, a);
    }

    public final boolean mo569a() {
        return this.f6645f;
    }
}
