package com.facebook.friendsharing.listeningto.composer;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.composer.activity.ComposerFragment;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass36;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.FetchTaggableObjectsQueryModel;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLModels.TaggableObjectEdgeModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaePreviewTemplateModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityModel.Builder;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableObjectFieldsModel;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.composer.minutiae.protocol.MinutiaeObjectsDataFetcher;
import com.facebook.composer.minutiae.protocol.MinutiaeObjectsDataFetcherProvider;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.ipc.composer.intent.SerializedComposerPluginConfig;
import com.facebook.ipc.composer.plugin.ComposerPlugin.InstanceState;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.BooleanGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginSession;
import com.facebook.ipc.composer.plugin.impl.ComposerPluginDefault;
import com.facebook.ipc.friendsharing.listeningto.ListeningToComposerPluginConfig;
import com.google.common.collect.ImmutableList;
import java.util.Locale;
import java.util.Random;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: all_tiles_in_cache_some_are_stale */
public class ListeningToComposerPlugin extends ComposerPluginDefault {
    public final MinutiaeObjectsDataFetcher f10057a;
    private final Resources f10058b;
    public final ListeningToComposerPluginConfig f10059c;
    private boolean f10060d;

    /* compiled from: all_tiles_in_cache_some_are_stale */
    public class Factory implements com.facebook.ipc.composer.plugin.ComposerPlugin.Factory {
        private final ListeningToComposerPluginProvider f10055a;
        private final JsonPluginConfigSerializer<ListeningToComposerPluginConfig> f10056b;

        @Inject
        public Factory(ListeningToComposerPluginProvider listeningToComposerPluginProvider, JsonPluginConfigSerializer jsonPluginConfigSerializer) {
            this.f10055a = listeningToComposerPluginProvider;
            this.f10056b = jsonPluginConfigSerializer;
        }

        public final ComposerPluginDefault m10400a(SerializedComposerPluginConfig serializedComposerPluginConfig, ComposerPluginSession composerPluginSession, @Nullable InstanceState instanceState) {
            ListeningToComposerPluginProvider listeningToComposerPluginProvider = this.f10055a;
            return new ListeningToComposerPlugin((Context) listeningToComposerPluginProvider.getInstance(Context.class), (MinutiaeObjectsDataFetcherProvider) listeningToComposerPluginProvider.getOnDemandAssistedProviderForStaticDi(MinutiaeObjectsDataFetcherProvider.class), ResourcesMethodAutoProvider.a(listeningToComposerPluginProvider), composerPluginSession, (ListeningToComposerPluginConfig) this.f10056b.a(serializedComposerPluginConfig, ListeningToComposerPluginConfig.class));
        }

        public final String m10401b() {
            return ListeningToComposerPluginConfig.a;
        }
    }

    @Inject
    public ListeningToComposerPlugin(Context context, MinutiaeObjectsDataFetcherProvider minutiaeObjectsDataFetcherProvider, Resources resources, @Assisted ComposerPluginSession composerPluginSession, @Assisted ListeningToComposerPluginConfig listeningToComposerPluginConfig) {
        super(context, composerPluginSession);
        this.f10057a = minutiaeObjectsDataFetcherProvider.a(Integer.valueOf(new Random().nextInt()), null, "composer");
        this.f10058b = resources;
        this.f10059c = listeningToComposerPluginConfig;
    }

