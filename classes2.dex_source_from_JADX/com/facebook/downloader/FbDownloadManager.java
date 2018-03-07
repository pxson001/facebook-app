package com.facebook.downloader;

import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.android.DownloadManagerMethodAutoProvider;
import com.facebook.common.executors.C0087xd695ba9d;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.common.file.StatFsHelperMethodAutoProvider;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.statfs.StatFsHelper.StorageType;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.downloader.DownloadRequest.DownloadType;
import com.facebook.downloader.contracts.DefaultDownloadLimitProvider;
import com.facebook.downloader.event.DownloadCleanupEvent;
import com.facebook.downloader.event.DownloadErrorEvent;
import com.facebook.downloader.event.DownloadErrorEvent.ErrorCode;
import com.facebook.downloader.event.DownloadEventBus;
import com.facebook.downloader.event.DownloadInfoEvent;
import com.facebook.downloader.event.DownloadInfoEvent.InfoEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Maps;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@TargetApi(9)
/* compiled from: reaction_android_components_async_layout */
public class FbDownloadManager {
    private static volatile FbDownloadManager f8217m;
    private final Context f8218a;
    private final DownloadRequestFactory f8219b;
    private final DownloadManager f8220c;
    private final StatFsHelper f8221d;
    private final ViewerContext f8222e;
    private final MoreFileUtils f8223f;
    public final ExecutorService f8224g;
    public final DownloadEventBus f8225h;
    private final DefaultDownloadLimitProvider f8226i;
    private final AnalyticsLogger f8227j;
    private DynamicSecureBroadcastReceiver f8228k;
    public HashMap<Long, DownloadRequest> f8229l = Maps.m838c();

