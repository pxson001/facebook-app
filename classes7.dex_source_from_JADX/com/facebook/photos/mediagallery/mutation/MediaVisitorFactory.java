package com.facebook.photos.mediagallery.mutation;

import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLMedia.Builder;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.querybuilder.convertible.DefaultGraphQLConversionHelper;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLModels.SizeAwareMediaModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataWithoutFeedbackModel.ExplicitPlaceModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataWithoutFeedbackModel.PendingPlaceModel;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import javax.inject.Singleton;

@Singleton
/* compiled from: is_self_location */
public class MediaVisitorFactory {
    private static volatile MediaVisitorFactory f10770a;

    /* compiled from: is_self_location */
    public class C09141 extends SimpleMediaTransform {
        final /* synthetic */ DefaultTextWithEntitiesLongFields f10757a;
        final /* synthetic */ MediaVisitorFactory f10758b;

        public C09141(MediaVisitorFactory mediaVisitorFactory, String str, DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields) {
            this.f10758b = mediaVisitorFactory;
            this.f10757a = defaultTextWithEntitiesLongFields;
            super(str);
        }

        public final GraphQLMedia mo604a(GraphQLMedia graphQLMedia) {
            Builder a = Builder.a(graphQLMedia);
            a.ay = DefaultGraphQLConversionHelper.m5800a(this.f10757a);
            return a.a();
        }

        public final MediaMetadataModel mo605a(MediaMetadataModel mediaMetadataModel) {
            MediaMetadataModel.Builder a = MediaMetadataModel.Builder.a(mediaMetadataModel);
            a.K = DefaultTextWithEntitiesLongFieldsModel.a(this.f10757a);
            return a.a();
        }
    }

    /* compiled from: is_self_location */
    public class C09152 extends SimpleMediaTransform {
        final /* synthetic */ MediaVisitorFactory f10759a;

        public C09152(MediaVisitorFactory mediaVisitorFactory, String str) {
            this.f10759a = mediaVisitorFactory;
            super(str);
        }

        public final GraphQLMedia mo604a(GraphQLMedia graphQLMedia) {
            return null;
        }

        public final MediaMetadataModel mo605a(MediaMetadataModel mediaMetadataModel) {
            return null;
        }

        public final SizeAwareMediaModel mo606a(SizeAwareMediaModel sizeAwareMediaModel) {
            return null;
        }
    }

    /* compiled from: is_self_location */
    public class C09163 extends SimpleMediaTransform {
        final /* synthetic */ CheckinPlaceModel f10760a;
        final /* synthetic */ String f10761b;
        final /* synthetic */ MediaVisitorFactory f10762c;

        public C09163(MediaVisitorFactory mediaVisitorFactory, String str, CheckinPlaceModel checkinPlaceModel, String str2) {
            this.f10762c = mediaVisitorFactory;
            this.f10760a = checkinPlaceModel;
            this.f10761b = str2;
            super(str);
        }

        public final GraphQLMedia mo604a(GraphQLMedia graphQLMedia) {
            Builder a = Builder.a(graphQLMedia);
            a.A = MediaVisitorFactory.m12793a(this.f10762c, this.f10760a, this.f10761b);
            return a.a();
        }

        public final MediaMetadataModel mo605a(MediaMetadataModel mediaMetadataModel) {
            ExplicitPlaceModel explicitPlaceModel = null;
            ExplicitPlaceModel.Builder builder;
            if (this.f10760a != null) {
                builder = new ExplicitPlaceModel.Builder();
                builder.c = this.f10760a.j();
                builder = builder;
                builder.b = this.f10760a.cf_();
                explicitPlaceModel = builder.a();
            } else if (this.f10761b != null) {
                builder = new ExplicitPlaceModel.Builder();
                builder.c = this.f10761b;
                builder = builder;
                builder.b = "0";
                explicitPlaceModel = builder.a();
            }
            MediaMetadataModel.Builder a = MediaMetadataModel.Builder.a(mediaMetadataModel);
            a.s = explicitPlaceModel;
            return a.a();
        }
    }

    /* compiled from: is_self_location */
    public class C09174 extends SimpleMediaTransform {
        final /* synthetic */ CheckinPlaceModel f10763a;
        final /* synthetic */ String f10764b;
        final /* synthetic */ MediaVisitorFactory f10765c;

        public C09174(MediaVisitorFactory mediaVisitorFactory, String str, CheckinPlaceModel checkinPlaceModel, String str2) {
            this.f10765c = mediaVisitorFactory;
            this.f10763a = checkinPlaceModel;
            this.f10764b = str2;
            super(str);
        }

