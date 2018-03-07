package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory;
import com.facebook.cache.disk.DiskStorage.Inserter;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.FileUtils;
import com.facebook.common.file.FileUtils.CreateDirectoryException;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/* compiled from: measurement.upload.max_queue_time */
public class DefaultDiskStorage implements DiskStorage {
    public static final long f14693a = TimeUnit.MINUTES.toMillis(30);
    public static final Class<?> f14694b = DefaultDiskStorage.class;
    public final File f14695c;
    public final File f14696d;
    public final CacheErrorLogger f14697e;
    public final Clock f14698f = SystemClock.f762a;

    /* compiled from: measurement.upload.max_queue_time */
    public class FileInfo {
        public final FileType f14699a;
        public final String f14700b;

        public FileInfo(FileType fileType, String str) {
            this.f14699a = fileType;
            this.f14700b = str;
        }

        public String toString() {
            return this.f14699a + "(" + this.f14700b + ")";
        }

        public final File m21123a(File file) {
            return File.createTempFile(this.f14700b + ".", ".tmp", file);
        }
    }

    /* compiled from: measurement.upload.max_queue_time */
    public enum FileType {
        CONTENT(".cnt"),
        TEMP(".tmp");
        
        public final String extension;

        private FileType(String str) {
            this.extension = str;
        }

        public static FileType fromExtension(String str) {
            if (".cnt".equals(str)) {
                return CONTENT;
            }
            if (".tmp".equals(str)) {
                return TEMP;
            }
            return null;
        }
    }

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        Preconditions.a(file);
        this.f14695c = file;
        this.f14696d = new File(this.f14695c, String.format(null, "%s.ols%d.%d", new Object[]{"v2", Integer.valueOf(100), Integer.valueOf(i)}));
        this.f14697e = cacheErrorLogger;
        m21113e();
    }

    private void m21113e() {
        Object obj = 1;
        if (this.f14695c.exists()) {
            if (this.f14696d.exists()) {
                obj = null;
            } else {
                FileTree.b(this.f14695c);
            }
        }
        if (obj != null) {
            try {
                FileUtils.a(this.f14696d);
            } catch (CreateDirectoryException e) {
                this.f14697e.mo2056a(CacheErrorCategory.WRITE_CREATE_DIR, f14694b, "version directory could not be created: " + this.f14696d, null);
            }
        }
    }

    @VisibleForTesting
    final File m21116a(String str) {
        return new File(m21112d(str));
    }

    private String m21110b(String str) {
        return this.f14696d + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File m21111c(String str) {
        return new File(m21110b(str));
    }

    public final void mo2079a() {
        FileTree.a(this.f14695c, new PurgingVisitor(this));
    }

    private void m21107a(File file, String str) {
        try {
            FileUtils.a(file);
        } catch (CreateDirectoryException e) {
            this.f14697e.mo2056a(CacheErrorCategory.WRITE_CREATE_DIR, f14694b, str, e);
            throw e;
        }
    }

    public final Inserter mo2078a(String str, Object obj) {
        FileInfo fileInfo = new FileInfo(FileType.TEMP, str);
        File c = m21111c(fileInfo.f14700b);
        if (!c.exists()) {
            m21107a(c, "insert");
        }
        try {
            return new InserterImpl(this, str, fileInfo.m21123a(c));
        } catch (Throwable e) {
            this.f14697e.mo2056a(CacheErrorCategory.WRITE_CREATE_TEMPFILE, f14694b, "insert", e);
            throw e;
        }
    }

    public final BinaryResource mo2080b(String str, Object obj) {
        File a = m21116a(str);
        if (!a.exists()) {
            return null;
        }
        a.setLastModified(this.f14698f.mo211a());
        return FileBinaryResource.m25094a(a);
    }

    private String m21112d(String str) {
        FileInfo fileInfo = new FileInfo(FileType.CONTENT, str);
        return m21110b(fileInfo.f14700b) + File.separator + fileInfo.f14700b + fileInfo.f14699a.extension;
    }

    public final boolean mo2083c(String str, Object obj) {
        return m21108a(str, false);
    }

    public final boolean mo2084d(String str, Object obj) {
        return m21108a(str, true);
    }

    private boolean m21108a(String str, boolean z) {
        File a = m21116a(str);
        boolean exists = a.exists();
        if (z && exists) {
            a.setLastModified(this.f14698f.mo211a());
        }
        return exists;
    }

    public final long mo2077a(EntryImpl entryImpl) {
        long length;
        File file = entryImpl.b.f17878a;
        if (file.exists()) {
            length = file.length();
            if (!file.delete()) {
                length = -1;
            }
        } else {
            length = 0;
        }
        return length;
    }

    public final void mo2081b() {
        FileTree.a(this.f14695c);
    }

    public final Collection mo2082c() {
        EntriesCollector entriesCollector = new EntriesCollector(this);
        FileTree.a(this.f14696d, entriesCollector);
        return Collections.unmodifiableList(entriesCollector.b);
    }

    public static FileInfo m21109b(DefaultDiskStorage defaultDiskStorage, File file) {
        FileInfo fileInfo;
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf <= 0) {
            fileInfo = null;
        } else {
            FileType fromExtension = FileType.fromExtension(name.substring(lastIndexOf));
            if (fromExtension == null) {
                fileInfo = null;
            } else {
                name = name.substring(0, lastIndexOf);
                if (fromExtension.equals(FileType.TEMP)) {
                    lastIndexOf = name.lastIndexOf(46);
                    if (lastIndexOf <= 0) {
                        fileInfo = null;
                    } else {
                        name = name.substring(0, lastIndexOf);
                    }
                }
                fileInfo = new FileInfo(fromExtension, name);
            }
        }
        FileInfo fileInfo2 = fileInfo;
        if (fileInfo2 != null && defaultDiskStorage.m21111c(fileInfo2.f14700b).equals(file.getParentFile())) {
            return fileInfo2;
        }
        return null;
    }
}
