package com.facebook.messaging.rtc.adminmsg.xma;

import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAAttachmentStoryFieldsModel;
import com.facebook.messaging.xma.SnippetCreator;
import com.facebook.messaging.xma.SnippetCreatorParams;
import com.google.common.base.Preconditions;

/* compiled from: deliveryReceipts */
public class RTCAdminMsgSnippetCreator implements SnippetCreator {
    public final String m16629a(SnippetCreatorParams snippetCreatorParams) {
        return (String) Preconditions.checkNotNull(((XMAAttachmentStoryFieldsModel) Preconditions.checkNotNull(snippetCreatorParams.b.c())).l());
    }
}
