package com.facebook.katana.urimap;

import android.content.Context;
import android.content.Intent;
import com.facebook.adinterfaces.AdInterfacesUriIntentBuilder;
import com.facebook.adpreview.activity.AdPreviewUriIntentBuilder;
import com.facebook.adsexperiencetool.AdsExperienceUriIntentBuilder;
import com.facebook.adsmanager.deeplinking.uri.AdsManagerRedirectUriIntentBuilder;
import com.facebook.aplacefor.activity.APlaceForUriIntentBuilder;
import com.facebook.appdiscovery.appfeed.activity.AppFeedUriIntentBuilder;
import com.facebook.appdiscovery.lite.LiteUriIntentBuilder;
import com.facebook.appinvites.activity.AppInvitesUriIntentBuilder;
import com.facebook.backgroundlocation.nux.BackgroundLocationNuxUriIntentBuilder;
import com.facebook.backstage.entry.BackstageReplyUriIntentBuilder;
import com.facebook.backstage.entry.BackstageStackUriIntentBuilder;
import com.facebook.checkin.socialsearch.conversion.SocialSearchConversionUriIntentBuilder;
import com.facebook.checkin.socialsearch.map.SocialSearchMapFragmentAndUriIntentBuilder;
import com.facebook.commerce.productdetails.intent.ProductDetailsUriIntentBuilder;
import com.facebook.commerce.publishing.CommercePublishingUriIntentBuilder;
import com.facebook.commerce.storefront.intent.StorefrontUriIntentBuilder;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.uri.STATICDI_MULTIBIND_PROVIDER;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.composer.shareintent.ComposerShareUriIntentBuilder;
import com.facebook.composer.topics.uri.ComposerTopicsUriIntentBuilder;
import com.facebook.confirmation.uri.AccountConfirmationUriIntentBuilder;
import com.facebook.crowdsourcing.suggestedits.intent.SuggestEditsUriIntentBuilder;
import com.facebook.dialtone.DialtoneIntentUriBuilder;
import com.facebook.events.dashboard.birthdays.BirthdaysUriIntentBuilder;
import com.facebook.events.permalink.messagefriends.EventMessageFriendsUriIntentBuilder;
import com.facebook.events.reaction.EventsReactionUriIntentBuilder;
import com.facebook.events.uri.EventsInviteFriendsUriIntentBuilder;
import com.facebook.events.uri.EventsPermalinkUriIntentBuilder;
import com.facebook.events.uri.EventsUriIntentBuilder;
import com.facebook.facecast.FacecastUriIntentBuilder;
import com.facebook.fbreact.navigation.FbReactNavigationUriIntentBuilder;
import com.facebook.feed.NewsFeedIntentUriBuilder;
import com.facebook.feed.awesomizer.ui.FeedAwesomizerUriIntentBuilder;
import com.facebook.feed.threadedcomments.uri.CommentUriIntentBuilder;
import com.facebook.feedplugins.prompts.SocialPromptInviteFriendsUriIntentBuilder;
import com.facebook.friending.center.uri.FriendsCenterUriIntentBuilder;
import com.facebook.friending.immersive.ImmersivePeopleYouMayKnowUriIntentBuilder;
import com.facebook.friending.profileshare.uri.ProfileShareUriIntentBuilder;
import com.facebook.friending.suggestion.uri.FriendingSuggestionUriIntentBuilder;
import com.facebook.friendlist.intent.FriendListUriIntentBuilder;
import com.facebook.friendsnearby.FriendsNearbyUriIntentBuilder;
import com.facebook.goodwill.GoodwillUriIntentBuilder;
import com.facebook.groupcommerce.deep_link.ForSalePostUriIntentBuilder;
import com.facebook.groups.fb4a.addtogroups.FB4AAddToGroupsIntentUriBuilder;
import com.facebook.groups.fb4a.create.FB4AGroupsCreateIntentUriBuilder;
import com.facebook.groups.fb4a.discover.FB4AGroupsDiscoverUriIntentBuilder;
import com.facebook.groups.fb4a.docsandfiles.intent.GroupsDocsAndFilesUriIntentBuilder;
import com.facebook.groups.fb4a.events.FB4AGroupEventsUriIntentBuilder;
import com.facebook.groups.fb4a.info.FB4AGroupMembershipUriIntentBuilder;
import com.facebook.groups.fb4a.info.FB4AGroupSubscriptionUriIntentBuilder;
import com.facebook.groups.fb4a.pendingposts.PendingPostsIntentUriBuilder;
import com.facebook.groups.fb4a.photos.FB4APhotosUriIntentBuilder;
import com.facebook.groups.fb4a.react.FB4AGroupsReactUriIntentBuilder;
import com.facebook.groups.feed.integration.CrossGroupForSalePostsFeedIntentUriBuilder;
import com.facebook.groups.feed.integration.GroupFeedIntentUriBuilder;
import com.facebook.groups.feed.integration.GroupFeedYourPostsIntentUriBuilder;
import com.facebook.groups.memberpicker.MemberPickerIntentUriBuilder;
import com.facebook.groups.memberrequests.MemberRequestsIntentUriBuilder;
import com.facebook.growth.uri.GrowthUriIntentBuilder;
import com.facebook.hashtag.uri.HashtagUriIntentBuilder;
import com.facebook.http.prefs.delaybasedqp.DelayBasedHttpQPRequestUriIntentBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.instantarticles.RichDocumentUriIntentBuilder;
import com.facebook.instantshopping.InstantShoppingUriIntentBuilder;
import com.facebook.katana.DBLLoggedInAccountSettingsUriIntentBuilder;
import com.facebook.katana.SettingsIntentUriBuilder;
import com.facebook.katana.activity.PlatformFacewebUriIntentBuilder;
import com.facebook.katana.activity.media.VideoUriIntentBuilder;
import com.facebook.katana.activity.nearby.NearbyPlacesFallbackUriIntentBuilder;
import com.facebook.katana.activity.nearby.NearbyPlacesUriIntentBuilder;
import com.facebook.katana.activity.nearby.SubcategorySelectionUriIntentBuilder;
import com.facebook.katana.activity.photos.PhotosUriIntentBuilder;
import com.facebook.katana.login.OtpUriIntentBuilder;
import com.facebook.localcontent.menus.AddPhotoMenuUriIntentBuilder;
import com.facebook.localcontent.menus.PagePhotoMenuUriIntentBuilder;
import com.facebook.localcontent.menus.admin.manager.PageMenuManagementUriIntentBuilder;
import com.facebook.localcontent.menus.structured.StructuredMenuUriIntentBuilder;
import com.facebook.localcontent.photos.PhotosByCategoryUriIntentBuilder;
import com.facebook.looknow.LookNowUriIntentBuilder;
import com.facebook.maps.GenericMapsFragmentAndUriIntentBuilder;
import com.facebook.neko.getgamesneko.GetGamesNekoUriIntentBuilder;
import com.facebook.offers.uri.OffersUriIntentBuilder;
import com.facebook.pages.browser.intent.uri.PagesBrowserUriIntentBuilder;
import com.facebook.pages.common.editpage.EditPageUriIntentBuilder;
import com.facebook.pages.common.friendinviter.uri.PageInviterUriIntentBuilder;
import com.facebook.pages.deeplinking.uri.ManagedPageUriIntentBuilder;
import com.facebook.pages.fb4a.admin_activity.uri.PagesFb4aAdminActivityUriIntentBuilder;
import com.facebook.pages.fb4a.uri.PagesFb4aMessagingUriIntentBuilder;
import com.facebook.pages.identity.intent.uri.DefaultPageUriIntentBuilder;
import com.facebook.pages.identity.intent.uri.PageIdentityUriIntentBuilder;
import com.facebook.pages.launchpoint.uri.PagesLaunchpointUriIntentBuilder;
import com.facebook.photos.mediagallery.ui.MediaGalleryUriIntentBuilder;
import com.facebook.placetips.settings.ui.PlaceTipsSettingsUriIntentBuilder;
import com.facebook.placetips.upsell.PlaceTipsUriIntentBuilder;
import com.facebook.privacy.checkup.PrivacyCheckupUriIntentBuilder;
import com.facebook.profile.inforequest.InfoRequestUriIntentBuilder;
import com.facebook.quickpromotion.uri.QuickPromotionUriIntentBuilder;
import com.facebook.rapidfeedback.debug.DebugRapidFeedbackUriIntentBuilder;
import com.facebook.reaction.ui.uri.ReactionUriIntentBuilder;
import com.facebook.reviews.intent.ReviewsUriIntentBuilder;
import com.facebook.reviews.intent.UserReviewsUriIntentBuilder;
import com.facebook.reviews.intent.ViewReviewUriIntentBuilder;
import com.facebook.saved.intent.SavedUriIntentBuilder;
import com.facebook.search.uri.SearchResultUriIntentBuilder;
import com.facebook.search.uri.SearchUriIntentBuilder;
import com.facebook.search.uri.TrendingSportsUriIntentBuilder;
import com.facebook.socialgood.SocialGoodUriIntentBuilder;
import com.facebook.socialgood.inviter.FundraiserPageInviterUriIntentBuilder;
import com.facebook.storelocator.StoreLocatorUriIntentBuilder;
import com.facebook.timeline.ProfileVideoUriIntentBuilder;
import com.facebook.timeline.aboutpage.CollectionsUriIntentBuilder;
import com.facebook.ui.browser.BrowserUriIntentBuilder;
import com.facebook.vault.momentsupsell.uri.MomentsUpsellUriIntentBuilder;
import com.facebook.video.channelfeed.uri.ChannelFeedUriIntentBuilder;
import com.facebook.video.videohome.uri.VideoHomeUriIntentBuilder;
import com.facebook.zero.carrier.fragment.CarrierManagerIntentUriBuilder;
import com.facebook.zero.fb4a.ZeroInterstitialIntentUriBuilder;
import com.facebook.zero.onboarding.AssistedOnboardingIntentUriBuilder;
import com.facebook.zero.settings.DialtoneInfoScreenUriIntentBuilder;
import com.facebook.zero.settings.FreeFacebookSettingsUriIntentBuilder;
import com.facebook.zero.upsell.activity.ZeroUpsellUriIntentBuilder;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: timeline_story_like_fail_no_ */
public class StaticUriIntentMapper {
    private static volatile StaticUriIntentMapper f1232c;
    private final Provider<Set<UriIntentBuilder>> f1233a;
    private final AbstractFbErrorReporter f1234b;

