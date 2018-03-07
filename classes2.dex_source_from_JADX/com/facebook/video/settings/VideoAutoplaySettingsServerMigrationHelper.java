package com.facebook.video.settings;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.TriState;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.graphql.calls.DeviceAutoplaySettingUpdateInputData;
import com.facebook.graphql.calls.DeviceAutoplaySettingUpdateInputData.AutoplaySetting;
import com.facebook.graphql.calls.DeviceAutoplaySettingUpdateInputData.UpdateType;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.enums.GraphQLAutoplaySettingEffective;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.video.settings.VideoPrefs.AutoPlaySettingValue;
import com.facebook.video.settings.graphql.AutoplaySettingsGraphQL.ViewerQueryString;
import com.facebook.video.settings.graphql.AutoplaySettingsMutations.DeviceAutoplaySettingUpdateString;
import com.facebook.video.settings.graphql.VideoAutoplaySettingsServerMigrationClient;
import com.facebook.video.settings.graphql.VideoAutoplaySettingsServerMigrationClient.1;
import com.facebook.video.settings.graphql.VideoAutoplaySettingsServerMigrationClient.2;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: is_friend */
public class VideoAutoplaySettingsServerMigrationHelper {
    public static final String f19165a = VideoAutoplaySettingsServerMigrationHelper.class.getName();
    private static volatile VideoAutoplaySettingsServerMigrationHelper f19166h;
    public VideoAutoplaySettingsServerMigrationClient f19167b;
    public AbstractFbErrorReporter f19168c;
    private Provider<TriState> f19169d;
    public AutoPlaySettingValue f19170e = AutoPlaySettingValue.OFF;
    public AutoPlaySettingValue f19171f;
    private Resources f19172g;

