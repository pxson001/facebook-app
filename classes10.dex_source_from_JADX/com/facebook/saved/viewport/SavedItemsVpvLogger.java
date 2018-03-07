package com.facebook.saved.viewport;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.StringUtil;
import com.facebook.common.viewport.BaseViewportEventListener;
import com.facebook.graphql.enums.GraphQLSavedDashboardSectionType;
import com.facebook.inject.Assisted;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.saved.controller.SavedDataAndListStateController;
import com.facebook.saved.data.SavedDashboardItem;
import com.facebook.saved.helper.SavedSectionHelper;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: instant_shopping_post_action_failure */
public class SavedItemsVpvLogger extends BaseViewportEventListener {
    public static final String f9327a = SavedItemsVpvLogger.class.getSimpleName();
    private final SavedDataAndListStateController f9328b;
    public final MonotonicClock f9329c;
    public final AbstractFbErrorReporter f9330d;
    private final SavedSectionHelper f9331e;
    private final SaveAnalyticsLogger f9332f;
    public final Map<SavedDashboardItem, Long> f9333g;
    public boolean f9334h = false;

    @Inject
    public SavedItemsVpvLogger(@Assisted SavedDataAndListStateController savedDataAndListStateController, SaveAnalyticsLogger saveAnalyticsLogger, SavedSectionHelper savedSectionHelper, MonotonicClock monotonicClock, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f9328b = savedDataAndListStateController;
        this.f9332f = saveAnalyticsLogger;
        this.f9331e = savedSectionHelper;
        this.f9329c = monotonicClock;
        this.f9330d = abstractFbErrorReporter;
        this.f9333g = Maps.c();
    }

    public final void m9491a(Object obj) {
        if (obj instanceof SavedDashboardItem) {
            SavedDashboardItem savedDashboardItem = (SavedDashboardItem) obj;
            if (!(savedDashboardItem.f9112g == null || StringUtil.a(savedDashboardItem.f9112g.m9318o()))) {
                if (!this.f9333g.containsKey(savedDashboardItem)) {
                    this.f9333g.put(savedDashboardItem, Long.valueOf(this.f9329c.now()));
                } else if (!this.f9334h) {
                    this.f9334h = true;
                    this.f9330d.b(f9327a, StringFormatUtil.formatStrLocaleSafe("Saved Item %s enters the viewport twice without exiting.", savedDashboardItem.f9106a));
                }
            }
        }
    }

    public final void m9492b(Object obj) {
        if (obj instanceof SavedDashboardItem) {
            m9489b((SavedDashboardItem) obj);
        }
    }

    private void m9489b(SavedDashboardItem savedDashboardItem) {
        if (savedDashboardItem.f9112g == null || StringUtil.a(savedDashboardItem.f9112g.m9318o())) {
            if (!this.f9334h) {
                this.f9334h = true;
                this.f9330d.b(f9327a, StringFormatUtil.formatStrLocaleSafe("Saved Item %s does not have ID to be logged.", savedDashboardItem.f9106a));
            }
        } else if (this.f9333g.containsKey(savedDashboardItem)) {
            long longValue = ((Long) this.f9333g.get(savedDashboardItem)).longValue();
            this.f9332f.a(savedDashboardItem.f9112g.m9318o(), (GraphQLSavedDashboardSectionType) SavedSectionHelper.m9181a(this.f9328b.f9084s).or(GraphQLSavedDashboardSectionType.ALL), this.f9329c.now() - longValue);
            this.f9333g.remove(savedDashboardItem);
        } else {
            m9490e(savedDashboardItem);
        }
    }

    private void m9490e(SavedDashboardItem savedDashboardItem) {
        if (!this.f9334h) {
            this.f9334h = true;
            this.f9330d.b(f9327a, StringFormatUtil.formatStrLocaleSafe("Saved Item %s exits the viewport without entering.", savedDashboardItem.f9106a));
        }
    }
}
