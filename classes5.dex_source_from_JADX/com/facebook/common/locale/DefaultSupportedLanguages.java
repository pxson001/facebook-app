package com.facebook.common.locale;

import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.common.build.config.BuildConfig;
import com.facebook.common.locale.SupportedLanguages.Type;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;
import com.google.common.collect.Sets;
import java.util.Collection;

/* compiled from: signInConfiguration */
public class DefaultSupportedLanguages extends SupportedLanguages {
    private static final ImmutableSet<String> f2692a;
    private static final ImmutableSet<String> f2693b;

    /* compiled from: signInConfiguration */
    /* synthetic */ class C01871 {
        static final /* synthetic */ int[] f2691a = new int[Type.values().length];

        static {
            try {
                f2691a[Type.ASSET.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2691a[Type.DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static DefaultSupportedLanguages m3804a(InjectorLike injectorLike) {
        return new DefaultSupportedLanguages();
    }

    public final ImmutableSet<String> m3805a() {
        return f2692a;
    }

    public final ImmutableSet<String> m3806a(Type type) {
        switch (C01871.f2691a[type.ordinal()]) {
            case 1:
                if (null != null) {
                    return f2693b;
                }
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                if (1 != 0) {
                    return f2693b;
                }
                break;
        }
        return RegularImmutableSet.a;
    }

    static {
        ImmutableSet copyOf = ImmutableSet.copyOf(BuildConfig.f);
        f2692a = copyOf;
        Collection b = Sets.b(copyOf);
        b.remove("en");
        f2693b = ImmutableSet.copyOf(b);
    }
}
