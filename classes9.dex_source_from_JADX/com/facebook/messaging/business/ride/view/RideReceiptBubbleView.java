package com.facebook.messaging.business.ride.view;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.facebook.android.maps.model.LatLng;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.FbMapViewDelegate;
import com.facebook.maps.delegate.MapDelegate;
import com.facebook.maps.delegate.MapDelegate.OnMapClickListener;
import com.facebook.maps.delegate.OnMapReadyDelegateCallback;
import com.facebook.messaging.business.common.helper.LogoViewHelper;
import com.facebook.messaging.business.common.view.BusinessPairTextView;
import com.facebook.messaging.business.ride.helper.RideMapHelper;
import com.facebook.messaging.graphql.threads.business.RideThreadFragmentsInterfaces.BusinessRideReceiptFragment;
import com.facebook.messaging.linkhandling.LinkHandlingHelper;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

/* compiled from: mmssms_error_type */
public class RideReceiptBubbleView extends CustomLinearLayout {
    @Inject
    public RideMapHelper f9373a;
    @Inject
    public LogoViewHelper f9374b;
    @Inject
    public Lazy<LinkHandlingHelper> f9375c;
    public Uri f9376d;
    public FbMapViewDelegate f9377e = ((FbMapViewDelegate) a(2131567074));
    public FbDraweeView f9378f;
    public RideRouteInfoView f9379g;
    public BusinessPairTextView f9380h;
    public BusinessPairTextView f9381i;
    public BusinessPairTextView f9382j;
    public BetterTextView f9383k;
    public OnMapClickListener f9384l;

    /* compiled from: mmssms_error_type */
    public class C10891 implements OnClickListener {
        final /* synthetic */ RideReceiptBubbleView f9369a;

        public C10891(RideReceiptBubbleView rideReceiptBubbleView) {
            this.f9369a = rideReceiptBubbleView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -790533522);
            if (this.f9369a.f9376d != null) {
                ((LinkHandlingHelper) this.f9369a.f9375c.get()).a(this.f9369a.getContext(), this.f9369a.f9376d);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 675023579, a);
        }
    }

    /* compiled from: mmssms_error_type */
    public class C10902 implements OnMapClickListener {
        final /* synthetic */ RideReceiptBubbleView f9370a;

        public C10902(RideReceiptBubbleView rideReceiptBubbleView) {
            this.f9370a = rideReceiptBubbleView;
        }

        public final void m9824a() {
            if (this.f9370a.f9376d != null) {
                ((LinkHandlingHelper) this.f9370a.f9375c.get()).a(this.f9370a.getContext(), this.f9370a.f9376d);
            }
        }
    }

    /* compiled from: mmssms_error_type */
    public class C10913 implements OnMapReadyDelegateCallback {
        final /* synthetic */ BusinessRideReceiptFragment f9371a;
        final /* synthetic */ RideReceiptBubbleView f9372b;

        public C10913(RideReceiptBubbleView rideReceiptBubbleView, BusinessRideReceiptFragment businessRideReceiptFragment) {
            this.f9372b = rideReceiptBubbleView;
            this.f9371a = businessRideReceiptFragment;
        }

        public final void m9825a(MapDelegate mapDelegate) {
            LatLng a = RideMapHelper.m9707a(this.f9371a.bm());
            LatLng a2 = RideMapHelper.m9707a(this.f9371a.an());
            RideMapHelper rideMapHelper = this.f9372b.f9373a;
            if (RideMapHelper.m9709a(a, a2)) {
                a2 = null;
            }
            rideMapHelper.m9711a(mapDelegate, a, a2);
            mapDelegate.a(this.f9372b.f9384l);
        }
    }

    public static void m9826a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        RideReceiptBubbleView rideReceiptBubbleView = (RideReceiptBubbleView) obj;
        RideMapHelper a = RideMapHelper.m9708a(injectorLike);
        LogoViewHelper b = LogoViewHelper.m9022b(injectorLike);
        Lazy b2 = IdBasedSingletonScopeProvider.b(injectorLike, 7898);
        rideReceiptBubbleView.f9373a = a;
        rideReceiptBubbleView.f9374b = b;
        rideReceiptBubbleView.f9375c = b2;
    }

    public RideReceiptBubbleView(Context context) {
        super(context);
        Class cls = RideReceiptBubbleView.class;
        m9826a(this, getContext());
        setContentView(2130906893);
        this.f9377e.a(null);
        this.f9379g = (RideRouteInfoView) a(2131567070);
        this.f9378f = (FbDraweeView) a(2131567075);
        this.f9380h = (BusinessPairTextView) a(2131567071);
        this.f9381i = (BusinessPairTextView) a(2131567072);
        this.f9382j = (BusinessPairTextView) a(2131567073);
        this.f9383k = (BetterTextView) a(2131560074);
        setOrientation(1);
        setOnClickListener(new C10891(this));
        this.f9384l = new C10902(this);
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        LayoutParams layoutParams = this.f9377e.getLayoutParams();
        layoutParams.width = size;
        layoutParams.height = (int) (((double) ((float) size)) / 1.9d);
        this.f9377e.setLayoutParams(layoutParams);
        super.onMeasure(i, i2);
    }
}
