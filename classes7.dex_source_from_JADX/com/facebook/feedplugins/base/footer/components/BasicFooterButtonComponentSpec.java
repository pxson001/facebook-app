package com.facebook.feedplugins.base.footer.components;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.ComponentLayout.ContainerBuilder;
import com.facebook.components.Container;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.fb.widget.TouchSpringIconComponent;
import com.facebook.components.glyph.GlyphColorizerDrawableReference;
import com.facebook.components.reference.Reference;
import com.facebook.components.widget.Text;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.widget.DownstateType;
import com.facebook.feedplugins.base.footer.ui.BasicFooterClickHandler;
import com.facebook.feedplugins.base.footer.ui.Footer.FooterButtonId;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@LayoutSpec
@ContextScoped
/* compiled from: TAP */
public class BasicFooterButtonComponentSpec<E extends HasFeedListType & HasPersistentState> {
    private static BasicFooterButtonComponentSpec f22955d;
    private static final Object f22956e = new Object();
    private final GlyphColorizerDrawableReference f22957a;
    private final TouchSpringIconComponent<E> f22958b;
    private final Lazy<BasicFooterClickHandler> f22959c;

    private static BasicFooterButtonComponentSpec m25464b(InjectorLike injectorLike) {
        return new BasicFooterButtonComponentSpec(GlyphColorizerDrawableReference.a(injectorLike), TouchSpringIconComponent.a(injectorLike), IdBasedLazy.a(injectorLike, 1832));
    }

    @Inject
    public BasicFooterButtonComponentSpec(GlyphColorizerDrawableReference glyphColorizerDrawableReference, TouchSpringIconComponent touchSpringIconComponent, Lazy<BasicFooterClickHandler> lazy) {
        this.f22957a = glyphColorizerDrawableReference;
        this.f22958b = touchSpringIconComponent;
        this.f22959c = lazy;
    }

    public static BasicFooterButtonComponentSpec m25463a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BasicFooterButtonComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22956e) {
                BasicFooterButtonComponentSpec basicFooterButtonComponentSpec;
                if (a2 != null) {
                    basicFooterButtonComponentSpec = (BasicFooterButtonComponentSpec) a2.a(f22956e);
                } else {
                    basicFooterButtonComponentSpec = f22955d;
                }
                if (basicFooterButtonComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25464b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22956e, b3);
                        } else {
                            f22955d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = basicFooterButtonComponentSpec;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    protected final ComponentLayout m25465a(ComponentContext componentContext, FeedProps<GraphQLStory> feedProps, FooterButtonId footerButtonId, DownstateType downstateType, boolean z, E e) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        ContainerBuilder I = Container.a(componentContext).C(2).E(2).D(1).a(PressedStateDrawableReference.m25493a(componentContext).m25490a(downstateType)).b(BasicFooterButtonComponent.m25458b(componentContext)).b(FooterStylingUtils.m25488b(footerButtonId)).I(FooterStylingUtils.m25485a(footerButtonId, graphQLStory));
        if (z) {
            Reference a = FooterStylingUtils.m25487a(componentContext, graphQLStory, footerButtonId, this.f22957a);
            Drawable drawable = (Drawable) Reference.a(componentContext, a);
            int i = (-drawable.getIntrinsicWidth()) / 2;
            int dimensionPixelSize = componentContext.getResources().getDimensionPixelSize(2131427475) - (drawable.getIntrinsicWidth() / 2);
            Reference.a(componentContext, drawable, a);
            I.a(this.f22958b.a(componentContext).m20693a(a).m20694a((HasPersistentState) e).m20696a(footerButtonId.toString() + graphQLStory.g()).m20695a((CacheableEntity) graphQLStory).c().a(6, i).a(7, dimensionPixelSize).a(true));
        }
        return I.a(Text.a(componentContext).h(FooterStylingUtils.m25484a(footerButtonId)).o(2131427476).k(FooterStylingUtils.m25486a(graphQLStory, footerButtonId)).b(true).a(Typeface.DEFAULT_BOLD).a(false)).j();
    }

    protected final void m25466a(View view, FeedProps<GraphQLStory> feedProps, FooterButtonId footerButtonId, E e, boolean z) {
        ((BasicFooterClickHandler) this.f22959c.get()).a(feedProps, view, footerButtonId, z, e.c());
    }
}
