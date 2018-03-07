package com.facebook.video.server;

import com.facebook.ui.media.cache.FileMetadata;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: configuration */
public interface AsyncWriter$Handler {
    OutputStream mo1418a(FileMetadata fileMetadata);

    void mo1419a(IOException iOException);

    void mo1420a(OutputStream outputStream, IOException iOException);
}
