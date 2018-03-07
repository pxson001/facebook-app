package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class PeriodicTask extends Task {
    public static final Creator<PeriodicTask> CREATOR = new C07851();
    public long f6805a = -1;
    public long f6806b = -1;

    final class C07851 implements Creator<PeriodicTask> {
        C07851() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PeriodicTask(parcel);
        }

        public final Object[] newArray(int i) {
            return new PeriodicTask[i];
        }
    }

    public class Builder extends com.google.android.gms.gcm.Task.Builder {
        public long f6803i;
        public long f6804j;

        public Builder() {
            this.f6803i = -1;
            this.f6804j = -1;
            this.e = true;
        }

        public final com.google.android.gms.gcm.Task.Builder m12701a(Bundle bundle) {
            this.h = bundle;
            return this;
        }

        protected final void m12702a() {
            super.a();
            if (this.f6803i == -1) {
                throw new IllegalArgumentException("Must call setPeriod(long) to establish an execution interval for this periodic task.");
            } else if (this.f6803i <= 0) {
                throw new IllegalArgumentException("Period set cannot be less or equal to 0: " + this.f6803i);
            } else if (this.f6804j == -1) {
                this.f6804j = (long) (((float) this.f6803i) * 0.1f);
            } else if (this.f6804j > this.f6803i) {
                this.f6804j = this.f6803i;
            }
        }

        public final com.google.android.gms.gcm.Task.Builder m12703b(int i) {
            this.a = i;
            return this;
        }

        public final com.google.android.gms.gcm.Task.Builder m12704b(Class cls) {
            this.b = cls.getName();
            return this;
        }

        public final com.google.android.gms.gcm.Task.Builder m12705b(String str) {
            this.c = str;
            return this;
        }

        public final Task m12706c() {
            m12702a();
            return new PeriodicTask(this);
        }

        public final com.google.android.gms.gcm.Task.Builder m12707d(boolean z) {
            this.d = z;
            return this;
        }

        public final com.google.android.gms.gcm.Task.Builder m12708e(boolean z) {
            this.f = z;
            return this;
        }
    }

    @Deprecated
    public PeriodicTask(Parcel parcel) {
        super(parcel);
        this.f6805a = parcel.readLong();
        this.f6806b = Math.min(parcel.readLong(), this.f6805a);
    }

    public PeriodicTask(Builder builder) {
        super(builder);
        this.f6805a = builder.f6803i;
        this.f6806b = Math.min(builder.f6804j, this.f6805a);
    }

    public final void m12709a(Bundle bundle) {
        super.a(bundle);
        bundle.putLong("period", this.f6805a);
        bundle.putLong("period_flex", this.f6806b);
    }

    public String toString() {
        return super.toString() + " period=" + this.f6805a + " flex=" + this.f6806b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.f6805a);
        parcel.writeLong(this.f6806b);
    }
}
