package com.facebook.messaging.quickpromotion;

import com.facebook.quickpromotion.filter.AbstractContextualFilterPredicate;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.facebook.user.model.User;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: registration_contact_switch_type */
public class HasNoProfilePicturePredicate extends AbstractContextualFilterPredicate {
    private final Provider<User> f3733a;

    @Inject
    public HasNoProfilePicturePredicate(Provider<User> provider) {
        this.f3733a = provider;
    }

    public final boolean m3543a(QuickPromotionDefinition quickPromotionDefinition, ContextualFilter contextualFilter) {
        User user = (User) this.f3733a.get();
        return user != null && user.G.asBoolean(false);
    }
}
