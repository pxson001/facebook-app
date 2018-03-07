package com.facebook.friendsharing.souvenirs.manager;

import com.facebook.friendsharing.souvenirs.models.SouvenirModel;
import com.google.common.primitives.Longs;
import java.util.Comparator;

/* compiled from: RUN_JS_BUNDLE_START */
final class SouvenirManager$2 implements Comparator<SouvenirModel> {
    SouvenirManager$2() {
    }

    public final int compare(Object obj, Object obj2) {
        return Longs.a(((SouvenirModel) obj2).a().m26171c(), ((SouvenirModel) obj).a().m26171c());
    }
}
