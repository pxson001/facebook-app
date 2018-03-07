package com.facebook.photos.upload.manager;

import com.facebook.debug.log.BLog;
import com.facebook.inject.Lazy;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: tier */
public class UploadQueueFileManager {
    public static final Class<?> f2991a = UploadQueueFileManager.class;
    public final Provider<String> f2992b;
    private final Lazy<ExecutorService> f2993c;
    public File f2994d;
    public int f2995e;
    public String f2996f;
    private List<UploadOperation> f2997g;

    @Inject
    public UploadQueueFileManager(Provider<String> provider, Lazy<ExecutorService> lazy) {
        this.f2992b = provider;
        this.f2993c = lazy;
    }

    final void m4947a(File file, int i, String str) {
        this.f2994d = file;
        this.f2995e = i;
        this.f2996f = m4944a(str);
    }

    private static String m4944a(String str) {
        return str == null ? "" : str;
    }

    public final void m4946a(UploadOperation uploadOperation) {
        ExecutorDetour.a((ExecutorService) this.f2993c.get(), new 1(this, uploadOperation), 1012227073);
    }

    public final void m4949b(UploadOperation uploadOperation) {
        ExecutorDetour.a((ExecutorService) this.f2993c.get(), new 2(this, uploadOperation), -1814616980);
    }

    public final void m4945a() {
        ExecutorDetour.a((ExecutorService) this.f2993c.get(), new 3(this), 1873165309);
    }

    public final int m4948b() {
        IOException e;
        FileInputStream fileInputStream;
        Throwable th;
        if (this.f2994d.exists()) {
            FileInputStream fileInputStream2;
            try {
                this.f2997g = Lists.m1296a();
                fileInputStream2 = new FileInputStream(this.f2994d);
                try {
                    Object dataInputStream = new DataInputStream(fileInputStream2);
                    if (dataInputStream.readInt() != this.f2995e) {
                        throw new FailedSanityCheckException(this, "different app versions");
                    } else if (!Objects.equal(dataInputStream.readUTF(), this.f2996f)) {
                        throw new FailedSanityCheckException(this, "different OS versions");
                    } else if (Objects.equal(dataInputStream.readUTF(), this.f2992b.get())) {
                        while (fileInputStream2.available() > 0) {
                            int readInt = dataInputStream.readInt();
                            if (readInt == FieldType.QueuedOperation.ordinal()) {
                                this.f2997g.add(UploadOperation.a(dataInputStream));
                            } else if (readInt == FieldType.CompletedOperation.ordinal()) {
                                String readUTF = dataInputStream.readUTF();
                                for (int i = 0; i < this.f2997g.size(); i++) {
                                    if (Objects.equal(((UploadOperation) this.f2997g.get(i)).N(), readUTF)) {
                                        this.f2997g.remove(i);
                                        break;
                                    }
                                }
                            }
                        }
                        try {
                            fileInputStream2.close();
                        } catch (IOException e2) {
                        }
                        this.f2994d.delete();
                        return this.f2997g.size();
                    } else {
                        throw new FailedSanityCheckException(this, "different users");
                    }
                } catch (IOException e3) {
                    e = e3;
                    fileInputStream = fileInputStream2;
                    try {
                        BLog.a(f2991a, "Failed to read queued uploads: %s, %s", new Object[]{e.getClass().getSimpleName(), e.getMessage()});
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                            }
                        }
                        this.f2994d.delete();
                        return this.f2997g.size();
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e5) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
                fileInputStream = null;
                BLog.a(f2991a, "Failed to read queued uploads: %s, %s", new Object[]{e.getClass().getSimpleName(), e.getMessage()});
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.f2994d.delete();
                return this.f2997g.size();
            } catch (Throwable th4) {
                th = th4;
                fileInputStream2 = null;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                throw th;
            }
        }
        this.f2997g = null;
        return 0;
    }

    public final List<UploadOperation> m4950c() {
        List<UploadOperation> list = this.f2997g;
        this.f2997g = null;
        return list;
    }
}
