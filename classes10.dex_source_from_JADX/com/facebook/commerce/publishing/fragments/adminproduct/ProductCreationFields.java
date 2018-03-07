package com.facebook.commerce.publishing.fragments.adminproduct;

import com.facebook.commerce.publishing.fetcher.AdminProductFetcher;
import com.facebook.commerce.publishing.fragments.adminproduct.ProductInitializationLoadable.ResultHandler;
import com.facebook.commerce.publishing.graphql.FetchAdminCommerceProductCreationFields.FetchAdminCommerceProductCreationFieldsString;
import com.facebook.commerce.publishing.graphql.FetchAdminCommerceProductCreationFieldsModels.PageShopProductCreationFieldsModel;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: custom_events_file */
public class ProductCreationFields implements ProductInitializationLoadable<PageShopProductCreationFieldsModel> {
    private final AdminProductFetcher f15626a;
    private final TasksManager f15627b;
    public final String f15628c;
    public final ResultHandler f15629d;

    /* compiled from: custom_events_file */
    public class C21791 extends AbstractDisposableFutureCallback<PageShopProductCreationFieldsModel> {
        final /* synthetic */ ProductCreationFields f15625a;

        public C21791(ProductCreationFields productCreationFields) {
            this.f15625a = productCreationFields;
        }

        protected final void m16103a(@Nullable Object obj) {
            this.f15625a.f15629d.mo760a((PageShopProductCreationFieldsModel) obj);
        }

        protected final void m16104a(Throwable th) {
            this.f15625a.f15629d.mo761a("ProductCreationFields failure. pageId: " + this.f15625a.f15628c, th);
        }
    }

    @Inject
    public ProductCreationFields(AdminProductFetcher adminProductFetcher, @Assisted TasksManager tasksManager, @Assisted String str, @Assisted ResultHandler<PageShopProductCreationFieldsModel> resultHandler) {
        this.f15626a = adminProductFetcher;
        this.f15627b = tasksManager;
        this.f15628c = str;
        this.f15629d = resultHandler;
    }

    public final void mo762a() {
        TasksManager tasksManager = this.f15627b;
        String name = ProductCreationFields.class.getName();
        AdminProductFetcher adminProductFetcher = this.f15626a;
        GraphQLRequest a = GraphQLRequest.a((FetchAdminCommerceProductCreationFieldsString) new FetchAdminCommerceProductCreationFieldsString().a("page_id", this.f15628c));
        a.a(RequestPriority.INTERACTIVE);
        tasksManager.a(name, GraphQLQueryExecutor.a(adminProductFetcher.f15528a.a(a)), new C21791(this));
    }
}
