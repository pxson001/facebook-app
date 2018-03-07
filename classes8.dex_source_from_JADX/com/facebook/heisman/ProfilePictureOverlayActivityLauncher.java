package com.facebook.heisman;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.enums.GraphQLProfilePictureActionLinkType;
import com.facebook.heisman.abtest.ExperimentsForProfilePictureOverlayAbTestModule;
import com.facebook.heisman.intent.ProfilePictureOverlayCameraIntentData;
import com.facebook.heisman.intent.ProfilePictureOverlayPivotIntentData;
import com.facebook.heisman.intent.ProfilePictureOverlayPivotIntentData.Builder;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.heisman.swipeable.ImageOverlayValidator;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.qe.api.QeAccessor;
import com.facebook.runtimepermissions.AbstractRuntimePermissionsListener;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@TargetApi(16)
/* compiled from: vertical_position */
public class ProfilePictureOverlayActivityLauncher {
    @VisibleForTesting
    static final String[] f608a = new String[]{"android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    @VisibleForTesting
    static final String[] f609b = new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    private static volatile ProfilePictureOverlayActivityLauncher f610g;
    public final SecureContextHelper f611c;
    private final ActivityRuntimePermissionsManagerProvider f612d;
    private final Lazy<FbErrorReporter> f613e;
    private final Lazy<QeAccessor> f614f;

    public static com.facebook.heisman.ProfilePictureOverlayActivityLauncher m648a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f610g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.heisman.ProfilePictureOverlayActivityLauncher.class;
        monitor-enter(r1);
        r0 = f610g;	 Catch:{ all -> 0x003a }
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
        r0 = m649b(r0);	 Catch:{ all -> 0x0035 }
        f610g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f610g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.heisman.ProfilePictureOverlayActivityLauncher.a(com.facebook.inject.InjectorLike):com.facebook.heisman.ProfilePictureOverlayActivityLauncher");
    }

    private static ProfilePictureOverlayActivityLauncher m649b(InjectorLike injectorLike) {
        return new ProfilePictureOverlayActivityLauncher((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (ActivityRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedSingletonScopeProvider.b(injectorLike, 3219));
    }

    @Inject
    public ProfilePictureOverlayActivityLauncher(SecureContextHelper secureContextHelper, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, Lazy<FbErrorReporter> lazy, Lazy<QeAccessor> lazy2) {
        this.f611c = secureContextHelper;
        this.f612d = activityRuntimePermissionsManagerProvider;
        this.f613e = lazy;
        this.f614f = lazy2;
    }

    public final void m651a(Activity activity, GraphQLProfilePictureActionLinkType graphQLProfilePictureActionLinkType, @Nullable String str, @Nullable String str2, String str3, ImageOverlayFieldsModel imageOverlayFieldsModel, long j, @Nullable PromptAnalytics promptAnalytics, int i) {
        if (i == 1 && !(((QeAccessor) this.f614f.get()).a(ExperimentsForTimelineAbTestModule.aK, false) && ((QeAccessor) this.f614f.get()).a(ExperimentsForProfilePictureOverlayAbTestModule.g, false))) {
            i = 0;
        }
        String uuid = SafeUUIDGenerator.a().toString();
        if (graphQLProfilePictureActionLinkType == GraphQLProfilePictureActionLinkType.SUGGESTED_OVERLAYS) {
            m652a(activity, ((Builder) ((Builder) ((Builder) ((Builder) new Builder(uuid, str3).c(imageOverlayFieldsModel.c()).a(str)).b(str2)).a(j)).a(i)).a());
        } else if (ImageOverlayValidator.a(imageOverlayFieldsModel)) {
            m650a(activity, 8371, ((ProfilePictureOverlayCameraIntentData.Builder) ((ProfilePictureOverlayCameraIntentData.Builder) ((ProfilePictureOverlayCameraIntentData.Builder) ((ProfilePictureOverlayCameraIntentData.Builder) ((ProfilePictureOverlayCameraIntentData.Builder) new ProfilePictureOverlayCameraIntentData.Builder(imageOverlayFieldsModel, uuid, str3).a(str)).b(str2)).a(j)).a(promptAnalytics)).a(i)).a());
        } else {
            ((AbstractFbErrorReporter) this.f613e.get()).b("profile_picture_overlay_launcher", StringLocaleUtil.a("Insufficient information to launch profile picture overlay flow; imageOverlay: %s", new Object[]{ImageOverlayValidator.c(imageOverlayFieldsModel)}));
        }
    }

    @VisibleForTesting
    public final void m652a(Context context, ProfilePictureOverlayPivotIntentData profilePictureOverlayPivotIntentData) {
        Intent intent = new Intent(context, ProfilePictureOverlayPivotActivity.class);
        intent.putExtra("heisman_pivot_intent_data", profilePictureOverlayPivotIntentData);
        this.f611c.a(intent, context);
    }

    @VisibleForTesting
    public final void m650a(final Activity activity, final int i, final ProfilePictureOverlayCameraIntentData profilePictureOverlayCameraIntentData) {
        String[] strArr;
        ActivityRuntimePermissionsManager a = this.f612d.a(activity);
        if (profilePictureOverlayCameraIntentData.i() == 0) {
            strArr = f608a;
        } else {
            strArr = f609b;
        }
        a.a(strArr, new AbstractRuntimePermissionsListener(this) {
            final /* synthetic */ ProfilePictureOverlayActivityLauncher f607d;

            public final void m647a() {
                Intent intent = new Intent(activity, ProfilePictureOverlayCameraActivity.class);
                intent.putExtra("heisman_camera_intent_data", profilePictureOverlayCameraIntentData);
                this.f607d.f611c.a(intent, i, activity);
            }
        });
    }
}
