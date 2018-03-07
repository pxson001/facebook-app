package com.facebook.login;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import java.util.Set;

/* compiled from: view_collection */
public class KatanaProxyLoginMethodHandler extends LoginMethodHandler {
    public static final Creator<KatanaProxyLoginMethodHandler> CREATOR = new C00331();

    /* compiled from: view_collection */
    final class C00331 implements Creator {
        C00331() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new KatanaProxyLoginMethodHandler(parcel);
        }

        public final Object[] newArray(int i) {
            return new KatanaProxyLoginMethodHandler[i];
        }
    }

    public KatanaProxyLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    final String mo2c() {
        return "katana_proxy_auth";
    }

    final boolean mo1a(Request request) {
        boolean z;
        Object j = LoginClient.m242j();
        FragmentActivity b = this.f199b.m250b();
        String str = request.f210d;
        Set set = request.f208b;
        boolean z2 = request.f212f;
        for (String str2 : request.f208b) {
            Object obj;
            if (str2 == null || !(str2.startsWith("publish") || str2.startsWith("manage") || LoginManager.f237a.contains(str2))) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                z = true;
                break;
            }
        }
        z = false;
        Intent a = NativeProtocol.a(b, str, set, j, z2, z, request.f209c);
        m208a("e2e", j);
        return m225a(a, RequestCodeOffset.Login.toRequestCode());
    }

    final boolean mo4a(int i, Intent intent) {
        Result a;
        Request request = this.f199b.f225g;
        if (intent == null) {
            a = Result.m234a(request, "Operation canceled");
        } else if (i == 0) {
            Result a2;
            Bundle extras = intent.getExtras();
            String a3 = m224a(extras);
            String string = extras.getString("error_code");
            if ("CONNECTION_FAILURE".equals(string)) {
                a2 = Result.m236a(request, a3, m226b(extras), string);
            } else {
                a2 = Result.m234a(request, a3);
            }
            a = a2;
        } else if (i != -1) {
            a = Result.m235a(request, "Unexpected resultCode from authorization.", null);
        } else {
            a = m223a(request, intent);
        }
        if (a != null) {
            this.f199b.m249a(a);
        } else {
            this.f199b.m254g();
        }
        return true;
    }

    private Result m223a(Request request, Intent intent) {
        String str = null;
        Bundle extras = intent.getExtras();
        String a = m224a(extras);
        String string = extras.getString("error_code");
        String b = m226b(extras);
        String string2 = extras.getString("e2e");
        if (!Utility.a(string2)) {
            m207a(string2);
        }
        if (a == null && string == null && b == null) {
            try {
                return Result.m233a(request, LoginMethodHandler.m203a(request.m230a(), extras, AccessTokenSource.FACEBOOK_APPLICATION_WEB, request.m231d()));
            } catch (FacebookException e) {
                return Result.m235a(request, str, e.getMessage());
            }
        } else if (ServerProtocol.a.contains(a)) {
            return str;
        } else {
            if (ServerProtocol.b.contains(a)) {
                return Result.m234a(request, str);
            }
            return Result.m236a(request, a, b, string);
        }
    }

    public static String m224a(Bundle bundle) {
        String string = bundle.getString("error");
        if (string == null) {
            return bundle.getString("error_type");
        }
        return string;
    }

    public static String m226b(Bundle bundle) {
        String string = bundle.getString("error_message");
        if (string == null) {
            return bundle.getString("error_description");
        }
        return string;
    }

    private boolean m225a(Intent intent, int i) {
        if (intent == null) {
            return false;
        }
        try {
            this.f199b.m246a().a(intent, i);
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }

    KatanaProxyLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    public int describeContents() {
        return 0;
    }
}
