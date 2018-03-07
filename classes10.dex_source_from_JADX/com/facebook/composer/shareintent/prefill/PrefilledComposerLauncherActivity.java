package com.facebook.composer.shareintent.prefill;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForegroundExecutorService;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.minutiae.intent.SingleMinutiaeFetcher;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.composer.ui.titlebar.ComposerBaseTitleBar;
import com.facebook.composer.ui.titlebar.HarrisonPlusIconType;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ErrorCodeUtil;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.productionprompts.common.ProductionPromptsQueryFetchingHelper;
import com.facebook.productionprompts.composer.ProductionPromptComposerUtil;
import com.facebook.productionprompts.composer.ProductionPromptsPluginConfig;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLModels.FetchProductionPromptsQueryModel;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLModels.ProductionPromptsInfoModel;
import com.facebook.productionprompts.logging.ProductionPromptsLogger;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.productionprompts.model.ProductionPrompt;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.error.GenericErrorView;
import com.facebook.widget.titlebar.FbTitleBar.OnBackPressedListener;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: context_menu_item */
public class PrefilledComposerLauncherActivity extends FbFragmentActivity {
    public static final String f15872u = PrefilledComposerLauncherActivity.class.getSimpleName();
    private static final ComposerSourceSurface f15873v = ComposerSourceSurface.URI_HANDLER;
    private Uri f15874A;
    @Nullable
    private String f15875B;
    @Nullable
    private String f15876C;
    @Nullable
    private String f15877D;
    @Nullable
    private String f15878E;
    @Nullable
    private String f15879F;
    @Nullable
    private ComposerSourceType f15880G;
    public ProgressBar f15881H;
    public GenericErrorView f15882I;
    @Inject
    ComposerLauncher f15883p;
    @Inject
    @ForegroundExecutorService
    ExecutorService f15884q;
    @Inject
    SingleMinutiaeFetcher f15885r;
    @Inject
    @IsWorkBuild
    Boolean f15886s;
    @Inject
    AbstractFbErrorReporter f15887t;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<ProductionPromptsQueryFetchingHelper> f15888w = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<TasksManager> f15889x = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<JsonPluginConfigSerializer> f15890y = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<ProductionPromptsLogger> f15891z = UltralightRuntime.b;

    /* compiled from: context_menu_item */
    class C22071 implements OnBackPressedListener {
        final /* synthetic */ PrefilledComposerLauncherActivity f15862a;

        C22071(PrefilledComposerLauncherActivity prefilledComposerLauncherActivity) {
            this.f15862a = prefilledComposerLauncherActivity;
        }

        public final void m16304a() {
            this.f15862a.onBackPressed();
        }
    }

    /* compiled from: context_menu_item */
    class C22082 implements OnClickListener {
        final /* synthetic */ PrefilledComposerLauncherActivity f15863a;

