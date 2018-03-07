package com.facebook.feed.rows.sections.header;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.components.FriendableHeaderComponentPartDefinition;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryActionLinkHelper;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
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
/* compiled from: http/2 */
public class FriendableHeaderPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static FriendableHeaderPartDefinition f20752d;
    private static final Object f20753e = new Object();
    private final Lazy<FriendableHeaderComponentPartDefinition<FeedEnvironment>> f20754a;
    private final Lazy<DefaultFriendableHeaderPartDefinition<FeedEnvironment>> f20755b;
    private final GraphQLStoryUtil f20756c;

    private static FriendableHeaderPartDefinition m28471b(InjectorLike injectorLike) {
        return new FriendableHeaderPartDefinition(IdBasedLazy.m1808a(injectorLike, 6030), IdBasedLazy.m1808a(injectorLike, 6025), GraphQLStoryUtil.m9565a(injectorLike));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (FeedProps) obj;
        SubPartsSelector.m19115a(baseMultiRowSubParts, this.f20754a, obj).m19119a(this.f20755b, obj);
        return null;
    }

    public final boolean mo2536a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).f13444a;
        boolean z = false;
        if (graphQLStory != null) {
            GraphQLActor b = StoryActorHelper.m27492b(graphQLStory);
            if (b != null) {
                GraphQLObjectType b2 = b.m23790b();
                if (!(b2 == null || b2.m22301g() != 2645995 || b.m23762E() == GraphQLFriendshipStatus.CANNOT_REQUEST || StoryActionLinkHelper.m28072a(graphQLStory, 1337291567) == null)) {
                    z = true;
                }
            }
        }
        return z;
    }

    @Inject
    public FriendableHeaderPartDefinition(Lazy<FriendableHeaderComponentPartDefinition> lazy, Lazy<DefaultFriendableHeaderPartDefinition> lazy2, GraphQLStoryUtil graphQLStoryUtil) {
        this.f20754a = lazy;
        this.f20755b = lazy2;
        this.f20756c = graphQLStoryUtil;
    }

    public static FriendableHeaderPartDefinition m28470a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendableHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20753e) {
                FriendableHeaderPartDefinition friendableHeaderPartDefinition;
                if (a2 != null) {
                    friendableHeaderPartDefinition = (FriendableHeaderPartDefinition) a2.mo818a(f20753e);
                } else {
                    friendableHeaderPartDefinition = f20752d;
                }
                if (friendableHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28471b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20753e, b3);
                        } else {
                            f20752d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = friendableHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
