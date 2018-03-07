package com.facebook.feed.rows.permalink;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.FeedAttachedStoryPartDefinition;
import com.facebook.feedplugins.attachments.AttachmentsPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.StoryEmptyFooterPartDefinition;
import com.facebook.feedplugins.graphqlstory.stickers.StickerRootPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.graphql.story.util.StoryUtilModelConverter;
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
/* compiled from: add_to_groups */
public class PermalinkAggregatedStoryGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static PermalinkAggregatedStoryGroupPartDefinition f19848k;
    private static final Object f19849l = new Object();
    private final StoryEmptyFooterPartDefinition f19850a;
    private final SeenByPartDefinition f19851b;
    private final LikesDescriptionPartDefinition f19852c;
    private final PermalinkTopLevelFooterPartSelector f19853d;
    private final PermalinkSubStoriesPartDefinition f19854e;
    private final FeedAttachedStoryPartDefinition f19855f;
    private final AttachmentsPartDefinition f19856g;
    private final PermalinkTextPartDefinition f19857h;
    private final StickerRootPartDefinition<FeedEnvironment> f19858i;
    private final PermalinkTextHeaderSelectorPartDefinition f19859j;

    private static PermalinkAggregatedStoryGroupPartDefinition m23103b(InjectorLike injectorLike) {
        return new PermalinkAggregatedStoryGroupPartDefinition(PermalinkTextHeaderSelectorPartDefinition.m23174a(injectorLike), StickerRootPartDefinition.a(injectorLike), PermalinkTextPartDefinition.m23178a(injectorLike), AttachmentsPartDefinition.a(injectorLike), FeedAttachedStoryPartDefinition.a(injectorLike), PermalinkSubStoriesPartDefinition.m23156a(injectorLike), PermalinkTopLevelFooterPartSelector.a(injectorLike), LikesDescriptionPartDefinition.a(injectorLike), SeenByPartDefinition.a(injectorLike), StoryEmptyFooterPartDefinition.m25638a(injectorLike));
    }

    public final Object m23104a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f19859j, feedProps);
        baseMultiRowSubParts.a(this.f19858i, feedProps);
        baseMultiRowSubParts.a(this.f19857h, feedProps);
        baseMultiRowSubParts.a(this.f19856g, feedProps);
        baseMultiRowSubParts.a(this.f19855f, feedProps);
        baseMultiRowSubParts.a(this.f19854e, feedProps);
        baseMultiRowSubParts.a(this.f19853d, feedProps);
        baseMultiRowSubParts.a(this.f19852c, feedProps);
        baseMultiRowSubParts.a(this.f19851b, feedProps);
        baseMultiRowSubParts.a(this.f19850a, feedProps);
        return null;
    }

    public final boolean m23105a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).a;
        if (graphQLStory.aD() == 0) {
            return false;
        }
        return !GraphQLStoryUtil.a(StoryUtilModelConverter.a(graphQLStory));
    }

    @Inject
    public PermalinkAggregatedStoryGroupPartDefinition(PermalinkTextHeaderSelectorPartDefinition permalinkTextHeaderSelectorPartDefinition, StickerRootPartDefinition stickerRootPartDefinition, PermalinkTextPartDefinition permalinkTextPartDefinition, AttachmentsPartDefinition attachmentsPartDefinition, FeedAttachedStoryPartDefinition feedAttachedStoryPartDefinition, PermalinkSubStoriesPartDefinition permalinkSubStoriesPartDefinition, PermalinkTopLevelFooterPartSelector permalinkTopLevelFooterPartSelector, LikesDescriptionPartDefinition likesDescriptionPartDefinition, SeenByPartDefinition seenByPartDefinition, StoryEmptyFooterPartDefinition storyEmptyFooterPartDefinition) {
        this.f19850a = storyEmptyFooterPartDefinition;
        this.f19851b = seenByPartDefinition;
        this.f19852c = likesDescriptionPartDefinition;
        this.f19853d = permalinkTopLevelFooterPartSelector;
        this.f19854e = permalinkSubStoriesPartDefinition;
        this.f19855f = feedAttachedStoryPartDefinition;
        this.f19856g = attachmentsPartDefinition;
        this.f19857h = permalinkTextPartDefinition;
        this.f19858i = stickerRootPartDefinition;
        this.f19859j = permalinkTextHeaderSelectorPartDefinition;
    }

    public static PermalinkAggregatedStoryGroupPartDefinition m23102a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PermalinkAggregatedStoryGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19849l) {
                PermalinkAggregatedStoryGroupPartDefinition permalinkAggregatedStoryGroupPartDefinition;
                if (a2 != null) {
                    permalinkAggregatedStoryGroupPartDefinition = (PermalinkAggregatedStoryGroupPartDefinition) a2.a(f19849l);
                } else {
                    permalinkAggregatedStoryGroupPartDefinition = f19848k;
                }
                if (permalinkAggregatedStoryGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23103b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19849l, b3);
                        } else {
                            f19848k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = permalinkAggregatedStoryGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
