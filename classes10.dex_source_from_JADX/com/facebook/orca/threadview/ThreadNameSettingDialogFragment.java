package com.facebook.orca.threadview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.Operation;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.service.model.ModifyThreadParamsBuilder;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.dialogs.NonDismissingAlertDialogFragment;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogParamsBuilder;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.widget.text.TextViewUtils;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: message_capping_composer_button_exit_saved_mode */
public class ThreadNameSettingDialogFragment extends NonDismissingAlertDialogFragment {
    public DataCache am;
    public InputMethodManager an;
    public DefaultBlueServiceOperationFactory ao;
    public ErrorDialogs ap;
    public EditText aq;
    public ListenableFuture<OperationResult> ar;
    private ThreadSummary as;

    /* compiled from: message_capping_composer_button_exit_saved_mode */
    class C11111 implements TextWatcher {
        final /* synthetic */ ThreadNameSettingDialogFragment f7426a;

        C11111(ThreadNameSettingDialogFragment threadNameSettingDialogFragment) {
            this.f7426a = threadNameSettingDialogFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ThreadNameSettingDialogFragment.m7069a(this.f7426a, charSequence);
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: message_capping_composer_button_exit_saved_mode */
    class C11122 implements OnClickListener {
        final /* synthetic */ ThreadNameSettingDialogFragment f7427a;

        C11122(ThreadNameSettingDialogFragment threadNameSettingDialogFragment) {
            this.f7427a = threadNameSettingDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f7427a.an.hideSoftInputFromWindow(this.f7427a.aq.getWindowToken(), 0);
            this.f7427a.a();
        }
    }

    /* compiled from: message_capping_composer_button_exit_saved_mode */
    class C11133 implements OnClickListener {
        final /* synthetic */ ThreadNameSettingDialogFragment f7428a;

        C11133(ThreadNameSettingDialogFragment threadNameSettingDialogFragment) {
            this.f7428a = threadNameSettingDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ThreadNameSettingDialogFragment.ar(this.f7428a);
        }
    }

    /* compiled from: message_capping_composer_button_exit_saved_mode */
    class C11144 implements OnClickListener {
        final /* synthetic */ ThreadNameSettingDialogFragment f7429a;

        C11144(ThreadNameSettingDialogFragment threadNameSettingDialogFragment) {
            this.f7429a = threadNameSettingDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ThreadNameSettingDialogFragment.as(this.f7429a);
        }
    }

    /* compiled from: message_capping_composer_button_exit_saved_mode */
    class C11155 extends OperationResultFutureCallback {
        final /* synthetic */ ThreadNameSettingDialogFragment f7430a;

        C11155(ThreadNameSettingDialogFragment threadNameSettingDialogFragment) {
            this.f7430a = threadNameSettingDialogFragment;
        }

        public final void m7068a(Object obj) {
            this.f7430a.ar = null;
            this.f7430a.b();
        }

        protected final void m7067a(ServiceException serviceException) {
            this.f7430a.ar = null;
            ThreadNameSettingDialogFragment threadNameSettingDialogFragment = this.f7430a;
            ErrorDialogs errorDialogs = threadNameSettingDialogFragment.ap;
            ErrorDialogParamsBuilder b = ErrorDialogParams.a(threadNameSettingDialogFragment.jW_()).a(2131230721).b(2131230762);
            b.g = new C11166(threadNameSettingDialogFragment);
            errorDialogs.a(b.l());
        }
    }

    /* compiled from: message_capping_composer_button_exit_saved_mode */
    public class C11166 implements OnClickListener {
        final /* synthetic */ ThreadNameSettingDialogFragment f7431a;

        public C11166(ThreadNameSettingDialogFragment threadNameSettingDialogFragment) {
            this.f7431a = threadNameSettingDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.f7431a.a();
        }
    }

    public static void m7070a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ThreadNameSettingDialogFragment threadNameSettingDialogFragment = (ThreadNameSettingDialogFragment) obj;
        DataCache a = DataCache.a(fbInjector);
        InputMethodManager b = InputMethodManagerMethodAutoProvider.b(fbInjector);
        DefaultBlueServiceOperationFactory b2 = DefaultBlueServiceOperationFactory.b(fbInjector);
        ErrorDialogs a2 = ErrorDialogs.a(fbInjector);
        threadNameSettingDialogFragment.am = a;
        threadNameSettingDialogFragment.an = b;
        threadNameSettingDialogFragment.ao = b2;
        threadNameSettingDialogFragment.ap = a2;
    }

