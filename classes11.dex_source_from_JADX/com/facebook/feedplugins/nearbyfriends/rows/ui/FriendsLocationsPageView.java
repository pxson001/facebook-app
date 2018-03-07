package com.facebook.feedplugins.nearbyfriends.rows.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.FbMapViewDelegate;
import com.facebook.maps.FbStaticMapView;
import com.facebook.maps.delegate.OnMapReadyDelegateCallback;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;
import javax.annotation.Nullable;

/* compiled from: com.facebook.about.AboutActivity */
public class FriendsLocationsPageView extends PagerItemWrapperLayout implements OnInflateListener, RecyclableView {
    public boolean f8553a;
    private final DraweeView f8554b = ((DraweeView) c(2131562343));
    public final ImageView f8555c = ((ImageView) c(2131562344));
    private final TextView f8556d = ((TextView) c(2131562346));
    private final TextView f8557e = ((TextView) c(2131562347));
    private final LinearLayout f8558f = ((LinearLayout) c(2131562345));
    private final View f8559g = c(2131562348);
    private final ImageView f8560h = ((ImageView) c(2131562349));
    private final View f8561i = c(2131562342);
    private final View f8562j = c(2131562336);
    private final FbStaticMapView f8563k = ((FbStaticMapView) c(2131562337));
    private final ViewStub f8564l = ((ViewStub) c(2131562338));
    private FbMapViewDelegate f8565m;
    private final FbDraweeView f8566n = ((FbDraweeView) c(2131562341));
    private final View f8567o = c(2131562340);

    public FriendsLocationsPageView(Context context) {
        super(context);
        setContentView(2130904521);
        this.f8556d.setMovementMethod(LinkMovementMethod.getInstance());
        Drawable colorDrawable = new ColorDrawable(0);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(context.getResources());
        genericDraweeHierarchyBuilder.u = RoundingParams.e();
        genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder;
        genericDraweeHierarchyBuilder.f = colorDrawable;
        this.f8554b.setHierarchy(genericDraweeHierarchyBuilder.u());
        this.f8564l.setOnInflateListener(this);
    }

    public void setCenterImage(@Nullable DraweeController draweeController) {
        this.f8554b.setController(draweeController);
        this.f8561i.setVisibility(draweeController == null ? 8 : 0);
    }

    public void setPageCoverMap(@Nullable StaticMapOptions staticMapOptions) {
        if (staticMapOptions == null) {
            this.f8563k.setVisibility(8);
            return;
        }
        this.f8563k.setMapOptions(staticMapOptions);
        this.f8563k.setVisibility(0);
    }

    public void setPulseMapReadyCallback(OnMapReadyDelegateCallback onMapReadyDelegateCallback) {
        if (onMapReadyDelegateCallback != null) {
            if (this.f8565m == null) {
                this.f8565m = (FbMapViewDelegate) this.f8564l.inflate();
            }
            this.f8565m.setVisibility(0);
            this.f8565m.a(onMapReadyDelegateCallback);
        } else if (this.f8565m != null) {
            this.f8565m.setVisibility(8);
        }
    }

    public final void m9407a(Uri uri, CallerContext callerContext) {
        if (uri == null) {
            this.f8567o.setVisibility(8);
            return;
        }
        this.f8566n.a(uri, callerContext);
        this.f8567o.setVisibility(0);
    }

    public void setNameText(String str) {
        this.f8556d.setText(str);
        this.f8554b.setContentDescription(str);
    }

    public void setOnNameClickListener(OnClickListener onClickListener) {
        this.f8556d.setOnClickListener(onClickListener);
    }

    public void setOnLocationClickListener(OnClickListener onClickListener) {
        this.f8557e.setOnClickListener(onClickListener);
    }

    public void setOnNameLocationSectionClickListener(OnClickListener onClickListener) {
        this.f8558f.setOnClickListener(onClickListener);
    }

    public void setCenterCircleOnClickListener(OnClickListener onClickListener) {
        this.f8554b.setOnClickListener(onClickListener);
    }

    public void setPulseCenterFrameOnClickListener(OnClickListener onClickListener) {
        this.f8567o.setOnClickListener(onClickListener);
    }

    public void setPageCoverOnClickListener(OnClickListener onClickListener) {
        this.f8562j.setOnClickListener(onClickListener);
        this.f8563k.setOnClickListener(onClickListener);
    }

    public final void m9406a(Drawable drawable, String str) {
        this.f8557e.setCompoundDrawables(drawable, null, null, null);
        this.f8557e.setText(str);
    }

    public final void m9405a(Drawable drawable, OnClickListener onClickListener) {
        if (drawable == null) {
            this.f8559g.setVisibility(8);
            this.f8560h.setVisibility(8);
            return;
        }
        this.f8559g.setVisibility(0);
        this.f8560h.setVisibility(0);
        this.f8560h.setImageDrawable(drawable);
        this.f8560h.setOnClickListener(onClickListener);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 744624090);
        super.onAttachedToWindow();
        this.f8553a = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1333483667, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1841256143);
        super.onDetachedFromWindow();
        this.f8553a = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1807815486, a);
    }

    public final boolean m9408a() {
        return this.f8553a;
    }

    public void onInflate(ViewStub viewStub, View view) {
        ((FbMapViewDelegate) view).a(null);
    }
}
