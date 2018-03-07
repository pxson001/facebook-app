package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;

/* compiled from: ttl_after_first_use */
public class DefaultItemAnimator$8 extends DefaultItemAnimator$VpaListenerAdapter {
    final /* synthetic */ DefaultItemAnimator$ChangeInfo f1353a;
    final /* synthetic */ ViewPropertyAnimatorCompat f1354b;
    final /* synthetic */ View f1355c;
    final /* synthetic */ DefaultItemAnimator f1356d;

    public DefaultItemAnimator$8(DefaultItemAnimator defaultItemAnimator, DefaultItemAnimator$ChangeInfo defaultItemAnimator$ChangeInfo, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
        this.f1356d = defaultItemAnimator;
        this.f1353a = defaultItemAnimator$ChangeInfo;
        this.f1354b = viewPropertyAnimatorCompat;
        this.f1355c = view;
    }

    public final void mo87a(View view) {
    }

    public final void mo88b(View view) {
        this.f1354b.m489a(null);
        ViewCompat.c(this.f1355c, 1.0f);
        ViewCompat.a(this.f1355c, 0.0f);
        ViewCompat.b(this.f1355c, 0.0f);
        this.f1356d.a(this.f1353a.f1358b, false);
        this.f1356d.k.remove(this.f1353a.f1358b);
        DefaultItemAnimator.j(this.f1356d);
    }
}
