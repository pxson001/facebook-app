package com.facebook.messaging.attributionview;

import android.net.Uri;
import com.facebook.messaging.attribution.AttributionActionType;
import com.facebook.messaging.attributionview.AttributionViewData.DataChangeListener;
import com.facebook.messaging.model.attribution.AttributionVisibility;
import com.facebook.messaging.model.attribution.AttributionVisibilityBuilder;
import com.facebook.messaging.model.messages.Message;

/* compiled from: original_width */
public class MontageAddAttributionViewData implements AttributionViewData {
    private final AttributionVisibility f7968a;
    private final Message f7969b;

    public MontageAddAttributionViewData(Message message) {
        AttributionVisibilityBuilder newBuilder = AttributionVisibility.newBuilder();
        newBuilder.e = true;
        this.f7968a = newBuilder.h();
        this.f7969b = message;
    }

    public final void mo293a(DataChangeListener dataChangeListener) {
    }

    public final Message mo292a() {
        return this.f7969b;
    }

    public final String mo294b() {
        return String.valueOf(this.f7969b.b.e);
    }

    public final String mo295c() {
        return "";
    }

    public final AttributionActionType mo296d() {
        return AttributionActionType.MONTAGE_ADD;
    }

    public final AttributionVisibility mo297e() {
        return this.f7968a;
    }

    public final Uri mo298f() {
        return null;
    }
}
