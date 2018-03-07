package com.facebook.components.fb.fresco;

import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.Pools$SynchronizedPool;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.ComponentLifecycle.MountType;
import com.facebook.components.ComponentsPools;
import com.facebook.components.Diff;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.Size;
import com.facebook.components.fresco.GenericReferenceDraweeHierarchy;
import com.facebook.components.reference.Reference;
import com.facebook.drawee.components.DraweeEventTracker.Event;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.drawee.view.FbDraweeHolder;
import com.facebook.drawee.view.FbDraweeHolder.1;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: full_number */
public final class FbFrescoComponent extends ComponentLifecycle {
    public static FbFrescoComponent f22868b = null;
    public static final Pools$SynchronizedPool<Builder> f22869c = new Pools$SynchronizedPool(2);
    private final FbFrescoComponentSpec f22870d = new FbFrescoComponentSpec();

    /* compiled from: full_number */
    public class State extends Component<FbFrescoComponent> implements Cloneable {
        float f22871a = 1.0f;
        DraweeController f22872b;
        Reference<Drawable> f22873c;
        ScalingUtils$ScaleType f22874d;
        RoundingParams f22875e;
        ScalingUtils$ScaleType f22876f;
        public PointF f22877g;

        public State() {
            super(FbFrescoComponent.m30976j());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            State state = (State) obj;
            if (this.f22588b == state.f22588b) {
                return true;
            }
            if (Float.compare(this.f22871a, state.f22871a) != 0) {
                return false;
            }
            if (this.f22872b == null ? state.f22872b != null : !this.f22872b.equals(state.f22872b)) {
                return false;
            }
            if (this.f22873c == null ? state.f22873c != null : !this.f22873c.equals(state.f22873c)) {
                return false;
            }
            if (this.f22874d == null ? state.f22874d != null : !this.f22874d.equals(state.f22874d)) {
                return false;
            }
            if (this.f22875e == null ? state.f22875e != null : !this.f22875e.equals(state.f22875e)) {
                return false;
            }
            if (this.f22876f == null ? state.f22876f != null : !this.f22876f.equals(state.f22876f)) {
                return false;
            }
            if (this.f22877g != null) {
                if (this.f22877g.equals(state.f22877g)) {
                    return true;
                }
            } else if (state.f22877g == null) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: full_number */
    public class Builder extends com.facebook.components.Component.Builder<FbFrescoComponent> {
        private static String[] f22878b = new String[]{"controller"};
        private static int f22879c = 1;
        public State f22880a;
        private BitSet f22881d = new BitSet(f22879c);

        public static void m30990a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.m30661a(componentContext, i, state);
            builder.f22880a = state;
            builder.f22881d.clear();
        }

        public final Builder m30996b(float f) {
            this.f22880a.f22871a = f;
            return this;
        }

        public final Builder m30994a(DraweeController draweeController) {
            this.f22880a.f22872b = draweeController;
            this.f22881d.set(0);
            return this;
        }

        public final Builder m30991a(Reference<Drawable> reference) {
            this.f22880a.f22873c = reference;
            return this;
        }

        public final Builder m30992a(ScalingUtils$ScaleType scalingUtils$ScaleType) {
            this.f22880a.f22874d = scalingUtils$ScaleType;
            return this;
        }

        public final Builder m30993a(RoundingParams roundingParams) {
            this.f22880a.f22875e = roundingParams;
            return this;
        }

        public final Builder m30997b(ScalingUtils$ScaleType scalingUtils$ScaleType) {
            this.f22880a.f22876f = scalingUtils$ScaleType;
            return this;
        }

        public final Component<FbFrescoComponent> mo3296d() {
            int i = 0;
            if (this.f22881d == null || this.f22881d.nextClearBit(0) >= f22879c) {
                Component component = this.f22880a;
                mo3295a();
                return component;
            }
            List arrayList = new ArrayList();
            while (i < f22879c) {
                if (!this.f22881d.get(i)) {
                    arrayList.add(f22878b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void mo3295a() {
            super.mo3295a();
            this.f22880a = null;
            FbFrescoComponent.f22869c.mo741a(this);
        }
    }

    private FbFrescoComponent() {
    }

    public static synchronized FbFrescoComponent m30976j() {
        FbFrescoComponent fbFrescoComponent;
        synchronized (FbFrescoComponent.class) {
            if (f22868b == null) {
                f22868b = new FbFrescoComponent();
            }
            fbFrescoComponent = f22868b;
        }
        return fbFrescoComponent;
    }

    public static Builder m30975a(ComponentContext componentContext) {
        State state = new State();
        Builder builder = (Builder) f22869c.mo740a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m30990a(builder, componentContext, 0, state);
        return builder;
    }

    protected final boolean mo3144c() {
        return true;
    }

    protected final void mo3141a(ComponentContext componentContext, InternalNode internalNode, int i, int i2, Size size, Component component) {
        FbFrescoComponentSpec.m30989a(i, i2, size, ((State) component).f22871a);
    }

    public final MountType mo3146f() {
        return MountType.DRAWABLE;
    }

    protected final Object mo3145e(ComponentContext componentContext, Object obj, Component component) {
        State state = (State) component;
        return FbFrescoComponentSpec.m30988a(componentContext, (FbDraweeDrawable) obj, state.f22873c, state.f22874d, state.f22875e, state.f22876f, state.f22877g);
    }

    protected final void mo3367h(ComponentContext componentContext, Object obj, Component component) {
        DraweeHolder draweeHolder = ((FbDraweeDrawable) obj).f23026c;
        if (!draweeHolder.f23031d) {
            draweeHolder.f14187g.m20546a(Event.ON_SCHEDULE_CLEAR_CONTROLLER);
            Handler handler = FbDraweeHolder.f23028a;
            if (draweeHolder.f23029b == null) {
                draweeHolder.f23029b = new 1(draweeHolder);
            }
            HandlerDetour.b(handler, draweeHolder.f23029b, 80, 1852670393);
            draweeHolder.f23031d = true;
        }
    }

    protected final void mo3366g(ComponentContext componentContext, Object obj, Component component) {
        ((FbDraweeDrawable) obj).m31156a(((State) component).f22872b);
    }

    protected final void mo3150f(ComponentContext componentContext, Object obj, Component component) {
        FbDraweeDrawable fbDraweeDrawable = (FbDraweeDrawable) obj;
        fbDraweeDrawable.m31156a(null);
        fbDraweeDrawable.f23026c.m20523d();
        fbDraweeDrawable.mo2740a(fbDraweeDrawable.f23025a);
        GenericReferenceDraweeHierarchy genericReferenceDraweeHierarchy = (GenericReferenceDraweeHierarchy) fbDraweeDrawable.m31157d();
        if (genericReferenceDraweeHierarchy.f23017c != null) {
            Reference.m30532a(genericReferenceDraweeHierarchy.f23015a, genericReferenceDraweeHierarchy.f23021g, genericReferenceDraweeHierarchy.f23017c);
            genericReferenceDraweeHierarchy.f23017c = null;
            genericReferenceDraweeHierarchy.f23021g = null;
            genericReferenceDraweeHierarchy.f23016b.m20608b(null);
        }
        if (genericReferenceDraweeHierarchy.f23018d != null) {
            Reference.m30532a(genericReferenceDraweeHierarchy.f23015a, genericReferenceDraweeHierarchy.f23022h, genericReferenceDraweeHierarchy.f23018d);
            genericReferenceDraweeHierarchy.f23022h = null;
            genericReferenceDraweeHierarchy.f23018d = null;
            genericReferenceDraweeHierarchy.f23016b.m20613d(null);
        }
        if (genericReferenceDraweeHierarchy.f23019e != null) {
            Reference.m30532a(genericReferenceDraweeHierarchy.f23015a, genericReferenceDraweeHierarchy.f23023i, genericReferenceDraweeHierarchy.f23019e);
            genericReferenceDraweeHierarchy.f23023i = null;
            genericReferenceDraweeHierarchy.f23019e = null;
            genericReferenceDraweeHierarchy.f23016b.m20611c(null);
        }
        if (genericReferenceDraweeHierarchy.f23020f != null) {
            Reference.m30532a(genericReferenceDraweeHierarchy.f23015a, genericReferenceDraweeHierarchy.f23024j, genericReferenceDraweeHierarchy.f23020f);
            genericReferenceDraweeHierarchy.f23024j = null;
            genericReferenceDraweeHierarchy.f23020f = null;
            genericReferenceDraweeHierarchy.f23016b.m20614e(null);
        }
        genericReferenceDraweeHierarchy.f23015a = null;
    }

    public final boolean mo3148h() {
        return true;
    }

    public final boolean mo3143b(Component component, Component component2) {
        State state = (State) component;
        State state2 = (State) component2;
        Diff a = ComponentLifecycle.m28111a(state.f22873c, state2.f22873c);
        Diff a2 = ComponentLifecycle.m28111a(state.f22875e, state2.f22875e);
        Diff a3 = ComponentLifecycle.m28111a(state.f22876f, state2.f22876f);
        boolean z = Reference.m30533a((Reference) a.a, (Reference) a.b) ? true : ((a3.b == null || ((ScalingUtils$ScaleType) a3.b).equals(a3.a)) && (a3.a == null || a3.b != null)) ? !(a2.b == null || ((RoundingParams) a2.b).equals(a2.a)) || (a2.a != null && a2.b == null) : true;
        boolean z2 = z;
        ComponentsPools.m30523a(a);
        ComponentsPools.m30523a(a2);
        ComponentsPools.m30523a(a3);
        return z2;
    }

    public final boolean mo3368i() {
        return true;
    }

    public final void mo3134a(EventHandler eventHandler, Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.f20393a, new 1(this, eventHandler, obj), -1205748595);
        }
    }
}
