package com.facebook.messaging.composer.block;

import android.net.Uri;
import android.support.annotation.Nullable;
import com.facebook.messaging.model.threadkey.ThreadKey;

/* compiled from: thread.canReplyTo */
public class BlockComposerViewParamsFactory {
    private static final Uri f1710a = Uri.parse("https://www.facebook.com/help/314046672118572");

    public static BlockComposerViewParams m1693a(@Nullable ThreadKey threadKey) {
        if (ThreadKey.g(threadKey)) {
            return m1694a(ThreadKey.h(threadKey));
        }
        return m1692a();
    }

    private static BlockComposerViewParams m1692a() {
        BlockComposerViewParamsBuilder blockComposerViewParamsBuilder = new BlockComposerViewParamsBuilder();
        blockComposerViewParamsBuilder.f1705a = 2131241189;
        blockComposerViewParamsBuilder = blockComposerViewParamsBuilder;
        blockComposerViewParamsBuilder.f1706b = 2131361920;
        blockComposerViewParamsBuilder = blockComposerViewParamsBuilder;
        blockComposerViewParamsBuilder.f1707c = 2131362241;
        blockComposerViewParamsBuilder = blockComposerViewParamsBuilder;
        blockComposerViewParamsBuilder.f1708d = 2131241190;
        blockComposerViewParamsBuilder = blockComposerViewParamsBuilder;
        blockComposerViewParamsBuilder.f1709e = f1710a;
        return blockComposerViewParamsBuilder.m1691f();
    }

    private static BlockComposerViewParams m1694a(boolean z) {
        int i;
        BlockComposerViewParamsBuilder blockComposerViewParamsBuilder = new BlockComposerViewParamsBuilder();
        if (z) {
            i = 2131241191;
        } else {
            i = 2131241188;
        }
        blockComposerViewParamsBuilder.f1705a = i;
        BlockComposerViewParamsBuilder blockComposerViewParamsBuilder2 = blockComposerViewParamsBuilder;
        blockComposerViewParamsBuilder2.f1706b = 2131361920;
        blockComposerViewParamsBuilder2 = blockComposerViewParamsBuilder2;
        blockComposerViewParamsBuilder2.f1707c = 2131362549;
        return blockComposerViewParamsBuilder2.m1691f();
    }
}
