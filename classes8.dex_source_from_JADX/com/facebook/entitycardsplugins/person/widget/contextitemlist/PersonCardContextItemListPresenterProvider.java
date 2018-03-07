package com.facebook.entitycardsplugins.person.widget.contextitemlist;

import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.entitycards.analytics.EntityCardsAnalyticsLogger;
import com.facebook.entitycards.model.AbstractEntityCardsDataSource.C11881;
import com.facebook.entitycards.model.event.EntityCardsDatasourceEventBus;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLModels.PersonCardModel;
import com.facebook.entitycardsplugins.person.view.PersonCardViewHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.animations.ViewHelperViewAnimatorFactory;

/* compiled from: heisman_fetch_title_failed */
public class PersonCardContextItemListPresenterProvider extends AbstractAssistedProvider<PersonCardContextItemListPresenter> {
    public final PersonCardContextItemListPresenter m13311a(PersonCardModel personCardModel, EntityCardsDatasourceEventBus entityCardsDatasourceEventBus, C11881 c11881, EntityCardsAnalyticsLogger entityCardsAnalyticsLogger) {
        return new PersonCardContextItemListPresenter(personCardModel, entityCardsDatasourceEventBus, c11881, PersonCardViewHelper.m13239a(this), IdBasedSingletonScopeProvider.b(this, 11387), entityCardsAnalyticsLogger, DefaultUserInteractionController.a(this), PersonCardContextItemsHelper.m13317a((InjectorLike) this), PersonCardViewHelper.m13239a(this), ViewHelperViewAnimatorFactory.a(this), DefaultTimeFormatUtil.a(this));
    }
}
