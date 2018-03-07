package com.facebook.search.bootstrap.model;

import android.net.Uri;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPageVerificationBadge;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchException;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: executor_waiting_time */
public class BootstrapEntity {
    public final String f15764a;
    public final String f15765b;
    public final GraphQLObjectType f15766c;
    public final Uri f15767d;
    public final String f15768e;
    public final String f15769f;
    public final boolean f15770g;
    private final GraphQLPageVerificationBadge f15771h;
    public final boolean f15772i;
    public final ImmutableList<String> f15773j;
    public double f15774k;

    /* compiled from: executor_waiting_time */
    public class Builder {
        public String f15753a;
        public String f15754b;
        public GraphQLObjectType f15755c;
        public Uri f15756d;
        public String f15757e;
        public String f15758f;
        public boolean f15759g = false;
        public GraphQLPageVerificationBadge f15760h = GraphQLPageVerificationBadge.NOT_VERIFIED;
        public boolean f15761i = false;
        public ImmutableList<String> f15762j;
        public double f15763k;

        public final Builder m23438a(@Nullable ImmutableList<String> immutableList) {
            if (immutableList == null) {
                immutableList = RegularImmutableList.a;
            }
            this.f15762j = immutableList;
            return this;
        }

        public final BootstrapEntity m23439l() {
            BootstrapEntity bootstrapEntity = new BootstrapEntity(this);
            BootstrapEntity.m23440k(bootstrapEntity);
            return bootstrapEntity;
        }
    }

    public BootstrapEntity(Builder builder) {
        this.f15764a = builder.f15754b;
        this.f15765b = builder.f15753a;
        this.f15766c = builder.f15755c;
        this.f15767d = builder.f15756d;
        this.f15769f = builder.f15758f;
        this.f15768e = builder.f15757e;
        this.f15770g = builder.f15759g;
        this.f15771h = builder.f15760h;
        this.f15772i = builder.f15761i;
        this.f15773j = builder.f15762j;
        this.f15774k = builder.f15763k;
    }

    public static void m23440k(BootstrapEntity bootstrapEntity) {
        if (bootstrapEntity.f15766c == null || bootstrapEntity.f15766c.g() == 0) {
            throw new GraphSearchException(GraphSearchError.BAD_BOOTSTRAP_SUGGESTION, "Missing object type");
        }
        String e = bootstrapEntity.f15766c.e();
        if (Strings.isNullOrEmpty(bootstrapEntity.f15764a)) {
            throw new GraphSearchException(GraphSearchError.BAD_BOOTSTRAP_SUGGESTION, "Missing id for entity of type " + e);
        } else if (Strings.isNullOrEmpty(bootstrapEntity.f15765b)) {
            throw new GraphSearchException(GraphSearchError.BAD_BOOTSTRAP_SUGGESTION, "Missing name for id " + bootstrapEntity.f15764a + " with type " + e);
        } else if (bootstrapEntity.f15774k == -1.0d) {
            throw new GraphSearchException(GraphSearchError.BAD_BOOTSTRAP_SUGGESTION, "Missing costs for id " + bootstrapEntity.f15764a);
        } else if (bootstrapEntity.f15773j.isEmpty()) {
            throw new GraphSearchException(GraphSearchError.BAD_BOOTSTRAP_SUGGESTION, "Missing or empty name search tokens for id " + bootstrapEntity.f15764a);
        } else if (bootstrapEntity.f15767d == null) {
            throw new GraphSearchException(GraphSearchError.BAD_BOOTSTRAP_SUGGESTION, "Missing profile pic uri for id " + bootstrapEntity.f15764a);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof BootstrapEntity) {
            return this.f15764a.equals(((BootstrapEntity) obj).f15764a);
        }
        return false;
    }

    public int hashCode() {
        return this.f15764a.hashCode();
    }

    public String toString() {
        return "BootstrapEntity[" + this.f15765b + "]";
    }
}
