package com.facebook.graphql.executor.filemap;

import com.facebook.common.filelite.DeleteUtils;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.google.common.base.Preconditions;
import java.io.File;
import java.util.Set;

/* compiled from: learn_more_text */
public class FlatBufferModelFileManager {
    public static String m6326a(File file) {
        if (!file.exists()) {
            Preconditions.checkState(file.mkdirs());
        }
        return new File(file, SafeUUIDGenerator.a().toString()).getAbsolutePath();
    }

    public static void m6327a(File file, Set<String> set) {
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (!set.contains(file2.getAbsolutePath())) {
                        file2.delete();
                    }
                }
            }
        }
    }

    public static void m6328b(File file) {
        if (file.exists()) {
            Preconditions.checkState(DeleteUtils.m3693a(file));
        }
    }
}
