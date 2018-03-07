package com.facebook.messaging.montage.composer;

import android.content.Context;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: is_local_awareness */
public class MontageSendUtil {
    public final Context f12552a;
    public final SecureContextHelper f12553b;

    @Inject
    public MontageSendUtil(@Assisted Context context, SecureContextHelper secureContextHelper) {
        this.f12552a = context;
        this.f12553b = secureContextHelper;
    }
}
