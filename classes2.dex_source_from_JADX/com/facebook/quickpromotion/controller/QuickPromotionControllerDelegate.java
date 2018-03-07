package com.facebook.quickpromotion.controller;

import android.content.Intent;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.time.Clock;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.qe.api.QeAccessor;
import com.facebook.quickpromotion.annotations.ActionLimitValidator;
import com.facebook.quickpromotion.annotations.ClientsideDynamicParametersValidator;
import com.facebook.quickpromotion.annotations.ContextualFilterValidator;
import com.facebook.quickpromotion.annotations.DefinitionValidator;
import com.facebook.quickpromotion.asset.QuickPromotionAssetManager;
import com.facebook.quickpromotion.customrender.CustomRenderManager;
import com.facebook.quickpromotion.filter.QuickPromotionCounters;
import com.facebook.quickpromotion.logger.QuickPromotionLogger;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Attribute;
import com.facebook.quickpromotion.prefs.QuickPromotionPrefKeys;
import com.facebook.quickpromotion.ui.QuickPromotionFragmentFactory;
import com.facebook.quickpromotion.validators.QuickPromotionValidator;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: reactions_nux_source */
public final class QuickPromotionControllerDelegate {
    private static final long f7986a = (BuildConstants.j ? 0 : 900000);
    public final QuickPromotionController f7987b;
    @DefinitionValidator
    public final QuickPromotionValidator f7988c;
    @ContextualFilterValidator
    private final Lazy<QuickPromotionValidator> f7989d;
    @ActionLimitValidator
    private final QuickPromotionValidator f7990e;
    @ClientsideDynamicParametersValidator
    private final Lazy<QuickPromotionValidator> f7991f;
    public final Lazy<QuickPromotionAssetManager> f7992g;
    public final FbSharedPreferences f7993h;
    public final Lazy<QuickPromotionLogger> f7994i;
    public final Lazy<QuickPromotionFragmentFactory> f7995j;
    private final Clock f7996k;
    private final QuickPromotionCounters f7997l;
    public final DefaultAppChoreographer f7998m;
    public final Lazy<CustomRenderManager> f7999n;
    public final QeAccessor f8000o;
    @Nonnull
    public ImmutableList<QuickPromotionDefinition> f8001p = ImmutableList.of();
    @Nonnull
    public ImmutableList<QuickPromotionDefinition> f8002q = ImmutableList.of();
    public ImmutableList<InterstitialTrigger> f8003r = ImmutableList.of();
    public long f8004s;
    public QuickPromotionDefinition f8005t;
    private InterstitialTrigger f8006u;

    @Inject
    QuickPromotionControllerDelegate(@Assisted QuickPromotionController quickPromotionController, QuickPromotionValidator quickPromotionValidator, Lazy<QuickPromotionValidator> lazy, QuickPromotionValidator quickPromotionValidator2, Lazy<QuickPromotionValidator> lazy2, Lazy<QuickPromotionAssetManager> lazy3, FbSharedPreferences fbSharedPreferences, Lazy<QuickPromotionLogger> lazy4, Clock clock, Lazy<QuickPromotionFragmentFactory> lazy5, QuickPromotionCounters quickPromotionCounters, AppChoreographer appChoreographer, Lazy<CustomRenderManager> lazy6, QeAccessor qeAccessor) {
        this.f7987b = quickPromotionController;
        this.f7988c = quickPromotionValidator;
        this.f7989d = lazy;
        this.f7990e = quickPromotionValidator2;
        this.f7991f = lazy2;
        this.f7992g = lazy3;
        this.f7993h = fbSharedPreferences;
        this.f7994i = lazy4;
        this.f7996k = clock;
        this.f7995j = lazy5;
        this.f7997l = quickPromotionCounters;
        this.f7998m = appChoreographer;
        this.f7999n = lazy6;
        this.f8000o = qeAccessor;
    }

