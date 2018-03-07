package com.facebook.messaging.actionlinks;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: trackers_that_failed */
public class MessagingActionLinkModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    public static ActionLinkHandler m1589a(KeyboardBroadcastActionLinkHandler keyboardBroadcastActionLinkHandler, AutoComposeBroadcastActionLinkHandler autoComposeBroadcastActionLinkHandler, AutoComposeIntentActionLinkHandler autoComposeIntentActionLinkHandler, DefaultActionLinkHandler defaultActionLinkHandler) {
        return new CompositeActionLinkHandler(keyboardBroadcastActionLinkHandler, autoComposeBroadcastActionLinkHandler, autoComposeIntentActionLinkHandler, defaultActionLinkHandler);
    }
}
