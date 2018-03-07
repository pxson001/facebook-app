package com.facebook.xconfig.core;

import com.facebook.debug.log.BLog;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: skip_intro_toast_arg */
public class XConfigSetting implements Comparable<XConfigSetting> {
    public final String f4700a;
    public final XConfigName f4701b;
    @Nullable
    String f4702c = null;

    public int compareTo(Object obj) {
        XConfigSetting xConfigSetting = (XConfigSetting) obj;
        int c = this.f4701b.m2015c(xConfigSetting.f4701b);
        if (c == 0) {
            return this.f4700a.compareTo(xConfigSetting.f4700a);
        }
        BLog.c("XConfigSetting", "Tried to compare %s:%s with %s:%s - we should not compare settings from different configs", new Object[]{this.f4701b, this.f4700a, xConfigSetting.f4701b, xConfigSetting.f4700a});
        return c;
    }

    public XConfigSetting(XConfigName xConfigName, String str) {
        Preconditions.checkArgument(XConfigRegistry.m8938a(str));
        this.f4700a = str;
        this.f4701b = (XConfigName) Preconditions.checkNotNull(xConfigName);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof XConfigSetting)) {
            return false;
        }
        XConfigSetting xConfigSetting = (XConfigSetting) obj;
        if (!this.f4700a.equals(xConfigSetting.f4700a)) {
            return false;
        }
        if (this.f4701b.equals(xConfigSetting.f4701b)) {
            return true;
        }
        BLog.c("XConfigSetting", "Tried to check whether %s:%s equals %s:%s - we should not compare settings from different configs", new Object[]{this.f4701b, this.f4700a, xConfigSetting.f4701b, xConfigSetting.f4700a});
        return false;
    }

    public int hashCode() {
        return (this.f4700a.hashCode() * 31) + this.f4701b.hashCode();
    }

    public String toString() {
        return this.f4700a;
    }
}
