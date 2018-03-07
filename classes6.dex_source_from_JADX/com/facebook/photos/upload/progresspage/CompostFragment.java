package com.facebook.photos.upload.progresspage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.FindViewUtil;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.composer.publish.compost.story.CompostDraftStory;
import com.facebook.composer.publish.compost.story.CompostStory;
import com.facebook.composer.publish.compost.story.RecentlyUploadedStory;
import com.facebook.compost.abtest.ExperimentsForCompostAbTestModule;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.composer.model.RetrySource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.upload.compost.CompostNetworkMonitor;
import com.facebook.photos.upload.compost.CompostNetworkMonitor.CompostNetworkListener;
import com.facebook.photos.upload.compost.CompostNetworkMonitor.CompostNetworkStatus;
import com.facebook.photos.upload.compost.CompostPendingPost;
import com.facebook.photos.upload.compost.CompostStoryFetcher;
import com.facebook.photos.upload.compost.analytics.CompostAnalyticsLogger;
import com.facebook.photos.upload.progresspage.CompostRecyclerViewAdapter.CompostSectionType;
import com.facebook.photos.upload.progresspage.CompostRecyclerViewAdapter.MultiIndex;
import com.facebook.photos.upload.progresspage.composer.CompostComposerLauncher;
import com.facebook.photos.upload.progresspage.survey.CompostSurveyController;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rapidfeedback.RapidFeedbackConstants.RapidFeedbackTheme;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.ui.titlebar.Fb4aTitleBar.OnActionButtonClickListener;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: giveupUpload / manual retry */
public class CompostFragment extends FbFragment {
    private static final String f13842a = CompostFragment.class.getSimpleName();
    @Inject
    public CompostRecyclerViewAdapter al;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<CompostSurveyController> am = UltralightRuntime.b;
    @Inject
    public QeAccessor an;
    public LoadingIndicatorView ao;
    public Fb4aTitleBar ap;
    public boolean aq;
    public OnActionButtonClickListener ar;
    @Nullable
    private RecyclerView as;
    @Nullable
    private View at;
    private CompostSourceType au;
    private final C08901 av = new C08901(this);
    private final C08912 aw = new C08912(this);
    @Inject
    public CompostAnalyticsLogger f13843b;
    @Inject
    public CompostStoryViewUtil f13844c;
    @Inject
    public CompostComposerLauncher f13845d;
    @Inject
    public ComposerLauncher f13846e;
    @Inject
    public CompostStoryFetcher f13847f;
    @Inject
    public CompostNetworkMonitor f13848g;
    @Inject
    private SecureContextHelper f13849h;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ComposerPublishServiceHelper> f13850i = UltralightRuntime.b;

    /* compiled from: giveupUpload / manual retry */
    public class C08901 {
        public final /* synthetic */ CompostFragment f13836a;

        /* compiled from: giveupUpload / manual retry */
        public class C08891 implements Runnable {
            final /* synthetic */ RecentlyUploadedStory f13834a;
            final /* synthetic */ C08901 f13835b;

            public C08891(C08901 c08901, RecentlyUploadedStory recentlyUploadedStory) {
                this.f13835b = c08901;
                this.f13834a = recentlyUploadedStory;
            }

            public void run() {
                this.f13835b.f13836a.al.m21655a(this.f13834a);
            }
        }

        C08901(CompostFragment compostFragment) {
            this.f13836a = compostFragment;
        }

