package com.facebook.messaging.platform.utilities;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.platform.opengraph.OpenGraphRequest;
import com.facebook.platform.opengraph.OpenGraphRequest.OpenGraphRequestException;
import com.facebook.platform.opengraph.OpenGraphRequestFactory;
import com.facebook.platform.opengraph.model.OpenGraphActionRobotext;
import com.facebook.platform.opengraph.model.OpenGraphObject;
import com.facebook.platform.opengraph.server.UploadStagingResourcePhotosOperation.Params;
import com.facebook.share.model.LinksPreview;
import com.facebook.share.model.ShareItem;
import com.facebook.share.model.ShareItemBuilder;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: registration_flow_enter */
public class PlatformShareUploadManager {
    private static volatile PlatformShareUploadManager f3673d;
    private final DefaultBlueServiceOperationFactory f3674a;
    public final ExecutorService f3675b;
    private final OpenGraphRequestFactory f3676c;

    public static com.facebook.messaging.platform.utilities.PlatformShareUploadManager m3477a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3673d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.platform.utilities.PlatformShareUploadManager.class;
        monitor-enter(r1);
        r0 = f3673d;	 Catch:{ all -> 0x003a }
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
        r0 = m3485b(r0);	 Catch:{ all -> 0x0035 }
        f3673d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3673d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.platform.utilities.PlatformShareUploadManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.platform.utilities.PlatformShareUploadManager");
    }

    private static PlatformShareUploadManager m3485b(InjectorLike injectorLike) {
        return new PlatformShareUploadManager(DefaultBlueServiceOperationFactory.b(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), OpenGraphRequestFactory.a(injectorLike));
    }

    @Inject
    public PlatformShareUploadManager(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, ExecutorService executorService, OpenGraphRequestFactory openGraphRequestFactory) {
        this.f3674a = defaultBlueServiceOperationFactory;
        this.f3675b = executorService;
        this.f3676c = openGraphRequestFactory;
    }

    public final ListenableFuture<ShareItem> m3489a(ShareItem shareItem) {
        if (shareItem.j != null) {
            return m3487c(shareItem);
        }
        return m3486b(shareItem);
    }

    private ListenableFuture<ShareItem> m3486b(final ShareItem shareItem) {
        final SettableFuture f = SettableFuture.f();
        Futures.a(m3488d(shareItem), new FutureCallback<OperationResult>(this) {
            final /* synthetic */ PlatformShareUploadManager f3661c;

            public void onSuccess(Object obj) {
                String str;
                LinksPreview linksPreview = (LinksPreview) ((Bundle) ((OperationResult) obj).h()).getParcelable("links_preview_result");
                ShareItemBuilder shareItemBuilder = new ShareItemBuilder();
                shareItemBuilder.a = linksPreview.name;
                shareItemBuilder.c = linksPreview.description;
                shareItemBuilder.b = linksPreview.caption;
                if (linksPreview.properties.containsKey("id")) {
                    str = (String) linksPreview.properties.get("id");
                } else {
                    str = null;
                }
                shareItemBuilder.f = str;
                shareItemBuilder.d = linksPreview.b();
                shareItemBuilder.i = shareItem.i;
                FutureDetour.a(f, shareItemBuilder.k(), 1042841214);
            }

            public void onFailure(Throwable th) {
                f.a(th);
            }
        }, this.f3675b);
        return f;
    }

    private ListenableFuture<ShareItem> m3487c(ShareItem shareItem) {
        SettableFuture f = SettableFuture.f();
        OpenGraphRequest a = this.f3676c.a(shareItem.j.a, shareItem.j.b, shareItem.j.c);
        try {
            a.h();
            try {
                OpenGraphObject a2 = m3478a(a);
                String str = null;
                if (a2 == null) {
                    str = a.a().b(a.c()).B();
                }
                m3484a(shareItem, a, str, a2, f, 3);
                return f;
            } catch (Throwable e) {
                return Futures.a(e);
            }
        } catch (OpenGraphRequestException e2) {
            return Futures.a(new RuntimeException("Open Graph Object was validated initially, but is no longer"));
        }
    }

    private void m3484a(ShareItem shareItem, OpenGraphRequest openGraphRequest, String str, OpenGraphObject openGraphObject, SettableFuture<ShareItem> settableFuture, int i) {
        final AtomicInteger atomicInteger = new AtomicInteger(i);
        final OpenGraphObject openGraphObject2 = openGraphObject;
        final OpenGraphRequest openGraphRequest2 = openGraphRequest;
        final ShareItem shareItem2 = shareItem;
        final SettableFuture<ShareItem> settableFuture2 = settableFuture;
        final int i2 = i;
        final String str2 = str;
        Futures.a(m3481a(this, shareItem, openGraphRequest, str), new FutureCallback<OperationResult>(this) {
            final /* synthetic */ PlatformShareUploadManager f3669h;

            public void onSuccess(Object obj) {
                OpenGraphObject openGraphObject;
                Bundle bundle = (Bundle) ((OperationResult) obj).h();
                ShareItemBuilder shareItemBuilder = new ShareItemBuilder();
                shareItemBuilder.f = bundle.getString("og_post_id");
                String string = bundle.getString("app_name");
                if (string != null) {
                    shareItemBuilder.b = string;
                }
                shareItemBuilder.g = ((OpenGraphActionRobotext) bundle.getParcelable("robotext_preview_result")).a;
                OpenGraphObject openGraphObject2 = openGraphObject2;
                if (openGraphObject2 == null) {
                    openGraphObject = (OpenGraphObject) bundle.getParcelable("object_details");
                    Uri d = openGraphRequest2.d();
                    if (d != null) {
                        openGraphObject = new OpenGraphObject(openGraphObject.b, openGraphObject.a, d.toString());
                    }
                } else {
                    openGraphObject = openGraphObject2;
                }
                if (openGraphObject.b != null) {
                    shareItemBuilder.a = openGraphObject.b;
                }
                if (openGraphObject.a != null) {
                    shareItemBuilder.c = openGraphObject.a;
                }
                if (openGraphObject.c != null) {
                    shareItemBuilder.d = openGraphObject.c;
                }
                shareItemBuilder.i = shareItem2.i;
                FutureDetour.a(settableFuture2, shareItemBuilder.k(), -388001275);
            }

            public void onFailure(Throwable th) {
                int i = atomicInteger.get();
                if (i > 0) {
                    try {
                        Thread.sleep(((long) Math.pow(2.0d, (double) (i2 - i))) * 500);
                    } catch (Exception e) {
                    }
                    Futures.a(PlatformShareUploadManager.m3481a(this.f3669h, shareItem2, openGraphRequest2, str2), this, this.f3669h.f3675b);
                    atomicInteger.set(i - 1);
                    return;
                }
                settableFuture2.a(th);
            }
        }, this.f3675b);
    }

    public static ListenableFuture m3481a(PlatformShareUploadManager platformShareUploadManager, final ShareItem shareItem, OpenGraphRequest openGraphRequest, final String str) {
        if (openGraphRequest.e().size() == 0) {
            return m3480a(platformShareUploadManager, shareItem, null, str);
        }
        return Futures.b(platformShareUploadManager.m3482a(openGraphRequest.e()), new AsyncFunction<OperationResult, OperationResult>(platformShareUploadManager) {
            final /* synthetic */ PlatformShareUploadManager f3672c;

            public final ListenableFuture m3476a(Object obj) {
                return PlatformShareUploadManager.m3480a(this.f3672c, shareItem, (Bundle) ((OperationResult) obj).h(), str);
            }
        }, platformShareUploadManager.f3675b);
    }

    public static ListenableFuture m3480a(PlatformShareUploadManager platformShareUploadManager, ShareItem shareItem, Bundle bundle, String str) {
        Parcelable openGraphMessageBatchOperation$Params = new OpenGraphMessageBatchOperation$Params(shareItem, bundle, str);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("platform_open_graph_share_upload_params", openGraphMessageBatchOperation$Params);
        return platformShareUploadManager.m3479a(bundle2, "platform_open_graph_share_upload");
    }

    private ListenableFuture<OperationResult> m3488d(ShareItem shareItem) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("platform_link_share_upload_params", new LinkShareMessageBatchOperation$Params(shareItem));
        return m3479a(bundle, "platform_link_share_upload");
    }

    private OpenGraphObject m3478a(OpenGraphRequest openGraphRequest) {
        String str = null;
        JsonNode b = openGraphRequest.a().b(openGraphRequest.e);
        if (b == null) {
            throw new RuntimeException("OpenGraphRequest did not specify preview property that exists on action");
        } else if (!b.i()) {
            return null;
        } else {
            String a = m3483a(b, "title");
            String a2 = m3483a(b, "description");
            if (openGraphRequest.d() != null) {
                str = openGraphRequest.d().toString();
            }
            return new OpenGraphObject(a, a2, str);
        }
    }

    private ListenableFuture<OperationResult> m3482a(ImmutableMap<Uri, Bitmap> immutableMap) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("platform_upload_staging_resource_photos_params", new Params(immutableMap));
        return m3479a(bundle, "platform_upload_staging_resource_photos");
    }

    private ListenableFuture<OperationResult> m3479a(Bundle bundle, String str) {
        return BlueServiceOperationFactoryDetour.a(this.f3674a, str, bundle, -1740872541).a();
    }

    private static String m3483a(JsonNode jsonNode, String str) {
        JsonNode b = jsonNode.b(str);
        if (b == null) {
            b = jsonNode.b("og:" + str);
        }
        if (b == null || !b.o()) {
            return null;
        }
        return b.B();
    }
}
