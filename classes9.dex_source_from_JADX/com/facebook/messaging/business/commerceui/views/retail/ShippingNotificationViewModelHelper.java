package com.facebook.messaging.business.commerceui.views.retail;

import android.content.Context;
import com.facebook.messaging.business.attachments.model.LogoImage;
import com.facebook.messaging.business.commerce.model.retail.CommerceBubbleModel;
import com.facebook.messaging.business.commerce.model.retail.CommerceBubbleModelType;
import com.facebook.messaging.business.commerce.model.retail.RetailAddress;
import com.facebook.messaging.business.commerce.model.retail.Shipment;
import com.facebook.messaging.business.commerce.model.retail.ShipmentTrackingEvent;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: now_presence */
public class ShippingNotificationViewModelHelper {
    private final Context f8631a;
    @Nullable
    public CommerceBubbleModel f8632b;

    public ShippingNotificationViewModelHelper(Context context) {
        this.f8631a = (Context) Preconditions.checkNotNull(context);
    }

    public final CommerceBubbleModel m8846a() {
        return this.f8632b;
    }

    public final ShippingNotificationViewModelHelper m8847a(CommerceBubbleModel commerceBubbleModel) {
        Preconditions.checkState(CommerceBubbleModelType.isShippingBubble(commerceBubbleModel.b()));
        this.f8632b = (CommerceBubbleModel) Preconditions.checkNotNull(commerceBubbleModel);
        return this;
    }

    @Nullable
    public final LogoImage m8848b() {
        if (this.f8632b != null) {
            if (this.f8632b instanceof Shipment) {
                return ((Shipment) this.f8632b).o;
            }
            if (this.f8632b instanceof ShipmentTrackingEvent) {
                ShipmentTrackingEvent shipmentTrackingEvent = (ShipmentTrackingEvent) this.f8632b;
                if (shipmentTrackingEvent.f != null) {
                    return shipmentTrackingEvent.f.o;
                }
            }
        }
        return null;
    }

    @Nullable
    public final String m8849c() {
        if (this.f8632b.b() == CommerceBubbleModelType.SHIPMENT_TRACKING_DELAYED) {
            return this.f8631a.getResources().getString(2131240659);
        }
        return null;
    }

    @Nullable
    public final String m8850d() {
        if (this.f8632b == null) {
            return null;
        }
        if (this.f8632b.b() == CommerceBubbleModelType.SHIPMENT) {
            return this.f8631a.getResources().getString(2131240663);
        }
        if (this.f8632b.b() == CommerceBubbleModelType.SHIPMENT_ETA || this.f8632b.b() == CommerceBubbleModelType.SHIPMENT_TRACKING_ETA) {
            return this.f8631a.getResources().getString(2131240664);
        }
        if (this.f8632b.b() == CommerceBubbleModelType.SHIPMENT_TRACKING_IN_TRANSIT) {
            return this.f8631a.getResources().getString(2131240668);
        }
        if (this.f8632b.b() == CommerceBubbleModelType.SHIPMENT_TRACKING_OUT_FOR_DELIVERY) {
            return this.f8631a.getResources().getString(2131240665);
        }
        if (this.f8632b.b() == CommerceBubbleModelType.SHIPMENT_TRACKING_DELIVERED) {
            return this.f8631a.getResources().getString(2131240666);
        }
        if (this.f8632b.b() == CommerceBubbleModelType.SHIPMENT_TRACKING_DELAYED) {
            return this.f8631a.getResources().getString(2131240664);
        }
        if (this.f8632b.b() == CommerceBubbleModelType.SHIPMENT_FOR_UNSUPPORTED_CARRIER) {
            return this.f8631a.getResources().getString(2131240663);
        }
        return null;
    }

    @Nullable
    public final String m8851e() {
        if (this.f8632b == null) {
            return null;
        }
        if (this.f8632b.b() == CommerceBubbleModelType.SHIPMENT) {
            return ((Shipment) this.f8632b).g;
        }
        if (this.f8632b.b() == CommerceBubbleModelType.SHIPMENT_ETA || this.f8632b.b() == CommerceBubbleModelType.SHIPMENT_TRACKING_ETA) {
            return ((ShipmentTrackingEvent) this.f8632b).d;
        }
        if (this.f8632b.b() == CommerceBubbleModelType.SHIPMENT_TRACKING_IN_TRANSIT || this.f8632b.b() == CommerceBubbleModelType.SHIPMENT_TRACKING_OUT_FOR_DELIVERY || this.f8632b.b() == CommerceBubbleModelType.SHIPMENT_TRACKING_DELIVERED) {
            return ((ShipmentTrackingEvent) this.f8632b).d;
        }
        if (this.f8632b.b() == CommerceBubbleModelType.SHIPMENT_TRACKING_DELAYED) {
            return this.f8631a.getResources().getString(2131240660, new Object[]{((ShipmentTrackingEvent) this.f8632b).d});
        } else if (this.f8632b.b() == CommerceBubbleModelType.SHIPMENT_FOR_UNSUPPORTED_CARRIER) {
            return ((Shipment) this.f8632b).g;
        } else {
            return null;
        }
    }

    @Nullable
    public final String m8852f() {
        if (this.f8632b != null) {
            if (this.f8632b.b() == CommerceBubbleModelType.SHIPMENT && !Strings.isNullOrEmpty(((Shipment) this.f8632b).k)) {
                return this.f8631a.getResources().getString(2131240664);
            }
            if (this.f8632b.b() == CommerceBubbleModelType.SHIPMENT_FOR_UNSUPPORTED_CARRIER) {
                return this.f8631a.getResources().getString(2131240667);
            }
        }
        return null;
    }

    @Nullable
    public final String m8853g() {
        if (this.f8632b == null) {
            return null;
        }
        if (this.f8632b.b() == CommerceBubbleModelType.SHIPMENT) {
            return ((Shipment) this.f8632b).k;
        }
        if (this.f8632b.b() == CommerceBubbleModelType.SHIPMENT_FOR_UNSUPPORTED_CARRIER) {
            return ((Shipment) this.f8632b).d.a;
        }
        return null;
    }

    public final RetailAddress m8854h() {
        if (this.f8632b != null) {
            if (this.f8632b.b() == CommerceBubbleModelType.SHIPMENT_TRACKING_ETA || this.f8632b.b() == CommerceBubbleModelType.SHIPMENT_TRACKING_IN_TRANSIT || this.f8632b.b() == CommerceBubbleModelType.SHIPMENT_TRACKING_OUT_FOR_DELIVERY || this.f8632b.b() == CommerceBubbleModelType.SHIPMENT_TRACKING_DELIVERED || this.f8632b.b() == CommerceBubbleModelType.SHIPMENT_TRACKING_DELAYED) {
                return ((ShipmentTrackingEvent) this.f8632b).e;
            }
            if (this.f8632b.b() == CommerceBubbleModelType.SHIPMENT) {
                return ((Shipment) this.f8632b).i;
            }
        }
        return null;
    }
}
