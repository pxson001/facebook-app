package com.facebook.productionprompts;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.TriState;
import com.facebook.friendsharing.suggestedcoverphotos.abtest.ExperimentsForSuggestedCoverPhotosAbtestModule;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.ProductionPromptDismissInputData;
import com.facebook.graphql.calls.ProductionPromptDismissInputData.UserAction;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.cache.GraphQLDiskCache;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.productionprompts.fetcher.PromptFetcher;
import com.facebook.productionprompts.common.ClientPromptRanker;
import com.facebook.productionprompts.common.ProductionPromptsQueryFetchingHelper;
import com.facebook.productionprompts.graphql.C0582x78ef048a;
import com.facebook.productionprompts.graphql.C0582x78ef048a.ClientProductionPromptsModel;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLModels$ProductionPromptsInfoModel;
import com.facebook.productionprompts.graphql.ProductionPromptsGraphQLMutations.ProductionPromptDismissString;
import com.facebook.productionprompts.model.ProductionPrompt;
import com.facebook.productionprompts.model.ProductionPromptObject;
import com.facebook.productionprompts.model.PromptObject;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Calendar;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: network_info_closed_conn */
public class ProductionPromptsPromptFetcher implements PromptFetcher {
    public static final String f12681b = ProductionPromptsPromptFetcher.class.getSimpleName();
    private static ProductionPromptsPromptFetcher f12682k;
    private static final Object f12683l = new Object();
    protected final QuickPerformanceLogger f12684a;
    public final GraphQLQueryExecutor f12685c;
    public final ProductionPromptsQueryFetchingHelper f12686d;
    private final TasksManager f12687e;
    private final Provider<GraphQLDiskCache> f12688f;
    private final Provider<TriState> f12689g;
    public final ClientPromptRanker f12690h;
    public final AbstractFbErrorReporter f12691i;
    public final QeAccessor f12692j;

    /* compiled from: network_info_closed_conn */
    class C05861 implements Function<GraphQLResult<C0582x78ef048a>, ImmutableList<PromptObject>> {
        final /* synthetic */ ProductionPromptsPromptFetcher f14005a;

        C05861(ProductionPromptsPromptFetcher productionPromptsPromptFetcher) {
            this.f14005a = productionPromptsPromptFetcher;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            ClientProductionPromptsModel clientProductionPromptsModel;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            ProductionPromptsQueryFetchingHelper productionPromptsQueryFetchingHelper = this.f14005a.f12686d;
            ImmutableList a = ProductionPromptsQueryFetchingHelper.m18756a(graphQLResult);
            Builder builder = ImmutableList.builder();
            ProductionPromptsPromptFetcher.m18747a(this.f14005a, a, builder);
            this.f14005a.f12684a.mo456a(9633793, (short) 13, "fetcher", ProductionPromptsPromptFetcher.class.getSimpleName());
            ProductionPromptsPromptFetcher productionPromptsPromptFetcher = this.f14005a;
            if (graphQLResult == null || graphQLResult.f6203e == null) {
                clientProductionPromptsModel = null;
            } else {
                clientProductionPromptsModel = ((C0582x78ef048a) graphQLResult.f6203e).m20285a();
            }
            ClientProductionPromptsModel clientProductionPromptsModel2 = clientProductionPromptsModel;
            if (clientProductionPromptsModel2 == null) {
                String str;
                AbstractFbErrorReporter abstractFbErrorReporter = this.f14005a.f12691i;
                String str2 = ProductionPromptsPromptFetcher.f12681b;
                ProductionPromptsPromptFetcher productionPromptsPromptFetcher2 = this.f14005a;
                int i = 0;
                if (graphQLResult == null) {
                    str = "null GraphQLResult";
                } else {
                    boolean z;
                    if (((C0582x78ef048a) graphQLResult.f6203e).m20286j() != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        i = ((C0582x78ef048a) graphQLResult.f6203e).m20286j().m21605a().size();
                    }
                    if (((C0582x78ef048a) graphQLResult.f6203e).m20285a() == null) {
                        str = StringFormatUtil.formatStrLocaleSafe("no client production prompts in graphql result. Has Production prompts in result? %s with %d prompt models", Boolean.valueOf(z), Integer.valueOf(i));
                    } else {
                        str = StringFormatUtil.formatStrLocaleSafe("Client production prompt models exist: number of client prompts: %d", Integer.valueOf(((C0582x78ef048a) graphQLResult.f6203e).m20285a().m21629a().size()));
                    }
                }
                abstractFbErrorReporter.m2350b(str2, str);
            }
            this.f14005a.f12690h.m18765a(clientProductionPromptsModel2);
            return builder.m1068b();
        }
    }

