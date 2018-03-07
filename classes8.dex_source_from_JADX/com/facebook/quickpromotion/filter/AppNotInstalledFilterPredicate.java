package com.facebook.quickpromotion.filter;

import android.content.pm.PackageManager;
import com.facebook.common.util.DeviceUtil;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: recommendationsByViewerFriends */
public class AppNotInstalledFilterPredicate extends AbstractContextualFilterPredicate {
    private PackageManager f4688a;

    @Inject
    public AppNotInstalledFilterPredicate(PackageManager packageManager) {
        this.f4688a = packageManager;
    }

    public final boolean mo217a(@Nonnull QuickPromotionDefinition quickPromotionDefinition, @Nonnull ContextualFilter contextualFilter) {
        return !DeviceUtil.a(this.f4688a, contextualFilter.value);
    }
}
