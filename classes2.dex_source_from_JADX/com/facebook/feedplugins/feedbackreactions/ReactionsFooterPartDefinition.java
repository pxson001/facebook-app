package com.facebook.feedplugins.feedbackreactions;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.feedbackreactions.ui.BaseReactionsFooterPartDefinition;
import com.facebook.feedplugins.feedbackreactions.ui.BaseReactionsFooterPartDefinition.Props;
import com.facebook.feedplugins.feedbackreactions.ui.ReactionsFooterView;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: has_permission */
public class ReactionsFooterPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, CanShowVideoInFullScreen, ReactionsFooterView> {
    private static ReactionsFooterPartDefinition f21317c;
    private static final Object f21318d = new Object();
    private final BaseReactionsFooterPartDefinition f21319a;
    private final GraphQLStoryUtil f21320b;

    private static ReactionsFooterPartDefinition m29019b(InjectorLike injectorLike) {
        return new ReactionsFooterPartDefinition(BaseReactionsFooterPartDefinition.m29025a(injectorLike), GraphQLStoryUtil.m9565a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.mo2756a(this.f21319a, new Props((FeedProps) obj, true));
        return null;
    }

    @Inject
    public ReactionsFooterPartDefinition(BaseReactionsFooterPartDefinition baseReactionsFooterPartDefinition, GraphQLStoryUtil graphQLStoryUtil) {
        this.f21319a = baseReactionsFooterPartDefinition;
        this.f21320b = graphQLStoryUtil;
    }

    public final ViewType mo2547a() {
        return ReactionsFooterView.f22290h;
    }

    public final boolean m29022a(FeedProps<GraphQLStory> feedProps) {
        return this.f21320b.m9603n((FeedProps) feedProps);
    }

    public static ReactionsFooterPartDefinition m29018a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionsFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21318d) {
                ReactionsFooterPartDefinition reactionsFooterPartDefinition;
                if (a2 != null) {
                    reactionsFooterPartDefinition = (ReactionsFooterPartDefinition) a2.mo818a(f21318d);
                } else {
                    reactionsFooterPartDefinition = f21317c;
                }
                if (reactionsFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m29019b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21318d, b3);
                        } else {
                            f21317c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionsFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
