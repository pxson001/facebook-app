package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import android.graphics.Rect;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.Layout;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.reference.DrawableReference;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.photosfeed.PhotosFeedBackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundAttributeResourceResolver;
import com.facebook.feed.rows.styling.BackgroundResourceResolver;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.BackgroundStyles;
import com.facebook.feed.rows.styling.BasePaddingStyleResolver;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.PositionResolver;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@LayoutSpec
@ContextScoped
/* compiled from: ac194a500c899d29303c795600101a66 */
public class PhotosFeedBackgroundComponentSpec {
    private static PhotosFeedBackgroundComponentSpec f20184d;
    private static final Object f20185e = new Object();
    private final PositionResolver f20186a;
    private final BasePaddingStyleResolver f20187b;
    private final BackgroundResourceResolver f20188c;

    private static PhotosFeedBackgroundComponentSpec m23325b(InjectorLike injectorLike) {
        return new PhotosFeedBackgroundComponentSpec(PositionResolver.a(injectorLike), (BasePaddingStyleResolver) DefaultPaddingStyleResolver.a(injectorLike), (BackgroundResourceResolver) BackgroundAttributeResourceResolver.a(injectorLike));
    }

    @Inject
    public PhotosFeedBackgroundComponentSpec(PositionResolver positionResolver, BasePaddingStyleResolver basePaddingStyleResolver, BackgroundResourceResolver backgroundResourceResolver) {
        this.f20186a = positionResolver;
        this.f20187b = basePaddingStyleResolver;
        this.f20188c = backgroundResourceResolver;
    }

    protected final ComponentLayout m23326a(ComponentContext componentContext, Component<?> component, StylingData stylingData, HasPositionInformation hasPositionInformation) {
        Rect rect = new Rect();
        Position a = BackgroundStyles.a(0, stylingData.f20189a, null, this.f20186a, hasPositionInformation.f(), hasPositionInformation.hK_(), hasPositionInformation.h(), hasPositionInformation.i(), hasPositionInformation.j());
        BackgroundStyles.a(a, 0, this.f20187b, stylingData.f20190b, componentContext, rect);
        return Layout.a(componentContext, component).a(DrawableReference.b().a(BackgroundStyles.a(a, 0, -1, -1, this.f20188c, componentContext, rect, stylingData.f20190b, this.f20187b, GraphQLStorySeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE)).b()).e(0, rect.left).e(1, rect.top).e(2, rect.right).e(3, rect.bottom).j();
    }

    public static PhotosFeedBackgroundComponentSpec m23324a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFeedBackgroundComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20185e) {
                PhotosFeedBackgroundComponentSpec photosFeedBackgroundComponentSpec;
                if (a2 != null) {
                    photosFeedBackgroundComponentSpec = (PhotosFeedBackgroundComponentSpec) a2.a(f20185e);
                } else {
                    photosFeedBackgroundComponentSpec = f20184d;
                }
                if (photosFeedBackgroundComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23325b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20185e, b3);
                        } else {
                            f20184d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFeedBackgroundComponentSpec;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
