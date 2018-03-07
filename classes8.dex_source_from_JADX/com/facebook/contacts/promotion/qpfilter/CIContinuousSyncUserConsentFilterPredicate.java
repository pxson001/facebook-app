package com.facebook.contacts.promotion.qpfilter;

import com.facebook.common.util.TriState;
import com.facebook.growth.prefs.GrowthPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.quickpromotion.filter.AbstractContextualFilterPredicate;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: inline_action_name */
public class CIContinuousSyncUserConsentFilterPredicate extends AbstractContextualFilterPredicate {
    private final String f10818a;
    private final FbSharedPreferences f10819b;
    private final Provider<TriState> f10820c;

    @Inject
    public CIContinuousSyncUserConsentFilterPredicate(String str, FbSharedPreferences fbSharedPreferences, Provider<TriState> provider) {
        this.f10818a = str;
        this.f10819b = fbSharedPreferences;
        this.f10820c = provider;
    }

    public final boolean mo217a(@Nonnull QuickPromotionDefinition quickPromotionDefinition, @Nonnull ContextualFilter contextualFilter) {
        if (((TriState) this.f10820c.get()).asBoolean(false)) {
            return this.f10819b.a(GrowthPrefKeys.a(this.f10818a), false) == Boolean.parseBoolean(contextualFilter.value);
        } else {
            return false;
        }
    }
}
