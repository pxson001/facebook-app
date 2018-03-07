package com.facebook.feedplugins.pyml.rows.components;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.util.SparseArray;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout.Builder;
import com.facebook.components.ComponentLayout.ContainerBuilder;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.Container;
import com.facebook.components.InternalNode;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.glyph.GlyphColorizerDrawableReference;
import com.facebook.components.widget.Image;
import com.facebook.components.widget.SolidColor;
import com.facebook.components.widget.Text;
import com.facebook.feedplugins.pyml.EgoUnitUtil;
import com.facebook.feedplugins.pyml.rows.PageLiker;
import com.facebook.feedplugins.pyml.rows.PymlPagePartDefinition.Props;
import com.facebook.feedplugins.pyml.rows.PymlSpannableHeaderBuilder;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.SponsoredImpression;
import com.facebook.graphql.model.SuggestedPageUnitItem;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;

@LayoutSpec
@ContextScoped
/* compiled from: android_back_button_pressed */
public class PageYouMayLikeCardComponentSpec {
    public static final SparseArray<Object> f19745a = new SparseArray();
    private static PageYouMayLikeCardComponentSpec f19746g;
    private static final Object f19747h = new Object();
    public final PymlSpannableHeaderBuilder f19748b;
    private final GlyphColorizerDrawableReference f19749c;
    public final PageLiker f19750d;
    public final ScheduledExecutorService f19751e;
    public final GatekeeperStoreImpl f19752f;

    private static PageYouMayLikeCardComponentSpec m20014b(InjectorLike injectorLike) {
        return new PageYouMayLikeCardComponentSpec(PymlSpannableHeaderBuilder.b(injectorLike), GlyphColorizerDrawableReference.a(injectorLike), PageLiker.b(injectorLike), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public static PageYouMayLikeCardComponentSpec m20012a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageYouMayLikeCardComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19747h) {
                PageYouMayLikeCardComponentSpec pageYouMayLikeCardComponentSpec;
                if (a2 != null) {
                    pageYouMayLikeCardComponentSpec = (PageYouMayLikeCardComponentSpec) a2.a(f19747h);
                } else {
                    pageYouMayLikeCardComponentSpec = f19746g;
                }
                if (pageYouMayLikeCardComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m20014b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19747h, b3);
                        } else {
                            f19746g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pageYouMayLikeCardComponentSpec;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PageYouMayLikeCardComponentSpec(PymlSpannableHeaderBuilder pymlSpannableHeaderBuilder, GlyphColorizerDrawableReference glyphColorizerDrawableReference, PageLiker pageLiker, ScheduledExecutorService scheduledExecutorService, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f19748b = pymlSpannableHeaderBuilder;
        this.f19749c = glyphColorizerDrawableReference;
        this.f19750d = pageLiker;
        this.f19751e = scheduledExecutorService;
        this.f19752f = gatekeeperStoreImpl;
    }

    public final InternalNode m20015a(ComponentContext componentContext, Props props) {
        SponsoredImpression ab_ = props.a.ab_();
        boolean z = ab_ != null && ab_.k();
        ContainerBuilder G = Container.a(componentContext).C(2).G(2131362751);
        ContainerBuilder n = Container.a(componentContext).C(0).n(5, 2131428854).n(1, 2131430375).n(3, 2131430376);
        CharSequence a = EgoUnitUtil.a(componentContext, this.f19748b.a((ScrollableItemListFeedUnit) props.b.a, props.a), props.a);
        if (f19745a.size() == 0) {
            f19745a.put(2131558541, Boolean.valueOf(z));
        }
        return G.a(n.a(Text.a(componentContext).j(2).o(2131427402).a(false).q(2131430377).a(a).a(TruncateAt.END).c().a(z ? f19745a : null)).a(m20011a(componentContext, props.a)).b(1.0f)).a(m20010a(componentContext)).a(m20013b(componentContext, props)).j();
    }

    private static Builder m20011a(ComponentContext componentContext, SuggestedPageUnitItem suggestedPageUnitItem) {
        return Text.a(componentContext).o(2131427400).b(true).a(false).a(TruncateAt.END).l(2131362754).r(1).a(EgoUnitUtil.a(componentContext, suggestedPageUnitItem)).c().g(1, 2131430378);
    }

    private static Builder m20010a(ComponentContext componentContext) {
        return SolidColor.a(componentContext).h(2131362050).c().l(2131427379).a(4).c(4, 2131428854);
    }

    private Builder m20013b(ComponentContext componentContext, Props props) {
        return Image.a(componentContext).a(this.f19749c.a(componentContext).h(2130840276).j(props.a.m().O() ? 2131361917 : 2131361938).b()).c().g(8, 2131430374).a(2).a(ComponentLifecycle.a(componentContext, 761706327, null));
    }
}
