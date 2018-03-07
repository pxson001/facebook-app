package com.facebook.pages.identity.common;

import android.content.Context;
import android.view.LayoutInflater;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.pages.common.surface.cards.interfaces.PageCardType;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageCardView;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.identity.batching.PageCardsRenderScheduler;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: privacy_checkup_write_request_failure */
public interface PageCardSpecifications {

    /* compiled from: privacy_checkup_write_request_failure */
    public interface PageIdentityCardSpecification {
        PageCardView mo76a(LayoutInflater layoutInflater, Context context);

        boolean mo77a();

        PageCardType mo79b();

        FetchType mo80c();
    }

    /* compiled from: privacy_checkup_write_request_failure */
    public interface PageHeaderCardSpecification extends PageIdentityCardSpecification {
        boolean mo78a(PageHeaderData pageHeaderData);
    }

    /* compiled from: privacy_checkup_write_request_failure */
    public interface PageBatchFetchingCardSpecification extends PageIdentityCardSpecification {
        Optional<? extends ListenableFuture<? extends GraphQLResult<?>>> mo81a(long j, GraphQLBatchRequest graphQLBatchRequest, PageViewPlaceHolder pageViewPlaceHolder, Context context, LayoutInflater layoutInflater, PageHeaderData pageHeaderData, GraphQLCachePolicy graphQLCachePolicy, PageCardsRenderScheduler pageCardsRenderScheduler);
    }

    /* compiled from: privacy_checkup_write_request_failure */
    public enum FetchType {
        EXTRA,
        PRIMARY,
        SECONDARY
    }
}
