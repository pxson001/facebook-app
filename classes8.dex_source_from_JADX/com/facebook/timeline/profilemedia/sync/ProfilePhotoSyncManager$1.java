package com.facebook.timeline.profilemedia.sync;

import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.timeline.profilemedia.sync.ProfilePhotoSyncManager.Listener;
import com.google.common.util.concurrent.FutureCallback;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: mTargetAlbum */
public class ProfilePhotoSyncManager$1 implements FutureCallback<DefaultImageFieldsModel> {
    final /* synthetic */ ProfilePhotoSyncManager f9184a;

    public ProfilePhotoSyncManager$1(ProfilePhotoSyncManager profilePhotoSyncManager) {
        this.f9184a = profilePhotoSyncManager;
    }

    public void onSuccess(@Nullable Object obj) {
        DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) obj;
        this.f9184a.b();
        this.f9184a.e.lock();
        try {
            for (WeakReference weakReference : this.f9184a.c) {
                if (weakReference.get() != null) {
                    Listener listener = (Listener) weakReference.get();
                    if (defaultImageFieldsModel != null) {
                        defaultImageFieldsModel.b();
                    }
                    listener.a();
                }
            }
        } finally {
            this.f9184a.e.unlock();
        }
    }

    public void onFailure(Throwable th) {
    }
}
