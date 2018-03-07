package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;

/* compiled from: ttl_after_first_use */
public class DefaultItemAnimator$7 extends DefaultItemAnimator$VpaListenerAdapter {
    final /* synthetic */ DefaultItemAnimator$ChangeInfo f1350a;
    final /* synthetic */ ViewPropertyAnimatorCompat f1351b;
    final /* synthetic */ DefaultItemAnimator f1352c;

    public DefaultItemAnimator$7(DefaultItemAnimator defaultItemAnimator, DefaultItemAnimator$ChangeInfo defaultItemAnimator$ChangeInfo, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        this.f1352c = defaultItemAnimator;
        this.f1350a = defaultItemAnimator$ChangeInfo;
        this.f1351b = viewPropertyAnimatorCompat;
    }

    public final void mo87a(View view) {
    }

    public final void mo88b(View view) {
        this.f1351b.m489a(null);
        ViewCompat.c(view, 1.0f);
        ViewCompat.a(view, 0.0f);
        ViewCompat.b(view, 0.0f);
        this.f1352c.a(this.f1350a.f1357a, true);
        this.f1352c.k.remove(this.f1350a.f1357a);
        DefaultItemAnimator.j(this.f1352c);
    }
}
