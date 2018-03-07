package com.facebook.feed.rows.sections;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.MinutiaeAttachmentGroupPartDefinition;
import com.facebook.feed.rows.sections.header.ExplanationSelectorPartDefinition;
import com.facebook.feed.rows.sections.header.HeaderSelectorPartDefinition;
import com.facebook.feed.rows.sections.inlinesurvey.InlineSurveyGroupPartDefinition;
import com.facebook.feedplugins.attachments.AttachmentsPartDefinition;
import com.facebook.feedplugins.graphqlstory.followup.FollowUpGroupPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.BlingBarSelectorPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.TopLevelFooterPartSelector;
import com.facebook.feedplugins.graphqlstory.inlinecomments.FeedCommentsPartDefinition;
import com.facebook.feedplugins.graphqlstory.inlinecomments.InlineCommentComposerPartDefinition;
import com.facebook.feedplugins.graphqlstory.seefirsttombstone.SeeFirstTombstonePartDefinition;
import com.facebook.feedplugins.graphqlstory.seefirsttombstone.SeeFirstTombstonePartDefinition.Props;
import com.facebook.feedplugins.graphqlstory.stickers.StickerRootPartDefinition;
import com.facebook.feedplugins.graphqlstory.translation.SeeTranslationSelectorPartDefinition;
import com.facebook.feedplugins.momentsupsell.MomentsUpsellPartDefinition;
import com.facebook.feedplugins.profile.introcard.favphotos.ViewAllFavPhotosPartDefinition;
import com.facebook.feedplugins.prompts.SocialPromptFeedEntryPointPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: initial_reaction */
public class BasicGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static BasicGroupPartDefinition f20008v;
    private static final Object f20009w = new Object();
    private final SeeFirstTombstonePartDefinition<FeedEnvironment> f20010a;
    private final TrendingPartDefinition f20011b;
    private final ExplanationSelectorPartDefinition f20012c;
    private final HeaderSelectorPartDefinition f20013d;
    private final StickerRootPartDefinition<FeedEnvironment> f20014e;
    private final TextOrTranslationSelectorPartDefinition f20015f;
    private final Lazy<SeeTranslationSelectorPartDefinition<FeedEnvironment>> f20016g;
    private final AttachmentsPartDefinition f20017h;
    private final AttachmentCallToActionPartDefinition f20018i;
    private final MinutiaeAttachmentGroupPartDefinition f20019j;
    private final StoryPostFooterSelectorPartDefinition f20020k;
    private final Lazy<SubStoriesHScrollPartDefinition<FeedEnvironment>> f20021l;
    private final BlingBarSelectorPartDefinition f20022m;
    private final Lazy<TopLevelFooterPartSelector> f20023n;
    private final FeedCommentsPartDefinition<FeedEnvironment> f20024o;
    private final InlineCommentComposerPartDefinition<FeedEnvironment> f20025p;
    private final InlineSurveyGroupPartDefinition f20026q;
    private final FollowUpGroupPartDefinition<FeedEnvironment> f20027r;
    private final MomentsUpsellPartDefinition f20028s;
    private final ViewAllFavPhotosPartDefinition f20029t;
    private final SocialPromptFeedEntryPointPartDefinition f20030u;

    private static BasicGroupPartDefinition m27749b(InjectorLike injectorLike) {
        return new BasicGroupPartDefinition(SeeFirstTombstonePartDefinition.m27752a(injectorLike), TrendingPartDefinition.m27759a(injectorLike), ExplanationSelectorPartDefinition.m27773a(injectorLike), HeaderSelectorPartDefinition.m27777a(injectorLike), StickerRootPartDefinition.m27781a(injectorLike), TextOrTranslationSelectorPartDefinition.m27792a(injectorLike), IdBasedLazy.m1808a(injectorLike, 1901), AttachmentsPartDefinition.m27796a(injectorLike), MinutiaeAttachmentGroupPartDefinition.m27828a(injectorLike), StoryPostFooterSelectorPartDefinition.m27844a(injectorLike), IdBasedLazy.m1808a(injectorLike, 1513), AttachmentCallToActionPartDefinition.m27848a(injectorLike), BlingBarSelectorPartDefinition.m27852a(injectorLike), IdBasedLazy.m1808a(injectorLike, 1873), FeedCommentsPartDefinition.m27856a(injectorLike), InlineCommentComposerPartDefinition.m27906a(injectorLike), InlineSurveyGroupPartDefinition.m27923a(injectorLike), FollowUpGroupPartDefinition.m27958a(injectorLike), MomentsUpsellPartDefinition.m27998a(injectorLike), ViewAllFavPhotosPartDefinition.m28004a(injectorLike), SocialPromptFeedEntryPointPartDefinition.m28011a(injectorLike));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (FeedProps) obj;
        Object obj2 = (GraphQLStory) obj.f13444a;
        baseMultiRowSubParts.m19112a(this.f20010a, new Props(obj2, (FeedEnvironment) anyEnvironment));
        baseMultiRowSubParts.m19112a(this.f20011b, obj);
        baseMultiRowSubParts.m19112a(this.f20012c, obj);
        baseMultiRowSubParts.m19112a(this.f20013d, obj);
        baseMultiRowSubParts.m19112a(this.f20014e, obj);
        baseMultiRowSubParts.m19112a(this.f20019j, obj);
        baseMultiRowSubParts.m19112a(this.f20015f, obj);
        baseMultiRowSubParts.m19113a(SeeTranslationSelectorPartDefinition.m28707a((FeedProps) obj), this.f20016g, obj);
        baseMultiRowSubParts.m19112a(this.f20017h, obj);
        baseMultiRowSubParts.m19112a(this.f20018i, obj);
        baseMultiRowSubParts.m19113a(SubStoriesHScrollPartDefinition.m28868a((FeedProps) obj), this.f20021l, obj);
        baseMultiRowSubParts.m19112a(this.f20022m, obj);
        baseMultiRowSubParts.m19113a(TopLevelFooterPartSelector.m28948a((FeedProps) obj), this.f20023n, obj);
        baseMultiRowSubParts.m19112a(this.f20020k, obj);
        baseMultiRowSubParts.m19112a(this.f20024o, obj);
        baseMultiRowSubParts.m19112a(this.f20025p, obj);
        baseMultiRowSubParts.m19112a(this.f20026q, obj);
        baseMultiRowSubParts.m19112a(this.f20027r, obj2);
        baseMultiRowSubParts.m19112a(this.f20028s, obj2);
        baseMultiRowSubParts.m19112a(this.f20030u, obj);
        baseMultiRowSubParts.m19112a(this.f20029t, obj);
        return null;
    }

    public static BasicGroupPartDefinition m27748a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BasicGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20009w) {
                BasicGroupPartDefinition basicGroupPartDefinition;
                if (a2 != null) {
                    basicGroupPartDefinition = (BasicGroupPartDefinition) a2.mo818a(f20009w);
                } else {
                    basicGroupPartDefinition = f20008v;
                }
                if (basicGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27749b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20009w, b3);
                        } else {
                            f20008v = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = basicGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public BasicGroupPartDefinition(SeeFirstTombstonePartDefinition seeFirstTombstonePartDefinition, TrendingPartDefinition trendingPartDefinition, ExplanationSelectorPartDefinition explanationSelectorPartDefinition, HeaderSelectorPartDefinition headerSelectorPartDefinition, StickerRootPartDefinition stickerRootPartDefinition, TextOrTranslationSelectorPartDefinition textOrTranslationSelectorPartDefinition, Lazy<SeeTranslationSelectorPartDefinition> lazy, AttachmentsPartDefinition attachmentsPartDefinition, MinutiaeAttachmentGroupPartDefinition minutiaeAttachmentGroupPartDefinition, StoryPostFooterSelectorPartDefinition storyPostFooterSelectorPartDefinition, Lazy<SubStoriesHScrollPartDefinition> lazy2, AttachmentCallToActionPartDefinition attachmentCallToActionPartDefinition, BlingBarSelectorPartDefinition blingBarSelectorPartDefinition, Lazy<TopLevelFooterPartSelector> lazy3, FeedCommentsPartDefinition feedCommentsPartDefinition, InlineCommentComposerPartDefinition inlineCommentComposerPartDefinition, InlineSurveyGroupPartDefinition inlineSurveyGroupPartDefinition, FollowUpGroupPartDefinition followUpGroupPartDefinition, MomentsUpsellPartDefinition momentsUpsellPartDefinition, ViewAllFavPhotosPartDefinition viewAllFavPhotosPartDefinition, SocialPromptFeedEntryPointPartDefinition socialPromptFeedEntryPointPartDefinition) {
        this.f20010a = seeFirstTombstonePartDefinition;
        this.f20011b = trendingPartDefinition;
        this.f20012c = explanationSelectorPartDefinition;
        this.f20013d = headerSelectorPartDefinition;
        this.f20014e = stickerRootPartDefinition;
        this.f20015f = textOrTranslationSelectorPartDefinition;
        this.f20016g = lazy;
        this.f20017h = attachmentsPartDefinition;
        this.f20019j = minutiaeAttachmentGroupPartDefinition;
        this.f20020k = storyPostFooterSelectorPartDefinition;
        this.f20021l = lazy2;
        this.f20018i = attachmentCallToActionPartDefinition;
        this.f20022m = blingBarSelectorPartDefinition;
        this.f20023n = lazy3;
        this.f20024o = feedCommentsPartDefinition;
        this.f20025p = inlineCommentComposerPartDefinition;
        this.f20026q = inlineSurveyGroupPartDefinition;
        this.f20027r = followUpGroupPartDefinition;
        this.f20028s = momentsUpsellPartDefinition;
        this.f20029t = viewAllFavPhotosPartDefinition;
        this.f20030u = socialPromptFeedEntryPointPartDefinition;
    }

    public final boolean mo2536a(Object obj) {
        return true;
    }
}
