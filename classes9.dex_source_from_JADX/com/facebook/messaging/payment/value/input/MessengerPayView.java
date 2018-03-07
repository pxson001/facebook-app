package com.facebook.messaging.payment.value.input;

import android.view.MenuItem;
import android.view.View;
import com.facebook.messaging.payment.value.input.EnterPaymentValueFragment.C17747;
import javax.annotation.Nullable;

/* compiled from: externalRequestId */
public interface MessengerPayView {
    void mo620a();

    void mo621a(@Nullable MenuItem menuItem);

    @Nullable
    View getImmediateFocusView();

    void setListener(C17747 c17747);

    void setMessengerPayViewParams(MessengerPayViewParams messengerPayViewParams);
}
