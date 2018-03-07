package com.facebook.messaging.media.imageurirequest;

import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.imageurirequest.graphql.DownloadImageFragmentModels.DownloadImageFragmentModel;
import com.facebook.messaging.media.imageurirequest.graphql.DownloadImageFragmentModels.DownloadImageFragmentModel.AnimatedGifModel;
import com.facebook.messaging.media.imageurirequest.graphql.DownloadImageFragmentModels.DownloadImageFragmentModel.ImageModel;
import com.google.common.base.Throwables;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: pymi_invite */
public class ImageUriRequestManager {
    @Inject
    public DefaultAndroidThreadUtil f3996a;
    private final AbstractSingleMethodRunner f3997b;
    private final FetchImageInfoGraphQlMethod f3998c;

    public static ImageUriRequestManager m4490b(InjectorLike injectorLike) {
        ImageUriRequestManager imageUriRequestManager = new ImageUriRequestManager((AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), FetchImageInfoGraphQlMethod.m4493b(injectorLike));
        imageUriRequestManager.f3996a = DefaultAndroidThreadUtil.b(injectorLike);
        return imageUriRequestManager;
    }

    @Inject
    public ImageUriRequestManager(AbstractSingleMethodRunner abstractSingleMethodRunner, FetchImageInfoGraphQlMethod fetchImageInfoGraphQlMethod) {
        this.f3997b = abstractSingleMethodRunner;
        this.f3998c = fetchImageInfoGraphQlMethod;
    }

    @Nullable
    public final Uri m4491a(String str, int i, CallerContext callerContext) {
        Uri uri = null;
        this.f3996a.b();
        try {
            DownloadImageFragmentModel downloadImageFragmentModel = (DownloadImageFragmentModel) this.f3997b.a(this.f3998c, new FetchImageParams(str, i), CallerContext.a(ImageUriRequestManager.class, "download_image_info", callerContext == null ? null : callerContext.b()));
            AnimatedGifModel a = downloadImageFragmentModel.a();
            if (a != null) {
                uri = Uri.parse(a.a());
            } else {
                ImageModel b = downloadImageFragmentModel.b();
                if (b != null) {
                    uri = Uri.parse(b.a());
                }
            }
            return uri;
        } catch (Throwable e) {
            Throwables.propagateIfPossible(e, IOException.class);
            throw new IOException(e);
        }
    }
}
