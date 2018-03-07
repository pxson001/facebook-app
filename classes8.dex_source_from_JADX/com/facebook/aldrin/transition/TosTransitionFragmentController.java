package com.facebook.aldrin.transition;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.fragment.AbstractNavigableFragmentController;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.InjectorLike;
import com.facebook.statemachine.AbstractStateMachineListener;
import javax.inject.Inject;

/* compiled from: last_cursor */
public class TosTransitionFragmentController extends AbstractNavigableFragmentController {
    @Inject
    AldrinTransitionLauncher f10395a;
    @Inject
    TosTransitionStateMachine f10396b;

    /* compiled from: last_cursor */
    class C11071 extends AbstractStateMachineListener<TosTransitionState, TosTransitionStateEvent> {
        final /* synthetic */ TosTransitionFragmentController f10394a;

        C11071(TosTransitionFragmentController tosTransitionFragmentController) {
            this.f10394a = tosTransitionFragmentController;
        }

        public final void mo680a(Object obj, Object obj2, Object obj3) {
            this.f10394a.m12196a((TosTransitionState) obj3);
        }
    }

    private static <T extends InjectableComponentWithContext> void m12197a(Class<T> cls, T t) {
        m12198a((Object) t, t.getContext());
    }

    private static void m12198a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((TosTransitionFragmentController) obj).m12194a(AldrinTransitionLauncher.m12188a(injectorLike), TosTransitionStateMachine.m12200a(injectorLike));
    }

    public final void m12199c(Bundle bundle) {
        super.c(bundle);
        m12197a(TosTransitionFragmentController.class, (InjectableComponentWithContext) this);
        if (this.f10395a.m12191a()) {
            this.f10396b.f10400a.e = new C11071(this);
            b(((TosTransitionState) this.f10396b.f10400a.b).getIntent());
            return;
        }
        ao().finish();
    }

    private void m12196a(TosTransitionState tosTransitionState) {
        Intent intent = tosTransitionState.getIntent();
        if (intent != null) {
            b(intent);
        }
    }

    private void m12194a(AldrinTransitionLauncher aldrinTransitionLauncher, TosTransitionStateMachine tosTransitionStateMachine) {
        this.f10395a = aldrinTransitionLauncher;
        this.f10396b = tosTransitionStateMachine;
    }
}
