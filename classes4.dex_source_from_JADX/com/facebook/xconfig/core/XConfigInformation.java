package com.facebook.xconfig.core;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Arrays;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: story_title */
public class XConfigInformation {
    public final XConfigName f1651a;
    public final ImmutableSet<XConfigSetting> f1652b;
    public final String f1653c;
    public final String f1654d;

    public XConfigInformation(XConfigName xConfigName, ImmutableSet<XConfigSetting> immutableSet, String str, String str2) {
        this.f1651a = (XConfigName) Preconditions.checkNotNull(xConfigName);
        this.f1652b = (ImmutableSet) Preconditions.checkNotNull(immutableSet);
        this.f1653c = (String) Preconditions.checkNotNull(str);
        this.f1654d = (String) Preconditions.checkNotNull(str2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof XConfigInformation)) {
            return false;
        }
        XConfigInformation xConfigInformation = (XConfigInformation) obj;
        if (this.f1651a.equals(xConfigInformation.f1651a) && this.f1652b.equals(xConfigInformation.f1652b) && this.f1653c.equals(xConfigInformation.f1653c) && this.f1654d.equals(xConfigInformation.f1654d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f1651a, this.f1652b, this.f1653c, this.f1654d});
    }

    public String toString() {
        return this.f1651a + ":" + this.f1652b;
    }
}