        C22082(PrefilledComposerLauncherActivity prefilledComposerLauncherActivity) {
            this.f15863a = prefilledComposerLauncherActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -17150798);
            this.f15863a.f15881H.setVisibility(0);
            this.f15863a.f15882I.setVisibility(8);
            PrefilledComposerLauncherActivity.m16325k(this.f15863a);
            Logger.a(2, EntryType.UI_INPUT_END, 489897776, a);
        }
    }

    private static <T extends Context> void m16316a(Class<T> cls, T t) {
        m16317a((Object) t, (Context) t);
    }

    public static void m16317a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PrefilledComposerLauncherActivity) obj).m16315a((ComposerLauncher) ComposerLauncherImpl.a(fbInjector), (ExecutorService) ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(fbInjector), SingleMinutiaeFetcher.b(fbInjector), Boolean_IsWorkBuildMethodAutoProvider.a(fbInjector), IdBasedLazy.a(fbInjector, 3139), IdBasedLazy.a(fbInjector, 3561), IdBasedLazy.a(fbInjector, 2370), IdBasedSingletonScopeProvider.b(fbInjector, 3152), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector));
    }

    protected final void m16327b(Bundle bundle) {
        super.b(bundle);
        Class cls = PrefilledComposerLauncherActivity.class;
        m16317a((Object) this, (Context) this);
        m16324j();
        this.f15874A = getIntent().getData();
        if ("minutiae".equals(this.f15874A.getAuthority())) {
            this.f15880G = ComposerSourceType.MINUTIAE_PREFILLED;
            this.f15875B = this.f15874A.getQueryParameter("og_action");
            this.f15876C = this.f15874A.getQueryParameter("og_object");
            this.f15877D = this.f15874A.getQueryParameter("link");
        } else {
            this.f15880G = ComposerSourceType.PREFILLED;
            this.f15875B = this.f15874A.getQueryParameter("minutiae_og_action");
            this.f15876C = this.f15874A.getQueryParameter("minutiae_og_object");
            this.f15877D = this.f15874A.getQueryParameter("link");
            this.f15878E = this.f15874A.getQueryParameter("shareid");
            this.f15879F = this.f15874A.getQueryParameter("prompt_id");
        }
        m16325k(this);
    }

    public void onStop() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -155686937);
        this.f15885r.b.c();
        super.onStop();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1465686720, a);
    }

    private void m16324j() {
        setContentView(getLayoutInflater().inflate(2130906366, null));
        ComposerBaseTitleBar composerBaseTitleBar = (ComposerBaseTitleBar) a(2131560528);
        if (composerBaseTitleBar != null) {
            composerBaseTitleBar.a(HarrisonPlusIconType.c());
            composerBaseTitleBar.setTitle(this.f15886s.booleanValue() ? 2131234524 : 2131234523);
            composerBaseTitleBar.setHasBackButton(true);
            composerBaseTitleBar.setOnBackPressedListener(new C22071(this));
        }
        this.f15881H = (ProgressBar) a(2131559308);
        this.f15882I = (GenericErrorView) a(2131560576);
        this.f15882I.setClickable(true);
        this.f15882I.setOnClickListener(new C22082(this));
    }

    public static void m16325k(PrefilledComposerLauncherActivity prefilledComposerLauncherActivity) {
        if (prefilledComposerLauncherActivity.m16326l()) {
            Builder c;
            if (prefilledComposerLauncherActivity.f15878E != null) {
                GraphQLEntity.Builder builder = new GraphQLEntity.Builder();
                builder.m = prefilledComposerLauncherActivity.f15878E;
                builder = builder;
                builder.S = new GraphQLObjectType(-1196289854);
                c = ComposerConfigurationFactory.c(prefilledComposerLauncherActivity.f15880G, ComposerShareParams.Builder.a(builder.a()).b());
            } else {
                c = ComposerConfigurationFactory.a(f15873v, "status_composer_from_uri");
            }
            if (prefilledComposerLauncherActivity.f15877D != null) {
                c.setInitialShareParams(ComposerShareParams.Builder.a(prefilledComposerLauncherActivity.f15877D).b());
            }
            if (prefilledComposerLauncherActivity.f15879F != null) {
                prefilledComposerLauncherActivity.m16314a(c, prefilledComposerLauncherActivity.f15879F);
            } else if (prefilledComposerLauncherActivity.f15875B == null && prefilledComposerLauncherActivity.f15876C == null) {
                prefilledComposerLauncherActivity.m16313a(c);
            } else {
                prefilledComposerLauncherActivity.f15885r.a("single_minutiae", prefilledComposerLauncherActivity.f15884q, prefilledComposerLauncherActivity.f15875B, prefilledComposerLauncherActivity.f15876C, new AbstractDisposableFutureCallback<MinutiaeObject>(prefilledComposerLauncherActivity) {
                    final /* synthetic */ PrefilledComposerLauncherActivity f15865b;

                    protected final void m16305a(Object obj) {
                        c.setMinutiaeObjectTag((MinutiaeObject) obj);
                        this.f15865b.m16313a(c);
                    }

                    protected final void m16306a(Throwable th) {
                        if (ErrorCodeUtil.a(th) == ErrorCode.CONNECTION_FAILURE) {
                            this.f15865b.f15882I.a();
                        } else {
                            this.f15865b.f15882I.b();
                        }
                        this.f15865b.f15881H.setVisibility(8);
                        this.f15865b.f15882I.setVisibility(0);
                    }
                });
            }
        }
    }

    private void m16314a(final Builder builder, final String str) {
        ((TasksManager) this.f15889x.get()).a("FETCH_PROMPT", new Callable<ListenableFuture<GraphQLResult<FetchProductionPromptsQueryModel>>>(this) {
            final /* synthetic */ PrefilledComposerLauncherActivity f15868b;

            /* compiled from: context_menu_item */
            class C22101 implements Function<GraphQLResult<FetchProductionPromptsQueryModel>, Boolean> {
                final /* synthetic */ C22114 f15866a;

                C22101(C22114 c22114) {
                    this.f15866a = c22114;
                }

                @Nullable
                public Object apply(@Nullable Object obj) {
                    return Boolean.valueOf(this.f15866a.f15868b.m16311a((GraphQLResult) obj, str) != null);
                }
            }

            public Object call() {
                return ((ProductionPromptsQueryFetchingHelper) this.f15868b.f15888w.get()).a(new C22101(this));
            }
        }, new AbstractDisposableFutureCallback<GraphQLResult<FetchProductionPromptsQueryModel>>(this) {
            final /* synthetic */ PrefilledComposerLauncherActivity f15871c;

            protected final void m16307a(Object obj) {
                ProductionPrompt a = this.f15871c.m16311a((GraphQLResult) obj, str);
                if (a != null) {
                    PromptAnalytics a2 = PromptAnalytics.a(a.a(), a.i(), "FROM_CULTURAL_MOMENTS", null, a.o(), null);
                    ProductionPromptsPluginConfig a3 = ProductionPromptsPluginConfig.a(a, a2, true);
                    ((ProductionPromptsLogger) this.f15871c.f15891z.get()).a(a2);
                    ProductionPromptComposerUtil.a(builder, a);
                    builder.setPluginConfig(((JsonPluginConfigSerializer) this.f15871c.f15890y.get()).a(a3));
                    this.f15871c.m16313a(builder);
                    return;
                }
                this.f15871c.f15887t.b(PrefilledComposerLauncherActivity.f15872u, "prompt with id: " + str + " not found.");
                this.f15871c.m16313a(builder);
            }

            protected final void m16308a(Throwable th) {
                if (ErrorCodeUtil.a(th) == ErrorCode.CONNECTION_FAILURE) {
                    this.f15871c.f15882I.a();
                } else {
                    this.f15871c.f15882I.b();
                }
                this.f15871c.f15881H.setVisibility(8);
                this.f15871c.f15882I.setVisibility(0);
            }
        });
    }

    private void m16315a(ComposerLauncher composerLauncher, ExecutorService executorService, SingleMinutiaeFetcher singleMinutiaeFetcher, Boolean bool, com.facebook.inject.Lazy<ProductionPromptsQueryFetchingHelper> lazy, com.facebook.inject.Lazy<TasksManager> lazy2, com.facebook.inject.Lazy<JsonPluginConfigSerializer> lazy3, com.facebook.inject.Lazy<ProductionPromptsLogger> lazy4, FbErrorReporter fbErrorReporter) {
        this.f15883p = composerLauncher;
        this.f15884q = executorService;
        this.f15885r = singleMinutiaeFetcher;
        this.f15886s = bool;
        this.f15888w = lazy;
        this.f15889x = lazy2;
        this.f15890y = lazy3;
        this.f15891z = lazy4;
        this.f15887t = fbErrorReporter;
    }

    @Nullable
    private ProductionPrompt m16311a(GraphQLResult<FetchProductionPromptsQueryModel> graphQLResult, String str) {
        ImmutableList a;
        this.f15888w.get();
        if (ProductionPromptsQueryFetchingHelper.a(graphQLResult) != null) {
            this.f15888w.get();
            a = ProductionPromptsQueryFetchingHelper.a(graphQLResult);
        } else {
            a = RegularImmutableList.a;
        }
        int size = a.size();
        for (int i = 0; i < size; i++) {
            ProductionPrompt a2 = ProductionPrompt.a((ProductionPromptsInfoModel) a.get(i));
            if (a2 != null && a2.a().equals(str)) {
                return a2;
            }
        }
        return null;
    }

    private void m16313a(Builder builder) {
        this.f15883p.a(null, builder.setIsFireAndForget(true).a(), this);
    }

    private boolean m16326l() {
        if (this.f15877D == null || this.f15878E == null) {
            return true;
        }
        this.f15887t.a(f15872u, "Multiple exclusive parameters found in uri: " + this.f15874A, 1);
        this.f15882I.b();
        this.f15881H.setVisibility(8);
        this.f15882I.setVisibility(0);
        return false;
    }
}
