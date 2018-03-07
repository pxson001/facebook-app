package com.facebook.feedplugins.reviews.views;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.maps.FbStaticMapView;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;
import com.facebook.zero.sdk.common.ZeroFeatureKey;

/* compiled from: frame_rate_logging */
public class PlaceReviewItemView extends PagerItemWrapperLayout implements RecyclableView {
    public static final ViewType f13002a = new C13551();
    public final LinearLayout f13003b = ((LinearLayout) c(2131566001));
    public final TextView f13004c = ((TextView) c(2131566007));
    public final TextView f13005d = ((TextView) c(2131566008));
    public final FbDraweeView f13006e = ((FbDraweeView) c(2131566002));
    public final FbStaticMapView f13007f = ((FbStaticMapView) c(2131566003));
    private final ImageView f13008g = ((ImageView) c(2131566004));
    private final View f13009h = c(2131566009);
    private final ViewGroup f13010i = ((ViewGroup) c(2131566005));
    private boolean f13011j;

    /* compiled from: frame_rate_logging */
    final class C13551 extends ViewType {
        C13551() {
        }

        public final View m14720a(Context context) {
            return new PlaceReviewItemView(context);
        }
    }

    public PlaceReviewItemView(Context context) {
        super(context);
        setContentView(2130906262);
        if (getContext() instanceof FragmentActivity) {
            this.f13007f.a(ZeroFeatureKey.VIEW_MAP_INTERSTITIAL, ((FragmentActivity) getContext()).kO_(), null);
        }
    }

    public void setHasBeenAttached(boolean z) {
        this.f13011j = z;
    }

    public final boolean m14721a() {
        return this.f13011j;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f13003b.setOnClickListener(onClickListener);
    }

    public void setMainImageVisibility(int i) {
        this.f13006e.setVisibility(i);
    }

    public void setMapImageVisibility(int i) {
        this.f13007f.setVisibility(i);
    }

    public void setBottomSectionContainerOnClickListener(OnClickListener onClickListener) {
        this.f13010i.setOnClickListener(onClickListener);
    }

    public void setTitleOnClickListener(OnClickListener onClickListener) {
        this.f13004c.setOnClickListener(onClickListener);
    }

    public void setReviewButtonOnClickListener(OnClickListener onClickListener) {
        this.f13009h.setOnClickListener(onClickListener);
    }

    public void setXOutIconOnClickListener(OnClickListener onClickListener) {
        this.f13008g.setOnClickListener(onClickListener);
    }
}
