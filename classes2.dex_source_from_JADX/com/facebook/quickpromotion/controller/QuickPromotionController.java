package com.facebook.quickpromotion.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.facebook.common.appchoreographer.AppChoreographer$Priority;
import com.facebook.common.appchoreographer.AppChoreographer$ThreadType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialControllerNeedsCouldShowLogging;
import com.facebook.interstitial.manager.InterstitialControllerWithContextClass;
import com.facebook.interstitial.manager.InterstitialControllerWithExtraLogData;
import com.facebook.interstitial.manager.InterstitialIntentController;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.quickpromotion.controller.QuickPromotionControllerDelegate.1;
import com.facebook.quickpromotion.controller.QuickPromotionControllerDelegate.2;
import com.facebook.quickpromotion.customrender.CustomRenderManager;
import com.facebook.quickpromotion.customrender.CustomRenderType;
import com.facebook.quickpromotion.logger.QuickPromotionLogger;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.TemplateType;
import com.facebook.quickpromotion.protocol.QuickPromotionDefinitionsFetchResult;
import com.facebook.quickpromotion.qe.ExperimentsForQuickPromotionModule;
import com.facebook.quickpromotion.ui.QuickPromotionFragmentFactory;
import com.facebook.quickpromotion.validators.QuickPromotionValidator;
import com.facebook.quickpromotion.validators.QuickPromotionValidatorResult;
import com.facebook.quickpromotion.validators.QuickPromotionValidatorResult.Builder;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.RegularImmutableSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nonnull;

/* compiled from: redirect_time */
public abstract class QuickPromotionController implements InterstitialControllerNeedsCouldShowLogging, InterstitialControllerWithContextClass, InterstitialControllerWithExtraLogData, InterstitialIntentController, QuickPromotionValidator {
    public final QuickPromotionControllerDelegate f7857a;

    protected abstract Intent mo1683b(Context context);

    protected abstract long mo1684f();

    public abstract String mo1685g();

    public final Optional<Intent> mo1689a(int i, Intent intent) {
        return Absent.INSTANCE;
    }

    public Set<TemplateType> mo1686j() {
        return RegularImmutableSet.f688a;
    }

    public QuickPromotionController(QuickPromotionControllerDelegateProvider quickPromotionControllerDelegateProvider) {
        this.f7857a = quickPromotionControllerDelegateProvider.m12556a(this);
    }

    public final Class<? extends Parcelable> mo1691d() {
        return QuickPromotionDefinitionsFetchResult.class;
    }

    public final void mo1172a(Parcelable parcelable) {
        QuickPromotionDefinitionsFetchResult quickPromotionDefinitionsFetchResult = (QuickPromotionDefinitionsFetchResult) parcelable;
        QuickPromotionControllerDelegate quickPromotionControllerDelegate = this.f7857a;
        if (quickPromotionDefinitionsFetchResult == null || quickPromotionDefinitionsFetchResult.mQuickPromotionDefinitions == null) {
            quickPromotionControllerDelegate.f8001p = RegularImmutableList.f535a;
            quickPromotionControllerDelegate.f8003r = RegularImmutableList.f535a;
            return;
        }
        Collection<QuickPromotionDefinition> a = Lists.m1296a();
        QuickPromotionLogger quickPromotionLogger = (QuickPromotionLogger) quickPromotionControllerDelegate.f7994i.get();
        Collection collection = null;
        for (QuickPromotionDefinition quickPromotionDefinition : quickPromotionDefinitionsFetchResult.mQuickPromotionDefinitions) {
            boolean z = quickPromotionControllerDelegate.f7988c.mo1688a(quickPromotionDefinition, null).c;
            if (z) {
                quickPromotionLogger.m12606a(quickPromotionDefinition, "client_controller_validator");
                z = quickPromotionControllerDelegate.f7987b.mo1688a(quickPromotionDefinition, null).c;
            }
            if (z) {
                quickPromotionLogger.m12606a(quickPromotionDefinition, "client_promotion_valid");
                a.add(quickPromotionDefinition);
            } else {
                if (collection == null) {
                    collection = Lists.m1296a();
                }
                collection.add(quickPromotionDefinition);
            }
        }
        Collections.sort(a, new 1(quickPromotionControllerDelegate));
        quickPromotionControllerDelegate.f8001p = ImmutableList.copyOf((Collection) a);
        if (collection != null) {
            quickPromotionControllerDelegate.f8002q = ImmutableList.copyOf(collection);
        }
        Collection hashSet = new HashSet();
        for (QuickPromotionDefinition a2 : a) {
            hashSet.addAll(a2.a());
        }
        quickPromotionControllerDelegate.f8003r = ImmutableList.copyOf(hashSet);
        if (!quickPromotionControllerDelegate.f8000o.mo596a(ExperimentsForQuickPromotionModule.a, false)) {
            quickPromotionControllerDelegate.f7998m.m1634a("QP asset fetch", new 2(quickPromotionControllerDelegate), AppChoreographer$Priority.APPLICATION_LOADED_LOW_PRIORITY, AppChoreographer$ThreadType.BACKGROUND);
        }
    }

