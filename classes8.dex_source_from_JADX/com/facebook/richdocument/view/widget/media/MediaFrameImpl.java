package com.facebook.richdocument.view.widget.media;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEvents.RecyclerViewFocusRequest;
import com.facebook.richdocument.event.RichDocumentEvents.RecyclerViewFocusRequest.RequestType;
import com.facebook.richdocument.model.block.Annotation.AnnotationSlot;
import com.facebook.richdocument.view.transition.AbstractTransitionStrategy;
import com.facebook.richdocument.view.transition.MediaLayoutStrategy.AnnotationLayoutType;
import com.facebook.richdocument.view.transition.MediaTransitionState;
import com.facebook.richdocument.view.transition.MediaTransitionStrategy;
import com.facebook.richdocument.view.transition.ViewAttribute.ViewAttributeType;
import com.facebook.richdocument.view.transition.ViewAttributes;
import com.facebook.richdocument.view.transition.ViewLayout;
import com.facebook.richdocument.view.transition.ViewOpacity;
import com.facebook.richdocument.view.transition.ViewRect;
import com.facebook.richdocument.view.transition.state.MediaStateMachine;
import com.facebook.richdocument.view.transition.state.MediaStateMachine.Event;
import com.facebook.richdocument.view.widget.AnnotationView;
import com.facebook.richdocument.view.widget.ExpandedMediaHolder;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: off_text */
public abstract class MediaFrameImpl<V extends MediaView> extends FrameWithOverlay implements MediaFrame<V> {
    @Inject
    public RichDocumentEventBus f7589d;
    @Inject
    public ExpandedMediaHolder f7590e;
    private MediaFrameBody<V> f7591f;
    public MediaTransitionStrategy f7592g;
    public ViewLayout f7593h;
    private final GestureDetector f7594i;
    private MediaStateMachine f7595j;

    /* compiled from: off_text */
    class C08721 extends SimpleOnGestureListener {
        final /* synthetic */ MediaFrameImpl f7588a;

        C08721(MediaFrameImpl mediaFrameImpl) {
            this.f7588a = mediaFrameImpl;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            this.f7588a.mo447a(Event.CLICK_MEDIA);
            return true;
        }
    }

