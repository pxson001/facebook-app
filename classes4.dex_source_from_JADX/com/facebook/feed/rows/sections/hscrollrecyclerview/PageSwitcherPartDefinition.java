package com.facebook.feed.rows.sections.hscrollrecyclerview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.widget.hscrollrecyclerview.SnapRecyclerView;
import com.facebook.widget.hscrollrecyclerview.SnapRecyclerView.Direction;
import javax.annotation.Nullable;

@ContextScoped
/* compiled from: onInfo MEDIA_INFO_BUFFERING_END */
public class PageSwitcherPartDefinition extends BaseSinglePartDefinition<Controller, Void, AnyEnvironment, View> {
    private static PageSwitcherPartDefinition f6181a;
    private static final Object f6182b = new Object();

    /* compiled from: onInfo MEDIA_INFO_BUFFERING_END */
    public class Controller {
        @Nullable
        public View f6360a;

        public final void m6834a() {
            if (this.f6360a instanceof ViewPager) {
                ViewPager viewPager = (ViewPager) this.f6360a;
                viewPager.setCurrentItem(viewPager.k + 1);
            } else if (this.f6360a instanceof SnapRecyclerView) {
                ((SnapRecyclerView) this.f6360a).m14575a(Direction.NEXT);
            }
        }
    }

    private static PageSwitcherPartDefinition m6657a() {
        return new PageSwitcherPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m6659a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 369225587);
        ((Controller) obj).f6360a = view;
        Logger.a(8, EntryType.MARK_POP, 1505137008, a);
    }

    public final void m6660b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((Controller) obj).f6360a = null;
    }

    public static PageSwitcherPartDefinition m6658a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PageSwitcherPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f6182b) {
                PageSwitcherPartDefinition pageSwitcherPartDefinition;
                if (a3 != null) {
                    pageSwitcherPartDefinition = (PageSwitcherPartDefinition) a3.a(f6182b);
                } else {
                    pageSwitcherPartDefinition = f6181a;
                }
                if (pageSwitcherPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m6657a();
                        if (a3 != null) {
                            a3.a(f6182b, a2);
                        } else {
                            f6181a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = pageSwitcherPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
