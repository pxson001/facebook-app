package com.facebook.quickpromotion.validators;

import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTriggerContextHelper;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Creative;
import com.google.common.collect.ImmutableSet;
import java.util.Set;

/* compiled from: query_scope_id */
public class QuickPromotionClientsideDynamicParametersValidator implements QuickPromotionValidator {
    public final QuickPromotionValidatorResult m4740a(QuickPromotionDefinition quickPromotionDefinition, InterstitialTrigger interstitialTrigger) {
        Creative c = quickPromotionDefinition.c();
        if (interstitialTrigger == null || interstitialTrigger.a == null) {
            return QuickPromotionValidatorResult.f4869a;
        }
        ImmutableSet a = interstitialTrigger.a.a();
        if (c != null) {
            QuickPromotionValidatorResult a2 = m4739a(c.title, a);
            if (!a2.f4871c) {
                return a2;
            }
            a2 = m4739a(c.content, a);
            if (!a2.f4871c) {
                return a2;
            }
            if (c.primaryAction != null) {
                a2 = m4739a(c.primaryAction.title, a);
                if (!a2.f4871c) {
                    return a2;
                }
                a2 = m4739a(c.primaryAction.url, a);
                if (!a2.f4871c) {
                    return a2;
                }
            }
            if (c.secondaryAction != null) {
                a2 = m4739a(c.secondaryAction.title, a);
                if (!a2.f4871c) {
                    return a2;
                }
                a2 = m4739a(c.secondaryAction.url, a);
                if (!a2.f4871c) {
                    return a2;
                }
            }
        }
        return QuickPromotionValidatorResult.f4869a;
    }

    private static QuickPromotionValidatorResult m4739a(String str, ImmutableSet<String> immutableSet) {
        Set a = InterstitialTriggerContextHelper.a(str);
        if (a.isEmpty()) {
            return QuickPromotionValidatorResult.f4869a;
        }
        if (immutableSet == null || immutableSet.isEmpty()) {
            return QuickPromotionValidatorResult.f4870b;
        }
        a.removeAll(immutableSet);
        if (a.isEmpty()) {
            return QuickPromotionValidatorResult.f4869a;
        }
        return QuickPromotionValidatorResult.f4870b;
    }
}
