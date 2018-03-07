package com.facebook.messaging.xma;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.inject.Lazy;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAAttachmentStoryFieldsModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: title_annotation */
public class SnippetGenerator {
    private final ImmutableMap<GraphQLStoryAttachmentStyle, Lazy<SnippetCreator>> f1560a;
    private final SnippetCreator f1561b;

    @Inject
    public SnippetGenerator(Set<StyleAssociation> set, SnippetCreator snippetCreator) {
        this.f1561b = snippetCreator;
        Builder builder = ImmutableMap.builder();
        for (StyleAssociation styleAssociation : set) {
            if (!styleAssociation.f1565d) {
                builder.b(styleAssociation.f1562a, styleAssociation.f1564c);
            }
        }
        this.f1560a = builder.b();
    }

    public final String m1738a(SnippetCreatorParams snippetCreatorParams) {
        ImmutableList<GraphQLStoryAttachmentStyle> aN_ = ((XMAAttachmentStoryFieldsModel) Preconditions.checkNotNull(snippetCreatorParams.f1559b.c())).aN_();
        if (aN_ == null) {
            return this.f1561b.mo68a(snippetCreatorParams);
        }
        for (GraphQLStoryAttachmentStyle graphQLStoryAttachmentStyle : aN_) {
            if (this.f1560a.containsKey(graphQLStoryAttachmentStyle)) {
                return ((SnippetCreator) ((Lazy) this.f1560a.get(graphQLStoryAttachmentStyle)).get()).mo68a(snippetCreatorParams);
            }
        }
        return this.f1561b.mo68a(snippetCreatorParams);
    }
}
