package com.facebook.today.ui;

import android.content.res.Resources;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLReactionUnitCollapseState;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.graphql.enums.GraphQLReactionUnitStyle;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel.Builder;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationCache;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.reaction.ReactionQueryParams;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionSessionManager;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoriesModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoriesModel.EdgesModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitSubComponentModel;
import com.facebook.today.abtest.ExperimentsForTodayAbTestModule;
import com.facebook.today.abtest.TodayExperimentController;
import com.facebook.today.prefs.TodayPrefKeys;
import com.google.common.collect.ImmutableList;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import javax.inject.Inject;

/* compiled from: triggerGeneration */
public class TodayReactionSessionBuilder {
    public final FbLocationCache f1264a;
    private final FbSharedPreferences f1265b;
    private final QeAccessor f1266c;
    public final ReactionSessionManager f1267d;
    public final ReactionUtil f1268e;
    public final Resources f1269f;
    public final TodayExperimentController f1270g;
    public final ViewerContextManager f1271h;

    /* compiled from: triggerGeneration */
    public class C01211 implements Runnable {
        final /* synthetic */ String f1262a;
        final /* synthetic */ TodayReactionSessionBuilder f1263b;

        public C01211(TodayReactionSessionBuilder todayReactionSessionBuilder, String str) {
            this.f1263b = todayReactionSessionBuilder;
            this.f1262a = str;
        }

        public void run() {
            ReactionQueryParams reactionQueryParams = new ReactionQueryParams();
            reactionQueryParams.t = Long.valueOf(Long.parseLong(this.f1263b.f1271h.d().mUserId));
            reactionQueryParams = reactionQueryParams;
            reactionQueryParams.g = this.f1263b.f1264a.a();
            reactionQueryParams = reactionQueryParams;
            if (this.f1263b.f1270g.b.a(ExperimentsForTodayAbTestModule.ac, false)) {
                reactionQueryParams.b = 3;
            }
            this.f1263b.f1268e.a(reactionQueryParams, this.f1262a, Surface.ANDROID_TODAY);
        }
    }

