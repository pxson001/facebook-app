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
/* compiled from: YOUR_POSTS_PAGE_OTHER_GROUPS */
public final class UnnecessaryViewGroupRule implements RuntimeLinterRule {
    private static volatile UnnecessaryViewGroupRule f12205e;
    public final ViewDescriptionBuilder f12206b;
    public final ObjectMapper f12207c;
    private final AbstractFbErrorReporter f12208d;

    public static com.facebook.fbui.runtimelinter.rules.UnnecessaryViewGroupRule m20221a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12205e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.fbui.runtimelinter.rules.UnnecessaryViewGroupRule.class;
        monitor-enter(r1);
        r0 = f12205e;	 Catch:{ all -> 0x003a }
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
        r0 = m20223b(r0);	 Catch:{ all -> 0x0035 }
        f12205e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12205e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbui.runtimelinter.rules.UnnecessaryViewGroupRule.a(com.facebook.inject.InjectorLike):com.facebook.fbui.runtimelinter.rules.UnnecessaryViewGroupRule");
    }

    private static UnnecessaryViewGroupRule m20223b(InjectorLike injectorLike) {
        return new UnnecessaryViewGroupRule(ViewDescriptionBuilder.b(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public UnnecessaryViewGroupRule(ViewDescriptionBuilder viewDescriptionBuilder, ObjectMapper objectMapper, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f12206b = viewDescriptionBuilder;
        this.f12207c = objectMapper;
        this.f12208d = abstractFbErrorReporter;
    }

    public final boolean mo1223a(ViewGroup viewGroup, Map<String, String> map) {
        ArrayNode f = this.f12207c.f();
        m20222a(viewGroup, f);
        int e = f.e();
        if (e == 0) {
            return false;
        }
        Object a;
        map.put("num_rule_breakers", String.valueOf(e));
        try {
            a = this.f12207c.a(f);
        } catch (Throwable e2) {
            Throwable th = e2;
            String str = "Error serializing rule breakers: ";
            a = str + th.toString();
            this.f12208d.a(str + getClass().getSimpleName(), th);
            BLog.b(a, str, th);
        }
        map.put("rule_breakers", a);
        return true;
    }

    public final String mo1222a() {
        return "ViewGroups that have less than two children are often unnecessary. Merge the important properties to neighboring Views and remove this ViewGroup.";
    }

    public final String mo1224b() {
        return "Unnecessary ViewGroup";
    }

    private void m20222a(ViewGroup viewGroup, ArrayNode arrayNode) {
        View childAt;
        int i = 0;
        if (viewGroup.getChildCount() < 2) {
            childAt = viewGroup.getChildCount() == 0 ? null : viewGroup.getChildAt(0);
            ObjectNode e = this.f12207c.e();
            e.c("offending_view_group", this.f12206b.b(viewGroup, ViewDescriptionBuilder$ViewTraversalMode.NONE));
            if (childAt != null) {
                e.c("offending_view_group_child", this.f12206b.b(childAt, ViewDescriptionBuilder$ViewTraversalMode.NONE));
            }
            arrayNode.a(e);
        }
        while (i < viewGroup.getChildCount()) {
            childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                m20222a((ViewGroup) childAt, arrayNode);
            }
            i++;
        }
    }
}
