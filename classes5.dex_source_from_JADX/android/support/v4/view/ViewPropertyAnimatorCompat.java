package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.view.ViewPropertyAnimatorCompatICS.C00261;
import android.support.v4.view.ViewPropertyAnimatorCompatJB.C00271;
import android.support.v4.view.ViewPropertyAnimatorCompatKK.C00281;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: vertex_place_information */
public class ViewPropertyAnimatorCompat {
    static final ViewPropertyAnimatorCompatImpl f363a;
    private WeakReference<View> f364b;
    public Runnable f365c = null;
    public Runnable f366d = null;
    public int f367e = -1;

    /* compiled from: vertex_place_information */
    interface ViewPropertyAnimatorCompatImpl {
        void mo74a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        void mo75a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void mo76a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener);

        void mo77a(View view, long j);

        void mo78a(View view, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener);

        void mo79a(View view, Interpolator interpolator);

        void mo80b(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        void mo81b(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void mo82b(View view, long j);

        void mo83c(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void mo84d(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void mo85e(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void mo86f(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);
    }

    /* compiled from: vertex_place_information */
    public class BaseViewPropertyAnimatorCompatImpl implements ViewPropertyAnimatorCompatImpl {
        public WeakHashMap<View, Runnable> f360a = null;

        /* compiled from: vertex_place_information */
        class Starter implements Runnable {
            WeakReference<View> f357a;
            ViewPropertyAnimatorCompat f358b;
            final /* synthetic */ BaseViewPropertyAnimatorCompatImpl f359c;

            public Starter(BaseViewPropertyAnimatorCompatImpl baseViewPropertyAnimatorCompatImpl, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
                this.f359c = baseViewPropertyAnimatorCompatImpl;
                this.f357a = new WeakReference(view);
                this.f358b = viewPropertyAnimatorCompat;
            }

            public void run() {
                View view = (View) this.f357a.get();
                if (view != null) {
                    BaseViewPropertyAnimatorCompatImpl.m452c(this.f359c, this.f358b, view);
                }
            }
        }

        BaseViewPropertyAnimatorCompatImpl() {
        }

        public void mo77a(View view, long j) {
        }

        public void mo75a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m453d(viewPropertyAnimatorCompat, view);
        }

        public void mo81b(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m453d(viewPropertyAnimatorCompat, view);
        }

        public void mo83c(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m453d(viewPropertyAnimatorCompat, view);
        }

        public void mo79a(View view, Interpolator interpolator) {
        }

        public void mo82b(View view, long j) {
        }

        public void mo84d(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m453d(viewPropertyAnimatorCompat, view);
        }

        public void mo85e(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m453d(viewPropertyAnimatorCompat, view);
        }

        public void mo86f(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            m453d(viewPropertyAnimatorCompat, view);
        }

        public void mo74a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            m453d(viewPropertyAnimatorCompat, view);
        }

        public void mo76a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
            view.setTag(2113929216, viewPropertyAnimatorListener);
        }

        public void mo78a(View view, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        }

        public static void m452c(BaseViewPropertyAnimatorCompatImpl baseViewPropertyAnimatorCompatImpl, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            ViewPropertyAnimatorListener viewPropertyAnimatorListener;
            Object tag = view.getTag(2113929216);
            if (tag instanceof ViewPropertyAnimatorListener) {
                viewPropertyAnimatorListener = (ViewPropertyAnimatorListener) tag;
            } else {
                viewPropertyAnimatorListener = null;
            }
            Runnable runnable = viewPropertyAnimatorCompat.f365c;
            Runnable runnable2 = viewPropertyAnimatorCompat.f366d;
            if (runnable != null) {
                runnable.run();
            }
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.mo87a(view);
                viewPropertyAnimatorListener.mo88b(view);
            }
            if (runnable2 != null) {
                runnable2.run();
            }
            if (baseViewPropertyAnimatorCompatImpl.f360a != null) {
                baseViewPropertyAnimatorCompatImpl.f360a.remove(view);
            }
        }

        public void mo80b(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            if (this.f360a != null) {
                Runnable runnable = (Runnable) this.f360a.get(view);
                if (runnable != null) {
                    view.removeCallbacks(runnable);
                }
            }
            m452c(this, viewPropertyAnimatorCompat, view);
        }

        private void m453d(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            Runnable runnable = null;
            if (this.f360a != null) {
                runnable = (Runnable) this.f360a.get(view);
            }
            if (runnable == null) {
                runnable = new Starter(this, viewPropertyAnimatorCompat, view);
                if (this.f360a == null) {
                    this.f360a = new WeakHashMap();
                }
                this.f360a.put(view, runnable);
            }
            view.removeCallbacks(runnable);
            view.post(runnable);
        }
    }

    /* compiled from: vertex_place_information */
    class ICSViewPropertyAnimatorCompatImpl extends BaseViewPropertyAnimatorCompatImpl {
        WeakHashMap<View, Integer> f362b = null;

        /* compiled from: vertex_place_information */
        class MyVpaListener implements ViewPropertyAnimatorListener {
            ViewPropertyAnimatorCompat f361a;

            MyVpaListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
                this.f361a = viewPropertyAnimatorCompat;
            }

