package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component.Builder;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.ComponentLayout$ContainerBuilder;
import com.facebook.components.Container;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.components.HeaderSubtitleComponent.State;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ultralight.Inject;

@LayoutSpec
@ContextScoped
/* compiled from: image/png */
public class HeaderTitleAndSubtitleComponentSpec<E extends HasContext & HasFeedListType & HasInvalidate & HasPersistentState & HasPrefetcher & HasRowKey> {
    private static HeaderTitleAndSubtitleComponentSpec f20505c;
    private static final Object f20506d = new Object();
    private final HeaderTitleComponent<E> f20507a;
    private final HeaderSubtitleComponent f20508b;

    private static HeaderTitleAndSubtitleComponentSpec m28248b(InjectorLike injectorLike) {
        return new HeaderTitleAndSubtitleComponentSpec(HeaderTitleComponent.m28250a(injectorLike), HeaderSubtitleComponent.m28274a(injectorLike));
    }

    @Inject
    private HeaderTitleAndSubtitleComponentSpec(HeaderTitleComponent headerTitleComponent, HeaderSubtitleComponent headerSubtitleComponent) {
        this.f20507a = headerTitleComponent;
        this.f20508b = headerSubtitleComponent;
    }

    protected final ComponentLayout m28249a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        ComponentLayout$ContainerBuilder a = Container.m30723a(componentContext).mo3322b(1.0f).mo3302E(1).mo3314a(this.f20507a.m28252a(componentContext).m31008a((FeedProps) feedProps).m31007a((HasPersistentState) e));
        State state = new State(this.f20508b);
        Builder builder = (HeaderSubtitleComponent.Builder) HeaderSubtitleComponent.f20547b.mo740a();
        if (builder == null) {
            builder = new HeaderSubtitleComponent.Builder();
        }
        HeaderSubtitleComponent.Builder.m31063a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.f22952a.f22944a = feedProps;
        builder2.f22955d.set(0);
        return a.mo3316a(builder2.m30663c().mo3336g(1, 2131428859)).mo3343j();
    }

    public static HeaderTitleAndSubtitleComponentSpec m28247a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HeaderTitleAndSubtitleComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20506d) {
                HeaderTitleAndSubtitleComponentSpec headerTitleAndSubtitleComponentSpec;
                if (a2 != null) {
                    headerTitleAndSubtitleComponentSpec = (HeaderTitleAndSubtitleComponentSpec) a2.mo818a(f20506d);
                } else {
                    headerTitleAndSubtitleComponentSpec = f20505c;
                }
                if (headerTitleAndSubtitleComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28248b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20506d, b3);
                        } else {
                            f20505c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = headerTitleAndSubtitleComponentSpec;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
