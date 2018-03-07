package com.facebook.payments.paymentmethods.cardform;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: tag_places_view */
public class SimpleCardFormStyleAssociation extends CardFormStyleAssociation<SimpleCardFormStyleRenderer, SimpleCardFormAnalyticsEventSelector, SimpleCardFormConfigurator, SimpleCardFormViewController, SimpleCardFormMutator> {
    public static SimpleCardFormStyleAssociation m2087b(InjectorLike injectorLike) {
        return new SimpleCardFormStyleAssociation(IdBasedLazy.a(injectorLike, 9155), IdBasedLazy.a(injectorLike, 9150), IdBasedLazy.a(injectorLike, 9151), IdBasedLazy.a(injectorLike, 9156), IdBasedLazy.a(injectorLike, 9153));
    }

    @Inject
    public SimpleCardFormStyleAssociation(Lazy<SimpleCardFormStyleRenderer> lazy, Lazy<SimpleCardFormAnalyticsEventSelector> lazy2, Lazy<SimpleCardFormConfigurator> lazy3, Lazy<SimpleCardFormViewController> lazy4, Lazy<SimpleCardFormMutator> lazy5) {
        super(CardFormStyle.SIMPLE, lazy, lazy2, lazy3, lazy4, lazy5);
    }
}
