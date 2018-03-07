package com.facebook.analytics;

import com.facebook.analytics.ClientPeriodicEventReporterManager.EventCollectionStatus;
import com.facebook.analytics.analyticsmodule.BatteryStatusPeriodicReporter;
import com.facebook.analytics.analyticsmodule.DBSizePeriodicReporter;
import com.facebook.analytics.analyticsmodule.DeviceInfoPeriodicReporter;
import com.facebook.analytics.analyticsmodule.DeviceStatusPeriodicReporter;
import com.facebook.analytics.reporters.periodic.AppInstallationPeriodicReporter;
import com.facebook.analytics.reporters.periodic.ClassInstancesPeriodicReporter;
import com.facebook.analytics.reporters.periodic.PeriodicFeatureStatusReporter;
import com.facebook.analytics.reporters.periodic.PistolFirePeriodicReporter;
import com.facebook.analytics.reporters.periodic.ProcessStatusPeriodicReporter;
import com.facebook.assetdownload.logging.AssetDownloadPeriodicEventReporter;
import com.facebook.contacts.upload.ContactsUploadPeriodicReporter;
import com.facebook.fbreact.jscperf.JSCPerfPeriodicReporter;
import com.facebook.graphql.executor.cache.GraphQLDiskCachePeriodicReporter;
import com.facebook.http.push.ImagePushEfficiencyPeriodicReporter;
import com.facebook.imagepipeline.instrumentation.ImagePipelinePeriodicReporter;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.memory.logging.OtherAppMemoryUsageReporter;
import com.facebook.messaging.audio.playback.AudioCache;
import com.facebook.photos.base.analytics.efficiency.ImageFetchEfficiencyReporter;
import com.facebook.timeline.cache.db.reporters.TimelineDbCachePeriodicReporter;
import com.facebook.ui.images.cache.ImageCache;
import com.facebook.ui.images.fetch.FeatureAwareImageAccessLogger;
import com.facebook.video.analytics.DeviceVideoCapabilitiesPeriodicReporter;
import com.facebook.video.analytics.VideoCachePeriodicReporter;
import com.facebook.video.server.VideoPerformancePeriodicReporter;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: t_sm_b_rsp */
public class ClientPeriodicEventReporterHandlerImpl implements ClientPeriodicEventReporterHandler {
    private static volatile ClientPeriodicEventReporterHandlerImpl f3459y;
    private Lazy<BatteryStatusPeriodicReporter> f3460a;
    private Lazy<DBSizePeriodicReporter> f3461b;
    private Lazy<DeviceInfoPeriodicReporter> f3462c;
    private Lazy<DeviceStatusPeriodicReporter> f3463d;
    private Lazy<AppInstallationPeriodicReporter> f3464e;
    private Lazy<ClassInstancesPeriodicReporter> f3465f;
    private Lazy<PeriodicFeatureStatusReporter> f3466g;
    private Lazy<PistolFirePeriodicReporter> f3467h;
    private Lazy<ProcessStatusPeriodicReporter> f3468i;
    private Lazy<AssetDownloadPeriodicEventReporter> f3469j;
    private Lazy<ContactsUploadPeriodicReporter> f3470k;
    private Lazy<JSCPerfPeriodicReporter> f3471l;
    private Lazy<GraphQLDiskCachePeriodicReporter> f3472m;
    private Lazy<ImagePushEfficiencyPeriodicReporter> f3473n;
    private Lazy<ImagePipelinePeriodicReporter> f3474o;
    private Lazy<OtherAppMemoryUsageReporter> f3475p;
    private Lazy<AudioCache> f3476q;
    private Lazy<ImageFetchEfficiencyReporter> f3477r;
    private Lazy<TimelineDbCachePeriodicReporter> f3478s;
    private Lazy<ImageCache> f3479t;
    private Lazy<FeatureAwareImageAccessLogger> f3480u;
    private Lazy<DeviceVideoCapabilitiesPeriodicReporter> f3481v;
    private Lazy<VideoCachePeriodicReporter> f3482w;
    private Lazy<VideoPerformancePeriodicReporter> f3483x;

