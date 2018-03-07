package com.facebook.contacts.graphql;

import com.facebook.contacts.graphql.ContactGraphQL.FetchContactsDeltaQueryString;
import com.facebook.contacts.graphql.ContactGraphQL.FetchContactsFullQueryString;
import com.facebook.contacts.graphql.ContactGraphQL.FetchContactsFullWithAfterQueryString;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: reused_distance */
public final class GraphQLContactsQueryBuilder {
    private final ContactsGraphQlParams f3362a;

    /* compiled from: reused_distance */
    public enum QueryType {
        FULL,
        DELTA
    }

    public static GraphQLContactsQueryBuilder m3593b(InjectorLike injectorLike) {
        return new GraphQLContactsQueryBuilder(ContactsGraphQlParams.m3484b(injectorLike));
    }

    @Inject
    public GraphQLContactsQueryBuilder(ContactsGraphQlParams contactsGraphQlParams) {
        this.f3362a = contactsGraphQlParams;
    }

    public final GraphQlQueryString m3594a(int i, String str, QueryType queryType) {
        GraphQlQueryString graphQlQueryString;
        if (queryType == QueryType.DELTA) {
            Preconditions.checkArgument(str != null);
            graphQlQueryString = (FetchContactsDeltaQueryString) new FetchContactsDeltaQueryString().a("limit", Integer.toString(i));
            if (str != null) {
                graphQlQueryString.a("after", str);
            }
            this.f3362a.m3486b(graphQlQueryString);
            this.f3362a.m3485a(graphQlQueryString);
            return graphQlQueryString.b(true);
        } else if (str != null) {
            graphQlQueryString = (FetchContactsFullWithAfterQueryString) new FetchContactsFullWithAfterQueryString().a("limit", Integer.toString(i));
            graphQlQueryString.a("after", str);
            this.f3362a.m3486b(graphQlQueryString);
            this.f3362a.m3485a(graphQlQueryString);
            return graphQlQueryString.b(true);
        } else {
            graphQlQueryString = (FetchContactsFullQueryString) new FetchContactsFullQueryString().a("limit", Integer.toString(i));
            this.f3362a.m3486b(graphQlQueryString);
            this.f3362a.m3485a(graphQlQueryString);
            return graphQlQueryString.b(true);
        }
    }
}
