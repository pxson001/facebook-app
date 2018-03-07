package com.facebook.messaging.rtc.adminmsg.model;

import com.facebook.messaging.graphql.threads.ThreadQueriesInterfaces.XMAAttachmentStoryFields.AttachmentProperties;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAAttachmentStoryFieldsModel.AttachmentPropertiesModel;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: unlock */
public final class RTCAdminMsgProperties {
    public final long f2433a;
    public final long f2434b;
    public final boolean f2435c;
    public final boolean f2436d;
    public final String f2437e;
    public final String f2438f;

    /* compiled from: unlock */
    public final class Builder {
        public UserKey f2426a;
        @Nullable
        public Long f2427b;
        @Nullable
        public Long f2428c;
        @Nullable
        public Boolean f2429d;
        @Nullable
        public Boolean f2430e;
        @Nullable
        public String f2431f;
        @Nullable
        public String f2432g;

        public Builder(UserKey userKey) {
            this.f2426a = userKey;
        }

        public final RTCAdminMsgProperties m3656a() {
            return new RTCAdminMsgProperties(this);
        }

        public final Builder m3655a(ImmutableList<? extends AttachmentProperties> immutableList) {
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                AttachmentPropertiesModel attachmentPropertiesModel = (AttachmentPropertiesModel) immutableList.get(i);
                if (attachmentPropertiesModel.m2540b().equals("answered")) {
                    this.f2429d = Boolean.valueOf(Boolean.parseBoolean(attachmentPropertiesModel.m2542d().m2534a()));
                } else if (attachmentPropertiesModel.m2540b().equals("timestamp")) {
                    this.f2427b = Long.valueOf(Long.parseLong(attachmentPropertiesModel.m2542d().m2534a()));
                } else if (attachmentPropertiesModel.m2540b().equals("duration")) {
                    this.f2428c = Long.valueOf(Long.parseLong(attachmentPropertiesModel.m2542d().m2534a()));
                } else if (attachmentPropertiesModel.m2540b().equals("senderID")) {
                    String a = attachmentPropertiesModel.m2542d().m2534a();
                    this.f2431f = a;
                    if (a != null) {
                        this.f2430e = Boolean.valueOf(!a.equals(this.f2426a.b()));
                    }
                } else if (attachmentPropertiesModel.m2540b().equals("peerUserID")) {
                    this.f2432g = attachmentPropertiesModel.m2542d().m2534a();
                }
            }
            return this;
        }
    }

    public RTCAdminMsgProperties(Builder builder) {
        if (builder.f2427b != null) {
            this.f2433a = builder.f2427b.longValue();
        } else {
            this.f2433a = 0;
        }
        if (builder.f2428c != null) {
            this.f2434b = builder.f2428c.longValue();
        } else {
            this.f2434b = 0;
        }
        this.f2435c = Boolean.TRUE.equals(builder.f2429d);
        this.f2436d = Boolean.TRUE.equals(builder.f2430e);
        if (builder.f2431f != null) {
            this.f2437e = builder.f2431f;
        } else {
            this.f2437e = "";
        }
        if (builder.f2432g != null) {
            this.f2438f = builder.f2432g;
        } else {
            this.f2438f = "";
        }
    }
}
