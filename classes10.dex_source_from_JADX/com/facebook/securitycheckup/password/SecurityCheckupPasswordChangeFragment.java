package com.facebook.securitycheckup.password;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.PasswordChangeInputData;
import com.facebook.graphql.calls.PasswordChangeInputData.SecurityCheckupSource;
import com.facebook.graphql.calls.SecurityCheckupLoggingInputData.Event;
import com.facebook.graphql.error.GraphQLException;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.securitycheckup.SecurityCheckupLogger;
import com.facebook.securitycheckup.api.PasswordChangeMutation.PasswordChangeMutationString;
import com.facebook.securitycheckup.api.PasswordChangeMutationModels.PasswordChangeMutationModel;
import com.facebook.securitycheckup.password.PasswordStrengthIndicator.Strength;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;

/* compiled from: hour */
public class SecurityCheckupPasswordChangeFragment extends FbFragment {
    public SecurityCheckupPasswordView f9915a;
    public ExecutorService al;
    public SecurityCheckupLogger am;
    public SecurityCheckupPasswordView f9916b;
    public SecurityCheckupPasswordView f9917c;
    public FbButton f9918d;
    public FbTextView f9919e;
    public ProgressBar f9920f;
    public boolean f9921g = false;
    public boolean f9922h = false;
    public Lazy<GraphQLQueryExecutor> f9923i;

    /* compiled from: hour */
    class C14661 implements Runnable {
        final /* synthetic */ SecurityCheckupPasswordChangeFragment f9902a;

        C14661(SecurityCheckupPasswordChangeFragment securityCheckupPasswordChangeFragment) {
            this.f9902a = securityCheckupPasswordChangeFragment;
        }

        public void run() {
            this.f9902a.f9915a.setNameWidth(this.f9902a.f9917c.getNameWidth());
            this.f9902a.f9916b.setNameWidth(this.f9902a.f9917c.getNameWidth());
        }
    }

    /* compiled from: hour */
    class C14672 implements TextWatcher {
        final /* synthetic */ SecurityCheckupPasswordChangeFragment f9903a;

        C14672(SecurityCheckupPasswordChangeFragment securityCheckupPasswordChangeFragment) {
            this.f9903a = securityCheckupPasswordChangeFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (SecurityCheckupPasswordChangeFragment.m10053b(this.f9903a)) {
                this.f9903a.f9918d.setEnabled(false);
            } else {
                this.f9903a.f9918d.setEnabled(true);
            }
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: hour */
    class C14683 implements OnClickListener {
        final /* synthetic */ SecurityCheckupPasswordChangeFragment f9904a;

        C14683(SecurityCheckupPasswordChangeFragment securityCheckupPasswordChangeFragment) {
            this.f9904a = securityCheckupPasswordChangeFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1263629331);
            this.f9904a.f9919e.setVisibility(8);
            if (this.f9904a.f9916b.getText().equals(this.f9904a.f9917c.getText())) {
                SecurityCheckupPasswordChangeFragment securityCheckupPasswordChangeFragment = this.f9904a;
                String text = this.f9904a.f9915a.getText();
                String text2 = this.f9904a.f9916b.getText();
                String text3 = this.f9904a.f9917c.getText();
                securityCheckupPasswordChangeFragment.f9921g = true;
                securityCheckupPasswordChangeFragment.f9918d.setEnabled(false);
                securityCheckupPasswordChangeFragment.f9920f.setVisibility(0);
                PasswordChangeInputData passwordChangeInputData = new PasswordChangeInputData();
                passwordChangeInputData.a("old_password", text);
                GraphQlCallInput graphQlCallInput = passwordChangeInputData;
                graphQlCallInput.a("new_password", text2);
                graphQlCallInput = graphQlCallInput;
                graphQlCallInput.a("confirm_password", text3);
                graphQlCallInput = graphQlCallInput;
                graphQlCallInput.a("security_checkup_source", SecurityCheckupSource.FB4A_MEGAPHONE);
                graphQlCallInput = graphQlCallInput;
                GraphQlQueryString passwordChangeMutationString = new PasswordChangeMutationString();
                passwordChangeMutationString.a("input", graphQlCallInput);
                Futures.a(((GraphQLQueryExecutor) securityCheckupPasswordChangeFragment.f9923i.get()).a(GraphQLRequest.a(passwordChangeMutationString)), new C14714(securityCheckupPasswordChangeFragment), securityCheckupPasswordChangeFragment.al);
                LogUtils.a(1308570351, a);
                return;
            }
            this.f9904a.f9917c.m10064b();
            Logger.a(2, EntryType.UI_INPUT_END, 1019599078, a);
        }
    }

