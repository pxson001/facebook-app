package com.facebook.quickpromotion.filter;

import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.statfs.StatFsHelper.StorageType;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: recipients */
public class ApplicationInstallSpaceFilterPredicate extends AbstractContextualFilterPredicate {
    private StatFsHelper f4689a;

    @Inject
    public ApplicationInstallSpaceFilterPredicate(StatFsHelper statFsHelper) {
        this.f4689a = statFsHelper;
    }

    public final boolean mo217a(@Nonnull QuickPromotionDefinition quickPromotionDefinition, @Nonnull ContextualFilter contextualFilter) {
        Preconditions.checkNotNull(contextualFilter.value);
        return !this.f4689a.a(StorageType.INTERNAL, Long.parseLong(contextualFilter.value) * 1024);
    }
}