        public final GraphQLMedia mo604a(GraphQLMedia graphQLMedia) {
            Builder a = Builder.a(graphQLMedia);
            a.aG = MediaVisitorFactory.m12793a(this.f10765c, this.f10763a, this.f10764b);
            return a.a();
        }

        public final MediaMetadataModel mo605a(MediaMetadataModel mediaMetadataModel) {
            PendingPlaceModel pendingPlaceModel = null;
            PendingPlaceModel.Builder builder;
            if (this.f10763a != null) {
                builder = new PendingPlaceModel.Builder();
                builder.c = this.f10763a.j();
                builder = builder;
                builder.b = this.f10763a.cf_();
                pendingPlaceModel = builder.a();
            } else if (this.f10764b != null) {
                builder = new PendingPlaceModel.Builder();
                builder.c = this.f10764b;
                builder = builder;
                builder.b = "0";
                pendingPlaceModel = builder.a();
            }
            MediaMetadataModel.Builder a = MediaMetadataModel.Builder.a(mediaMetadataModel);
            a.M = pendingPlaceModel;
            return a.a();
        }
    }

    /* compiled from: is_self_location */
    public class C09185 extends SimpleMediaTransform {
        final /* synthetic */ String f10766a;
        final /* synthetic */ String f10767b;
        final /* synthetic */ MediaVisitorFactory f10768c;

        public C09185(MediaVisitorFactory mediaVisitorFactory, String str, String str2, String str3) {
            this.f10768c = mediaVisitorFactory;
            this.f10766a = str2;
            this.f10767b = str3;
            super(str);
        }

        public final GraphQLMedia mo604a(GraphQLMedia graphQLMedia) {
            GraphQLPlace.Builder builder = new GraphQLPlace.Builder();
            builder.q = this.f10766a;
            GraphQLPlace a = builder.c(this.f10767b).a();
            Builder a2 = Builder.a(graphQLMedia);
            a2.A = a;
            Builder builder2 = a2;
            builder2.av = null;
            return builder2.a();
        }

        public final MediaMetadataModel mo605a(MediaMetadataModel mediaMetadataModel) {
            ExplicitPlaceModel.Builder builder = new ExplicitPlaceModel.Builder();
            builder.b = this.f10766a;
            builder = builder;
            builder.c = this.f10767b;
            ExplicitPlaceModel a = builder.a();
            MediaMetadataModel.Builder a2 = MediaMetadataModel.Builder.a(mediaMetadataModel);
            a2.s = a;
            MediaMetadataModel.Builder builder2 = a2;
            builder2.J = null;
            return builder2.a();
        }
    }

    /* compiled from: is_self_location */
    public class C09196 extends SimpleMediaTransform {
        final /* synthetic */ MediaVisitorFactory f10769a;

        public C09196(MediaVisitorFactory mediaVisitorFactory, String str) {
            this.f10769a = mediaVisitorFactory;
            super(str);
        }

        public final GraphQLMedia mo604a(GraphQLMedia graphQLMedia) {
            Builder a = Builder.a(graphQLMedia);
            a.av = null;
            return a.a();
        }

        public final MediaMetadataModel mo605a(MediaMetadataModel mediaMetadataModel) {
            MediaMetadataModel.Builder a = MediaMetadataModel.Builder.a(mediaMetadataModel);
            a.J = null;
            return a.a();
        }
    }

    public static com.facebook.photos.mediagallery.mutation.MediaVisitorFactory m12795a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f10770a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.photos.mediagallery.mutation.MediaVisitorFactory.class;
        monitor-enter(r1);
        r0 = f10770a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m12794a();	 Catch:{ all -> 0x0034 }
        f10770a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f10770a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.mediagallery.mutation.MediaVisitorFactory.a(com.facebook.inject.InjectorLike):com.facebook.photos.mediagallery.mutation.MediaVisitorFactory");
    }

    private static MediaVisitorFactory m12794a() {
        return new MediaVisitorFactory();
    }

    static /* synthetic */ GraphQLPlace m12793a(MediaVisitorFactory mediaVisitorFactory, CheckinPlaceModel checkinPlaceModel, String str) {
        GraphQLPlace a;
        GraphQLPlace.Builder c;
        if (checkinPlaceModel != null) {
            c = new GraphQLPlace.Builder().c(checkinPlaceModel.j());
            c.q = checkinPlaceModel.cf_();
            a = c.a();
        } else if (str != null) {
            c = new GraphQLPlace.Builder().c(str);
            c.q = "0";
            a = c.a();
        } else {
            a = null;
        }
        return a;
    }
}
