package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.LoginFragment.C00371;
import com.facebook.login.LoginFragment.C00382;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: video_redirect */
public class LoginClient implements Parcelable {
    public static final Creator<LoginClient> CREATOR = new C00341();
    LoginMethodHandler[] f219a;
    public int f220b = -1;
    Fragment f221c;
    public C00371 f222d;
    public C00382 f223e;
    boolean f224f;
    public Request f225g;
    Map<String, String> f226h;
    private LoginLogger f227i;

    /* compiled from: video_redirect */
    final class C00341 implements Creator {
        C00341() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LoginClient(parcel);
        }

        public final Object[] newArray(int i) {
            return new LoginClient[i];
        }
    }

    /* compiled from: video_redirect */
    public class Request implements Parcelable {
        public static final Creator<Request> CREATOR = new C00351();
        public final LoginBehavior f207a;
        public Set<String> f208b;
        public final DefaultAudience f209c;
        public final String f210d;
        public final String f211e;
        public boolean f212f = false;

        /* compiled from: video_redirect */
        final class C00351 implements Creator {
            C00351() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Request(parcel);
            }

            public final Object[] newArray(int i) {
                return new Request[i];
            }
        }

        final Set<String> m230a() {
            return this.f208b;
        }

        final String m231d() {
            return this.f210d;
        }

        final String m232e() {
            return this.f211e;
        }

        public Request(Parcel parcel) {
            boolean z;
            DefaultAudience defaultAudience = null;
            String readString = parcel.readString();
            this.f207a = readString != null ? LoginBehavior.valueOf(readString) : null;
            Collection arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            this.f208b = new HashSet(arrayList);
            readString = parcel.readString();
            if (readString != null) {
                defaultAudience = DefaultAudience.valueOf(readString);
            }
            this.f209c = defaultAudience;
            this.f210d = parcel.readString();
            this.f211e = parcel.readString();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.f212f = z;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            String str = null;
            parcel.writeString(this.f207a != null ? this.f207a.name() : null);
            parcel.writeStringList(new ArrayList(this.f208b));
            if (this.f209c != null) {
                str = this.f209c.name();
            }
            parcel.writeString(str);
            parcel.writeString(this.f210d);
            parcel.writeString(this.f211e);
            parcel.writeByte((byte) (this.f212f ? 1 : 0));
        }
    }

    /* compiled from: video_redirect */
    public class Result implements Parcelable {
        public static final Creator<Result> CREATOR = new C00361();
        public final Code f213a;
        final AccessToken f214b;
        final String f215c;
        final String f216d;
        final Request f217e;
        public Map<String, String> f218f;

        /* compiled from: video_redirect */
        final class C00361 implements Creator {
            C00361() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Result(parcel);
            }

            public final Object[] newArray(int i) {
                return new Result[i];
            }
        }

        /* compiled from: video_redirect */
        public enum Code {
            SUCCESS("success"),
            CANCEL("cancel"),
            ERROR("error");
            
            private final String loggingValue;

            private Code(String str) {
                this.loggingValue = str;
            }

            public final String getLoggingValue() {
                return this.loggingValue;
            }
        }

        private Result(Request request, Code code, AccessToken accessToken, String str, String str2) {
            Validate.a(code, "code");
            this.f217e = request;
            this.f214b = accessToken;
            this.f215c = str;
            this.f213a = code;
            this.f216d = str2;
        }

        static Result m233a(Request request, AccessToken accessToken) {
            return new Result(request, Code.SUCCESS, accessToken, null, null);
        }

        public static Result m234a(Request request, String str) {
            return new Result(request, Code.CANCEL, null, str, null);
        }

        public static Result m235a(Request request, String str, String str2) {
            return m236a(request, str, str2, null);
        }

        public static Result m236a(Request request, String str, String str2, String str3) {
            CharSequence charSequence = ": ";
            String[] strArr = new String[]{str, str2};
            ArrayList arrayList = new ArrayList();
            for (Object obj : strArr) {
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            return new Result(request, Code.ERROR, null, TextUtils.join(charSequence, arrayList), str3);
        }

        public Result(Parcel parcel) {
            this.f213a = Code.valueOf(parcel.readString());
            this.f214b = (AccessToken) parcel.readParcelable(AccessToken.class.getClassLoader());
            this.f215c = parcel.readString();
            this.f216d = parcel.readString();
            this.f217e = (Request) parcel.readParcelable(Request.class.getClassLoader());
            this.f218f = Utility.a(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f213a.name());
            parcel.writeParcelable(this.f214b, i);
            parcel.writeString(this.f215c);
            parcel.writeString(this.f216d);
            parcel.writeParcelable(this.f217e, i);
            Utility.a(parcel, this.f218f);
        }
    }

    public LoginClient(Fragment fragment) {
        this.f221c = fragment;
    }

    public final Fragment m246a() {
        return this.f221c;
    }

    final void m247a(Fragment fragment) {
        if (this.f221c != null) {
            throw new FacebookException("Can't set fragment once it is already set.");
        }
        this.f221c = fragment;
    }

    public final FragmentActivity m250b() {
        return this.f221c.o();
    }

    public final Request m252c() {
        return this.f225g;
    }

    private void m240b(Request request) {
        if (request != null) {
            if (this.f225g != null) {
                throw new FacebookException("Attempted to authorize while a request is pending.");
            } else if (AccessToken.a() == null || m243l()) {
                this.f225g = request;
                ArrayList arrayList = new ArrayList();
                LoginBehavior loginBehavior = request.f207a;
                if (loginBehavior.allowsKatanaAuth()) {
                    arrayList.add(new GetTokenLoginMethodHandler(this));
                    arrayList.add(new KatanaProxyLoginMethodHandler(this));
                }
                if (loginBehavior.allowsWebViewAuth()) {
                    arrayList.add(new WebViewLoginMethodHandler(this));
                }
                if (loginBehavior.allowsDeviceAuth()) {
                    arrayList.add(new DeviceAuthMethodHandler(this));
                }
                LoginMethodHandler[] loginMethodHandlerArr = new LoginMethodHandler[arrayList.size()];
                arrayList.toArray(loginMethodHandlerArr);
                this.f219a = loginMethodHandlerArr;
                m254g();
            }
        }
    }

    final void m248a(Request request) {
        Object obj;
        if (this.f225g == null || this.f220b < 0) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            m240b(request);
        }
    }

    public final LoginMethodHandler m253f() {
        if (this.f220b >= 0) {
            return this.f219a[this.f220b];
        }
        return null;
    }

    private boolean m243l() {
        if (this.f224f) {
            return true;
        }
        if (m250b().checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            FragmentActivity b = m250b();
            m251b(Result.m235a(this.f225g, b.getString(2131242270), b.getString(2131242271)));
            return false;
        }
        this.f224f = true;
        return true;
    }

    public final void m254g() {
        if (this.f220b >= 0) {
            m238a(m253f().mo2c(), "skipped", null, null, m253f().f198a);
        }
        while (this.f219a != null && this.f220b < this.f219a.length - 1) {
            this.f220b++;
            if (m244n()) {
                return;
            }
        }
        if (this.f225g != null) {
            m251b(Result.m235a(this.f225g, "Login attempt failed.", null));
        }
    }

    private void m239a(String str, String str2, boolean z) {
        if (this.f226h == null) {
            this.f226h = new HashMap();
        }
        if (this.f226h.containsKey(str) && z) {
            str2 = ((String) this.f226h.get(str)) + "," + str2;
        }
        this.f226h.put(str, str2);
    }

    private boolean m244n() {
        boolean z = false;
        LoginMethodHandler f = m253f();
        if (!f.mo5d() || m243l()) {
            z = f.mo1a(this.f225g);
            if (z) {
                LoginLogger o = m245o();
                String str = this.f225g.f211e;
                String c = f.mo2c();
                Bundle a = LoginLogger.m263a(str);
                a.putString("3_method", c);
                o.f234a.a("fb_mobile_login_method_start", null, a);
            } else {
                m239a("not_tried", f.mo2c(), true);
            }
        } else {
            m239a("no_internet_permission", "1", false);
        }
        return z;
    }

    public final void m249a(Result result) {
        if (result.f214b == null || AccessToken.a() == null) {
            m251b(result);
        } else {
            m241c(result);
        }
    }

    public final void m251b(Result result) {
        LoginMethodHandler f = m253f();
        if (f != null) {
            m237a(f.mo2c(), result, f.f198a);
        }
        if (this.f226h != null) {
            result.f218f = this.f226h;
        }
        this.f219a = null;
        this.f220b = -1;
        this.f225g = null;
        this.f226h = null;
        if (this.f222d != null) {
            LoginFragment loginFragment = this.f222d.f228a;
            loginFragment.f233c = null;
            int i = result.f213a == Code.CANCEL ? 0 : -1;
            Bundle bundle = new Bundle();
            bundle.putParcelable("com.facebook.LoginFragment:Result", result);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            if (loginFragment.mx_()) {
                loginFragment.o().setResult(i, intent);
                loginFragment.o().finish();
            }
        }
    }

    private void m241c(Result result) {
        if (result.f214b == null) {
            throw new FacebookException("Can't validate without a token");
        }
        Result a;
        AccessToken a2 = AccessToken.a();
        AccessToken accessToken = result.f214b;
        if (!(a2 == null || accessToken == null)) {
            try {
                if (a2.i().equals(accessToken.i())) {
                    a = Result.m233a(this.f225g, result.f214b);
                    m251b(a);
                }
            } catch (Exception e) {
                m251b(Result.m235a(this.f225g, "Caught exception", e.getMessage()));
                return;
            }
        }
        a = Result.m235a(this.f225g, "User logged in as different Facebook user.", null);
        m251b(a);
    }

    private LoginLogger m245o() {
        if (this.f227i == null || !this.f227i.f235b.equals(this.f225g.f210d)) {
            this.f227i = new LoginLogger(m250b(), this.f225g.f210d);
        }
        return this.f227i;
    }

    public final void m255h() {
        if (this.f223e != null) {
            this.f223e.f229a.findViewById(2131560415).setVisibility(0);
        }
    }

    private void m237a(String str, Result result, Map<String, String> map) {
        m238a(str, result.f213a.getLoggingValue(), result.f215c, result.f216d, map);
    }

    private void m238a(String str, String str2, String str3, String str4, Map<String, String> map) {
        if (this.f225g == null) {
            LoginLogger o = m245o();
            Bundle a = LoginLogger.m263a("");
            a.putString("2_result", Code.ERROR.getLoggingValue());
            a.putString("5_error_message", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.");
            a.putString("3_method", str);
            o.f234a.a("fb_mobile_login_method_complete", null, a);
            return;
        }
        m245o().m264a(this.f225g.m232e(), str, str2, str3, str4, map);
    }

    static String m242j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("init", System.currentTimeMillis());
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }

    public LoginClient(Parcel parcel) {
        Parcelable[] readParcelableArray = parcel.readParcelableArray(LoginMethodHandler.class.getClassLoader());
        this.f219a = new LoginMethodHandler[readParcelableArray.length];
        for (int i = 0; i < readParcelableArray.length; i++) {
            this.f219a[i] = (LoginMethodHandler) readParcelableArray[i];
            this.f219a[i].m206a(this);
        }
        this.f220b = parcel.readInt();
        this.f225g = (Request) parcel.readParcelable(Request.class.getClassLoader());
        this.f226h = Utility.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelableArray(this.f219a, i);
        parcel.writeInt(this.f220b);
        parcel.writeParcelable(this.f225g, i);
        Utility.a(parcel, this.f226h);
    }
}
