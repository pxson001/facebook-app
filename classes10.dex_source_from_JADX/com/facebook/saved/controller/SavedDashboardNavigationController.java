package com.facebook.saved.controller;

import android.support.v4.app.Fragment;
import com.facebook.graphql.enums.GraphQLSavedDashboardSectionType;
import com.facebook.inject.Assisted;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.saved.common.data.SavedDashboardSection;
import com.facebook.saved.fragment.SavedDashboardChildFragmentInstanceManager;
import com.facebook.saved.fragment.SavedDashboardFragmentInfo;
import com.facebook.saved.helper.SavedSectionHelper;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.inject.Inject;

/* compiled from: is_fetching_old_birthdays */
public class SavedDashboardNavigationController {
    public final SavedDashboardChildFragmentInstanceManager f9035a;
    private Optional<SavedDashboardSection> f9036b = Absent.INSTANCE;
    private final SaveAnalyticsLogger f9037c;
    private final SavedSectionHelper f9038d;

    /* compiled from: is_fetching_old_birthdays */
    public interface NavigationEventListener {
        void mo417a(Optional<SavedDashboardSection> optional);
    }

    @Inject
    public SavedDashboardNavigationController(@Assisted SavedDashboardChildFragmentInstanceManager savedDashboardChildFragmentInstanceManager, SaveAnalyticsLogger saveAnalyticsLogger, SavedSectionHelper savedSectionHelper) {
        this.f9035a = savedDashboardChildFragmentInstanceManager;
        this.f9037c = saveAnalyticsLogger;
        this.f9038d = savedSectionHelper;
    }

    public final void m9057a(SavedDashboardSection savedDashboardSection) {
        this.f9037c.a(m9055a(), savedDashboardSection.a);
        m9054a(Optional.of(savedDashboardSection), SavedDashboardFragmentInfo.SAVED_ITEMS_LIST);
    }

    public final void m9056a(GraphQLSavedDashboardSectionType graphQLSavedDashboardSectionType) {
        m9054a(this.f9038d.m9183a(graphQLSavedDashboardSectionType), SavedDashboardFragmentInfo.SAVED_ITEMS_LIST);
    }

    private void m9054a(Optional<SavedDashboardSection> optional, SavedDashboardFragmentInfo savedDashboardFragmentInfo) {
        this.f9035a.m9127a(savedDashboardFragmentInfo);
        if (!this.f9036b.equals(optional)) {
            Fragment a = this.f9035a.m9126a();
            if (a instanceof NavigationEventListener) {
                ((NavigationEventListener) a).mo417a(optional);
            }
        }
        this.f9036b = optional;
    }

    public final GraphQLSavedDashboardSectionType m9055a() {
        return (GraphQLSavedDashboardSectionType) SavedSectionHelper.m9181a(this.f9036b).or(GraphQLSavedDashboardSectionType.ALL);
    }
}
