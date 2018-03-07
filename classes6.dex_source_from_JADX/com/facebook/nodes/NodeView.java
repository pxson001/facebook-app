package com.facebook.nodes;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityNodeProvider;
import com.facebook.R;
import com.facebook.accessibility.AccessibilityHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nodes.canvas.DeferredModeRenderState;
import com.facebook.nodes.canvas.RenderState;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: thread_tile */
public class NodeView extends ViewGroup {
    public RenderState f3132a;
    private BaseThreadingModel f3133b;
    private Controller f3134c;
    private AccessibilityHelper f3135d;

    public NodeView(Context context) {
        this(context, null);
    }

    public NodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3132a = new DeferredModeRenderState();
        this.f3133b = new SyncThreadingModel(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NodeView, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId > 0) {
            setNode(NodeInflater.m4168a(getContext()).m4172a(resourceId));
        }
        obtainStyledAttributes.recycle();
        if (VERSION.SDK_INT >= 16) {
            this.f3135d = new NodeViewAccessibilityHelper(this);
        }
        setWillNotDraw(false);
    }

    public void setContentNode(int i) {
        setNode(NodeInflater.m4168a(getContext()).m4172a(i));
    }

    public final <T extends Node> T m4173a(int i) {
        T b = getNode().mo179b(i);
        if (b != null) {
            return b;
        }
        throw new IllegalStateException("Required node with ID " + getResources().getResourceEntryName(i) + " is not found");
    }

    public void setController(Controller controller) {
        this.f3134c = controller;
    }

    public Controller getController() {
        return this.f3134c;
    }

    public void setNode(Node node) {
        if (node.f3075f == null) {
            node.mo205a(new LayoutParams(-1, -1));
        }
        this.f3132a.f3186a = node;
        this.f3133b.mo194a(node);
    }

    public Node getNode() {
        return this.f3133b.mo196e();
    }

    public void setRenderState(RenderState renderState) {
        this.f3132a = renderState;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        this.f3132a.mo207a(canvas);
    }

    protected void dispatchDraw(Canvas canvas) {
    }

    public void requestLayout() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.isLayoutRequested()) {
                ((Node) childAt.getTag(2131558567)).m4107s();
            }
        }
        super.requestLayout();
    }

    protected void onMeasure(int i, int i2) {
        this.f3133b.mo193a(i, i2);
        setMeasuredDimension(Node.m4076d((this.f3133b.mo197f() + getPaddingLeft()) + getPaddingRight(), i), Node.m4076d((this.f3133b.mo198g() + getPaddingTop()) + getPaddingBottom(), i2));
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.f3135d == null || !this.f3135d.a(motionEvent)) {
            return super.dispatchHoverEvent(motionEvent);
        }
        return true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f3133b.mo199h();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean a;
        int a2 = Logger.a(2, EntryType.UI_INPUT_START, -1917403748);
        BaseThreadingModel baseThreadingModel = this.f3133b;
        if (baseThreadingModel.f3069e != null) {
            a = baseThreadingModel.f3069e.mo175a(motionEvent, baseThreadingModel.f3065a);
            int action = motionEvent.getAction();
            if (action == 1 || action == 3) {
                baseThreadingModel.f3069e = null;
            }
        } else {
            int size = baseThreadingModel.f3068d.size();
            for (int i = 0; i < size; i++) {
                TouchHandler touchHandler = (TouchHandler) baseThreadingModel.f3068d.get(i);
                if (touchHandler.mo175a(motionEvent, baseThreadingModel.f3065a)) {
                    baseThreadingModel.f3069e = touchHandler;
                    a = true;
                    break;
                }
            }
            a = false;
        }
        if (a) {
            Logger.a(2, EntryType.UI_INPUT_END, 627624705, a2);
            return true;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        LogUtils.a(659863369, a2);
        return onTouchEvent;
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return true;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f3133b.mo195a(getDrawableState());
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -278452693);
        super.onAttachedToWindow();
        this.f3133b.m4064b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1299325568, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1528352264);
        super.onDetachedFromWindow();
        this.f3133b.m4067c();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1253838707, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f3133b.m4067c();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f3133b.m4064b();
    }

    public void invalidateDrawable(Drawable drawable) {
        if (super.verifyDrawable(drawable)) {
            super.invalidateDrawable(drawable);
        } else if (1 != 0) {
            invalidate();
        }
    }

    public void onRtlPropertiesChanged(int i) {
        this.f3133b.mo192a(i);
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        return (AccessibilityNodeProvider) this.f3135d.b;
    }
}
