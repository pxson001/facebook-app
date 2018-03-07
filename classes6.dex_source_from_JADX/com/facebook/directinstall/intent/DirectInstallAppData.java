package com.facebook.directinstall.intent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: old_ui */
public class DirectInstallAppData implements Parcelable {
    public static final Creator<DirectInstallAppData> CREATOR = new C05811();
    public final DownloadConnectivityPolicy f8767a;
    public final DirectInstallAppDescriptor f8768b;
    public final DirectInstallAppDetails f8769c;
    @Nullable
    private String f8770d;
    @Nullable
    private Bundle f8771e;
    @Nullable
    private String f8772f;

    /* compiled from: old_ui */
    final class C05811 implements Creator<DirectInstallAppData> {
        C05811() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DirectInstallAppData(parcel);
        }

        public final Object[] newArray(int i) {
            return new DirectInstallAppData[i];
        }
    }

    /* compiled from: old_ui */
    public class Builder {
        @Nullable
        public final DownloadConnectivityPolicy f8761a;
        @Nullable
        private final DirectInstallAppDescriptor f8762b;
        private final DirectInstallAppDetails f8763c;
        @Nullable
        public String f8764d;
        @Nullable
        public Bundle f8765e;
        @Nullable
        public String f8766f;

        public Builder(DirectInstallAppDescriptor directInstallAppDescriptor, DirectInstallAppDetails directInstallAppDetails, DownloadConnectivityPolicy downloadConnectivityPolicy) {
            this.f8762b = directInstallAppDescriptor;
            this.f8763c = directInstallAppDetails;
            if (downloadConnectivityPolicy == null) {
                downloadConnectivityPolicy = DownloadConnectivityPolicy.WifiOnly;
            }
            this.f8761a = downloadConnectivityPolicy;
        }

        public final DirectInstallAppData m12532a() {
            return new DirectInstallAppData(this.f8762b, this.f8763c, this.f8761a, this.f8764d, this.f8765e, this.f8766f);
        }
    }

    /* compiled from: old_ui */
    public enum DownloadConnectivityPolicy {
        WifiOnly(0),
        Any(1),
        WifiForce(2);
        
        private final int mValue;

        private DownloadConnectivityPolicy(int i) {
            this.mValue = i;
        }

        public final int getValue() {
            return this.mValue;
        }

        public static DownloadConnectivityPolicy fromValue(int i) {
            switch (i) {
                case 1:
                    return Any;
                case 2:
                    return WifiForce;
                default:
                    return WifiOnly;
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f8768b, 0);
        parcel.writeParcelable(this.f8769c, 0);
        parcel.writeInt(this.f8767a.getValue());
        parcel.writeString(this.f8770d);
        parcel.writeBundle(this.f8771e);
        parcel.writeString(this.f8772f);
    }

    @Nullable
    public final String m12533a() {
        return this.f8772f;
    }

    @Nullable
    public final Bundle m12534b() {
        return this.f8771e;
    }

    @Nullable
    public final String m12535c() {
        return this.f8770d;
    }

    public final DirectInstallAppDetails m12536d() {
        return this.f8769c;
    }

    public final DirectInstallAppDescriptor m12537e() {
        return this.f8768b;
    }

    public DirectInstallAppData(Parcel parcel) {
        this.f8768b = (DirectInstallAppDescriptor) parcel.readParcelable(DirectInstallAppDescriptor.class.getClassLoader());
        this.f8769c = (DirectInstallAppDetails) parcel.readParcelable(DirectInstallAppDetails.class.getClassLoader());
        this.f8767a = DownloadConnectivityPolicy.fromValue(parcel.readInt());
        this.f8770d = parcel.readString();
        this.f8771e = parcel.readBundle();
        this.f8772f = parcel.readString();
    }

    private DirectInstallAppData(@Nullable DirectInstallAppDescriptor directInstallAppDescriptor, DirectInstallAppDetails directInstallAppDetails, DownloadConnectivityPolicy downloadConnectivityPolicy, @Nullable String str, @Nullable Bundle bundle, @Nullable String str2) {
        Preconditions.checkNotNull(directInstallAppDetails);
        this.f8768b = directInstallAppDescriptor;
        this.f8769c = directInstallAppDetails;
        this.f8767a = downloadConnectivityPolicy;
        this.f8770d = str;
        this.f8771e = bundle;
        this.f8772f = str2;
    }
}
