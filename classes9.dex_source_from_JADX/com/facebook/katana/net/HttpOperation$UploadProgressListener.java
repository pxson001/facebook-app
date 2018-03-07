package com.facebook.katana.net;

import com.facebook.http.entity.mime.content.ChunkedContentSerializationListener;

/* compiled from: p2p_payment */
class HttpOperation$UploadProgressListener extends ChunkedContentSerializationListener {
    final /* synthetic */ HttpOperation f7567a;

    public HttpOperation$UploadProgressListener(HttpOperation httpOperation, long j) {
        this.f7567a = httpOperation;
        super(j, 5);
    }
}
