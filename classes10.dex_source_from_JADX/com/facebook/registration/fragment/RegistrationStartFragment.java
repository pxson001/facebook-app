package com.facebook.registration.fragment;

import android.content.Context;
import android.os.Bundle;
import com.facebook.common.executors.ForUiThread;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.registration.constants.RegErrorCategory;
import com.facebook.registration.constants.RegFragmentState;
import com.facebook.registration.util.RegistrationUtil;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: language_switcher_activity_suggestions_fetched */
public class RegistrationStartFragment extends RegistrationInputFragment {
    @Inject
    public RegistrationUtil f8876b;
    @Inject
    @ForUiThread
    public Lazy<Executor> f8877c;

    /* compiled from: language_switcher_activity_suggestions_fetched */
    class C13521 implements FutureCallback<Object> {
        final /* synthetic */ RegistrationStartFragment f8875a;

        C13521(RegistrationStartFragment registrationStartFragment) {
            this.f8875a = registrationStartFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            super.ay();
        }

        public void onFailure(Throwable th) {
            super.ay();
        }
    }

    public static void m8851a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        RegistrationStartFragment registrationStartFragment = (RegistrationStartFragment) obj;
        RegistrationUtil b = RegistrationUtil.b(fbInjector);
        Lazy b2 = IdBasedSingletonScopeProvider.b(fbInjector, 3863);
        registrationStartFragment.f8876b = b;
        registrationStartFragment.f8877c = b2;
    }

    public final void mo394c(Bundle bundle) {
        super.mo394c(bundle);
        Class cls = RegistrationStartFragment.class;
        m8851a(this, getContext());
    }

    protected final int mo384e() {
        return 2131239790;
    }

    protected final int mz_() {
        return 2131239791;
    }

    protected final int as() {
        return 2131239792;
    }

    protected final int at() {
        return 2130906816;
    }

    protected final void au() {
    }

    protected final void av() {
    }

    protected final RegFragmentState aw() {
        return RegFragmentState.START_COMPLETED;
    }

    protected final RegErrorCategory ax() {
        return RegErrorCategory.START;
    }

    protected final void ay() {
        Futures.a(this.f8876b.a(o()), new C13521(this), (Executor) this.f8877c.get());
    }
}
