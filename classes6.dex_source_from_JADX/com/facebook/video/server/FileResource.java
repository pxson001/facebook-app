package com.facebook.video.server;

import com.facebook.ui.media.cache.FileMetadata;
import java.io.InputStream;

/* compiled from: commerce_news_feed */
public interface FileResource {

    /* compiled from: commerce_news_feed */
    public class SimpleReader {
        public final FileMetadata f19472a;
        private final InputStream f19473b;

        public SimpleReader(FileMetadata fileMetadata, InputStream inputStream) {
            this.f19472a = fileMetadata;
            this.f19473b = inputStream;
        }

        public final InputStream m28229b() {
            return this.f19473b;
        }
    }
}
