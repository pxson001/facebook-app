package com.facebook.analytics2.logger;

import java.io.File;
import java.io.FileFilter;

/* compiled from: wifi_sleep_policy */
public class BatchDirectoryStructure$BatchFilenameStructure {
    public static final FileFilter f88a = new C00081();

    /* compiled from: wifi_sleep_policy */
    final class C00081 implements FileFilter {
        C00081() {
        }

        public final boolean accept(File file) {
            if (!file.isFile()) {
                return false;
            }
            String name = file.getName();
            if (name.startsWith("batch-") && name.endsWith(".json")) {
                return true;
            }
            return false;
        }
    }
}
