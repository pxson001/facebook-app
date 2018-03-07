package com.facebook.timeline.profilevideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.widget.Toast;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.content.SecureContextHelper;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.profile.profilevideo.ProfileVideoPreviewLauncher;
import com.facebook.ipc.videoeditgallery.VideoEditGalleryLaunchConfiguration;
import com.facebook.photos.base.media.MediaItemFactory.FallbackMediaId;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.share.model.ComposerAppAttribution;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.profilevideo.logging.ProfileVideoEvent;
import com.facebook.timeline.profilevideo.logging.ProfileVideoSessionTracker;
import com.facebook.timeline.profilevideo.model.ProfileVideoModel;
import com.facebook.timeline.stagingground.StagingGroundIntentFactory;
import com.facebook.timeline.stagingground.StagingGroundLaunchConfig;
import com.facebook.timeline.stagingground.StagingGroundLaunchConfig.Builder;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: mPrompt */
public class ProfileVideoPreviewLauncherImpl implements ProfileVideoPreviewLauncher {
    @Inject
    volatile Provider<IFeedIntentBuilder> f9320a = UltralightRuntime.a;
    @Inject
    volatile Provider<SecureContextHelper> f9321b = UltralightRuntime.a;
    @Inject
    volatile Provider<MediaMetadataRetriever> f9322c = UltralightRuntime.a;
    @Inject
    private ProfileVideoSessionTracker f9323d;
    @Inject
    private QeAccessor f9324e;

