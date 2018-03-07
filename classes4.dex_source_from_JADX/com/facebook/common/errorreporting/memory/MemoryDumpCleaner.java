package com.facebook.common.errorreporting.memory;

import com.facebook.common.fileupload.FileUploadUtils;
import javax.inject.Inject;

/* compiled from: memory_info */
public class MemoryDumpCleaner {
    private static final Class<?> f8143a = MemoryDumpCleaner.class;
    public final FileUploadUtils f8144b;

    @Inject
    public MemoryDumpCleaner(FileUploadUtils fileUploadUtils) {
        this.f8144b = fileUploadUtils;
    }
}
