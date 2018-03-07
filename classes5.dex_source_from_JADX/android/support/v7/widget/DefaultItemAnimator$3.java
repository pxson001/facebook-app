package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ttl_after_first_use */
class DefaultItemAnimator$3 implements Runnable {
    final /* synthetic */ ArrayList f1337a;
    final /* synthetic */ DefaultItemAnimator f1338b;

    DefaultItemAnimator$3(DefaultItemAnimator defaultItemAnimator, ArrayList arrayList) {
        this.f1338b = defaultItemAnimator;
        this.f1337a = arrayList;
    }

    public void run() {
        Iterator it = this.f1337a.iterator();
        while (it.hasNext()) {
            ViewHolder viewHolder = (ViewHolder) it.next();
            DefaultItemAnimator defaultItemAnimator = this.f1338b;
            ViewPropertyAnimatorCompat t = ViewCompat.t(viewHolder.a);
            defaultItemAnimator.h.add(viewHolder);
            t.m487a(1.0f).m488a(defaultItemAnimator.c).m489a(new DefaultItemAnimator$5(defaultItemAnimator, viewHolder, t)).m495b();
        }
        this.f1337a.clear();
        this.f1338b.e.remove(this.f1337a);
    }
}
