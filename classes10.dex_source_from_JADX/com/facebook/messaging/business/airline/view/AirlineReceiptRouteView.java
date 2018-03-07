package com.facebook.messaging.business.airline.view;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsModels.AirlineConfirmationBubbleModel.ItineraryLegsModel.NodesModel.SegmentsModel;
import com.facebook.messaging.graphql.threads.business.AirlineThreadFragmentsModels.AirlineConfirmationBubbleModel.ItineraryLegsModel.NodesModel.SegmentsModel.SegmentsNodesModel;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: thread_event_reminder_title */
public class AirlineReceiptRouteView extends CustomRelativeLayout {
    private final BetterTextView f1606a;
    private final BetterTextView f1607b;
    private final AirlineAirportRouteView f1608c;

    public AirlineReceiptRouteView(Context context) {
        this(context, null, 0);
    }

    public AirlineReceiptRouteView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AirlineReceiptRouteView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130903207);
        this.f1606a = (BetterTextView) a(2131559492);
        this.f1607b = (BetterTextView) a(2131559493);
        this.f1608c = (AirlineAirportRouteView) a(2131559494);
        this.f1608c.setTintColor(getResources().getColor(2131363824));
    }

    public void setFlightDetail(SegmentsModel segmentsModel) {
        int size = segmentsModel.a().size();
        if (size == 0) {
            setVisibility(8);
            return;
        }
        SegmentsNodesModel segmentsNodesModel = (SegmentsNodesModel) segmentsModel.a().get(0);
        SegmentsNodesModel segmentsNodesModel2 = (SegmentsNodesModel) segmentsModel.a().get(size - 1);
        if (segmentsNodesModel.a() == null || segmentsNodesModel2.a() == null || segmentsNodesModel.a().b() == null || segmentsNodesModel2.a().a() == null || segmentsNodesModel.a().c() == null) {
            setVisibility(8);
            return;
        }
        this.f1607b.setText(segmentsNodesModel.a().c().b());
        this.f1608c.setDepartureAirport(segmentsNodesModel.a().b());
        this.f1608c.setArrivalAirport(segmentsNodesModel2.a().a());
    }

    public void setNumberOfStops(String str) {
        this.f1606a.setText(str);
    }

    public void setTintColor(int i) {
        this.f1608c.setTintColor(i);
    }
}
