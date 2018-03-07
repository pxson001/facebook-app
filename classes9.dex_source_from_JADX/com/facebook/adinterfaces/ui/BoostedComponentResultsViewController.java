package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.adinterfaces.AdInterfacesContext;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEvent;
import com.facebook.adinterfaces.logging.BoostedComponentLogger;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CampaignGroupResultsModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CampaignGroupResultsModel.LifetimeOverallStatsModel;
import com.facebook.adinterfaces.ui.preview.AdInterfacesResultsTooltipNuxController;
import com.facebook.adinterfaces.util.AdInterfacesUiUtil;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Unsupported command %d received by %s. */
public class BoostedComponentResultsViewController extends BaseAdInterfacesViewController<AdInterfacesPromotionDetailsView, AdInterfacesDataModel> {
    public final AdInterfacesReactUtil f23088a;
    public final BoostedComponentLogger f23089b;
    public final Provider<InterstitialManager> f23090c;
    private final AdInterfacesDataHelper f23091d;
    private final Resources f23092e;
    public int f23093f = 0;
    public int f23094g = 0;
    private String f23095h;
    public Runnable f23096i;
    private AdInterfacesPromotionDetailsView f23097j;
    public BaseAdInterfacesData f23098k;

    /* compiled from: Unsupported command %d received by %s. */
    class C27111 implements OnClickListener {
        final /* synthetic */ BoostedComponentResultsViewController f23083a;

        C27111(BoostedComponentResultsViewController boostedComponentResultsViewController) {
            this.f23083a = boostedComponentResultsViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1770100776);
            this.f23083a.f23089b.m22785o(this.f23083a.f23098k);
            String j = this.f23083a.f23098k.mo955p().m23402j();
            String s = AdInterfacesDataHelper.m22792a(this.f23083a.f23098k, this.f23083a.f23098k.m22853i()).m23145s();
            AdInterfacesContext adInterfacesContext = this.f23083a.f22440b;
            AdInterfacesReactUtil adInterfacesReactUtil = this.f23083a.f23088a;
            Context context = view.getContext();
            String a2 = StringFormatUtil.a(FBLinks.o, new Object[]{s, j});
            Bundle bundle = new Bundle();
            bundle.putString("campaignGroup", j);
            bundle.putString("account", s);
            adInterfacesContext.m22429a(new IntentEvent(adInterfacesReactUtil.f22888c.a(context, a2).putExtra("init_props", bundle)));
            Logger.a(2, EntryType.UI_INPUT_END, 1168404557, a);
        }
    }

    public final void mo982a(View view, @Nullable final AdInterfacesCardLayout adInterfacesCardLayout) {
        AdInterfacesPromotionDetailsView adInterfacesPromotionDetailsView = (AdInterfacesPromotionDetailsView) view;
        super.mo982a(adInterfacesPromotionDetailsView, adInterfacesCardLayout);
        this.f23097j = adInterfacesPromotionDetailsView;
        if (adInterfacesCardLayout != null) {
            if (this.f23093f == 0 && this.f23094g == 0) {
                adInterfacesPromotionDetailsView.setColumnsActive(false);
                Resources resources = adInterfacesCardLayout.getResources();
                adInterfacesCardLayout.setCallToActionText(null);
                adInterfacesCardLayout.setFooterText(resources.getString(2131233876));
                return;
            }
            adInterfacesPromotionDetailsView.m24843a(String.valueOf(this.f23094g), this.f23092e.getString(2131233966));
            adInterfacesPromotionDetailsView.m24845b(String.valueOf(this.f23093f), this.f23095h);
            AdInterfacesUiUtil.m25234a((View) adInterfacesCardLayout);
            Handler handler = this.f23097j.getHandler();
            if (!(this.f23093f == 0 || this.f23094g == 0)) {
                final InterstitialManager interstitialManager = (InterstitialManager) this.f23090c.get();
                final AdInterfacesResultsTooltipNuxController adInterfacesResultsTooltipNuxController = (AdInterfacesResultsTooltipNuxController) interstitialManager.a(new InterstitialTrigger(Action.AD_INTERFACES_VIEW_RESULTS), AdInterfacesResultsTooltipNuxController.class);
                if (adInterfacesResultsTooltipNuxController != null) {
                    this.f23096i = new Runnable(this) {
                        final /* synthetic */ BoostedComponentResultsViewController f23087d;

                        public void run() {
                            View view = adInterfacesCardLayout;
                            Context context = view.getContext();
                            Tooltip tooltip = new Tooltip(context, 2);
                            tooltip.b(context.getString(2131241628));
                            tooltip.a(Position.BELOW);
                            tooltip.t = -1;
                            tooltip.b(0.3f);
                            tooltip.f(view);
                            interstitialManager.a().a(adInterfacesResultsTooltipNuxController.b());
                        }
                    };
                    if (handler != null) {
                        HandlerDetour.b(handler, this.f23096i, 1000, 1540738035);
                    }
                }
            }
            adInterfacesCardLayout.setCallToActionClickListener(new C27111(this));
        }
    }

    @Inject
    public BoostedComponentResultsViewController(AdInterfacesReactUtil adInterfacesReactUtil, BoostedComponentLogger boostedComponentLogger, Provider<InterstitialManager> provider, AdInterfacesDataHelper adInterfacesDataHelper, Resources resources) {
        this.f23088a = adInterfacesReactUtil;
        this.f23089b = boostedComponentLogger;
        this.f23090c = provider;
        this.f23091d = adInterfacesDataHelper;
        this.f23092e = resources;
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        ImmutableList k;
        int i;
        this.f23098k = baseAdInterfacesData;
        this.f23093f = 0;
        this.f23094g = 0;
        CampaignGroupResultsModel p = this.f23098k.mo955p();
        Object obj = (p == null || p.m23403k() == null) ? null : 1;
        if (obj != null) {
            k = p.m23403k();
        } else {
            k = RegularImmutableList.a;
        }
        ImmutableList immutableList = k;
        int size = immutableList.size();
        for (i = 0; i < size; i++) {
            LifetimeOverallStatsModel lifetimeOverallStatsModel = (LifetimeOverallStatsModel) immutableList.get(i);
            this.f23093f += lifetimeOverallStatsModel.m23397j();
            this.f23094g = lifetimeOverallStatsModel.m23393a() + this.f23094g;
        }
        BaseAdInterfacesData baseAdInterfacesData2 = this.f23098k;
        i = this.f23093f;
        CampaignGroupResultsModel p2 = baseAdInterfacesData2.mo955p();
        String m = p2 == null ? null : i == 1 ? p2.m23405m() : p2.m23404l();
        this.f23095h = m;
    }

    public final void mo981a() {
        super.mo981a();
        Handler handler = this.f23097j.getHandler();
        if (handler != null) {
            HandlerDetour.a(handler, this.f23096i);
        }
        this.f23097j = null;
    }
}
