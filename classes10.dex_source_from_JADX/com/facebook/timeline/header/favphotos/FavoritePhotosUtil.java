package com.facebook.timeline.header.favphotos;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.device.ScreenUtil;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel.Builder;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.CollageLayoutFields;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.FavoritePhoto;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.SuggestedPhoto;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.FavoritePhotoModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.IntroCardPhotoFieldsModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.SuggestedPhotoModel;
import com.facebook.timeline.util.ProfileMosaicUtil;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: file.encoding */
public class FavoritePhotosUtil {
    private static volatile FavoritePhotosUtil f11709d;
    private final ScreenUtil f11710a;
    private final Resources f11711b;
    private final GraphQLImageHelper f11712c;

    public static com.facebook.timeline.header.favphotos.FavoritePhotosUtil m11786a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11709d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.header.favphotos.FavoritePhotosUtil.class;
        monitor-enter(r1);
        r0 = f11709d;	 Catch:{ all -> 0x003a }
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
        r0 = m11790b(r0);	 Catch:{ all -> 0x0035 }
        f11709d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11709d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.header.favphotos.FavoritePhotosUtil.a(com.facebook.inject.InjectorLike):com.facebook.timeline.header.favphotos.FavoritePhotosUtil");
    }

    private static FavoritePhotosUtil m11790b(InjectorLike injectorLike) {
        return new FavoritePhotosUtil(ScreenUtil.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), GraphQLImageHelper.a(injectorLike));
    }

    @Inject
    public FavoritePhotosUtil(ScreenUtil screenUtil, Resources resources, GraphQLImageHelper graphQLImageHelper) {
        this.f11710a = screenUtil;
        this.f11711b = resources;
        this.f11712c = graphQLImageHelper;
    }

    public static FavoritePhotoModel m11787a(String str, String str2) {
        Builder builder = new Builder();
        builder.b = str2;
        DefaultImageFieldsModel a = builder.a();
        IntroCardPhotoFieldsModel.Builder builder2 = new IntroCardPhotoFieldsModel.Builder();
        builder2.d = str;
        builder2 = builder2;
        builder2.f = a;
        IntroCardPhotoFieldsModel a2 = builder2.a();
        FavoritePhotoModel.Builder builder3 = new FavoritePhotoModel.Builder();
        builder3.b = a2;
        return builder3.a();
    }

    public final int m11792a() {
        return GraphQLImageHelper.a((this.f11710a.c() - ((m11789b() * 2) + m11791c())) / 3).intValue();
    }

    public static ImmutableList<FavoritePhoto> m11788a(ImmutableList<? extends SuggestedPhoto> immutableList) {
        ImmutableList.Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            SuggestedPhotoModel suggestedPhotoModel = (SuggestedPhotoModel) immutableList.get(i);
            FavoritePhotoModel.Builder builder2 = new FavoritePhotoModel.Builder();
            builder2.a = null;
            builder2 = builder2;
            builder2.b = IntroCardPhotoFieldsModel.a(suggestedPhotoModel.a());
            builder.c(builder2.a());
        }
        return builder.b();
    }

    @Nullable
    public final DefaultImageFields m11793a(SizeAwareMedia sizeAwareMedia, CollageLayoutFields collageLayoutFields) {
        if (sizeAwareMedia == null) {
            return null;
        }
        if (collageLayoutFields == null) {
            return sizeAwareMedia.g();
        }
        int b = (int) collageLayoutFields.b();
        return ProfileMosaicUtil.a(sizeAwareMedia, b, 6, m11785a(b));
    }

    private int m11785a(int i) {
        int i2 = (6 / i) - 1;
        return this.f11710a.c() - ((i2 * m11789b()) + m11791c());
    }

    private int m11789b() {
        return this.f11711b.getDimensionPixelSize(2131429961);
    }

    private int m11791c() {
        return this.f11711b.getDimensionPixelSize(2131429957) * 2;
    }
}
