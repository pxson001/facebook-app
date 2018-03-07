package com.facebook.fbui.runtimelinter.rules;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.runtimelinter.RuntimeLinterRule;
import com.facebook.fbui.viewdescriptionbuilder.ViewDescriptionBuilder;
import com.facebook.fbui.viewdescriptionbuilder.ViewDescriptionBuilder$ViewTraversalMode;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: YOUR_POSTS_RHC */
public final class MaximumViewDepthRule implements RuntimeLinterRule {
    private static volatile MaximumViewDepthRule f12201e;
    public final ViewDescriptionBuilder f12202b;
    public final ObjectMapper f12203c;
    private final AbstractFbErrorReporter f12204d;

    public static com.facebook.fbui.runtimelinter.rules.MaximumViewDepthRule m20216a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12201e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.fbui.runtimelinter.rules.MaximumViewDepthRule.class;
        monitor-enter(r1);
        r0 = f12201e;	 Catch:{ all -> 0x003a }
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
        r0 = m20217b(r0);	 Catch:{ all -> 0x0035 }
        f12201e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12201e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbui.runtimelinter.rules.MaximumViewDepthRule.a(com.facebook.inject.InjectorLike):com.facebook.fbui.runtimelinter.rules.MaximumViewDepthRule");
    }

    private static MaximumViewDepthRule m20217b(InjectorLike injectorLike) {
        return new MaximumViewDepthRule(ViewDescriptionBuilder.b(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public MaximumViewDepthRule(ViewDescriptionBuilder viewDescriptionBuilder, ObjectMapper objectMapper, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f12202b = viewDescriptionBuilder;
        this.f12203c = objectMapper;
        this.f12204d = abstractFbErrorReporter;
    }

    public final boolean mo1223a(ViewGroup viewGroup, Map<String, String> map) {
        ArrayNode f = this.f12203c.f();
        map.put("max_view_depth", String.valueOf(m20214a((View) viewGroup, f)));
        int e = f.e();
        if (e == 0) {
            return false;
        }
        Object a;
        map.put("num_rule_breakers", String.valueOf(e));
        try {
            a = this.f12203c.a(f);
        } catch (Throwable e2) {
            Throwable th = e2;
            String str = "Error serializing rule breakers: ";
            a = str + th.toString();
            this.f12204d.a(str + getClass().getSimpleName(), th);
            BLog.b(a, str, th);
        }
        map.put("rule_breakers", a);
        return true;
    }

    private int m20214a(View view, ArrayNode arrayNode) {
        return m20215a(view, arrayNode, -1);
    }

    private int m20215a(View view, ArrayNode arrayNode, int i) {
        int i2 = i + 1;
        if (view.getVisibility() != 0) {
            return i2;
        }
        int i3;
        if (i2 > 19) {
            ObjectNode e = this.f12203c.e();
            e.c("offending_view", this.f12202b.b(view, ViewDescriptionBuilder$ViewTraversalMode.NONE));
            e.a("offending_view_depth", String.valueOf(i2));
            arrayNode.a(e);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            int i4 = 0;
            i3 = i2;
            while (i4 < childCount) {
                int a = m20215a(viewGroup.getChildAt(i4), arrayNode, i2);
                if (a <= i3) {
                    a = i3;
                }
                i4++;
                i3 = a;
            }
        } else {
            i3 = i2;
        }
        return i3;
    }

    public final String mo1222a() {
        StringBuilder stringBuilder = new StringBuilder(130);
        stringBuilder.append("Flatten view hierarchies. Don't add ViewGroups when they're unnecessary");
        stringBuilder.append(". Consider using LayoutParams to achieve your layout needs.");
        return stringBuilder.toString();
    }

    public final String mo1224b() {
        return "View Hierarchy Too Deep";
    }
}
