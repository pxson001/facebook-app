package com.facebook.entitycardsplugins.person.loader;

import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.entitycardsplugins.person.abtest.ExperimentsForPersonCardAbTestModule;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQL.PersonCardFetchCardString;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLModels.PersonCardModel;
import com.facebook.entitycardsplugins.person.view.PersonCardViewHelper;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.graphql.querybuilder.common.ScaleInputPixelRatio;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import com.facebook.timeline.coverphotosize.CoverPhotoSize;
import com.facebook.timeline.widget.actionbar.PersonActionBarQueryParamsFactory;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: home_%s_camera_icon_tapped */
public class DefaultPersonCardsLoader {
    private final DefaultAppChoreographer f11153a;
    private final Provider<GraphQLImageHelper> f11154b;
    private final GraphQLQueryExecutor f11155c;
    private final PersonActionBarQueryParamsFactory f11156d;
    private final PersonCardViewHelper f11157e;
    private final CoverPhotoSize f11158f;
    private final QeAccessor f11159g;
    private final Optional<String> f11160h;
    @Nullable
    private final CallerContext f11161i;

    /* compiled from: home_%s_camera_icon_tapped */
    class C12111 implements Function<Map<String, PersonCardModel>, ImmutableMap<String, ?>> {
        final /* synthetic */ DefaultPersonCardsLoader f11150a;

        C12111(DefaultPersonCardsLoader defaultPersonCardsLoader) {
            this.f11150a = defaultPersonCardsLoader;
        }

        public Object apply(Object obj) {
            return ImmutableMap.copyOf((Map) obj);
        }
    }

    @Inject
    public DefaultPersonCardsLoader(AppChoreographer appChoreographer, Provider<GraphQLImageHelper> provider, GraphQLQueryExecutor graphQLQueryExecutor, PersonActionBarQueryParamsFactory personActionBarQueryParamsFactory, PersonCardViewHelper personCardViewHelper, CoverPhotoSize coverPhotoSize, QeAccessor qeAccessor, @Assisted Optional<String> optional, @Nullable @Assisted CallerContext callerContext) {
        this.f11153a = appChoreographer;
        this.f11154b = provider;
        this.f11155c = graphQLQueryExecutor;
        this.f11156d = personActionBarQueryParamsFactory;
        this.f11157e = personCardViewHelper;
        this.f11158f = coverPhotoSize;
        this.f11159g = qeAccessor;
        this.f11160h = optional;
        this.f11161i = callerContext;
    }

    public final ListenableFuture<ImmutableMap<String, ?>> m13091a(ImmutableList<String> immutableList) {
        ListenableFuture b = m13090b(immutableList);
        this.f11153a.a(b);
        return Futures.a(b, new C12111(this), MoreExecutors.a());
    }

    private GraphQLRequest<PersonCardModel> m13089a(String str) {
        Enum enumR;
        ScaleInputPixelRatio a = GraphQlQueryDefaults.a();
        if (a == null) {
            enumR = GraphQlQueryDefaults.a;
        } else {
            enumR = a;
        }
        GraphQLImageHelper graphQLImageHelper = (GraphQLImageHelper) this.f11154b.get();
        GraphQlQueryString personCardFetchCardString = new PersonCardFetchCardString();
        CoverPhotoSize coverPhotoSize = this.f11158f;
        personCardFetchCardString.a("id", str).a("mini_preview_enabled", Boolean.valueOf(this.f11159g.a(ExperimentsForPersonCardAbTestModule.f11149a, false))).a("context_items_num", "3").a("context_item_icon_scale", enumR).a("context_item_image_size", String.valueOf(GraphQLImageHelper.a(this.f11157e.m13245c()))).a("context_item_type", (String) this.f11160h.orNull()).a("cover_image_portrait_size", String.valueOf(GraphQLImageHelper.a(Math.min(coverPhotoSize.a.c(), coverPhotoSize.a.d())))).a("media_type", graphQLImageHelper.a()).a("profile_image_size", String.valueOf(GraphQLImageHelper.a(this.f11157e.m13245c())));
        this.f11156d.a(personCardFetchCardString);
        GraphQLRequest a2 = GraphQLRequest.a(personCardFetchCardString).a(GraphQLCachePolicy.a);
        a2.f = this.f11161i;
        GraphQLRequest<PersonCardModel> a3 = a2.a(RequestPriority.INTERACTIVE).a(3600);
        a3.b = true;
        return a3;
    }

    private ListenableFuture<Map<String, PersonCardModel>> m13090b(ImmutableList<String> immutableList) {
        GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest("DefaultPersonCard");
        Iterable a = Lists.a();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            a.add(graphQLBatchRequest.b(m13089a((String) immutableList.get(i))));
        }
        this.f11155c.a(graphQLBatchRequest);
        final SettableFuture f = SettableFuture.f();
        Futures.a(Futures.a(a), new FutureCallback<List<GraphQLResult<PersonCardModel>>>(this) {
            final /* synthetic */ DefaultPersonCardsLoader f11152b;

            public void onSuccess(Object obj) {
                List<GraphQLResult> list = (List) obj;
                Builder builder = ImmutableMap.builder();
                for (GraphQLResult graphQLResult : list) {
                    PersonCardModel personCardModel = (PersonCardModel) graphQLResult.e;
                    builder.b(personCardModel.m13204r(), personCardModel);
                }
                FutureDetour.a(f, builder.b(), 1728287634);
            }

            public void onFailure(Throwable th) {
                f.a(th);
            }
        }, MoreExecutors.a());
        return f;
    }
}
