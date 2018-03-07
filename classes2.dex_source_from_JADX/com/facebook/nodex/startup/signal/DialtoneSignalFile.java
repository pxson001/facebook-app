package com.facebook.nodex.startup.signal;

import android.content.Context;
import android.util.Log;
import java.io.File;

/* compiled from: triggered_code */
public class DialtoneSignalFile {
    public static final String f2242a = DialtoneSignalFile.class.getSimpleName();
    protected Boolean f2243b = null;
    private final File f2244c;

    public DialtoneSignalFile(Context context) {
        this.f2244c = new File(context.getCacheDir(), "fb_dialtone_signal");
    }

    public boolean mo637a() {
        try {
            if (m4401e()) {
                File file = new File(this.f2244c, "enable_dialtone_mode");
                file.createNewFile();
                Log.d(f2242a, "Dialtone signal file successfully created at " + file);
                m4400d();
                return true;
            }
        } catch (Throwable e) {
            Log.w(f2242a, "Dialtone file could not be created", e);
        } finally {
            m4400d();
        }
        return false;
    }

    private void m4400d() {
        this.f2243b = Boolean.valueOf(new File(this.f2244c, "enable_dialtone_mode").exists());
    }

    public boolean mo638b() {
        boolean z = true;
        File[] listFiles = this.f2244c.listFiles();
        if (listFiles != null) {
            for (File delete : listFiles) {
                if (!delete.delete()) {
                    z = false;
                }
            }
        }
        m4400d();
        return z;
    }

    private boolean m4401e() {
        if (this.f2244c.exists()) {
            return this.f2244c.isDirectory() && this.f2244c.canRead() && this.f2244c.canWrite();
        } else {
            return this.f2244c.mkdirs();
        }
    }

    public boolean m4404c() {
        if (this.f2243b == null) {
            m4400d();
        }
        return this.f2243b.booleanValue();
    }
}
