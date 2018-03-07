package com.facebook.search.model.converter;

import com.facebook.graphql.enums.GraphQLPageCategoryType;
import com.facebook.placetips.bootstrap.PresenceSource;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLModels.LocationTriggerWithReactionUnitsModel.UnitsModel.PlacesModel;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLModels.LocationTriggerWithReactionUnitsModel.UnitsModel.PlacesModel.PageModel;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLModels.LocationTriggerWithReactionUnitsModel.UnitsModel.PlacesModel.PageModel.LocationModel;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchException;
import com.facebook.search.model.NearbyTypeaheadUnit;
import com.facebook.search.model.NearbyTypeaheadUnit.Builder;
import com.facebook.search.model.NullStateModuleSuggestionUnit.Type;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.inject.Singleton;

@Singleton
/* compiled from: liveStatusPoller */
public class NearbyEntitySuggestionGraphQLModelConverter {
    private static volatile NearbyEntitySuggestionGraphQLModelConverter f9284a;

    public static com.facebook.search.model.converter.NearbyEntitySuggestionGraphQLModelConverter m9664a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9284a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.search.model.converter.NearbyEntitySuggestionGraphQLModelConverter.class;
        monitor-enter(r1);
        r0 = f9284a;	 Catch:{ all -> 0x0039 }
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
        r0 = m9663a();	 Catch:{ all -> 0x0034 }
        f9284a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f9284a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.model.converter.NearbyEntitySuggestionGraphQLModelConverter.a(com.facebook.inject.InjectorLike):com.facebook.search.model.converter.NearbyEntitySuggestionGraphQLModelConverter");
    }

    private static NearbyEntitySuggestionGraphQLModelConverter m9663a() {
        return new NearbyEntitySuggestionGraphQLModelConverter();
    }

    public static NearbyTypeaheadUnit m9662a(PlacesModel placesModel, PresenceSource presenceSource, Type type, int i) {
        Preconditions.checkNotNull(placesModel);
        PageModel pageModel = (PageModel) Preconditions.checkNotNull(placesModel.a());
        String c = pageModel.c();
        String jd_ = pageModel.jd_();
        GraphQLPageCategoryType b = pageModel.b();
        LocationModel d = pageModel.d();
        String je_ = pageModel.je_();
        String b2 = pageModel.g() == null ? "" : pageModel.g().b();
        String a = placesModel.b() == null ? "" : placesModel.b().a();
        String a2 = placesModel.c() == null ? "" : placesModel.c().a();
        if (Strings.isNullOrEmpty(c)) {
            throw new GraphSearchException(GraphSearchError.BAD_NEARBY_SUGGESTION, "Got nearby entity suggestion without id!");
        } else if (Strings.isNullOrEmpty(jd_)) {
            throw new GraphSearchException(GraphSearchError.BAD_NEARBY_SUGGESTION, "Got nearby entity suggestion without name!");
        } else if (b == null) {
            throw new GraphSearchException(GraphSearchError.BAD_NEARBY_SUGGESTION, "Got nearby entity suggestion without category type!");
        } else if (d == null) {
            throw new GraphSearchException(GraphSearchError.BAD_NEARBY_SUGGESTION, "Got nearby entity suggestion without location!");
        } else if (Strings.isNullOrEmpty(je_)) {
            throw new GraphSearchException(GraphSearchError.BAD_NEARBY_SUGGESTION, "Got nearby entity suggestion without top category name!");
        } else if (Strings.isNullOrEmpty(b2)) {
            throw new GraphSearchException(GraphSearchError.BAD_NEARBY_SUGGESTION, "Got nearby entity suggestion without profile picture!");
        } else {
            Builder builder = new Builder();
            builder.a = c;
            Builder builder2 = builder;
            builder2.b = jd_;
            builder2 = builder2;
            builder2.d = b;
            builder2 = builder2.a(d.a(), d.b());
            builder2.f = je_;
            builder2 = builder2;
            builder2.c = b2;
            Builder builder3 = builder2;
            builder3.g = a;
            builder3 = builder3;
            builder3.h = a2;
            builder3 = builder3;
            builder3.i = presenceSource;
            builder3 = builder3.a(type);
            builder3.j = i;
            return new NearbyTypeaheadUnit(builder3);
        }
    }
}
