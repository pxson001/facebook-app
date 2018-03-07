package com.facebook.katana.platform;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.uri.FbUriResolver;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.PlatformConfiguration;
import com.facebook.ipc.composer.intent.SharePreview;
import com.facebook.ipc.composer.model.ComposerLocationInfo;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.ipc.media.MediaItem;
import com.facebook.katana.platform.handler.AddPendingMediaUploadAppCallOperation$Params;
import com.facebook.katana.platform.handler.CopyPlatformAppContentToTempFileOperation$Params;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.photos.base.media.MediaItemFactory.FallbackMediaId;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.platform.PlatformAnalyticsEventBuilder;
import com.facebook.platform.common.PlatformConstants.MediaType;
import com.facebook.platform.composer.logging.PlatformComposerPerformanceLogger;
import com.facebook.platform.feed.PlatformActivityFeedDialogRequest;
import com.facebook.platformattribution.PlatformAttributionLaunchHelper;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.runtimepermissions.RuntimePermissionsManager.RuntimePermissionsListener;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.SettableFuture;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: uffxrfwwwboyzxc */
public class FeedDialogActionExecutor extends BaseShareDialogExecutor {
    private static final Class<?> f1073k = FeedDialogActionExecutor.class;
    private final ComposerPublishServiceHelper f1074l;
    private final ComposerConfigurationFactory f1075m;
    public final PlatformActivityFeedDialogRequest f1076n;
    private final FbUriResolver f1077o;
    public final MediaItemFactory f1078p;
    private final ActivityRuntimePermissionsManagerProvider f1079q;

    /* compiled from: uffxrfwwwboyzxc */
    class C01751 implements AsyncFunction<Builder, Builder> {
        final /* synthetic */ FeedDialogActionExecutor f1062a;

        C01751(FeedDialogActionExecutor feedDialogActionExecutor) {
            this.f1062a = feedDialogActionExecutor;
        }

        public final ListenableFuture m1091a(Object obj) {
            Builder builder = (Builder) obj;
            BaseShareDialogExecutor baseShareDialogExecutor = this.f1062a;
            builder.setNectarModule("platform_composer").setDisablePhotos(true);
            CheckinPlaceModel c = BaseShareDialogExecutor.m1077c(baseShareDialogExecutor.f1076n.a);
            if (c != null) {
                builder.setInitialLocationInfo(ComposerLocationInfo.newBuilder().b(c).b());
            }
            String str = baseShareDialogExecutor.f1076n.l;
            if (!(baseShareDialogExecutor.f1076n.h == null && !baseShareDialogExecutor.f1046d && Strings.isNullOrEmpty(str))) {
                PlatformConfiguration.Builder a = builder.a().getPlatformConfiguration().a();
                if (baseShareDialogExecutor.f1076n.h != null) {
                    a.d = baseShareDialogExecutor.f1076n.h;
                }
                if (baseShareDialogExecutor.f1046d) {
                    a.c = true;
                }
                a.e = str;
                builder.setPlatformConfiguration(a.a());
            }
            ListenableFuture a2 = (baseShareDialogExecutor.f1076n.b == null || baseShareDialogExecutor.f1076n.b.isEmpty()) ? Futures.a(builder) : baseShareDialogExecutor.m1080a(baseShareDialogExecutor.f1076n.b, builder);
            return a2;
        }
    }

    /* compiled from: uffxrfwwwboyzxc */
    class C01762 implements AsyncFunction<Void, Builder> {
        final /* synthetic */ FeedDialogActionExecutor f1063a;

        C01762(FeedDialogActionExecutor feedDialogActionExecutor) {
            this.f1063a = feedDialogActionExecutor;
        }

        public final ListenableFuture m1092a(Object obj) {
            return FeedDialogActionExecutor.m1101d(this.f1063a);
        }
    }

    /* compiled from: uffxrfwwwboyzxc */
    class C01784 implements AsyncFunction<Void, Builder> {
        final /* synthetic */ FeedDialogActionExecutor f1066a;

        C01784(FeedDialogActionExecutor feedDialogActionExecutor) {
            this.f1066a = feedDialogActionExecutor;
        }

        public final ListenableFuture m1096a(Object obj) {
            return FeedDialogActionExecutor.m1105h(this.f1066a);
        }
    }

