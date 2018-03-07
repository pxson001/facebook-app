package com.facebook.ui.media.cache;

import com.facebook.common.file.FileTree;
import com.facebook.common.file.FileUtils;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.google.common.primitives.Longs;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: PROGRESSIVE */
public class ChunkedPartialFileStorage$PartialFileImpl implements PartialFileStorage$PartialFile {
    public final /* synthetic */ ChunkedPartialFileStorage f410a;
    private final String f411b;
    private final File f412c;
    public final File f413d;
    public FileMetadata f414e;
    private final FilenameFilter f415f = new C00112(this);
    private final Comparator<File> f416g = new C00123(this);

    /* compiled from: PROGRESSIVE */
    class C00112 implements FilenameFilter {
        final /* synthetic */ ChunkedPartialFileStorage$PartialFileImpl f417a;

        C00112(ChunkedPartialFileStorage$PartialFileImpl chunkedPartialFileStorage$PartialFileImpl) {
            this.f417a = chunkedPartialFileStorage$PartialFileImpl;
        }

        public boolean accept(File file, String str) {
            return str.length() == 16;
        }
    }

    /* compiled from: PROGRESSIVE */
    class C00123 implements Comparator<File> {
        final /* synthetic */ ChunkedPartialFileStorage$PartialFileImpl f418a;

        C00123(ChunkedPartialFileStorage$PartialFileImpl chunkedPartialFileStorage$PartialFileImpl) {
            this.f418a = chunkedPartialFileStorage$PartialFileImpl;
        }

        public int compare(Object obj, Object obj2) {
            return Longs.a(ChunkedPartialFileStorage$PartialFileImpl.m366a(this.f418a, (File) obj), ChunkedPartialFileStorage$PartialFileImpl.m366a(this.f418a, (File) obj2));
        }
    }

    public ChunkedPartialFileStorage$PartialFileImpl(ChunkedPartialFileStorage chunkedPartialFileStorage, String str, File file) {
        this.f410a = chunkedPartialFileStorage;
        this.f411b = str;
        this.f412c = file;
        this.f413d = new File(this.f412c, "metadata.json");
        this.f414e = m367k();
        Object obj = null;
        if (!(this.f414e == null || this.f414e.a <= 0 || Strings.isNullOrEmpty(this.f414e.b))) {
            obj = 1;
        }
        if (obj == null) {
            m376e();
        }
    }

    public final Object mo15g() {
        return this.f411b;
    }

    public final FileMetadata mo9a() {
        return this.f414e;
    }

    private FileMetadata m367k() {
        if (!this.f413d.exists()) {
            return null;
        }
        try {
            JsonNode a = this.f410a.c.a(this.f413d);
            JsonNode b = a.b("version");
            JsonNode b2 = a.b("length");
            JsonNode b3 = a.b("mimeType");
            if (b == null || b2 == null || b3 == null) {
                BLog.a(ChunkedPartialFileStorage.a, "Metadata is not complete. Ignoring. (%s)", new Object[]{a});
                return null;
            }
            if (b.b(-1) == 2) {
                return new FileMetadata(b2.D(), b3.B());
            }
            BLog.a(ChunkedPartialFileStorage.a, "Retrieved metadata version %d, ignoring (%d required).", new Object[]{Integer.valueOf(b.b(-1)), Integer.valueOf(2)});
            return null;
        } catch (Throwable e) {
            BLog.a(ChunkedPartialFileStorage.a, "Error reading partial file metadata", e);
            return null;
        }
    }

    public final long mo11b() {
        return this.f410a.d.d(this.f412c);
    }

    public final long mo13c() {
        return this.f413d.lastModified();
    }

    public final OutputStream mo10a(long j) {
        m368m();
        File file = new File(this.f412c, StringFormatUtil.formatStrLocaleSafe("%1$016x", Long.valueOf(j)));
        return new 1(this, new FileOutputStream(file), file);
    }

    public final InputStream mo12b(long j) {
        m368m();
        return new ChunkedInputStream(this, j);
    }

    public final void m372a(FileMetadata fileMetadata) {
        m376e();
        FileUtils.a(this.f412c);
        this.f414e = fileMetadata;
        ObjectNode e = this.f410a.c.e();
        this.f410a.c.d();
        e.a("version", IntNode.c(2));
        e.a("length", LongNode.b(this.f414e.a));
        e.a("mimeType", TextNode.h(this.f414e.b));
        this.f410a.c.a(this.f413d, e);
        m368m();
    }

    public final void m376e() {
        FileTree.b(this.f412c);
        this.f414e = null;
    }

    private void m368m() {
        this.f413d.setLastModified(this.f410a.b.a());
    }

    public static long m366a(ChunkedPartialFileStorage$PartialFileImpl chunkedPartialFileStorage$PartialFileImpl, File file) {
        return Long.parseLong(file.getName(), 16);
    }

    public static Map m369n(ChunkedPartialFileStorage$PartialFileImpl chunkedPartialFileStorage$PartialFileImpl) {
        File[] listFiles = chunkedPartialFileStorage$PartialFileImpl.f412c.listFiles(chunkedPartialFileStorage$PartialFileImpl.f415f);
        if (listFiles == null) {
            return Collections.emptyMap();
        }
        Arrays.sort(listFiles, chunkedPartialFileStorage$PartialFileImpl.f416g);
        LinkedHashMap d = Maps.d();
        int length = listFiles.length;
        int i = 0;
        long j = 0;
        while (i < length) {
            File file = listFiles[i];
            long length2 = file.length();
            if (length2 > 0) {
                long a = m366a(chunkedPartialFileStorage$PartialFileImpl, file);
                length2 += a;
                d.put(new Range(a, length2), file);
                if (j > a) {
                    Long.valueOf(j);
                    Long.valueOf(a);
                }
            } else {
                length2 = j;
            }
            i++;
            j = length2;
        }
        return d;
    }

    public final List<Range> mo14f() {
        return new Range(0, this.f414e.a).m389b(m369n(this).keySet());
    }
}