    public final void mo1171a(long j) {
        this.f7857a.f8004s = j;
    }

    public final InterstitialControllerState mo1170a(InterstitialTrigger interstitialTrigger) {
        return this.f7857a.m12565a(interstitialTrigger);
    }

    public final void mo1690b(InterstitialTrigger interstitialTrigger) {
        this.f7857a.m12566b(interstitialTrigger);
    }

    public final ImmutableList<InterstitialTrigger> mo1174c() {
        return this.f7857a.f8003r;
    }

    public final Intent mo1687a(Context context) {
        return this.f7857a.m12564a(mo1683b(context));
    }

    public final ImmutableMap<String, String> mo1692e() {
        ImmutableMap b;
        QuickPromotionControllerDelegate quickPromotionControllerDelegate = this.f7857a;
        if (quickPromotionControllerDelegate.f8005t != null) {
            b = ImmutableBiMap.m978b("promotion_id", quickPromotionControllerDelegate.f8005t.promotionId);
        } else {
            b = RegularImmutableBiMap.f695a;
        }
        return b;
    }

    public final long hI_() {
        return 0;
    }

    public final Iterable<QuickPromotionDefinition> m12430h() {
        return this.f7857a.f8001p;
    }

    public final Iterable<QuickPromotionDefinition> m12431i() {
        return this.f7857a.f8002q;
    }

    protected boolean mo2884k() {
        return false;
    }

    @Nonnull
    public final QuickPromotionValidatorResult mo1688a(QuickPromotionDefinition quickPromotionDefinition, InterstitialTrigger interstitialTrigger) {
        if (mo2884k()) {
            QuickPromotionValidatorResult quickPromotionValidatorResult;
            TemplateType e = quickPromotionDefinition.e();
            Set j = mo1686j();
            if (((QuickPromotionFragmentFactory) this.f7857a.f7995j.get()).a.containsKey(e) && (j.size() == 0 || j.contains(e))) {
                quickPromotionValidatorResult = QuickPromotionValidatorResult.a;
            } else {
                quickPromotionValidatorResult = m12416b(quickPromotionDefinition);
            }
            return quickPromotionValidatorResult;
        } else if (!mo1686j().contains(quickPromotionDefinition.e())) {
            return m12416b(quickPromotionDefinition);
        } else {
            if (quickPromotionDefinition.e() == TemplateType.CUSTOM_RENDERED) {
                Object obj;
                QuickPromotionControllerDelegate quickPromotionControllerDelegate = this.f7857a;
                CustomRenderType g = quickPromotionDefinition.g();
                CustomRenderManager customRenderManager = (CustomRenderManager) quickPromotionControllerDelegate.f7999n.get();
                if (g == CustomRenderType.UNKNOWN || customRenderManager.a.get(g) == null) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null) {
                    Builder builder = new Builder(false);
                    builder.e = StringFormatUtil.a("Invalid custom render type for promotion %s: %s", new Object[]{quickPromotionDefinition.promotionId, quickPromotionDefinition.g()});
                    return builder.a();
                }
            }
            return QuickPromotionValidatorResult.a;
        }
    }

    public static QuickPromotionValidatorResult m12416b(QuickPromotionDefinition quickPromotionDefinition) {
        Builder builder = new Builder(false);
        builder.e = StringFormatUtil.a("Invalid template for promotion %s: %s", new Object[]{quickPromotionDefinition.promotionId, quickPromotionDefinition.e()});
        return builder.a();
    }
}
