package com.facebook.components;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.components.fb.logger.QPLComponentsLogger;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: getMutableFlatBuffer is not supported */
public class ComponentView extends ComponentHost {
    private static final int[] f22533d = new int[2];
    public ComponentTree f22534a;
    public final MountState f22535b;
    private boolean f22536c;

    public ComponentView(Context context) {
        this(context, null);
    }

    public ComponentView(Context context, AttributeSet attributeSet) {
        this(new ComponentContext(context), attributeSet);
    }

    public ComponentView(ComponentContext componentContext) {
        this(componentContext, null);
    }

    public ComponentView(ComponentContext componentContext, AttributeSet attributeSet) {
        super(componentContext, attributeSet);
        this.f22535b = new MountState(this);
    }

    String getLogTag() {
        return this.f22534a == null ? null : this.f22534a.f22684p;
    }

    QPLComponentsLogger getLogger() {
        return this.f22534a == null ? null : this.f22534a.f22683o;
    }

    private static void m30423b(ComponentHost componentHost) {
        int childCount = componentHost.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = componentHost.getChildAt(i);
            if (childAt.isLayoutRequested()) {
                childAt.measure(MeasureSpec.makeMeasureSpec(childAt.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(childAt.getHeight(), 1073741824));
                childAt.layout(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            }
            if (childAt instanceof ComponentHost) {
                m30423b((ComponentHost) childAt);
            }
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -38114717);
        super.onAttachedToWindow();
        m30424m();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1708122157, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -330847500);
        super.onDetachedFromWindow();
        m30425n();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -937859485, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        m30425n();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        m30424m();
    }

    private void m30424m() {
        if (!this.f22536c) {
            this.f22536c = true;
            if (this.f22534a != null) {
                this.f22534a.m30632a();
            }
        }
    }

    private void m30425n() {
        if (this.f22536c) {
            this.f22536c = false;
            if (this.f22534a != null) {
                if (this.f22534a.f22678j) {
                    this.f22535b.m30498e();
                } else {
                    this.f22535b.m30497d();
                }
                this.f22534a.m30642f();
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (this.f22534a != null) {
            this.f22534a.m30635a(i, i2, f22533d);
            size = f22533d[0];
            size2 = f22533d[1];
        }
        setMeasuredDimension(size, size2);
    }

    protected final void mo3289c() {
        if (this.f22534a != null && !this.f22534a.m30644h()) {
            m30423b(this);
        }
    }

    protected final boolean mo3290d() {
        if (this.f22534a == null || !this.f22534a.f22676h) {
            return super.mo3290d();
        }
        return false;
    }

    public ComponentTree getComponent() {
        return this.f22534a;
    }

    public void setComponent(ComponentTree componentTree) {
        if (this.f22534a != componentTree) {
            m30433k();
            if (this.f22534a != null) {
                if (!this.f22534a.f22678j) {
                    this.f22535b.m30497d();
                }
                if (this.f22536c) {
                    this.f22534a.m30642f();
                }
                this.f22534a.m30643g();
            }
            this.f22534a = componentTree;
            if (this.f22534a != null) {
                this.f22534a.m30638a(this);
                if (this.f22536c) {
                    this.f22534a.m30632a();
                }
            }
        } else if (this.f22536c) {
            m30429e();
        }
    }

    public final void m30429e() {
        this.f22535b.m30499f();
    }

    public final void m30430f() {
        this.f22535b.m30498e();
    }

    final void m30431g() {
        if (this.f22536c) {
            throw new IllegalStateException("Trying to clear the ComponentTree while attached.");
        }
        this.f22534a = null;
    }

    protected final void m30426a(Rect rect) {
        if (this.f22534a.m30645i()) {
            this.f22534a.m30636a(rect);
            return;
        }
        throw new IllegalStateException("To perform incremental mounting, you need first to enable it when creating the ComponentTree.");
    }

    public final void mo3291h() {
        if (this.f22534a.m30645i()) {
            this.f22534a.m30641e();
            return;
        }
        throw new IllegalStateException("To perform incremental mounting, you need first to enable it when creating the ComponentTree.");
    }

    final void m30433k() {
        MountState mountState = this.f22535b;
        ThreadUtils.m30579b();
        mountState.f22575c = true;
    }

    final boolean m30434l() {
        MountState mountState = this.f22535b;
        ThreadUtils.m30579b();
        return mountState.f22575c;
    }
}
