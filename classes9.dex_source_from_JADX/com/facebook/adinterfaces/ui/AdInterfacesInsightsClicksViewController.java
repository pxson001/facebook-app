package com.facebook.adinterfaces.ui;

import android.view.View;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesInsightsViewModel;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryInsightsModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: V2_RECENT_ITEMS */
public class AdInterfacesInsightsClicksViewController extends BaseAdInterfacesViewController<SegmentedBarInfoView, AdInterfacesBoostPostDataModel> {
    public StoryInsightsModel f22734a;
    public SegmentedBarInfoView f22735b;
    private AdInterfacesDataHelper f22736c;
    public int f22737d;
    public Builder<Integer> f22738e;
    public Builder<String> f22739f;
    public Builder<String> f22740g;
    public Builder<Float> f22741h;

    public final void mo982a(View view, AdInterfacesCardLayout adInterfacesCardLayout) {
        int i;
        SegmentedBarInfoView segmentedBarInfoView = (SegmentedBarInfoView) view;
        super.mo982a(segmentedBarInfoView, adInterfacesCardLayout);
        adInterfacesCardLayout.setHeaderTitleResource(2131233967);
        this.f22735b = segmentedBarInfoView;
        Preconditions.checkNotNull(this.f22734a);
        if (this.f22734a.mO_() > 0 || this.f22734a.mQ_() > 0) {
            i = 3;
        } else {
            i = 2;
        }
        this.f22737d = i;
        this.f22738e = new Builder();
        this.f22739f = new Builder();
        this.f22740g = new Builder();
        this.f22741h = new Builder();
        this.f22738e.c(Integer.valueOf(this.f22735b.getResources().getColor(2131362859)));
        this.f22739f.c(this.f22735b.getResources().getQuantityString(2131689573, this.f22734a.m23648a()));
        this.f22740g.c(AdInterfacesDataHelper.m22797a(this.f22734a.m23648a(), this.f22735b.getContext()));
        this.f22741h.c(Float.valueOf(((float) this.f22734a.m23648a()) / ((float) this.f22734a.m23655g())));
        if (this.f22734a.mO_() > 0) {
            this.f22738e.c(Integer.valueOf(this.f22735b.getResources().getColor(2131362860)));
            this.f22739f.c(this.f22735b.getResources().getQuantityString(2131689575, this.f22734a.mO_()));
            this.f22740g.c(AdInterfacesDataHelper.m22797a(this.f22734a.mO_(), this.f22735b.getContext()));
            this.f22741h.c(Float.valueOf(((float) this.f22734a.mO_()) / ((float) this.f22734a.m23655g())));
        } else if (this.f22734a.mQ_() > 0) {
            this.f22738e.c(Integer.valueOf(this.f22735b.getResources().getColor(2131362860)));
            this.f22739f.c(this.f22735b.getResources().getQuantityString(2131689576, this.f22734a.mQ_()));
            this.f22740g.c(AdInterfacesDataHelper.m22797a(this.f22734a.mQ_(), this.f22735b.getContext()));
            this.f22741h.c(Float.valueOf(((float) this.f22734a.mQ_()) / ((float) this.f22734a.m23655g())));
        }
        if (this.f22737d == 3) {
            this.f22738e.c(Integer.valueOf(this.f22735b.getResources().getColor(2131362861)));
        } else {
            this.f22738e.c(Integer.valueOf(this.f22735b.getResources().getColor(2131362860)));
        }
        this.f22739f.c(this.f22735b.getResources().getQuantityString(2131689574, this.f22734a.m23653c()));
        this.f22740g.c(AdInterfacesDataHelper.m22797a(this.f22734a.m23653c(), this.f22735b.getContext()));
        this.f22741h.c(Float.valueOf(((float) this.f22734a.m23653c()) / ((float) this.f22734a.m23655g())));
        SegmentedBarInfoView segmentedBarInfoView2 = this.f22735b;
        AdInterfacesInsightsViewModel.Builder builder = new AdInterfacesInsightsViewModel.Builder();
        builder.f21703g = this.f22737d;
        builder = builder;
        builder.f21697a = AdInterfacesDataHelper.m22797a(this.f22734a.m23655g(), this.f22735b.getContext());
        builder = builder;
        builder.f21698b = this.f22735b.getResources().getString(2131233972);
        builder = builder;
        builder.f21702f = this.f22738e.b();
        builder = builder;
        builder.f21700d = this.f22739f.b();
        builder = builder;
        builder.f21699c = this.f22740g.b();
        builder = builder;
        builder.f21701e = this.f22741h.b();
        segmentedBarInfoView2.setViewModel(builder.m22829a());
        this.f22738e = null;
        this.f22739f = null;
        this.f22740g = null;
        this.f22741h = null;
        this.f22734a = null;
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        this.f22734a = ((AdInterfacesBoostPostDataModel) baseAdInterfacesData).f21780a.m23711j();
    }

    @Inject
    public AdInterfacesInsightsClicksViewController(AdInterfacesDataHelper adInterfacesDataHelper) {
        this.f22736c = adInterfacesDataHelper;
    }

    public final void mo981a() {
        super.mo981a();
        this.f22735b = null;
    }
}
