package com.facebook.messaging.event.sending;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.xma.XMAStyleDetector;

/* compiled from: mSenderShortName */
public class EventMessageUtil {
    public static boolean m11475a(XMAModel xMAModel) {
        return XMAStyleDetector.a(xMAModel, GraphQLStoryAttachmentStyle.MESSAGE_EVENT);
    }
}
