package com.facebook.katana.dbl;

import android.net.Uri;
import com.facebook.auth.credentials.DBLFacebookCredentials;
import com.facebook.auth.credentials.DeviceBasedLoginCredentials;
import com.facebook.auth.credentials.PasswordCredentials;

/* compiled from: trace_control */
public interface DeviceBasedLoginListener {
    void mo74a();

    void mo75a(Uri uri);

    void mo76a(DBLFacebookCredentials dBLFacebookCredentials);

    void mo77a(DeviceBasedLoginCredentials deviceBasedLoginCredentials, DBLFacebookCredentials dBLFacebookCredentials);

    void mo78a(PasswordCredentials passwordCredentials, DBLFacebookCredentials dBLFacebookCredentials, int i);

    void mo79b();

    void mo80d();
}
