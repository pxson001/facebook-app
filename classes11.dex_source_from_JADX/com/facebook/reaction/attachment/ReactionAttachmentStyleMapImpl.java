package com.facebook.reaction.attachment;

import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.reaction.common.ReactionAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionAdminedPagesListAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionBoostedLocalAwarenessAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionCriticReviewHscrollAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionEventBlocksAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionEventHScrollLargeAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionEventLargeAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionFacepileAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionFacepileHscrollAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionFriendYouMayInviteToLikePageAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionImageTextBlockAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionOGObjectBlocksAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionPageAttributionAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionPageCommerceAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionPageLikesAndVisitsAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionPageResidenceAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionPageServiceListAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionPageYouMayLikeHscrollAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionPhotosAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionPhotosLargeAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionPhotosWithAttributionAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionPlaceQuestionHorizontalAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionPlaceQuestionThankyouAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionPlaceQuestionVerticalAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionPopularProductAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionProfileAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionProfileHscrollAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionProfileStoryAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionSimpleLeftRightTextAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionSimpleTextAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionSinglePhotoAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionTodayGenericMLEImageBlocksAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionTopicBlocksAttachmentStyle;
import com.facebook.reaction.ui.attachment.style.ReactionVideoHscrollAttachmentStyle;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: RCTScrollView */
public final class ReactionAttachmentStyleMapImpl implements ReactionAttachmentStyleMap {
    private static volatile ReactionAttachmentStyleMapImpl f11627I;
    private final Lazy<ReactionProfileStoryAttachmentStyle> f11628A;
    private final Lazy<ReactionSimpleLeftRightTextAttachmentStyle> f11629B;
    private final Lazy<ReactionSimpleTextAttachmentStyle> f11630C;
    private final Lazy<ReactionSinglePhotoAttachmentStyle> f11631D;
    private final Lazy<ReactionTodayGenericMLEImageBlocksAttachmentStyle> f11632E;
    private final Lazy<ReactionTopicBlocksAttachmentStyle> f11633F;
    private final Lazy<ReactionVideoHscrollAttachmentStyle> f11634G;
    private ImmutableList<String> f11635H;
    private final Lazy<ReactionAdminedPagesListAttachmentStyle> f11636a;
    private final Lazy<ReactionBoostedLocalAwarenessAttachmentStyle> f11637b;
    private final Lazy<ReactionCriticReviewHscrollAttachmentStyle> f11638c;
    private final Lazy<ReactionEventBlocksAttachmentStyle> f11639d;
    private final Lazy<ReactionEventHScrollLargeAttachmentStyle> f11640e;
    private final Lazy<ReactionEventLargeAttachmentStyle> f11641f;
    private final Lazy<ReactionFacepileAttachmentStyle> f11642g;
    private final Lazy<ReactionFacepileHscrollAttachmentStyle> f11643h;
    private final Lazy<ReactionFriendYouMayInviteToLikePageAttachmentStyle> f11644i;
    private final Lazy<ReactionImageTextBlockAttachmentStyle> f11645j;
    private final Lazy<ReactionOGObjectBlocksAttachmentStyle> f11646k;
    private final Lazy<ReactionPageAttributionAttachmentStyle> f11647l;
    private final Lazy<ReactionPageCommerceAttachmentStyle> f11648m;
    private final Lazy<ReactionPageLikesAndVisitsAttachmentStyle> f11649n;
    private final Lazy<ReactionPageResidenceAttachmentStyle> f11650o;
    private final Lazy<ReactionPageServiceListAttachmentStyle> f11651p;
    private final Lazy<ReactionPageYouMayLikeHscrollAttachmentStyle> f11652q;
    private final Lazy<ReactionPhotosAttachmentStyle> f11653r;
    private final Lazy<ReactionPhotosLargeAttachmentStyle> f11654s;
    private final Lazy<ReactionPhotosWithAttributionAttachmentStyle> f11655t;
    private final Lazy<ReactionPlaceQuestionHorizontalAttachmentStyle> f11656u;
    private final Lazy<ReactionPlaceQuestionThankyouAttachmentStyle> f11657v;
    private final Lazy<ReactionPlaceQuestionVerticalAttachmentStyle> f11658w;
    private final Lazy<ReactionPopularProductAttachmentStyle> f11659x;
    private final Lazy<ReactionProfileAttachmentStyle> f11660y;
    private final Lazy<ReactionProfileHscrollAttachmentStyle> f11661z;

