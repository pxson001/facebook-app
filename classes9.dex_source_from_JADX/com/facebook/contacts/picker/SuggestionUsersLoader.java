package com.facebook.contacts.picker;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.contacts.graphql.contactprofiletype.ContactProfileType;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.UserIterator;
import com.facebook.contacts.iterator.UserIterators;
import com.facebook.inject.InjectorLike;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: postComposerEvent */
public class SuggestionUsersLoader {
    private static final Class<?> f6491a = SuggestionUsersLoader.class;
    private final SuggestionsCache f6492b;
    private final UserIterators f6493c;
    private final DefaultAndroidThreadUtil f6494d;
    public final ListeningExecutorService f6495e;

    /* compiled from: postComposerEvent */
    public class C06701 implements Callable<ImmutableList<User>> {
        final /* synthetic */ ImmutableList f6489a;
        final /* synthetic */ SuggestionUsersLoader f6490b;

        public C06701(SuggestionUsersLoader suggestionUsersLoader, ImmutableList immutableList) {
            this.f6490b = suggestionUsersLoader;
            this.f6489a = immutableList;
        }

        public Object call() {
            return this.f6490b.m6844a(this.f6489a);
        }
    }

    public static SuggestionUsersLoader m6843b(InjectorLike injectorLike) {
        return new SuggestionUsersLoader(SuggestionsCache.a(injectorLike), UserIterators.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SuggestionUsersLoader(SuggestionsCache suggestionsCache, UserIterators userIterators, DefaultAndroidThreadUtil defaultAndroidThreadUtil, ListeningExecutorService listeningExecutorService) {
        this.f6492b = suggestionsCache;
        this.f6493c = userIterators;
        this.f6494d = defaultAndroidThreadUtil;
        this.f6495e = listeningExecutorService;
    }

    public final ImmutableList<User> m6844a(ImmutableList<UserKey> immutableList) {
        Preconditions.checkNotNull(immutableList);
        this.f6494d.b();
        Map a = Maps.a(immutableList.size());
        UserIterator a2 = this.f6493c.a(ContactCursorsQuery.a().c(ContactProfileType.MESSAGABLE_TYPES).e(immutableList));
        while (a2.hasNext()) {
            try {
                User user = (User) a2.next();
                a.put(user.e(), user);
            } finally {
                a2.close();
            }
        }
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            UserKey userKey = (UserKey) immutableList.get(i);
            if (a.containsKey(userKey)) {
                builder.c(a.get(userKey));
            }
        }
        ImmutableList<User> b = builder.b();
        this.f6492b.a(b);
        return b;
    }
}