        public final void m21608a(CompostPendingPost compostPendingPost) {
            MultiIndex multiIndex;
            CompostRecyclerViewAdapter compostRecyclerViewAdapter = this.f13836a.al;
            loop0:
            for (int i = 0; i < compostRecyclerViewAdapter.f13875a.size(); i++) {
                for (int i2 = 0; i2 < ((List) compostRecyclerViewAdapter.f13875a.get(i)).size(); i2++) {
                    CompostStory compostStory = (CompostStory) ((List) compostRecyclerViewAdapter.f13875a.get(i)).get(i2);
                    if (compostStory.getClass().equals(compostPendingPost.getClass()) && compostStory.mo934f().equals(compostPendingPost.mo934f())) {
                        multiIndex = new MultiIndex(i, i2 + 1);
                        break loop0;
                    }
                }
            }
            multiIndex = new MultiIndex(compostRecyclerViewAdapter.f13875a.size(), -1);
            compostRecyclerViewAdapter.m21658a(multiIndex);
        }

        public final void m21607a() {
            CompostFragment.as(this.f13836a);
        }
    }

    /* compiled from: giveupUpload / manual retry */
    public class C08912 {
        public final /* synthetic */ CompostFragment f13837a;

        C08912(CompostFragment compostFragment) {
            this.f13837a = compostFragment;
        }
    }

    /* compiled from: giveupUpload / manual retry */
    class C08923 implements CompostNetworkListener {
        final /* synthetic */ CompostFragment f13838a;

        C08923(CompostFragment compostFragment) {
            this.f13838a = compostFragment;
        }

        public final void mo1142a() {
            CompostFragment.m21613a(this.f13838a, "update");
            this.f13838a.al.m21659e();
        }
    }

    /* compiled from: giveupUpload / manual retry */
    public class C08934 implements OnClickListener {
        final /* synthetic */ CompostFragment f13839a;

