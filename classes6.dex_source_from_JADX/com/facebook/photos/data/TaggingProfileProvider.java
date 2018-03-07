package com.facebook.photos.data;

import com.facebook.contacts.graphql.ContactLinkType;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.UserIterator;
import com.facebook.contacts.iterator.UserIterators;
import com.facebook.inject.InjectorLike;
import com.facebook.tagging.data.TaggingProfiles;
import com.facebook.tagging.model.TaggingProfile;
import com.facebook.tagging.model.TaggingProfile.Type;
import com.facebook.user.model.Name;
import com.facebook.user.model.User;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import javax.inject.Inject;

/* compiled from: image_overlay_id */
public class TaggingProfileProvider {
    public final ListeningExecutorService f12877a = MoreExecutors.a(Executors.newSingleThreadExecutor());
    private final UserIterators f12878b;
    private final TaggingProfiles f12879c;

    /* compiled from: image_overlay_id */
    public class C08211 implements Callable<Map<String, List<TaggingProfile>>> {
        final /* synthetic */ Map f12873a;
        final /* synthetic */ TaggingProfileProvider f12874b;

        public C08211(TaggingProfileProvider taggingProfileProvider, Map map) {
            this.f12874b = taggingProfileProvider;
            this.f12873a = map;
        }

        public Object call() {
            Collection a = Sets.a();
            for (List addAll : this.f12873a.values()) {
                a.addAll(addAll);
            }
            Map b = TaggingProfileProvider.m20264b(this.f12874b, a);
            Map c = Maps.c();
            for (Entry entry : this.f12873a.entrySet()) {
                List a2 = Lists.a();
                for (String str : (List) entry.getValue()) {
                    if (!Strings.isNullOrEmpty(str)) {
                        a2.add(b.get(str));
                    }
                }
                c.put(entry.getKey(), a2);
            }
            return c;
        }
    }

    /* compiled from: image_overlay_id */
    public class C08222 implements Callable<Map<String, TaggingProfile>> {
        final /* synthetic */ Collection f12875a;
        final /* synthetic */ TaggingProfileProvider f12876b;

        public C08222(TaggingProfileProvider taggingProfileProvider, Collection collection) {
            this.f12876b = taggingProfileProvider;
            this.f12875a = collection;
        }

        public Object call() {
            return TaggingProfileProvider.m20264b(this.f12876b, this.f12875a);
        }
    }

    public static TaggingProfileProvider m20263b(InjectorLike injectorLike) {
        return new TaggingProfileProvider(TaggingProfiles.m25203b(injectorLike), UserIterators.a(injectorLike));
    }

    @Inject
    public TaggingProfileProvider(TaggingProfiles taggingProfiles, UserIterators userIterators) {
        this.f12879c = taggingProfiles;
        this.f12878b = userIterators;
    }

    public static Map m20264b(TaggingProfileProvider taggingProfileProvider, Collection collection) {
        UserIterators userIterators = taggingProfileProvider.f12878b;
        ContactCursorsQuery b = ContactCursorsQuery.b(collection);
        b.b = ContactLinkType.FRIENDS_AND_ME;
        UserIterator a = userIterators.a(b);
        Map c = Maps.c();
        while (a.hasNext()) {
            User user = (User) a.next();
            if (user != null) {
                Name name;
                if (Strings.isNullOrEmpty(user.h()) || Strings.isNullOrEmpty(user.i())) {
                    name = new Name(null, null, user.e.g());
                } else {
                    name = new Name(user.e.a(), user.e.c(), user.e.g());
                }
                c.put(user.a, taggingProfileProvider.f12879c.m25205a(name, Long.parseLong(user.a), user.x(), Type.USER));
            }
        }
        a.close();
        return c;
    }
}
