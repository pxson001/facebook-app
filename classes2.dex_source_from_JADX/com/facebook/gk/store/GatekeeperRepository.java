package com.facebook.gk.store;

import android.text.TextUtils;
import com.facebook.debug.log.BLog;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: videos_fb4a_new_player_old_ui_closed_captioning */
public class GatekeeperRepository {
    public static final String f1060a = GatekeeperRepository.class.getSimpleName();
    public final GatekeeperStoreConfig f1061b;
    private final AtomicFileHelper<StateFileContent> f1062c;
    private final AtomicFileHelper<NamesFileContent> f1063d;
    private boolean f1064e;
    @Nullable
    private String f1065f;
    private final FileLockHelper f1066g;
    private final File f1067h;
    private String f1068i;

    /* compiled from: videos_fb4a_new_player_old_ui_closed_captioning */
    class FileLockHelper {
        private final File f1073a;
        private RandomAccessFile f1074b;
        private FileLock f1075c;

        public FileLockHelper(File file) {
            this.f1073a = file;
        }

        public final boolean m2171a() {
            RandomAccessFile a = m2168a(this.f1073a);
            if (a == null) {
                return false;
            }
            FileLock a2 = m2169a(this.f1073a, a);
            if (a2 == null) {
                m2170b(this.f1073a, a);
                return false;
            }
            this.f1074b = a;
            this.f1075c = a2;
            return true;
        }

        public final void m2172b() {
            FileLock fileLock = this.f1075c;
            RandomAccessFile randomAccessFile = this.f1074b;
            this.f1075c = null;
            this.f1074b = null;
            try {
                fileLock.release();
            } catch (Throwable e) {
                BLog.a(GatekeeperRepository.f1060a, e, "Cannot release a lock to file %s", new Object[]{this.f1073a});
            }
            m2170b(this.f1073a, randomAccessFile);
        }

        private static RandomAccessFile m2168a(File file) {
            try {
                return new RandomAccessFile(file, "rw");
            } catch (Throwable e) {
                BLog.b(GatekeeperRepository.f1060a, e, "Cannot create file %s", new Object[]{file});
                return null;
            }
        }

        private static FileLock m2169a(File file, RandomAccessFile randomAccessFile) {
            try {
                return randomAccessFile.getChannel().lock();
            } catch (Throwable e) {
                BLog.b(GatekeeperRepository.f1060a, e, "Cannot acquire a lock to file %s", new Object[]{file});
                m2170b(file, randomAccessFile);
                return null;
            }
        }

        private static void m2170b(File file, RandomAccessFile randomAccessFile) {
            try {
                randomAccessFile.close();
            } catch (Throwable e) {
                BLog.a(GatekeeperRepository.f1060a, e, "Cannot close file %s", new Object[]{file});
            }
        }
    }

    public static void m2149a(GatekeeperCache gatekeeperCache, int i, byte b) {
        Object obj;
        boolean z;
        if ((b & 3) != 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            if ((b & 2) != 0) {
                z = true;
            } else {
                z = false;
            }
            gatekeeperCache.m2202a(i, z);
        } else {
            gatekeeperCache.m2210e(i);
        }
        if ((b & 12) != 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            if ((b & 8) != 0) {
                z = true;
            } else {
                z = false;
            }
            gatekeeperCache.m2206b(i, z);
            return;
        }
        gatekeeperCache.m2211f(i);
    }

    public GatekeeperRepository(GatekeeperStoreConfig gatekeeperStoreConfig, File file) {
        this(gatekeeperStoreConfig, new AtomicFileHelper(new StateFileSerializer(), file, "gk_state"), new AtomicFileHelper(new NamesFileSerializer(), file, "gk_names"), file);
    }

    private GatekeeperRepository(GatekeeperStoreConfig gatekeeperStoreConfig, AtomicFileHelper<StateFileContent> atomicFileHelper, AtomicFileHelper<NamesFileContent> atomicFileHelper2, File file) {
        this.f1061b = gatekeeperStoreConfig;
        this.f1062c = atomicFileHelper;
        this.f1063d = atomicFileHelper2;
        this.f1067h = file;
        this.f1066g = new FileLockHelper(new File(file, "file_lock"));
    }

