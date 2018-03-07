package com.facebook.messaging.montage;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.attachments.AttachmentDataFactory;
import com.facebook.messaging.messageclassifier.MessageClassifier;
import com.facebook.stickers.client.FetchStickerCoordinator;
import com.facebook.stickers.data.StickerCache;
import com.facebook.stickers.ui.StickerUrls;
import java.util.concurrent.Executor;

/* compiled from: iso-8859-1 */
public class MontageThumbnailControllerProvider extends AbstractAssistedProvider<MontageThumbnailController> {
    public final MontageThumbnailController m12896a(FbDraweeView fbDraweeView) {
        return new MontageThumbnailController(fbDraweeView, AttachmentDataFactory.a(this), IdBasedProvider.a(this, 1117), FetchStickerCoordinator.a(this), MessageClassifier.a(this), MontageMessagesHelper.m12857b((InjectorLike) this), ResourcesMethodAutoProvider.a(this), StickerCache.a(this), StickerUrls.b(this), IdBasedProvider.a(this, 3597), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this));
    }
}