    /* compiled from: hour */
    public class C14714 implements FutureCallback<GraphQLResult<PasswordChangeMutationModel>> {
        final /* synthetic */ SecurityCheckupPasswordChangeFragment f9908a;

        /* compiled from: hour */
        class C14691 implements Runnable {
            final /* synthetic */ C14714 f9905a;

            C14691(C14714 c14714) {
                this.f9905a = c14714;
            }

            public void run() {
                SecurityCheckupPasswordChangeFragment.ar(this.f9905a.f9908a);
                if (this.f9905a.f9908a.ao() != null) {
                    this.f9905a.f9908a.ao().onBackPressed();
                }
            }
        }

        public C14714(SecurityCheckupPasswordChangeFragment securityCheckupPasswordChangeFragment) {
            this.f9908a = securityCheckupPasswordChangeFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            if (this.f9908a.ao() != null) {
                this.f9908a.ao().runOnUiThread(new C14691(this));
            }
        }

        public void onFailure(final Throwable th) {
            this.f9908a.ao().runOnUiThread(new Runnable(this) {
                final /* synthetic */ C14714 f9907b;

                public void run() {
                    SecurityCheckupPasswordChangeFragment.m10051a(this.f9907b.f9908a, th);
                    SecurityCheckupPasswordChangeFragment.ar(this.f9907b.f9908a);
                }
            });
        }
    }

    /* compiled from: hour */
    public class NewPasswordTextWatcher implements TextWatcher {
        final /* synthetic */ SecurityCheckupPasswordChangeFragment f9909a;
        private SecurityCheckupPasswordView f9910b;
        private SecurityCheckupPasswordView f9911c;

