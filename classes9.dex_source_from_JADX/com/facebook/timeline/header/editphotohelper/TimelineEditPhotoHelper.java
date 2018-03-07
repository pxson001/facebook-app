package com.facebook.timeline.header.editphotohelper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.fragment.IRefreshableFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.editgallery.EditGalleryIpcBundle;
import com.facebook.ipc.profile.TimelinePhotoEditMode;
import com.facebook.ipc.profile.TimelinePhotoTabModeParams;
import com.facebook.ipc.profile.profilevideo.ProfileVideoPreviewLauncher;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Builder;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.qe.api.QeAccessor;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.profilemedia.crop.ProfilePicCropHandler;
import com.facebook.timeline.profilemedia.upload.ProfileMediaUploadReceiver;
import com.facebook.timeline.profilepiccoverphotoupload.ProfilePicUploadHandler;
import com.facebook.timeline.tempprofilepic.model.ExpirationState;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: upload_size */
public class TimelineEditPhotoHelper {
    private long f834a;
    public Fragment f835b;
    private int f836c;
    private final Provider<IFeedIntentBuilder> f837d;
    private final Lazy<ProfilePicUploadHandler> f838e;
    private final Lazy<ProfilePicCropHandler> f839f;
    public final Provider<SecureContextHelper> f840g;
    private final Provider<ViewerContext> f841h;
    private final QeAccessor f842i;
    public final ProfileVideoPreviewLauncher f843j;
    private final AbstractFbErrorReporter f844k;
    private final Lazy<ProfileMediaUploadReceiver> f845l;

    @Inject
    public TimelineEditPhotoHelper(@Assisted Long l, @Assisted Fragment fragment, @Assisted int i, QeAccessor qeAccessor, Provider<IFeedIntentBuilder> provider, Provider<SecureContextHelper> provider2, Provider<ViewerContext> provider3, Lazy<ProfilePicUploadHandler> lazy, Lazy<ProfilePicCropHandler> lazy2, ProfileVideoPreviewLauncher profileVideoPreviewLauncher, FbErrorReporter fbErrorReporter, Lazy<ProfileMediaUploadReceiver> lazy3) {
        this.f834a = l.longValue();
        this.f835b = (Fragment) Preconditions.checkNotNull(fragment);
        Preconditions.checkArgument(this.f835b instanceof IRefreshableFragment);
        this.f836c = i;
        this.f842i = qeAccessor;
        this.f837d = provider;
        this.f840g = provider2;
        this.f841h = provider3;
        this.f838e = lazy;
        this.f839f = lazy2;
        this.f843j = profileVideoPreviewLauncher;
        this.f844k = fbErrorReporter;
        this.f845l = lazy3;
    }

    public final void m884a(boolean z, boolean z2) {
        m880a(TimelinePhotoEditMode.EDIT_COVER_PHOTO, 9916, z, z2, true);
    }

    public final void m881a() {
        ((SecureContextHelper) this.f840g.get()).a(SimplePickerIntent.a(this.f835b.getContext(), new Builder(SimplePickerSource.COVERPHOTO).h().i().a(Action.NONE)), 124, this.f835b);
    }

    public final void m885b(boolean z, boolean z2) {
        m880a(TimelinePhotoEditMode.EDIT_PROFILE_PIC, 9915, z, z2, false);
    }

    private void m880a(TimelinePhotoEditMode timelinePhotoEditMode, int i, boolean z, boolean z2, boolean z3) {
        boolean z4 = false;
        boolean z5 = (!z2 && this.f842i.a(ExperimentsForTimelineAbTestModule.aI, false)) || this.f842i.a(ExperimentsForTimelineAbTestModule.aD, false);
        Intent b = ((IFeedIntentBuilder) this.f837d.get()).b(this.f835b.getContext(), z5 ? FBLinks.bm : FBLinks.bo);
        b.putExtra("extra_photo_tab_mode_params", new TimelinePhotoTabModeParams(timelinePhotoEditMode, this.f834a));
        b.putExtra("extra_should_merge_camera_roll", z);
        b.putExtra("extra_simple_picker_launcher_configuration", m878a(z3));
        String str = "extra_should_show_suggested_photos";
        boolean z6 = this.f842i.a(ExperimentsForTimelineAbTestModule.aH, false) && !z3 && z && z2;
        b.putExtra(str, z6);
        String str2 = "extra_should_show_suggested_photos_before_camera_roll";
        if (this.f842i.a(ExperimentsForTimelineAbTestModule.aF, false) && !z3 && z) {
            z4 = true;
        }
        b.putExtra(str2, z4);
        if (z5) {
            b.putExtra("title", this.f835b.getContext().getString(2131234990));
            b.putExtra("extra_cancel_button_enabled", true);
        }
        ((SecureContextHelper) this.f840g.get()).a(b, i, this.f835b);
    }

