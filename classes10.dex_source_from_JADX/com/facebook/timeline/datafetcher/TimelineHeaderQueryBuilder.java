package com.facebook.timeline.datafetcher;

import com.facebook.accessibility.AutomaticPhotoCaptioningUtils;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.graphql.calls.RenderLocationInputRenderLocation;
import com.facebook.graphql.enums.GraphQLProfileWizardStepType;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.header.bio.IntroCardSuggestedBioExperimentController;
import com.facebook.timeline.header.favphotos.IntroCardSuggestedPhotosExperimentController;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQL.UserTimelineQueryString;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQL.UserTimelineSelfQueryString;
import com.facebook.timeline.protocol.FetchTimelineHeaderParams;
import com.facebook.timeline.viewfeaturedcontainers.abtest.FavPhotosVsFeaturedContainersController;
import com.facebook.timeline.widget.actionbar.PersonActionBarQueryParamsFactory;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: grid_item_view_holder */
public class TimelineHeaderQueryBuilder {
    private static volatile TimelineHeaderQueryBuilder f10542j;
    public final QeAccessor f10543a;
    private final FavPhotosVsFeaturedContainersController f10544b;
    private final IntroCardSuggestedPhotosExperimentController f10545c;
    private final IntroCardSuggestedBioExperimentController f10546d;
    @LoggedInUserId
    public final Provider<String> f10547e;
    private final PersonActionBarQueryParamsFactory f10548f;
    private final SizeAwareImageUtil f10549g;
    private final GraphQLImageHelper f10550h;
    private final AutomaticPhotoCaptioningUtils f10551i;

