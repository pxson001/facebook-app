package com.facebook.photos.pandora.common.cache;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.LruCache;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.photos.pandora.common.data.PandoraInstanceId;
import com.facebook.photos.pandora.common.data.PandoraStoryPagedCollection;
import com.facebook.photos.pandora.common.source.PandoraRequestSource;
import com.facebook.photos.pandora.common.util.PandoraGraphQLObjectExtractor;
import com.google.common.base.Objects;
import javax.inject.Inject;

@ContextScoped
/* compiled from: composer_update_titlebar */
public class PandoraStoryMemoryCache implements IHaveUserData {
    public static LruCache<MemoryCacheEntryKey, PandoraStoryPagedCollection> f17354b = new LruCache(10);
    private static PandoraStoryMemoryCache f17355c;
    private static final Object f17356d = new Object();
    private final Lazy<PandoraGraphQLObjectExtractor> f17357a;

    /* compiled from: composer_update_titlebar */
    public class MemoryCacheEntryKey implements Parcelable {
        public static final Creator<MemoryCacheEntryKey> CREATOR = new C18431();
        public final PandoraInstanceId f17352a;
        public final PandoraRequestSource f17353b;

        /* compiled from: composer_update_titlebar */
        final class C18431 implements Creator<MemoryCacheEntryKey> {
            C18431() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new MemoryCacheEntryKey(parcel);
            }

            public final Object[] newArray(int i) {
                return new MemoryCacheEntryKey[i];
            }
        }

        public MemoryCacheEntryKey(PandoraInstanceId pandoraInstanceId, PandoraRequestSource pandoraRequestSource) {
            this.f17352a = pandoraInstanceId;
            this.f17353b = pandoraRequestSource;
        }

        public MemoryCacheEntryKey(Parcel parcel) {
            this.f17352a = (PandoraInstanceId) parcel.readParcelable(PandoraInstanceId.class.getClassLoader());
            this.f17353b = (PandoraRequestSource) parcel.readSerializable();
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof MemoryCacheEntryKey)) {
                return false;
            }
            MemoryCacheEntryKey memoryCacheEntryKey = (MemoryCacheEntryKey) obj;
            if (Objects.equal(this.f17352a, memoryCacheEntryKey.f17352a) && this.f17353b == memoryCacheEntryKey.f17353b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f17352a.hashCode() * (this.f17353b.ordinal() + 1);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f17352a, i);
            parcel.writeSerializable(this.f17353b);
        }
    }

    private static PandoraStoryMemoryCache m21362b(InjectorLike injectorLike) {
        return new PandoraStoryMemoryCache(IdBasedSingletonScopeProvider.b(injectorLike, 9393));
    }

    @Inject
    public PandoraStoryMemoryCache(Lazy<PandoraGraphQLObjectExtractor> lazy) {
        this.f17357a = lazy;
    }

    public final PandoraStoryPagedCollection m21363a(MemoryCacheEntryKey memoryCacheEntryKey) {
        if (memoryCacheEntryKey == null) {
            return null;
        }
        PandoraStoryPagedCollection pandoraStoryPagedCollection = (PandoraStoryPagedCollection) f17354b.a(memoryCacheEntryKey);
        if (pandoraStoryPagedCollection == null) {
            pandoraStoryPagedCollection = new PandoraStoryPagedCollection(this.f17357a);
        }
        f17354b.a(memoryCacheEntryKey, pandoraStoryPagedCollection);
        return pandoraStoryPagedCollection;
    }

    public void clearUserData() {
        f17354b.a();
    }

    public static PandoraStoryMemoryCache m21361a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PandoraStoryMemoryCache b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f17356d) {
                PandoraStoryMemoryCache pandoraStoryMemoryCache;
                if (a2 != null) {
                    pandoraStoryMemoryCache = (PandoraStoryMemoryCache) a2.a(f17356d);
                } else {
                    pandoraStoryMemoryCache = f17355c;
                }
                if (pandoraStoryMemoryCache == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m21362b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f17356d, b3);
                        } else {
                            f17355c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pandoraStoryMemoryCache;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
