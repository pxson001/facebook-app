package com.facebook.messaging.service.methods;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: db_folder_size */
public class Boolean_IsMarkFolderSeenOverMqttGatekeeperGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(147, false));
    }
}
