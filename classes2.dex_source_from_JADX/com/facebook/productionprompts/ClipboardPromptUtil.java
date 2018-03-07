package com.facebook.productionprompts;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.content.Context;
import android.util.Patterns;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.SystemClock;
import com.facebook.feed.inlinecomposer.v2attachment.V2PromptUtil;
import com.facebook.graphql.enums.GraphQLPromptType;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import com.facebook.productionprompts.common.PromptsInternalSettingsController;
import com.facebook.productionprompts.model.ProductionPrompt;
import com.facebook.productionprompts.model.ProductionPromptBuilder;
import com.facebook.productionprompts.prefs.PromptsPrefKeys;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UserScoped
/* compiled from: network_info_active_write_seconds */
public class ClipboardPromptUtil {
    private static final String f12706a = GraphQLPromptType.CLIPBOARD.toString();
    private static final Object f12707k = new Object();
    public final ClipboardManager f12708b;
    private final String f12709c = V2PromptUtil.m18712a(2130838089).toString();
    private final String f12710d;
    private final String f12711e;
    public final PromptsExperimentHelper f12712f;
    private final AbstractFbErrorReporter f12713g;
    private final V2PromptUtil f12714h;
    private final FbSharedPreferences f12715i;
    private final PromptsInternalSettingsController f12716j;

    /* compiled from: network_info_active_write_seconds */
    public class C05241 implements OnPrimaryClipChangedListener {
        final /* synthetic */ ClipboardPromptUtil f12764a;

        public C05241(ClipboardPromptUtil clipboardPromptUtil) {
            this.f12764a = clipboardPromptUtil;
        }

        public void onPrimaryClipChanged() {
            ClipboardPromptUtil.m18769e(this.f12764a);
        }
    }

