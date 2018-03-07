package com.facebook.timeline.protiles.util;

import android.content.Context;
import android.os.Bundle;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.DraweeView;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataModel;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams.Builder;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParamProvider;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParams;
import com.facebook.photos.mediagallery.launcher.animation.DrawingRule;
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.timeline.intent.ModelBundleGraphQLModels.ModelBundleProfileGraphQLModel;
import com.facebook.timeline.protiles.model.ProtileModel;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.ProtileItemFieldsModel;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: fb4a_registration_upsell_campaign */
public class ProtilesClickHandler {
    private static volatile ProtilesClickHandler f12362d;
    private final FbUriIntentHandler f12363a;
    private final Provider<MediaGalleryLauncher> f12364b;
    private final Provider<MediaGalleryLauncherParamsFactory> f12365c;

    public static com.facebook.timeline.protiles.util.ProtilesClickHandler m12399a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12362d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.protiles.util.ProtilesClickHandler.class;
        monitor-enter(r1);
        r0 = f12362d;	 Catch:{ all -> 0x003a }
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
        r0 = m12401b(r0);	 Catch:{ all -> 0x0035 }
        f12362d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12362d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.protiles.util.ProtilesClickHandler.a(com.facebook.inject.InjectorLike):com.facebook.timeline.protiles.util.ProtilesClickHandler");
    }

    private static ProtilesClickHandler m12401b(InjectorLike injectorLike) {
        return new ProtilesClickHandler(FbUriIntentHandler.a(injectorLike), IdBasedProvider.a(injectorLike, 9351), IdBasedSingletonScopeProvider.a(injectorLike, 9346));
    }

    @Inject
    public ProtilesClickHandler(FbUriIntentHandler fbUriIntentHandler, Provider<MediaGalleryLauncher> provider, Provider<MediaGalleryLauncherParamsFactory> provider2) {
        this.f12363a = fbUriIntentHandler;
        this.f12364b = provider;
        this.f12365c = provider2;
    }

    public final void m12403a(final DraweeView<GenericDraweeHierarchy> draweeView, final String str, @Nullable DefaultImageFields defaultImageFields, @Nullable String str2, ProtileModel protileModel) {
        Builder a;
        if (str2 != null) {
            this.f12365c.get();
            a = MediaGalleryLauncherParamsFactory.a(str2);
        } else {
            this.f12365c.get();
            a = MediaGalleryLauncherParamsFactory.f(ImmutableList.of(str));
        }
        final ImageRequest a2 = defaultImageFields != null ? ImageRequest.a(defaultImageFields.b()) : null;
        ((MediaGalleryLauncher) this.f12364b.get()).a(draweeView.getContext(), a.a(FullscreenGallerySource.TIMELINE_PHOTOS_OF_USER).a(str).a(a2).a(m12400a(protileModel)).b(), new AnimationParamProvider(this) {
            final /* synthetic */ ProtilesClickHandler f12361d;

            public final AnimationParams m12398a(String str) {
                if (str.equals(str)) {
                    return new AnimationParams(DrawingRule.a(draweeView), a2);
                }
                return null;
            }
        });
    }

    private static ImmutableList<MediaMetadata> m12400a(ProtileModel protileModel) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        ImmutableList immutableList = protileModel.f12107c;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ProtileItemFieldsModel protileItemFieldsModel = (ProtileItemFieldsModel) immutableList.get(i);
            MediaMetadataModel.Builder builder2 = new MediaMetadataModel.Builder();
            builder2.y = protileItemFieldsModel.m12184k().m12151d();
            builder2 = builder2;
            builder2.C = DefaultImageFieldsModel.a(protileItemFieldsModel.m12184k().m12163t());
            builder2 = builder2;
            builder2.D = DefaultImageFieldsModel.a(protileItemFieldsModel.m12184k().m12164u());
            builder2 = builder2;
            builder2.A = DefaultImageFieldsModel.a(protileItemFieldsModel.m12184k().m12162s());
            builder2 = builder2;
            builder2.z = DefaultImageFieldsModel.a(protileItemFieldsModel.m12184k().m12161r());
            builder.c(builder2.a());
        }
        return builder.b();
    }

    public final void m12402a(Context context, String str, @Nullable DefaultImageFields defaultImageFields, String str2, GraphQLFriendshipStatus graphQLFriendshipStatus, boolean z) {
        Bundle bundle = new Bundle();
        ModelBundleProfileGraphQLModel.Builder builder = new ModelBundleProfileGraphQLModel.Builder();
        builder.c = str;
        builder = builder;
        builder.d = str2;
        builder = builder;
        builder.e = DefaultImageFieldsModel.a(defaultImageFields);
        builder = builder;
        builder.b = graphQLFriendshipStatus;
        ModelBundle.a(bundle, builder.a());
        bundle.putBoolean("timeline_has_unseen_section", z);
        this.f12363a.a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, str), bundle);
    }
}
