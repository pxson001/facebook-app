package com.facebook.account.recovery.helper;

import com.facebook.account.recovery.logging.AccountRecoveryAnalyticsLogger;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.debug.log.BLog;
import com.facebook.growth.model.DeviceOwnerData;
import com.facebook.growth.model.FullName;
import com.facebook.growth.util.DeviceOwnerDataFetcher;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;

/* compiled from: translation_type */
public class DeviceOwnerDataBackgroundHelper {
    public static final Class<?> f704a = DeviceOwnerDataBackgroundHelper.class;
    public final DeviceOwnerDataFetcher f705b;
    public final FbSharedPreferences f706c;
    public final ListeningExecutorService f707d;
    private final FbObjectMapper f708e;
    public final AccountRecoveryAnalyticsLogger f709f;

    @Inject
    public DeviceOwnerDataBackgroundHelper(DeviceOwnerDataFetcher deviceOwnerDataFetcher, FbSharedPreferences fbSharedPreferences, ListeningExecutorService listeningExecutorService, FbObjectMapper fbObjectMapper, AccountRecoveryAnalyticsLogger accountRecoveryAnalyticsLogger) {
        this.f705b = deviceOwnerDataFetcher;
        this.f706c = fbSharedPreferences;
        this.f707d = listeningExecutorService;
        this.f708e = fbObjectMapper;
        this.f709f = accountRecoveryAnalyticsLogger;
    }

    public static String m1093a(DeviceOwnerDataBackgroundHelper deviceOwnerDataBackgroundHelper, DeviceOwnerData deviceOwnerData) {
        HashMap hashMap = new HashMap();
        if (deviceOwnerData.f()) {
            hashMap.put("email", deviceOwnerData.c());
        }
        if (deviceOwnerData.g()) {
            hashMap.put("phone", deviceOwnerData.d());
        }
        ImmutableList<FullName> b = deviceOwnerData.b();
        List arrayList = new ArrayList();
        for (FullName fullName : b) {
            arrayList.add(fullName.toString());
        }
        if (!arrayList.isEmpty()) {
            hashMap.put("name", arrayList);
        }
        String str = null;
        try {
            str = deviceOwnerDataBackgroundHelper.f708e.a(hashMap);
        } catch (Throwable e) {
            BLog.b(f704a, "Account Recovery Parallel Search Device Data JSON Encode failed", e);
        }
        return str;
    }
}
