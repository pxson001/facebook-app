package com.facebook.stickers.search;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.stickers.model.StickerInterface;
import java.util.concurrent.Executor;

/* compiled from: editRatingPrivacy */
public class TaggedStickersLoaderProvider extends AbstractAssistedProvider<TaggedStickersLoader> {
    public final TaggedStickersLoader m24603a(StickerInterface stickerInterface) {
        return new TaggedStickersLoader(stickerInterface, DefaultBlueServiceOperationFactory.b(this), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this));
    }
}
