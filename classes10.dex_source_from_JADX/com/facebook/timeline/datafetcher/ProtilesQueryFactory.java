package com.facebook.timeline.datafetcher;

import com.facebook.graphql.calls.StylesInputStyles;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQL.TimelineProtilesQueryString;
import com.facebook.timeline.protiles.util.ProtilesQueryBuilder;
import com.facebook.timeline.protiles.util.TimelineCollapsedProtilesExperimentHelper;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: group_approve_all_pending_members */
public class ProtilesQueryFactory {
    private static volatile ProtilesQueryFactory f10421c;
    private final Provider<ProtilesQueryBuilder> f10422a;
    private final TimelineCollapsedProtilesExperimentHelper f10423b;

    public static com.facebook.timeline.datafetcher.ProtilesQueryFactory m10534a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10421c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.datafetcher.ProtilesQueryFactory.class;
        monitor-enter(r1);
        r0 = f10421c;	 Catch:{ all -> 0x003a }
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
        r0 = m10536b(r0);	 Catch:{ all -> 0x0035 }
        f10421c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10421c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.datafetcher.ProtilesQueryFactory.a(com.facebook.inject.InjectorLike):com.facebook.timeline.datafetcher.ProtilesQueryFactory");
    }

    private static ProtilesQueryFactory m10536b(InjectorLike injectorLike) {
        return new ProtilesQueryFactory(IdBasedSingletonScopeProvider.a(injectorLike, 11343), TimelineCollapsedProtilesExperimentHelper.m12438a(injectorLike));
    }

    @Inject
    public ProtilesQueryFactory(Provider<ProtilesQueryBuilder> provider, TimelineCollapsedProtilesExperimentHelper timelineCollapsedProtilesExperimentHelper) {
        this.f10422a = provider;
        this.f10423b = timelineCollapsedProtilesExperimentHelper;
    }

    public final TimelineProtilesQueryString m10537a(String str) {
        boolean a = this.f10423b.m12443a();
        return m10535a(str, a ? "PHOTOS, FRIENDS" : "FRIENDS", a);
    }

    public final TimelineProtilesQueryString m10538b(String str) {
        return m10535a(str, "PHOTOS, FRIENDS", this.f10423b.m12443a());
    }

    @Nullable
    private TimelineProtilesQueryString m10535a(String str, String str2, boolean z) {
        int a;
        ProtilesQueryBuilder protilesQueryBuilder = (ProtilesQueryBuilder) this.f10422a.get();
        GraphQlQueryString a2 = new TimelineProtilesQueryString().a("profile_id", str).a("icon_scale", GraphQlQueryDefaults.a()).a("view_styles", ImmutableList.of(StylesInputStyles.PHOTO_GRID, StylesInputStyles.FRIEND_GRID)).a("section_types_list", ProtilesQueryBuilder.m12436a(str2)).a("first_item_count", Integer.valueOf(6));
        String str3 = "tiny_required";
        boolean z2 = false;
        if (!protilesQueryBuilder.f12391c.a(ExperimentsForTimelineAbTestModule.aZ, false)) {
            z2 = protilesQueryBuilder.f12391c.a(ExperimentsForTimelineAbTestModule.aW, false);
        }
        a2 = a2.a(str3, Boolean.valueOf(z2)).a("tiny_profile_image_size", String.valueOf(protilesQueryBuilder.f12390b.m12428a()));
        str3 = "grid_profile_image_size";
        if (protilesQueryBuilder.f12391c.a(ExperimentsForTimelineAbTestModule.aZ, false)) {
            a = protilesQueryBuilder.f12390b.m12428a();
        } else if (protilesQueryBuilder.f12391c.a(ExperimentsForTimelineAbTestModule.aX, false)) {
            a = GraphQlQueryDefaults.c();
            int b = protilesQueryBuilder.f12390b.m12429b();
            if (b >= a * 2) {
                a = b;
            }
        } else {
            a = protilesQueryBuilder.f12390b.m12429b();
        }
        TimelineProtilesQueryString timelineProtilesQueryString = (TimelineProtilesQueryString) a2.a(str3, String.valueOf(a)).a("should_collapse", String.valueOf(z)).a("fetch_dominant_color", Boolean.valueOf(protilesQueryBuilder.f12391c.a(ExperimentsForTimelineAbTestModule.D, false))).a("automatic_photo_captioning_enabled", Boolean.toString(protilesQueryBuilder.f12394f.a()));
        if (protilesQueryBuilder.f12391c.a(ExperimentsForTimelineAbTestModule.aV, false)) {
            protilesQueryBuilder.f12393e.a(timelineProtilesQueryString, protilesQueryBuilder.f12392d.c());
        } else {
            String valueOf = String.valueOf(protilesQueryBuilder.f12390b.m12429b());
            timelineProtilesQueryString.a("image_low_width", valueOf);
            timelineProtilesQueryString.a("image_low_height", valueOf);
            valueOf = String.valueOf(protilesQueryBuilder.f12390b.m12431c());
            timelineProtilesQueryString.a("image_medium_width", valueOf);
            timelineProtilesQueryString.a("image_medium_height", valueOf);
            valueOf = String.valueOf(protilesQueryBuilder.f12390b.m12432d());
            timelineProtilesQueryString.a("image_high_width", valueOf);
            timelineProtilesQueryString.a("image_high_height", valueOf);
        }
        return timelineProtilesQueryString;
    }
}
