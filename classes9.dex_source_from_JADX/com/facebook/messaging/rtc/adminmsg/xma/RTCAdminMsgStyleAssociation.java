package com.facebook.messaging.rtc.adminmsg.xma;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.inject.Lazy;
import com.facebook.messaging.xma.StyleAssociation;
import javax.inject.Inject;

/* compiled from: deleted_rows_analytics */
public class RTCAdminMsgStyleAssociation extends StyleAssociation<RTCAdminMsgRenderer, RTCAdminMsgSnippetCreator> {
    @Inject
    public RTCAdminMsgStyleAssociation(Lazy<RTCAdminMsgRenderer> lazy, Lazy<RTCAdminMsgSnippetCreator> lazy2) {
        super(GraphQLStoryAttachmentStyle.RTC_CALL_LOG, lazy, lazy2);
    }
}
