package com.facebook.feed.rows.sections;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.sections.header.TextHeaderSelectorPartDefinition;
import com.facebook.feed.rows.sections.inlinesurvey.InlineSurveyGroupPartDefinition;
import com.facebook.feedplugins.graphqlstory.followup.FollowUpGroupPartDefinition;
import com.facebook.feedplugins.graphqlstory.seefirsttombstone.SeeFirstTombstonePartDefinition;
import com.facebook.feedplugins.graphqlstory.seefirsttombstone.SeeFirstTombstonePartDefinition.Props;
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
/* compiled from: feedback.id =  */
public class EdgeStoryGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static EdgeStoryGroupPartDefinition f24455f;
    private static final Object f24456g = new Object();
    private final FollowUpGroupPartDefinition<FeedEnvironment> f24457a;
    private final FeedAttachedStoryPartDefinition f24458b;
    private final TextHeaderSelectorPartDefinition f24459c;
    private final SeeFirstTombstonePartDefinition<FeedEnvironment> f24460d;
    private final InlineSurveyGroupPartDefinition f24461e;

    private static EdgeStoryGroupPartDefinition m32770b(InjectorLike injectorLike) {
        return new EdgeStoryGroupPartDefinition(SeeFirstTombstonePartDefinition.m27752a(injectorLike), TextHeaderSelectorPartDefinition.m32773a(injectorLike), FeedAttachedStoryPartDefinition.m32655a(injectorLike), FollowUpGroupPartDefinition.m27958a(injectorLike), InlineSurveyGroupPartDefinition.m27923a(injectorLike));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (FeedProps) obj;
        Object obj2 = (GraphQLStory) obj.f13444a;
        baseMultiRowSubParts.m19112a(this.f24460d, new Props(obj2, (FeedEnvironment) anyEnvironment));
        baseMultiRowSubParts.m19112a(this.f24459c, obj);
        baseMultiRowSubParts.m19112a(this.f24458b, obj);
        baseMultiRowSubParts.m19112a(this.f24461e, obj);
        baseMultiRowSubParts.m19112a(this.f24457a, obj2);
        return null;
    }

    public final boolean mo2536a(Object obj) {
        return StoryProps.m27464m((FeedProps) obj);
    }

    @Inject
    public EdgeStoryGroupPartDefinition(SeeFirstTombstonePartDefinition seeFirstTombstonePartDefinition, TextHeaderSelectorPartDefinition textHeaderSelectorPartDefinition, FeedAttachedStoryPartDefinition feedAttachedStoryPartDefinition, FollowUpGroupPartDefinition followUpGroupPartDefinition, InlineSurveyGroupPartDefinition inlineSurveyGroupPartDefinition) {
        this.f24457a = followUpGroupPartDefinition;
        this.f24458b = feedAttachedStoryPartDefinition;
        this.f24459c = textHeaderSelectorPartDefinition;
        this.f24460d = seeFirstTombstonePartDefinition;
        this.f24461e = inlineSurveyGroupPartDefinition;
    }

    public static EdgeStoryGroupPartDefinition m32769a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EdgeStoryGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24456g) {
                EdgeStoryGroupPartDefinition edgeStoryGroupPartDefinition;
                if (a2 != null) {
                    edgeStoryGroupPartDefinition = (EdgeStoryGroupPartDefinition) a2.mo818a(f24456g);
                } else {
                    edgeStoryGroupPartDefinition = f24455f;
                }
                if (edgeStoryGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32770b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24456g, b3);
                        } else {
                            f24455f = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = edgeStoryGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
