package com.facebook.quickpromotion.filter;

import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: reaction_request_code */
public class MessengerInstalledContextualFilterPredicate extends AbstractContextualFilterPredicate {
    private final PackageManager f4708a;

    @Inject
    public MessengerInstalledContextualFilterPredicate(PackageManager packageManager) {
        this.f4708a = packageManager;
    }

    public final boolean mo217a(@Nonnull QuickPromotionDefinition quickPromotionDefinition, @Nonnull ContextualFilter contextualFilter) {
        boolean z;
        Preconditions.checkNotNull(contextualFilter.value);
        try {
            this.f4708a.getApplicationInfo("com.facebook.orca", 0);
            z = true;
        } catch (NameNotFoundException e) {
            z = false;
        }
        if (z == Boolean.parseBoolean(contextualFilter.value)) {
            return true;
        }
        return false;
    }
}
