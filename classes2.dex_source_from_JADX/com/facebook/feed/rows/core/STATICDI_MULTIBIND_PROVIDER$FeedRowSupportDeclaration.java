package com.facebook.feed.rows.core;

import com.facebook.aplacefor.reaction.APlaceForRowSupportDeclaration;
import com.facebook.appdiscovery.lite.ui.rows.sections.AppDiscoveryDeclarations;
import com.facebook.checkin.socialsearch.feed.SocialSearchFeedRowsDeclaration;
import com.facebook.events.dashboard.multirow.EventsDashboardRowSupportDeclaration;
import com.facebook.events.permalink.multirow.EventsPermalinkRowSupportDeclaration;
import com.facebook.feed.inlinecomposer.multirow.InlineComposerRowSupportDeclaration;
import com.facebook.feed.rows.sections.MultipleRowsDeclaration;
import com.facebook.feedback.ui.rows.CommentRowSupportDeclaration;
import com.facebook.feedplugins.attachments.album.AlbumAttachmentDeclaration;
import com.facebook.feedplugins.attachments.poll.PollAttachmentDeclaration;
import com.facebook.feedplugins.customizedstory.CustomizedStoryDeclaration;
import com.facebook.feedplugins.egolistview.rows.GysjDeclarations;
import com.facebook.feedplugins.facebookvoice.FacebookVoiceDeclaration;
import com.facebook.feedplugins.findgroups.FindGroupsDeclaration;
import com.facebook.feedplugins.findpages.FindPagesDeclaration;
import com.facebook.feedplugins.fitness.FitnessAttachmentDeclaration;
import com.facebook.feedplugins.fitness.FitnessAttachmentUtils;
import com.facebook.feedplugins.games.QuicksilverDeclaration;
import com.facebook.feedplugins.goodwill.GoodwillDeclaration;
import com.facebook.feedplugins.graphqlstory.seefirsttombstone.SeeFirstTombstoneDeclaration;
import com.facebook.feedplugins.graphqlstory.usertopictombstone.UserTopicTombstoneDeclaration;
import com.facebook.feedplugins.greetingcard.GreetingCardAttachmentDeclaration;
import com.facebook.feedplugins.greetingcard.GreetingCardPromoDeclaration;
import com.facebook.feedplugins.groupcommerce.GroupCommerceItemAttachmentDeclaration;
import com.facebook.feedplugins.groupcommerce.GroupCommerceMarkAsSoldAttachmentDeclaration;
import com.facebook.feedplugins.growth.GrowthDeclaration;
import com.facebook.feedplugins.gts.GtsDeclarations;
import com.facebook.feedplugins.hpp.MobilePageAdminPanelDeclaration;
import com.facebook.feedplugins.instagram.InstagramPhotosFromFriendsDeclaration;
import com.facebook.feedplugins.instantarticles.InstantArticlesDeclaration;
import com.facebook.feedplugins.musicpreview.MusicPreviewMultiRowSupportPluginDeclaration;
import com.facebook.feedplugins.musicstory.MusicStoryMultiRowDeclaration;
import com.facebook.feedplugins.nearbyfriends.rows.friendslocations.FriendsLocationsRowSupportDeclaration;
import com.facebook.feedplugins.offline.rows.OfflineFeedRowSupportDeclaration;
import com.facebook.feedplugins.pyma.PymaDeclaration;
import com.facebook.feedplugins.pymi.PymiDeclarations;
import com.facebook.feedplugins.pymk.PymkDeclarations;
import com.facebook.feedplugins.pyml.rows.PagesYouMayLikeDeclaration;
import com.facebook.feedplugins.pysf.rows.PeopleYouShouldFollowDeclaration;
import com.facebook.feedplugins.quickpromotion.QuickPromotionDeclarations;
import com.facebook.feedplugins.reactnative.ReactNativePluginFeedRowSupportDeclaration;
import com.facebook.feedplugins.researchpoll.ResearchPollDeclarations;
import com.facebook.feedplugins.reviews.declarations.PlaceReviewDeclaration;
import com.facebook.feedplugins.richmedia.RichMediaDeclaration;
import com.facebook.feedplugins.saved.declarations.SavedCollectionDeclarations;
import com.facebook.feedplugins.sgny.SgnyDeclarations;
import com.facebook.feedplugins.socialgood.SocialGoodDeclaration;
import com.facebook.feedplugins.storygallerysurvey.StoryGallerySurveyInFeedDeclaration;
import com.facebook.feedplugins.survey.SurveyDeclarations;
import com.facebook.feedplugins.video.VideoDeclaration;
import com.facebook.feedplugins.voiceswitcher.VoiceSwitcherDeclaration;
import com.facebook.feedplugins.worktrending.WorkTrendingDeclarations;
import com.facebook.gametime.ui.GametimeRowSupportDeclaration;
import com.facebook.goodfriends.feedplugins.FeedPluginsDeclaration;
import com.facebook.goodwill.feed.rows.ThrowbackPartsDeclaration;
import com.facebook.groups.feed.ui.partdefinitions.GroupsFeedRowSupportDeclaration;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.notifications.multirow.NotificationsRowSupportDeclaration;
import com.facebook.notifications.settings.NotificationSettingsRowSupportDeclaration;
import com.facebook.pages.common.reaction.declaration.PagesSurfaceRowSupportDeclaration;
import com.facebook.pages.common.surface.ui.relatedpages.PageRelatedPagesFeedRowSupportDeclaration;
import com.facebook.pages.identity.timeline.PageIdentityFeedRowSupportDeclaration;
import com.facebook.privacy.checkup.photofeed.PrivacyCheckupDeclaration;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.reaction.feed.rows.ReactionRowSupportDeclaration;
import com.facebook.redspace.rows.RedSpaceFeedRowSupportDeclaration;
import com.facebook.search.results.rows.SearchResultsRowsDeclaration;
import com.facebook.search.results.rows.livefeed.LiveFeedRowsDeclaration;
import com.facebook.search.typeahead.rows.SearchTypeaheadRowsDeclaration;
import com.facebook.timeline.editfeaturedcontainers.rows.NullStateDeclarations;
import com.facebook.timeline.favmediapicker.rows.FavoriteMediaPickerDeclarations;
import com.facebook.timeline.feed.TimelineFeedPlugInDeclarations;
import com.facebook.timeline.protiles.ProtilesDeclarations;
import com.facebook.timeline.publisher.rows.PublisherDeclarations;
import com.facebook.timeline.pymk.PeopleYouMayKnowDeclarations;
import com.facebook.today.ui.TodayRowSupportDeclaration;
import com.facebook.video.channelfeed.ChannelFeedRowsDeclaration;
import com.facebook.video.videohome.partdefinitions.VideoHomeRowSupportDeclaration;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$FeedRowSupportDeclaration implements MultiBindIndexedProvider<FeedRowSupportDeclaration>, Provider<Set<FeedRowSupportDeclaration>> {
    private final InjectorLike f11255a;

    public STATICDI_MULTIBIND_PROVIDER$FeedRowSupportDeclaration(InjectorLike injectorLike) {
        this.f11255a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f11255a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 75;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new APlaceForRowSupportDeclaration();
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return AppDiscoveryDeclarations.a(injector);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return new SocialSearchFeedRowsDeclaration();
            case 3:
                return EventsDashboardRowSupportDeclaration.a(injector);
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return new EventsPermalinkRowSupportDeclaration();
            case 5:
                return InlineComposerRowSupportDeclaration.a(injector);
            case 6:
                return MultipleRowsDeclaration.a(injector);
            case 7:
                return CommentRowSupportDeclaration.a(injector);
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return AlbumAttachmentDeclaration.a(injector);
            case 9:
                return PollAttachmentDeclaration.a(injector);
            case 10:
                return CustomizedStoryDeclaration.m25214a((InjectorLike) injector);
            case 11:
                return GysjDeclarations.m25266a((InjectorLike) injector);
            case 12:
                return FacebookVoiceDeclaration.a(injector);
            case 13:
                return FindGroupsDeclaration.m25309a((InjectorLike) injector);
            case 14:
                return FindPagesDeclaration.m25321a((InjectorLike) injector);
            case 15:
                return new FitnessAttachmentDeclaration(FitnessAttachmentUtils.b(injector));
            case HTTPTransportCallback.HEADER_BYTES_GENERATED /*16*/:
                return QuicksilverDeclaration.a(injector);
            case 17:
                return GoodwillDeclaration.m25333a((InjectorLike) injector);
            case 18:
                return SeeFirstTombstoneDeclaration.a(injector);
            case 19:
                return UserTopicTombstoneDeclaration.a(injector);
            case 20:
                return GreetingCardAttachmentDeclaration.a(injector);
            case 21:
                return GreetingCardPromoDeclaration.m25403a((InjectorLike) injector);
            case 22:
                return new GroupCommerceItemAttachmentDeclaration();
            case 23:
                return new GroupCommerceMarkAsSoldAttachmentDeclaration();
            case 24:
                return GrowthDeclaration.m25447a((InjectorLike) injector);
            case 25:
                return GtsDeclarations.m25467a((InjectorLike) injector);
            case 26:
                return MobilePageAdminPanelDeclaration.m25519a((InjectorLike) injector);
            case 27:
                return InstagramPhotosFromFriendsDeclaration.m25543a((InjectorLike) injector);
            case 28:
                return InstantArticlesDeclaration.a(injector);
            case 29:
                return MusicPreviewMultiRowSupportPluginDeclaration.a(injector);
            case 30:
                return MusicStoryMultiRowDeclaration.a(injector);
            case 31:
                return FriendsLocationsRowSupportDeclaration.a(injector);
            case HTTPTransportCallback.HEADER_BYTES_RECEIVED /*32*/:
                return OfflineFeedRowSupportDeclaration.a(injector);
            case 33:
                return PymaDeclaration.m25596a((InjectorLike) injector);
            case 34:
                return PymiDeclarations.m25629a((InjectorLike) injector);
            case 35:
                return PymkDeclarations.m25680a((InjectorLike) injector);
            case 36:
                return PagesYouMayLikeDeclaration.m25723a((InjectorLike) injector);
            case 37:
                return PeopleYouShouldFollowDeclaration.m25791a((InjectorLike) injector);
            case 38:
                return QuickPromotionDeclarations.m25817a((InjectorLike) injector);
            case 39:
                return ReactNativePluginFeedRowSupportDeclaration.a(injector);
            case 40:
                return ResearchPollDeclarations.m25849a((InjectorLike) injector);
            case 41:
                return PlaceReviewDeclaration.m25899a((InjectorLike) injector);
            case 42:
                return RichMediaDeclaration.a(injector);
            case 43:
                return SavedCollectionDeclarations.m25920a((InjectorLike) injector);
            case 44:
                return SgnyDeclarations.m25925a((InjectorLike) injector);
            case 45:
                return SocialGoodDeclaration.m25951a((InjectorLike) injector);
            case 46:
                return StoryGallerySurveyInFeedDeclaration.m25955a((InjectorLike) injector);
            case 47:
                return SurveyDeclarations.m26054a((InjectorLike) injector);
            case 48:
                return VideoDeclaration.a(injector);
            case 49:
                return VoiceSwitcherDeclaration.a(injector);
            case 50:
                return WorkTrendingDeclarations.m26130a((InjectorLike) injector);
            case 51:
                return GametimeRowSupportDeclaration.a(injector);
            case 52:
                return FeedPluginsDeclaration.m26153a((InjectorLike) injector);
            case 53:
                return ThrowbackPartsDeclaration.m26165a((InjectorLike) injector);
            case 54:
                return new GroupsFeedRowSupportDeclaration();
            case 55:
                return new NotificationsRowSupportDeclaration();
            case 56:
                return new NotificationSettingsRowSupportDeclaration();
            case 57:
                return new PagesSurfaceRowSupportDeclaration();
            case 58:
                return new PageRelatedPagesFeedRowSupportDeclaration();
            case 59:
                return new PageIdentityFeedRowSupportDeclaration();
            case 60:
                return PrivacyCheckupDeclaration.m26182b(injector);
            case 61:
                return ReactionRowSupportDeclaration.a(injector);
            case 62:
                return RedSpaceFeedRowSupportDeclaration.a(injector);
            case 63:
                return SearchResultsRowsDeclaration.a(injector);
            case HTTPTransportCallback.BODY_BYTES_GENERATED /*64*/:
                return LiveFeedRowsDeclaration.a(injector);
            case 65:
                return SearchTypeaheadRowsDeclaration.a(injector);
            case 66:
                return NullStateDeclarations.a(injector);
            case 67:
                return FavoriteMediaPickerDeclarations.a(injector);
            case 68:
                return TimelineFeedPlugInDeclarations.a(injector);
            case 69:
                return ProtilesDeclarations.a(injector);
            case 70:
                return PublisherDeclarations.a(injector);
            case 71:
                return PeopleYouMayKnowDeclarations.a(injector);
            case 72:
                return new TodayRowSupportDeclaration();
            case 73:
                return ChannelFeedRowsDeclaration.a(injector);
            case 74:
                return new VideoHomeRowSupportDeclaration();
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
