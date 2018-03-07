package com.facebook.reaction;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLReactionStoryActionStyle;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Singleton;

@Singleton
/* compiled from: button-size */
public class ReactionSupportedActionStyles {
    private static volatile ReactionSupportedActionStyles f18714b;
    public final ReactionExpensiveConditionalActionStyleProvider[] f18715a = new ReactionExpensiveConditionalActionStyleProvider[]{new C20711(this)};

    @VisibleForTesting
    /* compiled from: button-size */
    public interface ReactionExpensiveConditionalActionStyleProvider {
        GraphQLReactionStoryActionStyle mo1112a();

        boolean mo1113a(Surface surface);
    }

    /* compiled from: button-size */
    class C20711 implements ReactionExpensiveConditionalActionStyleProvider {
        final /* synthetic */ ReactionSupportedActionStyles f18713a;

        C20711(ReactionSupportedActionStyles reactionSupportedActionStyles) {
            this.f18713a = reactionSupportedActionStyles;
        }

        public final boolean mo1113a(Surface surface) {
            return surface == Surface.ANDROID_EVENT_PERMALINK;
        }

        public final GraphQLReactionStoryActionStyle mo1112a() {
            return GraphQLReactionStoryActionStyle.INVITE_FRIENDS_TO_EVENT;
        }
    }

