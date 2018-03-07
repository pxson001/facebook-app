package com.facebook.adinterfaces.ui.selector;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.adinterfaces.ui.selector.TargetingSelectorFragmentFactory.SelectorType;

/* compiled from: Unknown field id  */
public class TargetingSelectorArgument implements Parcelable {
    public static final Creator<TargetingSelectorArgument> CREATOR = new C27491();
    public final SelectorType f23235a;
    public final int f23236b;

    /* compiled from: Unknown field id  */
    final class C27491 implements Creator<TargetingSelectorArgument> {
        C27491() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new TargetingSelectorArgument(parcel);
        }

        public final Object[] newArray(int i) {
            return new TargetingSelectorArgument[i];
        }
    }

    public TargetingSelectorArgument(SelectorType selectorType, int i) {
        this.f23235a = selectorType;
        this.f23236b = i;
    }

    public TargetingSelectorArgument(Parcel parcel) {
        this((SelectorType) parcel.readSerializable(), parcel.readInt());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f23235a);
        parcel.writeInt(this.f23236b);
    }
}
