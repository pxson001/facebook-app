package com.facebook.messaging.business.commerceui.views.retail;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.android.maps.model.BitmapDescriptor;
import com.facebook.android.maps.model.BitmapDescriptorFactory;
import com.facebook.android.maps.model.LatLng;
import com.facebook.android.maps.model.LatLngBounds;
import com.facebook.android.maps.model.LatLngBounds.Builder;
import com.facebook.android.maps.model.MarkerOptions;
import com.facebook.android.maps.model.PolylineOptions;
import com.facebook.inject.InjectorLike;
import com.facebook.maps.FbMapViewDelegate;
import com.facebook.maps.delegate.CameraUpdateFactoryDelegate;
import com.facebook.maps.delegate.MapDelegate;
import com.facebook.maps.delegate.OnMapReadyDelegateCallback;
import com.facebook.messaging.business.commerce.model.retail.CommerceBubbleModel;
import com.facebook.messaging.business.commerce.model.retail.RetailAddress;
import com.facebook.messaging.business.commerce.model.retail.Shipment;
import com.facebook.messaging.business.commerce.model.retail.ShipmentTrackingEvent;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: null ViewerContextUser found when populating the banner for payment platform context. */
public class MapViewHelper {
    public final int f8515a;
    public final int f8516b;
    public final int f8517c;
    public final int f8518d;
    public final BitmapDescriptor f8519e = BitmapDescriptorFactory.a(2130843717);
    public final BitmapDescriptor f8520f = BitmapDescriptorFactory.a(2130841461);
    public LatLngBounds f8521g;

    /* compiled from: null ViewerContextUser found when populating the banner for payment platform context. */
    public class C09712 implements OnMapReadyDelegateCallback {
        final /* synthetic */ MapViewHelper f8514a;

        public C09712(MapViewHelper mapViewHelper) {
            this.f8514a = mapViewHelper;
        }

        public final void m8758a(MapDelegate mapDelegate) {
            mapDelegate.a(CameraUpdateFactoryDelegate.a(this.f8514a.f8521g, this.f8514a.f8518d));
        }
    }

    public static MapViewHelper m8760b(InjectorLike injectorLike) {
        return new MapViewHelper((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public MapViewHelper(Context context) {
        Resources resources = context.getResources();
        this.f8515a = resources.getColor(2131363768);
        this.f8516b = resources.getColor(2131363769);
        this.f8517c = resources.getDimensionPixelSize(2131433508);
        BitmapDescriptorFactory.a(context.getApplicationContext());
        this.f8518d = resources.getDimensionPixelSize(2131430977);
    }

    public final void m8761a(CommerceBubbleModel commerceBubbleModel, FbMapViewDelegate fbMapViewDelegate) {
        LatLng b;
        LatLng latLng = null;
        ImmutableList immutableList = RegularImmutableList.a;
        if (commerceBubbleModel instanceof Shipment) {
            Shipment shipment = (Shipment) commerceBubbleModel;
            b = m8759b(shipment.i);
            latLng = m8759b(shipment.h);
        } else {
            if (commerceBubbleModel instanceof ShipmentTrackingEvent) {
                ShipmentTrackingEvent shipmentTrackingEvent = (ShipmentTrackingEvent) commerceBubbleModel;
                if (shipmentTrackingEvent.f != null) {
                    b = m8759b(shipmentTrackingEvent.f.i);
                    latLng = m8759b(shipmentTrackingEvent.f.h);
                    immutableList = shipmentTrackingEvent.f.q;
                }
            }
            b = null;
        }
        if (b == null || latLng == null) {
            fbMapViewDelegate.setVisibility(8);
            return;
        }
        fbMapViewDelegate.a(new OnMapReadyDelegateCallback(this) {
            final /* synthetic */ MapViewHelper f8513d;

            public final void m8757a(MapDelegate mapDelegate) {
                LatLng latLng;
                int i = 0;
                mapDelegate.a();
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.c = this.f8513d.f8520f;
                markerOptions = markerOptions;
                markerOptions.b = b;
                markerOptions = markerOptions;
                markerOptions.j = 2.0f;
                mapDelegate.a(markerOptions);
                markerOptions = new MarkerOptions();
                markerOptions.j = 1.0f;
                markerOptions = markerOptions;
                markerOptions.c = this.f8513d.f8519e;
                MarkerOptions a = markerOptions.a(0.5f, 0.5f);
                a.b = b;
                mapDelegate.a(a);
                a.b = latLng;
                mapDelegate.a(a);
                PolylineOptions polylineOptions = new PolylineOptions();
                polylineOptions.f = 0.0f;
                polylineOptions = polylineOptions;
                polylineOptions.a = this.f8513d.f8516b;
                polylineOptions = polylineOptions;
                polylineOptions.e = (float) this.f8513d.f8517c;
                PolylineOptions polylineOptions2 = polylineOptions;
                polylineOptions2.a(b);
                if (immutableList.isEmpty()) {
                    latLng = latLng;
                } else {
                    latLng = MapViewHelper.m8759b(((ShipmentTrackingEvent) immutableList.get(0)).e);
                }
                polylineOptions2.a(latLng);
                if (polylineOptions2.c.size() >= 2) {
                    mapDelegate.a(polylineOptions2);
                }
                polylineOptions = new PolylineOptions();
                polylineOptions.f = 0.0f;
                polylineOptions = polylineOptions;
                polylineOptions.a = this.f8513d.f8515a;
                polylineOptions = polylineOptions;
                polylineOptions.e = (float) this.f8513d.f8517c;
                polylineOptions2 = polylineOptions;
                Builder a2 = LatLngBounds.a();
                a2.a(b);
                int size = immutableList.size();
                while (i < size) {
                    latLng = MapViewHelper.m8759b(((ShipmentTrackingEvent) immutableList.get(i)).e);
                    if (latLng != null) {
                        polylineOptions2.a(latLng);
                        a.b = latLng;
                        a2.a(latLng);
                        mapDelegate.a(a);
                    }
                    i++;
                }
                polylineOptions2.a(latLng);
                if (polylineOptions2.c.size() >= 2) {
                    mapDelegate.a(polylineOptions2);
                }
                a2.a(latLng);
                this.f8513d.f8521g = a2.a();
                mapDelegate.a(CameraUpdateFactoryDelegate.a(this.f8513d.f8521g, this.f8513d.f8518d));
            }
        });
        fbMapViewDelegate.setVisibility(0);
    }

    @Nullable
    public static LatLng m8759b(RetailAddress retailAddress) {
        if (retailAddress == null || (retailAddress.h == 0.0d && retailAddress.i == 0.0d)) {
            return null;
        }
        return new LatLng(retailAddress.h, retailAddress.i);
    }
}
