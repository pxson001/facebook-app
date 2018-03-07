package com.facebook.ui.typeahead;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableBiMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: extra_topic_id */
public class TypeaheadRequest {
    public static final TypeaheadRequest f15457a = new TypeaheadRequest("", "", RegularImmutableBiMap.a);
    public final String f15458b;
    public final String f15459c;
    public final ImmutableMap<String, Object> f15460d;

    /* compiled from: extra_topic_id */
    public class Builder {
        protected String f15446a;
        protected String f15447b = "";
        protected com.google.common.collect.ImmutableMap.Builder<String, Object> f15448c = ImmutableMap.builder();
        final /* synthetic */ TypeaheadRequest f15449d;

        public Builder(TypeaheadRequest typeaheadRequest, TypeaheadRequest typeaheadRequest2) {
            this.f15449d = typeaheadRequest;
            Preconditions.checkNotNull(typeaheadRequest2);
            Preconditions.checkNotNull(typeaheadRequest2.f15458b);
            Preconditions.checkNotNull(typeaheadRequest2.f15459c);
            Preconditions.checkNotNull(typeaheadRequest2.f15460d);
            this.f15446a = typeaheadRequest2.f15458b;
            this.f15447b = typeaheadRequest2.f15459c;
            this.f15448c.a(typeaheadRequest2.f15460d);
        }

        public final Builder m23081a(Map<String, Object> map) {
            this.f15448c.a(map);
            return this;
        }

        public TypeaheadRequest mo1223a() {
            return new TypeaheadRequest(this);
        }
    }

    public TypeaheadRequest(String str) {
        this(str, "", RegularImmutableBiMap.a);
    }

    public TypeaheadRequest(Builder builder) {
        this.f15458b = builder.f15446a;
        this.f15459c = builder.f15447b;
        this.f15460d = builder.f15448c.b();
    }

    protected TypeaheadRequest(String str, @Nullable String str2, ImmutableMap<String, Object> immutableMap) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(immutableMap);
        this.f15458b = str.toLowerCase(Locale.getDefault());
        this.f15459c = str2;
        this.f15460d = immutableMap;
    }

    public boolean mo1224a() {
        return false;
    }

    public boolean mo1225b() {
        return true;
    }

    public boolean equals(Object obj) {
        return (obj instanceof TypeaheadRequest) && ((TypeaheadRequest) obj).f15458b.equals(this.f15458b) && ((TypeaheadRequest) obj).f15459c.equals(this.f15459c);
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f15458b, this.f15459c});
    }

    public Builder mo1226c() {
        return new Builder(this, this);
    }
}
