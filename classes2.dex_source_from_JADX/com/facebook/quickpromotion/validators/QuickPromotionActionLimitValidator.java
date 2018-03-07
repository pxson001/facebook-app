package com.facebook.quickpromotion.validators;

import com.facebook.inject.InjectorLike;
import com.facebook.quickpromotion.filter.QuickPromotionCounters;
import com.facebook.quickpromotion.filter.QuickPromotionCounters.CounterType;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.validators.QuickPromotionValidatorResult.Builder;
import javax.inject.Inject;

/* compiled from: reactions_dock_away */
public class QuickPromotionActionLimitValidator implements QuickPromotionValidator {
    private final QuickPromotionCounters f8011a;

    public static QuickPromotionActionLimitValidator m12573b(InjectorLike injectorLike) {
        return new QuickPromotionActionLimitValidator(QuickPromotionCounters.m12575a(injectorLike));
    }

    @Inject
    public QuickPromotionActionLimitValidator(QuickPromotionCounters quickPromotionCounters) {
        this.f8011a = quickPromotionCounters;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @javax.annotation.Nonnull
    public final com.facebook.quickpromotion.validators.QuickPromotionValidatorResult mo1688a(com.facebook.quickpromotion.model.QuickPromotionDefinition r3, com.facebook.interstitial.manager.InterstitialTrigger r4) {
        /*
        r2 = this;
        r0 = com.facebook.quickpromotion.validators.QuickPromotionValidatorResult.a;
        r1 = r3.maxImpressions;
        if (r1 <= 0) goto L_0x0011;
    L_0x0006:
        r0 = com.facebook.quickpromotion.filter.QuickPromotionCounters.CounterType.IMPRESSION;
        r0 = r2.m12572a(r3, r0);
        r1 = r0.c;
        if (r1 != 0) goto L_0x0011;
    L_0x0010:
        return r0;
    L_0x0011:
        r1 = r3.primaryAction;
        if (r1 == 0) goto L_0x001f;
    L_0x0015:
        r0 = com.facebook.quickpromotion.filter.QuickPromotionCounters.CounterType.PRIMARY_ACTION;
        r0 = r2.m12572a(r3, r0);
        r1 = r0.c;
        if (r1 == 0) goto L_0x0010;
    L_0x001f:
        r1 = r3.secondaryAction;
        if (r1 == 0) goto L_0x002d;
    L_0x0023:
        r0 = com.facebook.quickpromotion.filter.QuickPromotionCounters.CounterType.SECONDARY_ACTION;
        r0 = r2.m12572a(r3, r0);
        r1 = r0.c;
        if (r1 == 0) goto L_0x0010;
    L_0x002d:
        r1 = r3.dismissAction;
        if (r1 == 0) goto L_0x0010;
    L_0x0031:
        r0 = com.facebook.quickpromotion.filter.QuickPromotionCounters.CounterType.DISMISS_ACTION;
        r0 = r2.m12572a(r3, r0);
        r1 = r0.c;
        if (r1 != 0) goto L_0x0010;
    L_0x003b:
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.quickpromotion.validators.QuickPromotionActionLimitValidator.a(com.facebook.quickpromotion.model.QuickPromotionDefinition, com.facebook.interstitial.manager.InterstitialTrigger):com.facebook.quickpromotion.validators.QuickPromotionValidatorResult");
    }

    private QuickPromotionValidatorResult m12572a(QuickPromotionDefinition quickPromotionDefinition, CounterType counterType) {
        Object obj;
        boolean z;
        QuickPromotionCounters quickPromotionCounters = this.f8011a;
        int i = -1;
        if (counterType == CounterType.IMPRESSION) {
            i = quickPromotionDefinition.maxImpressions;
        } else if (counterType == CounterType.PRIMARY_ACTION && quickPromotionDefinition.primaryAction != null) {
            i = quickPromotionDefinition.primaryAction.limit;
        } else if (counterType == CounterType.SECONDARY_ACTION && quickPromotionDefinition.secondaryAction != null) {
            i = quickPromotionDefinition.secondaryAction.limit;
        } else if (counterType == CounterType.DISMISS_ACTION && quickPromotionDefinition.dismissAction != null) {
            i = quickPromotionDefinition.dismissAction.limit;
        }
        if (i <= 0 || quickPromotionCounters.m12580c(quickPromotionDefinition, counterType) < i) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return QuickPromotionValidatorResult.a;
        }
        Builder builder = new Builder(false);
        builder.c = counterType;
        builder = builder;
        builder.e = "Limit reached for counter: " + counterType.getReadableName();
        return builder.a();
    }
}
