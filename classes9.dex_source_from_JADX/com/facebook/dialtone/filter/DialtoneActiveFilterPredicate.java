package com.facebook.dialtone.filter;

import com.facebook.dialtone.DialtoneController;
import com.facebook.quickpromotion.filter.AbstractContextualFilterPredicate;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: The field 'newReceiverStatus' has been assigned the invalid value  */
public class DialtoneActiveFilterPredicate extends AbstractContextualFilterPredicate {
    private DialtoneController f24219a;

    @Inject
    public DialtoneActiveFilterPredicate(DialtoneController dialtoneController) {
        this.f24219a = dialtoneController;
    }

    public final boolean m26173a(QuickPromotionDefinition quickPromotionDefinition, ContextualFilter contextualFilter) {
        Preconditions.checkNotNull(contextualFilter.value);
        return this.f24219a.b() == Boolean.parseBoolean(contextualFilter.value);
    }
}
