package com.facebook.orca.app;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.orca.app.OrcaDataManager.MyAuthComponent;

@InjectorModule
/* compiled from: 동방 */
public class MessagesDefaultProcessDataModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    public static MyAuthComponent m28a(OrcaDataManager orcaDataManager) {
        return orcaDataManager.d;
    }
}
