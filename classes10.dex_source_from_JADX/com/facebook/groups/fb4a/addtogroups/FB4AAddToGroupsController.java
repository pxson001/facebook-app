package com.facebook.groups.fb4a.addtogroups;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: xcv */
public class FB4AAddToGroupsController {
    public final Set<String> f246a = new HashSet();

    public final Set<String> m295a() {
        return Collections.unmodifiableSet(this.f246a);
    }

    public final boolean m296c(String str) {
        return this.f246a.contains(str);
    }
}
