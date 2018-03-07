package com.facebook.richdocument.utils;

import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.video.server.VideoPrefetchModelMethodAutoProvider;
import com.facebook.video.server.VideoResourceMetadata;
import com.facebook.video.server.prefetcher.VideoPrefetchList;
import com.facebook.video.server.prefetcher.VideoPrefetchLocation;
import com.facebook.video.server.prefetcher.VideoPrefetchModel;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: fetch_thread_by_participants */
public class PrefetchUtils {
    private VideoPrefetchList f23874a;
    private final ImagePipeline f23875b;
    private final VideoPrefetchModel f23876c;
    private final Map<String, VideoResourceMetadata> f23877d = new HashMap();

    public static PrefetchUtils m32264b(InjectorLike injectorLike) {
        return new PrefetchUtils(ImagePipelineMethodAutoProvider.m15546a(injectorLike), VideoPrefetchModelMethodAutoProvider.m14810a(injectorLike));
    }

    @Inject
    public PrefetchUtils(ImagePipeline imagePipeline, VideoPrefetchModel videoPrefetchModel) {
        this.f23875b = imagePipeline;
        this.f23876c = videoPrefetchModel;
    }

    public final DataSource m32265a(@Nullable String str) {
        if (StringUtil.m3589a((CharSequence) str)) {
            return null;
        }
        DataSource d = this.f23875b.m16074d(ImageRequest.m18796a(str), CallerContext.m9060a(PrefetchUtils.class));
        d.mo2783a(new ClosingDataSubscriber(), MoreExecutors.m1813a());
        return d;
    }

    public final void m32266b(String str) {
        this.f23874a = this.f23876c.m14816a(VideoPrefetchLocation.INSTANT_ARTICLE);
        if (!StringUtil.m3589a((CharSequence) str)) {
            this.f23877d.put(str, new VideoResourceMetadata(Uri.parse(str)));
            this.f23874a.mo2175a(r0);
        }
        this.f23874a.mo2174a(true);
    }

    public final void m32267c(String str) {
        if (!StringUtil.m3589a((CharSequence) str) && this.f23877d.containsKey(str)) {
            VideoResourceMetadata videoResourceMetadata = (VideoResourceMetadata) this.f23877d.remove(str);
            this.f23874a.mo2179c(videoResourceMetadata);
        }
    }
}
