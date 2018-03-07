package com.facebook.timeline.profilepiccoverphotoupload;

import com.facebook.content.event.FbEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.upload.event.MediaUploadEventBus;
import com.facebook.photos.upload.event.MediaUploadEventSubscriber;
import com.facebook.photos.upload.event.MediaUploadFailedEvent;
import com.facebook.photos.upload.event.MediaUploadSuccessEvent;
import com.facebook.photos.upload.operation.UploadOperation.Type;
import javax.inject.Inject;

@Deprecated
/* compiled from: mSuggestifierFooterDescription */
public class ProfilePicCoverPhotoUploadReceiver {
    private final MediaUploadEventBus f9211a;
    private final MediaSuccessBusSubscriber f9212b = new MediaSuccessBusSubscriber(this);
    private final MediaFailureBusSubscriber f9213c = new MediaFailureBusSubscriber(this);
    public ProfilePicCoverPhotoCallback f9214d;

    /* compiled from: mSuggestifierFooterDescription */
    /* synthetic */ class C09551 {
        static final /* synthetic */ int[] f9208a = new int[Type.values().length];

        static {
            try {
                f9208a[Type.PROFILE_PIC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9208a[Type.COVER_PHOTO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: mSuggestifierFooterDescription */
    class MediaFailureBusSubscriber extends MediaUploadEventSubscriber<MediaUploadFailedEvent> {
        final /* synthetic */ ProfilePicCoverPhotoUploadReceiver f9209a;

        public MediaFailureBusSubscriber(ProfilePicCoverPhotoUploadReceiver profilePicCoverPhotoUploadReceiver) {
            this.f9209a = profilePicCoverPhotoUploadReceiver;
        }

        public final void m10995b(FbEvent fbEvent) {
            MediaUploadFailedEvent mediaUploadFailedEvent = (MediaUploadFailedEvent) fbEvent;
            int[] iArr = C09551.f9208a;
            mediaUploadFailedEvent.a.r.ordinal();
        }

        public final Class<MediaUploadFailedEvent> m10994a() {
            return MediaUploadFailedEvent.class;
        }
    }

    /* compiled from: mSuggestifierFooterDescription */
    class MediaSuccessBusSubscriber extends MediaUploadEventSubscriber<MediaUploadSuccessEvent> {
        final /* synthetic */ ProfilePicCoverPhotoUploadReceiver f9210a;

        public MediaSuccessBusSubscriber(ProfilePicCoverPhotoUploadReceiver profilePicCoverPhotoUploadReceiver) {
            this.f9210a = profilePicCoverPhotoUploadReceiver;
        }

        public final void m10997b(FbEvent fbEvent) {
            switch (C09551.f9208a[((MediaUploadSuccessEvent) fbEvent).a.r.ordinal()]) {
                case 1:
                case 2:
                    if (this.f9210a.f9214d != null) {
                        this.f9210a.f9214d.m10998a();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public final Class<MediaUploadSuccessEvent> m10996a() {
            return MediaUploadSuccessEvent.class;
        }
    }

    /* compiled from: mSuggestifierFooterDescription */
    public interface ProfilePicCoverPhotoCallback {
        void m10998a();
    }

    public static ProfilePicCoverPhotoUploadReceiver m10999a(InjectorLike injectorLike) {
        return new ProfilePicCoverPhotoUploadReceiver(MediaUploadEventBus.a(injectorLike));
    }

    @Inject
    public ProfilePicCoverPhotoUploadReceiver(MediaUploadEventBus mediaUploadEventBus) {
        this.f9211a = mediaUploadEventBus;
    }

    public final void m11001a(ProfilePicCoverPhotoCallback profilePicCoverPhotoCallback) {
        this.f9214d = profilePicCoverPhotoCallback;
        this.f9211a.a(this.f9212b);
        this.f9211a.a(this.f9213c);
    }

    public final void m11000a() {
        this.f9214d = null;
        this.f9211a.b(this.f9212b);
        this.f9211a.b(this.f9213c);
    }
}
