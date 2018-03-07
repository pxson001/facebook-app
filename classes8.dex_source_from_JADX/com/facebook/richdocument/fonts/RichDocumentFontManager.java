package com.facebook.richdocument.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.LruCache;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.CollectionUtil;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.richdocument.fonts.FetchFontExecutor.C06891;
import com.facebook.richdocument.fonts.FontResourceCache.FontResourceEntry;
import com.facebook.richdocument.fonts.FontResourceCache.FontResourceKey;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentFontResource;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentStyleModel;
import com.facebook.richdocument.utils.ConnectionQualityMonitor;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: preferred_scrubbing */
public class RichDocumentFontManager {
    private static final Map<String, TypefaceCreator> f5269a = new C06911();
    private static RichDocumentFontManager f5270g;
    private static final Object f5271h = new Object();
    private final FontResourceCache f5272b;
    private final FetchFontExecutor f5273c;
    private final FontCache f5274d;
    public final LruCache<FontCacheKey, Typeface> f5275e = new LruCache(20);
    private final ConnectionQualityMonitor f5276f;

    /* compiled from: preferred_scrubbing */
    final class C06911 extends HashMap<String, TypefaceCreator> {
        C06911() {
            put("HelveticaNeue", new TypefaceCreator("sans-serif", 0));
            put("HelveticaNeue-Bold", new TypefaceCreator("sans-serif", 1));
            put("HelveticaNeue-BoldItalic", new TypefaceCreator("sans-serif", 3));
            put("HelveticaNeue-CondensedBlack", new TypefaceCreator("sans-serif-condensed", 1));
            put("HelveticaNeue-CondensedBold", new TypefaceCreator("sans-serif-condensed", 1));
            put("HelveticaNeue-Italic", new TypefaceCreator("sans-serif", 2));
            put("HelveticaNeue-Light", new TypefaceCreator("sans-serif-light", 0));
            put("HelveticaNeue-LightItalic", new TypefaceCreator("sans-serif-light", 2));
            put("HelveticaNeue-Medium", new TypefaceCreator("sans-serif", 1));
            put("HelveticaNeue-MediumItalic", new TypefaceCreator("sans-serif", 3));
            put("HelveticaNeue-UltraLight", new TypefaceCreator("sans-serif-thin", 0));
            put("HelveticaNeue-UltraLightItalic", new TypefaceCreator("sans-serif-thin", 2));
            put("HelveticaNeue-Thin", new TypefaceCreator("sans-serif-thin", 0));
            put("HelveticaNeue-ThinItalic", new TypefaceCreator("sans-serif-thin", 2));
            put("Helvetica", new TypefaceCreator("sans-serif", 0));
            put("Helvetica-Bold", new TypefaceCreator("sans-serif", 1));
            put("Helvetica-BoldOblique", new TypefaceCreator("sans-serif", 3));
            put("Helvetica-Light", new TypefaceCreator("sans-serif-light", 0));
            put("Helvetica-LightOblique", new TypefaceCreator("sans-serif-light", 2));
            put("Helvetica-Oblique", new TypefaceCreator("sans-serif", 2));
            put("Georgia", new TypefaceCreator("serif", 0));
            put("Georgia-Bold", new TypefaceCreator("serif", 1));
            put("Georgia-BoldItalic", new TypefaceCreator("serif", 3));
            put("Georgia-Italic", new TypefaceCreator("serif", 2));
        }
    }

    /* compiled from: preferred_scrubbing */
    public class TypefaceCreator {
        public final String f5267a;
        public final int f5268b;

        public TypefaceCreator(String str, int i) {
            this.f5267a = str;
            this.f5268b = i;
        }
    }

    private static RichDocumentFontManager m5209b(InjectorLike injectorLike) {
        return new RichDocumentFontManager(FontResourceCache.m5195a(injectorLike), FetchFontExecutor.m5173a(injectorLike), FontCache.m5181a(injectorLike), ConnectionQualityMonitor.a(injectorLike));
    }

