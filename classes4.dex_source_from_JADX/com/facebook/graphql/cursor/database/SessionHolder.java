package com.facebook.graphql.cursor.database;

import com.facebook.debug.log.BLog;
import com.facebook.graphql.cursor.CursorModelCache;
import com.facebook.graphql.cursor.ModelReader;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: meta_context */
public class SessionHolder {
    @GuardedBy("this")
    private final Map<String, Integer> f7893a = new HashMap();
    private final CursorModelCache f7894b;

    public SessionHolder(CursorModelCache cursorModelCache) {
        this.f7894b = cursorModelCache;
    }

    public final synchronized void m8187a(String str) {
        if (this.f7893a.containsKey(str)) {
            this.f7893a.put(str, Integer.valueOf(((Integer) this.f7893a.get(str)).intValue() + 1));
        } else {
            this.f7893a.put(str, Integer.valueOf(1));
        }
    }

    public final synchronized void m8189b(String str) {
        if (this.f7893a.containsKey(str)) {
            Integer num = (Integer) this.f7893a.get(str);
            if (num.intValue() == 1) {
                this.f7893a.remove(str);
                this.f7894b.m8185a();
                ModelReader.m8332a();
            } else {
                this.f7893a.put(str, Integer.valueOf(num.intValue() - 1));
            }
        } else {
            BLog.c(SessionHolder.class, "Decreasing session count of a closed session");
        }
    }

    public final synchronized boolean m8190c(String str) {
        return this.f7893a.containsKey(str);
    }

    public final synchronized String[] m8188a() {
        return (String[]) this.f7893a.keySet().toArray(new String[this.f7893a.size()]);
    }
}
