package com.facebook.feed.inlinecomposer.multirow;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: mutate_reaction_ */
public class InlineComposerBottomBackgroundPartDefinition extends BaseSinglePartDefinition<Props, State, AnyEnvironment, View> {
    private static InlineComposerBottomBackgroundPartDefinition f13138b;
    private static final Object f13139c = new Object();
    public final Resources f13140a;

    /* compiled from: mutate_reaction_ */
    public class Props {
        public final int f13135a;
        public final boolean f13136b;
        public final boolean f13137c;

        public Props(int i, boolean z, boolean z2) {
            this.f13135a = i;
            this.f13136b = z;
            this.f13137c = z2;
        }
    }

    /* compiled from: mutate_reaction_ */
    public class State {
        public final Drawable f14576a;
        public final int f14577b;
        public final int f14578c;
        public final int f14579d;

        public State(Drawable drawable, int i, int i2, int i3) {
            this.f14576a = drawable;
            this.f14577b = i;
            this.f14578c = i2;
            this.f14579d = i3;
        }
    }

    private static InlineComposerBottomBackgroundPartDefinition m19349b(InjectorLike injectorLike) {
        return new InlineComposerBottomBackgroundPartDefinition(ResourcesMethodAutoProvider.m6510a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        int i = 0;
        int dimensionPixelSize = this.f13140a.getDimensionPixelSize(2131427594);
        Drawable a = m19347a(props.f13135a, dimensionPixelSize, props.f13136b);
        int dimensionPixelSize2 = props.f13137c ? 0 : this.f13140a.getDimensionPixelSize(2131427645);
        if (!props.f13137c) {
            i = this.f13140a.getDimensionPixelSize(2131427417);
        }
        return new State(a, dimensionPixelSize2, i, dimensionPixelSize + i);
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -465142528);
        State state = (State) obj2;
        view.setBackgroundDrawable(state.f14576a);
        view.setPadding(state.f14577b, state.f14578c, state.f14577b, state.f14579d);
        Logger.a(8, EntryType.MARK_POP, 632651239, a);
    }

    public static InlineComposerBottomBackgroundPartDefinition m19348a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineComposerBottomBackgroundPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13139c) {
                InlineComposerBottomBackgroundPartDefinition inlineComposerBottomBackgroundPartDefinition;
                if (a2 != null) {
                    inlineComposerBottomBackgroundPartDefinition = (InlineComposerBottomBackgroundPartDefinition) a2.mo818a(f13139c);
                } else {
                    inlineComposerBottomBackgroundPartDefinition = f13138b;
                }
                if (inlineComposerBottomBackgroundPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m19349b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f13139c, b3);
                        } else {
                            f13138b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineComposerBottomBackgroundPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public InlineComposerBottomBackgroundPartDefinition(Resources resources) {
        this.f13140a = resources;
    }

    private Drawable m19347a(int i, int i2, boolean z) {
        Drawable colorDrawable = new ColorDrawable(this.f13140a.getColor(i));
        if (z) {
            Drawable layerDrawable = new LayerDrawable(new Drawable[]{this.f13140a.getDrawable(2130839828), colorDrawable});
            layerDrawable.setLayerInset(1, 0, r9.getIntrinsicHeight(), 0, 0);
            colorDrawable = layerDrawable;
        }
        return new InsetDrawable(colorDrawable, 0, 0, 0, i2);
    }
}
