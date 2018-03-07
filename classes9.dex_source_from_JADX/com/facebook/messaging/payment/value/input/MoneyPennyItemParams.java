package com.facebook.messaging.payment.value.input;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.StringUtil;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: events_common_part */
public class MoneyPennyItemParams implements Parcelable {
    public static final Creator<MoneyPennyItemParams> CREATOR = new C18071();
    public final long f15477a;
    @Nullable
    public final String f15478b;
    public final String f15479c;
    public final String f15480d;
    public final String f15481e;
    public final String f15482f;
    public final String f15483g;

    /* compiled from: events_common_part */
    final class C18071 implements Creator<MoneyPennyItemParams> {
        C18071() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MoneyPennyItemParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new MoneyPennyItemParams[i];
        }
    }

    public MoneyPennyItemParams(MoneyPennyItemParamsBuilder moneyPennyItemParamsBuilder) {
        this.f15477a = moneyPennyItemParamsBuilder.f15484a;
        this.f15478b = moneyPennyItemParamsBuilder.f15485b;
        this.f15479c = moneyPennyItemParamsBuilder.f15486c;
        this.f15480d = moneyPennyItemParamsBuilder.f15487d;
        this.f15481e = moneyPennyItemParamsBuilder.f15488e;
        this.f15482f = moneyPennyItemParamsBuilder.f15489f;
        this.f15483g = moneyPennyItemParamsBuilder.f15490g;
    }

    public MoneyPennyItemParams(Parcel parcel) {
        this.f15477a = parcel.readLong();
        this.f15478b = parcel.readString();
        this.f15479c = parcel.readString();
        this.f15480d = parcel.readString();
        this.f15481e = parcel.readString();
        this.f15482f = parcel.readString();
        this.f15483g = parcel.readString();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("itemId", this.f15477a).add("imageUri", this.f15478b).add("itemTitle", this.f15479c).add("itemDescription", this.f15480d).add("itemSellerInfo", this.f15481e).add("itemAmount", this.f15482f).add("currency", this.f15483g).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f15477a);
        parcel.writeString(this.f15478b);
        parcel.writeString(this.f15479c);
        parcel.writeString(this.f15480d);
        parcel.writeString(this.f15481e);
        parcel.writeString(this.f15482f);
        parcel.writeString(this.f15483g);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MoneyPennyItemParams moneyPennyItemParams = (MoneyPennyItemParams) obj;
        if (this.f15477a != moneyPennyItemParams.f15477a) {
            return false;
        }
        boolean equals = this.f15478b != null ? this.f15478b.equals(moneyPennyItemParams.f15478b) : moneyPennyItemParams.f15478b == null;
        if (!equals) {
            return false;
        }
        if (!this.f15479c.equals(moneyPennyItemParams.f15479c)) {
            return false;
        }
        if (!this.f15480d.equals(moneyPennyItemParams.f15480d)) {
            return false;
        }
        if (!this.f15481e.equals(moneyPennyItemParams.f15481e)) {
            return false;
        }
        if (!this.f15482f.equals(moneyPennyItemParams.f15482f)) {
            return false;
        }
        if (StringUtil.a(this.f15483g, moneyPennyItemParams.f15483g)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Long.valueOf(this.f15477a), this.f15478b, this.f15479c, this.f15480d, this.f15481e, this.f15482f, this.f15483g});
    }

    public static MoneyPennyItemParamsBuilder newBuilder() {
        return new MoneyPennyItemParamsBuilder();
    }
}
