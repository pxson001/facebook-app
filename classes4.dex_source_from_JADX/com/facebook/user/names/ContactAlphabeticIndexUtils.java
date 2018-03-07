package com.facebook.user.names;

import android.os.Build.VERSION;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.app.module.LocaleMethodAutoProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: received_message */
public class ContactAlphabeticIndexUtils {
    public static final Locale f13244a = new Locale("ar");
    public static final Locale f13245b = new Locale("el");
    public static final Locale f13246c = new Locale("he");
    public static final Locale f13247d = new Locale("uk");
    public static final Locale f13248e = new Locale("th");
    private static final Class<?> f13249f = ContactAlphabeticIndexUtils.class;
    private static final String f13250h = Locale.JAPANESE.getLanguage().toLowerCase();
    private static volatile ContactAlphabeticIndexUtils f13251l;
    private TriState f13252g = TriState.UNSET;
    private final Locale f13253i;
    private final String f13254j;
    private AlphabeticIndexLocaleUtilsBase f13255k;

    /* compiled from: received_message */
    class AlphabeticIndexLocaleUtilsBase {
        protected final AlphabeticIndexWrapper f3726a;
        private final int f3727b;
        private final int f3728c = (this.f3727b - 1);

        public AlphabeticIndexLocaleUtilsBase(Locale locale) {
            List a = Lists.a();
            a.add(Locale.ENGLISH);
            a.add(Locale.JAPANESE);
            a.add(Locale.KOREAN);
            a.add(ContactAlphabeticIndexUtils.f13248e);
            a.add(ContactAlphabeticIndexUtils.f13244a);
            a.add(ContactAlphabeticIndexUtils.f13246c);
            a.add(ContactAlphabeticIndexUtils.f13245b);
            a.add(ContactAlphabeticIndexUtils.f13247d);
            this.f3726a = new AlphabeticIndexWrapper(locale, a, 300);
            AlphabeticIndexWrapper alphabeticIndexWrapper = this.f3726a;
            this.f3727b = ((Integer) alphabeticIndexWrapper.f3713b.invoke(alphabeticIndexWrapper.f3712a, new Object[0])).intValue();
        }

        public int m4158a(String str) {
            Object obj = null;
            int length = str.length();
            int i = 0;
            while (i < length) {
                int codePointAt = Character.codePointAt(str, i);
                if (!Character.isDigit(codePointAt)) {
                    if (!Character.isSpaceChar(codePointAt) && codePointAt != 43 && codePointAt != 40 && codePointAt != 41 && codePointAt != 46 && codePointAt != 45 && codePointAt != 35) {
                        break;
                    }
                    i += Character.charCount(codePointAt);
                } else {
                    obj = 1;
                    break;
                }
            }
            if (obj != null) {
                return this.f3728c;
            }
            AlphabeticIndexWrapper alphabeticIndexWrapper = this.f3726a;
            int intValue = ((Integer) alphabeticIndexWrapper.f3714c.invoke(alphabeticIndexWrapper.f3712a, new Object[]{str})).intValue();
            if (intValue < 0) {
                return -1;
            }
            if (intValue >= this.f3728c) {
                return intValue + 1;
            }
            return intValue;
        }

        public int m4157a() {
            return this.f3727b + 1;
        }

        public String m4159a(int i) {
            if (i < 0 || i >= m4157a()) {
                return "";
            }
            if (i == this.f3728c) {
                return "#";
            }
            if (i > this.f3728c) {
                i--;
            }
            AlphabeticIndexWrapper alphabeticIndexWrapper = this.f3726a;
            return (String) alphabeticIndexWrapper.f3715d.invoke(alphabeticIndexWrapper.f3712a, new Object[]{Integer.valueOf(i)});
        }
    }

    public static com.facebook.user.names.ContactAlphabeticIndexUtils m14107a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f13251l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.user.names.ContactAlphabeticIndexUtils.class;
        monitor-enter(r1);
        r0 = f13251l;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m14108b(r0);	 Catch:{ all -> 0x0035 }
        f13251l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13251l;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.user.names.ContactAlphabeticIndexUtils.a(com.facebook.inject.InjectorLike):com.facebook.user.names.ContactAlphabeticIndexUtils");
    }

    private static ContactAlphabeticIndexUtils m14108b(InjectorLike injectorLike) {
        return new ContactAlphabeticIndexUtils(LocaleMethodAutoProvider.b(injectorLike));
    }

    public final boolean m14111a() {
        boolean z = false;
        if (this.f13252g.isSet()) {
            return this.f13252g.asBoolean();
        }
        if (VERSION.SDK_INT < 18) {
            this.f13252g = TriState.NO;
            return false;
        }
        try {
            AlphabeticIndexWrapper alphabeticIndexWrapper = new AlphabeticIndexWrapper(Locale.getDefault(), ImmutableList.of(), 300);
            z = true;
        } catch (ClassNotFoundException e) {
        } catch (IllegalAccessException e2) {
        } catch (InvocationTargetException e3) {
        } catch (InstantiationException e4) {
        } catch (NoSuchMethodException e5) {
        }
        this.f13252g = TriState.valueOf(z);
        return this.f13252g.asBoolean();
    }

    @Inject
    public ContactAlphabeticIndexUtils(Locale locale) {
        if (locale == null) {
            this.f13253i = Locale.getDefault();
        } else {
            this.f13253i = locale;
        }
        this.f13254j = this.f13253i.getLanguage().toLowerCase();
    }

    public final String m14110a(String str) {
        m14109b();
        try {
            return this.f13255k.m4159a(this.f13255k.m4158a(str));
        } catch (Throwable e) {
            BLog.a(f13249f, e, "Internal error getting label for %s", new Object[]{str});
            return null;
        } catch (Throwable e2) {
            BLog.a(f13249f, e2, "Access error getting label for %s", new Object[]{str});
            return null;
        }
    }

    private void m14109b() {
        if (this.f13255k == null) {
            AlphabeticIndexLocaleUtilsBase alphabeticIndexJapaneseUtils;
            try {
                if (this.f13254j.equals(f13250h)) {
                    alphabeticIndexJapaneseUtils = new AlphabeticIndexJapaneseUtils(this.f13253i);
                } else {
                    alphabeticIndexJapaneseUtils = new AlphabeticIndexLocaleUtilsBase(this.f13253i);
                }
            } catch (Throwable e) {
                BLog.a(f13249f, "ensureAlphabeticIndexLocaleUtils", e);
                alphabeticIndexJapaneseUtils = null;
            } catch (Throwable e2) {
                BLog.a(f13249f, "ensureAlphabeticIndexLocaleUtils", e2);
                alphabeticIndexJapaneseUtils = null;
            } catch (Throwable e22) {
                BLog.a(f13249f, "ensureAlphabeticIndexLocaleUtils", e22);
                alphabeticIndexJapaneseUtils = null;
            } catch (Throwable e222) {
                BLog.a(f13249f, "ensureAlphabeticIndexLocaleUtils", e222);
                alphabeticIndexJapaneseUtils = null;
            } catch (Throwable e2222) {
                BLog.a(f13249f, "ensureAlphabeticIndexLocaleUtils", e2222);
                alphabeticIndexJapaneseUtils = null;
            }
            this.f13255k = alphabeticIndexJapaneseUtils;
        }
        if (this.f13255k == null) {
            throw new IllegalStateException("Unable to instantiate AlphabeticIndexLocaleUtils.isAlphabeticIndexAvailable should be called first");
        }
    }
}
