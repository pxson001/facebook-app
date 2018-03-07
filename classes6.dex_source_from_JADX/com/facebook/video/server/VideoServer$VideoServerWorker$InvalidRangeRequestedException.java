package com.facebook.video.server;

import java.io.IOException;

/* compiled from: comment_edit */
class VideoServer$VideoServerWorker$InvalidRangeRequestedException extends IOException {
    public VideoServer$VideoServerWorker$InvalidRangeRequestedException(String str, long j) {
        super("Invalid range: " + str + " - Resource length: " + j);
    }

    public VideoServer$VideoServerWorker$InvalidRangeRequestedException(String str) {
        super("Invalid range: " + str);
    }
}
