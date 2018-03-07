package com.facebook.payments.paymentmethods.cardform;

import com.facebook.inject.Lazy;
import com.google.common.base.Preconditions;

/* compiled from: tap_create_button */
public class CardFormStyleAssociation<STYLE_RENDERER extends CardFormStyleRenderer, ANALYTICS_EVENT_SELECTOR extends CardFormAnalyticsEventSelector, CONFIGURATOR extends CardFormConfigurator, VIEW_CONTROLLER extends CardFormViewController, MUTATOR extends CardFormMutator> {
    public final CardFormStyle f1843a;
    public final Lazy<STYLE_RENDERER> f1844b;
    public final Lazy<ANALYTICS_EVENT_SELECTOR> f1845c;
    public final Lazy<CONFIGURATOR> f1846d;
    public final Lazy<VIEW_CONTROLLER> f1847e;
    public final Lazy<MUTATOR> f1848f;

    public CardFormStyleAssociation(CardFormStyle cardFormStyle, Lazy<STYLE_RENDERER> lazy, Lazy<ANALYTICS_EVENT_SELECTOR> lazy2, Lazy<CONFIGURATOR> lazy3, Lazy<VIEW_CONTROLLER> lazy4, Lazy<MUTATOR> lazy5) {
        this.f1843a = (CardFormStyle) Preconditions.checkNotNull(cardFormStyle);
        this.f1844b = lazy;
        this.f1845c = lazy2;
        this.f1846d = lazy3;
        this.f1847e = lazy4;
        this.f1848f = lazy5;
    }
}
