package com.facebook.groups.memberlist;

import java.util.HashSet;
import java.util.Set;

/* compiled from: extra_session_id */
public class GroupMemberListInfoManager {
    public final Set<String> f14263a = new HashSet();
    public final Set<String> f14264b = new HashSet();
    private final Set<String> f14265c = new HashSet();
    public boolean f14266d;
    public boolean f14267e;
    public boolean f14268f;

    public final void m15876a() {
        this.f14265c.clear();
    }

    public final void m15877a(String str) {
        this.f14265c.add(str);
    }

    public final int m15878b() {
        return this.f14265c.size();
    }

    public final boolean m15879b(String str) {
        return this.f14265c.contains(str);
    }

    public final boolean m15880c(String str) {
        return this.f14263a.contains(str);
    }
}
