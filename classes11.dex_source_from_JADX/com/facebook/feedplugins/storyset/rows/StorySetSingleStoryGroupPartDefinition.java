package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.BasicGroupPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.StorySetHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: audience_educator_manager_save_suggested */
public class StorySetSingleStoryGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStorySet>, Void, FeedEnvironment> {
    private static StorySetSingleStoryGroupPartDefinition f9772b;
    private static final Object f9773c = new Object();
    private final BasicGroupPartDefinition f9774a;

    private static StorySetSingleStoryGroupPartDefinition m10205b(InjectorLike injectorLike) {
        return new StorySetSingleStoryGroupPartDefinition(BasicGroupPartDefinition.a(injectorLike));
    }

    public final Object m10206a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f9774a, FeedProps.a((GraphQLStory) StorySetHelper.b((GraphQLStorySet) feedProps.a).get(0), ImmutableList.of(feedProps.a)));
        return null;
    }

    @Inject
    public StorySetSingleStoryGroupPartDefinition(BasicGroupPartDefinition basicGroupPartDefinition) {
        this.f9774a = basicGroupPartDefinition;
    }

    public static boolean m10204a(FeedProps<GraphQLStorySet> feedProps) {
        return StorySetHelper.d((GraphQLStorySet) feedProps.a) && StorySetHelper.b((GraphQLStorySet) feedProps.a).size() == 1;
    }

    public static StorySetSingleStoryGroupPartDefinition m10203a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetSingleStoryGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9773c) {
                StorySetSingleStoryGroupPartDefinition storySetSingleStoryGroupPartDefinition;
                if (a2 != null) {
                    storySetSingleStoryGroupPartDefinition = (StorySetSingleStoryGroupPartDefinition) a2.a(f9773c);
                } else {
                    storySetSingleStoryGroupPartDefinition = f9772b;
                }
                if (storySetSingleStoryGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10205b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9773c, b3);
                        } else {
                            f9772b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetSingleStoryGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