    public static void m7814a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        MediaFrameImpl mediaFrameImpl = (MediaFrameImpl) obj;
        RichDocumentEventBus a = RichDocumentEventBus.m5130a(injectorLike);
        ExpandedMediaHolder a2 = ExpandedMediaHolder.m7438a(injectorLike);
        mediaFrameImpl.f7589d = a;
        mediaFrameImpl.f7590e = a2;
    }

    public MediaFrameImpl(Context context) {
        this(context, null);
    }

    public MediaFrameImpl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MediaFrameImpl(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = MediaFrameImpl.class;
        m7814a((Object) this, getContext());
        this.f7595j = new MediaStateMachineImpl(this, this.f7590e);
        this.f7594i = new GestureDetector(getContext(), new C08721(this));
        this.f7594i.setIsLongpressEnabled(false);
        setClipChildren(false);
        setClipToPadding(false);
    }

    public void setOverlayBackgroundColor(int i) {
        super.setOverlayBackgroundColor(i);
        getBody().setOverlayBackgroundColor(i);
    }

    public MediaFrameBody<V> getBody() {
        return this.f7591f;
    }

    public void setBody(MediaFrameBody<V> mediaFrameBody) {
        this.f7591f = mediaFrameBody;
    }

    public V getMediaView() {
        return this.f7591f == null ? null : this.f7591f.f7587d;
    }

    public final void mo407a(AnnotationView annotationView) {
        Object obj;
        AbstractTransitionStrategy transitionStrategy = getTransitionStrategy();
        AnnotationLayoutType annotationLayoutType = transitionStrategy.m7201b(transitionStrategy.mo420d()).f6963g;
        AnnotationSlot annotationSlot = annotationView.getAnnotation().f5612e;
        if (annotationLayoutType == AnnotationLayoutType.ANNOTATION_DEFAULT && (annotationSlot == AnnotationSlot.ABOVE || annotationSlot == AnnotationSlot.BELOW)) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            getBody().mo407a(annotationView);
        } else {
            super.mo407a(annotationView);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1130241324);
        if (getOverlayBounds().contains(Math.round(motionEvent.getX()), Math.round(motionEvent.getY()))) {
            this.f7594i.onTouchEvent(motionEvent);
            Logger.a(2, EntryType.UI_INPUT_END, 540863037, a);
            return true;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        LogUtils.a(1052876193, a);
        return onTouchEvent;
    }

    public boolean mo447a(Event event) {
        if (this.f7595j != null) {
            return this.f7595j.mo447a(event);
        }
        return false;
    }

    public void mo437a() {
        super.mo437a();
        getBody().mo437a();
        this.f7593h = null;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f7591f != null) {
            m7791a(this.f7591f, mo471a(this.f7591f));
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        if (view == this.f7591f) {
            Rect a = mo471a(getOverlayView());
            if (a != null) {
                int save = canvas.save(2);
                canvas.clipRect(a);
                boolean drawChild = super.drawChild(canvas, view, j);
                canvas.restoreToCount(save);
                return drawChild;
            }
        }
        return super.drawChild(canvas, view, j);
    }

    protected final void mo472a(Canvas canvas) {
        if (this.f7591f.getRotation() != 0.0f) {
            super.mo472a(canvas);
        }
    }

    public ViewLayout getCurrentLayout() {
        return this.f7592g.mo417a(false);
    }

    public void setTransitionStrategy(MediaTransitionStrategy mediaTransitionStrategy) {
        if (this.f7592g != null) {
            AbstractTransitionStrategy abstractTransitionStrategy = this.f7592g;
            abstractTransitionStrategy.m7199a(null);
            abstractTransitionStrategy.f6954i.clear();
        }
        this.f7592g = mediaTransitionStrategy;
        this.f7592g.f6954i.add(this);
    }

    public MediaTransitionStrategy getTransitionStrategy() {
        return this.f7592g;
    }

    public void mo478a(MediaTransitionState mediaTransitionState) {
        if (mo481b(mediaTransitionState)) {
            ViewLayout currentLayout = getCurrentLayout();
            ViewLayout a = getTransitionStrategy().m7196a(mediaTransitionState, false);
            if (currentLayout != null && a != null && !a.equals(currentLayout)) {
                getTransitionStrategy().m7204d(mediaTransitionState);
                if (getTransitionStrategy().mo426a(((MediaTransitionState) currentLayout.mo427a()).m7272e(), mediaTransitionState)) {
                    mo482c();
                }
                mo496c(mediaTransitionState);
            }
        }
    }

    public final boolean mo481b(MediaTransitionState mediaTransitionState) {
        return getTransitionStrategy().m7196a(mediaTransitionState, false) != null;
    }

    protected void mo496c(MediaTransitionState mediaTransitionState) {
        if (mediaTransitionState != getTransitionStrategy().mo420d()) {
            this.f7590e.m7441a((View) this);
        } else {
            this.f7590e.m7441a(null);
        }
    }

    public void mo479a(ViewLayout viewLayout) {
        ViewLayout viewLayout2 = this.f7593h;
        if (viewLayout2 == null) {
            requestLayout();
        } else {
            for (View view : viewLayout.mo432b().keySet()) {
                Object obj = 1;
                ViewAttributes a = viewLayout2.mo429a(view);
                ViewAttributes a2 = viewLayout.mo429a(view);
                if (!(a == null || a2 == null || !a.equals(a2))) {
                    obj = null;
                }
                if (obj != null) {
                    view.requestLayout();
                }
            }
        }
        this.f7593h = viewLayout;
        Rect a3 = m7813a(viewLayout, (View) this);
        if (a3 != null) {
            mo501a(a3);
        }
    }

    public void mo482c() {
        this.f7589d.a(new RecyclerViewFocusRequest(RequestType.SET_FOCUSED_VIEW, this, null));
    }

    protected void mo501a(Rect rect) {
        if (rect != null) {
            this.f7589d.a(new RecyclerViewFocusRequest(RequestType.SCROLL_FOCUSED_VIEW_TO_RECT, this, rect));
        }
    }

    public final Rect mo471a(View view) {
        return m7813a(getCurrentLayout(), view);
    }

    private static Rect m7813a(ViewLayout viewLayout, View view) {
        ViewRect viewRect = (ViewRect) viewLayout.mo428a(view, ViewAttributeType.RECT, ViewRect.class);
        return viewRect == null ? null : viewRect.f7004a;
    }

    protected final Float mo473b(View view) {
        ViewOpacity viewOpacity = (ViewOpacity) getCurrentLayout().mo428a(view, ViewAttributeType.OPACITY, ViewOpacity.class);
        return viewOpacity == null ? null : viewOpacity.m7318b();
    }

    protected Rect getOverlayBounds() {
        return mo471a(this.f7591f);
    }

    public final ViewGroup mo480b() {
        return this;
    }

    public void mo483d() {
    }

    public void mo484e() {
    }
}
