package com.facebook.intent.thirdparty;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.debug.log.BLog;
import com.google.common.collect.Maps;
import java.util.Map;

/* compiled from: mCommunicationRank */
public class NativeThirdPartyUriHelper$LoggingParams implements Parcelable {
    public static final Creator<NativeThirdPartyUriHelper$LoggingParams> CREATOR = new C06981();
    private boolean f11223a;
    private Bundle f11224b;
    private Bundle f11225c;

    /* compiled from: mCommunicationRank */
    final class C06981 implements Creator<NativeThirdPartyUriHelper$LoggingParams> {
        C06981() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NativeThirdPartyUriHelper$LoggingParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new NativeThirdPartyUriHelper$LoggingParams[i];
        }
    }

    public NativeThirdPartyUriHelper$LoggingParams(boolean z, Bundle bundle, Bundle bundle2) {
        this.f11223a = z;
        this.f11224b = bundle;
        this.f11225c = bundle2;
    }

    public NativeThirdPartyUriHelper$LoggingParams(Parcel parcel) {
        this.f11223a = parcel.readInt() != 0;
        this.f11224b = parcel.readBundle();
        this.f11225c = parcel.readBundle();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f11223a ? 1 : 0);
        parcel.writeBundle(this.f11224b);
        parcel.writeBundle(this.f11225c);
    }

    public final Map<String, Object> m18112a() {
        Map<String, Object> c = Maps.c();
        if (this.f11223a) {
            c.put("sponsored", Boolean.TRUE);
        }
        if (!(this.f11224b == null || this.f11224b.isEmpty())) {
            for (String str : this.f11224b.keySet()) {
                try {
                    c.put(str, FbObjectMapper.i().a(this.f11224b.getString(str)));
                } catch (Throwable e) {
                    BLog.b(NativeThirdPartyUriHelper.a, "Error parsing extra logging parameters", e);
                }
            }
        }
        if (!(this.f11225c == null || this.f11225c.isEmpty())) {
            for (String str2 : this.f11225c.keySet()) {
                c.put(str2, this.f11225c.getString(str2));
            }
        }
        return c;
    }
}
