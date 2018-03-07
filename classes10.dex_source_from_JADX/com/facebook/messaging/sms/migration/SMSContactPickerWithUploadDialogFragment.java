package com.facebook.messaging.sms.migration;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.messaging.sms.migration.pref.SMSMigrationPrefKeys;

/* compiled from: qrcode_camera_exception */
public class SMSContactPickerWithUploadDialogFragment extends SMSContactPickerFragment {

    /* compiled from: qrcode_camera_exception */
    public class C06271 implements OnClickListener {
        final /* synthetic */ SMSContactPickerWithUploadDialogFragment f4168a;

        public C06271(SMSContactPickerWithUploadDialogFragment sMSContactPickerWithUploadDialogFragment) {
            this.f4168a = sMSContactPickerWithUploadDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f4168a.f4165g.m3867a();
            this.f4168a.b(SMSContactsMigratorConstants.f4179a);
        }
    }

    /* compiled from: qrcode_camera_exception */
    public class C06282 implements OnClickListener {
        final /* synthetic */ SMSContactPickerWithUploadDialogFragment f4169a;

        public C06282(SMSContactPickerWithUploadDialogFragment sMSContactPickerWithUploadDialogFragment) {
            this.f4169a = sMSContactPickerWithUploadDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f4169a.b(SMSContactsMigratorConstants.f4179a);
        }
    }

    protected final void mo120e() {
        SMSContactMigrationDialogHelper sMSContactMigrationDialogHelper = this.f4166h;
        C06271 c06271 = new C06271(this);
        C06282 c06282 = new C06282(this);
        CharSequence a = sMSContactMigrationDialogHelper.f4139f.m3865a(sMSContactMigrationDialogHelper.f4134a.getResources().getString(2131240071), "{learn_more_link}", null);
        sMSContactMigrationDialogHelper.f4135b.edit().putBoolean(SMSMigrationPrefKeys.f4235a, true).commit();
        TextView textView = (TextView) new Builder(sMSContactMigrationDialogHelper.f4134a).a(2131240070).b(a).a(2131240073, c06271).b(2131240074, c06282).a(false).b().findViewById(2131559674);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setLinkTextColor(sMSContactMigrationDialogHelper.f4134a.getResources().getColor(2131363731));
    }
}
