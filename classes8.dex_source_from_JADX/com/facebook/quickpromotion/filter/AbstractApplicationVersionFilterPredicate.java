package com.facebook.quickpromotion.filter;

import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.VersionStringComparator;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;

/* compiled from: redesign_v1 */
public abstract class AbstractApplicationVersionFilterPredicate extends AbstractContextualFilterPredicate {
    private final AppVersionInfo f4683a;
    private final VersionStringComparator f4684b;

    protected abstract boolean mo218a(int i);

    public AbstractApplicationVersionFilterPredicate(AppVersionInfo appVersionInfo, VersionStringComparator versionStringComparator) {
        this.f4683a = appVersionInfo;
        this.f4684b = versionStringComparator;
    }

    public final boolean mo217a(@Nonnull QuickPromotionDefinition quickPromotionDefinition, @Nonnull ContextualFilter contextualFilter) {
        Preconditions.checkNotNull(contextualFilter.value);
        return mo218a(this.f4684b.a(this.f4683a.a(), contextualFilter.value));
    }
}
