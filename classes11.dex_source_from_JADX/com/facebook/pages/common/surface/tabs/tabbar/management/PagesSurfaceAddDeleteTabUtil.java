package com.facebook.pages.common.surface.tabs.tabbar.management;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.calls.PageServicesCardDeleteInputData;
import com.facebook.graphql.calls.PageServicesSectionInputData;
import com.facebook.graphql.calls.PageServicesSectionInputData.Visibility;
import com.facebook.graphql.enums.GraphQLPagePresenceTabType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.pages.common.surface.tabs.tabbar.graphql.PageServicesSectionMutation.PageServicesSectionMutationString;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment.AnonymousClass20;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment.AnonymousClass21;
import com.facebook.pages.identity.protocol.graphql.ServicesMutations.PageServicesCardDeleteMutationString;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: request_started */
public class PagesSurfaceAddDeleteTabUtil {
    public static final ImmutableSet<GraphQLPagePresenceTabType> f2550a = ImmutableSet.builder().c(GraphQLPagePresenceTabType.SERVICES).b();
    private final GraphQLQueryExecutor f2551b;
    private final TasksManager f2552c;

    /* compiled from: request_started */
    interface PagesSurfaceTabListenerWrapper {
        void mo57a(GraphQLPagePresenceTabType graphQLPagePresenceTabType);

        void mo58a(GraphQLPagePresenceTabType graphQLPagePresenceTabType, GraphQLResult graphQLResult);
    }

    /* compiled from: request_started */
    public /* synthetic */ class C03384 {
        public static final /* synthetic */ int[] f2549a = new int[GraphQLPagePresenceTabType.values().length];

        static {
            try {
                f2549a[GraphQLPagePresenceTabType.SERVICES.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    @Inject
    public PagesSurfaceAddDeleteTabUtil(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager) {
        this.f2551b = graphQLQueryExecutor;
        this.f2552c = tasksManager;
    }

    public final void m3497a(String str, GraphQLPagePresenceTabType graphQLPagePresenceTabType, final AnonymousClass20 anonymousClass20) {
        switch (C03384.f2549a[graphQLPagePresenceTabType.ordinal()]) {
            case 1:
                m3496a(GraphQLRequest.a((PageServicesSectionMutationString) new PageServicesSectionMutationString().a("input", new PageServicesSectionInputData().a(str).a(Visibility.PUBLISHED))), str, graphQLPagePresenceTabType, new PagesSurfaceTabListenerWrapper(this) {
                    final /* synthetic */ PagesSurfaceAddDeleteTabUtil f2543b;

                    public final void mo58a(GraphQLPagePresenceTabType graphQLPagePresenceTabType, GraphQLResult graphQLResult) {
                        AnonymousClass20 anonymousClass20 = anonymousClass20;
                        anonymousClass20.f4081a.by = graphQLPagePresenceTabType;
                        PagesSurfaceFragment.av(anonymousClass20.f4081a);
                        PagesSurfaceFragment.m5023e(anonymousClass20.f4081a, GraphQLPagePresenceTabType.HOME);
                    }

                    public final void mo57a(GraphQLPagePresenceTabType graphQLPagePresenceTabType) {
                        AnonymousClass20 anonymousClass20 = anonymousClass20;
                        ((Toaster) anonymousClass20.f4081a.aw.get()).a(new ToastBuilder(2131235444));
                        anonymousClass20.f4081a.bz.b();
                    }
                });
                return;
            default:
                throw new IllegalArgumentException("Invalid tab type to add to page!");
        }
    }

    public final void m3498a(String str, GraphQLPagePresenceTabType graphQLPagePresenceTabType, final AnonymousClass21 anonymousClass21) {
        switch (C03384.f2549a[graphQLPagePresenceTabType.ordinal()]) {
            case 1:
                PageServicesCardDeleteInputData pageServicesCardDeleteInputData = new PageServicesCardDeleteInputData();
                pageServicesCardDeleteInputData.a("page_id", str);
                m3496a(GraphQLRequest.a((PageServicesCardDeleteMutationString) new PageServicesCardDeleteMutationString().a("input", pageServicesCardDeleteInputData)), str, graphQLPagePresenceTabType, new PagesSurfaceTabListenerWrapper(this) {
                    final /* synthetic */ PagesSurfaceAddDeleteTabUtil f2545b;

                    public final void mo58a(GraphQLPagePresenceTabType graphQLPagePresenceTabType, GraphQLResult graphQLResult) {
                        AnonymousClass21 anonymousClass21 = anonymousClass21;
                        PagesSurfaceFragment.av(anonymousClass21.f4082a);
                        PagesSurfaceFragment.m5023e(anonymousClass21.f4082a, GraphQLPagePresenceTabType.HOME);
                        anonymousClass21.f4082a.mo100d(GraphQLPagePresenceTabType.HOME);
                    }

                    public final void mo57a(GraphQLPagePresenceTabType graphQLPagePresenceTabType) {
                        AnonymousClass21 anonymousClass21 = anonymousClass21;
                        ((Toaster) anonymousClass21.f4082a.aw.get()).a(new ToastBuilder(2131235445));
                        anonymousClass21.f4082a.bA.b();
                    }
                });
                return;
            default:
                throw new IllegalArgumentException("Invalid tab type to remove from page!");
        }
    }

    private void m3496a(MutationRequest mutationRequest, String str, final GraphQLPagePresenceTabType graphQLPagePresenceTabType, final PagesSurfaceTabListenerWrapper pagesSurfaceTabListenerWrapper) {
        this.f2552c.a("page_add_tab_" + str + "_" + graphQLPagePresenceTabType.name(), this.f2551b.a(mutationRequest), new AbstractDisposableFutureCallback<GraphQLResult>(this) {
            final /* synthetic */ PagesSurfaceAddDeleteTabUtil f2548c;

            protected final void m3494a(Object obj) {
                pagesSurfaceTabListenerWrapper.mo58a(graphQLPagePresenceTabType, (GraphQLResult) obj);
            }

            protected final void m3495a(Throwable th) {
                pagesSurfaceTabListenerWrapper.mo57a(graphQLPagePresenceTabType);
            }
        });
    }
}
