package com.facebook.reaction.action;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.adinterfaces.external.AdInterfacesIntentUtil;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.appads.analytics.AppFeedReferrer;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.commerce.core.util.CommerceNavigationUtil;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivity;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityFieldsModel.GlyphModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityFieldsModel.IconImageLargeModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityModel.AllIconsModel;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventActionContext;
import com.facebook.events.invite.common.EventInviteNavigationHelper;
import com.facebook.events.permalink.guestlist.common.EventGuestListType;
import com.facebook.events.permalink.guestlist.common.EventGuestSingleListModel;
import com.facebook.events.permalink.guestlist.common.EventsGuestListFragmentNavigationHelper;
import com.facebook.events.permalink.guestlist.common.EventsGuestListInitializationModel;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.friending.center.constants.FriendsCenterSource;
import com.facebook.friending.center.constants.FriendsCenterTabType;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEntityCardContextItemType;
import com.facebook.graphql.enums.GraphQLEventPrivacyType;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLFundraiserSupportersConnectionType;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.enums.GraphQLNearbyFriendsNuxType;
import com.facebook.graphql.enums.GraphQLPagePresenceTabType;
import com.facebook.graphql.enums.GraphQLPhotosByCategoryEntryPoint;
import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentActionStyle;
import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.GetEntityFbLinkGraphQL;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLInlineActivity;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLTaggableActivity;
import com.facebook.graphql.model.GraphQLTaggableActivityAllIconsConnection;
import com.facebook.graphql.model.GraphQLTaggableActivityIcon;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.intent.DefaultPluginConfigSerializer;
import com.facebook.ipc.composer.model.ComposerLocationInfo;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.feed.PermalinkStoryIdParams;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.maps.ExternalMapLauncher;
import com.facebook.maps.HereMapsUpsellDialogActivity;
import com.facebook.maps.HereMapsUpsellInterstitialController;
import com.facebook.maps.abtest.ExperimentsForMapsModule;
import com.facebook.messaging.sharing.sendasmessage.SendAsMessageUtil;
import com.facebook.nearby.common.NearbyTopic;
import com.facebook.nearby.common.SearchSuggestion;
import com.facebook.nearby.v2.logging.NearbyPlacesSession.EntryPoint;
import com.facebook.pages.common.constants.PagesConstants.URL;
import com.facebook.photos.albums.protocols.MediasetType;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel;
import com.facebook.photos.mediagallery.ui.MediaGalleryActivity;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel.Builder;
import com.facebook.qe.api.QeAccessor;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.event.ReactionUiEvents.ReactionEventsSeeAllPostsEvent;
import com.facebook.reaction.event.ReactionUiEvents.ReactionPageAddTabEvent;
import com.facebook.reaction.event.ReactionUiEvents.ReactionPageCreatePhotoAlbumEvent;
import com.facebook.reaction.event.ReactionUiEvents.ReactionPagePublishEvent;
import com.facebook.reaction.event.ReactionUiEvents.ReactionPageSeeAllEvent;
import com.facebook.reaction.event.ReactionUiEvents.ReactionPageViewPhotosOfPageAlbumEvent;
import com.facebook.reaction.event.ReactionUiEvents.ReactionPromotePageEvent;
import com.facebook.reaction.event.ReactionUiEvents.ReactionPymlSeeMoreEvent;
import com.facebook.reaction.event.ReactionUiEvents.ReactionSeePageAllMessagesEvent;
import com.facebook.reaction.event.ReactionUiEvents.ReactionSeePageInsightsEvent;
import com.facebook.reaction.event.ReactionUiEvents.ReactionSeePageProfileEvent;
import com.facebook.reaction.event.ReactionUiEvents.ReactionSendMessageAsPageEvent;
import com.facebook.reaction.event.ReactionUiEvents.ReactionViewPageSettingsEvent;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionProfileFields;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionImageFieldsModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionActionFatFields.RelatedUsers;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionViewEventGuestListActionFields.Event;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionActionFatFieldsModel.EventModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionActionFatFieldsModel.RelatedUsersModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionComposerActionFieldsModel.ComposerInlineActivityModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionComposerActionFieldsModel.ComposerInlineActivityModel.ObjectModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionComposerActionFieldsModel.ComposerInlineActivityModel.TaggableActivityIconModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionComposerActionFieldsModel.ComposerInlineActivityModel.TaggableActivityIconModel.ImageModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionComposerActionFieldsModel.EventSpaceModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionEventInviteFieldsModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionOpenNearbyPlacesActionFieldsModel.PlacesQueryLocationPageModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionReplacementUnitFieldsModel.ReplacementUnitModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionReplacementUnitFieldsModel.ReplacementUnitModel.ReactionUnitComponentsModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionConversionHelper;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.MessageModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.SubMessageModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentModel;
import com.facebook.reaction.util.ReactionSurfaceUtil;
import com.facebook.reviews.composer.config.ReviewComposerPluginConfig;
import com.facebook.reviews.intent.ReviewsListLauncher;
import com.facebook.search.intent.SearchResultsIntentBuilder;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.logging.api.SearchTypeaheadSession;
import com.facebook.socialgood.ipc.SocialGoodUtil;
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.video.activity.FullScreenVideoPlayerActivity;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: bqf */
public class ReactionIntentFactory {
    private static final InterstitialTrigger f18777a = new InterstitialTrigger(Action.MAPS_LAUNCH_EXTERNAL_MAP_APP);
    private static volatile ReactionIntentFactory f18778q;
    private final Lazy<CommerceNavigationUtil> f18779b;
    private final Provider<ComponentName> f18780c;
    private final EventInviteNavigationHelper f18781d;
    private final IFeedIntentBuilder f18782e;
    public final GraphQLLinkExtractor f18783f;
    private final Lazy<InterstitialManager> f18784g;
    private final Lazy<PagesReactionManager> f18785h;
    private final ReviewsListLauncher f18786i;
    private final SearchResultsIntentBuilder f18787j;
    private final SendAsMessageUtil f18788k;
    private final Lazy<UriIntentMapper> f18789l;
    private final ViewPermalinkIntentFactory f18790m;
    private final Lazy<QeAccessor> f18791n;
    private final Lazy<SocialGoodUtil> f18792o;
    private final ImmutableList<GraphQLReactionStoryAttachmentActionStyle> f18793p = ImmutableList.of(GraphQLReactionStoryAttachmentActionStyle.OPEN_URL, GraphQLReactionStoryAttachmentActionStyle.VIEW_PROFILE, GraphQLReactionStoryAttachmentActionStyle.SEND_MESSAGE);