        public C08934(CompostFragment compostFragment) {
            this.f13839a = compostFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1927164358);
            this.f13839a.f13843b.m21262d();
            this.f13839a.o().onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 1257836021, a);
        }
    }

    /* compiled from: giveupUpload / manual retry */
    public class C08945 implements OnActionButtonClickListener {
        final /* synthetic */ CompostFragment f13840a;

        public C08945(CompostFragment compostFragment) {
            this.f13840a = compostFragment;
        }

        public final void m21610a(View view) {
            CompostFragment compostFragment = this.f13840a;
            compostFragment.f13843b.m21258c();
            compostFragment.f13846e.a(null, ComposerConfigurationFactory.a(ComposerSourceSurface.COMPOST, "launchComposerFromCompost").m18223a(), 1, compostFragment);
        }
    }

    /* compiled from: giveupUpload / manual retry */
    public class C08956 implements RetryClickedListener {
        final /* synthetic */ CompostFragment f13841a;

        public C08956(CompostFragment compostFragment) {
            this.f13841a = compostFragment;
        }

        public final void m21611a() {
            CompostFragment.ar(this.f13841a);
        }
    }

    public static void m21614a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((CompostFragment) obj).m21612a(CompostAnalyticsLogger.m21244b(injectorLike), CompostStoryViewUtil.m21676b(injectorLike), CompostComposerLauncher.m21683b(injectorLike), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), CompostStoryFetcher.m21236b(injectorLike), CompostNetworkMonitor.m21213b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), IdBasedLazy.a(injectorLike, 5272), CompostRecyclerViewAdapter.m21646b(injectorLike), IdBasedLazy.a(injectorLike, 9474), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final void m21622c(Bundle bundle) {
        super.c(bundle);
        Class cls = CompostFragment.class;
        m21614a((Object) this, getContext());
        this.au = (CompostSourceType) this.s.getSerializable("source");
        boolean z = this.an.a(ExperimentsForCompostAbTestModule.f8088g, true) && (this.au == CompostSourceType.DRAFT_NOTIFICATION || this.au == CompostSourceType.SNACKBAR);
        this.aq = z;
    }

    public final View m21620a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1243168663);
        View inflate = layoutInflater.inflate(2130903741, viewGroup, false);
        this.ap = (Fb4aTitleBar) FindViewUtil.b(inflate, 2131558563);
        this.ap.setTitle(2131236025);
        this.ap.a(new C08934(this));
        Builder a2 = TitleBarButtonSpec.a();
        a2.b = jW_().getDrawable(2130838464);
        a2 = a2;
        a2.j = "Composer entry to create a new post";
        this.ap.setPrimaryButton(a2.a());
        this.ar = new C08945(this);
        this.ap.setActionButtonOnClickListener(this.ar);
        m21615e();
        this.ao = (LoadingIndicatorView) inflate.findViewById(2131560667);
        this.f13847f.f13563l = Optional.fromNullable(this.av);
        m21613a(this, "init");
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1823104240, a);
        return inflate;
    }

    public final void m21618G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1152942400);
        super.G();
        ar(this);
        CompostStoryFetcher compostStoryFetcher = this.f13847f;
        compostStoryFetcher.f13553b.a(compostStoryFetcher.f13559h);
        compostStoryFetcher.f13555d.f8042d = compostStoryFetcher.f13558g;
        this.f13848g.m21215a(new C08923(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1347764040, a);
    }

    public final void m21619H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1640215408);
        super.H();
        CompostStoryFetcher compostStoryFetcher = this.f13847f;
        compostStoryFetcher.f13555d.f8042d = null;
        compostStoryFetcher.f13553b.b(compostStoryFetcher.f13559h);
        ((TasksManager) compostStoryFetcher.f13557f.get()).c();
        this.f13848g.m21216d();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -532824191, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -464146271);
        this.ap = null;
        this.as = null;
        this.ao = null;
        this.at = null;
        this.al.m21656a(null);
        this.al = null;
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1673500466, a);
    }

    public final void m21621a(int i, int i2, @Nullable Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1) {
                    ((ComposerPublishServiceHelper) this.f13850i.get()).m11572c(intent);
                    PublishPostParams publishPostParams = (PublishPostParams) intent.getParcelableExtra("publishPostParams");
                    this.f13843b.m21270h(publishPostParams != null ? publishPostParams.composerSessionId : "");
                    return;
                } else if (i2 == 0 && intent != null) {
                    Bundle bundleExtra = intent.getBundleExtra("try_show_survey_on_result_extra_data");
                    if (bundleExtra != null) {
                        CompostSurveyController compostSurveyController = (CompostSurveyController) this.am.get();
                        compostSurveyController.f13962b.a(bundleExtra);
                        compostSurveyController.f13962b.a("767272543409294", compostSurveyController.f13961a, RapidFeedbackTheme.LCAU);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public static void m21613a(CompostFragment compostFragment, String str) {
        String str2;
        if (compostFragment.f13848g.f13540e == CompostNetworkStatus.CONNECTED) {
            str2 = "connected";
        } else {
            str2 = "no_internet";
        }
        compostFragment.f13843b.m21265d(str2, str);
    }

    private void m21615e() {
        Collection of;
        this.al.m21656a(this.aw);
        if (this.au == CompostSourceType.DRAFT_NOTIFICATION) {
            of = ImmutableList.of(CompostSectionType.DRAFT_SECTION, CompostSectionType.PENDING_SECTION, CompostSectionType.UPLOADED_SECTION);
        } else {
            of = ImmutableList.of(CompostSectionType.PENDING_SECTION, CompostSectionType.UPLOADED_SECTION, CompostSectionType.DRAFT_SECTION);
        }
        CompostRecyclerViewAdapter compostRecyclerViewAdapter = this.al;
        compostRecyclerViewAdapter.f13876b.addAll(of);
        for (int i = 0; i < compostRecyclerViewAdapter.f13876b.size(); i++) {
            compostRecyclerViewAdapter.f13875a.add(new ArrayList());
        }
    }

    public static void ar(CompostFragment compostFragment) {
        compostFragment.m21616g(8);
        compostFragment.m21617h(8);
        compostFragment.ao.setVisibility(0);
        compostFragment.ao.a();
        CompostRecyclerViewAdapter compostRecyclerViewAdapter = compostFragment.al;
        for (List clear : compostRecyclerViewAdapter.f13875a) {
            clear.clear();
        }
        compostRecyclerViewAdapter.notifyDataSetChanged();
        compostFragment.f13847f.m21240c();
    }

    public static void as(CompostFragment compostFragment) {
        Object obj;
        if (compostFragment.f13847f.m21241d().isEmpty() && compostFragment.f13847f.m21242e().isEmpty() && compostFragment.f13847f.m21243f().isEmpty()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            compostFragment.aw();
        } else if (compostFragment.f13847f.f13565n) {
            compostFragment.f13843b.m21254b();
            compostFragment.ao.a(new C08956(compostFragment), null);
        } else {
            ax(compostFragment);
        }
        ImmutableList f = compostFragment.f13847f.m21243f();
        if (compostFragment.aq && !f.isEmpty()) {
            compostFragment.aq = false;
            compostFragment.f13845d.m21684a((CompostDraftStory) f.get(0), compostFragment, 1);
        }
        if (compostFragment.an.a(ExperimentsForCompostAbTestModule.f8105x, true) && compostFragment.f13848g.f13536a.d()) {
            ImmutableList d = compostFragment.f13847f.m21241d();
            int size = d.size();
            for (int i = 0; i < size; i++) {
                compostFragment.f13844c.m21678a(((CompostPendingPost) d.get(i)).m21217a(), RetrySource.AUTOMATIC, false);
            }
        }
    }

    private void aw() {
        this.ao.b();
        this.ao.setVisibility(8);
        List d = this.f13847f.m21241d();
        List e = this.f13847f.m21242e();
        List f = this.f13847f.m21243f();
        this.al.m21657a(CompostSectionType.PENDING_SECTION, d);
        this.al.m21657a(CompostSectionType.UPLOADED_SECTION, e);
        this.al.m21657a(CompostSectionType.DRAFT_SECTION, f);
        this.f13843b.m21248a(d.size(), e.size(), f.size());
        m21616g(0);
        m21617h(8);
        this.as.setLayoutManager(new LinearLayoutManager(getContext()));
        this.as.setAdapter(this.al);
    }

    public static void ax(CompostFragment compostFragment) {
        compostFragment.ao.b();
        compostFragment.ao.setVisibility(8);
        compostFragment.m21616g(8);
        compostFragment.m21617h(0);
        compostFragment.f13843b.m21246a();
    }

    private void m21612a(CompostAnalyticsLogger compostAnalyticsLogger, CompostStoryViewUtil compostStoryViewUtil, CompostComposerLauncher compostComposerLauncher, ComposerLauncher composerLauncher, CompostStoryFetcher compostStoryFetcher, CompostNetworkMonitor compostNetworkMonitor, SecureContextHelper secureContextHelper, com.facebook.inject.Lazy<ComposerPublishServiceHelper> lazy, CompostRecyclerViewAdapter compostRecyclerViewAdapter, com.facebook.inject.Lazy<CompostSurveyController> lazy2, QeAccessor qeAccessor) {
        this.f13843b = compostAnalyticsLogger;
        this.f13844c = compostStoryViewUtil;
        this.f13845d = compostComposerLauncher;
        this.f13846e = composerLauncher;
        this.f13847f = compostStoryFetcher;
        this.f13848g = compostNetworkMonitor;
        this.f13849h = secureContextHelper;
        this.f13850i = lazy;
        this.al = compostRecyclerViewAdapter;
        this.am = lazy2;
        this.an = qeAccessor;
    }

    private void m21616g(int i) {
        if (this.as != null) {
            this.as.setVisibility(i);
        } else if (i == 0) {
            this.as = (RecyclerView) ((ViewStub) this.T.findViewById(2131560665)).inflate();
        }
    }

    private void m21617h(int i) {
        if (this.at != null) {
            this.at.setVisibility(i);
        } else if (i == 0) {
            this.at = ((ViewStub) this.T.findViewById(2131560666)).inflate();
        }
    }
}
