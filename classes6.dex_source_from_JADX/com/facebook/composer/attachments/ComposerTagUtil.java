package com.facebook.composer.attachments;

import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.photos.base.tagging.Tag;
import com.facebook.tagging.graphql.utils.MentionsUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* compiled from: place_picker_backgrounded */
public class ComposerTagUtil {
    private ComposerTagUtil() {
    }

    public static ImmutableList<ComposerTaggedUser> m11248a(ImmutableList<Tag> immutableList, ImmutableList<ComposerTaggedUser> immutableList2) {
        int i = 0;
        Set hashSet = new HashSet();
        int size = immutableList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            hashSet.add(Long.valueOf(((ComposerTaggedUser) immutableList2.get(i2)).a()));
        }
        Builder builder = ImmutableList.builder();
        builder.b(immutableList2);
        size = immutableList.size();
        while (i < size) {
            Tag tag = (Tag) immutableList.get(i);
            if (!hashSet.contains(Long.valueOf(tag.f12788c))) {
                hashSet.add(Long.valueOf(tag.f12788c));
                ComposerTaggedUser.Builder a = ComposerTaggedUser.a(tag.f12788c);
                a.b = tag.f12787b.i();
                a = a;
                a.c = tag.f12794i;
                builder.c(a.a());
            }
            i++;
        }
        return builder.b();
    }

    public static ImmutableList<ComposerTaggedUser> m11249a(ImmutableSet<Long> immutableSet, ImmutableList<ComposerTaggedUser> immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ComposerTaggedUser composerTaggedUser = (ComposerTaggedUser) immutableList.get(i);
            if (!immutableSet.contains(Long.valueOf(composerTaggedUser.a()))) {
                builder.c(composerTaggedUser);
            }
        }
        return builder.b();
    }

    public static ImmutableList<Long> m11247a(ImmutableList<ComposerTaggedUser> immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            builder.c(Long.valueOf(((ComposerTaggedUser) immutableList.get(i)).a()));
        }
        return builder.b();
    }

    public static ImmutableSet<Long> m11250a(long j, ImmutableList<ComposerTaggedUser> immutableList, GraphQLTextWithEntities graphQLTextWithEntities, ImmutableList<ComposerAttachment> immutableList2) {
        int i = 0;
        Collection hashSet = new HashSet();
        int size = immutableList.size();
        for (int i2 = 0; i2 < size; i2++) {
            hashSet.add(Long.valueOf(((ComposerTaggedUser) immutableList.get(i2)).a()));
        }
        ImmutableSet of = ImmutableSet.of(Integer.valueOf(2645995));
        hashSet.addAll(MentionsUtils.m25499a(graphQLTextWithEntities, of));
        size = immutableList2.size();
        while (i < size) {
            hashSet.addAll(MentionsUtils.m25499a(((ComposerAttachment) immutableList2.get(i)).m11229d(), of));
            i++;
        }
        hashSet.remove(Long.valueOf(j));
        return ImmutableSet.copyOf(hashSet);
    }
}
