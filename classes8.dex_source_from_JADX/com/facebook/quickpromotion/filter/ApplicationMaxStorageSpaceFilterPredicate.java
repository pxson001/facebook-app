package com.facebook.quickpromotion.filter;

import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.statfs.StatFsHelper.StorageType;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: recent_posters */
public class ApplicationMaxStorageSpaceFilterPredicate extends AbstractContextualFilterPredicate {
    private StatFsHelper f4690a;

    @Inject
    public ApplicationMaxStorageSpaceFilterPredicate(StatFsHelper statFsHelper) {
        this.f4690a = statFsHelper;
    }

    public final boolean mo217a(QuickPromotionDefinition quickPromotionDefinition, ContextualFilter contextualFilter) {
        Preconditions.checkNotNull(contextualFilter.value);
        return this.f4690a.a(StorageType.INTERNAL, Long.parseLong(contextualFilter.value) * 1024);
    }
}