    /* compiled from: bqf */
    /* synthetic */ class C20761 {
        static final /* synthetic */ int[] f18776a = new int[GraphQLNearbyFriendsNuxType.values().length];

        static {
            try {
                f18776a[GraphQLNearbyFriendsNuxType.NEARBY_FRIENDS_NUX.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18776a[GraphQLNearbyFriendsNuxType.INFORMATIONAL_NUX.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18776a[GraphQLNearbyFriendsNuxType.DASHBOARD_UPSELL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static com.facebook.reaction.action.ReactionIntentFactory m22683a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f18778q;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.action.ReactionIntentFactory.class;
        monitor-enter(r1);
        r0 = f18778q;	 Catch:{ all -> 0x003a }
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
        r0 = m22704b(r0);	 Catch:{ all -> 0x0035 }
        f18778q = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18778q;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.action.ReactionIntentFactory.a(com.facebook.inject.InjectorLike):com.facebook.reaction.action.ReactionIntentFactory");
    }

    private static ReactionIntentFactory m22704b(InjectorLike injectorLike) {
        return new ReactionIntentFactory(IdBasedLazy.a(injectorLike, 5054), IdBasedProvider.a(injectorLike, 12), EventInviteNavigationHelper.m13376b(injectorLike), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), GraphQLLinkExtractor.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2360), IdBasedLazy.a(injectorLike, 9840), ReviewsListLauncher.m25169a(injectorLike), SearchResultsIntentBuilder.a(injectorLike), SendAsMessageUtil.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2436), ViewPermalinkIntentFactory.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3219), IdBasedSingletonScopeProvider.b(injectorLike, 10988));
    }

    @Inject
    public ReactionIntentFactory(Lazy<CommerceNavigationUtil> lazy, @FragmentChromeActivity Provider<ComponentName> provider, EventInviteNavigationHelper eventInviteNavigationHelper, IFeedIntentBuilder iFeedIntentBuilder, GraphQLLinkExtractor graphQLLinkExtractor, Lazy<InterstitialManager> lazy2, Lazy<PagesReactionManager> lazy3, ReviewsListLauncher reviewsListLauncher, SearchResultsIntentBuilder searchResultsIntentBuilder, SendAsMessageUtil sendAsMessageUtil, Lazy<UriIntentMapper> lazy4, ViewPermalinkIntentFactory viewPermalinkIntentFactory, Lazy<QeAccessor> lazy5, Lazy<SocialGoodUtil> lazy6) {
        this.f18779b = lazy;
        this.f18780c = provider;
        this.f18781d = eventInviteNavigationHelper;
        this.f18782e = iFeedIntentBuilder;
        this.f18783f = graphQLLinkExtractor;
        this.f18784g = lazy2;
        this.f18785h = lazy3;
        this.f18786i = reviewsListLauncher;
        this.f18787j = searchResultsIntentBuilder;
        this.f18788k = sendAsMessageUtil;
        this.f18789l = lazy4;
        this.f18790m = viewPermalinkIntentFactory;
        this.f18791n = lazy5;
        this.f18792o = lazy6;
    }

    public final boolean m22753a(GraphQLReactionStoryAttachmentActionStyle graphQLReactionStoryAttachmentActionStyle) {
        return this.f18793p.contains(graphQLReactionStoryAttachmentActionStyle);
    }

    public static ReactionAttachmentIntent m22685a(Context context, String str, @Nullable String str2) {
        Builder builder = new Builder();
        builder.f = str;
        builder = builder;
        builder.h = str2;
        ComposerConfiguration a = ComposerConfigurationFactory.a(ComposerSourceSurface.REACTION, "addPhotosFromReaction").setInitialLocationInfo(ComposerLocationInfo.newBuilder().b(builder.a()).b()).a();
        SimplePickerLauncherConfiguration.Builder builder2 = new SimplePickerLauncherConfiguration.Builder(SimplePickerSource.REACTION);
        builder2.a = a;
        return new ReactionAttachmentIntent(str, UnitInteractionType.ADD_PHOTOS_AT_PLACE_TAP, SimplePickerIntent.a(context, builder2).putExtra("launch_activity_for_result", true).putExtra("reaction_request_code", 1756));
    }

    public final ReactionAttachmentIntent m22724a(@Nonnull Context context) {
        return new ReactionAttachmentIntent(null, UnitInteractionType.SEE_MORE_APPS_TAP, ((UriIntentMapper) this.f18789l.get()).a(context, FBLinks.dN).addFlags(268435456).putExtra("referrer", AppFeedReferrer.REACTION));
    }

    public static ReactionAttachmentIntent m22689a(Uri uri) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(uri);
        intent.putExtra("launch_external_activity", true);
        return new ReactionAttachmentIntent(null, UnitInteractionType.CALL_PHONE_TAP, intent);
    }

    public static ReactionAttachmentIntent m22687a(Context context, String str, String str2, String str3) {
        return new ReactionAttachmentIntent(null, UnitInteractionType.BOOST_POST_TAP, AdInterfacesIntentUtil.a(context, 2131234020, str2, str3, str, "pages_manager_overview_tab", false));
    }

    public static ReactionAttachmentIntent m22705b(Context context, String str, String str2, String str3) {
        return new ReactionAttachmentIntent(null, UnitInteractionType.VIEW_POST_INSIGHTS, AdInterfacesIntentUtil.a(context, 2131233525, "pages_manager_overview_tab", str2, AdInterfacesIntentUtil.a(context, 2131234020, str2, str3, str, "pages_manager_overview_tab", false)));
    }

    public final ReactionAttachmentIntent m22735a(ReactionSession reactionSession) {
        ReactionAttachmentIntent reactionAttachmentIntent = null;
        if (reactionSession != null) {
            Object J = reactionSession.m22551J();
            Object K = reactionSession.m22552K();
            if (!(TextUtils.isEmpty(J) || TextUtils.isEmpty(K))) {
                try {
                    reactionAttachmentIntent = m22784h(AdInterfacesIntentUtil.a(Long.toString(reactionSession.m22553L()), K, J, "aymt_hot_post_afterparty"));
                } catch (UnsupportedEncodingException e) {
                }
            }
        }
        return reactionAttachmentIntent;
    }

    @Nullable
    public final ReactionAttachmentIntent m22747a(String str, String str2, String str3) {
        GraphQLGraphSearchResultsDisplayStyle valueOf = GraphQLGraphSearchResultsDisplayStyle.valueOf(str);
        if (!SearchResultsIntentBuilder.a(valueOf)) {
            return null;
        }
        return new ReactionAttachmentIntent(null, UnitInteractionType.BROWSE_QUERY_TAP, this.f18787j.a(valueOf, str3, str2, "content", SearchResultsSource.y, SearchTypeaheadSession.a));
    }

