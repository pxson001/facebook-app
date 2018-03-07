package com.facebook.katana.platform;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.util.TriState;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.PlatformConfiguration;
import com.facebook.ipc.composer.intent.SharePreview;
import com.facebook.ipc.composer.model.ComposerLocationInfo;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.katana.platform.handler.CopyPlatformAppContentToTempFileOperation$Params;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.platform.PlatformAnalyticsEventBuilder;
import com.facebook.platform.common.server.PlatformCommonClient;
import com.facebook.platform.composer.logging.PlatformComposerPerformanceLogger;
import com.facebook.platform.opengraph.OpenGraphRequest;
import com.facebook.platform.opengraph.OpenGraphRequest.OpenGraphRequestException;
import com.facebook.platform.opengraph.OpenGraphRequest.SavedInstanceState;
import com.facebook.platform.opengraph.OpenGraphRequestFactory;
import com.facebook.platform.opengraph.PlatformActivityOpenGraphDialogRequest;
import com.facebook.platform.opengraph.server.UploadStagingResourcePhotosOperation.Params;
import com.facebook.platformattribution.PlatformAttributionLaunchHelper;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: ty960007weic55ndxxusjujo67fu20ppbozzhali8987co */
public class OpenGraphActionDialogActionExecutor extends BaseShareDialogExecutor {
    private static final Class<?> f1104k = OpenGraphActionDialogActionExecutor.class;
    private final PlatformPublishClient f1105l;
    private final PlatformCommonClient f1106m;
    private final OpenGraphRequestFactory f1107n;
    private final ComposerConfigurationFactory f1108o;
    private final Provider<TriState> f1109p;
    public final MediaItemFactory f1110q;
    private final PlatformActivityOpenGraphDialogRequest f1111r;
    private OpenGraphRequest f1112s;

    /* compiled from: ty960007weic55ndxxusjujo67fu20ppbozzhali8987co */
    class PreviewPropertyDoesNotExistException extends Exception {
        public PreviewPropertyDoesNotExistException() {
            super("Preview property does not exist.");
        }
    }

    @Inject
    public OpenGraphActionDialogActionExecutor(@Assisted Activity activity, @Assisted PlatformActivityOpenGraphDialogRequest platformActivityOpenGraphDialogRequest, BlueServiceOperationFactory blueServiceOperationFactory, AnalyticsLogger analyticsLogger, PlatformPublishClient platformPublishClient, Executor executor, ComposerConfigurationFactory composerConfigurationFactory, OpenGraphRequestFactory openGraphRequestFactory, Provider<TriState> provider, PlatformCommonClient platformCommonClient, MediaItemFactory mediaItemFactory, PlatformAttributionLaunchHelper platformAttributionLaunchHelper, ListeningExecutorService listeningExecutorService, PlatformComposerPerformanceLogger platformComposerPerformanceLogger, SecureContextHelper secureContextHelper) {
        super(blueServiceOperationFactory, analyticsLogger, executor, activity, 131, platformActivityOpenGraphDialogRequest.a(), platformActivityOpenGraphDialogRequest.g(), listeningExecutorService, platformAttributionLaunchHelper, platformComposerPerformanceLogger, secureContextHelper);
        this.f1105l = platformPublishClient;
        this.f1108o = composerConfigurationFactory;
        this.f1107n = openGraphRequestFactory;
        this.f1109p = provider;
        this.f1106m = platformCommonClient;
        this.f1110q = mediaItemFactory;
        this.f1111r = platformActivityOpenGraphDialogRequest;
        this.f1112s = this.f1107n.a(platformActivityOpenGraphDialogRequest);
    }

    public final void mo42a(Bundle bundle) {
        if (bundle != null) {
            this.f1112s = this.f1107n.a((SavedInstanceState) bundle.getParcelable("action_processor"));
        }
        super.mo42a(bundle);
    }

    public final void mo43b(Bundle bundle) {
        super.mo43b(bundle);
        bundle.putParcelable("action_processor", new SavedInstanceState(this.f1112s));
    }

