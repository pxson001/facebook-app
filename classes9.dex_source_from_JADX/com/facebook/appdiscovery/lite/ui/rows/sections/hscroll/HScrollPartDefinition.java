package com.facebook.appdiscovery.lite.ui.rows.sections.hscroll;

import android.content.Context;
import com.facebook.appdiscovery.lite.ui.rows.sections.relatedapps.RelatedAppsGroupPartDefinition.C03841;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.injectable.DisplayUtil;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.pager.PagerRowType;
import com.facebook.feed.rows.pager.PersistentPagerPartDefinition;
import com.facebook.feed.rows.pager.RowViewPager;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Callbacks;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Props;
import com.facebook.feed.rows.styling.BasePaddingStyleResolver;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: selected_payment_method */
public class HScrollPartDefinition<M, E extends HasPersistentState & HasPositionInformation> extends MultiRowSinglePartDefinition<Props<M, E>, Void, E, RowViewPager> {
    private static final PaddingStyle f4169a = PaddingStyle.a;
    private static HScrollPartDefinition f4170f;
    private static final Object f4171g = new Object();
    private final Context f4172b;
    private final FeedRenderUtils f4173c;
    private final PersistentPagerPartDefinition<M, E> f4174d;
    private final BasePaddingStyleResolver f4175e;

    private static HScrollPartDefinition m4226b(InjectorLike injectorLike) {
        return new HScrollPartDefinition((Context) injectorLike.getInstance(Context.class), FeedRenderUtils.a(injectorLike), PersistentPagerPartDefinition.a(injectorLike), (BasePaddingStyleResolver) DefaultPaddingStyleResolver.a(injectorLike), DisplayUtil.a(injectorLike));
    }

    public final Object m4229a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final C03841 c03841 = (C03841) obj;
        subParts.a(this.f4174d, new Props(m4227c(c03841), 0, new Callbacks<M, E>(this) {
            final /* synthetic */ HScrollPartDefinition f4168b;

            public final SinglePartDefinitionWithViewType<M, ?, ? super E, ?> m4222a(int i) {
                return c03841.f4177b.f4182c;
            }

            public final M m4223b(int i) {
                return c03841.m4231a().get(i);
            }

            public final void m4224c(int i) {
            }

            public final int m4221a() {
                return c03841.m4231a().size();
            }
        }, c03841.f4176a.g(), c03841.f4176a));
        return null;
    }

    public final boolean m4230a(Object obj) {
        ImmutableList a = ((C03841) obj).m4231a();
        return (a == null || a.isEmpty()) ? false : true;
    }

    public static HScrollPartDefinition m4225a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HScrollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4171g) {
                HScrollPartDefinition hScrollPartDefinition;
                if (a2 != null) {
                    hScrollPartDefinition = (HScrollPartDefinition) a2.a(f4171g);
                } else {
                    hScrollPartDefinition = f4170f;
                }
                if (hScrollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m4226b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4171g, b3);
                        } else {
                            f4170f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = hScrollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public HScrollPartDefinition(Context context, FeedRenderUtils feedRenderUtils, PersistentPagerPartDefinition persistentPagerPartDefinition, BasePaddingStyleResolver basePaddingStyleResolver, DisplayUtil displayUtil) {
        this.f4172b = context;
        this.f4173c = feedRenderUtils;
        this.f4174d = persistentPagerPartDefinition;
        this.f4175e = basePaddingStyleResolver;
    }

    public final ViewType<RowViewPager> m4228a() {
        return PagerRowType.a;
    }

    private PageStyle m4227c(C03841 c03841) {
        return PageStyle.a((float) SizeUtil.c(c03841.f4177b.f4183d, c03841.f4177b.f4183d.getResources().getDimension(2131433194) - c03841.f4177b.f4183d.getResources().getDimension(2131433195)), this.f4173c.a(this.f4172b, this.f4175e.a(f4169a).d.a(1)));
    }
}
