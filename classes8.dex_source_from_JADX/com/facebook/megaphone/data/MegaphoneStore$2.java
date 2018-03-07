package com.facebook.megaphone.data;

import com.facebook.graphql.enums.GraphQLMegaphoneLocation;
import com.facebook.megaphone.fetcher.MegaphoneExtraDataFetcher;
import com.facebook.megaphone.model.MegaphoneWithLayout;
import com.google.common.base.Objects;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: twitter */
public class MegaphoneStore$2 implements FutureCallback {
    final /* synthetic */ String f1296a;
    final /* synthetic */ GraphQLMegaphoneLocation f1297b;
    final /* synthetic */ MegaphoneWithLayout f1298c;
    final /* synthetic */ MegaphoneStore f1299d;

    public MegaphoneStore$2(MegaphoneStore megaphoneStore, String str, GraphQLMegaphoneLocation graphQLMegaphoneLocation, MegaphoneWithLayout megaphoneWithLayout) {
        this.f1299d = megaphoneStore;
        this.f1296a = str;
        this.f1297b = graphQLMegaphoneLocation;
        this.f1298c = megaphoneWithLayout;
    }

    public void onSuccess(Object obj) {
        Object obj2;
        ((MegaphoneExtraDataFetcher) this.f1299d.f.get()).m1531a(this.f1296a, obj);
        MegaphoneExtraDataFetcher megaphoneExtraDataFetcher = (MegaphoneExtraDataFetcher) this.f1299d.f.get();
        if (Objects.equal(this.f1296a, "2322")) {
            Object obj3;
            IdentityGrowthMegaphoneStoryData identityGrowthMegaphoneStoryData = megaphoneExtraDataFetcher.f1303b;
            if (identityGrowthMegaphoneStoryData.f1286a == null || identityGrowthMegaphoneStoryData.f1286a.b().isEmpty() || identityGrowthMegaphoneStoryData.f1286a.a() == 100) {
                obj3 = null;
            } else {
                obj3 = 1;
            }
            obj2 = obj3;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            this.f1299d.a(this.f1297b, this.f1298c, this.f1299d.d.a() + 3600000);
        }
    }

    public void onFailure(Throwable th) {
        this.f1299d.h.a("megaphone", "Failure fetching megaphone extra data for location" + this.f1297b, th);
    }
}
