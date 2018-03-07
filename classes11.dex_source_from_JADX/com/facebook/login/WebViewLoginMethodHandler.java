package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookServiceException;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.Utility;
import com.facebook.internal.WebDialog;
import com.facebook.internal.WebDialog.Builder;
import com.facebook.internal.WebDialog.OnCompleteListener;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import java.util.Locale;

/* compiled from: video_autoplay */
public class WebViewLoginMethodHandler extends LoginMethodHandler {
    public static final Creator<WebViewLoginMethodHandler> CREATOR = new C00412();
    private WebDialog f244c;
    private String f245d;

    /* compiled from: video_autoplay */
    final class C00412 implements Creator {
        C00412() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new WebViewLoginMethodHandler(parcel);
        }

        public final Object[] newArray(int i) {
            return new WebViewLoginMethodHandler[i];
        }
    }

    /* compiled from: video_autoplay */
    public class AuthDialogBuilder extends Builder {
        public String f242a;
        public boolean f243b;

        public AuthDialogBuilder(Context context, String str, Bundle bundle) {
            super(context, str, "oauth", bundle);
        }

        public final WebDialog m266a() {
            Bundle bundle = this.f;
            bundle.putString("redirect_uri", "fbconnect://success");
            bundle.putString("client_id", this.b);
            bundle.putString("e2e", this.f242a);
            bundle.putString("response_type", "token,signed_request");
            bundle.putString("return_scopes", "true");
            if (this.f243b) {
                bundle.putString("auth_type", "rerequest");
            }
            return new WebDialog(this.a, "oauth", bundle, this.d, this.e);
        }
    }

    public WebViewLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    final String mo2c() {
        return "web_view";
    }

    final boolean mo5d() {
        return true;
    }

    final void mo3a() {
        if (this.f244c != null) {
            this.f244c.cancel();
            this.f244c = null;
        }
    }

    final boolean mo1a(final Request request) {
        String str;
        Bundle bundle = new Bundle();
        if (!Utility.a(request.f208b)) {
            Object join = TextUtils.join(",", request.f208b);
            bundle.putString("scope", join);
            m208a("scope", join);
        }
        bundle.putString("default_audience", request.f209c.getNativeProtocolAudience());
        AccessToken a = AccessToken.a();
        if (a != null) {
            str = a.h;
        } else {
            str = null;
        }
        if (str == null || !str.equals(this.f199b.m250b().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).getString("TOKEN", ""))) {
            Utility.b(this.f199b.m250b());
            m208a("access_token", (Object) "0");
        } else {
            bundle.putString("access_token", str);
            m208a("access_token", (Object) "1");
        }
        C00401 c00401 = new OnCompleteListener(this) {
            final /* synthetic */ WebViewLoginMethodHandler f241b;

            public final void m265a(Bundle bundle, FacebookException facebookException) {
                this.f241b.m269a(request, bundle, facebookException);
            }
        };
        this.f245d = LoginClient.m242j();
        m208a("e2e", this.f245d);
        FragmentActivity b = this.f199b.m250b();
        AuthDialogBuilder authDialogBuilder = new AuthDialogBuilder(b, request.f210d, bundle);
        authDialogBuilder.f242a = this.f245d;
        AuthDialogBuilder authDialogBuilder2 = authDialogBuilder;
        authDialogBuilder2.f243b = request.f212f;
        Builder builder = authDialogBuilder2;
        builder.e = c00401;
        this.f244c = builder.a();
        FacebookDialogFragment facebookDialogFragment = new FacebookDialogFragment();
        facebookDialogFragment.d(true);
        facebookDialogFragment.al = this.f244c;
        facebookDialogFragment.a(b.kO_(), "FacebookDialogFragment");
        return true;
    }

    final void m269a(Request request, Bundle bundle, FacebookException facebookException) {
        Result a;
        if (bundle != null) {
            if (bundle.containsKey("e2e")) {
                this.f245d = bundle.getString("e2e");
            }
            try {
                AccessToken a2 = LoginMethodHandler.m203a(request.m230a(), bundle, AccessTokenSource.WEB_VIEW, request.m231d());
                a = Result.m233a(this.f199b.m252c(), a2);
                CookieSyncManager.createInstance(this.f199b.m250b()).sync();
                m267b(a2.b());
            } catch (FacebookException e) {
                a = Result.m235a(this.f199b.m252c(), null, e.getMessage());
            }
        } else if (facebookException instanceof FacebookOperationCanceledException) {
            a = Result.m234a(this.f199b.m252c(), "User canceled log in.");
        } else {
            String format;
            this.f245d = null;
            String message = facebookException.getMessage();
            if (facebookException instanceof FacebookServiceException) {
                format = String.format(Locale.ROOT, "%d", new Object[]{Integer.valueOf(((FacebookServiceException) facebookException).a().b())});
                message = r0.toString();
            } else {
                format = null;
            }
            a = Result.m236a(this.f199b.m252c(), null, message, format);
        }
        if (!Utility.a(this.f245d)) {
            m207a(this.f245d);
        }
        this.f199b.m249a(a);
    }

    private void m267b(String str) {
        this.f199b.m250b().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).edit().putString("TOKEN", str).apply();
    }

    WebViewLoginMethodHandler(Parcel parcel) {
        super(parcel);
        this.f245d = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f245d);
    }
}
