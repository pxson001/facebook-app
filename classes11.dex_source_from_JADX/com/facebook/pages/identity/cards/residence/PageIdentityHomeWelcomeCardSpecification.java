package com.facebook.pages.identity.cards.residence;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.pages.ProfilePermissions.Permission;
import com.facebook.pages.common.surface.cards.interfaces.PageCardType;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageCardView;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageSecondaryCardView;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.identity.batching.PageCardsRenderScheduler;
import com.facebook.pages.identity.common.PageCardSpecifications.FetchType;
import com.facebook.pages.identity.common.PageCardSpecifications.PageBatchFetchingCardSpecification;
import com.facebook.pages.identity.common.PageViewPlaceHolder;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

/* compiled from: pref */
public class PageIdentityHomeWelcomeCardSpecification implements PageBatchFetchingCardSpecification {
    public static PageIdentityHomeWelcomeCardSpecification m4676a(InjectorLike injectorLike) {
        return new PageIdentityHomeWelcomeCardSpecification();
    }

    public final /* bridge */ /* synthetic */ PageCardView mo76a(LayoutInflater layoutInflater, Context context) {
        return m4675a(context);
    }

    public final boolean mo77a() {
        return true;
    }

    public static PageSecondaryCardView m4675a(Context context) {
        return new PageIdentityHomeWelcomeCardView(context, null, 2130773402);
    }

    public final PageCardType mo79b() {
        return PageCardType.WELCOME_HOME;
    }

    public final FetchType mo80c() {
        return FetchType.SECONDARY;
    }

    public final Optional<? extends ListenableFuture<? extends GraphQLResult<?>>> mo81a(long j, GraphQLBatchRequest graphQLBatchRequest, PageViewPlaceHolder pageViewPlaceHolder, Context context, LayoutInflater layoutInflater, PageHeaderData pageHeaderData, GraphQLCachePolicy graphQLCachePolicy, PageCardsRenderScheduler pageCardsRenderScheduler) {
        if (pageHeaderData.g().K() != GraphQLPlaceType.RESIDENCE || !pageHeaderData.a(Permission.EDIT_PROFILE)) {
            return Absent.withType();
        }
        ListenableFuture a = Futures.a(null);
        final PageViewPlaceHolder pageViewPlaceHolder2 = pageViewPlaceHolder;
        final LayoutInflater layoutInflater2 = layoutInflater;
        final Context context2 = context;
        final PageCardsRenderScheduler pageCardsRenderScheduler2 = pageCardsRenderScheduler;
        Futures.a(a, new FutureCallback<GraphQLResult<?>>(this) {
            final /* synthetic */ PageIdentityHomeWelcomeCardSpecification f3649e;

            /* compiled from: pref */
            class C04991 implements Runnable {
                final /* synthetic */ C05001 f3644a;

                C04991(C05001 c05001) {
                    this.f3644a = c05001;
                }

                public void run() {
                    if (pageViewPlaceHolder2.f3791d == null) {
                        pageViewPlaceHolder2.m4758a((View) PageIdentityHomeWelcomeCardSpecification.m4675a(context2));
                    }
                }
            }

            public void onSuccess(@Nullable Object obj) {
                pageCardsRenderScheduler2.m4244a(this.f3649e.mo79b(), new C04991(this));
            }

            public void onFailure(Throwable th) {
            }
        });
        return Optional.of(a);
    }
}
