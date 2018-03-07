package com.facebook.katana.reportaproblem;

import android.content.Context;
import android.net.Uri;
import com.facebook.analytics.activityidentifier.ActivityNameFormatter;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.locale.Locales;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.marketplace.tab.abtest.ExperimentsForMarketplaceTabAbtestModule;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.reportaproblem.base.ReportAProblemForkOption;
import com.facebook.reportaproblem.base.bugreport.BugReportCategoryInfo;
import com.facebook.reportaproblem.base.bugreport.file.STATICDI_MULTIBIND_PROVIDER.BugReportActivityFileProvider;
import com.facebook.reportaproblem.base.bugreport.file.STATICDI_MULTIBIND_PROVIDER.BugReportBackgroundDataProvider;
import com.facebook.reportaproblem.base.bugreport.file.STATICDI_MULTIBIND_PROVIDER.BugReportFileProvider;
import com.facebook.reportaproblem.base.bugreport.file.STATICDI_MULTIBIND_PROVIDER.BugReportUiDataProvider;
import com.facebook.reportaproblem.fb.FbBitmapDecoder;
import com.facebook.reportaproblem.fb.FbBugReportMetadata;
import com.facebook.reportaproblem.fb.FbBugReportUploader;
import com.facebook.reportaproblem.fb.FbReportAProblemConfig;
import com.google.common.collect.Lists;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Unrecognized view type in createcollectionItemView */
public class Fb4aReportAProblemConfig extends FbReportAProblemConfig {
    private final QeAccessor f10408b;

    /* compiled from: Unrecognized view type in createcollectionItemView */
    class C12271 implements Comparator<BugReportCategoryInfo> {
        final /* synthetic */ Fb4aReportAProblemConfig f10407a;

        C12271(Fb4aReportAProblemConfig fb4aReportAProblemConfig) {
            this.f10407a = fb4aReportAProblemConfig;
        }

        public int compare(Object obj, Object obj2) {
            BugReportCategoryInfo bugReportCategoryInfo = (BugReportCategoryInfo) obj;
            BugReportCategoryInfo bugReportCategoryInfo2 = (BugReportCategoryInfo) obj2;
            String string = this.f10407a.a.getString(2131235871);
            if (bugReportCategoryInfo.a.equals(string)) {
                return 1;
            }
            if (bugReportCategoryInfo2.a.equals(string)) {
                return -1;
            }
            return bugReportCategoryInfo.a.compareTo(bugReportCategoryInfo2.a);
        }
    }

    public static Fb4aReportAProblemConfig m10808b(InjectorLike injectorLike) {
        return new Fb4aReportAProblemConfig((Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 640), IdBasedProvider.a(injectorLike, 4442), IdBasedProvider.a(injectorLike, 10238), BugReportFileProvider.a(injectorLike), BugReportActivityFileProvider.a(injectorLike), BugReportBackgroundDataProvider.a(injectorLike), BugReportUiDataProvider.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 968), IdBasedProvider.a(injectorLike, 10235), IdBasedProvider.a(injectorLike, 10236), IdBasedProvider.a(injectorLike, 147), IdBasedSingletonScopeProvider.a(injectorLike, 576), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public Fb4aReportAProblemConfig(Context context, Provider<TriState> provider, Provider<String> provider2, Provider<FbBugReportUploader> provider3, Provider<Set<com.facebook.reportaproblem.base.bugreport.file.BugReportFileProvider>> provider4, Provider<Set<com.facebook.reportaproblem.base.bugreport.file.BugReportActivityFileProvider>> provider5, Provider<Set<com.facebook.reportaproblem.base.bugreport.file.BugReportBackgroundDataProvider>> provider6, Provider<Set<com.facebook.reportaproblem.base.bugreport.file.BugReportUiDataProvider>> provider7, Provider<SecureContextHelper> provider8, Provider<FbBitmapDecoder> provider9, Provider<FbBugReportMetadata> provider10, Provider<ActivityNameFormatter> provider11, Provider<Locales> provider12, QeAccessor qeAccessor) {
        super(context, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
        this.f10408b = qeAccessor;
    }

    public final List<ReportAProblemForkOption> m10809a() {
        List<ReportAProblemForkOption> a = super.a();
        a.add(new ReportAProblemForkOption(this.a.getString(2131235831), Uri.parse(StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, Uri.encode("https://m.facebook.com/help/319931211461990?refid=69"))), 2130842857));
        a.add(new ReportAProblemForkOption(this.a.getString(2131235827), Uri.parse(StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, Uri.encode("https://m.facebook.com/help/contact/268228883256323?refid=69"))), 2130842860));
        return a;
    }

