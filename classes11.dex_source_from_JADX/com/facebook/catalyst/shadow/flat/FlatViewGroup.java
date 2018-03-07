package com.facebook.catalyst.shadow.flat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Animation;
import com.facebook.infer.annotation.Assertions;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.common.SystemClock;
import com.facebook.react.touch.OnInterceptTouchEventListener;
import com.facebook.react.touch.ReactInterceptingViewGroup;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactCompoundViewGroup;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.views.image.ImageLoadEvent;
import com.facebook.react.views.view.ReactClippingViewGroup;
import com.facebook.react.views.view.ReactClippingViewGroupHelper;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: loginClient */
public final class FlatViewGroup extends ViewGroup implements ReactInterceptingViewGroup, ReactCompoundViewGroup, ReactPointerEventsView, ReactClippingViewGroup {
    public static final ArrayList<FlatViewGroup> f5731a = new ArrayList();
    private static final Rect f5732b = new Rect();
    @Nullable
    public InvalidateCallback f5733c;
    public DrawCommand[] f5734d = DrawCommand.f5606b;
    private AttachDetachListener[] f5735e = AttachDetachListener.f5623a;
    public NodeRegion[] f5736f = NodeRegion.f5771a;
    private int f5737g = 0;
    private boolean f5738h = false;
    public boolean f5739i = false;
    public boolean f5740j = false;
    public Drawable f5741k;
    public PointerEvents f5742l = PointerEvents.AUTO;
    private long f5743m;
    @Nullable
    private OnInterceptTouchEventListener f5744n;
    public boolean f5745o;
    @Nullable
    private Rect f5746p;
    public final Map<Integer, DrawView> f5747q = new HashMap();
    public final Map<Integer, FlatViewGroup> f5748r = new HashMap();
    public boolean f5749s;

    /* compiled from: loginClient */
    public final class InvalidateCallback extends WeakReference<FlatViewGroup> {
        public InvalidateCallback(FlatViewGroup flatViewGroup) {
            super(flatViewGroup);
        }

        public final void m7067a() {
            FlatViewGroup flatViewGroup = (FlatViewGroup) get();
            if (flatViewGroup != null) {
                flatViewGroup.invalidate();
            }
        }

        public final void m7068a(int i, int i2) {
            FlatViewGroup flatViewGroup = (FlatViewGroup) get();
            if (flatViewGroup != null) {
                ((UIManagerModule) ((ReactContext) flatViewGroup.getContext()).b(UIManagerModule.class)).a.a(new ImageLoadEvent(i, SystemClock.b(), i2));
            }
        }
    }

    FlatViewGroup(Context context) {
        super(context);
        setClipChildren(false);
    }

    protected final void detachAllViewsFromParent() {
        super.detachAllViewsFromParent();
    }

    public final void requestLayout() {
        if (!this.f5739i) {
            this.f5739i = true;
            f5731a.add(this);
        }
    }

    public final int m7075a(float f, float f2) {
        SoftAssertions.a(this.f5742l != PointerEvents.NONE, "TouchTargetHelper should not allow calling this method when pointer events are NONE");
        if (this.f5742l != PointerEvents.BOX_ONLY) {
            NodeRegion c = m7073c(f, f2);
            if (c != null) {
                return c.mo178b(f, f2);
            }
        }
        return getId();
    }

