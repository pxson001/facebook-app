package com.facebook.friendsharing.souvenirs.util;

import android.net.Uri;
import com.facebook.common.util.UriUtil;
import com.facebook.friendsharing.souvenirs.models.SouvenirItem.Type;
import com.facebook.friendsharing.souvenirs.models.SouvenirModel;
import com.facebook.friendsharing.souvenirs.models.SouvenirUriItem;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.io.File;

/* compiled from: REAL */
public class SouvenirModelHelper {
    private static final Predicate<SouvenirUriItem> f24215a = new C21071();
    public static final Predicate<SouvenirUriItem> f24216b = new C21082();

    /* compiled from: REAL */
    final class C21071 implements Predicate<SouvenirUriItem> {
        C21071() {
        }

        public final boolean apply(Object obj) {
            return ((SouvenirUriItem) obj).hw_() != Type.Video;
        }
    }

    /* compiled from: REAL */
    final class C21082 implements Predicate<SouvenirUriItem> {
        C21082() {
        }

        public final boolean apply(Object obj) {
            return ((SouvenirUriItem) obj).hw_() == Type.Video;
        }
    }

    public static boolean m26458d(SouvenirModel souvenirModel) {
        return m26456a((UnmodifiableIterator) new SouvenirUriItemIterator(souvenirModel.b().iterator()));
    }

    public static UnmodifiableIterator<SouvenirUriItem> m26454a(SouvenirModel souvenirModel) {
        return new SouvenirDisplayItemIterator(souvenirModel.b().iterator());
    }

    public static UnmodifiableIterator<SouvenirUriItem> m26457b(SouvenirModel souvenirModel) {
        return Iterators.b(m26454a(souvenirModel), f24215a);
    }

    private static boolean m26456a(UnmodifiableIterator<SouvenirUriItem> unmodifiableIterator) {
        Preconditions.checkArgument(unmodifiableIterator.hasNext());
        SouvenirUriItem souvenirUriItem = (SouvenirUriItem) unmodifiableIterator.next();
        while (unmodifiableIterator.hasNext()) {
            if (!m26455a(souvenirUriItem)) {
                return false;
            }
            souvenirUriItem = (SouvenirUriItem) unmodifiableIterator.next();
        }
        return true;
    }

    @VisibleForTesting
    private static boolean m26455a(SouvenirUriItem souvenirUriItem) {
        Uri uri = souvenirUriItem.b().mUri;
        if (UriUtil.a(uri)) {
            return true;
        }
        File file = new File(uri.getPath());
        if (file.exists() && file.canRead() && file.length() > 0) {
            return true;
        }
        return false;
    }
}
