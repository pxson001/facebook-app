package com.facebook.components;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.util.Pools$SimplePool;
import android.support.v4.util.Pools$SynchronizedPool;
import android.support.v4.util.SparseArrayCompat;
import android.util.SparseArray;
import com.facebook.components.ComponentTree.Builder;
import com.facebook.components.displaylist.DisplayList;
import com.facebook.components.reference.Reference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: getExtra called when mMutationSupported = false */
public class ComponentsPools {
    static boolean f22591a;
    public static final Pools$SynchronizedPool<LayoutState> f22592b = new Pools$SynchronizedPool(64);
    public static final Pools$SynchronizedPool<InternalNode> f22593c = new Pools$SynchronizedPool(256);
    private static final Pools$SynchronizedPool<MountItem> f22594d = new Pools$SynchronizedPool(256);
    private static final Pools$SynchronizedPool<ViewMountItem> f22595e = new Pools$SynchronizedPool(64);
    public static final Map<Context, SparseArray<Pools$SimplePool<Object>>> f22596f = new HashMap(4);
    private static final Pools$SynchronizedPool<LayoutOutput> f22597g = new Pools$SynchronizedPool(256);
    private static final Pools$SynchronizedPool<ViewLayoutOutput> f22598h = new Pools$SynchronizedPool(64);
    private static final Pools$SynchronizedPool<Output<?>> f22599i = new Pools$SynchronizedPool(20);
    public static final Pools$SynchronizedPool<DiffNode> f22600j = new Pools$SynchronizedPool(256);
    public static final Pools$SynchronizedPool<Diff<?>> f22601k = new Pools$SynchronizedPool(20);
    public static final Pools$SynchronizedPool<Builder> f22602l = new Pools$SynchronizedPool(2);
    private static final Pools$SimplePool<SparseArrayCompat<MountItem>> f22603m = new Pools$SimplePool(8);
    public static final Pools$SimplePool<SparseArrayCompat<Touchable>> f22604n = new Pools$SimplePool(4);
    private static final Pools$SimplePool<RectF> f22605o = new Pools$SimplePool(4);
    private static PoolsActivityCallback f22606p;

    @TargetApi(14)
    /* compiled from: getExtra called when mMutationSupported = false */
    class PoolsActivityCallback implements ActivityLifecycleCallbacks {
        public void onActivityCreated(Activity activity, Bundle bundle) {
            ComponentsPools.m30518a(activity);
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            ComponentsPools.f22596f.remove(activity);
            Iterator it = ComponentsPools.f22596f.entrySet().iterator();
            while (it.hasNext()) {
                Object obj;
                Context context = (Context) ((Entry) it.next()).getKey();
                while (context instanceof ContextWrapper) {
                    context = ((ContextWrapper) context).getBaseContext();
                    if (context == activity) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    it.remove();
                }
            }
        }
    }

    public static void m30526a(Output output) {
        output.f22989a = null;
        f22599i.mo741a(output);
    }

    private ComponentsPools() {
    }

    static LayoutState m30514a(ComponentContext componentContext) {
        LayoutState layoutState = (LayoutState) f22592b.mo740a();
        if (layoutState == null) {
            layoutState = new LayoutState();
        }
        layoutState.f22646a = componentContext;
        layoutState.f22655j.set(1);
        return layoutState;
    }

    static MountItem m30515a(Component<?> component, ComponentHost componentHost, Object obj, CharSequence charSequence, EventHandler eventHandler, SparseArray<Object> sparseArray, DisplayList displayList, int i, int i2) {
        MountItem mountItem = (MountItem) f22594d.mo740a();
        if (mountItem == null) {
            mountItem = new MountItem();
        }
        mountItem.m30539a(component, componentHost, obj, charSequence, sparseArray, eventHandler, displayList, i, i2);
        return mountItem;
    }

    static ViewMountItem m30516a(Component<?> component, ComponentHost componentHost, Object obj, CharSequence charSequence, SparseArray<Object> sparseArray, EventHandler eventHandler, int i, int i2, int i3, Rect rect, Reference<Drawable> reference, Reference<Drawable> reference2) {
        ViewMountItem viewMountItem = (ViewMountItem) f22595e.mo740a();
        if (viewMountItem == null) {
            viewMountItem = new ViewMountItem();
        }
        viewMountItem.m30535a(component, componentHost, obj, charSequence, sparseArray, eventHandler, i, i2, i3, rect, reference, reference2);
        return viewMountItem;
    }