    public final void m7073a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1983473003);
        super.a(bundle);
        Class cls = ThreadNameSettingDialogFragment.class;
        m7070a((Object) this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -648284439, a);
    }

    public final FbAlertDialogBuilder aq() {
        ThreadKey threadKey;
        Bundle bundle = this.s;
        if (bundle != null) {
            threadKey = (ThreadKey) bundle.getParcelable("thread_key");
        } else {
            threadKey = null;
        }
        Preconditions.checkNotNull(threadKey);
        this.as = this.am.a(threadKey);
        if (this.as == null || !this.as.w) {
            a();
        }
        View inflate = LayoutInflater.from(getContext()).inflate(2130905886, null);
        this.aq = (EditText) inflate.findViewById(2131565208);
        if (this.as != null) {
            this.aq.setText(this.as.g);
        }
        this.aq.setSelection(this.aq.getText().length());
        this.aq.addTextChangedListener(new C11111(this));
        TextViewUtils.a(getContext(), this.aq);
        FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(getContext());
        fbAlertDialogBuilder.a("").b(null).b(inflate).a(2131231500, new C11133(this)).b(2131230727, new C11122(this));
        if (this.as != null && this.as.a()) {
            fbAlertDialogBuilder.c(2131231501, new C11144(this));
        }
        return fbAlertDialogBuilder;
    }

    public final void m7074d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -322728687);
        super.d(bundle);
        this.f.getWindow().setSoftInputMode(4);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2128444174, a);
    }

    public final void m7072G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -519046435);
        super.G();
        m7069a(this, this.aq.getText());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1692487621, a);
    }

    public static void ar(ThreadNameSettingDialogFragment threadNameSettingDialogFragment) {
        threadNameSettingDialogFragment.an.hideSoftInputFromWindow(threadNameSettingDialogFragment.aq.getWindowToken(), 0);
        String trim = threadNameSettingDialogFragment.aq.getText().toString().trim();
        if (StringUtil.c(trim, threadNameSettingDialogFragment.as.g)) {
            threadNameSettingDialogFragment.a();
        } else {
            threadNameSettingDialogFragment.m7071a(trim);
        }
    }

    public static void as(ThreadNameSettingDialogFragment threadNameSettingDialogFragment) {
        threadNameSettingDialogFragment.an.hideSoftInputFromWindow(threadNameSettingDialogFragment.aq.getWindowToken(), 0);
        if (!StringUtil.a(threadNameSettingDialogFragment.as.g)) {
            threadNameSettingDialogFragment.m7071a("");
        }
    }

    private void m7071a(String str) {
        if (this.ar == null) {
            Bundle bundle = new Bundle();
            ModifyThreadParamsBuilder modifyThreadParamsBuilder = new ModifyThreadParamsBuilder();
            modifyThreadParamsBuilder.a = this.as.a;
            bundle.putParcelable("modifyThreadParams", modifyThreadParamsBuilder.b(str).q());
            Operation a = BlueServiceOperationFactoryDetour.a(this.ao, "modify_thread", bundle, -397022977);
            if (!ThreadKey.g(this.as.a)) {
                a.a(new DialogBasedProgressIndicator(getContext(), 2131231159));
            }
            this.ar = a.a();
            Futures.a(this.ar, new C11155(this));
        }
    }

    public static void m7069a(ThreadNameSettingDialogFragment threadNameSettingDialogFragment, CharSequence charSequence) {
        boolean z;
        Button a = ((AlertDialog) threadNameSettingDialogFragment.f).a(-1);
        if (charSequence.length() != 0) {
            z = true;
        } else {
            z = false;
        }
        a.setEnabled(z);
    }
}
