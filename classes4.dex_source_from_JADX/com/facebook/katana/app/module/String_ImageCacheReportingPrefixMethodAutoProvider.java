package com.facebook.katana.app.module;

import com.facebook.common.process.ProcessNameMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: environment_notification_stories */
public class String_ImageCacheReportingPrefixMethodAutoProvider extends AbstractProvider<String> {
    public Object get() {
        return MainProcessModule.a(ProcessNameMethodAutoProvider.b(this));
    }
}
