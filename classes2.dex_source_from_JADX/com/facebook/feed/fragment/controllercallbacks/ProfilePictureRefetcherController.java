package com.facebook.feed.fragment.controllercallbacks;

import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.fragment.FragmentCreateDestroyCallbacks;
import com.facebook.feed.util.event.DataSetEvents$DataSetUpdatedEvent;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.profilemedia.sync.ProfilePhotoSyncManager;
import com.facebook.timeline.profilemedia.sync.ProfilePhotoSyncManager.Listener;
import javax.inject.Inject;

/* compiled from: place_question_photo_size */
public class ProfilePictureRefetcherController extends BaseController implements FragmentCreateDestroyCallbacks {
    public final ProfilePhotoSyncManager f9801a;
    public final FeedEventBus f9802b;
    public final Listener f9803c = new C04141(this);

    /* compiled from: place_question_photo_size */
    class C04141 implements Listener {
        final /* synthetic */ ProfilePictureRefetcherController f9828a;

        C04141(ProfilePictureRefetcherController profilePictureRefetcherController) {
            this.f9828a = profilePictureRefetcherController;
        }

        public final void mo1950a() {
            if (this.f9828a.f9802b != null) {
                this.f9828a.f9802b.mo651a(new DataSetEvents$DataSetUpdatedEvent());
            }
        }
    }

    public static ProfilePictureRefetcherController m14828a(InjectorLike injectorLike) {
        return new ProfilePictureRefetcherController(ProfilePhotoSyncManager.m14830a(injectorLike), FeedEventBus.m4573a(injectorLike));
    }

    @Inject
    public ProfilePictureRefetcherController(ProfilePhotoSyncManager profilePhotoSyncManager, FeedEventBus feedEventBus) {
        this.f9801a = profilePhotoSyncManager;
        this.f9802b = feedEventBus;
    }

    public final void mo1949b() {
    }
}