    public final void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f5745o) {
            for (DrawCommand drawCommand : this.f5734d) {
                if (!(drawCommand instanceof DrawView) || !((DrawView) drawCommand).f5651d) {
                    drawCommand.mo153a(this, canvas);
                }
            }
        } else {
            for (DrawCommand a : this.f5734d) {
                a.mo153a(this, canvas);
            }
        }
        if (this.f5737g != getChildCount()) {
            throw new RuntimeException("Did not draw all children: " + this.f5737g + " / " + getChildCount());
        }
        this.f5737g = 0;
        if (this.f5741k != null) {
            this.f5741k.draw(canvas);
        }
    }

    protected final boolean drawChild(Canvas canvas, View view, long j) {
        return false;
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    protected final boolean verifyDrawable(Drawable drawable) {
        return true;
    }

    protected final void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1528367701);
        if (this.f5738h) {
            Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 815705536, a);
            return;
        }
        this.f5738h = true;
        super.onAttachedToWindow();
        m7072b(this.f5735e);
        if (this.f5745o) {
            m7076a();
        }
        LogUtils.g(-455429808, a);
    }

    protected final void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 435456788);
        if (this.f5738h) {
            this.f5738h = false;
            super.onDetachedFromWindow();
            m7074c(this.f5735e);
            LogUtils.g(-1062847249, a);
            return;
        }
        RuntimeException runtimeException = new RuntimeException("Double detach");
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 482224967, a);
        throw runtimeException;
    }

    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 192186642);
        if (this.f5741k != null) {
            this.f5741k.setBounds(0, 0, i, i2);
            invalidate();
        }
        if (this.f5745o) {
            m7076a();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -666628943, a);
    }

    public final void dispatchDrawableHotspotChanged(float f, float f2) {
        if (this.f5741k != null) {
            this.f5741k.setHotspot(f, f2);
            invalidate();
        }
    }

    protected final void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f5741k != null && this.f5741k.isStateful()) {
            this.f5741k.setState(getDrawableState());
        }
    }

    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f5741k != null) {
            this.f5741k.jumpToCurrentState();
        }
    }

    public final void invalidate() {
        invalidate(0, 0, getWidth() + 1, getHeight() + 1);
    }

    public final boolean hasOverlappingRendering() {
        return this.f5740j;
    }

    public final void setOnInterceptTouchEventListener(OnInterceptTouchEventListener onInterceptTouchEventListener) {
        this.f5744n = onInterceptTouchEventListener;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        long downTime = motionEvent.getDownTime();
        if (downTime != this.f5743m) {
            this.f5743m = downTime;
            if (m7083b(motionEvent.getX(), motionEvent.getY())) {
                return true;
            }
        }
        if ((this.f5744n != null && this.f5744n.a(this, motionEvent)) || this.f5742l == PointerEvents.NONE || this.f5742l == PointerEvents.BOX_ONLY) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 189951249);
        if (this.f5742l == PointerEvents.NONE) {
            Logger.a(2, EntryType.UI_INPUT_END, -964601986, a);
            return false;
        } else if (this.f5742l == PointerEvents.BOX_NONE && m7073c(motionEvent.getX(), motionEvent.getY()) == null) {
            LogUtils.a(-1184659679, a);
            return false;
        } else {
            LogUtils.a(2117885759, a);
            return true;
        }
    }

    public final PointerEvents getPointerEvents() {
        return this.f5742l;
    }

    final void m7077a(Canvas canvas) {
        View childAt = getChildAt(this.f5737g);
        if (childAt instanceof FlatViewGroup) {
            super.drawChild(canvas, childAt, getDrawingTime());
        } else {
            canvas.save(2);
            childAt.getHitRect(f5732b);
            canvas.clipRect(f5732b);
            super.drawChild(canvas, childAt, getDrawingTime());
            canvas.restore();
        }
        this.f5737g++;
    }

    final void m7080a(FlatViewGroup flatViewGroup) {
        removeDetachedView(flatViewGroup, false);
    }

    final void m7081a(AttachDetachListener[] attachDetachListenerArr) {
        if (this.f5738h) {
            m7072b(attachDetachListenerArr);
            m7074c(this.f5735e);
        }
        this.f5735e = attachDetachListenerArr;
    }

    final void m7079a(FlatNativeViewHierarchyManager flatNativeViewHierarchyManager, int[] iArr, int[] iArr2) {
        for (int i : iArr) {
            if (i > 0) {
                View a = m7069a(flatNativeViewHierarchyManager.m6980d(i));
                addViewInLayout(a, -1, m7070a(a.getLayoutParams()), true);
            } else {
                View a2 = m7069a(flatNativeViewHierarchyManager.m6980d(-i));
                attachViewToParent(a2, -1, m7070a(a2.getLayoutParams()));
                if (this.f5745o) {
                    this.f5748r.remove(Integer.valueOf(-i));
                    DrawView drawView = (DrawView) this.f5747q.get(Integer.valueOf(-i));
                    if (drawView != null) {
                        drawView.f5651d = false;
                    }
                }
            }
        }
        for (int i2 : iArr2) {
            a2 = flatNativeViewHierarchyManager.m6980d(i2);
            if (a2.getParent() != null) {
                removeViewInLayout(a2);
            } else {
                removeDetachedView(a2, false);
            }
            if (this.f5745o) {
                this.f5748r.remove(Integer.valueOf(i2));
            }
        }
        invalidate();
    }

    @Nullable
    private NodeRegion m7073c(float f, float f2) {
        for (int length = this.f5736f.length - 1; length >= 0; length--) {
            NodeRegion nodeRegion = this.f5736f[length];
            if (nodeRegion.f5778h && nodeRegion.m7107a(f, f2)) {
                return nodeRegion;
            }
        }
        return null;
    }

    public final boolean m7083b(float f, float f2) {
        NodeRegion nodeRegion;
        for (int length = this.f5736f.length - 1; length >= 0; length--) {
            nodeRegion = this.f5736f[length];
            if (nodeRegion.m7107a(f, f2)) {
                break;
            }
        }
        nodeRegion = null;
        NodeRegion nodeRegion2 = nodeRegion;
        return nodeRegion2 != null && nodeRegion2.f5778h;
    }

    private View m7069a(View view) {
        ViewParent parent = view.getParent();
        if (parent == null) {
            return view;
        }
        throw new RuntimeException("Cannot add view " + view + " to " + this + " while it has a parent " + parent);
    }

    private void m7072b(AttachDetachListener[] attachDetachListenerArr) {
        if (attachDetachListenerArr.length != 0) {
            if (this.f5733c == null) {
                this.f5733c = new InvalidateCallback(this);
            }
            InvalidateCallback invalidateCallback = this.f5733c;
            for (AttachDetachListener a : attachDetachListenerArr) {
                a.mo157a(invalidateCallback);
            }
        }
    }

    private static void m7074c(AttachDetachListener[] attachDetachListenerArr) {
        for (AttachDetachListener nX_ : attachDetachListenerArr) {
            nX_.nX_();
        }
    }

    private LayoutParams m7070a(LayoutParams layoutParams) {
        return checkLayoutParams(layoutParams) ? layoutParams : generateDefaultLayoutParams();
    }

    public final void m7076a() {
        if (this.f5745o) {
            Assertions.b(this.f5746p);
            ReactClippingViewGroupHelper.a(this, this.f5746p);
            if (getParent() != null && this.f5746p.top != this.f5746p.bottom) {
                m7071b(this.f5746p);
            }
        }
    }

    private void m7071b(Rect rect) {
        DrawCommand[] drawCommandArr = this.f5734d;
        int length = drawCommandArr.length;
        int i = 0;
        boolean z = false;
        int i2 = 0;
        while (i < length) {
            int i3;
            boolean z2;
            DrawCommand drawCommand = drawCommandArr[i];
            if (drawCommand instanceof DrawView) {
                DrawView drawView = (DrawView) drawCommand;
                FlatViewGroup flatViewGroup = (FlatViewGroup) this.f5748r.get(Integer.valueOf(drawView.f5650c));
                if (flatViewGroup == null) {
                    int i4 = i2 + 1;
                    View childAt = getChildAt(i2);
                    if (childAt instanceof FlatViewGroup) {
                        flatViewGroup = (FlatViewGroup) childAt;
                        Animation animation = flatViewGroup.getAnimation();
                        boolean z3 = (animation == null || animation.hasEnded()) ? false : true;
                        if (!(z3 || flatViewGroup.f5749s || rect.intersects(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom()))) {
                            this.f5748r.put(Integer.valueOf(childAt.getId()), flatViewGroup);
                            detachViewFromParent(childAt);
                            drawView.f5651d = true;
                            i3 = i4 - 1;
                            z2 = true;
                        }
                    }
                    z2 = z;
                    i3 = i4;
                } else if (rect.intersects(flatViewGroup.getLeft(), flatViewGroup.getTop(), flatViewGroup.getRight(), flatViewGroup.getBottom())) {
                    int i5 = i2 + 1;
                    attachViewToParent(flatViewGroup, i2, m7070a(flatViewGroup.getLayoutParams()));
                    this.f5748r.remove(Integer.valueOf(flatViewGroup.getId()));
                    drawView.f5651d = false;
                    z2 = true;
                    i3 = i5;
                }
                i++;
                z = z2;
                i2 = i3;
            }
            z2 = z;
            i3 = i2;
            i++;
            z = z2;
            i2 = i3;
        }
        if (z) {
            invalidate();
        }
    }

    public final void m7078a(Rect rect) {
        rect.set(this.f5746p);
    }

    public final void m7082b(boolean z) {
        if (z != this.f5745o) {
            this.f5745o = z;
            if (z) {
                this.f5746p = new Rect();
                m7076a();
                return;
            }
            Assertions.b(this.f5746p);
            getDrawingRect(this.f5746p);
            m7071b(this.f5746p);
            this.f5746p = null;
        }
    }

    public final boolean getRemoveClippedSubviews() {
        return this.f5745o;
    }
}
