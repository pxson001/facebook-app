package com.facebook.messaging.momentsinvite.ui;

import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.messaging.momentsinvite.kenburns.KenBurnsSlideShowAnimation;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: item_after_cursor */
public class MomentsInviteImageLoader {
    public static final CallerContext f12334a = CallerContext.a(MomentsInviteImageLoader.class, "thread_view_module");
    public final ImagePipeline f12335b;
    public final Executor f12336c;
    @Nullable
    public MomentsInviteImageLoadingListener f12337d;

    /* compiled from: item_after_cursor */
    public class C13581 extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
        final /* synthetic */ KenBurnsSlideShowAnimation f12331a;
        final /* synthetic */ Uri f12332b;
        final /* synthetic */ MomentsInviteImageLoader f12333c;

        public C13581(MomentsInviteImageLoader momentsInviteImageLoader, KenBurnsSlideShowAnimation kenBurnsSlideShowAnimation, Uri uri) {
            this.f12333c = momentsInviteImageLoader;
            this.f12331a = kenBurnsSlideShowAnimation;
            this.f12332b = uri;
        }

        public final void m12802e(DataSource<CloseableReference<CloseableImage>> dataSource) {
            CloseableReference closeableReference = (CloseableReference) dataSource.d();
            if (closeableReference != null) {
                try {
                    CloseableImage closeableImage = (CloseableImage) closeableReference.a();
                    this.f12331a.m12767a(this.f12332b, closeableImage.f(), closeableImage.g());
                } finally {
                    closeableReference.close();
                }
            }
        }

        public final void m12803f(DataSource dataSource) {
            Throwable e = dataSource.e();
            if (this.f12333c.f12337d != null && this.f12332b != null) {
                this.f12333c.f12337d.mo466a(this.f12332b, e);
            }
        }
    }

    @Inject
    public MomentsInviteImageLoader(ImagePipeline imagePipeline, Executor executor) {
        this.f12335b = imagePipeline;
        this.f12336c = executor;
    }
}
