package com.facebook.location.foreground;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import com.facebook.annotations.DoNotOptimize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: Unknown row type */
public class CellInfos {

    @DoNotOptimize
    /* compiled from: Unknown row type */
    class Api17Utils {
        private Api17Utils() {
        }

        @TargetApi(17)
        static List<CellInfo> m10831a(TelephonyManager telephonyManager) {
            return telephonyManager.getAllCellInfo();
        }

        @TargetApi(17)
        static boolean m10832a(CellInfo cellInfo) {
            return cellInfo.isRegistered();
        }
    }

    @Nullable
    public static List<CellInfo> m10833a(Context context) {
        if (VERSION.SDK_INT < 17) {
            throw new CellTowerInfoNotAvailableException(Type.INCOMPATIBLE_DEVICE);
        }
        try {
            return Api17Utils.m10831a((TelephonyManager) context.getSystemService("phone"));
        } catch (SecurityException e) {
            throw new CellTowerInfoNotAvailableException(Type.PERMISSION_DENIED);
        }
    }

    @Nullable
    public static List<CellInfo> m10834a(List<CellInfo> list) {
        if (list == null || VERSION.SDK_INT < 17) {
            return null;
        }
        Builder builder = ImmutableList.builder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            CellInfo cellInfo = (CellInfo) list.get(i);
            if (Api17Utils.m10832a(cellInfo)) {
                builder.c(cellInfo);
            }
        }
        List<CellInfo> b = builder.b();
        return b.isEmpty() ? null : b;
    }

    private CellInfos() {
    }
}
