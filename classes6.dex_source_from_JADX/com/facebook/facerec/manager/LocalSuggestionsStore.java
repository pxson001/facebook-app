package com.facebook.facerec.manager;

import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.contacts.graphql.ContactLinkType;
import com.facebook.contacts.graphql.contactprofiletype.ContactProfileType;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.UserIterator;
import com.facebook.contacts.iterator.UserIterators;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.tagging.data.TaggingProfiles;
import com.facebook.tagging.model.TaggingProfile;
import com.facebook.tagging.model.TaggingProfile.Type;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: non_member_section */
public class LocalSuggestionsStore implements IHaveUserData {
    public final DefaultAndroidThreadUtil f9930a;
    public final LoggedInUserSessionManager f9931b;
    public final UserIterators f9932c;
    public final TaggingProfiles f9933d;
    public final AbstractFbErrorReporter f9934e;
    public volatile ImmutableList<TaggingProfile> f9935f = RegularImmutableList.a;
    public volatile Map<String, TaggingProfile> f9936g = Maps.c();

    /* compiled from: non_member_section */
    public class LocalSuggestionsInitRunnable implements Runnable {
        final /* synthetic */ LocalSuggestionsStore f9929a;

        public LocalSuggestionsInitRunnable(LocalSuggestionsStore localSuggestionsStore) {
            this.f9929a = localSuggestionsStore;
        }

        public void run() {
            UserIterator a;
            this.f9929a.f9930a.b();
            if (this.f9929a.f9935f.size() != 0) {
                throw new IllegalStateException("Cannot initialize the local suggestions twice");
            }
            Builder builder = new Builder();
            long j = 0;
            if (this.f9929a.f9931b.b()) {
                User c = this.f9929a.f9931b.c();
                j = Long.parseLong(c.d());
                builder.c(this.f9929a.f9933d.m25205a(c.f(), j, c.x(), Type.SELF));
            }
            long j2 = j;
            try {
                a = this.f9929a.f9932c.a(ContactCursorsQuery.a(ContactProfileType.FACEBOOK_FRIENDS_TYPES, 20));
            } catch (Throwable e) {
                this.f9929a.f9934e.b("LocalSuggestionsStore", "Failed to query top friends; no suggestions", e);
                a = null;
            }
            if (a != null) {
                while (true) {
                    try {
                        User user = (User) a.next();
                        if (user == null) {
                            break;
                        }
                        j = Long.parseLong(user.d());
                        if (j != j2) {
                            TaggingProfile a2 = this.f9929a.f9933d.m25205a(user.f(), j, user.x(), Type.USER);
                            builder.c(a2);
                            this.f9929a.f9936g.put(user.d(), a2);
                        }
                    } finally {
                        a.close();
                    }
                }
            }
            this.f9929a.f9935f = builder.b();
        }
    }

    public static LocalSuggestionsStore m15642b(InjectorLike injectorLike) {
        return new LocalSuggestionsStore(DefaultAndroidThreadUtil.b(injectorLike), LoggedInUserSessionManager.a(injectorLike), UserIterators.a(injectorLike), TaggingProfiles.m25203b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public LocalSuggestionsStore(DefaultAndroidThreadUtil defaultAndroidThreadUtil, LoggedInUserSessionManager loggedInUserSessionManager, UserIterators userIterators, TaggingProfiles taggingProfiles, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f9930a = defaultAndroidThreadUtil;
        this.f9931b = loggedInUserSessionManager;
        this.f9932c = userIterators;
        this.f9933d = taggingProfiles;
        this.f9934e = abstractFbErrorReporter;
    }

    public void clearUserData() {
        this.f9935f = RegularImmutableList.a;
        this.f9936g.clear();
    }

    public final Map<String, List<TaggingProfile>> m15643a(Map<String, List<String>> map) {
        Builder builder = new Builder();
        Builder builder2 = new Builder();
        for (List<String> it : map.values()) {
            for (String str : it) {
                if (!this.f9936g.containsKey(str)) {
                    builder.c(str);
                    builder2.c(ContactProfileType.USER);
                }
            }
        }
        if (builder2.b().size() > 0) {
            UserIterator a = this.f9932c.a(ContactCursorsQuery.b(builder.b()).d(ContactLinkType.USERS));
            while (a.hasNext()) {
                try {
                    User user = (User) a.next();
                    if (user != null) {
                        String d = user.d();
                        this.f9936g.put(d, this.f9933d.m25205a(user.f(), Long.parseLong(d), user.x(), Type.USER));
                    }
                } finally {
                    a.close();
                }
            }
        }
        Map<String, List<TaggingProfile>> c = Maps.c();
        for (String str2 : map.keySet()) {
            List a2 = Lists.a();
            for (String str3 : (List) map.get(str2)) {
                TaggingProfile taggingProfile = (TaggingProfile) this.f9936g.get(str3);
                if (taggingProfile != null) {
                    a2.add(taggingProfile);
                } else {
                    BLog.b("LocalSuggestionsStore", "Could not find local metadata for friend with FBID = " + str3);
                }
            }
            c.put(str2, a2);
        }
        return c;
    }
}
