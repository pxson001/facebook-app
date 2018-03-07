package com.facebook.ui.media.cache;

import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import java.util.Map;

/* compiled from: pack_types_type_index */
public class FileMetadata {
    public final long f5544a;
    public final String f5545b;
    public Map<String, Object> f5546c;

    public FileMetadata(long j, String str) {
        this.f5544a = j;
        this.f5545b = str;
    }

    public final void m5972a(String str, Object obj) {
        if (this.f5546c == null) {
            this.f5546c = Maps.a(4);
        }
        this.f5546c.put(str, obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FileMetadata fileMetadata = (FileMetadata) obj;
        if (Objects.equal(Long.valueOf(this.f5544a), Long.valueOf(fileMetadata.f5544a)) && Objects.equal(this.f5545b, fileMetadata.f5545b) && Objects.equal(this.f5546c, fileMetadata.f5546c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Long.valueOf(this.f5544a), this.f5545b, this.f5546c});
    }
}
