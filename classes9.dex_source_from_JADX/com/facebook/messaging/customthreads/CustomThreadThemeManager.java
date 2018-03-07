package com.facebook.messaging.customthreads;

import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: media_picker/ */
public class CustomThreadThemeManager {
    public static final CustomThreadTheme f10244a;
    public static final CustomThreadTheme f10245b;
    public static final CustomThreadTheme f10246c;
    public static final CustomThreadTheme f10247d;
    public static final CustomThreadTheme f10248e;
    public static final CustomThreadTheme f10249f;
    public static final CustomThreadTheme f10250g;
    public static final CustomThreadTheme f10251h;
    public static final CustomThreadTheme f10252i;
    public static final CustomThreadTheme f10253j;
    public static final CustomThreadTheme f10254k;
    private static volatile CustomThreadThemeManager f10255o;
    private final XConfigReader f10256l;
    private final FbObjectMapper f10257m;
    public List<CustomThreadTheme> f10258n;

    public static com.facebook.messaging.customthreads.CustomThreadThemeManager m10856a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f10255o;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.customthreads.CustomThreadThemeManager.class;
        monitor-enter(r1);
        r0 = f10255o;	 Catch:{ all -> 0x003a }
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
        r0 = m10858b(r0);	 Catch:{ all -> 0x0035 }
        f10255o = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10255o;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.customthreads.CustomThreadThemeManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.customthreads.CustomThreadThemeManager");
    }

    private static CustomThreadThemeManager m10858b(InjectorLike injectorLike) {
        return new CustomThreadThemeManager(XConfigReader.a(injectorLike), FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    static {
        CustomThreadThemeBuilder newBuilder = CustomThreadTheme.newBuilder();
        newBuilder.f10242d = -1381654;
        newBuilder = newBuilder;
        newBuilder.f10243e = -16743169;
        f10244a = newBuilder.m10854f();
        newBuilder = CustomThreadTheme.newBuilder();
        newBuilder.f10239a = -1033943;
        newBuilder = newBuilder;
        newBuilder.f10240b = -14079703;
        newBuilder = newBuilder;
        newBuilder.f10241c = -4709610;
        newBuilder = newBuilder;
        newBuilder.f10242d = -1033943;
        f10245b = newBuilder.m10854f();
        newBuilder = CustomThreadTheme.newBuilder();
        newBuilder.f10239a = -45908;
        newBuilder = newBuilder;
        newBuilder.f10240b = -7598;
        newBuilder = newBuilder;
        newBuilder.f10241c = -2739329;
        newBuilder = newBuilder;
        newBuilder.f10242d = -45908;
        f10246c = newBuilder.m10854f();
        newBuilder = CustomThreadTheme.newBuilder();
        newBuilder.f10239a = -6672393;
        newBuilder = newBuilder;
        newBuilder.f10240b = -1118482;
        newBuilder = newBuilder;
        newBuilder.f10241c = -9429292;
        newBuilder = newBuilder;
        newBuilder.f10242d = -6672393;
        f10247d = newBuilder.m10854f();
        newBuilder = CustomThreadTheme.newBuilder();
        newBuilder.f10239a = -16743169;
        newBuilder = newBuilder;
        newBuilder.f10240b = -16640;
        newBuilder = newBuilder;
        newBuilder.f10241c = -14985524;
        newBuilder = newBuilder;
        newBuilder.f10242d = -16743169;
        f10248e = newBuilder.m10854f();
        newBuilder = CustomThreadTheme.newBuilder();
        newBuilder.f10239a = -16726316;
        newBuilder = newBuilder;
        newBuilder.f10240b = -45908;
        newBuilder = newBuilder;
        newBuilder.f10241c = -16738371;
        newBuilder = newBuilder;
        newBuilder.f10242d = -16726316;
        f10249f = newBuilder.m10854f();
        newBuilder = CustomThreadTheme.newBuilder();
        newBuilder.f10239a = -16736443;
        newBuilder = newBuilder;
        newBuilder.f10240b = -3083008;
        newBuilder = newBuilder;
        newBuilder.f10241c = -15499974;
        newBuilder = newBuilder;
        newBuilder.f10242d = -16736443;
        f10250g = newBuilder.m10854f();
        newBuilder = CustomThreadTheme.newBuilder();
        newBuilder.f10239a = -6106112;
        newBuilder = newBuilder;
        newBuilder.f10240b = -43948;
        newBuilder = newBuilder;
        newBuilder.f10241c = -9067776;
        newBuilder = newBuilder;
        newBuilder.f10242d = -6106112;
        f10251h = newBuilder.m10854f();
        newBuilder = CustomThreadTheme.newBuilder();
        newBuilder.f10239a = -16640;
        newBuilder = newBuilder;
        newBuilder.f10240b = -8978177;
        newBuilder = newBuilder;
        newBuilder.f10241c = -1663744;
        newBuilder = newBuilder;
        newBuilder.f10242d = -16640;
        f10252i = newBuilder.m10854f();
        newBuilder = CustomThreadTheme.newBuilder();
        newBuilder.f10239a = -364770;
        newBuilder = newBuilder;
        newBuilder.f10240b = -11208;
        newBuilder = newBuilder;
        newBuilder.f10241c = -2862575;
        newBuilder = newBuilder;
        newBuilder.f10242d = -364770;
        f10253j = newBuilder.m10854f();
        newBuilder = CustomThreadTheme.newBuilder();
        newBuilder.f10239a = -14079703;
        newBuilder = newBuilder;
        newBuilder.f10240b = -12105913;
        newBuilder = newBuilder;
        newBuilder.f10241c = -15461356;
        newBuilder = newBuilder;
        newBuilder.f10242d = -14079703;
        f10254k = newBuilder.m10854f();
    }

    @Inject
    public CustomThreadThemeManager(XConfigReader xConfigReader, FbObjectMapper fbObjectMapper) {
        this.f10256l = xConfigReader;
        this.f10257m = fbObjectMapper;
        m10859b();
    }

    public final List<CustomThreadTheme> m10861a() {
        return this.f10258n;
    }

    private void m10859b() {
        this.f10258n = m10860c();
        if (this.f10258n == null) {
            List arrayList = new ArrayList();
            arrayList.add(f10244a);
            arrayList.add(f10245b);
            arrayList.add(f10246c);
            arrayList.add(f10247d);
            arrayList.add(f10248e);
            arrayList.add(f10249f);
            arrayList.add(f10250g);
            arrayList.add(f10251h);
            arrayList.add(f10252i);
            arrayList.add(f10253j);
            arrayList.add(f10254k);
            this.f10258n = arrayList;
        }
    }

    @Nullable
    private List<CustomThreadTheme> m10860c() {
        String a = this.f10256l.a(CustomThreadThemesXConfig.c, null);
        if (a == null) {
            return null;
        }
        try {
            JsonNode a2 = this.f10257m.a(a);
            List<CustomThreadTheme> arrayList = new ArrayList();
            arrayList.add(f10244a);
            Iterator it = a2.iterator();
            while (it.hasNext()) {
                CustomThreadTheme a3 = m10855a((JsonNode) it.next());
                if (a3 != null) {
                    arrayList.add(a3);
                }
            }
            return arrayList;
        } catch (IOException e) {
            return null;
        }
    }

    @Nullable
    private static CustomThreadTheme m10855a(JsonNode jsonNode) {
        Integer a = m10857a(jsonNode, "wallpaper_color");
        Integer a2 = m10857a(jsonNode, "me_color");
        Integer a3 = m10857a(jsonNode, "other_color");
        Integer a4 = m10857a(jsonNode, "bar_color");
        if (a == null || a2 == null || a3 == null || a4 == null) {
            return null;
        }
        CustomThreadThemeBuilder newBuilder = CustomThreadTheme.newBuilder();
        newBuilder.f10239a = a.intValue();
        CustomThreadThemeBuilder customThreadThemeBuilder = newBuilder;
        customThreadThemeBuilder.f10240b = a2.intValue();
        customThreadThemeBuilder = customThreadThemeBuilder;
        customThreadThemeBuilder.f10241c = a3.intValue();
        customThreadThemeBuilder = customThreadThemeBuilder;
        customThreadThemeBuilder.f10242d = a4.intValue();
        return customThreadThemeBuilder.m10854f();
    }

    @Nullable
    private static Integer m10857a(JsonNode jsonNode, String str) {
        Integer num = null;
        JsonNode b = jsonNode.b(str);
        if (b != null && b.o()) {
            try {
                num = Integer.valueOf((int) Long.parseLong(b.s(), 16));
            } catch (NumberFormatException e) {
            }
        }
        return num;
    }
}
