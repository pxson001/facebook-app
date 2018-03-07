package com.facebook.search.bootstrap.db.model;

import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: experiment_group */
public class EntityDbModel extends BootstrapDbModel {
    public final String f15721a;
    public final String f15722b;
    public final boolean f15723c;
    public final boolean f15724d;
    public final boolean f15725e;

    /* compiled from: experiment_group */
    public class Builder {
        public boolean f15711a;
        public String f15712b;
        public String f15713c;
        public String f15714d;
        public String f15715e;
        public String f15716f;
        public String f15717g;
        public boolean f15718h;
        public String f15719i;
        public boolean f15720j;

        public final EntityDbModel m23424k() {
            return new EntityDbModel(this);
        }
    }

    public static Builder m23425j() {
        return new Builder();
    }

    public EntityDbModel(Builder builder) {
        super(builder.f15712b, builder.f15713c, builder.f15715e, builder.f15717g, builder.f15719i);
        this.f15721a = builder.f15714d;
        this.f15722b = builder.f15716f;
        this.f15723c = builder.f15718h;
        this.f15724d = builder.f15711a;
        this.f15725e = builder.f15720j;
    }
}
