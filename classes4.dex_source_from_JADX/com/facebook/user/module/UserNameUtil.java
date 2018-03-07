package com.facebook.user.module;

import com.facebook.common.locale.Locales;
import com.facebook.graphql.enums.GraphQLStructuredNamePart;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces$DefaultNamePartFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultNameFields;
import com.facebook.inject.InjectorLike;
import com.facebook.user.model.Name;
import com.facebook.user.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: is_live_streaming */
public class UserNameUtil {
    private static final String f9994b = Locale.JAPANESE.getLanguage().toLowerCase(Locale.US);
    private static final String f9995c = Locale.KOREAN.getLanguage().toLowerCase(Locale.US);
    private static final String f9996d = Locale.CHINESE.getLanguage().toLowerCase(Locale.US);
    private static volatile UserNameUtil f9997e;
    private final Locales f9998a;

    public static com.facebook.user.module.UserNameUtil m10377a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9997e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.user.module.UserNameUtil.class;
        monitor-enter(r1);
        r0 = f9997e;	 Catch:{ all -> 0x003a }
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
        r0 = m10380b(r0);	 Catch:{ all -> 0x0035 }
        f9997e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9997e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.user.module.UserNameUtil.a(com.facebook.inject.InjectorLike):com.facebook.user.module.UserNameUtil");
    }

    private static UserNameUtil m10380b(InjectorLike injectorLike) {
        return new UserNameUtil(Locales.a(injectorLike));
    }

    @Inject
    public UserNameUtil(Locales locales) {
        this.f9998a = locales;
    }

    @Nullable
    public final String m10383a(User user) {
        if (user == null) {
            return null;
        }
        if (m10379a()) {
            String k = user.k();
            if (k != null) {
                return k;
            }
        }
        String b = m10381b(user.e);
        if (Strings.isNullOrEmpty(b)) {
            Object obj;
            if (user.c.isEmpty()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                b = user.u();
            } else {
                b = null;
            }
        }
        return b;
    }

    @Nullable
    public final String m10382a(Name name) {
        if (name == null) {
            return null;
        }
        if (m10379a()) {
            String i = name.i();
            if (i != null) {
                return i;
            }
        }
        return m10381b(name);
    }

    @Nullable
    public static String m10381b(Name name) {
        if (name.b()) {
            return name.a();
        }
        if (name.e()) {
            return name.f();
        }
        if (name.h()) {
            return name.g();
        }
        return null;
    }

    public static Name m10376a(DefaultNameFields defaultNameFields) {
        String str = null;
        if (defaultNameFields == null) {
            return null;
        }
        String s_ = defaultNameFields.s_();
        ImmutableList<CommonGraphQL2Interfaces$DefaultNamePartFields> a = defaultNameFields.a();
        if (!a.isEmpty()) {
            String str2 = null;
            for (CommonGraphQL2Interfaces$DefaultNamePartFields commonGraphQL2Interfaces$DefaultNamePartFields : a) {
                int t_ = commonGraphQL2Interfaces$DefaultNamePartFields.t_();
                int a2 = commonGraphQL2Interfaces$DefaultNamePartFields.mo139a();
                GraphQLStructuredNamePart c = commonGraphQL2Interfaces$DefaultNamePartFields.mo140c();
                int offsetByCodePoints = s_.offsetByCodePoints(0, t_);
                String substring = s_.substring(offsetByCodePoints, s_.offsetByCodePoints(offsetByCodePoints, a2));
                if (Objects.equal(c, GraphQLStructuredNamePart.FIRST)) {
                    str2 = substring;
                } else {
                    if (!Objects.equal(c, GraphQLStructuredNamePart.LAST)) {
                        substring = str;
                    }
                    str = substring;
                }
            }
            return new Name(str2, str, s_);
        } else if (s_ != null) {
            return new Name(s_);
        } else {
            return null;
        }
    }

    @JsonIgnore
    public static String m10378a(Name name, Name name2) {
        if (name == null || name.g() == null) {
            return null;
        }
        String str = "";
        if (name2 != null) {
            str = name2.i();
        }
        if (str.length() <= 0) {
            return name.g();
        }
        return str;
    }

    private boolean m10379a() {
        String language = this.f9998a.a().getLanguage();
        return f9994b.equalsIgnoreCase(language) || f9995c.equalsIgnoreCase(language) || f9996d.equalsIgnoreCase(language);
    }
}
