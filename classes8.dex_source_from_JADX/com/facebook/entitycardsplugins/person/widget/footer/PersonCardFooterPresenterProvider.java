package com.facebook.entitycardsplugins.person.widget.footer;

import com.facebook.entitycards.analytics.EntityCardsAnalyticsLogger;
import com.facebook.entitycards.model.event.EntityCardsDatasourceEventBus;
import com.facebook.entitycardsplugins.person.TimelineLauncher;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLModels.PersonCardModel;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: heisman_existing_photo_selected */
public class PersonCardFooterPresenterProvider extends AbstractAssistedProvider<PersonCardFooterPresenter> {
    public final PersonCardFooterPresenter m13323a(PersonCardModel personCardModel, EntityCardsDatasourceEventBus entityCardsDatasourceEventBus, EntityCardsAnalyticsLogger entityCardsAnalyticsLogger) {
        return new PersonCardFooterPresenter(personCardModel, entityCardsDatasourceEventBus, entityCardsAnalyticsLogger, TimelineLauncher.m13085a((InjectorLike) this));
    }
}
