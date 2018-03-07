package com.facebook.login;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.PermissionsPair;
import com.facebook.login.LoginClient.Result;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: wakelock is null and cannot be released */
public class DeviceAuthDialog extends DialogFragment {
    private ProgressBar al;
    private TextView am;
    public DeviceAuthMethodHandler an;
    public AtomicBoolean ao = new AtomicBoolean();
    private volatile GraphRequestAsyncTask ap;
    private volatile ScheduledFuture aq;
    public volatile RequestState ar;
    public Dialog as;
    private boolean at = false;

    /* compiled from: wakelock is null and cannot be released */
    class C00231 implements OnClickListener {
        final /* synthetic */ DeviceAuthDialog f188a;

        C00231(DeviceAuthDialog deviceAuthDialog) {
            this.f188a = deviceAuthDialog;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1012567082);
            DeviceAuthDialog.aq(this.f188a);
            Logger.a(2, EntryType.UI_INPUT_END, -547185715, a);
        }
    }

    /* compiled from: wakelock is null and cannot be released */
    public class C00242 implements Callback {
        final /* synthetic */ DeviceAuthDialog f189a;

        public C00242(DeviceAuthDialog deviceAuthDialog) {
            this.f189a = deviceAuthDialog;
        }

        public final void m190a(GraphResponse graphResponse) {
            if (graphResponse.a() != null) {
                DeviceAuthDialog.m196a(this.f189a, graphResponse.a().e());
                return;
            }
            JSONObject b = graphResponse.b();
            RequestState requestState = new RequestState();
            try {
                requestState.m194a(b.getString("user_code"));
                requestState.m195b(b.getString("code"));
                requestState.m193a(b.getLong("interval"));
                DeviceAuthDialog.m197a(this.f189a, requestState);
            } catch (Throwable e) {
                DeviceAuthDialog.m196a(this.f189a, new FacebookException(e));
            }
        }
    }

    /* compiled from: wakelock is null and cannot be released */
    class C00253 implements Runnable {
        final /* synthetic */ DeviceAuthDialog f190a;

        C00253(DeviceAuthDialog deviceAuthDialog) {
            this.f190a = deviceAuthDialog;
        }

        public void run() {
            DeviceAuthDialog.an(this.f190a);
        }
    }

    /* compiled from: wakelock is null and cannot be released */
    public class C00264 implements Callback {
        final /* synthetic */ DeviceAuthDialog f191a;

        public C00264(DeviceAuthDialog deviceAuthDialog) {
            this.f191a = deviceAuthDialog;
        }

        public final void m191a(GraphResponse graphResponse) {
            if (!this.f191a.ao.get()) {
                FacebookRequestError a = graphResponse.a();
                if (a != null) {
                    String d = a.d();
                    if (d.equals("authorization_pending") || d.equals("slow_down")) {
                        DeviceAuthDialog.ao(this.f191a);
                        return;
                    } else if (d.equals("authorization_declined") || d.equals("code_expired")) {
                        DeviceAuthDialog.aq(this.f191a);
                        return;
                    } else {
                        DeviceAuthDialog.m196a(this.f191a, graphResponse.a().e());
                        return;
                    }
                }
                try {
                    DeviceAuthDialog.m198a(this.f191a, graphResponse.b().getString("access_token"));
                } catch (Throwable e) {
                    DeviceAuthDialog.m196a(this.f191a, new FacebookException(e));
                }
            }
        }
    }

    /* compiled from: wakelock is null and cannot be released */
    public class RequestState implements Parcelable {
        public static final Creator<RequestState> CREATOR = new C00281();
        public String f194a;
        public String f195b;
        public long f196c;
        public long f197d;

        /* compiled from: wakelock is null and cannot be released */
        final class C00281 implements Creator<RequestState> {
            C00281() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new RequestState(parcel);
            }

            public final Object[] newArray(int i) {
                return new RequestState[i];
            }
        }

        RequestState() {
        }

        public final void m194a(String str) {
            this.f194a = str;
        }

        public final void m195b(String str) {
            this.f195b = str;
        }

        public final void m193a(long j) {
            this.f196c = j;
        }

        protected RequestState(Parcel parcel) {
            this.f194a = parcel.readString();
            this.f195b = parcel.readString();
            this.f196c = parcel.readLong();
            this.f197d = parcel.readLong();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f194a);
            parcel.writeString(this.f195b);
            parcel.writeLong(this.f196c);
            parcel.writeLong(this.f197d);
        }
    }

    @Nullable
    public final View m200a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1086339152);
        View a2 = super.a(layoutInflater, viewGroup, bundle);
        this.an = (DeviceAuthMethodHandler) ((LoginFragment) ((FacebookActivity) o()).r).f232b.m253f();
        if (bundle != null) {
            RequestState requestState = (RequestState) bundle.getParcelable("request_state");
            if (requestState != null) {
                m197a(this, requestState);
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1021496217, a);
        return a2;
    }

    public final Dialog m201c(Bundle bundle) {
        this.as = new Dialog(o(), 2131626638);
        View inflate = o().getLayoutInflater().inflate(2130903611, null);
        this.al = (ProgressBar) inflate.findViewById(2131559418);
        this.am = (TextView) inflate.findViewById(2131560413);
        ((Button) inflate.findViewById(2131560414)).setOnClickListener(new C00231(this));
        ((TextView) inflate.findViewById(2131560412)).setText(Html.fromHtml(b(2131242276)));
        this.as.setContentView(inflate);
        return this.as;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (!this.at) {
            aq(this);
        }
    }

    public final void m202e(Bundle bundle) {
        super.e(bundle);
        if (this.ar != null) {
            bundle.putParcelable("request_state", this.ar);
        }
    }

    public final void m199I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -399442598);
        this.at = true;
        this.ao.set(true);
        super.I();
        if (this.ap != null) {
            this.ap.cancel(true);
        }
        if (this.aq != null) {
            this.aq.cancel(true);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2088079727, a);
    }

    public static void m197a(DeviceAuthDialog deviceAuthDialog, RequestState requestState) {
        deviceAuthDialog.ar = requestState;
        deviceAuthDialog.am.setText(requestState.f194a);
        deviceAuthDialog.am.setVisibility(0);
        deviceAuthDialog.al.setVisibility(8);
        Object obj = null;
        if (requestState.f197d != 0 && (new Date().getTime() - requestState.f197d) - (requestState.f196c * 1000) < 0) {
            obj = 1;
        }
        if (obj != null) {
            ao(deviceAuthDialog);
        } else {
            an(deviceAuthDialog);
        }
    }

    public static void an(DeviceAuthDialog deviceAuthDialog) {
        deviceAuthDialog.ar.f197d = new Date().getTime();
        Bundle bundle = new Bundle();
        bundle.putString("type", "device_token");
        bundle.putString("client_id", FacebookSdk.i());
        bundle.putString("code", deviceAuthDialog.ar.f195b);
        deviceAuthDialog.ap = new GraphRequest(null, "oauth/device", bundle, HttpMethod.POST, new C00264(deviceAuthDialog)).g();
    }

    public static void ao(DeviceAuthDialog deviceAuthDialog) {
        deviceAuthDialog.aq = DeviceAuthMethodHandler.m213b().schedule(new C00253(deviceAuthDialog), deviceAuthDialog.ar.f196c, TimeUnit.SECONDS);
    }

    public static void m198a(DeviceAuthDialog deviceAuthDialog, final String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,permissions");
        new GraphRequest(new AccessToken(str, FacebookSdk.i(), "0", null, null, null, null, null), "me", bundle, HttpMethod.GET, new Callback(deviceAuthDialog) {
            final /* synthetic */ DeviceAuthDialog f193b;

            public final void m192a(GraphResponse graphResponse) {
                if (!this.f193b.ao.get()) {
                    if (graphResponse.a() != null) {
                        DeviceAuthDialog.m196a(this.f193b, graphResponse.a().e());
                        return;
                    }
                    try {
                        JSONObject b = graphResponse.b();
                        String string = b.getString("id");
                        PermissionsPair a = Utility.a(b);
                        this.f193b.an.m214a(str, FacebookSdk.i(), string, a.a(), a.b(), AccessTokenSource.DEVICE_AUTH, null, null);
                        this.f193b.as.dismiss();
                    } catch (Throwable e) {
                        DeviceAuthDialog.m196a(this.f193b, new FacebookException(e));
                    }
                }
            }
        }).g();
    }

    public static void m196a(DeviceAuthDialog deviceAuthDialog, FacebookException facebookException) {
        if (deviceAuthDialog.ao.compareAndSet(false, true)) {
            LoginMethodHandler loginMethodHandler = deviceAuthDialog.an;
            loginMethodHandler.f199b.m249a(Result.m235a(loginMethodHandler.f199b.f225g, null, facebookException.getMessage()));
            deviceAuthDialog.as.dismiss();
        }
    }

    public static void aq(DeviceAuthDialog deviceAuthDialog) {
        if (deviceAuthDialog.ao.compareAndSet(false, true)) {
            if (deviceAuthDialog.an != null) {
                LoginMethodHandler loginMethodHandler = deviceAuthDialog.an;
                loginMethodHandler.f199b.m249a(Result.m234a(loginMethodHandler.f199b.f225g, "User canceled log in."));
            }
            deviceAuthDialog.as.dismiss();
        }
    }
}
