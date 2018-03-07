package com.facebook.xconfig.sync;

import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: structured_names */
public class XSyncApiMethodProvider extends AbstractAssistedProvider<XSyncApiMethod> {
    public final XSyncApiMethod m1859a(String str) {
        return new XSyncApiMethod(str, UniqueIdForDeviceHolderMethodAutoProvider.b(this));
    }
}
