package com.facebook.composer.metatext;

import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import javax.annotation.Nullable;

/* compiled from: transliteration/ */
public class MetaTextModel {
    public static final Function<FacebookProfile, String> f1313e = new C01151();
    public final CharSequence f1314a;
    public final MinutiaeObject f1315b;
    public final ImmutableList<FacebookProfile> f1316c;
    public final CheckinPlaceModel f1317d;

    /* compiled from: transliteration/ */
    final class C01151 implements Function<FacebookProfile, String> {
        C01151() {
        }

        @Nullable
        public final Object apply(@Nullable Object obj) {
            return ((FacebookProfile) obj).mDisplayName;
        }

        public final boolean equals(@Nullable Object obj) {
            return false;
        }
    }

    /* compiled from: transliteration/ */
    public class Builder {
        public CharSequence f1309a;
        public MinutiaeObject f1310b;
        public ImmutableList<FacebookProfile> f1311c;
        public CheckinPlaceModel f1312d;

        public final MetaTextModel m1384a() {
            return new MetaTextModel(this);
        }
    }

    public MetaTextModel(Builder builder) {
        this.f1314a = builder.f1309a;
        this.f1315b = builder.f1310b;
        this.f1316c = builder.f1311c;
        this.f1317d = builder.f1312d;
    }

    public final boolean m1385a(MetaTextModel metaTextModel) {
        if (this == metaTextModel) {
            return true;
        }
        if (metaTextModel == null || getClass() != metaTextModel.getClass()) {
            return false;
        }
        boolean z;
        if (this.f1314a == metaTextModel.f1314a) {
            z = true;
        } else if (this.f1314a == null || metaTextModel.f1314a == null) {
            z = false;
        } else {
            z = this.f1314a.equals(metaTextModel.f1314a);
        }
        if (z) {
            if (this.f1315b == metaTextModel.f1315b) {
                z = true;
            } else if (this.f1315b == null || metaTextModel.f1315b == null) {
                z = false;
            } else {
                z = this.f1315b.b(metaTextModel.f1315b);
            }
            if (z) {
                if (this.f1316c == metaTextModel.f1316c) {
                    z = true;
                } else if (this.f1316c == null || metaTextModel.f1316c == null) {
                    z = false;
                } else {
                    z = Sets.b(Lists.a(this.f1316c, f1313e)).equals(Sets.b(Lists.a(metaTextModel.f1316c, f1313e)));
                }
                if (z) {
                    if (this.f1317d == metaTextModel.f1317d) {
                        z = true;
                    } else if (this.f1317d == null || metaTextModel.f1317d == null) {
                        z = false;
                    } else {
                        z = this.f1317d.j().equals(metaTextModel.f1317d.j());
                    }
                    if (z) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
