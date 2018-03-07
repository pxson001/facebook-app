package com.facebook.timeline.header.favphotos.edit;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.upload.uploaders.DirectPhotoUploader;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: fetch_nearby_friends_highlight */
public class UploadFavoritePhotoController {
    public final ListeningExecutorService f11815a;
    public final Provider<ViewerContext> f11816b;
    public final DirectPhotoUploader f11817c;
    public final String f11818d = SafeUUIDGenerator.a().toString();

    /* compiled from: fetch_nearby_friends_highlight */
    public class C16871 implements Callable<String> {
        final /* synthetic */ MediaItem f11813a;
        final /* synthetic */ UploadFavoritePhotoController f11814b;

        public C16871(UploadFavoritePhotoController uploadFavoritePhotoController, MediaItem mediaItem) {
            this.f11814b = uploadFavoritePhotoController;
            this.f11813a = mediaItem;
        }

        public Object call() {
            DirectPhotoUploader directPhotoUploader = this.f11814b.f11817c;
            MediaItem mediaItem = this.f11813a;
            String str = this.f11814b.f11818d;
            String str2 = "favorite_photos_batch";
            ViewerContext viewerContext = (ViewerContext) this.f11814b.f11816b.get();
            if (!viewerContext.mIsPageContext) {
                viewerContext = null;
            }
            return directPhotoUploader.a(mediaItem, str, str2, viewerContext);
        }
    }

    @Inject
    public UploadFavoritePhotoController(ListeningExecutorService listeningExecutorService, Provider<ViewerContext> provider, DirectPhotoUploader directPhotoUploader) {
        this.f11815a = listeningExecutorService;
        this.f11816b = provider;
        this.f11817c = directPhotoUploader;
    }
}
