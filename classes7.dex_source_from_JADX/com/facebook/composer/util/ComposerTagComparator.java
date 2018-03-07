package com.facebook.composer.util;

import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: tapped_friends_here_now */
public class ComposerTagComparator<DataProvider extends ProvidesConfiguration & ProvidesLocationInfo & ProvidesTaggedUsers & ProvidesMinutiae> {
    private final WeakReference<DataProvider> f2113a;

    @Inject
    public ComposerTagComparator(@Assisted DataProvider dataProvider) {
        this.f2113a = new WeakReference(Preconditions.checkNotNull(dataProvider));
    }

    public final boolean m2083a() {
        ProvidesConfiguration providesConfiguration = (ProvidesConfiguration) Preconditions.checkNotNull(this.f2113a.get());
        MinutiaeObject minutiaeObjectTag = providesConfiguration.o().getMinutiaeObjectTag();
        MinutiaeObject l = ((ProvidesMinutiae) providesConfiguration).l();
        if (minutiaeObjectTag == l) {
            return false;
        }
        if (minutiaeObjectTag == null || l == null) {
            return true;
        }
        return !minutiaeObjectTag.b(l);
    }

    public final boolean m2084b() {
        ProvidesConfiguration providesConfiguration = (ProvidesConfiguration) Preconditions.checkNotNull(this.f2113a.get());
        return !m2082a(providesConfiguration.o().getInitialTaggedUsers()).equals(m2082a(((ProvidesTaggedUsers) providesConfiguration).h()));
    }

    private static ImmutableSet<Long> m2082a(ImmutableList<ComposerTaggedUser> immutableList) {
        Builder builder = ImmutableSet.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            builder.c(Long.valueOf(((ComposerTaggedUser) immutableList.get(i)).a()));
        }
        return builder.b();
    }

    public final boolean m2085c() {
        ProvidesConfiguration providesConfiguration = (ProvidesConfiguration) Preconditions.checkNotNull(this.f2113a.get());
        CheckinPlaceModel a = providesConfiguration.o().getInitialLocationInfo().a();
        CheckinPlaceModel a2 = ((ProvidesLocationInfo) providesConfiguration).g().a();
        if (a == a2) {
            return false;
        }
        if (a == null || a2 == null) {
            return true;
        }
        return !a.cf_().equals(a2.cf_());
    }
}
