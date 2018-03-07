package com.facebook.dialtone;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.content.InternalIntentHandler;
import com.facebook.content.SecureContextHelper;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: fresh_feed_more_data_fetch */
public class DialtoneAwareInternalIntentHandler implements InternalIntentHandler {
    private final DialtoneController f23250a;
    private final SecureContextHelper f23251b;

    @Inject
    public DialtoneAwareInternalIntentHandler(DialtoneController dialtoneController, SecureContextHelper secureContextHelper) {
        this.f23250a = dialtoneController;
        this.f23251b = secureContextHelper;
    }

    public final boolean mo3407a(Intent intent, Context context) {
        if (!this.f23250a.mo1221b() || !DialtoneIntentHelper.a(intent, this.f23250a)) {
            return false;
        }
        this.f23251b.mo662a(DialtoneIntentHelper.a(context, intent, 0, false), context);
        return true;
    }

    public final boolean mo3405a(Intent intent, int i, Activity activity) {
        if (!this.f23250a.mo1221b() || !DialtoneIntentHelper.a(intent, this.f23250a)) {
            return false;
        }
        this.f23251b.mo662a(DialtoneIntentHelper.a(activity, intent, 0, false), activity);
        return true;
    }

    public final boolean mo3406a(Intent intent, int i, Fragment fragment) {
        if (!this.f23250a.mo1221b() || !DialtoneIntentHelper.a(intent, this.f23250a)) {
            return false;
        }
        this.f23251b.mo662a(DialtoneIntentHelper.a(fragment.getContext(), intent, 0, false), fragment.getContext());
        return true;
    }

    @Nullable
    public final ComponentName mo3408b(Intent intent, Context context) {
        return null;
    }
}
