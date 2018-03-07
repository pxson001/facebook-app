package com.facebook.fbui.viewdescriptionbuilder;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: YOUR_POSTS_ISLAND_NAV */
public class LayoutParamsFormatter {
    public static final String[] f12211a = new String[]{"LEFT_OF", "RIGHT_OF", "ABOVE", "BELOW", "ALIGN_BASELINE", "ALIGN_LEFT", "ALIGN_TOP", "ALIGN_RIGHT", "ALIGN_BOTTOM", "ALIGN_PARENT_LEFT", "ALIGN_PARENT_TOP", "ALIGN_PARENT_RIGHT", "ALIGN_PARENT_BOTTOM", "CENTER_IN_PARENT", "CENTER_HORIZONTAL", "CENTER_VERTICAL", "START_OF", "END_OF", "ALIGN_START", "ALIGN_END", "ALIGN_PARENT_START", "ALIGN_PARENT_END"};
    private static final ImmutableMap<Integer, String> f12212b = ImmutableMap.builder().b(Integer.valueOf(0), "NO_GRAVITY").b(Integer.valueOf(48), "TOP").b(Integer.valueOf(80), "BOTTOM").b(Integer.valueOf(3), "LEFT").b(Integer.valueOf(5), "RIGHT").b(Integer.valueOf(8388611), "START").b(Integer.valueOf(8388613), "END").b(Integer.valueOf(16), "CENTER_VERTICAL").b(Integer.valueOf(112), "FILL_VERTICAL").b(Integer.valueOf(1), "CENTER_HORIZONTAL").b(Integer.valueOf(7), "FILL_HORIZONTAL").b(Integer.valueOf(17), "CENTER").b(Integer.valueOf(119), "FILL").b();
    private static volatile LayoutParamsFormatter f12213e;
    private final ViewIdExtractor f12214c;
    public final Context f12215d;

    public static com.facebook.fbui.viewdescriptionbuilder.LayoutParamsFormatter m20229a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12213e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.fbui.viewdescriptionbuilder.LayoutParamsFormatter.class;
        monitor-enter(r1);
        r0 = f12213e;	 Catch:{ all -> 0x003a }
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
        r0 = m20231b(r0);	 Catch:{ all -> 0x0035 }
        f12213e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12213e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbui.viewdescriptionbuilder.LayoutParamsFormatter.a(com.facebook.inject.InjectorLike):com.facebook.fbui.viewdescriptionbuilder.LayoutParamsFormatter");
    }

    private static LayoutParamsFormatter m20231b(InjectorLike injectorLike) {
        return new LayoutParamsFormatter(ViewIdExtractor.m20238a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public LayoutParamsFormatter(ViewIdExtractor viewIdExtractor, Context context) {
        this.f12214c = viewIdExtractor;
        this.f12215d = context;
    }

    public final Bundle m20233a(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return null;
        }
        return m20228a(layoutParams);
    }

    private Bundle m20228a(LayoutParams layoutParams) {
        Bundle bundle = new Bundle();
        bundle.putString("type", layoutParams.getClass().getName());
        bundle.putString("height", m20230a(layoutParams.height));
        bundle.putString("width", m20230a(layoutParams.width));
        if (layoutParams instanceof MarginLayoutParams) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
            Bundle bundle2 = new Bundle(4);
            bundle2.putInt("left", marginLayoutParams.leftMargin);
            bundle2.putInt("top", marginLayoutParams.topMargin);
            bundle2.putInt("right", marginLayoutParams.rightMargin);
            bundle2.putInt("bottom", marginLayoutParams.bottomMargin);
            bundle.putBundle("margins", bundle2);
        }
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            bundle.putString("gravity", m20232b(layoutParams2.gravity));
            bundle.putFloat("weight", layoutParams2.weight);
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams;
            String str = "rules";
            Bundle bundle3 = new Bundle();
            int[] rules = layoutParams3.getRules();
            for (int i = 0; i < rules.length - 1; i++) {
                if (rules[i] != 0) {
                    bundle3.putString(f12211a[i], rules[i] == -1 ? "true" : ViewIdExtractor.m20239a(this.f12215d, rules[i]));
                }
            }
            if (bundle3.isEmpty()) {
                bundle2 = null;
            } else {
                bundle2 = bundle3;
            }
            bundle.putBundle(str, bundle2);
        }
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            bundle.putString("gravity", m20232b(((FrameLayout.LayoutParams) layoutParams).gravity));
        }
        return bundle;
    }

    private static String m20230a(int i) {
        if (i == -1) {
            return "MATCH_PARENT";
        }
        if (i == -2) {
            return "WRAP_CONTENT";
        }
        return String.valueOf(i);
    }

    private static String m20232b(int i) {
        if (i == -1) {
            return "NONE";
        }
        StringBuilder stringBuilder = new StringBuilder();
        List a = Lists.a();
        Iterator it = f12212b.keySet().iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if ((intValue & i) == intValue) {
                a.add(Integer.valueOf(intValue));
            }
        }
        if (a.contains(Integer.valueOf(17))) {
            a.remove(Integer.valueOf(1));
            a.remove(Integer.valueOf(16));
        }
        if (a.contains(Integer.valueOf(7))) {
            a.remove(Integer.valueOf(3));
            a.remove(Integer.valueOf(5));
        }
        if (a.contains(Integer.valueOf(112))) {
            a.remove(Integer.valueOf(48));
            a.remove(Integer.valueOf(80));
        }
        stringBuilder.append(Joiner.on("|").join(a.toArray()));
        return stringBuilder.toString();
    }
}
