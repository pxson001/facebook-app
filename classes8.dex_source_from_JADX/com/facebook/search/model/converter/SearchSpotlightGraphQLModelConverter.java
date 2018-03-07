package com.facebook.search.model.converter;

import android.graphics.Color;
import com.facebook.graphql.enums.GraphQLSearchAwarenessTutorialNUXTemplate;
import com.facebook.inject.InjectorLike;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.common.errors.GraphSearchException;
import com.facebook.search.model.SearchSpotlightCardUnit;
import com.facebook.search.model.SearchSpotlightIntroUnit;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.TutorialNuxCardFieldsFragmentModel;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.TutorialNuxCarouselFieldsFragmentModel;
import com.facebook.ultralight.Inject;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: TF;) */
public class SearchSpotlightGraphQLModelConverter {
    private static volatile SearchSpotlightGraphQLModelConverter f22327b;
    private final GraphSearchErrorReporter f22328a;

    /* compiled from: TF;) */
    /* synthetic */ class C23721 {
        static final /* synthetic */ int[] f22326a = new int[GraphQLSearchAwarenessTutorialNUXTemplate.values().length];

        static {
            try {
                f22326a[GraphQLSearchAwarenessTutorialNUXTemplate.CARD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22326a[GraphQLSearchAwarenessTutorialNUXTemplate.INTRO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static com.facebook.search.model.converter.SearchSpotlightGraphQLModelConverter m25809a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f22327b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.model.converter.SearchSpotlightGraphQLModelConverter.class;
        monitor-enter(r1);
        r0 = f22327b;	 Catch:{ all -> 0x003a }
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
        r0 = m25810b(r0);	 Catch:{ all -> 0x0035 }
        f22327b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f22327b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.model.converter.SearchSpotlightGraphQLModelConverter.a(com.facebook.inject.InjectorLike):com.facebook.search.model.converter.SearchSpotlightGraphQLModelConverter");
    }

    private static SearchSpotlightGraphQLModelConverter m25810b(InjectorLike injectorLike) {
        return new SearchSpotlightGraphQLModelConverter(GraphSearchErrorReporter.a(injectorLike));
    }

    @Inject
    private SearchSpotlightGraphQLModelConverter(GraphSearchErrorReporter graphSearchErrorReporter) {
        this.f22328a = graphSearchErrorReporter;
    }

    public final ImmutableList<TypeaheadUnit> m25811a(@Nullable TutorialNuxCarouselFieldsFragmentModel tutorialNuxCarouselFieldsFragmentModel) {
        if (tutorialNuxCarouselFieldsFragmentModel == null) {
            return RegularImmutableList.a;
        }
        Builder builder = new Builder();
        ImmutableList j = tutorialNuxCarouselFieldsFragmentModel.m9049j();
        int size = j.size();
        for (int i = 0; i < size; i++) {
            Object a;
            TutorialNuxCardFieldsFragmentModel tutorialNuxCardFieldsFragmentModel = (TutorialNuxCardFieldsFragmentModel) j.get(i);
            switch (C23721.f22326a[tutorialNuxCardFieldsFragmentModel.m9042q().ordinal()]) {
                case 1:
                    SearchSpotlightCardUnit.Builder builder2 = new SearchSpotlightCardUnit.Builder();
                    builder2.f22258a = tutorialNuxCardFieldsFragmentModel.m9034a();
                    builder2 = builder2;
                    builder2.f22259b = Color.parseColor("#" + tutorialNuxCardFieldsFragmentModel.m9035j());
                    SearchSpotlightCardUnit searchSpotlightCardUnit = new SearchSpotlightCardUnit(builder2);
                    break;
                case 2:
                    SearchSpotlightIntroUnit.Builder builder3 = new SearchSpotlightIntroUnit.Builder();
                    builder3.f22263a = tutorialNuxCardFieldsFragmentModel.m9034a();
                    a = builder3.m25733a();
                    break;
                default:
                    this.f22328a.a(new GraphSearchException(GraphSearchError.BAD_SEARCH_SPOTLIGHT_SUGGESTION, "Unsupported Search Spotlight template: " + tutorialNuxCardFieldsFragmentModel.m9042q()));
                    a = null;
                    break;
            }
            if (a != null) {
                builder.c(a);
            }
        }
        return builder.b();
    }
}