    private static ProductionPromptsPromptFetcher m18746a(InjectorLike injectorLike) {
        return new ProductionPromptsPromptFetcher(GraphQLQueryExecutor.m10435a(injectorLike), ProductionPromptsQueryFetchingHelper.m18758b(injectorLike), TasksManager.m14550b(injectorLike), IdBasedSingletonScopeProvider.m1809a(injectorLike, 2183), IdBasedProvider.m1811a(injectorLike, 675), QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike), ClientPromptRanker.m18762a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public static ProductionPromptsPromptFetcher m18748b(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProductionPromptsPromptFetcher a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.m1330a(b2);
            synchronized (f12683l) {
                ProductionPromptsPromptFetcher productionPromptsPromptFetcher;
                if (a3 != null) {
                    productionPromptsPromptFetcher = (ProductionPromptsPromptFetcher) a3.mo818a(f12683l);
                } else {
                    productionPromptsPromptFetcher = f12682k;
                }
                if (productionPromptsPromptFetcher == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        a2 = m18746a(injectorThreadStack.m1474e());
                        if (a3 != null) {
                            a3.mo822a(f12683l, a2);
                        } else {
                            f12682k = a2;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    a2 = productionPromptsPromptFetcher;
                }
            }
            return a2;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public ProductionPromptsPromptFetcher(GraphQLQueryExecutor graphQLQueryExecutor, ProductionPromptsQueryFetchingHelper productionPromptsQueryFetchingHelper, TasksManager tasksManager, Provider<GraphQLDiskCache> provider, Provider<TriState> provider2, QuickPerformanceLogger quickPerformanceLogger, ClientPromptRanker clientPromptRanker, FbErrorReporter fbErrorReporter, QeAccessor qeAccessor) {
        this.f12685c = graphQLQueryExecutor;
        this.f12686d = productionPromptsQueryFetchingHelper;
        this.f12687e = tasksManager;
        this.f12688f = provider;
        this.f12689g = provider2;
        this.f12684a = quickPerformanceLogger;
        this.f12690h = clientPromptRanker;
        this.f12691i = fbErrorReporter;
        this.f12692j = qeAccessor;
    }

    public final boolean mo2490a() {
        return this.f12689g.get() == TriState.YES;
    }

    public Class<? extends PromptObject> mo2491b() {
        return ProductionPromptObject.class;
    }

    public ListenableFuture<ImmutableList<PromptObject>> mo2492c() {
        return Futures.m2450a(this.f12686d.m18760a(null), new C05861(this), MoreExecutors.m1813a());
    }

    public static void m18747a(ProductionPromptsPromptFetcher productionPromptsPromptFetcher, ImmutableList immutableList, Builder builder) {
        Calendar instance = Calendar.getInstance();
        if (immutableList != null) {
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                FetchProductionPromptsGraphQLModels$ProductionPromptsInfoModel fetchProductionPromptsGraphQLModels$ProductionPromptsInfoModel = (FetchProductionPromptsGraphQLModels$ProductionPromptsInfoModel) immutableList.get(i);
                ProductionPrompt a = ProductionPrompt.a(fetchProductionPromptsGraphQLModels$ProductionPromptsInfoModel);
                if (ProductionPrompt.a(fetchProductionPromptsGraphQLModels$ProductionPromptsInfoModel, instance) && productionPromptsPromptFetcher.f12686d.m18761a(a)) {
                    boolean z = false;
                    if (a.s() == null || a.s().isEmpty() || productionPromptsPromptFetcher.f12692j.mo596a(ExperimentsForSuggestedCoverPhotosAbtestModule.d, false)) {
                        z = true;
                    }
                    if (z) {
                        builder.m1069c(new ProductionPromptObject(a));
                    }
                }
            }
        }
    }

    public void mo2488a(Class<? extends PromptObject> cls) {
        Preconditions.checkArgument(ProductionPromptObject.class.equals(cls));
        m18754d();
    }

    public void mo2489a(Class<? extends PromptObject> cls, String str, boolean z) {
        Enum enumR;
        Preconditions.checkArgument(ProductionPromptObject.class.equals(cls));
        ProductionPromptDismissInputData productionPromptDismissInputData = new ProductionPromptDismissInputData();
        productionPromptDismissInputData.m11397a("production_prompt_id", str);
        GraphQlCallInput graphQlCallInput = productionPromptDismissInputData;
        if (z) {
            enumR = UserAction.POSTSUGG;
        } else {
            enumR = UserAction.XOUT;
        }
        graphQlCallInput.m11395a("user_action", enumR);
        GraphQlCallInput graphQlCallInput2 = graphQlCallInput;
        TypedGraphQLMutationString productionPromptDismissString = new ProductionPromptDismissString();
        productionPromptDismissString.m11310a("input", graphQlCallInput2);
        this.f12687e.m14556a("dismiss_prodution_prompt_" + str, new 2(this, GraphQLRequest.m11588a(productionPromptDismissString)), new 3(this));
    }

    protected final void m18754d() {
        ((GraphQLDiskCache) this.f12688f.get()).mo1446c(this.f12686d.m18759a());
    }
}
