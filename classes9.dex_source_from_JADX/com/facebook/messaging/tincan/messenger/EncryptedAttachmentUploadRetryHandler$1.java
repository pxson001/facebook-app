package com.facebook.messaging.tincan.messenger;

import com.facebook.ui.media.attachments.MediaResource;

/* compiled from: client_address */
class EncryptedAttachmentUploadRetryHandler$1 implements Runnable {
    final /* synthetic */ MediaResource f17998a;
    final /* synthetic */ EncryptedAttachmentUploadRetryHandler f17999b;

    EncryptedAttachmentUploadRetryHandler$1(EncryptedAttachmentUploadRetryHandler encryptedAttachmentUploadRetryHandler, MediaResource mediaResource) {
        this.f17999b = encryptedAttachmentUploadRetryHandler;
        this.f17998a = mediaResource;
    }

    public void run() {
        this.f17999b.a.a(this.f17998a);
    }
}
