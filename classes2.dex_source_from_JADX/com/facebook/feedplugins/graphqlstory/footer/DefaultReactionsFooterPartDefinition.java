package com.facebook.feedplugins.graphqlstory.footer;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.fallback.annotations.FallbackSpec;
import com.facebook.feed.environment.CanFeedback;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.feedbackreactions.ReactionsFooterPartDefinition;
import com.facebook.feedplugins.feedbackreactions.ui.ReactionsFooterView;
import com.facebook.feedplugins.graphqlstory.footer.FooterBackgroundPartDefinition.Props;
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
@FallbackSpec(mountType = ReactionsFooterView.class)
/* compiled from: has_post_params */
public class DefaultReactionsFooterPartDefinition<E extends CanFeedback & CanShowVideoInFullScreen & HasPersistentState> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, ReactionsFooterView> {
    private static DefaultReactionsFooterPartDefinition f21311e;
    private static final Object f21312f = new Object();
    private final ReactionsFooterPartDefinition f21313a;
    private final DefaultFooterPartDefinition f21314b;
    private final FooterBackgroundPartDefinition<ReactionsFooterView> f21315c;
    private final GraphQLStoryUtil f21316d;

    private static DefaultReactionsFooterPartDefinition m29013b(InjectorLike injectorLike) {
        return new DefaultReactionsFooterPartDefinition(ReactionsFooterPartDefinition.m29018a(injectorLike), DefaultFooterPartDefinition.m28960a(injectorLike), FooterBackgroundPartDefinition.m28997a(injectorLike), GraphQLStoryUtil.m9565a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        CanFeedback canFeedback = (CanFeedback) anyEnvironment;
        subParts.mo2756a(this.f21313a, feedProps);
        subParts.mo2756a(this.f21315c, new Props(feedProps, this.f21314b.m28963a(feedProps, (HasPersistentState) canFeedback)));
        return null;
    }

    @Inject
    public DefaultReactionsFooterPartDefinition(ReactionsFooterPartDefinition reactionsFooterPartDefinition, DefaultFooterPartDefinition defaultFooterPartDefinition, FooterBackgroundPartDefinition footerBackgroundPartDefinition, GraphQLStoryUtil graphQLStoryUtil) {
        this.f21313a = reactionsFooterPartDefinition;
        this.f21314b = defaultFooterPartDefinition;
        this.f21315c = footerBackgroundPartDefinition;
        this.f21316d = graphQLStoryUtil;
    }

    public final ViewType<ReactionsFooterView> mo2547a() {
        return ReactionsFooterView.f22290h;
    }

    public final boolean m29016a(FeedProps<GraphQLStory> feedProps) {
        if (this.f21316d.m9603n((FeedProps) feedProps) && this.f21313a.m29022a((FeedProps) feedProps) && this.f21314b.m28963a(feedProps, null) != null) {
            return true;
        }
        return false;
    }

    public static DefaultReactionsFooterPartDefinition m29012a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultReactionsFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21312f) {
                DefaultReactionsFooterPartDefinition defaultReactionsFooterPartDefinition;
                if (a2 != null) {
                    defaultReactionsFooterPartDefinition = (DefaultReactionsFooterPartDefinition) a2.mo818a(f21312f);
                } else {
                    defaultReactionsFooterPartDefinition = f21311e;
                }
                if (defaultReactionsFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m29013b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21312f, b3);
                        } else {
                            f21311e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultReactionsFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
