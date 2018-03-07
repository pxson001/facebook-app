package android.support.v4.app;

import android.support.v4.util.ArrayMap;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;

/* compiled from: withPrefix */
class BackStackRecord$2 implements OnPreDrawListener {
    final /* synthetic */ View f29a;
    final /* synthetic */ Object f30b;
    final /* synthetic */ ArrayList f31c;
    final /* synthetic */ BackStackRecord$TransitionState f32d;
    final /* synthetic */ boolean f33e;
    final /* synthetic */ Fragment f34f;
    final /* synthetic */ Fragment f35g;
    final /* synthetic */ BackStackRecord f36h;

    BackStackRecord$2(BackStackRecord backStackRecord, View view, Object obj, ArrayList arrayList, BackStackRecord$TransitionState backStackRecord$TransitionState, boolean z, Fragment fragment, Fragment fragment2) {
        this.f36h = backStackRecord;
        this.f29a = view;
        this.f30b = obj;
        this.f31c = arrayList;
        this.f32d = backStackRecord$TransitionState;
        this.f33e = z;
        this.f34f = fragment;
        this.f35g = fragment2;
    }

    public boolean onPreDraw() {
        this.f29a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.f30b != null) {
            FragmentTransitionCompat21.m92a(this.f30b, this.f31c);
            this.f31c.clear();
            ArrayMap a = BackStackRecord.a(this.f36h, this.f32d, this.f33e, this.f34f);
            this.f31c.add(this.f32d.f45d);
            this.f31c.addAll(a.values());
            FragmentTransitionCompat21.m96b(this.f30b, this.f31c);
            BackStackRecord backStackRecord = this.f36h;
            BackStackRecord$TransitionState backStackRecord$TransitionState = this.f32d;
            if (!(backStackRecord.u == null || a.isEmpty())) {
                View view = (View) a.get(backStackRecord.u.get(0));
                if (view != null) {
                    backStackRecord$TransitionState.f44c.f132a = view;
                }
            }
            BackStackRecord.a(this.f36h, this.f32d, this.f34f, this.f35g, this.f33e, a);
        }
        return true;
    }
}