    public static com.facebook.timeline.datafetcher.TimelineHeaderQueryBuilder m10629a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10542j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.datafetcher.TimelineHeaderQueryBuilder.class;
        monitor-enter(r1);
        r0 = f10542j;	 Catch:{ all -> 0x003a }
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
        r0 = m10631b(r0);	 Catch:{ all -> 0x0035 }
        f10542j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10542j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.datafetcher.TimelineHeaderQueryBuilder.a(com.facebook.inject.InjectorLike):com.facebook.timeline.datafetcher.TimelineHeaderQueryBuilder");
    }

    private static TimelineHeaderQueryBuilder m10631b(InjectorLike injectorLike) {
        return new TimelineHeaderQueryBuilder((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FavPhotosVsFeaturedContainersController.m12774a(injectorLike), IntroCardSuggestedPhotosExperimentController.m11801a(injectorLike), IntroCardSuggestedBioExperimentController.m11605a(injectorLike), IdBasedProvider.a(injectorLike, 4442), PersonActionBarQueryParamsFactory.a(injectorLike), GraphQLImageHelper.a(injectorLike), SizeAwareImageUtil.a(injectorLike), AutomaticPhotoCaptioningUtils.b(injectorLike));
    }

    @Inject
    public TimelineHeaderQueryBuilder(QeAccessor qeAccessor, FavPhotosVsFeaturedContainersController favPhotosVsFeaturedContainersController, IntroCardSuggestedPhotosExperimentController introCardSuggestedPhotosExperimentController, IntroCardSuggestedBioExperimentController introCardSuggestedBioExperimentController, Provider<String> provider, PersonActionBarQueryParamsFactory personActionBarQueryParamsFactory, GraphQLImageHelper graphQLImageHelper, SizeAwareImageUtil sizeAwareImageUtil, AutomaticPhotoCaptioningUtils automaticPhotoCaptioningUtils) {
        this.f10543a = qeAccessor;
        this.f10544b = favPhotosVsFeaturedContainersController;
        this.f10545c = introCardSuggestedPhotosExperimentController;
        this.f10546d = introCardSuggestedBioExperimentController;
        this.f10547e = provider;
        this.f10548f = personActionBarQueryParamsFactory;
        this.f10550h = graphQLImageHelper;
        this.f10549g = sizeAwareImageUtil;
        this.f10551i = automaticPhotoCaptioningUtils;
    }

    public final TypedGraphQlQueryString<?> m10636a(FetchTimelineHeaderParams fetchTimelineHeaderParams) {
        return Objects.equal(this.f10547e.get(), String.valueOf(fetchTimelineHeaderParams.a)) ? m10632c(fetchTimelineHeaderParams) : m10634d(fetchTimelineHeaderParams);
    }

    private void m10630a(TypedGraphQlQueryString<?> typedGraphQlQueryString, FetchTimelineHeaderParams fetchTimelineHeaderParams) {
        Number valueOf;
        boolean z = this.f10543a.a(ExperimentsForTimelineAbTestModule.aj, false) || m10633c();
        GraphQlQueryString a = typedGraphQlQueryString.a("cover_image_high_res_size", String.valueOf(GraphQLImageHelper.a(fetchTimelineHeaderParams.c))).a("media_type", this.f10550h.c()).a("profile_pic_media_type", this.f10550h.b()).a("icon_scale", GraphQlQueryDefaults.a()).a("render_location", m10635e());
        String str = "first_count";
        if (this.f10543a.a(ExperimentsForTimelineAbTestModule.X, false)) {
            valueOf = Integer.valueOf(1);
        } else {
            valueOf = null;
        }
        a.a(str, valueOf).a("profile_id", String.valueOf(fetchTimelineHeaderParams.a)).a("fetch_intro_card", Boolean.valueOf(z)).a("fetch_bio", Boolean.valueOf(this.f10543a.a(ExperimentsForTimelineAbTestModule.X, false))).a("fetch_suggested_bio", Boolean.valueOf(this.f10546d.mo533e())).a("fetch_fav_photos", Boolean.valueOf(this.f10544b.m12776a())).a("fetch_suggested_photos", Boolean.valueOf(this.f10545c.mo533e())).a("fetch_dominant_color", Boolean.valueOf(this.f10543a.a(ExperimentsForTimelineAbTestModule.C, false))).a("fetch_external_links", Boolean.valueOf(this.f10543a.a(ExperimentsForTimelineAbTestModule.J, false))).a("fetch_expiration_information", Boolean.valueOf(Objects.equal(this.f10547e.get(), String.valueOf(fetchTimelineHeaderParams.a)))).a("automatic_photo_captioning_enabled", Boolean.toString(this.f10551i.a()));
        this.f10549g.a(typedGraphQlQueryString, this.f10550h.c());
        this.f10548f.a(typedGraphQlQueryString);
    }

    private boolean m10633c() {
        return this.f10543a.a(ExperimentsForTimelineAbTestModule.X, false) || this.f10543a.a(ExperimentsForTimelineAbTestModule.ai, false) || this.f10544b.m12776a();
    }

    private TypedGraphQlQueryString<?> m10634d(FetchTimelineHeaderParams fetchTimelineHeaderParams) {
        GraphQlQueryString userTimelineQueryString = new UserTimelineQueryString();
        userTimelineQueryString.a("is_self_profile", Boolean.valueOf(false));
        m10630a(userTimelineQueryString, fetchTimelineHeaderParams);
        return userTimelineQueryString;
    }

    private RenderLocationInputRenderLocation m10635e() {
        if (this.f10543a.a(ExperimentsForTimelineAbTestModule.aj, false) || m10633c()) {
            return RenderLocationInputRenderLocation.ANDROID_PROFILE_INTRO_CARD_HEADER;
        }
        return RenderLocationInputRenderLocation.ANDROID_PROFILE_TILE;
    }

    private TypedGraphQlQueryString<?> m10632c(FetchTimelineHeaderParams fetchTimelineHeaderParams) {
        GraphQlQueryString userTimelineSelfQueryString = new UserTimelineSelfQueryString();
        Builder builder = new Builder();
        builder.c(GraphQLProfileWizardStepType.PROFILE_PICTURE);
        builder.c(GraphQLProfileWizardStepType.COVER_PHOTO);
        builder.c(GraphQLProfileWizardStepType.CORE_PROFILE_FIELD);
        userTimelineSelfQueryString.a("profile_refresher_step_types", builder.b()).a("is_self_profile", Boolean.valueOf(true));
        m10630a(userTimelineSelfQueryString, fetchTimelineHeaderParams);
        return userTimelineSelfQueryString;
    }
}
