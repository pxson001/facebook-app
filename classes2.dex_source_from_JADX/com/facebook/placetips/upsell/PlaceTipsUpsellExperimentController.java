package com.facebook.placetips.upsell;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.placetips.upsell.abtest.ExperimentsForPlaceTipsUpsellAbtestModule;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: marauder_network_retry_logic */
public class PlaceTipsUpsellExperimentController {
    public final ImmutableList<? extends Supplier<UpsellPageConfig>> f15108a = ImmutableList.of(new C06591(this), new C06602(this));
    public final QeAccessor f15109b;
    public final Provider<PlaceTipsUpsellBuilder> f15110c;

    /* compiled from: marauder_network_retry_logic */
    class C06591 implements Supplier<UpsellPageConfig> {
        final /* synthetic */ PlaceTipsUpsellExperimentController f15111a;

        C06591(PlaceTipsUpsellExperimentController placeTipsUpsellExperimentController) {
            this.f15111a = placeTipsUpsellExperimentController;
        }

        public Object get() {
            String a = this.f15111a.f15109b.mo581a(ExperimentsForPlaceTipsUpsellAbtestModule.j, null);
            if (a == null) {
                return null;
            }
            return new UpsellPageConfig(UpsellPage.fromId(a), this.f15111a.f15109b.mo581a(ExperimentsForPlaceTipsUpsellAbtestModule.m, null), this.f15111a.f15109b.mo581a(ExperimentsForPlaceTipsUpsellAbtestModule.g, null), this.f15111a.f15109b.mo581a(ExperimentsForPlaceTipsUpsellAbtestModule.h, null), this.f15111a.f15109b.mo581a(ExperimentsForPlaceTipsUpsellAbtestModule.i, null), this.f15111a.f15109b.mo581a(ExperimentsForPlaceTipsUpsellAbtestModule.l, null), this.f15111a.f15109b.mo581a(ExperimentsForPlaceTipsUpsellAbtestModule.k, null));
        }
    }

    /* compiled from: marauder_network_retry_logic */
    class C06602 implements Supplier<UpsellPageConfig> {
        final /* synthetic */ PlaceTipsUpsellExperimentController f15112a;

        C06602(PlaceTipsUpsellExperimentController placeTipsUpsellExperimentController) {
            this.f15112a = placeTipsUpsellExperimentController;
        }

        public Object get() {
            String a = this.f15112a.f15109b.mo581a(ExperimentsForPlaceTipsUpsellAbtestModule.q, null);
            if (a == null) {
                return null;
            }
            return new UpsellPageConfig(UpsellPage.fromId(a), this.f15112a.f15109b.mo581a(ExperimentsForPlaceTipsUpsellAbtestModule.t, null), this.f15112a.f15109b.mo581a(ExperimentsForPlaceTipsUpsellAbtestModule.n, null), this.f15112a.f15109b.mo581a(ExperimentsForPlaceTipsUpsellAbtestModule.o, null), this.f15112a.f15109b.mo581a(ExperimentsForPlaceTipsUpsellAbtestModule.p, null), this.f15112a.f15109b.mo581a(ExperimentsForPlaceTipsUpsellAbtestModule.s, null), this.f15112a.f15109b.mo581a(ExperimentsForPlaceTipsUpsellAbtestModule.r, null));
        }
    }

    public static PlaceTipsUpsellExperimentController m21648b(InjectorLike injectorLike) {
        return new PlaceTipsUpsellExperimentController(QeInternalImplMethodAutoProvider.m3744a(injectorLike), IdBasedProvider.m1811a(injectorLike, 9619));
    }

    @Inject
    public PlaceTipsUpsellExperimentController(QeAccessor qeAccessor, Provider<PlaceTipsUpsellBuilder> provider) {
        this.f15109b = qeAccessor;
        this.f15110c = provider;
    }

    public final boolean m21649a() {
        return this.f15109b.mo596a(ExperimentsForPlaceTipsUpsellAbtestModule.c, false);
    }

    public final int m21650c() {
        return this.f15109b.mo572a(ExperimentsForPlaceTipsUpsellAbtestModule.v, 0);
    }
}
