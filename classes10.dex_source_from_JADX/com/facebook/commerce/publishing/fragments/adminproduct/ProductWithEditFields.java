package com.facebook.commerce.publishing.fragments.adminproduct;

import com.facebook.commerce.publishing.fetcher.AdminProductFetcher;
import com.facebook.commerce.publishing.fragments.adminproduct.ProductInitializationLoadable.ResultHandler;
import com.facebook.commerce.publishing.graphql.FetchAdminCommerceProductItem.FetchAdminCommerceProductItemString;
import com.facebook.commerce.publishing.graphql.FetchAdminCommerceProductItemModels.FetchAdminCommerceProductItemModel;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: currentactivity_null */
public class ProductWithEditFields implements ProductInitializationLoadable<FetchAdminCommerceProductItemModel> {
    private final AdminProductFetcher f15631a;
    private final TasksManager f15632b;
    public final String f15633c;
    public final ResultHandler f15634d;

    /* compiled from: currentactivity_null */
    public class C21801 extends AbstractDisposableFutureCallback<FetchAdminCommerceProductItemModel> {
        final /* synthetic */ ProductWithEditFields f15630a;

        public C21801(ProductWithEditFields productWithEditFields) {
            this.f15630a = productWithEditFields;
        }

        protected final void m16106a(@Nullable Object obj) {
            this.f15630a.f15634d.mo760a((FetchAdminCommerceProductItemModel) obj);
        }

        protected final void m16107a(Throwable th) {
            this.f15630a.f15634d.mo761a("ProductWithEditFields failure. productItemId: " + this.f15630a.f15633c, th);
        }
    }

    @Inject
    public ProductWithEditFields(AdminProductFetcher adminProductFetcher, @Assisted TasksManager tasksManager, @Assisted String str, @Assisted ResultHandler<FetchAdminCommerceProductItemModel> resultHandler) {
        this.f15631a = adminProductFetcher;
        this.f15632b = tasksManager;
        this.f15633c = str;
        this.f15634d = resultHandler;
    }

    public final void mo762a() {
        TasksManager tasksManager = this.f15632b;
        String name = ProductWithEditFields.class.getName();
        AdminProductFetcher adminProductFetcher = this.f15631a;
        GraphQLRequest a = GraphQLRequest.a((FetchAdminCommerceProductItemString) new FetchAdminCommerceProductItemString().a("product_id", this.f15633c));
        a.a(RequestPriority.INTERACTIVE);
        tasksManager.a(name, GraphQLQueryExecutor.a(adminProductFetcher.f15528a.a(a)), new C21801(this));
    }
}
