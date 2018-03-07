package com.facebook.messaging.send.client;

import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.init.INeedInit;
import com.facebook.config.application.Product;
import com.facebook.messaging.abtest.ExperimentsForMessagingAbTestModule;
import com.facebook.messaging.send.client.StartupRetryManager.1;
import com.facebook.messaging.send.client.StartupRetryManager.2;
import com.facebook.messaging.send.client.StartupRetryManager.InitialSendRetryStatus;
import com.google.common.util.concurrent.Futures;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;

@ThreadSafe
/* compiled from: is_messenger_only */
public class StartupRetryInitializer implements INeedInit {
    private final Product f9957a;
    private final ViewerContextManager f9958b;
    private final Provider<StartupRetryManager> f9959c;

    @Inject
    public StartupRetryInitializer(Product product, ViewerContextManager viewerContextManager, Provider<StartupRetryManager> provider) {
        this.f9957a = product;
        this.f9958b = viewerContextManager;
        this.f9959c = provider;
    }

    public void init() {
        if (this.f9957a != Product.PAA && this.f9958b.a() != null) {
            StartupRetryManager startupRetryManager = (StartupRetryManager) this.f9959c.get();
            if (startupRetryManager.f9969i != Product.PAA) {
                long a = startupRetryManager.f9966f.a(ExperimentsForMessagingAbTestModule.f10048d, 0);
                if ((a > 0 ? 1 : null) != null && startupRetryManager.f9971k == InitialSendRetryStatus.NOT_STARTED) {
                    startupRetryManager.f9971k = InitialSendRetryStatus.IN_PROGRESS;
                    Futures.a(startupRetryManager.f9964d.a(new 1(startupRetryManager, a, startupRetryManager.f9972l - (startupRetryManager.f9966f.a(ExperimentsForMessagingAbTestModule.f10049e, 0) * 1000))), new 2(startupRetryManager), startupRetryManager.f9963c);
                }
            }
        }
    }
}
