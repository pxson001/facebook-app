package com.google.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: amount_in_hundredths */
public class ExtensionRegistryLite {
    public static volatile boolean f20904a = false;
    public static final ExtensionRegistryLite f20905c = new ExtensionRegistryLite((byte) 0);
    private final Map<Object, Object<?, ?>> f20906b;

    ExtensionRegistryLite() {
        this.f20906b = new HashMap();
    }

    ExtensionRegistryLite(ExtensionRegistryLite extensionRegistryLite) {
        if (extensionRegistryLite == f20905c) {
            this.f20906b = Collections.emptyMap();
        } else {
            this.f20906b = Collections.unmodifiableMap(extensionRegistryLite.f20906b);
        }
    }

    private ExtensionRegistryLite(byte b) {
        this.f20906b = Collections.emptyMap();
    }
}
