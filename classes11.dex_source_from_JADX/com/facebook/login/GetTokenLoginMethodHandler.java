package com.facebook.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.NativeProtocol.NativeAppInfo;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.GraphMeRequestWithCacheCallback;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import com.facebook.tools.dextr.runtime.detour.ServiceConnectionDetour;
import java.util.Collection;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: viewed_with_location_off */
public class GetTokenLoginMethodHandler extends LoginMethodHandler {
    public static final Creator<GetTokenLoginMethodHandler> CREATOR = new C00323();
    public GetTokenClient f206c;

    /* compiled from: viewed_with_location_off */
    public class C00312 implements GraphMeRequestWithCacheCallback {
        final /* synthetic */ Bundle f203a;
        final /* synthetic */ Request f204b;
        final /* synthetic */ GetTokenLoginMethodHandler f205c;

        public C00312(GetTokenLoginMethodHandler getTokenLoginMethodHandler, Bundle bundle, Request request) {
            this.f205c = getTokenLoginMethodHandler;
            this.f203a = bundle;
            this.f204b = request;
        }

        public final void m218a(JSONObject jSONObject) {
            try {
                this.f203a.putString("com.facebook.platform.extra.USER_ID", jSONObject.getString("id"));
                this.f205c.m221b(this.f204b, this.f203a);
            } catch (JSONException e) {
                this.f205c.f199b.m251b(Result.m235a(this.f205c.f199b.m252c(), "Caught exception", e.getMessage()));
            }
        }

        public final void m217a(FacebookException facebookException) {
            this.f205c.f199b.m251b(Result.m235a(this.f205c.f199b.f225g, "Caught exception", facebookException.getMessage()));
        }
    }

    /* compiled from: viewed_with_location_off */
    final class C00323 implements Creator {
        C00323() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GetTokenLoginMethodHandler(parcel);
        }

        public final Object[] newArray(int i) {
            return new GetTokenLoginMethodHandler[i];
        }
    }

    public GetTokenLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    final String mo2c() {
        return "get_token";
    }

    final void mo3a() {
        if (this.f206c != null) {
            this.f206c.d = false;
            this.f206c.c = null;
            this.f206c = null;
        }
    }

    final boolean mo1a(final Request request) {
        this.f206c = new GetTokenClient(this.f199b.m250b(), request.f210d);
        GetTokenClient getTokenClient = this.f206c;
        boolean z = false;
        if (!(getTokenClient.d || NativeProtocol.a(getTokenClient.i) == -1)) {
            Intent b;
            Context context = getTokenClient.a;
            for (NativeAppInfo nativeAppInfo : NativeProtocol.b) {
                b = NativeProtocol.b(context, new Intent("com.facebook.platform.PLATFORM_SERVICE").setPackage(nativeAppInfo.a()).addCategory("android.intent.category.DEFAULT"), nativeAppInfo);
                if (b != null) {
                    break;
                }
            }
            b = null;
            Intent intent = b;
            if (intent != null) {
                getTokenClient.d = true;
                ServiceConnectionDetour.a(getTokenClient.a, intent, getTokenClient, 1, -1690279553);
                z = true;
            }
        }
        if (!z) {
            return false;
        }
        this.f199b.m255h();
        this.f206c.c = new Object(this) {
            public final /* synthetic */ GetTokenLoginMethodHandler f202b;
        };
        return true;
    }

    public final void m221b(Request request, Bundle bundle) {
        AccessTokenSource accessTokenSource = AccessTokenSource.FACEBOOK_APPLICATION_SERVICE;
        String str = request.f210d;
        Collection collection = null;
        Date a = Utility.a(bundle, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", new Date(0));
        Collection stringArrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
        String string = bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN");
        if (!Utility.a(string)) {
            collection = new AccessToken(string, str, bundle.getString("com.facebook.platform.extra.USER_ID"), stringArrayList, null, accessTokenSource, a, new Date());
        }
        this.f199b.m249a(Result.m233a(this.f199b.f225g, (AccessToken) collection));
    }

    GetTokenLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    public int describeContents() {
        return 0;
    }
}
