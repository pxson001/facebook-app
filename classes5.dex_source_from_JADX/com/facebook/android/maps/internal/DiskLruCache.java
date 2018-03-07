package com.facebook.android.maps.internal;

import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* compiled from: await must not be called on the UI thread */
public final class DiskLruCache implements Closeable {
    static final Charset f8371a = Charset.forName("US-ASCII");
    static final Charset f8372b = Charset.forName("UTF-8");
    static final Pattern f8373c = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream f8374r = new C09262();
    final ThreadPoolExecutor f8375d = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    public final File f8376e;
    private final File f8377f;
    private final File f8378g;
    private final File f8379h;
    private final int f8380i;
    private long f8381j;
    public final int f8382k;
    private long f8383l = 0;
    public Writer f8384m;
    private final LinkedHashMap<String, Entry> f8385n = new LinkedHashMap(0, 0.75f, true);
    private int f8386o;
    private long f8387p = 0;
    private final Callable<Void> f8388q = new C09251(this);

    /* compiled from: await must not be called on the UI thread */
    class C09251 implements Callable<Void> {
        final /* synthetic */ DiskLruCache f8346a;

        C09251(DiskLruCache diskLruCache) {
            this.f8346a = diskLruCache;
        }

        public Object call() {
            synchronized (this.f8346a) {
                if (this.f8346a.f8384m == null) {
                } else {
                    DiskLruCache.m14479g(this.f8346a);
                    if (DiskLruCache.m14477e(this.f8346a)) {
                        DiskLruCache.m14474d(this.f8346a);
                        this.f8346a.f8386o = 0;
                    }
                }
            }
            return null;
        }
    }

    /* compiled from: await must not be called on the UI thread */
    final class C09262 extends OutputStream {
        C09262() {
        }

        public final void write(int i) {
        }
    }

    /* compiled from: await must not be called on the UI thread */
    public final class Editor {
        final /* synthetic */ DiskLruCache f8348a;
        public final Entry f8349b;
        public final boolean[] f8350c;
        private boolean f8351d;
        private boolean f8352e;

        /* compiled from: await must not be called on the UI thread */
        class FaultHidingOutputStream extends FilterOutputStream {
            final /* synthetic */ Editor f8347a;

