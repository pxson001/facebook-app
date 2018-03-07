package com.facebook.messaging.sms.migration;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.messaging.sms.migration.util.SMSContactsMigrationTextUtil;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: qrcode_code_scanned */
public class SMSContactMigrationDialogHelperProvider extends AbstractAssistedProvider<SMSContactMigrationDialogHelper> {
    public final SMSContactMigrationDialogHelper m3794a(FragmentManager fragmentManager) {
        return new SMSContactMigrationDialogHelper((Context) getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(this), fragmentManager, (QeAccessor) QeInternalImplMethodAutoProvider.a(this), ResourcesMethodAutoProvider.a(this), SMSContactsMigrationTextUtil.m3864b(this));
    }
}
