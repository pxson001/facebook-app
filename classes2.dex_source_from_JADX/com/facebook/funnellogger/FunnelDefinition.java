package com.facebook.funnellogger;

import java.util.HashMap;
import javax.annotation.Nullable;

/* compiled from: header_generated */
public class FunnelDefinition {
    private static final HashMap<String, FunnelDefinition> f21180e = new HashMap();
    public final String f21181a;
    public final short f21182b;
    public int f21183c = 600;
    public boolean f21184d = true;

    static FunnelDefinition m28906a(String str) {
        FunnelDefinition funnelDefinition = new FunnelDefinition(str);
        f21180e.put(str, funnelDefinition);
        return funnelDefinition;
    }

    @Nullable
    public static FunnelDefinition m28907b(String str) {
        return (FunnelDefinition) f21180e.get(str);
    }

    private FunnelDefinition(String str) {
        this.f21181a = str;
        this.f21182b = (short) this.f21181a.hashCode();
    }

    public final String m28908a() {
        return this.f21181a;
    }

    public int hashCode() {
        return this.f21181a.hashCode();
    }

    public boolean equals(Object obj) {
        return (obj == null || !(obj instanceof FunnelDefinition)) ? false : ((FunnelDefinition) obj).f21181a.equals(this.f21181a);
    }
}