    public static com.facebook.downloader.FbDownloadManager m12711a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8217m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.downloader.FbDownloadManager.class;
        monitor-enter(r1);
        r0 = f8217m;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m12717b(r0);	 Catch:{ all -> 0x0035 }
        f8217m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8217m;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.downloader.FbDownloadManager.a(com.facebook.inject.InjectorLike):com.facebook.downloader.FbDownloadManager");
    }

    private static FbDownloadManager m12717b(InjectorLike injectorLike) {
        return new FbDownloadManager((Context) injectorLike.getInstance(Context.class), ViewerContextMethodAutoProvider.m5006b(injectorLike), DownloadManagerMethodAutoProvider.m12723b(injectorLike), DownloadRequestFactory.m12728a(injectorLike), StatFsHelperMethodAutoProvider.m2307a(injectorLike), MoreFileUtils.m5023a(injectorLike), C0087xd695ba9d.m2486a(injectorLike), DownloadEventBus.m12730a(injectorLike), new DefaultDownloadLimitProvider(), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike));
    }

    @Inject
    public FbDownloadManager(Context context, ViewerContext viewerContext, DownloadManager downloadManager, DownloadRequestFactory downloadRequestFactory, StatFsHelper statFsHelper, MoreFileUtils moreFileUtils, ExecutorService executorService, DownloadEventBus downloadEventBus, DefaultDownloadLimitProvider defaultDownloadLimitProvider, AnalyticsLogger analyticsLogger) {
        this.f8218a = context;
        this.f8220c = downloadManager;
        this.f8219b = downloadRequestFactory;
        this.f8221d = statFsHelper;
        this.f8222e = viewerContext;
        this.f8223f = moreFileUtils;
        this.f8224g = executorService;
        this.f8225h = downloadEventBus;
        this.f8226i = defaultDownloadLimitProvider;
        this.f8227j = analyticsLogger;
    }

    private static boolean m12715a(Uri uri) {
        return uri.getHost().endsWith(".facebook.com");
    }

    public final void m12721a() {
        if (this.f8228k == null) {
            this.f8228k = new DynamicSecureBroadcastReceiver(new Builder().m609b("android.intent.action.DOWNLOAD_COMPLETE", new 1(this)).m610b());
            this.f8218a.registerReceiver(this.f8228k, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        }
    }

    public static DownloadType m12710a(FbDownloadManager fbDownloadManager, long j) {
        if (fbDownloadManager.f8229l.containsKey(Long.valueOf(j))) {
            DownloadRequest downloadRequest = (DownloadRequest) fbDownloadManager.f8229l.get(Long.valueOf(j));
            if (downloadRequest != null) {
                return downloadRequest.a;
            }
        }
        return DownloadType.UNKNOWN;
    }

    @TargetApi(11)
    public final long m12719a(DownloadRequest downloadRequest) {
        Uri build;
        Request a;
        DownloadNetworkPreference c;
        int i;
        long enqueue;
        Uri parse = Uri.parse(downloadRequest.b());
        String str = null;
        if (parse.getScheme().equalsIgnoreCase("https")) {
            if (VERSION.SDK_INT < 11) {
                Uri.Builder buildUpon = parse.buildUpon();
                buildUpon.scheme("http");
                build = buildUpon.build();
            } else if (m12715a(parse)) {
                if (this.f8222e == null) {
                    return -1;
                }
                str = this.f8222e.m1526b();
                build = parse;
            }
            this.f8225h.mo651a(new DownloadCleanupEvent(downloadRequest.a(), downloadRequest.g()));
            a = DownloadRequestFactory.m12725a(build);
            if (downloadRequest.f()) {
                c = downloadRequest.c();
                if (c.a()) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (c.b()) {
                    i |= 2;
                }
                if (m12716a("android.permission.DOWNLOAD_WITHOUT_NOTIFICATION")) {
                    if (VERSION.SDK_INT < 11) {
                        a.setNotificationVisibility(2);
                    } else {
                        a.setShowRunningNotification(false);
                    }
                }
                a.setAllowedOverRoaming(false);
            } else {
                i = 0;
            }
            a.setVisibleInDownloadsUi(false);
            if (i != 0) {
                a.setAllowedNetworkTypes(i);
            }
            a.addRequestHeader("Accept", "application/octet-stream");
            if (str != null) {
                a.addRequestHeader("Authorization", "OAuth " + str);
            }
            str = downloadRequest.h();
            if (str != null) {
                a.addRequestHeader("User-Agent", str);
            }
            if (downloadRequest.d() != null) {
                a.setTitle(downloadRequest.d());
            }
            if (!m12714a(downloadRequest.e(), a, downloadRequest.a(), downloadRequest.g(), downloadRequest.i())) {
                return -1;
            }
            this.f8225h.mo651a(new DownloadInfoEvent(downloadRequest.a(), downloadRequest.g(), InfoEvent.QUEUE_DOWNLOAD, build.toString()));
            try {
                enqueue = this.f8220c.enqueue(a);
            } catch (IllegalArgumentException e) {
                enqueue = -1;
            }
            if (enqueue != -1) {
                return enqueue;
            }
            this.f8229l.put(Long.valueOf(enqueue), downloadRequest);
            return enqueue;
        }
        build = parse;
        this.f8225h.mo651a(new DownloadCleanupEvent(downloadRequest.a(), downloadRequest.g()));
        a = DownloadRequestFactory.m12725a(build);
        if (downloadRequest.f()) {
            i = 0;
        } else {
            c = downloadRequest.c();
            if (c.a()) {
                i = 0;
            } else {
                i = 1;
            }
            if (c.b()) {
                i |= 2;
            }
            if (m12716a("android.permission.DOWNLOAD_WITHOUT_NOTIFICATION")) {
                if (VERSION.SDK_INT < 11) {
                    a.setShowRunningNotification(false);
                } else {
                    a.setNotificationVisibility(2);
                }
            }
            a.setAllowedOverRoaming(false);
        }
        a.setVisibleInDownloadsUi(false);
        if (i != 0) {
            a.setAllowedNetworkTypes(i);
        }
        a.addRequestHeader("Accept", "application/octet-stream");
        if (str != null) {
            a.addRequestHeader("Authorization", "OAuth " + str);
        }
        str = downloadRequest.h();
        if (str != null) {
            a.addRequestHeader("User-Agent", str);
        }
        if (downloadRequest.d() != null) {
            a.setTitle(downloadRequest.d());
        }
        if (!m12714a(downloadRequest.e(), a, downloadRequest.a(), downloadRequest.g(), downloadRequest.i())) {
            return -1;
        }
        this.f8225h.mo651a(new DownloadInfoEvent(downloadRequest.a(), downloadRequest.g(), InfoEvent.QUEUE_DOWNLOAD, build.toString()));
        enqueue = this.f8220c.enqueue(a);
        if (enqueue != -1) {
            return enqueue;
        }
        this.f8229l.put(Long.valueOf(enqueue), downloadRequest);
        return enqueue;
    }

    private boolean m12716a(String str) {
        return this.f8218a.checkCallingOrSelfPermission(str) == 0;
    }

    private boolean m12714a(long j, Request request, DownloadType downloadType, @Nullable String str, boolean z) {
        long a = this.f8221d.m2314a(StorageType.INTERNAL);
        if (a < 2 * j) {
            this.f8225h.mo651a(new DownloadErrorEvent(downloadType, str, ErrorCode.ERROR_NO_FREE_SPACE_TO_DOWNLOAD, null, j));
            return false;
        }
        long a2 = this.f8226i.m12731a(downloadType);
        if (a >= 3 * j && a >= a2) {
            return true;
        }
        a = this.f8226i.m12732b(downloadType);
        if (j > a) {
            a = j;
        }
        if (z && Environment.getExternalStorageState().equals("mounted") && !this.f8221d.m2315a(StorageType.EXTERNAL, r0)) {
            request.setDestinationInExternalFilesDir(this.f8218a, Environment.DIRECTORY_DOWNLOADS, SafeUUIDGenerator.m2795a().toString());
            this.f8225h.mo651a(new DownloadInfoEvent(downloadType, str, InfoEvent.DOWNLOAD_AT_EXTERNAL_DESTINATION, null));
            return true;
        }
        this.f8225h.mo651a(new DownloadErrorEvent(downloadType, str, ErrorCode.ERROR_NO_FREE_SPACE_TO_DOWNLOAD, null, j));
        return false;
    }

    public final File m12720a(String str, long j, DownloadType downloadType, @Nullable String str2) {
        File file;
        if (downloadType == DownloadType.UNKNOWN) {
            downloadType = m12710a(this, j);
        }
        if (TextUtils.isEmpty(str)) {
            file = null;
        } else {
            Uri parse = Uri.parse(str);
            if (MoreFileUtils.m5030a(parse)) {
                file = MoreFileUtils.m5026a(parse.getPath());
            } else {
                try {
                    file = MoreFileUtils.m5024a(this.f8218a, this.f8220c.openDownloadedFile(j), SafeUUIDGenerator.m2795a().toString());
                    if (file != null) {
                        m12718b(j, downloadType, str2);
                        this.f8225h.mo651a(new DownloadInfoEvent(downloadType, str2, InfoEvent.CREATED_FILE, null));
                    }
                } catch (FileNotFoundException e) {
                    return null;
                }
            }
        }
        return file;
    }

    private void m12718b(long j, DownloadType downloadType, @Nullable String str) {
        DownloadType a;
        if (downloadType == DownloadType.UNKNOWN) {
            a = m12710a(this, j);
        } else {
            a = downloadType;
        }
        try {
            this.f8220c.remove(new long[]{j});
        } catch (Exception e) {
            this.f8225h.mo651a(new DownloadErrorEvent(a, str, ErrorCode.ERROR_FAILED_TO_REMOVE_DOWNLOAD_ID, e, j));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m12722a(long r12, com.facebook.downloader.DownloadRequest.DownloadType r14, @javax.annotation.Nullable java.lang.String r15) {
        /*
        r11 = this;
        r0 = 0;
        r1 = new android.app.DownloadManager$Query;
        r1.<init>();
        r2 = 1;
        r2 = new long[r2];
        r3 = 0;
        r2[r3] = r12;
        r1.setFilterById(r2);
        r2 = com.facebook.downloader.DownloadRequest.DownloadType.UNKNOWN;
        if (r14 != r2) goto L_0x0017;
    L_0x0013:
        r14 = m12710a(r11, r12);
    L_0x0017:
        r2 = r11.f8220c;	 Catch:{ Exception -> 0x0085, all -> 0x0108 }
        r0 = r2.query(r1);	 Catch:{ Exception -> 0x0085, all -> 0x0108 }
        if (r0 == 0) goto L_0x0025;
    L_0x001f:
        r1 = r0.moveToFirst();	 Catch:{ Exception -> 0x0085 }
        if (r1 != 0) goto L_0x005a;
    L_0x0025:
        r1 = "download_complete_cursor_empty";
        r2 = 0;
        r11.m12713a(r1, r2);	 Catch:{ Exception -> 0x0085 }
        r8 = r11.f8225h;	 Catch:{ Exception -> 0x0085 }
        r1 = new com.facebook.downloader.event.DownloadErrorEvent;	 Catch:{ Exception -> 0x0085 }
        r2 = m12710a(r11, r12);	 Catch:{ Exception -> 0x0085 }
        r4 = com.facebook.downloader.event.DownloadErrorEvent.ErrorCode.ERROR_EMPTY_DOWNLOAD_MANAGER_CURSOR;	 Catch:{ Exception -> 0x0085 }
        r5 = 0;
        r6 = -1;
        r3 = r15;
        r1.<init>(r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x0085 }
        r8.mo651a(r1);	 Catch:{ Exception -> 0x0085 }
    L_0x003f:
        if (r0 == 0) goto L_0x0044;
    L_0x0041:
        r0.close();
    L_0x0044:
        r0 = r11.f8229l;
        r1 = java.lang.Long.valueOf(r12);
        r0 = r0.containsKey(r1);
        if (r0 == 0) goto L_0x0059;
    L_0x0050:
        r0 = r11.f8229l;
        r1 = java.lang.Long.valueOf(r12);
        r0.remove(r1);
    L_0x0059:
        return;
    L_0x005a:
        r1 = "status";
        r1 = r0.getColumnIndex(r1);	 Catch:{  }
        r1 = r0.getInt(r1);	 Catch:{  }
        r2 = "reason";
        r2 = r0.getColumnIndex(r2);	 Catch:{  }
        r7 = r0.getInt(r2);	 Catch:{  }
        r2 = "local_uri";
        r2 = r0.getColumnIndex(r2);	 Catch:{  }
        r6 = r0.getString(r2);	 Catch:{  }
        switch(r1) {
            case 8: goto L_0x00b9;
            case 16: goto L_0x00ed;
            default: goto L_0x007b;
        };	 Catch:{  }
    L_0x007b:
        r1 = "download_complete_status_other";
        r2 = m12712a(r0);	 Catch:{  }
        r11.m12713a(r1, r2);	 Catch:{  }
        goto L_0x003f;
    L_0x0085:
        r5 = move-exception;
        r1 = "download_complete_exception";
        r2 = m12712a(r0);	 Catch:{ all -> 0x00ce }
        r11.m12713a(r1, r2);	 Catch:{ all -> 0x00ce }
        r8 = r11.f8225h;	 Catch:{ all -> 0x00ce }
        r1 = new com.facebook.downloader.event.DownloadErrorEvent;	 Catch:{ all -> 0x00ce }
        r4 = com.facebook.downloader.event.DownloadErrorEvent.ErrorCode.ERROR_DOWNLOAD_MANAGER_COMPLETION_EXCEPTION;	 Catch:{ all -> 0x00ce }
        r2 = r14;
        r3 = r15;
        r6 = r12;
        r1.<init>(r2, r3, r4, r5, r6);	 Catch:{ all -> 0x00ce }
        r8.mo651a(r1);	 Catch:{ all -> 0x00ce }
        if (r0 == 0) goto L_0x00a3;
    L_0x00a0:
        r0.close();
    L_0x00a3:
        r0 = r11.f8229l;
        r1 = java.lang.Long.valueOf(r12);
        r0 = r0.containsKey(r1);
        if (r0 == 0) goto L_0x0059;
    L_0x00af:
        r0 = r11.f8229l;
        r1 = java.lang.Long.valueOf(r12);
        r0.remove(r1);
        goto L_0x0059;
    L_0x00b9:
        r1 = "download_complete_successful";
        r2 = 0;
        r11.m12713a(r1, r2);	 Catch:{  }
        r8 = r11.f8225h;	 Catch:{  }
        r1 = new com.facebook.downloader.event.DownloadSuccessEvent;	 Catch:{  }
        r2 = r14;
        r3 = r15;
        r4 = r12;
        r1.<init>(r2, r3, r4, r6, r7);	 Catch:{  }
        r8.mo651a(r1);	 Catch:{  }
        goto L_0x003f;
    L_0x00ce:
        r1 = move-exception;
        r9 = r1;
        r1 = r0;
        r0 = r9;
    L_0x00d2:
        if (r1 == 0) goto L_0x00d7;
    L_0x00d4:
        r1.close();
    L_0x00d7:
        r1 = r11.f8229l;
        r2 = java.lang.Long.valueOf(r12);
        r1 = r1.containsKey(r2);
        if (r1 == 0) goto L_0x00ec;
    L_0x00e3:
        r1 = r11.f8229l;
        r2 = java.lang.Long.valueOf(r12);
        r1.remove(r2);
    L_0x00ec:
        throw r0;
    L_0x00ed:
        r1 = "download_complete_failed";
        r2 = m12712a(r0);	 Catch:{  }
        r11.m12713a(r1, r2);	 Catch:{  }
        r8 = r11.f8225h;	 Catch:{  }
        r1 = new com.facebook.downloader.event.DownloadErrorEvent;	 Catch:{  }
        r4 = com.facebook.downloader.event.DownloadErrorEvent.ErrorCode.ERROR_DOWNLOAD_MANAGER_FAILURE;	 Catch:{  }
        r5 = 0;
        r6 = (long) r7;	 Catch:{  }
        r2 = r14;
        r3 = r15;
        r1.<init>(r2, r3, r4, r5, r6);	 Catch:{  }
        r8.mo651a(r1);	 Catch:{  }
        goto L_0x003f;
    L_0x0108:
        r1 = move-exception;
        r9 = r1;
        r1 = r0;
        r0 = r9;
        goto L_0x00d2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.downloader.FbDownloadManager.a(long, com.facebook.downloader.DownloadRequest$DownloadType, java.lang.String):void");
    }

    private static Map<String, ?> m12712a(Cursor cursor) {
        String str;
        Map<String, ?> hashMap = new HashMap();
        int i = cursor.getInt(cursor.getColumnIndex("status"));
        switch (i) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                hashMap.put("status", "STATUS_PENDING");
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                hashMap.put("status", "STATUS_RUNNING");
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                hashMap.put("status", "STATUS_PAUSED");
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                hashMap.put("status", "STATUS_SUCCESSFUL");
                break;
            case HTTPTransportCallback.HEADER_BYTES_GENERATED /*16*/:
                hashMap.put("status", "STATUS_FAILED");
                break;
            default:
                hashMap.put("status", "UNKNOWN(" + i + ")");
                break;
        }
        i = cursor.getInt(cursor.getColumnIndex("reason"));
        String str2 = "status_reason";
        switch (i) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                str = "PAUSED_WAITING_TO_RETRY";
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                str = "PAUSED_WAITING_FOR_NETWORK";
                break;
            case 3:
                str = "PAUSED_QUEUED_FOR_WIFI";
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                str = "PAUSED_UNKNOWN";
                break;
            case 1000:
                str = "ERROR_UNKNOWN";
                break;
            case 1001:
                str = "ERROR_FILE_ERROR";
                break;
            case 1002:
                str = "ERROR_UNHANDLED_HTTP_CODE";
                break;
            case 1004:
                str = "ERROR_HTTP_DATA_ERROR";
                break;
            case 1005:
                str = "ERROR_TOO_MANY_REDIRECTS";
                break;
            case 1006:
                str = "ERROR_INSUFFICIENT_SPACE";
                break;
            case 1007:
                str = "ERROR_DEVICE_NOT_FOUND";
                break;
            case 1008:
                str = "ERROR_CANNOT_RESUME";
                break;
            case 1009:
                str = "ERROR_FILE_ALREADY_EXISTS";
                break;
            default:
                str = "UNKNOWN(" + i + ")";
                break;
        }
        hashMap.put(str2, str);
        hashMap.put("last_modified", Long.valueOf(cursor.getLong(cursor.getColumnIndex("last_modified_timestamp"))));
        hashMap.put("bytes_so_far", Long.valueOf(cursor.getLong(cursor.getColumnIndex("bytes_so_far"))));
        hashMap.put("total_bytes", Long.valueOf(cursor.getLong(cursor.getColumnIndex("total_size"))));
        return hashMap;
    }

    private void m12713a(String str, @Nullable Map<String, ?> map) {
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.f3099c = "com_facebook_downloader";
        honeyClientEvent.m5088a((Map) map);
        this.f8227j.mo526a(honeyClientEvent);
    }
}
