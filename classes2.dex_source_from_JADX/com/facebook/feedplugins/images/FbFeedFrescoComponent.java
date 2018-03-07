package com.facebook.feedplugins.images;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import android.support.v4.util.Pools$SynchronizedPool;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.reference.Reference;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: image_loading_state */
public class FbFeedFrescoComponent<E extends HasFeedListType & HasPersistentState & HasPrefetcher & HasRowKey> extends ComponentLifecycle {
    private static FbFeedFrescoComponent f20416d;
    private static final Object f20417e = new Object();
    private final FbFeedFrescoComponentSpec f20418b;
    public final Pools$SynchronizedPool<Builder> f20419c = new Pools$SynchronizedPool(2);

    /* compiled from: image_loading_state */
    public class State extends Component<FbFeedFrescoComponent> implements Cloneable {
        FeedProps<? extends CacheableEntity> f22840a;
        Uri f22841b;
        CallerContext f22842c;
        E f22843d;
        boolean f22844e = false;
        public Reference<Drawable> f22845f;
        ScalingUtils$ScaleType f22846g;
        RoundingParams f22847h;
        ScalingUtils$ScaleType f22848i;
        public PointF f22849j;
        float f22850k = 1.0f;
        final /* synthetic */ FbFeedFrescoComponent f22851l;

        public State(FbFeedFrescoComponent fbFeedFrescoComponent) {
            this.f22851l = fbFeedFrescoComponent;
            super(fbFeedFrescoComponent);
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
            if (this.f22840a == null ? state.f22840a != null : !this.f22840a.equals(state.f22840a)) {
                return false;
            }
            if (this.f22841b == null ? state.f22841b != null : !this.f22841b.equals(state.f22841b)) {
                return false;
            }
            if (this.f22842c == null ? state.f22842c != null : !this.f22842c.equals(state.f22842c)) {
                return false;
            }
            if (this.f22843d == null ? state.f22843d != null : !this.f22843d.equals(state.f22843d)) {
                return false;
            }
            if (this.f22844e != state.f22844e) {
                return false;
            }
            if (this.f22845f == null ? state.f22845f != null : !this.f22845f.equals(state.f22845f)) {
                return false;
            }
            if (this.f22846g == null ? state.f22846g != null : !this.f22846g.equals(state.f22846g)) {
                return false;
            }
            if (this.f22847h == null ? state.f22847h != null : !this.f22847h.equals(state.f22847h)) {
                return false;
            }
            if (this.f22848i == null ? state.f22848i != null : !this.f22848i.equals(state.f22848i)) {
                return false;
            }
            if (this.f22849j == null ? state.f22849j != null : !this.f22849j.equals(state.f22849j)) {
                return false;
            }
            if (Float.compare(this.f22850k, state.f22850k) != 0) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: image_loading_state */
    public class Builder extends com.facebook.components.Component.Builder<FbFeedFrescoComponent> {
        public State f22852a;
        final /* synthetic */ FbFeedFrescoComponent f22853b;
        private String[] f22854c = new String[]{"feedProps", "imageUri", "callerContext", "environment"};
        private int f22855d = 4;
        private BitSet f22856e = new BitSet(this.f22855d);

        public Builder(FbFeedFrescoComponent fbFeedFrescoComponent) {
            this.f22853b = fbFeedFrescoComponent;
        }

        public static void m30955a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.m30661a(componentContext, i, state);
            builder.f22852a = state;
            builder.f22856e.clear();
        }

        public final Builder m30959a(FeedProps<? extends CacheableEntity> feedProps) {
            this.f22852a.f22840a = feedProps;
            this.f22856e.set(0);
            return this;
        }

        public final Builder m30956a(Uri uri) {
            this.f22852a.f22841b = uri;
            this.f22856e.set(1);
            return this;
        }

        public final Builder m30957a(CallerContext callerContext) {
            this.f22852a.f22842c = callerContext;
            this.f22856e.set(2);
            return this;
        }

        public final Builder m30958a(E e) {
            this.f22852a.f22843d = e;
            this.f22856e.set(3);
            return this;
        }

        public final Builder m30960a(boolean z) {
            this.f22852a.f22844e = z;
            return this;
        }

        public final Builder m30962b(float f) {
            this.f22852a.f22850k = f;
            return this;
        }

        public final Component<FbFeedFrescoComponent> mo3296d() {
            int i = 0;
            if (this.f22856e == null || this.f22856e.nextClearBit(0) >= this.f22855d) {
                Component component = this.f22852a;
                mo3295a();
                return component;
            }
            List arrayList = new ArrayList();
            while (i < this.f22855d) {
                if (!this.f22856e.get(i)) {
                    arrayList.add(this.f22854c[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void mo3295a() {
            super.mo3295a();
            this.f22852a = null;
            this.f22853b.f20419c.mo741a(this);
        }
    }

    private static FbFeedFrescoComponent m28160b(InjectorLike injectorLike) {
        return new FbFeedFrescoComponent(FbFeedFrescoComponentSpec.m28166a(injectorLike));
    }

    public static FbFeedFrescoComponent m28159a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FbFeedFrescoComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20417e) {
                FbFeedFrescoComponent fbFeedFrescoComponent;
                if (a2 != null) {
                    fbFeedFrescoComponent = (FbFeedFrescoComponent) a2.mo818a(f20417e);
                } else {
                    fbFeedFrescoComponent = f20416d;
                }
                if (fbFeedFrescoComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28160b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20417e, b3);
                        } else {
                            f20416d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = fbFeedFrescoComponent;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public FbFeedFrescoComponent(FbFeedFrescoComponentSpec fbFeedFrescoComponentSpec) {
        this.f20418b = fbFeedFrescoComponentSpec;
    }

    public final Builder m28161a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) this.f20419c.mo740a();
        if (builder == null) {
            builder = new Builder(this);
        }
        Builder.m30955a(builder, componentContext, 0, state);
        return builder;
    }

    protected final InternalNode mo3135b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f20418b.m28168a(componentContext, state.f22840a, state.f22841b, state.f22842c, state.f22843d, state.f22844e, state.f22845f, state.f22846g, state.f22847h, state.f22848i, state.f22849j, state.f22850k);
    }

    public final void mo3134a(EventHandler eventHandler, Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.f20393a, new 1(this, eventHandler, obj), -1985128392);
        }
    }
}
