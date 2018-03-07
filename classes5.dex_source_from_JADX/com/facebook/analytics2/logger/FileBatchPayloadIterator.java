package com.facebook.analytics2.logger;

import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.analytics2.logger.BatchDirectoryStructureIterator.DayDirNode;
import com.facebook.analytics2.logger.BatchDirectoryStructureIterator.DirectoryNode;
import com.facebook.analytics2.logger.BatchDirectoryStructureIterator.FileNode;
import com.facebook.analytics2.logger.BatchDirectoryStructureIterator.HourDirNode;
import com.facebook.analytics2.logger.BatchDirectoryStructureIterator.PriorityDirNode;
import com.facebook.analytics2.logger.BatchDirectoryStructureIterator.ProcessDirNode;
import com.facebook.analytics2.logger.BatchDirectoryStructureIterator.TimestampDirectoryNode;
import com.facebook.analytics2.logger.BatchDirectoryStructureIterator.TraversalEvent;
import com.facebook.analytics2.logger.BatchLockState.BatchLock;
import com.facebook.analytics2.logger.UploadJobHandler.C01341;
import com.facebook.crudolib.processname.ProcessNameHelper;
import com.facebook.debug.log.BLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: third_party_app_via_fb_api */
public class FileBatchPayloadIterator implements Iterator<BatchPayloadInternal> {
    private final BatchDynamicMetadataHelper f1996a;
    private final BatchDirectoryStructureIterator f1997b;
    private final C01341 f1998c;
    private final int f1999d;
    private final long f2000e = (BatchDirectoryStructure.a() - 7);
    private final long f2001f = (BatchDirectoryStructure.b() - 168);
    private BatchLockState<Object> f2002g;
    private boolean f2003h;
    @Nullable
    private BatchPayloadInternal f2004i;
    @Nullable
    private File f2005j;
    private int f2006k;

    /* compiled from: third_party_app_via_fb_api */
    class CleanupBatchPayloadWrapper implements BatchPayloadInternal {
        private final BatchPayloadInternal f1983a;
        private final EmptyDirectoryCleaner f1984b;

        public CleanupBatchPayloadWrapper(BatchPayloadInternal batchPayloadInternal, EmptyDirectoryCleaner emptyDirectoryCleaner) {
            this.f1983a = batchPayloadInternal;
            this.f1984b = emptyDirectoryCleaner;
        }

        public final void mo491c() {
            this.f1983a.mo491c();
        }

        public final boolean mo492d() {
            return this.f1983a.mo492d();
        }

        public final void mo493e() {
            this.f1983a.mo493e();
            EmptyDirectoryCleaner emptyDirectoryCleaner = this.f1984b;
            String valueOf = String.valueOf(BatchDirectoryStructure.a());
            String valueOf2 = String.valueOf(BatchDirectoryStructure.b());
            int size = emptyDirectoryCleaner.f1985a.size();
            for (int i = 0; i < size; i++) {
                DirectoryNode directoryNode = (DirectoryNode) emptyDirectoryCleaner.f1985a.get(i);
                if (directoryNode instanceof HourDirNode) {
                    FileBatchPayloadIterator.m2700b(directoryNode.f1953a, valueOf2);
                } else if (directoryNode instanceof DayDirNode) {
                    FileBatchPayloadIterator.m2700b(directoryNode.f1953a, valueOf);
                } else {
                    FileBatchPayloadIterator.m2699b(directoryNode.f1953a);
                }
            }
            emptyDirectoryCleaner.f1985a.clear();
        }

        public final void mo489a(Writer writer) {
            this.f1983a.mo489a(writer);
        }

        public final int mo488a() {
            return this.f1983a.mo488a();
        }

        public final boolean mo490b() {
            return this.f1983a.mo490b();
        }
    }

    /* compiled from: third_party_app_via_fb_api */
    public class EmptyDirectoryCleaner {
        public final ArrayList<DirectoryNode> f1985a = new ArrayList(2);

        public final void m2669a(DirectoryNode directoryNode) {
            this.f1985a.add(directoryNode);
        }
    }

    /* compiled from: third_party_app_via_fb_api */
    public class FileBatchPayload extends SimpleBatchPayload {
        private final File f1991f;
        private final BatchLockState<Object> f1992g;

        public FileBatchPayload(BatchDynamicMetadataHelper batchDynamicMetadataHelper, File file, BatchLockState<Object> batchLockState) {
            super(batchDynamicMetadataHelper, file);
            this.f1991f = file;
            this.f1992g = batchLockState;
        }

        public final File mo495f() {
            return this.f1991f;
        }

