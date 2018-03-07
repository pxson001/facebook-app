package com.facebook.messaging.dialog;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Preconditions;

/* compiled from: total_active_time */
public class MenuDialogItem implements Parcelable {
    public static final Creator<MenuDialogItem> CREATOR = new C01601();
    public final int f1510a;
    public final int f1511b;
    public final String f1512c;
    public final String f1513d;
    public final Parcelable f1514e;

    /* compiled from: total_active_time */
    final class C01601 implements Creator<MenuDialogItem> {
        C01601() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MenuDialogItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new MenuDialogItem[i];
        }
    }

    public MenuDialogItem(MenuDialogItemBuilder menuDialogItemBuilder) {
        int i;
        int i2 = 1;
        if (menuDialogItemBuilder.f1516b == 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (menuDialogItemBuilder.f1517c != null) {
            i2 = 0;
        }
        Preconditions.checkArgument(i ^ i2);
        this.f1510a = menuDialogItemBuilder.f1515a;
        this.f1511b = menuDialogItemBuilder.f1516b;
        this.f1512c = menuDialogItemBuilder.f1517c;
        this.f1513d = menuDialogItemBuilder.f1518d;
        this.f1514e = menuDialogItemBuilder.f1519e;
    }

    public MenuDialogItem(Parcel parcel) {
        this.f1510a = parcel.readInt();
        this.f1511b = parcel.readInt();
        this.f1512c = parcel.readString();
        this.f1513d = parcel.readString();
        this.f1514e = parcel.readParcelable(ClassLoader.getSystemClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1510a);
        parcel.writeInt(this.f1511b);
        parcel.writeString(this.f1512c);
        parcel.writeString(this.f1513d);
        parcel.writeParcelable(this.f1514e, 0);
    }
}
