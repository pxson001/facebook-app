package com.facebook.redspace.rows.inlinecomposer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.DrawableRes;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerEnvironment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PUBLISHER_BAR */
public class InlineComposerPromptBackgroundPartDefinition extends BaseSinglePartDefinition<Props, State, InlineComposerEnvironment, View> {
    private static InlineComposerPromptBackgroundPartDefinition f12224b;
    private static final Object f12225c = new Object();
    private final Resources f12226a;

    /* compiled from: PUBLISHER_BAR */
    public class Props {
        @DrawableRes
        public final int f12217a;
        public final boolean f12218b;
        public final boolean f12219c;
    }

    /* compiled from: PUBLISHER_BAR */
    public class State {
        public final Drawable f12220a;
        public final int f12221b;
        public final int f12222c;
        public final int f12223d;

        public State(Drawable drawable, int i, int i2, int i3) {
            this.f12220a = drawable;
            this.f12221b = i;
            this.f12222c = i2;
            this.f12223d = i3;
        }
    }

    private static InlineComposerPromptBackgroundPartDefinition m12688b(InjectorLike injectorLike) {
        return new InlineComposerPromptBackgroundPartDefinition(ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m12689a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        int i;
        Props props = (Props) obj;
        InlineComposerEnvironment inlineComposerEnvironment = (InlineComposerEnvironment) anyEnvironment;
        int i2 = 0;
        int dimensionPixelSize = this.f12226a.getDimensionPixelSize(2131427594);
        if (inlineComposerEnvironment.t) {
            i = 0;
        } else {
            i = dimensionPixelSize;
        }
        if (inlineComposerEnvironment.s) {
            dimensionPixelSize = 0;
        }
        Drawable a = m12686a(props.f12217a, i, dimensionPixelSize, props.f12218b);
        int dimensionPixelSize2 = props.f12219c ? 0 : this.f12226a.getDimensionPixelSize(2131427645);
        if (!props.f12219c) {
            i2 = this.f12226a.getDimensionPixelSize(2131427417);
        }
        return new State(a, dimensionPixelSize2, i + i2, i2 + dimensionPixelSize);
    }

    public static InlineComposerPromptBackgroundPartDefinition m12687a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineComposerPromptBackgroundPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12225c) {
                InlineComposerPromptBackgroundPartDefinition inlineComposerPromptBackgroundPartDefinition;
                if (a2 != null) {
                    inlineComposerPromptBackgroundPartDefinition = (InlineComposerPromptBackgroundPartDefinition) a2.a(f12225c);
                } else {
                    inlineComposerPromptBackgroundPartDefinition = f12224b;
                }
                if (inlineComposerPromptBackgroundPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12688b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12225c, b3);
                        } else {
                            f12224b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineComposerPromptBackgroundPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public InlineComposerPromptBackgroundPartDefinition(Resources resources) {
        this.f12226a = resources;
    }

    private Drawable m12686a(@DrawableRes int i, int i2, int i3, boolean z) {
        Drawable drawable = this.f12226a.getDrawable(i);
        if (!z) {
            return new InsetDrawable(drawable, 0, i2, 0, i3);
        }
        Drawable layerDrawable = new LayerDrawable(new Drawable[]{this.f12226a.getDrawable(2130839829), drawable});
        layerDrawable.setLayerInset(1, 0, 0, 0, r3.getIntrinsicHeight());
        return new InsetDrawable(layerDrawable, 0, i2, 0, i3);
    }
}
