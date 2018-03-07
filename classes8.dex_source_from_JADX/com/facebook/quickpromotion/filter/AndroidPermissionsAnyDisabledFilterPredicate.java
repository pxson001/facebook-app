package com.facebook.quickpromotion.filter;

import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.google.common.base.Preconditions;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: rect */
public class AndroidPermissionsAnyDisabledFilterPredicate extends AbstractContextualFilterPredicate {
    private final RuntimePermissionsUtil f4686a;

    @Inject
    public AndroidPermissionsAnyDisabledFilterPredicate(RuntimePermissionsUtil runtimePermissionsUtil) {
        this.f4686a = runtimePermissionsUtil;
    }

    public final boolean mo217a(QuickPromotionDefinition quickPromotionDefinition, ContextualFilter contextualFilter) {
        Map map = (Map) Preconditions.checkNotNull(contextualFilter.b());
        return !this.f4686a.a((String[]) map.keySet().toArray(new String[map.size()]));
    }
}
