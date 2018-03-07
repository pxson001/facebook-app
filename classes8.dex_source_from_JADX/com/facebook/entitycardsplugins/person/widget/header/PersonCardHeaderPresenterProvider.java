package com.facebook.entitycardsplugins.person.widget.header;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.entitycards.analytics.EntityCardsAnalyticsLogger;
import com.facebook.entitycards.model.event.EntityCardsDatasourceEventBus;
import com.facebook.entitycardsplugins.person.TimelineLauncher;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLModels.PersonCardModel;
import com.facebook.entitycardsplugins.person.view.PersonCardViewHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import java.util.concurrent.Executor;

/* compiled from: heisman_category_id */
public class PersonCardHeaderPresenterProvider extends AbstractAssistedProvider<PersonCardHeaderPresenter> {
    public final PersonCardHeaderPresenter m13343a(PersonCardModel personCardModel, EntityCardsDatasourceEventBus entityCardsDatasourceEventBus, EntityCardsAnalyticsLogger entityCardsAnalyticsLogger) {
        return new PersonCardHeaderPresenter(personCardModel, entityCardsDatasourceEventBus, entityCardsAnalyticsLogger, PersonCardViewHelper.m13239a(this), TimelineLauncher.m13085a((InjectorLike) this), DefaultUserInteractionController.a(this), IdBasedSingletonScopeProvider.a(this, 8617), (Executor) ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider.a(this));
    }
}
