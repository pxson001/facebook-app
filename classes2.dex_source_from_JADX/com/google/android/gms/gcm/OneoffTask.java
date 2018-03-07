package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class OneoffTask extends Task {
    public static final Creator<OneoffTask> CREATOR = new C02131();
    public final long f3664a;
    public final long f3665b;

    public class Builder extends com.google.android.gms.gcm.Task.Builder {
        public long f3638i;
        public long f3639j;

        public Builder() {
            this.f3638i = -1;
            this.f3639j = -1;
            this.e = false;
        }

        public final Builder m5901a(int i) {
            this.f3640a = i;
            return this;
        }

        public final Builder m5902a(long j, long j2) {
            this.f3638i = j;
            this.f3639j = j2;
            return this;
        }

        public final Builder m5903a(Class<? extends GcmTaskService> cls) {
            this.b = cls.getName();
            return this;
        }

        public final Builder m5904a(String str) {
            this.f3642c = str;
            return this;
        }

        public final Builder m5905a(boolean z) {
            this.f3645f = z;
            return this;
        }

        public final com.google.android.gms.gcm.Task.Builder mo770a(Bundle bundle) {
            this.h = bundle;
            return this;
        }

        protected final void mo771a() {
            super.mo771a();
            if (this.f3638i == -1 || this.f3639j == -1) {
                throw new IllegalArgumentException("Must specify an execution window using setExecutionWindow.");
            } else if (this.f3638i >= this.f3639j) {
                throw new IllegalArgumentException("Window start must be shorter than window end.");
            }
        }

        public final Builder m5908b(boolean z) {
            this.f3644e = z;
            return this;
        }

        public final OneoffTask m5909b() {
            mo771a();
            return new OneoffTask(this);
        }

        public final /* synthetic */ com.google.android.gms.gcm.Task.Builder mo772b(int i) {
            this.f3640a = i;
            return this;
        }

        public final /* synthetic */ com.google.android.gms.gcm.Task.Builder mo773b(Class cls) {
            return m5903a(cls);
        }

        public final /* synthetic */ com.google.android.gms.gcm.Task.Builder mo774b(String str) {
            this.f3642c = str;
            return this;
        }

        public final Builder m5913c(boolean z) {
            this.f3643d = z;
            return this;
        }

        public final /* synthetic */ Task mo775c() {
            return m5909b();
        }

        public final /* synthetic */ com.google.android.gms.gcm.Task.Builder mo776d(boolean z) {
            this.f3643d = z;
            return this;
        }

        public final /* synthetic */ com.google.android.gms.gcm.Task.Builder mo777e(boolean z) {
            this.f3645f = z;
            return this;
        }
    }

    final class C02131 implements Creator<OneoffTask> {
        C02131() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new OneoffTask(parcel);
        }

        public final Object[] newArray(int i) {
            return new OneoffTask[i];
        }
    }

    @Deprecated
    public OneoffTask(Parcel parcel) {
        super(parcel);
        this.f3664a = parcel.readLong();
        this.f3665b = parcel.readLong();
    }

    public OneoffTask(Builder builder) {
        super((com.google.android.gms.gcm.Task.Builder) builder);
        this.f3664a = builder.f3638i;
        this.f3665b = builder.f3639j;
    }

    public final void mo778a(Bundle bundle) {
        super.mo778a(bundle);
        bundle.putLong("window_start", this.f3664a);
        bundle.putLong("window_end", this.f3665b);
    }

    public String toString() {
        return super.toString() + " windowStart=" + this.f3664a + " windowEnd=" + this.f3665b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.f3664a);
        parcel.writeLong(this.f3665b);
    }
}
