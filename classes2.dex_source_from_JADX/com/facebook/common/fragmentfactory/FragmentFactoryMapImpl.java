package com.facebook.common.fragmentfactory;

import com.facebook.checkin.socialsearch.map.SocialSearchMapFragmentAndUriIntentBuilder;
import com.facebook.commerce.productdetails.fragments.ProductGroupFragmentFactory;
import com.facebook.commerce.publishing.fragments.AdminAddShopFragmentFactory;
import com.facebook.commerce.publishing.fragments.AdminEditShopFragmentFactory;
import com.facebook.commerce.publishing.fragments.AdminProductFragmentFactory;
import com.facebook.commerce.storefront.fragments.AdCollectionViewFragmentFactory;
import com.facebook.commerce.storefront.fragments.CollectionViewFragmentFactory;
import com.facebook.commerce.storefront.fragments.StorefrontFragmentFactory;
import com.facebook.composer.topics.ComposerTopicSelectorFragmentFactory;
import com.facebook.crowdsourcing.friendvote.fragment.FriendVoteInviteFragmentFactory;
import com.facebook.crowdsourcing.picker.hours.HoursPickerFragmentFactory;
import com.facebook.crowdsourcing.suggestedits.fragment.SuggestEditsFragmentFactory;
import com.facebook.events.cancelevent.EventsCancelEventFragmentFactory;
import com.facebook.events.create.EventCreationCategorySelectionFragmentFactory;
import com.facebook.events.create.EventCreationHostSelectionFragmentFactory;
import com.facebook.events.dashboard.EventsDashboardFragmentFactory;
import com.facebook.events.dashboard.EventsDiscoveryUpcomingEventsFragmentFactory;
import com.facebook.events.dashboard.birthdays.EventsUpcomingBirthdaysFragmentFactory;
import com.facebook.events.dashboard.subscriptions.EventsSubscriptionsFragmentFactory;
import com.facebook.events.dashboard.suggestions.EventsSuggestionsFragmentFactory;
import com.facebook.events.eventsdiscovery.EventsDiscoveryFragmentFactory;
import com.facebook.events.eventsdiscovery.EventsDiscoveryLocationPickerFragmentFactory;
import com.facebook.events.invite.CaspianFriendSelectorFragmentFactory;
import com.facebook.events.invite.InviteeReviewModeFragmentFactory;
import com.facebook.events.notificationsettings.EventsNotificationSettingsFragmentFactory;
import com.facebook.events.permalink.EventsPermalinkFragmentFactory;
import com.facebook.events.permalink.guestlist.EventGuestListFragmentFactory;
import com.facebook.events.permalink.hostsinfo.EventHostsFragmentFactory;
import com.facebook.events.permalink.messagefriends.EventMessageFriendsFragmentFactory;
import com.facebook.events.permalink.messageguests.EventMessageGuestsFragmentFactory;
import com.facebook.fbreact.fragment.ImmersiveReactFragmentFactory;
import com.facebook.feed.activity.ProfileListFragmentFactory;
import com.facebook.feed.activity.ReactorsListFragmentFactory;
import com.facebook.feed.awesomizer.ui.AwesomizerFragmentFactory;
import com.facebook.feed.awesomizer.ui.DiscoverFragmentFactory;
import com.facebook.feed.awesomizer.ui.DiscoverTopicFragmentFactory;
import com.facebook.feed.awesomizer.ui.RefollowFragmentFactory;
import com.facebook.feed.awesomizer.ui.SeefirstFragmentFactory;
import com.facebook.feed.awesomizer.ui.UnfollowFragmentFactory;
import com.facebook.feed.fragment.NewsFeedFragmentFactory;
import com.facebook.feed.history.EditHistoryFragmentFactory;
import com.facebook.feed.permalink.CommentPermalinkFragmentFactory;
import com.facebook.feed.storypermalink.PermalinkFragmentFactory;
import com.facebook.feed.topicfeeds.NewsFeedSwitcherFragmentFactory;
import com.facebook.feedplugins.prompts.PromptFriendSelectorFragmentFactory;
import com.facebook.friending.center.uri.FriendsCenterFragmentFactory;
import com.facebook.friending.immersive.ImmersivePeopleYouMayKnowFragmentFactory;
import com.facebook.friending.profileshare.uri.ProfileShareFragmentFactory;
import com.facebook.friending.suggestion.uri.FriendingSuggestionFragmentFactory;
import com.facebook.friendlist.FriendListFragmentFactory;
import com.facebook.friendsnearby.ui.NearbyFriendsFragmentFactory;
import com.facebook.friendsnearby.ui.NearbyFriendsInviteMultipickerFragmentFactory;
import com.facebook.gametime.ui.GametimeDashboardFragmentFactory;
import com.facebook.gametime.ui.plays.GametimePlaysFragmentFactory;
import com.facebook.goodfriends.audience.AudienceFragmentFactory;
import com.facebook.goodwill.birthday.BirthdayCardFragmentFactory;
import com.facebook.goodwill.feed.ui.ThrowbackFeedFragmentFactory;
import com.facebook.groups.docsandfiles.GroupsFileFragmentFactory;
import com.facebook.groups.editfavorites.GroupEditFavoritesFragmentFactory;
import com.facebook.groups.editsettings.GroupEditNameDescFragmentFactory;
import com.facebook.groups.editsettings.GroupEditPrivacyFragmentFactory;
import com.facebook.groups.editsettings.GroupEditPurposeFragmentFactory;
import com.facebook.groups.editsettings.GroupEditSettingsFragmentFactory;
import com.facebook.groups.events.GroupsEventsFragmentFactory;
import com.facebook.groups.fb4a.addtogroups.FB4AAddToGroupsFragmentFactory;
import com.facebook.groups.fb4a.create.FB4AGroupsCreateFragmentFactory;
import com.facebook.groups.fb4a.groupshub.fragment.FB4AGroupsCreationTabFragmentFactory;
import com.facebook.groups.fb4a.groupshub.fragment.FB4AGroupsDiscoverFragmentFactory;
import com.facebook.groups.fb4a.groupshub.fragment.FB4AGroupsGridFragmentFactory;
import com.facebook.groups.fb4a.groupshub.fragment.FB4AGroupsHubSearchFragmentFactory;
import com.facebook.groups.fb4a.memberpicker.FB4AGroupsMemberPickerFragmentFactory;
import com.facebook.groups.fb4a.react.GeneralGroupsReactFragmentFactory;
import com.facebook.groups.feed.integration.CrossGroupForSalePostsFragmentFactory;
import com.facebook.groups.feed.integration.GroupFeedFragmentFactory;
import com.facebook.groups.feed.integration.GroupForSalePostFragmentFactory;
import com.facebook.groups.feed.integration.GroupPendingPostsFragmentFactory;
import com.facebook.groups.feed.integration.GroupPinnedPostFragmentFactory;
import com.facebook.groups.feed.integration.GroupYourPostFragmentFactory;
import com.facebook.groups.info.GroupInfoFragmentFactory;
import com.facebook.groups.info.GroupReactReportedPostFragmentFactory;
import com.facebook.groups.memberlist.GroupMembershipFragmentFactory;
import com.facebook.groups.memberlist.GroupSuggestAdminFragmentFactory;
import com.facebook.groups.memberrequests.GroupsMemberRequestsFragmentFactory;
import com.facebook.groups.photos.GroupAlbumFragmentFactory;
import com.facebook.groups.photos.GroupsPhotosFragmentFactory;
import com.facebook.groups.settings.GroupSubscriptionFragmentFactory;
import com.facebook.groups.sideconversation.GroupsStartSideConversationFragmentFactory;
import com.facebook.growth.friendfinder.FriendFinderIntroFragmentFactory;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.activity.BookmarkMenuFragmentFactory;
import com.facebook.katana.activity.BookmarkSectionFragmentFactory;
import com.facebook.katana.activity.FacewebFragmentFactory;
import com.facebook.katana.activity.FriendRequestsFragmentFactory;
import com.facebook.katana.activity.NearbyPlacesFragmentFactory;
import com.facebook.katana.activity.UberbarFragmentFactory;
import com.facebook.localcontent.AddPhotoMenuFragmentFactory;
import com.facebook.localcontent.PageMenuManagementFragmentFactory;
import com.facebook.localcontent.PageMenuManagementLinkMenuFragmentFactory;
import com.facebook.localcontent.PagePhotoMenuFragmentFactory;
import com.facebook.localcontent.ShowAllPhotosByCategoryFragmentFactory;
import com.facebook.localcontent.StructuredMenuFragmentFactory;
import com.facebook.location.ui.LocationSettingsFragmentFactory;
import com.facebook.looknow.LookNowPermalinkFragmentFactory;
import com.facebook.maps.GenericMapsFragmentAndUriIntentBuilder;
import com.facebook.marketplace.tab.MarketplaceTabFragmentFactory;
import com.facebook.notifications.fragmentfactory.NotificationSettingsFragmentFactory;
import com.facebook.notifications.fragmentfactory.NotificationsFragmentFactory;
import com.facebook.notifications.fragmentfactory.NotificationsFriendingFragmentFactory;
import com.facebook.notifications.widget.NotificationSettingsAlertsFragmentFactory;
import com.facebook.offers.fragment.OffersDetailPageFragmentFactory;
import com.facebook.offers.fragment.OffersWalletFragmentFactory;
import com.facebook.pages.browser.fragment.PagesBrowserFragmentFactory;
import com.facebook.pages.browser.fragment.PagesBrowserListFragmentFactory;
import com.facebook.pages.common.editpage.PageEditPageFragmentFactory;
import com.facebook.pages.common.friendinviter.fragments.PageFriendInviterFragmentFactory;
import com.facebook.pages.fb4a.admin_activity.uri.Fb4aPagesNotificationsFragmentFactory;
import com.facebook.pages.identity.fragments.identity.PageAlbumFragmentFactory;
import com.facebook.pages.identity.fragments.identity.PageCallToActionFragmentFactory;
import com.facebook.pages.identity.fragments.identity.PageChildLocationsFragmentFactory;
import com.facebook.pages.identity.fragments.identity.PageContactInboxFragmentFactory;
import com.facebook.pages.identity.fragments.identity.PageEventsListFragmentFactory;
import com.facebook.pages.identity.fragments.identity.PageIdentityFragmentFactory;
import com.facebook.pages.identity.fragments.identity.PageInformationFragmentFactory;
import com.facebook.pages.identity.fragments.identity.PageManagerCoverPhotoFragmentFactory;
import com.facebook.pages.identity.fragments.identity.PageReactionFragmentFactory;
import com.facebook.pages.identity.fragments.identity.PageResidenceFragmentFactory;
import com.facebook.pages.identity.fragments.identity.PageServiceFragmentFactory;
import com.facebook.pages.identity.fragments.identity.PageSingleServiceFragmentFactory;
import com.facebook.pages.identity.fragments.identity.PageVideoHubFragmentFactory;
import com.facebook.pages.identity.fragments.identity.PageVideoListAllVideosFragmentFactory;
import com.facebook.pages.identity.fragments.identity.PageVideoListFragmentFactory;
import com.facebook.pages.identity.fragments.identity.PageVistorPostsFragmentFactory;
import com.facebook.pages.launchpoint.fragments.factories.PagesLaunchpointFragmentFactory;
import com.facebook.places.create.citypicker.CityPickerFragmentFactory;
import com.facebook.places.pagetopics.CategoryPickerFragmentFactory;
import com.facebook.placetips.settings.ui.PlaceTipsBlacklistConfirmationFragmentFactory;
import com.facebook.placetips.settings.ui.PlaceTipsBlacklistPromptFragmentFactory;
import com.facebook.placetips.settings.ui.PlaceTipsBlacklistReasonFragmentFactory;
import com.facebook.placetips.settings.ui.PlaceTipsSettingsFragmentFactory;
import com.facebook.placetips.upsell.UpsellFragmentFactory;
import com.facebook.profile.inforequest.InfoRequestFragmentFactory;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.quickpromotion.ui.QuickPromotionTabFragmentFactory;
import com.facebook.reaction.ui.fragment.ReactionDialogFragmentFactory;
import com.facebook.reaction.ui.fragment.ShowMoreAttachmentsFragmentFactory;
import com.facebook.reaction.ui.fragment.ShowMoreComponentsFragmentFactory;
import com.facebook.redspace.fragment.RedSpaceFriendsOverflowFragmentFactory;
import com.facebook.redspace.fragment.RedSpaceHomeFragmentFactory;
import com.facebook.reviews.ui.PageReviewsFragmentFactory;
import com.facebook.reviews.ui.UserReviewsFragmentFactory;
import com.facebook.saved.fragment.SavedFragmentFactory;
import com.facebook.search.fragmentfactory.EntitiesFragmentFactory;
import com.facebook.search.fragmentfactory.FeedFragmentFactory;
import com.facebook.search.fragmentfactory.FilterTypeaheadFragmentFactory;
import com.facebook.search.fragmentfactory.GraphSearchFragmentFactory;
import com.facebook.search.fragmentfactory.LiveFeedFragmentFactory;
import com.facebook.search.fragmentfactory.PandoraPhotosFragmentFactory;
import com.facebook.search.fragmentfactory.PlacesFragmentFactory;
import com.facebook.search.fragmentfactory.ResultsFragmentFactory;
import com.facebook.securitycheckup.password.SecurityCheckupPasswordChangeFragmentFactory;
import com.facebook.socialgood.FundraiserDonationFragmentFactory;
import com.facebook.socialgood.FundraiserPageFragmentFactory;
import com.facebook.socialgood.guestlist.FundraiserGuestListFragmentFactory;
import com.facebook.socialgood.guestlist.FundraiserMessageGuestsFragmentFactory;
import com.facebook.socialgood.inviter.FundraiserPageInviterFragmentFactory;
import com.facebook.timeline.CoverPhotoFragmentFactory;
import com.facebook.timeline.TimelineFragmentFactory;
import com.facebook.timeline.aboutpage.CollectionsCollectionFragmentFactory;
import com.facebook.timeline.aboutpage.CollectionsSectionFragmentFactory;
import com.facebook.timeline.aboutpage.CollectionsSummaryFragmentFactory;
import com.facebook.today.intent.TodayFragmentFactory;
import com.facebook.topics.customization.TopicCustomizationFragmentFactory;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.vault.momentsupsell.uri.MomentsUpsellPromotionFragmentFactory;
import com.facebook.video.livemap.LiveMapFragmentFactory;
import com.facebook.video.videohome.fragment.VideoHomeFragmentFactory;
import com.facebook.video.videohome.fragment.VideoHomeGuideFragmentFactory;
import com.facebook.zero.carrier.fragment.CarrierManagerFragmentFactory;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: profile/section_stories/%d/%d */
public class FragmentFactoryMapImpl implements FragmentFactoryMap {
    private static volatile FragmentFactoryMapImpl ct;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<EventHostsFragmentFactory> f8887A = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<EventMessageFriendsFragmentFactory> f8888B = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<EventMessageGuestsFragmentFactory> f8889C = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<EventsNotificationSettingsFragmentFactory> f8890D = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ImmersiveReactFragmentFactory> f8891E = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<AwesomizerFragmentFactory> f8892F = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<DiscoverFragmentFactory> f8893G = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<DiscoverTopicFragmentFactory> f8894H = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RefollowFragmentFactory> f8895I = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SeefirstFragmentFactory> f8896J = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<UnfollowFragmentFactory> f8897K = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<NewsFeedFragmentFactory> f8898L = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<EditHistoryFragmentFactory> f8899M = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ProfileListFragmentFactory> f8900N = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ReactorsListFragmentFactory> f8901O = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<CommentPermalinkFragmentFactory> f8902P = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PermalinkFragmentFactory> f8903Q = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<NewsFeedSwitcherFragmentFactory> f8904R = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PromptFriendSelectorFragmentFactory> f8905S = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FriendsCenterFragmentFactory> f8906T = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ImmersivePeopleYouMayKnowFragmentFactory> f8907U = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ProfileShareFragmentFactory> f8908V = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FriendingSuggestionFragmentFactory> f8909W = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FriendListFragmentFactory> f8910X = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<NearbyFriendsFragmentFactory> f8911Y = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<NearbyFriendsInviteMultipickerFragmentFactory> f8912Z = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SocialSearchMapFragmentAndUriIntentBuilder> f8913a = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GroupInfoFragmentFactory> aA = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GroupReactReportedPostFragmentFactory> aB = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GroupMembershipFragmentFactory> aC = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GroupSuggestAdminFragmentFactory> aD = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GroupsMemberRequestsFragmentFactory> aE = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GroupAlbumFragmentFactory> aF = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GroupsPhotosFragmentFactory> aG = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GroupSubscriptionFragmentFactory> aH = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GroupsStartSideConversationFragmentFactory> aI = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FriendFinderIntroFragmentFactory> aJ = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<BookmarkMenuFragmentFactory> aK = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<BookmarkSectionFragmentFactory> aL = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FacewebFragmentFactory> aM = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FriendRequestsFragmentFactory> aN = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<NearbyPlacesFragmentFactory> aO = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<UberbarFragmentFactory> aP = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<AddPhotoMenuFragmentFactory> aQ = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PageMenuManagementFragmentFactory> aR = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PageMenuManagementLinkMenuFragmentFactory> aS = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PagePhotoMenuFragmentFactory> aT = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ShowAllPhotosByCategoryFragmentFactory> aU = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<StructuredMenuFragmentFactory> aV = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<LocationSettingsFragmentFactory> aW = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<LookNowPermalinkFragmentFactory> aX = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GenericMapsFragmentAndUriIntentBuilder> aY = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<MarketplaceTabFragmentFactory> aZ = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GametimeDashboardFragmentFactory> aa = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GametimePlaysFragmentFactory> ab = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<AudienceFragmentFactory> ac = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<BirthdayCardFragmentFactory> ad = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ThrowbackFeedFragmentFactory> ae = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GroupsFileFragmentFactory> af = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GroupEditFavoritesFragmentFactory> ag = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GroupEditNameDescFragmentFactory> ah = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GroupEditPrivacyFragmentFactory> ai = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GroupEditPurposeFragmentFactory> aj = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GroupEditSettingsFragmentFactory> ak = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GroupsEventsFragmentFactory> al = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FB4AAddToGroupsFragmentFactory> am = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FB4AGroupsCreateFragmentFactory> an = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FB4AGroupsCreationTabFragmentFactory> ao = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FB4AGroupsDiscoverFragmentFactory> ap = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FB4AGroupsGridFragmentFactory> aq = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FB4AGroupsHubSearchFragmentFactory> ar = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FB4AGroupsMemberPickerFragmentFactory> as = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GeneralGroupsReactFragmentFactory> at = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<CrossGroupForSalePostsFragmentFactory> au = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GroupFeedFragmentFactory> av = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GroupForSalePostFragmentFactory> aw = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GroupPendingPostsFragmentFactory> ax = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GroupPinnedPostFragmentFactory> ay = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GroupYourPostFragmentFactory> az = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ProductGroupFragmentFactory> f8914b = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PageVistorPostsFragmentFactory> bA = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PagesLaunchpointFragmentFactory> bB = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<CityPickerFragmentFactory> bC = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<CategoryPickerFragmentFactory> bD = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PlaceTipsBlacklistConfirmationFragmentFactory> bE = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PlaceTipsBlacklistPromptFragmentFactory> bF = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PlaceTipsBlacklistReasonFragmentFactory> bG = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PlaceTipsSettingsFragmentFactory> bH = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<UpsellFragmentFactory> bI = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<InfoRequestFragmentFactory> bJ = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<QuickPromotionTabFragmentFactory> bK = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ReactionDialogFragmentFactory> bL = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ShowMoreAttachmentsFragmentFactory> bM = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ShowMoreComponentsFragmentFactory> bN = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceFriendsOverflowFragmentFactory> bO = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceHomeFragmentFactory> bP = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PageReviewsFragmentFactory> bQ = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<UserReviewsFragmentFactory> bR = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SavedFragmentFactory> bS = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<EntitiesFragmentFactory> bT = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FeedFragmentFactory> bU = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FilterTypeaheadFragmentFactory> bV = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GraphSearchFragmentFactory> bW = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<LiveFeedFragmentFactory> bX = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PandoraPhotosFragmentFactory> bY = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PlacesFragmentFactory> bZ = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<NotificationSettingsFragmentFactory> ba = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<NotificationsFragmentFactory> bb = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<NotificationsFriendingFragmentFactory> bc = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<NotificationSettingsAlertsFragmentFactory> bd = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<OffersDetailPageFragmentFactory> be = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<OffersWalletFragmentFactory> bf = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PagesBrowserFragmentFactory> bg = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PagesBrowserListFragmentFactory> bh = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PageEditPageFragmentFactory> bi = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PageFriendInviterFragmentFactory> bj = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<Fb4aPagesNotificationsFragmentFactory> bk = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PageAlbumFragmentFactory> bl = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PageCallToActionFragmentFactory> bm = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PageChildLocationsFragmentFactory> bn = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PageContactInboxFragmentFactory> bo = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PageEventsListFragmentFactory> bp = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PageIdentityFragmentFactory> bq = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PageInformationFragmentFactory> br = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PageManagerCoverPhotoFragmentFactory> bs = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PageReactionFragmentFactory> bt = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PageResidenceFragmentFactory> bu = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PageServiceFragmentFactory> bv = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PageSingleServiceFragmentFactory> bw = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PageVideoHubFragmentFactory> bx = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PageVideoListAllVideosFragmentFactory> by = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PageVideoListFragmentFactory> bz = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<AdminAddShopFragmentFactory> f8915c = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ResultsFragmentFactory> ca = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SecurityCheckupPasswordChangeFragmentFactory> cb = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FundraiserGuestListFragmentFactory> cc = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FundraiserMessageGuestsFragmentFactory> cd = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FundraiserPageInviterFragmentFactory> ce = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FundraiserDonationFragmentFactory> cf = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FundraiserPageFragmentFactory> cg = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<CollectionsCollectionFragmentFactory> ch = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<CollectionsSectionFragmentFactory> ci = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<CollectionsSummaryFragmentFactory> cj = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<CoverPhotoFragmentFactory> ck = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<TimelineFragmentFactory> cl = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<TodayFragmentFactory> cm = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<TopicCustomizationFragmentFactory> cn = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<MomentsUpsellPromotionFragmentFactory> co = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<LiveMapFragmentFactory> cp = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<VideoHomeFragmentFactory> cq = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<VideoHomeGuideFragmentFactory> cr = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<CarrierManagerFragmentFactory> cs = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<AdminEditShopFragmentFactory> f8916d = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<AdminProductFragmentFactory> f8917e = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<AdCollectionViewFragmentFactory> f8918f = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<CollectionViewFragmentFactory> f8919g = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<StorefrontFragmentFactory> f8920h = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ComposerTopicSelectorFragmentFactory> f8921i = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FriendVoteInviteFragmentFactory> f8922j = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<HoursPickerFragmentFactory> f8923k = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SuggestEditsFragmentFactory> f8924l = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<EventsCancelEventFragmentFactory> f8925m = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<EventCreationCategorySelectionFragmentFactory> f8926n = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<EventCreationHostSelectionFragmentFactory> f8927o = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<EventsDiscoveryFragmentFactory> f8928p = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<EventsDiscoveryLocationPickerFragmentFactory> f8929q = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<EventsDashboardFragmentFactory> f8930r = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<EventsDiscoveryUpcomingEventsFragmentFactory> f8931s = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<EventsUpcomingBirthdaysFragmentFactory> f8932t = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<EventsSubscriptionsFragmentFactory> f8933u = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<EventsSuggestionsFragmentFactory> f8934v = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<CaspianFriendSelectorFragmentFactory> f8935w = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<InviteeReviewModeFragmentFactory> f8936x = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<EventsPermalinkFragmentFactory> f8937y = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<EventGuestListFragmentFactory> f8938z = UltralightRuntime.f368b;