    public static com.facebook.video.settings.VideoAutoplaySettingsServerMigrationHelper m26889a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19166h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.settings.VideoAutoplaySettingsServerMigrationHelper.class;
        monitor-enter(r1);
        r0 = f19166h;	 Catch:{ all -> 0x003a }
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
        r0 = m26891b(r0);	 Catch:{ all -> 0x0035 }
        f19166h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19166h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.settings.VideoAutoplaySettingsServerMigrationHelper.a(com.facebook.inject.InjectorLike):com.facebook.video.settings.VideoAutoplaySettingsServerMigrationHelper");
    }

    private static VideoAutoplaySettingsServerMigrationHelper m26891b(InjectorLike injectorLike) {
        return new VideoAutoplaySettingsServerMigrationHelper(new VideoAutoplaySettingsServerMigrationClient(UniqueIdForDeviceHolderMethodAutoProvider.m4339b(injectorLike), GraphQLQueryExecutor.m10435a(injectorLike), GraphQLCacheManager.m14847a(injectorLike)), IdBasedProvider.m1811a(injectorLike, 812), C0759x3db8deda.m26896a(injectorLike), ResourcesMethodAutoProvider.m6510a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public VideoAutoplaySettingsServerMigrationHelper(VideoAutoplaySettingsServerMigrationClient videoAutoplaySettingsServerMigrationClient, Provider<TriState> provider, AutoPlaySettingValue autoPlaySettingValue, Resources resources, FbErrorReporter fbErrorReporter) {
        this.f19167b = videoAutoplaySettingsServerMigrationClient;
        this.f19168c = fbErrorReporter;
        this.f19169d = provider;
        this.f19171f = autoPlaySettingValue;
        this.f19172g = resources;
    }

    public final AutoPlaySettingValue m26892a(AutoPlaySettingValue autoPlaySettingValue, FbSharedPreferences fbSharedPreferences) {
        this.f19170e = VideoAutoPlayListPreferenceSettings.m26900a(autoPlaySettingValue, fbSharedPreferences, true);
        if (!((TriState) this.f19169d.get()).isSet() || this.f19169d.get() == TriState.YES) {
            VideoAutoplaySettingsServerMigrationClient videoAutoplaySettingsServerMigrationClient = this.f19167b;
            TypedGraphQlQueryString viewerQueryString = new ViewerQueryString();
            viewerQueryString.m11315a("input", videoAutoplaySettingsServerMigrationClient.f19190b.m4346a());
            GraphQLQueryExecutor graphQLQueryExecutor = videoAutoplaySettingsServerMigrationClient.f19189a;
            GraphQLRequest a = GraphQLRequest.m11587a(viewerQueryString).m11594a(GraphQLCachePolicy.f7109a).m11590a(86400);
            a.f7087e = ImmutableSet.of("AUTOPLAY_SETTING_READ_QUERY");
            Futures.m2458a(Futures.m2450a(graphQLQueryExecutor.m10446a(a), new 2(videoAutoplaySettingsServerMigrationClient), MoreExecutors.m1813a()), new 1(this, fbSharedPreferences), MoreExecutors.m1813a());
        }
        return this.f19170e;
    }

    public final void m26894a(FbSharedPreferences fbSharedPreferences, AutoPlaySettingValue autoPlaySettingValue, UpdateType updateType) {
        if (this.f19169d.get() == TriState.YES) {
            AutoplaySetting autoplaySetting;
            if (VideoAutoPlayListPreferenceSettings.m26904b(fbSharedPreferences).asBoolean(false)) {
                switch (3.b[autoPlaySettingValue.ordinal()]) {
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                        autoplaySetting = AutoplaySetting.ON;
                        break;
                    case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                        autoplaySetting = AutoplaySetting.WIFI_ONLY;
                        break;
                    case 3:
                        autoplaySetting = AutoplaySetting.OFF;
                        break;
                    default:
                        autoplaySetting = AutoplaySetting.OFF;
                        break;
                }
            }
            autoplaySetting = AutoplaySetting.DEFAULT_AUTOPLAY;
            Enum enumR = autoplaySetting;
            VideoAutoplaySettingsServerMigrationClient videoAutoplaySettingsServerMigrationClient = this.f19167b;
            DeviceAutoplaySettingUpdateInputData deviceAutoplaySettingUpdateInputData = new DeviceAutoplaySettingUpdateInputData();
            deviceAutoplaySettingUpdateInputData.m11397a("device_identifier", videoAutoplaySettingsServerMigrationClient.f19190b.m4346a());
            GraphQlCallInput graphQlCallInput = deviceAutoplaySettingUpdateInputData;
            graphQlCallInput.m11395a("update_type", (Enum) updateType);
            graphQlCallInput = graphQlCallInput;
            graphQlCallInput.m11395a("autoplay_setting", enumR);
            graphQlCallInput = graphQlCallInput;
            TypedGraphQLMutationString deviceAutoplaySettingUpdateString = new DeviceAutoplaySettingUpdateString();
            deviceAutoplaySettingUpdateString.m11310a("input", graphQlCallInput);
            Futures.m2458a(Futures.m2450a(videoAutoplaySettingsServerMigrationClient.f19189a.m10448a(GraphQLRequest.m11588a(deviceAutoplaySettingUpdateString)), new 1(videoAutoplaySettingsServerMigrationClient), MoreExecutors.m1813a()), new 2(this, autoPlaySettingValue, fbSharedPreferences), MoreExecutors.m1813a());
        }
    }

    public final void m26895a(String str, Throwable th) {
        this.f19168c.m2343a(f19165a, str, th);
    }

    public static AutoPlaySettingValue m26890a(GraphQLAutoplaySettingEffective graphQLAutoplaySettingEffective) {
        switch (3.a[graphQLAutoplaySettingEffective.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return AutoPlaySettingValue.ON;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return AutoPlaySettingValue.WIFI_ONLY;
            case 3:
                return AutoPlaySettingValue.OFF;
            default:
                return AutoPlaySettingValue.OFF;
        }
    }

    public final String m26893a(AutoPlaySettingValue autoPlaySettingValue) {
        switch (3.b[autoPlaySettingValue.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return this.f19172g.getString(2131236190);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return this.f19172g.getString(2131236189);
            default:
                return this.f19172g.getString(2131236188);
        }
    }
}
