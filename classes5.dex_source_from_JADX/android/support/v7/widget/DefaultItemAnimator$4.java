package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

/* compiled from: ttl_after_first_use */
class DefaultItemAnimator$4 extends DefaultItemAnimator$VpaListenerAdapter {
    final /* synthetic */ ViewHolder f1339a;
    final /* synthetic */ ViewPropertyAnimatorCompat f1340b;
    final /* synthetic */ DefaultItemAnimator f1341c;

    DefaultItemAnimator$4(DefaultItemAnimator defaultItemAnimator, ViewHolder viewHolder, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        this.f1341c = defaultItemAnimator;
        this.f1339a = viewHolder;
        this.f1340b = viewPropertyAnimatorCompat;
    }

    public final void mo87a(View view) {
    }

    public final void mo88b(View view) {
        this.f1340b.m489a(null);
        ViewCompat.c(view, 1.0f);
        this.f1341c.d(this.f1339a);
        this.f1341c.j.remove(this.f1339a);
        DefaultItemAnimator.j(this.f1341c);
    }
}
