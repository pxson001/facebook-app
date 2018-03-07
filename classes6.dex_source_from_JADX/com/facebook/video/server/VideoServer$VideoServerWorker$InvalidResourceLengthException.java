package com.facebook.video.server;

import java.io.IOException;

/* compiled from: comment_edit */
class VideoServer$VideoServerWorker$InvalidResourceLengthException extends IOException {
    public VideoServer$VideoServerWorker$InvalidResourceLengthException(long j) {
        super("Invalid resource length: " + j);
    }
}
