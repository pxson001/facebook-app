package com.facebook.orca.threadview;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.messaging.database.serialization.DbMessageClientTagsSerialization;
import com.facebook.messaging.database.serialization.MessageDebugDataSerializationHelper;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.xconfig.core.XConfigReader;

/* compiled from: messenger_invalid_attachment_composition_dialog */
public class MessageSendFailedDataFileProviderProvider extends AbstractAssistedProvider<MessageSendFailedDataFileProvider> {
    public final MessageSendFailedDataFileProvider m6913a(Message message) {
        return new MessageSendFailedDataFileProvider(message, (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), new MessageDebugDataSerializationHelper(MessageUtil.a(this), IdBasedProvider.a(this, 4443), DbMessageClientTagsSerialization.b(this)), XConfigReader.a(this));
    }
}
