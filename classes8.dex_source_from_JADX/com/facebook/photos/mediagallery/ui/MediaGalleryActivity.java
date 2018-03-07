package com.facebook.photos.mediagallery.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbui.draggable.Direction;
import com.facebook.inject.FbInjector;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.dialog.PhotoAnimationDialogFragment;
import com.facebook.photos.dialog.PhotoAnimationDialogLaunchParams;
import com.facebook.photos.dialog.util.PhotosDialogPerfUtil;
import com.facebook.photos.mediafetcher.MediaFetcherFactory;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams.Builder;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: social_good */
public class MediaGalleryActivity extends FbFragmentActivity implements AnalyticsActivity {
    private static final CallerContext f2355t = CallerContext.a(MediaGalleryActivity.class, "photo_viewer");
    @Inject
    MediaFetcherFactory f2356p;
    @Inject
    PhotosDialogPerfUtil f2357q;
    @Inject
    MediaGalleryLauncherParamsFactory f2358r;
    @Inject
    QeAccessor f2359s;

    /* compiled from: social_good */
    class C02791 implements OnDismissListener {
        final /* synthetic */ MediaGalleryActivity f2354a;

        C02791(MediaGalleryActivity mediaGalleryActivity) {
            this.f2354a = mediaGalleryActivity;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            this.f2354a.finish();
        }
    }

    private static <T extends Context> void m2467a(Class<T> cls, T t) {
        m2468a((Object) t, (Context) t);
    }

    public static void m2468a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((MediaGalleryActivity) obj).m2466a(MediaFetcherFactory.b(fbInjector), PhotosDialogPerfUtil.a(fbInjector), MediaGalleryLauncherParamsFactory.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
    }

    private void m2466a(MediaFetcherFactory mediaFetcherFactory, PhotosDialogPerfUtil photosDialogPerfUtil, MediaGalleryLauncherParamsFactory mediaGalleryLauncherParamsFactory, QeAccessor qeAccessor) {
        this.f2356p = mediaFetcherFactory;
        this.f2357q = photosDialogPerfUtil;
        this.f2358r = mediaGalleryLauncherParamsFactory;
        this.f2359s = qeAccessor;
    }

    protected final void m2469a(Bundle bundle) {
        super.a(bundle);
        overridePendingTransition(2130968664, 0);
    }

    protected final void m2470b(Bundle bundle) {
        Builder f;
        int i = 0;
        Preconditions.checkNotNull(getIntent().getExtras());
        super.b(bundle);
        Class cls = MediaGalleryActivity.class;
        m2468a((Object) this, (Context) this);
        setContentView(2130905166);
        String valueOf = String.valueOf(getIntent().getExtras().getLong("photo_fbid"));
        String string = getIntent().getExtras().getString("photoset_token");
        boolean z = getIntent().getExtras().getBoolean("extra_show_attribution", false);
        FullscreenGallerySource valueOf2 = getIntent().hasExtra("fullscreen_gallery_source") ? FullscreenGallerySource.valueOf(getIntent().getStringExtra("fullscreen_gallery_source")) : FullscreenGallerySource.INTENT;
        if (Strings.isNullOrEmpty(string)) {
            ImmutableList b;
            long[] longArray = getIntent().getExtras().getLongArray("extra_photo_set_fb_id_array");
            if (longArray != null) {
                ImmutableList.Builder builder = new ImmutableList.Builder();
                while (i < longArray.length) {
                    builder.c(String.valueOf(longArray[i]));
                    i++;
                }
                b = builder.b();
            } else {
                b = ImmutableList.of(valueOf);
            }
            f = MediaGalleryLauncherParamsFactory.f(b);
        } else {
            f = MediaGalleryLauncherParamsFactory.b(string);
        }
        f = f.a(valueOf);
        f.m = z;
        MediaGalleryLauncherParams b2 = f.a(valueOf2).b();
        if (((PhotoAnimationDialogFragment) kO_().a(valueOf)) == null) {
            MediaGalleryFragment a = MediaGalleryFragment.m2505a(b2, this.f2356p, this.f2357q, f2355t, this.f2359s);
            OnDismissListener c02791 = new C02791(this);
            PhotoAnimationDialogLaunchParams.Builder a2 = new PhotoAnimationDialogLaunchParams.Builder(b2).a(Direction.UP);
            a2.f = Direction.UP.flag() | Direction.DOWN.flag();
            a2 = a2;
            a2.g = -16777216;
            if (!PhotoAnimationDialogFragment.a(this, a, a2.a(), null, c02791)) {
                finish();
            }
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 2130968665);
    }

    public final String am_() {
        return f2355t.c();
    }

    public final void m2471i() {
        PhotoAnimationDialogFragment photoAnimationDialogFragment = (PhotoAnimationDialogFragment) kO_().a(2131559222);
        Preconditions.checkNotNull(photoAnimationDialogFragment);
        photoAnimationDialogFragment.a(null);
    }
}
