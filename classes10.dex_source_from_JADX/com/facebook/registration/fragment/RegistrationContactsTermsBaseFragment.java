package com.facebook.registration.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.registration.constants.RegFragmentState;
import com.facebook.registration.logging.SimpleRegLogger;
import com.facebook.registration.model.SimpleRegFormData;
import com.facebook.registration.ui.RegClickableSpan.TargetActivity;
import com.facebook.registration.util.RegistrationUtil;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: last_successful_cache_key */
public abstract class RegistrationContactsTermsBaseFragment extends RegistrationFragment {
    @Inject
    public RegistrationUtil f8785b;
    @Inject
    public SimpleRegFormData f8786c;
    @Inject
    public SimpleRegLogger f8787d;
    @Inject
    @ForUiThread
    public Lazy<Executor> f8788e;

    /* compiled from: last_successful_cache_key */
    class C13191 implements FutureCallback<Object> {
        final /* synthetic */ RegistrationContactsTermsBaseFragment f8784a;

        C13191(RegistrationContactsTermsBaseFragment registrationContactsTermsBaseFragment) {
            this.f8784a = registrationContactsTermsBaseFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f8784a.mo385a(RegFragmentState.TERMS_ACCEPTED);
        }

        public void onFailure(Throwable th) {
            this.f8784a.mo385a(RegFragmentState.TERMS_ACCEPTED);
        }
    }

    public static void m8784a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        RegistrationContactsTermsBaseFragment registrationContactsTermsBaseFragment = (RegistrationContactsTermsBaseFragment) obj;
        RegistrationUtil b = RegistrationUtil.b(fbInjector);
        SimpleRegFormData a = SimpleRegFormData.a(fbInjector);
        SimpleRegLogger b2 = SimpleRegLogger.b(fbInjector);
        Lazy b3 = IdBasedSingletonScopeProvider.b(fbInjector, 3863);
        registrationContactsTermsBaseFragment.f8785b = b;
        registrationContactsTermsBaseFragment.f8786c = a;
        registrationContactsTermsBaseFragment.f8787d = b2;
        registrationContactsTermsBaseFragment.f8788e = b3;
    }

    protected abstract void as();

    public void mo399c(Bundle bundle) {
        super.c(bundle);
        Class cls = RegistrationContactsTermsBaseFragment.class;
        m8784a(this, getContext());
    }

    public final void mo383b(View view, Bundle bundle) {
        mo398b(view);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ViewGroup viewGroup = (ViewGroup) this.T;
        viewGroup.removeAllViewsInLayout();
        View inflate = LayoutInflater.from(o()).inflate(ar(), viewGroup, true);
        ViewStub viewStub = (ViewStub) FindViewUtil.b(inflate, 2131566930);
        viewStub.setLayoutResource(aq());
        viewStub.inflate();
        mo398b(inflate);
    }

    protected final int mo384e() {
        return 2131239793;
    }

    protected final int ar() {
        return 2130906807;
    }

    protected void mo398b(View view) {
        as();
        this.f8785b.a((TextView) FindViewUtil.b(view, 2131566909));
        RegistrationUtil registrationUtil = this.f8785b;
        TextView textView = (TextView) FindViewUtil.b(view, 2131566911);
        Resources resources = registrationUtil.a.getResources();
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(resources);
        styledStringBuilder.a(StringFormatUtil.formatStrLocaleSafe(resources.getString(2131239861), "[[learn_more]]"));
        styledStringBuilder.a("[[learn_more]]", resources.getString(2131230747), registrationUtil.c.a(TargetActivity.FRIEND_FINDER_LEARN_MORE, null), 33);
        CharSequence b = styledStringBuilder.b();
        textView.setContentDescription(b);
        textView.setText(b);
        textView.setMovementMethod(registrationUtil.b);
    }

    protected final void m8785a(boolean z) {
        this.f8786c.a = true;
        this.f8786c.b = z;
        this.f8787d.a(z);
        Futures.a(this.f8785b.a(o()), new C13191(this), (Executor) this.f8788e.get());
    }
}
