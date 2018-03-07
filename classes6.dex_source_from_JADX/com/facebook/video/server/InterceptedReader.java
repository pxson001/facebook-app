package com.facebook.video.server;

import com.facebook.ui.media.cache.Range;
import com.facebook.video.server.FileResource.SimpleReader;

/* compiled from: commerce_message_type */
public class InterceptedReader {
    public final Range f19474a;
    public final SimpleReader f19475b;

    public InterceptedReader(Range range, SimpleReader simpleReader) {
        this.f19474a = range;
        this.f19475b = simpleReader;
    }
}
