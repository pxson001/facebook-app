package com.facebook.registration.fragment;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.facebook.common.executors.ForUiThread;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.registration.constants.RegErrorCategory;
import com.facebook.registration.constants.RegFragmentState;
import com.facebook.registration.model.SimpleRegFormData;
import com.facebook.registration.util.RegistrationUtil;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: language_switcher_activity_started */
public class RegistrationTermsFragment extends RegistrationInputFragment {
    @Inject
    public RegistrationUtil f8888b;
    @Inject
    public SimpleRegFormData f8889c;
    @Inject
    @ForUiThread
    public Lazy<Executor> f8890d;

    /* compiled from: language_switcher_activity_started */
    class C13551 implements FutureCallback<Object> {
        final /* synthetic */ RegistrationTermsFragment f8887a;

        C13551(RegistrationTermsFragment registrationTermsFragment) {
            this.f8887a = registrationTermsFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            super.ay();
        }

        public void onFailure(Throwable th) {
            super.ay();
        }
    }

    public static void m8862a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        RegistrationTermsFragment registrationTermsFragment = (RegistrationTermsFragment) obj;
        RegistrationUtil b = RegistrationUtil.b(fbInjector);
        SimpleRegFormData a = SimpleRegFormData.a(fbInjector);
        Lazy b2 = IdBasedSingletonScopeProvider.b(fbInjector, 3863);
        registrationTermsFragment.f8888b = b;
        registrationTermsFragment.f8889c = a;
        registrationTermsFragment.f8890d = b2;
    }

    public final void mo394c(Bundle bundle) {
        super.mo394c(bundle);
        Class cls = RegistrationTermsFragment.class;
        m8862a(this, getContext());
    }

    protected final void q_() {
        super.q_();
        this.f8888b.a((TextView) e(2131566924));
    }

    protected final int mo384e() {
        return 2131239793;
    }

    protected final int mz_() {
        return 2131239795;
    }

    protected final int as() {
        return 2131239796;
    }

    protected final int at() {
        return 2130906817;
    }

    protected final void au() {
    }

    protected final void av() {
        this.f8889c.a = true;
    }

    protected final RegFragmentState aw() {
        return RegFragmentState.TERMS_ACCEPTED;
    }

    protected final RegErrorCategory ax() {
        return RegErrorCategory.TERMS;
    }

    protected final void ay() {
        Futures.a(this.f8888b.a(o()), new C13551(this), (Executor) this.f8890d.get());
    }
}