    /* compiled from: uffxrfwwwboyzxc */
    class C01795 implements AsyncFunction<Void, Builder> {
        final /* synthetic */ FeedDialogActionExecutor f1067a;

        C01795(FeedDialogActionExecutor feedDialogActionExecutor) {
            this.f1067a = feedDialogActionExecutor;
        }

        public final ListenableFuture m1097a(Object obj) {
            return FeedDialogActionExecutor.m1107j(this.f1067a);
        }
    }

    /* compiled from: uffxrfwwwboyzxc */
    /* synthetic */ class C01828 {
        static final /* synthetic */ int[] f1072a = new int[MediaType.values().length];

        static {
            try {
                f1072a[MediaType.PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1072a[MediaType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    @Inject
    public FeedDialogActionExecutor(@Assisted Activity activity, @Assisted PlatformActivityFeedDialogRequest platformActivityFeedDialogRequest, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, AnalyticsLogger analyticsLogger, ComposerPublishServiceHelper composerPublishServiceHelper, ComposerConfigurationFactory composerConfigurationFactory, Executor executor, FbUriResolver fbUriResolver, MediaItemFactory mediaItemFactory, ListeningExecutorService listeningExecutorService, PlatformAttributionLaunchHelper platformAttributionLaunchHelper, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, PlatformComposerPerformanceLogger platformComposerPerformanceLogger, SecureContextHelper secureContextHelper) {
        super(defaultBlueServiceOperationFactory, analyticsLogger, executor, activity, 115, platformActivityFeedDialogRequest.a(), platformActivityFeedDialogRequest.k(), listeningExecutorService, platformAttributionLaunchHelper, platformComposerPerformanceLogger, secureContextHelper);
        this.f1074l = composerPublishServiceHelper;
        this.f1075m = composerConfigurationFactory;
        this.f1076n = platformActivityFeedDialogRequest;
        this.f1077o = fbUriResolver;
        this.f1078p = mediaItemFactory;
        this.f1079q = activityRuntimePermissionsManagerProvider;
    }

    protected final ListenableFuture<Builder> mo41b() {
        int i;
        ListenableFuture a;
        int i2 = 1;
        int i3 = !StringUtil.a(this.f1076n.c) ? 1 : 0;
        boolean q = this.f1076n.q();
        boolean r = this.f1076n.r();
        boolean s = this.f1076n.s();
        if (i3 == 0) {
            i2 = 0;
        }
        if (q) {
            i2++;
        }
        if (r) {
            i2++;
        }
        if (s) {
            i = i2 + 1;
        } else {
            i = i2;
        }
        switch (i) {
            case 0:
                a = Futures.a(ComposerConfigurationFactory.a(ComposerSourceSurface.THIRD_PARTY_APP_VIA_FB_API, "feedDialogActionExecutorStatus").setDisableAttachToAlbum(true).setReactionSurface(Surface.ANDROID_PLATFORM_COMPOSER));
                break;
            case 1:
                if (!q) {
                    if (!r) {
                        if (i3 == 0) {
                            if (!s) {
                                a = null;
                                break;
                            }
                            a = m1106i();
                            break;
                        }
                        a = Futures.a(m1108k());
                        break;
                    }
                    a = m1104g();
                    break;
                }
                a = m1102e();
                break;
            default:
                m1083a("Only one of link, photos, and video should be specified.");
                a = Futures.a(new RuntimeException("Only one of link, photos, and video should be specified."));
                break;
        }
        Preconditions.checkNotNull(a);
        return Futures.b(a, new C01751(this), this.f1049g);
    }

    public static ListenableFuture m1101d(FeedDialogActionExecutor feedDialogActionExecutor) {
        ArrayList arrayList = feedDialogActionExecutor.f1076n.i;
        List arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) arrayList.get(i);
            Bundle bundle = new Bundle();
            bundle.putString("type", MediaType.PHOTO.name());
            bundle.putString("uri", str);
            arrayList2.add(bundle);
        }
        return feedDialogActionExecutor.m1100a(arrayList2);
    }

    private ListenableFuture<Builder> m1102e() {
        return Futures.b(m1103f(), new C01762(this), this.f1049g);
    }

    private ListenableFuture<Void> m1103f() {
        String[] strArr = new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
        ActivityRuntimePermissionsManager a = this.f1079q.a(this.f1047e);
        a.a(strArr);
        if (a.a(strArr)) {
            return Futures.a(null);
        }
        final ListenableFuture<Void> f = SettableFuture.f();
        a.a(strArr, this.f1047e.getString(2131241489), this.f1047e.getString(2131241490), new RuntimePermissionsListener(this) {
            final /* synthetic */ FeedDialogActionExecutor f1065b;

            public final void m1093a() {
                FutureDetour.a(f, null, 1585408742);
            }

            public final void m1094a(String[] strArr, String[] strArr2) {
                f.a(new RuntimeException("Permission Error"));
            }

            public final void m1095b() {
                f.a(new RuntimeException("Permission Error"));
            }
        });
        return f;
    }

    private ListenableFuture<Builder> m1104g() {
        return Futures.b(m1103f(), new C01784(this), this.f1049g);
    }

    public static ListenableFuture m1105h(FeedDialogActionExecutor feedDialogActionExecutor) {
        String str = feedDialogActionExecutor.f1076n.j;
        if (FbUriResolver.a(Uri.parse(str))) {
            Bundle bundle = new Bundle();
            bundle.putString("type", MediaType.VIDEO.name());
            bundle.putString("uri", str);
            return feedDialogActionExecutor.m1100a(Lists.a(new Bundle[]{bundle}));
        }
        return Futures.a(ComposerConfigurationFactory.a(ComposerSourceSurface.THIRD_PARTY_APP_VIA_FB_API, "feedDialogActionExecutorVideo").setInitialAttachments(ComposerAttachment.a(ImmutableList.of(Uri.parse(str)), feedDialogActionExecutor.f1078p)).setReactionSurface(Surface.ANDROID_PLATFORM_COMPOSER));
    }

    private ListenableFuture<Builder> m1106i() {
        return Futures.b(m1103f(), new C01795(this), this.f1049g);
    }

    public static ListenableFuture m1107j(FeedDialogActionExecutor feedDialogActionExecutor) {
        return feedDialogActionExecutor.m1100a((List) feedDialogActionExecutor.f1076n.m);
    }

    private ListenableFuture<Builder> m1100a(final List<Bundle> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            for (Bundle bundle : list) {
                String string = bundle.getString("uri");
                switch (C01828.f1072a[MediaType.valueOf(bundle.getString("type")).ordinal()]) {
                    case 1:
                        arrayList.add(string);
                        break;
                    case 2:
                        arrayList2.add(string);
                        break;
                    default:
                        break;
                }
            }
            ListenableFuture a = m1099a(arrayList, ".jpeg", "Failed to copy image.");
            ListenableFuture a2 = m1099a(arrayList2, ".mp4", "Failed to copy video.");
            return Futures.b(Futures.a(new ListenableFuture[]{a, a2}), new AsyncFunction<List<OperationResult>, Builder>(this) {
                final /* synthetic */ FeedDialogActionExecutor f1069b;

                public final ListenableFuture m1098a(@Nullable Object obj) {
                    List<OperationResult> list = (List) obj;
                    if (list == null) {
                        this.f1069b.m1083a("Failed to copy media.");
                        return Futures.a(new RuntimeException("Failed to copy media."));
                    }
                    HashMap hashMap = new HashMap();
                    for (OperationResult operationResult : list) {
                        if (operationResult == null || !operationResult.b) {
                            this.f1069b.m1083a("Failed to copy media.");
                            return Futures.a(new RuntimeException("Failed to copy media."));
                        }
                        Bundle bundle = (Bundle) operationResult.h();
                        for (String str : bundle.keySet()) {
                            hashMap.put(str, bundle.getString(str));
                        }
                    }
                    ImmutableList.Builder builder = new ImmutableList.Builder();
                    for (Bundle bundle2 : list) {
                        MediaItem a = this.f1069b.f1078p.a(Uri.fromFile(new File((String) hashMap.get(bundle2.getString("uri")))), FallbackMediaId.DEFAULT);
                        if (a != null) {
                            builder.c(a);
                        }
                    }
                    FeedDialogActionExecutor feedDialogActionExecutor = this.f1069b;
                    return Futures.a(ComposerConfigurationFactory.a(ComposerSourceSurface.THIRD_PARTY_APP_VIA_FB_API, "feedDialogActionExecutorMedia").setReactionSurface(Surface.ANDROID_PLATFORM_COMPOSER).setInitialAttachments(ComposerAttachment.a(builder.b())));
                }
            }, this.f1049g);
        } catch (IllegalArgumentException e) {
            return Futures.a(new IllegalArgumentException("Invalid media type specified."));
        }
    }

    private Builder m1108k() {
        String str = this.f1076n.c;
        String str2 = this.f1076n.d;
        String str3 = this.f1076n.e;
        String str4 = this.f1076n.f;
        String str5 = this.f1076n.g;
        String str6 = this.f1076n.k;
        String str7 = !Strings.isNullOrEmpty(str5) ? str5 : str4;
        SharePreview.Builder builder = new SharePreview.Builder();
        builder.a = str3;
        builder = builder;
        builder.b = str7;
        SharePreview.Builder builder2 = builder;
        builder2.d = str2;
        builder2 = builder2;
        builder2.e = true;
        SharePreview a = builder2.a();
        ComposerShareParams.Builder a2 = ComposerShareParams.Builder.a(str);
        a2.d = a;
        ComposerShareParams.Builder builder3 = a2;
        if (!StringUtil.a(str6)) {
            builder3.f = str6;
        }
        Builder reactionSurface = ComposerConfigurationFactory.a(ComposerSourceSurface.THIRD_PARTY_APP_VIA_FB_API, "feedDialogActionExecutorForLinkShare").setComposerType(ComposerType.SHARE).setInitialShareParams(builder3.b()).setDisableAttachToAlbum(true).setReactionSurface(Surface.ANDROID_PLATFORM_COMPOSER);
        PlatformConfiguration.Builder builder4 = new PlatformConfiguration.Builder();
        builder4.f = str3;
        builder4 = builder4;
        builder4.g = str4;
        PlatformConfiguration.Builder builder5 = builder4;
        builder5.i = str5;
        PlatformConfiguration.Builder builder6 = builder5;
        builder6.h = str2;
        return reactionSurface.setPlatformConfiguration(builder6.a());
    }

    private ListenableFuture<OperationResult> m1099a(ArrayList<String> arrayList, String str, final String str2) {
        Parcelable copyPlatformAppContentToTempFileOperation$Params = new CopyPlatformAppContentToTempFileOperation$Params(this.f1048f.a, arrayList, str);
        Bundle bundle = new Bundle();
        bundle.putParcelable("platform_copy_platform_app_content_params", copyPlatformAppContentToTempFileOperation$Params);
        ListenableFuture<OperationResult> a = BlueServiceOperationFactoryDetour.a(this.f1044b, "platform_copy_platform_app_content", bundle, 120927674).a();
        Futures.a(a, new FutureCallback<OperationResult>(this) {
            final /* synthetic */ FeedDialogActionExecutor f1071b;

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            }

            public void onFailure(Throwable th) {
                this.f1071b.m1083a(str2);
            }
        }, this.f1049g);
        return a;
    }

    protected final ListenableFuture<OperationResult> mo39a(Intent intent) {
        if (!this.f1076n.q() && !this.f1076n.r() && !this.f1076n.s()) {
            return this.f1074l.c(intent);
        }
        Parcelable addPendingMediaUploadAppCallOperation$Params = new AddPendingMediaUploadAppCallOperation$Params(this.f1048f, ((PublishPostParams) intent.getParcelableExtra("publishPostParams")).composerSessionId);
        Bundle bundle = new Bundle();
        bundle.putParcelable("platform_add_pending_media_upload_params", addPendingMediaUploadAppCallOperation$Params);
        return BlueServiceOperationFactoryDetour.a(this.f1044b, "platform_add_pending_media_upload", bundle, -930248243).a();
    }

    protected final PlatformAnalyticsEventBuilder mo40b(String str) {
        int size;
        PlatformAnalyticsEventBuilder b = super.mo40b(str);
        b.h = "android_feed_dialog";
        b = b;
        PlatformActivityFeedDialogRequest platformActivityFeedDialogRequest = this.f1076n;
        if (platformActivityFeedDialogRequest.q()) {
            size = platformActivityFeedDialogRequest.i.size();
        } else {
            size = 0;
        }
        b.i = size;
        b = b;
        b.j = this.f1076n.r();
        b = b;
        b.m = this.f1076n.o;
        b = b;
        b.g = "share";
        return b;
    }
}
