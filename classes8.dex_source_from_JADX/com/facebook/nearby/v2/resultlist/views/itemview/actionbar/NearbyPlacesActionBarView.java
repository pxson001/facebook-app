package com.facebook.nearby.v2.resultlist.views.itemview.actionbar;

import android.content.Context;
import android.location.Location;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nearby.v2.model.NearbyPlacesPlaceModel;
import com.facebook.nearby.v2.resultlist.util.NearbyPlacesV2OpenNowStatusHelper;
import com.facebook.nearby.v2.resultlist.views.itemview.actionbar.buttons.NearbyPlacesActionBarButtonView;
import com.facebook.nearby.v2.resultlist.views.itemview.actionbar.buttons.NearbyPlacesActionBarDistanceButtonView;
import com.facebook.nearby.v2.resultlist.views.itemview.actionbar.buttons.NearbyPlacesActionBarLikesButtonView;
import com.facebook.nearby.v2.resultlist.views.itemview.actionbar.buttons.NearbyPlacesActionBarOpenNowButtonView;
import com.facebook.nearby.v2.resultlist.views.itemview.actionbar.buttons.NearbyPlacesActionBarPriceRatingButtonView;
import com.facebook.nearby.v2.resultlist.views.itemview.actionbar.buttons.NearbyPlacesActionBarReviewRatingButtonView;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Preconditions;

/* compiled from: daily_dialogue_lightweight_unit_id */
public class NearbyPlacesActionBarView extends CustomLinearLayout {
    private NearbyPlacesActionBarReviewRatingButtonView f15998a;
    private NearbyPlacesActionBarDistanceButtonView f15999b;
    private NearbyPlacesActionBarPriceRatingButtonView f16000c;
    private NearbyPlacesActionBarOpenNowButtonView f16001d;
    private NearbyPlacesActionBarLikesButtonView f16002e;
    private boolean f16003f;
    public OnActionBarItemClickedListener f16004g;

    /* compiled from: daily_dialogue_lightweight_unit_id */
    public interface OnActionBarItemClickedListener {
        void mo969a(ActionBarItemType actionBarItemType);
    }

    /* compiled from: daily_dialogue_lightweight_unit_id */
    public enum ActionBarItemType {
        REVIEW,
        DISTANCE,
        PRICE,
        OPEN_NOW,
        LIKES
    }

    public NearbyPlacesActionBarView(Context context) {
        this(context, null);
    }

    public NearbyPlacesActionBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NearbyPlacesActionBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905399);
        this.f15998a = (NearbyPlacesActionBarReviewRatingButtonView) a(2131564131);
        this.f15999b = (NearbyPlacesActionBarDistanceButtonView) a(2131564132);
        this.f16000c = (NearbyPlacesActionBarPriceRatingButtonView) a(2131564133);
        this.f16001d = (NearbyPlacesActionBarOpenNowButtonView) a(2131564134);
        this.f16002e = (NearbyPlacesActionBarLikesButtonView) a(2131564135);
    }

    public final void m18804a(NearbyPlacesPlaceModel nearbyPlacesPlaceModel, Location location, boolean z) {
        int i;
        Preconditions.checkNotNull(nearbyPlacesPlaceModel);
        if (!this.f16003f) {
            m18800a();
            this.f16003f = true;
        }
        int i2 = NearbyPlacesActionBarActionComponents.m18799a(nearbyPlacesPlaceModel, location, z).f15995a;
        NearbyPlacesActionBarButtonView nearbyPlacesActionBarButtonView = null;
        if ((i2 & 1) > 0) {
            this.f15998a.m18812a(nearbyPlacesPlaceModel.m17750n() != null ? nearbyPlacesPlaceModel.m17750n().m17867c() : 0.0d);
            this.f15998a.setVisibility(0);
            this.f15998a.setShowRightBorder(true);
            nearbyPlacesActionBarButtonView = this.f15998a;
            i = 1;
        } else {
            this.f15998a.setVisibility(8);
            i = 0;
        }
        if ((i2 & 2) > 0) {
            this.f15999b.m18808a(location, nearbyPlacesPlaceModel.m17742f());
            this.f15999b.setVisibility(0);
            this.f15999b.setShowRightBorder(true);
            nearbyPlacesActionBarButtonView = this.f15999b;
            i++;
        } else {
            this.f15999b.setVisibility(8);
        }
        if ((i2 & 4) <= 0 || i >= 4) {
            this.f16000c.setVisibility(8);
        } else {
            this.f16000c.m18811a(nearbyPlacesPlaceModel.m17744h());
            this.f16000c.setVisibility(0);
            this.f16000c.setShowRightBorder(true);
            nearbyPlacesActionBarButtonView = this.f16000c;
            i++;
        }
        if ((i2 & 8) <= 0 || i >= 4) {
            this.f16001d.setVisibility(8);
        } else {
            this.f16001d.m18810a(NearbyPlacesV2OpenNowStatusHelper.m18718a(nearbyPlacesPlaceModel.m17749m(), nearbyPlacesPlaceModel.m17743g()));
            this.f16001d.setVisibility(0);
            this.f16001d.setShowRightBorder(true);
            nearbyPlacesActionBarButtonView = this.f16001d;
            i++;
        }
        if ((i2 & 16) <= 0 || r1 >= 4) {
            this.f16002e.setVisibility(8);
        } else {
            this.f16002e.m18809c(nearbyPlacesPlaceModel.m17746j());
            this.f16002e.setVisibility(0);
            this.f16002e.setShowRightBorder(true);
            nearbyPlacesActionBarButtonView = this.f16002e;
        }
        if (nearbyPlacesActionBarButtonView != null) {
            nearbyPlacesActionBarButtonView.setShowRightBorder(false);
        }
    }

    public void setOnActionBarItemClickedListener(OnActionBarItemClickedListener onActionBarItemClickedListener) {
        this.f16004g = onActionBarItemClickedListener;
    }

    private void m18800a() {
        Preconditions.checkNotNull(this.f15998a);
        this.f15998a.setOnClickListener(m18803b(ActionBarItemType.REVIEW));
        Preconditions.checkNotNull(this.f15999b);
        this.f15999b.setOnClickListener(m18803b(ActionBarItemType.DISTANCE));
        Preconditions.checkNotNull(this.f16000c);
        this.f16000c.setOnClickListener(m18803b(ActionBarItemType.PRICE));
        Preconditions.checkNotNull(this.f16001d);
        this.f16001d.setOnClickListener(m18803b(ActionBarItemType.OPEN_NOW));
        Preconditions.checkNotNull(this.f16002e);
        this.f16002e.setOnClickListener(m18803b(ActionBarItemType.LIKES));
    }

    private void m18801a(ActionBarItemType actionBarItemType) {
        if (this.f16004g != null) {
            this.f16004g.mo969a(actionBarItemType);
        }
    }

    private final OnClickListener m18803b(final ActionBarItemType actionBarItemType) {
        return new OnClickListener(this) {
            final /* synthetic */ NearbyPlacesActionBarView f15997b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1105504922);
                this.f15997b.m18801a(actionBarItemType);
                Logger.a(2, EntryType.UI_INPUT_END, 178814010, a);
            }
        };
    }
}
