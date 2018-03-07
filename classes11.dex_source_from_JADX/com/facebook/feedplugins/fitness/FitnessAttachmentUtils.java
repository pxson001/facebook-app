package com.facebook.feedplugins.fitness;

import android.location.Location;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: didReceiveNetworkData */
public class FitnessAttachmentUtils {
    private final QeAccessor f7611a;

    public static FitnessAttachmentUtils m8837b(InjectorLike injectorLike) {
        return new FitnessAttachmentUtils((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FitnessAttachmentUtils(QeAccessor qeAccessor) {
        this.f7611a = qeAccessor;
    }

    public static ImmutableList<Location> m8835a(ImmutableList<GraphQLLocation> immutableList, int i) {
        float size;
        Builder builder = ImmutableList.builder();
        if (immutableList.size() > i) {
            size = ((float) immutableList.size()) / ((float) (i - 1));
        } else {
            size = 1.0f;
        }
        for (float f = 0.0f; f < ((float) (immutableList.size() - 1)); f += size) {
            builder.c(GraphQLHelper.a((GraphQLLocation) immutableList.get((int) f)));
        }
        builder.c(GraphQLHelper.a((GraphQLLocation) immutableList.get(immutableList.size() - 1)));
        return builder.b();
    }

    public static boolean m8836a(Location location, Location location2) {
        float[] fArr = new float[1];
        Location.distanceBetween(location.getLatitude(), location.getLongitude(), location2.getLatitude(), location2.getLongitude(), fArr);
        return Math.abs(fArr[0]) < 100.0f;
    }

    public final boolean m8838a() {
        return this.f7611a.a(ExperimentsForFitnessModule.f7600a, false);
    }
}
