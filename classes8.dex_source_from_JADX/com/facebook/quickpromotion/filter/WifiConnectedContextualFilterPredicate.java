package com.facebook.quickpromotion.filter;

import com.facebook.device.DeviceConditionHelper;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: reaction_friend_inviter_profile_image_size */
public class WifiConnectedContextualFilterPredicate extends AbstractContextualFilterPredicate {
    private final DeviceConditionHelper f4744a;

    @Inject
    public WifiConnectedContextualFilterPredicate(DeviceConditionHelper deviceConditionHelper) {
        this.f4744a = deviceConditionHelper;
    }

    public final boolean mo217a(@Nonnull QuickPromotionDefinition quickPromotionDefinition, @Nonnull ContextualFilter contextualFilter) {
        Preconditions.checkNotNull(contextualFilter.value);
        return this.f4744a.b() == Boolean.parseBoolean(contextualFilter.value);
    }
}