    public static com.facebook.reaction.ReactionSupportedActionStyles m22625a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f18714b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.reaction.ReactionSupportedActionStyles.class;
        monitor-enter(r1);
        r0 = f18714b;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m22624a();	 Catch:{ all -> 0x0034 }
        f18714b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f18714b;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.ReactionSupportedActionStyles.a(com.facebook.inject.InjectorLike):com.facebook.reaction.ReactionSupportedActionStyles");
    }

    private static ReactionSupportedActionStyles m22624a() {
        return new ReactionSupportedActionStyles();
    }

    public final ImmutableList<String> m22626a(Surface surface) {
        int i = 0;
        Builder b = ImmutableList.builder().b(new String[]{GraphQLReactionStoryActionStyle.ADD_PHOTOS.name(), GraphQLReactionStoryActionStyle.BOOST_POST.name(), GraphQLReactionStoryActionStyle.BROWSE_QUERY.name(), GraphQLReactionStoryActionStyle.CALL_PHONE.name(), GraphQLReactionStoryActionStyle.CHECK_IN.name(), GraphQLReactionStoryActionStyle.CONTACT_FUNDRAISER_SUPPORTERS.name(), GraphQLReactionStoryActionStyle.CREATE_PAGE.name(), GraphQLReactionStoryActionStyle.CRISIS_MARK_SAFE.name(), GraphQLReactionStoryActionStyle.CRISIS_NOT_IN_AREA.name(), GraphQLReactionStoryActionStyle.DO_NOTHING.name(), GraphQLReactionStoryActionStyle.EDIT_PAGE_INFO.name(), GraphQLReactionStoryActionStyle.EVENTS_SUBSCRIBE.name(), GraphQLReactionStoryActionStyle.EVENT_COMPOSER.name(), GraphQLReactionStoryActionStyle.EVENT_MESSAGE_FRIENDS.name(), GraphQLReactionStoryActionStyle.EVENT_MESSAGE_FRIENDS_AS_GROUP.name(), GraphQLReactionStoryActionStyle.EVENT_MESSAGE_FRIENDS_SEPARATELY.name(), GraphQLReactionStoryActionStyle.EVENT_MESSAGE_ONLY_FRIEND.name(), GraphQLReactionStoryActionStyle.FRIENDS_IN_CITY.name(), GraphQLReactionStoryActionStyle.GOING_TO_EVENT.name(), GraphQLReactionStoryActionStyle.GO_LIVE.name(), GraphQLReactionStoryActionStyle.HIDE_EVENT_SUGGESTION.name(), GraphQLReactionStoryActionStyle.HOVER_TOOLTIP.name(), GraphQLReactionStoryActionStyle.INVITE_FUNDRAISER_GUEST.name(), GraphQLReactionStoryActionStyle.JOIN_EVENT.name(), GraphQLReactionStoryActionStyle.MAYBE_GOING_TO_EVENT.name(), GraphQLReactionStoryActionStyle.MEMBER_OF_GROUP.name(), GraphQLReactionStoryActionStyle.MINUTIAE_COMPOSER.name(), GraphQLReactionStoryActionStyle.NOT_GOING_TO_EVENT.name(), GraphQLReactionStoryActionStyle.OPEN_ALL_PLAYS.name(), GraphQLReactionStoryActionStyle.OPEN_LOCAL_SEARCH.name(), GraphQLReactionStoryActionStyle.OPEN_MAP.name(), GraphQLReactionStoryActionStyle.OPEN_NEARBY_FRIENDS_SETTINGS.name(), GraphQLReactionStoryActionStyle.OPEN_NEARBY_PLACES.name(), GraphQLReactionStoryActionStyle.OPEN_PAGE_INFO.name(), GraphQLReactionStoryActionStyle.OPEN_PAGE_MAP.name(), GraphQLReactionStoryActionStyle.OPEN_PAGE_NAVIGATION.name(), GraphQLReactionStoryActionStyle.OPEN_SCORING_PLAYS.name(), GraphQLReactionStoryActionStyle.OPEN_URL.name(), GraphQLReactionStoryActionStyle.OPEN_VERTICAL_ACTION_SHEET.name(), GraphQLReactionStoryActionStyle.OPEN_VIDEO_CHANNEL.name(), GraphQLReactionStoryActionStyle.PAGE_COMMERCE_OPEN_COLLECTION.name(), GraphQLReactionStoryActionStyle.PAGE_COMMERCE_OPEN_STORE.name(), GraphQLReactionStoryActionStyle.PAGE_CREATE_PHOTO_ALBUM.name(), GraphQLReactionStoryActionStyle.PAGE_SEE_ALL_PHOTO_ALBUMS.name(), GraphQLReactionStoryActionStyle.PAGE_SERVICE_START.name(), GraphQLReactionStoryActionStyle.PAGE_SHOP_ADD_PRODUCT.name(), GraphQLReactionStoryActionStyle.PAGE_SHOP_START.name(), GraphQLReactionStoryActionStyle.PROMOTE_PAGE.name(), GraphQLReactionStoryActionStyle.PUBLISH_PAGE_POST.name(), GraphQLReactionStoryActionStyle.REPLACE_UNIT.name(), GraphQLReactionStoryActionStyle.RESPOND_TO_EVENT.name(), GraphQLReactionStoryActionStyle.SAVE_OG_OBJECT.name(), GraphQLReactionStoryActionStyle.SAVE_PAGE.name(), GraphQLReactionStoryActionStyle.SEE_ALL_ADMINED_PAGES.name(), GraphQLReactionStoryActionStyle.SEE_ALL_ADMIN_FEED_STORIES.name(), GraphQLReactionStoryActionStyle.SEE_ALL_FACEPILE_PROFILES.name(), GraphQLReactionStoryActionStyle.SEE_ALL_FEED_STORIES.name(), GraphQLReactionStoryActionStyle.SEE_ALL_FRIENDS_TO_INVITE_TO_PAGE.name(), GraphQLReactionStoryActionStyle.SEE_ALL_FRIEND_REQUESTS.name(), GraphQLReactionStoryActionStyle.SEE_ALL_MESSAGES.name(), GraphQLReactionStoryActionStyle.SEE_ALL_OG_OBJECTS.name(), GraphQLReactionStoryActionStyle.SEE_ALL_PAGE_COMMENTS.name(), GraphQLReactionStoryActionStyle.SEE_ALL_PAGE_INSIGHTS.name(), GraphQLReactionStoryActionStyle.SEE_ALL_PAGE_PHOTOS.name(), GraphQLReactionStoryActionStyle.SEE_ALL_PAGE_POSTS.name(), GraphQLReactionStoryActionStyle.SEE_ALL_PAGE_REVIEWS.name(), GraphQLReactionStoryActionStyle.SEE_ALL_PAGE_VIDEOS.name(), GraphQLReactionStoryActionStyle.SEE_ALL_PAGE_VIDEO_PLAYLISTS.name(), GraphQLReactionStoryActionStyle.SEE_ALL_PAGINATABLE_COMPONENTS_ACTION.name(), GraphQLReactionStoryActionStyle.SEE_ALL_PHOTOS.name(), GraphQLReactionStoryActionStyle.SEE_ALL_PHOTOS_AT_PAGE.name(), GraphQLReactionStoryActionStyle.SEE_ALL_PHOTOS_BY_CATEGORY.name(), GraphQLReactionStoryActionStyle.SEE_ALL_PHOTOS_OF_PAGE.name(), GraphQLReactionStoryActionStyle.SEE_ALL_POSTS_TO_PAGE.name(), GraphQLReactionStoryActionStyle.SEE_ALL_PROFILES.name(), GraphQLReactionStoryActionStyle.SEE_ALL_RATINGS.name(), GraphQLReactionStoryActionStyle.SEE_ALL_SUGGESTED_EVENTS.name(), GraphQLReactionStoryActionStyle.SEE_ALL_TOPICS.name(), GraphQLReactionStoryActionStyle.SEE_APPS.name(), GraphQLReactionStoryActionStyle.SEE_PAGE_ADS_AND_PROMOTIONS.name(), GraphQLReactionStoryActionStyle.SEE_PAGE_CHECKINS_DETAILS.name(), GraphQLReactionStoryActionStyle.SEE_PAGE_LIKE_DETAILS.name(), GraphQLReactionStoryActionStyle.SEE_PAGE_LIKERS_DETAILS.name(), GraphQLReactionStoryActionStyle.SEE_PAGE_MENTIONS_DETAILS.name(), GraphQLReactionStoryActionStyle.SEE_PAGE_PROFILE.name(), GraphQLReactionStoryActionStyle.SEE_PAGE_REVIEWS_DETAILS.name(), GraphQLReactionStoryActionStyle.SEE_PAGE_SHARES_DETAILS.name(), GraphQLReactionStoryActionStyle.SEND_MESSAGE_AS_PAGE.name(), GraphQLReactionStoryActionStyle.SEND_MESSAGE_TO_PROFILE.name(), GraphQLReactionStoryActionStyle.SHARE_EVENT.name(), GraphQLReactionStoryActionStyle.SHARE_FUNDRAISER.name(), GraphQLReactionStoryActionStyle.SHARE_OG_OBJECT.name(), GraphQLReactionStoryActionStyle.SHARE_PAGE.name(), GraphQLReactionStoryActionStyle.SHARE_PHOTO_TO_PAGE.name(), GraphQLReactionStoryActionStyle.SHARE_PROFILE_LINK.name(), GraphQLReactionStoryActionStyle.UNHIGHLIGHT_RICH_NOTIF.name(), GraphQLReactionStoryActionStyle.VIEW_COMMENT.name(), GraphQLReactionStoryActionStyle.VIEW_COMMENT_AND_OPEN_COMPOSER.name(), GraphQLReactionStoryActionStyle.VIEW_EVENTS.name(), GraphQLReactionStoryActionStyle.VIEW_EVENTS_DASHBOARD.name(), GraphQLReactionStoryActionStyle.VIEW_EVENT_POSTS.name(), GraphQLReactionStoryActionStyle.VIEW_FUNDRAISER.name(), GraphQLReactionStoryActionStyle.VIEW_FUNDRAISER_SUPPORTERS.name(), GraphQLReactionStoryActionStyle.VIEW_GROUP.name(), GraphQLReactionStoryActionStyle.VIEW_GROUP_EVENTS.name(), GraphQLReactionStoryActionStyle.VIEW_GROUP_PHOTOS.name(), GraphQLReactionStoryActionStyle.VIEW_GUEST_LIST.name(), GraphQLReactionStoryActionStyle.VIEW_MENU.name(), GraphQLReactionStoryActionStyle.VIEW_NEARBY_FRIENDS.name(), GraphQLReactionStoryActionStyle.VIEW_NEARBY_FRIENDS_NUX.name(), GraphQLReactionStoryActionStyle.VIEW_PAGE_ADMIN_POST.name(), GraphQLReactionStoryActionStyle.VIEW_PAGE_ADMIN_POST_INSIGHT.name(), GraphQLReactionStoryActionStyle.VIEW_PAGE_CHILD_LOCATIONS.name(), GraphQLReactionStoryActionStyle.VIEW_PAGE_EVENTS.name(), GraphQLReactionStoryActionStyle.VIEW_PAGE_SERVICE.name(), GraphQLReactionStoryActionStyle.VIEW_PAGE_SERVICES.name(), GraphQLReactionStoryActionStyle.VIEW_PAGE_SETTINGS.name(), GraphQLReactionStoryActionStyle.VIEW_PHOTOS_OF_PAGE_ALBUM.name(), GraphQLReactionStoryActionStyle.VIEW_PHOTO_MENU.name(), GraphQLReactionStoryActionStyle.VIEW_PROFILE.name(), GraphQLReactionStoryActionStyle.VIEW_PYML.name(), GraphQLReactionStoryActionStyle.VIEW_STORY.name(), GraphQLReactionStoryActionStyle.VIEW_UPCOMING_BIRTHDAYS_DASHBOARD.name(), GraphQLReactionStoryActionStyle.WRITE_ON_TIMELINE.name(), GraphQLReactionStoryActionStyle.WRITE_POST_TO_PAGE.name(), GraphQLReactionStoryActionStyle.WRITE_REVIEW.name(), GraphQLReactionStoryActionStyle.WRITE_REVIEW_ON_PAGE.name()});
        if (this.f18715a != null) {
            ReactionExpensiveConditionalActionStyleProvider[] reactionExpensiveConditionalActionStyleProviderArr = this.f18715a;
            int length = reactionExpensiveConditionalActionStyleProviderArr.length;
            while (i < length) {
                ReactionExpensiveConditionalActionStyleProvider reactionExpensiveConditionalActionStyleProvider = reactionExpensiveConditionalActionStyleProviderArr[i];
                if (reactionExpensiveConditionalActionStyleProvider.mo1113a(surface)) {
                    b.c(reactionExpensiveConditionalActionStyleProvider.mo1112a().name());
                }
                i++;
            }
        }
        return b.b();
    }
}
