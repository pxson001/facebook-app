package com.facebook.ui.recyclableviewpool;

import com.facebook.appdiscovery.lite.ui.rows.sections.AppDiscoveryDeclarations;
import com.facebook.appinvites.ui.AppInvitesRecyclableViewsDeclaration;
import com.facebook.feed.rows.sections.MultipleRowsDeclaration;
import com.facebook.feedplugins.articlechaining.view.ArticleChainingDeclarations;
import com.facebook.feedplugins.customizedstory.CustomizedStoryDeclaration;
import com.facebook.feedplugins.egolistview.EgoListViewDeclarations;
import com.facebook.feedplugins.eventschaining.view.EventsChainingDeclarations;
import com.facebook.feedplugins.goodwill.GoodwillDeclaration;
import com.facebook.feedplugins.groupcommerce.GroupCommerceStorySetDeclaration;
import com.facebook.feedplugins.gts.GtsDeclarations;
import com.facebook.feedplugins.gysc.GroupsYouShouldCreateDeclaration;
import com.facebook.feedplugins.hpp.MobilePageAdminPanelDeclaration;
import com.facebook.feedplugins.instagram.InstagramPhotosFromFriendsDeclaration;
import com.facebook.feedplugins.multishare.MultiShareDeclaration;
import com.facebook.feedplugins.nearbyfriends.rows.friendslocations.FriendsLocationsRowSupportDeclaration;
import com.facebook.feedplugins.offline.rows.OfflineFeedRowSupportDeclaration;
import com.facebook.feedplugins.photochaining.view.PhotoChainingDeclarations;
import com.facebook.feedplugins.pymi.PymiDeclarations;
import com.facebook.feedplugins.pymk.PymkDeclarations;
import com.facebook.feedplugins.pyml.rows.PagesYouMayLikeDeclaration;
import com.facebook.feedplugins.pyml.views.FollowUpPymlDeclarations;
import com.facebook.feedplugins.pysf.rows.PeopleYouShouldFollowDeclaration;
import com.facebook.feedplugins.researchpoll.ResearchPollDeclarations;
import com.facebook.feedplugins.reviews.declarations.PlaceReviewDeclaration;
import com.facebook.feedplugins.saved.declarations.SavedCollectionDeclarations;
import com.facebook.feedplugins.sgny.SgnyDeclarations;
import com.facebook.feedplugins.socialgood.SocialGoodDeclaration;
import com.facebook.feedplugins.storyset.rows.StorySetDeclaration;
import com.facebook.feedplugins.topiccustomizationstory.TopicCustomizationStoryDeclaration;
import com.facebook.feedplugins.worktrending.WorkTrendingDeclarations;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.localcontent.criticreviews.CriticReviewRecyclableViewDeclaration;
import com.facebook.messaging.xma.hscroll.HScrollRecyclableViewDeclaration;
import com.facebook.pages.identity.cards.events.PageIdentityEventGalleryItemDescription;
import com.facebook.pages.identity.cards.photos.PageIdentityPhotoGalleryItemViewDescription;
import com.facebook.reaction.feed.rows.ReactionRowSupportDeclaration;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$RecyclableViewsDeclaration implements MultiBindIndexedProvider<RecyclableViewsDeclaration>, Provider<Set<RecyclableViewsDeclaration>> {
    private final InjectorLike f6464a;

    public STATICDI_MULTIBIND_PROVIDER$RecyclableViewsDeclaration(InjectorLike injectorLike) {
        this.f6464a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f6464a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 35;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return AppDiscoveryDeclarations.m6905a((InjectorLike) injector);
            case 1:
                return AppInvitesRecyclableViewsDeclaration.m6961a((InjectorLike) injector);
            case 2:
                return MultipleRowsDeclaration.m6970a((InjectorLike) injector);
            case 3:
                return ArticleChainingDeclarations.m6986a((InjectorLike) injector);
            case 4:
                return CustomizedStoryDeclaration.a(injector);
            case 5:
                return EgoListViewDeclarations.m6990a((InjectorLike) injector);
            case 6:
                return EventsChainingDeclarations.m7007a((InjectorLike) injector);
            case 7:
                return GoodwillDeclaration.a(injector);
            case 8:
                return GroupCommerceStorySetDeclaration.m7011a((InjectorLike) injector);
            case 9:
                return GtsDeclarations.a(injector);
            case 10:
                return GroupsYouShouldCreateDeclaration.a(injector);
            case 11:
                return MobilePageAdminPanelDeclaration.a(injector);
            case 12:
                return InstagramPhotosFromFriendsDeclaration.a(injector);
            case 13:
                return MultiShareDeclaration.m7045a((InjectorLike) injector);
            case 14:
                return FriendsLocationsRowSupportDeclaration.m7048a((InjectorLike) injector);
            case 15:
                return OfflineFeedRowSupportDeclaration.m7060a((InjectorLike) injector);
            case 16:
                return PhotoChainingDeclarations.m7064a((InjectorLike) injector);
            case 17:
                return PymiDeclarations.a(injector);
            case 18:
                return PymkDeclarations.a(injector);
            case 19:
                return PagesYouMayLikeDeclaration.a(injector);
            case 20:
                return FollowUpPymlDeclarations.m7137a((InjectorLike) injector);
            case 21:
                return PeopleYouShouldFollowDeclaration.a(injector);
            case 22:
                return ResearchPollDeclarations.a(injector);
            case 23:
                return PlaceReviewDeclaration.a(injector);
            case 24:
                return SavedCollectionDeclarations.a(injector);
            case 25:
                return SgnyDeclarations.a(injector);
            case 26:
                return SocialGoodDeclaration.a(injector);
            case 27:
                return StorySetDeclaration.a(injector);
            case 28:
                return TopicCustomizationStoryDeclaration.a(injector);
            case 29:
                return WorkTrendingDeclarations.a(injector);
            case 30:
                return new CriticReviewRecyclableViewDeclaration();
            case 31:
                return new HScrollRecyclableViewDeclaration();
            case 32:
                return new PageIdentityEventGalleryItemDescription();
            case 33:
                return new PageIdentityPhotoGalleryItemViewDescription();
            case 34:
                return ReactionRowSupportDeclaration.m7223a((InjectorLike) injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
