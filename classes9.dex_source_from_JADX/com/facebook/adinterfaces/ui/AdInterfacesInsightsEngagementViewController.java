package com.facebook.adinterfaces.ui;

import android.content.res.Resources;
import android.view.View;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesInsightsViewModel.Builder;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryFeedbackModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: V2_RECENT_ITEM */
public class AdInterfacesInsightsEngagementViewController extends BaseAdInterfacesViewController<SegmentedBarInfoView, AdInterfacesBoostPostDataModel> {
    public StoryFeedbackModel f22742a;
    public SegmentedBarInfoView f22743b;
    private AdInterfacesDataHelper f22744c;

    public final void mo982a(View view, AdInterfacesCardLayout adInterfacesCardLayout) {
        int i;
        SegmentedBarInfoView segmentedBarInfoView = (SegmentedBarInfoView) view;
        super.mo982a(segmentedBarInfoView, adInterfacesCardLayout);
        adInterfacesCardLayout.setHeaderTitleResource(2131233965);
        this.f22743b = segmentedBarInfoView;
        Preconditions.checkNotNull(this.f22742a);
        Preconditions.checkNotNull(this.f22742a.m23640b());
        Preconditions.checkNotNull(this.f22742a.m23641c());
        Preconditions.checkNotNull(this.f22742a.m23642d());
        int a = this.f22742a.m23642d().m23627a() + (this.f22742a.m23640b().m23612a() + this.f22742a.m23641c().m23619a());
        SegmentedBarInfoView segmentedBarInfoView2 = this.f22743b;
        Builder builder = new Builder();
        builder.f21703g = 3;
        builder = builder;
        builder.f21697a = AdInterfacesDataHelper.m22797a(a, this.f22743b.getContext());
        builder = builder;
        builder.f21698b = this.f22743b.getResources().getString(2131233971);
        builder = builder;
        builder.f21702f = ImmutableList.of(Integer.valueOf(this.f22743b.getResources().getColor(2131362856)), Integer.valueOf(this.f22743b.getResources().getColor(2131362857)), Integer.valueOf(this.f22743b.getResources().getColor(2131362858)));
        Builder builder2 = builder;
        Resources resources = this.f22743b.getResources();
        if (this.f22742a.m23639a()) {
            i = 2131689581;
        } else {
            i = 2131689580;
        }
        builder2.f21700d = ImmutableList.of(resources.getQuantityString(i, this.f22742a.m23640b().m23612a()), this.f22743b.getResources().getQuantityString(2131689582, this.f22742a.m23642d().m23627a()), this.f22743b.getResources().getQuantityString(2131689583, this.f22742a.m23641c().m23619a()));
        builder = builder2;
        builder.f21699c = ImmutableList.of(AdInterfacesDataHelper.m22797a(this.f22742a.m23640b().m23612a(), this.f22743b.getContext()), AdInterfacesDataHelper.m22797a(this.f22742a.m23642d().m23627a(), this.f22743b.getContext()), AdInterfacesDataHelper.m22797a(this.f22742a.m23641c().m23619a(), this.f22743b.getContext()));
        builder = builder;
        builder.f21701e = ImmutableList.of(Float.valueOf(((float) this.f22742a.m23640b().m23612a()) / ((float) a)), Float.valueOf(((float) this.f22742a.m23642d().m23627a()) / ((float) a)), Float.valueOf(((float) this.f22742a.m23641c().m23619a()) / ((float) a)));
        segmentedBarInfoView2.setViewModel(builder.m22829a());
        this.f22742a = null;
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        this.f22742a = ((AdInterfacesBoostPostDataModel) baseAdInterfacesData).f21780a.m23707a();
    }

    @Inject
    public AdInterfacesInsightsEngagementViewController(AdInterfacesDataHelper adInterfacesDataHelper) {
        this.f22744c = adInterfacesDataHelper;
    }

    public final void mo981a() {
        super.mo981a();
        this.f22743b = null;
    }
}
