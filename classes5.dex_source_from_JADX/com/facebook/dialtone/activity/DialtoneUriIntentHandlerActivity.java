package com.facebook.dialtone.activity;

import android.content.Context;
import android.os.Bundle;
import com.facebook.base.activity.DeliverOnNewIntentWhenFinishing;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.inject.FbInjector;
import javax.annotation.Nullable;
import javax.inject.Inject;

@DeliverOnNewIntentWhenFinishing
/* compiled from: \\. */
public class DialtoneUriIntentHandlerActivity extends FbFragmentActivity {
    @Inject
    public DialtoneController f11850p;

    private static <T extends Context> void m19872a(Class<T> cls, T t) {
        m19873a((Object) t, (Context) t);
    }

    public static void m19873a(Object obj, Context context) {
        ((DialtoneUriIntentHandlerActivity) obj).f11850p = (DialtoneController) DialtoneControllerImpl.a(FbInjector.get(context));
    }

    protected final void m19874b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = DialtoneUriIntentHandlerActivity.class;
        m19873a((Object) this, (Context) this);
        this.f11850p.a(this, getIntent());
        finish();
    }

    private void m19871a(DialtoneController dialtoneController) {
        this.f11850p = dialtoneController;
    }
}