        protected final BatchLock mo496g() {
            return this.f1992g.a(this.f1991f);
        }

        protected final void mo494b(Writer writer) {
            PoolFriendlyInputStreamReader poolFriendlyInputStreamReader = new PoolFriendlyInputStreamReader(new FileInputStream(this.f1991f), ByteBuffer.wrap((byte[]) SimpleBatchPayload.f1986c.get()));
            try {
                char[] cArr = (char[]) SimpleBatchPayload.f1987d.get();
                while (true) {
                    int read = poolFriendlyInputStreamReader.read(cArr);
                    if (read == -1) {
                        break;
                    }
                    writer.write(cArr, 0, read);
                }
            } finally {
                poolFriendlyInputStreamReader.close();
            }
        }

        final int mo497h() {
            return Math.round((float) this.f1991f.length());
        }

        protected final void mo498i() {
            if (!this.f1991f.delete()) {
                BLog.a("FileBatchPayloadIterator", "Failed to remove %s", new Object[]{this.f1991f});
            }
        }

        public final void mo499j() {
        }
    }

    /* compiled from: third_party_app_via_fb_api */
    public class MultiBatchPayload implements BatchPayloadInternal {
        public final List<FileBatchPayload> f1993a;
        public final BatchDynamicMetadataHelper f1994b;
        public volatile boolean f1995c;

        public MultiBatchPayload(List<FileBatchPayload> list, BatchDynamicMetadataHelper batchDynamicMetadataHelper) {
            if (list.isEmpty()) {
                throw new IllegalArgumentException("payloads cannot be empty");
            }
            this.f1993a = list;
            this.f1994b = batchDynamicMetadataHelper;
        }

        public final void mo491c() {
            int size = this.f1993a.size();
            for (int i = 0; i < size; i++) {
                ((FileBatchPayload) this.f1993a.get(i)).mo491c();
            }
            this.f1995c = false;
        }

        public final boolean mo492d() {
            return this.f1995c;
        }

        public final void mo489a(Writer writer) {
            int size;
            if (!mo492d()) {
                size = this.f1993a.size();
                for (int i = 0; i < size; i++) {
                    ((FileBatchPayload) this.f1993a.get(i)).m2683k();
                }
                this.f1995c = true;
            }
            MultiBatchWriterStructure multiBatchWriterStructure = new MultiBatchWriterStructure(writer);
            multiBatchWriterStructure.m2736a();
            size = this.f1993a.size();
            for (int i2 = 0; i2 < size; i2++) {
                multiBatchWriterStructure.m2738a((SimpleBatchPayload) this.f1993a.get(i2));
            }
            multiBatchWriterStructure.m2737a(this.f1994b);
        }

        public final void mo493e() {
            int size = this.f1993a.size();
            for (int i = 0; i < size; i++) {
                ((FileBatchPayload) this.f1993a.get(i)).mo493e();
            }
        }

        public final int mo488a() {
            int i = 0;
            for (int i2 = 0; i2 < this.f1993a.size(); i2++) {
                i += ((FileBatchPayload) this.f1993a.get(i2)).mo497h();
            }
            return 256 + i;
        }

        public final boolean mo490b() {
            return true;
        }
    }

    public FileBatchPayloadIterator(File file, BatchDynamicMetadataHelper batchDynamicMetadataHelper, C01341 c01341, int i) {
        this.f1997b = new BatchDirectoryStructureIterator(new PriorityDirNode(file));
        this.f1996a = batchDynamicMetadataHelper;
        this.f1998c = c01341;
        this.f1999d = i;
    }

    public boolean hasNext() {
        if (!this.f2003h) {
            this.f2003h = true;
            this.f2004i = m2701c();
        }
        if (this.f2004i != null) {
            return true;
        }
        return false;
    }

    public Object next() {
        if (hasNext()) {
            BatchPayloadInternal batchPayloadInternal = this.f2004i;
            this.f2003h = false;
            this.f2004i = null;
            return batchPayloadInternal;
        }
        throw new IllegalStateException();
    }

    public final int m2702a() {
        return this.f2006k;
    }

    public void remove() {
        throw new UnsupportedOperationException("File removal should be accomplished via markSuccessful");
    }

