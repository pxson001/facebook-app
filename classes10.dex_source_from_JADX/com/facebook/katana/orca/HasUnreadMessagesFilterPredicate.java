package com.facebook.katana.orca;

import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.model.folders.FolderCounts;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.quickpromotion.filter.AbstractContextualFilterPredicate;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: unified_tid */
public class HasUnreadMessagesFilterPredicate extends AbstractContextualFilterPredicate {
    private final Provider<DataCache> f1016a;

    @Inject
    public HasUnreadMessagesFilterPredicate(Provider<DataCache> provider) {
        this.f1016a = provider;
    }

    public final boolean m1066a(@Nonnull QuickPromotionDefinition quickPromotionDefinition, @Nonnull ContextualFilter contextualFilter) {
        boolean parseBoolean = Boolean.parseBoolean(contextualFilter.value);
        FolderCounts a = ((DataCache) this.f1016a.get()).a(FolderName.INBOX);
        if (a == null) {
            return false;
        }
        return (a.b > 0) == parseBoolean;
    }
}
