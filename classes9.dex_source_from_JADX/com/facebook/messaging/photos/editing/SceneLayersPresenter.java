package com.facebook.messaging.photos.editing;

import android.content.Context;
import android.graphics.Matrix;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.messaging.photos.editing.Layer.Event;
import com.facebook.messaging.photos.editing.PhotoEditingController.C18913;
import com.facebook.messaging.photos.editing.PhotoEditingController.C18924;
import com.facebook.messaging.photos.editing.RotateGestureDetector.C19001;
import com.facebook.messaging.photos.editing.RotateGestureDetector.SimpleOnRotateGestureListener;
import com.facebook.messaging.photos.editing.ScaleGestureDetector.SimpleOnScaleGestureListener;
import com.facebook.springs.SpringSystem;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: did_show_wifi_notification */
public class SceneLayersPresenter {
    public final Scene f16207a;
    public LayerGroupLayout f16208b;
    public final SpringSystem f16209c;
    public final Map<Layer, LayerPresenter> f16210d = new HashMap();
    private final Observer f16211e = new C19021(this);
    public C18913 f16212f;
    public C18924 f16213g;
    public GestureDetector f16214h;
    public ScaleGestureDetector f16215i;
    public RotateGestureDetector f16216j;
    public float f16217k;
    public boolean f16218l;
    public boolean f16219m;
    public boolean f16220n;
    private final int f16221o;
    private float[] f16222p = new float[2];
    public LayerPresenter f16223q;

    /* compiled from: did_show_wifi_notification */
    class C19021 implements Observer {
        final /* synthetic */ SceneLayersPresenter f16197a;

        C19021(SceneLayersPresenter sceneLayersPresenter) {
            this.f16197a = sceneLayersPresenter;
        }

        public final void mo663a(Object obj) {
            this.f16197a.m16318a(obj);
        }
    }

    /* compiled from: did_show_wifi_notification */
    public class C19032 {
        public final /* synthetic */ SceneLayersPresenter f16198a;

        C19032(SceneLayersPresenter sceneLayersPresenter) {
            this.f16198a = sceneLayersPresenter;
        }

        public final float m16299b() {
            return SceneLayersPresenter.m16315d(this.f16198a);
        }
    }

    /* compiled from: did_show_wifi_notification */
    public class C19043 {
        final /* synthetic */ SceneLayersPresenter f16199a;

        C19043(SceneLayersPresenter sceneLayersPresenter) {
            this.f16199a = sceneLayersPresenter;
        }

        public final float m16300a() {
            return SceneLayersPresenter.m16313c(this.f16199a);
        }

        public final float m16301b() {
            return SceneLayersPresenter.m16315d(this.f16199a);
        }
    }

    /* compiled from: did_show_wifi_notification */
    public class C19054 {
        final /* synthetic */ SceneLayersPresenter f16200a;

        C19054(SceneLayersPresenter sceneLayersPresenter) {
            this.f16200a = sceneLayersPresenter;
        }
    }

    /* compiled from: did_show_wifi_notification */
    public class C19065 {
        public final /* synthetic */ SceneLayersPresenter f16201a;

        public C19065(SceneLayersPresenter sceneLayersPresenter) {
            this.f16201a = sceneLayersPresenter;
        }
    }

    /* compiled from: did_show_wifi_notification */
    class MyGestureListener extends SimpleOnGestureListener {
        final /* synthetic */ SceneLayersPresenter f16202a;

        public MyGestureListener(SceneLayersPresenter sceneLayersPresenter) {
            this.f16202a = sceneLayersPresenter;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (this.f16202a.f16219m) {
                return false;
            }
            Layer a = m16302a(motionEvent);
            if (a != null) {
                if (a != this.f16202a.f16207a.f16192c) {
                    this.f16202a.f16207a.m16296b(a);
                } else {
                    ((LayerPresenter) this.f16202a.f16210d.get(a)).mo680f();
                }
                return true;
            }
            m16303a();
            return false;
        }

