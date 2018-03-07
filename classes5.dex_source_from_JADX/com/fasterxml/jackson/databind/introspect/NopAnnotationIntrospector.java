package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.cfg.PackageVersion;
import java.io.Serializable;

/* compiled from: celebsTitle */
public abstract class NopAnnotationIntrospector extends AnnotationIntrospector implements Serializable {
    public static final NopAnnotationIntrospector f6112a = new C05531();
    private static final long serialVersionUID = 1;

    /* compiled from: celebsTitle */
    final class C05531 extends NopAnnotationIntrospector {
        private static final long serialVersionUID = 1;

        C05531() {
        }

        public final Version version() {
            return PackageVersion.VERSION;
        }
    }

    public Version version() {
        return Version.a;
    }
}
