package com.facebook.ui.media.cache;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/* compiled from: No future returned from request procesor ?! */
public interface PartialFileStorage$PartialFile<Key> {
    FileMetadata mo9a();

    OutputStream mo10a(long j);

    long mo11b();

    InputStream mo12b(long j);

    long mo13c();

    List<Range> mo14f();

    Key mo15g();
}
