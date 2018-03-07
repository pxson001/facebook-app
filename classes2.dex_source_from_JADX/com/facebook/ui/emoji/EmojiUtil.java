package com.facebook.ui.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.text.Editable;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.emoji.data.EmojisDataMethodAutoProvider;
import com.facebook.ui.emoji.data.FacebookEmojisData;
import com.facebook.ui.emoji.model.BigEmojis;
import com.facebook.ui.emoji.model.Emoji;
import com.facebook.ui.emoji.model.EmojisData;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.regex.Matcher;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: index.bin */
public class EmojiUtil {
    private static final int[] f20220a = new int[]{169, 174, 8482, 8252, 8265, 12951, 12953};
    private static EmojiUtil f20221j;
    private static final Object f20222k = new Object();
    private final Lazy<Emojis> f20223b;
    private final EmojiCodePointFilter f20224c;
    private final Resources f20225d;
    @Nullable
    private final BigEmojis f20226e;
    private final QeAccessor f20227f;
    private final FacebookEmojisData f20228g;
    private final Lazy<EmojiCodePointParser> f20229h;
    @Nullable
    private Boolean f20230i = null;

    @VisibleForTesting
    /* compiled from: index.bin */
    class EmojiSpanConfig {
        public int f22492a;
        public int f22493b;
        public int f22494c = -1;
        public boolean f22495d = true;
        public boolean f22496e = true;

        EmojiSpanConfig() {
        }
    }

