package com.facebook.user.names;

import android.annotation.SuppressLint;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@SuppressLint({"UseSparseArrays"})
/* compiled from: eligible_for_survey */
public class ContactLocaleUtils {
    private static final String f13223b = Locale.CHINESE.getLanguage().toLowerCase();
    private static final String f13224c = Locale.JAPANESE.getLanguage().toLowerCase();
    private static final String f13225d = Locale.KOREAN.getLanguage().toLowerCase();
    private static volatile ContactLocaleUtils f13226h;
    public Lazy<HanziToPinyin> f13227a;
    private HashMap<Integer, ContactLocaleUtilsBase> f13228e = new HashMap();
    private ContactLocaleUtilsBase f13229f = new ContactLocaleUtilsBase(this);
    public String f13230g;

    /* compiled from: eligible_for_survey */
    public class ContactLocaleUtilsBase {
        final /* synthetic */ ContactLocaleUtils f13231b;

        public ContactLocaleUtilsBase(ContactLocaleUtils contactLocaleUtils) {
            this.f13231b = contactLocaleUtils;
        }

        public String m14091a(String str) {
            return str;
        }

        public Iterator<String> m14092b(String str) {
            return null;
        }
    }

    public static com.facebook.user.names.ContactLocaleUtils m14085a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13226h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.user.names.ContactLocaleUtils.class;
        monitor-enter(r1);
        r0 = f13226h;	 Catch:{ all -> 0x003a }
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
        r0 = m14087b(r0);	 Catch:{ all -> 0x0035 }
        f13226h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13226h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.user.names.ContactLocaleUtils.a(com.facebook.inject.InjectorLike):com.facebook.user.names.ContactLocaleUtils");
    }

    private static ContactLocaleUtils m14087b(InjectorLike injectorLike) {
        return new ContactLocaleUtils(IdBasedLazy.a(injectorLike, 11534));
    }

    @Inject
    public ContactLocaleUtils(Lazy<HanziToPinyin> lazy) {
        this.f13227a = lazy;
        Locale locale = null;
        if (locale == null) {
            this.f13230g = Locale.getDefault().getLanguage().toLowerCase();
        } else {
            this.f13230g = locale.getLanguage().toLowerCase();
        }
    }

    public final String m14089a(String str, int i) {
        return m14088c(Integer.valueOf(i)).m14091a(str);
    }

    public final Iterator<String> m14090b(String str, int i) {
        return m14084a(Integer.valueOf(i)).m14092b(str);
    }

    private ContactLocaleUtilsBase m14084a(Integer num) {
        int intValue = num.intValue();
        Integer valueOf = Integer.valueOf(m14083a(intValue));
        if (f13223b.equals(this.f13230g) && intValue == 1) {
            valueOf = Integer.valueOf(3);
        }
        return m14086b(valueOf);
    }

    private synchronized ContactLocaleUtilsBase m14086b(Integer num) {
        ContactLocaleUtilsBase contactLocaleUtilsBase;
        contactLocaleUtilsBase = (ContactLocaleUtilsBase) this.f13228e.get(num);
        if (contactLocaleUtilsBase == null && num.intValue() == 3) {
            contactLocaleUtilsBase = new ChineseContactUtils(this);
            this.f13228e.put(num, contactLocaleUtilsBase);
        }
        if (contactLocaleUtilsBase == null) {
            contactLocaleUtilsBase = this.f13229f;
        }
        return contactLocaleUtilsBase;
    }

    private ContactLocaleUtilsBase m14088c(Integer num) {
        return m14086b(Integer.valueOf(m14083a(num.intValue())));
    }

    private int m14083a(int i) {
        if (i != 2 || f13224c.equals(this.f13230g) || f13225d.equals(this.f13230g)) {
            return i;
        }
        return 3;
    }
}
