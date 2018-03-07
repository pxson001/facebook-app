package android.support.v7.widget;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ttl_after_first_use */
class DefaultItemAnimator$1 implements Runnable {
    final /* synthetic */ ArrayList f1333a;
    final /* synthetic */ DefaultItemAnimator f1334b;

    DefaultItemAnimator$1(DefaultItemAnimator defaultItemAnimator, ArrayList arrayList) {
        this.f1334b = defaultItemAnimator;
        this.f1333a = arrayList;
    }

    public void run() {
        Iterator it = this.f1333a.iterator();
        while (it.hasNext()) {
            DefaultItemAnimator$MoveInfo defaultItemAnimator$MoveInfo = (DefaultItemAnimator$MoveInfo) it.next();
            DefaultItemAnimator.a(this.f1334b, defaultItemAnimator$MoveInfo.f1363a, defaultItemAnimator$MoveInfo.f1364b, defaultItemAnimator$MoveInfo.f1365c, defaultItemAnimator$MoveInfo.f1366d, defaultItemAnimator$MoveInfo.f1367e);
        }
        this.f1333a.clear();
        this.f1334b.f.remove(this.f1333a);
    }
}
