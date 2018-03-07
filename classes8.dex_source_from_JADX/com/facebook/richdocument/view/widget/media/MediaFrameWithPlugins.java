package com.facebook.richdocument.view.widget.media;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.richdocument.view.transition.MediaTransitionState;
import com.facebook.richdocument.view.transition.ViewLayout;
import com.facebook.richdocument.view.transition.state.MediaStateMachine.Event;
import com.facebook.richdocument.view.widget.AnnotationView;
import com.facebook.richdocument.view.widget.UFIView;
import com.facebook.richdocument.view.widget.media.plugins.ImageInteractionMonitorPlugin;
import com.facebook.richdocument.view.widget.media.plugins.MediaFramePlugin;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: obtain() called with null nextItem */
public class MediaFrameWithPlugins<V extends MediaView> extends MediaFrameImpl<V> {
    @Inject
    public GatekeeperStoreImpl f7596f;
    private final boolean f7597g;
    private final Map<Class, MediaFramePlugin> f7598h;

    private static <T extends View> void m7830a(Class<T> cls, T t) {
        m7831a((Object) t, t.getContext());
    }

    private static void m7831a(Object obj, Context context) {
        ((MediaFrameWithPlugins) obj).f7596f = GatekeeperStoreImplMethodAutoProvider.a(FbInjector.get(context));
    }

    public MediaFrameWithPlugins(Context context) {
        this(context, null);
    }

    public MediaFrameWithPlugins(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MediaFrameWithPlugins(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7598h = new HashMap();
        m7830a(MediaFrameWithPlugins.class, (View) this);
        this.f7597g = this.f7596f.a(681, false);
    }

    public final <T extends MediaFramePlugin> void mo492a(T t) {
        if (t != null) {
            this.f7598h.put(t.getClass(), t);
            t.mo508c();
        }
    }

    public Collection<MediaFramePlugin> getPlugins() {
        return Collections.unmodifiableCollection(this.f7598h.values());
    }

    public final <T extends MediaFramePlugin> boolean mo494a(Class<T> cls) {
        return this.f7598h.containsKey(cls);
    }

    public final <T extends MediaFramePlugin> T mo495b(Class<T> cls) {
        return (MediaFramePlugin) this.f7598h.get(cls);
    }

    public final <T extends MediaFramePlugin> void mo497c(Class<T> cls) {
        this.f7598h.remove(cls);
    }

    public final void mo493a(MediaFramePlugin mediaFramePlugin, Object obj) {
        for (MediaFramePlugin mediaFramePlugin2 : this.f7598h.values()) {
            if (mediaFramePlugin2 != mediaFramePlugin) {
                mediaFramePlugin2.mo505a(mediaFramePlugin2, obj);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -807730181);
        for (MediaFramePlugin mediaFramePlugin : this.f7598h.values()) {
            if ((mediaFramePlugin instanceof OnMediaTouchListener) && ((OnMediaTouchListener) mediaFramePlugin).mo513b(motionEvent)) {
                Logger.a(2, EntryType.UI_INPUT_END, -1739872200, a);
                return true;
            }
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        LogUtils.a(-114496833, a);
        return onTouchEvent;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        for (MediaFramePlugin mediaFramePlugin : this.f7598h.values()) {
            if (mediaFramePlugin instanceof OnMediaTouchListener) {
                return ((OnMediaTouchListener) mediaFramePlugin).mo512a(motionEvent);
            }
        }
        return false;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -260087845);
        super.onAttachedToWindow();
        if (!this.f7597g) {
            m7832f();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 993541093, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1412965621);
        super.onDetachedFromWindow();
        if (!this.f7597g) {
            m7833g();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 318534885, a);
    }

    public final void mo483d() {
        super.mo483d();
        if (this.f7597g) {
            m7832f();
        }
    }

    public final void mo484e() {
        super.mo484e();
        if (this.f7597g) {
            m7833g();
        }
    }

    private void m7832f() {
        for (MediaFramePlugin mediaFramePlugin : this.f7598h.values()) {
            if (mediaFramePlugin.mo507b()) {
                mediaFramePlugin.mo509d();
            }
        }
    }

    private void m7833g() {
        for (MediaFramePlugin mediaFramePlugin : this.f7598h.values()) {
            if (mediaFramePlugin.mo507b()) {
                mediaFramePlugin.mo510e();
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ViewLayout a;
        super.onLayout(z, i, i2, i3, i4);
        ViewLayout currentLayout = getCurrentLayout();
        if (m7834h()) {
            a = this.f7592g.mo417a(true);
        } else {
            a = currentLayout;
        }
        for (MediaFramePlugin mediaFramePlugin : this.f7598h.values()) {
            if (mediaFramePlugin.mo507b()) {
                mediaFramePlugin.mo504a(a);
            }
        }
    }

    private boolean m7834h() {
        Iterator it = getAnnotationViews().iterator();
        boolean z = false;
        while (it.hasNext()) {
            boolean isDirtyAndReset;
            AnnotationView annotationView = (AnnotationView) it.next();
            if (annotationView instanceof UFIView) {
                isDirtyAndReset = ((UFIView) annotationView).getIsDirtyAndReset();
            } else {
                isDirtyAndReset = z;
            }
            z = isDirtyAndReset;
        }
        return z;
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        for (MediaFramePlugin mediaFramePlugin : this.f7598h.values()) {
            if (mediaFramePlugin.mo507b()) {
                mediaFramePlugin.mo502a(canvas);
            }
        }
    }

    public final boolean mo447a(Event event) {
        boolean z = false;
        for (MediaFramePlugin mediaFramePlugin : this.f7598h.values()) {
            if (mediaFramePlugin.mo507b() && !(mediaFramePlugin instanceof ImageInteractionMonitorPlugin) && mediaFramePlugin.mo447a(event)) {
                z = true;
                break;
            }
        }
        ImageInteractionMonitorPlugin imageInteractionMonitorPlugin = (ImageInteractionMonitorPlugin) mo495b(ImageInteractionMonitorPlugin.class);
        if (imageInteractionMonitorPlugin != null) {
            imageInteractionMonitorPlugin.mo447a(event);
        }
        if (z) {
            return true;
        }
        return super.mo447a(event);
    }

    public final void mo437a() {
        super.mo437a();
        for (MediaFramePlugin c : this.f7598h.values()) {
            c.mo508c();
        }
    }

    protected final void mo496c(MediaTransitionState mediaTransitionState) {
        super.mo496c(mediaTransitionState);
        for (MediaFramePlugin mediaFramePlugin : this.f7598h.values()) {
            if (mediaFramePlugin.mo507b()) {
                mediaFramePlugin.mo503a(mediaTransitionState);
            }
        }
    }

    public final void mo479a(ViewLayout viewLayout) {
        super.mo479a(viewLayout);
        for (MediaFramePlugin mediaFramePlugin : this.f7598h.values()) {
            if (mediaFramePlugin.mo507b()) {
                mediaFramePlugin.mo506b(viewLayout);
            }
        }
    }
}
