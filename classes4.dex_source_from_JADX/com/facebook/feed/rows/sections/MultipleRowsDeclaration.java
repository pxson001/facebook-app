package com.facebook.feed.rows.sections;

import com.facebook.attachments.angora.AngoraAttachmentView;
import com.facebook.attachments.angora.AngoraAttachmentWithSubcontextView;
import com.facebook.attachments.angora.AngoraInstantArticlesAttachmentView;
import com.facebook.attachments.angora.AngoraInstantPreviewAttachmentView;
import com.facebook.attachments.angora.AngoraVideoAttachmentView;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.links.ActionLinkFooterPartDefinition;
import com.facebook.feed.rows.pager.PagerRowType;
import com.facebook.feed.rows.permalink.PermalinkProfilePhotoPromptPartDefinition;
import com.facebook.feed.rows.permalink.ShareCountPartDefinition;
import com.facebook.feed.rows.photosfeed.PhotosFeedAttachmentImagePartDefinition;
import com.facebook.feed.rows.photosfeed.PhotosFeedAttachmentStaticVideoPartDefinition;
import com.facebook.feed.rows.photosfeed.PhotosFeedAttachmentVideoPartDefinition;
import com.facebook.feed.rows.photosfeed.PhotosFeedObjectionableAttachmentImagePartDefinition;
import com.facebook.feed.rows.photosfeed.PhotosFeedObjectionableAttachmentMessagePartDefinition;
import com.facebook.feed.rows.sections.attachments.AlbumAttachmentPagePartDefinition;
import com.facebook.feed.rows.sections.attachments.CenteredTextPartDefinition;
import com.facebook.feed.rows.sections.attachments.GifShareAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.ImageShareAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.LifeEventAttachmentDescriptionPartDefinition;
import com.facebook.feed.rows.sections.attachments.LifeEventAttachmentHeaderIconPartDefinition;
import com.facebook.feed.rows.sections.attachments.LifeEventAttachmentHeaderTextPartDefinition;
import com.facebook.feed.rows.sections.attachments.LivePhotoAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.MinutiaeAttachmentIconPartDefinition;
import com.facebook.feed.rows.sections.attachments.MinutiaeAttachmentTextPartDefinition;
import com.facebook.feed.rows.sections.attachments.ObjectionableContentPhotoAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.PhotoAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.ReadingAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.SphericalPhotoAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.SportsMatchFooterTextPartDefinition;
import com.facebook.feed.rows.sections.attachments.SportsMatchPhotoPartDefinition;
import com.facebook.feed.rows.sections.attachments.SportsMatchScorePartDefinition;
import com.facebook.feed.rows.sections.attachments.TranscodedAnimatedImageShareAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.calltoaction.LinkShareActionPartDefinition;
import com.facebook.feed.rows.sections.attachments.calltoaction.PageLikeAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.calltoaction.ui.CallToActionAttachmentView;
import com.facebook.feed.rows.sections.attachments.calltoaction.ui.LeadGenCallToActionAttachmentView;
import com.facebook.feed.rows.sections.attachments.linkshare.AttachmentLinkCoverPartDefinition;
import com.facebook.feed.rows.sections.attachments.linkshare.QuoteShareWithQuoteMarkPartDefinition;
import com.facebook.feed.rows.sections.attachments.linkshare.QuoteShareWithVerticalBarPartDefinition;
import com.facebook.feed.rows.sections.attachments.linkshare.components.ShareAttachmentComponentPartDefinition;
import com.facebook.feed.rows.sections.attachments.ui.EventAttachmentView;
import com.facebook.feed.rows.sections.attachments.ui.EventTicketAttachmentView;
import com.facebook.feed.rows.sections.attachments.ui.LargeSquarePhotoInstantArticleAttachmentView;
import com.facebook.feed.rows.sections.attachments.ui.LargeSquarePhotoShareAttachmentView;
import com.facebook.feed.rows.sections.attachments.ui.PortraitPhotoShareAttachmentView;
import com.facebook.feed.rows.sections.attachments.ui.RatingBarShareAttachmentView;
import com.facebook.feed.rows.sections.attachments.ui.UnavailableAttachmentView;
import com.facebook.feed.rows.sections.attachments.videos.VideoViewCountPartDefinition;
import com.facebook.feed.rows.sections.common.EmptyPartDefinition;
import com.facebook.feed.rows.sections.common.endoffeed.EndOfFeedPartDefinition;
import com.facebook.feed.rows.sections.common.loadingmore.LoadingMorePartDefinition;
import com.facebook.feed.rows.sections.common.scissor.ScissorPartDefinition;
import com.facebook.feed.rows.sections.common.unknown.UnknownFeedUnitPartDefinition;
import com.facebook.feed.rows.sections.header.DefaultFriendableHeaderPartDefinition;
import com.facebook.feed.rows.sections.header.ExplanationPartDefinition;
import com.facebook.feed.rows.sections.header.FeedTextHeaderComponentPartDefinition;
import com.facebook.feed.rows.sections.header.FollowableHeaderPartDefinition;
import com.facebook.feed.rows.sections.header.LikableHeaderPartDefinition;
import com.facebook.feed.rows.sections.header.PageOutcomeButtonHeaderPartDefinition;
import com.facebook.feed.rows.sections.header.ThrowbackSharedStoryExplanationPartDefinition;
import com.facebook.feed.rows.sections.header.ThrowbackSharedStoryHeaderExplanationPartDefinition;
import com.facebook.feed.rows.sections.header.components.DefaultHeaderComponentPartDefinition;
import com.facebook.feed.rows.sections.header.components.ExplanationComponentPartDefinition;
import com.facebook.feed.rows.sections.header.ui.HeaderView;
import com.facebook.feed.rows.sections.header.ui.HeaderViewWithClientSideBumpLayout;
import com.facebook.feed.rows.sections.header.ui.HeaderViewWithSeeFirstLayout;
import com.facebook.feed.rows.sections.header.ui.HeaderViewWithTextLayout;
import com.facebook.feed.rows.sections.header.ui.TextWithClientRankingBumpAndMenuButtonView;
import com.facebook.feed.rows.sections.header.ui.TextWithMenuButtonView;
import com.facebook.feed.rows.sections.header.ui.TextWithSeeFirstAndMenuButtonView;
import com.facebook.feed.rows.sections.hidden.FeedHiddenUnitPartDefinition;
import com.facebook.feed.rows.sections.hidden.HiddenUnitPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.RecyclableViewTypeUtil;
import com.facebook.feed.rows.sections.hscrollrecyclerview.RowViewPagerIndicator;
import com.facebook.feed.rows.sections.inlinesurvey.InlineSurveyFeedbackPartDefinition;
import com.facebook.feed.rows.sections.inlinesurvey.InlineSurveyQuestionPartDefinition;
import com.facebook.feed.rows.sections.offline.OfflineBlingBarPartDefinition;
import com.facebook.feed.rows.sections.offline.OfflineFooterPartDefinition;
import com.facebook.feed.rows.sections.text.BaseTextPartDefinition;
import com.facebook.feed.rows.sections.text.ContentTextComponentPartDefinition;
import com.facebook.feed.rows.sections.text.ContentTextLayoutBasePartDefinition;
import com.facebook.feed.rows.sections.text.CopyTextPartDefinition;
import com.facebook.feed.rows.sections.text.ObjectionableContentMessagePartDefinition;
import com.facebook.feedback.reactions.ui.PillsBlingBarView;
import com.facebook.feedplugins.attachments.linkshare.follow.FollowShareAttachmentView;
import com.facebook.feedplugins.attachments.linkshare.offlinesave.OfflineAttachmentSaveFooterView;
import com.facebook.feedplugins.attachments.poll.PollAddOptionPartDefinition;
import com.facebook.feedplugins.attachments.poll.PollOptionItemPartDefinition;
import com.facebook.feedplugins.attachments.poll.PollSeeMorePartDefinition;
import com.facebook.feedplugins.attachments.poll.RadioButtonPartDefinition;
import com.facebook.feedplugins.base.blingbar.ui.DefaultBlingBarView;
import com.facebook.feedplugins.base.footer.EmptyFooterPartDefinition;
import com.facebook.feedplugins.base.footer.ui.DefaultFooterView;
import com.facebook.feedplugins.base.footer.ui.OneButtonFooterView;
import com.facebook.feedplugins.base.footer.ui.TwoButtonFooterView;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionView;
import com.facebook.feedplugins.feedbackreactions.ui.ReactionsFooterView;
import com.facebook.feedplugins.graphqlstory.followup.FollowUpPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.BaseVideoPlaysBlingBarPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.InstagramBlingBarPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.SeeMoreFooterPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.StoryEmptyFooterPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.ui.FeedDiscoveryDefaultBlingBarView;
import com.facebook.feedplugins.graphqlstory.footer.ui.FeedDiscoveryPillsBlingBarView;
import com.facebook.feedplugins.graphqlstory.inlinecomments.InlineCommentComposerPartDefinition;
import com.facebook.feedplugins.graphqlstory.inlinecomments.InlineCommentPartDefinition;
import com.facebook.feedplugins.graphqlstory.location.LocationPartDefinition;
import com.facebook.feedplugins.graphqlstory.location.ZeroLocationPartDefinition;
import com.facebook.feedplugins.graphqlstory.stickers.StickerRootPartDefinition;
import com.facebook.feedplugins.graphqlstory.translation.AutoTranslatePartDefinition;
import com.facebook.feedplugins.graphqlstory.translation.SeeTranslationPartDefinition;
import com.facebook.feedplugins.momentsupsell.MomentsUpsellPartDefinition;
import com.facebook.feedplugins.profile.ui.CenteredButtonView;
import com.facebook.feedplugins.prompts.SocialPromptFeedEntryPointPartDefinition;
import com.facebook.fig.attachment.FIGAttachmentView;
import com.facebook.multirow.api.ViewType;
import com.facebook.permalink.rows.LikesDescriptionPartDefinition;
import com.facebook.permalink.rows.SeenByPartDefinition;
import com.facebook.photos.warning.ObjectionableContentAttachmentView;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.facebook.ui.recyclableviewpool.RecyclableViewsDeclaration;
import com.google.common.collect.ImmutableList;
import javax.inject.Singleton;

