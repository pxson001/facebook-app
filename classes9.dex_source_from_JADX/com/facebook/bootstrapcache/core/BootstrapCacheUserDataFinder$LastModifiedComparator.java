package com.facebook.bootstrapcache.core;

import java.io.File;
import java.util.Comparator;

/* compiled from: reason_phrase */
class BootstrapCacheUserDataFinder$LastModifiedComparator implements Comparator<File> {
    public int compare(Object obj, Object obj2) {
        File file = (File) obj2;
        long lastModified = ((File) obj).lastModified();
        long lastModified2 = file.lastModified();
        if (lastModified < lastModified2) {
            return -1;
        }
        return lastModified == lastModified2 ? 0 : 1;
    }
}
