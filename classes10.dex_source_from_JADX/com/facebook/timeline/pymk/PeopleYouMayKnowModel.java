package com.facebook.timeline.pymk;

import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.friends.model.PersonYouMayKnow;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import java.util.ArrayList;
import java.util.List;

/* compiled from: fail to fetch commerce store query */
public class PeopleYouMayKnowModel implements CacheableEntity {
    public final ArrayList<PersonYouMayKnow> f12468a;
    public GraphQLPageInfo f12469b;
    private final String f12470c = SafeUUIDGenerator.a().toString();

    public PeopleYouMayKnowModel(List<PersonYouMayKnow> list, GraphQLPageInfo graphQLPageInfo) {
        this.f12468a = new ArrayList(list);
        this.f12469b = graphQLPageInfo;
    }

    public final String m12499g() {
        return this.f12470c;
    }
}
