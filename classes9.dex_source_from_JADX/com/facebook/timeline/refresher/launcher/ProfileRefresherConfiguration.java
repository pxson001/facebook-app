package com.facebook.timeline.refresher.launcher;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeInterfaces.ComposerTargetDataPrivacyScopeFields;
import javax.annotation.Nullable;

/* compiled from: unprotected_thread_profiles */
public class ProfileRefresherConfiguration implements Parcelable {
    public static final Creator<ProfileRefresherConfiguration> CREATOR = new C01081();
    public final String f1066a;
    public final String f1067b;
    public final String f1068c;
    public final String f1069d;
    public final boolean f1070e;
    @Nullable
    public final ComposerTargetDataPrivacyScopeFields f1071f;

    /* compiled from: unprotected_thread_profiles */
    final class C01081 implements Creator<ProfileRefresherConfiguration> {
        C01081() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ProfileRefresherConfiguration(parcel);
        }

        public final Object[] newArray(int i) {
            return new ProfileRefresherConfiguration[i];
        }
    }

    /* compiled from: unprotected_thread_profiles */
    public class Builder {
        public String f1060a;
        public String f1061b;
        public String f1062c;
        public String f1063d;
        public boolean f1064e;
        @Nullable
        public ComposerTargetDataPrivacyScopeFields f1065f = null;

        public final ProfileRefresherConfiguration m1062a() {
            return new ProfileRefresherConfiguration(this.f1060a, this.f1061b, this.f1062c, this.f1063d, this.f1064e, this.f1065f);
        }
    }

    ProfileRefresherConfiguration(String str, String str2, String str3, String str4, boolean z, ComposerTargetDataPrivacyScopeFields composerTargetDataPrivacyScopeFields) {
        this.f1066a = str;
        this.f1067b = str2;
        this.f1068c = str3;
        this.f1069d = str4;
        this.f1070e = z;
        this.f1071f = composerTargetDataPrivacyScopeFields;
    }

    public ProfileRefresherConfiguration(Parcel parcel) {
        this.f1066a = parcel.readString();
        this.f1067b = parcel.readString();
        this.f1068c = parcel.readString();
        this.f1069d = parcel.readString();
        this.f1070e = ParcelUtil.a(parcel);
        this.f1071f = (ComposerTargetDataPrivacyScopeFields) FlatBufferModelHelper.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1066a);
        parcel.writeString(this.f1067b);
        parcel.writeString(this.f1068c);
        parcel.writeString(this.f1069d);
        ParcelUtil.a(parcel, this.f1070e);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f1071f);
    }
}
