package com.facebook.katana;

import android.annotation.SuppressLint;
import com.facebook.auth.credentials.DBLFacebookCredentials;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.katana.service.AppSessionListener;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;

@SuppressLint({"DeprecatedClass"})
/* compiled from: SEGMENT_UPLOADING_FAILURE */
class DeviceBasedLoginActivity$LoginAppSessionListener extends AppSessionListener {
    final /* synthetic */ DeviceBasedLoginActivity f24178a;
    private DBLFacebookCredentials f24179b;
    private int f24180c;

    public DeviceBasedLoginActivity$LoginAppSessionListener(DeviceBasedLoginActivity deviceBasedLoginActivity, DBLFacebookCredentials dBLFacebookCredentials, int i) {
        this.f24178a = deviceBasedLoginActivity;
        this.f24179b = dBLFacebookCredentials;
        this.f24180c = i;
    }

    public final void m25477a(Throwable th) {
        if (th == null) {
            this.f24178a.D = true;
            if (this.f24180c == 1) {
                Editor edit = this.f24178a.u.a.edit();
                edit.putBoolean(AuthPrefKeys.p, true);
                edit.commit();
            } else if (this.f24180c == 2) {
                this.f24178a.i();
                return;
            }
            if (DeviceBasedLoginActivity.r(this.f24178a)) {
                DeviceBasedLoginActivity.p(this.f24178a).b();
                if (this.f24178a.u.f().booleanValue()) {
                    DeviceBasedLoginActivity.o(this.f24178a);
                    return;
                } else {
                    DeviceBasedLoginActivity.n(this.f24178a);
                    return;
                }
            }
            return;
        }
        DeviceBasedLoginActivity.a(this.f24178a, th, this.f24179b, this.f24180c);
    }
}
