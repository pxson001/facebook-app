package com.facebook.entitycardsplugins.person.presenter;

import com.facebook.entitycards.analytics.EntityCardsAnalyticsLogger;
import com.facebook.entitycards.intent.EntityCardsFragment.C11761;
import com.facebook.entitycards.model.AbstractEntityCardsDataSource.C11881;
import com.facebook.entitycards.model.event.EntityCardsDatasourceEventBus;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLModels.PersonCardModel;
import com.facebook.entitycardsplugins.person.widget.actionbar.PersonCardActionBarPresenterProvider;
import com.facebook.entitycardsplugins.person.widget.contextitemlist.PersonCardContextItemListPresenterProvider;
import com.facebook.entitycardsplugins.person.widget.footer.PersonCardFooterPresenterProvider;
import com.facebook.entitycardsplugins.person.widget.header.PersonCardHeaderPresenterProvider;
import com.facebook.friends.constants.FriendRequestMakeRef;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: home_%s_address_tapped */
public class PersonCardPresenterProvider extends AbstractAssistedProvider<PersonCardPresenter> {
    public final PersonCardPresenter m13096a(PersonCardModel personCardModel, EntityCardsAnalyticsLogger entityCardsAnalyticsLogger, EntityCardsDatasourceEventBus entityCardsDatasourceEventBus, C11761 c11761, C11881 c11881, FriendingLocation friendingLocation, FriendRequestMakeRef friendRequestMakeRef) {
        return new PersonCardPresenter(personCardModel, entityCardsAnalyticsLogger, entityCardsDatasourceEventBus, c11761, c11881, friendingLocation, friendRequestMakeRef, (PersonCardActionBarPresenterProvider) getOnDemandAssistedProviderForStaticDi(PersonCardActionBarPresenterProvider.class), (PersonCardContextItemListPresenterProvider) getOnDemandAssistedProviderForStaticDi(PersonCardContextItemListPresenterProvider.class), (PersonCardHeaderPresenterProvider) getOnDemandAssistedProviderForStaticDi(PersonCardHeaderPresenterProvider.class), (PersonCardFooterPresenterProvider) getOnDemandAssistedProviderForStaticDi(PersonCardFooterPresenterProvider.class));
    }
}
