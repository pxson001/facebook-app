package com.facebook.nearby.v2.resultlist.views.itemview;

import android.content.Context;
import android.location.Location;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nearby.v2.model.NearbyPlacesPlaceModel;
import com.facebook.nearby.v2.resultlist.views.itemview.NearbyPlacesResultListItemHeaderView.HeaderViewType;
import com.facebook.nearby.v2.resultlist.views.itemview.actionbar.NearbyPlacesActionBarActionComponents;
import com.facebook.nearby.v2.resultlist.views.itemview.actionbar.NearbyPlacesActionBarView;
import com.facebook.nearby.v2.resultlist.views.itemview.actionbar.NearbyPlacesActionBarView.ActionBarItemType;
import com.facebook.nearby.v2.resultlist.views.itemview.actionbar.NearbyPlacesActionBarView.OnActionBarItemClickedListener;
import com.facebook.nearby.v2.resultlist.views.itemview.photohscroll.NearbyPlacesPhotoHScrollView;
import com.facebook.nearby.v2.resultlist.views.itemview.photohscroll.NearbyPlacesPhotoHScrollView.OnPhotoClickedListener;
import com.facebook.nearby.v2.resultlist.views.itemview.socialcontext.NearbyPlacesFriendsWhoVisitedView;
import com.facebook.nearby.v2.resultlist.views.itemview.socialcontext.NearbyPlacesSocialContextComponentType;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomRelativeLayout;
import com.google.common.base.Preconditions;

/* compiled from: deleteReviewParams */
public class NearbyPlacesResultListItemView extends CustomRelativeLayout {
    private final NearbyPlacesResultListItemHeaderView f15986a;
    private final NearbyPlacesActionBarView f15987b;
    private final NearbyPlacesPhotoHScrollView f15988c;
    public final NearbyPlacesFriendsWhoVisitedView f15989d;
    private final OnClickListener f15990e;
    private final OnPhotoClickedListener f15991f;
    private final OnActionBarItemClickedListener f15992g;
    private final OnClickListener f15993h;
    public OnResultListItemViewClickedListener f15994i;

    /* compiled from: deleteReviewParams */
    public interface OnResultListItemViewClickedListener {
        void mo955a();

        void mo956a(int i);

        void mo957a(ActionBarItemType actionBarItemType);

        void mo958b();
    }

    /* compiled from: deleteReviewParams */
    class C17091 implements OnClickListener {
        final /* synthetic */ NearbyPlacesResultListItemView f15981a;

