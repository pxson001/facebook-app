package com.facebook.entitycardsplugins.person.widget.actionbar;

import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.entitycards.analytics.EntityCardsAnalyticsLogger;
import com.facebook.entitycards.intent.EntityCardsFragment.C11761;
import com.facebook.entitycards.model.event.EntityCardsDatasourceEventBus;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLModels.PersonCardModel;
import com.facebook.friends.constants.FriendRequestMakeRef;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.timeline.actionbar.seefirst.FollowSwitcherPopupWindowProvider;

/* compiled from: heisman_photo_taken */
public class PersonCardActionBarPresenterProvider extends AbstractAssistedProvider<PersonCardActionBarPresenter> {
    public final PersonCardActionBarPresenter m13267a(PersonCardModel personCardModel, EntityCardsAnalyticsLogger entityCardsAnalyticsLogger, EntityCardsDatasourceEventBus entityCardsDatasourceEventBus, C11761 c11761, FriendingLocation friendingLocation, FriendRequestMakeRef friendRequestMakeRef) {
        PersonCardActionBarPresenter personCardActionBarPresenter = new PersonCardActionBarPresenter(personCardModel, entityCardsAnalyticsLogger, entityCardsDatasourceEventBus, c11761, friendingLocation, friendRequestMakeRef);
        personCardActionBarPresenter.m13264a(IdBasedSingletonScopeProvider.a(this, 11388), IdBasedSingletonScopeProvider.a(this, 3863), IdBasedProvider.a(this, 2073), IdBasedSingletonScopeProvider.a(this, 968), IdBasedProvider.a(this, 782), IdBasedProvider.a(this, 639), IdBasedSingletonScopeProvider.a(this, 11406), IdBasedSingletonScopeProvider.a(this, 494), IdBasedProvider.a(this, 4442), IdBasedSingletonScopeProvider.a(this, 137), IdBasedSingletonScopeProvider.a(this, 616), (PersonCardFriendingControllerProvider) getOnDemandAssistedProviderForStaticDi(PersonCardFriendingControllerProvider.class), (FollowSwitcherPopupWindowProvider) getOnDemandAssistedProviderForStaticDi(FollowSwitcherPopupWindowProvider.class), DefaultUserInteractionController.a(this), FriendingEventBus.a(this));
        return personCardActionBarPresenter;
    }
}
