package com.fasterxml.jackson.dataformat.smile;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.Versioned;
import com.fasterxml.jackson.core.util.VersionUtil;

/* compiled from: codePointRange may not be null */
public final class PackageVersion implements Versioned {
    public static final Version VERSION = VersionUtil.m10780a("2.2.3", "com.fasterxml.jackson.dataformat", "jackson-dataformat-smile");

    public final Version version() {
        return VERSION;
    }
}
