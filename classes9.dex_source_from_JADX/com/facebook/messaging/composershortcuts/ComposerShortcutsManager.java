package com.facebook.messaging.composershortcuts;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: messaging_send_via_mqtt */
public interface ComposerShortcutsManager {

    /* compiled from: messaging_send_via_mqtt */
    public class ShortcutsList {
        public final ImmutableList<ComposerShortcutItem> f10053a;
        public final boolean f10054b;

        public ShortcutsList(ImmutableList<ComposerShortcutItem> immutableList, boolean z) {
            this.f10053a = immutableList;
            this.f10054b = z;
        }
    }

    ShortcutsList mo406a(ComposerShortcutsFilter composerShortcutsFilter);

    ListenableFuture<ImmutableMap<String, ImmutableList<PlatformSampleContent>>> mo407a();

    void mo408a(ComposerShortcutItem composerShortcutItem);
}
