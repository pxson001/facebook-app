package com.facebook.messaging.media.imagepipelinewrapper;

import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ForNonUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider;
import com.facebook.common.futures.DataSourceToFutureAdapter;
import com.facebook.common.idleexecutor.IdleExecutorFactory;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.connectivity.ConnectionStatusMonitor;
import com.facebook.messaging.connectivity.ConnectionStatusMonitor.ConnectionType;
import com.facebook.messaging.connectivity.ConnectionStatusMonitorMethodAutoProvider;
import com.facebook.messaging.media.imageurirequest.ImageUriRequestManager;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import junit.framework.Assert;

@Singleton
/* compiled from: pymk_search_cache_tag */
public class ImagePipelineWrapper {
    private static volatile ImagePipelineWrapper f3980n;
    @Inject
    public DefaultAndroidThreadUtil f3981a;
    @Inject
    public FbNetworkManager f3982b;
    @ForNonUiThread
    @Inject
    public ExecutorService f3983c;
    private final ImagePipeline f3984d;
    public final Executor f3985e;
    public final Executor f3986f;
    public final ImagePipelineWrapperEventLogger f3987g;
    private final ImageUriRequestManager f3988h;
    private final Cache<Uri, Uri> f3989i = CacheBuilder.newBuilder().a(7, TimeUnit.DAYS).q();
    public final Cache<DataSource<CloseableReference<CloseableImage>>, Map<String, String>> f3990j = CacheBuilder.newBuilder().a(5, TimeUnit.MINUTES).q();
    public final GatekeeperStoreImpl f3991k;
    public final ConnectionStatusMonitor f3992l;
    private final AbstractFbErrorReporter f3993m;