    public static RichDocumentFontManager m5204a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RichDocumentFontManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5271h) {
                RichDocumentFontManager richDocumentFontManager;
                if (a2 != null) {
                    richDocumentFontManager = (RichDocumentFontManager) a2.a(f5271h);
                } else {
                    richDocumentFontManager = f5270g;
                }
                if (richDocumentFontManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5209b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5271h, b3);
                        } else {
                            f5270g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = richDocumentFontManager;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public RichDocumentFontManager(FontResourceCache fontResourceCache, FetchFontExecutor fetchFontExecutor, FontCache fontCache, ConnectionQualityMonitor connectionQualityMonitor) {
        this.f5272b = fontResourceCache;
        this.f5273c = fetchFontExecutor;
        this.f5274d = fontCache;
        this.f5276f = connectionQualityMonitor;
    }

    public final void m5212b(@Nullable RichDocumentStyleModel richDocumentStyleModel) {
        if (richDocumentStyleModel != null && !CollectionUtil.a(richDocumentStyleModel.m6358o())) {
            m5205a(richDocumentStyleModel.m6358o(), new RichDocumentStyleFontHelper(richDocumentStyleModel).m5219a(), false, false);
        }
    }

    public static Map<String, Typeface> m5207a(Set<String> set, Map<String, Typeface> map) {
        Map<String, Typeface> hashMap = new HashMap();
        for (String str : set) {
            if (map == null || !map.containsKey(str)) {
                Object a = m5202a(str);
                if (a == null) {
                    a = Typeface.DEFAULT;
                }
                hashMap.put(str, a);
            } else {
                hashMap.put(str, map.get(str));
            }
        }
        return hashMap;
    }

    private Map<String, Typeface> m5205a(ImmutableList<? extends RichDocumentFontResource> immutableList, Set<String> set, boolean z, boolean z2) {
        Set set2;
        Set<RichDocumentFontResource> hashSet = new HashSet();
        Set hashSet2 = new HashSet();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            RichDocumentFontResource richDocumentFontResource = (RichDocumentFontResource) immutableList.get(i);
            FontResourceEntry fontResourceEntry = (FontResourceEntry) this.f5272b.f5264e.get(m5203a(richDocumentFontResource));
            if (fontResourceEntry == null) {
                hashSet.add(richDocumentFontResource);
            } else {
                hashSet2.addAll(fontResourceEntry.m5194c());
            }
        }
        if (z) {
            set2 = hashSet2;
        } else {
            set2 = m5208a(hashSet2, (Set) set);
        }
        Map a = this.f5274d.m5185a(set2);
        SetView<FontCacheKey> c = Sets.c(set2, new HashSet(a.keySet()));
        if (!c.isEmpty()) {
            Set hashSet3 = new HashSet();
            for (FontCacheKey d : c) {
                hashSet3.add(d.m5190d());
            }
            int size2 = immutableList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                richDocumentFontResource = (RichDocumentFontResource) immutableList.get(i2);
                if (hashSet3.contains(m5203a(richDocumentFontResource))) {
                    hashSet.add(richDocumentFontResource);
                }
            }
        }
        if (hashSet.isEmpty()) {
            return z2 ? m5206a(a) : null;
        } else {
            ConnectionQuality a2 = this.f5276f.a();
            if (a2 == ConnectionQuality.MODERATE || a2 == ConnectionQuality.POOR) {
                return null;
            }
            for (RichDocumentFontResource richDocumentFontResource2 : hashSet) {
                m5210b(richDocumentFontResource2);
            }
            return null;
        }
    }

    public final Map<String, Typeface> m5211a(ImmutableList<? extends RichDocumentFontResource> immutableList, Set<String> set, boolean z) {
        return m5205a(immutableList, set, z, true);
    }

    private static FontResourceKey m5203a(RichDocumentFontResource richDocumentFontResource) {
        return new FontResourceKey(richDocumentFontResource.mo25a(), richDocumentFontResource.mo26b());
    }

    private static Set<FontCacheKey> m5208a(Set<FontCacheKey> set, Set<String> set2) {
        Set<FontCacheKey> hashSet = new HashSet();
        for (FontCacheKey fontCacheKey : set) {
            if (set2.contains(fontCacheKey.f5256c)) {
                hashSet.add(fontCacheKey);
            }
        }
        return hashSet;
    }

    private void m5210b(RichDocumentFontResource richDocumentFontResource) {
        FetchFontParams fetchFontParams = new FetchFontParams(richDocumentFontResource.mo25a(), richDocumentFontResource.mo26b(), richDocumentFontResource.mo27c());
        FetchFontExecutor fetchFontExecutor = this.f5273c;
        FontResourceKey fontResourceKey = new FontResourceKey(fetchFontParams.f5247a, fetchFontParams.f5248b);
        if (!FetchFontExecutor.f5239b.containsKey(fontResourceKey)) {
            FetchFontExecutor.f5239b.put(fontResourceKey, Boolean.valueOf(true));
            ListenableFuture a = ((ListeningExecutorService) fetchFontExecutor.f5242c.get()).a(new C06891(fetchFontExecutor, fetchFontParams, fontResourceKey));
        }
    }

    private Map<String, Typeface> m5206a(Map<FontCacheKey, Uri> map) {
        Map<String, Typeface> hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            Object obj;
            FontCacheKey fontCacheKey = (FontCacheKey) entry.getKey();
            Uri uri = (Uri) entry.getValue();
            if (map.containsKey(fontCacheKey)) {
                Typeface typeface = (Typeface) this.f5275e.get(fontCacheKey);
                if (typeface == null) {
                    typeface = Typeface.createFromFile(new File(uri.getPath()));
                    this.f5275e.put(fontCacheKey, typeface);
                }
                obj = typeface;
            } else {
                obj = null;
            }
            hashMap.put(fontCacheKey.f5256c, obj);
        }
        return hashMap;
    }

    public static Typeface m5202a(String str) {
        if (str == null) {
            return null;
        }
        if (f5269a.containsKey(str)) {
            TypefaceCreator typefaceCreator = (TypefaceCreator) f5269a.get(str);
            return Typeface.create(typefaceCreator.f5267a, typefaceCreator.f5268b);
        }
        int i = -1;
        switch (str.hashCode()) {
            case -1766855711:
                if (str.equals("PRE_INSTALLED_FONT_SERIF_ITALIC")) {
                    i = 11;
                    break;
                }
                break;
            case -1482856897:
                if (str.equals("Georgia-Italic")) {
                    i = 10;
                    break;
                }
                break;
            case -1190877066:
                if (str.equals("PRE_INSTALLED_FONT_SERIF_BOLD")) {
                    i = 9;
                    break;
                }
                break;
            case -117957036:
                if (str.equals("Georgia-Bold")) {
                    i = 8;
                    break;
                }
                break;
            case 57540352:
                if (str.equals("PRE_INSTALLED_FONT_SANS_SERIF")) {
                    i = 1;
                    break;
                }
                break;
            case 644172879:
                if (str.equals("PRE_INSTALLED_FONT_SANS_SERIF_ITALIC")) {
                    i = 5;
                    break;
                }
                break;
            case 701751214:
                if (str.equals("PRE_INSTALLED_FONT_SERIF")) {
                    i = 7;
                    break;
                }
                break;
            case 831976634:
                if (str.equals("HelveticaNeue-Bold")) {
                    i = 2;
                    break;
                }
                break;
            case 870333221:
                if (str.equals("HelveticaNeue-Italic")) {
                    i = 4;
                    break;
                }
                break;
            case 1104366692:
                if (str.equals("PRE_INSTALLED_FONT_SANS_SERIF_BOLD")) {
                    i = 3;
                    break;
                }
                break;
            case 1585805502:
                if (str.equals("Georgia")) {
                    i = 6;
                    break;
                }
                break;
            case 2049424024:
                if (str.equals("HelveticaNeue")) {
                    i = 0;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
            case 1:
                return Typeface.SANS_SERIF;
            case 2:
            case 3:
                return Typeface.create(Typeface.SANS_SERIF, 1);
            case 4:
            case 5:
                return Typeface.create(Typeface.SANS_SERIF, 2);
            case 6:
            case 7:
                return Typeface.SERIF;
            case 8:
            case 9:
                return Typeface.create(Typeface.SERIF, 1);
            case 10:
            case 11:
                return Typeface.create(Typeface.SERIF, 2);
            default:
                if (str.contains("HelveticaNeue")) {
                    return Typeface.SANS_SERIF;
                }
                if (str.contains("Georgia")) {
                    return Typeface.SERIF;
                }
                return null;
        }
    }
}
