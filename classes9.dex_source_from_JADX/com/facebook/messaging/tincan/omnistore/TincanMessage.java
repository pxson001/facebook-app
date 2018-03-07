package com.facebook.messaging.tincan.omnistore;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.nio.ByteBuffer;

/* compiled from: click_request_code_button */
public class TincanMessage implements Parcelable {
    public static final Creator<TincanMessage> CREATOR = new C21131();
    public final String f18074a;
    public final ByteBuffer f18075b;

    /* compiled from: click_request_code_button */
    final class C21131 implements Creator<TincanMessage> {
        C21131() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new TincanMessage(parcel);
        }

        public final Object[] newArray(int i) {
            return new TincanMessage[i];
        }
    }

    public TincanMessage(String str, ByteBuffer byteBuffer) {
        this.f18074a = str;
        this.f18075b = byteBuffer;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18074a);
        parcel.writeByteArray(this.f18075b.array());
    }

    public TincanMessage(Parcel parcel) {
        this.f18074a = parcel.readString();
        this.f18075b = ByteBuffer.wrap(parcel.createByteArray());
    }
}
