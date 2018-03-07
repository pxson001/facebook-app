package com.facebook.messaging.business.ride.view;

import android.content.Context;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import com.facebook.android.maps.model.LatLng;
import com.facebook.inject.FbInjector;
import com.facebook.maps.FbMapViewDelegate;
import com.facebook.maps.delegate.MapDelegate;
import com.facebook.maps.delegate.OnMapReadyDelegateCallback;
import com.facebook.messaging.business.ride.helper.RideMapHelper;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.StoryAttachmentTargetFragmentModel;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

/* compiled from: mmssms_quickfail_msg */
public class RideOrderBubbleView extends CustomRelativeLayout {
    @Inject
    public RideMapHelper f9365a;
    public FbMapViewDelegate f9366b = ((FbMapViewDelegate) a(2131567067));
    public BetterTextView f9367c = ((BetterTextView) a(2131567068));
    public RideRouteInfoView f9368d = ((RideRouteInfoView) a(2131567069));

    /* compiled from: mmssms_quickfail_msg */
    public class C10881 implements OnMapReadyDelegateCallback {
        final /* synthetic */ StoryAttachmentTargetFragmentModel f9363a;
        final /* synthetic */ RideOrderBubbleView f9364b;

        public C10881(RideOrderBubbleView rideOrderBubbleView, StoryAttachmentTargetFragmentModel storyAttachmentTargetFragmentModel) {
            this.f9364b = rideOrderBubbleView;
            this.f9363a = storyAttachmentTargetFragmentModel;
        }

        public final void m9822a(MapDelegate mapDelegate) {
            LatLng a = RideMapHelper.m9707a(this.f9363a.bm());
            LatLng a2 = RideMapHelper.m9707a(this.f9363a.an());
            RideMapHelper rideMapHelper = this.f9364b.f9365a;
            if (RideMapHelper.m9709a(a, a2)) {
                a2 = null;
            }
            rideMapHelper.m9711a(mapDelegate, a, a2);
        }
    }

    public static void m9823a(Object obj, Context context) {
        ((RideOrderBubbleView) obj).f9365a = RideMapHelper.m9708a(FbInjector.get(context));
    }

    public RideOrderBubbleView(Context context) {
        super(context);
        Class cls = RideOrderBubbleView.class;
        m9823a(this, getContext());
        setContentView(2130906891);
        this.f9366b.a(null);
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        LayoutParams layoutParams = this.f9366b.getLayoutParams();
        layoutParams.width = size;
        layoutParams.height = (int) (((double) ((float) size)) / 1.9d);
        this.f9366b.setLayoutParams(layoutParams);
        super.onMeasure(i, i2);
    }
}
