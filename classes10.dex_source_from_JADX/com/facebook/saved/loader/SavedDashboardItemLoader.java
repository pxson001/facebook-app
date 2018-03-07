package com.facebook.saved.loader;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.enums.GraphQLSavedDashboardSectionType;
import com.facebook.inject.InjectorLike;
import com.facebook.saved.data.SavedDashboardPaginatedSavedItems;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: jcnuffgfhguyquefoxjhgcbvvcxdbxjdfbcddogqqqkkkfczfkbhtq */
public class SavedDashboardItemLoader {
    public final TasksManager<String> f9225a;
    public final SavedDashboardDataFetcher f9226b;

    /* compiled from: jcnuffgfhguyquefoxjhgcbvvcxdbxjdfbcddogqqqkkkfczfkbhtq */
    public interface ItemLoadListener {
        void mo407a();

        void mo408a(SavedDashboardPaginatedSavedItems savedDashboardPaginatedSavedItems);
    }

    /* compiled from: jcnuffgfhguyquefoxjhgcbvvcxdbxjdfbcddogqqqkkkfczfkbhtq */
    public class C13991 extends AbstractDisposableFutureCallback<SavedDashboardPaginatedSavedItems> {
        final /* synthetic */ Optional f9221a;
        final /* synthetic */ SavedDashboardItemLoader f9222b;

        public C13991(SavedDashboardItemLoader savedDashboardItemLoader, Optional optional) {
            this.f9222b = savedDashboardItemLoader;
            this.f9221a = optional;
        }

        protected final void m9230a(Object obj) {
            if (!((SavedDashboardPaginatedSavedItems) obj).f9121a.isPresent()) {
                this.f9222b.m9240b(this.f9221a, null);
            }
        }

        protected final void m9231a(Throwable th) {
        }
    }

    public static SavedDashboardItemLoader m9236b(InjectorLike injectorLike) {
        return new SavedDashboardItemLoader(TasksManager.b(injectorLike), SavedDashboardDataFetcher.m9222b(injectorLike));
    }

    @Inject
    public SavedDashboardItemLoader(TasksManager tasksManager, SavedDashboardDataFetcher savedDashboardDataFetcher) {
        this.f9225a = tasksManager;
        this.f9226b = savedDashboardDataFetcher;
    }

    public static SavedDashboardItemLoader m9235a(InjectorLike injectorLike) {
        return m9236b(injectorLike);
    }

    public final void m9238a(ListenableFuture<SavedDashboardPaginatedSavedItems> listenableFuture, @Nullable ItemLoadListener itemLoadListener) {
        this.f9225a.a("task_key_fetch_cached_only_saved_items", listenableFuture, m9234a(itemLoadListener));
    }

    public final void m9240b(Optional<GraphQLSavedDashboardSectionType> optional, @Nullable ItemLoadListener itemLoadListener) {
        m9241b(this.f9226b.m9223a(optional, Absent.INSTANCE), itemLoadListener);
    }

    public final void m9241b(ListenableFuture<SavedDashboardPaginatedSavedItems> listenableFuture, ItemLoadListener itemLoadListener) {
        this.f9225a.a("task_key_fetch_fresh_saved_items", listenableFuture, m9234a(itemLoadListener));
    }

    public final void m9237a(Optional<GraphQLSavedDashboardSectionType> optional, Optional<String> optional2, @Nullable ItemLoadListener itemLoadListener) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty((String) optional2.get()));
        this.f9225a.a("task_key_fetch_fresh_saved_items" + optional2, this.f9226b.m9223a(optional, optional2), m9234a(itemLoadListener));
    }

    public final void m9239b() {
        this.f9225a.c();
    }

    @Nullable
    private AbstractDisposableFutureCallback<SavedDashboardPaginatedSavedItems> m9234a(@Nullable final ItemLoadListener itemLoadListener) {
        return new AbstractDisposableFutureCallback<SavedDashboardPaginatedSavedItems>(this) {
            final /* synthetic */ SavedDashboardItemLoader f9224b;

            protected final void m9232a(Object obj) {
                SavedDashboardPaginatedSavedItems savedDashboardPaginatedSavedItems = (SavedDashboardPaginatedSavedItems) obj;
                if (itemLoadListener != null) {
                    itemLoadListener.mo408a(savedDashboardPaginatedSavedItems);
                }
            }

            protected final void m9233a(Throwable th) {
                if (itemLoadListener != null) {
                    itemLoadListener.mo407a();
                }
            }
        };
    }
}
