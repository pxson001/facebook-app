package com.facebook.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.app.NoSaveStateView;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.R;
import com.facebook.common.util.FindViewUtil;
import com.facebook.content.event.FbEventBus;
import com.facebook.content.event.FbEventSubscriber;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Optional;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;

/* compiled from: skipSameController */
public class CustomLinearLayout extends LinearLayout implements NoSaveStateView, FbCustomViewGroup {
    @Nullable
    private String f4713a = null;
    @Nullable
    private String f4714b = null;
    @Nullable
    private String f4715c = null;
    @Nullable
    private Drawable f4716d;
    private boolean f4717e = true;
    private boolean f4718f = true;
    private int f4719g;
    private FbEventSubscriberListManager f4720h;
    private CopyOnWriteArraySet<OnDispatchDrawListener> f4721i;

    protected void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r2 = r3.f4715c;
        if (r2 == 0) goto L_0x001a;
    L_0x0004:
        r0 = 1;
        r1 = r0;
    L_0x0006:
        if (r1 == 0) goto L_0x000e;
    L_0x0008:
        r0 = 1897558862; // 0x711a734e float:7.648014E29 double:9.375186447E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r2, r0);
    L_0x000e:
        super.onLayout(r4, r5, r6, r7, r8);	 Catch:{ RuntimeException -> 0x001d, StackOverflowError -> 0x002c, all -> 0x003b }
        if (r1 == 0) goto L_0x0019;
    L_0x0013:
        r0 = -1135152635; // 0xffffffffbc56f205 float:-0.013119225 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
    L_0x0019:
        return;
    L_0x001a:
        r0 = 0;
        r1 = r0;
        goto L_0x0006;
    L_0x001d:
        r0 = move-exception;
        r2 = r3.f4719g;	 Catch:{ RuntimeException -> 0x001d, StackOverflowError -> 0x002c, all -> 0x003b }
        com.facebook.widget.WrappedViewException.a(r3, r2, r0);	 Catch:{ RuntimeException -> 0x001d, StackOverflowError -> 0x002c, all -> 0x003b }
        if (r1 == 0) goto L_0x0019;
    L_0x0025:
        r0 = 776029012; // 0x2e414354 float:4.394292E-11 double:3.83409275E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        goto L_0x0019;
    L_0x002c:
        r0 = move-exception;
        r2 = r3.f4719g;	 Catch:{  }
        com.facebook.widget.WrappedViewException.a(r3, r2, r0);	 Catch:{  }
        if (r1 == 0) goto L_0x0019;
    L_0x0034:
        r0 = -1549704968; // 0xffffffffa3a160f8 float:-1.7496723E-17 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        goto L_0x0019;
    L_0x003b:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0044;
    L_0x003e:
        r1 = -1357054523; // 0xffffffffaf1cfdc5 float:-1.4278274E-10 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
    L_0x0044:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.widget.CustomLinearLayout.onLayout(boolean, int, int, int, int):void");
    }

    protected void onMeasure(int r4, int r5) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r2 = r3.f4714b;
        if (r2 == 0) goto L_0x001a;
    L_0x0004:
        r0 = 1;
        r1 = r0;
    L_0x0006:
        if (r1 == 0) goto L_0x000e;
    L_0x0008:
        r0 = -148907672; // 0xfffffffff71fd968 float:-3.2421278E33 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r2, r0);
    L_0x000e:
        super.onMeasure(r4, r5);	 Catch:{ RuntimeException -> 0x001d, StackOverflowError -> 0x002c, all -> 0x003b }
        if (r1 == 0) goto L_0x0019;
    L_0x0013:
        r0 = -441725254; // 0xffffffffe5abceba float:-1.0141726E23 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
    L_0x0019:
        return;
    L_0x001a:
        r0 = 0;
        r1 = r0;
        goto L_0x0006;
    L_0x001d:
        r0 = move-exception;
        r2 = r3.f4719g;	 Catch:{ RuntimeException -> 0x001d, StackOverflowError -> 0x002c, all -> 0x003b }
        com.facebook.widget.WrappedViewException.a(r3, r2, r0);	 Catch:{ RuntimeException -> 0x001d, StackOverflowError -> 0x002c, all -> 0x003b }
        if (r1 == 0) goto L_0x0019;
    L_0x0025:
        r0 = -1727231000; // 0xffffffff990c8be8 float:-7.266084E-24 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        goto L_0x0019;
    L_0x002c:
        r0 = move-exception;
        r2 = r3.f4719g;	 Catch:{  }
        com.facebook.widget.WrappedViewException.a(r3, r2, r0);	 Catch:{  }
        if (r1 == 0) goto L_0x0019;
    L_0x0034:
        r0 = -1165488897; // 0xffffffffba880cff float:-0.001037985 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        goto L_0x0019;
    L_0x003b:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0044;
    L_0x003e:
        r1 = 420976946; // 0x19179932 float:7.8374546E-24 double:2.079902467E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
    L_0x0044:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.widget.CustomLinearLayout.onMeasure(int, int):void");
    }

    public CustomLinearLayout(Context context) {
        super(context);
        m8503a(context, null, 0);
    }

    public CustomLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m8503a(context, attributeSet, 0);
    }

    public CustomLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8503a(context, attributeSet, i);
    }

    private final void m8503a(Context context, @Nullable AttributeSet attributeSet, int i) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CustomLinearLayout, i, 0);
            this.f4713a = obtainStyledAttributes.getString(0);
            obtainStyledAttributes.recycle();
            if (this.f4713a != null) {
                this.f4714b = this.f4713a + ".onMeasure";
                this.f4715c = this.f4713a + ".onLayout";
            }
        }
    }

    public void setContentView(int i) {
        this.f4719g = i;
        Object simpleName = this.f4713a != null ? this.f4713a : getClass().getSimpleName();
        if (getContext() == null || getContext().getResources() == null) {
            TracerDetour.a("%s.setContentView", simpleName, 1504134084);
        } else {
            TracerDetour.a("%s.setContentView(%s)", new Object[]{simpleName, getContext().getResources().getResourceName(i)}, -404698601);
        }
        try {
            LayoutInflater.from(getContext()).inflate(i, this);
        } catch (Throwable e) {
            WrappedViewException.a(this, this.f4719g, e);
        } catch (Throwable e2) {
            WrappedViewException.a(this, this.f4719g, e2);
        } finally {
            TracerDetour.a(1363444684);
        }
    }

    @Deprecated
    protected FbInjector getInjector() {
        return FbInjector.get(getContext());
    }

    public final <T extends View> T m8506a(int i) {
        return FindViewUtil.m6202b((View) this, i);
    }

    protected final <T extends View> Optional<T> m8509b(int i) {
        return FindViewUtil.m6200a(this, i);
    }

    public final void m8507a(OnDispatchDrawListener onDispatchDrawListener) {
        if (this.f4721i == null) {
            this.f4721i = new CopyOnWriteArraySet();
        }
        this.f4721i.add(onDispatchDrawListener);
    }

    public void setForeground(Drawable drawable) {
        if (this.f4716d != drawable) {
            if (this.f4716d != null) {
                this.f4716d.setCallback(null);
                unscheduleDrawable(this.f4716d);
            }
            this.f4716d = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
            } else {
                setWillNotDraw(true);
            }
            this.f4717e = true;
            invalidate();
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.f4716d != null) {
            boolean z;
            Drawable drawable = this.f4716d;
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            drawable.setVisible(z, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f4716d;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f4716d != null && this.f4716d.isStateful()) {
            this.f4716d.setState(getDrawableState());
        }
    }

    public void detachRecyclableViewFromParent(View view) {
        super.detachViewFromParent(view);
        requestLayout();
    }

    public void attachRecyclableViewToParent(View view, int i, @Nullable LayoutParams layoutParams) {
        if (!(view instanceof IViewAttachAware) || !RecyclableViewHelper.a(this, view, i)) {
            super.attachViewToParent(view, i, layoutParams);
            requestLayout();
        }
    }

    public void removeRecyclableViewFromParent(View view, boolean z) {
        super.removeDetachedView(view, z);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1116376947);
        super.onAttachedToWindow();
        mo1242b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2123569386, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 187153114);
        super.onDetachedFromWindow();
        mo1243g();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 643555936, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        mo1243g();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        mo1242b();
    }

    private void mo1242b() {
        if (this.f4720h != null) {
            this.f4720h.m14131a(getEventBus());
        }
    }

    private void mo1243g() {
        if (this.f4720h != null) {
            this.f4720h.m14134b(getEventBus());
        }
    }

    protected <T extends FbEventBus> T getEventBus() {
        return null;
    }

    public final boolean m8508a(FbEventSubscriber fbEventSubscriber) {
        if (this.f4720h == null) {
            this.f4720h = new FbEventSubscriberListManager();
        }
        return this.f4720h.m14133a(fbEventSubscriber);
    }

    public void setSaveFromParentEnabledCompat(boolean z) {
        this.f4718f = z;
    }

    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
        super.dispatchSaveInstanceState(sparseArray);
    }

    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
        try {
            super.dispatchRestoreInstanceState(sparseArray);
        } catch (Throwable e) {
            WrappedViewException.a(this, this.f4719g, e);
        }
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        if (this.f4718f) {
            super.dispatchSaveInstanceState(sparseArray);
        }
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        if (this.f4718f) {
            super.dispatchRestoreInstanceState(sparseArray);
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
            if (this.f4721i != null) {
                Collection a = Sets.m1313a();
                Iterator it = this.f4721i.iterator();
                while (it.hasNext()) {
                    OnDispatchDrawListener onDispatchDrawListener = (OnDispatchDrawListener) it.next();
                    if (onDispatchDrawListener.mo1728a()) {
                        a.add(onDispatchDrawListener);
                    }
                }
                this.f4721i.removeAll(a);
                if (this.f4721i.isEmpty()) {
                    this.f4721i = null;
                }
            }
        } catch (Throwable e) {
            WrappedViewException.a(this, this.f4719g, e);
        } catch (Throwable e2) {
            WrappedViewException.a(this, this.f4719g, e2);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f4716d != null) {
            if (this.f4717e) {
                this.f4717e = false;
                this.f4716d.setBounds(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
            }
            this.f4716d.draw(canvas);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1915595218);
        super.onSizeChanged(i, i2, i3, i4);
        this.f4717e = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 454517865, a);
    }

    public ViewGroup asViewGroup() {
        return this;
    }
}
