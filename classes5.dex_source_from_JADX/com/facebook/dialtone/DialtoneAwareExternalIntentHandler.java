package com.facebook.dialtone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.content.ExternalIntentHandler;
import com.facebook.content.SecureContextHelper;
import javax.inject.Inject;

/* compiled from: ] -- unresolved forward-reference? */
public class DialtoneAwareExternalIntentHandler implements ExternalIntentHandler {
    private final DialtoneController f11791a;
    private final SecureContextHelper f11792b;

    @Inject
    public DialtoneAwareExternalIntentHandler(DialtoneController dialtoneController, SecureContextHelper secureContextHelper) {
        this.f11791a = dialtoneController;
        this.f11792b = secureContextHelper;
    }

    public final boolean mo581a(Intent intent, Context context) {
        if (!this.f11791a.b() || !DialtoneIntentHelper.m19824a(intent, this.f11791a)) {
            return false;
        }
        this.f11792b.b(DialtoneIntentHelper.m19823a(context, intent, 0, false), context);
        return true;
    }

    public final boolean mo579a(Intent intent, int i, Activity activity) {
        if (!this.f11791a.b() || !DialtoneIntentHelper.m19824a(intent, this.f11791a)) {
            return false;
        }
        this.f11792b.b(DialtoneIntentHelper.m19823a(activity, intent, 0, false), activity);
        return true;
    }

    public final boolean mo580a(Intent intent, int i, Fragment fragment) {
        if (!this.f11791a.b() || !DialtoneIntentHelper.m19824a(intent, this.f11791a)) {
            return false;
        }
        this.f11792b.b(DialtoneIntentHelper.m19823a(fragment.getContext(), intent, 0, false), fragment.getContext());
        return true;
    }
}
