package com.facebook.interstitial.manager;

import com.facebook.adinterfaces.ui.preview.AdInterfacesResultsTooltipNuxController;
import com.facebook.appinvites.nux.AppInviteCaretNuxInterstitialController;
import com.facebook.appinvites.nux.AppInviteNuxInterstitialController;
import com.facebook.apptab.ui.nux.AppTabInterstitialController;
import com.facebook.backgroundlocation.nux.BackgroundLocationNuxInterstitialController;
import com.facebook.backstage.entry.BackstageOnboardInterstitialController;
import com.facebook.bookmark.nux.MessengerBookmarkNuxInterstitialController;
import com.facebook.browser.liteclient.nux.QuoteShareNuxController;
import com.facebook.composer.minutiae.interstitial.RidgeInterstitialController;
import com.facebook.composer.tip.FeedOnlyPostInterstitialController;
import com.facebook.composer.tip.MinutiaeNuxBubbleInterstitialController;
import com.facebook.composer.tip.PublishModeSelectorNuxBubbleInterstitialController;
import com.facebook.composer.tip.RidgeNuxBubbleInterstitialController;
import com.facebook.composer.tip.TopicComposerNuxInterstitialController;
import com.facebook.confirmation.interstitial.AccountConfirmationInterstitialController;
import com.facebook.devicebasedlogin.nux.DeviceBasedLoginNuxInterstitialController;
import com.facebook.devicebasedlogin.nux.DeviceBasedLoginNuxV2InterstitialController;
import com.facebook.events.create.ui.CoverPhotoSelectorThemeInterstitialController;
import com.facebook.events.invite.EventsExtendedInviteAddContactsButtonInterstitialController;
import com.facebook.events.invite.EventsExtendedInviteAddNoteButtonInterstitialController;
import com.facebook.events.invite.EventsExtendedInviteNoteInterstitialController;
import com.facebook.events.invite.EventsInviteThroughMessengerInterstitialController;
import com.facebook.events.permalink.guestlist.GuestListSeenStateInterstitialController;
import com.facebook.events.permalink.interestednux.InterestedNuxInterstitialController;
import com.facebook.events.ui.privacy.EventsPrivacyEducationInterstitialController;
import com.facebook.feed.diode.nux.FeedDiodeSwitcherInterstitialController;
import com.facebook.feed.nux.PrivacyEducationInterstitialController;
import com.facebook.feed.seefirst.SeeFirstNuxInterstitialController;
import com.facebook.feed.topicfeeds.nux.TopicFeedsCustomizationInterstitialController;
import com.facebook.feed.topicfeeds.nux.TopicFeedsSwitcherInterstitialController;
import com.facebook.feed.topicfeeds.nux.TopicFeedsTooltipInterstitialController;
import com.facebook.feedback.ui.CommentDraftEducationInterstitialController;
import com.facebook.feedback.ui.VideoCommentInterstitialController;
import com.facebook.feedback.ui.nux.CommentReactionsNuxInterstitialController;
import com.facebook.feedplugins.feedbackreactions.ui.nux.ReactionsLaunchNuxInterstitialController;
import com.facebook.feedplugins.feedbackreactions.ui.nux.ReactionsRetargetNuxInterstitialController;
import com.facebook.feedplugins.pymk.quickpromotion.QuickPromotionFeedPYMKController;
import com.facebook.feedplugins.saved.nux.SavedCaretNuxInterstitialController;
import com.facebook.feedplugins.saved.nux.SavedOnlyMeShareNuxInterstitialController;
import com.facebook.groups.fb4a.groupshub.nux.FB4AGroupsDiscoverToolTipInterstitialController;
import com.facebook.groups.feed.ui.nux.GroupsSeedsComposerNuxInterstitialController;
import com.facebook.groups.feed.ui.nux.GroupsSeedsComposerSellSomethingNuxInterstitialController;
import com.facebook.groups.memberlist.nux.GroupsMultiTierAdminNuxInterstitialController;
import com.facebook.growth.interstitial.UserAccountNUXInterstitialController;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.instantshopping.view.block.impl.SaveNuxInterstitialController;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.localcontent.menus.nux.AddPhotoMenuMoreTabNuxController;
import com.facebook.maps.HereMapsUpsellInterstitialController;
import com.facebook.messaging.nativesurvey.MessengerSurveyInterstitialController;
import com.facebook.messaging.photoreminders.PhotoRemindersNuxInterstitialController;
import com.facebook.messaging.quickpromotion.QuickPromotionMessengerInterstitialController;
import com.facebook.messaging.quickpromotion.QuickPromotionThreadListBannerController;
import com.facebook.messaging.quickpromotion.QuickPromotionThreadViewBannerController;
import com.facebook.notifications.nux.NotificationsInlineFeedbackNuxInterstitialController;
import com.facebook.notifications.nux.NotificationsInlineNotificationNuxController;
import com.facebook.nux.interstitial.FollowVideosButtonNuxBubbleInterstitialController;
import com.facebook.nux.interstitial.MusicPreviewNuxBubbleInterstitialController;
import com.facebook.nux.interstitial.PageStoryAdminAtrributionNuxInterstitialController;
import com.facebook.nux.interstitial.SaveNuxBubbleInterstitialController;
import com.facebook.nux.interstitial.SeeFirstPromptNuxController;
import com.facebook.pages.common.surface.calltoaction.PageCallToActionButtonNuxController;
import com.facebook.pages.identity.cards.actionbar.PageMessageButtonNuxInterstitialController;
import com.facebook.photos.mediagallery.ui.widget.ViewerSuggestLocationInterstitialController;
import com.facebook.photos.simplepicker.nux.SimplePickerHDUploadInterstitialController;
import com.facebook.photos.simplepicker.nux.SimplePickerMultimediaInterstitialController;
import com.facebook.photos.simplepicker.nux.SimplePickerSlideshowInterstitialController;
import com.facebook.photos.simplepicker.nux.SimplePickerSouvenirInterstitialController;
import com.facebook.placetips.upsell.OnLoginGmsLsUpsellInterstitialController;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.quickpromotion.ui.QuickPromotionDiveBarController;
import com.facebook.quickpromotion.ui.QuickPromotionFooterController;
import com.facebook.quickpromotion.ui.QuickPromotionMultiPageInterstitialController;
import com.facebook.quickpromotion.ui.QuickPromotionToastFooterController;
import com.facebook.quickpromotion.ui.fb4a.QuickPromotionInterstitialControllerForFb4a;
import com.facebook.quickpromotion.ui.fb4a.QuickPromotionMegaphoneControllerForFb4a;
import com.facebook.quickpromotion.ui.fb4a.QuickPromotionThreadListInterstitialControllerForFb4a;
import com.facebook.rapidfeedback.nux.RapidFeedbackNuxInterstitialController;
import com.facebook.redspace.nux.RedSpaceDivebarInterstitialController;
import com.facebook.redspace.nux.RedSpaceInterstitialController;
import com.facebook.richdocument.nux.InstantArticleIconInterstitialController;
import com.facebook.saved.common.nux.DownloadVideoBookmarksNuxInterstitialController;
import com.facebook.saved.common.nux.SavedBookmarksNuxInterstitialController;
import com.facebook.saved.interstitial.SavedDashboardInterstitialController;
import com.facebook.search.quickpromotion.QuickPromotionSearchBarTooltipController;
import com.facebook.search.quickpromotion.QuickPromotionSearchMegaphoneController;
import com.facebook.search.quickpromotion.ScopedSearchGroupsNuxController;
import com.facebook.search.quickpromotion.SearchTrendingAwarenessNuxInterstitialController;
import com.facebook.search.quickpromotion.TutorialNuxInterstitialController;
import com.facebook.survey.interstitial.SurveyDialogInterstitialController;
import com.facebook.tablet.sideshow.nux.PortraitSideshowNuxInterstitialController;
import com.facebook.timeline.actionbar.TimelineActionBarManageButtonNuxController;
import com.facebook.timeline.header.ProfilePicUnifiedEditingNuxInterstitialController;
import com.facebook.timeline.header.ProfilePictureNuxBubbleInterstitialController;
import com.facebook.timeline.header.ProfileVideoNuxInterstitialController;
import com.facebook.timeline.header.ProfileVideoTrimmerNuxInterstitialController;
import com.facebook.timeline.header.TempProfilePicNuxInterstitialController;
import com.facebook.timeline.header.bio.TimelineHeaderBioPostToFeedNuxInterstitialController;
import com.facebook.timeline.header.bio.TimelineHeaderSuggestedBioNuxInterstitialController;
import com.facebook.timeline.header.controllers.TimelineIntroCardNuxInterstitialController;
import com.facebook.timeline.header.favphotos.TimelineHeaderFavPhotosPostToFeedNuxInterstitialController;
import com.facebook.timeline.header.favphotos.TimelineHeaderSuggestedPhotosNuxInterstitialController;
import com.facebook.timeline.viewfeaturedcontainers.nux.FeaturedHeaderNuxInterstitialController;
import com.facebook.video.settings.AutoplayRolloutNuxController;
import com.facebook.video.videohome.nux.VideoHomeTabToolTipNuxController;
import com.facebook.zero.interstitial.ZeroInterstitialController;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: social_context */
public final class InterstitialControllersHolderImpl extends InterstitialControllersHolder {
    private final Lazy<PrivacyEducationInterstitialController> f4409A;
    private final Lazy<SeeFirstNuxInterstitialController> f4410B;
    private final Lazy<TopicFeedsCustomizationInterstitialController> f4411C;
    private final Lazy<TopicFeedsSwitcherInterstitialController> f4412D;
    private final Lazy<TopicFeedsTooltipInterstitialController> f4413E;
    private final Lazy<CommentDraftEducationInterstitialController> f4414F;
    private final Lazy<VideoCommentInterstitialController> f4415G;
    private final Lazy<CommentReactionsNuxInterstitialController> f4416H;
    private final Lazy<ReactionsLaunchNuxInterstitialController> f4417I;
    private final Lazy<ReactionsRetargetNuxInterstitialController> f4418J;
    private final Lazy<QuickPromotionFeedPYMKController> f4419K;
    private final Lazy<SavedCaretNuxInterstitialController> f4420L;
    private final Lazy<SavedOnlyMeShareNuxInterstitialController> f4421M;
    private final Lazy<FB4AGroupsDiscoverToolTipInterstitialController> f4422N;
    private final Lazy<GroupsSeedsComposerNuxInterstitialController> f4423O;
    private final Lazy<GroupsSeedsComposerSellSomethingNuxInterstitialController> f4424P;
    private final Lazy<GroupsMultiTierAdminNuxInterstitialController> f4425Q;
    private final Lazy<UserAccountNUXInterstitialController> f4426R;
    private final Lazy<SaveNuxInterstitialController> f4427S;
    private final Lazy<AddPhotoMenuMoreTabNuxController> f4428T;
    private final Lazy<HereMapsUpsellInterstitialController> f4429U;
    private final Lazy<MessengerSurveyInterstitialController> f4430V;
    private final Lazy<PhotoRemindersNuxInterstitialController> f4431W;
    private final Lazy<QuickPromotionMessengerInterstitialController> f4432X;
    private final Lazy<QuickPromotionThreadListBannerController> f4433Y;
    private final Lazy<QuickPromotionThreadViewBannerController> f4434Z;
    private final Lazy<AdInterfacesResultsTooltipNuxController> f4435a;
    private final Lazy<DownloadVideoBookmarksNuxInterstitialController> aA;
    private final Lazy<SavedBookmarksNuxInterstitialController> aB;
    private final Lazy<SavedDashboardInterstitialController> aC;
    private final Lazy<QuickPromotionSearchBarTooltipController> aD;
    private final Lazy<QuickPromotionSearchMegaphoneController> aE;
    private final Lazy<ScopedSearchGroupsNuxController> aF;
    private final Lazy<SearchTrendingAwarenessNuxInterstitialController> aG;
    private final Lazy<TutorialNuxInterstitialController> aH;
    private final Lazy<SurveyDialogInterstitialController> aI;
    private final Lazy<PortraitSideshowNuxInterstitialController> aJ;
    private final Lazy<TimelineActionBarManageButtonNuxController> aK;
    private final Lazy<ProfilePicUnifiedEditingNuxInterstitialController> aL;
    private final Lazy<ProfilePictureNuxBubbleInterstitialController> aM;
    private final Lazy<ProfileVideoNuxInterstitialController> aN;
    private final Lazy<ProfileVideoTrimmerNuxInterstitialController> aO;
    private final Lazy<TempProfilePicNuxInterstitialController> aP;
    private final Lazy<TimelineHeaderBioPostToFeedNuxInterstitialController> aQ;
    private final Lazy<TimelineHeaderSuggestedBioNuxInterstitialController> aR;
    private final Lazy<TimelineIntroCardNuxInterstitialController> aS;
    private final Lazy<TimelineHeaderFavPhotosPostToFeedNuxInterstitialController> aT;
    private final Lazy<TimelineHeaderSuggestedPhotosNuxInterstitialController> aU;
    private final Lazy<FeaturedHeaderNuxInterstitialController> aV;
    private final Lazy<AutoplayRolloutNuxController> aW;
    private final Lazy<VideoHomeTabToolTipNuxController> aX;
    private final Lazy<ZeroInterstitialController> aY;
    private Collection<String> aZ = null;
    private final Lazy<NotificationsInlineFeedbackNuxInterstitialController> aa;
    private final Lazy<NotificationsInlineNotificationNuxController> ab;
    private final Lazy<FollowVideosButtonNuxBubbleInterstitialController> ac;
    private final Lazy<MusicPreviewNuxBubbleInterstitialController> ad;
    private final Lazy<PageStoryAdminAtrributionNuxInterstitialController> ae;
    private final Lazy<SaveNuxBubbleInterstitialController> af;
    private final Lazy<SeeFirstPromptNuxController> ag;
    private final Lazy<PageCallToActionButtonNuxController> ah;
    private final Lazy<PageMessageButtonNuxInterstitialController> ai;
    private final Lazy<ViewerSuggestLocationInterstitialController> aj;
    private final Lazy<SimplePickerHDUploadInterstitialController> ak;
    private final Lazy<SimplePickerMultimediaInterstitialController> al;
    private final Lazy<SimplePickerSlideshowInterstitialController> am;
    private final Lazy<SimplePickerSouvenirInterstitialController> an;
    private final Lazy<OnLoginGmsLsUpsellInterstitialController> ao;
    private final Lazy<QuickPromotionDiveBarController> ap;
    private final Lazy<QuickPromotionFooterController> aq;
    private final Lazy<QuickPromotionMultiPageInterstitialController> ar;
    private final Lazy<QuickPromotionToastFooterController> as;
    private final Lazy<QuickPromotionInterstitialControllerForFb4a> at;
    private final Lazy<QuickPromotionMegaphoneControllerForFb4a> au;
    private final Lazy<QuickPromotionThreadListInterstitialControllerForFb4a> av;
    private final Lazy<RapidFeedbackNuxInterstitialController> aw;
    private final Lazy<RedSpaceDivebarInterstitialController> ax;
    private final Lazy<RedSpaceInterstitialController> ay;
    private final Lazy<InstantArticleIconInterstitialController> az;
    private final Lazy<AppInviteCaretNuxInterstitialController> f4436b;
    private Collection<String> ba = null;
    private Multimap<Action, String> bb = null;
    private final Lazy<AppInviteNuxInterstitialController> f4437c;
    private final Lazy<AppTabInterstitialController> f4438d;
    private final Lazy<BackgroundLocationNuxInterstitialController> f4439e;
    private final Lazy<BackstageOnboardInterstitialController> f4440f;
    private final Lazy<MessengerBookmarkNuxInterstitialController> f4441g;
    private final Lazy<QuoteShareNuxController> f4442h;
    private final Lazy<RidgeInterstitialController> f4443i;
    private final Lazy<FeedOnlyPostInterstitialController> f4444j;
    private final Lazy<MinutiaeNuxBubbleInterstitialController> f4445k;
    private final Lazy<PublishModeSelectorNuxBubbleInterstitialController> f4446l;
    private final Lazy<RidgeNuxBubbleInterstitialController> f4447m;
    private final Lazy<TopicComposerNuxInterstitialController> f4448n;
    private final Lazy<AccountConfirmationInterstitialController> f4449o;
    private final Lazy<DeviceBasedLoginNuxInterstitialController> f4450p;
    private final Lazy<DeviceBasedLoginNuxV2InterstitialController> f4451q;
    private final Lazy<CoverPhotoSelectorThemeInterstitialController> f4452r;
    private final Lazy<EventsExtendedInviteAddContactsButtonInterstitialController> f4453s;
    private final Lazy<EventsExtendedInviteAddNoteButtonInterstitialController> f4454t;
    private final Lazy<EventsExtendedInviteNoteInterstitialController> f4455u;
    private final Lazy<EventsInviteThroughMessengerInterstitialController> f4456v;
    private final Lazy<GuestListSeenStateInterstitialController> f4457w;
    private final Lazy<InterestedNuxInterstitialController> f4458x;
    private final Lazy<EventsPrivacyEducationInterstitialController> f4459y;
    private final Lazy<FeedDiodeSwitcherInterstitialController> f4460z;

