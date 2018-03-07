package com.facebook.feedplugins.loadingindicator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
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
import com.facebook.widget.ShimmerFrameLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friending_location */
public class ShimmeringStoryPartDefinition<T> extends MultiRowSinglePartDefinition<T, Void, HasPositionInformation, ShimmerFrameLayout> {
    public static final ViewType<ShimmerFrameLayout> f12901a = new C13431();
    private static ShimmeringStoryPartDefinition f12902c;
    private static final Object f12903d = new Object();
    private final BackgroundPartDefinition f12904b;

    /* compiled from: friending_location */
    final class C13431 extends ViewType<ShimmerFrameLayout> {
        C13431() {
        }

        public final View m14650a(Context context) {
            return ShimmeringStoryPartDefinition.m14652a(context, null);
        }
    }

    private static ShimmeringStoryPartDefinition m14653b(InjectorLike injectorLike) {
        return new ShimmeringStoryPartDefinition(BackgroundPartDefinition.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m14656a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1909087845);
        ((ShimmerFrameLayout) view).b();
        Logger.a(8, EntryType.MARK_POP, 1580047661, a);
    }

    public final void m14658b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((ShimmerFrameLayout) view).c();
    }

    @Inject
    public ShimmeringStoryPartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f12904b = backgroundPartDefinition;
    }

    public static ShimmerFrameLayout m14652a(Context context, @Nullable ViewGroup viewGroup) {
        return (ShimmerFrameLayout) LayoutInflater.from(context).inflate(2130907080, viewGroup, false);
    }

    public final ViewType<ShimmerFrameLayout> m14654a() {
        return f12901a;
    }

    public final boolean m14657a(T t) {
        return true;
    }

    public final Object m14655a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f12904b, LoadingStory.f12895a);
        return null;
    }

    public static ShimmeringStoryPartDefinition m14651a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ShimmeringStoryPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12903d) {
                ShimmeringStoryPartDefinition shimmeringStoryPartDefinition;
                if (a2 != null) {
                    shimmeringStoryPartDefinition = (ShimmeringStoryPartDefinition) a2.a(f12903d);
                } else {
                    shimmeringStoryPartDefinition = f12902c;
                }
                if (shimmeringStoryPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14653b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12903d, b3);
                        } else {
                            f12902c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = shimmeringStoryPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
