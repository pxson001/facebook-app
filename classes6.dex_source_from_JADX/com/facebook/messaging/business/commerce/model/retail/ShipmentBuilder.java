package com.facebook.messaging.business.commerce.model.retail;

import android.net.Uri;
import com.facebook.messaging.business.attachments.model.LogoImage;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachmentItem;
import com.google.common.base.Strings;
import java.util.List;

/* compiled from: video_streaming_config */
public class ShipmentBuilder {
    public String f670a;
    public String f671b;
    public String f672c;
    public RetailCarrier f673d;
    public Uri f674e;
    public long f675f;
    public String f676g;
    public RetailAddress f677h;
    public RetailAddress f678i;
    public long f679j;
    public String f680k;
    public long f681l;
    public String f682m;
    public String f683n;
    public LogoImage f684o;
    public List<PlatformGenericAttachmentItem> f685p;
    public List<ShipmentTrackingEvent> f686q;

    public final ShipmentBuilder m705d(String str) {
        this.f674e = !Strings.isNullOrEmpty(str) ? Uri.parse(str) : null;
        return this;
    }

    public final Shipment m706r() {
        return new Shipment(this);
    }
}
