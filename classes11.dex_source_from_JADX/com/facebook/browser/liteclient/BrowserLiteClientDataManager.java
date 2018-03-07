package com.facebook.browser.liteclient;

import android.content.Context;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.browser.lite.BrowserLiteIntentServiceHelper;
import com.facebook.inject.ForAppContext;
import javax.inject.Inject;

/* compiled from: maybeCreateTimelineFragment */
public class BrowserLiteClientDataManager implements IHaveUserData {
    private final Context f5519a;

    @Inject
    public BrowserLiteClientDataManager(@ForAppContext Context context) {
        this.f5519a = context;
    }

    public void clearUserData() {
        BrowserLiteIntentServiceHelper.b(this.f5519a);
    }
}
