package com.facebook.feedplugins.graphqlstory.footer.components;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.fallback.FallbackViewCreator;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.components.feed.ComponentPartHelper;
import com.facebook.feed.environment.CanFeedback;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.feedplugins.base.footer.ui.DefaultFooterView;
import com.facebook.feedplugins.graphqlstory.footer.DefaultFooterPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.DefaultFooterPartDefinitionFallbackComponent;
import com.facebook.feedplugins.graphqlstory.footer.DefaultFooterPartDefinitionFallbackComponent.Builder;
import com.facebook.feedplugins.graphqlstory.footer.DefaultFooterPartDefinitionFallbackComponent.State;
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
/* compiled from: SingleServiceGraphQL */
public class DefaultFooterComponentPartDefinition<E extends HasPersistentState & CanFeedback & HasContext & HasIsAsync> extends ComponentPartDefinition<FeedProps<GraphQLStory>, E> {
    private static DefaultFooterComponentPartDefinition f23276e;
    private static final Object f23277f = new Object();
    public final DefaultFooterPartDefinition f23278c;
    private final AndroidComponentsExperimentHelper f23279d;

    /* compiled from: SingleServiceGraphQL */
    class C20121 extends FallbackViewCreator<DefaultFooterView> {
        final /* synthetic */ DefaultFooterComponentPartDefinition f23275a;

        C20121(DefaultFooterComponentPartDefinition defaultFooterComponentPartDefinition) {
            this.f23275a = defaultFooterComponentPartDefinition;
        }

        public final View mo1573a(Context context) {
            return (DefaultFooterView) this.f23275a.f23278c.a().a(context);
        }
    }

    private static DefaultFooterComponentPartDefinition m25646b(InjectorLike injectorLike) {
        return new DefaultFooterComponentPartDefinition((Context) injectorLike.getInstance(Context.class), DefaultFooterPartDefinition.a(injectorLike), AndroidComponentsExperimentHelper.a(injectorLike));
    }

    public final boolean m25649a(Object obj) {
        return this.f23278c.a((FeedProps) obj) && this.f23279d.j();
    }

    public final CacheableEntity m25650b(Object obj) {
        return ComponentPartHelper.a((FeedProps) obj);
    }

    @Inject
    public DefaultFooterComponentPartDefinition(Context context, DefaultFooterPartDefinition defaultFooterPartDefinition, AndroidComponentsExperimentHelper androidComponentsExperimentHelper) {
        super(context);
        this.f23278c = defaultFooterPartDefinition;
        this.f23279d = androidComponentsExperimentHelper;
    }

    public static DefaultFooterComponentPartDefinition m25645a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultFooterComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23277f) {
                DefaultFooterComponentPartDefinition defaultFooterComponentPartDefinition;
                if (a2 != null) {
                    defaultFooterComponentPartDefinition = (DefaultFooterComponentPartDefinition) a2.a(f23277f);
                } else {
                    defaultFooterComponentPartDefinition = f23276e;
                }
                if (defaultFooterComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25646b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23277f, b3);
                        } else {
                            f23276e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultFooterComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private Component<?> m25644a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        State state = new State();
        Builder builder = (Builder) DefaultFooterPartDefinitionFallbackComponent.f23193c.a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m25579a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.f23185a.f23188b = e;
        builder2.f23186d.set(1);
        builder2 = builder2;
        builder2.f23185a.f23187a = this.f23278c;
        builder2.f23186d.set(0);
        builder2 = builder2;
        builder2.f23185a.f23189c = feedProps;
        builder2.f23186d.set(2);
        builder2 = builder2;
        builder2.f23185a.f23191e = new C20121(this);
        builder2.f23186d.set(3);
        return builder2.d();
    }
}
