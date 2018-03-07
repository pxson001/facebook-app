package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.ComponentLayout$ContainerBuilder;
import com.facebook.components.Container;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.BaseExplanationPartDefinition;
import com.facebook.feed.rows.sections.header.components.ExplanationTextComponent.Builder;
import com.facebook.feed.rows.sections.header.components.ExplanationTextComponent.State;
import com.facebook.feed.rows.sections.header.ui.TextHeaderStyle;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@LayoutSpec
@ContextScoped
/* compiled from: friending_blacklist_people_you_may_invite */
public class ExplanationComponentSpec<E extends HasInvalidate & HasMenuButtonProvider & HasPersistentState> {
    private static ExplanationComponentSpec f23143c;
    private static final Object f23144d = new Object();
    private final ExplanationTextComponent<E> f23145a;
    private final HeaderMenuComponentLayouts f23146b;

    private static ExplanationComponentSpec m31258b(InjectorLike injectorLike) {
        return new ExplanationComponentSpec(ExplanationTextComponent.m31260a(injectorLike), HeaderMenuComponentLayouts.m28491b(injectorLike));
    }

    @Inject
    public ExplanationComponentSpec(ExplanationTextComponent explanationTextComponent, HeaderMenuComponentLayouts headerMenuComponentLayouts) {
        this.f23145a = explanationTextComponent;
        this.f23146b = headerMenuComponentLayouts;
    }

    protected final ComponentLayout m31259a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, E e, TextHeaderStyle textHeaderStyle) {
        ComponentLayout$ContainerBuilder E = Container.m30723a(componentContext).mo3300C(2).mo3302E(1);
        ExplanationTextComponent explanationTextComponent = this.f23145a;
        State state = new State(explanationTextComponent);
        Builder builder = (Builder) explanationTextComponent.f23150c.mo740a();
        if (builder == null) {
            builder = new Builder(explanationTextComponent);
        }
        Builder.a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.a.a = feedProps;
        builder2.e.set(0);
        builder2 = builder2;
        builder2.a.b = e;
        builder2.e.set(1);
        builder2 = builder2;
        int colorResource = textHeaderStyle.getColorResource();
        builder2.a.c = builder2.m30673d(colorResource);
        builder2.e.set(2);
        builder2 = builder2;
        colorResource = textHeaderStyle.getFontSizeResource();
        builder2.a.d = builder2.m30675e(colorResource);
        builder2.e.set(3);
        builder2 = builder2;
        builder2.a.e = textHeaderStyle.getFontStyle();
        builder2.e.set(4);
        return E.mo3316a(builder2.m30663c().mo3307a(1.0f).mo3328c(1, 2131428829)).mo3316a(this.f23146b.m28493a(componentContext, feedProps, BaseExplanationPartDefinition.m31282b((FeedProps) feedProps), ((HasMenuButtonProvider) e).mo2448e())).mo3343j();
    }

    public static ExplanationComponentSpec m31257a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ExplanationComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23144d) {
                ExplanationComponentSpec explanationComponentSpec;
                if (a2 != null) {
                    explanationComponentSpec = (ExplanationComponentSpec) a2.mo818a(f23144d);
                } else {
                    explanationComponentSpec = f23143c;
                }
                if (explanationComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m31258b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23144d, b3);
                        } else {
                            f23143c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = explanationComponentSpec;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
