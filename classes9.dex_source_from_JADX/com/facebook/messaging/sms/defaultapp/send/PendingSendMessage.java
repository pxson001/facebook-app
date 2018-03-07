package com.facebook.messaging.sms.defaultapp.send;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import javax.annotation.Nullable;

/* compiled from: com.facebook.orca.extra.IS_COMPOSE */
public class PendingSendMessage implements Parcelable {
    public static final Creator<PendingSendMessage> CREATOR = new C20901();
    public String f17703a;
    public long f17704b;
    public long f17705c;
    public int f17706d;
    private boolean f17707e;

    /* compiled from: com.facebook.orca.extra.IS_COMPOSE */
    final class C20901 implements Creator<PendingSendMessage> {
        C20901() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PendingSendMessage(parcel);
        }

        public final Object[] newArray(int i) {
            return new PendingSendMessage[i];
        }
    }

    public PendingSendMessage(String str, long j, long j2, int i) {
        this.f17703a = str;
        this.f17704b = j;
        this.f17705c = j2;
        this.f17706d = i;
    }

    public final String m17663a() {
        return this.f17703a;
    }

    public final long m17664b() {
        return this.f17704b;
    }

    public final long m17665c() {
        return this.f17705c;
    }

    public final boolean m17666e() {
        return this.f17707e;
    }

    public final void m17667f() {
        this.f17707e = true;
    }

    public final void m17668g() {
        this.f17706d++;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f17703a);
        parcel.writeLong(this.f17704b);
        parcel.writeLong(this.f17705c);
        parcel.writeInt(this.f17706d);
        ParcelUtil.a(parcel, this.f17707e);
    }

    public PendingSendMessage(Parcel parcel) {
        this.f17703a = parcel.readString();
        this.f17704b = parcel.readLong();
        this.f17705c = parcel.readLong();
        this.f17706d = parcel.readInt();
        this.f17707e = ParcelUtil.a(parcel);
    }

    public String toString() {
        return "PendingSendMessage{mMessageId='" + this.f17703a + '\'' + ", mThreadId=" + this.f17704b + ", mTimestampMs=" + this.f17705c + ", mRetryCount=" + this.f17706d + ", mIsExpired=" + this.f17707e + '}';
    }

    public static void m17662a(Intent intent, PendingSendMessage pendingSendMessage) {
        Bundle bundleExtra = intent.getBundleExtra("mmssms_custom_bundle");
        if (bundleExtra == null) {
            bundleExtra = new Bundle();
            intent.putExtra("mmssms_custom_bundle", bundleExtra);
        }
        bundleExtra.putParcelable("pending_send_message", pendingSendMessage);
    }

    @Nullable
    public static PendingSendMessage m17661a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("mmssms_custom_bundle");
        if (bundle2 != null) {
            return (PendingSendMessage) bundle2.getParcelable("pending_send_message");
        }
        return null;
    }
}
