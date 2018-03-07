package com.facebook.reaction.feed.styling;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: android.location.PROVIDERS_CHANGED */
public class ReactionPaginatedHScrollUnitBackgroundResolver {
    private static ReactionPaginatedHScrollUnitBackgroundResolver f19529b;
    private static final Object f19530c = new Object();
    private final AbstractFbErrorReporter f19531a;

    /* compiled from: android.location.PROVIDERS_CHANGED */
    /* synthetic */ class C21151 {
        static final /* synthetic */ int[] f19528a = new int[Position.values().length];

        static {
            try {
                f19528a[Position.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19528a[Position.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f19528a[Position.BOX.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f19528a[Position.MIDDLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private static ReactionPaginatedHScrollUnitBackgroundResolver m23469b(InjectorLike injectorLike) {
        return new ReactionPaginatedHScrollUnitBackgroundResolver((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public ReactionPaginatedHScrollUnitBackgroundResolver(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f19531a = abstractFbErrorReporter;
    }

    public final int m23470a(Position position) {
        if (position == null) {
            return 2130773613;
        }
        switch (C21151.f19528a[position.ordinal()]) {
            case 1:
                return 2130773609;
            case 2:
                return 2130773610;
            case 3:
                return 2130773612;
            case 4:
                return 2130773611;
            default:
                this.f19531a.b(getClass().getSimpleName(), "Unsupported reaction feedunit position: " + position.toString() + " passed.");
                return 2130773613;
        }
    }

    public static ReactionPaginatedHScrollUnitBackgroundResolver m23468a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionPaginatedHScrollUnitBackgroundResolver b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19530c) {
                ReactionPaginatedHScrollUnitBackgroundResolver reactionPaginatedHScrollUnitBackgroundResolver;
                if (a2 != null) {
                    reactionPaginatedHScrollUnitBackgroundResolver = (ReactionPaginatedHScrollUnitBackgroundResolver) a2.a(f19530c);
                } else {
                    reactionPaginatedHScrollUnitBackgroundResolver = f19529b;
                }
                if (reactionPaginatedHScrollUnitBackgroundResolver == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23469b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19530c, b3);
                        } else {
                            f19529b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionPaginatedHScrollUnitBackgroundResolver;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
