package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.DefaultDiskStorage.IncompleteFileException;
import com.facebook.common.file.FileUtils;
import com.facebook.common.file.FileUtils.ParentDirNotFoundException;
import com.facebook.common.file.FileUtils.RenameException;
import com.facebook.common.internal.CountingOutputStream;
import com.facebook.common.internal.VisibleForTesting;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

@VisibleForTesting
/* compiled from: seekTo */
class DefaultDiskStorage$InserterImpl implements DiskStorage$Inserter {
    @VisibleForTesting
    final File f2927a;
    final /* synthetic */ DefaultDiskStorage f2928b;
    private final String f2929c;

    public DefaultDiskStorage$InserterImpl(DefaultDiskStorage defaultDiskStorage, String str, File file) {
        this.f2928b = defaultDiskStorage;
        this.f2929c = str;
        this.f2927a = file;
    }

    public final void mo264a(WriterCallback writerCallback, Object obj) {
        try {
            OutputStream fileOutputStream = new FileOutputStream(this.f2927a);
            try {
                OutputStream countingOutputStream = new CountingOutputStream(fileOutputStream);
                writerCallback.mo259a(countingOutputStream);
                countingOutputStream.flush();
                long a = countingOutputStream.m3175a();
                if (this.f2927a.length() != a) {
                    throw new IncompleteFileException(a, this.f2927a.length());
                }
            } finally {
                fileOutputStream.close();
            }
        } catch (Throwable e) {
            this.f2928b.e.a(CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.b, "updateResource", e);
            throw e;
        }
    }

    public final BinaryResource mo263a(Object obj) {
        CacheErrorCategory cacheErrorCategory;
        File a = this.f2928b.a(this.f2929c);
        try {
            FileUtils.a(this.f2927a, a);
            if (a.exists()) {
                a.setLastModified(this.f2928b.f.a());
            }
            return FileBinaryResource.a(a);
        } catch (RenameException e) {
            RenameException renameException = e;
            Throwable cause = renameException.getCause();
            if (cause != null) {
                if (cause instanceof ParentDirNotFoundException) {
                    cacheErrorCategory = CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND;
                } else if (cause instanceof FileNotFoundException) {
                    cacheErrorCategory = CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND;
                }
                this.f2928b.e.a(cacheErrorCategory, DefaultDiskStorage.b, "commit", renameException);
                throw renameException;
            }
            cacheErrorCategory = CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
            this.f2928b.e.a(cacheErrorCategory, DefaultDiskStorage.b, "commit", renameException);
            throw renameException;
        }
    }

    public final boolean mo265a() {
        return !this.f2927a.exists() || this.f2927a.delete();
    }
}