@Singleton
/* compiled from: num_reads */
public class MultipleRowsDeclaration implements FeedRowSupportDeclaration, RecyclableViewsDeclaration {
    private static volatile MultipleRowsDeclaration f6552a;

    public static com.facebook.feed.rows.sections.MultipleRowsDeclaration m6970a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6552a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.feed.rows.sections.MultipleRowsDeclaration.class;
        monitor-enter(r1);
        r0 = f6552a;	 Catch:{ all -> 0x0039 }
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
        r0 = m6969a();	 Catch:{ all -> 0x0034 }
        f6552a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f6552a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.rows.sections.MultipleRowsDeclaration.a(com.facebook.inject.InjectorLike):com.facebook.feed.rows.sections.MultipleRowsDeclaration");
    }

    private static MultipleRowsDeclaration m6969a() {
        return new MultipleRowsDeclaration();
    }

    public final void m6971a(ListItemRowController listItemRowController) {
        ImmutableList of = ImmutableList.of(OfflineBlingBarPartDefinition.a, OfflineFooterPartDefinition.a, OfflineAttachmentSaveFooterView.a, TrendingPartDefinition.a, ExplanationPartDefinition.a, ThrowbackSharedStoryExplanationPartDefinition.a, ThrowbackSharedStoryHeaderExplanationPartDefinition.a, HeaderView.h, HeaderViewWithTextLayout.k, HeaderViewWithSeeFirstLayout.j, HeaderViewWithClientSideBumpLayout.j, TextWithMenuButtonView.b, new ViewType[]{TextWithSeeFirstAndMenuButtonView.a, TextWithClientRankingBumpAndMenuButtonView.a, LikableHeaderPartDefinition.a, FollowableHeaderPartDefinition.a, DefaultFriendableHeaderPartDefinition.a, BaseTextPartDefinition.a, ContentTextLayoutBasePartDefinition.a, LocationPartDefinition.f7136a, DefaultBlingBarView.a, InstagramBlingBarPartDefinition.a, BaseVideoPlaysBlingBarPartDefinition.a, StoryEmptyFooterPartDefinition.a, OneButtonFooterView.a, EmptyFooterPartDefinition.b, DefaultFooterView.a, ReactionsFooterView.h, HoldoutUnitPartDefinition.a, ScissorPartDefinition.a, LivePhotoAttachmentPartDefinition.a, PhotoAttachmentPartDefinition.a, SphericalPhotoAttachmentPartDefinition.a, ObjectionableContentPhotoAttachmentPartDefinition.a, ObjectionableContentMessagePartDefinition.a, ObjectionableContentAttachmentView.a, AngoraAttachmentView.f11887a, AngoraAttachmentView.f11888b, AngoraInstantArticlesAttachmentView.c, AngoraVideoAttachmentView.a, EventAttachmentView.f5979a, EventTicketAttachmentView.a, LargeSquarePhotoShareAttachmentView.f6999h, LargeSquarePhotoInstantArticleAttachmentView.h, PortraitPhotoShareAttachmentView.h, LikesDescriptionPartDefinition.a, SeenByPartDefinition.a, FollowUpPartDefinition.a, HiddenUnitPartDefinition.a, FeedHiddenUnitPartDefinition.a, PagerRowType.f6291a, RowViewPagerIndicator.a, HScrollRecyclerViewRowType.f11901a, HScrollRecyclerViewRowType.f11902b, HScrollRecyclerViewRowType.f11903c, LifeEventAttachmentHeaderTextPartDefinition.a, LifeEventAttachmentDescriptionPartDefinition.a, LifeEventAttachmentHeaderIconPartDefinition.a, ZeroLocationPartDefinition.f7112a, StoryPromotionPartDefinition.a, InlineCommentComposerPartDefinition.a, InlineCommentPartDefinition.a, FeedDiscoveryDefaultBlingBarView.b, FeedDiscoveryPillsBlingBarView.b, ImageShareAttachmentPartDefinition.a, TranscodedAnimatedImageShareAttachmentPartDefinition.a, GifShareAttachmentPartDefinition.a, CallToActionAttachmentView.a, AutoTranslatePartDefinition.a, SeeTranslationPartDefinition.a, VideoViewCountPartDefinition.a, TwoButtonFooterView.a, PageLikeAttachmentPartDefinition.a, SeeMoreFooterPartDefinition.a, ActionLinkFooterPartDefinition.a, UnavailableAttachmentView.a, EndOfFeedPartDefinition.a, LoadingMorePartDefinition.a, RatingBarShareAttachmentView.a, PermalinkProfilePhotoPromptPartDefinition.a, PillsBlingBarView.a, UnknownFeedUnitPartDefinition.a, EmptyPartDefinition.a, PhotosFeedAttachmentImagePartDefinition.a, PhotosFeedAttachmentVideoPartDefinition.a, PhotosFeedAttachmentStaticVideoPartDefinition.a, PhotosFeedObjectionableAttachmentImagePartDefinition.a, PhotosFeedObjectionableAttachmentMessagePartDefinition.a, LinkShareActionPartDefinition.a, ComponentPartDefinition.a, DefaultHeaderComponentPartDefinition.c, ExplanationComponentPartDefinition.f7164c, FeedTextHeaderComponentPartDefinition.c, ContentTextComponentPartDefinition.c, StickerRootPartDefinition.a, SportsMatchPhotoPartDefinition.a, SportsMatchScorePartDefinition.a, SportsMatchFooterTextPartDefinition.a, AttachmentLinkCoverPartDefinition.b, ReadingAttachmentPartDefinition.a, ActionLinkCallToActionView.h, FollowShareAttachmentView.b, CopyTextPartDefinition.a, MomentsUpsellPartDefinition.a, PollOptionItemPartDefinition.a, RadioButtonPartDefinition.a, PollSeeMorePartDefinition.a, PollAddOptionPartDefinition.a, AttributionPartDefinition.a, QuoteShareWithVerticalBarPartDefinition.a, QuoteShareWithQuoteMarkPartDefinition.a, AngoraAttachmentWithSubcontextView.c, LeadGenCallToActionAttachmentView.a, ShareCountPartDefinition.a, CenteredTextPartDefinition.a, ShareAttachmentComponentPartDefinition.c, SocialPromptFeedEntryPointPartDefinition.a, StoryAYMTHotPostFooterPartDefinition.a, CenteredButtonView.a, AngoraInstantPreviewAttachmentView.c, MinutiaeAttachmentIconPartDefinition.a, MinutiaeAttachmentTextPartDefinition.a, FIGAttachmentView.f4166h, PageOutcomeButtonHeaderPartDefinition.a, InlineSurveyFeedbackPartDefinition.a, InlineSurveyQuestionPartDefinition.a});
        int size = of.size();
        for (int i = 0; i < size; i++) {
            listItemRowController.a((ViewType) of.get(i));
        }
    }

    public final void m6972a(RecyclableViewPoolManager recyclableViewPoolManager) {
        RecyclableViewTypeUtil.m6979a(recyclableViewPoolManager, SubStoriesPagePartDefinition.f6553a);
        RecyclableViewTypeUtil.m6979a(recyclableViewPoolManager, AlbumAttachmentPagePartDefinition.f6565a);
    }
}
