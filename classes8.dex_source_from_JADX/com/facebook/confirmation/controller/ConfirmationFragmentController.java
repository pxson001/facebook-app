package com.facebook.confirmation.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.fragment.AbstractNavigableFragmentController;
import com.facebook.base.fragment.NavigableFragment;
import com.facebook.base.fragment.NavigableFragmentController.Listener;
import com.facebook.confirmation.constants.ConfFragmentState;
import com.facebook.confirmation.fragment.ConfEmailCodeInputFragment;
import com.facebook.confirmation.fragment.ConfPhoneCodeInputFragment;
import com.facebook.confirmation.fragment.ConfPhoneFragment;
import com.facebook.confirmation.model.AccountConfirmationData;
import com.facebook.growth.model.Contactpoint;
import com.facebook.growth.model.ContactpointType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: invalid stream type */
public class ConfirmationFragmentController extends AbstractNavigableFragmentController {
    @Inject
    ConfStateMachine f10722a;
    @Inject
    AccountConfirmationData f10723b;

    /* compiled from: invalid stream type */
    class C11441 implements Listener {
        final /* synthetic */ ConfirmationFragmentController f10721a;

        C11441(ConfirmationFragmentController confirmationFragmentController) {
            this.f10721a = confirmationFragmentController;
        }

        public final void m12645a(NavigableFragment navigableFragment, Intent intent) {
            ConfFragmentState valueOfKey = ConfFragmentState.valueOfKey(intent.getAction());
            if (valueOfKey == ConfFragmentState.CODE_SUCCESS) {
                this.f10721a.o().finish();
                return;
            }
            ConfirmationFragmentController confirmationFragmentController = this.f10721a;
            ConfStateMachine confStateMachine = this.f10721a.f10722a;
            ConfTransition confTransition = (ConfTransition) confStateMachine.f10717b.get(valueOfKey);
            if (confTransition == null) {
                confTransition = (ConfTransition) confStateMachine.f10717b.get(ConfFragmentState.UNKNOWN_ERROR);
            }
            confirmationFragmentController.b(confTransition.m12644c());
        }
    }

    private static <T extends InjectableComponentWithContext> void m12647a(Class<T> cls, T t) {
        m12648a((Object) t, t.getContext());
    }

    private static void m12648a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ConfirmationFragmentController) obj).m12646a(new ConfStateMachine(AccountConfirmationData.m12724a(injectorLike)), AccountConfirmationData.m12724a(injectorLike));
    }

    public final void m12653c(Bundle bundle) {
        super.c(bundle);
        m12647a(ConfirmationFragmentController.class, (InjectableComponentWithContext) this);
        this.d = new C11441(this);
    }

    public final void aq() {
        ConfStateMachine confStateMachine = this.f10722a;
        ConfTransition confTransition = new ConfTransition(ConfPhoneFragment.class);
        confTransition.f10719b = false;
        confTransition = confTransition;
        confTransition.f10720c = false;
        confTransition = confTransition;
        Contactpoint contactpoint = confStateMachine.f10716a.f10776a;
        if (contactpoint != null && contactpoint.m17345a()) {
            if (contactpoint.type == ContactpointType.PHONE) {
                confTransition = new ConfTransition(ConfPhoneCodeInputFragment.class);
                confTransition.f10719b = false;
                confTransition = confTransition;
                confTransition.f10720c = false;
                confTransition = confTransition;
            } else {
                confTransition = new ConfTransition(ConfEmailCodeInputFragment.class);
                confTransition.f10719b = false;
                confTransition = confTransition;
                confTransition.f10720c = false;
                confTransition = confTransition;
            }
        }
        b(confTransition.m12644c());
    }

    public final void m12649a(Contactpoint contactpoint) {
        this.f10723b.m12726a(contactpoint);
    }

    public final void m12651a(boolean z) {
        this.f10723b.f10777b = z;
    }

    public final void m12652b(boolean z) {
        this.f10723b.f10778c = z;
    }

    public final void m12650a(String str) {
        this.f10723b.f10779d = str;
    }

    private void m12646a(ConfStateMachine confStateMachine, AccountConfirmationData accountConfirmationData) {
        this.f10722a = confStateMachine;
        this.f10723b = accountConfirmationData;
    }
}
