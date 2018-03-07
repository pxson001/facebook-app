package com.facebook.feedplugins.graphqlstory.translation;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ClickEvent;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.ComponentsPools;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.Output;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.graphqlstory.translation.SeeTranslationComponentSpec.1;
import com.facebook.feedplugins.graphqlstory.translation.SeeTranslationComponentSpec.2;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.translation.TranslationMenuHelper;
import javax.inject.Inject;

@ContextScoped
/* compiled from: orient */
public class SeeTranslationComponent<E extends HasPositionInformation & HasInvalidate & HasPersistentState> extends ComponentLifecycle {
    private static SeeTranslationComponent f5932d;
    private static final Object f5933e = new Object();
    private final SeeTranslationComponentSpec f5934b;
    public final SynchronizedPool<Builder> f5935c = new SynchronizedPool(2);

    private static SeeTranslationComponent m6397b(InjectorLike injectorLike) {
        return new SeeTranslationComponent(SeeTranslationComponentSpec.m6405a(injectorLike));
    }

    @Inject
    public SeeTranslationComponent(SeeTranslationComponentSpec seeTranslationComponentSpec) {
        this.f5934b = seeTranslationComponentSpec;
    }

    public static SeeTranslationComponent m6395a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SeeTranslationComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5933e) {
                SeeTranslationComponent seeTranslationComponent;
                if (a2 != null) {
                    seeTranslationComponent = (SeeTranslationComponent) a2.a(f5933e);
                } else {
                    seeTranslationComponent = f5932d;
                }
                if (seeTranslationComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6397b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5933e, b3);
                        } else {
                            f5932d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = seeTranslationComponent;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    protected final InternalNode m6400b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        Output c = ComponentsPools.c();
        InternalNode a = this.f5934b.m6407a(componentContext, state.a, state.b, c);
        if (c.a != null) {
            state.c = (TranslatedTextPersistentState) c.a;
        }
        ComponentsPools.a(c);
        return a;
    }

    private void m6396a(View view, Component component) {
        State state = (State) component;
        SeeTranslationComponentSpec seeTranslationComponentSpec = this.f5934b;
        FeedProps feedProps = state.a;
        HasPositionInformation hasPositionInformation = state.b;
        TranslatedTextPersistentState translatedTextPersistentState = state.c;
        translatedTextPersistentState.f13712b = true;
        ((HasInvalidate) hasPositionInformation).a(new FeedProps[]{feedProps});
        seeTranslationComponentSpec.f5939b.d = new 1(seeTranslationComponentSpec, hasPositionInformation, feedProps);
        seeTranslationComponentSpec.f5939b.a((GraphQLStory) feedProps.a, translatedTextPersistentState);
    }

    private void m6398b(View view, Component component) {
        State state = (State) component;
        SeeTranslationComponentSpec seeTranslationComponentSpec = this.f5934b;
        FeedProps feedProps = state.a;
        TranslatedTextPersistentState translatedTextPersistentState = state.c;
        TranslationMenuHelper translationMenuHelper = new TranslationMenuHelper(((GraphQLStory) feedProps.a).aL(), seeTranslationComponentSpec.f5944g, seeTranslationComponentSpec.f5941d, Boolean.valueOf(false), seeTranslationComponentSpec.f5943f);
        translationMenuHelper.b.e = new 2(seeTranslationComponentSpec, feedProps, translatedTextPersistentState);
        translationMenuHelper.a(view);
    }

    public final void m6399a(EventHandler eventHandler, Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new 1(this, eventHandler, obj), 2093563816);
            return;
        }
        switch (eventHandler.b) {
            case 154277921:
                m6396a(((ClickEvent) obj).a, eventHandler.a);
                return;
            case 1729416567:
                m6398b(((ClickEvent) obj).a, eventHandler.a);
                return;
            default:
                return;
        }
    }
}
