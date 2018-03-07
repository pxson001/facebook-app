package com.facebook.quickpromotion.filter;

import android.content.pm.PackageManager;
import com.facebook.common.util.DeviceUtil;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: recovery_success */
public class AppInstalledFilterPredicate extends AbstractContextualFilterPredicate {
    private PackageManager f4687a;

    @Inject
    public AppInstalledFilterPredicate(PackageManager packageManager) {
        this.f4687a = packageManager;
    }

    public final boolean mo217a(@Nonnull QuickPromotionDefinition quickPromotionDefinition, @Nonnull ContextualFilter contextualFilter) {
        return DeviceUtil.a(this.f4687a, contextualFilter.value);
    }
}
