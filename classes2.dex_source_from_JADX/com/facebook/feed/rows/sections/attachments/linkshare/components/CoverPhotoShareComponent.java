package com.facebook.feed.rows.sections.attachments.linkshare.components;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools$SynchronizedPool;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ClickEvent;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetchZeroIndicatorParams */
public class CoverPhotoShareComponent<E extends HasFeedListType & HasInvalidate & HasPersistentState & HasPrefetcher & HasRowKey> extends ComponentLifecycle {
    private static CoverPhotoShareComponent f24249d;
    private static final Object f24250e = new Object();
    private final CoverPhotoShareComponentSpec f24251b;
    public final Pools$SynchronizedPool<Builder> f24252c = new Pools$SynchronizedPool(2);

    private static CoverPhotoShareComponent m32594b(InjectorLike injectorLike) {
        return new CoverPhotoShareComponent(CoverPhotoShareComponentSpec.m32597a(injectorLike));
    }

    @Inject
    public CoverPhotoShareComponent(CoverPhotoShareComponentSpec coverPhotoShareComponentSpec) {
        this.f24251b = coverPhotoShareComponentSpec;
    }

    public static CoverPhotoShareComponent m32591a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CoverPhotoShareComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24250e) {
                CoverPhotoShareComponent coverPhotoShareComponent;
                if (a2 != null) {
                    coverPhotoShareComponent = (CoverPhotoShareComponent) a2.mo818a(f24250e);
                } else {
                    coverPhotoShareComponent = f24249d;
                }
                if (coverPhotoShareComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32594b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24250e, b3);
                        } else {
                            f24249d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = coverPhotoShareComponent;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    protected final InternalNode mo3135b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f24251b.m32602a(componentContext, state.a, state.b);
    }

    private void m32592a(View view, Component component) {
        State state = (State) component;
        this.f24251b.m32603a(view, state.a, state.b);
    }

    public static EventHandler m32593b(ComponentContext componentContext) {
        return ComponentLifecycle.m28112a(componentContext, 1514683219, null);
    }

    public final void mo3134a(EventHandler eventHandler, Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.f20393a, new 1(this, eventHandler, obj), 634210041);
            return;
        }
        switch (eventHandler.f22608b) {
            case 1514683219:
                m32592a(((ClickEvent) obj).a, eventHandler.f22607a);
                return;
            default:
                return;
        }
    }
}
