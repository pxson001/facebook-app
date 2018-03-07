package com.google.common.io;

import com.facebook.messaging.media.upload.util.MediaHashCache.2;
import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.TreeTraverser;
import com.google.common.hash.AbstractStreamingHashFunction;
import com.google.common.hash.Funnels.SinkAsStream;
import com.google.common.hash.HashCode;
import com.google.common.io.ByteSink.AsCharSink;
import com.google.common.io.ByteSource.AsCharSource;
import com.google.common.io.ByteStreams.FastByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Arrays;

@Beta
/* compiled from: fql_result_set */
public final class Files {
    private static final TreeTraverser<File> f11455a = new C05552();

    /* compiled from: fql_result_set */
    final class C05552 extends TreeTraverser<File> {
        C05552() {
        }

        public final String toString() {
            return "Files.fileTreeTraverser()";
        }
    }

    /* compiled from: fql_result_set */
    final class FileByteSource extends ByteSource {
        private final File f11456a;

        public final /* synthetic */ InputStream mo846a() {
            return m11932c();
        }

        public FileByteSource(File file) {
            this.f11456a = (File) Preconditions.checkNotNull(file);
        }

        private FileInputStream m11932c() {
            return new FileInputStream(this.f11456a);
        }

        public final byte[] mo847b() {
            Closer a = Closer.m11942a();
            try {
                InputStream inputStream = (FileInputStream) a.m11943a(m11932c());
                byte[] a2 = Files.m11925a(inputStream, inputStream.getChannel().size());
                a.close();
                return a2;
            } catch (Throwable th) {
                a.close();
            }
        }

        public final String toString() {
            return "Files.asByteSource(" + this.f11456a + ")";
        }
    }

    /* compiled from: fql_result_set */
    final class FileByteSink extends ByteSink {
        private final File f11977a;
        private final ImmutableSet<FileWriteMode> f11978b;

        public FileByteSink(File file, FileWriteMode... fileWriteModeArr) {
            this.f11977a = (File) Preconditions.checkNotNull(file);
            this.f11978b = ImmutableSet.copyOf(fileWriteModeArr);
        }

        public final OutputStream mo896a() {
            return new FileOutputStream(this.f11977a, this.f11978b.contains(FileWriteMode.APPEND));
        }

        public final String toString() {
            return "Files.asByteSink(" + this.f11977a + ", " + this.f11978b + ")";
        }
    }

    private Files() {
    }

    public static ByteSource m11917a(File file) {
        return new FileByteSource(file);
    }

    static byte[] m11925a(InputStream inputStream, long j) {
        if (j > 2147483647L) {
            throw new OutOfMemoryError("file is too large to fit in a byte array: " + j + " bytes");
        } else if (j == 0) {
            return ByteStreams.m11954a(inputStream);
        } else {
            int i = (int) j;
            byte[] bArr = new byte[i];
            int i2 = i;
            while (i2 > 0) {
                int i3 = i - i2;
                int read = inputStream.read(bArr, i3, i2);
                if (read == -1) {
                    bArr = Arrays.copyOf(bArr, i3);
                    break;
                }
                i2 -= read;
            }
            i2 = inputStream.read();
            if (i2 != -1) {
                OutputStream fastByteArrayOutputStream = new FastByteArrayOutputStream();
                fastByteArrayOutputStream.write(i2);
                ByteStreams.m11949a(inputStream, fastByteArrayOutputStream);
                Object obj = new byte[(fastByteArrayOutputStream.size() + i)];
                System.arraycopy(bArr, 0, obj, 0, i);
                fastByteArrayOutputStream.a(obj, i);
                Object obj2 = obj;
            }
            return bArr;
        }
    }

    public static ByteSink m11916a(File file, FileWriteMode... fileWriteModeArr) {
        return new FileByteSink(file, fileWriteModeArr);
    }

    public static String m11920a(File file, Charset charset) {
        return new AsCharSource(m11917a(file), charset).b();
    }

    public static CharSink m11918a(File file, Charset charset, FileWriteMode... fileWriteModeArr) {
        return new AsCharSink(m11916a(file, fileWriteModeArr), charset);
    }

    public static byte[] m11929b(File file) {
        return m11917a(file).mo847b();
    }

    public static void m11924a(byte[] bArr, File file) {
        m11916a(file, new FileWriteMode[0]).m12633a(bArr);
    }

    public static void m11923a(File file, OutputStream outputStream) {
        m11917a(file).m11936a(outputStream);
    }

    public static void m11922a(File file, File file2) {
        boolean z;
        if (file.equals(file2)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z, "Source %s and destination %s must be different", new Object[]{file, file2});
        m11917a(file).m11935a(m11916a(file2, new FileWriteMode[0]));
    }

    public static void m11927b(CharSequence charSequence, File file, Charset charset) {
        m11918a(file, charset, 1 != 0 ? new FileWriteMode[]{FileWriteMode.APPEND} : new FileWriteMode[0]).a(charSequence);
    }

    public static boolean m11928b(File file, File file2) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(file2);
        if (file == file2 || file.equals(file2)) {
            return true;
        }
        long length = file.length();
        long length2 = file2.length();
        if (length == 0 || length2 == 0 || length == length2) {
            return m11917a(file).m11940a(m11917a(file2));
        }
        return false;
    }

    public static void m11930c(File file) {
        Preconditions.checkNotNull(file);
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                throw new IOException("Unable to create parent directories of " + file);
            }
        }
    }

    public static void m11931c(File file, File file2) {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(file2);
        Preconditions.checkArgument(!file.equals(file2), "Source %s and destination %s must be different", new Object[]{file, file2});
        if (!file.renameTo(file2)) {
            m11922a(file, file2);
            if (!file.delete()) {
                if (file2.delete()) {
                    throw new IOException("Unable to delete " + file);
                }
                throw new IOException("Unable to delete " + file2);
            }
        }
    }

    public static <T> T m11919a(File file, ByteProcessor<T> byteProcessor) {
        return m11917a(file).m11939a((2) byteProcessor);
    }

    public static HashCode m11915a(File file, AbstractStreamingHashFunction abstractStreamingHashFunction) {
        ByteSource a = m11917a(file);
        Object a2 = abstractStreamingHashFunction.mo115a();
        a.m11936a((OutputStream) new SinkAsStream(a2));
        return a2.mo116a();
    }

    public static String m11921a(String str) {
        Preconditions.checkNotNull(str);
        String name = new File(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf == -1 ? "" : name.substring(lastIndexOf + 1);
    }

    public static String m11926b(String str) {
        Preconditions.checkNotNull(str);
        String name = new File(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf == -1 ? name : name.substring(0, lastIndexOf);
    }
}
