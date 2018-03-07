package com.facebook.components.reference;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.util.Pools$SynchronizedPool;
import com.facebook.components.ComponentContext;
import com.facebook.components.reference.DrawableResourcesCache.SimplePoolWithCount;
import com.facebook.components.reference.Reference.Builder;

/* compiled from: fullscreen_gallery_source */
public final class ResourceDrawableReference extends ReferenceLifecycle<Drawable> {
    private static ResourceDrawableReference f22857a;
    public static final Pools$SynchronizedPool<PropsBuilder> f22858b = new Pools$SynchronizedPool(2);
    private final DrawableResourcesCache f22859c = new DrawableResourcesCache();

    /* compiled from: fullscreen_gallery_source */
    class State extends Reference<Drawable> {
        int f22860a;

        protected State() {
            super(ResourceDrawableReference.m30965a());
        }

        public int hashCode() {
            return this.f22860a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            if (this.f22860a != ((State) obj).f22860a) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: fullscreen_gallery_source */
    public class PropsBuilder extends Builder<Drawable> {
        private State f22863a;

        public final void m30970a(ComponentContext componentContext, State state) {
            super.m30721a(componentContext);
            this.f22863a = state;
        }

        protected final void mo3295a() {
            super.mo3295a();
            this.f22863a = null;
            ResourceDrawableReference.f22858b.mo741a(this);
        }

        public final PropsBuilder m30972h(int i) {
            this.f22863a.f22860a = i;
            return this;
        }

        public final Reference<Drawable> mo3297b() {
            Reference reference = this.f22863a;
            mo3295a();
            return reference;
        }
    }

    protected final void mo3365a(ComponentContext componentContext, Object obj, Reference reference) {
        Drawable drawable = (Drawable) obj;
        DrawableResourcesCache drawableResourcesCache = this.f22859c;
        int i = ((State) reference).f22860a;
        SimplePoolWithCount simplePoolWithCount = (SimplePoolWithCount) drawableResourcesCache.f22861a.m4432a(Integer.valueOf(i));
        if (simplePoolWithCount == null) {
            simplePoolWithCount = new SimplePoolWithCount(10);
            drawableResourcesCache.f22861a.m4433a(Integer.valueOf(i), (Object) simplePoolWithCount);
        }
        simplePoolWithCount.mo741a(drawable);
    }

    private ResourceDrawableReference() {
    }

    public static synchronized ResourceDrawableReference m30965a() {
        ResourceDrawableReference resourceDrawableReference;
        synchronized (ResourceDrawableReference.class) {
            if (f22857a == null) {
                f22857a = new ResourceDrawableReference();
            }
            resourceDrawableReference = f22857a;
        }
        return resourceDrawableReference;
    }

    public static PropsBuilder m30964a(ComponentContext componentContext) {
        State state = new State();
        PropsBuilder propsBuilder = (PropsBuilder) f22858b.mo740a();
        if (propsBuilder == null) {
            propsBuilder = new PropsBuilder();
        }
        propsBuilder.m30970a(componentContext, state);
        return propsBuilder;
    }

    protected final Object mo3151a(ComponentContext componentContext, Reference reference) {
        SimplePoolWithCount simplePoolWithCount;
        DrawableResourcesCache drawableResourcesCache = this.f22859c;
        int i = ((State) reference).f22860a;
        Resources resources = componentContext.getResources();
        SimplePoolWithCount simplePoolWithCount2 = (SimplePoolWithCount) drawableResourcesCache.f22861a.m4432a(Integer.valueOf(i));
        if (simplePoolWithCount2 == null) {
            simplePoolWithCount2 = new SimplePoolWithCount(10);
            drawableResourcesCache.f22861a.m4433a(Integer.valueOf(i), (Object) simplePoolWithCount2);
            simplePoolWithCount = simplePoolWithCount2;
        } else {
            simplePoolWithCount = simplePoolWithCount2;
        }
        Drawable drawable = (Drawable) simplePoolWithCount.mo740a();
        if (drawable == null) {
            drawable = resources.getDrawable(i);
        }
        if (simplePoolWithCount.m31138b() == 0) {
            simplePoolWithCount.mo741a(drawable.getConstantState().newDrawable());
        }
        return drawable;
    }
}
