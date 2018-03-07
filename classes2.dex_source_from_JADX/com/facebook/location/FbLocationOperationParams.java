package com.facebook.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.location.FbLocationManagerParams.Priority;
import com.google.common.base.Absent;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: locations */
public class FbLocationOperationParams implements Parcelable {
    public static final Creator<FbLocationOperationParams> CREATOR = new C07061();
    public final Priority f16481a;
    public final long f16482b;
    public final float f16483c;
    public final long f16484d;
    public final Optional<Long> f16485e;
    public final Optional<Float> f16486f;
    public final long f16487g;
    public final long f16488h;
    public final float f16489i;

    /* compiled from: locations */
    final class C07061 implements Creator<FbLocationOperationParams> {
        C07061() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FbLocationOperationParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FbLocationOperationParams[i];
        }
    }

    /* compiled from: locations */
    public class Builder {
        public final Priority f16490a;
        public long f16491b = 120000;
        public float f16492c = 100.0f;
        public long f16493d = 5000;
        public Optional<Long> f16494e = Absent.INSTANCE;
        public Optional<Float> f16495f = Absent.INSTANCE;
        public long f16496g = 500;
        public long f16497h = 120000;
        public float f16498i = 0.6666667f;

        public Builder(Priority priority) {
            this.f16490a = priority;
        }

        public final Builder m23334c(long j) {
            this.f16494e = Optional.of(Long.valueOf(j));
            return this;
        }

        public final FbLocationOperationParams m23333a() {
            return new FbLocationOperationParams(this);
        }
    }

    public static Builder m23332a(Priority priority) {
        return new Builder(priority);
    }

    public FbLocationOperationParams(Builder builder) {
        this.f16481a = builder.f16490a;
        this.f16482b = builder.f16491b;
        this.f16483c = builder.f16492c;
        this.f16484d = builder.f16493d;
        this.f16485e = builder.f16494e;
        this.f16486f = builder.f16495f;
        this.f16487g = builder.f16496g;
        this.f16488h = builder.f16497h;
        this.f16489i = builder.f16498i;
    }

    public String toString() {
        return Objects.toStringHelper((Object) this).add("priority", this.f16481a).add("desired_age_ms", this.f16482b).add("desired_accuracy_meters", this.f16483c).add("timeout_ms", this.f16484d).add("age_limit_ms", this.f16485e).add("accuracy_limit_meters", this.f16486f).add("time_between_updates_ms", this.f16487g).add("significant_time_improvement_ms", this.f16488h).add("significant_accuracy_improvement_ratio", this.f16489i).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.f16481a.name());
        parcel.writeLong(this.f16482b);
        parcel.writeFloat(this.f16483c);
        parcel.writeLong(this.f16484d);
        parcel.writeInt(this.f16485e.isPresent() ? 1 : 0);
        if (this.f16485e.isPresent()) {
            parcel.writeLong(((Long) this.f16485e.get()).longValue());
        }
        if (!this.f16486f.isPresent()) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f16486f.isPresent()) {
            parcel.writeFloat(((Float) this.f16486f.get()).floatValue());
        }
        parcel.writeLong(this.f16487g);
        parcel.writeLong(this.f16488h);
        parcel.writeFloat(this.f16489i);
    }

    public FbLocationOperationParams(Parcel parcel) {
        this.f16481a = Priority.valueOf(parcel.readString());
        this.f16482b = parcel.readLong();
        this.f16483c = parcel.readFloat();
        this.f16484d = parcel.readLong();
        if (parcel.readInt() == 0) {
            this.f16485e = Absent.INSTANCE;
        } else {
            this.f16485e = Optional.of(Long.valueOf(parcel.readLong()));
        }
        if (parcel.readInt() == 0) {
            this.f16486f = Absent.INSTANCE;
        } else {
            this.f16486f = Optional.of(Float.valueOf(parcel.readFloat()));
        }
        this.f16487g = parcel.readLong();
        this.f16488h = parcel.readLong();
        this.f16489i = parcel.readFloat();
    }
}
