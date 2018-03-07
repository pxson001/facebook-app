package com.facebook.productionprompts;

import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.util.TriState;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.cache.GraphQLDiskCache;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.productionprompts.common.ClientPromptRanker;
import com.facebook.productionprompts.common.ProductionPromptsQueryFetchingHelper;
import com.facebook.productionprompts.model.ClipboardPromptObject;
import com.facebook.productionprompts.model.ProductionPrompt;
import com.facebook.productionprompts.model.PromptObject;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: network_info_dequeued_req */
public class ClipboardPromptsPromptFetcher extends ProductionPromptsPromptFetcher {
    private final ListeningExecutorService f12679b;
    public final ClipboardPromptUtil f12680c;

    /* compiled from: network_info_dequeued_req */
    class C05811 implements Callable<ImmutableList<PromptObject>> {
        final /* synthetic */ ClipboardPromptsPromptFetcher f13943a;

        C05811(ClipboardPromptsPromptFetcher clipboardPromptsPromptFetcher) {
            this.f13943a = clipboardPromptsPromptFetcher;
        }

        public Object call() {
            Builder builder = ImmutableList.builder();
            if (this.f13943a.f12680c.m18772a()) {
                ProductionPrompt b = this.f13943a.f12680c.m18773b();
                if (b != null) {
                    builder.m1069c(new ClipboardPromptObject(b));
                }
            }
            this.f13943a.f12684a.mo456a(9633793, (short) 13, "fetcher", ClipboardPromptsPromptFetcher.class.getSimpleName());
            return builder.m1068b();
        }
    }

    public static ClipboardPromptsPromptFetcher m18741c(InjectorLike injectorLike) {
        return new ClipboardPromptsPromptFetcher(GraphQLQueryExecutor.m10435a(injectorLike), ProductionPromptsQueryFetchingHelper.m18758b(injectorLike), TasksManager.m14550b(injectorLike), IdBasedSingletonScopeProvider.m1809a(injectorLike, 2183), IdBasedProvider.m1811a(injectorLike, 675), QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike), ClientPromptRanker.m18762a(injectorLike), ClipboardPromptUtil.m18766a(injectorLike), C0055x2995691a.m1881a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public ClipboardPromptsPromptFetcher(GraphQLQueryExecutor graphQLQueryExecutor, ProductionPromptsQueryFetchingHelper productionPromptsQueryFetchingHelper, TasksManager tasksManager, Provider<GraphQLDiskCache> provider, Provider<TriState> provider2, QuickPerformanceLogger quickPerformanceLogger, ClientPromptRanker clientPromptRanker, ClipboardPromptUtil clipboardPromptUtil, ListeningExecutorService listeningExecutorService, FbErrorReporter fbErrorReporter, QeAccessor qeAccessor) {
        super(graphQLQueryExecutor, productionPromptsQueryFetchingHelper, tasksManager, provider, provider2, quickPerformanceLogger, clientPromptRanker, fbErrorReporter, qeAccessor);
        this.f12680c = clipboardPromptUtil;
        this.f12679b = listeningExecutorService;
    }

    public final ListenableFuture<ImmutableList<PromptObject>> mo2492c() {
        return this.f12679b.mo271a(new C05811(this));
    }

    public final Class<? extends PromptObject> mo2491b() {
        return ClipboardPromptObject.class;
    }

    public final void mo2488a(Class<? extends PromptObject> cls) {
        Preconditions.checkArgument(ClipboardPromptObject.class.equals(cls));
        m18754d();
        this.f12680c.m18774c();
    }

    public final void mo2489a(Class<? extends PromptObject> cls, String str, boolean z) {
        Preconditions.checkArgument(ClipboardPromptObject.class.equals(cls));
        this.f12680c.m18774c();
    }
}
