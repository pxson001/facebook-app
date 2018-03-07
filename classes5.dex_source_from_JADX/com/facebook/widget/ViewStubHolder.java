package com.facebook.widget;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.LayoutRes;
import android.support.v7.internal.widget.ViewStubCompat;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google */
public class ViewStubHolder<T extends View> {
    @GuardedBy("UI-thread")
    public static final WeakHashMap<Context, SparseArray<WeakReference<View>>> f5816d = new WeakHashMap();
    @Nullable
    private ViewStubCompat f5817a;
    @Nullable
    private T f5818b;
    @Nullable
    public OnInflateListener<T> f5819c;

    /* compiled from: com.google */
    public interface OnInflateListener<T extends View> {
        void m10551a(T t);
    }

    public static <T extends View> ViewStubHolder<T> m10553a(ViewStubCompat viewStubCompat) {
        Preconditions.checkNotNull(viewStubCompat);
        return new ViewStubHolder(viewStubCompat);
    }

    public static <T extends View> ViewStubHolder<T> m10554a(ViewStubCompat viewStubCompat, int i) {
        Preconditions.checkNotNull(viewStubCompat);
        viewStubCompat.f1255a = i;
        return new ViewStubHolder(viewStubCompat);
    }

    private ViewStubHolder(ViewStubCompat viewStubCompat) {
        this.f5817a = viewStubCompat;
    }

    public final T m10556a() {
        if (this.f5818b == null && this.f5817a != null) {
            View a = m10552a(this.f5817a.getContext(), this.f5817a.getLayoutResource());
            if (a != null) {
                this.f5818b = a;
                ViewGroup viewGroup = (ViewGroup) this.f5817a.getParent();
                int indexOfChild = viewGroup.indexOfChild(this.f5817a);
                viewGroup.removeViewInLayout(this.f5817a);
                LayoutParams layoutParams = this.f5817a.getLayoutParams();
                if (layoutParams != null) {
                    viewGroup.addView(this.f5818b, indexOfChild, layoutParams);
                } else {
                    viewGroup.addView(this.f5818b, indexOfChild);
                }
            } else {
                Object obj = this.f5817a.getResources() != null ? 1 : null;
                if (obj != null) {
                    TracerDetour.a("getView: inflate(%s)", this.f5817a.getResources().getResourceName(this.f5817a.getLayoutResource()), 780004362);
                }
                try {
                    this.f5818b = this.f5817a.m1752a();
                    if (obj != null) {
                        TracerDetour.a(-713338911);
                    }
                } catch (Throwable th) {
                    if (obj != null) {
                        TracerDetour.a(1836384802);
                    }
                }
            }
            if (this.f5819c != null) {
                this.f5819c.m10551a(this.f5818b);
            }
            this.f5817a = null;
            this.f5819c = null;
        }
        return this.f5818b;
    }

    public final View m10560b() {
        if (this.f5818b != null) {
            return this.f5818b;
        }
        return this.f5817a;
    }

    public final boolean m10561c() {
        return this.f5818b != null;
    }

    public final boolean m10562d() {
        return m10561c() && this.f5818b.getVisibility() == 0;
    }

    public final void m10563e() {
        if (m10561c()) {
            this.f5818b.setVisibility(8);
        }
    }

    public final void m10564f() {
        m10556a().setVisibility(0);
    }

    public final void m10559a(boolean z) {
        if (z) {
            m10564f();
        } else {
            m10563e();
        }
    }

    public final void m10558a(OnInflateListener<T> onInflateListener) {
        this.f5819c = onInflateListener;
    }

    public final void m10557a(LayoutInflater layoutInflater) {
        if (this.f5817a != null) {
            this.f5817a.f1258d = layoutInflater;
        }
    }

    @Nullable
    private static View m10552a(Context context, @LayoutRes int i) {
        Preconditions.checkState(m10555g(), "Must be called from GUI thread");
        SparseArray sparseArray = (SparseArray) f5816d.get(context);
        if (sparseArray == null) {
            return null;
        }
        View view;
        WeakReference weakReference = (WeakReference) sparseArray.get(i);
        if (weakReference != null) {
            view = (View) weakReference.get();
            sparseArray.remove(i);
        } else {
            view = null;
        }
        context.getResources().getResourceName(i);
        return view;
    }

    public static boolean m10555g() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