    public static com.facebook.reaction.attachment.ReactionAttachmentStyleMapImpl m12140a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11627I;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.attachment.ReactionAttachmentStyleMapImpl.class;
        monitor-enter(r1);
        r0 = f11627I;	 Catch:{ all -> 0x003a }
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
        r0 = m12141b(r0);	 Catch:{ all -> 0x0035 }
        f11627I = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11627I;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.attachment.ReactionAttachmentStyleMapImpl.a(com.facebook.inject.InjectorLike):com.facebook.reaction.attachment.ReactionAttachmentStyleMapImpl");
    }

    private static ReactionAttachmentStyleMapImpl m12141b(InjectorLike injectorLike) {
        return new ReactionAttachmentStyleMapImpl(IdBasedLazy.a(injectorLike, 10119), IdBasedLazy.a(injectorLike, 10120), IdBasedLazy.a(injectorLike, 10121), IdBasedLazy.a(injectorLike, 10122), IdBasedLazy.a(injectorLike, 10123), IdBasedLazy.a(injectorLike, 10124), IdBasedLazy.a(injectorLike, 10125), IdBasedLazy.a(injectorLike, 10126), IdBasedLazy.a(injectorLike, 10127), IdBasedLazy.a(injectorLike, 10128), IdBasedLazy.a(injectorLike, 10129), IdBasedLazy.a(injectorLike, 10130), IdBasedLazy.a(injectorLike, 10131), IdBasedLazy.a(injectorLike, 10132), IdBasedLazy.a(injectorLike, 10133), IdBasedLazy.a(injectorLike, 10134), IdBasedLazy.a(injectorLike, 10135), IdBasedLazy.a(injectorLike, 10136), IdBasedLazy.a(injectorLike, 10137), IdBasedLazy.a(injectorLike, 10138), IdBasedLazy.a(injectorLike, 10139), IdBasedLazy.a(injectorLike, 10140), IdBasedLazy.a(injectorLike, 10141), IdBasedLazy.a(injectorLike, 10142), IdBasedLazy.a(injectorLike, 10143), IdBasedLazy.a(injectorLike, 10144), IdBasedLazy.a(injectorLike, 10145), IdBasedLazy.a(injectorLike, 10146), IdBasedLazy.a(injectorLike, 10147), IdBasedLazy.a(injectorLike, 10148), IdBasedLazy.a(injectorLike, 10149), IdBasedLazy.a(injectorLike, 10150), IdBasedLazy.a(injectorLike, 10151));
    }

    @Inject
    public ReactionAttachmentStyleMapImpl(Lazy<ReactionAdminedPagesListAttachmentStyle> lazy, Lazy<ReactionBoostedLocalAwarenessAttachmentStyle> lazy2, Lazy<ReactionCriticReviewHscrollAttachmentStyle> lazy3, Lazy<ReactionEventBlocksAttachmentStyle> lazy4, Lazy<ReactionEventHScrollLargeAttachmentStyle> lazy5, Lazy<ReactionEventLargeAttachmentStyle> lazy6, Lazy<ReactionFacepileAttachmentStyle> lazy7, Lazy<ReactionFacepileHscrollAttachmentStyle> lazy8, Lazy<ReactionFriendYouMayInviteToLikePageAttachmentStyle> lazy9, Lazy<ReactionImageTextBlockAttachmentStyle> lazy10, Lazy<ReactionOGObjectBlocksAttachmentStyle> lazy11, Lazy<ReactionPageAttributionAttachmentStyle> lazy12, Lazy<ReactionPageCommerceAttachmentStyle> lazy13, Lazy<ReactionPageLikesAndVisitsAttachmentStyle> lazy14, Lazy<ReactionPageResidenceAttachmentStyle> lazy15, Lazy<ReactionPageServiceListAttachmentStyle> lazy16, Lazy<ReactionPageYouMayLikeHscrollAttachmentStyle> lazy17, Lazy<ReactionPhotosAttachmentStyle> lazy18, Lazy<ReactionPhotosLargeAttachmentStyle> lazy19, Lazy<ReactionPhotosWithAttributionAttachmentStyle> lazy20, Lazy<ReactionPlaceQuestionHorizontalAttachmentStyle> lazy21, Lazy<ReactionPlaceQuestionThankyouAttachmentStyle> lazy22, Lazy<ReactionPlaceQuestionVerticalAttachmentStyle> lazy23, Lazy<ReactionPopularProductAttachmentStyle> lazy24, Lazy<ReactionProfileAttachmentStyle> lazy25, Lazy<ReactionProfileHscrollAttachmentStyle> lazy26, Lazy<ReactionProfileStoryAttachmentStyle> lazy27, Lazy<ReactionSimpleLeftRightTextAttachmentStyle> lazy28, Lazy<ReactionSimpleTextAttachmentStyle> lazy29, Lazy<ReactionSinglePhotoAttachmentStyle> lazy30, Lazy<ReactionTodayGenericMLEImageBlocksAttachmentStyle> lazy31, Lazy<ReactionTopicBlocksAttachmentStyle> lazy32, Lazy<ReactionVideoHscrollAttachmentStyle> lazy33) {
        this.f11636a = lazy;
        this.f11637b = lazy2;
        this.f11638c = lazy3;
        this.f11639d = lazy4;
        this.f11640e = lazy5;
        this.f11641f = lazy6;
        this.f11642g = lazy7;
        this.f11643h = lazy8;
        this.f11644i = lazy9;
        this.f11645j = lazy10;
        this.f11646k = lazy11;
        this.f11647l = lazy12;
        this.f11648m = lazy13;
        this.f11649n = lazy14;
        this.f11650o = lazy15;
        this.f11651p = lazy16;
        this.f11652q = lazy17;
        this.f11653r = lazy18;
        this.f11654s = lazy19;
        this.f11655t = lazy20;
        this.f11656u = lazy21;
        this.f11657v = lazy22;
        this.f11658w = lazy23;
        this.f11659x = lazy24;
        this.f11660y = lazy25;
        this.f11661z = lazy26;
        this.f11628A = lazy27;
        this.f11629B = lazy28;
        this.f11630C = lazy29;
        this.f11631D = lazy30;
        this.f11632E = lazy31;
        this.f11633F = lazy32;
        this.f11634G = lazy33;
    }

    @Nullable
    public final ReactionAttachmentStyle m12142a(GraphQLReactionStoryAttachmentsStyle graphQLReactionStoryAttachmentsStyle) {
        switch (graphQLReactionStoryAttachmentsStyle.ordinal()) {
            case 1:
                return (ReactionAttachmentStyle) this.f11660y.get();
            case 2:
                return (ReactionAttachmentStyle) this.f11653r.get();
            case 3:
                return (ReactionAttachmentStyle) this.f11628A.get();
            case 4:
                return (ReactionAttachmentStyle) this.f11631D.get();
            case 6:
                return (ReactionAttachmentStyle) this.f11642g.get();
            case 7:
                return (ReactionAttachmentStyle) this.f11633F.get();
            case 9:
                return (ReactionAttachmentStyle) this.f11659x.get();
            case 10:
                return (ReactionAttachmentStyle) this.f11639d.get();
            case 16:
                return (ReactionAttachmentStyle) this.f11634G.get();
            case 18:
                return (ReactionAttachmentStyle) this.f11656u.get();
            case 19:
                return (ReactionAttachmentStyle) this.f11658w.get();
            case 20:
                return (ReactionAttachmentStyle) this.f11643h.get();
            case 21:
                return (ReactionAttachmentStyle) this.f11657v.get();
            case 22:
                return (ReactionAttachmentStyle) this.f11632E.get();
            case 24:
                return (ReactionAttachmentStyle) this.f11649n.get();
            case 25:
                return (ReactionAttachmentStyle) this.f11630C.get();
            case 26:
                return (ReactionAttachmentStyle) this.f11629B.get();
            case 27:
                return (ReactionAttachmentStyle) this.f11638c.get();
            case 30:
                return (ReactionAttachmentStyle) this.f11645j.get();
            case 32:
                return (ReactionAttachmentStyle) this.f11651p.get();
            case 33:
                return (ReactionAttachmentStyle) this.f11641f.get();
            case 34:
                return (ReactionAttachmentStyle) this.f11654s.get();
            case 37:
                return (ReactionAttachmentStyle) this.f11636a.get();
            case 38:
                return (ReactionAttachmentStyle) this.f11640e.get();
            case 39:
                return (ReactionAttachmentStyle) this.f11647l.get();
            case 40:
                return (ReactionAttachmentStyle) this.f11648m.get();
            case 41:
                return (ReactionAttachmentStyle) this.f11655t.get();
            case 42:
                return (ReactionAttachmentStyle) this.f11650o.get();
            case 43:
                return (ReactionAttachmentStyle) this.f11652q.get();
            case 47:
                return (ReactionAttachmentStyle) this.f11644i.get();
            case 54:
                return (ReactionAttachmentStyle) this.f11661z.get();
            case 64:
                return (ReactionAttachmentStyle) this.f11646k.get();
            case 69:
                return (ReactionAttachmentStyle) this.f11637b.get();
            default:
                return null;
        }
    }

    public final ImmutableList<String> m12143a() {
        if (this.f11635H == null) {
            this.f11635H = ImmutableList.of(GraphQLReactionStoryAttachmentsStyle.ADMINED_PAGES_LIST.name(), GraphQLReactionStoryAttachmentsStyle.BOOSTED_LOCAL_AWARENESS_TIP.name(), GraphQLReactionStoryAttachmentsStyle.CRITIC_REVIEW_HORIZONTAL_SCROLL.name(), GraphQLReactionStoryAttachmentsStyle.EVENT_BLOCKS.name(), GraphQLReactionStoryAttachmentsStyle.EVENT_CARD_LARGE_HORIZONTAL_SCROLL.name(), GraphQLReactionStoryAttachmentsStyle.EVENT_CARD_LARGE.name(), GraphQLReactionStoryAttachmentsStyle.FACEPILE.name(), GraphQLReactionStoryAttachmentsStyle.FACEPILE_HORIZONTAL_SCROLL.name(), GraphQLReactionStoryAttachmentsStyle.FRIEND_YOU_MAY_INVITE_TO_LIKE_PAGE.name(), GraphQLReactionStoryAttachmentsStyle.IMAGE_TEXT_BLOCK.name(), GraphQLReactionStoryAttachmentsStyle.OG_OBJECT_BLOCKS.name(), GraphQLReactionStoryAttachmentsStyle.PAGE_ATTRIBUTION_FOOTER.name(), new String[]{GraphQLReactionStoryAttachmentsStyle.PAGE_COMMERCE_UNITS.name(), GraphQLReactionStoryAttachmentsStyle.PAGE_LIKES_AND_VISITS.name(), GraphQLReactionStoryAttachmentsStyle.PAGE_WELCOME_HOME.name(), GraphQLReactionStoryAttachmentsStyle.PAGE_SERVICE_LIST.name(), GraphQLReactionStoryAttachmentsStyle.PAGE_YOU_MAY_LIKE_HORIZONTAL_SCROLL.name(), GraphQLReactionStoryAttachmentsStyle.PHOTOS.name(), GraphQLReactionStoryAttachmentsStyle.PHOTOS_LARGE.name(), GraphQLReactionStoryAttachmentsStyle.PHOTOS_WITH_ATTRIBUTION.name(), GraphQLReactionStoryAttachmentsStyle.PLACE_QUESTION_HORIZONTAL.name(), GraphQLReactionStoryAttachmentsStyle.PLACE_SURVEY_THANK_YOU.name(), GraphQLReactionStoryAttachmentsStyle.PLACE_QUESTION_VERTICAL.name(), GraphQLReactionStoryAttachmentsStyle.PAGE_PRODUCT_LIST.name(), GraphQLReactionStoryAttachmentsStyle.PROFILE_BLOCKS.name(), GraphQLReactionStoryAttachmentsStyle.PROFILE_HORIZONTAL_SCROLL.name(), GraphQLReactionStoryAttachmentsStyle.FEED_STORY_PROFILE_BLOCKS.name(), GraphQLReactionStoryAttachmentsStyle.SIMPLE_LEFT_RIGHT_TEXT.name(), GraphQLReactionStoryAttachmentsStyle.SIMPLE_TEXT.name(), GraphQLReactionStoryAttachmentsStyle.SINGLE_LARGE_PHOTO.name(), GraphQLReactionStoryAttachmentsStyle.TODAY_GENERIC_MLE_IMAGE_BLOCKS.name(), GraphQLReactionStoryAttachmentsStyle.TOPIC_LIST.name(), GraphQLReactionStoryAttachmentsStyle.VIDEO_HORIZONTAL_SCROLL.name(), GraphQLReactionStoryAttachmentsStyle.FEED_STORY_SINGLE.name(), GraphQLReactionStoryAttachmentsStyle.PAGE_POST_STORY.name()});
        }
        return this.f11635H;
    }
}
