package com.facebook.timeline.units.model;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.feed.server.FeedUnitFilter;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLTimelineSection;
import com.facebook.graphql.model.GraphQLTimelineSectionUnitsConnection;
import com.facebook.graphql.model.GraphQLTimelineSectionUnitsEdge;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.timeline.rows.TimelineViewTypeMapper;
import com.facebook.timeline.rows.TimelineViewTypeMapper.ViewTypes;
import com.google.common.base.Absent;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: extra_instant_articles_featured_element_id */
public class TimelineFilterHandler {
    private static volatile TimelineFilterHandler f12771e;
    private final String f12772a = "TimelineFilterHandler";
    private final Provider<TimelineViewTypeMapper> f12773b;
    private final Lazy<FeedUnitFilter> f12774c;
    public final Provider<FbErrorReporter> f12775d;

    public static com.facebook.timeline.units.model.TimelineFilterHandler m12732a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12771e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.units.model.TimelineFilterHandler.class;
        monitor-enter(r1);
        r0 = f12771e;	 Catch:{ all -> 0x003a }
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
        r0 = m12733b(r0);	 Catch:{ all -> 0x0035 }
        f12771e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12771e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.units.model.TimelineFilterHandler.a(com.facebook.inject.InjectorLike):com.facebook.timeline.units.model.TimelineFilterHandler");
    }

    private static TimelineFilterHandler m12733b(InjectorLike injectorLike) {
        return new TimelineFilterHandler(IdBasedSingletonScopeProvider.a(injectorLike, 11377), IdBasedLazy.a(injectorLike, 1712), IdBasedSingletonScopeProvider.a(injectorLike, 494));
    }

    @Inject
    public TimelineFilterHandler(Provider<TimelineViewTypeMapper> provider, Lazy<FeedUnitFilter> lazy, Provider<FbErrorReporter> provider2) {
        this.f12773b = provider;
        this.f12774c = lazy;
        this.f12775d = provider2;
    }

    public final GraphQLTimelineSection m12734a(GraphQLTimelineSection graphQLTimelineSection) {
        if (graphQLTimelineSection == null || graphQLTimelineSection.j() == null || graphQLTimelineSection.l() == null || graphQLTimelineSection.l().a() == null) {
            ((AbstractFbErrorReporter) this.f12775d.get()).a("TimelineFilterHandler", "Incomplete section data");
            throw new IllegalStateException(graphQLTimelineSection == null ? "section is null" : "a required field in section result is null");
        }
        Builder builder = ImmutableList.builder();
        ImmutableList a = graphQLTimelineSection.l().a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLTimelineSectionUnitsEdge graphQLTimelineSectionUnitsEdge = (GraphQLTimelineSectionUnitsEdge) a.get(i);
            this.f12773b.get();
            if (TimelineViewTypeMapper.m12587a(graphQLTimelineSectionUnitsEdge.j()) == ViewTypes.UNKNOWN) {
                FeedUnit j = graphQLTimelineSectionUnitsEdge.j();
                ((AbstractFbErrorReporter) this.f12775d.get()).a("TimelineFilterHandler", StringFormatUtil.formatStrLocaleSafe("The object isn't supported: [FeedUnit: %s]", j == null ? "null" : j.getClass().getSimpleName()));
            } else {
                FeedUnit a2 = ((FeedUnitFilter) this.f12774c.get()).a(graphQLTimelineSectionUnitsEdge.j(), Absent.INSTANCE);
                if (a2 != null) {
                    GraphQLTimelineSectionUnitsEdge.Builder builder2 = new GraphQLTimelineSectionUnitsEdge.Builder();
                    graphQLTimelineSectionUnitsEdge.h();
                    builder2.d = graphQLTimelineSectionUnitsEdge.a();
                    builder2.e = graphQLTimelineSectionUnitsEdge.j();
                    builder2.f = graphQLTimelineSectionUnitsEdge.k();
                    BaseModel.Builder.a(builder2, graphQLTimelineSectionUnitsEdge);
                    GraphQLTimelineSectionUnitsEdge.Builder builder3 = builder2;
                    builder3.e = a2;
                    builder.c(new GraphQLTimelineSectionUnitsEdge(builder3));
                }
            }
        }
        GraphQLTimelineSection.Builder builder4 = new GraphQLTimelineSection.Builder();
        graphQLTimelineSection.h();
        builder4.d = graphQLTimelineSection.j();
        builder4.e = graphQLTimelineSection.k();
        builder4.f = graphQLTimelineSection.l();
        builder4.g = graphQLTimelineSection.m();
        builder4.h = graphQLTimelineSection.n();
        BaseModel.Builder.a(builder4, graphQLTimelineSection);
        GraphQLTimelineSection.Builder builder5 = builder4;
        GraphQLTimelineSectionUnitsConnection l = graphQLTimelineSection.l();
        GraphQLTimelineSectionUnitsConnection.Builder builder6 = new GraphQLTimelineSectionUnitsConnection.Builder();
        l.h();
        builder6.d = l.a();
        builder6.e = l.j();
        BaseModel.Builder.a(builder6, l);
        GraphQLTimelineSectionUnitsConnection.Builder builder7 = builder6;
        builder7.d = builder.b();
        builder5.f = new GraphQLTimelineSectionUnitsConnection(builder7);
        return new GraphQLTimelineSection(builder5);
    }
}
