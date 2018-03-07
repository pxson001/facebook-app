package com.facebook.entitycardsplugins.person.presenter;

import com.facebook.entitycards.analytics.EntityCardsAnalyticsLogger;
import com.facebook.entitycards.intent.EntityCardsFragment.C11761;
import com.facebook.entitycards.model.AbstractEntityCardsDataSource.C11881;
import com.facebook.entitycards.model.event.EntityCardsDatasourceEventBus;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLModels.PersonCardModel;
import com.facebook.entitycardsplugins.person.view.PersonCardView;
import com.facebook.entitycardsplugins.person.widget.actionbar.PersonCardActionBarPresenter;
import com.facebook.entitycardsplugins.person.widget.actionbar.PersonCardActionBarPresenterProvider;
import com.facebook.entitycardsplugins.person.widget.contextitemlist.PersonCardContextItemListPresenter;
import com.facebook.entitycardsplugins.person.widget.contextitemlist.PersonCardContextItemListPresenterProvider;
import com.facebook.entitycardsplugins.person.widget.footer.PersonCardFooterPresenter;
import com.facebook.entitycardsplugins.person.widget.footer.PersonCardFooterPresenterProvider;
import com.facebook.entitycardsplugins.person.widget.header.PersonCardHeaderPresenter;
import com.facebook.entitycardsplugins.person.widget.header.PersonCardHeaderPresenterProvider;
import com.facebook.friends.constants.FriendRequestMakeRef;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.inject.Assisted;
import com.facebook.presenter.ViewPresenter;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: home_%s_address_updated */
public class PersonCardPresenter extends ViewPresenter<PersonCardView> {
    private final PersonCardActionBarPresenter f11162a;
    private final PersonCardContextItemListPresenter f11163b;
    private final PersonCardHeaderPresenter f11164c;
    private final PersonCardFooterPresenter f11165d;

    public final /* synthetic */ void mo790b(Object obj) {
        m13093a((PersonCardView) obj);
    }

    @Inject
    public PersonCardPresenter(@Assisted PersonCardModel personCardModel, @Assisted EntityCardsAnalyticsLogger entityCardsAnalyticsLogger, @Assisted EntityCardsDatasourceEventBus entityCardsDatasourceEventBus, @Assisted C11761 c11761, @Assisted C11881 c11881, @Assisted FriendingLocation friendingLocation, @Assisted FriendRequestMakeRef friendRequestMakeRef, PersonCardActionBarPresenterProvider personCardActionBarPresenterProvider, PersonCardContextItemListPresenterProvider personCardContextItemListPresenterProvider, PersonCardHeaderPresenterProvider personCardHeaderPresenterProvider, PersonCardFooterPresenterProvider personCardFooterPresenterProvider) {
        Preconditions.checkNotNull(entityCardsAnalyticsLogger);
        this.f11162a = personCardActionBarPresenterProvider.m13267a(personCardModel, entityCardsAnalyticsLogger, entityCardsDatasourceEventBus, c11761, friendingLocation, friendRequestMakeRef);
        this.f11163b = personCardContextItemListPresenterProvider.m13311a(personCardModel, entityCardsDatasourceEventBus, c11881, entityCardsAnalyticsLogger);
        this.f11164c = personCardHeaderPresenterProvider.m13343a(personCardModel, entityCardsDatasourceEventBus, entityCardsAnalyticsLogger);
        this.f11165d = personCardFooterPresenterProvider.m13323a(personCardModel, entityCardsDatasourceEventBus, entityCardsAnalyticsLogger);
    }

    protected final void mo789b() {
        Optional a = m13028a();
        if (a.isPresent()) {
            PersonCardView personCardView = (PersonCardView) a.get();
            this.f11164c.m13029a(personCardView.f11254b);
            this.f11162a.m13029a(personCardView.f11255c);
            this.f11163b.m13029a(personCardView.f11256d);
            this.f11165d.m13029a(personCardView.f11257e);
            personCardView.f11253a = this;
        }
    }

    public final void m13093a(PersonCardView personCardView) {
        this.f11164c.m13341b(personCardView.f11254b);
        this.f11162a.m13262a(personCardView.f11255c);
        this.f11163b.m13306a(personCardView.f11256d);
        this.f11165d.mo790b(personCardView.f11257e);
        super.mo790b(personCardView);
    }
}
