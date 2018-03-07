package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.abtest.ExperimentsForAdInterfacesModule;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.protocol.AdInterfacesAdPreviewQuery.AdInterfacesAdPreviewFeedUnitQueryString;
import com.facebook.adinterfaces.protocol.AdInterfacesAdPreviewQueryModels.AdInterfacesAdPreviewFeedUnitQueryModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel;
import com.facebook.adinterfaces.protocol.FetchAvailableAudiencesQuery.FetchAvailableAudiencesQueryString;
import com.facebook.adinterfaces.protocol.FetchAvailableAudiencesQueryModels.FetchAvailableAudiencesQueryModel;
import com.facebook.adinterfaces.protocol.FetchStoryPromotionQuery.FetchStoryPromotionQueryString;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.story.GraphQLStoryHelper;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: ZIP_INPUT_VA */
public class AdInterfacesQueryBuilder {
    private static volatile AdInterfacesQueryBuilder f21931c;
    public GraphQLStoryHelper f21932a;
    public QeAccessor f21933b;

    public static com.facebook.adinterfaces.protocol.AdInterfacesQueryBuilder m23051a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21931c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.adinterfaces.protocol.AdInterfacesQueryBuilder.class;
        monitor-enter(r1);
        r0 = f21931c;	 Catch:{ all -> 0x003a }
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
        r0 = m23052b(r0);	 Catch:{ all -> 0x0035 }
        f21931c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21931c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryBuilder.a(com.facebook.inject.InjectorLike):com.facebook.adinterfaces.protocol.AdInterfacesQueryBuilder");
    }

    private static AdInterfacesQueryBuilder m23052b(InjectorLike injectorLike) {
        return new AdInterfacesQueryBuilder(GraphQLStoryHelper.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public AdInterfacesQueryBuilder(GraphQLStoryHelper graphQLStoryHelper, QeAccessor qeAccessor) {
        this.f21932a = graphQLStoryHelper;
        this.f21933b = qeAccessor;
    }

    public final GraphQLRequest<FetchAvailableAudiencesQueryModel> m23056a(String str, String str2, String str3, int i, ObjectiveType objectiveType) {
        return GraphQLRequest.a((FetchAvailableAudiencesQueryString) m23053b(str, str2, str3, i, objectiveType));
    }

    private GraphQlQueryString m23053b(String str, String str2, String str3, int i, ObjectiveType objectiveType) {
        boolean z = true;
        GraphQlQueryString a = new FetchAvailableAudiencesQueryString().a("page_id", str).a("ad_account_id", str2).a("after_audience_id", str3).a("audience_count", Integer.valueOf(i)).a("is_page_like", Boolean.valueOf(objectiveType == ObjectiveType.PAGE_LIKE)).a("is_promote_website", Boolean.valueOf(objectiveType == ObjectiveType.PROMOTE_WEBSITE));
        String str4 = "is_cta";
        if (objectiveType != ObjectiveType.PROMOTE_CTA) {
            z = false;
        }
        return a.a(str4, Boolean.valueOf(z)).a("remove_audience_targeting_sentences", Boolean.valueOf(this.f21933b.a(ExperimentsForAdInterfacesModule.f21611h, false)));
    }

    public final GraphQLRequest<StoryPromotionModel> m23054a(String str, ObjectiveType objectiveType) {
        return GraphQLRequest.a((FetchStoryPromotionQueryString) new FetchStoryPromotionQueryString().a("fetch_event_info", Boolean.valueOf(objectiveType == ObjectiveType.BOOST_EVENT)).a("story_id", str).a("image_large_aspect_height", this.f21932a.z()).a("image_large_aspect_width", this.f21932a.y()));
    }

    public final GraphQLRequest<AdInterfacesAdPreviewFeedUnitQueryModel> m23055a(String str, String str2) {
        return GraphQLRequest.a((AdInterfacesAdPreviewFeedUnitQueryString) new AdInterfacesAdPreviewFeedUnitQueryString().a("creative_spec", str2).a("account_id", str).a("image_large_aspect_height", this.f21932a.z()).a("image_large_aspect_width", this.f21932a.y()));
    }
}
