package com.facebook.feed.rows.sections;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.links.ActionLinkFooterPartDefinition;
import com.facebook.feed.rows.sections.attachments.MinutiaeAttachmentGroupPartDefinition;
import com.facebook.feed.rows.sections.header.ExplanationSelectorPartDefinition;
import com.facebook.feed.rows.sections.header.HeaderSelectorPartDefinition;
import com.facebook.feedplugins.attachments.AttachmentsPartDefinition;
import com.facebook.feedplugins.creativeediting.FrameCallToActionPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.BlingBarSelectorPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.TopLevelFooterPartSelector;
import com.facebook.feedplugins.graphqlstory.inlinecomments.FeedCommentsPartDefinition;
import com.facebook.feedplugins.graphqlstory.inlinecomments.InlineCommentComposerPartDefinition;
import com.facebook.feedplugins.graphqlstory.stickers.StickerRootPartDefinition;
import com.facebook.feedplugins.graphqlstory.translation.SeeTranslationPartDefinition;
import com.facebook.feedplugins.graphqlstory.translation.TranslationOrContentSelectorPartDefinition;
import com.facebook.feedplugins.momentsupsell.MomentsUpsellPartDefinition;
import com.facebook.feedplugins.profile.calltoaction.CreateProfilePictureCallToActionPartDefinition;
import com.facebook.feedplugins.profile.calltoaction.CreateProfileVideoCallToActionPartDefinition;
import com.facebook.feedplugins.profile.calltoaction.ProfileGenericCallToActionPartDefinition;
import com.facebook.feedplugins.profile.calltoaction.ProfilePictureOverlayCallToActionPartDefinition;
import com.facebook.feedplugins.prompts.SocialPromptFeedEntryPointPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetchGKInfo */
public class FeedAttachedStoryPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static FeedAttachedStoryPartDefinition f24314v;
    private static final Object f24315w = new Object();
    private final AttachedStorySectionHelper f24316a;
    private final LimitedAttachedStoryPartDefinition f24317b;
    private final HeaderSelectorPartDefinition f24318c;
    private final ExplanationSelectorPartDefinition f24319d;
    private final StickerRootPartDefinition<FeedEnvironment> f24320e;
    private final TranslationOrContentSelectorPartDefinition f24321f;
    private final SeeTranslationPartDefinition f24322g;
    private final AttachmentsPartDefinition f24323h;
    private final MinutiaeAttachmentGroupPartDefinition f24324i;
    private final ProfilePictureOverlayCallToActionPartDefinition<FeedEnvironment> f24325j;
    private final CreateProfilePictureCallToActionPartDefinition<FeedEnvironment> f24326k;
    private final CreateProfileVideoCallToActionPartDefinition<FeedEnvironment> f24327l;
    private final ProfileGenericCallToActionPartDefinition f24328m;
    private final ActionLinkFooterPartDefinition f24329n;
    private final BlingBarSelectorPartDefinition f24330o;
    private final TopLevelFooterPartSelector f24331p;
    private final FeedCommentsPartDefinition<FeedEnvironment> f24332q;
    private final InlineCommentComposerPartDefinition<FeedEnvironment> f24333r;
    private final MomentsUpsellPartDefinition f24334s;
    private final FrameCallToActionPartDefinition<FeedEnvironment> f24335t;
    private final SocialPromptFeedEntryPointPartDefinition f24336u;

    private static FeedAttachedStoryPartDefinition m32656b(InjectorLike injectorLike) {
        return new FeedAttachedStoryPartDefinition(GraphQLStoryUtil.m9565a(injectorLike), LimitedAttachedStoryPartDefinition.m32659a(injectorLike), HeaderSelectorPartDefinition.m27777a(injectorLike), ExplanationSelectorPartDefinition.m27773a(injectorLike), StickerRootPartDefinition.m27781a(injectorLike), TranslationOrContentSelectorPartDefinition.m32663a(injectorLike), SeeTranslationPartDefinition.m32668a(injectorLike), AttachmentsPartDefinition.m27796a(injectorLike), MinutiaeAttachmentGroupPartDefinition.m27828a(injectorLike), ProfilePictureOverlayCallToActionPartDefinition.m32688a(injectorLike), CreateProfilePictureCallToActionPartDefinition.m32701a(injectorLike), CreateProfileVideoCallToActionPartDefinition.m32706a(injectorLike), ProfileGenericCallToActionPartDefinition.m32711a(injectorLike), ActionLinkFooterPartDefinition.m32693a(injectorLike), BlingBarSelectorPartDefinition.m27852a(injectorLike), TopLevelFooterPartSelector.m28947a(injectorLike), FeedCommentsPartDefinition.m27856a(injectorLike), InlineCommentComposerPartDefinition.m27906a(injectorLike), MomentsUpsellPartDefinition.m27998a(injectorLike), FrameCallToActionPartDefinition.m32717a(injectorLike), SocialPromptFeedEntryPointPartDefinition.m28011a(injectorLike));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        Object L = ((GraphQLStory) feedProps.f13444a).m22326L();
        Object a = feedProps.m19803a(L);
        baseMultiRowSubParts.m19112a(this.f24319d, a);
        baseMultiRowSubParts.m19112a(this.f24318c, a);
        baseMultiRowSubParts.m19112a(this.f24320e, a);
        baseMultiRowSubParts.m19112a(this.f24324i, a);
        baseMultiRowSubParts.m19112a(this.f24321f, a);
        baseMultiRowSubParts.m19112a(this.f24323h, a);
        baseMultiRowSubParts.m19112a(this.f24322g, a);
        baseMultiRowSubParts.m19112a(this.f24325j, a);
        baseMultiRowSubParts.m19112a(this.f24326k, a);
        baseMultiRowSubParts.m19112a(this.f24327l, a);
        baseMultiRowSubParts.m19112a(this.f24328m, a);
        baseMultiRowSubParts.m19112a(this.f24335t, a);
        baseMultiRowSubParts.m19112a(this.f24317b, a);
        baseMultiRowSubParts.m19112a(this.f24329n, a);
        baseMultiRowSubParts.m19112a(this.f24330o, a);
        baseMultiRowSubParts.m19112a(this.f24331p, a);
        baseMultiRowSubParts.m19112a(this.f24332q, a);
        baseMultiRowSubParts.m19112a(this.f24333r, a);
        baseMultiRowSubParts.m19112a(this.f24334s, L);
        baseMultiRowSubParts.m19112a(this.f24336u, a);
        return null;
    }

    public final boolean mo2536a(Object obj) {
        return this.f24316a.m32700a((FeedProps) obj);
    }

    public static FeedAttachedStoryPartDefinition m32655a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedAttachedStoryPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24315w) {
                FeedAttachedStoryPartDefinition feedAttachedStoryPartDefinition;
                if (a2 != null) {
                    feedAttachedStoryPartDefinition = (FeedAttachedStoryPartDefinition) a2.mo818a(f24315w);
                } else {
                    feedAttachedStoryPartDefinition = f24314v;
                }
                if (feedAttachedStoryPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32656b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24315w, b3);
                        } else {
                            f24314v = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = feedAttachedStoryPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public FeedAttachedStoryPartDefinition(GraphQLStoryUtil graphQLStoryUtil, LimitedAttachedStoryPartDefinition limitedAttachedStoryPartDefinition, HeaderSelectorPartDefinition headerSelectorPartDefinition, ExplanationSelectorPartDefinition explanationSelectorPartDefinition, StickerRootPartDefinition stickerRootPartDefinition, TranslationOrContentSelectorPartDefinition translationOrContentSelectorPartDefinition, SeeTranslationPartDefinition seeTranslationPartDefinition, AttachmentsPartDefinition attachmentsPartDefinition, MinutiaeAttachmentGroupPartDefinition minutiaeAttachmentGroupPartDefinition, ProfilePictureOverlayCallToActionPartDefinition profilePictureOverlayCallToActionPartDefinition, CreateProfilePictureCallToActionPartDefinition createProfilePictureCallToActionPartDefinition, CreateProfileVideoCallToActionPartDefinition createProfileVideoCallToActionPartDefinition, ProfileGenericCallToActionPartDefinition profileGenericCallToActionPartDefinition, ActionLinkFooterPartDefinition actionLinkFooterPartDefinition, BlingBarSelectorPartDefinition blingBarSelectorPartDefinition, TopLevelFooterPartSelector topLevelFooterPartSelector, FeedCommentsPartDefinition feedCommentsPartDefinition, InlineCommentComposerPartDefinition inlineCommentComposerPartDefinition, MomentsUpsellPartDefinition momentsUpsellPartDefinition, FrameCallToActionPartDefinition frameCallToActionPartDefinition, SocialPromptFeedEntryPointPartDefinition socialPromptFeedEntryPointPartDefinition) {
        this.f24316a = new AttachedStorySectionHelper(graphQLStoryUtil);
        this.f24317b = limitedAttachedStoryPartDefinition;
        this.f24318c = headerSelectorPartDefinition;
        this.f24319d = explanationSelectorPartDefinition;
        this.f24320e = stickerRootPartDefinition;
        this.f24321f = translationOrContentSelectorPartDefinition;
        this.f24322g = seeTranslationPartDefinition;
        this.f24323h = attachmentsPartDefinition;
        this.f24324i = minutiaeAttachmentGroupPartDefinition;
        this.f24325j = profilePictureOverlayCallToActionPartDefinition;
        this.f24326k = createProfilePictureCallToActionPartDefinition;
        this.f24327l = createProfileVideoCallToActionPartDefinition;
        this.f24328m = profileGenericCallToActionPartDefinition;
        this.f24329n = actionLinkFooterPartDefinition;
        this.f24330o = blingBarSelectorPartDefinition;
        this.f24331p = topLevelFooterPartSelector;
        this.f24332q = feedCommentsPartDefinition;
        this.f24333r = inlineCommentComposerPartDefinition;
        this.f24334s = momentsUpsellPartDefinition;
        this.f24335t = frameCallToActionPartDefinition;
        this.f24336u = socialPromptFeedEntryPointPartDefinition;
    }
}
