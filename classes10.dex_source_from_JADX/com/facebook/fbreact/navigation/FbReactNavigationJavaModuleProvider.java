package com.facebook.fbreact.navigation;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbreact.fragment.ImmersiveReactFragmentHooks;
import com.facebook.fbreact.search.ReactSearchEventBus;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.concurrent.Executor;

/* compiled from: anonymousAppDeviceGUID */
public class FbReactNavigationJavaModuleProvider extends AbstractAssistedProvider<FbReactNavigationJavaModule> {
    public final FbReactNavigationJavaModule m19919a(ReactApplicationContext reactApplicationContext) {
        return new FbReactNavigationJavaModule(reactApplicationContext, (SecureContextHelper) DefaultSecureContextHelper.a(this), FbReactNavigationUriIntentBuilder.m19920a(this), ImmersiveReactFragmentHooks.a(this), FbUriIntentHandler.a(this), ReactSearchEventBus.a(this), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this));
    }
}
