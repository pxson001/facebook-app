package com.facebook.photos.creativeediting.stickers.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.bitmaps.Dimension;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.SizeUtil;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.photos.base.media.MediaItemFactory.FallbackMediaId;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.creativeediting.model.CreativeEditingData.Builder;
import com.facebook.photos.creativeediting.model.StickerParams;
import com.facebook.photos.creativeediting.stickers.ui.StickerEditFragment.EventListener;
import com.facebook.photos.creativeediting.stickers.ui.StickerEditFragment.FileEditingListener;
import com.facebook.photos.creativeediting.utilities.CreativeEditingImageHelper;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mMetadata */
public class StickerEditActivity extends FbFragmentActivity implements AnalyticsActivity {
    @Inject
    ComposerConfigurationFactory f9681p;
    @Inject
    BitmapUtils f9682q;
    @Inject
    ComposerLauncher f9683r;
    @Inject
    Lazy<TasksManager> f9684s;
    @Inject
    Lazy<CreativeEditingImageHelper> f9685t;
    @Inject
    Lazy<MediaItemFactory> f9686u;
    private String f9687v;
    private MediaItem f9688w;

    /* compiled from: mMetadata */
    class PromotionEditFinishEventListener implements EventListener {
        final /* synthetic */ StickerEditActivity f9678a;

        public PromotionEditFinishEventListener(StickerEditActivity stickerEditActivity) {
            this.f9678a = stickerEditActivity;
        }

        public final void mo506a(ImmutableList<StickerParams> immutableList, boolean z, FileEditingListener fileEditingListener) {
            if (z) {
                this.f9678a.m11616a((ImmutableList) immutableList);
                this.f9678a.finish();
                return;
            }
            this.f9678a.finish();
        }
    }

    /* compiled from: mMetadata */
    class StickerOffEditFinishEventListener implements EventListener {
        final /* synthetic */ StickerEditActivity f9679a;
        private final Uri f9680b;

        public StickerOffEditFinishEventListener(StickerEditActivity stickerEditActivity, Uri uri) {
            this.f9679a = stickerEditActivity;
            this.f9680b = uri;
        }

        public final void mo506a(ImmutableList<StickerParams> immutableList, boolean z, FileEditingListener fileEditingListener) {
            if (z) {
                this.f9679a.m11611a(this.f9680b, fileEditingListener, immutableList);
            } else {
                this.f9679a.finish();
            }
        }
    }

    private static <T extends Context> void m11617a(Class<T> cls, T t) {
        m11618a((Object) t, (Context) t);
    }

    public static void m11618a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((StickerEditActivity) obj).m11612a(ComposerConfigurationFactory.b(fbInjector), BitmapUtils.a(fbInjector), (ComposerLauncher) ComposerLauncherImpl.a(fbInjector), IdBasedLazy.a(fbInjector, 3561), IdBasedLazy.a(fbInjector, 9299), IdBasedLazy.a(fbInjector, 2963));
    }

    protected final void m11619b(@Nullable Bundle bundle) {
        Class cls = StickerEditActivity.class;
        m11618a((Object) this, (Context) this);
        super.b(bundle);
        this.f9687v = getIntent().getStringExtra("composer_session_id");
        this.f9688w = (MediaItem) getIntent().getParcelableExtra("input_image_path_extra");
        if (this.f9688w == null) {
            Uri parse = Uri.parse(getIntent().getStringExtra("stickeroff_input_fb_url"));
            StickerEditFragment.m11630a(this.f9687v, kO_(), parse, getIntent().getIntExtra("stickeroff_input_width", 0), getIntent().getIntExtra("stickeroff_input_height", 0), null, new StickerOffEditFinishEventListener(this, parse), null, this.f9687v, null);
            return;
        }
        int round;
        int a = SizeUtil.a(this, 220.0f);
        if ((this.f9688w instanceof PhotoItem) && this.f9688w.m() == MediaType.PHOTO) {
            round = Math.round(((float) a) / m11609a(this.f9688w));
        } else {
            round = a;
        }
        StickerEditFragment.m11630a(this.f9687v, kO_(), this.f9688w.f(), a, round, null, new PromotionEditFinishEventListener(this), null, this.f9688w.d().toString(), null);
    }

    private void m11612a(ComposerConfigurationFactory composerConfigurationFactory, BitmapUtils bitmapUtils, ComposerLauncher composerLauncher, Lazy<TasksManager> lazy, Lazy<CreativeEditingImageHelper> lazy2, Lazy<MediaItemFactory> lazy3) {
        this.f9681p = composerConfigurationFactory;
        this.f9682q = bitmapUtils;
        this.f9683r = composerLauncher;
        this.f9684s = lazy;
        this.f9685t = lazy2;
        this.f9686u = lazy3;
    }

    private void m11616a(ImmutableList<StickerParams> immutableList) {
        CreativeEditingData creativeEditingData = null;
        if (!(immutableList == null || immutableList.isEmpty())) {
            Builder builder = new Builder();
            builder.f = immutableList;
            creativeEditingData = builder.a();
        }
        ComposerAttachment.Builder a = ComposerAttachment.Builder.a(this.f9688w);
        a.e = creativeEditingData;
        this.f9683r.a(this.f9687v, ComposerConfigurationFactory.a(ComposerSourceType.STICKER_MEDIA_GALLERY_PROMOTION).setInitialAttachments(ImmutableList.of(Preconditions.checkNotNull(a.a()))).a(), this);
    }

    private void m11611a(final Uri uri, final FileEditingListener fileEditingListener, ImmutableList<StickerParams> immutableList) {
        if (immutableList == null || immutableList.isEmpty()) {
            fileEditingListener.m11624a();
            finish();
            return;
        }
        Builder builder = new Builder();
        builder.f = immutableList;
        final CreativeEditingData a = builder.a();
        ((TasksManager) this.f9684s.get()).a("SavingStickeredPhoto_" + uri, new Callable<ListenableFuture<Uri>>(this) {
            final /* synthetic */ StickerEditActivity f9675c;

            public Object call() {
                return ((CreativeEditingImageHelper) this.f9675c.f9685t.get()).a(0.5f, a, uri, false);
            }
        }, new AbstractDisposableFutureCallback<Uri>(this) {
            final /* synthetic */ StickerEditActivity f9677b;

            protected final void m11604a(Object obj) {
                this.f9677b.m11610a((Uri) obj);
                fileEditingListener.m11624a();
                this.f9677b.finish();
            }

            protected final void m11605a(Throwable th) {
                fileEditingListener.m11624a();
                this.f9677b.finish();
            }
        });
    }

    private void m11610a(Uri uri) {
        MediaItem a = ((MediaItemFactory) this.f9686u.get()).a(uri, FallbackMediaId.REMOTE_MEDIA);
        Intent intent = new Intent();
        intent.putExtra("stickered_media_item", a);
        setResult(-1, intent);
    }

    public final String am_() {
        return "stickers_in_composer";
    }

    private float m11609a(MediaItem mediaItem) {
        Dimension a = BitmapUtils.a(mediaItem.e());
        if (a == null) {
            return 1.0f;
        }
        int g = mediaItem.g();
        if (g == -1 && mediaItem.l() == MediaType.PHOTO) {
            g = BitmapUtils.b(mediaItem.e());
        }
        float f = mediaItem.l() == MediaType.PHOTO ? ((float) a.b) / ((float) a.a) : 1.3333334f;
        if (g == 90 || g == 270) {
            return 1.0f / f;
        }
        return f;
    }
}
