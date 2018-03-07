package com.facebook.messaging.rtc.adminmsg.model;

import com.facebook.inject.Assisted;
import com.facebook.messaging.graphql.threads.ThreadQueriesInterfaces.XMAAttachmentStoryFields.AttachmentProperties;
import com.facebook.messaging.rtc.adminmsg.model.RTCAdminMsgProperties.Builder;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: unknown type */
public class RtcCallLogClassifierHelper {
    private final RTCAdminMsgProperties f2446a;

    @Inject
    public RtcCallLogClassifierHelper(Provider<UserKey> provider, @Assisted ImmutableList<? extends AttachmentProperties> immutableList) {
        this.f2446a = new Builder((UserKey) provider.get()).m3655a(immutableList).m3656a();
    }

    public final boolean m3664a() {
        return !this.f2446a.f2435c;
    }

    public final boolean m3665b() {
        return this.f2446a.f2436d;
    }
}
