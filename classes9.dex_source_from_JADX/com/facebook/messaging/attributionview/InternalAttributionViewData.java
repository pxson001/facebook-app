package com.facebook.messaging.attributionview;

import android.net.Uri;
import com.facebook.messaging.attribution.AttributionActionType;
import com.facebook.messaging.attributionview.AttributionViewData.DataChangeListener;
import com.facebook.messaging.model.attribution.AttributionVisibility;
import com.facebook.messaging.model.attribution.AttributionVisibilityBuilder;
import com.facebook.messaging.model.messages.Message;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Source;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: orion_messenger_pay_params */
public class InternalAttributionViewData implements AttributionViewData {
    private static final AttributionVisibility f7963e;
    private final Message f7964a;
    private final Source f7965b;
    private final String f7966c;
    private final Uri f7967d;

    static {
        AttributionVisibilityBuilder newBuilder = AttributionVisibility.newBuilder();
        newBuilder.c = true;
        f7963e = newBuilder.h();
    }

    public InternalAttributionViewData(Message message, String str, Uri uri) {
        this.f7964a = message;
        this.f7965b = ((MediaResource) message.a().get(0)).e;
        this.f7966c = str;
        this.f7967d = uri;
    }

    public final void mo293a(DataChangeListener dataChangeListener) {
    }

    public final Message mo292a() {
        return this.f7964a;
    }

    public final String mo294b() {
        return this.f7965b.toString();
    }

    public final String mo295c() {
        return this.f7966c;
    }

    public final AttributionActionType mo296d() {
        return AttributionActionType.INTERNAL_FEATURE_REPLY;
    }

    public final AttributionVisibility mo297e() {
        return f7963e;
    }

    public final Uri mo298f() {
        return this.f7967d;
    }
}
