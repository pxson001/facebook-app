package com.facebook.ui.media.cache;

import com.facebook.common.file.MoreFileUtils;
import com.facebook.common.time.Clock;
import com.facebook.ui.media.cache.PartialFileStorage.PartialFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import java.io.File;
import java.util.Collections;
import java.util.List;
import javax.inject.Provider;

/* compiled from: offline_mode_operation_retry_succeeded */
public class ChunkedPartialFileStorage implements PartialFileStorage<String> {
    public static final String f11385a = ChunkedPartialFileStorage.class.getName();
    public final Clock f11386b;
    public final ObjectMapper f11387c;
    public final MoreFileUtils f11388d;
    private final MemoizedProvider<File> f11389e;

    public final PartialFile mo2147a(Object obj, FileMetadata fileMetadata) {
        PartialFileImpl c = m16677c((String) obj);
        c.a(fileMetadata);
        return c;
    }

    public final void mo2149a(Object obj) {
        m16677c((String) obj).e();
    }

    public final PartialFile mo2150b(Object obj) {
        PartialFileImpl c = m16677c((String) obj);
        return (c.e != null ? 1 : null) != null ? c : null;
    }

    public ChunkedPartialFileStorage(Provider<File> provider, Clock clock, ObjectMapper objectMapper, MoreFileUtils moreFileUtils) {
        this.f11389e = new MemoizedProvider(provider);
        this.f11386b = clock;
        this.f11387c = objectMapper;
        this.f11388d = moreFileUtils;
    }

    public final List<String> mo2148a() {
        Object[] list = ((File) this.f11389e.get()).list();
        if (list == null) {
            return Collections.emptyList();
        }
        return ImmutableList.copyOf(list);
    }

    private PartialFileImpl m16677c(String str) {
        return new PartialFileImpl(this, str, new File((File) this.f11389e.get(), str));
    }
}
