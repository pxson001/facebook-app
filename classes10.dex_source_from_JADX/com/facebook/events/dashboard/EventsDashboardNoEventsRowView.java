package com.facebook.events.dashboard;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: comm */
public class EventsDashboardNoEventsRowView extends FbTextView {
    @Inject
    public EventsDashboardCaspianPagerController f16688a;
    @Inject
    @IsWorkBuild
    public Boolean f16689b;

    public static void m17081a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        EventsDashboardNoEventsRowView eventsDashboardNoEventsRowView = (EventsDashboardNoEventsRowView) obj;
        EventsDashboardCaspianPagerController a = EventsDashboardCaspianPagerController.m16972a(fbInjector);
        Boolean a2 = Boolean_IsWorkBuildMethodAutoProvider.a(fbInjector);
        eventsDashboardNoEventsRowView.f16688a = a;
        eventsDashboardNoEventsRowView.f16689b = a2;
    }

    public EventsDashboardNoEventsRowView(Context context) {
        int dimensionPixelSize;
        super(context);
        Class cls = EventsDashboardNoEventsRowView.class;
        m17081a(this, getContext());
        Resources resources = context.getResources();
        setBackgroundColor(resources.getColor(2131361920));
        setTextAppearance(context, 2131625809);
        setGravity(17);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(2131431206);
        if (this.f16688a.m16974a()) {
            dimensionPixelSize = resources.getDimensionPixelSize(2131431340);
        } else {
            dimensionPixelSize = resources.getDimensionPixelSize(2131431207);
        }
        int dimensionPixelSize3 = resources.getDimensionPixelSize(2131431206);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(2131431207);
        if (VERSION.SDK_INT >= 17) {
            setPaddingRelative(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize4);
        } else {
            setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize4);
        }
        setMinimumHeight(resources.getDimensionPixelSize(2131431208));
    }

    public final void m17083a(@Nonnull DashboardFilterType dashboardFilterType) {
        m17082b(dashboardFilterType);
    }

    private void m17082b(@Nonnull DashboardFilterType dashboardFilterType) {
        switch (dashboardFilterType) {
            case UPCOMING:
                setText(2131237130);
                return;
            case INVITED:
                setText(2131237131);
                return;
            case HOSTING:
                setText(this.f16689b.booleanValue() ? 2131237133 : 2131237132);
                return;
            case BIRTHDAYS:
                setText(2131237134);
                return;
            case PAST:
                setText(2131237136);
                return;
            default:
                throw new IllegalArgumentException("Unsupported filter type for empty list label: " + dashboardFilterType.name());
        }
    }
}
