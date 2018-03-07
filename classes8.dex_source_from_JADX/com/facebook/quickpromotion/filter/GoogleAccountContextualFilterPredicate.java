package com.facebook.quickpromotion.filter;

import android.accounts.AccountManager;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: reaction_supported_component_styles */
public class GoogleAccountContextualFilterPredicate extends AbstractContextualFilterPredicate {
    public AccountManager f4698a;

    @Inject
    public GoogleAccountContextualFilterPredicate(AccountManager accountManager) {
        this.f4698a = accountManager;
    }

    public final boolean mo217a(@Nonnull QuickPromotionDefinition quickPromotionDefinition, @Nonnull ContextualFilter contextualFilter) {
        Preconditions.checkNotNull(contextualFilter.value);
        return (this.f4698a.getAccountsByType("com.google").length > 0) == Boolean.parseBoolean(contextualFilter.value);
    }
}
