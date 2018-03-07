package com.facebook.messaging.sms.migration;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import com.facebook.inject.Assisted;
import com.facebook.messaging.sms.migration.abtest.ExperimentsForSMSMigrationModule;
import com.facebook.messaging.sms.migration.util.SMSContactsMigrationTextUtil;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import javax.inject.Inject;

/* compiled from: qrcode_create */
public class SMSContactMigrationDialogHelper {
    public final Context f4134a;
    public final FbSharedPreferences f4135b;
    private final FragmentManager f4136c;
    private final QeAccessor f4137d;
    private final Resources f4138e;
    public final SMSContactsMigrationTextUtil f4139f;

    @Inject
    public SMSContactMigrationDialogHelper(Context context, FbSharedPreferences fbSharedPreferences, @Assisted FragmentManager fragmentManager, QeAccessor qeAccessor, Resources resources, SMSContactsMigrationTextUtil sMSContactsMigrationTextUtil) {
        this.f4134a = context;
        this.f4135b = fbSharedPreferences;
        this.f4136c = fragmentManager;
        this.f4137d = qeAccessor;
        this.f4138e = resources;
        this.f4139f = sMSContactsMigrationTextUtil;
    }

    protected final void m3790a() {
        if (((DialogFragment) this.f4136c.a("sms_contact_picker_progress_dialog")) == null) {
            ProgressDialogFragment.a(this.f4137d.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForSMSMigrationModule.f4219c, 2131240064, this.f4138e), true, false).a(this.f4136c, "sms_contact_picker_progress_dialog");
        }
    }

    protected final void m3791b() {
        DialogFragment dialogFragment = (DialogFragment) this.f4136c.a("sms_contact_picker_progress_dialog");
        if (dialogFragment != null) {
            dialogFragment.b();
        }
    }

    protected final void m3792b(OnClickListener onClickListener, OnDismissListener onDismissListener) {
        m3789a(2131240065, onClickListener, onDismissListener);
    }

    protected final void m3793c(OnClickListener onClickListener, OnDismissListener onDismissListener) {
        m3789a(2131240067, onClickListener, onDismissListener);
    }

    private void m3789a(int i, OnClickListener onClickListener, OnDismissListener onDismissListener) {
        new FbAlertDialogBuilder(this.f4134a).a(2131240069, onClickListener).a(onDismissListener).a(i).b();
    }
}
