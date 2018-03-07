package com.facebook.katana.features.bugreporter;

import android.content.Context;
import android.net.Uri;
import com.facebook.bugreporter.BugReporterConfig;
import com.facebook.bugreporter.activity.categorylist.CategoryInfo;
import com.facebook.bugreporter.activity.chooser.ChooserOption;
import com.facebook.bugreporter.analytics.BugReporterAnalyticsLogger.CoreEvent;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.InjectorLike;
import com.facebook.marketplace.tab.abtest.ExperimentsForMarketplaceTabAbtestModule;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: update_build */
public class Fb4aBugReporterConfig implements BugReporterConfig {
    private static volatile Fb4aBugReporterConfig f924d;
    private final ImmutableList<CategoryInfo> f925a;
    private final Context f926b;
    private final QeAccessor f927c;

    public static com.facebook.katana.features.bugreporter.Fb4aBugReporterConfig m972a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f924d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.features.bugreporter.Fb4aBugReporterConfig.class;
        monitor-enter(r1);
        r0 = f924d;	 Catch:{ all -> 0x003a }
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
        r0 = m974b(r0);	 Catch:{ all -> 0x0035 }
        f924d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f924d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.features.bugreporter.Fb4aBugReporterConfig.a(com.facebook.inject.InjectorLike):com.facebook.katana.features.bugreporter.Fb4aBugReporterConfig");
    }

    private static Fb4aBugReporterConfig m974b(InjectorLike injectorLike) {
        return new Fb4aBugReporterConfig((Context) injectorLike.getInstance(Context.class, ForAppContext.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public Fb4aBugReporterConfig(@ForAppContext Context context, QeAccessor qeAccessor) {
        this.f926b = context;
        Builder builder = new Builder();
        this.f927c = qeAccessor;
        builder.b(new CategoryInfo[]{CategoryInfo.b(m973a(2131235833), 337626633011679L), CategoryInfo.b(m973a(2131235834), 297855413659693L), CategoryInfo.a(m973a(2131235835), 138551746296358L), CategoryInfo.a(m973a(2131235839), m973a(2131235840), 400385060038546L), CategoryInfo.b(m973a(2131235841), 103199433183080L), CategoryInfo.a(m973a(2131235842), m973a(2131235843), 286835824752176L), CategoryInfo.a(m973a(2131235844), 227679770697583L), CategoryInfo.b(m973a(2131235845), 607094879315866L), CategoryInfo.a(m973a(2131235846), m973a(2131235847), 393308357414341L), CategoryInfo.a(m973a(2131235848), 144239065723965L), CategoryInfo.b(m973a(2131235849), 455753877821540L), CategoryInfo.a(m973a(2131235850), 542057685839853L), CategoryInfo.a(m973a(2131235852), m973a(2131235853), 391791257648917L), CategoryInfo.a(m973a(2131235854), 299922733459834L), CategoryInfo.a(m973a(2131235855), 137158569769198L), CategoryInfo.b(m973a(2131235877), 962847767080023L), CategoryInfo.a(m973a(2131235856), 127519127406648L), CategoryInfo.a(m973a(2131235857), 619274784880955L), CategoryInfo.a(m973a(2131235859), 550788918269472L), CategoryInfo.a(m973a(2131235861), 295554083889525L), CategoryInfo.a(m973a(2131235862), 446673222057006L), CategoryInfo.b(m973a(2131235876), 669565466435907L), CategoryInfo.a(m973a(2131235860), 384567634994691L), CategoryInfo.a(m973a(2131235864), 474280492611187L), CategoryInfo.a(m973a(2131235866), 184260628378721L), CategoryInfo.b(m973a(2131235868), 1711163495779305L), CategoryInfo.b(m973a(2131235871), 210094942460077L)});
        if (this.f927c.a(ExperimentsForMarketplaceTabAbtestModule.a, false)) {
            builder.c(CategoryInfo.a(m973a(2131235883), 619055418244390L));
        }
        this.f925a = builder.b();
    }

    public final ImmutableList<CategoryInfo> m975a() {
        return this.f925a;
    }

    public final ImmutableList<ChooserOption> m976b() {
        ChooserOption.Builder builder = new ChooserOption.Builder(2131235827, StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, Uri.encode("https://m.facebook.com/help/contact/268228883256323?refid=69")));
        builder.c = 2131235828;
        builder = builder;
        builder.d = CoreEvent.RAP_SELECT_FEEDBACK;
        ChooserOption a = builder.a();
        ChooserOption.Builder builder2 = new ChooserOption.Builder(2131235829, ChooserOption.a);
        builder2.c = 2131235830;
        builder2 = builder2;
        builder2.d = CoreEvent.RAP_SELECT_BUG;
        ChooserOption a2 = builder2.a();
        ChooserOption.Builder builder3 = new ChooserOption.Builder(2131235831, StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, Uri.encode("https://m.facebook.com/help/319931211461990?refid=69")));
        builder3.c = 2131235832;
        builder3 = builder3;
        builder3.d = CoreEvent.RAP_SELECT_ABUSE;
        return ImmutableList.of(a, a2, builder3.a());
    }

    private String m973a(int i) {
        return this.f926b.getString(i);
    }
}