    public static com.facebook.analytics.ClientPeriodicEventReporterHandlerImpl m5676a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f3459y;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.ClientPeriodicEventReporterHandlerImpl.class;
        monitor-enter(r1);
        r0 = f3459y;	 Catch:{ all -> 0x003a }
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
        r0 = m5677b(r0);	 Catch:{ all -> 0x0035 }
        f3459y = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3459y;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.ClientPeriodicEventReporterHandlerImpl.a(com.facebook.inject.InjectorLike):com.facebook.analytics.ClientPeriodicEventReporterHandlerImpl");
    }

    private static ClientPeriodicEventReporterHandlerImpl m5677b(InjectorLike injectorLike) {
        return new ClientPeriodicEventReporterHandlerImpl(IdBasedSingletonScopeProvider.m1810b(injectorLike, 4778), IdBasedSingletonScopeProvider.m1810b(injectorLike, 4779), IdBasedSingletonScopeProvider.m1810b(injectorLike, 148), IdBasedSingletonScopeProvider.m1810b(injectorLike, 149), IdBasedSingletonScopeProvider.m1810b(injectorLike, 179), IdBasedSingletonScopeProvider.m1810b(injectorLike, 4786), IdBasedSingletonScopeProvider.m1810b(injectorLike, 180), IdBasedSingletonScopeProvider.m1810b(injectorLike, 4787), IdBasedSingletonScopeProvider.m1810b(injectorLike, 4788), IdBasedSingletonScopeProvider.m1810b(injectorLike, 4876), IdBasedSingletonScopeProvider.m1810b(injectorLike, 957), IdBasedSingletonScopeProvider.m1810b(injectorLike, 5784), IdBasedSingletonScopeProvider.m1810b(injectorLike, 6857), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2291), IdBasedSingletonScopeProvider.m1810b(injectorLike, 7218), IdBasedSingletonScopeProvider.m1810b(injectorLike, 7502), IdBasedSingletonScopeProvider.m1810b(injectorLike, 7536), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2959), IdBasedSingletonScopeProvider.m1810b(injectorLike, 11160), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3562), IdBasedSingletonScopeProvider.m1810b(injectorLike, 11507), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3640), IdBasedSingletonScopeProvider.m1810b(injectorLike, 11564), IdBasedSingletonScopeProvider.m1810b(injectorLike, 11640));
    }

    @Inject
    public ClientPeriodicEventReporterHandlerImpl(Lazy<BatteryStatusPeriodicReporter> lazy, Lazy<DBSizePeriodicReporter> lazy2, Lazy<DeviceInfoPeriodicReporter> lazy3, Lazy<DeviceStatusPeriodicReporter> lazy4, Lazy<AppInstallationPeriodicReporter> lazy5, Lazy<ClassInstancesPeriodicReporter> lazy6, Lazy<PeriodicFeatureStatusReporter> lazy7, Lazy<PistolFirePeriodicReporter> lazy8, Lazy<ProcessStatusPeriodicReporter> lazy9, Lazy<AssetDownloadPeriodicEventReporter> lazy10, Lazy<ContactsUploadPeriodicReporter> lazy11, Lazy<JSCPerfPeriodicReporter> lazy12, Lazy<GraphQLDiskCachePeriodicReporter> lazy13, Lazy<ImagePushEfficiencyPeriodicReporter> lazy14, Lazy<ImagePipelinePeriodicReporter> lazy15, Lazy<OtherAppMemoryUsageReporter> lazy16, Lazy<AudioCache> lazy17, Lazy<ImageFetchEfficiencyReporter> lazy18, Lazy<TimelineDbCachePeriodicReporter> lazy19, Lazy<ImageCache> lazy20, Lazy<FeatureAwareImageAccessLogger> lazy21, Lazy<DeviceVideoCapabilitiesPeriodicReporter> lazy22, Lazy<VideoCachePeriodicReporter> lazy23, Lazy<VideoPerformancePeriodicReporter> lazy24) {
        this.f3460a = lazy;
        this.f3461b = lazy2;
        this.f3462c = lazy3;
        this.f3463d = lazy4;
        this.f3464e = lazy5;
        this.f3465f = lazy6;
        this.f3466g = lazy7;
        this.f3467h = lazy8;
        this.f3468i = lazy9;
        this.f3469j = lazy10;
        this.f3470k = lazy11;
        this.f3471l = lazy12;
        this.f3472m = lazy13;
        this.f3473n = lazy14;
        this.f3474o = lazy15;
        this.f3475p = lazy16;
        this.f3476q = lazy17;
        this.f3477r = lazy18;
        this.f3478s = lazy19;
        this.f3479t = lazy20;
        this.f3480u = lazy21;
        this.f3481v = lazy22;
        this.f3482w = lazy23;
        this.f3483x = lazy24;
    }

    public final void mo754a(ClientPeriodicEventReporterManager clientPeriodicEventReporterManager, EventCollectionStatus eventCollectionStatus, String str, long j) {
        ClientPeriodicEventReporterHandlerDelegate.a(clientPeriodicEventReporterManager, eventCollectionStatus, str, j, this.f3460a, "BatteryStatusPeriodicReporter-battery_status", "BatteryStatusPeriodicReporter", "battery_status", false);
        ClientPeriodicEventReporterHandlerDelegate.a(clientPeriodicEventReporterManager, eventCollectionStatus, str, j, this.f3461b, "DBSizePeriodicReporter-db_size_info", "DBSizePeriodicReporter", "db_size_info", false, 86400000);
        ClientPeriodicEventReporterHandlerDelegate.a(clientPeriodicEventReporterManager, eventCollectionStatus, str, j, this.f3462c, "DeviceInfoPeriodicReporter-device_info", "DeviceInfoPeriodicReporter", "device_info", true);
        ClientPeriodicEventReporterHandlerDelegate.a(clientPeriodicEventReporterManager, eventCollectionStatus, str, j, this.f3463d, "DeviceStatusPeriodicReporter-device_status", "DeviceStatusPeriodicReporter", "device_status", true);
        ClientPeriodicEventReporterHandlerDelegate.a(clientPeriodicEventReporterManager, eventCollectionStatus, str, j, this.f3464e, "AppInstallationPeriodicReporter-app_installations", "AppInstallationPeriodicReporter", "app_installations", true, 86400000);
        ClientPeriodicEventReporterHandlerDelegate.a(clientPeriodicEventReporterManager, eventCollectionStatus, str, j, this.f3465f, "ClassInstancesPeriodicReporter-class_instances", "ClassInstancesPeriodicReporter", "class_instances", false, 7200000);
        ClientPeriodicEventReporterHandlerDelegate.a(clientPeriodicEventReporterManager, eventCollectionStatus, str, j, this.f3466g, "PeriodicFeatureStatusReporter-features_status", "PeriodicFeatureStatusReporter", "features_status", true, 43200000);
        ClientPeriodicEventReporterHandlerDelegate.a(clientPeriodicEventReporterManager, eventCollectionStatus, str, j, this.f3467h, "PistolFirePeriodicReporter-fbandroid_pistol_fire_crash", "PistolFirePeriodicReporter", "fbandroid_pistol_fire_crash", false, 86400000);
        ClientPeriodicEventReporterHandlerDelegate.a(clientPeriodicEventReporterManager, eventCollectionStatus, str, j, this.f3468i, "ProcessStatusPeriodicReporter-process_status", "ProcessStatusPeriodicReporter", "process_status", false);
        ClientPeriodicEventReporterHandlerDelegate.a(clientPeriodicEventReporterManager, eventCollectionStatus, str, j, this.f3469j, "AssetDownloadPeriodicEventReporter-assetdownload_db_and_fs_stats", "AssetDownloadPeriodicEventReporter", "assetdownload_db_and_fs_stats", false, 86400000);
        ClientPeriodicEventReporterHandlerDelegate.a(clientPeriodicEventReporterManager, eventCollectionStatus, str, j, this.f3470k, "ContactsUploadPeriodicReporter-contacts_upload_state", "ContactsUploadPeriodicReporter", "contacts_upload_state", true, 86400000);
        ClientPeriodicEventReporterHandlerDelegate.a(clientPeriodicEventReporterManager, eventCollectionStatus, str, j, this.f3471l, "JSCPerfPeriodicReporter-jsc_perf_event", "JSCPerfPeriodicReporter", "jsc_perf_event", false, 3600000);
        ClientPeriodicEventReporterHandlerDelegate.a(clientPeriodicEventReporterManager, eventCollectionStatus, str, j, this.f3472m, "GraphQLDiskCachePeriodicReporter-fb4a_graphql_disk_cache_snapshot_table", "GraphQLDiskCachePeriodicReporter", "fb4a_graphql_disk_cache_snapshot_table", false, 259200000);
        ClientPeriodicEventReporterHandlerDelegate.a(clientPeriodicEventReporterManager, eventCollectionStatus, str, j, this.f3473n, "ImagePushEfficiencyPeriodicReporter-android_image_push_fetch_efficiency", "ImagePushEfficiencyPeriodicReporter", "android_image_push_fetch_efficiency", true, 86400000);
        ClientPeriodicEventReporterHandlerDelegate.a(clientPeriodicEventReporterManager, eventCollectionStatus, str, j, this.f3474o, "ImagePipelinePeriodicReporter-image_pipeline_counters", "ImagePipelinePeriodicReporter", "image_pipeline_counters", false, 14400000);
        ClientPeriodicEventReporterHandlerDelegate.a(clientPeriodicEventReporterManager, eventCollectionStatus, str, j, this.f3475p, "OtherAppMemoryUsageReporter-other_app_memory_usage", "OtherAppMemoryUsageReporter", "other_app_memory_usage", false, 86400000);
        ClientPeriodicEventReporterHandlerDelegate.a(clientPeriodicEventReporterManager, eventCollectionStatus, str, j, this.f3476q, "AudioCache-media_cache_size", "AudioCache", "media_cache_size", false, 3600000);
        ClientPeriodicEventReporterHandlerDelegate.a(clientPeriodicEventReporterManager, eventCollectionStatus, str, j, this.f3477r, "ImageFetchEfficiencyReporter-android_image_fetch_efficiency", "ImageFetchEfficiencyReporter", "android_image_fetch_efficiency", true, 86400000);
        ClientPeriodicEventReporterHandlerDelegate.a(clientPeriodicEventReporterManager, eventCollectionStatus, str, j, this.f3478s, "TimelineDbCachePeriodicReporter-fb4a_timeline_disk_cache_snapshot_table", "TimelineDbCachePeriodicReporter", "fb4a_timeline_disk_cache_snapshot_table", false, 259200000);
        ClientPeriodicEventReporterHandlerDelegate.a(clientPeriodicEventReporterManager, eventCollectionStatus, str, j, this.f3479t, "ImageCache-media_cache_size", "ImageCache", "media_cache_size", false, 3600000);
        ClientPeriodicEventReporterHandlerDelegate.a(clientPeriodicEventReporterManager, eventCollectionStatus, str, j, this.f3480u, "FeatureAwareImageAccessLogger-feature_image_access", "FeatureAwareImageAccessLogger", "feature_image_access", false, 1800000);
        ClientPeriodicEventReporterHandlerDelegate.a(clientPeriodicEventReporterManager, eventCollectionStatus, str, j, this.f3481v, "DeviceVideoCapabilitiesPeriodicReporter-device_video_capabilities", "DeviceVideoCapabilitiesPeriodicReporter", "device_video_capabilities", false, 604800000);
        ClientPeriodicEventReporterHandlerDelegate.a(clientPeriodicEventReporterManager, eventCollectionStatus, str, j, this.f3482w, "VideoCachePeriodicReporter-video_cache_counters", "VideoCachePeriodicReporter", "video_cache_counters", false, 18000000);
        ClientPeriodicEventReporterHandlerDelegate.a(clientPeriodicEventReporterManager, eventCollectionStatus, str, j, this.f3483x, "VideoPerformancePeriodicReporter-video_daily_data_usage", "VideoPerformancePeriodicReporter", "video_daily_data_usage", false, 86400000);
    }
}
