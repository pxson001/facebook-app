package com.facebook.messaging.viewport;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.AbstractAssistedProvider;
import com.google.common.base.Function;

/* compiled from: change_nonce */
public class MessageEventMonitorProvider extends AbstractAssistedProvider<MessageEventMonitor> {
    public final <T> MessageEventMonitor<T> m18363a(Function<Object, T> function) {
        return new MessageEventMonitor(function, (AbstractFbErrorReporter) FbErrorReporterImpl.a(this));
    }
}