    public static ProfileVideoPreviewLauncherImpl m11085b(InjectorLike injectorLike) {
        ProfileVideoPreviewLauncherImpl profileVideoPreviewLauncherImpl = new ProfileVideoPreviewLauncherImpl();
        profileVideoPreviewLauncherImpl.m11082a(IdBasedSingletonScopeProvider.a(injectorLike, 2347), IdBasedSingletonScopeProvider.a(injectorLike, 968), IdBasedProvider.a(injectorLike, 35), ProfileVideoSessionTracker.m11111a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
        return profileVideoPreviewLauncherImpl;
    }

    public static ProfileVideoPreviewLauncherImpl m11077a(InjectorLike injectorLike) {
        return m11085b(injectorLike);
    }

    public final void mo53a(Activity activity, String str, Uri uri, int i, int i2, @Nullable ImageOverlayFieldsModel imageOverlayFieldsModel, @Nullable ComposerAppAttribution composerAppAttribution, long j) {
        int parseInt;
        if (uri == null || uri.getPath() == null) {
            m11086b(activity, str);
            return;
        }
        int parseInt2;
        int parseInt3;
        if (4 == i || 3 == i || 5 == i) {
            this.f9323d.m11114a(ProfileVideoEvent.EXISTING_VIDEO, str);
        } else {
            this.f9323d.m11114a(ProfileVideoEvent.TAKE_VIDEO, str);
        }
        MediaMetadataRetriever mediaMetadataRetriever = (MediaMetadataRetriever) this.f9322c.get();
        try {
            mediaMetadataRetriever.setDataSource(uri.getPath());
            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(18);
            String extractMetadata3 = mediaMetadataRetriever.extractMetadata(19);
            parseInt2 = Integer.parseInt(extractMetadata);
            parseInt3 = Integer.parseInt(extractMetadata2);
            parseInt = Integer.parseInt(extractMetadata3);
            int i3 = parseInt3;
            parseInt3 = parseInt2;
            parseInt2 = i3;
        } catch (IllegalArgumentException e) {
            parseInt = 0;
            parseInt3 = 0;
            parseInt2 = 0;
        }
        if (!m11083a(activity, str, parseInt3)) {
            return;
        }
        if (parseInt3 == 0) {
            m11086b(activity, str);
        } else if (parseInt2 < 180 || r0 < 180) {
            m11081a((Context) activity, str);
        } else {
            ProfileVideoModel a = ProfileVideoModel.m11123a(uri, parseInt3, this.f9324e.a(ExperimentsForTimelineAbTestModule.aR, 7) * 1000, i, imageOverlayFieldsModel, composerAppAttribution);
            if (m11084a(a)) {
                m11079a(activity, str, a, i2, j);
            } else {
                m11078a(activity, str, a, i2);
            }
        }
    }

    private void m11081a(Context context, String str) {
        this.f9323d.m11114a(ProfileVideoEvent.VIDEO_TOO_SMALL, str);
        Toast.makeText(context, context.getString(2131239230, new Object[]{Integer.valueOf(180), Integer.valueOf(180)}), 1).show();
    }

    private void m11086b(Context context, String str) {
        this.f9323d.m11114a(ProfileVideoEvent.INVALID_VIDEO, str);
        Toast.makeText(context, 2131239231, 1).show();
    }

    private static void m11080a(Context context, int i) {
        Toast.makeText(context, context.getString(2131239229, new Object[]{Integer.valueOf(i)}), 1).show();
    }

    private boolean m11083a(Context context, String str, int i) {
        int a = this.f9324e.a(ExperimentsForTimelineAbTestModule.aL, 60);
        if (((long) i) < ((long) a) * 1000) {
            return true;
        }
        this.f9323d.m11115a(str, i);
        m11080a(context, a);
        return false;
    }

    private void m11082a(Provider<IFeedIntentBuilder> provider, Provider<SecureContextHelper> provider2, Provider<MediaMetadataRetriever> provider3, ProfileVideoSessionTracker profileVideoSessionTracker, QeAccessor qeAccessor) {
        this.f9320a = provider;
        this.f9321b = provider2;
        this.f9322c = provider3;
        this.f9323d = profileVideoSessionTracker;
        this.f9324e = qeAccessor;
    }

    private void m11078a(Activity activity, String str, ProfileVideoModel profileVideoModel, int i) {
        SecureContextHelper secureContextHelper = (SecureContextHelper) this.f9321b.get();
        Intent b = ((IFeedIntentBuilder) this.f9320a.get()).b(activity, FBLinks.aW);
        b.putExtra("video_model", profileVideoModel).putExtra("session_id", str);
        secureContextHelper.a(b, i, activity);
    }

    private void m11079a(Activity activity, String str, ProfileVideoModel profileVideoModel, int i, long j) {
        SecureContextHelper secureContextHelper = (SecureContextHelper) this.f9321b.get();
        boolean z = profileVideoModel.m11126c() / 1000 >= this.f9324e.a(ExperimentsForTimelineAbTestModule.aP, Integer.MAX_VALUE);
        int a = this.f9324e.a(ExperimentsForTimelineAbTestModule.aR, 7);
        Builder a2 = new Builder().a(profileVideoModel.m11124a(), Long.toString(FallbackMediaId.REMOTE_MEDIA.getValue()));
        a2.e = str;
        a2 = a2;
        a2.r = true;
        a2 = a2;
        a2.p = true;
        a2 = a2;
        a2.s = true;
        a2 = a2;
        a2.g = 2131239227;
        a2 = a2;
        a2.h = 2131239225;
        a2 = a2;
        a2.o = profileVideoModel.m11129f();
        a2 = a2.a(j);
        a2.v = z;
        StagingGroundLaunchConfig a3 = a2.a();
        VideoEditGalleryLaunchConfiguration.Builder builder = new VideoEditGalleryLaunchConfiguration.Builder();
        builder.b = str;
        builder = builder;
        builder.e = false;
        builder = builder;
        builder.f = false;
        builder = builder;
        builder.g = true;
        builder = builder;
        builder.d = true;
        builder = builder;
        builder.j = a * 1000;
        VideoEditGalleryLaunchConfiguration.Builder builder2 = builder;
        builder2.h = true;
        Intent a4 = StagingGroundIntentFactory.a(activity, a3, builder2.a());
        a4.putExtra("video_model", profileVideoModel);
        secureContextHelper.a(a4, i, activity);
    }

    private boolean m11084a(ProfileVideoModel profileVideoModel) {
        if (this.f9324e.a(ExperimentsForTimelineAbTestModule.aQ, false) || (profileVideoModel != null && profileVideoModel.f9372e != null && profileVideoModel.f9372e.f() != null)) {
            return true;
        }
        return false;
    }
}
