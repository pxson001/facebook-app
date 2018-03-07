package com.facebook.messaging.attributionview;

import android.net.Uri;
import com.facebook.messaging.attribution.AttributionActionType;
import com.facebook.messaging.attributionview.AttributionViewData.DataChangeListener;
import com.facebook.messaging.model.attribution.AttributionVisibility;
import com.facebook.messaging.model.messages.Message;
import com.google.common.base.Preconditions;

/* compiled from: original_size */
public class PlatformAttributionViewData implements AttributionViewData {
    private final Message f7970a;
    private Uri f7971b;
    private final AttributionActionType f7972c;
    public DataChangeListener f7973d;

    public PlatformAttributionViewData(Message message, AttributionActionType attributionActionType) {
        this.f7970a = (Message) Preconditions.checkNotNull(message);
        Preconditions.checkNotNull(message.F);
        this.f7972c = attributionActionType;
    }

    public final void mo293a(DataChangeListener dataChangeListener) {
        this.f7973d = dataChangeListener;
    }

    public final Message mo292a() {
        return this.f7970a;
    }

    public final String mo294b() {
        return this.f7970a.F.b;
    }

    public final String mo295c() {
        return this.f7970a.F.c;
    }

    public final void m8205a(Uri uri) {
        this.f7971b = uri;
        if (this.f7973d != null) {
            this.f7973d.mo291a();
        }
    }

    public final AttributionActionType mo296d() {
        return this.f7972c;
    }

    public final AttributionVisibility mo297e() {
        return this.f7970a.F.h;
    }

    public final Uri mo298f() {
        return this.f7971b;
    }
}
