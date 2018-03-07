package com.facebook.quickpromotion.filter;

import com.facebook.common.hardware.SystemBatteryStateManager;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: readableCardType */
public class BatteryLowContextualFilterPredicate extends AbstractContextualFilterPredicate {
    private final SystemBatteryStateManager f4692a;

    @Inject
    public BatteryLowContextualFilterPredicate(SystemBatteryStateManager systemBatteryStateManager) {
        this.f4692a = systemBatteryStateManager;
    }

    public final boolean mo217a(@Nonnull QuickPromotionDefinition quickPromotionDefinition, @Nonnull ContextualFilter contextualFilter) {
        Preconditions.checkNotNull(contextualFilter.value);
        return this.f4692a.a() * 100.0f >= Float.parseFloat(contextualFilter.value);
    }
}