            public final void mo87a(View view) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener;
                if (this.f361a.f367e >= 0) {
                    ViewCompat.a(view, 2, null);
                }
                if (this.f361a.f365c != null) {
                    this.f361a.f365c.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof ViewPropertyAnimatorListener) {
                    viewPropertyAnimatorListener = (ViewPropertyAnimatorListener) tag;
                } else {
                    viewPropertyAnimatorListener = null;
                }
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.mo87a(view);
                }
            }

            public final void mo88b(View view) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener;
                if (this.f361a.f367e >= 0) {
                    ViewCompat.a(view, this.f361a.f367e, null);
                    this.f361a.f367e = -1;
                }
                if (this.f361a.f366d != null) {
                    this.f361a.f366d.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof ViewPropertyAnimatorListener) {
                    viewPropertyAnimatorListener = (ViewPropertyAnimatorListener) tag;
                } else {
                    viewPropertyAnimatorListener = null;
                }
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.mo88b(view);
                }
            }

            public final void mo89c(View view) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener;
                Object tag = view.getTag(2113929216);
                if (tag instanceof ViewPropertyAnimatorListener) {
                    viewPropertyAnimatorListener = (ViewPropertyAnimatorListener) tag;
                } else {
                    viewPropertyAnimatorListener = null;
                }
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.mo89c(view);
                }
            }
        }

        public final void mo77a(View view, long j) {
            view.animate().setDuration(j);
        }

        public final void mo75a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            view.animate().alpha(f);
        }

        public final void mo81b(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            view.animate().translationX(f);
        }

        public final void mo83c(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            view.animate().translationY(f);
        }

        public final void mo79a(View view, Interpolator interpolator) {
            view.animate().setInterpolator(interpolator);
        }

        public final void mo82b(View view, long j) {
            view.animate().setStartDelay(j);
        }

        public final void mo84d(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            view.animate().rotation(f);
        }

        public final void mo85e(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            view.animate().scaleX(f);
        }

        public final void mo86f(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            view.animate().scaleY(f);
        }

        public final void mo74a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            view.animate().cancel();
        }

        public final void mo80b(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            view.animate().start();
        }

        ICSViewPropertyAnimatorCompatImpl() {
        }

        public void mo76a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
            view.setTag(2113929216, viewPropertyAnimatorListener);
            ViewPropertyAnimatorListener myVpaListener = new MyVpaListener(viewPropertyAnimatorCompat);
            if (myVpaListener != null) {
                view.animate().setListener(new C00261(myVpaListener, view));
            } else {
                view.animate().setListener(null);
            }
        }
    }

    /* compiled from: vertex_place_information */
    class JBViewPropertyAnimatorCompatImpl extends ICSViewPropertyAnimatorCompatImpl {
        public final void mo76a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
            if (viewPropertyAnimatorListener != null) {
                view.animate().setListener(new C00271(viewPropertyAnimatorListener, view));
            } else {
                view.animate().setListener(null);
            }
        }

        JBViewPropertyAnimatorCompatImpl() {
        }
    }

    /* compiled from: vertex_place_information */
    class JBMr2ViewPropertyAnimatorCompatImpl extends JBViewPropertyAnimatorCompatImpl {
        JBMr2ViewPropertyAnimatorCompatImpl() {
        }
    }

    /* compiled from: vertex_place_information */
    class KitKatViewPropertyAnimatorCompatImpl extends JBMr2ViewPropertyAnimatorCompatImpl {
        public final void mo78a(View view, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
            view.animate().setUpdateListener(new C00281(viewPropertyAnimatorUpdateListener, view));
        }

        KitKatViewPropertyAnimatorCompatImpl() {
        }
    }

    ViewPropertyAnimatorCompat(View view) {
        this.f364b = new WeakReference(view);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 19) {
            f363a = new KitKatViewPropertyAnimatorCompatImpl();
        } else if (i >= 18) {
            f363a = new JBMr2ViewPropertyAnimatorCompatImpl();
        } else if (i >= 16) {
            f363a = new JBViewPropertyAnimatorCompatImpl();
        } else if (i >= 14) {
            f363a = new ICSViewPropertyAnimatorCompatImpl();
        } else {
            f363a = new BaseViewPropertyAnimatorCompatImpl();
        }
    }

    public final ViewPropertyAnimatorCompat m488a(long j) {
        View view = (View) this.f364b.get();
        if (view != null) {
            f363a.mo77a(view, j);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat m487a(float f) {
        View view = (View) this.f364b.get();
        if (view != null) {
            f363a.mo75a(this, view, f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat m493b(float f) {
        View view = (View) this.f364b.get();
        if (view != null) {
            f363a.mo81b(this, view, f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat m496c(float f) {
        View view = (View) this.f364b.get();
        if (view != null) {
            f363a.mo83c(this, view, f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat m491a(Interpolator interpolator) {
        View view = (View) this.f364b.get();
        if (view != null) {
            f363a.mo79a(view, interpolator);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat m494b(long j) {
        View view = (View) this.f364b.get();
        if (view != null) {
            f363a.mo82b(view, j);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat m497d(float f) {
        View view = (View) this.f364b.get();
        if (view != null) {
            f363a.mo84d(this, view, f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat m498e(float f) {
        View view = (View) this.f364b.get();
        if (view != null) {
            f363a.mo85e(this, view, f);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat m499f(float f) {
        View view = (View) this.f364b.get();
        if (view != null) {
            f363a.mo86f(this, view, f);
        }
        return this;
    }

    public final void m492a() {
        View view = (View) this.f364b.get();
        if (view != null) {
            f363a.mo74a(this, view);
        }
    }

    public final void m495b() {
        View view = (View) this.f364b.get();
        if (view != null) {
            f363a.mo80b(this, view);
        }
    }

    public final ViewPropertyAnimatorCompat m489a(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = (View) this.f364b.get();
        if (view != null) {
            f363a.mo76a(this, view, viewPropertyAnimatorListener);
        }
        return this;
    }

    public final ViewPropertyAnimatorCompat m490a(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        View view = (View) this.f364b.get();
        if (view != null) {
            f363a.mo78a(view, viewPropertyAnimatorUpdateListener);
        }
        return this;
    }
}
