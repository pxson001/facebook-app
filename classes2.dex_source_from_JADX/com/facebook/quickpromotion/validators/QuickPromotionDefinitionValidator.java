package com.facebook.quickpromotion.validators;

import android.text.TextUtils;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.quickpromotion.controller.QuickPromotionControllerDelegate;
import com.facebook.quickpromotion.logger.QuickPromotionLogger;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.TemplateType;
import com.facebook.quickpromotion.validators.QuickPromotionValidatorResult.Builder;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: reactions_like_up */
public class QuickPromotionDefinitionValidator implements QuickPromotionValidator {
    private static final String f8007a = QuickPromotionDefinitionValidator.class.getSimpleName();
    private final AbstractFbErrorReporter f8008b;
    private StringBuilder f8009c;
    private Lazy<QuickPromotionLogger> f8010d;

    public static QuickPromotionDefinitionValidator m12569b(InjectorLike injectorLike) {
        return new QuickPromotionDefinitionValidator(FbErrorReporterImpl.m2317a(injectorLike), IdBasedLazy.m1808a(injectorLike, 3239));
    }

    @Inject
    public QuickPromotionDefinitionValidator(FbErrorReporter fbErrorReporter, Lazy<QuickPromotionLogger> lazy) {
        this.f8008b = fbErrorReporter;
        this.f8010d = lazy;
    }

    public final QuickPromotionValidatorResult mo1688a(QuickPromotionDefinition quickPromotionDefinition, InterstitialTrigger interstitialTrigger) {
        Preconditions.checkNotNull(quickPromotionDefinition);
        if (this.f8009c != null) {
            this.f8009c.delete(0, this.f8009c.length());
        }
        QuickPromotionLogger quickPromotionLogger = (QuickPromotionLogger) this.f8010d.get();
        quickPromotionLogger.m12606a(quickPromotionDefinition, "client_definition_validator_content");
        if (m12568a(quickPromotionDefinition)) {
            quickPromotionLogger.m12606a(quickPromotionDefinition, "client_definition_validator_conditions");
            if (m12570b(quickPromotionDefinition)) {
                return QuickPromotionValidatorResult.a;
            }
        }
        String stringBuilder = this.f8009c.toString();
        this.f8008b.m2340a(f8007a + "_invalid_promotion_" + quickPromotionDefinition.promotionId, stringBuilder);
        Builder builder = new Builder(false);
        builder.e = stringBuilder;
        return builder.a();
    }

    private boolean m12568a(QuickPromotionDefinition quickPromotionDefinition) {
        boolean z = true;
        boolean z2 = false;
        if (quickPromotionDefinition.isExposureHoldout) {
            return true;
        }
        if (!QuickPromotionDefinition.b(quickPromotionDefinition) && TextUtils.isEmpty(quickPromotionDefinition.title)) {
            m12567a("Title is null/empty\n");
            z = false;
        }
        if (!QuickPromotionControllerDelegate.m12557a(quickPromotionDefinition)) {
            Object obj;
            if ((quickPromotionDefinition.primaryAction == null || !quickPromotionDefinition.primaryAction.dismissPromotion) && ((quickPromotionDefinition.secondaryAction == null || !quickPromotionDefinition.secondaryAction.dismissPromotion) && (quickPromotionDefinition.dismissAction == null || !quickPromotionDefinition.dismissAction.dismissPromotion))) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null && !QuickPromotionDefinition.c(quickPromotionDefinition)) {
                m12567a("No button dismisses promotion");
                z = false;
            }
        }
        if (!QuickPromotionDefinition.a(quickPromotionDefinition)) {
            if (quickPromotionDefinition.primaryAction == null) {
                m12567a("Primary Action is null\n");
            } else {
                if (TextUtils.isEmpty(quickPromotionDefinition.primaryAction.title) && quickPromotionDefinition.e() != TemplateType.TOAST_FOOTER) {
                    m12567a("Primary Action title is null/empty\n");
                    z = false;
                }
                if (!TextUtils.isEmpty(quickPromotionDefinition.primaryAction.url) || quickPromotionDefinition.primaryAction.dismissPromotion) {
                    z2 = z;
                } else {
                    m12567a("Primary Action url is null/empty\n");
                }
            }
            return z2;
        } else if (quickPromotionDefinition.primaryAction == null || !TextUtils.isEmpty(quickPromotionDefinition.primaryAction.url) || quickPromotionDefinition.primaryAction.dismissPromotion) {
            return z;
        } else {
            m12567a("Primary Action url is null/empty\n");
            return false;
        }
    }

    private boolean m12570b(QuickPromotionDefinition quickPromotionDefinition) {
        boolean z = true;
        if (quickPromotionDefinition.a().isEmpty()) {
            m12567a("Trigger list is empty\n");
            z = false;
        }
        boolean z2 = z;
        for (ContextualFilter contextualFilter : quickPromotionDefinition.d()) {
            if (TextUtils.isEmpty(contextualFilter.value) && (contextualFilter.b() == null || contextualFilter.b().isEmpty())) {
                m12567a("Filter " + contextualFilter.a().name() + " has null/empty data\n");
                z = false;
            } else {
                z = z2;
            }
            z2 = z;
        }
        return z2;
    }

    private void m12567a(String str) {
        if (this.f8009c == null) {
            this.f8009c = new StringBuilder();
        }
        this.f8009c.append(str);
    }
}
