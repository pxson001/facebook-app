package android.support.v4.app;

import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;

/* compiled from: withPrefix */
class BackStackRecord$3 implements OnPreDrawListener {
    final /* synthetic */ View f37a;
    final /* synthetic */ BackStackRecord$TransitionState f38b;
    final /* synthetic */ int f39c;
    final /* synthetic */ Object f40d;
    final /* synthetic */ BackStackRecord f41e;

    BackStackRecord$3(BackStackRecord backStackRecord, View view, BackStackRecord$TransitionState backStackRecord$TransitionState, int i, Object obj) {
        this.f41e = backStackRecord;
        this.f37a = view;
        this.f38b = backStackRecord$TransitionState;
        this.f39c = i;
        this.f40d = obj;
    }

    public boolean onPreDraw() {
        this.f37a.getViewTreeObserver().removeOnPreDrawListener(this);
        BackStackRecord.a(this.f41e, this.f38b, this.f39c, this.f40d);
        return true;
    }
}
