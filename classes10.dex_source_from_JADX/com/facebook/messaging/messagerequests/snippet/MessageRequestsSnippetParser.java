package com.facebook.messaging.messagerequests.snippet;

import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: saved_calling_package_name */
public class MessageRequestsSnippetParser {
    public final Lazy<FbErrorReporter> f3270a;

    @Inject
    public MessageRequestsSnippetParser(Lazy<FbErrorReporter> lazy) {
        this.f3270a = lazy;
    }
}