        public NewPasswordTextWatcher(SecurityCheckupPasswordChangeFragment securityCheckupPasswordChangeFragment, SecurityCheckupPasswordView securityCheckupPasswordView, SecurityCheckupPasswordView securityCheckupPasswordView2) {
            this.f9909a = securityCheckupPasswordChangeFragment;
            this.f9910b = securityCheckupPasswordView;
            this.f9911c = securityCheckupPasswordView2;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Strength strength;
            String charSequence2 = charSequence.toString();
            if (StringUtil.a(charSequence2)) {
                strength = Strength.NULL;
            } else if (charSequence2.length() < 6) {
                strength = Strength.NULL;
            } else {
                double a = PasswordStrengthAnalyzer.m10043a(charSequence2);
                if (a < 35.0d) {
                    strength = Strength.WEAK;
                } else if (a < 52.0d) {
                    strength = Strength.OK;
                } else {
                    strength = Strength.STRONG;
                }
            }
            Strength strength2 = strength;
            if (SecurityCheckupPasswordChangeFragment.m10053b(this.f9909a)) {
                this.f9909a.f9918d.setEnabled(false);
            } else {
                this.f9909a.f9918d.setEnabled(true);
            }
            if (this.f9911c.f9935f != Strength.NULL) {
                this.f9911c.setPasswordStrength(Strength.NULL);
                this.f9911c.setPasswordsMatch(false);
            }
            this.f9910b.setPasswordStrength(strength2);
            this.f9910b.setPasswordsMatch(false);
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: hour */
    public class RetypeNewPasswordTextWatcher implements TextWatcher {
        final /* synthetic */ SecurityCheckupPasswordChangeFragment f9912a;
        private SecurityCheckupPasswordView f9913b;
        private SecurityCheckupPasswordView f9914c;

        public RetypeNewPasswordTextWatcher(SecurityCheckupPasswordChangeFragment securityCheckupPasswordChangeFragment, SecurityCheckupPasswordView securityCheckupPasswordView, SecurityCheckupPasswordView securityCheckupPasswordView2) {
            this.f9912a = securityCheckupPasswordChangeFragment;
            this.f9913b = securityCheckupPasswordView;
            this.f9914c = securityCheckupPasswordView2;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (SecurityCheckupPasswordChangeFragment.m10053b(this.f9912a)) {
                this.f9912a.f9918d.setEnabled(false);
            } else {
                this.f9912a.f9918d.setEnabled(true);
            }
            String text = this.f9914c.getText();
            if (!StringUtil.a(text)) {
                String charSequence2 = charSequence.toString();
                boolean startsWith = text.startsWith(charSequence2);
                boolean z = charSequence.length() >= 6;
                boolean z2;
                if (text.length() == charSequence2.length()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (startsWith) {
                    this.f9912a.f9922h = true;
                    if (z && r3) {
                        this.f9913b.setPasswordStrength(this.f9914c.f9935f);
                        this.f9913b.setPasswordsMatch(true);
                        this.f9913b.m10065c();
                        this.f9914c.setPasswordsMatch(true);
                        return;
                    }
                    this.f9913b.setPasswordStrength(Strength.NULL);
                    this.f9913b.setPasswordsMatch(false);
                    this.f9914c.setPasswordsMatch(false);
                    return;
                }
                if (this.f9912a.f9922h) {
                    this.f9913b.m10064b();
                    this.f9914c.setPasswordsMatch(false);
                }
                this.f9912a.f9922h = false;
                this.f9913b.m10064b();
            }
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    public static void m10052a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        SecurityCheckupPasswordChangeFragment securityCheckupPasswordChangeFragment = (SecurityCheckupPasswordChangeFragment) obj;
        ExecutorService executorService = (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike);
        Lazy a = IdBasedLazy.a(injectorLike, 2164);
        SecurityCheckupLogger a2 = SecurityCheckupLogger.m9901a(injectorLike);
        securityCheckupPasswordChangeFragment.al = executorService;
        securityCheckupPasswordChangeFragment.f9923i = a;
        securityCheckupPasswordChangeFragment.am = a2;
    }

    public final void m10056c(Bundle bundle) {
        super.c(bundle);
        Class cls = SecurityCheckupPasswordChangeFragment.class;
        m10052a((Object) this, getContext());
    }

    public final View m10055a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -110318719);
        View inflate = layoutInflater.inflate(2130907034, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1919115703, a);
        return inflate;
    }

    public final void m10057d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 665416122);
        super.d(bundle);
        this.f9915a = (SecurityCheckupPasswordView) e(2131567355);
        this.f9916b = (SecurityCheckupPasswordView) e(2131567356);
        this.f9917c = (SecurityCheckupPasswordView) e(2131567357);
        this.f9918d = (FbButton) e(2131567358);
        this.f9919e = (FbTextView) e(2131567354);
        this.f9920f = (ProgressBar) e(2131567359);
        this.f9916b.setName(ao().getResources().getString(2131241615));
        this.f9917c.setName(ao().getResources().getString(2131241616));
        this.f9917c.post(new C14661(this));
        this.f9916b.m10063a(new NewPasswordTextWatcher(this, this.f9916b, this.f9917c));
        this.f9917c.m10063a(new RetypeNewPasswordTextWatcher(this, this.f9917c, this.f9916b));
        this.f9915a.m10063a(new C14672(this));
        this.f9918d.setOnClickListener(new C14683(this));
        this.f9918d.setEnabled(false);
        this.f9915a.callOnClick();
        ((InputMethodManager) ao().getSystemService("input_method")).showSoftInput(this.f9915a.f9931b, 1);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1829969368, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -201468015);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.a_(ao().getResources().getString(2131241613));
            hasTitleBar.c(true);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 568012824, a);
    }

    public static boolean m10053b(SecurityCheckupPasswordChangeFragment securityCheckupPasswordChangeFragment) {
        return StringUtil.a(securityCheckupPasswordChangeFragment.f9916b.getText()) || StringUtil.a(securityCheckupPasswordChangeFragment.f9915a.getText()) || StringUtil.a(securityCheckupPasswordChangeFragment.f9917c.getText()) || securityCheckupPasswordChangeFragment.f9921g;
    }

    public static void m10051a(SecurityCheckupPasswordChangeFragment securityCheckupPasswordChangeFragment, Throwable th) {
        securityCheckupPasswordChangeFragment.am.m9903a(Event.PASSWORD_CHANGE_ERROR);
        securityCheckupPasswordChangeFragment.f9919e.setVisibility(0);
        if (th instanceof GraphQLException) {
            GraphQLException graphQLException = (GraphQLException) th;
            if (graphQLException.error == null) {
                securityCheckupPasswordChangeFragment.m10054e();
            }
            if (graphQLException.error.a() == 1604002) {
                securityCheckupPasswordChangeFragment.f9919e.setText(securityCheckupPasswordChangeFragment.ao().getResources().getString(2131241621));
                securityCheckupPasswordChangeFragment.f9915a.m10062a();
                return;
            }
            securityCheckupPasswordChangeFragment.f9919e.setText(graphQLException.error.c());
            return;
        }
        securityCheckupPasswordChangeFragment.m10054e();
    }

    private void m10054e() {
        this.f9919e.setText(ao().getResources().getString(2131241622));
    }

    public static void ar(SecurityCheckupPasswordChangeFragment securityCheckupPasswordChangeFragment) {
        securityCheckupPasswordChangeFragment.f9921g = false;
        securityCheckupPasswordChangeFragment.f9918d.setEnabled(true);
        securityCheckupPasswordChangeFragment.f9920f.setVisibility(8);
    }
}
