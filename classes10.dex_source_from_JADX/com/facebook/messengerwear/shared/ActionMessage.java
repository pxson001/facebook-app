package com.facebook.messengerwear.shared;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: photo_width */
public class ActionMessage implements Parcelable {
    public static final Creator<ActionMessage> CREATOR = new C06781();
    public final String f4941a;
    public final String f4942b;
    public final Type f4943c;

    /* compiled from: photo_width */
    final class C06781 implements Creator<ActionMessage> {
        C06781() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ActionMessage(parcel);
        }

        public final Object[] newArray(int i) {
            return new ActionMessage[i];
        }
    }

    /* compiled from: photo_width */
    public enum Type {
        REPLY_TEXT("text"),
        REPLY_STICKER("sticker"),
        REPLY_LIKE("like"),
        MUTE("mute"),
        OPEN_ON_PHONE("open");
        
        private final String name;

        private Type(String str) {
            this.name = str;
        }

        public final String toString() {
            return this.name;
        }
    }

    public ActionMessage(Parcel parcel) {
        this.f4941a = parcel.readString();
        this.f4942b = parcel.readString();
        this.f4943c = Type.values()[parcel.readInt()];
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4941a);
        parcel.writeString(this.f4942b);
        parcel.writeInt(this.f4943c.ordinal());
    }
}
