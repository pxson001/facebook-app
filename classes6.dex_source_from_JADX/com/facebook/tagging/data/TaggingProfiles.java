package com.facebook.tagging.data;

import android.net.Uri;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.app.module.LocaleMethodAutoProvider;
import com.facebook.search.api.SearchTypeaheadResult;
import com.facebook.search.bootstrap.db.model.EntityDbModel;
import com.facebook.tagging.model.TaggingProfile;
import com.facebook.tagging.model.TaggingProfile.Builder;
import com.facebook.tagging.model.TaggingProfile.Type;
import com.facebook.user.model.Name;
import com.facebook.user.names.NameNormalizer;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: details_buttons */
public class TaggingProfiles {
    private static final Pattern f17383a = Pattern.compile(" +");
    private final Locale f17384b;
    private final NameNormalizer f17385c;

    public static TaggingProfiles m25203b(InjectorLike injectorLike) {
        return new TaggingProfiles(LocaleMethodAutoProvider.b(injectorLike), NameNormalizer.b(injectorLike));
    }

    @Inject
    public TaggingProfiles(Locale locale, NameNormalizer nameNormalizer) {
        this.f17384b = locale;
        this.f17385c = nameNormalizer;
    }

    public final TaggingProfile m25206a(Name name, long j, String str, Type type, String str2, String str3) {
        return m25207a(name, j, str, type, null, str2, str3);
    }

    public static TaggingProfiles m25201a(InjectorLike injectorLike) {
        return m25203b(injectorLike);
    }

    public final TaggingProfile m25205a(Name name, long j, String str, Type type) {
        return m25206a(name, j, str, type, null, "");
    }

    public final TaggingProfile m25207a(Name name, long j, String str, Type type, @Nullable String str2, String str3, String str4) {
        String toLowerCase = name.i().toLowerCase(this.f17384b);
        String a = this.f17385c.a(toLowerCase);
        Builder builder = new Builder();
        builder.f17529a = name;
        builder = builder;
        builder.f17530b = j;
        builder = builder;
        builder.f17531c = m25202a(str);
        builder = builder;
        builder.f17533e = type;
        builder = builder;
        builder.f17532d = str2;
        builder = builder;
        builder.f17534f = toLowerCase;
        Builder builder2 = builder;
        builder2.f17535g = a;
        builder2 = builder2;
        builder2.f17536h = str3;
        builder2 = builder2;
        builder2.f17537i = str4;
        return builder2.m25525j();
    }

    private static String m25202a(String str) {
        if (str == null) {
            return null;
        }
        if (Uri.parse(str).isAbsolute()) {
            return str;
        }
        return null;
    }

    public static Long m25204b(String str) {
        try {
            return Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public final ImmutableList<TaggingProfile> m25208a(List<EntityDbModel> list, String str, String str2, boolean z) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (EntityDbModel entityDbModel : list) {
            String str3 = null;
            Long b = m25204b(entityDbModel.f15706a);
            if (b != null) {
                Builder builder2 = new Builder();
                builder2.f17529a = new Name(entityDbModel.f15707b, null, null);
                Builder builder3 = builder2;
                builder3.f17530b = b.longValue();
                builder3 = builder3;
                builder3.f17531c = entityDbModel.f15722b;
                builder3 = builder3;
                builder3.f17533e = TaggingProfile.m25527a(new GraphQLObjectType(entityDbModel.f15709d));
                builder3 = builder3;
                builder3.f17536h = str;
                builder3 = builder3;
                builder3.f17537i = str2;
                str3 = builder3.m25525j();
            }
            String str4 = str3;
            if (z || str4.m25531d() != Type.UNKNOWN) {
                builder.c(str4);
            }
        }
        return builder.b();
    }

    public final ImmutableList<TaggingProfile> m25209b(List<SearchTypeaheadResult> list, String str, String str2, boolean z) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (SearchTypeaheadResult searchTypeaheadResult : list) {
            Builder builder2 = new Builder();
            builder2.f17529a = new Name(searchTypeaheadResult.f15495k, null, null);
            builder2 = builder2;
            builder2.f17530b = searchTypeaheadResult.f15497m;
            builder2 = builder2;
            builder2.f17531c = searchTypeaheadResult.f15490f.toString();
            builder2 = builder2;
            builder2.f17533e = TaggingProfile.m25526a(searchTypeaheadResult.m23130a());
            builder2 = builder2;
            builder2.f17536h = str;
            builder2 = builder2;
            builder2.f17537i = str2;
            TaggingProfile j = builder2.m25525j();
            if (z || j.f17542e != Type.UNKNOWN) {
                builder.c(j);
            }
        }
        return builder.b();
    }
}
