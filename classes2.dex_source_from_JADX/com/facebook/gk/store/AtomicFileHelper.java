package com.facebook.gk.store;

import com.facebook.debug.log.BLog;
import java.io.File;
import javax.annotation.Nullable;

/* compiled from: videos_fb4a_new_player_new_ui_closed_captioning */
class AtomicFileHelper<T> {
    private final FileSerializer<T> f1069a;
    private final File f1070b;
    private final File f1071c;
    private final File f1072d;

    /* compiled from: videos_fb4a_new_player_new_ui_closed_captioning */
    public interface FileSerializer<T> {
        T mo330a(File file);

        void mo331a(File file, T t);
    }

    protected AtomicFileHelper(FileSerializer<T> fileSerializer, File file, String str) {
        this(fileSerializer, new File(file, str), new File(file, str + ".tmp"), new File(file, str + ".old"));
    }

    private AtomicFileHelper(FileSerializer<T> fileSerializer, File file, File file2, File file3) {
        this.f1069a = fileSerializer;
        this.f1070b = file;
        this.f1071c = file2;
        this.f1072d = file3;
    }

    public final boolean m2161a(T t) {
        try {
            this.f1069a.mo331a(this.f1071c, t);
            if (this.f1072d.exists() && !this.f1072d.delete()) {
                this.f1071c.delete();
                return false;
            } else if (this.f1070b.exists() && !this.f1070b.renameTo(this.f1072d)) {
                this.f1071c.delete();
                return false;
            } else if (this.f1071c.renameTo(this.f1070b)) {
                return true;
            } else {
                this.f1071c.delete();
                this.f1072d.renameTo(this.f1070b);
                return false;
            }
        } catch (Throwable e) {
            BLog.a("AtomicFileHelper", "Cannot write data to file", e);
            this.f1071c.delete();
            return false;
        }
    }

    @Nullable
    public final T m2160a() {
        T t = null;
        if (this.f1070b.exists()) {
            try {
                t = this.f1069a.mo330a(this.f1070b);
            } catch (Throwable e) {
                BLog.a("AtomicFileHelper", "Cannot read file", e);
            }
            return t;
        }
        if (this.f1072d.exists()) {
            try {
                t = this.f1069a.mo330a(this.f1072d);
            } catch (Throwable e2) {
                BLog.a("AtomicFileHelper", "Cannot read file", e2);
            }
        }
        return t;
    }
}
