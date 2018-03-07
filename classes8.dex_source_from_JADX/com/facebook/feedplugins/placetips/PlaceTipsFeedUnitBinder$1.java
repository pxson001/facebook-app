package com.facebook.feedplugins.placetips;

import android.content.Context;
import android.content.Intent;
import com.facebook.crowdsourcing.abtest.ExperimentsForCrowdsourcingAbTestModule;
import com.facebook.crowdsourcing.feather.FeatherManager;
import com.facebook.crowdsourcing.feather.activity.FeatherActivity;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.calls.SuggestifierQuestionVoteInputData.Sentiment;
import com.facebook.placetips.bootstrap.PresenceDescription;
import com.google.common.base.Optional;
import com.google.common.base.Strings;

/* compiled from: friend_suggestions_done */
public class PlaceTipsFeedUnitBinder$1 {
    public final /* synthetic */ PresenceDescription f12915a;
    public final /* synthetic */ PlaceTipsFeedUnitView f12916b;
    public final /* synthetic */ PlaceTipsFeedUnitBinder f12917c;

    /* compiled from: friend_suggestions_done */
    class C13441 implements Runnable {
        final /* synthetic */ PlaceTipsFeedUnitBinder$1 f12913a;

        C13441(PlaceTipsFeedUnitBinder$1 placeTipsFeedUnitBinder$1) {
            this.f12913a = placeTipsFeedUnitBinder$1;
        }

        public void run() {
            this.f12913a.f12916b.setFooterView(null);
        }
    }

    /* compiled from: friend_suggestions_done */
    class C13452 implements Runnable {
        final /* synthetic */ PlaceTipsFeedUnitBinder$1 f12914a;

        C13452(PlaceTipsFeedUnitBinder$1 placeTipsFeedUnitBinder$1) {
            this.f12914a = placeTipsFeedUnitBinder$1;
        }

        public void run() {
            FeatherManager featherManager = this.f12914a.f12917c.m;
            Context context = this.f12914a.f12916b.getContext();
            String i = this.f12914a.f12915a.m3695i();
            CrowdEntryPoint crowdEntryPoint = CrowdEntryPoint.FEATHER_PLACE_TIP_QUESTION;
            featherManager.f.b(FunnelRegistry.S, "prefetch_show_start");
            if (Strings.isNullOrEmpty(i) || !i.equals(featherManager.h)) {
                featherManager.f.b(FunnelRegistry.S, "prefetch_show_failed_wrong_place");
                featherManager.a.a("Feather", "Place ID didn't match prefetched place ID");
            }
            if (!featherManager.a(i)) {
                featherManager.f.b(FunnelRegistry.S, "prefetch_show_failed_no_data");
                featherManager.a.a("Feather", "There were no prefetched questions");
            }
            Intent intent = new Intent(context, FeatherActivity.class);
            intent.putExtra("extra_place", featherManager.h);
            intent.putExtra("extra_place_name", featherManager.i);
            intent.putExtra("extra_entry_point", crowdEntryPoint.getFullName());
            FlatBufferModelHelper.a(intent, "extra_questions", featherManager.j);
            featherManager.f.b(FunnelRegistry.S, "prefetch_show_end");
            featherManager.c.a(intent, context);
        }
    }

    PlaceTipsFeedUnitBinder$1(PlaceTipsFeedUnitBinder placeTipsFeedUnitBinder, PresenceDescription presenceDescription, PlaceTipsFeedUnitView placeTipsFeedUnitView) {
        this.f12917c = placeTipsFeedUnitBinder;
        this.f12915a = presenceDescription;
        this.f12916b = placeTipsFeedUnitView;
    }

    public final void m14659a(boolean z) {
        this.f12915a.m3687a(false);
        Runnable c13441 = new C13441(this);
        if (z) {
            boolean a;
            PlaceTipsFeedUnitBinder placeTipsFeedUnitBinder = this.f12917c;
            String i = this.f12915a.m3695i();
            if ("place_tip".equals(placeTipsFeedUnitBinder.l.a(ExperimentsForCrowdsourcingAbTestModule.a, "none"))) {
                a = placeTipsFeedUnitBinder.m.a(i);
            } else {
                a = false;
            }
            if (a) {
                this.f12916b.setFooterView(new PlaceTipsFooterFeatherUpsellView(this.f12916b.getContext(), new C13452(this), c13441));
                this.f12917c.o.b(FunnelRegistry.S, "place_tip_upsell_shown");
                this.f12917c.n.a(CrowdEntryPoint.FEATHER_PLACE_TIP_QUESTION, Optional.of(this.f12915a.m3695i()));
                PlaceTipsFeedUnitBinder.a(this.f12917c, this.f12915a, z ? Sentiment.AGREE : Sentiment.DISAGREE);
            }
        }
        this.f12916b.setFooterView(new PlaceTipsFooterThankYouView(this.f12916b.getContext(), c13441, this.f12915a.m3693g()));
        if (z) {
        }
        PlaceTipsFeedUnitBinder.a(this.f12917c, this.f12915a, z ? Sentiment.AGREE : Sentiment.DISAGREE);
    }
}