    static Object m30517a(Context context, int i) {
        ThreadUtils.m30579b();
        if (f22606p == null && !f22591a) {
            if (VERSION.SDK_INT < 14) {
                throw new RuntimeException("Activity callbacks must be invoked manually below ICS (API level 14)");
            }
            f22606p = new PoolsActivityCallback();
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(f22606p);
        }
        SparseArray sparseArray = (SparseArray) f22596f.get(context);
        if (sparseArray == null) {
            f22596f.put(context, new SparseArray());
            return null;
        }
        Pools$SimplePool pools$SimplePool = (Pools$SimplePool) sparseArray.get(i);
        if (pools$SimplePool == null) {
            return null;
        }
        return pools$SimplePool.mo740a();
    }

    static LayoutOutput m30513a() {
        LayoutOutput layoutOutput = (LayoutOutput) f22597g.mo740a();
        if (layoutOutput == null) {
            return new LayoutOutput();
        }
        return layoutOutput;
    }

    static ViewLayoutOutput m30527b() {
        ViewLayoutOutput viewLayoutOutput = (ViewLayoutOutput) f22598h.mo740a();
        if (viewLayoutOutput == null) {
            return new ViewLayoutOutput();
        }
        return viewLayoutOutput;
    }

    public static Output m30528c() {
        Output output = (Output) f22599i.mo740a();
        if (output == null) {
            return new Output();
        }
        return output;
    }

    public static Builder m30512a(ComponentContext componentContext, Component<?> component) {
        Builder builder = (Builder) f22602l.mo740a();
        if (builder == null) {
            builder = new Builder();
        }
        builder.f22734a = componentContext;
        builder.f22735b = component;
        return builder;
    }

    static void m30520a(Context context, MountItem mountItem) {
        mountItem.mo3293a(context);
        if (mountItem instanceof ViewMountItem) {
            f22595e.mo741a((ViewMountItem) mountItem);
        } else {
            f22594d.mo741a(mountItem);
        }
    }

    static void m30525a(LayoutOutput layoutOutput) {
        layoutOutput.mo3294l();
        if (layoutOutput instanceof ViewLayoutOutput) {
            f22598h.mo741a((ViewLayoutOutput) layoutOutput);
        } else {
            f22597g.mo741a(layoutOutput);
        }
    }

    public static void m30524a(DiffNode diffNode) {
        diffNode.f22998e = null;
        diffNode.f22994a = null;
        diffNode.f22995b = null;
        diffNode.f22996c = null;
        diffNode.f22997d = null;
        diffNode.f22999f = -1.0f;
        diffNode.f23000g = -1.0f;
        diffNode.f23001h = -1;
        diffNode.f23002i = -1;
        int size = diffNode.f23003j.size();
        for (int i = 0; i < size; i++) {
            m30524a((DiffNode) diffNode.f23003j.get(i));
        }
        diffNode.f23003j.clear();
        f22600j.mo741a(diffNode);
    }

    public static void m30523a(Diff diff) {
        diff.a = null;
        diff.b = null;
        f22601k.mo741a(diff);
    }

    static void m30519a(Context context, int i, Object obj) {
        ThreadUtils.m30579b();
        SparseArray sparseArray = (SparseArray) f22596f.get(context);
        if (sparseArray != null) {
            Pools$SimplePool pools$SimplePool = (Pools$SimplePool) sparseArray.get(i);
            if (pools$SimplePool == null) {
                pools$SimplePool = new Pools$SynchronizedPool(15);
                sparseArray.put(i, pools$SimplePool);
            }
            pools$SimplePool.mo741a(obj);
        }
    }

    public static SparseArrayCompat<MountItem> m30529f() {
        SparseArrayCompat<MountItem> sparseArrayCompat = (SparseArrayCompat) f22603m.mo740a();
        if (sparseArrayCompat == null) {
            return new SparseArrayCompat(4);
        }
        return sparseArrayCompat;
    }

    static void m30522a(SparseArrayCompat<MountItem> sparseArrayCompat) {
        f22603m.mo741a(sparseArrayCompat);
    }

    static RectF m30530h() {
        RectF rectF = (RectF) f22605o.mo740a();
        if (rectF == null) {
            return new RectF();
        }
        return rectF;
    }

    static void m30521a(RectF rectF) {
        rectF.setEmpty();
        f22605o.mo741a(rectF);
    }

    static void m30518a(Activity activity) {
        if (f22596f.containsKey(activity)) {
            throw new IllegalStateException("The MountContentPools has a reference to an activitythat has just been created");
        }
    }
}
