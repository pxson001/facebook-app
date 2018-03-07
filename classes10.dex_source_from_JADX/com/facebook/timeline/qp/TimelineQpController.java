package com.facebook.timeline.qp;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.inject.Assisted;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTriggerContext;
import com.facebook.quickpromotion.ui.QuickPromotionFooterController;
import com.facebook.quickpromotion.ui.QuickPromotionFooterFragment;
import com.facebook.quickpromotion.ui.QuickPromotionFragment;
import com.facebook.quickpromotion.ui.QuickPromotionFragmentFactory;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: f30597c6729d19c01ff130225071a15f */
public class TimelineQpController {
    private TimelineUserContext f12576a;
    private TimelineHeaderUserData f12577b;
    private FragmentManager f12578c;
    public View f12579d;
    private Provider<InterstitialManager> f12580e;
    private Provider<QuickPromotionFragmentFactory> f12581f;
    private QuickPromotionFooterFragment f12582g;

    @Inject
    public TimelineQpController(@Assisted TimelineUserContext timelineUserContext, @Assisted TimelineHeaderUserData timelineHeaderUserData, @Assisted FragmentManager fragmentManager, @Assisted View view, Provider<InterstitialManager> provider, Provider<QuickPromotionFragmentFactory> provider2) {
        this.f12576a = timelineUserContext;
        this.f12577b = timelineHeaderUserData;
        this.f12578c = fragmentManager;
        this.f12579d = view;
        this.f12580e = provider;
        this.f12581f = provider2;
    }

    public final void m12562a() {
        QuickPromotionFragment quickPromotionFragment = null;
        Intent d = m12561d();
        if (d == null || this.f12582g == null || !this.f12582g.b(d) || !this.f12582g.mx_()) {
            if (d != null) {
                quickPromotionFragment = ((QuickPromotionFragmentFactory) this.f12581f.get()).a(d);
            }
            if (quickPromotionFragment instanceof QuickPromotionFooterFragment) {
                this.f12582g = (QuickPromotionFooterFragment) quickPromotionFragment;
                this.f12578c.a().b(2131567929, this.f12582g).b();
                this.f12579d.setVisibility(0);
                return;
            }
            m12563c();
            return;
        }
        this.f12582g.ay();
    }

    public final void m12563c() {
        if (this.f12582g != null) {
            this.f12578c.a().a(this.f12582g).b();
            this.f12582g = null;
        }
        this.f12579d.setVisibility(8);
    }

    private Intent m12561d() {
        if (this.f12576a.i()) {
            return m12560a(QuickPromotionFooterController.g);
        }
        if (this.f12577b.B() == GraphQLFriendshipStatus.ARE_FRIENDS) {
            return m12560a(QuickPromotionFooterController.h);
        }
        return m12560a(QuickPromotionFooterController.i);
    }

    private Intent m12560a(InterstitialTrigger interstitialTrigger) {
        Map hashMap = new HashMap();
        if (this.f12577b.b() != null) {
            hashMap.put("context_profile_has_profile_video", "1");
        }
        QuickPromotionFooterController quickPromotionFooterController = (QuickPromotionFooterController) ((InterstitialManager) this.f12580e.get()).a(new InterstitialTrigger(interstitialTrigger, new InterstitialTriggerContext(hashMap)), QuickPromotionFooterController.class);
        if (quickPromotionFooterController == null) {
            return null;
        }
        return quickPromotionFooterController.a(this.f12579d.getContext());
    }
}
