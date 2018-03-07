package com.facebook.facecastdisplay;

import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: submission of inline feed survey response failed */
public class FacecastUtil {
    public final GatekeeperStoreImpl f2822a;
    public final Product f2823b;

    public static FacecastUtil m3107b(InjectorLike injectorLike) {
        return new FacecastUtil(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), ProductMethodAutoProvider.b(injectorLike));
    }

    public static FacecastUtil m3105a(InjectorLike injectorLike) {
        return m3107b(injectorLike);
    }

    @Inject
    public FacecastUtil(GatekeeperStoreImpl gatekeeperStoreImpl, Product product) {
        this.f2822a = gatekeeperStoreImpl;
        this.f2823b = product;
    }

    public final int m3108a(boolean z) {
        if (this.f2822a.a(596, false)) {
            if (z) {
                return 2130839964;
            }
            return 2130839965;
        } else if (z) {
            return 2130839966;
        } else {
            return 2130839967;
        }
    }

    public final boolean m3109a() {
        return this.f2822a.a(592, false);
    }

    public final boolean m3110b() {
        return this.f2822a.a(575, false);
    }

    public final boolean m3111c() {
        return this.f2822a.a(594, false);
    }

    public final boolean m3112d() {
        return this.f2822a.a(597, false);
    }

    public final boolean m3113h() {
        return this.f2822a.a(473, false);
    }

    public final boolean m3114j() {
        return this.f2822a.a(570, false);
    }

    public final boolean m3115k() {
        return this.f2822a.a(571, false);
    }

    public final boolean m3116l() {
        return this.f2822a.a(577, false);
    }

    public final boolean m3117m() {
        return this.f2822a.a(1060, false);
    }

    public final boolean m3118o() {
        return this.f2822a.a(581, false);
    }

    public static boolean m3106a(GraphQLVideoBroadcastStatus graphQLVideoBroadcastStatus) {
        return graphQLVideoBroadcastStatus == GraphQLVideoBroadcastStatus.LIVE_STOPPED || graphQLVideoBroadcastStatus == GraphQLVideoBroadcastStatus.SEAL_STARTED;
    }

    public final boolean m3119q() {
        return this.f2822a.a(573, false) && this.f2823b != Product.PAA;
    }

    public final boolean m3120s() {
        return this.f2822a.a(576, false);
    }

    public final boolean m3121u() {
        return this.f2822a.a(584, false);
    }

    public final boolean m3122w() {
        return this.f2822a.a(601, false);
    }

    public final boolean m3123x() {
        return this.f2822a.a(595, false);
    }

    public final boolean m3124y() {
        return this.f2822a.a(583, false);
    }
}
