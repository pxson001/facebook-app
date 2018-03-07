package com.facebook.adinterfaces.ui;

import android.view.View;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesInsightsViewModel.Builder;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryInsightsModel;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: V2_PHOTO_REMINDERS */
public class AdInterfacesInsightsReachViewController extends BaseAdInterfacesViewController<SegmentedBarInfoView, AdInterfacesBoostPostDataModel> {
    public StoryInsightsModel f22745a;
    public SegmentedBarInfoView f22746b;
    private AdInterfacesDataHelper f22747c;

    public final void mo982a(View view, AdInterfacesCardLayout adInterfacesCardLayout) {
        SegmentedBarInfoView segmentedBarInfoView = (SegmentedBarInfoView) view;
        super.mo982a(segmentedBarInfoView, adInterfacesCardLayout);
        adInterfacesCardLayout.setHeaderTitleResource(2131233966);
        this.f22746b = segmentedBarInfoView;
        SegmentedBarInfoView segmentedBarInfoView2 = this.f22746b;
        Builder builder = new Builder();
        builder.f21703g = 2;
        builder = builder;
        builder.f21697a = AdInterfacesDataHelper.m22797a(this.f22745a.mP_(), this.f22746b.getContext());
        builder = builder;
        builder.f21698b = this.f22746b.getResources().getString(2131233970);
        builder = builder;
        builder.f21702f = ImmutableList.of(Integer.valueOf(this.f22746b.getResources().getColor(2131362854)), Integer.valueOf(this.f22746b.getResources().getColor(2131362855)));
        builder = builder;
        builder.f21700d = ImmutableList.of(this.f22746b.getResources().getString(2131233968), this.f22746b.getResources().getString(2131233969));
        builder = builder;
        builder.f21699c = ImmutableList.of(AdInterfacesDataHelper.m22797a(this.f22745a.m23652b(), this.f22746b.getContext()), AdInterfacesDataHelper.m22797a(this.f22745a.m23654d(), this.f22746b.getContext()));
        builder = builder;
        builder.f21701e = ImmutableList.of(Float.valueOf(((float) this.f22745a.m23652b()) / ((float) this.f22745a.mP_())), Float.valueOf(((float) this.f22745a.m23654d()) / ((float) this.f22745a.mP_())));
        segmentedBarInfoView2.setViewModel(builder.m22829a());
        this.f22745a = null;
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        this.f22745a = ((AdInterfacesBoostPostDataModel) baseAdInterfacesData).f21780a.m23711j();
    }

    @Inject
    public AdInterfacesInsightsReachViewController(AdInterfacesDataHelper adInterfacesDataHelper) {
        this.f22747c = adInterfacesDataHelper;
    }

    public final void mo981a() {
        super.mo981a();
        this.f22746b = null;
    }
}