    public static ReactionAttachmentIntent m22703a(@Nonnull String str, @Nullable String str2, @Nullable List<? extends RelatedUsers> list) {
        ComposerConfiguration.Builder c = ComposerConfigurationFactory.c(ComposerSourceType.REACTION);
        Builder builder = new Builder();
        builder.f = str;
        builder = builder;
        builder.h = str2;
        c.setReactionSurface(Surface.ANDROID_AFTER_PARTY_COMPOSER).setSourceType(ComposerSourceType.REACTION).setInitialLocationInfo(ComposerLocationInfo.newBuilder().b(builder.a()).b());
        if (list != null) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                RelatedUsersModel relatedUsersModel = (RelatedUsersModel) it.next();
                ComposerTaggedUser.Builder a = ComposerTaggedUser.a(Long.parseLong(relatedUsersModel.b()));
                a.b = relatedUsersModel.c();
                builder2.c(a.a());
            }
            c.setInitialTaggedUsers(builder2.b());
        }
        return new ReactionAttachmentIntent(str, UnitInteractionType.CHECKIN_TAP, new Intent().putExtra("composer_configuration", c.a()));
    }

    public final ReactionAttachmentIntent m22750a(String str, String str2, String str3, @Nullable String str4, @Nullable String str5) {
        Intent component = new Intent().setComponent((ComponentName) this.f18780c.get());
        component.putExtra("target_fragment", ContentFragmentType.FUNDRAISER_MESSAGE_GUESTS_FRAGMENT.ordinal());
        component.putExtra("fundraiser_campaign_id", str2);
        component.putExtra("fundraiser_title", str);
        component.putExtra("owner_profile_picture_url", str5);
        component.putExtra("extra_fundraiser_subtitle", str3);
        component.putExtra("extra_fundraiser_progress_text", str4);
        return new ReactionAttachmentIntent(str2, UnitInteractionType.CONTACT_FUNDRAISER_SUPPORTERS, component);
    }

    @Nullable
    public final ReactionAttachmentIntent m22734a(GetEntityFbLinkGraphQL getEntityFbLinkGraphQL) {
        String a = this.f18783f.a(getEntityFbLinkGraphQL);
        if (Strings.isNullOrEmpty(a)) {
            return null;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(a));
        return new ReactionAttachmentIntent(getEntityFbLinkGraphQL.d(), UnitInteractionType.TEXT_ENTITY_TAP, intent);
    }

    @Nullable
    public final ReactionAttachmentIntent m22732a(GraphQLEventWatchStatus graphQLEventWatchStatus, Event event) {
        if (event.g() == null) {
            return null;
        }
        boolean z = event.fD_() != null && event.fD_().a();
        EventsGuestListInitializationModel.Builder builder = new EventsGuestListInitializationModel.Builder(event.g());
        builder.f11457a = EventActionContext.c;
        EventsGuestListInitializationModel.Builder builder2 = builder;
        builder2.f11459c = event.fC_();
        builder2 = builder2;
        builder2.f11460d = event.c();
        builder2 = builder2;
        builder2.f11461e = event.b();
        builder2 = builder2;
        builder2.f11462f = event.k();
        builder2 = builder2;
        builder2.f11463g = z;
        builder2 = builder2;
        GraphQLConnectionStyle b = event.b();
        GraphQLEventPrivacyType c = event.c();
        ImmutableList of = b == GraphQLConnectionStyle.INTERESTED ? ImmutableList.of(new EventGuestSingleListModel(EventGuestListType.PUBLIC_WATCHED), new EventGuestSingleListModel(EventGuestListType.PUBLIC_GOING), new EventGuestSingleListModel(EventGuestListType.PUBLIC_INVITED)) : ((c == GraphQLEventPrivacyType.PRIVATE_TYPE || c == GraphQLEventPrivacyType.GROUP) && z) ? ImmutableList.of(new EventGuestSingleListModel(EventGuestListType.PRIVATE_GOING), new EventGuestSingleListModel(EventGuestListType.PRIVATE_MAYBE), new EventGuestSingleListModel(EventGuestListType.PRIVATE_INVITED), new EventGuestSingleListModel(EventGuestListType.PRIVATE_NOT_GOING)) : ImmutableList.of(new EventGuestSingleListModel(EventGuestListType.PRIVATE_GOING), new EventGuestSingleListModel(EventGuestListType.PRIVATE_MAYBE), new EventGuestSingleListModel(EventGuestListType.PRIVATE_INVITED));
        builder2.f11464h = of;
        builder2.f11465i = false;
        Bundle a = EventsGuestListFragmentNavigationHelper.m13379a(builder.m13391a(), graphQLEventWatchStatus == GraphQLEventWatchStatus.WATCHED ? EventGuestListType.PUBLIC_WATCHED : EventGuestListType.PUBLIC_GOING);
        Intent component = new Intent().setComponent((ComponentName) this.f18780c.get());
        component.putExtras(a);
        component.putExtra("target_fragment", ContentFragmentType.EVENTS_GUEST_LIST_FRAGMENT.ordinal());
        return new ReactionAttachmentIntent(event.g(), UnitInteractionType.VIEW_EVENT_GUEST_LIST, component);
    }

    public final ReactionAttachmentIntent m22755b(Context context) {
        return new ReactionAttachmentIntent(null, UnitInteractionType.VIEW_EVENTS_DASHBOARD_TAP, ((UriIntentMapper) this.f18789l.get()).a(context, FBLinks.by));
    }

    public final ReactionAttachmentIntent m22738a(String str) {
        return m22712c(FBLinks.t, str, UnitInteractionType.EVENT_CARD_TAP);
    }

    public final ReactionAttachmentIntent m22730a(Context context, String str, @Nullable ReactionAnalyticsParams reactionAnalyticsParams) {
        return new ReactionAttachmentIntent(str, UnitInteractionType.EVENT_CARD_TAP, ((UriIntentMapper) this.f18789l.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.t, str)).putExtra("extra_reaction_analytics_params", reactionAnalyticsParams));
    }

    public final ReactionAttachmentIntent m22758b(Context context, String str, String str2) {
        Intent b = this.f18788k.b(context, str2, true, true, "event_invite_sheet_reaction");
        if (b == null) {
            return null;
        }
        return new ReactionAttachmentIntent(str, UnitInteractionType.EVENT_MESSAGE_FRIENDS, b);
    }

    public final ReactionAttachmentIntent m22737a(EventModel eventModel, String str) {
        String b;
        String str2 = null;
        Set hashSet = new HashSet();
        hashSet.add(str);
        SendAsMessageUtil sendAsMessageUtil = this.f18788k;
        String g = eventModel.g();
        String fC_ = eventModel.fC_();
        if (eventModel.j() != null) {
            b = eventModel.j().b();
        } else {
            b = null;
        }
        if (eventModel.d() != null) {
            str2 = eventModel.d().b();
        }
        return new ReactionAttachmentIntent(eventModel.g(), UnitInteractionType.EVENT_MESSAGE_FRIENDS, sendAsMessageUtil.a(g, fC_, b, str2, eventModel.fB_(), hashSet, "event"));
    }

    public final ReactionAttachmentIntent m22759b(String str) {
        return m22712c(FBLinks.bO, str, UnitInteractionType.EVENT_MESSAGE_FRIENDS);
    }

    public final ReactionAttachmentIntent m22766c(String str) {
        return m22712c(FBLinks.bP, str, UnitInteractionType.EVENT_MESSAGE_FRIENDS);
    }

    @Nullable
    public static ReactionAttachmentIntent m22691a(@Nonnull VideoDetailFragmentModel videoDetailFragmentModel, Context context) {
        if (videoDetailFragmentModel.v() == null || videoDetailFragmentModel.j() == null || videoDetailFragmentModel.F() == null || videoDetailFragmentModel.F().b() == null) {
            return null;
        }
        Intent a = FullScreenVideoPlayerActivity.m11245a(context, PlayerOrigin.REACTION_OVERLAY);
        FlatBufferModelHelper.a(a, "video_graphql_object", videoDetailFragmentModel);
        return new ReactionAttachmentIntent(videoDetailFragmentModel.j(), UnitInteractionType.VIDEO_TAP, a);
    }

    public static ReactionAttachmentIntent m22692a(ComposerInlineActivityModel composerInlineActivityModel, @Nullable String str) {
        GraphQLInlineActivity graphQLInlineActivity;
        GraphQLEntity a = GraphQLHelper.a(composerInlineActivityModel.c().c(), composerInlineActivityModel.c().b(), composerInlineActivityModel.c().fH_());
        ComposerConfiguration.Builder initialTargetData = ComposerConfigurationFactory.a(ComposerSourceSurface.REACTION, str).setInitialTargetData(ComposerTargetData.a);
        if (composerInlineActivityModel == null) {
            graphQLInlineActivity = null;
        } else {
            GraphQLNode graphQLNode;
            GraphQLTaggableActivity graphQLTaggableActivity;
            GraphQLImage graphQLImage;
            GraphQLImage.Builder builder;
            GraphQLTaggableActivityIcon graphQLTaggableActivityIcon;
            GraphQLInlineActivity.Builder builder2 = new GraphQLInlineActivity.Builder();
            builder2.d = composerInlineActivityModel.b();
            ObjectModel c = composerInlineActivityModel.c();
            if (c == null) {
                graphQLNode = null;
            } else {
                GraphQLNode.Builder builder3 = new GraphQLNode.Builder();
                builder3.kQ = c.b();
                builder3.dK = c.c();
                builder3.fw = c.d();
                builder3.kf = c.fH_();
                graphQLNode = builder3.a();
            }
            builder2.e = graphQLNode;
            MinutiaeTaggableActivity d = composerInlineActivityModel.d();
            if (d == null) {
                graphQLTaggableActivity = null;
            } else {
                GraphQLTaggableActivityAllIconsConnection graphQLTaggableActivityAllIconsConnection;
                GraphQLTaggableActivity.Builder builder4 = new GraphQLTaggableActivity.Builder();
                AllIconsModel B = d.B();
                if (B == null) {
                    graphQLTaggableActivityAllIconsConnection = null;
                } else {
                    GraphQLTaggableActivityAllIconsConnection.Builder builder5 = new GraphQLTaggableActivityAllIconsConnection.Builder();
                    builder5.d = B.a();
                    graphQLTaggableActivityAllIconsConnection = builder5.a();
                }
                builder4.d = graphQLTaggableActivityAllIconsConnection;
                GlyphModel A = d.A();
                if (A == null) {
                    graphQLImage = null;
                } else {
                    builder = new GraphQLImage.Builder();
                    builder.g = A.a();
                    graphQLImage = builder.a();
                }
                builder4.e = graphQLImage;
                IconImageLargeModel z = d.z();
                if (z == null) {
                    graphQLImage = null;
                } else {
                    builder = new GraphQLImage.Builder();
                    builder.g = z.a();
                    graphQLImage = builder.a();
                }
                builder4.f = graphQLImage;
                builder4.g = d.j();
                builder4.h = d.k();
                builder4.i = d.l();
                builder4.j = d.m();
                builder4.k = d.n();
                builder4.l = ReactionConversionHelper.a(d.y());
                builder4.m = ReactionConversionHelper.a(d.x());
                builder4.n = ReactionConversionHelper.a(d.w());
                builder4.o = ReactionConversionHelper.a(d.v());
                builder4.p = ReactionConversionHelper.a(d.u());
                builder4.q = ReactionConversionHelper.a(d.t());
                builder4.r = d.o();
                builder4.s = d.p();
                builder4.t = d.q();
                builder4.u = d.r();
                graphQLTaggableActivity = builder4.a();
            }
            builder2.f = graphQLTaggableActivity;
            TaggableActivityIconModel fG_ = composerInlineActivityModel.fG_();
            if (fG_ == null) {
                graphQLTaggableActivityIcon = null;
            } else {
                GraphQLTaggableActivityIcon.Builder builder6 = new GraphQLTaggableActivityIcon.Builder();
                ImageModel a2 = fG_.a();
                if (a2 == null) {
                    graphQLImage = null;
                } else {
                    builder = new GraphQLImage.Builder();
                    builder.g = a2.a();
                    graphQLImage = builder.a();
                }
                builder6.f = graphQLImage;
                graphQLTaggableActivityIcon = builder6.a();
            }
            builder2.g = graphQLTaggableActivityIcon;
            graphQLInlineActivity = builder2.a();
        }
        return new ReactionAttachmentIntent(composerInlineActivityModel.b(), UnitInteractionType.OPEN_COMPOSER_TAP, new Intent().putExtra("composer_configuration", initialTargetData.setMinutiaeObjectTag(MinutiaeObject.a(graphQLInlineActivity)).setIsFireAndForget(true).setInitialShareParams(ComposerShareParams.Builder.a(a).b()).a()));
    }

    public static ReactionAttachmentIntent m22693a(EventSpaceModel eventSpaceModel, @Nullable String str) {
        ComposerTargetData.Builder builder = new ComposerTargetData.Builder();
        builder.a = Long.parseLong(eventSpaceModel.b());
        builder = builder;
        builder.c = eventSpaceModel.c();
        builder = builder;
        builder.b = TargetType.EVENT;
        return new ReactionAttachmentIntent(eventSpaceModel.b(), UnitInteractionType.OPEN_COMPOSER_TAP, new Intent().putExtra("composer_configuration", ComposerConfigurationFactory.a(ComposerSourceSurface.REACTION, str).setInitialTargetData(builder.a(eventSpaceModel.d()).a()).setIsFireAndForget(true).a()));
    }

    public final ReactionAttachmentIntent m22771d(@Nonnull String str) {
        return m22712c(FBLinks.u, str, UnitInteractionType.VIEW_GROUP_TAP);
    }

    public final ReactionAttachmentIntent m22739a(String str, Context context) {
        Intent a = ((UriIntentMapper) this.f18789l.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.B, str));
        a.putExtra("group_feed_id", str);
        return new ReactionAttachmentIntent(str, UnitInteractionType.VIEW_GROUP_EVENTS_TAP, a);
    }

    public final ReactionAttachmentIntent m22760b(String str, Context context) {
        Intent a = ((UriIntentMapper) this.f18789l.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.C, str));
        a.putExtra("group_feed_id", str);
        return new ReactionAttachmentIntent(str, UnitInteractionType.VIEW_GROUP_PHOTOS_TAP, a);
    }

    public final ReactionAttachmentIntent m22743a(String str, ReactionEventInviteFieldsModel reactionEventInviteFieldsModel) {
        EventInviteNavigationHelper eventInviteNavigationHelper = this.f18781d;
        String d = reactionEventInviteFieldsModel.d();
        String b = reactionEventInviteFieldsModel.fI_() != null ? reactionEventInviteFieldsModel.fI_().b() : null;
        GraphQLEventPrivacyType b2 = reactionEventInviteFieldsModel.b();
        boolean z = reactionEventInviteFieldsModel.c() != null && reactionEventInviteFieldsModel.c().a();
        Intent a = eventInviteNavigationHelper.m13377a(d, b, b2, z, str);
        a.putExtra("launch_activity_for_result", true);
        a.putExtra("reaction_request_code", 501);
        return new ReactionAttachmentIntent(reactionEventInviteFieldsModel.d(), UnitInteractionType.INVITE_FRIENDS_TO_EVENT, a);
    }

    public final ReactionAttachmentIntent m22775e(String str) {
        return m22712c(FBLinks.am, str, UnitInteractionType.OPEN_PAGE_INFO_TAP);
    }

    public final ReactionAttachmentIntent m22779f(String str) {
        return m22712c(URL.f1691c, str, UnitInteractionType.EDIT_PAGE_INFO_TAP);
    }

    public static ReactionAttachmentIntent m22700a(String str, String str2, String str3, ReactionAttachmentIntent reactionAttachmentIntent, UnitInteractionType unitInteractionType) {
        return new ReactionAttachmentIntent(str2, unitInteractionType, new ReactionPageSeeAllEvent(str, str2, str3, reactionAttachmentIntent));
    }

    public static ReactionAttachmentIntent m22698a(String str, String str2, UnitInteractionType unitInteractionType, String str3) {
        return new ReactionAttachmentIntent(str2, unitInteractionType, new ReactionPageCreatePhotoAlbumEvent(str, str3));
    }

    public static ReactionAttachmentIntent m22699a(String str, String str2, UnitInteractionType unitInteractionType, String str3, String str4) {
        return new ReactionAttachmentIntent(str2, unitInteractionType, new ReactionPageViewPhotosOfPageAlbumEvent(str, str3, str4));
    }

    public static ReactionAttachmentIntent m22696a(String str, String str2, GraphQLPagePresenceTabType graphQLPagePresenceTabType, ReactionAttachmentIntent reactionAttachmentIntent, UnitInteractionType unitInteractionType) {
        return new ReactionAttachmentIntent(str2, unitInteractionType, new ReactionPageAddTabEvent(str, str2, graphQLPagePresenceTabType, reactionAttachmentIntent));
    }

    public final ReactionAttachmentIntent m22745a(String str, String str2, Surface surface) {
        return new ReactionAttachmentIntent(str, UnitInteractionType.OPEN_LOCAL_SEARCH_TAP, this.f18787j.b(str, str2, SafeUUIDGenerator.a().toString(), SearchResultsSource.A, ReactionSurfaceUtil.m4784k(surface) ? Surface.ANDROID_SEARCH_LOCAL_LOCALSERP : Surface.ANDROID_SEARCH_LOCAL_OTHER, null));
    }

    @Nullable
    public final ReactionAttachmentIntent m22728a(Context context, @Nullable PlacesQueryLocationPageModel placesQueryLocationPageModel, @Nullable String str, @Nullable String str2) {
        Intent a = ((UriIntentMapper) this.f18789l.get()).a(context, FBLinks.bp);
        if (a == null) {
            return null;
        }
        if (!(Strings.isNullOrEmpty(str) || Strings.isNullOrEmpty(str2))) {
            NearbyTopic nearbyTopic = new NearbyTopic(Sets.a(new Long[]{Long.valueOf(Long.parseLong(str2))}), str);
            a.putExtra("result_place_search_suggestion", new SearchSuggestion(nearbyTopic.f15285a, nearbyTopic.f15285a, null, nearbyTopic));
        }
        a.putExtra("nearby_places_entry", EntryPoint.REACTION);
        a.putExtra("nearby_places_query_topic", str);
        if (placesQueryLocationPageModel != null) {
            a.putExtra("nearby_places_location_id", placesQueryLocationPageModel.b());
            a.putExtra("nearby_places_location_name", placesQueryLocationPageModel.c());
        }
        return new ReactionAttachmentIntent(null, UnitInteractionType.NEARBY_PLACES_TAP, a);
    }

    public final ReactionAttachmentIntent m22782g(@Nonnull String str) {
        return m22708b(StringFormatUtil.formatStrLocaleSafe(FBLinks.cQ, str), null, UnitInteractionType.NEARBY_FRIENDS_TAP);
    }

    public final ReactionAttachmentIntent m22741a(@Nonnull String str, @Nonnull GraphQLNearbyFriendsNuxType graphQLNearbyFriendsNuxType) {
        String formatStrLocaleSafe;
        switch (C20761.f18776a[graphQLNearbyFriendsNuxType.ordinal()]) {
            case 1:
                formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.cT, str, Boolean.valueOf(true), Boolean.valueOf(false));
                break;
            case 2:
                formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.cT, str, Boolean.valueOf(false), Boolean.valueOf(true));
                break;
            default:
                formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.cQ, str);
                break;
        }
        return m22708b(formatStrLocaleSafe, null, UnitInteractionType.NEARBY_FRIENDS_NUX_TAP);
    }

    public final ReactionAttachmentIntent m22723a() {
        return m22708b(FBLinks.cU, null, UnitInteractionType.NEARBY_FRIENDS_TAP);
    }

    public static ReactionAttachmentIntent m22702a(String str, String str2, String str3, boolean z, UnitInteractionType unitInteractionType) {
        boolean z2;
        ComposerConfiguration.Builder a = ComposerConfigurationFactory.a();
        ComposerTargetData.Builder builder = new ComposerTargetData.Builder(Long.parseLong(str), TargetType.PAGE);
        builder.c = str2;
        builder = builder;
        builder.d = str3;
        ComposerConfiguration.Builder initialTargetData = a.setInitialTargetData(builder.a());
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        ComposerConfiguration a2 = initialTargetData.setDisablePhotos(z2).a();
        Intent intent = new Intent();
        intent.putExtra("composer_configuration", a2);
        return new ReactionAttachmentIntent(str, unitInteractionType, intent);
    }

    public static ReactionAttachmentIntent m22688a(Context context, String str, String str2, String str3, UnitInteractionType unitInteractionType) {
        ComposerTargetData.Builder builder = new ComposerTargetData.Builder(Long.parseLong(str), TargetType.PAGE);
        builder.c = str2;
        builder = builder;
        builder.d = str3;
        ComposerConfiguration.Builder initialTargetData = ComposerConfigurationFactory.a().setInitialTargetData(builder.a());
        SimplePickerLauncherConfiguration.Builder k = new SimplePickerLauncherConfiguration.Builder(SimplePickerSource.PAGE).k();
        k.a = initialTargetData.a();
        return new ReactionAttachmentIntent(str, unitInteractionType, SimplePickerIntent.a(context, k.h()));
    }

    public static ReactionAttachmentIntent m22690a(Uri uri, UnitInteractionType unitInteractionType) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("launch_external_activity", true);
        return new ReactionAttachmentIntent(null, unitInteractionType, intent);
    }

    @Nullable
    public final ReactionAttachmentIntent m22725a(Context context, double d, double d2) {
        Bundle bundle = new Bundle();
        bundle.putDouble("latitude", d);
        bundle.putDouble("longitude", d2);
        bundle.putFloat("zoom", 13.0f);
        bundle.putString("curation_surface", CurationSurface.NATIVE_REACTION.toString());
        Intent a = ((UriIntentMapper) this.f18789l.get()).a(context, FBLinks.eP);
        if (a == null) {
            return null;
        }
        a.putExtras(bundle);
        return new ReactionAttachmentIntent(null, UnitInteractionType.OPEN_MAP_TAP, a);
    }

    @Nullable
    public final ReactionAttachmentIntent m22726a(Context context, double d, double d2, String str, String str2, String str3) {
        Intent a;
        if (m22714c()) {
            a = HereMapsUpsellDialogActivity.a(context, ExternalMapLauncher.a(context, d, d2, str), d, d2, str2, str);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("place_name", str2);
            bundle.putString("extra_page_name", str2);
            bundle.putString("address", str);
            bundle.putDouble("latitude", d);
            bundle.putDouble("longitude", d2);
            bundle.putFloat("zoom", 13.0f);
            bundle.putString("curation_surface", CurationSurface.NATIVE_PAGE_PROFILE.toString());
            a = ((UriIntentMapper) this.f18789l.get()).a(context, FBLinks.eP);
            if (a == null) {
                return null;
            }
            a.putExtras(bundle);
        }
        return new ReactionAttachmentIntent(str3, UnitInteractionType.OPEN_PAGE_MAP_TAP, a);
    }

    public final ReactionAttachmentIntent m22756b(Context context, double d, double d2, String str, String str2, String str3) {
        Intent putExtra = ExternalMapLauncher.a(d, d2, str).putExtra("launch_external_activity", true);
        UnitInteractionType unitInteractionType = UnitInteractionType.OPEN_PAGE_NAVIGATION_TAP;
        if (m22714c()) {
            putExtra = HereMapsUpsellDialogActivity.a(context, putExtra, d, d2, str2, str);
        }
        return new ReactionAttachmentIntent(str3, unitInteractionType, putExtra);
    }

    public final ReactionAttachmentIntent m22784h(String str) {
        Uri parse = Uri.parse(str);
        UnitInteractionType unitInteractionType = UnitInteractionType.FACEWEB_URL_TAP;
        if (!FacebookUriUtil.c(parse)) {
            return m22690a(parse, unitInteractionType);
        }
        return m22708b(StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, Uri.encode(str)), null, unitInteractionType);
    }

    public final ReactionAttachmentIntent m22729a(Context context, String str) {
        Uri parse = Uri.parse(str);
        if ((!FacebookUriUtil.c(parse) || FacebookUriUtil.a(parse)) && !FacebookUriUtil.g(parse)) {
            return m22784h(str);
        }
        return new ReactionAttachmentIntent(null, UnitInteractionType.OPEN_PAGE_PROMOTION, ((UriIntentMapper) this.f18789l.get()).a(context, str));
    }

    public final ReactionAttachmentIntent m22757b(Context context, String str) {
        return new ReactionAttachmentIntent(str, UnitInteractionType.OPEN_VIDEO_CHANNEL, ((UriIntentMapper) this.f18789l.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.gb, str)));
    }

    public final ReactionAttachmentIntent m22764c(Context context, String str, String str2) {
        Intent a = ((UriIntentMapper) this.f18789l.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.eE, str2));
        if (!(a == null || str == null)) {
            a.putExtra("merchant_page_id", str);
        }
        return new ReactionAttachmentIntent(str, UnitInteractionType.OPEN_PAGE_COMMERCE_TAP, a);
    }

    public final ReactionAttachmentIntent m22769d(Context context, String str, @Nullable String str2) {
        Intent a = ((UriIntentMapper) this.f18789l.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.eD, str));
        if (!(a == null || Strings.isNullOrEmpty(str2))) {
            a.putExtra("arg_init_product_id", str2);
        }
        return new ReactionAttachmentIntent(str, UnitInteractionType.OPEN_PAGE_COMMERCE_TAP, a);
    }

    public final ReactionAttachmentIntent m22742a(String str, UnitInteractionType unitInteractionType) {
        return m22712c(FBLinks.af, str, unitInteractionType);
    }

    public static ReactionAttachmentIntent m22697a(String str, String str2, UnitInteractionType unitInteractionType) {
        return new ReactionAttachmentIntent(null, unitInteractionType, new ReactionPromotePageEvent(str, str2));
    }

    public static ReactionAttachmentIntent m22701a(String str, String str2, String str3, String str4) {
        return new ReactionAttachmentIntent(null, UnitInteractionType.OPEN_COMPOSER_TAP, new ReactionPagePublishEvent(str, str2, str3, str4));
    }

    public final ReactionAttachmentIntent m22763c(Context context, String str) {
        return new ReactionAttachmentIntent(str, UnitInteractionType.NUX_CONTINUE_TAP, ((UriIntentMapper) this.f18789l.get()).a(context, StringFormatUtil.formatStrLocaleSafe(URL.f1684D, str)));
    }

    public static ReactionAttachmentIntent m22718i(String str) {
        return new ReactionAttachmentIntent(null, UnitInteractionType.VIEW_PAGE_SETTINGS, new ReactionViewPageSettingsEvent(str));
    }

    public final ReactionAttachmentIntent m22768d(Context context, String str) {
        return new ReactionAttachmentIntent(str, UnitInteractionType.NUX_CONTINUE_TAP, ((UriIntentMapper) this.f18789l.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.eB, str)));
    }

    @Nullable
    public final ReactionAttachmentIntent m22789j(String str) {
        Intent b = ((CommerceNavigationUtil) this.f18779b.get()).b(Long.parseLong(str));
        if (b == null) {
            return null;
        }
        return new ReactionAttachmentIntent(str, UnitInteractionType.OPEN_PAGE_ADD_PRODUCT_TAP, b);
    }

    public final ReactionAttachmentIntent m22731a(Context context, String str, String str2, UnitInteractionType unitInteractionType) {
        return m22706b(context, FBLinks.af, str, str2, unitInteractionType);
    }

    public static ReactionAttachmentIntent m22684a(@Nonnull Context context, long j, long[] jArr, String str) {
        Intent intent = new Intent(context, MediaGalleryActivity.class);
        intent.putExtra("photo_fbid", j);
        intent.putExtra("extra_photo_set_fb_id_array", jArr);
        intent.putExtra("extra_show_attribution", true);
        intent.putExtra("photo_url", str);
        return new ReactionAttachmentIntent(Long.toString(j), UnitInteractionType.PHOTO_TAP, intent);
    }

    public final ReactionAttachmentIntent m22773e(Context context, String str) {
        return new ReactionAttachmentIntent(str, UnitInteractionType.VIEW_PHOTO_MENU_TAP, ((UriIntentMapper) this.f18789l.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.dv, str)));
    }

    public final ReactionAttachmentIntent m22752a(String str, @Nullable String str2, @Nullable String str3, boolean z) {
        return new ReactionAttachmentIntent(str2, UnitInteractionType.SEE_MORE_TAP, this.f18782e.b().putExtra("target_fragment", ContentFragmentType.GAMETIME_PLAYS_FRAGMENT.ordinal()).putExtra("show_more_title", str3).putExtra("feed_type_name", Name.z.A).putExtra("page_id", str).putExtra("scoring_plays", z));
    }

    public final ReactionAttachmentIntent m22736a(@Nullable ReactionProfileFields reactionProfileFields, UnitInteractionType unitInteractionType) {
        if (reactionProfileFields == null || reactionProfileFields.eL_() == null) {
            return null;
        }
        if (reactionProfileFields.b() != null && reactionProfileFields.b().g() == 2479791) {
            return m22742a(reactionProfileFields.eL_(), unitInteractionType);
        }
        if (reactionProfileFields.b() != null && reactionProfileFields.b().g() == 67338874) {
            return m22738a(reactionProfileFields.eL_());
        }
        Bundle bundle = new Bundle();
        ModelBundle.a(bundle, reactionProfileFields.eL_(), reactionProfileFields.k() != null ? reactionProfileFields.k().b() : null, reactionProfileFields.j());
        String str = FBLinks.aX;
        String eL_ = reactionProfileFields.eL_();
        ReactionAttachmentIntent b = m22708b(StringFormatUtil.formatStrLocaleSafe(str, eL_), eL_, unitInteractionType);
        if (bundle != null) {
            b.f18831d.putExtras(bundle);
        }
        return b;
    }

    public final ReactionAttachmentIntent m22761b(String str, UnitInteractionType unitInteractionType) {
        return m22712c(FBLinks.aX, str, unitInteractionType);
    }

    public static ReactionAttachmentIntent m22711c(String str, UnitInteractionType unitInteractionType) {
        return new ReactionAttachmentIntent(null, unitInteractionType, new ReactionPymlSeeMoreEvent(str));
    }

    public static ReactionAttachmentIntent m22694a(String str, ReplacementUnitModel replacementUnitModel) {
        Intent intent = new Intent();
        String str2 = "replacement_unit";
        ImmutableList.Builder builder = ImmutableList.builder();
        if (replacementUnitModel.d() != null) {
            ImmutableList d = replacementUnitModel.d();
            int size = d.size();
            for (int i = 0; i < size; i++) {
                ReactionUnitComponentsModel reactionUnitComponentsModel = (ReactionUnitComponentsModel) d.get(i);
                ReactionUnitComponentModel.Builder builder2 = new ReactionUnitComponentModel.Builder();
                MessageModel.Builder builder3 = new MessageModel.Builder();
                builder3.b = reactionUnitComponentsModel.fQ_().a();
                builder2.bh = builder3.a();
                builder2 = builder2;
                SubMessageModel.Builder builder4 = new SubMessageModel.Builder();
                builder4.b = reactionUnitComponentsModel.j().a();
                builder2.cB = builder4.a();
                builder2 = builder2;
                ReactionImageFieldsModel.Builder builder5 = new ReactionImageFieldsModel.Builder();
                builder5.a = reactionUnitComponentsModel.fR_().b();
                builder2.aB = builder5.a();
                builder2 = builder2;
                builder2.C = reactionUnitComponentsModel.a();
                builder2 = builder2;
                ReactionStoryAttachmentActionFragmentModel.Builder builder6 = new ReactionStoryAttachmentActionFragmentModel.Builder();
                builder6.i = reactionUnitComponentsModel.c().b();
                builder2.b = builder6.a();
                builder2 = builder2;
                builder2.g = reactionUnitComponentsModel.d();
                builder.c(builder2.a());
            }
        }
        ReactionUnitFragmentModel.Builder builder7 = new ReactionUnitFragmentModel.Builder();
        builder7.i = builder.b();
        builder7 = builder7;
        builder7.n = replacementUnitModel.fN_();
        builder7 = builder7;
        builder7.o = replacementUnitModel.fO_();
        builder7 = builder7;
        builder7.k = replacementUnitModel.fM_();
        builder7 = builder7;
        builder7.m = replacementUnitModel.g();
        builder7 = builder7;
        builder7.d = replacementUnitModel.c();
        FlatBufferModelHelper.a(intent, str2, builder7.a());
        return new ReactionAttachmentIntent(str, UnitInteractionType.REPLACE_UNIT_TAP, intent);
    }

    public final ReactionAttachmentIntent m22762c(Context context) {
        return new ReactionAttachmentIntent(null, UnitInteractionType.SEE_ALL_FRIEND_REQUESTS, ((UriIntentMapper) this.f18789l.get()).a(context, StringFormatUtil.a(FBLinks.cd, new Object[]{FriendsCenterSource.REACTION_FRIEND_REQUESTS_CARD.name(), FriendsCenterTabType.REQUESTS.name()})));
    }

    public final ReactionAttachmentIntent m22777f(Context context, String str) {
        return new ReactionAttachmentIntent(null, UnitInteractionType.SEE_MORE_TAP, ((UriIntentMapper) this.f18789l.get()).a(context, StringFormatUtil.a(FBLinks.az, new Object[]{str})));
    }

    public static ReactionAttachmentIntent m22719k(String str) {
        return new ReactionAttachmentIntent(null, UnitInteractionType.VIEW_PAGE_INSIGHTS, new ReactionSeePageInsightsEvent(str));
    }

    public final ReactionAttachmentIntent m22765c(Context context, String str, String str2, String str3) {
        GraphQLEntityCardContextItemType graphQLEntityCardContextItemType = GraphQLEntityCardContextItemType.LIKES_AP;
        ((PagesReactionManager) this.f18785h.get()).m22672a(graphQLEntityCardContextItemType, Long.parseLong(str2), str);
        Intent a = ((UriIntentMapper) this.f18789l.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.ao, str2));
        a.putExtra("reaction_session_id", str);
        a.putExtra("owner_id", str2);
        a.putExtra("com.facebook.katana.profile.id", str2);
        a.putExtra("source_name", str3);
        a.putExtra("page_context_item_type", graphQLEntityCardContextItemType);
        return new ReactionAttachmentIntent(str2, UnitInteractionType.SEE_PAGE_LIKES_TAP, a);
    }

    public final ReactionAttachmentIntent m22780g(Context context, String str) {
        return new ReactionAttachmentIntent(str, UnitInteractionType.VIEW_PAGE_LIKERS, ((UriIntentMapper) this.f18789l.get()).a(context, "fb://pma/newlikes"));
    }

    public final ReactionAttachmentIntent m22783h(Context context, String str) {
        return new ReactionAttachmentIntent(str, UnitInteractionType.VIEW_PAGE_MENTIONS, ((UriIntentMapper) this.f18789l.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.a("faceweb/f?href=/%s/activity_feed/?type=mention"), str)));
    }

    public final ReactionAttachmentIntent m22785i(Context context, String str) {
        return new ReactionAttachmentIntent(str, UnitInteractionType.VIEW_PAGE_CHECKINS, ((UriIntentMapper) this.f18789l.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.a("faceweb/f?href=/%s/activity_feed/?type=checkin"), str)));
    }

    public final ReactionAttachmentIntent m22787j(Context context, String str) {
        return new ReactionAttachmentIntent(str, UnitInteractionType.VIEW_PAGE_SHARES, ((UriIntentMapper) this.f18789l.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.a("faceweb/f?href=/%s/activity_feed/?type=share"), str)));
    }

    public final ReactionAttachmentIntent m22790k(Context context, String str) {
        Intent a = ((UriIntentMapper) this.f18789l.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.ad, str));
        a.putExtra("owner_id", str);
        return new ReactionAttachmentIntent(str, UnitInteractionType.SEE_MORE_TAP, a);
    }

    public final ReactionAttachmentIntent m22792l(Context context, String str) {
        return m22686a(context, str, FBLinks.aM, MediasetType.PHOTOS_TAKEN_HERE.ordinal(), true, UnitInteractionType.SEE_MORE_TAP);
    }

    public final ReactionAttachmentIntent m22795m(Context context, String str) {
        return m22686a(context, str, FBLinks.aN, MediasetType.PHOTOS_TAKEN_OF.ordinal(), true, UnitInteractionType.SEE_MORE_TAP);
    }

    public final ReactionAttachmentIntent m22796n(Context context, String str) {
        return new ReactionAttachmentIntent(str, UnitInteractionType.SEE_MORE_TAP, ((UriIntentMapper) this.f18789l.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.au, str)));
    }

    public final ReactionAttachmentIntent m22797o(Context context, String str) {
        return new ReactionAttachmentIntent(str, UnitInteractionType.SEE_MORE_TAP, ((UriIntentMapper) this.f18789l.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.aw, str, "ReactionAction")));
    }

    public final ReactionAttachmentIntent m22774e(Context context, String str, String str2) {
        return m22706b(context, FBLinks.aq, str, str2, UnitInteractionType.SEE_MORE_TAP);
    }

    public final ReactionAttachmentIntent m22778f(Context context, String str, String str2) {
        return m22706b(context, FBLinks.ar, str, str2, UnitInteractionType.SEE_MORE_TAP);
    }

    public final ReactionAttachmentIntent m22781g(Context context, String str, String str2) {
        return m22706b(context, FBLinks.ap, str, str2, UnitInteractionType.SEE_MORE_TAP);
    }

    public final ReactionAttachmentIntent m22744a(String str, String str2, Context context) {
        return new ReactionAttachmentIntent(str, UnitInteractionType.SEE_ALL_RATINGS_TAP, this.f18786i.m25172b(Long.parseLong(str), null, str2, null, context));
    }

    public final ReactionAttachmentIntent m22749a(String str, String str2, @Nullable String str3, @Nullable String str4, @Nullable ReactionAnalyticsParams reactionAnalyticsParams) {
        Intent component = new Intent().setComponent((ComponentName) this.f18780c.get());
        component.putExtra("target_fragment", ContentFragmentType.EVENTS_DISCOVERY_FRAGMENT.ordinal());
        component.putExtra("extra_events_discovery_title", str2);
        component.putExtra("extra_events_discovery_single_tab_title", str3);
        component.putExtra("extra_events_discovery_subtitle", str4);
        component.putExtra("extra_events_discovery_suggestion_token", str);
        component.putExtra("extra_reaction_analytics_params", reactionAnalyticsParams);
        component.putExtra("event_suggestion_token", str);
        return new ReactionAttachmentIntent(null, UnitInteractionType.SEE_ALL_SUGGESTED_EVENTS_TAP, component);
    }

    public static ReactionAttachmentIntent m22695a(String str, String str2) {
        return new ReactionAttachmentIntent(null, UnitInteractionType.MESSAGE_TAP, new ReactionSendMessageAsPageEvent(str, str2));
    }

    public final ReactionAttachmentIntent m22794l(@Nonnull String str) {
        return m22712c(FBLinks.R, str, UnitInteractionType.MESSAGE_TAP);
    }

    public final ReactionAttachmentIntent m22798p(Context context, String str) {
        return new ReactionAttachmentIntent(str, UnitInteractionType.OPEN_FRIEND_INVITER, ((UriIntentMapper) this.f18789l.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.aI, str)));
    }

    public static ReactionAttachmentIntent m22720m(String str) {
        return new ReactionAttachmentIntent(null, UnitInteractionType.SEE_MORE_TAP, new ReactionSeePageAllMessagesEvent(str));
    }

    public static ReactionAttachmentIntent m22721n(String str) {
        return new ReactionAttachmentIntent(null, UnitInteractionType.VIEW_PAGE_PROFILE, new ReactionSeePageProfileEvent(str));
    }

    public static ReactionAttachmentIntent m22707b(String str, String str2) {
        return new ReactionAttachmentIntent(str, UnitInteractionType.OPEN_COMPOSER_TAP, new Intent().putExtra("composer_configuration", ComposerConfigurationFactory.a(ComposerSourceType.REACTION, ComposerShareParams.Builder.a(str2).b()).setIsFireAndForget(true).a()));
    }

    public static ReactionAttachmentIntent m22715d(String str, UnitInteractionType unitInteractionType) {
        return new ReactionAttachmentIntent(str, unitInteractionType, new Intent().putExtra("composer_configuration", ComposerConfigurationFactory.a(ComposerSourceType.REACTION, Long.parseLong(str)).setIsFireAndForget(true).a()));
    }

    public static ReactionAttachmentIntent m22709b(String str, String str2, String str3) {
        ComposerConfiguration.Builder isFireAndForget = ComposerConfigurationFactory.a(ComposerSourceType.PAGE, Long.parseLong(str)).setIsFireAndForget(true);
        ComposerTargetData.Builder builder = new ComposerTargetData.Builder(Long.parseLong(str), TargetType.PAGE);
        builder.c = str2;
        builder = builder;
        builder.d = str3;
        return new ReactionAttachmentIntent(str, UnitInteractionType.OPEN_COMPOSER_TAP, new Intent().putExtra("composer_configuration", isFireAndForget.setInitialTargetData(builder.a()).a()));
    }

    public static ReactionAttachmentIntent m22717h(Context context, String str, String str2) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", FacebookUriUtil.a(Uri.parse(str2), "ti", "as").toString());
        intent = Intent.createChooser(intent, context.getString(2131237296));
        intent.putExtra("launch_external_activity", true);
        return new ReactionAttachmentIntent(str, UnitInteractionType.EXTERNAL_PROFILE_LINK_SHARE, intent);
    }

    public final ReactionAttachmentIntent m22733a(GraphQLReactionStoryAttachmentsStyle graphQLReactionStoryAttachmentsStyle, String str, Surface surface, @Nullable String str2, String str3) {
        Intent component = new Intent().setComponent((ComponentName) this.f18780c.get());
        component.putExtra("target_fragment", ContentFragmentType.REACTION_SHOW_MORE_ATTACHMENTS_FRAGMENT.ordinal());
        component.putExtra("attachment_style", graphQLReactionStoryAttachmentsStyle);
        component.putExtra("reaction_session_id", str);
        component.putExtra("reaction_surface", surface);
        component.putExtra("show_more_title", str2);
        component.putExtra("reaction_unit_id", str3);
        return new ReactionAttachmentIntent(str3, UnitInteractionType.SEE_MORE_TAP, component);
    }

    public final ReactionAttachmentIntent m22786i(Context context, String str, String str2) {
        return new ReactionAttachmentIntent(str, UnitInteractionType.SEE_MORE_EVENTS, ((UriIntentMapper) this.f18789l.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.at, str)).putExtra("extra_page_name", str2).putExtra("extra_ref_module", "reaction_dialog".toString()).putExtra("event_ref_mechanism", ActionMechanism.PLACE_TIPS.toString()));
    }

    public final ReactionAttachmentIntent m22727a(Context context, GraphQLPhotosByCategoryEntryPoint graphQLPhotosByCategoryEntryPoint, String str) {
        return new ReactionAttachmentIntent(null, UnitInteractionType.SEE_MORE_TAP, ((UriIntentMapper) this.f18789l.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.du, str)).putExtra("local_content_entry_point", graphQLPhotosByCategoryEntryPoint));
    }

    public static ReactionAttachmentIntent m22722o(String str) {
        return new ReactionAttachmentIntent(str, UnitInteractionType.SEE_MORE_TAP, new Intent().putExtra("launch_media_gallery", true));
    }

    public final ReactionAttachmentIntent m22788j(Context context, String str, String str2) {
        Intent a = ((UriIntentMapper) this.f18789l.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.dw, str));
        a.putExtra("profile_name", str2);
        return new ReactionAttachmentIntent(str, UnitInteractionType.VIEW_STRUCTURE_MENU_TAP, a);
    }

    public final ReactionAttachmentIntent m22767c(String str, @Nullable String str2) {
        Intent b = this.f18782e.b();
        b.putExtra("reaction_feed_story_id", str);
        b.putExtra("reaction_feed_title", str2);
        b.putExtra("feed_type_name", Name.m.A);
        return new ReactionAttachmentIntent(str, UnitInteractionType.SEE_MORE_TAP, b);
    }

    public final ReactionAttachmentIntent m22746a(String str, String str2, Surface surface, String str3, String str4, String str5, @Nullable String str6) {
        Intent component = new Intent().setComponent((ComponentName) this.f18780c.get());
        component.putExtra("target_fragment", ContentFragmentType.REACTION_SHOW_MORE_COMPONENTS_FRAGMENT.ordinal());
        component.putExtra("component_id", str3).putExtra("reaction_session_id", str2).putExtra("reaction_surface", surface).putExtra("show_more_title", str6).putExtra("settings_token", str4).putExtra("unit_type_token", str5).putExtra("reaction_unit_id", str);
        return new ReactionAttachmentIntent(str, UnitInteractionType.SEE_ALL_COMPONENTS, component);
    }

    public final ReactionAttachmentIntent m22772d(String str, String str2) {
        return new ReactionAttachmentIntent(str, UnitInteractionType.TOPIC_TAP, this.f18787j.a(SearchTypeaheadSession.a, str, str2, SearchResultsSource.A));
    }

    public final ReactionAttachmentIntent m22754b() {
        Calendar instance = GregorianCalendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        Date time = instance.getTime();
        Intent component = new Intent().setComponent((ComponentName) this.f18780c.get());
        component.putExtra("target_fragment", ContentFragmentType.EVENTS_UPCOMING_BIRTHDAYS_FRAGMENT.ordinal()).putExtra("birthday_view_referrer_param", "today_notification").putExtra("birthday_view_start_date", time.getTime());
        return new ReactionAttachmentIntent(null, UnitInteractionType.OPEN_UPCOMING_BIRTHDAYS_TAP, component);
    }

    public final ReactionAttachmentIntent m22791k(Context context, String str, String str2) {
        return new ReactionAttachmentIntent(str, UnitInteractionType.OPEN_PAGE_CHILD_LOCATIONS, ((UriIntentMapper) this.f18789l.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.as, str)).putExtra("extra_page_name", str2).putExtra("com.facebook.katana.profile.id", str));
    }

    public final ReactionAttachmentIntent m22751a(String str, @Nullable String str2, String str3, String str4, @Nullable String str5, boolean z) {
        PermalinkStoryIdParams.Builder builder = new PermalinkStoryIdParams.Builder();
        builder.a = str4;
        builder = builder;
        builder.b = str3;
        builder = builder;
        builder.h = CommentOrderType.getOrder(str5);
        builder = builder;
        builder.e = str;
        builder = builder;
        builder.m = Boolean.valueOf(z);
        builder = builder;
        if (str2 != null) {
            builder.c = str2;
        }
        Intent a = this.f18790m.a(builder.a());
        a.setComponent((ComponentName) this.f18780c.get());
        return new ReactionAttachmentIntent(str4, UnitInteractionType.VIEW_COMMENT_TAP, a);
    }

    public static ReactionAttachmentIntent m22713c(String str, String str2, String str3) {
        return new ReactionAttachmentIntent(str2, UnitInteractionType.VIEW_EVENT_POSTS, new ReactionEventsSeeAllPostsEvent(str, str3));
    }

    private ReactionAttachmentIntent m22686a(Context context, String str, String str2, int i, boolean z, UnitInteractionType unitInteractionType) {
        Intent a = ((UriIntentMapper) this.f18789l.get()).a(context, StringFormatUtil.formatStrLocaleSafe(str2, str));
        a.putExtra("extra_show_attribution", z);
        a.putExtra("mediaset_type", i);
        a.putExtra("owner_id", str);
        return new ReactionAttachmentIntent(str, unitInteractionType, a);
    }

    public final ReactionAttachmentIntent m22799p(String str) {
        Intent component = new Intent().setComponent((ComponentName) this.f18780c.get());
        component.putExtra("target_fragment", ContentFragmentType.FUNDRAISER_PAGE_FRAGMENT.ordinal());
        component.putExtra("fundraiser_campaign_id", str);
        return new ReactionAttachmentIntent(str, UnitInteractionType.VIEW_FUNDRAISER, component);
    }

    public final ReactionAttachmentIntent m22740a(String str, GraphQLFundraiserSupportersConnectionType graphQLFundraiserSupportersConnectionType) {
        Intent component = new Intent().setComponent((ComponentName) this.f18780c.get());
        component.putExtra("target_fragment", ContentFragmentType.FUNDRAISER_GUESTLIST_FRAGMENT.ordinal());
        component.putExtra("fundraiser_campaign_id", str);
        component.putExtra("extra_view_fundraiser_supporters_connection_type", graphQLFundraiserSupportersConnectionType);
        return new ReactionAttachmentIntent(str, UnitInteractionType.VIEW_FUNDRAISER_SUPPORTERS, component);
    }

    public final ReactionAttachmentIntent m22776e(String str, @Nullable String str2) {
        PermalinkStoryIdParams.Builder builder = new PermalinkStoryIdParams.Builder();
        builder.a = str;
        builder = builder;
        builder.b = str2;
        return new ReactionAttachmentIntent(str, UnitInteractionType.STORY_TAP, this.f18790m.a((ComponentName) this.f18780c.get(), builder.a()));
    }

    public final ReactionAttachmentIntent m22770d(Context context, String str, @Nullable String str2, @Nullable String str3) {
        Intent a = ((UriIntentMapper) this.f18789l.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.ag, str));
        a.putExtra("com.facebook.katana.profile.id", str);
        if (!Strings.isNullOrEmpty(str2)) {
            a.putExtra("profile_name", str2);
        }
        if (!Strings.isNullOrEmpty(str3)) {
            a.putExtra("page_clicked_item_id_extra", str3);
        }
        return new ReactionAttachmentIntent(str, UnitInteractionType.SEE_MORE_TAP, a);
    }

    public final ReactionAttachmentIntent m22793l(Context context, String str, String str2) {
        Intent a = ((UriIntentMapper) this.f18789l.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.ah, str, str2));
        a.putExtra("com.facebook.katana.profile.id", str);
        a.putExtra("page_service_id_extra", str2);
        a.putExtra("extra_service_launched_from_page", true);
        return new ReactionAttachmentIntent(str, UnitInteractionType.VIEW_PAGE_SERVICE_TAP, a);
    }

    public final ReactionAttachmentIntent m22748a(@Nonnull String str, @Nullable String str2, @Nullable String str3, @Nonnull UnitInteractionType unitInteractionType) {
        PermalinkStoryIdParams.Builder builder = new PermalinkStoryIdParams.Builder();
        builder.a = str;
        builder = builder;
        builder.b = str2;
        builder = builder;
        builder.h = CommentOrderType.getOrder(str3);
        return new ReactionAttachmentIntent(str, unitInteractionType, this.f18790m.a(builder.a()));
    }

    public static ReactionAttachmentIntent m22710b(String str, String str2, String str3, UnitInteractionType unitInteractionType) {
        return new ReactionAttachmentIntent(str2, unitInteractionType, new Intent().putExtra("composer_configuration", ComposerConfigurationFactory.a(ComposerSourceType.REACTION, false, Long.parseLong(str2), str3, CurationMechanism.REVIEW_BUTTON, CurationSurface.AFTER_PARTY).setPluginConfig(new DefaultPluginConfigSerializer().a(ReviewComposerPluginConfig.m4870c())).setReactionSurface(Surface.ANDROID_AFTER_PARTY_COMPOSER).setReactionUnitId(str).a()));
    }

    public static ReactionAttachmentIntent m22716d(String str, String str2, String str3) {
        ComposerConfiguration.Builder a = ComposerConfigurationFactory.a(ComposerSourceSurface.REACTION, "reactionWriteTimeline");
        ComposerTargetData.Builder builder = new ComposerTargetData.Builder(Long.parseLong(str), TargetType.USER);
        builder.c = str2;
        builder = builder;
        builder.d = str3;
        return new ReactionAttachmentIntent(str, UnitInteractionType.OPEN_COMPOSER_TAP, new Intent().putExtra("composer_configuration", a.setInitialTargetData(builder.a()).setIsFireAndForget(true).setReactionSurface(Surface.ANDROID_AFTER_PARTY_COMPOSER).a()));
    }

    public static ReactionAttachmentIntent m22708b(String str, String str2, UnitInteractionType unitInteractionType) {
        Intent intent = new Intent();
        intent.setData(Uri.parse(str));
        return new ReactionAttachmentIntent(str2, unitInteractionType, intent);
    }

    private ReactionAttachmentIntent m22712c(String str, String str2, UnitInteractionType unitInteractionType) {
        return m22708b(StringFormatUtil.formatStrLocaleSafe(str, str2), str2, unitInteractionType);
    }

    private ReactionAttachmentIntent m22706b(Context context, String str, String str2, String str3, UnitInteractionType unitInteractionType) {
        Intent a = ((UriIntentMapper) this.f18789l.get()).a(context, StringFormatUtil.formatStrLocaleSafe(str, str2));
        if (a == null) {
            return null;
        }
        a.putExtra("extra_page_name", str3);
        return new ReactionAttachmentIntent(str2, unitInteractionType, a);
    }

    private boolean m22714c() {
        return ((QeAccessor) this.f18791n.get()).a(ExperimentsForMapsModule.b, false) && ((InterstitialManager) this.f18784g.get()).b(f18777a, HereMapsUpsellInterstitialController.class);
    }
}