    final InterstitialControllerState m12565a(InterstitialTrigger interstitialTrigger) {
        this.f8005t = m12560c(interstitialTrigger);
        if (this.f8005t == null) {
            return InterstitialControllerState.INELIGIBLE;
        }
        this.f8006u = interstitialTrigger;
        return InterstitialControllerState.ELIGIBLE;
    }

    final Intent m12564a(Intent intent) {
        if (this.f8005t == null) {
            return null;
        }
        if (!m12558a(this.f8005t, this.f8006u)) {
            m12563h();
        }
        intent.putExtra("qp_definition", this.f8005t);
        intent.putExtra("qp_controller_id", this.f7987b.mo1173b());
        if (this.f8006u.f7862a != null) {
            intent.putExtra("qp_trigger_context", this.f8006u.f7862a);
        }
        if (!m12557a(this.f8005t)) {
            return intent;
        }
        intent.addFlags(268435456);
        intent.addFlags(32768);
        return intent;
    }

    final void m12566b(InterstitialTrigger interstitialTrigger) {
        ((QuickPromotionLogger) this.f7994i.get()).f8024h.m12613a("qp_trigger_hit:" + this.f7987b.mo1173b() + ":" + interstitialTrigger.action, 1, "qp_counters");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @com.google.common.annotations.VisibleForTesting
    private com.facebook.quickpromotion.model.QuickPromotionDefinition m12560c(com.facebook.interstitial.manager.InterstitialTrigger r9) {
        /*
        r8 = this;
        r3 = 0;
        r0 = r8.f8001p;
        r5 = r0.size();
        r0 = 0;
        r4 = r0;
    L_0x0009:
        if (r4 >= r5) goto L_0x00e1;
    L_0x000b:
        r0 = r8.f8001p;
        r0 = r0.get(r4);
        r0 = (com.facebook.quickpromotion.model.QuickPromotionDefinition) r0;
        r1 = r0.a();
        r1 = r1.contains(r9);
        if (r1 == 0) goto L_0x00df;
    L_0x001d:
        r1 = r8.f7994i;
        r1 = r1.get();
        r1 = (com.facebook.quickpromotion.logger.QuickPromotionLogger) r1;
        r2 = "client_force_mode";
        r1.m12606a(r0, r2);
        r2 = r8.f7993h;
        r6 = r0.promotionId;
        r6 = com.facebook.quickpromotion.prefs.QuickPromotionPrefKeys.c(r6);
        r7 = com.facebook.quickpromotion.prefs.QuickPromotionPrefKeys.PromotionForceMode.DEFAULT;
        r7 = r7.ordinal();
        r2 = r2.mo276a(r6, r7);
        r6 = com.facebook.quickpromotion.prefs.QuickPromotionPrefKeys.PromotionForceMode.values();
        r2 = r6[r2];
        r6 = com.facebook.quickpromotion.prefs.QuickPromotionPrefKeys.PromotionForceMode.FORCE_ON;
        r6 = r2.equals(r6);
        if (r6 == 0) goto L_0x004b;
    L_0x004a:
        return r0;
    L_0x004b:
        r6 = com.facebook.quickpromotion.prefs.QuickPromotionPrefKeys.PromotionForceMode.FORCE_OFF;
        r2 = r2.equals(r6);
        if (r2 != 0) goto L_0x00df;
    L_0x0053:
        r2 = "client_enabled_time";
        r1.m12606a(r0, r2);
        r2 = r8.m12559b(r0);
        if (r2 == 0) goto L_0x00df;
    L_0x005e:
        r2 = "client_surface_delay";
        r1.m12606a(r0, r2);
        r2 = r8.m12558a(r0, r9);
        if (r2 != 0) goto L_0x0077;
    L_0x0069:
        r2 = r0.promotionId;
        r2 = r8.m12561f();
        if (r2 == 0) goto L_0x00df;
    L_0x0071:
        r2 = r8.m12562g();
        if (r2 == 0) goto L_0x00df;
    L_0x0077:
        r2 = "client_action_limit";
        r1.m12606a(r0, r2);
        r2 = r8.f7990e;
        r2 = r2.mo1688a(r0, r9);
        r2 = r2.c;
        if (r2 == 0) goto L_0x00df;
    L_0x0086:
        r2 = "client_filters";
        r1.m12606a(r0, r2);
        r2 = r8.f7989d;
        r2 = r2.get();
        r2 = (com.facebook.quickpromotion.validators.QuickPromotionValidator) r2;
        r2 = r2.mo1688a(r0, r9);
        r2 = r2.c;
        if (r2 == 0) goto L_0x00df;
    L_0x009b:
        r2 = "client_parameters";
        r1.m12606a(r0, r2);
        r2 = r8.f7991f;
        r2 = r2.get();
        r2 = (com.facebook.quickpromotion.validators.QuickPromotionValidator) r2;
        r2 = r2.mo1688a(r0, r9);
        r2 = r2.c;
        if (r2 == 0) goto L_0x00df;
    L_0x00b0:
        r2 = "client_exposure_log";
        r1.m12606a(r0, r2);
        r1 = r0.isExposureHoldout;
        if (r1 == 0) goto L_0x00d2;
    L_0x00b9:
        r1 = r8.f7997l;
        r2 = com.facebook.quickpromotion.filter.QuickPromotionCounters.CounterType.IMPRESSION;
        r1.m12582e(r0, r2);
        r1 = r8.f7994i;
        r1 = r1.get();
        r1 = (com.facebook.quickpromotion.logger.QuickPromotionLogger) r1;
        r1.m12604a(r0);
        r0 = r3;
    L_0x00cc:
        r1 = r4 + 1;
        r4 = r1;
        r3 = r0;
        goto L_0x0009;
    L_0x00d2:
        r1 = r8.f7994i;
        r1 = r1.get();
        r1 = (com.facebook.quickpromotion.logger.QuickPromotionLogger) r1;
        r1.m12607b(r0);
        if (r3 == 0) goto L_0x00cc;
    L_0x00df:
        r0 = r3;
        goto L_0x00cc;
    L_0x00e1:
        r0 = r3;
        goto L_0x004a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.quickpromotion.controller.QuickPromotionControllerDelegate.c(com.facebook.interstitial.manager.InterstitialTrigger):com.facebook.quickpromotion.model.QuickPromotionDefinition");
    }

    private boolean m12561f() {
        return this.f7996k.mo211a() >= this.f7993h.mo277a(QuickPromotionPrefKeys.a(this.f7987b.mo1173b()), 0) + f7986a;
    }

    private boolean m12562g() {
        long f = this.f7987b.mo1684f();
        if (f == 0) {
            return true;
        }
        if (this.f7996k.mo211a() < f + this.f7993h.mo277a(QuickPromotionPrefKeys.b(this.f7987b.mo1173b()), 0)) {
            return false;
        }
        return true;
    }

    private void m12563h() {
        this.f7993h.edit().mo1275a(QuickPromotionPrefKeys.b(this.f7987b.mo1173b()), this.f7996k.mo211a()).commit();
    }

    private boolean m12558a(QuickPromotionDefinition quickPromotionDefinition, InterstitialTrigger interstitialTrigger) {
        if (this.f7993h.mo286a(QuickPromotionPrefKeys.b, false)) {
            return true;
        }
        if (interstitialTrigger == null || interstitialTrigger.action != Action.VOIP_CALL_START) {
            return m12557a(quickPromotionDefinition);
        }
        return true;
    }

    private boolean m12559b(QuickPromotionDefinition quickPromotionDefinition) {
        long a = this.f7996k.mo211a();
        long j = quickPromotionDefinition.startTime * 1000;
        long j2 = quickPromotionDefinition.endTime * 1000;
        long j3 = quickPromotionDefinition.clientTtlSeconds * 1000;
        return (j == 0 || a > j) && ((j2 == 0 || a < j2) && (j3 == 0 || this.f8004s == 0 || a < this.f8004s + j3));
    }

    public static boolean m12557a(QuickPromotionDefinition quickPromotionDefinition) {
        return quickPromotionDefinition.f().contains(Attribute.IS_UNCANCELABLE);
    }
}