        @Nullable
        private Layer m16302a(MotionEvent motionEvent) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int childCount = this.f16202a.f16208b.getChildCount() - 1;
            while (childCount >= 0) {
                if (this.f16202a.f16208b.getChildAt(childCount).getVisibility() == 0 && SceneLayersPresenter.m16312a(this.f16202a, x, y, childCount)) {
                    return this.f16202a.f16207a.m16294a(childCount);
                }
                childCount--;
            }
            return null;
        }

        private void m16303a() {
            Layer layer = this.f16202a.f16207a.f16192c;
            if (layer != null && layer.mo676a()) {
                this.f16202a.f16223q.mo681g();
                this.f16202a.f16212f.m16241b(false);
                this.f16202a.f16207a.m16297c(layer);
            } else if (this.f16202a.f16223q != null) {
                this.f16202a.f16223q.mo681g();
            }
            this.f16202a.f16208b.requestFocus();
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            Layer a = m16302a(motionEvent);
            if (a != null) {
                if (this.f16202a.f16212f != null) {
                    C18913 c18913 = this.f16202a.f16212f;
                    if (a instanceof StickerLayer) {
                        boolean z;
                        if (a.f16032f) {
                            z = false;
                        } else {
                            z = true;
                        }
                        a.m16179a(z);
                    }
                }
                return true;
            }
            m16303a();
            return false;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Layer layer = this.f16202a.f16207a.f16192c;
            if (SceneLayersPresenter.m16316f(this.f16202a)) {
                return false;
            }
            if (!this.f16202a.f16218l) {
                layer = SceneLayersPresenter.m16308a(this.f16202a, (int) motionEvent.getX(), (int) motionEvent.getY());
            }
            if (layer == null) {
                return false;
            }
            this.f16202a.f16218l = true;
            if (this.f16202a.f16212f != null) {
                this.f16202a.f16212f.m16240a(this.f16202a.f16218l);
            }
            if (this.f16202a.f16213g != null) {
                LayerPresenter layerPresenter = this.f16202a.f16223q;
                boolean a = this.f16202a.f16213g.m16242a((int) motionEvent2.getX(), (int) motionEvent2.getY());
                layerPresenter.f16044h = a;
                layerPresenter.f16039c.setAlpha(a ? 0.35f : 1.0f);
            }
            float width = ((float) this.f16202a.f16208b.getWidth()) * 0.5f;
            float height = ((float) this.f16202a.f16208b.getHeight()) * 0.5f;
            float f3 = layer.f16029c - f2;
            float max = Math.max(-width, Math.min(layer.f16028b - f, width));
            f3 = Math.max(-height, Math.min(f3, height));
            layer.f16028b = max;
            layer.f16029c = f3;
            layer.m16178a(Event.TRANSLATE);
            return true;
        }
    }

    /* compiled from: did_show_wifi_notification */
    class MyOnRotateGestureListener extends SimpleOnRotateGestureListener {
        final /* synthetic */ SceneLayersPresenter f16203a;

        public final boolean mo671b(RotateGestureDetector rotateGestureDetector) {
            return SceneLayersPresenter.m16308a(this.f16203a, (int) rotateGestureDetector.f16133d, (int) rotateGestureDetector.f16134e) != null;
        }

        public MyOnRotateGestureListener(SceneLayersPresenter sceneLayersPresenter) {
            this.f16203a = sceneLayersPresenter;
        }

        public final boolean mo670a(RotateGestureDetector rotateGestureDetector) {
            Layer layer = this.f16203a.f16207a.f16192c;
            if (layer != null) {
                layer.f16031e += -RotateGestureDetector.m16277a(rotateGestureDetector.f16147r, rotateGestureDetector.f16146q, rotateGestureDetector.f16143n, rotateGestureDetector.f16142m);
                layer.m16178a(Event.ROTATE);
            }
            return true;
        }
    }

    /* compiled from: did_show_wifi_notification */
    class MyOnScaleGestureListener extends SimpleOnScaleGestureListener {
        final /* synthetic */ SceneLayersPresenter f16204a;

        public final boolean mo673b(ScaleGestureDetector scaleGestureDetector) {
            return SceneLayersPresenter.m16308a(this.f16204a, (int) scaleGestureDetector.f16167d, (int) scaleGestureDetector.f16168e) != null;
        }

        public MyOnScaleGestureListener(SceneLayersPresenter sceneLayersPresenter) {
            this.f16204a = sceneLayersPresenter;
        }

        public final boolean mo672a(ScaleGestureDetector scaleGestureDetector) {
            Layer layer = this.f16204a.f16207a.f16192c;
            if (layer == null) {
                return false;
            }
            layer.f16030d = Math.min(7.5f, Math.max(0.1f, layer.f16030d * scaleGestureDetector.m16293d()));
            layer.m16178a(Event.SCALE);
            return true;
        }
    }

    /* compiled from: did_show_wifi_notification */
    class OnLayerViewFocusChangeListener implements OnFocusChangeListener {
        final /* synthetic */ SceneLayersPresenter f16205a;

        public OnLayerViewFocusChangeListener(SceneLayersPresenter sceneLayersPresenter) {
            this.f16205a = sceneLayersPresenter;
        }

        public void onFocusChange(View view, boolean z) {
            if (!z) {
                Layer a;
                SceneLayersPresenter sceneLayersPresenter = this.f16205a;
                int indexOfChild = sceneLayersPresenter.f16208b.indexOfChild(view);
                if (indexOfChild >= 0) {
                    a = sceneLayersPresenter.f16207a.m16294a(indexOfChild);
                } else {
                    a = null;
                }
                Layer layer = a;
                if (layer != null) {
                    if (layer.mo676a()) {
                        this.f16205a.f16207a.m16297c(layer);
                        return;
                    }
                    LayerPresenter layerPresenter = (LayerPresenter) this.f16205a.f16210d.get(layer);
                    if (layerPresenter != null) {
                        layerPresenter.mo681g();
                    }
                }
            }
        }
    }

    /* compiled from: did_show_wifi_notification */
    class RootViewOnTouchListener implements OnTouchListener {
        final /* synthetic */ SceneLayersPresenter f16206a;

        public RootViewOnTouchListener(SceneLayersPresenter sceneLayersPresenter) {
            this.f16206a = sceneLayersPresenter;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.f16206a.f16219m = false;
            }
            if (!SceneLayersPresenter.m16316f(this.f16206a)) {
                this.f16206a.f16215i.m16292a(motionEvent);
                this.f16206a.f16216j.m16281a(motionEvent);
            }
            this.f16206a.f16214h.onTouchEvent(motionEvent);
            if (actionMasked == 1) {
                this.f16206a.f16218l = false;
                if (this.f16206a.f16212f != null) {
                    this.f16206a.f16212f.m16240a(this.f16206a.f16218l);
                }
                if (this.f16206a.f16223q != null && this.f16206a.f16223q.f16044h) {
                    this.f16206a.f16207a.m16297c(this.f16206a.f16223q.f16038b);
                }
            }
            return true;
        }
    }

    public SceneLayersPresenter(Scene scene, LayerGroupLayout layerGroupLayout, SpringSystem springSystem) {
        this.f16207a = scene;
        this.f16208b = layerGroupLayout;
        this.f16209c = springSystem;
        this.f16221o = 48;
    }

    public final void m16317a() {
        Scene scene = this.f16207a;
        scene.f16191b.m16224a(this.f16211e);
        this.f16208b.removeAllViews();
        int size = this.f16207a.f16190a.size();
        for (int i = 0; i < size; i++) {
            m16309a(this.f16207a.m16294a(i), i);
        }
        Layer layer = this.f16207a.f16192c;
        if (layer != null) {
            m16310a(layer, null);
        }
        this.f16208b.setOnTouchListener(new RootViewOnTouchListener(this));
        Context context = this.f16208b.getContext();
        this.f16214h = new GestureDetector(context, new MyGestureListener(this));
        this.f16215i = new ScaleGestureDetector(context, new MyOnScaleGestureListener(this));
        this.f16215i.m16291a(true, true, new C19032(this));
        this.f16216j = new RotateGestureDetector(context, new MyOnRotateGestureListener(this));
        RotateGestureDetector rotateGestureDetector = this.f16216j;
        rotateGestureDetector.f16132c = new C19043(this);
        rotateGestureDetector.f16135f = true;
        rotateGestureDetector.f16136g = true;
        if (rotateGestureDetector.f16135f && rotateGestureDetector.f16129L == null) {
            rotateGestureDetector.f16129L = new GestureDetector(rotateGestureDetector.f16130a, new C19001(rotateGestureDetector), rotateGestureDetector.f16128K);
        }
    }

    public static float m16313c(SceneLayersPresenter sceneLayersPresenter) {
        Layer layer = sceneLayersPresenter.f16207a.f16192c;
        if (layer == null) {
            return (float) (sceneLayersPresenter.f16208b.getWidth() / 2);
        }
        int width;
        if (layer == null) {
            width = sceneLayersPresenter.f16208b.getWidth() / 2;
        } else {
            width = (sceneLayersPresenter.f16208b.getWidth() / 2) + ((int) layer.f16028b);
        }
        return (float) width;
    }

    public static float m16315d(SceneLayersPresenter sceneLayersPresenter) {
        Layer layer = sceneLayersPresenter.f16207a.f16192c;
        if (layer == null) {
            return (float) (sceneLayersPresenter.f16208b.getHeight() / 2);
        }
        int height;
        if (layer == null) {
            height = sceneLayersPresenter.f16208b.getHeight() / 2;
        } else {
            height = (sceneLayersPresenter.f16208b.getHeight() / 2) + ((int) layer.f16029c);
        }
        return (float) height;
    }

    public final void m16318a(Object obj) {
        if (obj instanceof AddLayerEvent) {
            AddLayerEvent addLayerEvent = (AddLayerEvent) obj;
            m16309a(addLayerEvent.f16015a, addLayerEvent.f16016a);
        } else if (obj instanceof DeleteLayerEvent) {
            Layer layer = ((DeleteLayerEvent) obj).f16015a;
            LayerPresenter layerPresenter = (LayerPresenter) this.f16210d.remove(layer);
            if (layerPresenter != null) {
                this.f16208b.removeView(layerPresenter.f16039c);
                this.f16210d.remove(layer);
                layerPresenter.mo678d();
            }
        } else if (obj instanceof SetActiveLayerEvent) {
            SetActiveLayerEvent setActiveLayerEvent = (SetActiveLayerEvent) obj;
            m16310a(setActiveLayerEvent.f16224a, setActiveLayerEvent.f16225b);
        }
    }

    public final void m16319b() {
        if (m16316f(this)) {
            ((TextLayerPresenter) this.f16223q).m16343c(false);
        }
    }

    private void m16309a(Layer layer, int i) {
        LayerPresenter c = m16314c(layer);
        c.f16047k = new C19054(this);
        c.mo675c();
        c.m16185a(this.f16217k);
        this.f16210d.put(layer, c);
        View view = c.f16039c;
        this.f16208b.addView(view, i);
        view.setOnFocusChangeListener(new OnLayerViewFocusChangeListener(this));
        this.f16220n = true;
        c.mo679e();
    }

    private LayerPresenter m16314c(Layer layer) {
        if (!(layer instanceof TextLayer)) {
            return layer instanceof StickerLayer ? new StickerLayerPresenter((StickerLayer) layer, (FbDraweeView) LayoutInflater.from(this.f16208b.getContext()).inflate(2130907234, this.f16208b, false), CallerContext.a(SceneLayersPresenter.class), this.f16209c) : null;
        } else {
            LayerPresenter textLayerPresenter = new TextLayerPresenter((TextLayer) layer, (LayerEditText) LayoutInflater.from(this.f16208b.getContext()).inflate(2130903960, this.f16208b, false), this.f16209c);
            textLayerPresenter.f16286g = new C19065(this);
            return textLayerPresenter;
        }
    }

    private void m16310a(Layer layer, Layer layer2) {
        LayerPresenter layerPresenter = (LayerPresenter) this.f16210d.get(layer2);
        if (layerPresenter != null) {
            layerPresenter.mo681g();
        }
        this.f16220n = false;
        this.f16223q = (LayerPresenter) this.f16210d.get(layer);
        if (this.f16212f != null && this.f16223q != null) {
            boolean z = this.f16223q.f16043g;
            this.f16212f.m16241b(m16316f(this));
        }
    }

    public static boolean m16312a(SceneLayersPresenter sceneLayersPresenter, int i, int i2, int i3) {
        Layer a = sceneLayersPresenter.f16207a.m16294a(i3);
        if (a == null) {
            return false;
        }
        return sceneLayersPresenter.m16311a(i, i2, a);
    }

    private boolean m16311a(int i, int i2, Layer layer) {
        LayerPresenter layerPresenter = (LayerPresenter) this.f16210d.get(layer);
        if (layerPresenter == null) {
            return false;
        }
        int width = this.f16208b.getWidth() / 2;
        int height = this.f16208b.getHeight() / 2;
        Matrix r = layerPresenter.m16200r();
        this.f16222p[0] = (float) (i - width);
        this.f16222p[1] = (float) (i2 - height);
        r.mapPoints(this.f16222p);
        int i3 = ((int) this.f16222p[0]) + width;
        int i4 = ((int) this.f16222p[1]) + height;
        View view = layerPresenter.f16039c;
        width = view.getLeft();
        int right = view.getRight();
        int top = view.getTop();
        height = view.getBottom();
        if (right - width < this.f16221o) {
            width = ((right + width) - this.f16221o) / 2;
            right = this.f16221o + width;
        }
        if (height - top < this.f16221o) {
            top = ((height + top) - this.f16221o) / 2;
            height = this.f16221o + top;
        }
        return i3 >= width && i3 < right && i4 >= top && i4 < height;
    }

    public static boolean m16316f(SceneLayersPresenter sceneLayersPresenter) {
        return (sceneLayersPresenter.f16223q instanceof TextLayerPresenter) && ((TextLayerPresenter) sceneLayersPresenter.f16223q).f16282c.isClickable();
    }

    public static Layer m16308a(SceneLayersPresenter sceneLayersPresenter, int i, int i2) {
        Layer layer = sceneLayersPresenter.f16207a.f16192c;
        Object obj = (sceneLayersPresenter.f16218l || sceneLayersPresenter.f16215i.f16180q || sceneLayersPresenter.f16216j.f16152w) ? 1 : null;
        if (obj != null || m16316f(sceneLayersPresenter) || (layer != null && sceneLayersPresenter.m16311a(i, i2, layer))) {
            return layer;
        }
        int childCount = sceneLayersPresenter.f16208b.getChildCount() - 1;
        while (childCount >= 0) {
            Layer a = sceneLayersPresenter.f16207a.m16294a(childCount);
            if (a != layer && sceneLayersPresenter.f16208b.getChildAt(childCount).getVisibility() == 0 && sceneLayersPresenter.m16311a(i, i2, a)) {
                sceneLayersPresenter.f16207a.m16296b(a);
                return a;
            }
            childCount--;
        }
        return layer;
    }
}
