package com.facebook.feedplugins.video.components;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.feed.rows.qe.ExperimentsForMultiRowQEModule;
import com.facebook.feedplugins.video.RichVideoRowPartDefinition;
import com.facebook.feedplugins.video.RichVideoRowPartDefinitionFallbackComponent;
import com.facebook.feedplugins.video.RichVideoRowPartDefinitionFallbackComponent.Builder;
import com.facebook.feedplugins.video.RichVideoRowPartDefinitionFallbackComponent.State;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: bytes_written */
public class RichVideoRowComponentPartDefinition<E extends CanShowVideoInFullScreen & HasPositionInformation & HasFeedListType & HasPersistentState & HasInvalidate & HasPrefetcher & HasContext & HasIsAsync> extends ComponentPartDefinition<FeedProps<GraphQLStoryAttachment>, E> {
    private static RichVideoRowComponentPartDefinition f250e;
    private static final Object f251f = new Object();
    public final RichVideoRowPartDefinition f252c;
    private final AndroidComponentsExperimentHelper f253d;

    private static RichVideoRowComponentPartDefinition m230b(InjectorLike injectorLike) {
        return new RichVideoRowComponentPartDefinition((Context) injectorLike.getInstance(Context.class), AndroidComponentsExperimentHelper.a(injectorLike), RichVideoRowPartDefinition.m176a(injectorLike));
    }

    public final boolean m233a(Object obj) {
        if (this.f252c.m180a((FeedProps) obj)) {
            AndroidComponentsExperimentHelper androidComponentsExperimentHelper = this.f253d;
            int i = 0;
            if (androidComponentsExperimentHelper.p == null) {
                androidComponentsExperimentHelper.p = Boolean.valueOf(AndroidComponentsExperimentHelper.a(androidComponentsExperimentHelper.a.a(ExperimentsForMultiRowQEModule.c, 0)));
            }
            if (androidComponentsExperimentHelper.p.booleanValue() || androidComponentsExperimentHelper.s()) {
                i = 1;
            }
            if (i != 0) {
                return true;
            }
        }
        return false;
    }

    @Inject
    public RichVideoRowComponentPartDefinition(Context context, AndroidComponentsExperimentHelper androidComponentsExperimentHelper, RichVideoRowPartDefinition richVideoRowPartDefinition) {
        super(context);
        this.f252c = richVideoRowPartDefinition;
        this.f253d = androidComponentsExperimentHelper;
    }

    public static RichVideoRowComponentPartDefinition m229a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RichVideoRowComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f251f) {
                RichVideoRowComponentPartDefinition richVideoRowComponentPartDefinition;
                if (a2 != null) {
                    richVideoRowComponentPartDefinition = (RichVideoRowComponentPartDefinition) a2.a(f251f);
                } else {
                    richVideoRowComponentPartDefinition = f250e;
                }
                if (richVideoRowComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m230b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f251f, b3);
                        } else {
                            f250e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = richVideoRowComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private Component<?> m228a(ComponentContext componentContext, FeedProps<GraphQLStoryAttachment> feedProps, E e) {
        State state = new State();
        Builder builder = (Builder) RichVideoRowPartDefinitionFallbackComponent.c.a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.a.b = e;
        builder2.d.set(1);
        builder2 = builder2;
        builder2.a.a = this.f252c;
        builder2.d.set(0);
        builder2 = builder2;
        builder2.a.c = feedProps;
        builder2.d.set(2);
        builder2 = builder2;
        builder2.a.e = new 1(this);
        builder2.d.set(3);
        return builder2.d();
    }

    public final CacheableEntity m234b(Object obj) {
        return null;
    }
}