    public final synchronized boolean m2158a(GatekeeperCache gatekeeperCache) {
        boolean z = false;
        synchronized (this) {
            if (!this.f1064e) {
                this.f1064e = true;
                if (m2155d() && this.f1066g.m2171a()) {
                    try {
                        z = m2153c(gatekeeperCache);
                    } finally {
                        this.f1066g.m2172b();
                    }
                }
            }
        }
        return z;
    }

    private boolean m2153c(GatekeeperCache gatekeeperCache) {
        StateFileContent stateFileContent = (StateFileContent) this.f1062c.m2160a();
        if (stateFileContent == null) {
            return false;
        }
        int i;
        if (TextUtils.equals(stateFileContent.f1449a, m2156e())) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            NamesFileContent namesFileContent = (NamesFileContent) this.f1063d.m2160a();
            if (namesFileContent == null) {
                return false;
            }
            if (!stateFileContent.f1449a.equals(namesFileContent.a)) {
                BLog.b(f1060a, "The hash of gatekeeper names in files doesn't match: %s and %s", new Object[]{stateFileContent.f1449a, namesFileContent.a});
                return false;
            } else if (!m2151a(stateFileContent.f1450b.length, namesFileContent.b.size())) {
                return false;
            } else {
                ArrayList arrayList = namesFileContent.b;
                byte[] bArr = stateFileContent.f1450b;
                GatekeeperIndices gatekeeperIndices = new GatekeeperIndices(this.f1061b);
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Integer a = gatekeeperIndices.a((String) arrayList.get(i2));
                    if (a != null) {
                        m2149a(gatekeeperCache, a.intValue(), bArr[i2]);
                    }
                }
                ExecutorDetour.a(Executors.newSingleThreadExecutor(), new 1(this, gatekeeperCache), -1188138996);
            }
        } else if (!m2151a(stateFileContent.f1450b.length, this.f1061b.mo327a())) {
            return false;
        } else {
            m2150a(gatekeeperCache, stateFileContent.f1450b);
        }
        this.f1068i = stateFileContent.f1449a;
        return true;
    }

    private static boolean m2151a(int i, int i2) {
        if (i == i2) {
            return true;
        }
        BLog.b(f1060a, "The number of gatekeepers in files doesn't match: %s and %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        return false;
    }

    private void m2150a(GatekeeperCache gatekeeperCache, byte[] bArr) {
        for (int i = 0; i < this.f1061b.mo327a(); i++) {
            m2149a(gatekeeperCache, i, bArr[i]);
        }
    }

    public final synchronized void m2159b(GatekeeperCache gatekeeperCache) {
        if (m2155d()) {
            m2156e();
            if (this.f1066g.m2171a()) {
                try {
                    m2154d(gatekeeperCache);
                } finally {
                    this.f1066g.m2172b();
                }
            }
        }
    }

    private void m2154d(GatekeeperCache gatekeeperCache) {
        if (!this.f1064e) {
            StateFileContent stateFileContent = (StateFileContent) this.f1062c.m2160a();
            if (stateFileContent != null) {
                this.f1068i = stateFileContent.f1449a;
            }
        }
        if (m2152c()) {
            if (this.f1063d.m2161a(new NamesFileContent(this.f1061b.mo329c(), this.f1061b.mo328b()))) {
                this.f1068i = m2156e();
            } else {
                return;
            }
        }
        String e = m2156e();
        int length = gatekeeperCache.f1087a.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) (RawGatekeeperStateConverter.a(gatekeeperCache.m2204b(i)) | RawGatekeeperStateConverter.b(gatekeeperCache.m2207c(i)));
        }
        this.f1062c.m2161a(new StateFileContent(e, bArr));
        this.f1064e = true;
    }

    private synchronized boolean m2152c() {
        return !TextUtils.equals(m2156e(), this.f1068i);
    }

    public static synchronized void m2157e(GatekeeperRepository gatekeeperRepository, GatekeeperCache gatekeeperCache) {
        synchronized (gatekeeperRepository) {
            if (gatekeeperRepository.m2152c()) {
                gatekeeperRepository.m2159b(gatekeeperCache);
            }
        }
    }

    private boolean m2155d() {
        if (this.f1067h.exists() || this.f1067h.mkdirs()) {
            return true;
        }
        BLog.a(f1060a, "Cannot create working directory: %s", new Object[]{this.f1067h.getAbsoluteFile()});
        return false;
    }

    private synchronized String m2156e() {
        if (this.f1065f == null) {
            this.f1065f = this.f1061b.mo329c();
        }
        return this.f1065f;
    }
}
