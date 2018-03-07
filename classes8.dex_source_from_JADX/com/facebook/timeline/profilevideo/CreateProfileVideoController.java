package com.facebook.timeline.profilevideo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.heisman.swipeable.ProfilePictureOverlaySwipeableFramesLogController;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.creativecam.CreativeCamCaptureInfo;
import com.facebook.ipc.creativecam.CreativeCamDelegate;
import com.facebook.ipc.creativecam.controller.CreativeCamPickerPreviewController;
import com.facebook.ipc.creativecam.controller.CreativeCamTopBarController;
import com.facebook.ipc.profile.profilevideo.VideoFileSource;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Builder;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.Frame;
import com.facebook.photos.simplepicker.launcher.SimplePickerLauncherActivity;
import com.facebook.qe.api.QeAccessor;
import com.facebook.resources.ui.FbButton;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.profilevideo.logging.ProfileVideoEvent;
import com.facebook.timeline.profilevideo.logging.ProfileVideoSessionTracker;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@TargetApi(10)
/* compiled from: mReadableCardType */
public class CreateProfileVideoController implements CreativeCamDelegate, CreativeCamPickerPreviewController {
    private static final CallerContext f9274c = CallerContext.a(CreateProfileVideoController.class, "create_profile_video_android");
    public Provider<SecureContextHelper> f9275a;
    Provider<MediaMetadataRetriever> f9276b;
    public String f9277d;
    public Activity f9278e;
    private Uri f9279f;
    public final ProfileVideoSessionTracker f9280g;
    private ProfileVideoPreviewLauncherImpl f9281h;
    private final QeAccessor f9282i;
    private final Lazy<PackageManager> f9283j;
    public LinearLayout f9284k;

    /* compiled from: mReadableCardType */
    class C09621 implements OnClickListener {
        final /* synthetic */ CreateProfileVideoController f9271a;

        C09621(CreateProfileVideoController createProfileVideoController) {
            this.f9271a = createProfileVideoController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1986462564);
            this.f9271a.f9280g.m11114a(ProfileVideoEvent.DEEP_LINK_BUTTON_CLICKED, this.f9271a.f9277d);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setPackage("com.instagram.boomerang");
            ((SecureContextHelper) this.f9271a.f9275a.get()).b(intent, 5, this.f9271a.f9278e);
            Logger.a(2, EntryType.UI_INPUT_END, 1222464266, a);
        }
    }

    /* compiled from: mReadableCardType */
    class C09632 implements OnClickListener {
        final /* synthetic */ CreateProfileVideoController f9272a;

        C09632(CreateProfileVideoController createProfileVideoController) {
            this.f9272a = createProfileVideoController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1999634367);
            this.f9272a.f9280g.m11114a(ProfileVideoEvent.DEEP_LINK_BUTTON_CLICKED, this.f9272a.f9277d);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setPackage("me.msqrd.android");
            ((SecureContextHelper) this.f9272a.f9275a.get()).b(intent, 6, this.f9272a.f9278e);
            Logger.a(2, EntryType.UI_INPUT_END, 1914678656, a);
        }
    }

    /* compiled from: mReadableCardType */
    class C09643 implements OnClickListener {
        final /* synthetic */ CreateProfileVideoController f9273a;

        C09643(CreateProfileVideoController createProfileVideoController) {
            this.f9273a = createProfileVideoController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2120741177);
            CreateProfileVideoController createProfileVideoController = this.f9273a;
            createProfileVideoController.f9280g.m11114a(ProfileVideoEvent.OPEN_GALLERY, createProfileVideoController.f9277d);
            Intent intent = new Intent(createProfileVideoController.f9278e.getApplicationContext(), SimplePickerLauncherActivity.class);
            intent.putExtra("extra_simple_picker_launcher_settings", new Builder(SimplePickerSource.PROFILEPIC).j().h().a(Action.NONE).r());
            ((SecureContextHelper) createProfileVideoController.f9275a.get()).a(intent, 2, createProfileVideoController.f9278e);
            Logger.a(2, EntryType.UI_INPUT_END, -891614261, a);
        }
    }

    @Inject
    public CreateProfileVideoController(@Assisted Activity activity, @Assisted String str, @Assisted Uri uri, Provider<SecureContextHelper> provider, Provider<MediaMetadataRetriever> provider2, ProfileVideoSessionTracker profileVideoSessionTracker, ProfileVideoPreviewLauncherImpl profileVideoPreviewLauncherImpl, QeAccessor qeAccessor, Lazy<PackageManager> lazy) {
        this.f9278e = activity;
        this.f9277d = str;
        this.f9279f = uri;
        this.f9275a = provider;
        this.f9276b = provider2;
        this.f9280g = profileVideoSessionTracker;
        this.f9281h = profileVideoPreviewLauncherImpl;
        this.f9282i = qeAccessor;
        this.f9283j = lazy;
    }

    public final void m11038a(Uri uri, CreativeCamCaptureInfo creativeCamCaptureInfo) {
    }

    public final void m11043b(Uri uri, CreativeCamCaptureInfo creativeCamCaptureInfo) {
        this.f9281h.mo53a(this.f9278e, this.f9277d, uri, VideoFileSource.m1393a(creativeCamCaptureInfo.a), 1, null, null, 0);
    }

    @Nullable
    public final ListenableFuture<ImmutableList<Frame>> m11036a() {
        return null;
    }

    public final CreativeCamPickerPreviewController m11042b() {
        return this;
    }

    public final CreativeCamTopBarController m11044c() {
        return null;
    }

    public final ProfilePictureOverlaySwipeableFramesLogController m11045d() {
        return null;
    }

    public final void m11037a(int i) {
        if (i != 0) {
            if (this.f9284k != null) {
                this.f9284k.setVisibility(0);
            }
        } else if (this.f9284k != null) {
            this.f9284k.setVisibility(8);
        }
    }

    public final void m11039a(ViewStub viewStub) {
        boolean h = m11034h();
        boolean i = m11035i();
        if ((h || i) && this.f9282i.a(ExperimentsForTimelineAbTestModule.aJ, false)) {
            viewStub.setLayoutResource(2130903868);
            this.f9284k = (LinearLayout) viewStub.inflate();
            FbButton fbButton = (FbButton) this.f9284k.findViewById(2131560932);
            if (h) {
                fbButton.setOnClickListener(new C09621(this));
                fbButton.setVisibility(0);
            }
            fbButton = (FbButton) this.f9284k.findViewById(2131560933);
            if (i) {
                fbButton.setOnClickListener(new C09632(this));
                fbButton.setVisibility(0);
            }
        }
    }

    private boolean m11034h() {
        try {
            PackageInfo packageInfo = ((PackageManager) this.f9283j.get()).getPackageInfo("com.instagram.boomerang", 0);
            if (!(packageInfo.versionName.equals("1.0.0") || packageInfo.versionName.equals("1.0.1") || packageInfo.versionName.equals("1.1.0") || packageInfo.versionName.equals("1.1.1"))) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    private boolean m11035i() {
        try {
            return ((PackageManager) this.f9283j.get()).getPackageInfo("me.msqrd.android", 0).versionCode >= 31;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public final void m11040a(FbDraweeView fbDraweeView, int i) {
        if (this.f9279f != null) {
            fbDraweeView.setVisibility(0);
            fbDraweeView.a(this.f9279f, f9274c);
            fbDraweeView.setOnClickListener(new C09643(this));
            return;
        }
        fbDraweeView.setVisibility(4);
    }

    public final boolean m11041a(String str, int i) {
        return false;
    }
}
