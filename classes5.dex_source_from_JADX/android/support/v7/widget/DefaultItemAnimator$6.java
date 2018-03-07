package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

/* compiled from: ttl_after_first_use */
class DefaultItemAnimator$6 extends DefaultItemAnimator$VpaListenerAdapter {
    final /* synthetic */ ViewHolder f1345a;
    final /* synthetic */ int f1346b;
    final /* synthetic */ int f1347c;
    final /* synthetic */ ViewPropertyAnimatorCompat f1348d;
    final /* synthetic */ DefaultItemAnimator f1349e;

    DefaultItemAnimator$6(DefaultItemAnimator defaultItemAnimator, ViewHolder viewHolder, int i, int i2, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        this.f1349e = defaultItemAnimator;
        this.f1345a = viewHolder;
        this.f1346b = i;
        this.f1347c = i2;
        this.f1348d = viewPropertyAnimatorCompat;
    }

    public final void mo87a(View view) {
    }

    public final void mo89c(View view) {
        if (this.f1346b != 0) {
            ViewCompat.a(view, 0.0f);
        }
        if (this.f1347c != 0) {
            ViewCompat.b(view, 0.0f);
        }
    }

    public final void mo88b(View view) {
        this.f1348d.m489a(null);
        this.f1349e.e(this.f1345a);
        this.f1349e.i.remove(this.f1345a);
        DefaultItemAnimator.j(this.f1349e);
    }
}