    private static SimplePickerLauncherConfiguration m878a(boolean z) {
        Builder n = new Builder(z ? SimplePickerSource.COVERPHOTO : SimplePickerSource.PROFILEPIC).h().i().k().a(z ? Action.NONE : Action.LAUNCH_PROFILE_PIC_EDIT_GALLERY).n();
        if (!z) {
            n.e().d.o = true;
        }
        return n.r();
    }

    public final void m883a(@Nullable ExpirationState expirationState) {
        Builder h = new Builder(SimplePickerSource.PROFILEPIC).h();
        h.c = expirationState;
        h = h.a(Action.LAUNCH_PROFILE_PIC_EDIT_GALLERY);
        if (this.f836c == 0 || !this.f842i.a(ExperimentsForTimelineAbTestModule.aK, false)) {
            h.i();
        }
        if (this.f836c == 1 && this.f842i.a(ExperimentsForTimelineAbTestModule.aI, false)) {
            h.j();
        }
        ((SecureContextHelper) this.f840g.get()).a(SimplePickerIntent.a(this.f835b.getContext(), h), 125, this.f835b);
    }

    public final void m882a(Bundle bundle) {
        if (bundle.containsKey(EditGalleryIpcBundle.a) && bundle.containsKey("extra_profile_pic_expiration")) {
            if (!bundle.containsKey("profile_photo_method_extra")) {
                this.f844k.a("timeline_logging", "profile_photo_method_not_set");
            } else if (bundle.getString("profile_photo_method_extra") == null) {
                this.f844k.a("timeline_logging", "profile_photo_method_unknown");
            }
            EditGalleryIpcBundle editGalleryIpcBundle = (EditGalleryIpcBundle) bundle.getParcelable(EditGalleryIpcBundle.a);
            String string = bundle.getString("extra_overlay_source_media_id");
            long j = bundle.getLong("extra_profile_pic_expiration");
            String string2 = bundle.getString("extra_profile_pic_caption");
            String string3 = bundle.getString("profile_photo_method_extra");
            CreativeEditingData creativeEditingData = editGalleryIpcBundle.e;
            Object obj = null;
            if ("existing".equals(string3)) {
                int i;
                if (creativeEditingData == null) {
                    i = 1;
                } else if (creativeEditingData.d().isEmpty() && creativeEditingData.e().isEmpty() && creativeEditingData.f().isEmpty() && !creativeEditingData.m() && !creativeEditingData.n()) {
                    i = 1;
                }
            }
            if (obj != null) {
                ((ProfilePicCropHandler) this.f839f.get()).a(editGalleryIpcBundle, j);
            } else {
                m879a(editGalleryIpcBundle, string, j, string2, string3);
            }
        }
    }

    private void m879a(EditGalleryIpcBundle editGalleryIpcBundle, @Nullable String str, long j, @Nullable String str2, String str3) {
        Uri a;
        if (editGalleryIpcBundle.d() == null || editGalleryIpcBundle.d().p() == null) {
            a = editGalleryIpcBundle.a();
        } else {
            a = editGalleryIpcBundle.d().p();
        }
        ((ProfileMediaUploadReceiver) this.f845l.get()).a(a, editGalleryIpcBundle.c());
        ((ProfilePicUploadHandler) this.f838e.get()).a(editGalleryIpcBundle, str, j, str2, str3, (ViewerContext) this.f841h.get());
    }
}
