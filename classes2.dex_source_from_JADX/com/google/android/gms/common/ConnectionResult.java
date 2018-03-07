package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;

public final class ConnectionResult implements SafeParcelable {
    public static final Creator<ConnectionResult> CREATOR = new zzb();
    public static final ConnectionResult f23271a = new ConnectionResult(0);
    public final int f23272b;
    public final int f23273c;
    public final PendingIntent f23274d;
    public final String f23275e;

    private ConnectionResult(int i) {
        this(i, null, null);
    }

    ConnectionResult(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f23272b = i;
        this.f23273c = i2;
        this.f23274d = pendingIntent;
        this.f23275e = str;
    }

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    private ConnectionResult(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }

    public static String m31392a(int i) {
        switch (i) {
            case 0:
                return "SUCCESS";
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return "SERVICE_MISSING";
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            case 13:
                return "CANCELED";
            case 14:
                return "TIMEOUT";
            case 15:
                return "INTERRUPTED";
            case HTTPTransportCallback.HEADER_BYTES_GENERATED /*16*/:
                return "API_UNAVAILABLE";
            case 17:
                return "SIGN_IN_FAILED";
            case 18:
                return "SERVICE_UPDATING";
            case 19:
                return "SERVICE_MISSING_PERMISSION";
            default:
                return "UNKNOWN_ERROR_CODE(" + i + ")";
        }
    }

    public final void m31393a(Activity activity, int i) {
        if (m31394a()) {
            activity.startIntentSenderForResult(this.f23274d.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    public final boolean m31394a() {
        return (this.f23273c == 0 || this.f23274d == null) ? false : true;
    }

    public final boolean m31395b() {
        return this.f23273c == 0;
    }

    public final int m31396c() {
        return this.f23273c;
    }

    public final int describeContents() {
        return 0;
    }

    public final String m31397e() {
        return this.f23275e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f23273c == connectionResult.f23273c && zzw.m26867a(this.f23274d, connectionResult.f23274d) && zzw.m26867a(this.f23275e, connectionResult.f23275e);
    }

    public final int hashCode() {
        return zzw.m26865a(Integer.valueOf(this.f23273c), this.f23274d, this.f23275e);
    }

    public final String toString() {
        return zzw.m26866a((Object) this).a("statusCode", m31392a(this.f23273c)).a("resolution", this.f23274d).a("message", this.f23275e).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f23272b);
        zzb.a(parcel, 2, this.f23273c);
        zzb.a(parcel, 3, this.f23274d, i, false);
        zzb.a(parcel, 4, this.f23275e, false);
        zzb.c(parcel, a);
    }
}
