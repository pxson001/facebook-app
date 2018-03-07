package com.facebook.tagging.graphql.data;

import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tagging.data.TagTypeaheadDataSource;
import com.facebook.tagging.data.TagTypeaheadDataSource.TagTypeaheadDataType;
import com.facebook.tagging.data.TaggingProfiles;
import com.facebook.tagging.model.TaggingProfile;
import com.facebook.tagging.model.TaggingProfile.Type;
import com.facebook.user.model.Name;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: destination must not be null */
public class CommentTaggingDataSource extends TagTypeaheadDataSource {
    public final Provider<String> f17400a;
    public final TaggingProfiles f17401b;
    public List<TaggingProfile> f17402c = Lists.a();

    public static CommentTaggingDataSource m25219b(InjectorLike injectorLike) {
        return new CommentTaggingDataSource(IdBasedProvider.a(injectorLike, 4443), TaggingProfiles.m25203b(injectorLike));
    }

    @Inject
    public CommentTaggingDataSource(Provider<String> provider, TaggingProfiles taggingProfiles) {
        this.f17400a = provider;
        this.f17401b = taggingProfiles;
    }

    public static CommentTaggingDataSource m25218a(InjectorLike injectorLike) {
        return m25219b(injectorLike);
    }

    public final List<TaggingProfile> mo1318a(CharSequence charSequence, boolean z, boolean z2, boolean z3, boolean z4) {
        List<TaggingProfile> list = this.f17402c;
        ArrayList a = Lists.a();
        for (TaggingProfile taggingProfile : list) {
            if ((z || taggingProfile.f17542e != Type.SELF) && ((z2 || taggingProfile.f17542e != Type.USER) && ((z3 || taggingProfile.f17542e != Type.PAGE) && (z4 || taggingProfile.f17542e != Type.TEXT)))) {
                a.add(taggingProfile);
            }
        }
        return a;
    }

    public final String mo1316b() {
        return "comments";
    }

    public final ImmutableList<String> mo1319d() {
        Builder builder = new Builder();
        builder.c(TagTypeaheadDataType.COMMENT_AUTHORS.toString());
        return builder.b();
    }

    public final void m25221a(GraphQLFeedback graphQLFeedback) {
        if (graphQLFeedback != null) {
            this.f17402c.clear();
            for (int i = 0; i < GraphQLHelper.g(graphQLFeedback); i++) {
                GraphQLActor r = GraphQLHelper.a(graphQLFeedback, i).r();
                if (!(r == null || r.aa() == null || r.H() == null)) {
                    String str;
                    Type a;
                    List list = this.f17402c;
                    TaggingProfiles taggingProfiles = this.f17401b;
                    Name name = new Name(null, null, r.aa());
                    long parseLong = Long.parseLong(r.H());
                    if (r.ai() == null) {
                        str = null;
                    } else {
                        str = r.ai().b();
                    }
                    String str2 = (String) this.f17400a.get();
                    if (str2 == null || !str2.equals(r.H())) {
                        a = TaggingProfile.m25527a(r.b());
                    } else {
                        a = Type.SELF;
                    }
                    list.add(taggingProfiles.m25207a(name, parseLong, str, a, null, "comments", TagTypeaheadDataType.COMMENT_AUTHORS.toString()));
                }
            }
            this.f17402c = TaggingProfile.m25528a(this.f17402c);
        }
    }
}
