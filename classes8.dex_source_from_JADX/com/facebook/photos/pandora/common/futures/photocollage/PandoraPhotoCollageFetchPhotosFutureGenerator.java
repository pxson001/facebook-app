package com.facebook.photos.pandora.common.futures.photocollage;

import com.facebook.fbservice.service.OperationResult;
import com.facebook.photos.pandora.common.data.PandoraInstanceId;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

/* compiled from: download_time */
public abstract class PandoraPhotoCollageFetchPhotosFutureGenerator {
    public abstract ListenableFuture<OperationResult> mo903a(@Nullable String str, @Nullable String str2, PandoraInstanceId pandoraInstanceId, int i, boolean z);
}
