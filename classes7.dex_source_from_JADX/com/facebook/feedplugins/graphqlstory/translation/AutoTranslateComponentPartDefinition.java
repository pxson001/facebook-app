package com.facebook.feedplugins.graphqlstory.translation;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.feed.rows.sections.components.FeedBackgroundStylerComponentWrapper;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.graphqlstory.translation.AutoTranslationComponent.Builder;
import com.facebook.feedplugins.graphqlstory.translation.AutoTranslationComponent.State;
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
/* compiled from: ScaleAspectCenter */
public class AutoTranslateComponentPartDefinition<E extends HasContext & HasIsAsync & HasPersistentState & HasPositionInformation> extends ComponentPartDefinition<FeedProps<GraphQLStory>, E> {
    private static AutoTranslateComponentPartDefinition f23380f;
    private static final Object f23381g = new Object();
    private final AutoTranslationComponent f23382c;
    private final AndroidComponentsExperimentHelper f23383d;
    private final FeedBackgroundStylerComponentWrapper f23384e;

    private static AutoTranslateComponentPartDefinition m25706b(InjectorLike injectorLike) {
        return new AutoTranslateComponentPartDefinition((Context) injectorLike.getInstance(Context.class), AutoTranslationComponent.m25726a(injectorLike), AndroidComponentsExperimentHelper.a(injectorLike), FeedBackgroundStylerComponentWrapper.b(injectorLike));
    }

    public final CacheableEntity m25710b(Object obj) {
        return (CacheableEntity) ((FeedProps) obj).a;
    }

    @Inject
    public AutoTranslateComponentPartDefinition(Context context, AutoTranslationComponent autoTranslationComponent, AndroidComponentsExperimentHelper androidComponentsExperimentHelper, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper) {
        super(context);
        this.f23382c = autoTranslationComponent;
        this.f23383d = androidComponentsExperimentHelper;
        this.f23384e = feedBackgroundStylerComponentWrapper;
    }

    private Component<?> m25704a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e) {
        FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper = this.f23384e;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) e;
        StylingData stylingData = new StylingData(feedProps, PaddingStyle.e);
        AutoTranslationComponent autoTranslationComponent = this.f23382c;
        State state = new State(autoTranslationComponent);
        Builder builder = (Builder) autoTranslationComponent.f23427c.a();
        if (builder == null) {
            builder = new Builder(autoTranslationComponent);
        }
        Builder.m25722a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.f23415a.f23420a = feedProps;
        builder2.f23419e.set(0);
        builder2 = builder2;
        builder2.f23415a.f23421b = (HasPersistentState) e;
        builder2.f23419e.set(1);
        return feedBackgroundStylerComponentWrapper.b(componentContext, hasPositionInformation, stylingData, builder2.d());
    }

    public static AutoTranslateComponentPartDefinition m25705a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AutoTranslateComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23381g) {
                AutoTranslateComponentPartDefinition autoTranslateComponentPartDefinition;
                if (a2 != null) {
                    autoTranslateComponentPartDefinition = (AutoTranslateComponentPartDefinition) a2.a(f23381g);
                } else {
                    autoTranslateComponentPartDefinition = f23380f;
                }
                if (autoTranslateComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25706b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23381g, b3);
                        } else {
                            f23380f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = autoTranslateComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m25709a(Object obj) {
        return this.f23383d.h();
    }
}
