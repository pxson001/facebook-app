package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.photosfeed.PhotosFeedBackgroundPartDefinition.StylingData;
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
/* compiled from: accent_color */
public class PhotosFeedBackgroundComponent extends ComponentLifecycle {
    public static final SynchronizedPool<Builder> f20180b = new SynchronizedPool(2);
    private static PhotosFeedBackgroundComponent f20181d;
    private static final Object f20182e = new Object();
    private final PhotosFeedBackgroundComponentSpec f20183c;

    /* compiled from: accent_color */
    public class Builder extends com.facebook.components.Component.Builder<PhotosFeedBackgroundComponent> {
        State f20172a;
        private String[] f20173b = new String[]{"delegate", "stylingData", "environment"};
        private int f20174c = 3;
        private BitSet f20175d = new BitSet(this.f20174c);

        public static void m23313a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f20172a = state;
            builder.f20175d.clear();
        }

        public final Builder m23314a(Component<?> component) {
            this.f20172a.f20176a = component;
            this.f20175d.set(0);
            return this;
        }

        public final Builder m23316a(StylingData stylingData) {
            this.f20172a.f20177b = stylingData;
            this.f20175d.set(1);
            return this;
        }

        public final Builder m23315a(HasPositionInformation hasPositionInformation) {
            this.f20172a.f20178c = hasPositionInformation;
            this.f20175d.set(2);
            return this;
        }

        public final Component<PhotosFeedBackgroundComponent> m23318d() {
            int i = 0;
            if (this.f20175d == null || this.f20175d.nextClearBit(0) >= this.f20174c) {
                State state = this.f20172a;
                m23317a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f20174c) {
                if (!this.f20175d.get(i)) {
                    arrayList.add(this.f20173b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m23317a() {
            super.a();
            this.f20172a = null;
            PhotosFeedBackgroundComponent.f20180b.a(this);
        }
    }

    /* compiled from: accent_color */
    public class State extends Component<PhotosFeedBackgroundComponent> implements Cloneable {
        Component<?> f20176a;
        StylingData f20177b;
        HasPositionInformation f20178c;
        final /* synthetic */ PhotosFeedBackgroundComponent f20179d;

        public State(PhotosFeedBackgroundComponent photosFeedBackgroundComponent) {
            this.f20179d = photosFeedBackgroundComponent;
            super(photosFeedBackgroundComponent);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            State state = (State) obj;
            if (this.b == state.b) {
                return true;
            }
            if (this.f20176a == null ? state.f20176a != null : !this.f20176a.equals(state.f20176a)) {
                return false;
            }
            if (this.f20177b == null ? state.f20177b != null : !this.f20177b.equals(state.f20177b)) {
                return false;
            }
            if (this.f20178c != null) {
                if (this.f20178c.equals(state.f20178c)) {
                    return true;
                }
            } else if (state.f20178c == null) {
                return true;
            }
            return false;
        }
    }

    private static PhotosFeedBackgroundComponent m23320b(InjectorLike injectorLike) {
        return new PhotosFeedBackgroundComponent(PhotosFeedBackgroundComponentSpec.m23324a(injectorLike));
    }

    @Inject
    public PhotosFeedBackgroundComponent(PhotosFeedBackgroundComponentSpec photosFeedBackgroundComponentSpec) {
        this.f20183c = photosFeedBackgroundComponentSpec;
    }

    public static PhotosFeedBackgroundComponent m23319a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFeedBackgroundComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20182e) {
                PhotosFeedBackgroundComponent photosFeedBackgroundComponent;
                if (a2 != null) {
                    photosFeedBackgroundComponent = (PhotosFeedBackgroundComponent) a2.a(f20182e);
                } else {
                    photosFeedBackgroundComponent = f20181d;
                }
                if (photosFeedBackgroundComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23320b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20182e, b3);
                        } else {
                            f20181d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFeedBackgroundComponent;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Builder m23321a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) f20180b.a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m23313a(builder, componentContext, 0, state);
        return builder;
    }

    protected final InternalNode m23323b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f20183c.m23326a(componentContext, state.f20176a, state.f20177b, state.f20178c);
    }

    public final void m23322a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ PhotosFeedBackgroundComponent f20171c;

                public void run() {
                    this.f20171c.a(eventHandler, obj);
                }
            }, -63087058);
        }
    }
}
