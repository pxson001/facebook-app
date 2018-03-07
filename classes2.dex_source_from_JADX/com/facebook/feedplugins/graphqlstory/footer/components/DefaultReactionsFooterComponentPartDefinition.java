package com.facebook.feedplugins.graphqlstory.footer.components;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.components.feed.ComponentPartHelper;
import com.facebook.feed.environment.CanFeedback;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.feedplugins.graphqlstory.footer.DefaultReactionsFooterPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.DefaultReactionsFooterPartDefinitionFallbackComponent;
import com.facebook.feedplugins.graphqlstory.footer.DefaultReactionsFooterPartDefinitionFallbackComponent.Builder;
import com.facebook.feedplugins.graphqlstory.footer.DefaultReactionsFooterPartDefinitionFallbackComponent.State;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: has_post_params_extra */
public class DefaultReactionsFooterComponentPartDefinition<E extends HasPersistentState & CanFeedback & HasContext & HasIsAsync> extends ComponentPartDefinition<FeedProps<GraphQLStory>, E> {
    private static DefaultReactionsFooterComponentPartDefinition f21307e;
    private static final Object f21308f = new Object();
    public final DefaultReactionsFooterPartDefinition f21309c;
    private final AndroidComponentsExperimentHelper f21310d;

    private static DefaultReactionsFooterComponentPartDefinition m29007b(InjectorLike injectorLike) {
        return new DefaultReactionsFooterComponentPartDefinition((Context) injectorLike.getInstance(Context.class), DefaultReactionsFooterPartDefinition.m29012a(injectorLike), AndroidComponentsExperimentHelper.m10053a(injectorLike));
    }

    public final boolean m29010a(Object obj) {
        return this.f21309c.m29016a((FeedProps) obj) && this.f21310d.m10060j();
    }

    public final CacheableEntity mo3131b(Object obj) {
        return ComponentPartHelper.m28377a((FeedProps) obj);
    }

    @Inject
    public DefaultReactionsFooterComponentPartDefinition(Context context, DefaultReactionsFooterPartDefinition defaultReactionsFooterPartDefinition, AndroidComponentsExperimentHelper androidComponentsExperimentHelper) {
        super(context);
        this.f21309c = defaultReactionsFooterPartDefinition;
        this.f21310d = androidComponentsExperimentHelper;
    }

    public static DefaultReactionsFooterComponentPartDefinition m29006a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultReactionsFooterComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21308f) {
                DefaultReactionsFooterComponentPartDefinition defaultReactionsFooterComponentPartDefinition;
                if (a2 != null) {
                    defaultReactionsFooterComponentPartDefinition = (DefaultReactionsFooterComponentPartDefinition) a2.mo818a(f21308f);
                } else {
                    defaultReactionsFooterComponentPartDefinition = f21307e;
                }
                if (defaultReactionsFooterComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m29007b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21308f, b3);
                        } else {
                            f21307e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultReactionsFooterComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    private Component<?> m29005a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        State state = new State();
        Builder builder = (Builder) DefaultReactionsFooterPartDefinitionFallbackComponent.c.mo740a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.a.b = e;
        builder2.d.set(1);
        builder2 = builder2;
        builder2.a.a = this.f21309c;
        builder2.d.set(0);
        builder2 = builder2;
        builder2.a.c = feedProps;
        builder2.d.set(2);
        builder2 = builder2;
        builder2.a.e = new 1(this);
        builder2.d.set(3);
        return builder2.mo3296d();
    }
}
