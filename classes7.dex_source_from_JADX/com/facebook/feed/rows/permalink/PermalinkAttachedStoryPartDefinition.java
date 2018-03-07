package com.facebook.feed.rows.permalink;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.links.ActionLinkFooterPartDefinition;
import com.facebook.feed.rows.sections.AttachedStorySectionHelper;
import com.facebook.feed.rows.sections.attachments.videos.VideoViewCountPartDefinition;
import com.facebook.feed.rows.sections.header.ExplanationSelectorPartDefinition;
import com.facebook.feed.rows.sections.header.HeaderSelectorPartDefinition;
import com.facebook.feedplugins.attachments.AttachmentsPartDefinition;
import com.facebook.feedplugins.graphqlstory.stickers.StickerRootPartDefinition;
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
import com.facebook.permalink.rows.LikesDescriptionPartDefinition;
import com.facebook.permalink.rows.PermalinkTopLevelFooterPartSelector;
import com.facebook.permalink.rows.SeenByPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: add_text */
public class PermalinkAttachedStoryPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static PermalinkAttachedStoryPartDefinition f19860l;
    private static final Object f19861m = new Object();
    private final HeaderSelectorPartDefinition f19862a;
    private final StickerRootPartDefinition<FeedEnvironment> f19863b;
    private final ExplanationSelectorPartDefinition f19864c;
    private final PermalinkTextPartDefinition f19865d;
    private final AttachmentsPartDefinition f19866e;
    private final VideoViewCountPartDefinition f19867f;
    private final ActionLinkFooterPartDefinition f19868g;
    private final PermalinkTopLevelFooterPartSelector f19869h;
    private final LikesDescriptionPartDefinition f19870i;
    private final SeenByPartDefinition f19871j;
    private final AttachedStorySectionHelper f19872k;

    private static PermalinkAttachedStoryPartDefinition m23107b(InjectorLike injectorLike) {
        return new PermalinkAttachedStoryPartDefinition(HeaderSelectorPartDefinition.a(injectorLike), StickerRootPartDefinition.a(injectorLike), ExplanationSelectorPartDefinition.a(injectorLike), PermalinkTextPartDefinition.m23178a(injectorLike), AttachmentsPartDefinition.a(injectorLike), VideoViewCountPartDefinition.m23983a(injectorLike), ActionLinkFooterPartDefinition.a(injectorLike), PermalinkTopLevelFooterPartSelector.a(injectorLike), LikesDescriptionPartDefinition.a(injectorLike), GraphQLStoryUtil.a(injectorLike), SeenByPartDefinition.a(injectorLike));
    }

    public final Object m23108a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        FeedProps a = feedProps.a(((GraphQLStory) feedProps.a).L());
        baseMultiRowSubParts.a(this.f19864c, a);
        baseMultiRowSubParts.a(this.f19862a, a);
        baseMultiRowSubParts.a(this.f19863b, a);
        baseMultiRowSubParts.a(this.f19865d, a);
        baseMultiRowSubParts.a(this.f19866e, a);
        baseMultiRowSubParts.a(this.f19867f, a);
        baseMultiRowSubParts.a(this.f19868g, a);
        baseMultiRowSubParts.a(this.f19869h, a);
        baseMultiRowSubParts.a(this.f19870i, a);
        baseMultiRowSubParts.a(this.f19871j, a);
        return null;
    }

    @Inject
    public PermalinkAttachedStoryPartDefinition(HeaderSelectorPartDefinition headerSelectorPartDefinition, StickerRootPartDefinition stickerRootPartDefinition, ExplanationSelectorPartDefinition explanationSelectorPartDefinition, PermalinkTextPartDefinition permalinkTextPartDefinition, AttachmentsPartDefinition attachmentsPartDefinition, VideoViewCountPartDefinition videoViewCountPartDefinition, ActionLinkFooterPartDefinition actionLinkFooterPartDefinition, PermalinkTopLevelFooterPartSelector permalinkTopLevelFooterPartSelector, LikesDescriptionPartDefinition likesDescriptionPartDefinition, GraphQLStoryUtil graphQLStoryUtil, SeenByPartDefinition seenByPartDefinition) {
        this.f19862a = headerSelectorPartDefinition;
        this.f19863b = stickerRootPartDefinition;
        this.f19864c = explanationSelectorPartDefinition;
        this.f19865d = permalinkTextPartDefinition;
        this.f19866e = attachmentsPartDefinition;
        this.f19867f = videoViewCountPartDefinition;
        this.f19868g = actionLinkFooterPartDefinition;
        this.f19869h = permalinkTopLevelFooterPartSelector;
        this.f19870i = likesDescriptionPartDefinition;
        this.f19871j = seenByPartDefinition;
        this.f19872k = new AttachedStorySectionHelper(graphQLStoryUtil);
    }

    public static PermalinkAttachedStoryPartDefinition m23106a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PermalinkAttachedStoryPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19861m) {
                PermalinkAttachedStoryPartDefinition permalinkAttachedStoryPartDefinition;
                if (a2 != null) {
                    permalinkAttachedStoryPartDefinition = (PermalinkAttachedStoryPartDefinition) a2.a(f19861m);
                } else {
                    permalinkAttachedStoryPartDefinition = f19860l;
                }
                if (permalinkAttachedStoryPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23107b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19861m, b3);
                        } else {
                            f19860l = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = permalinkAttachedStoryPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m23109a(FeedProps<GraphQLStory> feedProps) {
        return this.f19872k.a(feedProps);
    }
}
