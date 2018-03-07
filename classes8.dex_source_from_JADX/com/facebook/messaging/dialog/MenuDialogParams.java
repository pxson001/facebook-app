package com.facebook.messaging.dialog;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: totalCount */
public class MenuDialogParams implements Parcelable {
    public static final Creator<MenuDialogParams> CREATOR = new C01611();
    public final int f1520a;
    public final String f1521b;
    public final ImmutableList<MenuDialogItem> f1522c;
    public final Object f1523d;

    /* compiled from: totalCount */
    final class C01611 implements Creator<MenuDialogParams> {
        C01611() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MenuDialogParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new MenuDialogParams[i];
        }
    }

    public MenuDialogParams(MenuDialogParamsBuilder menuDialogParamsBuilder) {
        int i;
        boolean z = true;
        this.f1520a = menuDialogParamsBuilder.f1524a;
        this.f1521b = menuDialogParamsBuilder.f1525b;
        this.f1522c = ImmutableList.copyOf(menuDialogParamsBuilder.f1526c);
        this.f1523d = menuDialogParamsBuilder.f1527d;
        if (this.f1520a == 0) {
            i = 1;
        } else {
            i = 0;
        }
        Preconditions.checkArgument(i ^ (this.f1521b == null ? 1 : 0));
        if (this.f1522c.isEmpty()) {
            z = false;
        }
        Preconditions.checkArgument(z);
    }

    public MenuDialogParams(Parcel parcel) {
        this.f1520a = parcel.readInt();
        this.f1521b = parcel.readString();
        ClassLoader classLoader = MenuDialogItem.class.getClassLoader();
        this.f1522c = ImmutableList.copyOf(parcel.readArrayList(classLoader));
        this.f1523d = FlatBufferModelHelper.a(parcel.readBundle(classLoader), "extra_data");
        if (this.f1523d instanceof Bundle) {
            ((Bundle) this.f1523d).setClassLoader(classLoader);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1520a);
        parcel.writeString(this.f1521b);
        parcel.writeList(this.f1522c);
        Bundle bundle = new Bundle();
        FlatBufferModelHelper.a(bundle, "extra_data", this.f1523d);
        parcel.writeBundle(bundle);
    }
}
