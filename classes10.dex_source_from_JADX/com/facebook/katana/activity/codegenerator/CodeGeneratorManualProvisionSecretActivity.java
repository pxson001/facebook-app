package com.facebook.katana.activity.codegenerator;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.prefs.FbandroidPrefKeys;
import com.facebook.katana.util.AlertDialogs;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: user_application_invite_settings */
public class CodeGeneratorManualProvisionSecretActivity extends BaseFacebookActivity implements OnClickListener {
    private long f724p;
    private SecureContextHelper f725q;
    private FbSharedPreferences f726r;

    /* compiled from: user_application_invite_settings */
    class C01091 implements DialogInterface.OnClickListener {
        final /* synthetic */ CodeGeneratorManualProvisionSecretActivity f723a;

        C01091(CodeGeneratorManualProvisionSecretActivity codeGeneratorManualProvisionSecretActivity) {
            this.f723a = codeGeneratorManualProvisionSecretActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public final void m740b(Bundle bundle) {
        super.b(bundle);
        FbInjector hz_ = hz_();
        this.f724p = Long.parseLong((String) IdBasedProvider.a(hz_, 4442).get());
        this.f726r = (FbSharedPreferences) FbSharedPreferencesImpl.a(hz_);
        this.f725q = (SecureContextHelper) DefaultSecureContextHelper.a(hz_);
        setContentView(2130903584);
        findViewById(2131560338).setOnClickListener(this);
        ((TextView) findViewById(2131560336)).setText("http://fb.me/cg");
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1219024710);
        super.onResume();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1263796871, a);
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1771915510);
        if (view.getId() == 2131560338) {
            String b = CodeGeneratorValidator.b(((EditText) findViewById(2131560337)).getText().toString());
            if (CodeGeneratorValidator.a(b)) {
                this.f726r.edit().a((PrefKey) FbandroidPrefKeys.f.a(Long.toString(this.f724p)), b).commit();
                this.f725q.a(new Intent(getApplicationContext(), CodeGeneratorActivity.class), this);
                finish();
                Logger.a(2, EntryType.UI_INPUT_END, -568505178, a);
                return;
            }
            m739j();
        }
        LogUtils.a(517515532, a);
    }

    private void m739j() {
        AlertDialogs.a(this, getString(2131236464), 17301659, getString(2131236474), getString(2131230756), new C01091(this), null, null, null, false).show();
    }
}
