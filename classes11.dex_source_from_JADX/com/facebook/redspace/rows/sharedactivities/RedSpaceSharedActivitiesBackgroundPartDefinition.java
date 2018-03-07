package com.facebook.redspace.rows.sharedactivities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.support.annotation.DrawableRes;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
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
import com.facebook.multirow.api.SubParts;
import com.facebook.redspace.rows.RedSpaceEnvironment;
import com.facebook.redspace.rows.RedSpaceEnvironmentGenerated;
import com.facebook.widget.CustomViewUtils;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PROVIDER */
public class RedSpaceSharedActivitiesBackgroundPartDefinition extends BaseSinglePartDefinition<Void, State, RedSpaceEnvironment, View> {
    private static RedSpaceSharedActivitiesBackgroundPartDefinition f12231b;
    private static final Object f12232c = new Object();
    private final Resources f12233a;

    /* compiled from: PROVIDER */
    public class State {
        public final Drawable f12227a;
        public final int f12228b;
        public final int f12229c;
        public final int f12230d;

        public State(Drawable drawable, int i, int i2, int i3) {
            this.f12227a = drawable;
            this.f12228b = i;
            this.f12229c = i2;
            this.f12230d = i3;
        }
    }

    private static RedSpaceSharedActivitiesBackgroundPartDefinition m12693b(InjectorLike injectorLike) {
        return new RedSpaceSharedActivitiesBackgroundPartDefinition(ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m12694a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        int i;
        int i2;
        int i3;
        int i4;
        RedSpaceEnvironmentGenerated redSpaceEnvironmentGenerated = (RedSpaceEnvironmentGenerated) anyEnvironment;
        Object obj2 = 1;
        Object obj3 = redSpaceEnvironmentGenerated.hK_() != null ? 1 : null;
        if (redSpaceEnvironmentGenerated.h() == null) {
            obj2 = null;
        }
        int dimensionPixelSize = this.f12233a.getDimensionPixelSize(2131430548);
        int dimensionPixelSize2 = this.f12233a.getDimensionPixelSize(2131427594);
        if (obj3 != null) {
            i = 0;
        } else {
            i = dimensionPixelSize2;
        }
        if (obj2 != null) {
            i2 = 0;
        } else {
            i2 = dimensionPixelSize2;
        }
        if (obj3 != null) {
            i3 = dimensionPixelSize - dimensionPixelSize2;
        } else {
            i3 = dimensionPixelSize;
        }
        if (obj2 != null) {
            i4 = dimensionPixelSize - dimensionPixelSize2;
        } else {
            i4 = dimensionPixelSize;
        }
        return new State(m12691a(2130842981, i, i2), this.f12233a.getDimensionPixelSize(2131427645), i3, i4);
    }

    public final /* bridge */ /* synthetic */ void m12695a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1262443507);
        State state = (State) obj2;
        CustomViewUtils.b(view, state.f12227a);
        view.setPadding(state.f12228b, state.f12229c, state.f12228b, state.f12230d);
        Logger.a(8, EntryType.MARK_POP, 381953399, a);
    }

    @Inject
    public RedSpaceSharedActivitiesBackgroundPartDefinition(Resources resources) {
        this.f12233a = resources;
    }

    public static RedSpaceSharedActivitiesBackgroundPartDefinition m12692a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RedSpaceSharedActivitiesBackgroundPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12232c) {
                RedSpaceSharedActivitiesBackgroundPartDefinition redSpaceSharedActivitiesBackgroundPartDefinition;
                if (a2 != null) {
                    redSpaceSharedActivitiesBackgroundPartDefinition = (RedSpaceSharedActivitiesBackgroundPartDefinition) a2.a(f12232c);
                } else {
                    redSpaceSharedActivitiesBackgroundPartDefinition = f12231b;
                }
                if (redSpaceSharedActivitiesBackgroundPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12693b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12232c, b3);
                        } else {
                            f12231b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = redSpaceSharedActivitiesBackgroundPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @SuppressLint({"DeprecatedMethod"})
    private Drawable m12691a(@DrawableRes int i, int i2, int i3) {
        return new InsetDrawable(this.f12233a.getDrawable(i), 0, i2, 0, i3);
    }
}
