package com.facebook.xconfig.core;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Arrays;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: sms_takeover_inbox_filter_show_optin */
public class XConfigAndValueInformation {
    public final String f2016a;
    public final ImmutableMap<String, String> f2017b;
    public final String f2018c;
    public final String f2019d;

    public XConfigAndValueInformation(String str, ImmutableMap<String, String> immutableMap, String str2, String str3) {
        this.f2016a = (String) Preconditions.checkNotNull(str);
        this.f2017b = (ImmutableMap) Preconditions.checkNotNull(immutableMap);
        this.f2018c = (String) Preconditions.checkNotNull(str2);
        this.f2019d = (String) Preconditions.checkNotNull(str3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof XConfigAndValueInformation)) {
            return false;
        }
        XConfigAndValueInformation xConfigAndValueInformation = (XConfigAndValueInformation) obj;
        if (this.f2016a.equals(xConfigAndValueInformation.f2016a) && this.f2017b.equals(xConfigAndValueInformation.f2017b) && this.f2018c.equals(xConfigAndValueInformation.f2018c) && this.f2019d.equals(xConfigAndValueInformation.f2019d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2016a, this.f2017b, this.f2018c, this.f2019d});
    }

    public String toString() {
        return this.f2016a + ":" + this.f2017b;
    }
}
