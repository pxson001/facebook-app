package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ttl_after_first_use */
class DefaultItemAnimator$2 implements Runnable {
    final /* synthetic */ ArrayList f1335a;
    final /* synthetic */ DefaultItemAnimator f1336b;

    DefaultItemAnimator$2(DefaultItemAnimator defaultItemAnimator, ArrayList arrayList) {
        this.f1336b = defaultItemAnimator;
        this.f1335a = arrayList;
    }

    public void run() {
        Iterator it = this.f1335a.iterator();
        while (it.hasNext()) {
            DefaultItemAnimator$ChangeInfo defaultItemAnimator$ChangeInfo = (DefaultItemAnimator$ChangeInfo) it.next();
            DefaultItemAnimator defaultItemAnimator = this.f1336b;
            View view = null;
            ViewHolder viewHolder = defaultItemAnimator$ChangeInfo.f1357a;
            View view2 = viewHolder == null ? null : viewHolder.a;
            ViewHolder viewHolder2 = defaultItemAnimator$ChangeInfo.f1358b;
            if (viewHolder2 != null) {
                view = viewHolder2.a;
            }
            if (view2 != null) {
                ViewPropertyAnimatorCompat a = ViewCompat.t(view2).m488a(defaultItemAnimator.f);
                defaultItemAnimator.k.add(defaultItemAnimator$ChangeInfo.f1357a);
                a.m493b((float) (defaultItemAnimator$ChangeInfo.f1361e - defaultItemAnimator$ChangeInfo.f1359c));
                a.m496c((float) (defaultItemAnimator$ChangeInfo.f1362f - defaultItemAnimator$ChangeInfo.f1360d));
                a.m487a(0.0f).m489a(new DefaultItemAnimator$7(defaultItemAnimator, defaultItemAnimator$ChangeInfo, a)).m495b();
            }
            if (view != null) {
                a = ViewCompat.t(view);
                defaultItemAnimator.k.add(defaultItemAnimator$ChangeInfo.f1358b);
                a.m493b(0.0f).m496c(0.0f).m488a(defaultItemAnimator.f).m487a(1.0f).m489a(new DefaultItemAnimator$8(defaultItemAnimator, defaultItemAnimator$ChangeInfo, a, view)).m495b();
            }
        }
        this.f1335a.clear();
        this.f1336b.g.remove(this.f1335a);
    }
}
