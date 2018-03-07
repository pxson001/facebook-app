package com.facebook.gl;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Throwables;
import com.google.common.io.CharStreams;
import com.google.common.io.Closeables;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.inject.Inject;

/* compiled from: WWW_EVENTS_PERMALINK */
public class ProgramFactory {
    public final Resources f12349a;

    public static ProgramFactory m20428b(InjectorLike injectorLike) {
        return new ProgramFactory(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ProgramFactory(Resources resources) {
        this.f12349a = resources;
    }

    public final Program m20429a(int i, int i2) {
        return new Program(m20427a(i), m20427a(i2));
    }

    private String m20427a(int i) {
        Reader inputStreamReader = new InputStreamReader(this.f12349a.openRawResource(i));
        try {
            String a = CharStreams.a(inputStreamReader);
            Closeables.a(inputStreamReader);
            return a;
        } catch (Throwable e) {
            throw Throwables.propagate(e);
        } catch (Throwable th) {
            Closeables.a(inputStreamReader);
        }
    }
}