    private static EmojiUtil m27881b(InjectorLike injectorLike) {
        return new EmojiUtil(IdBasedSingletonScopeProvider.m1810b(injectorLike, 3557), EmojiCodePointFilter.m27891a(injectorLike), ResourcesMethodAutoProvider.m6510a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), BigEmojisMethodAutoProvider.m27893a(injectorLike), EmojisDataMethodAutoProvider.m27894a(injectorLike), IdBasedLazy.m1808a(injectorLike, 3555));
    }

    public static EmojiUtil m27878a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EmojiUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20222k) {
                EmojiUtil emojiUtil;
                if (a2 != null) {
                    emojiUtil = (EmojiUtil) a2.mo818a(f20222k);
                } else {
                    emojiUtil = f20221j;
                }
                if (emojiUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27881b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20222k, b3);
                        } else {
                            f20221j = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = emojiUtil;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public EmojiUtil(Lazy<Emojis> lazy, EmojiCodePointFilter emojiCodePointFilter, Resources resources, QeAccessor qeAccessor, @Nullable BigEmojis bigEmojis, EmojisData emojisData, Lazy<EmojiCodePointParser> lazy2) {
        Preconditions.checkNotNull(emojisData, "Binding for emojisData not defined.");
        this.f20223b = lazy;
        this.f20224c = emojiCodePointFilter;
        this.f20225d = resources;
        this.f20226e = bigEmojis;
        this.f20227f = qeAccessor;
        this.f20228g = emojisData;
        this.f20229h = lazy2;
    }

    public final boolean m27887a(Editable editable, int i) {
        EmojiSpanConfig emojiSpanConfig = new EmojiSpanConfig();
        emojiSpanConfig.f22492a = i;
        if (m27879a()) {
            return m27880a(editable, emojiSpanConfig);
        }
        return m27883b(editable, emojiSpanConfig);
    }

    public final boolean m27888a(Editable editable, int i, int i2, int i3) {
        EmojiSpanConfig emojiSpanConfig = new EmojiSpanConfig();
        emojiSpanConfig.f22492a = i;
        emojiSpanConfig.f22493b = i2;
        emojiSpanConfig.f22494c = i3;
        emojiSpanConfig.f22495d = false;
        if (m27879a()) {
            return m27880a(editable, emojiSpanConfig);
        }
        return m27883b(editable, emojiSpanConfig);
    }

    public final boolean m27886a(Editable editable) {
        EmojiSpanConfig emojiSpanConfig = new EmojiSpanConfig();
        emojiSpanConfig.f22496e = false;
        if (m27879a()) {
            return m27880a(editable, emojiSpanConfig);
        }
        return m27883b(editable, emojiSpanConfig);
    }

    @Nullable
    public final Emoji m27885a(@Nullable String str) {
        if (StringUtil.m3589a((CharSequence) str)) {
            return null;
        }
        int codePointAt = Character.codePointAt(str, 0);
        int charCount = Character.charCount(codePointAt);
        if (charCount < str.length()) {
            charCount = Character.codePointAt(str, charCount);
        } else {
            charCount = 0;
        }
        return EmojiCodePointFilter.m27892a(codePointAt, charCount) ? ((Emojis) this.f20223b.get()).m32627a(codePointAt, charCount) : null;
    }

    public final boolean m27889b(String str) {
        boolean z = false;
        TracerDetour.a("EmojiUtil.isStringOnlyEmoji", 1210718350);
        try {
            if (StringUtil.m3589a((CharSequence) str)) {
                return z;
            }
            int length = str.length();
            int i = 0;
            while (i < length) {
                int g;
                Emoji a = ((EmojiCodePointParser) this.f20229h.get()).a(str, i);
                if (a != null) {
                    g = a.m31237g();
                } else {
                    g = 1;
                }
                boolean isEmpty = str.substring(i, i + 1).trim().isEmpty();
                if (a == null && !isEmpty) {
                    Matcher matcher = ((Emojis) this.f20223b.get()).m32635c().matcher(str.substring(Math.max(i - 1, 0), Math.min(i + 6, length)));
                    if (!matcher.find() || matcher.start(1) > i) {
                        TracerDetour.a(379753369);
                        return false;
                    }
                    g = matcher.group(1).length();
                }
                i = g + i;
            }
            TracerDetour.a(1011883692);
            return true;
        } finally {
            z = true;
            TracerDetour.a(1851864431);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @com.google.common.annotations.VisibleForTesting
    private boolean m27880a(android.text.Editable r13, com.facebook.ui.emoji.EmojiUtil.EmojiSpanConfig r14) {
        /*
        r12 = this;
        r4 = 0;
        r0 = r13.length();
        r7 = new char[r0];
        r1 = 0;
        r2 = 0;
        r13.getChars(r1, r0, r7, r2);
        r3 = r14.f22493b;
        r1 = r14.f22494c;
        if (r1 >= 0) goto L_0x0039;
    L_0x0012:
        r1 = r0;
    L_0x0013:
        r8 = new com.facebook.ui.emoji.Emojis$EmoticonResult;
        r8.<init>();
        r2 = 0;
        r5 = 0;
        r6 = r3;
        r3 = r4;
    L_0x001c:
        r0 = r1 + -1;
        if (r6 >= r0) goto L_0x0283;
    L_0x0020:
        r4 = r7[r6];
        r0 = 8482; // 0x2122 float:1.1886E-41 double:4.1907E-320;
        if (r4 >= r0) goto L_0x0129;
    L_0x0026:
        r0 = 8252; // 0x203c float:1.1564E-41 double:4.077E-320;
        if (r4 == r0) goto L_0x0129;
    L_0x002a:
        r0 = 8265; // 0x2049 float:1.1582E-41 double:4.0835E-320;
        if (r4 == r0) goto L_0x0129;
    L_0x002e:
        switch(r4) {
            case 35: goto L_0x003e;
            case 38: goto L_0x00a5;
            case 40: goto L_0x00a5;
            case 48: goto L_0x0073;
            case 49: goto L_0x003e;
            case 50: goto L_0x003e;
            case 51: goto L_0x0073;
            case 52: goto L_0x003e;
            case 53: goto L_0x003e;
            case 54: goto L_0x003e;
            case 55: goto L_0x003e;
            case 56: goto L_0x003e;
            case 57: goto L_0x003e;
            case 58: goto L_0x00a5;
            case 59: goto L_0x00a5;
            case 60: goto L_0x00a5;
            case 61: goto L_0x00a5;
            case 62: goto L_0x00a5;
            case 79: goto L_0x00a5;
            case 94: goto L_0x00a5;
            case 111: goto L_0x00a5;
            case 169: goto L_0x0104;
            case 170: goto L_0x0104;
            case 171: goto L_0x0104;
            case 172: goto L_0x0104;
            case 173: goto L_0x0104;
            case 174: goto L_0x0104;
            default: goto L_0x0031;
        };
    L_0x0031:
        r0 = r2;
        r2 = r3;
    L_0x0033:
        r3 = r6 + 1;
        r6 = r3;
        r3 = r2;
        r2 = r0;
        goto L_0x001c;
    L_0x0039:
        r0 = r14.f22494c;
        r0 = r0 + r3;
        r1 = r0;
        goto L_0x0013;
    L_0x003e:
        r0 = r6 + 1;
        r0 = r7[r0];
        r9 = 8419; // 0x20e3 float:1.1798E-41 double:4.1595E-320;
        if (r0 != r9) goto L_0x006f;
    L_0x0046:
        r0 = r12.f20228g;
        r9 = 8419; // 0x20e3 float:1.1798E-41 double:4.1595E-320;
        r10 = -1;
        r0 = r0.m27899a(r4, r9, r10);
        r9 = -1;
        if (r0 == r9) goto L_0x006b;
    L_0x0052:
        r9 = new com.facebook.ui.emoji.model.Emoji;
        r10 = 8419; // 0x20e3 float:1.1798E-41 double:4.1595E-320;
        r9.<init>(r0, r4, r10);
        r0 = r14.f22492a;
        r4 = r14.f22496e;
        r0 = r12.m27877a(r9, r0, r4);
        if (r0 == 0) goto L_0x006b;
    L_0x0063:
        r3 = 1;
        r4 = r6 + 2;
        r9 = 33;
        r13.setSpan(r0, r6, r4, r9);
    L_0x006b:
        r0 = r6 + 2;
        r6 = r0;
        goto L_0x001c;
    L_0x006f:
        r0 = r6 + 1;
        r6 = r0;
        goto L_0x001c;
    L_0x0073:
        r0 = r6 + 1;
        r0 = r7[r0];
        r9 = 8419; // 0x20e3 float:1.1798E-41 double:4.1595E-320;
        if (r0 != r9) goto L_0x00a5;
    L_0x007b:
        r0 = r12.f20228g;
        r9 = 8419; // 0x20e3 float:1.1798E-41 double:4.1595E-320;
        r10 = -1;
        r0 = r0.m27899a(r4, r9, r10);
        r9 = -1;
        if (r0 == r9) goto L_0x00a0;
    L_0x0087:
        r9 = new com.facebook.ui.emoji.model.Emoji;
        r10 = 8419; // 0x20e3 float:1.1798E-41 double:4.1595E-320;
        r9.<init>(r0, r4, r10);
        r0 = r14.f22492a;
        r4 = r14.f22496e;
        r0 = r12.m27877a(r9, r0, r4);
        if (r0 == 0) goto L_0x00a0;
    L_0x0098:
        r3 = 1;
        r4 = r6 + 2;
        r9 = 33;
        r13.setSpan(r0, r6, r4, r9);
    L_0x00a0:
        r0 = r6 + 2;
        r6 = r0;
        goto L_0x001c;
    L_0x00a5:
        if (r6 <= 0) goto L_0x00b3;
    L_0x00a7:
        r0 = r6 + -1;
        r0 = r7[r0];
    L_0x00ab:
        switch(r0) {
            case 9: goto L_0x00b6;
            case 10: goto L_0x00b6;
            case 11: goto L_0x00b6;
            case 12: goto L_0x00b6;
            case 13: goto L_0x00b6;
            case 32: goto L_0x00b6;
            case 34: goto L_0x00b6;
            case 39: goto L_0x00b6;
            case 46: goto L_0x00b6;
            default: goto L_0x00ae;
        };
    L_0x00ae:
        r0 = r6 + 1;
        r6 = r0;
        goto L_0x001c;
    L_0x00b3:
        r0 = 32;
        goto L_0x00ab;
    L_0x00b6:
        r0 = com.facebook.ui.emoji.Emojis.m32623a(r7, r6, r8);
        if (r0 == 0) goto L_0x00ae;
    L_0x00bc:
        r0 = r8.f22499b;
        r0 = r0 + r6;
        if (r0 >= r1) goto L_0x00e0;
    L_0x00c1:
        r0 = r8.f22499b;
        r0 = r0 + r6;
        r0 = r7[r0];
    L_0x00c6:
        switch(r0) {
            case 9: goto L_0x00ca;
            case 10: goto L_0x00ca;
            case 11: goto L_0x00ca;
            case 12: goto L_0x00ca;
            case 13: goto L_0x00ca;
            case 32: goto L_0x00ca;
            case 33: goto L_0x00ca;
            case 34: goto L_0x00ca;
            case 39: goto L_0x00ca;
            case 44: goto L_0x00ca;
            case 46: goto L_0x00ca;
            case 63: goto L_0x00ca;
            default: goto L_0x00c9;
        };
    L_0x00c9:
        goto L_0x00ae;
    L_0x00ca:
        r0 = r12.f20223b;
        r0 = r0.get();
        r0 = (com.facebook.ui.emoji.Emojis) r0;
        r4 = r8.f22498a;
        r0 = r0.m32632b(r4);
        if (r0 != 0) goto L_0x00e3;
    L_0x00da:
        r0 = r8.f22499b;
        r0 = r0 + r6;
        r6 = r0;
        goto L_0x001c;
    L_0x00e0:
        r0 = 32;
        goto L_0x00c6;
    L_0x00e3:
        r4 = r14.f22492a;
        r9 = r14.f22496e;
        r0 = r12.m27877a(r0, r4, r9);
        if (r0 == 0) goto L_0x0326;
    L_0x00ed:
        r3 = 1;
        r4 = r8.f22499b;
        r4 = r4 + r6;
        r9 = 33;
        r13.setSpan(r0, r6, r4, r9);
        r0 = r5 + 1;
    L_0x00f8:
        r4 = 40;
        if (r0 <= r4) goto L_0x00fd;
    L_0x00fc:
        return r3;
    L_0x00fd:
        r4 = r8.f22499b;
        r4 = r4 + r6;
        r5 = r0;
        r6 = r4;
        goto L_0x001c;
    L_0x0104:
        r0 = android.os.Build.VERSION.SDK_INT;
        r4 = 16;
        if (r0 >= r4) goto L_0x0031;
    L_0x010a:
        if (r2 != 0) goto L_0x0323;
    L_0x010c:
        r0 = new com.facebook.ui.emoji.model.Emoji;
        r2 = 2130839424; // 0x7f020780 float:1.7283858E38 double:1.052774556E-314;
        r4 = 0;
        r0.<init>(r2, r4);
        r2 = r14.f22492a;
        r4 = r14.f22496e;
        r0 = r12.m27877a(r0, r2, r4);
    L_0x011d:
        if (r0 == 0) goto L_0x0329;
    L_0x011f:
        r2 = 1;
        r3 = r6 + 1;
        r4 = 33;
        r13.setSpan(r0, r6, r3, r4);
        goto L_0x0033;
    L_0x0129:
        r0 = 55296; // 0xd800 float:7.7486E-41 double:2.732E-319;
        if (r4 < r0) goto L_0x0133;
    L_0x012e:
        r0 = 57343; // 0xdfff float:8.0355E-41 double:2.8331E-319;
        if (r4 <= r0) goto L_0x0193;
    L_0x0133:
        r0 = 57345; // 0xe001 float:8.0357E-41 double:2.8332E-319;
        if (r4 < r0) goto L_0x0320;
    L_0x0138:
        r0 = 58678; // 0xe536 float:8.2225E-41 double:2.8991E-319;
        if (r4 > r0) goto L_0x0320;
    L_0x013d:
        r0 = r12.f20228g;
        r0 = r0.m27898a(r4, r4);
    L_0x0143:
        r9 = r12.f20228g;
        r10 = 0;
        r11 = -1;
        r0 = r9.m27899a(r0, r10, r11);
        r9 = -1;
        if (r0 == r9) goto L_0x0165;
    L_0x014e:
        r9 = new com.facebook.ui.emoji.model.Emoji;
        r9.<init>(r0, r4);
        r0 = r14.f22492a;
        r10 = r14.f22496e;
        r0 = r12.m27877a(r9, r0, r10);
        if (r0 == 0) goto L_0x0165;
    L_0x015d:
        r3 = 1;
        r9 = r6 + 1;
        r10 = 33;
        r13.setSpan(r0, r6, r9, r10);
    L_0x0165:
        r0 = android.os.Build.VERSION.SDK_INT;
        r9 = 16;
        if (r0 >= r9) goto L_0x018e;
    L_0x016b:
        r0 = com.facebook.ui.emoji.UnsupportedEmoji.a(r4);
        if (r0 == 0) goto L_0x018e;
    L_0x0171:
        if (r2 != 0) goto L_0x0184;
    L_0x0173:
        r0 = new com.facebook.ui.emoji.model.Emoji;
        r2 = 2130839424; // 0x7f020780 float:1.7283858E38 double:1.052774556E-314;
        r4 = 0;
        r0.<init>(r2, r4);
        r2 = r14.f22492a;
        r4 = r14.f22496e;
        r2 = r12.m27877a(r0, r2, r4);
    L_0x0184:
        if (r2 == 0) goto L_0x018e;
    L_0x0186:
        r3 = 1;
        r0 = r6 + 1;
        r4 = 33;
        r13.setSpan(r2, r6, r0, r4);
    L_0x018e:
        r0 = r6 + 1;
        r6 = r0;
        goto L_0x001c;
    L_0x0193:
        r0 = r6 + 1;
        r0 = r7[r0];
        r9 = 56320; // 0xdc00 float:7.8921E-41 double:2.7826E-319;
        if (r0 < r9) goto L_0x01a1;
    L_0x019c:
        r9 = 57343; // 0xdfff float:8.0355E-41 double:2.8331E-319;
        if (r0 <= r9) goto L_0x01a6;
    L_0x01a1:
        r0 = r6 + 2;
        r6 = r0;
        goto L_0x001c;
    L_0x01a6:
        r9 = 55296; // 0xd800 float:7.7486E-41 double:2.732E-319;
        r4 = r4 - r9;
        r4 = r4 << 10;
        r9 = 56320; // 0xdc00 float:7.8921E-41 double:2.7826E-319;
        r0 = r0 - r9;
        r0 = r0 + r4;
        r4 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r0 = r0 + r4;
        r4 = 127462; // 0x1f1e6 float:1.78612E-40 double:6.29746E-319;
        if (r0 < r4) goto L_0x0227;
    L_0x01b9:
        r4 = 127487; // 0x1f1ff float:1.78647E-40 double:6.2987E-319;
        if (r0 > r4) goto L_0x0227;
    L_0x01be:
        r4 = r6 + 4;
        if (r4 >= r1) goto L_0x0227;
    L_0x01c2:
        r4 = r6 + 2;
        r4 = r7[r4];
        r9 = 55296; // 0xd800 float:7.7486E-41 double:2.732E-319;
        if (r4 < r9) goto L_0x0227;
    L_0x01cb:
        r4 = r6 + 2;
        r4 = r7[r4];
        r9 = 56320; // 0xdc00 float:7.8921E-41 double:2.7826E-319;
        if (r4 >= r9) goto L_0x0227;
    L_0x01d4:
        r4 = r6 + 3;
        r4 = r7[r4];
        r9 = 56320; // 0xdc00 float:7.8921E-41 double:2.7826E-319;
        if (r4 < r9) goto L_0x0227;
    L_0x01dd:
        r4 = r6 + 3;
        r4 = r7[r4];
        r9 = 57343; // 0xdfff float:8.0355E-41 double:2.8331E-319;
        if (r4 > r9) goto L_0x0227;
    L_0x01e6:
        r4 = r6 + 2;
        r4 = r7[r4];
        r9 = 55296; // 0xd800 float:7.7486E-41 double:2.732E-319;
        r4 = r4 - r9;
        r4 = r4 << 10;
        r9 = r6 + 3;
        r9 = r7[r9];
        r10 = 56320; // 0xdc00 float:7.8921E-41 double:2.7826E-319;
        r9 = r9 - r10;
        r4 = r4 + r9;
        r9 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r9 = r9 + r4;
        r4 = r12.f20228g;
        r10 = -1;
        r10 = r4.m27899a(r0, r9, r10);
        r4 = -1;
        if (r10 == r4) goto L_0x0225;
    L_0x0206:
        r4 = new com.facebook.ui.emoji.model.Emoji;
        r4.<init>(r10, r0, r9);
        r0 = r4;
    L_0x020c:
        if (r0 == 0) goto L_0x0220;
    L_0x020e:
        r4 = r14.f22492a;
        r9 = r14.f22496e;
        r0 = r12.m27877a(r0, r4, r9);
        if (r0 == 0) goto L_0x0220;
    L_0x0218:
        r3 = 1;
        r4 = r6 + 4;
        r9 = 33;
        r13.setSpan(r0, r6, r4, r9);
    L_0x0220:
        r0 = r6 + 4;
        r6 = r0;
        goto L_0x001c;
    L_0x0225:
        r0 = 0;
        goto L_0x020c;
    L_0x0227:
        r4 = 128149; // 0x1f495 float:1.79575E-40 double:6.3314E-319;
        if (r0 != r4) goto L_0x022f;
    L_0x022c:
        r0 = 128147; // 0x1f493 float:1.79572E-40 double:6.3313E-319;
    L_0x022f:
        r4 = r12.f20228g;
        r9 = 0;
        r10 = -1;
        r9 = r4.m27899a(r0, r9, r10);
        r4 = -1;
        if (r9 == r4) goto L_0x0281;
    L_0x023a:
        r4 = new com.facebook.ui.emoji.model.Emoji;
        r4.<init>(r9, r0);
    L_0x023f:
        if (r4 == 0) goto L_0x0253;
    L_0x0241:
        r9 = r14.f22492a;
        r10 = r14.f22496e;
        r4 = r12.m27877a(r4, r9, r10);
        if (r4 == 0) goto L_0x0253;
    L_0x024b:
        r3 = 1;
        r9 = r6 + 2;
        r10 = 33;
        r13.setSpan(r4, r6, r9, r10);
    L_0x0253:
        r4 = android.os.Build.VERSION.SDK_INT;
        r9 = 16;
        if (r4 >= r9) goto L_0x027c;
    L_0x0259:
        r0 = com.facebook.ui.emoji.UnsupportedEmoji.b(r0);
        if (r0 == 0) goto L_0x027c;
    L_0x025f:
        if (r2 != 0) goto L_0x0272;
    L_0x0261:
        r0 = new com.facebook.ui.emoji.model.Emoji;
        r2 = 2130839424; // 0x7f020780 float:1.7283858E38 double:1.052774556E-314;
        r4 = 0;
        r0.<init>(r2, r4);
        r2 = r14.f22492a;
        r4 = r14.f22496e;
        r2 = r12.m27877a(r0, r2, r4);
    L_0x0272:
        if (r2 == 0) goto L_0x027c;
    L_0x0274:
        r3 = 1;
        r0 = r6 + 2;
        r4 = 33;
        r13.setSpan(r2, r6, r0, r4);
    L_0x027c:
        r0 = r6 + 2;
        r6 = r0;
        goto L_0x001c;
    L_0x0281:
        r4 = 0;
        goto L_0x023f;
    L_0x0283:
        if (r6 >= r1) goto L_0x00fc;
    L_0x0285:
        r1 = r7[r6];
        r0 = 55296; // 0xd800 float:7.7486E-41 double:2.732E-319;
        if (r1 < r0) goto L_0x0291;
    L_0x028c:
        r0 = 57343; // 0xdfff float:8.0355E-41 double:2.8331E-319;
        if (r1 <= r0) goto L_0x00fc;
    L_0x0291:
        r0 = r7[r6];
        switch(r0) {
            case 169: goto L_0x02f9;
            case 170: goto L_0x02f9;
            case 171: goto L_0x02f9;
            case 172: goto L_0x02f9;
            case 173: goto L_0x02f9;
            case 174: goto L_0x02f9;
            default: goto L_0x0296;
        };
    L_0x0296:
        r0 = 57345; // 0xe001 float:8.0357E-41 double:2.8332E-319;
        if (r1 < r0) goto L_0x031e;
    L_0x029b:
        r0 = 58678; // 0xe536 float:8.2225E-41 double:2.8991E-319;
        if (r1 > r0) goto L_0x031e;
    L_0x02a0:
        r0 = r12.f20228g;
        r0 = r0.m27898a(r1, r1);
    L_0x02a6:
        r4 = r12.f20228g;
        r5 = 0;
        r7 = -1;
        r4 = r4.m27899a(r0, r5, r7);
        r5 = -1;
        if (r4 == r5) goto L_0x02c8;
    L_0x02b1:
        r5 = new com.facebook.ui.emoji.model.Emoji;
        r5.<init>(r4, r1);
        r1 = r14.f22492a;
        r4 = r14.f22496e;
        r1 = r12.m27877a(r5, r1, r4);
        if (r1 == 0) goto L_0x02c8;
    L_0x02c0:
        r3 = 1;
        r4 = r6 + 1;
        r5 = 33;
        r13.setSpan(r1, r6, r4, r5);
    L_0x02c8:
        r1 = android.os.Build.VERSION.SDK_INT;
        r4 = 16;
        if (r1 >= r4) goto L_0x00fc;
    L_0x02ce:
        r1 = com.facebook.ui.emoji.UnsupportedEmoji.a(r0);
        if (r1 != 0) goto L_0x02da;
    L_0x02d4:
        r0 = com.facebook.ui.emoji.UnsupportedEmoji.b(r0);
        if (r0 == 0) goto L_0x00fc;
    L_0x02da:
        if (r2 != 0) goto L_0x02ed;
    L_0x02dc:
        r0 = new com.facebook.ui.emoji.model.Emoji;
        r1 = 2130839424; // 0x7f020780 float:1.7283858E38 double:1.052774556E-314;
        r2 = 0;
        r0.<init>(r1, r2);
        r1 = r14.f22492a;
        r2 = r14.f22496e;
        r2 = r12.m27877a(r0, r1, r2);
    L_0x02ed:
        if (r2 == 0) goto L_0x00fc;
    L_0x02ef:
        r3 = 1;
        r0 = r6 + 1;
        r1 = 33;
        r13.setSpan(r2, r6, r0, r1);
        goto L_0x00fc;
    L_0x02f9:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 16;
        if (r0 >= r1) goto L_0x00fc;
    L_0x02ff:
        if (r2 != 0) goto L_0x0312;
    L_0x0301:
        r0 = new com.facebook.ui.emoji.model.Emoji;
        r1 = 2130839424; // 0x7f020780 float:1.7283858E38 double:1.052774556E-314;
        r2 = 0;
        r0.<init>(r1, r2);
        r1 = r14.f22492a;
        r2 = r14.f22496e;
        r2 = r12.m27877a(r0, r1, r2);
    L_0x0312:
        if (r2 == 0) goto L_0x00fc;
    L_0x0314:
        r3 = 1;
        r0 = r6 + 1;
        r1 = 33;
        r13.setSpan(r2, r6, r0, r1);
        goto L_0x00fc;
    L_0x031e:
        r0 = r1;
        goto L_0x02a6;
    L_0x0320:
        r0 = r4;
        goto L_0x0143;
    L_0x0323:
        r0 = r2;
        goto L_0x011d;
    L_0x0326:
        r0 = r5;
        goto L_0x00f8;
    L_0x0329:
        r2 = r3;
        goto L_0x0033;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.emoji.EmojiUtil.a(android.text.Editable, com.facebook.ui.emoji.EmojiUtil$EmojiSpanConfig):boolean");
    }

    @VisibleForTesting
    private boolean m27883b(Editable editable, EmojiSpanConfig emojiSpanConfig) {
        int length = emojiSpanConfig.f22494c == -1 ? editable.length() : emojiSpanConfig.f22493b + emojiSpanConfig.f22494c;
        int i = emojiSpanConfig.f22493b;
        Object obj = null;
        boolean z = false;
        while (i < length) {
            Emoji a = ((EmojiCodePointParser) this.f20229h.get()).a(editable, i);
            if (a == null) {
                Object obj2;
                if (obj == null && Character.isSpaceChar(editable.charAt(i))) {
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
                i++;
                obj = obj2;
            } else {
                boolean z2;
                int g = a.m31237g();
                EmojiSpan a2 = m27877a(a, emojiSpanConfig.f22492a, emojiSpanConfig.f22496e);
                if (a2 != null) {
                    editable.setSpan(a2, i, i + g, 33);
                    z2 = true;
                } else {
                    z2 = z;
                }
                i += g;
                z = z2;
            }
        }
        if (!emojiSpanConfig.f22495d) {
            return z;
        }
        if (obj != null) {
            FacebookEmojisData facebookEmojisData = this.f20228g;
            if (1 == 0) {
                m27882b(editable);
            }
        }
        return m27884c(editable, emojiSpanConfig) || z;
    }

    private static void m27882b(Editable editable) {
        if (!StringUtil.m3589a((CharSequence) editable)) {
            EmojiSpan[] emojiSpanArr = (EmojiSpan[]) editable.getSpans(0, editable.length(), EmojiSpan.class);
            for (EmojiSpan emojiSpan : emojiSpanArr) {
                for (int i : f20220a) {
                    if (emojiSpan.b.f23124b == i && emojiSpan.b.f23125c == 0) {
                        editable.removeSpan(emojiSpan);
                    }
                }
            }
        }
    }

    private boolean m27884c(Editable editable, EmojiSpanConfig emojiSpanConfig) {
        int i = 0;
        Matcher matcher = ((Emojis) this.f20223b.get()).m32635c().matcher(editable);
        boolean z = false;
        while (matcher.find() && i < 40) {
            Emoji a = ((Emojis) this.f20223b.get()).m32629a(matcher.group(1));
            if (a != null) {
                EmojiSpan a2 = m27877a(a, emojiSpanConfig.f22492a, emojiSpanConfig.f22496e);
                if (a2 != null) {
                    editable.setSpan(a2, matcher.start(1), matcher.end(1), 33);
                    z = true;
                }
            }
            i++;
        }
        return z;
    }

    @VisibleForTesting
    private EmojiSpan m27877a(Emoji emoji, int i, boolean z) {
        BitmapDrawable bitmapDrawable;
        int a;
        if (z || this.f20226e == null) {
            bitmapDrawable = (BitmapDrawable) this.f20225d.getDrawable(emoji.f23123a);
        } else {
            a = this.f20226e.a();
            if (a == 0) {
                a = emoji.f23123a;
            }
            bitmapDrawable = (BitmapDrawable) this.f20225d.getDrawable(a);
        }
        if (bitmapDrawable == null) {
            return null;
        }
        int intrinsicWidth = bitmapDrawable.getIntrinsicWidth();
        a = bitmapDrawable.getIntrinsicHeight();
        if (z) {
            int a2 = SizeUtil.m19192a(this.f20225d, 16.0f);
            intrinsicWidth = (intrinsicWidth * i) / a2;
            a = (a * i) / a2;
        }
        bitmapDrawable.setBounds(0, 0, intrinsicWidth, a);
        return new EmojiSpan(bitmapDrawable, emoji);
    }

    private boolean m27879a() {
        if (this.f20230i == null) {
            this.f20230i = Boolean.valueOf(this.f20227f.mo596a(ExperimentsForEmojiModule.f22497a, false));
        }
        if (!this.f20230i.booleanValue()) {
            return false;
        }
        FacebookEmojisData facebookEmojisData = this.f20228g;
        if (1 != 0) {
            return true;
        }
        return false;
    }
}
