package com.facebook.adinterfaces.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEvent;
import com.facebook.adinterfaces.external.AdInterfacesIntentUtil;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryFeedbackModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryInsightsModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;

/* compiled from: V2_PEOPLE_YOU_MAY_MESSAGE */
public class AdInterfacesInsightsSummaryViewController extends BaseAdInterfacesViewController<AdInterfacesInsightsSummaryView, AdInterfacesBoostPostDataModel> {
    private final AdInterfacesDataHelper f22755a;
    private AdInterfacesBoostPostDataModel f22756b;
    private AdInterfacesInsightsSummaryView f22757c;

    /* compiled from: V2_PEOPLE_YOU_MAY_MESSAGE */
    class C26321 implements OnClickListener {
        final /* synthetic */ AdInterfacesInsightsSummaryViewController f22754a;

        C26321(AdInterfacesInsightsSummaryViewController adInterfacesInsightsSummaryViewController) {
            this.f22754a = adInterfacesInsightsSummaryViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1661890187);
            AdInterfacesInsightsSummaryViewController.m24669b(this.f22754a);
            Logger.a(2, EntryType.UI_INPUT_END, 1582968488, a);
        }
    }

    public static AdInterfacesInsightsSummaryViewController m24668b(InjectorLike injectorLike) {
        return new AdInterfacesInsightsSummaryViewController(AdInterfacesDataHelper.m22789a(injectorLike));
    }

    public final void mo982a(View view, AdInterfacesCardLayout adInterfacesCardLayout) {
        AdInterfacesInsightsSummaryView adInterfacesInsightsSummaryView = (AdInterfacesInsightsSummaryView) view;
        super.mo982a(adInterfacesInsightsSummaryView, adInterfacesCardLayout);
        this.f22757c = adInterfacesInsightsSummaryView;
        StoryPromotionModel storyPromotionModel = this.f22756b.f21780a;
        if (storyPromotionModel.m23711j().m23655g() + (((storyPromotionModel.m23707a().m23643j().m23612a() + storyPromotionModel.m23707a().m23644k().m23619a()) + storyPromotionModel.m23707a().m23645l().m23627a()) + storyPromotionModel.m23711j().mP_()) == 0) {
            adInterfacesInsightsSummaryView.m24665a();
            return;
        }
        m24670c();
        adInterfacesCardLayout.setCallToActionText(this.f22757c.getResources().getString(2131233973));
        adInterfacesCardLayout.setCallToActionClickListener(new C26321(this));
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        this.f22756b = (AdInterfacesBoostPostDataModel) baseAdInterfacesData;
    }

    @Inject
    public AdInterfacesInsightsSummaryViewController(AdInterfacesDataHelper adInterfacesDataHelper) {
        this.f22755a = adInterfacesDataHelper;
    }

    public static AdInterfacesInsightsSummaryViewController m24666a(InjectorLike injectorLike) {
        return m24668b(injectorLike);
    }

    public static void m24669b(AdInterfacesInsightsSummaryViewController adInterfacesInsightsSummaryViewController) {
        Intent a = AdInterfacesIntentUtil.a(adInterfacesInsightsSummaryViewController.f22757c.getContext(), ObjectiveType.BOOST_POST_INSIGHTS, Integer.valueOf(2131233963), adInterfacesInsightsSummaryViewController.f22756b.f21755k);
        a.putExtra("data", adInterfacesInsightsSummaryViewController.f22756b);
        adInterfacesInsightsSummaryViewController.f22440b.m22429a(new IntentEvent(a));
    }

    private void m24670c() {
        StoryInsightsModel j = this.f22756b.f21780a.m23711j();
        StoryFeedbackModel a = this.f22756b.f21780a.m23707a();
        this.f22757c.setFirstDataValue(AdInterfacesDataHelper.m22797a(j.mP_(), this.f22757c.getContext()));
        this.f22757c.setSecondDataValue(AdInterfacesDataHelper.m22797a(a.m23645l().m23627a() + (a.m23643j().m23612a() + a.m23644k().m23619a()), this.f22757c.getContext()));
        this.f22757c.setThirdDataValue(AdInterfacesDataHelper.m22797a(j.m23655g(), this.f22757c.getContext()));
        this.f22757c.setFirstDataLabel(this.f22757c.getResources().getString(2131233966));
        this.f22757c.setSecondDataLabel(this.f22757c.getResources().getString(2131233965));
        this.f22757c.setThirdDataLabel(this.f22757c.getResources().getString(2131233967));
    }

    public final void mo981a() {
        super.mo981a();
        this.f22757c = null;
    }
}