            public FaultHidingOutputStream(Editor editor, OutputStream outputStream) {
                this.f8347a = editor;
                super(outputStream);
            }

            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException e) {
                    this.f8347a.f8351d = true;
                }
            }

            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException e) {
                    this.f8347a.f8351d = true;
                }
            }

            public void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    this.f8347a.f8351d = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    this.f8347a.f8351d = true;
                }
            }
        }

        public Editor(DiskLruCache diskLruCache, Entry entry) {
            this.f8348a = diskLruCache;
            this.f8349b = entry;
            this.f8350c = entry.f8356d ? null : new boolean[diskLruCache.f8382k];
        }

        public final OutputStream m14449a(int i) {
            if (i < 0 || i >= this.f8348a.f8382k) {
                throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count " + "of " + this.f8348a.f8382k);
            }
            OutputStream outputStream;
            synchronized (this.f8348a) {
                if (this.f8349b.f8357e != this) {
                    throw new IllegalStateException();
                }
                OutputStream fileOutputStream;
                if (!this.f8349b.f8356d) {
                    this.f8350c[i] = true;
                }
                File b = this.f8349b.m14460b(i);
                try {
                    fileOutputStream = new FileOutputStream(b);
                } catch (FileNotFoundException e) {
                    this.f8348a.f8376e.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(b);
                    } catch (FileNotFoundException e2) {
                        outputStream = DiskLruCache.f8374r;
                    }
                }
                outputStream = new FaultHidingOutputStream(this, fileOutputStream);
            }
            return outputStream;
        }

        public final void m14450a() {
            if (this.f8351d) {
                DiskLruCache.m14467a(this.f8348a, this, false);
                this.f8348a.m14483c(this.f8349b.f8354b);
            } else {
                DiskLruCache.m14467a(this.f8348a, this, true);
            }
            this.f8352e = true;
        }

        public final void m14451b() {
            DiskLruCache.m14467a(this.f8348a, this, false);
        }

        public final void m14452c() {
            if (!this.f8352e) {
                try {
                    m14451b();
                } catch (IOException e) {
                }
            }
        }
    }

    /* compiled from: await must not be called on the UI thread */
    public final class Entry {
        final /* synthetic */ DiskLruCache f8353a;
        public final String f8354b;
        public final long[] f8355c;
        public boolean f8356d;
        public Editor f8357e;
        public long f8358f;

        public Entry(DiskLruCache diskLruCache, String str) {
            this.f8353a = diskLruCache;
            this.f8354b = str;
            this.f8355c = new long[diskLruCache.f8382k];
        }

        public final String m14459a() {
            StringBuilder stringBuilder = new StringBuilder();
            for (long append : this.f8355c) {
                stringBuilder.append(' ').append(append);
            }
            return stringBuilder.toString();
        }

        public static void m14455a(Entry entry, String[] strArr) {
            if (strArr.length != entry.f8353a.f8382k) {
                throw m14457b(strArr);
            }
            int i = 0;
            while (i < strArr.length) {
                try {
                    entry.f8355c[i] = Long.parseLong(strArr[i]);
                    i++;
                } catch (NumberFormatException e) {
                    throw m14457b(strArr);
                }
            }
        }

        private static IOException m14457b(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final File m14458a(int i) {
            return new File(this.f8353a.f8376e, this.f8354b + "." + i);
        }

        public final File m14460b(int i) {
            return new File(this.f8353a.f8376e, this.f8354b + "." + i + ".tmp");
        }
    }

    /* compiled from: await must not be called on the UI thread */
    public final class Snapshot implements Closeable {
        final /* synthetic */ DiskLruCache f8359a;
        private final String f8360b;
        private final long f8361c;
        private final InputStream[] f8362d;
        private final long[] f8363e;

        private Snapshot(DiskLruCache diskLruCache, String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.f8359a = diskLruCache;
            this.f8360b = str;
            this.f8361c = j;
            this.f8362d = inputStreamArr;
            this.f8363e = jArr;
        }

        public final InputStream m14461a(int i) {
            return this.f8362d[i];
        }

        public final void close() {
            for (Closeable a : this.f8362d) {
                DiskLruCache.m14468a(a);
            }
        }
    }

    /* compiled from: await must not be called on the UI thread */
    class StrictLineReader implements Closeable {
        final /* synthetic */ DiskLruCache f8365a;
        private final InputStream f8366b;
        public final Charset f8367c;
        private byte[] f8368d;
        private int f8369e;
        private int f8370f;

        public StrictLineReader(DiskLruCache diskLruCache, InputStream inputStream, Charset charset) {
            this(diskLruCache, inputStream, 8192, charset);
        }

        private StrictLineReader(DiskLruCache diskLruCache, InputStream inputStream, int i, Charset charset) {
            this.f8365a = diskLruCache;
            if (inputStream == null || charset == null) {
                throw new NullPointerException();
            } else if (i < 0) {
                throw new IllegalArgumentException("capacity <= 0");
            } else if (charset.equals(DiskLruCache.f8371a)) {
                this.f8366b = inputStream;
                this.f8367c = charset;
                this.f8368d = new byte[i];
            } else {
                throw new IllegalArgumentException("Unsupported encoding");
            }
        }

        public void close() {
            synchronized (this.f8366b) {
                if (this.f8368d != null) {
                    this.f8368d = null;
                    this.f8366b.close();
                }
            }
        }

        public final String m14463a() {
            String str;
            synchronized (this.f8366b) {
                if (this.f8368d == null) {
                    throw new IOException("LineReader is closed");
                }
                int i;
                if (this.f8369e >= this.f8370f) {
                    m14462b();
                }
                int i2 = this.f8369e;
                while (i2 != this.f8370f) {
                    if (this.f8368d[i2] == (byte) 10) {
                        int i3 = (i2 == this.f8369e || this.f8368d[i2 - 1] != (byte) 13) ? i2 : i2 - 1;
                        str = new String(this.f8368d, this.f8369e, i3 - this.f8369e, this.f8367c.name());
                        this.f8369e = i2 + 1;
                    } else {
                        i2++;
                    }
                }
                ByteArrayOutputStream c09271 = new ByteArrayOutputStream(this, (this.f8370f - this.f8369e) + 80) {
                    final /* synthetic */ StrictLineReader f8364a;

                    public String toString() {
                        int i = (this.count <= 0 || this.buf[this.count - 1] != (byte) 13) ? this.count : this.count - 1;
                        try {
                            return new String(this.buf, 0, i, this.f8364a.f8367c.name());
                        } catch (UnsupportedEncodingException e) {
                            throw new AssertionError(e);
                        }
                    }
                };
                loop1:
                while (true) {
                    c09271.write(this.f8368d, this.f8369e, this.f8370f - this.f8369e);
                    this.f8370f = -1;
                    m14462b();
                    i = this.f8369e;
                    while (i != this.f8370f) {
                        if (this.f8368d[i] == (byte) 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                if (i != this.f8369e) {
                    c09271.write(this.f8368d, this.f8369e, i - this.f8369e);
                }
                this.f8369e = i + 1;
                str = c09271.toString();
            }
            return str;
        }

        private void m14462b() {
            int read = this.f8366b.read(this.f8368d, 0, this.f8368d.length);
            if (read == -1) {
                throw new EOFException();
            }
            this.f8369e = 0;
            this.f8370f = read;
        }
    }

    private DiskLruCache(File file, int i, int i2, long j) {
        this.f8376e = file;
        this.f8380i = i;
        this.f8377f = new File(file, "journal");
        this.f8378g = new File(file, "journal.tmp");
        this.f8379h = new File(file, "journal.bkp");
        this.f8382k = i2;
        this.f8381j = j;
    }

    private static void m14469a(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            File file2 = listFiles[i];
            if (file2.isDirectory()) {
                m14469a(file2);
            }
            if (file2.delete()) {
                i++;
            } else {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }

    static void m14468a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static DiskLruCache m14466a(File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        } else {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    m14470a(file2, file3, false);
                }
            }
            DiskLruCache diskLruCache = new DiskLruCache(file, i, i2, j);
            if (diskLruCache.f8377f.exists()) {
                try {
                    diskLruCache.m14471b();
                    diskLruCache.m14473c();
                    diskLruCache.f8384m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(diskLruCache.f8377f, true), f8371a));
                    return diskLruCache;
                } catch (IOException e) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    diskLruCache.m14480h();
                }
            }
            file.mkdirs();
            diskLruCache = new DiskLruCache(file, i, i2, j);
            m14474d(diskLruCache);
            return diskLruCache;
        }
    }

    private void m14471b() {
        Closeable strictLineReader = new StrictLineReader(this, new FileInputStream(this.f8377f), f8371a);
        try {
            String a = strictLineReader.m14463a();
            String a2 = strictLineReader.m14463a();
            String a3 = strictLineReader.m14463a();
            String a4 = strictLineReader.m14463a();
            String a5 = strictLineReader.m14463a();
            if ("libcore.io.DiskLruCache".equals(a) && "1".equals(a2) && Integer.toString(this.f8380i).equals(a3) && Integer.toString(this.f8382k).equals(a4) && "".equals(a5)) {
                int i = 0;
                while (true) {
                    try {
                        m14475d(strictLineReader.m14463a());
                        i++;
                    } catch (EOFException e) {
                        this.f8386o = i - this.f8385n.size();
                        m14468a(strictLineReader);
                        return;
                    }
                }
            }
            throw new IOException("unexpected journal header: [" + a + ", " + a2 + ", " + a4 + ", " + a5 + "]");
        } catch (Throwable th) {
            m14468a(strictLineReader);
        }
    }

    private void m14475d(String str) {
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        String str2;
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            String substring = str.substring(i);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                this.f8385n.remove(substring);
                return;
            }
            str2 = substring;
        } else {
            str2 = str.substring(i, indexOf2);
        }
        Entry entry = (Entry) this.f8385n.get(str2);
        if (entry == null) {
            entry = new Entry(this, str2);
            this.f8385n.put(str2, entry);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            entry.f8356d = true;
            entry.f8357e = null;
            Entry.m14455a(entry, split);
        } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            entry.f8357e = new Editor(this, entry);
        } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void m14473c() {
        m14472b(this.f8378g);
        Iterator it = this.f8385n.values().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            int i;
            if (entry.f8357e == null) {
                for (i = 0; i < this.f8382k; i++) {
                    this.f8383l += entry.f8355c[i];
                }
            } else {
                entry.f8357e = null;
                for (i = 0; i < this.f8382k; i++) {
                    m14472b(entry.m14458a(i));
                    m14472b(entry.m14460b(i));
                }
                it.remove();
            }
        }
    }

    public static synchronized void m14474d(DiskLruCache diskLruCache) {
        synchronized (diskLruCache) {
            if (diskLruCache.f8384m != null) {
                diskLruCache.f8384m.close();
            }
            Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(diskLruCache.f8378g), f8371a));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(diskLruCache.f8380i));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(diskLruCache.f8382k));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (Entry entry : diskLruCache.f8385n.values()) {
                    if (entry.f8357e != null) {
                        bufferedWriter.write("DIRTY " + entry.f8354b + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + entry.f8354b + entry.m14459a() + '\n');
                    }
                }
                if (diskLruCache.f8377f.exists()) {
                    m14470a(diskLruCache.f8377f, diskLruCache.f8379h, true);
                }
                m14470a(diskLruCache.f8378g, diskLruCache.f8377f, false);
                diskLruCache.f8379h.delete();
                diskLruCache.f8384m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(diskLruCache.f8377f, true), f8371a));
            } finally {
                bufferedWriter.close();
            }
        }
    }

    private static void m14472b(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void m14470a(File file, File file2, boolean z) {
        if (z) {
            m14472b(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public final synchronized Snapshot m14481a(String str) {
        Snapshot snapshot = null;
        synchronized (this) {
            m14478f();
            m14476e(str);
            Entry entry = (Entry) this.f8385n.get(str);
            if (entry != null && entry.f8356d) {
                InputStream[] inputStreamArr = new InputStream[this.f8382k];
                int i = 0;
                while (i < this.f8382k) {
                    try {
                        inputStreamArr[i] = new FileInputStream(entry.m14458a(i));
                        i++;
                    } catch (FileNotFoundException e) {
                        int i2 = 0;
                        while (i2 < this.f8382k && inputStreamArr[i2] != null) {
                            m14468a(inputStreamArr[i2]);
                            i2++;
                        }
                    }
                }
                this.f8386o++;
                this.f8384m.append("READ " + str + '\n');
                if (m14477e(this)) {
                    ExecutorDetour.a(this.f8375d, this.f8388q, -495522132);
                }
                snapshot = new Snapshot(str, entry.f8358f, inputStreamArr, entry.f8355c);
            }
        }
        return snapshot;
    }

    public final Editor m14482b(String str) {
        return m14465a(str, -1);
    }

    private synchronized Editor m14465a(String str, long j) {
        Editor editor;
        m14478f();
        m14476e(str);
        Entry entry = (Entry) this.f8385n.get(str);
        if (j == -1 || (entry != null && entry.f8358f == j)) {
            Entry entry2;
            if (entry == null) {
                entry = new Entry(this, str);
                this.f8385n.put(str, entry);
                entry2 = entry;
            } else if (entry.f8357e != null) {
                editor = null;
            } else {
                entry2 = entry;
            }
            editor = new Editor(this, entry2);
            entry2.f8357e = editor;
            this.f8384m.write("DIRTY " + str + '\n');
            this.f8384m.flush();
        } else {
            editor = null;
        }
        return editor;
    }

    public static synchronized void m14467a(DiskLruCache diskLruCache, Editor editor, boolean z) {
        int i = 0;
        synchronized (diskLruCache) {
            Entry entry = editor.f8349b;
            if (entry.f8357e != editor) {
                throw new IllegalStateException();
            }
            if (z && !entry.f8356d) {
                int i2 = 0;
                while (i2 < diskLruCache.f8382k) {
                    if (!editor.f8350c[i2]) {
                        editor.m14451b();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    } else if (!entry.m14460b(i2).exists()) {
                        editor.m14451b();
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            while (i < diskLruCache.f8382k) {
                File b = entry.m14460b(i);
                if (!z) {
                    m14472b(b);
                } else if (b.exists()) {
                    File a = entry.m14458a(i);
                    b.renameTo(a);
                    long j = entry.f8355c[i];
                    long length = a.length();
                    entry.f8355c[i] = length;
                    diskLruCache.f8383l = (diskLruCache.f8383l - j) + length;
                }
                i++;
            }
            diskLruCache.f8386o++;
            entry.f8357e = null;
            if ((entry.f8356d | z) != 0) {
                entry.f8356d = true;
                diskLruCache.f8384m.write("CLEAN " + entry.f8354b + entry.m14459a() + '\n');
                if (z) {
                    long j2 = diskLruCache.f8387p;
                    diskLruCache.f8387p = 1 + j2;
                    entry.f8358f = j2;
                }
            } else {
                diskLruCache.f8385n.remove(entry.f8354b);
                diskLruCache.f8384m.write("REMOVE " + entry.f8354b + '\n');
            }
            diskLruCache.f8384m.flush();
            if (diskLruCache.f8383l > diskLruCache.f8381j || m14477e(diskLruCache)) {
                ExecutorDetour.a(diskLruCache.f8375d, diskLruCache.f8388q, 844405696);
            }
        }
    }

    public static boolean m14477e(DiskLruCache diskLruCache) {
        return diskLruCache.f8386o >= 2000 && diskLruCache.f8386o >= diskLruCache.f8385n.size();
    }

    public final synchronized boolean m14483c(String str) {
        boolean z;
        int i = 0;
        synchronized (this) {
            m14478f();
            m14476e(str);
            Entry entry = (Entry) this.f8385n.get(str);
            if (entry == null || entry.f8357e != null) {
                z = false;
            } else {
                while (i < this.f8382k) {
                    File a = entry.m14458a(i);
                    if (!a.exists() || a.delete()) {
                        this.f8383l -= entry.f8355c[i];
                        entry.f8355c[i] = 0;
                        i++;
                    } else {
                        throw new IOException("failed to delete " + a);
                    }
                }
                this.f8386o++;
                this.f8384m.append("REMOVE " + str + '\n');
                this.f8385n.remove(str);
                if (m14477e(this)) {
                    ExecutorDetour.a(this.f8375d, this.f8388q, -2072803794);
                }
                z = true;
            }
        }
        return z;
    }

    private void m14478f() {
        if (this.f8384m == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void close() {
        if (this.f8384m != null) {
            Iterator it = new ArrayList(this.f8385n.values()).iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (entry.f8357e != null) {
                    entry.f8357e.m14451b();
                }
            }
            m14479g(this);
            this.f8384m.close();
            this.f8384m = null;
        }
    }

    public static void m14479g(DiskLruCache diskLruCache) {
        while (diskLruCache.f8383l > diskLruCache.f8381j) {
            diskLruCache.m14483c((String) ((java.util.Map.Entry) diskLruCache.f8385n.entrySet().iterator().next()).getKey());
        }
    }

    private void m14480h() {
        close();
        m14469a(this.f8376e);
    }

    private static void m14476e(String str) {
        if (!f8373c.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }
}
