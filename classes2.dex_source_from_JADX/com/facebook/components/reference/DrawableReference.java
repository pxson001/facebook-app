package com.facebook.components.reference;

import android.graphics.drawable.Drawable;
import com.facebook.components.ComponentContext;
import com.facebook.components.reference.Reference.Builder;

/* compiled from: gametime_plays_feed_type */
public final class DrawableReference extends ReferenceLifecycle<Drawable> {
    private static DrawableReference f22750a;

    /* compiled from: gametime_plays_feed_type */
    public class PropsBuilder extends Builder<Drawable> {
        private State f22751a;

        public PropsBuilder(State state) {
            this.f22751a = state;
        }

        public final PropsBuilder m30719a(Drawable drawable) {
            this.f22751a.f22752a = drawable;
            return this;
        }

        public final Reference<Drawable> mo3297b() {
            return this.f22751a;
        }
    }

    /* compiled from: gametime_plays_feed_type */
    class State extends Reference<Drawable> {
        Drawable f22752a;

        public int hashCode() {
            return this.f22752a != null ? this.f22752a.hashCode() : 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return DrawableUtils.a(this.f22752a, ((State) obj).f22752a);
        }

        protected State() {
            super(DrawableReference.m30716a());
        }
    }

    private DrawableReference() {
    }

    public static synchronized DrawableReference m30716a() {
        DrawableReference drawableReference;
        synchronized (DrawableReference.class) {
            if (f22750a == null) {
                f22750a = new DrawableReference();
            }
            drawableReference = f22750a;
        }
        return drawableReference;
    }

    public static PropsBuilder m30717b() {
        return new PropsBuilder(new State());
    }

    protected final Object mo3151a(ComponentContext componentContext, Reference reference) {
        return ((State) reference).f22752a;
    }
}