    private static ClipboardPromptUtil m18768b(InjectorLike injectorLike) {
        return new ClipboardPromptUtil((Context) injectorLike.getInstance(Context.class), PromptsExperimentHelper.m15312b(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), V2PromptUtil.m18713b(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), PromptsInternalSettingsController.m18718a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.productionprompts.ClipboardPromptUtil m18766a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.m1499a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.mo191b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.m1454a(r1);
        r4 = r3.m8951b();	 Catch:{ all -> 0x006c }
        r1 = f12707k;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.f724a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.m8952c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.m1504b(r1);	 Catch:{  }
        r6 = r0.m1455a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.m1474e();	 Catch:{ all -> 0x0062 }
        r1 = m18768b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.m1452a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f12707k;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.f724a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.productionprompts.ClipboardPromptUtil) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.m1505c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.productionprompts.ClipboardPromptUtil) r0;	 Catch:{  }
        r3.m8952c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.m1452a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.m1505c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.m8952c();
        throw r0;
    L_0x0071:
        r0 = f12707k;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.productionprompts.ClipboardPromptUtil) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.productionprompts.ClipboardPromptUtil.a(com.facebook.inject.InjectorLike):com.facebook.productionprompts.ClipboardPromptUtil");
    }

    @Inject
    public ClipboardPromptUtil(Context context, PromptsExperimentHelper promptsExperimentHelper, AbstractFbErrorReporter abstractFbErrorReporter, V2PromptUtil v2PromptUtil, FbSharedPreferences fbSharedPreferences, PromptsInternalSettingsController promptsInternalSettingsController) {
        this.f12712f = promptsExperimentHelper;
        this.f12713g = abstractFbErrorReporter;
        this.f12708b = (ClipboardManager) context.getSystemService("clipboard");
        this.f12714h = v2PromptUtil;
        this.f12715i = fbSharedPreferences;
        this.f12716j = promptsInternalSettingsController;
        this.f12710d = context.getString(2131238469);
        this.f12711e = context.getString(2131238470);
        if (this.f12712f.m15316f()) {
            this.f12708b.addPrimaryClipChangedListener(new C05241(this));
        }
    }

    public static void m18769e(ClipboardPromptUtil clipboardPromptUtil) {
        String g = clipboardPromptUtil.m18771g();
        if (g != null && !g.equals(clipboardPromptUtil.f12715i.mo278a(PromptsPrefKeys.f12795q, null))) {
            clipboardPromptUtil.f12715i.edit().mo1276a(PromptsPrefKeys.f12795q, g).mo1275a(PromptsPrefKeys.f12796r, SystemClock.f762a.mo211a() + 1800000).commit();
        }
    }

    public final boolean m18772a() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String a = this.f12715i.mo278a(PromptsPrefKeys.f12795q, null);
        Long valueOf = Long.valueOf(this.f12715i.mo277a(PromptsPrefKeys.f12796r, 0));
        Long valueOf2 = Long.valueOf(valueOf.longValue() - 1800000);
        String g = m18771g();
        if (!this.f12712f.m15316f() || 1 == 0) {
            z = false;
        } else {
            z = true;
        }
        if (a == null || SystemClock.f762a.mo211a() > valueOf.longValue()) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (a == null || !a.equals(g) || valueOf2.longValue() + 300000 >= SystemClock.f762a.mo211a()) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (a == null || !a.equals(g)) {
            z4 = false;
        } else {
            z4 = true;
        }
        boolean f = m18770f();
        m18767a(a, z, z3, z4, z2);
        if (z && !z3 && z4 && (z2 || f)) {
            return true;
        }
        return false;
    }

    private boolean m18770f() {
        return m18771g() != null;
    }

    @Nullable
    public final ProductionPrompt m18773b() {
        String str;
        if (m18770f()) {
            m18769e(this);
        }
        String a = this.f12715i.mo278a(PromptsPrefKeys.f12795q, null);
        Long valueOf = Long.valueOf(this.f12715i.mo277a(PromptsPrefKeys.f12796r, 0));
        Long valueOf2 = Long.valueOf(valueOf.longValue() - 1800000);
        Preconditions.checkNotNull(a);
        ProductionPromptBuilder productionPromptBuilder = new ProductionPromptBuilder("448167148704580:" + a.hashCode());
        productionPromptBuilder.f = valueOf2.longValue();
        ProductionPromptBuilder productionPromptBuilder2 = productionPromptBuilder;
        productionPromptBuilder2.g = valueOf.longValue();
        ProductionPromptBuilder productionPromptBuilder3 = productionPromptBuilder2;
        productionPromptBuilder3.p = f12706a;
        productionPromptBuilder3 = productionPromptBuilder3;
        productionPromptBuilder3.b = "Clipboard Prompt";
        productionPromptBuilder3 = productionPromptBuilder3;
        productionPromptBuilder3.c = this.f12710d;
        productionPromptBuilder2 = productionPromptBuilder3;
        if (this.f12712f.m15314c()) {
            str = a;
        } else {
            str = this.f12711e;
        }
        productionPromptBuilder2.d = str;
        productionPromptBuilder3 = productionPromptBuilder2;
        productionPromptBuilder3.e = this.f12709c;
        productionPromptBuilder3 = productionPromptBuilder3;
        productionPromptBuilder3.j = a;
        productionPromptBuilder3 = productionPromptBuilder3;
        productionPromptBuilder3.s = 0.1d;
        productionPromptBuilder3.t = "ranking_unavailable";
        return ProductionPrompt.a(productionPromptBuilder);
    }

    private String m18771g() {
        if (!this.f12708b.hasPrimaryClip()) {
            return null;
        }
        ClipData primaryClip = this.f12708b.getPrimaryClip();
        ClipDescription primaryClipDescription = this.f12708b.getPrimaryClipDescription();
        if (primaryClipDescription.getMimeTypeCount() > 0 && !primaryClipDescription.getMimeType(0).equals("text/plain")) {
            return null;
        }
        CharSequence text = primaryClip.getItemAt(0).getText();
        if (text == null) {
            this.f12713g.m2340a(ClipboardPromptUtil.class.getSimpleName(), "Converting clipboard data into text but is null. Current clip data is " + primaryClip);
            return null;
        } else if (Patterns.WEB_URL.matcher(text).matches()) {
            return text.toString();
        } else {
            return null;
        }
    }

    public final void m18774c() {
        this.f12715i.edit().mo1275a(PromptsPrefKeys.f12796r, SystemClock.f762a.mo211a()).commit();
    }

    private void m18767a(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        String str2 = null;
        if (!z) {
            str2 = "Clipboard is not enabled by GK or QE";
        } else if (z2) {
            str2 = "This link has been prompted before";
        } else if (!z3) {
            str2 = "Link in clipboard is replaced by something else";
        } else if (str == null) {
            str2 = "Text in clipboard is not a valid URI";
        } else if (!z4) {
            str2 = "Link expired. Needs to be copied in the last 1800000 ms";
        }
        this.f12716j.m18725a(f12706a, str2);
    }
}
