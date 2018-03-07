package com.facebook.video.server;

import com.facebook.ui.media.cache.FileMetadata;
import com.facebook.ui.media.cache.Range;
import java.io.OutputStream;

/* compiled from: page_checkin */
public interface RangeWriter {
    long mo525a(Range range, OutputStream outputStream);

    FileMetadata mo526a();
}