    protected final ListenableFuture<Builder> mo41b() {
        try {
            this.f1112s.h();
            ObjectNode a = this.f1112s.a();
            try {
                Builder a2 = m1128a(a);
                m1134a(a2, a);
                return m1132a(m1130a(a2), a);
            } catch (Throwable e) {
                m1083a(e.getMessage());
                return Futures.a(e);
            }
        } catch (OpenGraphRequestException e2) {
            Bundle a3 = e2.a(this.f1048f);
            if (a3 != null) {
                c(a3);
            } else {
                m1083a(e2.getMessage());
            }
            return null;
        }
    }

    private boolean m1135d() {
        return !this.f1112s.f().isEmpty() && this.f1109p.get() == TriState.YES;
    }

    private void m1134a(Builder builder, ObjectNode objectNode) {
        JsonNode b = objectNode.b("place");
        if (b != null && b.o()) {
            builder.setInitialLocationInfo(ComposerLocationInfo.newBuilder().b(BaseShareDialogExecutor.m1077c(b.B())).b());
        }
        objectNode.h("place");
    }

    @Nullable
    private Builder m1128a(ObjectNode objectNode) {
        JsonNode b = objectNode.b(this.f1112s.e);
        if (b == null) {
            throw new PreviewPropertyDoesNotExistException();
        }
        PlatformConfiguration.Builder builder = new PlatformConfiguration.Builder();
        builder.c = this.f1046d;
        builder = builder;
        String str = this.f1112s.d;
        builder.a = objectNode.toString();
        builder.b = str;
        builder = builder;
        builder.e = this.f1111r.d;
        return ComposerConfigurationFactory.a(ComposerSourceSurface.THIRD_PARTY_APP_VIA_FB_API, "openGraphActionDialogActionExecutor").setComposerType(ComposerType.SHARE).setInitialShareParams(m1129a(b)).setDisableAttachToAlbum(true).setReactionSurface(Surface.ANDROID_PLATFORM_COMPOSER).setNectarModule("platform_composer").setDisablePhotos(true).setPlatformConfiguration(builder.a());
    }

    private ListenableFuture<Builder> m1132a(ListenableFuture<Builder> listenableFuture, ObjectNode objectNode) {
        JsonNode b = objectNode.b("tags");
        final ArrayList arrayList = new ArrayList();
        if (b != null && b.h()) {
            int e = b.e();
            for (int i = 0; i < e; i++) {
                arrayList.add(b.a(i).B());
            }
        }
        objectNode.h("tags");
        return Futures.b(listenableFuture, new AsyncFunction<Builder, Builder>(this) {
            final /* synthetic */ OpenGraphActionDialogActionExecutor f1098b;

            public final ListenableFuture m1125a(Object obj) {
                return this.f1098b.m1080a(arrayList, (Builder) obj);
            }
        }, this.f1050h);
    }

