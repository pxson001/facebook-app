package android.support.v7.internal.view;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: upsellTitleLabel */
public class ViewPropertyAnimatorCompatSet {
    public final ArrayList<ViewPropertyAnimatorCompat> f762a = new ArrayList();
    private long f763b = -1;
    private Interpolator f764c;
    public ViewPropertyAnimatorListener f765d;
    public boolean f766e;
    private final ViewPropertyAnimatorListenerAdapter f767f = new C00461(this);

    /* compiled from: upsellTitleLabel */
    public class C00461 extends ViewPropertyAnimatorListenerAdapter {
        public final /* synthetic */ ViewPropertyAnimatorCompatSet f759a;
        public boolean f760b = false;
        public int f761c = 0;

        C00461(ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet) {
            this.f759a = viewPropertyAnimatorCompatSet;
        }

        public final void mo87a(View view) {
            if (!this.f760b) {
                this.f760b = true;
                if (this.f759a.f765d != null) {
                    this.f759a.f765d.mo87a(null);
                }
            }
        }

        public final void mo88b(View view) {
            int i = this.f761c + 1;
            this.f761c = i;
            if (i == this.f759a.f762a.size()) {
                if (this.f759a.f765d != null) {
                    this.f759a.f765d.mo88b(null);
                }
                this.f761c = 0;
                this.f760b = false;
                this.f759a.f766e = false;
            }
        }
    }

    public final ViewPropertyAnimatorCompatSet m1316a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.f766e) {
            this.f762a.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    public final void m1319a() {
        if (!this.f766e) {
            Iterator it = this.f762a.iterator();
            while (it.hasNext()) {
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat) it.next();
                if (this.f763b >= 0) {
                    viewPropertyAnimatorCompat.m488a(this.f763b);
                }
                if (this.f764c != null) {
                    viewPropertyAnimatorCompat.m491a(this.f764c);
                }
                if (this.f765d != null) {
                    viewPropertyAnimatorCompat.m489a(this.f767f);
                }
                viewPropertyAnimatorCompat.m495b();
            }
            this.f766e = true;
        }
    }

    public final void m1320b() {
        if (this.f766e) {
            Iterator it = this.f762a.iterator();
            while (it.hasNext()) {
                ((ViewPropertyAnimatorCompat) it.next()).m492a();
            }
            this.f766e = false;
        }
    }

    public final ViewPropertyAnimatorCompatSet m1315a(long j) {
        if (!this.f766e) {
            this.f763b = j;
        }
        return this;
    }

    public final ViewPropertyAnimatorCompatSet m1318a(Interpolator interpolator) {
        if (!this.f766e) {
            this.f764c = interpolator;
        }
        return this;
    }

    public final ViewPropertyAnimatorCompatSet m1317a(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.f766e) {
            this.f765d = viewPropertyAnimatorListener;
        }
        return this;
    }
}
