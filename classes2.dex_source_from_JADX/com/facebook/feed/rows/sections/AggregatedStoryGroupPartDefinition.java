package com.facebook.feed.rows.sections;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.TextHeaderSelectorPartDefinition;
import com.facebook.feed.rows.sections.inlinesurvey.InlineSurveyGroupPartDefinition;
import com.facebook.feed.rows.sections.text.ContentTextPartDefinition;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.feedplugins.attachments.AttachmentsPartDefinition;
import com.facebook.feedplugins.graphqlstory.followup.FollowUpGroupPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.BlingBarSelectorPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.StoryEmptyFooterPartDefinition;
import com.facebook.feedplugins.graphqlstory.seefirsttombstone.SeeFirstTombstonePartDefinition;
import com.facebook.feedplugins.graphqlstory.seefirsttombstone.SeeFirstTombstonePartDefinition.Props;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: initializeSharedPrefs */
public class AggregatedStoryGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static AggregatedStoryGroupPartDefinition f19980l;
    private static final Object f19981m = new Object();
    private final AttributionPartDefinition f19982a;
    private final FollowUpGroupPartDefinition<FeedEnvironment> f19983b;
    private final StoryEmptyFooterPartDefinition f19984c;
    private final BlingBarSelectorPartDefinition f19985d;
    private final FeedSubStoriesPartDefinition f19986e;
    private final LimitedAttachedStoryPartDefinition f19987f;
    private final AttachmentsPartDefinition f19988g;
    private final ContentTextPartDefinition f19989h;
    private final TextHeaderSelectorPartDefinition f19990i;
    private final SeeFirstTombstonePartDefinition<FeedEnvironment> f19991j;
    private final InlineSurveyGroupPartDefinition f19992k;

    private static AggregatedStoryGroupPartDefinition m27740b(InjectorLike injectorLike) {
        return new AggregatedStoryGroupPartDefinition(SeeFirstTombstonePartDefinition.m27752a(injectorLike), TextHeaderSelectorPartDefinition.m32773a(injectorLike), ContentTextPartDefinition.m32753a(injectorLike), AttachmentsPartDefinition.m27796a(injectorLike), LimitedAttachedStoryPartDefinition.m32659a(injectorLike), FeedSubStoriesPartDefinition.a(injectorLike), BlingBarSelectorPartDefinition.m27852a(injectorLike), StoryEmptyFooterPartDefinition.a(injectorLike), AttributionPartDefinition.a(injectorLike), FollowUpGroupPartDefinition.m27958a(injectorLike), InlineSurveyGroupPartDefinition.m27923a(injectorLike));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (FeedProps) obj;
        FeedEnvironment feedEnvironment = (FeedEnvironment) anyEnvironment;
        Object obj2 = (GraphQLStory) obj.f13444a;
        baseMultiRowSubParts.m19112a(this.f19982a, obj);
        baseMultiRowSubParts.m19112a(this.f19991j, new Props(obj2, feedEnvironment));
        baseMultiRowSubParts.m19112a(this.f19990i, obj);
        baseMultiRowSubParts.m19112a(this.f19989h, obj);
        baseMultiRowSubParts.m19112a(this.f19988g, obj);
        baseMultiRowSubParts.m19112a(this.f19987f, obj);
        baseMultiRowSubParts.m19112a(this.f19986e, obj);
        baseMultiRowSubParts.m19112a(this.f19985d, obj);
        baseMultiRowSubParts.m19112a(this.f19984c, obj);
        baseMultiRowSubParts.m19112a(this.f19992k, obj);
        baseMultiRowSubParts.m19112a(this.f19983b, obj2);
        return null;
    }

    public final boolean mo2536a(Object obj) {
        return m27739a((FeedProps) obj);
    }

    @Inject
    public AggregatedStoryGroupPartDefinition(SeeFirstTombstonePartDefinition seeFirstTombstonePartDefinition, TextHeaderSelectorPartDefinition textHeaderSelectorPartDefinition, ContentTextPartDefinition contentTextPartDefinition, AttachmentsPartDefinition attachmentsPartDefinition, LimitedAttachedStoryPartDefinition limitedAttachedStoryPartDefinition, FeedSubStoriesPartDefinition feedSubStoriesPartDefinition, BlingBarSelectorPartDefinition blingBarSelectorPartDefinition, StoryEmptyFooterPartDefinition storyEmptyFooterPartDefinition, AttributionPartDefinition attributionPartDefinition, FollowUpGroupPartDefinition followUpGroupPartDefinition, InlineSurveyGroupPartDefinition inlineSurveyGroupPartDefinition) {
        this.f19983b = followUpGroupPartDefinition;
        this.f19984c = storyEmptyFooterPartDefinition;
        this.f19985d = blingBarSelectorPartDefinition;
        this.f19986e = feedSubStoriesPartDefinition;
        this.f19987f = limitedAttachedStoryPartDefinition;
        this.f19988g = attachmentsPartDefinition;
        this.f19989h = contentTextPartDefinition;
        this.f19990i = textHeaderSelectorPartDefinition;
        this.f19991j = seeFirstTombstonePartDefinition;
        this.f19982a = attributionPartDefinition;
        this.f19992k = inlineSurveyGroupPartDefinition;
    }

    public static AggregatedStoryGroupPartDefinition m27738a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AggregatedStoryGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f19981m) {
                AggregatedStoryGroupPartDefinition aggregatedStoryGroupPartDefinition;
                if (a2 != null) {
                    aggregatedStoryGroupPartDefinition = (AggregatedStoryGroupPartDefinition) a2.mo818a(f19981m);
                } else {
                    aggregatedStoryGroupPartDefinition = f19980l;
                }
                if (aggregatedStoryGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27740b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f19981m, b3);
                        } else {
                            f19980l = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = aggregatedStoryGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public static boolean m27739a(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        if (graphQLStory.aD() == 0) {
            return false;
        }
        return (GraphQLStoryUtil.m9570a(StoryUtilModelConverter.m28877a(graphQLStory)) || FeedStoryUtil.m18586e(graphQLStory)) ? false : true;
    }
}
