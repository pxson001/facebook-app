package com.facebook.auth.login.ui;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.auth.credentials.PasswordCredentials;
import com.facebook.auth.credentials.PasswordCredentials.Type;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: product_details_checkout_button */
public class PasswordCredentialsViewGroupHelper {
    private static final Class<?> f7392a = PasswordCredentialsViewGroupHelper.class;
    private final InputMethodManager f7393b;
    private final String f7394c;
    private final PackageManager f7395d;
    private final AccountManager f7396e;
    private final TelephonyManager f7397f;
    private final boolean f7398g;
    private AuthFragmentLogoViewGroup<PasswordCredentialsFragmentControl> f7399h;
    private PasswordCredentialsFragmentControl f7400i;
    private TextView f7401j;
    private TextView f7402k;
    private View f7403l;
    @Nullable
    private Button f7404m;
    @Nullable
    private PasswordCredentialsViewGroupHelperActionCallback f7405n;

    /* compiled from: product_details_checkout_button */
    class C04431 implements TextWatcher {
        final /* synthetic */ PasswordCredentialsViewGroupHelper f7388a;

        C04431(PasswordCredentialsViewGroupHelper passwordCredentialsViewGroupHelper) {
            this.f7388a = passwordCredentialsViewGroupHelper;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            PasswordCredentialsViewGroupHelper.m10489b(this.f7388a);
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: product_details_checkout_button */
    class C04442 implements OnClickListener {
        final /* synthetic */ PasswordCredentialsViewGroupHelper f7389a;

        C04442(PasswordCredentialsViewGroupHelper passwordCredentialsViewGroupHelper) {
            this.f7389a = passwordCredentialsViewGroupHelper;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1348572078);
            PasswordCredentialsViewGroupHelper.m10490c(this.f7389a);
            Logger.a(2, EntryType.UI_INPUT_END, -590780524, a);
        }
    }

    /* compiled from: product_details_checkout_button */
    class C04453 implements OnClickListener {
        final /* synthetic */ PasswordCredentialsViewGroupHelper f7390a;

        C04453(PasswordCredentialsViewGroupHelper passwordCredentialsViewGroupHelper) {
            this.f7390a = passwordCredentialsViewGroupHelper;
        }

        public void onClick(View view) {
            Logger.a(2, EntryType.UI_INPUT_END, 626228915, Logger.a(2, EntryType.UI_INPUT_START, -1399738136));
        }
    }

    /* compiled from: product_details_checkout_button */
    class C04464 implements OnEditorActionListener {
        final /* synthetic */ PasswordCredentialsViewGroupHelper f7391a;

        C04464(PasswordCredentialsViewGroupHelper passwordCredentialsViewGroupHelper) {
            this.f7391a = passwordCredentialsViewGroupHelper;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 2) {
                return false;
            }
            PasswordCredentialsViewGroupHelper.m10490c(this.f7391a);
            return true;
        }
    }

    /* compiled from: product_details_checkout_button */
    public interface PasswordCredentialsViewGroupHelperActionCallback {
    }

    @Inject
    public PasswordCredentialsViewGroupHelper(InputMethodManager inputMethodManager, String str, PackageManager packageManager, AccountManager accountManager, TelephonyManager telephonyManager, Boolean bool) {
        this.f7393b = inputMethodManager;
        this.f7394c = str;
        this.f7395d = packageManager;
        this.f7396e = accountManager;
        this.f7397f = telephonyManager;
        this.f7398g = bool.booleanValue();
    }

    public final void m10491a(AuthFragmentLogoViewGroup<PasswordCredentialsFragmentControl> authFragmentLogoViewGroup, PasswordCredentialsFragmentControl passwordCredentialsFragmentControl, TextView textView, TextView textView2, View view, @Nullable Button button, @Nullable PasswordCredentialsViewGroupHelperActionCallback passwordCredentialsViewGroupHelperActionCallback) {
        this.f7399h = authFragmentLogoViewGroup;
        this.f7400i = passwordCredentialsFragmentControl;
        this.f7401j = textView;
        this.f7402k = textView2;
        this.f7403l = view;
        this.f7404m = button;
        this.f7405n = passwordCredentialsViewGroupHelperActionCallback;
        m10489b(this);
        TextWatcher c04431 = new C04431(this);
        m10488a();
        this.f7401j.addTextChangedListener(c04431);
        this.f7402k.addTextChangedListener(c04431);
        this.f7403l.setOnClickListener(new C04442(this));
        if (this.f7404m != null) {
            this.f7404m.setOnClickListener(new C04453(this));
        }
        this.f7402k.setOnEditorActionListener(new C04464(this));
        this.f7402k.setTypeface(Typeface.DEFAULT);
    }

    private void m10488a() {
        if (this.f7401j instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.f7401j;
            Set d = Sets.d();
            if (this.f7395d.checkPermission("android.permission.READ_PHONE_STATE", this.f7394c) == 0 && this.f7397f != null) {
                CharSequence line1Number = this.f7397f.getLine1Number();
                if (line1Number != null && Patterns.PHONE.matcher(line1Number).matches()) {
                    d.add(line1Number);
                }
            }
            if (this.f7395d.checkPermission("android.permission.GET_ACCOUNTS", this.f7394c) == 0 && this.f7396e != null) {
                for (Account account : this.f7396e.getAccounts()) {
                    if (Patterns.EMAIL_ADDRESS.matcher(account.name).matches()) {
                        d.add(account.name);
                    }
                }
            }
            autoCompleteTextView.setAdapter(new ArrayAdapter(autoCompleteTextView.getContext(), 17367050, d.toArray(new String[d.size()])));
        }
    }

    public static void m10489b(PasswordCredentialsViewGroupHelper passwordCredentialsViewGroupHelper) {
        View view = passwordCredentialsViewGroupHelper.f7403l;
        boolean z = passwordCredentialsViewGroupHelper.f7401j.getText().length() > 0 && passwordCredentialsViewGroupHelper.f7402k.getText().length() > 0;
        view.setEnabled(z);
    }

    public static void m10490c(PasswordCredentialsViewGroupHelper passwordCredentialsViewGroupHelper) {
        String charSequence = passwordCredentialsViewGroupHelper.f7401j.getText().toString();
        if (charSequence.length() > 0) {
            String charSequence2 = passwordCredentialsViewGroupHelper.f7402k.getText().toString();
            if (charSequence2.length() > 0) {
                passwordCredentialsViewGroupHelper.f7393b.hideSoftInputFromWindow(passwordCredentialsViewGroupHelper.f7399h.getWindowToken(), 0);
                PasswordCredentials passwordCredentials = new PasswordCredentials(charSequence, charSequence2, passwordCredentialsViewGroupHelper.f7398g ? Type.WORK_ACCOUNT_PASSWORD : Type.UNSET);
                DialogBasedProgressIndicator dialogBasedProgressIndicator = new DialogBasedProgressIndicator(passwordCredentialsViewGroupHelper.f7399h.getContext(), 2131230858);
            }
        }
    }
}
