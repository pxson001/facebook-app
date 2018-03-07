package com.facebook.messaging.business.commerceui.protocol;

import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: num_stories */
public class CommerceUnlinkHandler {
    public final ApiMethodRunnerImpl f8398a;
    public final CommerceUnlinkMethod f8399b;
    public final ListeningExecutorService f8400c;

    /* compiled from: num_stories */
    public class C09511 implements Callable<Void> {
        final /* synthetic */ String f8396a;
        final /* synthetic */ CommerceUnlinkHandler f8397b;

        public C09511(CommerceUnlinkHandler commerceUnlinkHandler, String str) {
            this.f8397b = commerceUnlinkHandler;
            this.f8396a = str;
        }

        public Object call() {
            this.f8397b.f8398a.a(this.f8397b.f8399b, this.f8396a);
            return null;
        }
    }

    @Inject
    public CommerceUnlinkHandler(ApiMethodRunnerImpl apiMethodRunnerImpl, CommerceUnlinkMethod commerceUnlinkMethod, ListeningExecutorService listeningExecutorService) {
        this.f8398a = apiMethodRunnerImpl;
        this.f8399b = commerceUnlinkMethod;
        this.f8400c = listeningExecutorService;
    }
}