    public static com.facebook.katana.urimap.StaticUriIntentMapper m1265a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f1232c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.urimap.StaticUriIntentMapper.class;
        monitor-enter(r1);
        r0 = f1232c;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m1267b(r0);	 Catch:{ all -> 0x0035 }
        f1232c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1232c;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.urimap.StaticUriIntentMapper.a(com.facebook.inject.InjectorLike):com.facebook.katana.urimap.StaticUriIntentMapper");
    }

    private static StaticUriIntentMapper m1267b(InjectorLike injectorLike) {
        return new StaticUriIntentMapper(STATICDI_MULTIBIND_PROVIDER.UriIntentBuilder.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public StaticUriIntentMapper(Provider<Set<UriIntentBuilder>> provider, FbErrorReporter fbErrorReporter) {
        this.f1233a = provider;
        this.f1234b = fbErrorReporter;
    }

    public final Intent m1269a(Context context, String str, UriMapPerfLogger uriMapPerfLogger) {
        boolean z;
        Intent intent;
        uriMapPerfLogger.a(5701648, str);
        String a = m1266a(str);
        InjectorLike injectorLike = FbInjector.get(context.getApplicationContext());
        Intent intent2 = null;
        Object obj = -1;
        switch (a.hashCode()) {
            case -2133520921:
                if (a.equals("link_fb_invite")) {
                    obj = 104;
                    break;
                }
                break;
            case -2068278567:
                if (a.equals("localsell_saved_search_results")) {
                    obj = 15;
                    break;
                }
                break;
            case -2028191813:
                if (a.equals("app_discovery_lite")) {
                    obj = 86;
                    break;
                }
                break;
            case -2023155454:
                if (a.equals("recent_feed")) {
                    obj = 58;
                    break;
                }
                break;
            case -1986124414:
                if (a.equals("2g_empathy")) {
                    obj = 123;
                    break;
                }
                break;
            case -1971529053:
                if (a.equals("bookmarks_section")) {
                    obj = 93;
                    break;
                }
                break;
            case -1896937794:
                if (a.equals("privacy_review_lightweight")) {
                    obj = 52;
                    break;
                }
                break;
            case -1787927206:
                if (a.equals("search_result_page")) {
                    obj = 147;
                    break;
                }
                break;
            case -1755748902:
                if (a.equals("friendship")) {
                    obj = 138;
                    break;
                }
                break;
            case -1742485738:
                if (a.equals("syncnux")) {
                    obj = 32;
                    break;
                }
                break;
            case -1741312354:
                if (a.equals("collection")) {
                    obj = 84;
                    break;
                }
                break;
            case -1687149260:
                if (a.equals("cta_promotion")) {
                    obj = 40;
                    break;
                }
                break;
            case -1674202753:
                if (a.equals("onthisday")) {
                    obj = 74;
                    break;
                }
                break;
            case -1618203101:
                if (a.equals("video_home")) {
                    obj = 154;
                    break;
                }
                break;
            case -1601360161:
                if (a.equals("notification_settings_alerts")) {
                    obj = 61;
                    break;
                }
                break;
            case -1590195047:
                if (a.equals("topic_feeds_customization")) {
                    obj = 24;
                    break;
                }
                break;
            case -1566866361:
                if (a.equals("native_album")) {
                    obj = 34;
                    break;
                }
                break;
            case -1554067522:
                if (a.equals("notifications_tab")) {
                    obj = 63;
                    break;
                }
                break;
            case -1481450429:
                if (a.equals("native_document")) {
                    obj = 90;
                    break;
                }
                break;
            case -1434526486:
                if (a.equals("dbl_loggedin_settings")) {
                    obj = 125;
                    break;
                }
                break;
            case -1428741700:
                if (a.equals("findfriends")) {
                    obj = 44;
                    break;
                }
                break;
            case -1415163932:
                if (a.equals("albums")) {
                    obj = 27;
                    break;
                }
                break;
            case -1338513145:
                if (a.equals("localsell_category_search")) {
                    obj = 5;
                    break;
                }
                break;
            case -1326167441:
                if (a.equals("donate")) {
                    obj = 81;
                    break;
                }
                break;
            case -1293596731:
                if (a.equals("local_awareness_promotion")) {
                    obj = 37;
                    break;
                }
                break;
            case -1291329255:
                if (a.equals("events")) {
                    obj = 42;
                    break;
                }
                break;
            case -1247741778:
                if (a.equals("samplernintegration")) {
                    obj = 22;
                    break;
                }
                break;
            case -1237460524:
                if (a.equals("groups")) {
                    obj = 87;
                    break;
                }
                break;
            case -1236062124:
                if (a.equals("friendsnearby")) {
                    obj = 72;
                    break;
                }
                break;
            case -1190009054:
                if (a.equals("nativename")) {
                    obj = 46;
                    break;
                }
                break;
            case -1189302593:
                if (a.equals("zero_dialog")) {
                    obj = 134;
                    break;
                }
                break;
            case -1184344809:
                if (a.equals("id_backed_privacy_checkup")) {
                    obj = 54;
                    break;
                }
                break;
            case -1165025148:
                if (a.equals("friending")) {
                    obj = 120;
                    break;
                }
                break;
            case -1133943658:
                if (a.equals("photo_checkup")) {
                    obj = 53;
                    break;
                }
                break;
            case -1120073848:
                if (a.equals("lightswitch_optin_interstitial")) {
                    obj = 67;
                    break;
                }
                break;
            case -1102635913:
                if (a.equals("profile_qr")) {
                    obj = 50;
                    break;
                }
                break;
            case -1101584830:
                if (a.equals("platform_get_payments")) {
                    obj = 100;
                    break;
                }
                break;
            case -1092322345:
                if (a.equals("faceweb")) {
                    obj = 94;
                    break;
                }
                break;
            case -1082411692:
                if (a.equals("friendsnearby_invite")) {
                    obj = 73;
                    break;
                }
                break;
            case -1072859096:
                if (a.equals("videochannel")) {
                    obj = 153;
                    break;
                }
                break;
            case -1050466529:
                if (a.equals("localsell_product_message_threads")) {
                    obj = 11;
                    break;
                }
                break;
            case -1049482625:
                if (a.equals("nearby")) {
                    obj = 91;
                    break;
                }
                break;
            case -1040169423:
                if (a.equals("time_based_optin_interstitial")) {
                    obj = 68;
                    break;
                }
                break;
            case -1019793001:
                if (a.equals("offers")) {
                    obj = 25;
                    break;
                }
                break;
            case -1003406089:
                if (a.equals("notification_settings")) {
                    obj = 60;
                    break;
                }
                break;
            case -979805852:
                if (a.equals("prompt")) {
                    obj = 118;
                    break;
                }
                break;
            case -967730025:
                if (a.equals("a-place-for")) {
                    obj = 106;
                    break;
                }
                break;
            case -906336856:
                if (a.equals("search")) {
                    obj = 64;
                    break;
                }
                break;
            case -900754946:
                if (a.equals("mediaset")) {
                    obj = 33;
                    break;
                }
                break;
            case -880143957:
                if (a.equals("page_like_promotion")) {
                    obj = 39;
                    break;
                }
                break;
            case -867509719:
                if (a.equals("reaction")) {
                    obj = 79;
                    break;
                }
                break;
            case -853284191:
                if (a.equals("localsell_home")) {
                    obj = 4;
                    break;
                }
                break;
            case -847056947:
                if (a.equals("photosync")) {
                    obj = 31;
                    break;
                }
                break;
            case -838908944:
                if (a.equals("localsell_product_details")) {
                    obj = 13;
                    break;
                }
                break;
            case -822999359:
                if (a.equals("localsell_forsalegroupshome")) {
                    obj = 8;
                    break;
                }
                break;
            case -809270416:
                if (a.equals("promote_product")) {
                    obj = 41;
                    break;
                }
                break;
            case -807678359:
                if (a.equals("free_facebook_settings")) {
                    obj = 157;
                    break;
                }
                break;
            case -793417921:
                if (a.equals("appfeed")) {
                    obj = 107;
                    break;
                }
                break;
            case -776144932:
                if (a.equals("redirect")) {
                    obj = 131;
                    break;
                }
                break;
            case -710767143:
                if (a.equals("free_fb_invite")) {
                    obj = 103;
                    break;
                }
                break;
            case -695612956:
                if (a.equals("zero_upsell")) {
                    obj = 158;
                    break;
                }
                break;
            case -672141764:
                if (a.equals("add_services")) {
                    obj = 20;
                    break;
                }
                break;
            case -613614836:
                if (a.equals("anniversary_video")) {
                    obj = 1;
                    break;
                }
                break;
            case -602412325:
                if (a.equals("commerce")) {
                    obj = 56;
                    break;
                }
                break;
            case -600094315:
                if (a.equals("friends")) {
                    obj = 48;
                    break;
                }
                break;
            case -599342816:
                if (a.equals("composer")) {
                    obj = 70;
                    break;
                }
                break;
            case -533196289:
                if (a.equals("website_promotion")) {
                    obj = 38;
                    break;
                }
                break;
            case -507797684:
                if (a.equals("photo_menu")) {
                    obj = 135;
                    break;
                }
                break;
            case -430562217:
                if (a.equals("id_backed_privacy_checkup_react")) {
                    obj = 55;
                    break;
                }
                break;
            case -424527981:
                if (a.equals("marketplace_saved")) {
                    obj = 14;
                    break;
                }
                break;
            case -415318477:
                if (a.equals("upcoming_birthdays")) {
                    obj = 115;
                    break;
                }
                break;
            case -393257020:
                if (a.equals("requests")) {
                    obj = 49;
                    break;
                }
                break;
            case -391739536:
                if (a.equals("dialtone_optin_interstitial")) {
                    obj = 66;
                    break;
                }
                break;
            case -321821936:
                if (a.equals("newContactPoint")) {
                    obj = 47;
                    break;
                }
                break;
            case -309425751:
                if (a.equals("profile")) {
                    obj = 82;
                    break;
                }
                break;
            case -272384484:
                if (a.equals("marketplace_search")) {
                    obj = 16;
                    break;
                }
                break;
            case -255666441:
                if (a.equals("marketplace_category_browse")) {
                    obj = 6;
                    break;
                }
                break;
            case -233685790:
                if (a.equals("dialtone")) {
                    obj = 114;
                    break;
                }
                break;
            case -191392788:
                if (a.equals("privacy_checkup")) {
                    obj = 51;
                    break;
                }
                break;
            case -191379439:
                if (a.equals("rapid_feedback_survey")) {
                    obj = 144;
                    break;
                }
                break;
            case -175234227:
                if (a.equals("confirmAccount")) {
                    obj = 113;
                    break;
                }
                break;
            case -65721881:
                if (a.equals("extbrowser")) {
                    obj = 130;
                    break;
                }
                break;
            case -59906953:
                if (a.equals("localsell_location")) {
                    obj = 18;
                    break;
                }
                break;
            case -29393989:
                if (a.equals("social_search_conversion")) {
                    obj = 111;
                    break;
                }
                break;
            case 0:
                if (a.equals("")) {
                    obj = 88;
                    break;
                }
                break;
            case 3311:
                if (a.equals("gv")) {
                    obj = 3;
                    break;
                }
                break;
            case 3615:
                if (a.equals("qp")) {
                    obj = 102;
                    break;
                }
                break;
            case 3668:
                if (a.equals("sg")) {
                    obj = 80;
                    break;
                }
                break;
            case 96432:
                if (a.equals("ads")) {
                    obj = 85;
                    break;
                }
                break;
            case 110379:
                if (a.equals("otp")) {
                    obj = 128;
                    break;
                }
                break;
            case 3138974:
                if (a.equals("feed")) {
                    obj = 57;
                    break;
                }
                break;
            case 3344023:
                if (a.equals("maps")) {
                    obj = 139;
                    break;
                }
                break;
            case 3433103:
                if (a.equals("page")) {
                    obj = 99;
                    break;
                }
                break;
            case 73835324:
                if (a.equals("live_sport_event")) {
                    obj = 148;
                    break;
                }
                break;
            case 96891546:
                if (a.equals("event")) {
                    obj = 71;
                    break;
                }
                break;
            case 98629247:
                if (a.equals("group")) {
                    obj = 122;
                    break;
                }
                break;
            case 106426308:
                if (a.equals("pages")) {
                    obj = 98;
                    break;
                }
                break;
            case 106642994:
                if (a.equals("photo")) {
                    obj = 101;
                    break;
                }
                break;
            case 106847226:
                if (a.equals("pokes")) {
                    obj = 21;
                    break;
                }
                break;
            case 109211271:
                if (a.equals("saved")) {
                    obj = 146;
                    break;
                }
                break;
            case 109413437:
                if (a.equals("shops")) {
                    obj = 23;
                    break;
                }
                break;
            case 112202875:
                if (a.equals("video")) {
                    obj = 76;
                    break;
                }
                break;
            case 129572246:
                if (a.equals("photosbycategory")) {
                    obj = 137;
                    break;
                }
                break;
            case 151708515:
                if (a.equals("zero_interstitial")) {
                    obj = 65;
                    break;
                }
                break;
            case 204715786:
                if (a.equals("localsell_initial_message")) {
                    obj = 9;
                    break;
                }
                break;
            case 371916942:
                if (a.equals("page_link_menu_management")) {
                    obj = 97;
                    break;
                }
                break;
            case 418646840:
                if (a.equals("store_locator")) {
                    obj = 150;
                    break;
                }
                break;
            case 432582976:
                if (a.equals("dialtone_info_screen")) {
                    obj = 156;
                    break;
                }
                break;
            case 482127632:
                if (a.equals("nearbyInfoSettings")) {
                    obj = 142;
                    break;
                }
                break;
            case 546894160:
                if (a.equals("policies")) {
                    obj = 133;
                    break;
                }
                break;
            case 572840673:
                if (a.equals("{method}")) {
                    obj = 69;
                    break;
                }
                break;
            case 697547724:
                if (a.equals("hashtag")) {
                    obj = 75;
                    break;
                }
                break;
            case 716762823:
                if (a.equals("app_section")) {
                    obj = 83;
                    break;
                }
                break;
            case 733085641:
                if (a.equals("fb_photos_picker")) {
                    obj = 29;
                    break;
                }
                break;
            case 759894283:
                if (a.equals("fundraiser")) {
                    obj = 149;
                    break;
                }
                break;
            case 804330854:
                if (a.equals("carrier_manager")) {
                    obj = 155;
                    break;
                }
                break;
            case 862878436:
                if (a.equals("event_creation")) {
                    obj = 43;
                    break;
                }
                break;
            case 889124643:
                if (a.equals("menu_management")) {
                    obj = 96;
                    break;
                }
                break;
            case 950398559:
                if (a.equals("comment")) {
                    obj = 117;
                    break;
                }
                break;
            case 954101670:
                if (a.equals("background_location")) {
                    obj = 109;
                    break;
                }
                break;
            case 989872040:
                if (a.equals("albums_edit_flow")) {
                    obj = 28;
                    break;
                }
                break;
            case 996315636:
                if (a.equals("marketplace_notifications")) {
                    obj = 12;
                    break;
                }
                break;
            case 1073544103:
                if (a.equals("search_typeahead_results")) {
                    obj = 17;
                    break;
                }
                break;
            case 1091538423:
                if (a.equals("localsell_forsalegroupshome_story")) {
                    obj = 121;
                    break;
                }
                break;
            case 1099953179:
                if (a.equals("reviews")) {
                    obj = 145;
                    break;
                }
                break;
            case 1145902948:
                if (a.equals("data_savings_mode_settings")) {
                    obj = 77;
                    break;
                }
                break;
            case 1147382305:
                if (a.equals("feed_awesomizer")) {
                    obj = 116;
                    break;
                }
                break;
            case 1220955446:
                if (a.equals("facewebmodal")) {
                    obj = 95;
                    break;
                }
                break;
            case 1224424441:
                if (a.equals("webview")) {
                    obj = 151;
                    break;
                }
                break;
            case 1235271283:
                if (a.equals("moments")) {
                    obj = 152;
                    break;
                }
                break;
            case 1241999318:
                if (a.equals("profileshare")) {
                    obj = 119;
                    break;
                }
                break;
            case 1250748482:
                if (a.equals("placelist_map")) {
                    obj = 112;
                    break;
                }
                break;
            case 1254520717:
                if (a.equals("structured_menu")) {
                    obj = 136;
                    break;
                }
                break;
            case 1272354024:
                if (a.equals("notifications")) {
                    obj = 62;
                    break;
                }
                break;
            case 1322280310:
                if (a.equals("profilepictureupload")) {
                    obj = 30;
                    break;
                }
                break;
            case 1353627255:
                if (a.equals("backstage")) {
                    obj = 110;
                    break;
                }
                break;
            case 1406085618:
                if (a.equals("friends_day")) {
                    obj = 2;
                    break;
                }
                break;
            case 1427882313:
                if (a.equals("appinvites")) {
                    obj = 108;
                    break;
                }
                break;
            case 1434631203:
                if (a.equals("settings")) {
                    obj = 126;
                    break;
                }
                break;
            case 1451192573:
                if (a.equals("adsmanager")) {
                    obj = null;
                    break;
                }
                break;
            case 1584405253:
                if (a.equals("localsell_message")) {
                    obj = 10;
                    break;
                }
                break;
            case 1618258656:
                if (a.equals("instant_shopping_catalog")) {
                    obj = 89;
                    break;
                }
                break;
            case 1731853244:
                if (a.equals("boost_post")) {
                    obj = 35;
                    break;
                }
                break;
            case 1734673890:
                if (a.equals("localsell_composer")) {
                    obj = 7;
                    break;
                }
                break;
            case 1751021512:
                if (a.equals("native_post")) {
                    obj = 59;
                    break;
                }
                break;
            case 1756153640:
                if (a.equals("marketplace_your_items")) {
                    obj = 19;
                    break;
                }
                break;
            case 1792729893:
                if (a.equals("placefeed")) {
                    obj = 78;
                    break;
                }
                break;
            case 1826397033:
                if (a.equals("pagesmanager")) {
                    obj = 141;
                    break;
                }
                break;
            case 1874684019:
                if (a.equals("platform")) {
                    obj = 127;
                    break;
                }
                break;
            case 1892280409:
                if (a.equals("ads_experience")) {
                    obj = 105;
                    break;
                }
                break;
            case 1943955894:
                if (a.equals("appcenter")) {
                    obj = 129;
                    break;
                }
                break;
            case 1945463715:
                if (a.equals("offersite")) {
                    obj = 26;
                    break;
                }
                break;
            case 1957569947:
                if (a.equals("install")) {
                    obj = 132;
                    break;
                }
                break;
            case 1962982606:
                if (a.equals("native_article")) {
                    obj = 124;
                    break;
                }
                break;
            case 1983498539:
                if (a.equals("getgames")) {
                    obj = 140;
                    break;
                }
                break;
            case 1990813228:
                if (a.equals("placeTipsUpsell")) {
                    obj = 143;
                    break;
                }
                break;
            case 2037187069:
                if (a.equals("bookmarks")) {
                    obj = 92;
                    break;
                }
                break;
            case 2081931542:
                if (a.equals("friending_possibilities")) {
                    obj = 45;
                    break;
                }
                break;
            case 2137879294:
                if (a.equals("boost_event")) {
                    obj = 36;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                intent2 = FbReactNavigationUriIntentBuilder.m19920a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 1:
                intent2 = FbReactNavigationUriIntentBuilder.m19920a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 2:
                intent2 = FbReactNavigationUriIntentBuilder.m19920a(injectorLike).a(context, str);
                if (intent2 == null) {
                    intent2 = GoodwillUriIntentBuilder.m21992a(injectorLike).a(context, str);
                    if (intent2 != null) {
                        break;
                    }
                }
                break;
            case 3:
                intent2 = FbReactNavigationUriIntentBuilder.m19920a(injectorLike).a(context, str);
                if (intent2 == null) {
                    intent2 = GoodwillUriIntentBuilder.m21992a(injectorLike).a(context, str);
                    if (intent2 != null) {
                        break;
                    }
                }
                break;
            case 4:
                intent2 = FbReactNavigationUriIntentBuilder.m19920a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 5:
                intent2 = FbReactNavigationUriIntentBuilder.m19920a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 6:
                intent2 = FbReactNavigationUriIntentBuilder.m19920a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 7:
                intent2 = FbReactNavigationUriIntentBuilder.m19920a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 8:
                intent2 = FbReactNavigationUriIntentBuilder.m19920a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 9:
                intent2 = FbReactNavigationUriIntentBuilder.m19920a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 10:
                intent2 = FbReactNavigationUriIntentBuilder.m19920a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 11:
                intent2 = FbReactNavigationUriIntentBuilder.m19920a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 12:
                intent2 = FbReactNavigationUriIntentBuilder.m19920a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 13:
                intent2 = FbReactNavigationUriIntentBuilder.m19920a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 14:
                intent2 = FbReactNavigationUriIntentBuilder.m19920a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 15:
                intent2 = FbReactNavigationUriIntentBuilder.m19920a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 16:
                intent2 = FbReactNavigationUriIntentBuilder.m19920a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 17:
                intent2 = FbReactNavigationUriIntentBuilder.m19920a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 18:
                intent2 = FbReactNavigationUriIntentBuilder.m19920a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 19:
                intent2 = FbReactNavigationUriIntentBuilder.m19920a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 20:
                intent2 = FbReactNavigationUriIntentBuilder.m19920a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 21:
                intent2 = FbReactNavigationUriIntentBuilder.m19920a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 22:
                intent2 = FbReactNavigationUriIntentBuilder.m19920a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 23:
                intent2 = FbReactNavigationUriIntentBuilder.m19920a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 24:
                intent2 = FbReactNavigationUriIntentBuilder.m19920a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 25:
                intent2 = OffersUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 26:
                intent2 = OffersUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 27:
                intent2 = PhotosUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 28:
                intent2 = PhotosUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 29:
                intent2 = PhotosUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 30:
                intent2 = PhotosUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 31:
                intent2 = PhotosUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 32:
                intent2 = PhotosUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 33:
                intent2 = PhotosUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 34:
                intent2 = PhotosUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 35:
                intent2 = AdInterfacesUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 36:
                intent2 = AdInterfacesUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 37:
                intent2 = AdInterfacesUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 38:
                intent2 = AdInterfacesUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 39:
                intent2 = AdInterfacesUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 40:
                intent2 = AdInterfacesUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 41:
                intent2 = AdInterfacesUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 42:
                intent2 = EventsUriIntentBuilder.m19913a(injectorLike).a(context, str);
                if (intent2 == null) {
                    intent2 = EventsReactionUriIntentBuilder.m19297a(injectorLike).a(context, str);
                    if (intent2 != null) {
                        break;
                    }
                }
                break;
            case 43:
                intent2 = EventsUriIntentBuilder.m19913a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 44:
                intent2 = GrowthUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 45:
                intent2 = GrowthUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 46:
                intent2 = GrowthUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 47:
                intent2 = GrowthUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 48:
                intent2 = FriendsUriIntentBuilder.m1244a(injectorLike).a(context, str);
                if (intent2 == null) {
                    intent2 = FriendsCenterUriIntentBuilder.m20490a(injectorLike).a(context, str);
                    if (intent2 == null) {
                        intent2 = ImmersivePeopleYouMayKnowUriIntentBuilder.m20530a(injectorLike).a(context, str);
                        if (intent2 != null) {
                            break;
                        }
                    }
                }
                break;
            case 49:
                intent2 = FriendsUriIntentBuilder.m1244a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 50:
                intent2 = FriendsUriIntentBuilder.m1244a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 51:
                intent2 = PrivacyCheckupUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 52:
                intent2 = PrivacyCheckupUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 53:
                intent2 = PrivacyCheckupUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 54:
                intent2 = PrivacyCheckupUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 55:
                intent2 = PrivacyCheckupUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 56:
                intent2 = CommercePublishingUriIntentBuilder.m15975a(injectorLike).a(context, str);
                if (intent2 == null) {
                    intent2 = StorefrontUriIntentBuilder.m16254a(injectorLike).a(context, str);
                    if (intent2 == null) {
                        intent2 = ProductDetailsUriIntentBuilder.m15904a(injectorLike).a(context, str);
                        if (intent2 != null) {
                            break;
                        }
                    }
                }
                break;
            case 57:
                intent2 = NewsFeedIntentUriBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 58:
                intent2 = NewsFeedIntentUriBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 59:
                intent2 = NewsFeedIntentUriBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 60:
                intent2 = NotificationsUriIntentBuilder.m1258a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 61:
                intent2 = NotificationsUriIntentBuilder.m1258a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 62:
                intent2 = NotificationsUriIntentBuilder.m1258a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 63:
                intent2 = NotificationsUriIntentBuilder.m1258a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 64:
                intent2 = SearchUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 65:
                intent2 = ZeroInterstitialIntentUriBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 66:
                intent2 = ZeroInterstitialIntentUriBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 67:
                intent2 = ZeroInterstitialIntentUriBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 68:
                intent2 = ZeroInterstitialIntentUriBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 69:
                intent2 = AdsManagerRedirectUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 70:
                intent2 = ComposerShareUriIntentBuilder.m16296a(injectorLike).a(context, str);
                if (intent2 == null) {
                    intent2 = ComposerTopicsUriIntentBuilder.a(injectorLike).a(context, str);
                    if (intent2 == null) {
                        intent2 = FacecastUriIntentBuilder.a(injectorLike).a(context, str);
                        if (intent2 == null) {
                            intent2 = ForSalePostUriIntentBuilder.m22180a(injectorLike).a(context, str);
                            if (intent2 != null) {
                                break;
                            }
                        }
                    }
                }
                break;
            case 71:
                intent2 = EventsInviteFriendsUriIntentBuilder.m19902a(injectorLike).a(context, str);
                if (intent2 == null) {
                    intent2 = EventMessageFriendsUriIntentBuilder.m18949a(injectorLike).a(context, str);
                    if (intent2 == null) {
                        intent2 = EventsPermalinkUriIntentBuilder.m19909a(injectorLike).a(context, str);
                        if (intent2 != null) {
                            break;
                        }
                    }
                }
                break;
            case 72:
                intent2 = FriendsNearbyUriIntentBuilder.m20811a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 73:
                intent2 = FriendsNearbyUriIntentBuilder.m20811a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 74:
                intent2 = GoodwillUriIntentBuilder.m21992a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 75:
                intent2 = HashtagUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 76:
                intent2 = VideoUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 77:
                intent2 = DataSavingsModeUriIntentBuilder.m1237a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 78:
                intent2 = ReactionUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 79:
                intent2 = ReactionUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 80:
                intent2 = SocialGoodUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 81:
                intent2 = SocialGoodUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 82:
                intent2 = CollectionsUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 == null) {
                    intent2 = ProfileVideoUriIntentBuilder.a(injectorLike).a(context, str);
                    if (intent2 == null) {
                        intent2 = FriendListUriIntentBuilder.m20621a(injectorLike).a(context, str);
                        if (intent2 == null) {
                            intent2 = InfoRequestUriIntentBuilder.m8474a(injectorLike).a(context, str);
                            if (intent2 != null) {
                                break;
                            }
                        }
                    }
                }
                break;
            case 83:
                intent2 = CollectionsUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 84:
                intent2 = CollectionsUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 85:
                intent2 = AdPreviewUriIntentBuilder.m14162a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 86:
                intent2 = LiteUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 87:
                intent2 = FB4AGroupsDiscoverUriIntentBuilder.m23079a(injectorLike).a(context, str);
                if (intent2 == null) {
                    intent2 = FB4AGroupsReactUriIntentBuilder.a(injectorLike).a(context, str);
                    if (intent2 == null) {
                        intent2 = FB4AAddToGroupsIntentUriBuilder.m312a(injectorLike).a(context, str);
                        if (intent2 == null) {
                            intent2 = FB4AGroupsCreateIntentUriBuilder.a(injectorLike).a(context, str);
                            if (intent2 == null) {
                                intent2 = GroupsDocsAndFilesUriIntentBuilder.m23082a(injectorLike).a(context, str);
                                if (intent2 == null) {
                                    intent2 = FB4AGroupEventsUriIntentBuilder.m23085a(injectorLike).a(context, str);
                                    if (intent2 == null) {
                                        intent2 = FB4AGroupMembershipUriIntentBuilder.m23087a(injectorLike).a(context, str);
                                        if (intent2 == null) {
                                            intent2 = FB4AGroupSubscriptionUriIntentBuilder.m23090a(injectorLike).a(context, str);
                                            if (intent2 == null) {
                                                intent2 = PendingPostsIntentUriBuilder.m23093a(injectorLike).a(context, str);
                                                if (intent2 == null) {
                                                    intent2 = FB4APhotosUriIntentBuilder.m23095a(injectorLike).a(context, str);
                                                    if (intent2 == null) {
                                                        intent2 = MemberRequestsIntentUriBuilder.m24040a(injectorLike).a(context, str);
                                                        if (intent2 != null) {
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case 88:
                intent2 = FB4AGroupsDiscoverUriIntentBuilder.m23079a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 89:
                intent2 = InstantShoppingUriIntentBuilder.m24791a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 90:
                intent2 = InstantShoppingUriIntentBuilder.m24791a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 91:
                intent2 = NearbyPlacesUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 == null) {
                    intent2 = NearbyPlacesFallbackUriIntentBuilder.a(injectorLike).a(context, str);
                    if (intent2 == null) {
                        intent2 = SubcategorySelectionUriIntentBuilder.a(injectorLike).a(context, str);
                        if (intent2 != null) {
                            break;
                        }
                    }
                }
                break;
            case 92:
                intent2 = BookmarkIntentUriBuilder.m1235a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 93:
                intent2 = BookmarkIntentUriBuilder.m1235a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 94:
                intent2 = FacewebUriIntentBuilder.m1242a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 95:
                intent2 = FacewebUriIntentBuilder.m1242a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 96:
                intent2 = PageMenuManagementUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 97:
                intent2 = PageMenuManagementUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 98:
                intent2 = PagesBrowserUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 == null) {
                    intent2 = EditPageUriIntentBuilder.a(injectorLike).a(context, str);
                    if (intent2 == null) {
                        intent2 = PagesLaunchpointUriIntentBuilder.a(injectorLike).a(context, str);
                        if (intent2 != null) {
                            break;
                        }
                    }
                }
                break;
            case 99:
                intent2 = PageIdentityUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 == null) {
                    intent2 = SuggestEditsUriIntentBuilder.a(injectorLike).a(context, str);
                    if (intent2 == null) {
                        intent2 = PageInviterUriIntentBuilder.a(injectorLike).a(context, str);
                        if (intent2 == null) {
                            intent2 = PagesFb4aAdminActivityUriIntentBuilder.a(injectorLike).a(context, str);
                            if (intent2 == null) {
                                intent2 = PagesFb4aMessagingUriIntentBuilder.m8338a(injectorLike).a(context, str);
                                if (intent2 == null) {
                                    intent2 = DefaultPageUriIntentBuilder.a(injectorLike).a(context, str);
                                    if (intent2 != null) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case 100:
                intent2 = PageIdentityUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 101:
                intent2 = MediaGalleryUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 102:
                intent2 = QuickPromotionUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 103:
                intent2 = AssistedOnboardingIntentUriBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 104:
                intent2 = AssistedOnboardingIntentUriBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 105:
                intent2 = AdsExperienceUriIntentBuilder.m14500a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 106:
                intent2 = APlaceForUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 107:
                intent2 = AppFeedUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 108:
                intent2 = AppInvitesUriIntentBuilder.m14714a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 109:
                intent2 = BackgroundLocationNuxUriIntentBuilder.m15137a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 110:
                intent2 = BackstageReplyUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 == null) {
                    intent2 = BackstageStackUriIntentBuilder.a(injectorLike).a(context, str);
                    if (intent2 != null) {
                        break;
                    }
                }
                break;
            case 111:
                intent2 = SocialSearchConversionUriIntentBuilder.m15627a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 112:
                intent2 = SocialSearchMapFragmentAndUriIntentBuilder.m15638a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 113:
                intent2 = AccountConfirmationUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 114:
                intent2 = DialtoneIntentUriBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 115:
                intent2 = BirthdaysUriIntentBuilder.m17298b(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 116:
                intent2 = FeedAwesomizerUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 117:
                intent2 = CommentUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 118:
                intent2 = SocialPromptInviteFriendsUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 119:
                intent2 = ProfileShareUriIntentBuilder.m20568a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 120:
                intent2 = FriendingSuggestionUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 121:
                intent2 = CrossGroupForSalePostsFeedIntentUriBuilder.m23108a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 122:
                intent2 = GroupFeedIntentUriBuilder.m23112a(injectorLike).a(context, str);
                if (intent2 == null) {
                    intent2 = GroupFeedYourPostsIntentUriBuilder.m23114a(injectorLike).a(context, str);
                    if (intent2 == null) {
                        intent2 = MemberPickerIntentUriBuilder.a(injectorLike).a(context, str);
                        if (intent2 != null) {
                            break;
                        }
                    }
                }
                break;
            case 123:
                intent2 = DelayBasedHttpQPRequestUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 124:
                intent2 = RichDocumentUriIntentBuilder.m587a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 125:
                intent2 = DBLLoggedInAccountSettingsUriIntentBuilder.m25402a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 126:
                intent2 = new SettingsIntentUriBuilder().a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 127:
                intent2 = PlatformFacewebUriIntentBuilder.m25597a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 128:
                intent2 = OtpUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 129:
                intent2 = AppcenterUriIntentBuilder.m1233a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 130:
                intent2 = ExternalLinkUriIntentBuilder.m1239a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 131:
                intent2 = PlatformUriIntentBuilder.m1261a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 132:
                intent2 = SelfUpdateUriIntentBuilder.m1263a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 133:
                intent2 = TermsAndPoliciesIntentUriBuilder.m1270a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 134:
                intent2 = ZeroDialogUriIntentBuilder.m1271a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 135:
                intent2 = AddPhotoMenuUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 == null) {
                    intent2 = PagePhotoMenuUriIntentBuilder.a(injectorLike).a(context, str);
                    if (intent2 != null) {
                        break;
                    }
                }
                break;
            case 136:
                intent2 = StructuredMenuUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 137:
                intent2 = PhotosByCategoryUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 138:
                intent2 = LookNowUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 139:
                intent2 = GenericMapsFragmentAndUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 140:
                intent2 = GetGamesNekoUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 141:
                intent2 = ManagedPageUriIntentBuilder.m8332a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 142:
                intent2 = PlaceTipsSettingsUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 143:
                intent2 = PlaceTipsUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 144:
                intent2 = DebugRapidFeedbackUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 145:
                intent2 = ReviewsUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 == null) {
                    intent2 = UserReviewsUriIntentBuilder.a(injectorLike).a(context, str);
                    if (intent2 == null) {
                        intent2 = ViewReviewUriIntentBuilder.a(injectorLike).a(context, str);
                        if (intent2 != null) {
                            break;
                        }
                    }
                }
                break;
            case 146:
                intent2 = SavedUriIntentBuilder.m9184a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 147:
                intent2 = SearchResultUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 148:
                intent2 = TrendingSportsUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 149:
                intent2 = FundraiserPageInviterUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 150:
                intent2 = StoreLocatorUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 151:
                intent2 = BrowserUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 152:
                intent2 = MomentsUpsellUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 153:
                intent2 = ChannelFeedUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 154:
                intent2 = VideoHomeUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 155:
                intent2 = CarrierManagerIntentUriBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 156:
                intent2 = DialtoneInfoScreenUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 157:
                intent2 = FreeFacebookSettingsUriIntentBuilder.a(injectorLike).a(context, str);
                if (intent2 != null) {
                    break;
                }
                break;
            case 158:
                intent2 = ZeroUpsellUriIntentBuilder.a(injectorLike).a(context, str);
                break;
        }
        Intent intent3 = intent2;
        uriMapPerfLogger.a(5701648, intent3 == null);
        if (intent3 != null) {
            z = true;
        } else {
            z = false;
        }
        Boolean.valueOf(z);
        if (intent3 == null) {
            uriMapPerfLogger.a(5701649, str);
            intent = intent3;
            for (UriIntentBuilder uriIntentBuilder : (Set) this.f1233a.get()) {
                intent3 = uriIntentBuilder.a(context, str);
                if (intent3 != null) {
                    String simpleName = uriIntentBuilder.getClass().getSimpleName();
                    uriMapPerfLogger.b(5701649, simpleName);
                    uriMapPerfLogger.a(5701649, false);
                    uriIntentBuilder.getClass().getSimpleName();
                    m1268b(simpleName);
                    return intent3;
                }
                intent = intent3;
            }
            uriMapPerfLogger.a(5701649, true);
        } else {
            intent = intent3;
        }
        return intent;
    }

    private static String m1266a(String str) {
        if (str == null || !str.contains("://")) {
            return str;
        }
        int indexOf = str.indexOf("://") + 3;
        int length = str.length();
        for (int i = indexOf; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '/' || charAt == '?' || charAt == '=') {
                return str.substring(indexOf, i);
            }
        }
        return str.substring(indexOf);
    }

    private void m1268b(String str) {
        AbstractFbErrorReporter abstractFbErrorReporter = this.f1234b;
        SoftErrorBuilder a = SoftError.a("GeneratedUriMap", str + " was missing in GeneratedUriMap");
        a.e = 10;
        a = a;
        a.f = true;
        abstractFbErrorReporter.a(a.g());
    }
}
