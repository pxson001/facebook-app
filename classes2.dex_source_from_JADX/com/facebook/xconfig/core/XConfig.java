package com.facebook.xconfig.core;

import com.facebook.common.build.BuildConstants;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;

/* compiled from: skip_prefetch_urls */
public class XConfig {
    public final XConfigName f4698a;
    public final ImmutableSet<XConfigSetting> f4699b;

    public XConfig(XConfigName xConfigName, ImmutableSet<XConfigSetting> immutableSet) {
        this.f4698a = (XConfigName) Preconditions.checkNotNull(xConfigName);
        this.f4699b = (ImmutableSet) Preconditions.checkNotNull(immutableSet);
        if (BuildConstants.i) {
            Iterator it = immutableSet.iterator();
            while (it.hasNext()) {
                Preconditions.checkArgument(((XConfigSetting) it.next()).f4701b == xConfigName, "Setting %s:%s should have config %s", ((XConfigSetting) it.next()).f4701b, ((XConfigSetting) it.next()).f4700a, xConfigName);
            }
        }
    }
}