    public static InterstitialControllersHolderImpl m8129b(InjectorLike injectorLike) {
        return new InterstitialControllersHolderImpl(IdBasedLazy.m1808a(injectorLike, 108), IdBasedLazy.m1808a(injectorLike, 283), IdBasedLazy.m1808a(injectorLike, 284), IdBasedSingletonScopeProvider.m1810b(injectorLike, 303), IdBasedSingletonScopeProvider.m1810b(injectorLike, 4913), IdBasedLazy.m1808a(injectorLike, 4955), IdBasedLazy.m1808a(injectorLike, 4991), IdBasedLazy.m1808a(injectorLike, 414), IdBasedLazy.m1808a(injectorLike, 5241), IdBasedLazy.m1808a(injectorLike, 5292), IdBasedLazy.m1808a(injectorLike, 5293), IdBasedLazy.m1808a(injectorLike, 868), IdBasedLazy.m1808a(injectorLike, 5294), IdBasedLazy.m1808a(injectorLike, 5295), IdBasedLazy.m1808a(injectorLike, 5314), IdBasedLazy.m1808a(injectorLike, 5477), IdBasedLazy.m1808a(injectorLike, 5478), IdBasedLazy.m1808a(injectorLike, 1124), IdBasedLazy.m1808a(injectorLike, 5607), IdBasedLazy.m1808a(injectorLike, 1127), IdBasedLazy.m1808a(injectorLike, 1128), IdBasedLazy.m1808a(injectorLike, 1129), IdBasedLazy.m1808a(injectorLike, 1130), IdBasedLazy.m1808a(injectorLike, 1131), IdBasedLazy.m1808a(injectorLike, 1132), IdBasedLazy.m1808a(injectorLike, 5842), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1449), IdBasedLazy.m1808a(injectorLike, 6050), IdBasedLazy.m1808a(injectorLike, 6068), IdBasedLazy.m1808a(injectorLike, 6069), IdBasedLazy.m1808a(injectorLike, 6070), IdBasedLazy.m1808a(injectorLike, 1793), IdBasedLazy.m1808a(injectorLike, 6130), IdBasedSingletonScopeProvider.m1810b(injectorLike, 6131), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1854), IdBasedSingletonScopeProvider.m1810b(injectorLike, 6217), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1971), IdBasedLazy.m1808a(injectorLike, 2012), IdBasedLazy.m1808a(injectorLike, 2013), IdBasedLazy.m1808a(injectorLike, 6938), IdBasedLazy.m1808a(injectorLike, 2204), IdBasedLazy.m1808a(injectorLike, 6996), IdBasedLazy.m1808a(injectorLike, 7046), IdBasedSingletonScopeProvider.m1810b(injectorLike, 7138), IdBasedLazy.m1808a(injectorLike, 7259), IdBasedLazy.m1808a(injectorLike, 7437), IdBasedLazy.m1808a(injectorLike, 2527), IdBasedLazy.m1808a(injectorLike, 7995), IdBasedLazy.m1808a(injectorLike, 8281), IdBasedSingletonScopeProvider.m1810b(injectorLike, 8320), IdBasedLazy.m1808a(injectorLike, 8321), IdBasedLazy.m1808a(injectorLike, 8322), IdBasedSingletonScopeProvider.m1810b(injectorLike, 8709), IdBasedLazy.m1808a(injectorLike, 2814), IdBasedLazy.m1808a(injectorLike, 2846), IdBasedSingletonScopeProvider.m1810b(injectorLike, 8748), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2847), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2849), IdBasedLazy.m1808a(injectorLike, 8750), IdBasedLazy.m1808a(injectorLike, 2942), IdBasedLazy.m1808a(injectorLike, 2943), IdBasedLazy.m1808a(injectorLike, 9368), IdBasedLazy.m1808a(injectorLike, 9428), IdBasedLazy.m1808a(injectorLike, 2979), IdBasedLazy.m1808a(injectorLike, 9429), IdBasedLazy.m1808a(injectorLike, 2980), IdBasedLazy.m1808a(injectorLike, 9618), IdBasedSingletonScopeProvider.m1810b(injectorLike, 9820), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3242), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3243), IdBasedSingletonScopeProvider.m1810b(injectorLike, 9824), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3244), IdBasedLazy.m1808a(injectorLike, 3245), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3246), IdBasedLazy.m1808a(injectorLike, 9831), IdBasedLazy.m1808a(injectorLike, 10202), IdBasedLazy.m1808a(injectorLike, 10203), IdBasedLazy.m1808a(injectorLike, 10344), IdBasedSingletonScopeProvider.m1810b(injectorLike, 10399), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3367), IdBasedLazy.m1808a(injectorLike, 10428), IdBasedLazy.m1808a(injectorLike, 3382), IdBasedLazy.m1808a(injectorLike, 10515), IdBasedLazy.m1808a(injectorLike, 10516), IdBasedLazy.m1808a(injectorLike, 10526), IdBasedLazy.m1808a(injectorLike, 10527), IdBasedLazy.m1808a(injectorLike, 11049), IdBasedLazy.m1808a(injectorLike, 3492), IdBasedLazy.m1808a(injectorLike, 11153), IdBasedLazy.m1808a(injectorLike, 3500), IdBasedLazy.m1808a(injectorLike, 3501), IdBasedLazy.m1808a(injectorLike, 3502), IdBasedLazy.m1808a(injectorLike, 11248), IdBasedLazy.m1808a(injectorLike, 3503), IdBasedLazy.m1808a(injectorLike, 3504), IdBasedLazy.m1808a(injectorLike, 3505), IdBasedLazy.m1808a(injectorLike, 3506), IdBasedLazy.m1808a(injectorLike, 11273), IdBasedLazy.m1808a(injectorLike, 3507), IdBasedLazy.m1808a(injectorLike, 11403), IdBasedLazy.m1808a(injectorLike, 11643), IdBasedLazy.m1808a(injectorLike, 3712), IdBasedLazy.m1808a(injectorLike, 11819));
    }

    @Inject
    public InterstitialControllersHolderImpl(Lazy<AdInterfacesResultsTooltipNuxController> lazy, Lazy<AppInviteCaretNuxInterstitialController> lazy2, Lazy<AppInviteNuxInterstitialController> lazy3, Lazy<AppTabInterstitialController> lazy4, Lazy<BackgroundLocationNuxInterstitialController> lazy5, Lazy<BackstageOnboardInterstitialController> lazy6, Lazy<MessengerBookmarkNuxInterstitialController> lazy7, Lazy<QuoteShareNuxController> lazy8, Lazy<RidgeInterstitialController> lazy9, Lazy<FeedOnlyPostInterstitialController> lazy10, Lazy<MinutiaeNuxBubbleInterstitialController> lazy11, Lazy<PublishModeSelectorNuxBubbleInterstitialController> lazy12, Lazy<RidgeNuxBubbleInterstitialController> lazy13, Lazy<TopicComposerNuxInterstitialController> lazy14, Lazy<AccountConfirmationInterstitialController> lazy15, Lazy<DeviceBasedLoginNuxInterstitialController> lazy16, Lazy<DeviceBasedLoginNuxV2InterstitialController> lazy17, Lazy<CoverPhotoSelectorThemeInterstitialController> lazy18, Lazy<EventsExtendedInviteAddContactsButtonInterstitialController> lazy19, Lazy<EventsExtendedInviteAddNoteButtonInterstitialController> lazy20, Lazy<EventsExtendedInviteNoteInterstitialController> lazy21, Lazy<EventsInviteThroughMessengerInterstitialController> lazy22, Lazy<GuestListSeenStateInterstitialController> lazy23, Lazy<InterestedNuxInterstitialController> lazy24, Lazy<EventsPrivacyEducationInterstitialController> lazy25, Lazy<FeedDiodeSwitcherInterstitialController> lazy26, Lazy<PrivacyEducationInterstitialController> lazy27, Lazy<SeeFirstNuxInterstitialController> lazy28, Lazy<TopicFeedsCustomizationInterstitialController> lazy29, Lazy<TopicFeedsSwitcherInterstitialController> lazy30, Lazy<TopicFeedsTooltipInterstitialController> lazy31, Lazy<CommentDraftEducationInterstitialController> lazy32, Lazy<VideoCommentInterstitialController> lazy33, Lazy<CommentReactionsNuxInterstitialController> lazy34, Lazy<ReactionsLaunchNuxInterstitialController> lazy35, Lazy<ReactionsRetargetNuxInterstitialController> lazy36, Lazy<QuickPromotionFeedPYMKController> lazy37, Lazy<SavedCaretNuxInterstitialController> lazy38, Lazy<SavedOnlyMeShareNuxInterstitialController> lazy39, Lazy<FB4AGroupsDiscoverToolTipInterstitialController> lazy40, Lazy<GroupsSeedsComposerNuxInterstitialController> lazy41, Lazy<GroupsSeedsComposerSellSomethingNuxInterstitialController> lazy42, Lazy<GroupsMultiTierAdminNuxInterstitialController> lazy43, Lazy<UserAccountNUXInterstitialController> lazy44, Lazy<SaveNuxInterstitialController> lazy45, Lazy<AddPhotoMenuMoreTabNuxController> lazy46, Lazy<HereMapsUpsellInterstitialController> lazy47, Lazy<MessengerSurveyInterstitialController> lazy48, Lazy<PhotoRemindersNuxInterstitialController> lazy49, Lazy<QuickPromotionMessengerInterstitialController> lazy50, Lazy<QuickPromotionThreadListBannerController> lazy51, Lazy<QuickPromotionThreadViewBannerController> lazy52, Lazy<NotificationsInlineFeedbackNuxInterstitialController> lazy53, Lazy<NotificationsInlineNotificationNuxController> lazy54, Lazy<FollowVideosButtonNuxBubbleInterstitialController> lazy55, Lazy<MusicPreviewNuxBubbleInterstitialController> lazy56, Lazy<PageStoryAdminAtrributionNuxInterstitialController> lazy57, Lazy<SaveNuxBubbleInterstitialController> lazy58, Lazy<SeeFirstPromptNuxController> lazy59, Lazy<PageCallToActionButtonNuxController> lazy60, Lazy<PageMessageButtonNuxInterstitialController> lazy61, Lazy<ViewerSuggestLocationInterstitialController> lazy62, Lazy<SimplePickerHDUploadInterstitialController> lazy63, Lazy<SimplePickerMultimediaInterstitialController> lazy64, Lazy<SimplePickerSlideshowInterstitialController> lazy65, Lazy<SimplePickerSouvenirInterstitialController> lazy66, Lazy<OnLoginGmsLsUpsellInterstitialController> lazy67, Lazy<QuickPromotionDiveBarController> lazy68, Lazy<QuickPromotionFooterController> lazy69, Lazy<QuickPromotionMultiPageInterstitialController> lazy70, Lazy<QuickPromotionToastFooterController> lazy71, Lazy<QuickPromotionInterstitialControllerForFb4a> lazy72, Lazy<QuickPromotionMegaphoneControllerForFb4a> lazy73, Lazy<QuickPromotionThreadListInterstitialControllerForFb4a> lazy74, Lazy<RapidFeedbackNuxInterstitialController> lazy75, Lazy<RedSpaceDivebarInterstitialController> lazy76, Lazy<RedSpaceInterstitialController> lazy77, Lazy<InstantArticleIconInterstitialController> lazy78, Lazy<DownloadVideoBookmarksNuxInterstitialController> lazy79, Lazy<SavedBookmarksNuxInterstitialController> lazy80, Lazy<SavedDashboardInterstitialController> lazy81, Lazy<QuickPromotionSearchBarTooltipController> lazy82, Lazy<QuickPromotionSearchMegaphoneController> lazy83, Lazy<ScopedSearchGroupsNuxController> lazy84, Lazy<SearchTrendingAwarenessNuxInterstitialController> lazy85, Lazy<TutorialNuxInterstitialController> lazy86, Lazy<SurveyDialogInterstitialController> lazy87, Lazy<PortraitSideshowNuxInterstitialController> lazy88, Lazy<TimelineActionBarManageButtonNuxController> lazy89, Lazy<ProfilePicUnifiedEditingNuxInterstitialController> lazy90, Lazy<ProfilePictureNuxBubbleInterstitialController> lazy91, Lazy<ProfileVideoNuxInterstitialController> lazy92, Lazy<ProfileVideoTrimmerNuxInterstitialController> lazy93, Lazy<TempProfilePicNuxInterstitialController> lazy94, Lazy<TimelineHeaderBioPostToFeedNuxInterstitialController> lazy95, Lazy<TimelineHeaderSuggestedBioNuxInterstitialController> lazy96, Lazy<TimelineIntroCardNuxInterstitialController> lazy97, Lazy<TimelineHeaderFavPhotosPostToFeedNuxInterstitialController> lazy98, Lazy<TimelineHeaderSuggestedPhotosNuxInterstitialController> lazy99, Lazy<FeaturedHeaderNuxInterstitialController> lazy100, Lazy<AutoplayRolloutNuxController> lazy101, Lazy<VideoHomeTabToolTipNuxController> lazy102, Lazy<ZeroInterstitialController> lazy103) {
        this.f4435a = lazy;
        this.f4436b = lazy2;
        this.f4437c = lazy3;
        this.f4438d = lazy4;
        this.f4439e = lazy5;
        this.f4440f = lazy6;
        this.f4441g = lazy7;
        this.f4442h = lazy8;
        this.f4443i = lazy9;
        this.f4444j = lazy10;
        this.f4445k = lazy11;
        this.f4446l = lazy12;
        this.f4447m = lazy13;
        this.f4448n = lazy14;
        this.f4449o = lazy15;
        this.f4450p = lazy16;
        this.f4451q = lazy17;
        this.f4452r = lazy18;
        this.f4453s = lazy19;
        this.f4454t = lazy20;
        this.f4455u = lazy21;
        this.f4456v = lazy22;
        this.f4457w = lazy23;
        this.f4458x = lazy24;
        this.f4459y = lazy25;
        this.f4460z = lazy26;
        this.f4409A = lazy27;
        this.f4410B = lazy28;
        this.f4411C = lazy29;
        this.f4412D = lazy30;
        this.f4413E = lazy31;
        this.f4414F = lazy32;
        this.f4415G = lazy33;
        this.f4416H = lazy34;
        this.f4417I = lazy35;
        this.f4418J = lazy36;
        this.f4419K = lazy37;
        this.f4420L = lazy38;
        this.f4421M = lazy39;
        this.f4422N = lazy40;
        this.f4423O = lazy41;
        this.f4424P = lazy42;
        this.f4425Q = lazy43;
        this.f4426R = lazy44;
        this.f4427S = lazy45;
        this.f4428T = lazy46;
        this.f4429U = lazy47;
        this.f4430V = lazy48;
        this.f4431W = lazy49;
        this.f4432X = lazy50;
        this.f4433Y = lazy51;
        this.f4434Z = lazy52;
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
    }

    public final synchronized Collection<String> mo1203a() {
        if (this.aZ == null) {
            this.aZ = Collections.unmodifiableList(Arrays.asList(new String[]{"3960", "3078", "3205", "1862", "1631", "4063", "3086", "4174", "2326", "4155", "2923", "2752", "2377", "4096", "1907", "2504", "4196", "3819", "4157", "4158", "4159", "3936", "3763", "3884", "3764", "4212", "2551", "3193", "4066", "4060", "4153", "3746", "4181", "4239", "3754", "4131", "3279", "2862", "3909", "4207", "3775", "3908", "4136", "1630", "3903", "3395", "3127", "3171", "3923", "2415", "3543", "3545", "3809", "4127", "4141", "2438", "2449", "2447", "3573", "3795", "3641", "4003", "4169", "3883", "4194", "3993", "3931", "1824", "1820", "2610", "3248", "1818", "1822", "1957", "3184", "4093", "3949", "3838", "4163", "3907", "2607", "3877", "3191", "3747", "3699", "4084", "1803", "3417", "3226", "3887", "3336", "3972", "4101", "3876", "4079", "4058", "3621", "4075", "4017", "4139", "3507", "4111", "1710"}));
        }
        return this.aZ;
    }

    public final synchronized Collection<String> mo1205b() {
        if (this.ba == null) {
            this.ba = Collections.unmodifiableList(Arrays.asList(new String[]{"1907", "2504", "4196", "1630", "3931"}));
        }
        return this.ba;
    }

    @Nullable
    public final InterstitialController mo1202a(String str) {
        Object obj = -1;
        switch (str.hashCode()) {
            case 1513282:
                if (str.equals("1630")) {
                    obj = 43;
                    break;
                }
                break;
            case 1513283:
                if (str.equals("1631")) {
                    obj = 4;
                    break;
                }
                break;
            case 1514181:
                if (str.equals("1710")) {
                    obj = 102;
                    break;
                }
                break;
            case 1515114:
                if (str.equals("1803")) {
                    obj = 86;
                    break;
                }
                break;
            case 1515150:
                if (str.equals("1818")) {
                    obj = 71;
                    break;
                }
                break;
            case 1515173:
                if (str.equals("1820")) {
                    obj = 68;
                    break;
                }
                break;
            case 1515175:
                if (str.equals("1822")) {
                    obj = 72;
                    break;
                }
                break;
            case 1515177:
                if (str.equals("1824")) {
                    obj = 67;
                    break;
                }
                break;
            case 1515299:
                if (str.equals("1862")) {
                    obj = 3;
                    break;
                }
                break;
            case 1516079:
                if (str.equals("1907")) {
                    obj = 14;
                    break;
                }
                break;
            case 1516234:
                if (str.equals("1957")) {
                    obj = 73;
                    break;
                }
                break;
            case 1540165:
                if (str.equals("2326")) {
                    obj = 8;
                    break;
                }
                break;
            case 1540321:
                if (str.equals("2377")) {
                    obj = 12;
                    break;
                }
                break;
            case 1541094:
                if (str.equals("2415")) {
                    obj = 49;
                    break;
                }
                break;
            case 1541159:
                if (str.equals("2438")) {
                    obj = 55;
                    break;
                }
                break;
            case 1541189:
                if (str.equals("2447")) {
                    obj = 57;
                    break;
                }
                break;
            case 1541191:
                if (str.equals("2449")) {
                    obj = 56;
                    break;
                }
                break;
            case 1542023:
                if (str.equals("2504")) {
                    obj = 15;
                    break;
                }
                break;
            case 1542175:
                if (str.equals("2551")) {
                    obj = 26;
                    break;
                }
                break;
            case 1542987:
                if (str.equals("2607")) {
                    obj = 80;
                    break;
                }
                break;
            case 1543011:
                if (str.equals("2610")) {
                    obj = 69;
                    break;
                }
                break;
            case 1544098:
                if (str.equals("2752")) {
                    obj = 11;
                    break;
                }
                break;
            case 1545090:
                if (str.equals("2862")) {
                    obj = 37;
                    break;
                }
                break;
            case 1545928:
                if (str.equals("2923")) {
                    obj = 10;
                    break;
                }
                break;
            case 1567230:
                if (str.equals("3078")) {
                    obj = 1;
                    break;
                }
                break;
            case 1567259:
                if (str.equals("3086")) {
                    obj = 6;
                    break;
                }
                break;
            case 1568035:
                if (str.equals("3127")) {
                    obj = 46;
                    break;
                }
                break;
            case 1568184:
                if (str.equals("3171")) {
                    obj = 47;
                    break;
                }
                break;
            case 1568218:
                if (str.equals("3184")) {
                    obj = 74;
                    break;
                }
                break;
            case 1568246:
                if (str.equals("3191")) {
                    obj = 82;
                    break;
                }
                break;
            case 1568248:
                if (str.equals("3193")) {
                    obj = 27;
                    break;
                }
                break;
            case 1568932:
                if (str.equals("3205")) {
                    obj = 2;
                    break;
                }
                break;
            case 1568995:
                if (str.equals("3226")) {
                    obj = 88;
                    break;
                }
                break;
            case 1569059:
                if (str.equals("3248")) {
                    obj = 70;
                    break;
                }
                break;
            case 1569153:
                if (str.equals("3279")) {
                    obj = 36;
                    break;
                }
                break;
            case 1569987:
                if (str.equals("3336")) {
                    obj = 90;
                    break;
                }
                break;
            case 1570172:
                if (str.equals("3395")) {
                    obj = 45;
                    break;
                }
                break;
            case 1570887:
                if (str.equals("3417")) {
                    obj = 87;
                    break;
                }
                break;
            case 1571817:
                if (str.equals("3507")) {
                    obj = 100;
                    break;
                }
                break;
            case 1571937:
                if (str.equals("3543")) {
                    obj = 50;
                    break;
                }
                break;
            case 1571939:
                if (str.equals("3545")) {
                    obj = 51;
                    break;
                }
                break;
            case 1572030:
                if (str.equals("3573")) {
                    obj = 58;
                    break;
                }
                break;
            case 1572834:
                if (str.equals("3621")) {
                    obj = 96;
                    break;
                }
                break;
            case 1572896:
                if (str.equals("3641")) {
                    obj = 60;
                    break;
                }
                break;
            case 1573059:
                if (str.equals("3699")) {
                    obj = 84;
                    break;
                }
                break;
            case 1573862:
                if (str.equals("3746")) {
                    obj = 31;
                    break;
                }
                break;
            case 1573863:
                if (str.equals("3747")) {
                    obj = 83;
                    break;
                }
                break;
            case 1573891:
                if (str.equals("3754")) {
                    obj = 34;
                    break;
                }
                break;
            case 1573921:
                if (str.equals("3763")) {
                    obj = 22;
                    break;
                }
                break;
            case 1573922:
                if (str.equals("3764")) {
                    obj = 24;
                    break;
                }
                break;
            case 1573954:
                if (str.equals("3775")) {
                    obj = 40;
                    break;
                }
                break;
            case 1574016:
                if (str.equals("3795")) {
                    obj = 59;
                    break;
                }
                break;
            case 1574702:
                if (str.equals("3809")) {
                    obj = 52;
                    break;
                }
                break;
            case 1574733:
                if (str.equals("3819")) {
                    obj = 17;
                    break;
                }
                break;
            case 1574794:
                if (str.equals("3838")) {
                    obj = 77;
                    break;
                }
                break;
            case 1574916:
                if (str.equals("3876")) {
                    obj = 93;
                    break;
                }
                break;
            case 1574917:
                if (str.equals("3877")) {
                    obj = 81;
                    break;
                }
                break;
            case 1574944:
                if (str.equals("3883")) {
                    obj = 63;
                    break;
                }
                break;
            case 1574945:
                if (str.equals("3884")) {
                    obj = 23;
                    break;
                }
                break;
            case 1574948:
                if (str.equals("3887")) {
                    obj = 89;
                    break;
                }
                break;
            case 1575657:
                if (str.equals("3903")) {
                    obj = 44;
                    break;
                }
                break;
            case 1575661:
                if (str.equals("3907")) {
                    obj = 79;
                    break;
                }
                break;
            case 1575662:
                if (str.equals("3908")) {
                    obj = 41;
                    break;
                }
                break;
            case 1575663:
                if (str.equals("3909")) {
                    obj = 38;
                    break;
                }
                break;
            case 1575719:
                if (str.equals("3923")) {
                    obj = 48;
                    break;
                }
                break;
            case 1575748:
                if (str.equals("3931")) {
                    obj = 66;
                    break;
                }
                break;
            case 1575753:
                if (str.equals("3936")) {
                    obj = 21;
                    break;
                }
                break;
            case 1575787:
                if (str.equals("3949")) {
                    obj = 76;
                    break;
                }
                break;
            case 1575840:
                if (str.equals("3960")) {
                    obj = null;
                    break;
                }
                break;
            case 1575873:
                if (str.equals("3972")) {
                    obj = 91;
                    break;
                }
                break;
            case 1575936:
                if (str.equals("3993")) {
                    obj = 65;
                    break;
                }
                break;
            case 1596799:
                if (str.equals("4003")) {
                    obj = 61;
                    break;
                }
                break;
            case 1596834:
                if (str.equals("4017")) {
                    obj = 98;
                    break;
                }
                break;
            case 1596959:
                if (str.equals("4058")) {
                    obj = 95;
                    break;
                }
                break;
            case 1596982:
                if (str.equals("4060")) {
                    obj = 29;
                    break;
                }
                break;
            case 1596985:
                if (str.equals("4063")) {
                    obj = 5;
                    break;
                }
                break;
            case 1596988:
                if (str.equals("4066")) {
                    obj = 28;
                    break;
                }
                break;
            case 1597018:
                if (str.equals("4075")) {
                    obj = 97;
                    break;
                }
                break;
            case 1597022:
                if (str.equals("4079")) {
                    obj = 94;
                    break;
                }
                break;
            case 1597048:
                if (str.equals("4084")) {
                    obj = 85;
                    break;
                }
                break;
            case 1597078:
                if (str.equals("4093")) {
                    obj = 75;
                    break;
                }
                break;
            case 1597081:
                if (str.equals("4096")) {
                    obj = 13;
                    break;
                }
                break;
            case 1597758:
                if (str.equals("4101")) {
                    obj = 92;
                    break;
                }
                break;
            case 1597789:
                if (str.equals("4111")) {
                    obj = 101;
                    break;
                }
                break;
            case 1597826:
                if (str.equals("4127")) {
                    obj = 53;
                    break;
                }
                break;
            case 1597851:
                if (str.equals("4131")) {
                    obj = 35;
                    break;
                }
                break;
            case 1597856:
                if (str.equals("4136")) {
                    obj = 42;
                    break;
                }
                break;
            case 1597859:
                if (str.equals("4139")) {
                    obj = 99;
                    break;
                }
                break;
            case 1597882:
                if (str.equals("4141")) {
                    obj = 54;
                    break;
                }
                break;
            case 1597915:
                if (str.equals("4153")) {
                    obj = 30;
                    break;
                }
                break;
            case 1597917:
                if (str.equals("4155")) {
                    obj = 9;
                    break;
                }
                break;
            case 1597919:
                if (str.equals("4157")) {
                    obj = 18;
                    break;
                }
                break;
            case 1597920:
                if (str.equals("4158")) {
                    obj = 19;
                    break;
                }
                break;
            case 1597921:
                if (str.equals("4159")) {
                    obj = 20;
                    break;
                }
                break;
            case 1597946:
                if (str.equals("4163")) {
                    obj = 78;
                    break;
                }
                break;
            case 1597952:
                if (str.equals("4169")) {
                    obj = 62;
                    break;
                }
                break;
            case 1597978:
                if (str.equals("4174")) {
                    obj = 7;
                    break;
                }
                break;
            case 1598006:
                if (str.equals("4181")) {
                    obj = 32;
                    break;
                }
                break;
            case 1598040:
                if (str.equals("4194")) {
                    obj = 64;
                    break;
                }
                break;
            case 1598042:
                if (str.equals("4196")) {
                    obj = 16;
                    break;
                }
                break;
            case 1598725:
                if (str.equals("4207")) {
                    obj = 39;
                    break;
                }
                break;
            case 1598751:
                if (str.equals("4212")) {
                    obj = 25;
                    break;
                }
                break;
            case 1598820:
                if (str.equals("4239")) {
                    obj = 33;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return (InterstitialController) this.f4435a.get();
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return (InterstitialController) this.f4436b.get();
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return (InterstitialController) this.f4437c.get();
            case 3:
                return (InterstitialController) this.f4438d.get();
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return (InterstitialController) this.f4439e.get();
            case 5:
                return (InterstitialController) this.f4440f.get();
            case 6:
                return (InterstitialController) this.f4441g.get();
            case 7:
                return (InterstitialController) this.f4442h.get();
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return (InterstitialController) this.f4443i.get();
            case 9:
                return (InterstitialController) this.f4444j.get();
            case 10:
                return (InterstitialController) this.f4445k.get();
            case 11:
                return (InterstitialController) this.f4446l.get();
            case 12:
                return (InterstitialController) this.f4447m.get();
            case 13:
                return (InterstitialController) this.f4448n.get();
            case 14:
                return (InterstitialController) this.f4449o.get();
            case 15:
                return (InterstitialController) this.f4450p.get();
            case HTTPTransportCallback.HEADER_BYTES_GENERATED /*16*/:
                return (InterstitialController) this.f4451q.get();
            case 17:
                return (InterstitialController) this.f4452r.get();
            case 18:
                return (InterstitialController) this.f4453s.get();
            case 19:
                return (InterstitialController) this.f4454t.get();
            case 20:
                return (InterstitialController) this.f4455u.get();
            case 21:
                return (InterstitialController) this.f4456v.get();
            case 22:
                return (InterstitialController) this.f4457w.get();
            case 23:
                return (InterstitialController) this.f4458x.get();
            case 24:
                return (InterstitialController) this.f4459y.get();
            case 25:
                return (InterstitialController) this.f4460z.get();
            case 26:
                return (InterstitialController) this.f4409A.get();
            case 27:
                return (InterstitialController) this.f4410B.get();
            case 28:
                return (InterstitialController) this.f4411C.get();
            case 29:
                return (InterstitialController) this.f4412D.get();
            case 30:
                return (InterstitialController) this.f4413E.get();
            case 31:
                return (InterstitialController) this.f4414F.get();
            case HTTPTransportCallback.HEADER_BYTES_RECEIVED /*32*/:
                return (InterstitialController) this.f4415G.get();
            case 33:
                return (InterstitialController) this.f4416H.get();
            case 34:
                return (InterstitialController) this.f4417I.get();
            case 35:
                return (InterstitialController) this.f4418J.get();
            case 36:
                return (InterstitialController) this.f4419K.get();
            case 37:
                return (InterstitialController) this.f4420L.get();
            case 38:
                return (InterstitialController) this.f4421M.get();
            case 39:
                return (InterstitialController) this.f4422N.get();
            case 40:
                return (InterstitialController) this.f4423O.get();
            case 41:
                return (InterstitialController) this.f4424P.get();
            case 42:
                return (InterstitialController) this.f4425Q.get();
            case 43:
                return (InterstitialController) this.f4426R.get();
            case 44:
                return (InterstitialController) this.f4427S.get();
            case 45:
                return (InterstitialController) this.f4428T.get();
            case 46:
                return (InterstitialController) this.f4429U.get();
            case 47:
                return (InterstitialController) this.f4430V.get();
            case 48:
                return (InterstitialController) this.f4431W.get();
            case 49:
                return (InterstitialController) this.f4432X.get();
            case 50:
                return (InterstitialController) this.f4433Y.get();
            case 51:
                return (InterstitialController) this.f4434Z.get();
            case 52:
                return (InterstitialController) this.aa.get();
            case 53:
                return (InterstitialController) this.ab.get();
            case 54:
                return (InterstitialController) this.ac.get();
            case 55:
                return (InterstitialController) this.ad.get();
            case 56:
                return (InterstitialController) this.ae.get();
            case 57:
                return (InterstitialController) this.af.get();
            case 58:
                return (InterstitialController) this.ag.get();
            case 59:
                return (InterstitialController) this.ah.get();
            case 60:
                return (InterstitialController) this.ai.get();
            case 61:
                return (InterstitialController) this.aj.get();
            case 62:
                return (InterstitialController) this.ak.get();
            case 63:
                return (InterstitialController) this.al.get();
            case HTTPTransportCallback.BODY_BYTES_GENERATED /*64*/:
                return (InterstitialController) this.am.get();
            case 65:
                return (InterstitialController) this.an.get();
            case 66:
                return (InterstitialController) this.ao.get();
            case 67:
                return (InterstitialController) this.ap.get();
            case 68:
                return (InterstitialController) this.aq.get();
            case 69:
                return (InterstitialController) this.ar.get();
            case 70:
                return (InterstitialController) this.as.get();
            case 71:
                return (InterstitialController) this.at.get();
            case 72:
                return (InterstitialController) this.au.get();
            case 73:
                return (InterstitialController) this.av.get();
            case 74:
                return (InterstitialController) this.aw.get();
            case 75:
                return (InterstitialController) this.ax.get();
            case 76:
                return (InterstitialController) this.ay.get();
            case 77:
                return (InterstitialController) this.az.get();
            case 78:
                return (InterstitialController) this.aA.get();
            case 79:
                return (InterstitialController) this.aB.get();
            case 80:
                return (InterstitialController) this.aC.get();
            case 81:
                return (InterstitialController) this.aD.get();
            case 82:
                return (InterstitialController) this.aE.get();
            case 83:
                return (InterstitialController) this.aF.get();
            case 84:
                return (InterstitialController) this.aG.get();
            case 85:
                return (InterstitialController) this.aH.get();
            case 86:
                return (InterstitialController) this.aI.get();
            case 87:
                return (InterstitialController) this.aJ.get();
            case 88:
                return (InterstitialController) this.aK.get();
            case 89:
                return (InterstitialController) this.aL.get();
            case 90:
                return (InterstitialController) this.aM.get();
            case 91:
                return (InterstitialController) this.aN.get();
            case 92:
                return (InterstitialController) this.aO.get();
            case 93:
                return (InterstitialController) this.aP.get();
            case 94:
                return (InterstitialController) this.aQ.get();
            case 95:
                return (InterstitialController) this.aR.get();
            case 96:
                return (InterstitialController) this.aS.get();
            case 97:
                return (InterstitialController) this.aT.get();
            case 98:
                return (InterstitialController) this.aU.get();
            case 99:
                return (InterstitialController) this.aV.get();
            case 100:
                return (InterstitialController) this.aW.get();
            case 101:
                return (InterstitialController) this.aX.get();
            case 102:
                return (InterstitialController) this.aY.get();
            default:
                return null;
        }
    }

    @Nullable
    public final synchronized Collection<String> mo1204a(Action action) {
        if (this.bb == null) {
            this.bb = ArrayListMultimap.m2971t();
            this.bb.mo431a(Action.FEED_PYMK_FRIEND_REQUEST_SENT, (Object) "3279");
            this.bb.mo431a(Action.FEED_PYMK_SCROLLED, (Object) "3279");
            this.bb.mo431a(Action.FEED_PYMK_XOUTED, (Object) "3279");
            this.bb.mo431a(Action.MESSENGER_APP_DID_BECOME_ACTIVE, (Object) "2415");
            this.bb.mo431a(Action.MESSENGER_NEW_USER_SETUP_COMPLETE, (Object) "2415");
            this.bb.mo431a(Action.MESSENGER_THREAD_LIST, (Object) "3543");
            this.bb.mo431a(Action.MESSENGER_THREAD_LIST_PTR, (Object) "3543");
            this.bb.mo431a(Action.MESSENGER_THREAD_OPEN, (Object) "3545");
            this.bb.mo431a(Action.MESSENGER_AUDIO_CLIP_VISIBLE, (Object) "3545");
            this.bb.mo431a(Action.MESSENGER_RTC_PRESENCE_CHANGE, (Object) "3545");
            this.bb.mo431a(Action.DIVEBAR_OPEN, (Object) "1824");
            this.bb.mo431a(Action.THREAD_LIST_OPEN, (Object) "1820");
            this.bb.mo431a(Action.GROUP_MALL_VIEW, (Object) "1820");
            this.bb.mo431a(Action.TAB_NAVIGATION_FRIEND_REQUESTS, (Object) "1820");
            this.bb.mo431a(Action.TIMELINE, (Object) "1820");
            this.bb.mo431a(Action.PAGE_ADMIN_TIMELINE_VIEW, (Object) "1820");
            this.bb.mo431a(Action.PAGE_ADMIN_TIMELINE_VIEW_VERIFY_ELIGIBLE, (Object) "1820");
            this.bb.mo431a(Action.PERSONAL_PROFILE_OWNER, (Object) "1820");
            this.bb.mo431a(Action.PERSONAL_PROFILE_FRIEND, (Object) "1820");
            this.bb.mo431a(Action.PERSONAL_PROFILE_NONFRIEND, (Object) "1820");
            this.bb.mo431a(Action.APP_FOREGROUND, (Object) "2610");
            this.bb.mo431a(Action.BUILT_IN_BROWSER, (Object) "2610");
            this.bb.mo431a(Action.FRIEND_REQUEST_SENT, (Object) "2610");
            this.bb.mo431a(Action.GROUP_INFO_VIEW, (Object) "2610");
            this.bb.mo431a(Action.GROUP_MALL_VIEW, (Object) "2610");
            this.bb.mo431a(Action.PAGE_ADMIN_TIMELINE_VIEW, (Object) "2610");
            this.bb.mo431a(Action.POST_CREATED, (Object) "2610");
            this.bb.mo431a(Action.PROFILE_FRIEND_REQUEST_SENT, (Object) "2610");
            this.bb.mo431a(Action.SESSION_COLD_START, (Object) "2610");
            this.bb.mo431a(Action.SIMPLE_SEARCH_CLEAR_TEXT_ICON_CLICK, (Object) "2610");
            this.bb.mo431a(Action.TAB_NAVIGATION_FEED, (Object) "2610");
            this.bb.mo431a(Action.TAB_NAVIGATION_FRIEND_REQUESTS, (Object) "2610");
            this.bb.mo431a(Action.TAB_NAVIGATION_NOTIFICATIONS, (Object) "2610");
            this.bb.mo431a(Action.TAB_NAVIGATION_MORE, (Object) "2610");
            this.bb.mo431a(Action.THREAD_LIST_INTERSTITIAL_OPEN, (Object) "2610");
            this.bb.mo431a(Action.TO_ADS_MANAGER_M_SITE, (Object) "2610");
            this.bb.mo431a(Action.VOIP_CALL_END, (Object) "2610");
            this.bb.mo431a(Action.VOIP_CALL_START, (Object) "2610");
            this.bb.mo431a(Action.REQUEST_TAB_FRIENDING_ACTION_PERFORMED, (Object) "3248");
            this.bb.mo431a(Action.APP_FOREGROUND, (Object) "1818");
            this.bb.mo431a(Action.BUILT_IN_BROWSER, (Object) "1818");
            this.bb.mo431a(Action.FRIEND_REQUEST_SENT, (Object) "1818");
            this.bb.mo431a(Action.GROUP_INFO_VIEW, (Object) "1818");
            this.bb.mo431a(Action.GROUP_MALL_VIEW, (Object) "1818");
            this.bb.mo431a(Action.PAGE_ADMIN_TIMELINE_VIEW, (Object) "1818");
            this.bb.mo431a(Action.POST_CREATED, (Object) "1818");
            this.bb.mo431a(Action.PROFILE_FRIEND_REQUEST_SENT, (Object) "1818");
            this.bb.mo431a(Action.SESSION_COLD_START, (Object) "1818");
            this.bb.mo431a(Action.SIMPLE_SEARCH_CLEAR_TEXT_ICON_CLICK, (Object) "1818");
            this.bb.mo431a(Action.TAB_NAVIGATION_FEED, (Object) "1818");
            this.bb.mo431a(Action.TAB_NAVIGATION_FRIEND_REQUESTS, (Object) "1818");
            this.bb.mo431a(Action.TAB_NAVIGATION_NOTIFICATIONS, (Object) "1818");
            this.bb.mo431a(Action.TAB_NAVIGATION_MORE, (Object) "1818");
            this.bb.mo431a(Action.THREAD_LIST_INTERSTITIAL_OPEN, (Object) "1818");
            this.bb.mo431a(Action.TO_ADS_MANAGER_M_SITE, (Object) "1818");
            this.bb.mo431a(Action.VOIP_CALL_END, (Object) "1818");
            this.bb.mo431a(Action.VOIP_CALL_START, (Object) "1818");
            this.bb.mo431a(Action.GROUP_MALL_VIEW, (Object) "1822");
            this.bb.mo431a(Action.ADMIN_GROUP_MALL_MULTITIER_ENABLED_VIEW, (Object) "1822");
            this.bb.mo431a(Action.MOD_GROUP_MALL_MULTITIER_ENABLED_VIEW, (Object) "1822");
            this.bb.mo431a(Action.NEWSFEED, (Object) "1822");
            this.bb.mo431a(Action.TAB_NAVIGATION_FRIEND_REQUESTS, (Object) "1822");
            this.bb.mo431a(Action.MESSAGES_DIODE_CANONICAL_THREAD, (Object) "1957");
            this.bb.mo431a(Action.MESSAGES_DIODE_CREATE_THREAD, (Object) "1957");
            this.bb.mo431a(Action.MESSAGES_DIODE_GROUP_THREAD, (Object) "1957");
            this.bb.mo431a(Action.MESSAGES_DIODE_TAB, (Object) "1957");
            this.bb.mo431a(Action.THREAD_LIST_INTERSTITIAL_OPEN, (Object) "1957");
            this.bb.mo431a(Action.TAB_NAVIGATION_FEED, (Object) "1957");
            this.bb.mo431a(Action.TAB_NAVIGATION_FRIEND_REQUESTS, (Object) "1957");
            this.bb.mo431a(Action.TAB_NAVIGATION_MESSAGES, (Object) "1957");
            this.bb.mo431a(Action.TAB_NAVIGATION_NOTIFICATIONS, (Object) "1957");
            this.bb.mo431a(Action.TAB_NAVIGATION_MORE, (Object) "1957");
            this.bb.mo431a(Action.SEARCH_BAR_TOOLTIP, (Object) "3877");
            this.bb.mo431a(Action.SEARCH_NULL_STATE, (Object) "3191");
        }
        return this.bb.mo427c(action);
    }
}
