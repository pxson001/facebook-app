package com.facebook.orca.app;

import com.facebook.inject.AbstractProvider;
import com.facebook.orca.app.OrcaDataManager.MyAuthComponent;

/* compiled from: sync_local_preference_settings */
public class MyAuthComponentMethodAutoProvider extends AbstractProvider<MyAuthComponent> {
    public Object get() {
        return MessagesDefaultProcessDataModule.m28a(OrcaDataManager.a(this));
    }
}