    @Nullable
    private BatchPayloadInternal m2701c() {
        EmptyDirectoryCleaner emptyDirectoryCleaner = new EmptyDirectoryCleaner();
        Object arrayList = new ArrayList(4);
        FileNode fileNode = null;
        int i = 0;
        while (true) {
            if ((i == 0 || i < this.f1999d) && this.f1997b.hasNext()) {
                TraversalEvent a = this.f1997b.m2635a();
                FileNode fileNode2 = a.f1962a;
                switch (a.f1963b) {
                    case 1:
                        if (!(fileNode2 instanceof ProcessDirNode)) {
                            if (!(fileNode2 instanceof TimestampDirectoryNode)) {
                                break;
                            }
                            fileNode2 = (TimestampDirectoryNode) fileNode2;
                            if (!m2696a(fileNode2)) {
                                fileNode2 = fileNode;
                            }
                            fileNode = fileNode2;
                            break;
                        }
                        this.f2002g = BatchLockState.a(!fileNode2.f1953a.getName().equals(ProcessNameHelper.a()));
                        break;
                    case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                        if (fileNode != null) {
                            m2699b(fileNode2.m2623b());
                            if (fileNode.m2623b().equals(fileNode2.m2623b())) {
                                fileNode = null;
                            }
                        } else {
                            emptyDirectoryCleaner.m2669a((DirectoryNode) fileNode2);
                        }
                        if (!(fileNode2 instanceof ProcessDirNode)) {
                            break;
                        }
                        this.f1998c.m2743a(fileNode2.m2623b(), this.f2005j);
                        this.f2005j = null;
                        break;
                    case 3:
                        if (fileNode == null) {
                            FileBatchPayload fileBatchPayload = new FileBatchPayload(this.f1996a, fileNode2.m2623b(), this.f2002g);
                            arrayList.add(fileBatchPayload);
                            int length = (int) (((long) i) + fileBatchPayload.mo495f().length());
                            this.f2005j = fileNode2.m2623b();
                            i = length;
                            break;
                        }
                        fileNode2.m2623b();
                        m2698a(fileNode2.m2623b(), this.f2002g);
                        break;
                    default:
                        throw new IllegalArgumentException("eventType=" + a.f1963b);
                }
            }
            int size = arrayList.size();
            if (size <= 0) {
                return null;
            }
            BatchPayloadInternal multiBatchPayload;
            this.f2006k += size;
            if (size > 1) {
                Integer.valueOf(arrayList.size());
                Integer.valueOf(i);
                multiBatchPayload = new MultiBatchPayload(arrayList, this.f1996a);
            } else {
                multiBatchPayload = (BatchPayloadInternal) arrayList.get(0);
            }
            return new CleanupBatchPayloadWrapper(multiBatchPayload, emptyDirectoryCleaner);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m2698a(java.io.File r3, com.facebook.analytics2.logger.BatchLockState<java.lang.Object> r4) {
        /*
        r2 = this;
        r1 = r4.a(r3);
        r0 = r1.d(r2);	 Catch:{ all -> 0x0028 }
        if (r0 == 0) goto L_0x001e;
    L_0x000a:
        r0 = r3.delete();	 Catch:{ all -> 0x0023 }
        if (r0 == 0) goto L_0x001b;
    L_0x0010:
        r1.a(r2);	 Catch:{ all -> 0x0023 }
        r1.f(r2);	 Catch:{  }
        r1.a();
        r0 = 1;
    L_0x001a:
        return r0;
    L_0x001b:
        r1.f(r2);	 Catch:{  }
    L_0x001e:
        r1.a();
        r0 = 0;
        goto L_0x001a;
    L_0x0023:
        r0 = move-exception;
        r1.f(r2);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0028:
        r0 = move-exception;
        r1.a();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics2.logger.FileBatchPayloadIterator.a(java.io.File, com.facebook.analytics2.logger.BatchLockState):boolean");
    }

    public static void m2700b(File file, String str) {
        if (!file.getName().equals(str)) {
            m2699b(file);
        }
    }

    public static void m2699b(File file) {
        if (!file.isDirectory()) {
            BLog.a("FileBatchPayloadIterator", "%s: not a directory, deleting anyway...", new Object[]{file});
        }
        file.delete();
    }

    private boolean m2696a(TimestampDirectoryNode timestampDirectoryNode) {
        if (timestampDirectoryNode instanceof DayDirNode) {
            return m2697a(timestampDirectoryNode, this.f2000e);
        }
        if (timestampDirectoryNode instanceof HourDirNode) {
            return m2697a(timestampDirectoryNode, this.f2001f);
        }
        throw new IllegalArgumentException("directoryNode=" + timestampDirectoryNode);
    }

    private static boolean m2697a(TimestampDirectoryNode timestampDirectoryNode, long j) {
        long a = timestampDirectoryNode.m2626a(-1);
        if (a >= 0 && a >= j) {
            return false;
        }
        return true;
    }
}
