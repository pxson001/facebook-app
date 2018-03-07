package com.facebook.tagging.graphql.utils;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.unicode.RangeConverter;
import com.facebook.common.unicode.UTF16Range;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLEntity.Builder;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesEntityFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields.Ranges;
import com.facebook.tagging.model.HashtagSpan;
import com.facebook.tagging.model.MentionSpan;
import com.facebook.tagging.model.MentionSpan.C12781;
import com.facebook.tagging.model.MentionSpan.PartialMentionSpan;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: deltaThreadImage */
public final class MentionsUtils {

    /* compiled from: deltaThreadImage */
    final class C12772 implements Comparator<Ranges> {
        C12772() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((Ranges) obj2).c() - ((Ranges) obj).c();
        }
    }

    /* compiled from: deltaThreadImage */
    public interface MentionChangeListener {
        void mo1325a();
    }

    public static String m25500a(Editable editable) {
        int i = 0;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(editable);
        MentionSpan[] mentionSpanArr = (MentionSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), MentionSpan.class);
        if (mentionSpanArr == null || mentionSpanArr.length == 0) {
            return spannableStringBuilder.toString().trim();
        }
        int length = mentionSpanArr.length;
        while (i < length) {
            MentionSpan mentionSpan = mentionSpanArr[i];
            String str = "@[%d:%s]";
            Long valueOf = Long.valueOf(mentionSpan.m25523b());
            StringBuilder stringBuilder = new StringBuilder();
            int size = mentionSpan.f17528b.size();
            for (int i2 = 0; i2 < size; i2++) {
                stringBuilder.append(((PartialMentionSpan) mentionSpan.f17528b.get(i2)).f17525b);
                stringBuilder.append(' ');
            }
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(mentionSpan), spannableStringBuilder.getSpanEnd(mentionSpan), StringFormatUtil.formatStrLocaleSafe(str, valueOf, stringBuilder.toString().trim()));
            i++;
        }
        return spannableStringBuilder.toString();
    }

    public static List<GraphQLEntityAtRange> m25503b(Editable editable) {
        int length;
        int b;
        int i = 0;
        MentionSpan[] mentionSpanArr = (MentionSpan[]) editable.getSpans(0, editable.length(), MentionSpan.class);
        List<GraphQLEntityAtRange> a = Lists.a();
        if (mentionSpanArr != null) {
            for (MentionSpan mentionSpan : mentionSpanArr) {
                GraphQLObjectType graphQLObjectType;
                int a2 = mentionSpan.mo1323a(editable);
                String valueOf = String.valueOf(mentionSpan.m25523b());
                switch (C12781.f17523a[mentionSpan.f17527a.f17542e.ordinal()]) {
                    case 1:
                        graphQLObjectType = new GraphQLObjectType(2479791);
                        break;
                    default:
                        graphQLObjectType = new GraphQLObjectType(2645995);
                        break;
                }
                a.add(GraphQLHelper.a(GraphQLHelper.a(valueOf, graphQLObjectType), RangeConverter.a(editable.toString(), new UTF16Range(a2, mentionSpan.mo1324b(editable) - a2))));
            }
        }
        HashtagSpan[] hashtagSpanArr = (HashtagSpan[]) editable.getSpans(0, editable.length(), HashtagSpan.class);
        if (hashtagSpanArr != null) {
            length = hashtagSpanArr.length;
            while (i < length) {
                HashtagSpan hashtagSpan = hashtagSpanArr[i];
                int a3 = hashtagSpan.mo1323a(editable);
                b = hashtagSpan.mo1324b(editable);
                if (b - a3 > 1) {
                    String charSequence = editable.subSequence(a3 + 1, b).toString();
                    Builder builder = new Builder();
                    builder.O = charSequence;
                    Builder builder2 = builder;
                    builder2.S = new GraphQLObjectType(-1932766292);
                    a.add(GraphQLHelper.a(builder2.a(), RangeConverter.a(editable.toString(), new UTF16Range(a3, b - a3))));
                }
                i++;
            }
        }
        return a;
    }

    public static String m25501a(DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields) {
        if (defaultTextWithEntitiesLongFields == null || defaultTextWithEntitiesLongFields.a() == null) {
            return null;
        }
        if (defaultTextWithEntitiesLongFields.b() == null) {
            return defaultTextWithEntitiesLongFields.a();
        }
        StringBuilder stringBuilder = new StringBuilder(defaultTextWithEntitiesLongFields.a());
        List<Ranges> a = Lists.a(defaultTextWithEntitiesLongFields.b());
        Collections.sort(a, new C12772());
        for (Ranges ranges : a) {
            if (ranges.a() != null && m25502a(ranges.a(), null)) {
                stringBuilder.replace(ranges.c(), ranges.c() + ranges.b(), "@[" + ranges.a().d() + ":" + defaultTextWithEntitiesLongFields.a().substring(ranges.c(), ranges.b() + ranges.c()) + "]");
            }
        }
        return stringBuilder.toString();
    }

    public static ImmutableList<Long> m25498a(GraphQLTextWithEntities graphQLTextWithEntities) {
        return m25499a(graphQLTextWithEntities, null);
    }

    public static ImmutableList<Long> m25499a(GraphQLTextWithEntities graphQLTextWithEntities, @Nullable ImmutableSet<Integer> immutableSet) {
        if (graphQLTextWithEntities.b() == null) {
            return RegularImmutableList.a;
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList b = graphQLTextWithEntities.b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            GraphQLEntityAtRange graphQLEntityAtRange = (GraphQLEntityAtRange) b.get(i);
            if (graphQLEntityAtRange.j() != null && m25502a(graphQLEntityAtRange.j(), (ImmutableSet) immutableSet)) {
                builder.c(Long.valueOf(Long.parseLong(graphQLEntityAtRange.j().d())));
            }
        }
        return builder.b();
    }

    private static boolean m25502a(DefaultTextWithEntitiesEntityFields defaultTextWithEntitiesEntityFields, @Nullable ImmutableSet<Integer> immutableSet) {
        if (defaultTextWithEntitiesEntityFields.b() == null) {
            return false;
        }
        if (immutableSet != null && !immutableSet.contains(Integer.valueOf(defaultTextWithEntitiesEntityFields.b().g()))) {
            return false;
        }
        switch (defaultTextWithEntitiesEntityFields.b().g()) {
            case 2479791:
            case 2645995:
            case 69076575:
                try {
                    Long.parseLong(defaultTextWithEntitiesEntityFields.d());
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            default:
                return false;
        }
    }
}
