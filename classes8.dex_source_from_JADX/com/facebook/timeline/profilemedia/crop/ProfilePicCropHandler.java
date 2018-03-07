package com.facebook.timeline.profilemedia.crop;

import com.facebook.fbservice.service.OperationResult;
import com.facebook.ipc.editgallery.EditGalleryIpcBundle;
import com.facebook.photos.futures.PhotosFuturesGenerator;
import com.facebook.timeline.profilemedia.ProfileMediaChangeBroadcaster;
import com.facebook.timeline.profilemedia.ProfileMediaOptimisticPostingController;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mTopicIds */
public class ProfilePicCropHandler {
    private final PhotosFuturesGenerator f9176a;
    public final ProfileMediaChangeBroadcaster f9177b;
    public final ProfileMediaOptimisticPostingController f9178c;
    public final Toaster f9179d;
    private final Executor f9180e;

    @Inject
    public ProfilePicCropHandler(PhotosFuturesGenerator photosFuturesGenerator, ProfileMediaChangeBroadcaster profileMediaChangeBroadcaster, ProfileMediaOptimisticPostingController profileMediaOptimisticPostingController, Toaster toaster, Executor executor) {
        this.f9176a = photosFuturesGenerator;
        this.f9177b = profileMediaChangeBroadcaster;
        this.f9178c = profileMediaOptimisticPostingController;
        this.f9179d = toaster;
        this.f9180e = executor;
    }

    public final void m10955a(final EditGalleryIpcBundle editGalleryIpcBundle, long j) {
        boolean z;
        if (editGalleryIpcBundle.h == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.f9178c.m10951a(editGalleryIpcBundle.b, editGalleryIpcBundle.d);
        Futures.a(this.f9176a.a(editGalleryIpcBundle.f, editGalleryIpcBundle.g, "existing", j, editGalleryIpcBundle.h), new FutureCallback<OperationResult>(this) {
            final /* synthetic */ ProfilePicCropHandler f9175b;

            public void onSuccess(@Nullable Object obj) {
                this.f9175b.f9178c.m10952a(editGalleryIpcBundle.d);
                this.f9175b.f9177b.m10945b();
            }

            public void onFailure(Throwable th) {
                this.f9175b.f9178c.m10952a(editGalleryIpcBundle.d);
                this.f9175b.f9179d.b(new ToastBuilder(2131238434));
            }
        }, this.f9180e);
    }
}
