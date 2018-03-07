package com.facebook.search.bootstrap.db.model;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: exit_collection_opened */
public class KeywordDbModel extends BootstrapDbModel {
    @Nullable
    public String f15733a;
    @Nullable
    public final String f15734b;
    @Nullable
    public final String f15735c;

    /* compiled from: exit_collection_opened */
    public class Builder {
        public String f15726a;
        @Nullable
        public String f15727b;
        @Nullable
        public String f15728c;
        @Nullable
        public String f15729d;
        public String f15730e;
        public String f15731f;
        @Nullable
        public String f15732g;
    }

    public KeywordDbModel(Builder builder) {
        super(builder.f15726a, builder.f15726a, builder.f15728c, builder.f15730e, builder.f15731f);
        this.f15733a = builder.f15727b;
        this.f15734b = builder.f15729d;
        this.f15735c = builder.f15732g;
    }
}
