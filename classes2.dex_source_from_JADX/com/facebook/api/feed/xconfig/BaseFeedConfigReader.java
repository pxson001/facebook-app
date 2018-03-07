package com.facebook.api.feed.xconfig;

import com.facebook.common.util.StringUtil;
import com.facebook.xconfig.core.XConfigReader;
import com.facebook.xconfig.core.XConfigSetting;
import org.json.JSONObject;

/* compiled from: set_primary_payment_card */
public abstract class BaseFeedConfigReader {
    private final XConfigReader f5190a;
    private final int[] f5191b;
    private final boolean[] f5192c;
    private final boolean[] f5193d;
    private final boolean[] f5194e;
    private final JSONObject[] f5195f;
    private final boolean[] f5196g;
    private final String[] f5197h;
    private final boolean[] f5198i;
    private final String[][] f5199j;
    private final boolean[] f5200k;

    public BaseFeedConfigReader(XConfigReader xConfigReader, int i, int i2, int i3, int i4, int i5) {
        this.f5190a = xConfigReader;
        this.f5191b = new int[i];
        this.f5192c = new boolean[i];
        this.f5193d = new boolean[i2];
        this.f5194e = new boolean[i2];
        this.f5195f = new JSONObject[i4];
        this.f5196g = new boolean[i4];
        this.f5197h = new String[i3];
        this.f5198i = new boolean[i3];
        this.f5199j = new String[i5][];
        this.f5200k = new boolean[i5];
    }

    public BaseFeedConfigReader(XConfigReader xConfigReader, int i, int i2, int i3, int i4) {
        this(xConfigReader, i, i2, i3, i4, 0);
    }

    public final int m9087a(XConfigSetting xConfigSetting, int i, int i2) {
        if (!this.f5192c[i]) {
            this.f5191b[i] = this.f5190a.m2683a(xConfigSetting, i2);
            this.f5192c[i] = true;
        }
        return this.f5191b[i];
    }

    public final boolean m9089a(XConfigSetting xConfigSetting, int i, boolean z) {
        if (!this.f5194e[i]) {
            this.f5193d[i] = this.f5190a.m2686a(xConfigSetting, z);
            this.f5194e[i] = true;
        }
        return this.f5193d[i];
    }

    public final String m9088a(XConfigSetting xConfigSetting, int i, String str) {
        if (!this.f5198i[i]) {
            this.f5197h[i] = this.f5190a.m2685a(xConfigSetting, str);
            this.f5198i[i] = true;
        }
        return this.f5197h[i];
    }

    public final String[] m9090a(XConfigSetting xConfigSetting, int i, String[] strArr) {
        if (!this.f5200k[i]) {
            CharSequence a = this.f5190a.m2685a(xConfigSetting, "");
            if (!StringUtil.m3589a(a)) {
                strArr = a.split(",");
            }
            this.f5199j[i] = strArr;
            this.f5200k[i] = true;
        }
        return this.f5199j[i];
    }
}
