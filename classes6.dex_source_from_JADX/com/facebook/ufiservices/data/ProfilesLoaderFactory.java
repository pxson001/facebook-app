package com.facebook.ufiservices.data;

import com.facebook.inject.Lazy;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: dafe3ac143653926b537df678c88d499 */
public class ProfilesLoaderFactory {
    public Lazy<Set<ProfilesListLoader>> f18004a;

    @Inject
    public ProfilesLoaderFactory(Lazy<Set<ProfilesListLoader>> lazy) {
        this.f18004a = lazy;
    }
}
