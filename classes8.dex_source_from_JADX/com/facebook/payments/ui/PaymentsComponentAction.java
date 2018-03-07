package com.facebook.payments.ui;

import android.os.Bundle;
import android.os.Parcelable;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* compiled from: submit_captcha_input_clicked */
public class PaymentsComponentAction {
    public final Action f1974a;
    public final Bundle f1975b;

    @Immutable
    /* compiled from: submit_captcha_input_clicked */
    public enum Action {
        FINISH_ACTIVITY,
        MUTATION,
        RESET,
        USER_ACTION
    }

    public PaymentsComponentAction(Action action) {
        this(action, null);
    }

    public PaymentsComponentAction(Action action, @Nullable Bundle bundle) {
        this.f1974a = action;
        this.f1975b = new Bundle();
        if (bundle != null) {
            this.f1975b.putAll(bundle);
        }
    }

    public final String m2211a(String str, @Nullable String str2) {
        return this.f1975b.getString(str, str2);
    }

    public final <T extends Parcelable> T m2210a(String str) {
        return this.f1975b.getParcelable(str);
    }
}
