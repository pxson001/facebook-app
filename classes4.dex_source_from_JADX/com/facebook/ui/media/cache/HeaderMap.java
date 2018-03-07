package com.facebook.ui.media.cache;

import java.util.TreeMap;

@Deprecated
/* compiled from: package_name_ */
public final class HeaderMap extends TreeMap<String, String> {
    public HeaderMap() {
        super(String.CASE_INSENSITIVE_ORDER);
    }

    private long m5970b() {
        String str = (String) get("Content-Range");
        if (str != null) {
            try {
                long parseLong = Long.parseLong(str.substring(str.lastIndexOf(47) + 1).trim());
                if (parseLong > 0) {
                    return parseLong;
                }
            } catch (NumberFormatException e) {
            }
        }
        str = (String) get("Content-Length");
        if (str != null) {
            return Long.parseLong(str.trim());
        }
        return -1;
    }

    public final FileMetadata m5971a() {
        FileMetadata fileMetadata = new FileMetadata(m5970b(), (String) get("Content-Type"));
        fileMetadata.m5972a("Cache-Control", get("Cache-Control"));
        return fileMetadata;
    }
}
