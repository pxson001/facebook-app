package com.facebook.analytics.util;

import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mSyncMode */
public class LoggerMapUtils {
    public FbNetworkManager f8552a;

    public static LoggerMapUtils m8803b(InjectorLike injectorLike) {
        return new LoggerMapUtils(FbNetworkManager.a(injectorLike));
    }

    @Inject
    public LoggerMapUtils(FbNetworkManager fbNetworkManager) {
        this.f8552a = fbNetworkManager;
    }

    public static Map<String, String> m8802a(String... strArr) {
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Map must have an even (or zero) number of parameters");
        }
        Map<String, String> c = Maps.c();
        for (int i = 0; i < strArr.length; i += 2) {
            c.put(Strings.nullToEmpty(strArr[i]), Strings.nullToEmpty(strArr[i + 1]));
        }
        return c;
    }

    public final Map<String, String> m8804a(@Nullable Map<String, String> map, String... strArr) {
        Map<String, String> a = m8802a(strArr);
        if (!(map == null || map.isEmpty())) {
            a.putAll(map);
        }
        return a;
    }

    public final void m8805a(Map<String, String> map) {
        String typeName;
        String subtypeName;
        String extraInfo;
        NetworkInfo i = this.f8552a.i();
        WifiInfo o = this.f8552a.o();
        String str = null;
        if (i != null) {
            typeName = i.getTypeName();
            subtypeName = i.getSubtypeName();
            extraInfo = i.getExtraInfo();
        } else {
            extraInfo = null;
            subtypeName = null;
            typeName = null;
        }
        if (o != null) {
            str = Integer.toString(o.getRssi());
        }
        typeName = Strings.nullToEmpty(typeName);
        subtypeName = Strings.nullToEmpty(subtypeName);
        extraInfo = Strings.nullToEmpty(extraInfo);
        str = Strings.nullToEmpty(str);
        map.put("network_is_connected", Boolean.toString(this.f8552a.d()));
        map.put("network_type", typeName);
        map.put("network_subtype", subtypeName);
        map.put("network_extra_info", extraInfo);
        map.put("network_wifi_rssi", str);
    }
}
