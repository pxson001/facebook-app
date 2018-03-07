package com.facebook.reaction.action;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.events.common.ActionMechanism;
import com.facebook.facecast.FacecastActivity;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLFundraiserSupportersConnectionType;
import com.facebook.graphql.enums.GraphQLPagePresenceTabType;
import com.facebook.graphql.enums.GraphQLReactionStoryActionStyle;
import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerTargetData.Builder;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.reaction.ReactionSessionManager;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionStoryAttachmentActionCommonFragment;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionActionFatFieldsModel.StoryModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionActionFatFieldsModel.StoryModel.FeedbackModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionFundraiserActionFieldsModel.FundraiserCampaignModel;
import com.facebook.reaction.util.ReactionSurfaceUtil;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: browse_query_tap */
public class ReactionActionHandler {
    private static volatile ReactionActionHandler f18769d;
    private final Product f18770a;
    private final ReactionIntentFactory f18771b;
    private final ReactionSessionManager f18772c;

    /* compiled from: browse_query_tap */
    /* synthetic */ class C20751 {
        static final /* synthetic */ int[] f18768a = new int[GraphQLReactionStoryActionStyle.values().length];

        static {
            try {
                f18768a[GraphQLReactionStoryActionStyle.ADD_PHOTOS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.BOOST_POST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.BROWSE_QUERY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.CALL_PHONE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.CHECK_IN.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.CONTACT_FUNDRAISER_SUPPORTERS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.CREATE_PAGE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.EDIT_PAGE_INFO.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.EVENT_COMPOSER.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.EVENT_MESSAGE_ONLY_FRIEND.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.EVENT_MESSAGE_FRIENDS.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.EVENT_MESSAGE_FRIENDS_AS_GROUP.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.EVENT_MESSAGE_FRIENDS_SEPARATELY.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.GO_LIVE.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.INVITE_FRIENDS_TO_EVENT.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.MINUTIAE_COMPOSER.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.OPEN_ALL_PLAYS.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.OPEN_LOCAL_SEARCH.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.OPEN_MAP.ordinal()] = 19;
            } catch (NoSuchFieldError e19) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.OPEN_NEARBY_FRIENDS_SETTINGS.ordinal()] = 20;
            } catch (NoSuchFieldError e20) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.OPEN_NEARBY_PLACES.ordinal()] = 21;
            } catch (NoSuchFieldError e21) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.OPEN_PAGE_INFO.ordinal()] = 22;
            } catch (NoSuchFieldError e22) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.OPEN_PAGE_MAP.ordinal()] = 23;
            } catch (NoSuchFieldError e23) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.OPEN_PAGE_NAVIGATION.ordinal()] = 24;
            } catch (NoSuchFieldError e24) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.OPEN_SCORING_PLAYS.ordinal()] = 25;
            } catch (NoSuchFieldError e25) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.OPEN_URL.ordinal()] = 26;
            } catch (NoSuchFieldError e26) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.OPEN_VIDEO_CHANNEL.ordinal()] = 27;
            } catch (NoSuchFieldError e27) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.PAGE_COMMERCE_OPEN_COLLECTION.ordinal()] = 28;
            } catch (NoSuchFieldError e28) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.PAGE_COMMERCE_OPEN_STORE.ordinal()] = 29;
            } catch (NoSuchFieldError e29) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.PAGE_CREATE_PHOTO_ALBUM.ordinal()] = 30;
            } catch (NoSuchFieldError e30) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.PAGE_SEE_ALL_PHOTO_ALBUMS.ordinal()] = 31;
            } catch (NoSuchFieldError e31) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.PAGE_SERVICE_START.ordinal()] = 32;
            } catch (NoSuchFieldError e32) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.PAGE_SHOP_ADD_PRODUCT.ordinal()] = 33;
            } catch (NoSuchFieldError e33) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.PAGE_SHOP_START.ordinal()] = 34;
            } catch (NoSuchFieldError e34) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.PROMOTE_PAGE.ordinal()] = 35;
            } catch (NoSuchFieldError e35) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.PUBLISH_PAGE_POST.ordinal()] = 36;
            } catch (NoSuchFieldError e36) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.REPLACE_UNIT.ordinal()] = 37;
            } catch (NoSuchFieldError e37) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_ALL_FEED_STORIES.ordinal()] = 38;
            } catch (NoSuchFieldError e38) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_ALL_FRIEND_REQUESTS.ordinal()] = 39;
            } catch (NoSuchFieldError e39) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_ALL_FRIENDS_TO_INVITE_TO_PAGE.ordinal()] = 40;
            } catch (NoSuchFieldError e40) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_ALL_MESSAGES.ordinal()] = 41;
            } catch (NoSuchFieldError e41) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_ALL_OG_OBJECTS.ordinal()] = 42;
            } catch (NoSuchFieldError e42) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_ALL_PHOTOS.ordinal()] = 43;
            } catch (NoSuchFieldError e43) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_ALL_PHOTOS_BY_CATEGORY.ordinal()] = 44;
            } catch (NoSuchFieldError e44) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_ALL_ADMIN_FEED_STORIES.ordinal()] = 45;
            } catch (NoSuchFieldError e45) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_ALL_ADMINED_PAGES.ordinal()] = 46;
            } catch (NoSuchFieldError e46) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_ALL_FACEPILE_PROFILES.ordinal()] = 47;
            } catch (NoSuchFieldError e47) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_ALL_PROFILES.ordinal()] = 48;
            } catch (NoSuchFieldError e48) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_ALL_PAGE_COMMENTS.ordinal()] = 49;
            } catch (NoSuchFieldError e49) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_ALL_PAGE_INSIGHTS.ordinal()] = 50;
            } catch (NoSuchFieldError e50) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_ALL_PAGE_PHOTOS.ordinal()] = 51;
            } catch (NoSuchFieldError e51) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_ALL_PAGE_POSTS.ordinal()] = 52;
            } catch (NoSuchFieldError e52) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_ALL_PAGE_VIDEO_PLAYLISTS.ordinal()] = 53;
            } catch (NoSuchFieldError e53) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_ALL_PAGINATABLE_COMPONENTS_ACTION.ordinal()] = 54;
            } catch (NoSuchFieldError e54) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_ALL_PHOTOS_AT_PAGE.ordinal()] = 55;
            } catch (NoSuchFieldError e55) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_ALL_PHOTOS_OF_PAGE.ordinal()] = 56;
            } catch (NoSuchFieldError e56) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_ALL_PAGE_REVIEWS.ordinal()] = 57;
            } catch (NoSuchFieldError e57) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_ALL_PAGE_VIDEOS.ordinal()] = 58;
            } catch (NoSuchFieldError e58) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_ALL_POSTS_TO_PAGE.ordinal()] = 59;
            } catch (NoSuchFieldError e59) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_ALL_RATINGS.ordinal()] = 60;
            } catch (NoSuchFieldError e60) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_ALL_SUGGESTED_EVENTS.ordinal()] = 61;
            } catch (NoSuchFieldError e61) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_ALL_TOPICS.ordinal()] = 62;
            } catch (NoSuchFieldError e62) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_APPS.ordinal()] = 63;
            } catch (NoSuchFieldError e63) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_PAGE_ADS_AND_PROMOTIONS.ordinal()] = 64;
            } catch (NoSuchFieldError e64) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_PAGE_CHECKINS_DETAILS.ordinal()] = 65;
            } catch (NoSuchFieldError e65) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_PAGE_LIKE_DETAILS.ordinal()] = 66;
            } catch (NoSuchFieldError e66) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_PAGE_LIKERS_DETAILS.ordinal()] = 67;
            } catch (NoSuchFieldError e67) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_PAGE_MENTIONS_DETAILS.ordinal()] = 68;
            } catch (NoSuchFieldError e68) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_PAGE_PROFILE.ordinal()] = 69;
            } catch (NoSuchFieldError e69) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_PAGE_REVIEWS_DETAILS.ordinal()] = 70;
            } catch (NoSuchFieldError e70) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEE_PAGE_SHARES_DETAILS.ordinal()] = 71;
            } catch (NoSuchFieldError e71) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEND_MESSAGE_AS_PAGE.ordinal()] = 72;
            } catch (NoSuchFieldError e72) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SEND_MESSAGE_TO_PROFILE.ordinal()] = 73;
            } catch (NoSuchFieldError e73) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SHARE_OG_OBJECT.ordinal()] = 74;
            } catch (NoSuchFieldError e74) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SHARE_EVENT.ordinal()] = 75;
            } catch (NoSuchFieldError e75) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SHARE_PAGE.ordinal()] = 76;
            } catch (NoSuchFieldError e76) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SHARE_PROFILE_LINK.ordinal()] = 77;
            } catch (NoSuchFieldError e77) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.SHARE_PHOTO_TO_PAGE.ordinal()] = 78;
            } catch (NoSuchFieldError e78) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.VIEW_EVENT_POSTS.ordinal()] = 79;
            } catch (NoSuchFieldError e79) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.VIEW_EVENTS.ordinal()] = 80;
            } catch (NoSuchFieldError e80) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.VIEW_FUNDRAISER.ordinal()] = 81;
            } catch (NoSuchFieldError e81) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.VIEW_FUNDRAISER_SUPPORTERS.ordinal()] = 82;
            } catch (NoSuchFieldError e82) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.VIEW_PAGE_CHILD_LOCATIONS.ordinal()] = 83;
            } catch (NoSuchFieldError e83) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.VIEW_PAGE_SERVICE.ordinal()] = 84;
            } catch (NoSuchFieldError e84) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.VIEW_COMMENT.ordinal()] = 85;
            } catch (NoSuchFieldError e85) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.VIEW_COMMENT_AND_OPEN_COMPOSER.ordinal()] = 86;
            } catch (NoSuchFieldError e86) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.VIEW_PAGE_EVENTS.ordinal()] = 87;
            } catch (NoSuchFieldError e87) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.VIEW_GUEST_LIST.ordinal()] = 88;
            } catch (NoSuchFieldError e88) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.VIEW_EVENTS_DASHBOARD.ordinal()] = 89;
            } catch (NoSuchFieldError e89) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.VIEW_GROUP.ordinal()] = 90;
            } catch (NoSuchFieldError e90) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.VIEW_GROUP_EVENTS.ordinal()] = 91;
            } catch (NoSuchFieldError e91) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.VIEW_GROUP_PHOTOS.ordinal()] = 92;
            } catch (NoSuchFieldError e92) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.VIEW_MENU.ordinal()] = 93;
            } catch (NoSuchFieldError e93) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.VIEW_NEARBY_FRIENDS.ordinal()] = 94;
            } catch (NoSuchFieldError e94) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.VIEW_NEARBY_FRIENDS_NUX.ordinal()] = 95;
            } catch (NoSuchFieldError e95) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.VIEW_PAGE_ADMIN_POST.ordinal()] = 96;
            } catch (NoSuchFieldError e96) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.VIEW_PAGE_ADMIN_POST_INSIGHT.ordinal()] = 97;
            } catch (NoSuchFieldError e97) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.VIEW_PAGE_SERVICES.ordinal()] = 98;
            } catch (NoSuchFieldError e98) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.VIEW_PAGE_SETTINGS.ordinal()] = 99;
            } catch (NoSuchFieldError e99) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.VIEW_PHOTOS_OF_PAGE_ALBUM.ordinal()] = 100;
            } catch (NoSuchFieldError e100) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.VIEW_PHOTO_MENU.ordinal()] = 101;
            } catch (NoSuchFieldError e101) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.VIEW_PROFILE.ordinal()] = 102;
            } catch (NoSuchFieldError e102) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.VIEW_PYML.ordinal()] = 103;
            } catch (NoSuchFieldError e103) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.VIEW_STORY.ordinal()] = 104;
            } catch (NoSuchFieldError e104) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.VIEW_UPCOMING_BIRTHDAYS_DASHBOARD.ordinal()] = 105;
            } catch (NoSuchFieldError e105) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.WRITE_ON_TIMELINE.ordinal()] = 106;
            } catch (NoSuchFieldError e106) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.WRITE_POST_TO_PAGE.ordinal()] = 107;
            } catch (NoSuchFieldError e107) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.WRITE_REVIEW.ordinal()] = 108;
            } catch (NoSuchFieldError e108) {
            }
            try {
                f18768a[GraphQLReactionStoryActionStyle.WRITE_REVIEW_ON_PAGE.ordinal()] = 109;
            } catch (NoSuchFieldError e109) {
            }
        }
    }

    public static com.facebook.reaction.action.ReactionActionHandler m22673a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f18769d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.action.ReactionActionHandler.class;
        monitor-enter(r1);
        r0 = f18769d;	 Catch:{ all -> 0x003a }
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
        r0 = m22675b(r0);	 Catch:{ all -> 0x0035 }
        f18769d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18769d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.action.ReactionActionHandler.a(com.facebook.inject.InjectorLike):com.facebook.reaction.action.ReactionActionHandler");
    }

    private static ReactionActionHandler m22675b(InjectorLike injectorLike) {
        return new ReactionActionHandler(ProductMethodAutoProvider.b(injectorLike), ReactionIntentFactory.m22683a(injectorLike), ReactionSessionManager.m22590a(injectorLike));
    }

    @Inject
    public ReactionActionHandler(Product product, ReactionIntentFactory reactionIntentFactory, ReactionSessionManager reactionSessionManager) {
        this.f18770a = product;
        this.f18771b = reactionIntentFactory;
        this.f18772c = reactionSessionManager;
    }

    @Nullable
    public final ReactionAttachmentIntent m22676a(ReactionStoryAttachmentActionCommonFragment reactionStoryAttachmentActionCommonFragment, Context context, @Nullable String str, @Nullable String str2, @Nullable Surface surface, @Nullable String str3) {
        return m22674a(reactionStoryAttachmentActionCommonFragment, context, str, str2, surface, str3, null, null, null);
    }

    @Nullable
    public final ReactionAttachmentIntent m22677a(ReactionStoryAttachmentActionCommonFragment reactionStoryAttachmentActionCommonFragment, Context context, @Nullable String str, @Nullable String str2, @Nullable Surface surface, @Nullable String str3, @Nullable String str4, @Nullable ReactionAnalyticsParams reactionAnalyticsParams) {
        return m22674a(reactionStoryAttachmentActionCommonFragment, context, str, str2, surface, str3, null, str4, reactionAnalyticsParams);
    }

    @Nullable
    public final ReactionAttachmentIntent m22678a(ReactionStoryAttachmentActionCommonFragment reactionStoryAttachmentActionCommonFragment, Context context, @Nullable String str, @Nullable String str2, @Nullable Surface surface, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        return m22674a(reactionStoryAttachmentActionCommonFragment, context, str, str2, surface, str3, str4, str5, null);
    }

    @Nullable
    private ReactionAttachmentIntent m22674a(ReactionStoryAttachmentActionCommonFragment reactionStoryAttachmentActionCommonFragment, Context context, @Nullable String str, @Nullable String str2, @Nullable Surface surface, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable ReactionAnalyticsParams reactionAnalyticsParams) {
        if (reactionStoryAttachmentActionCommonFragment.j() == null) {
            return null;
        }
        ReactionAttachmentIntent k;
        switch (C20751.f18768a[reactionStoryAttachmentActionCommonFragment.j().ordinal()]) {
            case 1:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return ReactionIntentFactory.m22685a(context, reactionStoryAttachmentActionCommonFragment.F().b(), reactionStoryAttachmentActionCommonFragment.F().c());
            case 2:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.V() == null || Strings.isNullOrEmpty(reactionStoryAttachmentActionCommonFragment.F().b()) || Strings.isNullOrEmpty(reactionStoryAttachmentActionCommonFragment.V().d()) || Strings.isNullOrEmpty(reactionStoryAttachmentActionCommonFragment.V().fE_())) {
                    return this.f18771b.m22735a(this.f18772c.m22614b(str2));
                }
                return ReactionIntentFactory.m22687a(context, reactionStoryAttachmentActionCommonFragment.F().b(), reactionStoryAttachmentActionCommonFragment.V().d(), reactionStoryAttachmentActionCommonFragment.V().fE_());
            case 3:
                if (Strings.isNullOrEmpty(reactionStoryAttachmentActionCommonFragment.r()) || Strings.isNullOrEmpty(reactionStoryAttachmentActionCommonFragment.O()) || reactionStoryAttachmentActionCommonFragment.fU_() == null || Strings.isNullOrEmpty(reactionStoryAttachmentActionCommonFragment.fU_().a())) {
                    return null;
                }
                return this.f18771b.m22747a(reactionStoryAttachmentActionCommonFragment.r(), reactionStoryAttachmentActionCommonFragment.O(), reactionStoryAttachmentActionCommonFragment.fU_().a());
            case 4:
                if (reactionStoryAttachmentActionCommonFragment.G() == null) {
                    return null;
                }
                return ReactionIntentFactory.m22689a(Uri.parse(reactionStoryAttachmentActionCommonFragment.G()));
            case 5:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return ReactionIntentFactory.m22703a(reactionStoryAttachmentActionCommonFragment.F().b(), reactionStoryAttachmentActionCommonFragment.F().c(), reactionStoryAttachmentActionCommonFragment.P());
            case 6:
                if (reactionStoryAttachmentActionCommonFragment.z() == null || TextUtils.isEmpty(reactionStoryAttachmentActionCommonFragment.z().g()) || TextUtils.isEmpty(reactionStoryAttachmentActionCommonFragment.z().c())) {
                    return null;
                }
                FundraiserCampaignModel z = reactionStoryAttachmentActionCommonFragment.z();
                String str6 = null;
                if (!(z.fJ_() == null || z.fJ_().b() == null)) {
                    str6 = z.fJ_().b().b();
                }
                String str7 = null;
                if (z.d() != null) {
                    str7 = z.d().a();
                }
                String str8 = null;
                if (z.fK_() != null) {
                    str8 = z.fK_().a();
                }
                return this.f18771b.m22750a(z.c(), z.g(), str8, str7, str6);
            case 7:
                return this.f18771b.m22784h(FBLinks.a("faceweb/f?href=/pages/create/"));
            case 8:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return this.f18771b.m22779f(reactionStoryAttachmentActionCommonFragment.F().b());
            case 9:
                if (reactionStoryAttachmentActionCommonFragment.u() == null || reactionStoryAttachmentActionCommonFragment.u().d() == null || Strings.isNullOrEmpty(reactionStoryAttachmentActionCommonFragment.u().b())) {
                    return null;
                }
                return ReactionIntentFactory.m22693a(reactionStoryAttachmentActionCommonFragment.u(), reactionStoryAttachmentActionCommonFragment.U());
            case 10:
                if (reactionStoryAttachmentActionCommonFragment.t() == null || StringUtil.a(reactionStoryAttachmentActionCommonFragment.t().g()) || reactionStoryAttachmentActionCommonFragment.w() == null || StringUtil.a(reactionStoryAttachmentActionCommonFragment.w().b())) {
                    return null;
                }
                return this.f18771b.m22737a(reactionStoryAttachmentActionCommonFragment.t(), reactionStoryAttachmentActionCommonFragment.w().b());
            case 11:
                if (reactionStoryAttachmentActionCommonFragment.M() == null || StringUtil.a(reactionStoryAttachmentActionCommonFragment.M().eL_()) || StringUtil.a(reactionStoryAttachmentActionCommonFragment.M().l())) {
                    return null;
                }
                return this.f18771b.m22758b(context, reactionStoryAttachmentActionCommonFragment.M().eL_(), reactionStoryAttachmentActionCommonFragment.M().l());
            case 12:
                if (reactionStoryAttachmentActionCommonFragment.M() == null || reactionStoryAttachmentActionCommonFragment.M().eL_() == null) {
                    return null;
                }
                return this.f18771b.m22766c(reactionStoryAttachmentActionCommonFragment.M().eL_());
            case 13:
                if (reactionStoryAttachmentActionCommonFragment.M() == null || reactionStoryAttachmentActionCommonFragment.M().eL_() == null) {
                    return null;
                }
                return this.f18771b.m22759b(reactionStoryAttachmentActionCommonFragment.M().eL_());
            case 14:
                Builder builder = new Builder();
                builder.a(TargetType.UNDIRECTED);
                Intent intent = new Intent(context, FacecastActivity.class);
                intent.putExtras(FacecastActivity.a(builder.a()));
                return new ReactionAttachmentIntent(null, UnitInteractionType.GO_LIVE_TAP, intent);
            case 15:
                if (reactionStoryAttachmentActionCommonFragment.Y() == null || Strings.isNullOrEmpty(reactionStoryAttachmentActionCommonFragment.Y().d())) {
                    return null;
                }
                ReactionIntentFactory reactionIntentFactory = this.f18771b;
                if (str5 == null) {
                    str5 = ActionMechanism.REACTION_ATTACHMENT.toString();
                }
                return reactionIntentFactory.m22743a(str5, reactionStoryAttachmentActionCommonFragment.Y());
            case 16:
                if (reactionStoryAttachmentActionCommonFragment.p() == null || reactionStoryAttachmentActionCommonFragment.p().c() == null || reactionStoryAttachmentActionCommonFragment.p().c().b() == null || Strings.isNullOrEmpty(reactionStoryAttachmentActionCommonFragment.p().c().c()) || Strings.isNullOrEmpty(reactionStoryAttachmentActionCommonFragment.p().c().fH_())) {
                    return null;
                }
                return ReactionIntentFactory.m22692a(reactionStoryAttachmentActionCommonFragment.p(), reactionStoryAttachmentActionCommonFragment.U());
            case 17:
                if (reactionStoryAttachmentActionCommonFragment.D() == null || Strings.isNullOrEmpty(reactionStoryAttachmentActionCommonFragment.D().b())) {
                    return null;
                }
                return this.f18771b.m22752a(reactionStoryAttachmentActionCommonFragment.D().b(), str3, str, false);
            case 18:
                if (Strings.isNullOrEmpty(reactionStoryAttachmentActionCommonFragment.I()) || reactionStoryAttachmentActionCommonFragment.fU_() == null || Strings.isNullOrEmpty(reactionStoryAttachmentActionCommonFragment.fU_().a())) {
                    return null;
                }
                return this.f18771b.m22745a(reactionStoryAttachmentActionCommonFragment.I(), reactionStoryAttachmentActionCommonFragment.fU_().a(), surface);
            case 19:
                if (reactionStoryAttachmentActionCommonFragment.C() == null) {
                    return null;
                }
                return this.f18771b.m22725a(context, reactionStoryAttachmentActionCommonFragment.C().a(), reactionStoryAttachmentActionCommonFragment.C().b());
            case 20:
                return this.f18771b.m22723a();
            case 21:
                return this.f18771b.m22728a(context, reactionStoryAttachmentActionCommonFragment.J(), reactionStoryAttachmentActionCommonFragment.K(), reactionStoryAttachmentActionCommonFragment.L());
            case 22:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return ReactionIntentFactory.m22700a(str2, str3, GraphQLReactionStoryActionStyle.OPEN_PAGE_INFO.toString(), this.f18771b.m22775e(reactionStoryAttachmentActionCommonFragment.F().b()), UnitInteractionType.OPEN_PAGE_INFO_TAP);
            case 23:
                if (reactionStoryAttachmentActionCommonFragment.C() == null || reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return this.f18771b.m22726a(context, reactionStoryAttachmentActionCommonFragment.C().a(), reactionStoryAttachmentActionCommonFragment.C().b(), reactionStoryAttachmentActionCommonFragment.x(), reactionStoryAttachmentActionCommonFragment.F().c(), reactionStoryAttachmentActionCommonFragment.F().b());
            case 24:
                if (reactionStoryAttachmentActionCommonFragment.C() == null || reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return this.f18771b.m22756b(context, reactionStoryAttachmentActionCommonFragment.C().a(), reactionStoryAttachmentActionCommonFragment.C().b(), reactionStoryAttachmentActionCommonFragment.x(), reactionStoryAttachmentActionCommonFragment.F().c(), reactionStoryAttachmentActionCommonFragment.F().b());
            case 25:
                if (reactionStoryAttachmentActionCommonFragment.D() == null || Strings.isNullOrEmpty(reactionStoryAttachmentActionCommonFragment.D().b())) {
                    return null;
                }
                return this.f18771b.m22752a(reactionStoryAttachmentActionCommonFragment.D().b(), str3, str, true);
            case 26:
                return this.f18771b.m22784h(reactionStoryAttachmentActionCommonFragment.ac());
            case 27:
                if (reactionStoryAttachmentActionCommonFragment.ad() == null || reactionStoryAttachmentActionCommonFragment.ad().b() == null) {
                    return null;
                }
                return this.f18771b.m22757b(context, reactionStoryAttachmentActionCommonFragment.ad().b());
            case 28:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.m() == null || reactionStoryAttachmentActionCommonFragment.m().b() == null) {
                    return null;
                }
                return ReactionIntentFactory.m22700a(str2, str3, GraphQLReactionStoryActionStyle.PAGE_COMMERCE_OPEN_COLLECTION.toString(), this.f18771b.m22764c(context, reactionStoryAttachmentActionCommonFragment.F().b(), reactionStoryAttachmentActionCommonFragment.m().b()), UnitInteractionType.OPEN_PAGE_COMMERCE_TAP);
            case 29:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return ReactionIntentFactory.m22700a(str2, str3, GraphQLReactionStoryActionStyle.PAGE_COMMERCE_OPEN_STORE.toString(), this.f18771b.m22769d(context, reactionStoryAttachmentActionCommonFragment.F().b(), null), UnitInteractionType.OPEN_PAGE_COMMERCE_TAP);
            case 30:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || StringUtil.a(reactionStoryAttachmentActionCommonFragment.F().b())) {
                    return null;
                }
                if (!ReactionSurfaceUtil.m4783j(surface)) {
                    return null;
                }
                return ReactionIntentFactory.m22698a(str2, str3, UnitInteractionType.CREATION_TAB, reactionStoryAttachmentActionCommonFragment.F().b());
            case 31:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return this.f18771b.m22790k(context, reactionStoryAttachmentActionCommonFragment.F().b());
            case 32:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return ReactionIntentFactory.m22696a(str2, str3, GraphQLPagePresenceTabType.SERVICES, this.f18771b.m22763c(context, reactionStoryAttachmentActionCommonFragment.F().b()), UnitInteractionType.PAGE_ADD_TAB_TAP);
            case 33:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return this.f18771b.m22789j(reactionStoryAttachmentActionCommonFragment.F().b());
            case 34:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return this.f18771b.m22768d(context, reactionStoryAttachmentActionCommonFragment.F().b());
            case 35:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return ReactionIntentFactory.m22697a(str2, reactionStoryAttachmentActionCommonFragment.F().b(), UnitInteractionType.PROMOTE_PAGE);
            case 36:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null || StringUtil.a(reactionStoryAttachmentActionCommonFragment.F().c()) || reactionStoryAttachmentActionCommonFragment.F().d() == null || StringUtil.a(reactionStoryAttachmentActionCommonFragment.F().d().b())) {
                    return null;
                }
                return ReactionIntentFactory.m22701a(str2, reactionStoryAttachmentActionCommonFragment.F().b(), reactionStoryAttachmentActionCommonFragment.F().c(), reactionStoryAttachmentActionCommonFragment.F().d().b());
            case 37:
                if (str3 == null) {
                    return null;
                }
                return ReactionIntentFactory.m22694a(str3, reactionStoryAttachmentActionCommonFragment.Q());
            case 38:
                if (str3 == null) {
                    return null;
                }
                return this.f18771b.m22767c(str3, str);
            case 39:
                return this.f18771b.m22762c(context);
            case 40:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return this.f18771b.m22798p(context, reactionStoryAttachmentActionCommonFragment.F().b());
            case 41:
                if (this.f18770a != Product.PAA) {
                    return null;
                }
                return ReactionIntentFactory.m22720m(str2);
            case 42:
                if (str2 == null || surface == null || str3 == null) {
                    return null;
                }
                return this.f18771b.m22733a(GraphQLReactionStoryAttachmentsStyle.OG_OBJECT_BLOCKS, str2, surface, str, str3);
            case 43:
                if (str3 == null) {
                    return null;
                }
                return ReactionIntentFactory.m22722o(str3);
            case 44:
                if (reactionStoryAttachmentActionCommonFragment.M() == null || Strings.isNullOrEmpty(reactionStoryAttachmentActionCommonFragment.M().eL_())) {
                    return null;
                }
                return this.f18771b.m22727a(context, reactionStoryAttachmentActionCommonFragment.s(), reactionStoryAttachmentActionCommonFragment.M().eL_());
            case 45:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return this.f18771b.m22778f(context, reactionStoryAttachmentActionCommonFragment.F().b(), reactionStoryAttachmentActionCommonFragment.F().c());
            case 46:
                if (str2 == null || surface == null || str3 == null) {
                    return null;
                }
                return this.f18771b.m22733a(GraphQLReactionStoryAttachmentsStyle.ADMINED_PAGES_LIST, str2, surface, str, str3);
            case 47:
            case 48:
                if (str2 == null || surface == null || str3 == null) {
                    return null;
                }
                return this.f18771b.m22733a(GraphQLReactionStoryAttachmentsStyle.PROFILE_BLOCKS, str2, surface, str, str3);
            case 49:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return this.f18771b.m22777f(context, reactionStoryAttachmentActionCommonFragment.F().b());
            case 50:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return ReactionIntentFactory.m22719k(str2);
            case 51:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                k = this.f18771b.m22790k(context, reactionStoryAttachmentActionCommonFragment.F().b());
                if (!ReactionSurfaceUtil.m4783j(surface)) {
                    return k;
                }
                return ReactionIntentFactory.m22700a(str2, str3, GraphQLReactionStoryActionStyle.SEE_ALL_PAGE_PHOTOS.toString(), k, UnitInteractionType.SEE_MORE_TAP);
            case 52:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return this.f18771b.m22774e(context, reactionStoryAttachmentActionCommonFragment.F().b(), reactionStoryAttachmentActionCommonFragment.F().c());
            case 53:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return ReactionIntentFactory.m22700a(str2, str3, GraphQLReactionStoryActionStyle.SEE_ALL_PAGE_VIDEO_PLAYLISTS.toString(), this.f18771b.m22796n(context, reactionStoryAttachmentActionCommonFragment.F().b()), UnitInteractionType.SEE_MORE_TAP);
            case 54:
                if (reactionStoryAttachmentActionCommonFragment.o() == null) {
                    return null;
                }
                return this.f18771b.m22746a(str3, str2, surface, reactionStoryAttachmentActionCommonFragment.o(), str4, str5, str);
            case 55:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return this.f18771b.m22792l(context, reactionStoryAttachmentActionCommonFragment.F().b());
            case 56:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return this.f18771b.m22795m(context, reactionStoryAttachmentActionCommonFragment.F().b());
            case 57:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || StringUtil.a(reactionStoryAttachmentActionCommonFragment.F().b()) || StringUtil.a(reactionStoryAttachmentActionCommonFragment.F().c())) {
                    return null;
                }
                k = this.f18771b.m22744a(reactionStoryAttachmentActionCommonFragment.F().b(), reactionStoryAttachmentActionCommonFragment.F().c(), context);
                if (!ReactionSurfaceUtil.m4783j(surface)) {
                    return k;
                }
                return ReactionIntentFactory.m22700a(str2, str3, GraphQLReactionStoryActionStyle.SEE_ALL_PAGE_REVIEWS.toString(), k, UnitInteractionType.SEE_ALL_RATINGS_TAP);
            case 58:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return ReactionIntentFactory.m22700a(str2, str3, GraphQLReactionStoryActionStyle.SEE_ALL_PAGE_VIDEOS.toString(), this.f18771b.m22797o(context, reactionStoryAttachmentActionCommonFragment.F().b()), UnitInteractionType.SEE_MORE_TAP);
            case 59:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return this.f18771b.m22781g(context, reactionStoryAttachmentActionCommonFragment.F().b(), reactionStoryAttachmentActionCommonFragment.F().c());
            case 60:
                if (reactionStoryAttachmentActionCommonFragment.M() == null || StringUtil.a(reactionStoryAttachmentActionCommonFragment.M().eL_()) || StringUtil.a(reactionStoryAttachmentActionCommonFragment.M().j())) {
                    return null;
                }
                return this.f18771b.m22744a(reactionStoryAttachmentActionCommonFragment.M().eL_(), reactionStoryAttachmentActionCommonFragment.M().j(), context);
            case 61:
                String X = reactionStoryAttachmentActionCommonFragment.X();
                DefaultTextWithEntitiesFields g = reactionStoryAttachmentActionCommonFragment.g();
                DefaultTextWithEntitiesFields b = reactionStoryAttachmentActionCommonFragment.b();
                DefaultTextWithEntitiesFields c = reactionStoryAttachmentActionCommonFragment.c();
                if (StringUtil.a(X) || g == null || StringUtil.a(g.a())) {
                    return null;
                }
                if (reactionAnalyticsParams != null) {
                    reactionAnalyticsParams.f18812d = str5;
                }
                return this.f18771b.m22749a(X, g.a(), b == null ? null : b.a(), c == null ? null : c.a(), reactionAnalyticsParams);
            case 62:
                if (str2 == null || surface == null || str3 == null) {
                    return null;
                }
                return this.f18771b.m22733a(GraphQLReactionStoryAttachmentsStyle.TOPIC_LIST, str2, surface, str, str3);
            case 63:
                return this.f18771b.m22724a(context);
            case 64:
                String ac = reactionStoryAttachmentActionCommonFragment.ac();
                if (this.f18770a == Product.PAA) {
                    return this.f18771b.m22729a(context, ac);
                }
                return this.f18771b.m22784h(ac);
            case 65:
                if (str2 == null || reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return this.f18771b.m22785i(context, reactionStoryAttachmentActionCommonFragment.F().b());
            case 66:
                if (str2 == null || reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null || StringUtil.a(reactionStoryAttachmentActionCommonFragment.F().c())) {
                    return null;
                }
                return this.f18771b.m22765c(context, str2, reactionStoryAttachmentActionCommonFragment.F().b(), reactionStoryAttachmentActionCommonFragment.F().c());
            case 67:
                if (str2 == null || reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return this.f18771b.m22780g(context, reactionStoryAttachmentActionCommonFragment.F().b());
            case 68:
                if (str2 == null || reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return this.f18771b.m22783h(context, reactionStoryAttachmentActionCommonFragment.F().b());
            case 69:
                if (str2 == null || reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return ReactionIntentFactory.m22721n(str2);
            case 70:
                if (str2 == null || reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return this.f18771b.m22744a(reactionStoryAttachmentActionCommonFragment.F().b(), reactionStoryAttachmentActionCommonFragment.F().c(), context);
            case 71:
                if (str2 == null || reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return this.f18771b.m22787j(context, reactionStoryAttachmentActionCommonFragment.F().b());
            case 72:
                if (this.f18770a != Product.PAA || reactionStoryAttachmentActionCommonFragment.aa() == null || StringUtil.a(reactionStoryAttachmentActionCommonFragment.aa().a())) {
                    return null;
                }
                return ReactionIntentFactory.m22695a(reactionStoryAttachmentActionCommonFragment.aa().a(), str2);
            case 73:
                if (reactionStoryAttachmentActionCommonFragment.M() == null || Strings.isNullOrEmpty(reactionStoryAttachmentActionCommonFragment.M().eL_())) {
                    return null;
                }
                return this.f18771b.m22794l(reactionStoryAttachmentActionCommonFragment.M().eL_());
            case 74:
                if (reactionStoryAttachmentActionCommonFragment.fT_() == null || Strings.isNullOrEmpty(reactionStoryAttachmentActionCommonFragment.fT_().d()) || !reactionStoryAttachmentActionCommonFragment.fT_().b() || Strings.isNullOrEmpty(reactionStoryAttachmentActionCommonFragment.fT_().fL_())) {
                    return null;
                }
                return ReactionIntentFactory.m22707b(reactionStoryAttachmentActionCommonFragment.fT_().d(), reactionStoryAttachmentActionCommonFragment.fT_().fL_());
            case 75:
            case 76:
                if (reactionStoryAttachmentActionCommonFragment.M() == null || Strings.isNullOrEmpty(reactionStoryAttachmentActionCommonFragment.M().eL_())) {
                    return null;
                }
                return ReactionIntentFactory.m22715d(reactionStoryAttachmentActionCommonFragment.M().eL_(), reactionStoryAttachmentActionCommonFragment.j() == GraphQLReactionStoryActionStyle.SHARE_EVENT ? UnitInteractionType.SHARE_EVENT_TAP : UnitInteractionType.OPEN_COMPOSER_TAP);
            case 77:
                if (reactionStoryAttachmentActionCommonFragment.M() == null || StringUtil.a(reactionStoryAttachmentActionCommonFragment.M().eL_()) || StringUtil.a(reactionStoryAttachmentActionCommonFragment.M().l())) {
                    return null;
                }
                return ReactionIntentFactory.m22717h(context, reactionStoryAttachmentActionCommonFragment.M().eL_(), reactionStoryAttachmentActionCommonFragment.M().l());
            case 78:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return ReactionIntentFactory.m22688a(context, reactionStoryAttachmentActionCommonFragment.F().b(), reactionStoryAttachmentActionCommonFragment.F().c(), reactionStoryAttachmentActionCommonFragment.N(), UnitInteractionType.SHARE_PHOTO_TO_PAGE_TAP);
            case 79:
                if (reactionStoryAttachmentActionCommonFragment.M() == null || Strings.isNullOrEmpty(reactionStoryAttachmentActionCommonFragment.M().eL_())) {
                    return null;
                }
                return ReactionIntentFactory.m22713c(reactionStoryAttachmentActionCommonFragment.M().eL_(), str3, str2);
            case 80:
                return this.f18771b.m22786i(context, reactionStoryAttachmentActionCommonFragment.M().eL_(), reactionStoryAttachmentActionCommonFragment.M().j());
            case 81:
                if (reactionStoryAttachmentActionCommonFragment.z() == null || TextUtils.isEmpty(reactionStoryAttachmentActionCommonFragment.z().g())) {
                    return null;
                }
                return this.f18771b.m22799p(reactionStoryAttachmentActionCommonFragment.z().g());
            case 82:
                if (reactionStoryAttachmentActionCommonFragment.y() == null || TextUtils.isEmpty(reactionStoryAttachmentActionCommonFragment.y().b())) {
                    return null;
                }
                return this.f18771b.m22740a(reactionStoryAttachmentActionCommonFragment.y().b(), reactionStoryAttachmentActionCommonFragment.q() == null ? GraphQLFundraiserSupportersConnectionType.DONATED : reactionStoryAttachmentActionCommonFragment.q());
            case 83:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return ReactionIntentFactory.m22700a(str2, str3, GraphQLReactionStoryActionStyle.VIEW_PAGE_CHILD_LOCATIONS.toString(), this.f18771b.m22791k(context, reactionStoryAttachmentActionCommonFragment.F().b(), reactionStoryAttachmentActionCommonFragment.F().c()), UnitInteractionType.OPEN_PAGE_CHILD_LOCATIONS);
            case 84:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null || reactionStoryAttachmentActionCommonFragment.R() == null || reactionStoryAttachmentActionCommonFragment.R().d() == null) {
                    return null;
                }
                return this.f18771b.m22793l(context, reactionStoryAttachmentActionCommonFragment.F().b(), reactionStoryAttachmentActionCommonFragment.R().d());
            case 85:
            case 86:
                if (reactionStoryAttachmentActionCommonFragment.n() == null || reactionStoryAttachmentActionCommonFragment.n().c() == null || reactionStoryAttachmentActionCommonFragment.V() == null || reactionStoryAttachmentActionCommonFragment.V().b() == null || reactionStoryAttachmentActionCommonFragment.V().d() == null) {
                    return null;
                }
                return this.f18771b.m22751a(reactionStoryAttachmentActionCommonFragment.n().c(), reactionStoryAttachmentActionCommonFragment.n().b() == null ? null : reactionStoryAttachmentActionCommonFragment.n().b().b(), reactionStoryAttachmentActionCommonFragment.V().b(), reactionStoryAttachmentActionCommonFragment.V().d(), reactionStoryAttachmentActionCommonFragment.V().c() == null ? null : reactionStoryAttachmentActionCommonFragment.V().c().a(), reactionStoryAttachmentActionCommonFragment.j().equals(GraphQLReactionStoryActionStyle.VIEW_COMMENT_AND_OPEN_COMPOSER));
            case 87:
                k = this.f18771b.m22786i(context, reactionStoryAttachmentActionCommonFragment.F().b(), reactionStoryAttachmentActionCommonFragment.F().c());
                if (!ReactionSurfaceUtil.m4783j(surface)) {
                    return k;
                }
                return ReactionIntentFactory.m22700a(str2, str3, GraphQLReactionStoryActionStyle.VIEW_PAGE_EVENTS.toString(), k, UnitInteractionType.SEE_MORE_TAP);
            case 88:
                if (reactionStoryAttachmentActionCommonFragment.B() == null || reactionStoryAttachmentActionCommonFragment.t() == null) {
                    return null;
                }
                return this.f18771b.m22732a(reactionStoryAttachmentActionCommonFragment.B(), reactionStoryAttachmentActionCommonFragment.t());
            case 89:
                return this.f18771b.m22755b(context);
            case 90:
                if (reactionStoryAttachmentActionCommonFragment.A() == null || reactionStoryAttachmentActionCommonFragment.A().b() == null) {
                    return null;
                }
                return this.f18771b.m22771d(reactionStoryAttachmentActionCommonFragment.A().b());
            case 91:
                if (reactionStoryAttachmentActionCommonFragment.A() == null || reactionStoryAttachmentActionCommonFragment.A().b() == null) {
                    return null;
                }
                return this.f18771b.m22739a(reactionStoryAttachmentActionCommonFragment.A().b(), context);
            case 92:
                if (reactionStoryAttachmentActionCommonFragment.A() == null || reactionStoryAttachmentActionCommonFragment.A().b() == null) {
                    return null;
                }
                return this.f18771b.m22760b(reactionStoryAttachmentActionCommonFragment.A().b(), context);
            case 93:
                if (reactionStoryAttachmentActionCommonFragment.M() == null || Strings.isNullOrEmpty(reactionStoryAttachmentActionCommonFragment.M().eL_()) || Strings.isNullOrEmpty(reactionStoryAttachmentActionCommonFragment.M().j())) {
                    return null;
                }
                return this.f18771b.m22788j(context, reactionStoryAttachmentActionCommonFragment.M().eL_(), reactionStoryAttachmentActionCommonFragment.M().j());
            case 94:
                return this.f18771b.m22782g(reactionStoryAttachmentActionCommonFragment.T());
            case 95:
                return this.f18771b.m22741a(reactionStoryAttachmentActionCommonFragment.T(), reactionStoryAttachmentActionCommonFragment.E());
            case 96:
                if (reactionStoryAttachmentActionCommonFragment.V() == null || reactionStoryAttachmentActionCommonFragment.V().d() == null) {
                    return null;
                }
                return this.f18771b.m22776e(reactionStoryAttachmentActionCommonFragment.V().d(), reactionStoryAttachmentActionCommonFragment.V().b());
            case 97:
                return ReactionIntentFactory.m22705b(context, reactionStoryAttachmentActionCommonFragment.F().b(), reactionStoryAttachmentActionCommonFragment.V().d(), reactionStoryAttachmentActionCommonFragment.V().fE_());
            case 98:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || Strings.isNullOrEmpty(reactionStoryAttachmentActionCommonFragment.F().b())) {
                    return null;
                }
                return ReactionIntentFactory.m22700a(str2, str3, GraphQLReactionStoryActionStyle.VIEW_PAGE_SERVICES.toString(), this.f18771b.m22770d(context, reactionStoryAttachmentActionCommonFragment.F().b(), reactionStoryAttachmentActionCommonFragment.F().c(), null), UnitInteractionType.SEE_MORE_TAP);
            case 99:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return ReactionIntentFactory.m22718i(reactionStoryAttachmentActionCommonFragment.F().b());
            case 100:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || StringUtil.a(reactionStoryAttachmentActionCommonFragment.F().b()) || reactionStoryAttachmentActionCommonFragment.k() == null || StringUtil.a(reactionStoryAttachmentActionCommonFragment.k().b())) {
                    return null;
                }
                if (!ReactionSurfaceUtil.m4783j(surface)) {
                    return null;
                }
                return ReactionIntentFactory.m22699a(str2, str3, UnitInteractionType.ALBUM_TAP, reactionStoryAttachmentActionCommonFragment.F().b(), reactionStoryAttachmentActionCommonFragment.k().b());
            case 101:
                if (reactionStoryAttachmentActionCommonFragment.M() == null || Strings.isNullOrEmpty(reactionStoryAttachmentActionCommonFragment.M().eL_())) {
                    return null;
                }
                return this.f18771b.m22773e(context, reactionStoryAttachmentActionCommonFragment.M().eL_());
            case 102:
                if (reactionStoryAttachmentActionCommonFragment.M() == null || reactionStoryAttachmentActionCommonFragment.M().eL_() == null) {
                    return null;
                }
                if (reactionStoryAttachmentActionCommonFragment.M().b() == null || reactionStoryAttachmentActionCommonFragment.M().b().g() != 67338874) {
                    return this.f18771b.m22736a(reactionStoryAttachmentActionCommonFragment.M(), UnitInteractionType.VIEW_PROFILE_TAP);
                }
                if (reactionAnalyticsParams != null) {
                    reactionAnalyticsParams.f18812d = str5;
                }
                return this.f18771b.m22730a(context, reactionStoryAttachmentActionCommonFragment.M().eL_(), reactionAnalyticsParams);
            case 103:
                if (str2 == null) {
                    return null;
                }
                return ReactionIntentFactory.m22711c(str2, UnitInteractionType.VIEW_PYML_TAP);
            case 104:
                StoryModel V = reactionStoryAttachmentActionCommonFragment.V();
                if (V == null || V.d() == null) {
                    return null;
                }
                FeedbackModel c2 = V.c();
                return this.f18771b.m22748a(V.d(), V.b(), c2 != null ? c2.a() : null, UnitInteractionType.VIEW_STORY_TAP);
            case 105:
                return this.f18771b.m22754b();
            case 106:
                if (reactionStoryAttachmentActionCommonFragment.M() == null || StringUtil.a(reactionStoryAttachmentActionCommonFragment.M().j()) || StringUtil.a(reactionStoryAttachmentActionCommonFragment.M().eL_()) || StringUtil.a(reactionStoryAttachmentActionCommonFragment.M().l())) {
                    return null;
                }
                return ReactionIntentFactory.m22716d(reactionStoryAttachmentActionCommonFragment.M().eL_(), reactionStoryAttachmentActionCommonFragment.M().j(), reactionStoryAttachmentActionCommonFragment.M().l());
            case 107:
                if (reactionStoryAttachmentActionCommonFragment.F() == null || reactionStoryAttachmentActionCommonFragment.F().b() == null) {
                    return null;
                }
                return ReactionIntentFactory.m22702a(reactionStoryAttachmentActionCommonFragment.F().b(), reactionStoryAttachmentActionCommonFragment.F().c(), reactionStoryAttachmentActionCommonFragment.N(), reactionStoryAttachmentActionCommonFragment.l(), UnitInteractionType.WRITE_POST_TO_PAGE_TAP);
            case 108:
                if (Strings.isNullOrEmpty(str3) || reactionStoryAttachmentActionCommonFragment.M() == null || StringUtil.a(reactionStoryAttachmentActionCommonFragment.M().eL_()) || StringUtil.a(reactionStoryAttachmentActionCommonFragment.M().j())) {
                    return null;
                }
                return ReactionIntentFactory.m22710b(str3, reactionStoryAttachmentActionCommonFragment.M().eL_(), reactionStoryAttachmentActionCommonFragment.M().j(), UnitInteractionType.WRITE_REVIEW_TAP);
            case 109:
                if (Strings.isNullOrEmpty(str3) || reactionStoryAttachmentActionCommonFragment.F() == null || StringUtil.a(reactionStoryAttachmentActionCommonFragment.F().b()) || StringUtil.a(reactionStoryAttachmentActionCommonFragment.F().c())) {
                    return null;
                }
                return ReactionIntentFactory.m22710b(str3, reactionStoryAttachmentActionCommonFragment.F().b(), reactionStoryAttachmentActionCommonFragment.F().c(), UnitInteractionType.WRITE_REVIEW_TAP);
            default:
                return null;
        }
    }
}
