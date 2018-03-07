package com.facebook.goodwill.feed.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.sections.header.FeedTextHeaderPartDefinition;
import com.facebook.feedplugins.goodwill.throwback.ThrowbackFeedFooterPartDefinition;
import com.facebook.feedplugins.graphqlstory.followup.FollowUpGroupPartDefinition;
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
/* compiled from: fetchAlbumMediaSet */
public class ThrowbackEdgeStoryGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static ThrowbackEdgeStoryGroupPartDefinition f13538e;
    private static final Object f13539f = new Object();
    private final FollowUpGroupPartDefinition<FeedEnvironment> f13540a;
    private final ThrowbackFeedFooterPartDefinition f13541b;
    private final ThrowbackAttachedStoryPartDefinition f13542c;
    private final FeedTextHeaderPartDefinition<FeedEnvironment> f13543d;

    private static ThrowbackEdgeStoryGroupPartDefinition m15305b(InjectorLike injectorLike) {
        return new ThrowbackEdgeStoryGroupPartDefinition(FeedTextHeaderPartDefinition.a(injectorLike), ThrowbackAttachedStoryPartDefinition.m15300a(injectorLike), ThrowbackFeedFooterPartDefinition.a(injectorLike), FollowUpGroupPartDefinition.a(injectorLike));
    }

    public final Object m15306a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f13543d, feedProps);
        baseMultiRowSubParts.a(this.f13542c, feedProps);
        baseMultiRowSubParts.a(this.f13540a, feedProps.a);
        baseMultiRowSubParts.a(this.f13541b, feedProps);
        return null;
    }

    public final boolean m15307a(Object obj) {
        return StoryProps.m((FeedProps) obj);
    }

    @Inject
    public ThrowbackEdgeStoryGroupPartDefinition(FeedTextHeaderPartDefinition feedTextHeaderPartDefinition, ThrowbackAttachedStoryPartDefinition throwbackAttachedStoryPartDefinition, ThrowbackFeedFooterPartDefinition throwbackFeedFooterPartDefinition, FollowUpGroupPartDefinition followUpGroupPartDefinition) {
        this.f13540a = followUpGroupPartDefinition;
        this.f13541b = throwbackFeedFooterPartDefinition;
        this.f13542c = throwbackAttachedStoryPartDefinition;
        this.f13543d = feedTextHeaderPartDefinition;
    }

    public static ThrowbackEdgeStoryGroupPartDefinition m15304a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackEdgeStoryGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13539f) {
                ThrowbackEdgeStoryGroupPartDefinition throwbackEdgeStoryGroupPartDefinition;
                if (a2 != null) {
                    throwbackEdgeStoryGroupPartDefinition = (ThrowbackEdgeStoryGroupPartDefinition) a2.a(f13539f);
                } else {
                    throwbackEdgeStoryGroupPartDefinition = f13538e;
                }
                if (throwbackEdgeStoryGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15305b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13539f, b3);
                        } else {
                            f13538e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackEdgeStoryGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