    protected final String m10810c() {
        return this.a.getString(2131235797);
    }

    protected final List<BugReportCategoryInfo> m10812e() {
        List a = Lists.a(new BugReportCategoryInfo[]{new BugReportCategoryInfo(this.a.getString(2131235833), 337626633011679L, 2130839673), new BugReportCategoryInfo(this.a.getString(2131235836), 138551746296358L, 2130839986), new BugReportCategoryInfo(this.a.getString(2131235844), 227679770697583L, 2130839851), new BugReportCategoryInfo(this.a.getString(2131235848), 144239065723965L, 2130839914), new BugReportCategoryInfo(this.a.getString(2131235850), 542057685839853L, 2130839969), new BugReportCategoryInfo(this.a.getString(2131235854), 299922733459834L, 2130840003), new BugReportCategoryInfo(this.a.getString(2131235855), 137158569769198L, 2130840056), new BugReportCategoryInfo(this.a.getString(2131235856), 127519127406648L, 2130839687), new BugReportCategoryInfo(this.a.getString(2131235859), 550788918269472L, 2130840019), new BugReportCategoryInfo(this.a.getString(2131235861), 295554083889525L, 2130839972), new BugReportCategoryInfo(this.a.getString(2131235862), 446673222057006L, 2130840058), new BugReportCategoryInfo(this.a.getString(2131235860), 384567634994691L, 2130840148), new BugReportCategoryInfo(this.a.getString(2131235865), 474280492611187L, 2130840089), new BugReportCategoryInfo(this.a.getString(2131235867), 184260628378721L, 2130839877), new BugReportCategoryInfo(this.a.getString(2131235882), 143135295835754L, 2130839681), new BugReportCategoryInfo(this.a.getString(2131235871), 210094942460077L, 2130839667)});
        if (this.f10408b.a(ExperimentsForMarketplaceTabAbtestModule.a, false)) {
            a.add(new BugReportCategoryInfo(this.a.getString(2131235883), 619055418244390L, 2130839681));
        }
        return a;
    }

    protected final List<BugReportCategoryInfo> m10813f() {
        return Lists.a(new BugReportCategoryInfo[]{new BugReportCategoryInfo("Bookmarks / Navigation", 297855413659693L, 2130839681), new BugReportCategoryInfo("Check Ins / Places", 400385060038546L, 2130842656), new BugReportCategoryInfo("Comments / Likes / Shares", 103199433183080L, 2130839681), new BugReportCategoryInfo("Composer", 286835824752176L, 2130838209), new BugReportCategoryInfo("Friend Sharing", 1711163495779305L, 2130840097), new BugReportCategoryInfo("Platform / Games / Apps", 393308357414341L, 2130839681), new BugReportCategoryInfo("Login", 455753877821540L, 2130839681), new BugReportCategoryInfo("Place Search / Local", 391791257648917L, 2130839681), new BugReportCategoryInfo("Place Tips", 669565466435907L, 2130839681), new BugReportCategoryInfo("Public Content / Hashtags / Topics", 249565561852833L, 2130839681)});
    }

    protected final List<BugReportCategoryInfo> m10814g() {
        return Lists.a(new BugReportCategoryInfo[]{new BugReportCategoryInfo(this.a.getString(2131235840), 400385060038546L, 2130839970), new BugReportCategoryInfo(this.a.getString(2131235843), 286835824752176L, 2130839837), new BugReportCategoryInfo(this.a.getString(2131235847), 393308357414341L, 2130839693), new BugReportCategoryInfo(this.a.getString(2131235851), 391791257648917L, 2130839681)});
    }

    protected final Comparator<BugReportCategoryInfo> m10811d() {
        return new C12271(this);
    }
}
