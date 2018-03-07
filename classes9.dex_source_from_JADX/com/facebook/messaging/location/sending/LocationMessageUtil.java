package com.facebook.messaging.location.sending;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.xma.XMAStyleDetector;

/* compiled from: mParameters */
public class LocationMessageUtil {
    public static boolean m11973a(XMAModel xMAModel) {
        return XMAStyleDetector.a(xMAModel, GraphQLStoryAttachmentStyle.MESSAGE_LOCATION);
    }
}
