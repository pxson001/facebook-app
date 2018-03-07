package com.facebook.contacts.promotion.qpfilter;

import com.facebook.common.util.TriState;
import com.facebook.growth.prefs.FriendFinderPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.quickpromotion.filter.AbstractContextualFilterPredicate;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: inline_action_message */
public class CIUserConsentFilterPredicate extends AbstractContextualFilterPredicate {
    private final String f10821a;
    private final FbSharedPreferences f10822b;
    private final Provider<TriState> f10823c;

    @Inject
    public CIUserConsentFilterPredicate(String str, FbSharedPreferences fbSharedPreferences, Provider<TriState> provider) {
        this.f10821a = str;
        this.f10822b = fbSharedPreferences;
        this.f10823c = provider;
    }

    public final boolean mo217a(@Nonnull QuickPromotionDefinition quickPromotionDefinition, @Nonnull ContextualFilter contextualFilter) {
        if (((TriState) this.f10823c.get()).asBoolean(false)) {
            return this.f10822b.a(FriendFinderPrefKeys.a(this.f10821a, this.f10822b), false) == Boolean.parseBoolean(contextualFilter.value);
        } else {
            return false;
        }
    }
}
