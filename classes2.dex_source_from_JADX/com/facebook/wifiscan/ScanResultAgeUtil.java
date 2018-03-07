package com.facebook.wifiscan;

import android.annotation.TargetApi;
import android.net.wifi.ScanResult;
import android.os.Build.VERSION;
import com.facebook.common.time.TimeConversions;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: isPrefetch */
public class ScanResultAgeUtil {
    @TargetApi(17)
    public static long m27026a(ScanResult scanResult, long j) {
        Preconditions.checkState(VERSION.SDK_INT >= 17);
        return j - TimeConversions.m11978r(scanResult.timestamp);
    }

    @Nullable
    static List<ScanResult> m27027a(@Nullable List<ScanResult> list, long j, long j2) {
        if (list == null) {
            return null;
        }
        List<ScanResult> arrayList = new ArrayList();
        for (ScanResult scanResult : list) {
            if (m27026a(scanResult, j2) <= j) {
                arrayList.add(scanResult);
            }
        }
        return arrayList;
    }

    private ScanResultAgeUtil() {
    }
}
