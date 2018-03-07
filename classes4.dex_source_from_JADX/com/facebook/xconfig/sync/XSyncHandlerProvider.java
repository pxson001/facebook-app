package com.facebook.xconfig.sync;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.xconfig.core.STATICDI_MULTIBIND_PROVIDER$XConfigSyncListener;
import com.facebook.xconfig.core.XConfigRegistry;
import com.facebook.xconfig.core.XConfigStorage;

/* compiled from: style */
public class XSyncHandlerProvider extends AbstractAssistedProvider<XSyncHandler> {
    public final XSyncHandler m1858a(String str) {
        return new XSyncHandler((AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(this), DefaultAndroidThreadUtil.b(this), str, XConfigStorage.a(this), XConfigRegistry.a(this), (XSyncApiMethodProvider) getOnDemandAssistedProviderForStaticDi(XSyncApiMethodProvider.class), new MultiBinderSet(getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$XConfigSyncListener(this)));
    }
}
