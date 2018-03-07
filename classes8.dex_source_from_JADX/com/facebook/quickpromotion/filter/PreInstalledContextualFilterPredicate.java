package com.facebook.quickpromotion.filter;

import android.content.pm.ApplicationInfo;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: reaction_profile_image_size_medium */
public class PreInstalledContextualFilterPredicate extends AbstractContextualFilterPredicate {
    public final ApplicationInfo f4718a;

    @Inject
    public PreInstalledContextualFilterPredicate(ApplicationInfo applicationInfo) {
        this.f4718a = applicationInfo;
    }

    public final boolean mo217a(@Nonnull QuickPromotionDefinition quickPromotionDefinition, @Nonnull ContextualFilter contextualFilter) {
        Preconditions.checkNotNull(contextualFilter.value);
        return ((this.f4718a.flags & 1) != 0) == Boolean.parseBoolean(contextualFilter.value);
    }
}