    public static com.facebook.common.fragmentfactory.FragmentFactoryMapImpl m13795a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = ct;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.fragmentfactory.FragmentFactoryMapImpl.class;
        monitor-enter(r1);
        r0 = ct;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m13797b(r0);	 Catch:{ all -> 0x0035 }
        ct = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = ct;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.fragmentfactory.FragmentFactoryMapImpl.a(com.facebook.inject.InjectorLike):com.facebook.common.fragmentfactory.FragmentFactoryMapImpl");
    }

    private static FragmentFactoryMapImpl m13797b(InjectorLike injectorLike) {
        FragmentFactoryMapImpl fragmentFactoryMapImpl = new FragmentFactoryMapImpl();
        fragmentFactoryMapImpl.m13796a(IdBasedSingletonScopeProvider.m1810b(injectorLike, 5043), IdBasedLazy.m1808a(injectorLike, 5067), IdBasedLazy.m1808a(injectorLike, 5081), IdBasedLazy.m1808a(injectorLike, 5082), IdBasedLazy.m1808a(injectorLike, 5083), IdBasedLazy.m1808a(injectorLike, 5096), IdBasedLazy.m1808a(injectorLike, 5097), IdBasedLazy.m1808a(injectorLike, 5098), IdBasedLazy.m1808a(injectorLike, 5296), IdBasedLazy.m1808a(injectorLike, 5413), IdBasedLazy.m1808a(injectorLike, 5426), IdBasedLazy.m1808a(injectorLike, 5432), IdBasedLazy.m1808a(injectorLike, 5530), IdBasedLazy.m1808a(injectorLike, 5536), IdBasedLazy.m1808a(injectorLike, 5537), IdBasedLazy.m1808a(injectorLike, 5592), IdBasedLazy.m1808a(injectorLike, 5593), IdBasedLazy.m1808a(injectorLike, 5552), IdBasedLazy.m1808a(injectorLike, 5558), IdBasedLazy.m1808a(injectorLike, 5564), IdBasedLazy.m1808a(injectorLike, 5579), IdBasedLazy.m1808a(injectorLike, 5582), IdBasedLazy.m1808a(injectorLike, 5605), IdBasedLazy.m1808a(injectorLike, 5618), IdBasedLazy.m1808a(injectorLike, 5633), IdBasedLazy.m1808a(injectorLike, 5649), IdBasedLazy.m1808a(injectorLike, 5653), IdBasedLazy.m1808a(injectorLike, 5659), IdBasedLazy.m1808a(injectorLike, 5661), IdBasedLazy.m1808a(injectorLike, 5628), IdBasedLazy.m1808a(injectorLike, 5778), IdBasedLazy.m1808a(injectorLike, 5824), IdBasedLazy.m1808a(injectorLike, 5827), IdBasedLazy.m1808a(injectorLike, 5829), IdBasedLazy.m1808a(injectorLike, 5833), IdBasedLazy.m1808a(injectorLike, 5835), IdBasedLazy.m1808a(injectorLike, 5837), IdBasedLazy.m1808a(injectorLike, 1344), IdBasedLazy.m1808a(injectorLike, 5854), IdBasedLazy.m1808a(injectorLike, 5818), IdBasedLazy.m1808a(injectorLike, 5819), IdBasedLazy.m1808a(injectorLike, 5868), IdBasedLazy.m1808a(injectorLike, 6061), IdBasedLazy.m1808a(injectorLike, 1728), IdBasedLazy.m1808a(injectorLike, 6433), IdBasedLazy.m1808a(injectorLike, 6655), IdBasedLazy.m1808a(injectorLike, 6658), IdBasedLazy.m1808a(injectorLike, 6673), IdBasedLazy.m1808a(injectorLike, 6677), IdBasedLazy.m1808a(injectorLike, 6679), IdBasedLazy.m1808a(injectorLike, 6761), IdBasedLazy.m1808a(injectorLike, 6762), IdBasedLazy.m1808a(injectorLike, 6765), IdBasedLazy.m1808a(injectorLike, 6791), IdBasedLazy.m1808a(injectorLike, 6799), IdBasedLazy.m1808a(injectorLike, 6808), IdBasedLazy.m1808a(injectorLike, 6848), IdBasedLazy.m1808a(injectorLike, 6884), IdBasedLazy.m1808a(injectorLike, 6893), IdBasedLazy.m1808a(injectorLike, 6903), IdBasedLazy.m1808a(injectorLike, 6904), IdBasedLazy.m1808a(injectorLike, 6905), IdBasedLazy.m1808a(injectorLike, 6907), IdBasedLazy.m1808a(injectorLike, 6914), IdBasedLazy.m1808a(injectorLike, 6918), IdBasedLazy.m1808a(injectorLike, 6921), IdBasedLazy.m1808a(injectorLike, 6934), IdBasedLazy.m1808a(injectorLike, 6935), IdBasedLazy.m1808a(injectorLike, 6936), IdBasedLazy.m1808a(injectorLike, 6937), IdBasedLazy.m1808a(injectorLike, 6942), IdBasedLazy.m1808a(injectorLike, 6947), IdBasedLazy.m1808a(injectorLike, 6969), IdBasedLazy.m1808a(injectorLike, 6970), IdBasedLazy.m1808a(injectorLike, 6973), IdBasedLazy.m1808a(injectorLike, 6974), IdBasedLazy.m1808a(injectorLike, 6975), IdBasedLazy.m1808a(injectorLike, 6976), IdBasedLazy.m1808a(injectorLike, 7033), IdBasedLazy.m1808a(injectorLike, 7035), IdBasedLazy.m1808a(injectorLike, 7042), IdBasedLazy.m1808a(injectorLike, 7043), IdBasedLazy.m1808a(injectorLike, 7062), IdBasedLazy.m1808a(injectorLike, 7084), IdBasedLazy.m1808a(injectorLike, 7085), IdBasedLazy.m1808a(injectorLike, 7099), IdBasedLazy.m1808a(injectorLike, 7100), IdBasedLazy.m1808a(injectorLike, 7132), IdBasedLazy.m1808a(injectorLike, 7314), IdBasedLazy.m1808a(injectorLike, 7315), IdBasedLazy.m1808a(injectorLike, 7316), IdBasedLazy.m1808a(injectorLike, 7317), IdBasedLazy.m1808a(injectorLike, 7318), IdBasedLazy.m1808a(injectorLike, 7321), IdBasedLazy.m1808a(injectorLike, 7415), IdBasedLazy.m1808a(injectorLike, 7416), IdBasedLazy.m1808a(injectorLike, 7417), IdBasedLazy.m1808a(injectorLike, 7418), IdBasedLazy.m1808a(injectorLike, 7419), IdBasedLazy.m1808a(injectorLike, 7420), IdBasedLazy.m1808a(injectorLike, 7465), IdBasedLazy.m1808a(injectorLike, 7469), IdBasedSingletonScopeProvider.m1810b(injectorLike, 7477), IdBasedLazy.m1808a(injectorLike, 7488), IdBasedLazy.m1808a(injectorLike, 8691), IdBasedLazy.m1808a(injectorLike, 2797), IdBasedLazy.m1808a(injectorLike, 8692), IdBasedLazy.m1808a(injectorLike, 8744), IdBasedLazy.m1808a(injectorLike, 8756), IdBasedLazy.m1808a(injectorLike, 8758), IdBasedLazy.m1808a(injectorLike, 8898), IdBasedLazy.m1808a(injectorLike, 8899), IdBasedLazy.m1808a(injectorLike, 8915), IdBasedLazy.m1808a(injectorLike, 8922), IdBasedLazy.m1808a(injectorLike, 9018), IdBasedLazy.m1808a(injectorLike, 9079), IdBasedLazy.m1808a(injectorLike, 9080), IdBasedLazy.m1808a(injectorLike, 9081), IdBasedLazy.m1808a(injectorLike, 9082), IdBasedLazy.m1808a(injectorLike, 9083), IdBasedLazy.m1808a(injectorLike, 9084), IdBasedLazy.m1808a(injectorLike, 9085), IdBasedLazy.m1808a(injectorLike, 9086), IdBasedLazy.m1808a(injectorLike, 9087), IdBasedLazy.m1808a(injectorLike, 9088), IdBasedLazy.m1808a(injectorLike, 9089), IdBasedLazy.m1808a(injectorLike, 9090), IdBasedLazy.m1808a(injectorLike, 9091), IdBasedLazy.m1808a(injectorLike, 9092), IdBasedLazy.m1808a(injectorLike, 9093), IdBasedLazy.m1808a(injectorLike, 9094), IdBasedLazy.m1808a(injectorLike, 9107), IdBasedLazy.m1808a(injectorLike, 9545), IdBasedLazy.m1808a(injectorLike, 9566), IdBasedLazy.m1808a(injectorLike, 9612), IdBasedLazy.m1808a(injectorLike, 9613), IdBasedLazy.m1808a(injectorLike, 9614), IdBasedLazy.m1808a(injectorLike, 9615), IdBasedLazy.m1808a(injectorLike, 9622), IdBasedLazy.m1808a(injectorLike, 9730), IdBasedLazy.m1808a(injectorLike, 9823), IdBasedLazy.m1808a(injectorLike, 10153), IdBasedLazy.m1808a(injectorLike, 10154), IdBasedLazy.m1808a(injectorLike, 10155), IdBasedLazy.m1808a(injectorLike, 10190), IdBasedLazy.m1808a(injectorLike, 10191), IdBasedLazy.m1808a(injectorLike, 10279), IdBasedLazy.m1808a(injectorLike, 10280), IdBasedLazy.m1808a(injectorLike, 10421), IdBasedLazy.m1808a(injectorLike, 10480), IdBasedLazy.m1808a(injectorLike, 10481), IdBasedLazy.m1808a(injectorLike, 10482), IdBasedLazy.m1808a(injectorLike, 10483), IdBasedLazy.m1808a(injectorLike, 10484), IdBasedLazy.m1808a(injectorLike, 10485), IdBasedLazy.m1808a(injectorLike, 10486), IdBasedLazy.m1808a(injectorLike, 10487), IdBasedLazy.m1808a(injectorLike, 10955), IdBasedLazy.m1808a(injectorLike, 10983), IdBasedLazy.m1808a(injectorLike, 10984), IdBasedLazy.m1808a(injectorLike, 10986), IdBasedLazy.m1808a(injectorLike, 10978), IdBasedLazy.m1808a(injectorLike, 10979), IdBasedLazy.m1808a(injectorLike, 11123), IdBasedLazy.m1808a(injectorLike, 11128), IdBasedLazy.m1808a(injectorLike, 11129), IdBasedLazy.m1808a(injectorLike, 11118), IdBasedSingletonScopeProvider.m1810b(injectorLike, 11122), IdBasedLazy.m1808a(injectorLike, 11408), IdBasedLazy.m1808a(injectorLike, 11426), IdBasedLazy.m1808a(injectorLike, 11549), IdBasedLazy.m1808a(injectorLike, 11635), IdBasedLazy.m1808a(injectorLike, 11656), IdBasedLazy.m1808a(injectorLike, 11657), IdBasedLazy.m1808a(injectorLike, 11800));
        return fragmentFactoryMapImpl;
    }

    private void m13796a(com.facebook.inject.Lazy<SocialSearchMapFragmentAndUriIntentBuilder> lazy, com.facebook.inject.Lazy<ProductGroupFragmentFactory> lazy2, com.facebook.inject.Lazy<AdminAddShopFragmentFactory> lazy3, com.facebook.inject.Lazy<AdminEditShopFragmentFactory> lazy4, com.facebook.inject.Lazy<AdminProductFragmentFactory> lazy5, com.facebook.inject.Lazy<AdCollectionViewFragmentFactory> lazy6, com.facebook.inject.Lazy<CollectionViewFragmentFactory> lazy7, com.facebook.inject.Lazy<StorefrontFragmentFactory> lazy8, com.facebook.inject.Lazy<ComposerTopicSelectorFragmentFactory> lazy9, com.facebook.inject.Lazy<FriendVoteInviteFragmentFactory> lazy10, com.facebook.inject.Lazy<HoursPickerFragmentFactory> lazy11, com.facebook.inject.Lazy<SuggestEditsFragmentFactory> lazy12, com.facebook.inject.Lazy<EventsCancelEventFragmentFactory> lazy13, com.facebook.inject.Lazy<EventCreationCategorySelectionFragmentFactory> lazy14, com.facebook.inject.Lazy<EventCreationHostSelectionFragmentFactory> lazy15, com.facebook.inject.Lazy<EventsDiscoveryFragmentFactory> lazy16, com.facebook.inject.Lazy<EventsDiscoveryLocationPickerFragmentFactory> lazy17, com.facebook.inject.Lazy<EventsDashboardFragmentFactory> lazy18, com.facebook.inject.Lazy<EventsDiscoveryUpcomingEventsFragmentFactory> lazy19, com.facebook.inject.Lazy<EventsUpcomingBirthdaysFragmentFactory> lazy20, com.facebook.inject.Lazy<EventsSubscriptionsFragmentFactory> lazy21, com.facebook.inject.Lazy<EventsSuggestionsFragmentFactory> lazy22, com.facebook.inject.Lazy<CaspianFriendSelectorFragmentFactory> lazy23, com.facebook.inject.Lazy<InviteeReviewModeFragmentFactory> lazy24, com.facebook.inject.Lazy<EventsPermalinkFragmentFactory> lazy25, com.facebook.inject.Lazy<EventGuestListFragmentFactory> lazy26, com.facebook.inject.Lazy<EventHostsFragmentFactory> lazy27, com.facebook.inject.Lazy<EventMessageFriendsFragmentFactory> lazy28, com.facebook.inject.Lazy<EventMessageGuestsFragmentFactory> lazy29, com.facebook.inject.Lazy<EventsNotificationSettingsFragmentFactory> lazy30, com.facebook.inject.Lazy<ImmersiveReactFragmentFactory> lazy31, com.facebook.inject.Lazy<AwesomizerFragmentFactory> lazy32, com.facebook.inject.Lazy<DiscoverFragmentFactory> lazy33, com.facebook.inject.Lazy<DiscoverTopicFragmentFactory> lazy34, com.facebook.inject.Lazy<RefollowFragmentFactory> lazy35, com.facebook.inject.Lazy<SeefirstFragmentFactory> lazy36, com.facebook.inject.Lazy<UnfollowFragmentFactory> lazy37, com.facebook.inject.Lazy<NewsFeedFragmentFactory> lazy38, com.facebook.inject.Lazy<EditHistoryFragmentFactory> lazy39, com.facebook.inject.Lazy<ProfileListFragmentFactory> lazy40, com.facebook.inject.Lazy<ReactorsListFragmentFactory> lazy41, com.facebook.inject.Lazy<CommentPermalinkFragmentFactory> lazy42, com.facebook.inject.Lazy<PermalinkFragmentFactory> lazy43, com.facebook.inject.Lazy<NewsFeedSwitcherFragmentFactory> lazy44, com.facebook.inject.Lazy<PromptFriendSelectorFragmentFactory> lazy45, com.facebook.inject.Lazy<FriendsCenterFragmentFactory> lazy46, com.facebook.inject.Lazy<ImmersivePeopleYouMayKnowFragmentFactory> lazy47, com.facebook.inject.Lazy<ProfileShareFragmentFactory> lazy48, com.facebook.inject.Lazy<FriendingSuggestionFragmentFactory> lazy49, com.facebook.inject.Lazy<FriendListFragmentFactory> lazy50, com.facebook.inject.Lazy<NearbyFriendsFragmentFactory> lazy51, com.facebook.inject.Lazy<NearbyFriendsInviteMultipickerFragmentFactory> lazy52, com.facebook.inject.Lazy<GametimeDashboardFragmentFactory> lazy53, com.facebook.inject.Lazy<GametimePlaysFragmentFactory> lazy54, com.facebook.inject.Lazy<AudienceFragmentFactory> lazy55, com.facebook.inject.Lazy<BirthdayCardFragmentFactory> lazy56, com.facebook.inject.Lazy<ThrowbackFeedFragmentFactory> lazy57, com.facebook.inject.Lazy<GroupsFileFragmentFactory> lazy58, com.facebook.inject.Lazy<GroupEditFavoritesFragmentFactory> lazy59, com.facebook.inject.Lazy<GroupEditNameDescFragmentFactory> lazy60, com.facebook.inject.Lazy<GroupEditPrivacyFragmentFactory> lazy61, com.facebook.inject.Lazy<GroupEditPurposeFragmentFactory> lazy62, com.facebook.inject.Lazy<GroupEditSettingsFragmentFactory> lazy63, com.facebook.inject.Lazy<GroupsEventsFragmentFactory> lazy64, com.facebook.inject.Lazy<FB4AAddToGroupsFragmentFactory> lazy65, com.facebook.inject.Lazy<FB4AGroupsCreateFragmentFactory> lazy66, com.facebook.inject.Lazy<FB4AGroupsCreationTabFragmentFactory> lazy67, com.facebook.inject.Lazy<FB4AGroupsDiscoverFragmentFactory> lazy68, com.facebook.inject.Lazy<FB4AGroupsGridFragmentFactory> lazy69, com.facebook.inject.Lazy<FB4AGroupsHubSearchFragmentFactory> lazy70, com.facebook.inject.Lazy<FB4AGroupsMemberPickerFragmentFactory> lazy71, com.facebook.inject.Lazy<GeneralGroupsReactFragmentFactory> lazy72, com.facebook.inject.Lazy<CrossGroupForSalePostsFragmentFactory> lazy73, com.facebook.inject.Lazy<GroupFeedFragmentFactory> lazy74, com.facebook.inject.Lazy<GroupForSalePostFragmentFactory> lazy75, com.facebook.inject.Lazy<GroupPendingPostsFragmentFactory> lazy76, com.facebook.inject.Lazy<GroupPinnedPostFragmentFactory> lazy77, com.facebook.inject.Lazy<GroupYourPostFragmentFactory> lazy78, com.facebook.inject.Lazy<GroupInfoFragmentFactory> lazy79, com.facebook.inject.Lazy<GroupReactReportedPostFragmentFactory> lazy80, com.facebook.inject.Lazy<GroupMembershipFragmentFactory> lazy81, com.facebook.inject.Lazy<GroupSuggestAdminFragmentFactory> lazy82, com.facebook.inject.Lazy<GroupsMemberRequestsFragmentFactory> lazy83, com.facebook.inject.Lazy<GroupAlbumFragmentFactory> lazy84, com.facebook.inject.Lazy<GroupsPhotosFragmentFactory> lazy85, com.facebook.inject.Lazy<GroupSubscriptionFragmentFactory> lazy86, com.facebook.inject.Lazy<GroupsStartSideConversationFragmentFactory> lazy87, com.facebook.inject.Lazy<FriendFinderIntroFragmentFactory> lazy88, com.facebook.inject.Lazy<BookmarkMenuFragmentFactory> lazy89, com.facebook.inject.Lazy<BookmarkSectionFragmentFactory> lazy90, com.facebook.inject.Lazy<FacewebFragmentFactory> lazy91, com.facebook.inject.Lazy<FriendRequestsFragmentFactory> lazy92, com.facebook.inject.Lazy<NearbyPlacesFragmentFactory> lazy93, com.facebook.inject.Lazy<UberbarFragmentFactory> lazy94, com.facebook.inject.Lazy<AddPhotoMenuFragmentFactory> lazy95, com.facebook.inject.Lazy<PageMenuManagementFragmentFactory> lazy96, com.facebook.inject.Lazy<PageMenuManagementLinkMenuFragmentFactory> lazy97, com.facebook.inject.Lazy<PagePhotoMenuFragmentFactory> lazy98, com.facebook.inject.Lazy<ShowAllPhotosByCategoryFragmentFactory> lazy99, com.facebook.inject.Lazy<StructuredMenuFragmentFactory> lazy100, com.facebook.inject.Lazy<LocationSettingsFragmentFactory> lazy101, com.facebook.inject.Lazy<LookNowPermalinkFragmentFactory> lazy102, com.facebook.inject.Lazy<GenericMapsFragmentAndUriIntentBuilder> lazy103, com.facebook.inject.Lazy<MarketplaceTabFragmentFactory> lazy104, com.facebook.inject.Lazy<NotificationSettingsFragmentFactory> lazy105, com.facebook.inject.Lazy<NotificationsFragmentFactory> lazy106, com.facebook.inject.Lazy<NotificationsFriendingFragmentFactory> lazy107, com.facebook.inject.Lazy<NotificationSettingsAlertsFragmentFactory> lazy108, com.facebook.inject.Lazy<OffersDetailPageFragmentFactory> lazy109, com.facebook.inject.Lazy<OffersWalletFragmentFactory> lazy110, com.facebook.inject.Lazy<PagesBrowserFragmentFactory> lazy111, com.facebook.inject.Lazy<PagesBrowserListFragmentFactory> lazy112, com.facebook.inject.Lazy<PageEditPageFragmentFactory> lazy113, com.facebook.inject.Lazy<PageFriendInviterFragmentFactory> lazy114, com.facebook.inject.Lazy<Fb4aPagesNotificationsFragmentFactory> lazy115, com.facebook.inject.Lazy<PageAlbumFragmentFactory> lazy116, com.facebook.inject.Lazy<PageCallToActionFragmentFactory> lazy117, com.facebook.inject.Lazy<PageChildLocationsFragmentFactory> lazy118, com.facebook.inject.Lazy<PageContactInboxFragmentFactory> lazy119, com.facebook.inject.Lazy<PageEventsListFragmentFactory> lazy120, com.facebook.inject.Lazy<PageIdentityFragmentFactory> lazy121, com.facebook.inject.Lazy<PageInformationFragmentFactory> lazy122, com.facebook.inject.Lazy<PageManagerCoverPhotoFragmentFactory> lazy123, com.facebook.inject.Lazy<PageReactionFragmentFactory> lazy124, com.facebook.inject.Lazy<PageResidenceFragmentFactory> lazy125, com.facebook.inject.Lazy<PageServiceFragmentFactory> lazy126, com.facebook.inject.Lazy<PageSingleServiceFragmentFactory> lazy127, com.facebook.inject.Lazy<PageVideoHubFragmentFactory> lazy128, com.facebook.inject.Lazy<PageVideoListAllVideosFragmentFactory> lazy129, com.facebook.inject.Lazy<PageVideoListFragmentFactory> lazy130, com.facebook.inject.Lazy<PageVistorPostsFragmentFactory> lazy131, com.facebook.inject.Lazy<PagesLaunchpointFragmentFactory> lazy132, com.facebook.inject.Lazy<CityPickerFragmentFactory> lazy133, com.facebook.inject.Lazy<CategoryPickerFragmentFactory> lazy134, com.facebook.inject.Lazy<PlaceTipsBlacklistConfirmationFragmentFactory> lazy135, com.facebook.inject.Lazy<PlaceTipsBlacklistPromptFragmentFactory> lazy136, com.facebook.inject.Lazy<PlaceTipsBlacklistReasonFragmentFactory> lazy137, com.facebook.inject.Lazy<PlaceTipsSettingsFragmentFactory> lazy138, com.facebook.inject.Lazy<UpsellFragmentFactory> lazy139, com.facebook.inject.Lazy<InfoRequestFragmentFactory> lazy140, com.facebook.inject.Lazy<QuickPromotionTabFragmentFactory> lazy141, com.facebook.inject.Lazy<ReactionDialogFragmentFactory> lazy142, com.facebook.inject.Lazy<ShowMoreAttachmentsFragmentFactory> lazy143, com.facebook.inject.Lazy<ShowMoreComponentsFragmentFactory> lazy144, com.facebook.inject.Lazy<RedSpaceFriendsOverflowFragmentFactory> lazy145, com.facebook.inject.Lazy<RedSpaceHomeFragmentFactory> lazy146, com.facebook.inject.Lazy<PageReviewsFragmentFactory> lazy147, com.facebook.inject.Lazy<UserReviewsFragmentFactory> lazy148, com.facebook.inject.Lazy<SavedFragmentFactory> lazy149, com.facebook.inject.Lazy<EntitiesFragmentFactory> lazy150, com.facebook.inject.Lazy<FeedFragmentFactory> lazy151, com.facebook.inject.Lazy<FilterTypeaheadFragmentFactory> lazy152, com.facebook.inject.Lazy<GraphSearchFragmentFactory> lazy153, com.facebook.inject.Lazy<LiveFeedFragmentFactory> lazy154, com.facebook.inject.Lazy<PandoraPhotosFragmentFactory> lazy155, com.facebook.inject.Lazy<PlacesFragmentFactory> lazy156, com.facebook.inject.Lazy<ResultsFragmentFactory> lazy157, com.facebook.inject.Lazy<SecurityCheckupPasswordChangeFragmentFactory> lazy158, com.facebook.inject.Lazy<FundraiserGuestListFragmentFactory> lazy159, com.facebook.inject.Lazy<FundraiserMessageGuestsFragmentFactory> lazy160, com.facebook.inject.Lazy<FundraiserPageInviterFragmentFactory> lazy161, com.facebook.inject.Lazy<FundraiserDonationFragmentFactory> lazy162, com.facebook.inject.Lazy<FundraiserPageFragmentFactory> lazy163, com.facebook.inject.Lazy<CollectionsCollectionFragmentFactory> lazy164, com.facebook.inject.Lazy<CollectionsSectionFragmentFactory> lazy165, com.facebook.inject.Lazy<CollectionsSummaryFragmentFactory> lazy166, com.facebook.inject.Lazy<CoverPhotoFragmentFactory> lazy167, com.facebook.inject.Lazy<TimelineFragmentFactory> lazy168, com.facebook.inject.Lazy<TodayFragmentFactory> lazy169, com.facebook.inject.Lazy<TopicCustomizationFragmentFactory> lazy170, com.facebook.inject.Lazy<MomentsUpsellPromotionFragmentFactory> lazy171, com.facebook.inject.Lazy<LiveMapFragmentFactory> lazy172, com.facebook.inject.Lazy<VideoHomeFragmentFactory> lazy173, com.facebook.inject.Lazy<VideoHomeGuideFragmentFactory> lazy174, com.facebook.inject.Lazy<CarrierManagerFragmentFactory> lazy175) {
        this.f8913a = lazy;
        this.f8914b = lazy2;
        this.f8915c = lazy3;
        this.f8916d = lazy4;
        this.f8917e = lazy5;
        this.f8918f = lazy6;
        this.f8919g = lazy7;
        this.f8920h = lazy8;
        this.f8921i = lazy9;
        this.f8922j = lazy10;
        this.f8923k = lazy11;
        this.f8924l = lazy12;
        this.f8925m = lazy13;
        this.f8926n = lazy14;
        this.f8927o = lazy15;
        this.f8928p = lazy16;
        this.f8929q = lazy17;
        this.f8930r = lazy18;
        this.f8931s = lazy19;
        this.f8932t = lazy20;
        this.f8933u = lazy21;
        this.f8934v = lazy22;
        this.f8935w = lazy23;
        this.f8936x = lazy24;
        this.f8937y = lazy25;
        this.f8938z = lazy26;
        this.f8887A = lazy27;
        this.f8888B = lazy28;
        this.f8889C = lazy29;
        this.f8890D = lazy30;
        this.f8891E = lazy31;
        this.f8892F = lazy32;
        this.f8893G = lazy33;
        this.f8894H = lazy34;
        this.f8895I = lazy35;
        this.f8896J = lazy36;
        this.f8897K = lazy37;
        this.f8898L = lazy38;
        this.f8899M = lazy39;
        this.f8900N = lazy40;
        this.f8901O = lazy41;
        this.f8902P = lazy42;
        this.f8903Q = lazy43;
        this.f8904R = lazy44;
        this.f8905S = lazy45;
        this.f8906T = lazy46;
        this.f8907U = lazy47;
        this.f8908V = lazy48;
        this.f8909W = lazy49;
        this.f8910X = lazy50;
        this.f8911Y = lazy51;
        this.f8912Z = lazy52;
        this.aa = lazy53;
        this.ab = lazy54;
        this.ac = lazy55;
        this.ad = lazy56;
        this.ae = lazy57;
        this.af = lazy58;
        this.ag = lazy59;
        this.ah = lazy60;
        this.ai = lazy61;
        this.aj = lazy62;
        this.ak = lazy63;
        this.al = lazy64;
        this.am = lazy65;
        this.an = lazy66;
        this.ao = lazy67;
        this.ap = lazy68;
        this.aq = lazy69;
        this.ar = lazy70;
        this.as = lazy71;
        this.at = lazy72;
        this.au = lazy73;
        this.av = lazy74;
        this.aw = lazy75;
        this.ax = lazy76;
        this.ay = lazy77;
        this.az = lazy78;
        this.aA = lazy79;
        this.aB = lazy80;
        this.aC = lazy81;
        this.aD = lazy82;
        this.aE = lazy83;
        this.aF = lazy84;
        this.aG = lazy85;
        this.aH = lazy86;
        this.aI = lazy87;
        this.aJ = lazy88;
        this.aK = lazy89;
        this.aL = lazy90;
        this.aM = lazy91;
        this.aN = lazy92;
        this.aO = lazy93;
        this.aP = lazy94;
        this.aQ = lazy95;
        this.aR = lazy96;
        this.aS = lazy97;
        this.aT = lazy98;
        this.aU = lazy99;
        this.aV = lazy100;
        this.aW = lazy101;
        this.aX = lazy102;
        this.aY = lazy103;
        this.aZ = lazy104;
        this.ba = lazy105;
        this.bb = lazy106;
        this.bc = lazy107;
        this.bd = lazy108;
        this.be = lazy109;
        this.bf = lazy110;
        this.bg = lazy111;
        this.bh = lazy112;
        this.bi = lazy113;
        this.bj = lazy114;
        this.bk = lazy115;
        this.bl = lazy116;
        this.bm = lazy117;
        this.bn = lazy118;
        this.bo = lazy119;
        this.bp = lazy120;
        this.bq = lazy121;
        this.br = lazy122;
        this.bs = lazy123;
        this.bt = lazy124;
        this.bu = lazy125;
        this.bv = lazy126;
        this.bw = lazy127;
        this.bx = lazy128;
        this.by = lazy129;
        this.bz = lazy130;
        this.bA = lazy131;
        this.bB = lazy132;
        this.bC = lazy133;
        this.bD = lazy134;
        this.bE = lazy135;
        this.bF = lazy136;
        this.bG = lazy137;
        this.bH = lazy138;
        this.bI = lazy139;
        this.bJ = lazy140;
        this.bK = lazy141;
        this.bL = lazy142;
        this.bM = lazy143;
        this.bN = lazy144;
        this.bO = lazy145;
        this.bP = lazy146;
        this.bQ = lazy147;
        this.bR = lazy148;
        this.bS = lazy149;
        this.bT = lazy150;
        this.bU = lazy151;
        this.bV = lazy152;
        this.bW = lazy153;
        this.bX = lazy154;
        this.bY = lazy155;
        this.bZ = lazy156;
        this.ca = lazy157;
        this.cb = lazy158;
        this.cc = lazy159;
        this.cd = lazy160;
        this.ce = lazy161;
        this.cf = lazy162;
        this.cg = lazy163;
        this.ch = lazy164;
        this.ci = lazy165;
        this.cj = lazy166;
        this.ck = lazy167;
        this.cl = lazy168;
        this.cm = lazy169;
        this.cn = lazy170;
        this.co = lazy171;
        this.cp = lazy172;
        this.cq = lazy173;
        this.cr = lazy174;
        this.cs = lazy175;
    }

    public final IFragmentFactory mo1879a(int i) {
        switch (i) {
            case 0:
                return (IFragmentFactory) this.aM.get();
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return (IFragmentFactory) this.f8893G.get();
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return (IFragmentFactory) this.f8892F.get();
            case 3:
                return (IFragmentFactory) this.f8895I.get();
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return (IFragmentFactory) this.f8896J.get();
            case 5:
                return (IFragmentFactory) this.f8897K.get();
            case 6:
                return (IFragmentFactory) this.f8898L.get();
            case 7:
                return (IFragmentFactory) this.f8903Q.get();
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return (IFragmentFactory) this.cl.get();
            case 9:
                return (IFragmentFactory) this.bq.get();
            case 11:
                return (IFragmentFactory) this.bg.get();
            case 12:
                return (IFragmentFactory) this.bh.get();
            case 15:
                return (IFragmentFactory) this.f8900N.get();
            case HTTPTransportCallback.HEADER_BYTES_GENERATED /*16*/:
                return (IFragmentFactory) this.f8901O.get();
            case 20:
                return (IFragmentFactory) this.aK.get();
            case 21:
                return (IFragmentFactory) this.aL.get();
            case 22:
                return (IFragmentFactory) this.bb.get();
            case 24:
                return (IFragmentFactory) this.bk.get();
            case 26:
                return (IFragmentFactory) this.aN.get();
            case 27:
                return (IFragmentFactory) this.f8906T.get();
            case 28:
                return (IFragmentFactory) this.f8899M.get();
            case 29:
                return (IFragmentFactory) this.aO.get();
            case 30:
                return (IFragmentFactory) this.aW.get();
            case 31:
                return (IFragmentFactory) this.bE.get();
            case HTTPTransportCallback.HEADER_BYTES_RECEIVED /*32*/:
                return (IFragmentFactory) this.bF.get();
            case 33:
                return (IFragmentFactory) this.bG.get();
            case 34:
                return (IFragmentFactory) this.bH.get();
            case 35:
                return (IFragmentFactory) this.f8911Y.get();
            case 36:
                return (IFragmentFactory) this.f8912Z.get();
            case 38:
                return (IFragmentFactory) this.bW.get();
            case 39:
                return (IFragmentFactory) this.aP.get();
            case 42:
                return (IFragmentFactory) this.cj.get();
            case 43:
                return (IFragmentFactory) this.ci.get();
            case 44:
                return (IFragmentFactory) this.ch.get();
            case 45:
                return (IFragmentFactory) this.aF.get();
            case 46:
                return (IFragmentFactory) this.aI.get();
            case 47:
                return (IFragmentFactory) this.ag.get();
            case 48:
                return (IFragmentFactory) this.al.get();
            case 49:
                return (IFragmentFactory) this.aC.get();
            case 50:
                return (IFragmentFactory) this.as.get();
            case 51:
                return (IFragmentFactory) this.aE.get();
            case 52:
                return (IFragmentFactory) this.ax.get();
            case 53:
                return (IFragmentFactory) this.aG.get();
            case 55:
                return (IFragmentFactory) this.aH.get();
            case 56:
                return (IFragmentFactory) this.aD.get();
            case 58:
                return (IFragmentFactory) this.am.get();
            case 59:
                return (IFragmentFactory) this.ap.get();
            case 60:
                return (IFragmentFactory) this.an.get();
            case 61:
                return (IFragmentFactory) this.aw.get();
            case 62:
                return (IFragmentFactory) this.av.get();
            case 63:
                return (IFragmentFactory) this.ay.get();
            case 66:
                return (IFragmentFactory) this.aq.get();
            case 67:
                return (IFragmentFactory) this.az.get();
            case 68:
                return (IFragmentFactory) this.br.get();
            case 69:
                return (IFragmentFactory) this.bu.get();
            case 71:
                return (IFragmentFactory) this.bK.get();
            case 73:
                return (IFragmentFactory) this.cs.get();
            case 74:
                return (IFragmentFactory) this.bQ.get();
            case 75:
                return (IFragmentFactory) this.bR.get();
            case 76:
                return (IFragmentFactory) this.bJ.get();
            case 77:
                return (IFragmentFactory) this.f8937y.get();
            case 78:
                return (IFragmentFactory) this.f8887A.get();
            case 79:
                return (IFragmentFactory) this.f8938z.get();
            case 80:
                return (IFragmentFactory) this.f8890D.get();
            case 83:
                return (IFragmentFactory) this.bS.get();
            case 85:
                return (IFragmentFactory) this.f8902P.get();
            case 86:
                return (IFragmentFactory) this.f8930r.get();
            case 87:
                return (IFragmentFactory) this.bn.get();
            case 89:
                return (IFragmentFactory) this.f8910X.get();
            case 91:
                return (IFragmentFactory) this.bl.get();
            case 92:
                return (IFragmentFactory) this.bx.get();
            case 93:
                return (IFragmentFactory) this.bL.get();
            case 94:
                return (IFragmentFactory) this.bt.get();
            case 95:
                return (IFragmentFactory) this.bM.get();
            case 99:
                return (IFragmentFactory) this.f8932t.get();
            case 101:
                return (IFragmentFactory) this.f8934v.get();
            case 103:
                return (IFragmentFactory) this.bX.get();
            case 104:
                return (IFragmentFactory) this.bU.get();
            case 105:
                return (IFragmentFactory) this.bT.get();
            case 107:
                return (IFragmentFactory) this.bY.get();
            case 108:
                return (IFragmentFactory) this.f8936x.get();
            case 110:
                return (IFragmentFactory) this.f8924l.get();
            case 111:
                return (IFragmentFactory) this.bC.get();
            case 112:
                return (IFragmentFactory) this.f8933u.get();
            case 113:
                return (IFragmentFactory) this.f8889C.get();
            case 114:
                return (IFragmentFactory) this.aV.get();
            case 115:
                return (IFragmentFactory) this.bD.get();
            case 116:
                return (IFragmentFactory) this.f8923k.get();
            case 117:
                return (IFragmentFactory) this.ae.get();
            case 118:
                return (IFragmentFactory) this.aU.get();
            case 119:
                return (IFragmentFactory) this.ck.get();
            case 120:
                return (IFragmentFactory) this.bs.get();
            case 122:
                return (IFragmentFactory) this.aT.get();
            case 123:
                return (IFragmentFactory) this.aQ.get();
            case 124:
                return (IFragmentFactory) this.f8914b.get();
            case 125:
                return (IFragmentFactory) this.f8917e.get();
            case 126:
                return (IFragmentFactory) this.bp.get();
            case 127:
                return (IFragmentFactory) this.f8920h.get();
            case HTTPTransportCallback.BODY_BYTES_RECEIVED /*128*/:
                return (IFragmentFactory) this.f8919g.get();
            case 129:
                return (IFragmentFactory) this.bz.get();
            case 130:
                return (IFragmentFactory) this.by.get();
            case 131:
                return (IFragmentFactory) this.f8935w.get();
            case 133:
                return (IFragmentFactory) this.aY.get();
            case 134:
                return (IFragmentFactory) this.bv.get();
            case 135:
                return (IFragmentFactory) this.ad.get();
            case 136:
                return (IFragmentFactory) this.bm.get();
            case 137:
                return (IFragmentFactory) this.bj.get();
            case 140:
                return (IFragmentFactory) this.bB.get();
            case 145:
                return (IFragmentFactory) this.cm.get();
            case 146:
                return (IFragmentFactory) this.f8918f.get();
            case 147:
                return (IFragmentFactory) this.cf.get();
            case 149:
                return (IFragmentFactory) this.aX.get();
            case 150:
                return (IFragmentFactory) this.f8909W.get();
            case 152:
                return (IFragmentFactory) this.bo.get();
            case 155:
                return (IFragmentFactory) this.af.get();
            case 156:
                return (IFragmentFactory) this.f8915c.get();
            case 157:
                return (IFragmentFactory) this.f8916d.get();
            case 158:
                return (IFragmentFactory) this.f8891E.get();
            case 159:
                return (IFragmentFactory) this.bi.get();
            case 160:
                return (IFragmentFactory) this.bO.get();
            case 161:
                return (IFragmentFactory) this.bP.get();
            case 164:
                return (IFragmentFactory) this.f8927o.get();
            case 165:
                return (IFragmentFactory) this.aA.get();
            case 166:
                return (IFragmentFactory) this.aB.get();
            case 167:
                return (IFragmentFactory) this.f8922j.get();
            case 168:
                return (IFragmentFactory) this.f8926n.get();
            case 170:
                return (IFragmentFactory) this.aR.get();
            case 171:
                return (IFragmentFactory) this.aS.get();
            case 172:
                return (IFragmentFactory) this.bI.get();
            case 173:
                return (IFragmentFactory) this.ak.get();
            case 174:
                return (IFragmentFactory) this.ai.get();
            case 175:
                return (IFragmentFactory) this.ah.get();
            case 176:
                return (IFragmentFactory) this.aj.get();
            case 177:
                return (IFragmentFactory) this.f8894H.get();
            case 181:
                return (IFragmentFactory) this.f8888B.get();
            case 182:
                return (IFragmentFactory) this.cb.get();
            case 183:
                return (IFragmentFactory) this.co.get();
            case 185:
                return (IFragmentFactory) this.f8928p.get();
            case 186:
                return (IFragmentFactory) this.bN.get();
            case 187:
                return (IFragmentFactory) this.f8929q.get();
            case 188:
                return (IFragmentFactory) this.f8904R.get();
            case 189:
                return (IFragmentFactory) this.f8907U.get();
            case 190:
                return (IFragmentFactory) this.f8908V.get();
            case 192:
                return (IFragmentFactory) this.bf.get();
            case 193:
                return (IFragmentFactory) this.be.get();
            case 194:
                return (IFragmentFactory) this.cn.get();
            case 195:
                return (IFragmentFactory) this.f8931s.get();
            case 196:
                return (IFragmentFactory) this.cg.get();
            case 197:
                return (IFragmentFactory) this.cq.get();
            case 198:
                return (IFragmentFactory) this.cr.get();
            case 200:
                return (IFragmentFactory) this.aZ.get();
            case 204:
                return (IFragmentFactory) this.ba.get();
            case 205:
                return (IFragmentFactory) this.aJ.get();
            case 221:
                return (IFragmentFactory) this.bc.get();
            case 222:
                return (IFragmentFactory) this.ar.get();
            case 223:
                return (IFragmentFactory) this.f8913a.get();
            case 224:
                return (IFragmentFactory) this.ce.get();
            case 225:
                return (IFragmentFactory) this.at.get();
            case 226:
                return (IFragmentFactory) this.f8921i.get();
            case 229:
                return (IFragmentFactory) this.bA.get();
            case 230:
                return (IFragmentFactory) this.f8925m.get();
            case 233:
                return (IFragmentFactory) this.bZ.get();
            case 234:
                return (IFragmentFactory) this.ca.get();
            case 235:
                return (IFragmentFactory) this.f8905S.get();
            case 237:
                return (IFragmentFactory) this.ab.get();
            case 238:
                return (IFragmentFactory) this.ao.get();
            case 239:
                return (IFragmentFactory) this.bV.get();
            case 240:
                return (IFragmentFactory) this.au.get();
            case 243:
                return (IFragmentFactory) this.cd.get();
            case 245:
                return (IFragmentFactory) this.cc.get();
            case 246:
                return (IFragmentFactory) this.ac.get();
            case 249:
                return (IFragmentFactory) this.bw.get();
            case 250:
                return (IFragmentFactory) this.bd.get();
            case 251:
                return (IFragmentFactory) this.aa.get();
            case 253:
                return (IFragmentFactory) this.cp.get();
            default:
                throw new NullPointerException("Cannot load fragment factory for fragment type : " + i);
        }
    }
}