    public static com.facebook.messaging.media.imagepipelinewrapper.ImagePipelineWrapper m4472a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f3980n;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.media.imagepipelinewrapper.ImagePipelineWrapper.class;
        monitor-enter(r1);
        r0 = f3980n;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m4476b(r0);	 Catch:{ all -> 0x0035 }
        f3980n = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3980n;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.imagepipelinewrapper.ImagePipelineWrapper.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.imagepipelinewrapper.ImagePipelineWrapper");
    }

    private static ImagePipelineWrapper m4476b(InjectorLike injectorLike) {
        ImagePipelineWrapper imagePipelineWrapper = new ImagePipelineWrapper(ImagePipelineMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider.a(injectorLike), ImagePipelineWrapperEventLogger.m4485a(injectorLike), ImageUriRequestManager.m4490b(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), ConnectionStatusMonitorMethodAutoProvider.m8744a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdleExecutorFactory.a(injectorLike));
        FbNetworkManager a = FbNetworkManager.a(injectorLike);
        ExecutorService executorService = (ExecutorService) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(injectorLike);
        imagePipelineWrapper.f3981a = DefaultAndroidThreadUtil.b(injectorLike);
        imagePipelineWrapper.f3982b = a;
        imagePipelineWrapper.f3983c = executorService;
        return imagePipelineWrapper;
    }

    @Inject
    public ImagePipelineWrapper(ImagePipeline imagePipeline, Executor executor, ImagePipelineWrapperEventLogger imagePipelineWrapperEventLogger, ImageUriRequestManager imageUriRequestManager, GatekeeperStoreImpl gatekeeperStoreImpl, ConnectionStatusMonitor connectionStatusMonitor, AbstractFbErrorReporter abstractFbErrorReporter, IdleExecutorFactory idleExecutorFactory) {
        this.f3984d = imagePipeline;
        this.f3985e = executor;
        this.f3987g = imagePipelineWrapperEventLogger;
        this.f3988h = imageUriRequestManager;
        this.f3991k = gatekeeperStoreImpl;
        this.f3992l = connectionStatusMonitor;
        this.f3993m = abstractFbErrorReporter;
        this.f3986f = idleExecutorFactory.a((ExecutorService) executor);
    }

    private ImageRequest m4471a(ImageRequestBuilder imageRequestBuilder, Map<String, String> map, Uri uri, CallerContext callerContext) {
        if (FacebookUriUtil.f(uri)) {
            if (!m4477b()) {
                imageRequestBuilder.b = RequestLevel.DISK_CACHE;
            }
            Uri a = m4469a(uri, callerContext, imageRequestBuilder.d, (Map) map);
            if (a != null) {
                imageRequestBuilder.b(a);
            }
            return imageRequestBuilder.m();
        }
        if (map != null) {
            map.put("local_file_ratio", "1");
        }
        return imageRequestBuilder.m();
    }

    private boolean m4473a(Uri uri) {
        if (this.f3984d.b(uri)) {
            return true;
        }
        return m4478b(uri);
    }

    private boolean m4478b(Uri uri) {
        try {
            return ((Boolean) FutureDetour.a(DataSourceToFutureAdapter.m7803a(this.f3984d.c(uri)), 150, TimeUnit.MILLISECONDS, 1267343302)).booleanValue();
        } catch (TimeoutException e) {
            return false;
        } catch (ExecutionException e2) {
            return false;
        } catch (InterruptedException e3) {
            return false;
        }
    }

    private Uri m4469a(Uri uri, @Nullable CallerContext callerContext, @Nullable ResizeOptions resizeOptions, @Nullable Map<String, String> map) {
        if ((this.f3984d.b(uri) && this.f3991k.a(347, false)) || !FacebookUriUtil.f(uri) || !FacebookUriUtil.k(uri)) {
            return uri;
        }
        if (this.f3991k.a(347, false) && m4478b(uri)) {
            return uri;
        }
        Uri i = FacebookUriUtil.i(uri);
        Uri uri2 = (Uri) this.f3989i.a(i);
        if (uri2 != null) {
            if (FacebookUriUtil.k(uri2) && this.f3991k.a(179, false)) {
                if (map != null) {
                    map.put("total_cache_uri_expired_num", "0");
                }
                if (this.f3991k.a(347, false) && m4473a(uri2)) {
                    return uri2;
                }
                this.f3989i.b(i);
            } else {
                if (map != null) {
                    map.put("uri_cache_hit_ratio", "1");
                }
                return uri2;
            }
        }
        String str = null;
        if (!(uri == null || !FacebookUriUtil.m(uri) || uri.getLastPathSegment() == null)) {
            String[] split = uri.getLastPathSegment().split("_");
            if (split.length == 6) {
                str = split[2];
            } else if (split.length == 4) {
                str = split[1];
            }
        }
        String str2 = str;
        if (StringUtil.a(new CharSequence[]{str2})) {
            throw new Throwable("Image CDN Uri has expired and FbId not found within Uri: " + uri.toString());
        } else if (!m4477b()) {
            return null;
        } else {
            int i2;
            ImageUriRequestManager imageUriRequestManager = this.f3988h;
            if (resizeOptions == null) {
                i2 = 0;
            } else {
                i2 = Math.max(resizeOptions.f5739a, resizeOptions.f5740b);
            }
            uri2 = imageUriRequestManager.m4491a(str2, i2, callerContext);
            if (uri2 == null) {
                throw new Throwable("CDN Uri expired but could not retrieve new uri to replace expiring cdn uri. FBID = " + str2 + " , original Uri = " + uri.toString());
            }
            this.f3989i.a(i, uri2);
            if (map != null) {
                map.put("fetch_new_uri_success_ratio", "1");
            }
            return uri2;
        }
    }

    private boolean m4477b() {
        if (!this.f3991k.a(193, false)) {
            return this.f3992l.mo685a(ConnectionType.HTTP);
        }
        if (this.f3982b.d() && this.f3992l.mo685a(ConnectionType.HTTP)) {
            return true;
        }
        return false;
    }

    public final DataSource<CloseableReference<PooledByteBuffer>> m4479a(ImageRequestBuilder imageRequestBuilder, CallerContext callerContext) {
        if (!this.f3991k.a(240, false)) {
            return this.f3984d.d(imageRequestBuilder.m(), callerContext);
        }
        Uri a = imageRequestBuilder.a();
        Assert.assertNotNull(a);
        try {
            return this.f3984d.d(m4471a(imageRequestBuilder, new HashMap(), a, callerContext), callerContext);
        } catch (Throwable th) {
            BLog.b("ImagePipelineWrapper", th, "Fetching new encoded image failed for original Uri: %s", new Object[]{a.toString()});
            return DataSources.a(th);
        }
    }

    public final DataSource<CloseableReference<CloseableImage>> m4484b(ImageRequestBuilder imageRequestBuilder, CallerContext callerContext) {
        if (!this.f3991k.a(240, false)) {
            return this.f3984d.c(imageRequestBuilder.m(), callerContext);
        }
        int i;
        DataSource<CloseableReference<CloseableImage>> c;
        Map a = ImagePipelineWrapperEventLogger.m4486a(callerContext);
        Uri a2 = imageRequestBuilder.a();
        Assert.assertNotNull(a2);
        a.put("client_cdn_expired_ratio", String.valueOf(FacebookUriUtil.k(a2) ? 1 : 0));
        String str = "is_network_available";
        if (this.f3992l.mo685a(ConnectionType.HTTP)) {
            i = 1;
        } else {
            i = 0;
        }
        a.put(str, String.valueOf(i));
        try {
            c = this.f3984d.c(m4471a(imageRequestBuilder, a, a2, callerContext), callerContext);
        } catch (Throwable th) {
            a.put("fetch_new_uri_success_ratio", "0");
            BLog.b("ImagePipelineWrapper", th, "Fetching new decoded image failed for original Uri: %s", new Object[]{a2.toString()});
            c = DataSources.a(th);
        }
        this.f3990j.a(c, a);
        return c;
    }

    public final void m4482a(DataSource<CloseableReference<CloseableImage>> dataSource, final ImagePipelineWrapperListener imagePipelineWrapperListener) {
        final Map map = (Map) this.f3990j.a(dataSource);
        dataSource.a(new BaseDataSubscriber<CloseableReference<CloseableImage>>(this) {
            final /* synthetic */ ImagePipelineWrapper f5758c;

            public final void m6246e(DataSource<CloseableReference<CloseableImage>> dataSource) {
                this.f5758c.f3987g.m4488a(map);
                imagePipelineWrapperListener.mo537a(dataSource);
                this.f5758c.f3990j.b(dataSource);
            }

            public final void m6247f(DataSource<CloseableReference<CloseableImage>> dataSource) {
                this.f5758c.f3987g.m4489a(map, dataSource.e());
                imagePipelineWrapperListener.mo536a();
                this.f5758c.f3990j.b(dataSource);
            }
        }, this.f3985e);
    }

    public final ImageRequest m4481a(ImageRequest imageRequest, CallerContext callerContext) {
        return m4470a(imageRequest, ImagePipelineWrapperEventLogger.m4486a(callerContext), callerContext);
    }

    private ImageRequest m4470a(ImageRequest imageRequest, Map<String, String> map, CallerContext callerContext) {
        if (imageRequest == null) {
            return imageRequest;
        }
        ImageRequest imageRequest2 = null;
        try {
            imageRequest2 = m4471a(ImageRequestBuilder.a(imageRequest), (Map) map, imageRequest.b(), callerContext);
        } catch (Throwable th) {
            BLog.b("ImagePipelineWrapper", th, "Updating expired image request failed for original Uri: %s", new Object[]{r2.toString()});
        }
        return imageRequest2;
    }

    private ImageRequest[] m4474a(ImageRequest[] imageRequestArr, Map<String, String> map, CallerContext callerContext) {
        List arrayList = new ArrayList();
        int i = 0;
        for (ImageRequest imageRequest : imageRequestArr) {
            if (imageRequest != null) {
                Uri b = imageRequest.b();
                if (FacebookUriUtil.k(b)) {
                    i++;
                }
                try {
                    arrayList.add(m4471a(ImageRequestBuilder.a(imageRequest), (Map) map, b, callerContext));
                } catch (Throwable th) {
                    BLog.b("ImagePipelineWrapper", th, "Fetching new decoded image failed for original Uri: %s", new Object[]{b.toString()});
                }
            }
        }
        map.put("total_first_available_uri_num", String.valueOf(imageRequestArr.length));
        map.put("total_first_available_expired_uri_num", String.valueOf(i));
        return arrayList.isEmpty() ? null : (ImageRequest[]) arrayList.toArray(new ImageRequest[arrayList.size()]);
    }

    private ImageRequest m4475b(ImageRequest imageRequest, Map<String, String> map, CallerContext callerContext) {
        Uri b = imageRequest.b();
        map.put("low_res_image_client_cdn_uri_expired_ratio", String.valueOf(FacebookUriUtil.k(b) ? 1 : 0));
        try {
            return m4471a(ImageRequestBuilder.a(imageRequest), (Map) map, b, callerContext);
        } catch (Throwable th) {
            map.put("fetch_new_uri_success_ratio", "0");
            BLog.b("ImagePipelineWrapper", th, "Fetching new decoded image failed for original Uri: %s", new Object[]{b.toString()});
            return null;
        }
    }

    public final boolean m4483a() {
        return this.f3991k.a(206, false);
    }

    public final FbDraweeControllerBuilder m4480a(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        int i = 0;
        if (this.f3991k.a(206, false)) {
            if (this.f3981a.c()) {
                BLog.c("ImagePipelineWrapper", "Running getDraweeControllerBuilder which can potentially do http request on main/ui thread");
            }
            Map a = ImagePipelineWrapperEventLogger.m4486a(fbDraweeControllerBuilder.q());
            String str = "is_network_available";
            if (this.f3992l.mo685a(ConnectionType.HTTP)) {
                i = 1;
            }
            a.put(str, String.valueOf(i));
            ImageRequest[] imageRequestArr = (ImageRequest[]) fbDraweeControllerBuilder.h;
            if (imageRequestArr != null && imageRequestArr.length != 0) {
                fbDraweeControllerBuilder.a(m4474a(imageRequestArr, a, fbDraweeControllerBuilder.q()));
            } else if (fbDraweeControllerBuilder.f != null) {
                fbDraweeControllerBuilder.c(m4470a((ImageRequest) fbDraweeControllerBuilder.f, a, fbDraweeControllerBuilder.q()));
            }
            ImageRequest imageRequest = (ImageRequest) fbDraweeControllerBuilder.g;
            if (imageRequest != null) {
                fbDraweeControllerBuilder.d(m4475b(imageRequest, a, fbDraweeControllerBuilder.q()));
            }
            fbDraweeControllerBuilder.a(new 1(this, fbDraweeControllerBuilder.k, a));
        }
        return fbDraweeControllerBuilder;
    }
}
