package com.facebook.feed.rows.sections.header;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanLikePage;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.SpringScaleButtonPartDefinition.Props;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.widget.springbutton.SpringScaleButton;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fresh_feed_overlay */
public class LikePageButtonPartDefinition<E extends CanLikePage & HasPersistentState> extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, SpringScaleButton> {
    private static LikePageButtonPartDefinition f23221d;
    private static final Object f23222e = new Object();
    private final StoryActionLinkUtil f23223a;
    private final GatekeeperStoreImpl f23224b;
    private final SpringScaleButtonPartDefinition f23225c;

    private static LikePageButtonPartDefinition m31323b(InjectorLike injectorLike) {
        return new LikePageButtonPartDefinition(GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), StoryActionLinkUtil.m28026b(injectorLike), SpringScaleButtonPartDefinition.m28460a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        CanLikePage canLikePage = (CanLikePage) anyEnvironment;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        GraphQLStoryActionLink a = this.f23223a.m28027a(feedProps);
        if (a != null) {
            GraphQLPage ab = a.ab();
            subParts.mo2756a(this.f23225c, new Props(graphQLStory, ab.ae(), new PageLikeListener(feedProps, ab, this.f23224b, canLikePage), ab.m23463O()));
        }
        return null;
    }

    @Inject
    public LikePageButtonPartDefinition(GatekeeperStoreImpl gatekeeperStoreImpl, StoryActionLinkUtil storyActionLinkUtil, SpringScaleButtonPartDefinition springScaleButtonPartDefinition) {
        this.f23223a = storyActionLinkUtil;
        this.f23224b = gatekeeperStoreImpl;
        this.f23225c = springScaleButtonPartDefinition;
    }

    public static LikePageButtonPartDefinition m31322a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LikePageButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23222e) {
                LikePageButtonPartDefinition likePageButtonPartDefinition;
                if (a2 != null) {
                    likePageButtonPartDefinition = (LikePageButtonPartDefinition) a2.mo818a(f23222e);
                } else {
                    likePageButtonPartDefinition = f23221d;
                }
                if (likePageButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m31323b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23222e, b3);
                        } else {
                            f23221d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = likePageButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
