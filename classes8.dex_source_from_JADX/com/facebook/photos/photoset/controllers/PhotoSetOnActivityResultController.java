package com.facebook.photos.photoset.controllers;

import android.app.Activity;
import android.content.Intent;
import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.editgallery.EditGalleryIpcBundle;
import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.albums.ProfilePicCoverPhotoEditHelper;
import com.facebook.timeline.profilepiccoverphotoupload.ProfilePicUploadHandler;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: collage */
public class PhotoSetOnActivityResultController {
    private final BaseFbBroadcastManager f17786a;
    private final ProfilePicCoverPhotoEditHelper f17787b;
    private final ProfilePicUploadHandler f17788c;
    private ViewerContext f17789d;
    private ComposerPublishServiceHelper f17790e;

    public static PhotoSetOnActivityResultController m21763b(InjectorLike injectorLike) {
        return new PhotoSetOnActivityResultController(ViewerContextMethodAutoProvider.b(injectorLike), ComposerPublishServiceHelper.b(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), ProfilePicCoverPhotoEditHelper.b(injectorLike), ProfilePicUploadHandler.m11003b(injectorLike));
    }

    @Inject
    public PhotoSetOnActivityResultController(ViewerContext viewerContext, ComposerPublishServiceHelper composerPublishServiceHelper, BaseFbBroadcastManager baseFbBroadcastManager, ProfilePicCoverPhotoEditHelper profilePicCoverPhotoEditHelper, ProfilePicUploadHandler profilePicUploadHandler) {
        this.f17789d = viewerContext;
        this.f17790e = composerPublishServiceHelper;
        this.f17786a = baseFbBroadcastManager;
        this.f17787b = profilePicCoverPhotoEditHelper;
        this.f17788c = profilePicUploadHandler;
    }

    public final boolean m21764a(Activity activity, int i, int i2, Intent intent) {
        if (i2 != -1) {
            return false;
        }
        switch (i) {
            case 1000:
            case 1001:
            case 2000:
                if (intent == null || !intent.hasExtra(EditGalleryIpcBundle.a)) {
                    return false;
                }
                this.f17788c.m11004a((EditGalleryIpcBundle) intent.getParcelableExtra(EditGalleryIpcBundle.a), null, intent.getLongExtra("extra_profile_pic_expiration", 0), intent.getStringExtra("staging_ground_photo_caption"), intent.getStringExtra("profile_photo_method_extra"), this.f17789d);
                return true;
            case 1002:
            case 2001:
                if (intent == null || !intent.hasExtra("extra_media_items")) {
                    return false;
                }
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("extra_media_items");
                if (parcelableArrayListExtra.size() != 1) {
                    return false;
                }
                this.f17787b.a(0, ((MediaItem) parcelableArrayListExtra.get(0)).f(), activity, Long.parseLong(this.f17789d.mUserId));
                return true;
            case 1756:
                this.f17790e.c(intent);
                return true;
            case 9913:
                activity.setResult(-1, intent);
                activity.finish();
                return true;
            case 9914:
                break;
            case 9915:
                activity.setResult(-1, intent);
                activity.finish();
                return true;
            case 9916:
                Intent intent2 = new Intent();
                intent2.setAction("com.facebook.intent.action.COVER_PHOTO_UPDATED");
                this.f17786a.a(intent2);
                break;
            default:
                return false;
        }
        activity.setResult(-1);
        activity.finish();
        return true;
    }
}
