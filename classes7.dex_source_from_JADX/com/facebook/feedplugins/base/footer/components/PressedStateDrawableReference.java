package com.facebook.feedplugins.base.footer.components;

import android.graphics.drawable.Drawable;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.components.ComponentContext;
import com.facebook.components.reference.Reference;
import com.facebook.components.reference.ReferenceLifecycle;
import com.facebook.feed.widget.DownstateType;
import com.facebook.feedplugins.base.footer.components.PressedStateDrawableReferenceSpec.PressedStateBackgroundDrawable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: TAB_SWITCH */
public final class PressedStateDrawableReference extends ReferenceLifecycle<Drawable> {
    public static PressedStateDrawableReference f23009a = null;
    public static final SynchronizedPool<Builder> f23010b = new SynchronizedPool(2);
    private final PressedStateDrawableReferenceSpec f23011c = new PressedStateDrawableReferenceSpec();

    /* compiled from: TAB_SWITCH */
    public class Builder extends com.facebook.components.reference.Reference.Builder<Drawable> {
        private static String[] f23004b = new String[]{"downStateType"};
        private static int f23005c = 1;
        State f23006a;
        private BitSet f23007d = new BitSet(f23005c);

        public static void m25489a(Builder builder, ComponentContext componentContext, State state) {
            super.a(componentContext);
            builder.f23006a = state;
            builder.f23007d.clear();
        }

        public final Builder m25490a(DownstateType downstateType) {
            this.f23006a.f23008a = downstateType;
            this.f23007d.set(0);
            return this;
        }

        public final Reference<Drawable> m25492b() {
            int i = 0;
            if (this.f23007d == null || this.f23007d.nextClearBit(0) >= f23005c) {
                State state = this.f23006a;
                m25491a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < f23005c) {
                if (!this.f23007d.get(i)) {
                    arrayList.add(f23004b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m25491a() {
            super.a();
            this.f23006a = null;
            PressedStateDrawableReference.f23010b.a(this);
        }
    }

    /* compiled from: TAB_SWITCH */
    class State extends Reference<Drawable> {
        DownstateType f23008a;

        public State() {
            super(PressedStateDrawableReference.m25494a());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            State state = (State) obj;
            if (this.f23008a != null) {
                if (this.f23008a.equals(state.f23008a)) {
                    return true;
                }
            } else if (state.f23008a == null) {
                return true;
            }
            return false;
        }
    }

    protected final void m25496a(ComponentContext componentContext, Object obj, Reference reference) {
        Drawable drawable = (Drawable) obj;
        if (((State) reference).f23008a == DownstateType.NEWSFEED_SHADOW) {
            PressedStateDrawableReferenceSpec.f23012a.a(drawable);
        } else {
            PressedStateDrawableReferenceSpec.f23013b.a(drawable);
        }
    }

    private PressedStateDrawableReference() {
    }

    public static synchronized PressedStateDrawableReference m25494a() {
        PressedStateDrawableReference pressedStateDrawableReference;
        synchronized (PressedStateDrawableReference.class) {
            if (f23009a == null) {
                f23009a = new PressedStateDrawableReference();
            }
            pressedStateDrawableReference = f23009a;
        }
        return pressedStateDrawableReference;
    }

    protected final Object m25495a(ComponentContext componentContext, Reference reference) {
        Drawable drawable;
        DownstateType downstateType = ((State) reference).f23008a;
        if (downstateType == DownstateType.NEWSFEED_SHADOW) {
            drawable = (Drawable) PressedStateDrawableReferenceSpec.f23012a.a();
        } else {
            drawable = (Drawable) PressedStateDrawableReferenceSpec.f23013b.a();
        }
        if (drawable == null) {
            drawable = new PressedStateBackgroundDrawable(componentContext, downstateType);
        }
        return drawable;
    }

    public static Builder m25493a(ComponentContext componentContext) {
        State state = new State();
        Builder builder = (Builder) f23010b.a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m25489a(builder, componentContext, state);
        return builder;
    }
}
