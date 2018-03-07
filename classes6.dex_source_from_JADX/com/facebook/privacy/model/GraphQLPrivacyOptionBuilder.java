package com.facebook.privacy.model;

import com.facebook.common.json.FbObjectMapper;
import com.facebook.graphql.enums.GraphQLPrivacyOptionTagExpansionType;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLPrivacyAudienceMember;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.model.GraphQLPrivacyOption.Builder;
import com.facebook.graphql.model.GraphQLPrivacyRowInput;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* compiled from: feed_add_photo */
public class GraphQLPrivacyOptionBuilder {
    public final Builder f15088a;
    private final ArrayList<String> f15089b;
    private final ArrayList<String> f15090c;

    public static GraphQLPrivacyOptionBuilder m22662a(GraphQLPrivacyOption graphQLPrivacyOption) {
        return new GraphQLPrivacyOptionBuilder(Builder.a(graphQLPrivacyOption));
    }

    public GraphQLPrivacyOptionBuilder() {
        this(new Builder());
    }

    private GraphQLPrivacyOptionBuilder(Builder builder) {
        this.f15089b = new ArrayList();
        this.f15090c = new ArrayList();
        this.f15088a = (Builder) Preconditions.checkNotNull(builder);
    }

    public final GraphQLPrivacyOptionBuilder m22667a(String str) {
        this.f15089b.add(str);
        return this;
    }

    public final GraphQLPrivacyOptionBuilder m22670b(String str) {
        this.f15090c.add(str);
        return this;
    }

    public final GraphQLPrivacyOptionBuilder m22666a(ImmutableList<GraphQLPrivacyAudienceMember> immutableList) {
        this.f15088a.i = immutableList;
        return this;
    }

    public final GraphQLPrivacyOptionBuilder m22669b(ImmutableList<GraphQLPrivacyAudienceMember> immutableList) {
        this.f15088a.e = immutableList;
        return this;
    }

    public final GraphQLPrivacyOptionBuilder m22665a(@Nullable GraphQLPrivacyRowInput graphQLPrivacyRowInput) {
        this.f15088a.l = graphQLPrivacyRowInput;
        return this;
    }

    public final GraphQLPrivacyOptionBuilder m22671c(ImmutableList<GraphQLPrivacyOptionTagExpansionType> immutableList) {
        this.f15088a.m = immutableList;
        return this;
    }

    public final GraphQLPrivacyOptionBuilder m22663a() {
        if (this.f15088a.m != null && this.f15088a.m.size() > 1) {
            this.f15088a.d = (GraphQLPrivacyOptionTagExpansionType) this.f15088a.m.get(1);
        }
        return this;
    }

    public final GraphQLPrivacyOptionBuilder m22664a(@Nullable GraphQLImage graphQLImage) {
        this.f15088a.g = graphQLImage;
        return this;
    }

    public final GraphQLPrivacyOptionBuilder m22672c(@Nullable String str) {
        this.f15088a.j = str;
        return this;
    }

    public final GraphQLPrivacyOptionBuilder m22673d(@Nullable String str) {
        this.f15088a.k = str;
        return this;
    }

    public final GraphQLPrivacyOption m22668b() {
        GraphQLPrivacyOption a = this.f15088a.a();
        boolean d = PrivacyOptionHelper.d(a);
        if (this.f15089b.isEmpty() && this.f15090c.isEmpty() && !d) {
            return a;
        }
        try {
            PrivacyParameter privacyParameter = (PrivacyParameter) FbObjectMapper.i().a(a.c(), PrivacyParameter.class);
            if (privacyParameter == null) {
                return a;
            }
            this.f15088a.a(FbObjectMapper.i().a(PrivacyParameter.Builder.m22683a(privacyParameter).m22684a(this.f15089b).m22687b(this.f15090c).m22685a(d).m22686a()));
            return this.f15088a.a();
        } catch (IOException e) {
            throw new RuntimeException("Could not construct privacy.");
        }
    }
}
