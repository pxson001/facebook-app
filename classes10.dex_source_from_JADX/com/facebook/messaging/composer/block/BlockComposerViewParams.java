package com.facebook.messaging.composer.block;

import android.net.Uri;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: thread.hasFailedMessageSend */
public class BlockComposerViewParams {
    public final int f1700a;
    public final int f1701b;
    public final int f1702c;
    public final int f1703d;
    @Nullable
    public final Uri f1704e;

    BlockComposerViewParams(BlockComposerViewParamsBuilder blockComposerViewParamsBuilder) {
        this.f1700a = blockComposerViewParamsBuilder.f1705a;
        this.f1701b = blockComposerViewParamsBuilder.f1706b;
        this.f1702c = blockComposerViewParamsBuilder.f1707c;
        this.f1703d = blockComposerViewParamsBuilder.f1708d;
        this.f1704e = blockComposerViewParamsBuilder.f1709e;
    }

    public static BlockComposerViewParamsBuilder newBuilder() {
        return new BlockComposerViewParamsBuilder();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BlockComposerViewParams)) {
            return false;
        }
        BlockComposerViewParams blockComposerViewParams = (BlockComposerViewParams) obj;
        if (this.f1700a == blockComposerViewParams.f1700a && this.f1701b == blockComposerViewParams.f1701b && this.f1702c == blockComposerViewParams.f1702c && this.f1703d == blockComposerViewParams.f1703d && Objects.equal(this.f1704e, blockComposerViewParams.f1704e)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Integer.valueOf(this.f1700a), Integer.valueOf(this.f1701b), Integer.valueOf(this.f1702c), Integer.valueOf(this.f1703d), this.f1704e});
    }
}
