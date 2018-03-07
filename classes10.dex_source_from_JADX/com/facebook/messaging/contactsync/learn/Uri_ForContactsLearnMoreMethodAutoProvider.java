package com.facebook.messaging.contactsync.learn;

import android.net.Uri;
import com.facebook.common.locale.Locales;
import com.facebook.config.application.FbAppType;
import com.facebook.inject.AbstractProvider;

/* compiled from: tab_tapped */
public class Uri_ForContactsLearnMoreMethodAutoProvider extends AbstractProvider<Uri> {
    public Object get() {
        return ContactSyncLearnMoreModule.m1894a(Locales.a(this), (FbAppType) getInstance(FbAppType.class));
    }
}
