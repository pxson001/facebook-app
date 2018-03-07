package com.facebook.messaging.database.threads;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: me/montage_thread_messages */
public class ContentProviderColumnsMapping {
    private final ImmutableList<ColumnDescriptor> f10429a;
    private final ImmutableMap<String, ColumnDescriptor> f10430b;

    /* compiled from: me/montage_thread_messages */
    public class Builder {
        private final com.google.common.collect.ImmutableList.Builder<ColumnDescriptor> f10425a = ImmutableList.builder();

        public final Builder m11092a(String str, String str2, String str3) {
            this.f10425a.c(new ColumnDescriptor(str, str2, str3));
            return this;
        }

        public final ContentProviderColumnsMapping m11093a() {
            return new ContentProviderColumnsMapping(this.f10425a.b());
        }
    }

    @Immutable
    /* compiled from: me/montage_thread_messages */
    public class ColumnDescriptor {
        public final String f10426a;
        public final String f10427b;
        public final String f10428c;

        public ColumnDescriptor(String str, String str2, String str3) {
            this.f10426a = str;
            this.f10427b = str2;
            this.f10428c = str3;
        }
    }

    ContentProviderColumnsMapping(ImmutableList<ColumnDescriptor> immutableList) {
        this.f10429a = immutableList;
        com.google.common.collect.ImmutableMap.Builder builder = ImmutableMap.builder();
        int size = this.f10429a.size();
        for (int i = 0; i < size; i++) {
            ColumnDescriptor columnDescriptor = (ColumnDescriptor) this.f10429a.get(i);
            builder.b(columnDescriptor.f10426a, columnDescriptor);
        }
        this.f10430b = builder.b();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public final ColumnDescriptor m11094a(String str) {
        return (ColumnDescriptor) this.f10430b.get(str);
    }

    public final ImmutableSet<String> m11095a() {
        return this.f10430b.keySet();
    }
}
