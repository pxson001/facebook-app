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
import com.facebook.content.event.FbEventSubscriber;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.loom.logger.api.LoomLogger;
import com.facebook.messaging.contacts.picker.ContactPickerSectionUpsellView.1;
import com.facebook.tools.dextr.runtime.detour.LoomLoggerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.compat.fbrelativelayout.FbRelativeLayout;
import com.google.common.base.Optional;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;

/* compiled from: delivery_receipt_new_send_attempt */
public class CustomRelativeLayout extends FbRelativeLayout implements NoSaveStateView, FbCustomViewGroup {
    @Nullable
    private String f14047a = null;
    @Nullable
    private String f14048b = null;
    @Nullable
    private String f14049c = null;
    private boolean f14050d = true;
    private int f14051e;
    public FbInjector f14052f;
    private FbEventSubscriberListManager f14053g;
    public 1 f14054h;
    private CopyOnWriteArraySet<OnDispatchDrawListener> f14055i;

    protected void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
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
        r4 = this;
        r2 = r4.f14049c;
        if (r2 == 0) goto L_0x0031;
    L_0x0004:
        r0 = 1;
        r1 = r0;
    L_0x0006:
        if (r1 == 0) goto L_0x001a;
    L_0x0008:
        r0 = -1195986438; // 0xffffffffb8b6b1fa float:-8.711587E-5 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r2, r0);
        r0 = 813890108; // 0x3082fa3c float:9.529866E-10 double:4.02115142E-315;
        r0 = com.facebook.tools.dextr.runtime.detour.LoomLoggerDetour.a(r0);
        r3 = "trace section name";
        com.facebook.loom.logger.api.LoomLogger.a(r0, r3, r2);
    L_0x001a:
        super.onLayout(r5, r6, r7, r8, r9);	 Catch:{ RuntimeException -> 0x0034, StackOverflowError -> 0x0043, all -> 0x0052 }
        if (r5 == 0) goto L_0x0028;	 Catch:{ RuntimeException -> 0x0034, StackOverflowError -> 0x0043, all -> 0x0052 }
    L_0x001f:
        r0 = r4.f14054h;	 Catch:{ RuntimeException -> 0x0034, StackOverflowError -> 0x0043, all -> 0x0052 }
        if (r0 == 0) goto L_0x0028;	 Catch:{ RuntimeException -> 0x0034, StackOverflowError -> 0x0043, all -> 0x0052 }
    L_0x0023:
        r0 = r4.f14054h;	 Catch:{ RuntimeException -> 0x0034, StackOverflowError -> 0x0043, all -> 0x0052 }
        r0.a();	 Catch:{ RuntimeException -> 0x0034, StackOverflowError -> 0x0043, all -> 0x0052 }
    L_0x0028:
        if (r1 == 0) goto L_0x0030;
    L_0x002a:
        r0 = -1713978233; // 0xffffffff99d6c487 float:-2.2206458E-23 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
    L_0x0030:
        return;
    L_0x0031:
        r0 = 0;
        r1 = r0;
        goto L_0x0006;
    L_0x0034:
        r0 = move-exception;
        r2 = r4.f14051e;	 Catch:{ RuntimeException -> 0x0034, StackOverflowError -> 0x0043, all -> 0x0052 }
        com.facebook.widget.WrappedViewException.a(r4, r2, r0);	 Catch:{ RuntimeException -> 0x0034, StackOverflowError -> 0x0043, all -> 0x0052 }
        if (r1 == 0) goto L_0x0030;
    L_0x003c:
        r0 = 819144979; // 0x30d32913 float:1.5363945E-9 double:4.04711393E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        goto L_0x0030;
    L_0x0043:
        r0 = move-exception;
        r2 = r4.f14051e;	 Catch:{  }
        com.facebook.widget.WrappedViewException.a(r4, r2, r0);	 Catch:{  }
        if (r1 == 0) goto L_0x0030;
    L_0x004b:
        r0 = -660026058; // 0xffffffffd8a8cd36 float:-1.48479462E15 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        goto L_0x0030;
    L_0x0052:
        r0 = move-exception;
        if (r1 == 0) goto L_0x005b;
    L_0x0055:
        r1 = 888207321; // 0x34f0f7d9 float:4.4883816E-7 double:4.388327237E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
    L_0x005b:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.widget.CustomRelativeLayout.onLayout(boolean, int, int, int, int):void");
    }

    protected void onMeasure(int r5, int r6) {
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
        r4 = this;
        r2 = r4.f14048b;
        if (r2 == 0) goto L_0x0026;
    L_0x0004:
        r0 = 1;
        r1 = r0;
    L_0x0006:
        if (r1 == 0) goto L_0x001a;
    L_0x0008:
        r0 = 1104401477; // 0x41d3d445 float:26.478647 double:5.45646829E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r2, r0);
        r0 = 477850317; // 0x1c7b6acd float:8.318697E-22 double:2.360894255E-315;
        r0 = com.facebook.tools.dextr.runtime.detour.LoomLoggerDetour.a(r0);
        r3 = "traceSectionName";
        com.facebook.loom.logger.api.LoomLogger.a(r0, r3, r2);
    L_0x001a:
        super.onMeasure(r5, r6);	 Catch:{ RuntimeException -> 0x0029, StackOverflowError -> 0x0038, all -> 0x0047 }
        if (r1 == 0) goto L_0x0025;
    L_0x001f:
        r0 = 1760426241; // 0x68edf901 float:8.9903533E24 double:8.697661277E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
    L_0x0025:
        return;
    L_0x0026:
        r0 = 0;
        r1 = r0;
        goto L_0x0006;
    L_0x0029:
        r0 = move-exception;
        r2 = r4.f14051e;	 Catch:{ RuntimeException -> 0x0029, StackOverflowError -> 0x0038, all -> 0x0047 }
        com.facebook.widget.WrappedViewException.a(r4, r2, r0);	 Catch:{ RuntimeException -> 0x0029, StackOverflowError -> 0x0038, all -> 0x0047 }
        if (r1 == 0) goto L_0x0025;
    L_0x0031:
        r0 = -1053747978; // 0xffffffffc13114f6 float:-11.067617 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        goto L_0x0025;
    L_0x0038:
        r0 = move-exception;
        r2 = r4.f14051e;	 Catch:{  }
        com.facebook.widget.WrappedViewException.a(r4, r2, r0);	 Catch:{  }
        if (r1 == 0) goto L_0x0025;
    L_0x0040:
        r0 = 1192892084; // 0x471a16b4 float:39446.703 double:5.89366998E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        goto L_0x0025;
    L_0x0047:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0050;
    L_0x004a:
        r1 = 373484551; // 0x1642ec07 float:1.5745672E-25 double:1.84525886E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
    L_0x0050:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.widget.CustomRelativeLayout.onMeasure(int, int):void");
    }

    public CustomRelativeLayout(Context context) {
        super(context);
        m14858a(context, null, 0);
    }

    public CustomRelativeLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m14858a(context, attributeSet, 0);
    }

    public CustomRelativeLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14858a(context, attributeSet, i);
    }

    private final void m14858a(Context context, @Nullable AttributeSet attributeSet, int i) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CustomRelativeLayout, i, i);
            this.f14047a = obtainStyledAttributes.getString(0);
            obtainStyledAttributes.recycle();
            if (this.f14047a != null) {
                this.f14048b = this.f14047a + ".onMeasure";
                this.f14049c = this.f14047a + ".onLayout";
            }
        }
        this.f14052f = FbInjector.get(context);
    }

    public void setContentView(int i) {
        String str;
        this.f14051e = i;
        if (this.f14047a != null) {
            str = this.f14047a;
        } else {
            str = getClass().getSimpleName();
        }
        if (getContext() == null || getContext().getResources() == null) {
            TracerDetour.a("%s.setContentView", str, -963637419);
            LoomLogger.a(LoomLoggerDetour.a(1625373904), "setContentView", str);
        } else {
            TracerDetour.a("%s.setContentView(%s)", new Object[]{str, getContext().getResources().getResourceName(i)}, 355322536);
            LoomLogger.a(LoomLoggerDetour.a(-1406958441), str + "setContentView", getContext().getResources().getResourceName(i));
        }
        try {
            LayoutInflater.from(getContext()).inflate(i, this);
        } catch (Throwable e) {
            WrappedViewException.a(this, this.f14051e, e);
        } catch (Throwable e2) {
            WrappedViewException.a(this, this.f14051e, e2);
        } finally {
            TracerDetour.a(2121427476);
        }
    }

    @Deprecated
    protected FbInjector getInjector() {
        return this.f14052f;
    }

    public final <T extends View> T m14861a(int i) {
        return FindViewUtil.b(this, i);
    }

    public final <T extends View> Optional<T> m14863b(int i) {
        return FindViewUtil.a(this, i);
    }

    public void detachRecyclableViewFromParent(View view) {
        super.detachViewFromParent(view);
        requestLayout();
    }

    public void attachRecyclableViewToParent(View view, int i, LayoutParams layoutParams) {
        if (!(view instanceof IViewAttachAware) || !RecyclableViewHelper.a(this, view, i)) {
            super.attachViewToParent(view, i, layoutParams);
            requestLayout();
        }
    }

    public void removeRecyclableViewFromParent(View view, boolean z) {
        super.removeDetachedView(view, z);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -622227747);
        super.onAttachedToWindow();
        mo394b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1807901340, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1549641150);
        super.onDetachedFromWindow();
        mo378c();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2144173716, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        mo378c();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        mo394b();
    }

    private void mo394b() {
        if (this.f14053g != null) {
            this.f14053g.a(getEventBus());
        }
    }

    private void mo378c() {
        if (this.f14053g != null) {
            this.f14053g.b(getEventBus());
        }
    }

    protected <T extends FbEventBus> T getEventBus() {
        return null;
    }

    public final boolean m14862a(FbEventSubscriber fbEventSubscriber) {
        if (this.f14053g == null) {
            this.f14053g = new FbEventSubscriberListManager();
        }
        return this.f14053g.a(fbEventSubscriber);
    }

    public void setSaveFromParentEnabledCompat(boolean z) {
        this.f14050d = z;
    }

    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
        super.dispatchSaveInstanceState(sparseArray);
    }

    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
        super.dispatchRestoreInstanceState(sparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        if (this.f14050d) {
            super.dispatchSaveInstanceState(sparseArray);
        }
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        if (this.f14050d) {
            super.dispatchRestoreInstanceState(sparseArray);
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
            if (this.f14055i != null) {
                Collection a = Sets.a();
                Iterator it = this.f14055i.iterator();
                while (it.hasNext()) {
                    OnDispatchDrawListener onDispatchDrawListener = (OnDispatchDrawListener) it.next();
                    if (onDispatchDrawListener.a()) {
                        a.add(onDispatchDrawListener);
                    }
                }
                this.f14055i.removeAll(a);
                if (this.f14055i.isEmpty()) {
                    this.f14055i = null;
                }
            }
        } catch (Throwable e) {
            WrappedViewException.a(this, this.f14051e, e);
        } catch (Throwable e2) {
            WrappedViewException.a(this, this.f14051e, e2);
        }
    }

    public ViewGroup asViewGroup() {
        return this;
    }
}