    private ListenableFuture<Builder> m1130a(final Builder builder) {
        if (!m1135d()) {
            return Futures.a(builder);
        }
        final ImmutableList.Builder builder2 = new ImmutableList.Builder();
        ArrayList a = Lists.a();
        Iterator it = this.f1112s.f().iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (uri.getScheme().startsWith("content")) {
                a.add(uri.toString());
            } else {
                builder2.c(uri);
            }
        }
        Parcelable copyPlatformAppContentToTempFileOperation$Params = new CopyPlatformAppContentToTempFileOperation$Params(this.f1048f.a, a, ".jpeg");
        Bundle bundle = new Bundle();
        bundle.putParcelable("platform_copy_platform_app_content_params", copyPlatformAppContentToTempFileOperation$Params);
        return Futures.b(BlueServiceOperationFactoryDetour.a(this.f1044b, "platform_copy_platform_app_content", bundle, -1458383091).a(), new AsyncFunction<OperationResult, Builder>(this) {
            final /* synthetic */ OpenGraphActionDialogActionExecutor f1101c;

            public final ListenableFuture m1126a(@Nullable Object obj) {
                OperationResult operationResult = (OperationResult) obj;
                if (operationResult == null || !operationResult.b) {
                    this.f1101c.m1083a("Failed to copy image.");
                    return Futures.a(new RuntimeException("Failed to copy image."));
                }
                Bundle bundle = (Bundle) operationResult.h();
                for (String string : bundle.keySet()) {
                    builder2.c(Uri.fromFile(new File(bundle.getString(string))));
                }
                return Futures.a(builder.setInitialAttachments(ComposerAttachment.a(builder2.b(), this.f1101c.f1110q)));
            }
        }, this.f1049g);
    }

    @Nullable
    private ComposerShareParams m1129a(JsonNode jsonNode) {
        String str = null;
        if (m1135d()) {
            return null;
        }
        Uri d = this.f1112s.d();
        SharePreview.Builder builder;
        if (!jsonNode.i()) {
            ComposerShareParams.Builder a;
            str = jsonNode.B();
            if (str == null || !str.startsWith("http")) {
                a = ComposerShareParams.Builder.a(GraphQLHelper.a(str, -1304042141));
            } else {
                a = ComposerShareParams.Builder.a(str);
            }
            if (d != null) {
                builder = new SharePreview.Builder();
                builder.d = d.toString();
                SharePreview.Builder builder2 = builder;
                builder2.e = true;
                a.d = builder2.a();
            }
            return a.b();
        } else if (!this.f1112s.a(this.f1112s.e)) {
            return null;
        } else {
            String a2 = m1133a(jsonNode, "title");
            String a3 = m1133a(jsonNode, "description");
            SharePreview.Builder builder3 = new SharePreview.Builder();
            builder3.a = a2;
            builder = builder3;
            builder.b = a3;
            builder = builder;
            if (d != null) {
                str = d.toString();
            }
            builder.d = str;
            SharePreview a4 = builder.a();
            ComposerShareParams.Builder a5 = ComposerShareParams.Builder.a();
            a5.d = a4;
            return a5.b();
        }
    }

    private static String m1133a(JsonNode jsonNode, String str) {
        JsonNode b = jsonNode.b(str);
        if (b == null) {
            b = jsonNode.b("og:" + str);
        }
        if (b == null || !b.o()) {
            return null;
        }
        return b.B();
    }

    protected final ListenableFuture<OperationResult> mo39a(final Intent intent) {
        if (this.f1112s.e().size() == 0) {
            return m1131a(this, intent, null);
        }
        PlatformPublishClient platformPublishClient = this.f1105l;
        ImmutableMap e = this.f1112s.e();
        Bundle bundle = new Bundle();
        bundle.putParcelable("platform_upload_staging_resource_photos_params", new Params(e));
        return Futures.b(BlueServiceOperationFactoryDetour.a(platformPublishClient.f1143b, "platform_upload_staging_resource_photos", bundle, 473815637).a(), new AsyncFunction<OperationResult, OperationResult>(this) {
            final /* synthetic */ OpenGraphActionDialogActionExecutor f1103b;

            public final ListenableFuture m1127a(Object obj) {
                return OpenGraphActionDialogActionExecutor.m1131a(this.f1103b, intent, (Bundle) ((OperationResult) obj).h());
            }
        });
    }

    public static ListenableFuture m1131a(OpenGraphActionDialogActionExecutor openGraphActionDialogActionExecutor, Intent intent, Bundle bundle) {
        ObjectNode a = openGraphActionDialogActionExecutor.f1112s.a(bundle);
        a.h("tags");
        a.h("place");
        return openGraphActionDialogActionExecutor.f1105l.m1167a(intent, openGraphActionDialogActionExecutor.f1112s.d, a);
    }

    protected final PlatformAnalyticsEventBuilder mo40b(String str) {
        PlatformAnalyticsEventBuilder b = super.mo40b(str);
        b.h = "android_og_dialog";
        b = b;
        b.g = "ogshare";
        return b;
    }

    public final void m1137a() {
        this.f1106m.a(this.f1048f.a);
        super.a();
    }
}
