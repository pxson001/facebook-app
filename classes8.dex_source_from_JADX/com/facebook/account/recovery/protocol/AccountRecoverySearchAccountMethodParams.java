package com.facebook.account.recovery.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.debug.log.BLog;
import com.facebook.growth.model.DeviceOwnerData;
import com.facebook.growth.model.FullName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: live_page_id */
public class AccountRecoverySearchAccountMethodParams implements Parcelable {
    public static final Creator<AccountRecoverySearchAccountMethodParams> CREATOR = new C10941();
    private static final Class<?> f10312a = AccountRecoverySearchAccountMethodParams.class;
    public final String f10313b;
    public final String f10314c;
    public final String f10315d;

    /* compiled from: live_page_id */
    final class C10941 implements Creator<AccountRecoverySearchAccountMethodParams> {
        C10941() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AccountRecoverySearchAccountMethodParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new AccountRecoverySearchAccountMethodParams[i];
        }
    }

    public AccountRecoverySearchAccountMethodParams(String str, String str2, String str3) {
        this.f10313b = str;
        this.f10314c = str2;
        this.f10315d = str3;
    }

    public AccountRecoverySearchAccountMethodParams(Parcel parcel) {
        this.f10313b = parcel.readString();
        this.f10314c = parcel.readString();
        this.f10315d = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10313b);
        parcel.writeString(this.f10314c);
        parcel.writeString(this.f10315d);
    }

    public static String m12113a(DeviceOwnerData deviceOwnerData) {
        Map hashMap = new HashMap();
        if (deviceOwnerData.m17360f()) {
            hashMap.put("email", deviceOwnerData.m17356c());
        }
        if (deviceOwnerData.m17361g()) {
            hashMap.put("phone", deviceOwnerData.m17358d());
        }
        ImmutableList<FullName> b = deviceOwnerData.m17354b();
        List arrayList = new ArrayList();
        for (FullName fullName : b) {
            arrayList.add(fullName.toString());
        }
        if (!arrayList.isEmpty()) {
            hashMap.put("name", arrayList);
        }
        String str = null;
        try {
            str = FbObjectMapper.i().a(hashMap);
        } catch (JsonProcessingException e) {
            BLog.b(f10312a, "jsonEncode DeviceOwnerData failed", e);
        }
        return str;
    }
}