    public static TodayReactionSessionBuilder m1421a(InjectorLike injectorLike) {
        return new TodayReactionSessionBuilder(FbLocationCache.b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), ReactionSessionManager.a(injectorLike), ReactionUtil.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), TodayExperimentController.a(injectorLike), ViewerContextManagerProvider.b(injectorLike));
    }

    @Inject
    public TodayReactionSessionBuilder(FbLocationCache fbLocationCache, FbSharedPreferences fbSharedPreferences, QeAccessor qeAccessor, ReactionSessionManager reactionSessionManager, ReactionUtil reactionUtil, Resources resources, TodayExperimentController todayExperimentController, ViewerContextManager viewerContextManager) {
        this.f1264a = fbLocationCache;
        this.f1265b = fbSharedPreferences;
        this.f1266c = qeAccessor;
        this.f1267d = reactionSessionManager;
        this.f1268e = reactionUtil;
        this.f1269f = resources;
        this.f1270g = todayExperimentController;
        this.f1271h = viewerContextManager;
    }

    public final ReactionSession m1424b() {
        Collection arrayList = new ArrayList();
        if (this.f1270g.b.a(ExperimentsForTodayAbTestModule.S, false)) {
            arrayList.add(m1423c());
        }
        GraphQLObjectType graphQLObjectType = new GraphQLObjectType(1300000580);
        Builder builder = new Builder();
        builder.a = this.f1269f.getString(2131239627);
        DefaultTextWithEntitiesFieldsModel a = builder.a();
        ReactionUnitComponentModel.Builder builder2 = new ReactionUnitComponentModel.Builder();
        builder2.C = GraphQLReactionUnitComponentStyle.NOTIFICATIONS_LIST;
        builder2 = builder2;
        builder2.a = graphQLObjectType;
        ReactionUnitComponentModel.Builder builder3 = builder2;
        builder3.br = a;
        arrayList.add(builder3.a());
        GraphQLObjectType graphQLObjectType2 = new GraphQLObjectType(95562851);
        ReactionUnitFragmentModel.Builder builder4 = new ReactionUnitFragmentModel.Builder();
        builder4.d = "notification_placeholder";
        builder4 = builder4;
        builder4.o = "notification_placeholder_token";
        builder4 = builder4;
        builder4.a = graphQLObjectType2;
        ReactionUnitFragmentModel.Builder builder5 = builder4;
        builder5.i = ImmutableList.copyOf(arrayList);
        ReactionUnitFragmentModel.Builder builder6 = builder5;
        builder6.n = GraphQLReactionUnitStyle.VERTICAL_COMPONENTS;
        builder6 = builder6;
        builder6.b = GraphQLReactionUnitCollapseState.NOT_COLLAPSIBLE;
        ReactionUnitFragmentModel a2 = builder6.a();
        EdgesModel.Builder builder7 = new EdgesModel.Builder();
        builder7.a = a2;
        EdgesModel a3 = builder7.a();
        ReactionStoriesModel.Builder builder8 = new ReactionStoriesModel.Builder();
        builder8.a = ImmutableList.of(a3);
        ReactionStoriesModel.Builder builder9 = builder8;
        builder9.b = new DefaultPageInfoFieldsModel();
        ReactionStoriesModel a4 = builder9.a();
        ReactionSession a5 = this.f1267d.a(SafeUUIDGenerator.a().toString(), Surface.ANDROID_TODAY);
        a5.a(a4);
        a5.p = true;
        a5.q = true;
        return a5;
    }

    private ReactionUnitComponentModel m1423c() {
        boolean z = false;
        GraphQLObjectType graphQLObjectType = new GraphQLObjectType(-914925040);
        Builder builder = new Builder();
        builder.a = m1422a(false);
        DefaultTextWithEntitiesFieldsModel a = builder.a();
        Builder builder2 = new Builder();
        builder2.a = m1422a(true);
        DefaultTextWithEntitiesFieldsModel a2 = builder2.a();
        if (this.f1264a.a() == null) {
            z = true;
        }
        if (this.f1265b.a(TodayPrefKeys.f1241m)) {
            z = this.f1265b.a(TodayPrefKeys.f1241m, true);
        }
        ReactionUnitSubComponentModel.Builder builder3 = new ReactionUnitSubComponentModel.Builder();
        builder3.C = GraphQLReactionUnitComponentStyle.ACORN_HEADER;
        builder3 = builder3;
        builder3.R = a;
        builder3 = builder3;
        builder3.S = a2;
        builder3 = builder3;
        builder3.a = graphQLObjectType;
        builder3 = builder3;
        builder3.cv = z;
        ReactionUnitSubComponentModel a3 = builder3.a();
        GraphQLObjectType graphQLObjectType2 = new GraphQLObjectType(-1449201386);
        ReactionUnitComponentModel.Builder builder4 = new ReactionUnitComponentModel.Builder();
        builder4.C = GraphQLReactionUnitComponentStyle.VERTICAL_COMPONENTS_LIST;
        builder4 = builder4;
        builder4.a = graphQLObjectType2;
        ReactionUnitComponentModel.Builder builder5 = builder4;
        builder5.cA = ImmutableList.of(a3);
        return builder5.a();
    }

    private String m1422a(boolean z) {
        if (!this.f1266c.a(ExperimentsForTodayAbTestModule.a, false)) {
            return " ";
        }
        String a = this.f1266c.a(ExperimentsForTodayAbTestModule.c, "EEE, MMM d");
        if (z) {
            a = this.f1266c.a(ExperimentsForTodayAbTestModule.b, "EEE, MMM d");
        }
        return new SimpleDateFormat(a).format(Calendar.getInstance().getTime());
    }
}
