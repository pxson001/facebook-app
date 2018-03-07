package com.facebook.fbui.runtimelinter.rules;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
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
/* compiled from: YOUTH_ORGANIZATION */
public final class ListViewInRelativeLayoutRule implements RuntimeLinterRule {
    private static volatile ListViewInRelativeLayoutRule f12196e;
    public final ViewDescriptionBuilder f12197b;
    public final ObjectMapper f12198c;
    private final AbstractFbErrorReporter f12199d;

    public static com.facebook.fbui.runtimelinter.rules.ListViewInRelativeLayoutRule m20202a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12196e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.fbui.runtimelinter.rules.ListViewInRelativeLayoutRule.class;
        monitor-enter(r1);
        r0 = f12196e;	 Catch:{ all -> 0x003a }
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
        r0 = m20204b(r0);	 Catch:{ all -> 0x0035 }
        f12196e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12196e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbui.runtimelinter.rules.ListViewInRelativeLayoutRule.a(com.facebook.inject.InjectorLike):com.facebook.fbui.runtimelinter.rules.ListViewInRelativeLayoutRule");
    }

    private static ListViewInRelativeLayoutRule m20204b(InjectorLike injectorLike) {
        return new ListViewInRelativeLayoutRule(ViewDescriptionBuilder.b(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public ListViewInRelativeLayoutRule(ViewDescriptionBuilder viewDescriptionBuilder, ObjectMapper objectMapper, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f12197b = viewDescriptionBuilder;
        this.f12198c = objectMapper;
        this.f12199d = abstractFbErrorReporter;
    }

    public final boolean mo1223a(ViewGroup viewGroup, Map<String, String> map) {
        ArrayNode f = this.f12198c.f();
        m20203a(viewGroup, f, null, 0);
        int e = f.e();
        if (e == 0) {
            return false;
        }
        Object a;
        map.put("num_rule_breakers", String.valueOf(e));
        try {
            a = this.f12198c.a(f);
        } catch (Throwable e2) {
            Throwable th = e2;
            String str = "Error serializing rule breakers: ";
            a = str + th.toString();
            this.f12199d.a(str + getClass().getSimpleName(), th);
            BLog.b(a, str, th);
        }
        map.put("rule_breakers", a);
        return true;
    }

    public final String mo1222a() {
        return "If you host a ListView inside a RelativeLayout, perf is gonna have a bad time.";
    }

    public final String mo1224b() {
        return "ListView child of RelativeLayout";
    }

    private void m20203a(ViewGroup viewGroup, ArrayNode arrayNode, RelativeLayout relativeLayout, int i) {
        if (relativeLayout != null) {
            if (viewGroup instanceof ListView) {
                ListView listView = (ListView) viewGroup;
                ObjectNode e = this.f12198c.e();
                e.c("top_level_offending_relative_layout", this.f12197b.b(relativeLayout, ViewDescriptionBuilder$ViewTraversalMode.NONE));
                e.c("offending_list_view", this.f12197b.b(listView, ViewDescriptionBuilder$ViewTraversalMode.NONE));
                e.a("num_relative_layouts_in_listview_path", i);
                arrayNode.a(e);
                return;
            } else if (viewGroup instanceof RelativeLayout) {
                i++;
            }
        } else if (viewGroup instanceof RelativeLayout) {
            i = 1;
            relativeLayout = (RelativeLayout) viewGroup;
        }
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof ViewGroup) {
                m20203a((ViewGroup) childAt, arrayNode, relativeLayout, i);
            }
        }
    }
}
