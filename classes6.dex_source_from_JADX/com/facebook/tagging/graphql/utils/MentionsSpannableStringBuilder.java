package com.facebook.tagging.graphql.utils;

import android.content.res.Resources;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import com.facebook.common.unicode.UTF16Range;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields.Ranges;
import com.facebook.tagging.data.TaggingProfiles;
import com.facebook.tagging.graphql.utils.MentionsUtils.MentionChangeListener;
import com.facebook.tagging.model.HashtagSpan;
import com.facebook.tagging.model.MentionSpan;
import com.facebook.tagging.model.TaggingProfile;
import com.facebook.user.model.Name;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: deltaThreadMuteSettings */
public final class MentionsSpannableStringBuilder extends SpannableStringBuilder {
    private static final Class<?> f17518a = MentionsSpannableStringBuilder.class;
    public MentionChangeListener f17519b;

    /* compiled from: deltaThreadMuteSettings */
    final class C12762 implements Comparator<Ranges> {
        C12762() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((Ranges) obj).c() < ((Ranges) obj2).c() ? -1 : 1;
        }
    }

    public static MentionsSpannableStringBuilder m25490a(final CharSequence charSequence, final Resources resources, final TaggingProfiles taggingProfiles, MentionChangeListener mentionChangeListener) {
        MentionsSpannableStringBuilder mentionsSpannableStringBuilder = new MentionsSpannableStringBuilder();
        C12751 c12751 = new Object(mentionsSpannableStringBuilder) {
            final /* synthetic */ MentionsSpannableStringBuilder f17514a;

            public final void m25488a(int i, int i2, Long l, String str) {
                this.f17514a.append(charSequence.subSequence(i, i2));
                MentionsSpannableStringBuilder.m25493b(this.f17514a, l.longValue(), str, resources, taggingProfiles, null);
            }
        };
        Matcher matcher = Pattern.compile("@\\[(\\d+):(\\d+:)?((\\w|\\s|[-'])+)\\]", 64).matcher(charSequence);
        int i = 0;
        while (matcher.find()) {
            int start = matcher.start();
            matcher.end();
            c12751.m25488a(i, start, Long.valueOf(Long.parseLong(matcher.group(1))), matcher.group(3));
            i = matcher.end();
        }
        mentionsSpannableStringBuilder.append(charSequence.subSequence(i, charSequence.length()));
        mentionsSpannableStringBuilder.f17519b = mentionChangeListener;
        return mentionsSpannableStringBuilder;
    }

    public static MentionsSpannableStringBuilder m25489a(DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields, Resources resources, TaggingProfiles taggingProfiles) {
        int i = 0;
        MentionsSpannableStringBuilder mentionsSpannableStringBuilder = new MentionsSpannableStringBuilder();
        if (!(defaultTextWithEntitiesLongFields == null || defaultTextWithEntitiesLongFields.a() == null)) {
            if (defaultTextWithEntitiesLongFields.b() != null) {
                ArrayList a = Lists.a(defaultTextWithEntitiesLongFields.b());
                Collections.sort(a, new C12762());
                int size = a.size();
                int i2 = 0;
                while (i2 < size) {
                    int i3;
                    Ranges ranges = (Ranges) a.get(i2);
                    if (ranges.a() == null || ranges.a().d() == null) {
                        i3 = i;
                    } else {
                        mentionsSpannableStringBuilder.append(defaultTextWithEntitiesLongFields.a().subSequence(i, ranges.c()));
                        Long a2 = m25491a(ranges.a().d());
                        if (a2 != null) {
                            m25493b(mentionsSpannableStringBuilder, a2.longValue(), defaultTextWithEntitiesLongFields.a().subSequence(ranges.c(), ranges.c() + ranges.b()).toString(), resources, taggingProfiles, ranges.a().b());
                        } else {
                            mentionsSpannableStringBuilder.append(defaultTextWithEntitiesLongFields.a().subSequence(ranges.c(), ranges.c() + ranges.b()));
                        }
                        i3 = ranges.b() + ranges.c();
                    }
                    i2++;
                    i = i3;
                }
            }
            mentionsSpannableStringBuilder.append(defaultTextWithEntitiesLongFields.a().subSequence(i, defaultTextWithEntitiesLongFields.a().length()));
        }
        return mentionsSpannableStringBuilder;
    }

    private static Long m25491a(String str) {
        try {
            return Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static void m25493b(MentionsSpannableStringBuilder mentionsSpannableStringBuilder, long j, String str, Resources resources, TaggingProfiles taggingProfiles, GraphQLObjectType graphQLObjectType) {
        TaggingProfile a = taggingProfiles.m25205a(new Name(null, null, str), j, "", TaggingProfile.m25527a(graphQLObjectType));
        int length = mentionsSpannableStringBuilder.length();
        mentionsSpannableStringBuilder.append(a.f17538a.i());
        MentionSpan mentionSpan = new MentionSpan(resources, a);
        mentionsSpannableStringBuilder.setSpan(mentionSpan, length, mentionsSpannableStringBuilder.length(), 33);
        mentionSpan.m25520a((Editable) mentionsSpannableStringBuilder, length);
    }

    public final SpannableStringBuilder replace(int i, int i2, CharSequence charSequence, int i3, int i4) {
        boolean contains;
        int i5 = 0;
        if (i != i2) {
            contains = subSequence(i, i2).toString().contains(charSequence.subSequence(i3, i4));
        } else {
            contains = false;
        }
        MentionSpan[] mentionSpanArr = (MentionSpan[]) getSpans(i, i2, MentionSpan.class);
        super.replace(i, i2, charSequence, i3, i4);
        int length = mentionSpanArr.length;
        while (i5 < length) {
            mentionSpanArr[i5].m25521a((Editable) this, contains);
            i5++;
        }
        if (this.f17519b != null) {
            this.f17519b.mo1325a();
        }
        return this;
    }

    public final MentionsSpannableStringBuilder m25495a(UTF16Range uTF16Range, Resources resources) {
        setSpan(new HashtagSpan(resources.getColor(2131362915)), uTF16Range.a, uTF16Range.c(), 33);
        return this;
    }

    public final MentionsSpannableStringBuilder m25494a(int i, int i2, TaggingProfile taggingProfile, Resources resources) {
        delete(i, i2);
        insert(i, taggingProfile.f17538a.i());
        MentionSpan mentionSpan = new MentionSpan(resources, taggingProfile);
        setSpan(mentionSpan, i, taggingProfile.f17538a.i().length() + i, 33);
        mentionSpan.m25520a((Editable) this, i);
        if (this.f17519b != null) {
            this.f17519b.mo1325a();
        }
        return this;
    }

    public final boolean m25496a(int i) {
        MentionSpan[] mentionSpanArr = (MentionSpan[]) getSpans(i, i + 1, MentionSpan.class);
        return mentionSpanArr != null && mentionSpanArr.length > 0;
    }
}
