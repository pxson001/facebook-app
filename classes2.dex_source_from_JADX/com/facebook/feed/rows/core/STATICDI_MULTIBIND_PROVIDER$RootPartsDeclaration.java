package com.facebook.feed.rows.core;

import com.facebook.feed.rows.sections.common.endoffeed.EndOfFeedRootPartsDeclaration;
import com.facebook.feed.rows.sections.common.loadingmore.LoadingMoreRootPartsDeclaration;
import com.facebook.feed.rows.sections.common.scissor.ScissorRootPartsDeclaration;
import com.facebook.feedplugins.customizedstory.CustomizedStoryDeclaration;
import com.facebook.feedplugins.egolistview.rows.GysjDeclarations;
import com.facebook.feedplugins.findgroups.FindGroupsDeclaration;
import com.facebook.feedplugins.findpages.FindPagesDeclaration;
import com.facebook.feedplugins.goodwill.GoodwillDeclaration;
import com.facebook.feedplugins.greetingcard.GreetingCardPromoDeclaration;
import com.facebook.feedplugins.growth.GrowthDeclaration;
import com.facebook.feedplugins.gts.GtsDeclarations;
import com.facebook.feedplugins.gysc.GroupsYouShouldCreateDeclaration;
import com.facebook.feedplugins.hpp.MobilePageAdminPanelDeclaration;
import com.facebook.feedplugins.instagram.InstagramPhotosFromFriendsDeclaration;
import com.facebook.feedplugins.nearbyfriends.rows.friendslocations.FriendsLocationsDeclaration;
import com.facebook.feedplugins.psym.PsymDeclarations;
import com.facebook.feedplugins.pyma.PymaDeclaration;
import com.facebook.feedplugins.pymi.PymiDeclarations;
import com.facebook.feedplugins.pymk.PymkDeclarations;
import com.facebook.feedplugins.pyml.rows.PagesYouMayLikeDeclaration;
import com.facebook.feedplugins.pysf.rows.PeopleYouShouldFollowDeclaration;
import com.facebook.feedplugins.quickpromotion.QuickPromotionDeclarations;
import com.facebook.feedplugins.reactnative.ReactNativePluginDeclaration;
import com.facebook.feedplugins.researchpoll.ResearchPollDeclarations;
import com.facebook.feedplugins.reviews.declarations.PlaceReviewDeclaration;
import com.facebook.feedplugins.saved.declarations.SavedCollectionDeclarations;
import com.facebook.feedplugins.sgny.SgnyDeclarations;
import com.facebook.feedplugins.socialgood.SocialGoodDeclaration;
import com.facebook.feedplugins.storygallerysurvey.StoryGallerySurveyInFeedDeclaration;
import com.facebook.feedplugins.storyset.rows.StorySetDeclaration;
import com.facebook.feedplugins.survey.SurveyDeclarations;
import com.facebook.feedplugins.topiccustomizationstory.TopicCustomizationStoryDeclaration;
import com.facebook.feedplugins.worktrending.WorkTrendingDeclarations;
import com.facebook.goodfriends.feedplugins.FeedPluginsDeclaration;
import com.facebook.goodwill.feed.rows.ThrowbackPartsDeclaration;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.privacy.checkup.photofeed.PrivacyCheckupDeclaration;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$RootPartsDeclaration implements MultiBindIndexedProvider<RootPartsDeclaration>, Provider<Set<RootPartsDeclaration>> {
    private final InjectorLike f17942a;

    private STATICDI_MULTIBIND_PROVIDER$RootPartsDeclaration(InjectorLike injectorLike) {
        this.f17942a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f17942a.getScopeAwareInjector(), this);
    }

    public static Set<RootPartsDeclaration> m25169a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$RootPartsDeclaration(injectorLike));
    }

    public final int size() {
        return 36;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return EndOfFeedRootPartsDeclaration.m25197a((InjectorLike) injector);
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return LoadingMoreRootPartsDeclaration.m25208a((InjectorLike) injector);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return ScissorRootPartsDeclaration.m25211a((InjectorLike) injector);
            case 3:
                return CustomizedStoryDeclaration.m25214a((InjectorLike) injector);
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return GysjDeclarations.m25266a((InjectorLike) injector);
            case 5:
                return FindGroupsDeclaration.m25309a((InjectorLike) injector);
            case 6:
                return FindPagesDeclaration.m25321a((InjectorLike) injector);
            case 7:
                return GoodwillDeclaration.m25333a((InjectorLike) injector);
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return GreetingCardPromoDeclaration.m25403a((InjectorLike) injector);
            case 9:
                return GrowthDeclaration.m25447a((InjectorLike) injector);
            case 10:
                return GtsDeclarations.m25467a((InjectorLike) injector);
            case 11:
                return GroupsYouShouldCreateDeclaration.m25496a((InjectorLike) injector);
            case 12:
                return MobilePageAdminPanelDeclaration.m25519a((InjectorLike) injector);
            case 13:
                return InstagramPhotosFromFriendsDeclaration.m25543a((InjectorLike) injector);
            case 14:
                return FriendsLocationsDeclaration.m25566a((InjectorLike) injector);
            case 15:
                return PsymDeclarations.m25569a((InjectorLike) injector);
            case HTTPTransportCallback.HEADER_BYTES_GENERATED /*16*/:
                return PymaDeclaration.m25596a((InjectorLike) injector);
            case 17:
                return PymiDeclarations.m25629a((InjectorLike) injector);
            case 18:
                return PymkDeclarations.m25680a((InjectorLike) injector);
            case 19:
                return PagesYouMayLikeDeclaration.m25723a((InjectorLike) injector);
            case 20:
                return PeopleYouShouldFollowDeclaration.m25791a((InjectorLike) injector);
            case 21:
                return QuickPromotionDeclarations.m25817a((InjectorLike) injector);
            case 22:
                return ReactNativePluginDeclaration.m25846a((InjectorLike) injector);
            case 23:
                return ResearchPollDeclarations.m25849a((InjectorLike) injector);
            case 24:
                return PlaceReviewDeclaration.m25899a((InjectorLike) injector);
            case 25:
                return SavedCollectionDeclarations.m25920a((InjectorLike) injector);
            case 26:
                return SgnyDeclarations.m25925a((InjectorLike) injector);
            case 27:
                return SocialGoodDeclaration.m25951a((InjectorLike) injector);
            case 28:
                return StoryGallerySurveyInFeedDeclaration.m25955a((InjectorLike) injector);
            case 29:
                return StorySetDeclaration.m25986a((InjectorLike) injector);
            case 30:
                return SurveyDeclarations.m26054a((InjectorLike) injector);
            case 31:
                return TopicCustomizationStoryDeclaration.m26088a((InjectorLike) injector);
            case HTTPTransportCallback.HEADER_BYTES_RECEIVED /*32*/:
                return WorkTrendingDeclarations.m26130a((InjectorLike) injector);
            case 33:
                return FeedPluginsDeclaration.m26153a((InjectorLike) injector);
            case 34:
                return ThrowbackPartsDeclaration.m26165a((InjectorLike) injector);
            case 35:
                return PrivacyCheckupDeclaration.m26182b(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
