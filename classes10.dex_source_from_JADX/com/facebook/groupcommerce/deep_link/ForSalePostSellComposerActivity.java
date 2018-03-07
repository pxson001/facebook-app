package com.facebook.groupcommerce.deep_link;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.locale.Locales;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.groupcommerce.protocol.FetchGroupCommercePreferredMarketplaceInfo;
import com.facebook.groupcommerce.protocol.FetchGroupCommercePreferredMarketplaceInfoModels.PreferredMarketplaceQueryModel;
import com.facebook.groupcommerce.protocol.FetchGroupCommercePreferredMarketplaceInfoModels.PreferredMarketplaceQueryModel.PreferredMarketplacesModel.EdgesModel;
import com.facebook.groupcommerce.protocol.FetchGroupCommercePreferredMarketplaceInfoModels.PreferredMarketplaceQueryModel.PreferredMarketplacesModel.EdgesModel.NodeModel;
import com.facebook.groupcommerce.util.GroupCommerceComposerHelper;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQL;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQL.FetchGroupInformationString;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.groups.protocol.GroupInformationInterfaceFactory;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerTargetData.Builder;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeModels.ComposerTargetDataPrivacyScopeFieldsModel;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Currency;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: VALIDATION_ERROR */
public class ForSalePostSellComposerActivity extends FbFragmentActivity {
    public static String f21278p = "marketplace";
    public static String f21279q = "group";
    @Inject
    ComposerPublishServiceHelper f21280r;
    @Inject
    ComposerLauncher f21281s;
    @Inject
    GraphQLQueryExecutor f21282t;
    @Inject
    TasksManager f21283u;
    @Inject
    Locales f21284v;
    @Inject
    Resources f21285w;

    /* compiled from: VALIDATION_ERROR */
    class C30281 implements Callable<ListenableFuture> {
        final /* synthetic */ ForSalePostSellComposerActivity f21268a;

        C30281(ForSalePostSellComposerActivity forSalePostSellComposerActivity) {
            this.f21268a = forSalePostSellComposerActivity;
        }

        public Object call() {
            return this.f21268a.f21282t.a(GraphQLRequest.a(FetchGroupCommercePreferredMarketplaceInfo.a()));
        }
    }

    private static <T extends Context> void m22174a(Class<T> cls, T t) {
        m22175a((Object) t, (Context) t);
    }

    public static void m22175a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ForSalePostSellComposerActivity) obj).m22173a(ComposerPublishServiceHelper.b(fbInjector), (ComposerLauncher) ComposerLauncherImpl.a(fbInjector), GraphQLQueryExecutor.a(fbInjector), TasksManager.b(fbInjector), Locales.a(fbInjector), ResourcesMethodAutoProvider.a(fbInjector));
    }

    private void m22173a(ComposerPublishServiceHelper composerPublishServiceHelper, ComposerLauncher composerLauncher, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, Locales locales, Resources resources) {
        this.f21280r = composerPublishServiceHelper;
        this.f21281s = composerLauncher;
        this.f21282t = graphQLQueryExecutor;
        this.f21283u = tasksManager;
        this.f21284v = locales;
        this.f21285w = resources;
    }

    protected final void m22178b(Bundle bundle) {
        super.b(bundle);
        Class cls = ForSalePostSellComposerActivity.class;
        m22175a((Object) this, (Context) this);
        if (bundle == null) {
            Intent intent = getIntent();
            if (intent != null) {
                Bundle extras = intent.getExtras();
                String string = extras.getString("for_sale_profile_type");
                if (string.equals(f21278p)) {
                    m22176c(extras);
                } else if (string.equals(f21279q)) {
                    m22177d(extras);
                }
            }
        }
    }

    private void m22176c(Bundle bundle) {
        final String string = bundle.getString("for_sale_profile_type");
        Callable c30281 = new C30281(this);
        final DialogFragment a = ProgressDialogFragment.a(2131234609, true, false, true);
        a.a(kO_(), null);
        this.f21283u.a("QUERY_GROUP_INFORMATION_DATA_FOR_SALE_SELL_COMPOSER", c30281, new AbstractDisposableFutureCallback<GraphQLResult<PreferredMarketplaceQueryModel>>(this) {
            final /* synthetic */ ForSalePostSellComposerActivity f21272d;

            protected final void m22169a(@Nullable Object obj) {
                PreferredMarketplaceQueryModel preferredMarketplaceQueryModel = (PreferredMarketplaceQueryModel) ((GraphQLResult) obj).e;
                if (preferredMarketplaceQueryModel.a() != null) {
                    ImmutableList a = preferredMarketplaceQueryModel.a().a();
                    if (!a.isEmpty()) {
                        NodeModel a2 = ((EdgesModel) a.get(0)).a();
                        if (a2 != null && a2.j() != null) {
                            Builder builder = new Builder(Long.parseLong(a2.j()), TargetType.fromString(string));
                            builder.c = a2.k();
                            String currencyCode = Currency.getInstance(this.f21272d.f21284v.a()).getCurrencyCode();
                            ComposerTargetDataPrivacyScopeFieldsModel.Builder builder2 = new ComposerTargetDataPrivacyScopeFieldsModel.Builder();
                            builder2.b = this.f21272d.f21285w.getString(2131234252);
                            ComposerConfiguration a3 = ComposerConfigurationFactory.a(ComposerSourceSurface.GROUP_FEED, "forSalePostSellComposerActivity", currencyCode, builder.a(builder2.a()).a(), null).a();
                            a.a();
                            this.f21272d.f21281s.a(null, a3, 1756, this);
                        }
                    }
                }
            }

            protected final void m22170a(Throwable th) {
                a.a();
                this.f21272d.finish();
            }
        });
    }

    private void m22177d(Bundle bundle) {
        final long parseLong = Long.parseLong(bundle.getString("for_sale_profile_id"));
        Callable c30303 = new Callable<ListenableFuture>(this) {
            final /* synthetic */ ForSalePostSellComposerActivity f21274b;

            public Object call() {
                FetchGroupInformationString a = FetchGroupInformationGraphQL.a();
                a.a("group_id", Long.valueOf(parseLong));
                return this.f21274b.f21282t.a(GraphQLRequest.a(a));
            }
        };
        final DialogFragment a = ProgressDialogFragment.a(2131234609, true, false, true);
        a.a(kO_(), null);
        this.f21283u.a("QUERY_GROUP_INFORMATION_DATA_FOR_SALE_SELL_COMPOSER", c30303, new AbstractDisposableFutureCallback<GraphQLResult<FetchGroupInformationModel>>(this) {
            final /* synthetic */ ForSalePostSellComposerActivity f21277c;

            protected final void m22171a(@Nullable Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                a.a();
                this.f21277c.f21281s.a(null, GroupCommerceComposerHelper.a(GroupInformationInterfaceFactory.a((FetchGroupInformationModel) graphQLResult.e), this.f21277c.f21284v).a(), 1756, this);
            }

            protected final void m22172a(Throwable th) {
                a.a();
                this.f21277c.finish();
            }
        });
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1756 && i2 == -1) {
            PublishPostParams publishPostParams = (PublishPostParams) intent.getParcelableExtra("publishPostParams");
            if (!(publishPostParams == null || publishPostParams.isPhotoContainer)) {
                this.f21280r.c(intent);
            }
        }
        finish();
    }
}
