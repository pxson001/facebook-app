package com.facebook.rtc.fbwebrtcnew;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: application/x-x968-ca-cert */
public class FbWebrtcCallModel implements Parcelable {
    public static final Creator<FbWebrtcCallModel> CREATOR = new C23171();
    public final long f19637a;
    public final ImmutableList<String> f19638b;
    public final ImmutableMap<String, FbWebrtcConferenceUserState> f19639c;
    public final CallType f19640d;
    public final CallDirection f19641e;
    public final CallProtocol f19642f;
    public final String f19643g;
    public final String f19644h;
    public final String f19645i;
    public final boolean f19646j;
    public final boolean f19647k;
    public final boolean f19648l;
    public final boolean f19649m;
    public final boolean f19650n;
    public final boolean f19651o;
    public final long f19652p;
    public final long f19653q;
    public final FbWebrtcCallState f19654r;

    /* compiled from: application/x-x968-ca-cert */
    final class C23171 implements Creator<FbWebrtcCallModel> {
        C23171() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FbWebrtcCallModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new FbWebrtcCallModel[i];
        }
    }

    @Immutable
    /* compiled from: application/x-x968-ca-cert */
    public enum CallDirection {
        INBOUND,
        OUTBOUND
    }

    @Immutable
    /* compiled from: application/x-x968-ca-cert */
    public enum CallProtocol {
        P2P,
        MULTIWAY
    }

    @Immutable
    /* compiled from: application/x-x968-ca-cert */
    public enum CallType {
        VOICE,
        DIRECT_VIDEO,
        INSTANT_VIDEO,
        CONFERENCE_VOICE,
        CONFERENCE_VIDEO;

        public static boolean isConferenceCall(CallType callType) {
            return callType == CONFERENCE_VIDEO || callType == CONFERENCE_VOICE;
        }

        public static boolean isNonInstantVideoCall(CallType callType) {
            return callType == CONFERENCE_VIDEO || callType == DIRECT_VIDEO;
        }
    }

    public FbWebrtcCallModel(FbWebrtcCallProperties fbWebrtcCallProperties) {
        this.f19637a = fbWebrtcCallProperties.f19655a;
        this.f19638b = fbWebrtcCallProperties.f19656b;
        this.f19639c = fbWebrtcCallProperties.f19657c;
        this.f19640d = fbWebrtcCallProperties.f19658d;
        this.f19641e = fbWebrtcCallProperties.f19659e;
        this.f19642f = fbWebrtcCallProperties.f19660f;
        this.f19643g = fbWebrtcCallProperties.f19661g;
        this.f19644h = fbWebrtcCallProperties.f19662h;
        this.f19645i = fbWebrtcCallProperties.f19663i;
        this.f19646j = fbWebrtcCallProperties.f19664j;
        this.f19647k = fbWebrtcCallProperties.f19665k;
        this.f19648l = fbWebrtcCallProperties.f19666l;
        this.f19649m = fbWebrtcCallProperties.f19667m;
        this.f19650n = fbWebrtcCallProperties.f19668n;
        this.f19651o = fbWebrtcCallProperties.f19669o;
        this.f19652p = fbWebrtcCallProperties.f19670p;
        this.f19653q = fbWebrtcCallProperties.f19671q;
        this.f19654r = fbWebrtcCallProperties.f19672r;
    }

    public FbWebrtcCallModel(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f19637a = parcel.readLong();
        this.f19638b = (ImmutableList) parcel.readSerializable();
        this.f19639c = (ImmutableMap) parcel.readSerializable();
        this.f19640d = (CallType) parcel.readSerializable();
        this.f19641e = (CallDirection) parcel.readSerializable();
        this.f19642f = (CallProtocol) parcel.readSerializable();
        this.f19643g = parcel.readString();
        this.f19644h = parcel.readString();
        this.f19645i = parcel.readString();
        this.f19646j = parcel.readInt() > 0;
        if (parcel.readInt() > 0) {
            z = true;
        } else {
            z = false;
        }
        this.f19647k = z;
        if (parcel.readInt() > 0) {
            z = true;
        } else {
            z = false;
        }
        this.f19648l = z;
        if (parcel.readInt() > 0) {
            z = true;
        } else {
            z = false;
        }
        this.f19649m = z;
        if (parcel.readInt() > 0) {
            z = true;
        } else {
            z = false;
        }
        this.f19650n = z;
        if (parcel.readInt() <= 0) {
            z2 = false;
        }
        this.f19651o = z2;
        this.f19652p = parcel.readLong();
        this.f19653q = parcel.readLong();
        this.f19654r = (FbWebrtcCallState) parcel.readSerializable();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeLong(this.f19637a);
        parcel.writeSerializable(this.f19638b);
        parcel.writeSerializable(this.f19639c);
        parcel.writeSerializable(this.f19640d);
        parcel.writeSerializable(this.f19641e);
        parcel.writeSerializable(this.f19642f);
        parcel.writeString(this.f19643g);
        parcel.writeString(this.f19644h);
        parcel.writeString(this.f19645i);
        parcel.writeInt(this.f19646j ? 1 : 0);
        if (this.f19647k) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f19648l) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f19649m) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f19650n) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.f19651o) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeLong(this.f19652p);
        parcel.writeLong(this.f19653q);
        parcel.writeSerializable(this.f19654r);
    }

    public int describeContents() {
        return 0;
    }
}
