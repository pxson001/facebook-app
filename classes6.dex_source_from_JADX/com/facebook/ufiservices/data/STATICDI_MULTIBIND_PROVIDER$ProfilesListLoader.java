package com.facebook.ufiservices.data;

import com.facebook.feed.server.PollVotersProfilesListLoader;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: target_profile_pic_url */
public final class STATICDI_MULTIBIND_PROVIDER$ProfilesListLoader implements MultiBindIndexedProvider<ProfilesListLoader>, Provider<Set<ProfilesListLoader>> {
    private final InjectorLike f18005a;

    public STATICDI_MULTIBIND_PROVIDER$ProfilesListLoader(InjectorLike injectorLike) {
        this.f18005a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f18005a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 5;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return PollVotersProfilesListLoader.a(injector);
            case 1:
                return ActorProfilesLoader.m26502a(injector);
            case 2:
                return LikersProfilesLoader.m26512a(injector);
            case 3:
                return ProfilesByIdsLoader.m26517a(injector);
            case 4:
                return SeenByProfilesLoader.m26522a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
