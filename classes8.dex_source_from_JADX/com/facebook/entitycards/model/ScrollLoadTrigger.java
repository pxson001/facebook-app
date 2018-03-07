package com.facebook.entitycards.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;

/* compiled from: horizontal */
public class ScrollLoadTrigger implements Parcelable {
    public static final Creator<ScrollLoadTrigger> CREATOR = new C11981();
    private final EntityCardsScrollDirection f11079a;

    /* compiled from: horizontal */
    final class C11981 implements Creator<ScrollLoadTrigger> {
        C11981() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ScrollLoadTrigger(parcel);
        }

        public final Object[] newArray(int i) {
            return new ScrollLoadTrigger[i];
        }
    }

    public ScrollLoadTrigger(EntityCardsScrollDirection entityCardsScrollDirection) {
        this.f11079a = entityCardsScrollDirection;
    }

    public ScrollLoadTrigger(Parcel parcel) {
        this.f11079a = (EntityCardsScrollDirection) parcel.readSerializable();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f11079a);
    }

    public String toString() {
        return Objects.toStringHelper(ScrollLoadTrigger.class).add("direction", this.f11079a).toString();
    }
}
