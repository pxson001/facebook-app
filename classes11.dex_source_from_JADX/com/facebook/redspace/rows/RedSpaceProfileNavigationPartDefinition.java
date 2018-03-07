package com.facebook.redspace.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingPartDefinition;
import com.facebook.feed.rows.styling.PaddingPartDefinition.PaddingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.ui.RedSpaceProfileNavigationButton;
import com.facebook.ultralight.Inject;

@ContextScoped
/* compiled from: PYMA footer has NULL title */
public class RedSpaceProfileNavigationPartDefinition extends MultiRowSinglePartDefinition<Object, Void, RedSpaceEnvironment, RedSpaceProfileNavigationButton> {
    public static final ViewType<RedSpaceProfileNavigationButton> f12200a = new C14491();
    private static final PaddingStyle f12201b;
    private static RedSpaceProfileNavigationPartDefinition f12202d;
    private static final Object f12203e = new Object();
    private final PaddingPartDefinition f12204c;

    /* compiled from: PYMA footer has NULL title */
    final class C14491 extends ViewType<RedSpaceProfileNavigationButton> {
        C14491() {
        }

        public final View m12668a(Context context) {
            return new RedSpaceProfileNavigationButton(context);
        }
    }

    private static RedSpaceProfileNavigationPartDefinition m12671b(InjectorLike injectorLike) {
        return new RedSpaceProfileNavigationPartDefinition(PaddingPartDefinition.a(injectorLike));
    }

    public final Object m12673a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f12204c, new PaddingData(null, f12201b, Position.BOTTOM, 1));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m12674a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -843693397);
        m12670a(obj, (RedSpaceProfileNavigationButton) view);
        Logger.a(8, EntryType.MARK_POP, -380454873, a);
    }

    public final void m12676b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((RedSpaceProfileNavigationButton) view).m12778a();
    }

    static {
        Builder e = Builder.e();
        e.b = 4.0f;
        e = e;
        e.d = 12.0f;
        e = e;
        e.c = 6.0f;
        f12201b = e.i();
    }

    @Inject
    private RedSpaceProfileNavigationPartDefinition(PaddingPartDefinition paddingPartDefinition) {
        this.f12204c = paddingPartDefinition;
    }

    public final ViewType<RedSpaceProfileNavigationButton> m12672a() {
        return f12200a;
    }

    public final boolean m12675a(Object obj) {
        return obj instanceof RedSpaceFeedProfileFragmentModel;
    }

    public static RedSpaceProfileNavigationPartDefinition m12669a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RedSpaceProfileNavigationPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12203e) {
                RedSpaceProfileNavigationPartDefinition redSpaceProfileNavigationPartDefinition;
                if (a2 != null) {
                    redSpaceProfileNavigationPartDefinition = (RedSpaceProfileNavigationPartDefinition) a2.a(f12203e);
                } else {
                    redSpaceProfileNavigationPartDefinition = f12202d;
                }
                if (redSpaceProfileNavigationPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12671b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12203e, b3);
                        } else {
                            f12202d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = redSpaceProfileNavigationPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static void m12670a(Object obj, RedSpaceProfileNavigationButton redSpaceProfileNavigationButton) {
        redSpaceProfileNavigationButton.m12779a((RedSpaceFeedProfileFragmentModel) obj);
    }
}
