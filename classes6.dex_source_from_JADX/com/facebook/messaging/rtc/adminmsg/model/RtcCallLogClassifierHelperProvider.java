package com.facebook.messaging.rtc.adminmsg.model;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.messaging.graphql.threads.ThreadQueriesInterfaces.XMAAttachmentStoryFields.AttachmentProperties;
import com.google.common.collect.ImmutableList;

/* compiled from: unknown message in LocationHandler.handleMessage */
public class RtcCallLogClassifierHelperProvider extends AbstractAssistedProvider<RtcCallLogClassifierHelper> {
    public final RtcCallLogClassifierHelper m3666a(ImmutableList<? extends AttachmentProperties> immutableList) {
        return new RtcCallLogClassifierHelper(IdBasedProvider.a(this, 3597), immutableList);
    }
}
