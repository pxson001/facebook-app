package com.facebook.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Parcelable;
import android.support.v4.app.NoSaveStateView;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.R;
import com.facebook.common.util.FindViewUtil;
import com.facebook.content.event.FbEventBus;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbFrameLayout;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Optional;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nullable;

/* compiled from: o.0 */
public class CustomFrameLayout extends FbFrameLayout implements NoSaveStateView, FbCustomViewGroup {
    @Nullable
    private String f11668a = null;
    @Nullable
    private String f11669b = null;
    @Nullable
    private String f11670c = null;
    private boolean f11671d = true;
    private CopyOnWriteArrayList<OnDispatchDrawListener> f11672e;
    private int f11673f;
    private FbEventSubscriberListManager f11674g;

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
        r2 = r3.f11670c;
        if (r2 == 0) goto L_0x001a;
    L_0x0004:
        r0 = 1;
        r1 = r0;
    L_0x0006:
        if (r1 == 0) goto L_0x000e;
    L_0x0008:
        r0 = 237563777; // 0xe28ef81 float:2.0822916E-30 double:1.17372101E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r2, r0);
    L_0x000e:
        super.onLayout(r4, r5, r6, r7, r8);	 Catch:{ RuntimeException -> 0x001d, StackOverflowError -> 0x002c, all -> 0x003b }
        if (r1 == 0) goto L_0x0019;
    L_0x0013:
        r0 = -1760800179; // 0xffffffff970c524d float:-4.534032E-25 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
    L_0x0019:
        return;
    L_0x001a:
        r0 = 0;
        r1 = r0;
        goto L_0x0006;
    L_0x001d:
        r0 = move-exception;
        r2 = r3.f11673f;	 Catch:{ RuntimeException -> 0x001d, StackOverflowError -> 0x002c, all -> 0x003b }
        com.facebook.widget.WrappedViewException.a(r3, r2, r0);	 Catch:{ RuntimeException -> 0x001d, StackOverflowError -> 0x002c, all -> 0x003b }
        if (r1 == 0) goto L_0x0019;
    L_0x0025:
        r0 = 568867183; // 0x21e8396f float:1.5736134E-18 double:2.81057732E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        goto L_0x0019;
    L_0x002c:
        r0 = move-exception;
        r2 = r3.f11673f;	 Catch:{  }
        com.facebook.widget.WrappedViewException.a(r3, r2, r0);	 Catch:{  }
        if (r1 == 0) goto L_0x0019;
    L_0x0034:
        r0 = -790861244; // 0xffffffffd0dc6a44 float:-2.9583614E10 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        goto L_0x0019;
    L_0x003b:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0044;
    L_0x003e:
        r1 = 1425475279; // 0x54f706cf float:8.4877692E12 double:7.042783643E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
    L_0x0044:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.widget.CustomFrameLayout.onLayout(boolean, int, int, int, int):void");
    }

    public void onMeasure(int r4, int r5) {
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
        r2 = r3.f11669b;
        if (r2 == 0) goto L_0x001a;
    L_0x0004:
        r0 = 1;
        r1 = r0;
    L_0x0006:
        if (r1 == 0) goto L_0x000e;
    L_0x0008:
        r0 = -848304154; // 0xffffffffcd6fe7e6 float:-2.5155952E8 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r2, r0);
    L_0x000e:
        super.onMeasure(r4, r5);	 Catch:{ RuntimeException -> 0x001d, StackOverflowError -> 0x002c, all -> 0x003b }
        if (r1 == 0) goto L_0x0019;
    L_0x0013:
        r0 = 1675391452; // 0x63dc71dc float:8.132976E21 double:8.2775336E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
    L_0x0019:
        return;
    L_0x001a:
        r0 = 0;
        r1 = r0;
        goto L_0x0006;
    L_0x001d:
        r0 = move-exception;
        r2 = r3.f11673f;	 Catch:{ RuntimeException -> 0x001d, StackOverflowError -> 0x002c, all -> 0x003b }
        com.facebook.widget.WrappedViewException.a(r3, r2, r0);	 Catch:{ RuntimeException -> 0x001d, StackOverflowError -> 0x002c, all -> 0x003b }
        if (r1 == 0) goto L_0x0019;
    L_0x0025:
        r0 = 735485904; // 0x2bd69fd0 float:1.5249971E-12 double:3.63378318E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        goto L_0x0019;
    L_0x002c:
        r0 = move-exception;
        r2 = r3.f11673f;	 Catch:{  }
        com.facebook.widget.WrappedViewException.a(r3, r2, r0);	 Catch:{  }
        if (r1 == 0) goto L_0x0019;
    L_0x0034:
        r0 = -972226976; // 0xffffffffc60cfe60 float:-9023.594 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        goto L_0x0019;
    L_0x003b:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0044;
    L_0x003e:
        r1 = -1941686848; // 0xffffffff8c4435c0 float:-1.5115466E-31 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
    L_0x0044:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.widget.CustomFrameLayout.onMeasure(int, int):void");
    }

    public CustomFrameLayout(Context context) {
        super(context);
        m16952a(context, null, 0);
    }

    public CustomFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m16952a(context, attributeSet, 0);
    }

    public CustomFrameLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16952a(context, attributeSet, i);
    }

    private final void m16952a(Context context, @Nullable AttributeSet attributeSet, int i) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CustomFrameLayout, i, i);
            this.f11668a = obtainStyledAttributes.getString(0);
            obtainStyledAttributes.recycle();
            if (this.f11668a != null) {
                this.f11669b = this.f11668a + ".onMeasure";
                this.f11670c = this.f11668a + ".onLayout";
            }
        }
    }

    public void setContentView(int i) {
        this.f11673f = i;
        TracerDetour.a("%s.setContentView", this.f11668a != null ? this.f11668a : getClass().getSimpleName(), 281185178);
        try {
            LayoutInflater.from(getContext()).inflate(i, this);
        } catch (Throwable e) {
            WrappedViewException.a(this, this.f11673f, e);
        } catch (Throwable e2) {
            WrappedViewException.a(this, this.f11673f, e2);
        } finally {
            TracerDetour.a(1128137987);
        }
    }

    public final <T extends View> T m16956c(int i) {
        return FindViewUtil.m6202b((View) this, i);
    }

    public final <T extends View> Optional<T> m16957d(int i) {
        return FindViewUtil.m6200a(this, i);
    }

    public void detachRecyclableViewFromParent(View view) {
        super.detachViewFromParent(view);
        requestLayout();
    }

    public void attachRecyclableViewToParent(View view, int i, LayoutParams layoutParams) {
        if (!(view instanceof RecyclableView) || !RecyclableViewHelper.a(this, view, i)) {
            super.attachViewToParent(view, i, layoutParams);
            requestLayout();
        }
    }

    public void removeRecyclableViewFromParent(View view, boolean z) {
        super.removeDetachedView(view, z);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1337125802);
        super.onAttachedToWindow();
        gI_();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1525131183, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1646192049);
        super.onDetachedFromWindow();
        gJ_();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1938844599, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        gJ_();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        gI_();
    }

    public void dispatchDraw(Canvas canvas) {
        try {
            m16953a(canvas);
        } catch (Throwable e) {
            WrappedViewException.a(this, this.f11673f, e);
        } catch (Throwable e2) {
            WrappedViewException.a(this, this.f11673f, e2);
        }
    }

    private void m16953a(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f11672e != null && !this.f11672e.isEmpty()) {
            Iterator it = this.f11672e.iterator();
            while (it.hasNext()) {
                OnDispatchDrawListener onDispatchDrawListener = (OnDispatchDrawListener) it.next();
                if (onDispatchDrawListener.mo1728a()) {
                    this.f11672e.remove(onDispatchDrawListener);
                }
            }
        }
    }

    public final void m16954a(OnDispatchDrawListener onDispatchDrawListener) {
        if (this.f11672e == null) {
            this.f11672e = new CopyOnWriteArrayList();
        }
        this.f11672e.add(onDispatchDrawListener);
    }

    public final void m16955b(OnDispatchDrawListener onDispatchDrawListener) {
        if (this.f11672e != null) {
            this.f11672e.remove(onDispatchDrawListener);
        }
    }

    protected void gI_() {
        if (this.f11674g != null) {
            this.f11674g.m14131a(null);
        }
    }

    protected void gJ_() {
        if (this.f11674g != null) {
            this.f11674g.m14134b(null);
        }
    }

    protected <T extends FbEventBus> T getEventBus() {
        return null;
    }

    public void setSaveFromParentEnabledCompat(boolean z) {
        this.f11671d = z;
    }

    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
        super.dispatchSaveInstanceState(sparseArray);
    }

    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
        super.dispatchRestoreInstanceState(sparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        if (this.f11671d) {
            super.dispatchSaveInstanceState(sparseArray);
        }
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        if (this.f11671d) {
            super.dispatchRestoreInstanceState(sparseArray);
        }
    }

    public ViewGroup asViewGroup() {
        return this;
    }
}