    public final void m10405a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        super.a(composerEvent, composerEventOriginator);
        if (composerEvent == ComposerEvent.ON_RESUME && !this.f10060d) {
            this.f10060d = true;
            Builder builder = new Builder();
            builder.d = "dGFnZ2FibGVfYWN0aXZpdHk6MzgzNjM0ODY4MzM5NDc2";
            builder = builder;
            builder.f = "383634868339476";
            final MinutiaeTaggableActivityModel a = builder.a();
            this.f10057a.a(a, String.format(Locale.US, "%s %s", new Object[]{this.f10059c.c(), this.f10059c.d()}), SafeUUIDGenerator.a().toString(), new AbstractDisposableFutureCallback<GraphQLResult<FetchTaggableObjectsQueryModel>>(this) {
                final /* synthetic */ ListeningToComposerPlugin f10054b;

                protected final void m10398a(Object obj) {
                    FetchTaggableObjectsQueryModel fetchTaggableObjectsQueryModel = (FetchTaggableObjectsQueryModel) ((GraphQLResult) obj).e;
                    if (fetchTaggableObjectsQueryModel != null && fetchTaggableObjectsQueryModel.a() != null && fetchTaggableObjectsQueryModel.a().b() != null && fetchTaggableObjectsQueryModel.k() != null && fetchTaggableObjectsQueryModel.j() != null && fetchTaggableObjectsQueryModel.n() != null && fetchTaggableObjectsQueryModel.l() != null && fetchTaggableObjectsQueryModel.o() != null && fetchTaggableObjectsQueryModel.m() != null) {
                        ImmutableList a = fetchTaggableObjectsQueryModel.p().a();
                        if (a == null || a.isEmpty()) {
                            ListeningToComposerPlugin.m10403a(this.f10054b, null, a, fetchTaggableObjectsQueryModel);
                        } else {
                            ListeningToComposerPlugin.m10403a(this.f10054b, (TaggableObjectEdgeModel) a.get(0), a, fetchTaggableObjectsQueryModel);
                        }
                    }
                }

                protected final void m10399a(Throwable th) {
                }
            });
        }
    }

    public static void m10403a(ListeningToComposerPlugin listeningToComposerPlugin, TaggableObjectEdgeModel taggableObjectEdgeModel, MinutiaeTaggableActivityModel minutiaeTaggableActivityModel, FetchTaggableObjectsQueryModel fetchTaggableObjectsQueryModel) {
        MinutiaeObject a = listeningToComposerPlugin.m10402a(taggableObjectEdgeModel, minutiaeTaggableActivityModel, fetchTaggableObjectsQueryModel.a().b(), fetchTaggableObjectsQueryModel.k(), fetchTaggableObjectsQueryModel.j(), fetchTaggableObjectsQueryModel.n(), fetchTaggableObjectsQueryModel.l(), fetchTaggableObjectsQueryModel.o(), fetchTaggableObjectsQueryModel.m());
        AnonymousClass36 anonymousClass36 = listeningToComposerPlugin.E().b;
        ComposerFragment.m7538a(anonymousClass36.f6067a, a);
        ComposerFragment.bi(anonymousClass36.f6067a);
    }

    private MinutiaeObject m10402a(TaggableObjectEdgeModel taggableObjectEdgeModel, MinutiaeTaggableActivityModel minutiaeTaggableActivityModel, String str, MinutiaePreviewTemplateModel minutiaePreviewTemplateModel, MinutiaePreviewTemplateModel minutiaePreviewTemplateModel2, MinutiaePreviewTemplateModel minutiaePreviewTemplateModel3, MinutiaePreviewTemplateModel minutiaePreviewTemplateModel4, MinutiaePreviewTemplateModel minutiaePreviewTemplateModel5, MinutiaePreviewTemplateModel minutiaePreviewTemplateModel6) {
        if (taggableObjectEdgeModel == null) {
            TaggableObjectEdgeModel.Builder builder = new TaggableObjectEdgeModel.Builder();
            builder.d = this.f10058b.getString(2131234827, new Object[]{this.f10059c.c(), this.f10059c.d()});
            builder = builder;
            builder.g = new MinutiaeTaggableObjectFieldsModel.Builder().a();
            builder = builder;
            DefaultImageFieldsModel.Builder builder2 = new DefaultImageFieldsModel.Builder();
            builder2.b = str;
            builder.f = builder2.a();
            taggableObjectEdgeModel = builder.a();
        }
        MinutiaeObject.Builder builder3 = new MinutiaeObject.Builder();
        builder3.b = taggableObjectEdgeModel;
        builder3 = builder3;
        Builder a = Builder.a(minutiaeTaggableActivityModel);
        a.j = minutiaePreviewTemplateModel;
        a = a;
        a.i = minutiaePreviewTemplateModel2;
        a = a;
        a.m = minutiaePreviewTemplateModel3;
        a = a;
        a.k = minutiaePreviewTemplateModel4;
        a = a;
        a.n = minutiaePreviewTemplateModel5;
        a = a;
        a.l = minutiaePreviewTemplateModel6;
        builder3.a = a.a();
        return builder3.a();
    }

    @Nullable
    protected final BooleanGetter aD() {
        return BooleanGetter.a;
    }

    protected final BooleanGetter aF() {
        return BooleanGetter.b;
    }

    protected final BooleanGetter aM() {
        return BooleanGetter.b;
    }

    public final BooleanGetter m10406f() {
        return BooleanGetter.b;
    }

    protected final BooleanGetter aL() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final BooleanGetter m10404M() {
        return BooleanGetter.b;
    }
}
