package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

/* compiled from: ttl_after_first_use */
public class DefaultItemAnimator$5 extends DefaultItemAnimator$VpaListenerAdapter {
    final /* synthetic */ ViewHolder f1342a;
    final /* synthetic */ ViewPropertyAnimatorCompat f1343b;
    final /* synthetic */ DefaultItemAnimator f1344c;

    public DefaultItemAnimator$5(DefaultItemAnimator defaultItemAnimator, ViewHolder viewHolder, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        this.f1344c = defaultItemAnimator;
        this.f1342a = viewHolder;
        this.f1343b = viewPropertyAnimatorCompat;
    }

    public final void mo87a(View view) {
    }

    public final void mo89c(View view) {
        ViewCompat.c(view, 1.0f);
    }

    public final void mo88b(View view) {
        this.f1343b.m489a(null);
        this.f1344c.f(this.f1342a);
        this.f1344c.h.remove(this.f1342a);
        DefaultItemAnimator.j(this.f1344c);
    }
}
