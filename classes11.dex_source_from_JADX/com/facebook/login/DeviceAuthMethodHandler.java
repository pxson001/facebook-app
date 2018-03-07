package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.login.DeviceAuthDialog.C00242;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* compiled from: waiting */
public class DeviceAuthMethodHandler extends LoginMethodHandler {
    public static final Creator<DeviceAuthMethodHandler> CREATOR = new C00291();
    private static ScheduledThreadPoolExecutor f200c;

    /* compiled from: waiting */
    final class C00291 implements Creator {
        C00291() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DeviceAuthMethodHandler(parcel);
        }

        public final Object[] newArray(int i) {
            return new DeviceAuthMethodHandler[i];
        }
    }

    public DeviceAuthMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    final boolean mo1a(Request request) {
        DeviceAuthDialog deviceAuthDialog = new DeviceAuthDialog();
        deviceAuthDialog.a(this.f199b.m250b().kO_(), "login_with_facebook");
        Bundle bundle = new Bundle();
        bundle.putString("type", "device_code");
        bundle.putString("client_id", FacebookSdk.i());
        bundle.putString("scope", TextUtils.join(",", request.f208b));
        new GraphRequest(null, "oauth/device", bundle, HttpMethod.POST, new C00242(deviceAuthDialog)).g();
        return true;
    }

    public final void m214a(String str, String str2, String str3, Collection<String> collection, Collection<String> collection2, AccessTokenSource accessTokenSource, Date date, Date date2) {
        this.f199b.m249a(Result.m233a(this.f199b.m252c(), new AccessToken(str, str2, str3, collection, collection2, accessTokenSource, date, date2)));
    }

    public static synchronized ScheduledThreadPoolExecutor m213b() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        synchronized (DeviceAuthMethodHandler.class) {
            if (f200c == null) {
                f200c = new ScheduledThreadPoolExecutor(1);
            }
            scheduledThreadPoolExecutor = f200c;
        }
        return scheduledThreadPoolExecutor;
    }

    protected DeviceAuthMethodHandler(Parcel parcel) {
        super(parcel);
    }

    final String mo2c() {
        return "device_auth";
    }

    public int describeContents() {
        return 0;
    }
}
