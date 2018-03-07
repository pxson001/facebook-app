package com.facebook.feedplugins.storyset.rows.components;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.EmbeddedComponentPartDefinition;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feedplugins.storyset.rows.StorySetPageProps;
import com.facebook.feedplugins.storyset.rows.components.StorySetPageHeaderComponent.Builder;
import com.facebook.feedplugins.storyset.rows.components.StorySetPageHeaderComponent.State;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: async-feed-prefetch */
public class StorySetPageHeaderComponentPartDefinition<E extends HasContext & HasFeedListType & HasInvalidate & HasPersistentState & HasPositionInformation & HasPrefetcher & HasMenuButtonProvider & HasRowKey & HasIsAsync> extends EmbeddedComponentPartDefinition<StorySetPageProps, E> {
    private static StorySetPageHeaderComponentPartDefinition f9835c;
    private static final Object f9836d = new Object();
    private final StorySetPageHeaderComponent f9837b;

    private static StorySetPageHeaderComponentPartDefinition m10243b(InjectorLike injectorLike) {
        return new StorySetPageHeaderComponentPartDefinition((Context) injectorLike.getInstance(Context.class), StorySetPageHeaderComponent.m10237a(injectorLike));
    }

    @Inject
    public StorySetPageHeaderComponentPartDefinition(Context context, StorySetPageHeaderComponent storySetPageHeaderComponent) {
        super(context);
        this.f9837b = storySetPageHeaderComponent;
    }

    private Component<?> m10241a(ComponentContext componentContext, StorySetPageProps storySetPageProps, E e) {
        StorySetPageHeaderComponent storySetPageHeaderComponent = this.f9837b;
        State state = new State(storySetPageHeaderComponent);
        Builder builder = (Builder) storySetPageHeaderComponent.f9834c.a();
        if (builder == null) {
            builder = new Builder(storySetPageHeaderComponent);
        }
        Builder.m10234a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.f9823a.f9829b = (HasFeedListType) e;
        builder2.f9827e.set(1);
        builder2 = builder2;
        builder2.f9823a.f9828a = storySetPageProps;
        builder2.f9827e.set(0);
        return builder2.d();
    }

    public static StorySetPageHeaderComponentPartDefinition m10242a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetPageHeaderComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9836d) {
                StorySetPageHeaderComponentPartDefinition storySetPageHeaderComponentPartDefinition;
                if (a2 != null) {
                    storySetPageHeaderComponentPartDefinition = (StorySetPageHeaderComponentPartDefinition) a2.a(f9836d);
                } else {
                    storySetPageHeaderComponentPartDefinition = f9835c;
                }
                if (storySetPageHeaderComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10243b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9836d, b3);
                        } else {
                            f9835c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetPageHeaderComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
