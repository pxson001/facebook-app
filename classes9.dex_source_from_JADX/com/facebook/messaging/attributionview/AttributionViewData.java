package com.facebook.messaging.attributionview;

import android.net.Uri;
import com.facebook.messaging.attribution.AttributionActionType;
import com.facebook.messaging.model.attribution.AttributionVisibility;
import com.facebook.messaging.model.messages.Message;

/* compiled from: other_color */
public interface AttributionViewData {

    /* compiled from: other_color */
    public interface DataChangeListener {
        void mo291a();
    }

    Message mo292a();

    void mo293a(DataChangeListener dataChangeListener);

    String mo294b();

    String mo295c();

    AttributionActionType mo296d();

    AttributionVisibility mo297e();

    Uri mo298f();
}
