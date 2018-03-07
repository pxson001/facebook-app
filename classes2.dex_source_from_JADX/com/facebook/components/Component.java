package com.facebook.components;

import android.support.annotation.StyleRes;
import com.facebook.components.ComponentLifecycle.MountType;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: getFrameTime */
public abstract class Component<L extends ComponentLifecycle> {
    private static final AtomicInteger f22587a = new AtomicInteger(0);
    public final int f22588b = f22587a.getAndIncrement();
    public final L f22589c;
    private boolean f22590d = false;

    /* compiled from: getFrameTime */
    public abstract class Builder<L extends ComponentLifecycle> extends ResourceResolver {
        private ComponentContext f22702a;
        @StyleRes
        private int f22703b;

        public abstract Component<L> mo3296d();

        protected void mo3295a() {
            super.mo3295a();
            this.f22702a = null;
            this.f22703b = 0;
        }

        public final InternalNode m30662b() {
            return m30663c().mo3343j();
        }

        public final ComponentLayout$Builder m30663c() {
            return Layout.m30715a(this.f22702a, mo3296d(), this.f22703b);
        }

        protected final void m30661a(ComponentContext componentContext, @StyleRes int i, Component<L> component) {
            super.m30669a(componentContext, componentContext.f22550b);
            this.f22702a = componentContext;
            this.f22703b = i;
            if (i != 0) {
                ComponentLifecycle componentLifecycle = component.f22589c;
                componentContext.f22551c = i;
                componentLifecycle.mo3372d(componentContext, component);
                componentContext.f22551c = 0;
            }
        }
    }

    final synchronized void m30506a() {
        if (this.f22590d) {
            throw new IllegalStateException("Duplicate layout of a component: " + this);
        }
        this.f22590d = true;
    }

    protected final int m30508b() {
        return this.f22588b;
    }

    final Component<L> m30509c() {
        if (this.f22590d) {
            throw new IllegalStateException("Clone of component after layout started: " + this);
        }
        try {
            return (Component) super.clone();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    final void m30510d() {
        this.f22590d = false;
    }

    protected Component(L l) {
        this.f22589c = l;
    }

    public final L m30511e() {
        return this.f22589c;
    }

    public void mo3374a(Component<L> component) {
    }

    public static boolean m30503b(Component<?> component) {
        return component != null && (component.f22589c instanceof HostComponent);
    }

    static boolean m30504c(Component<?> component) {
        return (component == null || component.f22589c.mo3146f() == MountType.NONE) ? false : true;
    }

    static boolean m30505e(Component<?> component) {
        return component != null && component.f22589c.mo3146f() == MountType.VIEW;
    }
}
