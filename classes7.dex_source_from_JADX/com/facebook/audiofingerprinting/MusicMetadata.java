package com.facebook.audiofingerprinting;

import com.facebook.common.stringformat.StringFormatUtil;

/* compiled from: update_snapshot_db_with_server_entries */
public class MusicMetadata {
    public final String f1072a;
    public final String f1073b;
    public final String f1074c;
    public final String f1075d;

    public MusicMetadata(String str, String str2, String str3, String str4) {
        this.f1072a = str;
        this.f1073b = str3;
        this.f1074c = str2;
        this.f1075d = str4;
    }

    public String toString() {
        return StringFormatUtil.a("Artist : %s\n Album : %s\n Title : %s\n Timestamp : %s", new Object[]{this.f1072a, this.f1073b, this.f1074c, this.f1075d});
    }
}
