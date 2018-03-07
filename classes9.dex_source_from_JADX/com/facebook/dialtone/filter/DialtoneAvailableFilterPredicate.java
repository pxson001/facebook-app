package com.facebook.dialtone.filter;

import com.facebook.common.util.TriState;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneUiFeaturesAccessor;
import com.facebook.dialtone.gk.IsDialtoneEligibleGK;
import com.facebook.quickpromotion.filter.AbstractContextualFilterPredicate;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: The field 'initialStatus' has been assigned the invalid value  */
public class DialtoneAvailableFilterPredicate extends AbstractContextualFilterPredicate {
    private final DialtoneController f24220a;
    private final DialtoneUiFeaturesAccessor f24221b;
    @IsDialtoneEligibleGK
    private final Provider<TriState> f24222c;

    @Inject
    public DialtoneAvailableFilterPredicate(DialtoneController dialtoneController, DialtoneUiFeaturesAccessor dialtoneUiFeaturesAccessor, Provider<TriState> provider) {
        this.f24220a = dialtoneController;
        this.f24221b = dialtoneUiFeaturesAccessor;
        this.f24222c = provider;
    }

    public final boolean m26174a(QuickPromotionDefinition quickPromotionDefinition, ContextualFilter contextualFilter) {
        Preconditions.checkNotNull(contextualFilter.value);
        boolean z = !this.f24220a.b() && this.f24221b.c() && ((TriState) this.f24222c.get()).asBoolean(false);
        if (z == Boolean.parseBoolean(contextualFilter.value)) {
            return true;
        }
        return false;
    }
}
