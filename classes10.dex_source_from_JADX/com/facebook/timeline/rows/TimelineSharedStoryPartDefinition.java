package com.facebook.timeline.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.AttributionPartDefinition;
import com.facebook.feed.rows.sections.FeedAttachedStoryPartDefinition;
import com.facebook.feed.rows.sections.StoryPromotionPartDefinition;
import com.facebook.feed.rows.sections.TimelineStoryTextSelectorPartDefinition;
import com.facebook.feedplugins.attachments.AttachmentsPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.BlingBarSelectorPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.TopLevelFooterPartSelector;
import com.facebook.feedplugins.graphqlstory.translation.SeeTranslationPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
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
/* compiled from: extra_source_activity */
public class TimelineSharedStoryPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static TimelineSharedStoryPartDefinition f12620j;
    private static final Object f12621k = new Object();
    private final StoryPromotionPartDefinition<FeedEnvironment> f12622a;
    private final TopLevelFooterPartSelector f12623b;
    private final BlingBarSelectorPartDefinition f12624c;
    private final FeedAttachedStoryPartDefinition f12625d;
    private final AttachmentsPartDefinition f12626e;
    private final SeeTranslationPartDefinition<FeedEnvironment> f12627f;
    private final TimelineStoryTextSelectorPartDefinition f12628g;
    private final TimelineHeaderSelectorPartDefinition f12629h;
    private final AttributionPartDefinition f12630i;

    private static TimelineSharedStoryPartDefinition m12584b(InjectorLike injectorLike) {
        return new TimelineSharedStoryPartDefinition(TimelineHeaderSelectorPartDefinition.m12573a(injectorLike), TimelineStoryTextSelectorPartDefinition.a(injectorLike), SeeTranslationPartDefinition.a(injectorLike), AttachmentsPartDefinition.a(injectorLike), FeedAttachedStoryPartDefinition.a(injectorLike), BlingBarSelectorPartDefinition.a(injectorLike), TopLevelFooterPartSelector.a(injectorLike), AttributionPartDefinition.a(injectorLike), StoryPromotionPartDefinition.a(injectorLike));
    }

    public final Object m12585a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f12630i, feedProps);
        baseMultiRowSubParts.a(this.f12629h, feedProps);
        baseMultiRowSubParts.a(this.f12628g, feedProps);
        baseMultiRowSubParts.a(this.f12627f, feedProps);
        baseMultiRowSubParts.a(this.f12626e, feedProps);
        baseMultiRowSubParts.a(this.f12625d, feedProps);
        baseMultiRowSubParts.a(this.f12624c, feedProps);
        baseMultiRowSubParts.a(this.f12623b, feedProps);
        baseMultiRowSubParts.a(this.f12622a, feedProps);
        return null;
    }

    public final boolean m12586a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).a;
        return graphQLStory.L() != null && graphQLStory.aD() == 0;
    }

    @Inject
    public TimelineSharedStoryPartDefinition(TimelineHeaderSelectorPartDefinition timelineHeaderSelectorPartDefinition, TimelineStoryTextSelectorPartDefinition timelineStoryTextSelectorPartDefinition, SeeTranslationPartDefinition seeTranslationPartDefinition, AttachmentsPartDefinition attachmentsPartDefinition, FeedAttachedStoryPartDefinition feedAttachedStoryPartDefinition, BlingBarSelectorPartDefinition blingBarSelectorPartDefinition, TopLevelFooterPartSelector topLevelFooterPartSelector, AttributionPartDefinition attributionPartDefinition, StoryPromotionPartDefinition storyPromotionPartDefinition) {
        this.f12622a = storyPromotionPartDefinition;
        this.f12623b = topLevelFooterPartSelector;
        this.f12624c = blingBarSelectorPartDefinition;
        this.f12625d = feedAttachedStoryPartDefinition;
        this.f12626e = attachmentsPartDefinition;
        this.f12627f = seeTranslationPartDefinition;
        this.f12628g = timelineStoryTextSelectorPartDefinition;
        this.f12629h = timelineHeaderSelectorPartDefinition;
        this.f12630i = attributionPartDefinition;
    }

    public static TimelineSharedStoryPartDefinition m12583a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineSharedStoryPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12621k) {
                TimelineSharedStoryPartDefinition timelineSharedStoryPartDefinition;
                if (a2 != null) {
                    timelineSharedStoryPartDefinition = (TimelineSharedStoryPartDefinition) a2.a(f12621k);
                } else {
                    timelineSharedStoryPartDefinition = f12620j;
                }
                if (timelineSharedStoryPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12584b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12621k, b3);
                        } else {
                            f12620j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineSharedStoryPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
