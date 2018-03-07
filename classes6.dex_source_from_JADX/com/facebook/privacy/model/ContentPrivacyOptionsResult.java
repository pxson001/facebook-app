package com.facebook.privacy.model;

import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsForComposer;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: feedback_text */
public final class ContentPrivacyOptionsResult {
    public final ImmutableList<GraphQLPrivacyOption> f15071a;
    public final ImmutableList<GraphQLPrivacyOption> f15072b;
    public final GraphQLPrivacyOption f15073c;
    public final boolean f15074d;

    /* compiled from: feedback_text */
    public class Builder {
        private ImmutableList<GraphQLPrivacyOption> f15067a;
        private ImmutableList<GraphQLPrivacyOption> f15068b;
        private GraphQLPrivacyOption f15069c;
        private boolean f15070d;

        public Builder(ContentPrivacyOptionsResult contentPrivacyOptionsResult) {
            this.f15067a = contentPrivacyOptionsResult.f15071a;
            this.f15068b = contentPrivacyOptionsResult.f15072b;
            this.f15069c = contentPrivacyOptionsResult.f15073c;
        }

        public final Builder m22631a(GraphQLPrivacyOption graphQLPrivacyOption) {
            Preconditions.checkArgument(PrivacyOptionsResultFactory.a(graphQLPrivacyOption));
            if (PrivacyOptionHelper.a(this.f15067a, graphQLPrivacyOption) || PrivacyOptionHelper.a(this.f15068b, graphQLPrivacyOption)) {
                this.f15070d = false;
            } else {
                this.f15070d = true;
            }
            this.f15069c = graphQLPrivacyOption;
            return this;
        }

        private GraphQLPrivacyOption m22629a(String str) {
            int i;
            int i2 = 0;
            int size = this.f15067a.size();
            for (i = 0; i < size; i++) {
                GraphQLPrivacyOption graphQLPrivacyOption = (GraphQLPrivacyOption) this.f15067a.get(i);
                if (graphQLPrivacyOption.c().equals(str)) {
                    return graphQLPrivacyOption;
                }
            }
            i = this.f15068b.size();
            while (i2 < i) {
                graphQLPrivacyOption = (GraphQLPrivacyOption) this.f15068b.get(i2);
                if (graphQLPrivacyOption.c().equals(str)) {
                    return graphQLPrivacyOption;
                }
                i2++;
            }
            return null;
        }

        public final Builder m22632b(GraphQLPrivacyOption graphQLPrivacyOption) {
            Preconditions.checkArgument(PrivacyOptionsResultFactory.a(graphQLPrivacyOption));
            GraphQLPrivacyOption a = m22629a(graphQLPrivacyOption.c());
            if (a == null) {
                throw new IllegalArgumentException("Selected option not found");
            }
            this.f15069c = a;
            this.f15070d = false;
            return this;
        }

        public final Builder m22630a() {
            GraphQLPrivacyOption a = m22629a("{\"value\":\"EVERYONE\"}");
            if (a == null) {
                a = m22629a("{\"value\":\"FRIENDS_OF_FRIENDS\"}");
            }
            if (a != null) {
                this.f15069c = a;
                this.f15070d = false;
            }
            return this;
        }

        public final ContentPrivacyOptionsResult m22633b() {
            ImmutableList immutableList = this.f15067a;
            if (this.f15070d) {
                immutableList = ImmutableList.builder().b(this.f15067a).c(this.f15069c).b();
            }
            return new ContentPrivacyOptionsResult(immutableList, this.f15068b, this.f15069c, this.f15070d);
        }
    }

    public ContentPrivacyOptionsResult(ImmutableList<GraphQLPrivacyOption> immutableList, ImmutableList<GraphQLPrivacyOption> immutableList2, GraphQLPrivacyOption graphQLPrivacyOption, boolean z) {
        int i;
        GraphQLPrivacyOption graphQLPrivacyOption2;
        this.f15071a = immutableList;
        this.f15072b = immutableList2;
        int i2 = 0;
        int size = this.f15071a.size();
        for (i = 0; i < size; i++) {
            graphQLPrivacyOption2 = (GraphQLPrivacyOption) this.f15071a.get(i);
            if (PrivacyOptionHelper.a(graphQLPrivacyOption2, graphQLPrivacyOption)) {
                break;
            }
        }
        i = this.f15072b.size();
        while (i2 < i) {
            graphQLPrivacyOption2 = (GraphQLPrivacyOption) this.f15072b.get(i2);
            if (PrivacyOptionHelper.a(graphQLPrivacyOption2, graphQLPrivacyOption)) {
                break;
            }
            i2++;
        }
        graphQLPrivacyOption2 = null;
        this.f15073c = graphQLPrivacyOption2;
        this.f15074d = z;
    }

    public static Builder m22634a(ContentPrivacyOptionsResult contentPrivacyOptionsResult) {
        return new Builder(contentPrivacyOptionsResult);
    }

    public static ContentPrivacyOptionsResult m22635a(PrivacyOptionsResult privacyOptionsResult) {
        if (privacyOptionsResult == null) {
            return null;
        }
        return new ContentPrivacyOptionsResult(privacyOptionsResult.basicPrivacyOptions, privacyOptionsResult.friendListPrivacyOptions, privacyOptionsResult.selectedPrivacyOption, false);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContentPrivacyOptionsResult)) {
            return false;
        }
        ContentPrivacyOptionsResult contentPrivacyOptionsResult = (ContentPrivacyOptionsResult) obj;
        if (this.f15071a.size() != contentPrivacyOptionsResult.f15071a.size()) {
            return false;
        }
        int i;
        for (i = 0; i < this.f15071a.size(); i++) {
            if (!PrivacyOptionHelper.a((PrivacyOptionFieldsForComposer) this.f15071a.get(i), (PrivacyOptionFieldsForComposer) contentPrivacyOptionsResult.f15071a.get(i))) {
                return false;
            }
        }
        if (this.f15072b.size() != contentPrivacyOptionsResult.f15072b.size()) {
            return false;
        }
        for (i = 0; i < this.f15072b.size(); i++) {
            if (!PrivacyOptionHelper.a((PrivacyOptionFieldsForComposer) this.f15072b.get(i), (PrivacyOptionFieldsForComposer) contentPrivacyOptionsResult.f15072b.get(i))) {
                return false;
            }
        }
        if (PrivacyOptionHelper.a(this.f15073c, contentPrivacyOptionsResult.f15073c) && this.f15074d == contentPrivacyOptionsResult.f15074d) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(new Object[]{Integer.valueOf(this.f15071a.size()), Integer.valueOf(this.f15072b.size())});
    }

    public final String toString() {
        return Objects.toStringHelper(ContentPrivacyOptionsResult.class).add("basicPrivacyOptions", this.f15071a).add("friendListOptions", this.f15072b).add("selectedPrivacyOption", this.f15073c).add("showTagExpansionOption", this.f15074d).toString();
    }
}
