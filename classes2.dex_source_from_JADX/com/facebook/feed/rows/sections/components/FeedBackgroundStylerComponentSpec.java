package com.facebook.feed.rows.sections.components;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.ComponentLayout$Builder;
import com.facebook.components.Container;
import com.facebook.components.Layout;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.reference.DrawableReference;
import com.facebook.components.reference.Reference;
import com.facebook.feed.rows.styling.BackgroundAttributeResourceResolver;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundResourceResolver;
import com.facebook.feed.rows.styling.BackgroundStyler$Position;
import com.facebook.feed.rows.styling.BackgroundStyles;
import com.facebook.feed.rows.styling.BasePaddingStyleResolver;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.viewstate.UnseenStoryManager;
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
/* compiled from: id_backed_privacy_checkup_react/?checkup_id=%s */
public class FeedBackgroundStylerComponentSpec {
    private static FeedBackgroundStylerComponentSpec f20599d;
    private static final Object f20600e = new Object();
    private final BasePaddingStyleResolver f20601a;
    private final BackgroundResourceResolver f20602b;
    private final UnseenStoryManager f20603c;

    private static FeedBackgroundStylerComponentSpec m28347b(InjectorLike injectorLike) {
        return new FeedBackgroundStylerComponentSpec(DefaultPaddingStyleResolver.m19157a(injectorLike), BackgroundAttributeResourceResolver.m19150a(injectorLike), UnseenStoryManager.m19201a(injectorLike));
    }

    @Inject
    public FeedBackgroundStylerComponentSpec(BasePaddingStyleResolver basePaddingStyleResolver, BackgroundResourceResolver backgroundResourceResolver, UnseenStoryManager unseenStoryManager) {
        this.f20601a = basePaddingStyleResolver;
        this.f20602b = backgroundResourceResolver;
        this.f20603c = unseenStoryManager;
    }

    public static FeedBackgroundStylerComponentSpec m28346a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedBackgroundStylerComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20600e) {
                FeedBackgroundStylerComponentSpec feedBackgroundStylerComponentSpec;
                if (a2 != null) {
                    feedBackgroundStylerComponentSpec = (FeedBackgroundStylerComponentSpec) a2.mo818a(f20600e);
                } else {
                    feedBackgroundStylerComponentSpec = f20599d;
                }
                if (feedBackgroundStylerComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28347b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20600e, b3);
                        } else {
                            f20599d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = feedBackgroundStylerComponentSpec;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    protected final ComponentLayout m28348a(ComponentContext componentContext, Component<?> component, BackgroundStyler$Position backgroundStyler$Position, int i, StylingData stylingData, boolean z) {
        int i2;
        Rect rect = new Rect();
        BackgroundStyles.m26973a(backgroundStyler$Position, i, this.f20601a, stylingData.f19252b, (Context) componentContext, rect);
        Drawable a = BackgroundStyles.m26969a(backgroundStyler$Position, i, stylingData.f19253c, stylingData.f19254d, this.f20602b, componentContext, rect, stylingData.f19252b, this.f20601a, this.f20603c.m19203a(stylingData.f19251a));
        if (stylingData.f19251a != null && (stylingData.f19251a.m19804a() instanceof GraphQLStory)) {
            this.f20603c.m19204a(stylingData.f19251a, a);
        }
        Reference b = DrawableReference.m30717b().m30719a(a).mo3297b();
        Object obj = component != null ? 1 : null;
        ComponentLayout$Builder a2 = (obj == null || !z) ? Container.m30723a(componentContext).mo3315a((Component) component) : Layout.m30714a(componentContext, component);
        ComponentLayout$Builder a3 = a2.mo3312a(b);
        if (obj != null) {
            i2 = rect.left;
        } else {
            i2 = 0;
        }
        a3 = a3.mo3332e(6, i2);
        if (obj != null) {
            i2 = rect.top;
        } else {
            i2 = 0;
        }
        a3 = a3.mo3332e(1, i2);
        if (obj != null) {
            i2 = rect.right;
        } else {
            i2 = 0;
        }
        a3 = a3.mo3332e(7, i2);
        if (obj != null) {
            i2 = rect.bottom;
        } else {
            i2 = 0;
        }
        return a3.mo3332e(3, i2).mo3343j();
    }
}
