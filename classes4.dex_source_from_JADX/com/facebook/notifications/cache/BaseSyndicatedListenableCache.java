package com.facebook.notifications.cache;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.util.StringUtil;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import javax.annotation.Nullable;

/* compiled from: mms_media_type */
public abstract class BaseSyndicatedListenableCache<K, V> extends BaseListenableCache<K, V> implements MemoryTrimmable {
    private final String f7615a;
    private final String f7616b;
    private final MemoryTrimmableRegistry f7617c;
    private final AbstractFbErrorReporter f7618d;

    public BaseSyndicatedListenableCache(@Nullable Comparator<V> comparator, AndroidThreadUtil androidThreadUtil, String str, String str2, MemoryTrimmableRegistry memoryTrimmableRegistry, FbErrorReporter fbErrorReporter) {
        boolean z = true;
        super(comparator, androidThreadUtil);
        Preconditions.checkArgument(!StringUtil.a(str), "Can't have null or empty name");
        this.f7615a = str;
        if (StringUtil.a(str2)) {
            z = false;
        }
        Preconditions.checkArgument(z, "Can't have null or empty id");
        this.f7616b = str2;
        this.f7617c = (MemoryTrimmableRegistry) Preconditions.checkNotNull(memoryTrimmableRegistry);
        this.f7618d = fbErrorReporter;
    }

    public final void mo620g() {
        this.f7617c.a(this);
    }

    public final void m7940a(MemoryTrimType memoryTrimType) {
        m7958d();
    }

    protected final void mo619e() {
        super.mo619e();
        if (m7955c() > 0) {
            this.f7618d.c(this.f7616b, Integer.toString(m7955c()));
        } else {
            this.f7618d.a(this.f7616b);
        }
    }
}
