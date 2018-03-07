package com.facebook.analytics2.logger;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: thread_state */
public final class BatchDirectoryStructureIterator implements Iterator<TraversalEvent> {
    public static final FileFilter f1967d = new C01301();
    public final ArrayDeque<TraversalNode> f1968a = new ArrayDeque();
    private boolean f1969b;
    @Nullable
    private TraversalEvent f1970c;

    /* compiled from: thread_state */
    final class C01301 implements FileFilter {
        C01301() {
        }

        public final boolean accept(File file) {
            return file.isDirectory();
        }
    }

    /* compiled from: thread_state */
    public abstract class FileNode {
        private static final Iterator<FileNode> f1952b = new ArrayList(0).iterator();
        public final File f1953a;

        public FileNode(File file) {
            this.f1953a = file;
        }

        public final File m2623b() {
            return this.f1953a;
        }

        Iterator<FileNode> mo486a() {
            return f1952b;
        }
    }

    /* compiled from: thread_state */
    public final class BatchFileNode extends FileNode {
        public BatchFileNode(File file) {
            super(file);
        }
    }

    /* compiled from: thread_state */
    public abstract class DirectoryNode extends FileNode {
        @Nullable
        public FileFilter f1954b = BatchDirectoryStructureIterator.f1967d;
        @Nullable
        public Comparator<File> f1955c = BatchDirectoryStructure.c;

        protected abstract FileNode mo487a(File file);

        public DirectoryNode(File file) {
            super(file);
        }

        final Iterator<FileNode> mo486a() {
            final Iterator it = new SnapshotDirectoryIterable(this.f1953a, this.f1954b, this.f1955c).iterator();
            return new Iterator<FileNode>(this) {
                final /* synthetic */ DirectoryNode f1957b;

                public boolean hasNext() {
                    return it.hasNext();
                }

                public Object next() {
                    return this.f1957b.mo487a((File) it.next());
                }

                public void remove() {
                    it.remove();
                }
            };
        }
    }

    /* compiled from: thread_state */
    public abstract class TimestampDirectoryNode extends DirectoryNode {
        public TimestampDirectoryNode(File file) {
            super(file);
        }

        public final long m2626a(int i) {
            try {
                return Long.parseLong(m2623b().getName());
            } catch (NumberFormatException e) {
                return (long) i;
            }
        }
    }

    /* compiled from: thread_state */
    public final class DayDirNode extends TimestampDirectoryNode {
        public DayDirNode(File file) {
            super(file);
        }

        protected final FileNode mo487a(File file) {
            return new HourDirNode(file);
        }
    }

    /* compiled from: thread_state */
    class FastArrayIterator<T> implements Iterator<T> {
        private final T[] f1958a;
        private int f1959b;
        private int f1960c;

        public FastArrayIterator(T[] tArr) {
            this.f1958a = tArr;
            this.f1959b = tArr.length;
        }

        public boolean hasNext() {
            return this.f1960c < this.f1959b;
        }

        public T next() {
            Object[] objArr = this.f1958a;
            int i = this.f1960c;
            this.f1960c = i + 1;
            return objArr[i];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: thread_state */
    public final class HourDirNode extends TimestampDirectoryNode {
        public HourDirNode(File file) {
            super(file);
        }

        protected final FileNode mo487a(File file) {
            return new BatchFileNode(file);
        }
    }

    /* compiled from: thread_state */
    public final class PriorityDirNode extends DirectoryNode {
        public PriorityDirNode(File file) {
            super(file);
        }

        protected final FileNode mo487a(File file) {
            return new ProcessDirNode(file);
        }
    }

    /* compiled from: thread_state */
    public final class ProcessDirNode extends DirectoryNode {
        public ProcessDirNode(File file) {
            super(file);
        }

        protected final FileNode mo487a(File file) {
            return new UidDirNode(file);
        }
    }

    /* compiled from: thread_state */
    class SnapshotDirectoryIterable implements Iterable<File> {
        private final File[] f1961a;

        public SnapshotDirectoryIterable(File file, @Nullable FileFilter fileFilter, @Nullable Comparator<File> comparator) {
            File[] listFiles;
            if (fileFilter != null) {
                listFiles = file.listFiles(fileFilter);
            } else {
                listFiles = file.listFiles();
            }
            if (listFiles == null) {
                listFiles = new File[0];
            } else if (comparator != null) {
                Arrays.sort(listFiles, comparator);
            }
            this.f1961a = listFiles;
        }

        public Iterator<File> iterator() {
            return new FastArrayIterator(this.f1961a);
        }
    }

    /* compiled from: thread_state */
    public final class TraversalEvent {
        public final FileNode f1962a;
        @EventType
        public final int f1963b;

        /* compiled from: thread_state */
        public @interface EventType {
        }

        public TraversalEvent(FileNode fileNode, @EventType int i) {
            this.f1962a = fileNode;
            this.f1963b = i;
        }
    }

    /* compiled from: thread_state */
    public final class TraversalNode {
        public final FileNode f1964a;
        @Nullable
        private Iterator<FileNode> f1965b;
        public int f1966c;

        public TraversalNode(FileNode fileNode) {
            this.f1964a = fileNode;
        }

        public final boolean m2632b() {
            return m2631e().hasNext();
        }

        public final FileNode m2633d() {
            this.f1966c++;
            return (FileNode) m2631e().next();
        }

        private Iterator<FileNode> m2631e() {
            if (this.f1965b == null) {
                this.f1965b = this.f1964a.mo486a();
            }
            return this.f1965b;
        }
    }

    /* compiled from: thread_state */
    public final class UidDirNode extends DirectoryNode {
        public UidDirNode(File file) {
            super(file);
        }

        protected final FileNode mo487a(File file) {
            return new DayDirNode(file);
        }
    }

    public final /* synthetic */ Object next() {
        return m2635a();
    }

    public BatchDirectoryStructureIterator(PriorityDirNode priorityDirNode) {
        Iterator a = priorityDirNode.mo486a();
        while (a.hasNext()) {
            this.f1968a.addLast(new TraversalNode((FileNode) a.next()));
        }
    }

    public final boolean hasNext() {
        if (!this.f1969b) {
            TraversalEvent traversalEvent;
            this.f1969b = true;
            while (!this.f1968a.isEmpty()) {
                TraversalNode traversalNode = (TraversalNode) this.f1968a.getLast();
                FileNode fileNode = traversalNode.f1964a;
                if (traversalNode.m2632b()) {
                    this.f1968a.addLast(new TraversalNode(traversalNode.m2633d()));
                    Object obj = 1;
                    if (traversalNode.f1966c != 1) {
                        obj = null;
                    }
                    if (obj != null) {
                        traversalEvent = new TraversalEvent(fileNode, 1);
                        break;
                    }
                }
                this.f1968a.removeLast();
                traversalEvent = fileNode instanceof DirectoryNode ? new TraversalEvent(fileNode, 2) : new TraversalEvent(fileNode, 3);
            }
            traversalEvent = null;
            this.f1970c = traversalEvent;
        }
        if (this.f1970c != null) {
            return true;
        }
        return false;
    }

    public final TraversalEvent m2635a() {
        if (hasNext()) {
            TraversalEvent traversalEvent = this.f1970c;
            this.f1970c = null;
            this.f1969b = false;
            return traversalEvent;
        }
        throw new IllegalStateException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