        C17091(NearbyPlacesResultListItemView nearbyPlacesResultListItemView) {
            this.f15981a = nearbyPlacesResultListItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1946800650);
            if (this.f15981a.f15994i == null) {
                Logger.a(2, EntryType.UI_INPUT_END, 348042572, a);
                return;
            }
            this.f15981a.f15994i.mo955a();
            LogUtils.a(1164906905, a);
        }
    }

    /* compiled from: deleteReviewParams */
    class C17102 implements OnPhotoClickedListener {
        final /* synthetic */ NearbyPlacesResultListItemView f15982a;

        C17102(NearbyPlacesResultListItemView nearbyPlacesResultListItemView) {
            this.f15982a = nearbyPlacesResultListItemView;
        }

        public final void mo968a(int i) {
            if (this.f15982a.f15994i != null) {
                this.f15982a.f15994i.mo956a(i);
            }
        }
    }

    /* compiled from: deleteReviewParams */
    class C17113 implements OnActionBarItemClickedListener {
        final /* synthetic */ NearbyPlacesResultListItemView f15983a;

        C17113(NearbyPlacesResultListItemView nearbyPlacesResultListItemView) {
            this.f15983a = nearbyPlacesResultListItemView;
        }

        public final void mo969a(ActionBarItemType actionBarItemType) {
            if (this.f15983a.f15994i != null) {
                this.f15983a.f15994i.mo957a(actionBarItemType);
            }
        }
    }

    /* compiled from: deleteReviewParams */
    class C17124 implements OnClickListener {
        final /* synthetic */ NearbyPlacesResultListItemView f15984a;

        C17124(NearbyPlacesResultListItemView nearbyPlacesResultListItemView) {
            this.f15984a = nearbyPlacesResultListItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 592681559);
            Preconditions.checkArgument(view == this.f15984a.f15989d);
            this.f15984a.f15994i.mo958b();
            LogUtils.a(-2037568835, a);
        }
    }

    public NearbyPlacesResultListItemView(Context context) {
        this(context, null);
    }

    private NearbyPlacesResultListItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private NearbyPlacesResultListItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15990e = new C17091(this);
        this.f15991f = new C17102(this);
        this.f15992g = new C17113(this);
        this.f15993h = new C17124(this);
        setContentView(2130905403);
        this.f15986a = (NearbyPlacesResultListItemHeaderView) a(2131564149);
        this.f15986a.setOnClickListener(this.f15990e);
        this.f15987b = (NearbyPlacesActionBarView) a(2131564150);
        this.f15987b.f16004g = this.f15992g;
        this.f15988c = (NearbyPlacesPhotoHScrollView) a(2131564151);
        this.f15988c.f16026b = this.f15991f;
        this.f15989d = (NearbyPlacesFriendsWhoVisitedView) a(2131564152);
        this.f15989d.setOnClickListener(this.f15993h);
    }

    public final void m18798a(NearbyPlacesPlaceModel nearbyPlacesPlaceModel, Location location, boolean z) {
        Object obj;
        HeaderViewType headerViewType;
        Preconditions.checkNotNull(nearbyPlacesPlaceModel);
        Preconditions.checkNotNull(nearbyPlacesPlaceModel);
        Preconditions.checkNotNull(nearbyPlacesPlaceModel.m17737a());
        if (nearbyPlacesPlaceModel.f15301a.mo926H() == null || nearbyPlacesPlaceModel.f15301a.mo926H().isEmpty()) {
            obj = null;
        } else {
            obj = 1;
        }
        Object obj2 = obj;
        Object obj3 = (!nearbyPlacesPlaceModel.m17753s() || nearbyPlacesPlaceModel.m17748l().size() < 3) ? null : 1;
        if (obj3 != null) {
            headerViewType = HeaderViewType.LARGE;
        } else if (obj2 != null) {
            headerViewType = HeaderViewType.MEDIUM;
        } else {
            headerViewType = HeaderViewType.SMALL;
        }
        HeaderViewType headerViewType2 = headerViewType;
        this.f15986a.m18793a(nearbyPlacesPlaceModel, headerViewType2);
        if (headerViewType2 == HeaderViewType.LARGE) {
            this.f15988c.setVisibility(0);
            this.f15988c.m18817a(nearbyPlacesPlaceModel);
        } else {
            this.f15988c.m18816a();
            this.f15988c.setVisibility(8);
        }
        if (NearbyPlacesActionBarActionComponents.m18799a(nearbyPlacesPlaceModel, location, z).f15995a > 0) {
            this.f15987b.setVisibility(0);
            this.f15987b.m18804a(nearbyPlacesPlaceModel, location, z);
        } else {
            this.f15987b.setVisibility(8);
        }
        switch (NearbyPlacesSocialContextComponentType.getComponentTypeForPlace(nearbyPlacesPlaceModel)) {
            case FRIENDS_WHO_REVIEWED:
                this.f15989d.setVisibility(8);
                return;
            case FRIENDS_WHO_VISITED:
                this.f15989d.setVisibility(0);
                this.f15989d.m18821a(nearbyPlacesPlaceModel.m17741e(), nearbyPlacesPlaceModel.m17737a());
                return;
            default:
                this.f15989d.setVisibility(8);
                return;
        }
    }
}
