package com.facebook.saved.data;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.graphql.enums.GraphQLSavedDashboardSectionType;
import com.facebook.saved.loader.SavedDashboardItemLoader;
import com.facebook.saved.loader.SavedDashboardItemLoader.C13991;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.inject.Inject;

/* compiled from: isBestDevice */
public class SavedDashboardPrefetcher {
    public final SavedDashboardItemLoader f9125a;
    public final DefaultAndroidThreadUtil f9126b;

    /* compiled from: isBestDevice */
    public class C13881 implements Runnable {
        final /* synthetic */ SavedDashboardPrefetcher f9124a;

        public C13881(SavedDashboardPrefetcher savedDashboardPrefetcher) {
            this.f9124a = savedDashboardPrefetcher;
        }

        public void run() {
            SavedDashboardItemLoader savedDashboardItemLoader = this.f9124a.f9125a;
            Optional of = Optional.of(GraphQLSavedDashboardSectionType.ALL);
            savedDashboardItemLoader.f9225a.a("task_key_fetch_cached_only_saved_items", savedDashboardItemLoader.f9226b.m9224b(of, Absent.INSTANCE), new C13991(savedDashboardItemLoader, of));
        }
    }

    @Inject
    public SavedDashboardPrefetcher(SavedDashboardItemLoader savedDashboardItemLoader, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f9125a = savedDashboardItemLoader;
        this.f9126b = defaultAndroidThreadUtil;
    }
}
