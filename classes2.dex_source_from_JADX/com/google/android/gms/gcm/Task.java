package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;

public abstract class Task implements Parcelable {
    public final String f3656a;
    public final String f3657b;
    private final boolean f3658c;
    private final boolean f3659d;
    private final int f3660e;
    private final boolean f3661f;
    private final zzd f3662g;
    private final Bundle f3663h;

    public abstract class Builder {
        public int f3640a;
        protected String f3641b;
        public String f3642c;
        public boolean f3643d;
        public boolean f3644e;
        public boolean f3645f;
        protected zzd f3646g = zzd.f3648a;
        protected Bundle f3647h;

        public abstract Builder mo770a(Bundle bundle);

        protected void mo771a() {
            zzx.m113b(this.f3641b != null, "Must provide an endpoint for this task by calling setService(ComponentName).");
            GcmNetworkManager.m5927a(this.f3642c);
            Task.m5932a(this.f3646g);
            if (this.f3644e) {
                Task.m5933b(this.f3647h);
            }
        }

        public abstract Builder mo772b(int i);

        public abstract Builder mo773b(Class<? extends GcmTaskService> cls);

        public abstract Builder mo774b(String str);

        public abstract Task mo775c();

        public abstract Builder mo776d(boolean z);

        public abstract Builder mo777e(boolean z);
    }

    @Deprecated
    Task(Parcel parcel) {
        boolean z = true;
        Log.e("Task", "Constructing a Task object using a parcel.");
        this.f3656a = parcel.readString();
        this.f3657b = parcel.readString();
        this.f3658c = parcel.readInt() == 1;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.f3659d = z;
        this.f3660e = 2;
        this.f3661f = false;
        this.f3662g = zzd.f3648a;
        this.f3663h = null;
    }

    Task(Builder builder) {
        this.f3656a = builder.f3641b;
        this.f3657b = builder.f3642c;
        this.f3658c = builder.f3643d;
        this.f3659d = builder.f3644e;
        this.f3660e = builder.f3640a;
        this.f3661f = builder.f3645f;
        this.f3662g = builder.f3646g;
        this.f3663h = builder.f3647h;
    }

    public static void m5932a(zzd com_google_android_gms_gcm_zzd) {
        if (com_google_android_gms_gcm_zzd != null) {
            int i = com_google_android_gms_gcm_zzd.f3650c;
            if (i == 1 || i == 0) {
                int i2 = com_google_android_gms_gcm_zzd.f3651d;
                int i3 = com_google_android_gms_gcm_zzd.f3652e;
                if (i == 0 && i2 < 0) {
                    throw new IllegalArgumentException("InitialBackoffSeconds can't be negative: " + i2);
                } else if (i == 1 && i2 < 10) {
                    throw new IllegalArgumentException("RETRY_POLICY_LINEAR must have an initial backoff at least 10 seconds.");
                } else if (i3 < i2) {
                    throw new IllegalArgumentException("MaximumBackoffSeconds must be greater than InitialBackoffSeconds: " + com_google_android_gms_gcm_zzd.f3652e);
                } else {
                    return;
                }
            }
            throw new IllegalArgumentException("Must provide a valid RetryPolicy: " + i);
        }
    }

    public static void m5933b(Bundle bundle) {
        if (bundle != null) {
            Parcel obtain = Parcel.obtain();
            bundle.writeToParcel(obtain, 0);
            int dataSize = obtain.dataSize();
            if (dataSize > 10240) {
                obtain.recycle();
                throw new IllegalArgumentException("Extras exceeding maximum size(10240 bytes): " + dataSize);
            }
            obtain.recycle();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                Object obj2 = ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof String) || (obj instanceof Boolean)) ? 1 : null;
                if (obj2 == null) {
                    throw new IllegalArgumentException("Only the following extra parameter types are supported: Integer, Long, Double, String, and Boolean. ");
                }
            }
        }
    }

    public final String m5934a() {
        return this.f3656a;
    }

    public void mo778a(Bundle bundle) {
        bundle.putString("tag", this.f3657b);
        bundle.putBoolean("update_current", this.f3658c);
        bundle.putBoolean("persisted", this.f3659d);
        bundle.putString("service", this.f3656a);
        bundle.putInt("requiredNetwork", this.f3660e);
        bundle.putBoolean("requiresCharging", this.f3661f);
        zzd com_google_android_gms_gcm_zzd = this.f3662g;
        Bundle bundle2 = new Bundle();
        bundle2.putInt("retry_policy", com_google_android_gms_gcm_zzd.f3650c);
        bundle2.putInt("initial_backoff_seconds", com_google_android_gms_gcm_zzd.f3651d);
        bundle2.putInt("maximum_backoff_seconds", com_google_android_gms_gcm_zzd.f3652e);
        bundle.putBundle("retryStrategy", bundle2);
        bundle.putBundle("extras", this.f3663h);
    }

    public final String m5936b() {
        return this.f3657b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.f3656a);
        parcel.writeString(this.f3657b);
        parcel.writeInt(this.f3658c ? 1 : 0);
        if (!this.f3659d) {
            i2 = 0;
        }
        parcel.writeInt(i2);
    }
}
