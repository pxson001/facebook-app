package com.facebook.ipc.productionprompts.fetcher;

import com.facebook.productionprompts.model.PromptObject;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: network_info_ingress_avg */
public interface PromptFetcher {
    void mo2488a(Class<? extends PromptObject> cls);

    void mo2489a(Class<? extends PromptObject> cls, String str, boolean z);

    boolean mo2490a();

    Class<? extends PromptObject> mo2491b();

    ListenableFuture<ImmutableList<PromptObject>> mo2492c();
}
