package com.facebook.quickpromotion.ui;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.common.time.Clock;
import com.facebook.inject.Assisted;
import com.facebook.interstitial.manager.InterstitialTriggerContext;
import com.facebook.interstitial.manager.InterstitialTriggerContextHelper;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.quickpromotion.action.DefaultQuickPromotionActionHandler;
import com.facebook.quickpromotion.filter.QuickPromotionCounters;
import com.facebook.quickpromotion.filter.QuickPromotionCounters$CounterType;
import com.facebook.quickpromotion.logger.QuickPromotionLogger;
import com.facebook.quickpromotion.logger.QuickPromotionLogger$ActionType;
import com.facebook.quickpromotion.logger.QuickPromotionLogger$LayoutInfo;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Action;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Creative;
import com.facebook.quickpromotion.prefs.QuickPromotionPrefKeys;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: query_source */
public class QuickPromotionViewHelper {
    public final QuickPromotionCounters f4847a;
    private final QuickPromotionLogger f4848b;
    public final FbSharedPreferences f4849c;
    public final Clock f4850d;
    private final DefaultQuickPromotionActionHandler f4851e;
    public final QuickPromotionDefinition f4852f;
    public final String f4853g;
    private final Creative f4854h;
    private final InterstitialTriggerContext f4855i;

    @Inject
    public QuickPromotionViewHelper(@Assisted QuickPromotionDefinition quickPromotionDefinition, @Assisted String str, @Assisted Creative creative, @Assisted InterstitialTriggerContext interstitialTriggerContext, QuickPromotionCounters quickPromotionCounters, QuickPromotionLogger quickPromotionLogger, FbSharedPreferences fbSharedPreferences, Clock clock, DefaultQuickPromotionActionHandler defaultQuickPromotionActionHandler) {
        this.f4852f = quickPromotionDefinition;
        this.f4853g = str;
        this.f4854h = creative;
        this.f4855i = interstitialTriggerContext;
        this.f4847a = quickPromotionCounters;
        this.f4848b = quickPromotionLogger;
        this.f4849c = fbSharedPreferences;
        this.f4850d = clock;
        this.f4851e = defaultQuickPromotionActionHandler;
    }

    public final void m4727a(QuickPromotionLogger$LayoutInfo quickPromotionLogger$LayoutInfo) {
        this.f4848b.a(this.f4852f, quickPromotionLogger$LayoutInfo);
    }

    public final void m4726a() {
        this.f4847a.e(this.f4852f, QuickPromotionCounters$CounterType.IMPRESSION);
    }

    public final void m4728b() {
        m4723a(this.f4854h.primaryAction, QuickPromotionLogger$ActionType.PRIMARY_ACTION, QuickPromotionCounters$CounterType.PRIMARY_ACTION);
    }

    public final void m4729c() {
        m4722a(this.f4854h.primaryAction);
    }

    public final boolean m4730d() {
        return m4724b(this.f4854h.primaryAction);
    }

    public final void m4731e() {
        m4723a(this.f4854h.secondaryAction, QuickPromotionLogger$ActionType.SECONDARY_ACTION, QuickPromotionCounters$CounterType.SECONDARY_ACTION);
    }

    public final void m4732f() {
        m4722a(this.f4854h.secondaryAction);
    }

    public final boolean m4733g() {
        return m4724b(this.f4854h.secondaryAction);
    }

    public final void m4734h() {
        m4723a(this.f4854h.dismissAction, QuickPromotionLogger$ActionType.DISMISS_ACTION, QuickPromotionCounters$CounterType.DISMISS_ACTION);
    }

    public final boolean m4735i() {
        return m4724b(this.f4854h.dismissAction);
    }

    private void m4723a(Action action, QuickPromotionLogger$ActionType quickPromotionLogger$ActionType, QuickPromotionCounters$CounterType quickPromotionCounters$CounterType) {
        if (m4725c(action)) {
            this.f4851e.m4470a(Uri.parse(InterstitialTriggerContextHelper.a(action.url, this.f4855i)));
        }
        this.f4848b.a(action, quickPromotionLogger$ActionType, this.f4852f, this.f4853g);
        this.f4847a.e(this.f4852f, quickPromotionCounters$CounterType);
        if (m4724b(action)) {
            this.f4849c.edit().a(QuickPromotionPrefKeys.m4649a(this.f4853g), this.f4850d.a()).commit();
            this.f4847a.e(this.f4852f, QuickPromotionCounters$CounterType.DISMISSAL);
        }
    }

    private void m4722a(Action action) {
        if (m4725c(action)) {
            this.f4851e.m4470a(Uri.parse(InterstitialTriggerContextHelper.a(action.url, this.f4855i)));
        }
    }

    private static boolean m4724b(@Nullable Action action) {
        return action == null || action.dismissPromotion || TextUtils.isEmpty(action.url);
    }

    private static boolean m4725c(@Nullable Action action) {
        return (action == null || TextUtils.isEmpty(action.url)) ? false : true;
    }
}
