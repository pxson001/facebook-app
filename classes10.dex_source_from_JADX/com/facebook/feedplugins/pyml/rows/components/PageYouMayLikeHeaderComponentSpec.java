package com.facebook.feedplugins.pyml.rows.components;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout.Builder;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.widget.Image;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition;
import com.facebook.feedplugins.pyml.EgoUnitUtil;
import com.facebook.feedplugins.pyml.rows.PymlHeaderPartDefinition.Props;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@LayoutSpec
@ContextScoped
/* compiled from: android.webkit.WebSettings */
public class PageYouMayLikeHeaderComponentSpec<E extends HasContext & HasIsAsync & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey> {
    private static PageYouMayLikeHeaderComponentSpec f19794b;
    private static final Object f19795c = new Object();
    public final EgoUnitUtil f19796a;

    private static PageYouMayLikeHeaderComponentSpec m20045b(InjectorLike injectorLike) {
        return new PageYouMayLikeHeaderComponentSpec(EgoUnitUtil.b(injectorLike));
    }

    @Inject
    public PageYouMayLikeHeaderComponentSpec(EgoUnitUtil egoUnitUtil) {
        this.f19796a = egoUnitUtil;
    }

    public static PageYouMayLikeHeaderComponentSpec m20043a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageYouMayLikeHeaderComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19795c) {
                PageYouMayLikeHeaderComponentSpec pageYouMayLikeHeaderComponentSpec;
                if (a2 != null) {
                    pageYouMayLikeHeaderComponentSpec = (PageYouMayLikeHeaderComponentSpec) a2.a(f19795c);
                } else {
                    pageYouMayLikeHeaderComponentSpec = f19794b;
                }
                if (pageYouMayLikeHeaderComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m20045b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19795c, b3);
                        } else {
                            f19794b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageYouMayLikeHeaderComponentSpec;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static Builder m20042a(ComponentContext componentContext) {
        return Image.a(componentContext).h(2130840320).c().l(2131427600).p(2131427606).h(1, 9).h(3, 7).g(0, 2131427608).g(2, 2131427602).a(2).a(ComponentLifecycle.a(componentContext, 1125565395, null));
    }

    protected static void m20044a(View view, E e, Props props) {
        MenuButtonPartDefinition.a(view, (HasMenuButtonProvider) e, props.b);
    }
}
