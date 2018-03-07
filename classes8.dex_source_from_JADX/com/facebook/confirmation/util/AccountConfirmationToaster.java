package com.facebook.confirmation.util;

import com.facebook.inject.InjectorLike;
import com.facebook.ui.toaster.Toaster;
import javax.inject.Inject;

/* compiled from: inline_expansion_tap */
public class AccountConfirmationToaster {
    private Toaster f10810a;

    private static AccountConfirmationToaster m12749b(InjectorLike injectorLike) {
        return new AccountConfirmationToaster(Toaster.b(injectorLike));
    }

    @Inject
    public AccountConfirmationToaster(Toaster toaster) {
        this.f10810a = toaster;
    }
}
