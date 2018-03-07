package com.facebook.vault.protocol;

import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: thread_id IN (SELECT thread_id FROM #threads) AND action_id > %1$d */
public class VaultAllImagesGetParams {
    public final String f1846a;
    public final int f1847b;

    public VaultAllImagesGetParams(int i, String str) {
        this.f1846a = str;
        this.f1847b = i;
    }
}
