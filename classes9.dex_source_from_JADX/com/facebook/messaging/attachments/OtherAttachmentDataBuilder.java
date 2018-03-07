package com.facebook.messaging.attachments;

import com.facebook.ui.media.attachments.MediaResource;

/* compiled from: p2p_cancel_csc */
public class OtherAttachmentDataBuilder {
    public String f7758a;
    public String f7759b;
    public MediaResource f7760c;
    public String f7761d;
    public String f7762e;
    public Integer f7763f;

    OtherAttachmentDataBuilder() {
    }

    public final OtherAttachmentDataBuilder m8030a(int i) {
        this.f7763f = Integer.valueOf(i);
        return this;
    }

    public final OtherAttachmentData m8031g() {
        return new OtherAttachmentData(this);
    }
}
