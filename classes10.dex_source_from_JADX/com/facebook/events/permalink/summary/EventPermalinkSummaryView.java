package com.facebook.events.permalink.summary;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.connectionqe.EventsConnectionExperimentController;
import com.facebook.events.graphql.EventsGraphQLInterfaces.FetchEventPermalinkFragment;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.model.Event;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.inject.FbInjector;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: background_location_obtain_single_location_start */
public class EventPermalinkSummaryView extends SegmentedLinearLayout {
    @Inject
    public EventsConnectionExperimentController f18914a;
    private EventTimeInfoView f18915b;
    private EventLocationInfoView f18916c;
    private EventOrderRideView f18917d;
    private EventTicketInfoView f18918e;
    private EventInvitedByInfoView f18919f;
    private EventGroupInfoView f18920g;
    private EventLocationSharingInfoView f18921h;
    private boolean f18922i;

    public static void m19157a(Object obj, Context context) {
        ((EventPermalinkSummaryView) obj).f18914a = EventsConnectionExperimentController.a(FbInjector.get(context));
    }

    public EventPermalinkSummaryView(Context context, boolean z) {
        super(context);
        this.f18922i = z;
        m19155a(context);
    }

    private void m19155a(Context context) {
        Class cls = EventPermalinkSummaryView.class;
        m19157a(this, getContext());
        setOrientation(1);
        Resources resources = getResources();
        setBackgroundColor(resources.getColor(2131361920));
        setShowSegmentedDividers(this.f18922i ? 0 : 2);
        setSegmentedDividerThickness(1);
        setSegmentedDivider(resources.getDrawable(2131363142));
        if (!this.f18922i) {
            a(getResources().getDimensionPixelSize(2131431163), 0);
        }
        m19158b(context);
    }

    private void m19158b(Context context) {
        Resources resources = getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(2131431161);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(2131431162);
        this.f18915b = (EventTimeInfoView) m19154a(new EventTimeInfoView(context), dimensionPixelSize, 3);
        addView(this.f18915b, m19159d(dimensionPixelSize2));
        this.f18916c = (EventLocationInfoView) m19154a(new EventLocationInfoView(context), dimensionPixelSize, 4);
        addView(this.f18916c, m19159d(dimensionPixelSize2));
        this.f18917d = (EventOrderRideView) m19154a(new EventOrderRideView(context), dimensionPixelSize, 4);
        addView(this.f18917d, m19159d(dimensionPixelSize2));
        this.f18918e = (EventTicketInfoView) m19154a(new EventTicketInfoView(context), dimensionPixelSize, 3);
        addView(this.f18918e, m19159d(dimensionPixelSize2));
        this.f18919f = (EventInvitedByInfoView) m19154a(new EventInvitedByInfoView(context), dimensionPixelSize, 2);
        addView(this.f18919f, m19159d(dimensionPixelSize2));
        this.f18920g = (EventGroupInfoView) m19154a(new EventGroupInfoView(context), dimensionPixelSize, 2);
        addView(this.f18920g, m19159d(dimensionPixelSize2));
        this.f18921h = (EventLocationSharingInfoView) m19154a(new EventLocationSharingInfoView(context), dimensionPixelSize, 2);
        addView(this.f18921h, m19159d(dimensionPixelSize2));
    }

    private <T extends TextView> T m19154a(T t, int i, int i2) {
        t.setMinHeight(i);
        t.setEllipsize(TruncateAt.END);
        t.setMaxLines(i2);
        if (this.f18922i) {
            t.setGravity(48);
            Resources resources = getResources();
            t.setPadding(resources.getDimensionPixelSize(2131431267), resources.getDimensionPixelSize(2131427425), 0, resources.getDimensionPixelSize(2131427429));
            t.setLineSpacing(0.0f, 1.2f);
        } else {
            t.setGravity(16);
        }
        return t;
    }

    private LayoutParams m19159d(int i) {
        MarginLayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        MarginLayoutParamsCompat.b(generateDefaultLayoutParams, i);
        generateDefaultLayoutParams.gravity = this.f18922i ? 48 : 16;
        return generateDefaultLayoutParams;
    }

    public final void m19160a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, EventAnalyticsParams eventAnalyticsParams, boolean z) {
        this.f18922i = z;
        m19156a(this.f18915b, event, fetchEventPermalinkFragmentModel, eventAnalyticsParams);
        m19156a(this.f18916c, event, fetchEventPermalinkFragmentModel, eventAnalyticsParams);
        m19156a(this.f18917d, event, fetchEventPermalinkFragmentModel, eventAnalyticsParams);
        m19156a(this.f18918e, event, fetchEventPermalinkFragmentModel, eventAnalyticsParams);
        if (1 != 0 || z) {
            if (event.G || event.ai == null || event.ai.c == null) {
                this.f18919f.setVisibility(8);
                m19156a(this.f18920g, event, fetchEventPermalinkFragmentModel, eventAnalyticsParams);
                m19156a(this.f18921h, event, fetchEventPermalinkFragmentModel, eventAnalyticsParams);
            }
            this.f18919f.setVisibility(0);
        }
        m19156a(this.f18919f, event, fetchEventPermalinkFragmentModel, eventAnalyticsParams);
        m19156a(this.f18920g, event, fetchEventPermalinkFragmentModel, eventAnalyticsParams);
        m19156a(this.f18921h, event, fetchEventPermalinkFragmentModel, eventAnalyticsParams);
    }

    private <S extends View & EventPermalinkSummaryRow> void m19156a(S s, Event event, @Nullable FetchEventPermalinkFragment fetchEventPermalinkFragment, EventAnalyticsParams eventAnalyticsParams) {
        if (((EventPermalinkSummaryRow) s).mo852a(event, fetchEventPermalinkFragment)) {
            ((EventPermalinkSummaryRow) s).mo851a(event, fetchEventPermalinkFragment, eventAnalyticsParams, this.f18922i);
            s.setVisibility(0);
            return;
        }
        s.setVisibility(8);
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }
}
