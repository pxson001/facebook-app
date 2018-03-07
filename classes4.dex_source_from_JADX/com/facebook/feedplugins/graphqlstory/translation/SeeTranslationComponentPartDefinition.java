package com.facebook.feedplugins.graphqlstory.translation;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.components.feed.ComponentPartHelper;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.feed.rows.sections.components.FeedBackgroundStylerComponentWrapper;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.graphqlstory.translation.SeeTranslationComponent.Builder;
import com.facebook.feedplugins.graphqlstory.translation.SeeTranslationComponent.State;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: origin */
public class SeeTranslationComponentPartDefinition<E extends HasContext & HasInvalidate & HasIsAsync & HasPersistentState & HasPositionInformation> extends ComponentPartDefinition<FeedProps<GraphQLStory>, E> {
    private static SeeTranslationComponentPartDefinition f5927f;
    private static final Object f5928g = new Object();
    private final SeeTranslationComponent<E> f5929c;
    private final FeedBackgroundStylerComponentWrapper f5930d;
    private final AndroidComponentsExperimentHelper f5931e;

    private static SeeTranslationComponentPartDefinition m6389b(InjectorLike injectorLike) {
        return new SeeTranslationComponentPartDefinition((Context) injectorLike.getInstance(Context.class), SeeTranslationComponent.m6395a(injectorLike), FeedBackgroundStylerComponentWrapper.b(injectorLike), AndroidComponentsExperimentHelper.a(injectorLike));
    }

    public final CacheableEntity m6394b(Object obj) {
        return ComponentPartHelper.a((FeedProps) obj);
    }

    @Inject
    public SeeTranslationComponentPartDefinition(Context context, SeeTranslationComponent seeTranslationComponent, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper, AndroidComponentsExperimentHelper androidComponentsExperimentHelper) {
        super(context);
        this.f5929c = seeTranslationComponent;
        this.f5930d = feedBackgroundStylerComponentWrapper;
        this.f5931e = androidComponentsExperimentHelper;
    }

    public final ViewType m6392a() {
        return ComponentPartDefinition.a;
    }

    public static SeeTranslationComponentPartDefinition m6388a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SeeTranslationComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5928g) {
                SeeTranslationComponentPartDefinition seeTranslationComponentPartDefinition;
                if (a2 != null) {
                    seeTranslationComponentPartDefinition = (SeeTranslationComponentPartDefinition) a2.a(f5928g);
                } else {
                    seeTranslationComponentPartDefinition = f5927f;
                }
                if (seeTranslationComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6389b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5928g, b3);
                        } else {
                            f5927f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = seeTranslationComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private Component<?> m6387a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        SeeTranslationComponent seeTranslationComponent = this.f5929c;
        State state = new State(seeTranslationComponent);
        Builder builder = (Builder) seeTranslationComponent.f5935c.a();
        if (builder == null) {
            builder = new Builder(seeTranslationComponent);
        }
        Builder.a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.a.a = feedProps;
        builder2.e.set(0);
        Builder builder3 = builder2;
        builder3.a.b = (HasPositionInformation) e;
        builder3.e.set(1);
        return this.f5930d.b(componentContext, (HasPositionInformation) e, new StylingData(feedProps, PaddingStyle.e), builder3.d());
    }

    public final boolean m6393a(Object obj) {
        return this.f5931e.h();
    }
}
