package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;

/* compiled from: opened_location_setting */
public final class GameRequestContent implements ShareModel {
    public static final Creator<GameRequestContent> CREATOR = new C06191();
    private final String f4583a;
    private final List<String> f4584b;
    private final String f4585c;
    private final String f4586d;
    private final ActionType f4587e;
    private final String f4588f;
    private final Filters f4589g;
    private final List<String> f4590h;

    /* compiled from: opened_location_setting */
    final class C06191 implements Creator<GameRequestContent> {
        C06191() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GameRequestContent(parcel);
        }

        public final Object[] newArray(int i) {
            return new GameRequestContent[i];
        }
    }

    /* compiled from: opened_location_setting */
    public enum ActionType {
        SEND,
        ASKFOR,
        TURN
    }

    /* compiled from: opened_location_setting */
    public enum Filters {
        APP_USERS,
        APP_NON_USERS
    }

    GameRequestContent(Parcel parcel) {
        this.f4583a = parcel.readString();
        this.f4584b = parcel.createStringArrayList();
        this.f4585c = parcel.readString();
        this.f4586d = parcel.readString();
        this.f4587e = (ActionType) parcel.readSerializable();
        this.f4588f = parcel.readString();
        this.f4589g = (Filters) parcel.readSerializable();
        this.f4590h = parcel.createStringArrayList();
        parcel.readStringList(this.f4590h);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4583a);
        parcel.writeStringList(this.f4584b);
        parcel.writeString(this.f4585c);
        parcel.writeString(this.f4586d);
        parcel.writeSerializable(this.f4587e);
        parcel.writeString(this.f4588f);
        parcel.writeSerializable(this.f4589g);
        parcel.writeStringList(this.f4590h);
    }
}
