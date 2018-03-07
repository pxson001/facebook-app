package com.facebook.timeline.header.bio.edit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.Toast;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.FindViewUtil;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.fbui.popover.PopoverWindow.OnCancelListener;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.fbui.tooltip.Tooltip.OnTooltipClickListener;
import com.facebook.graphql.calls.ProfileIntroCardSetInputData;
import com.facebook.graphql.calls.ProfileIntroCardSetInputData.PublishBioFeedStory;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.ui.DefaultPrivacyScopeResourceResolver;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbEditText;
import com.facebook.resources.ui.FbTextView;
import com.facebook.timeline.header.bio.IntroCardBioPostToFeedNuxInterstitialController;
import com.facebook.timeline.header.intro.IntroCardShareToNewsfeedController;
import com.facebook.timeline.header.intro.IntroCardShareToNewsfeedController.FeedSharingSwitchNuxProvider;
import com.facebook.timeline.header.intro.IntroCardShareToNewsfeedControllerProvider;
import com.facebook.timeline.header.intro.protocol.BioQueryExecutor;
import com.facebook.timeline.protocol.ProfileIntroCardMutation.ProfileIntroCardBioMutationString;
import com.facebook.timeline.protocol.ProfileIntroCardMutationModels.ProfileIntroCardBioMutationModel;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpecCache;
import com.facebook.widget.titlebar.TitleBarButtonSpecCacheProvider;
import com.facebook.work.config.String_WorkCommunityNameMethodAutoProvider;
import com.facebook.work.config.community.WorkCommunityName;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: force_download */
public class TimelineBioEditFragment extends FbFragment implements FeedSharingSwitchNuxProvider {
    @Inject
    public GraphQLQueryExecutor f11614a;
    private final TextWatcher aA = new C16642(this);
    @Inject
    @IsWorkBuild
    public Boolean al;
    @Inject
    @WorkCommunityName
    public String am;
    @Inject
    public DefaultPrivacyScopeResourceResolver an;
    @Inject
    TitleBarButtonSpecCacheProvider ao;
    private int ap;
    private int aq;
    public IntroCardShareToNewsfeedController ar;
    private TitleBarButtonSpecCache as;
    public FbEditText at;
    private FbTitleBar au;
    private FbTextView av;
    public CharSequence aw;
    public boolean ax;
    public boolean ay;
    private final OnToolbarButtonListener az = new C16631(this);
    @Inject
    @ForUiThread
    public Executor f11615b;
    @Inject
    IntroCardBioPostToFeedNuxInterstitialController f11616c;
    @Inject
    public Lazy<UriIntentMapper> f11617d;
    @Inject
    public Lazy<SecureContextHelper> f11618e;
    @Inject
    @LoggedInUserId
    public Provider<String> f11619f;
    @Inject
    public GraphQLCacheManager f11620g;
    @Inject
    QeAccessor f11621h;
    @Inject
    IntroCardShareToNewsfeedControllerProvider f11622i;

    /* compiled from: force_download */
    class C16631 extends OnToolbarButtonListener {
        final /* synthetic */ TimelineBioEditFragment f11608a;

        C16631(TimelineBioEditFragment timelineBioEditFragment) {
            this.f11608a = timelineBioEditFragment;
        }

        public final void m11652a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            Enum enumR;
            TimelineBioEditFragment timelineBioEditFragment = this.f11608a;
            ProfileIntroCardSetInputData profileIntroCardSetInputData = new ProfileIntroCardSetInputData();
            profileIntroCardSetInputData.a("bio", timelineBioEditFragment.at.getText().toString().trim());
            if (timelineBioEditFragment.ar.m11887b()) {
                enumR = PublishBioFeedStory.TRUE;
            } else {
                enumR = PublishBioFeedStory.FALSE;
            }
            profileIntroCardSetInputData.a("publish_bio_feed_story", enumR);
            GraphQlQueryString profileIntroCardBioMutationString = new ProfileIntroCardBioMutationString();
            profileIntroCardBioMutationString.a("input", profileIntroCardSetInputData);
            MutationRequest a = GraphQLRequest.a(profileIntroCardBioMutationString);
            ProgressDialog a2 = ProgressDialog.a(timelineBioEditFragment.getContext(), null, timelineBioEditFragment.b(2131233366), true);
            timelineBioEditFragment.f11620g.a(BioQueryExecutor.f11836a);
            Futures.a(timelineBioEditFragment.f11614a.a(a), new C16653(timelineBioEditFragment, a2), timelineBioEditFragment.f11615b);
        }
    }

    /* compiled from: force_download */
    class C16642 implements TextWatcher {
        final /* synthetic */ TimelineBioEditFragment f11609a;

        C16642(TimelineBioEditFragment timelineBioEditFragment) {
            this.f11609a = timelineBioEditFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            TimelineBioEditFragment.at(this.f11609a);
            TimelineBioEditFragment.aw(this.f11609a);
        }
    }

    /* compiled from: force_download */
    public class C16653 extends AbstractDisposableFutureCallback<GraphQLResult<ProfileIntroCardBioMutationModel>> {
        final /* synthetic */ ProgressDialog f11610a;
        final /* synthetic */ TimelineBioEditFragment f11611b;

        public C16653(TimelineBioEditFragment timelineBioEditFragment, ProgressDialog progressDialog) {
            this.f11611b = timelineBioEditFragment;
            this.f11610a = progressDialog;
        }

        protected final void m11653a(Object obj) {
            FragmentActivity o = this.f11611b.o();
            if (o != null) {
                o.setResult(-1);
                TimelineBioEditFragment timelineBioEditFragment;
                if (this.f11611b.ay) {
                    timelineBioEditFragment = this.f11611b;
                    this.f11610a.dismiss();
                    Intent a = ((UriIntentMapper) timelineBioEditFragment.f11617d.get()).a(o, StringFormatUtil.a(FBLinks.aX, new Object[]{timelineBioEditFragment.f11619f.get()}));
                    if (a != null) {
                        ((SecureContextHelper) timelineBioEditFragment.f11618e.get()).a(a, o);
                    }
                    o.finish();
                    return;
                }
                timelineBioEditFragment = this.f11611b;
                this.f11610a.dismiss();
                o.finish();
            }
        }

        protected final void m11654a(Throwable th) {
            Toast.makeText(this.f11611b.getContext(), 2131235021, 1).show();
            FragmentActivity o = this.f11611b.o();
            if (o != null) {
                o.setResult(100);
                TimelineBioEditFragment timelineBioEditFragment = this.f11611b;
                this.f11610a.dismiss();
                o.finish();
            }
        }
    }

    /* compiled from: force_download */
    class C16664 implements OnTooltipClickListener {
        final /* synthetic */ TimelineBioEditFragment f11612a;

        C16664(TimelineBioEditFragment timelineBioEditFragment) {
            this.f11612a = timelineBioEditFragment;
        }

        public final void m11655a() {
            TimelineBioEditFragment.ar(this.f11612a);
        }
    }

    /* compiled from: force_download */
    class C16675 implements OnCancelListener {
        final /* synthetic */ TimelineBioEditFragment f11613a;

        C16675(TimelineBioEditFragment timelineBioEditFragment) {
            this.f11613a = timelineBioEditFragment;
        }

        public final boolean m11656a() {
            TimelineBioEditFragment.ar(this.f11613a);
            return false;
        }
    }

    public static void m11659a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((TimelineBioEditFragment) obj).m11658a(GraphQLQueryExecutor.a(fbInjector), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), IntroCardBioPostToFeedNuxInterstitialController.m11598a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 2436), IdBasedSingletonScopeProvider.b(fbInjector, 968), IdBasedProvider.a(fbInjector, 4442), GraphQLCacheManager.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), (IntroCardShareToNewsfeedControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(IntroCardShareToNewsfeedControllerProvider.class), Boolean_IsWorkBuildMethodAutoProvider.a(fbInjector), String_WorkCommunityNameMethodAutoProvider.b(fbInjector), DefaultPrivacyScopeResourceResolver.a(fbInjector), (TitleBarButtonSpecCacheProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(TitleBarButtonSpecCacheProvider.class));
    }

    private void m11658a(GraphQLQueryExecutor graphQLQueryExecutor, Executor executor, IntroCardBioPostToFeedNuxInterstitialController introCardBioPostToFeedNuxInterstitialController, Lazy<UriIntentMapper> lazy, Lazy<SecureContextHelper> lazy2, Provider<String> provider, GraphQLCacheManager graphQLCacheManager, QeAccessor qeAccessor, IntroCardShareToNewsfeedControllerProvider introCardShareToNewsfeedControllerProvider, Boolean bool, String str, DefaultPrivacyScopeResourceResolver defaultPrivacyScopeResourceResolver, TitleBarButtonSpecCacheProvider titleBarButtonSpecCacheProvider) {
        this.f11614a = graphQLQueryExecutor;
        this.f11615b = executor;
        this.f11616c = introCardBioPostToFeedNuxInterstitialController;
        this.f11617d = lazy;
        this.f11618e = lazy2;
        this.f11619f = provider;
        this.f11620g = graphQLCacheManager;
        this.f11621h = qeAccessor;
        this.f11622i = introCardShareToNewsfeedControllerProvider;
        this.al = bool;
        this.am = str;
        this.an = defaultPrivacyScopeResourceResolver;
        this.ao = titleBarButtonSpecCacheProvider;
    }

    public final void m11664c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = TimelineBioEditFragment.class;
        m11659a(this, getContext());
        this.as = this.ao.a(2131234971);
        this.aq = jW_().getColor(2131361918);
        this.ap = jW_().getColor(2131361935);
        this.ar = this.f11622i.m11889a(getContext(), this.f11616c, this);
    }

    public final View m11662a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String formatStrLocaleSafe;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -648345857);
        View inflate = layoutInflater.inflate(2130907433, viewGroup, false);
        FbTextView fbTextView = (FbTextView) FindViewUtil.b(inflate, 2131563275);
        if (this.al.booleanValue()) {
            formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(b(2131235015), this.am);
        } else {
            formatStrLocaleSafe = b(2131235014);
        }
        fbTextView.setText(Html.fromHtml(formatStrLocaleSafe));
        ImageView imageView = (ImageView) FindViewUtil.b(inflate, 2131563274);
        DefaultPrivacyScopeResourceResolver defaultPrivacyScopeResourceResolver = this.an;
        if (this.al.booleanValue()) {
            formatStrLocaleSafe = "work_list";
        } else {
            formatStrLocaleSafe = "everyone";
        }
        imageView.setImageResource(defaultPrivacyScopeResourceResolver.a(formatStrLocaleSafe));
        this.at = (FbEditText) inflate.findViewById(2131567908);
        this.av = (FbTextView) inflate.findViewById(2131567909);
        this.aw = "";
        if (this.s != null) {
            this.aw = this.s.getCharSequence("initial_bio_text", "");
            this.ax = this.s.getBoolean("came_from_suggested_bio", false);
            this.ay = this.s.getBoolean("should_open_new_timeline_activity_on_save_success", false);
        }
        FbEditText fbEditText = this.at;
        fbEditText.setSingleLine(true);
        fbEditText.setMaxLines(Integer.MAX_VALUE);
        fbEditText.setHorizontallyScrolling(false);
        fbEditText.setImeOptions(6);
        if (bundle != null) {
            this.at.setText(bundle.getCharSequence("bio_text"));
        } else {
            this.at.setText(this.aw);
        }
        this.at.setSelection(this.at.getText().length());
        this.at.addTextChangedListener(this.aA);
        this.ar.m11886a(bundle, this.s, inflate);
        LogUtils.f(472403182, a);
        return inflate;
    }

    public final void m11660G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1617429814);
        super.G();
        at(this);
        this.ar.m11884a();
        aw(this);
        this.ar.m11888c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -460133143, a);
    }

    public final void m11661H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -229586177);
        ((InputMethodManager) o().getSystemService("input_method")).hideSoftInputFromWindow(this.at.getWindowToken(), 0);
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1121678583, a);
    }

    public static void ar(TimelineBioEditFragment timelineBioEditFragment) {
        timelineBioEditFragment.at.requestFocus();
        ((InputMethodManager) timelineBioEditFragment.o().getSystemService("input_method")).toggleSoftInput(2, 1);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void at(com.facebook.timeline.header.bio.edit.TimelineBioEditFragment r8) {
        /*
        r0 = r8.au;
        if (r0 != 0) goto L_0x0013;
    L_0x0004:
        r0 = r8.o();
        r1 = 2131558563; // 0x7f0d00a3 float:1.8742445E38 double:1.053129858E-314;
        r0 = r0.findViewById(r1);
        r0 = (com.facebook.widget.titlebar.FbTitleBar) r0;
        r8.au = r0;
    L_0x0013:
        r4 = 1;
        r3 = 0;
        r2 = r8.ax;
        if (r2 != 0) goto L_0x002f;
    L_0x0019:
        r2 = r8.aw;
        r2 = r2.toString();
        r5 = r8.at;
        r5 = r5.getText();
        r5 = r5.toString();
        r2 = r2.equals(r5);
        if (r2 != 0) goto L_0x0080;
    L_0x002f:
        r2 = r4;
    L_0x0030:
        r5 = r8.at;
        r5 = r5.getText();
        r5 = r5.length();
        r6 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r5 > r6) goto L_0x0082;
    L_0x003e:
        r5 = r8.at;
        r5 = r5.getText();
        r5 = r5.toString();
        r7 = r5.length();
        if (r7 <= 0) goto L_0x0084;
    L_0x004e:
        r7 = r5.trim();
        r7 = r7.length();
        if (r7 != 0) goto L_0x0084;
    L_0x0058:
        r7 = 1;
    L_0x0059:
        r5 = r7;
        if (r5 != 0) goto L_0x0082;
    L_0x005c:
        if (r2 == 0) goto L_0x0082;
    L_0x005e:
        r0 = r4;
        if (r0 == 0) goto L_0x0074;
    L_0x0061:
        r0 = r8.au;
        r1 = r8.as;
        r1 = r1.a();
        r0.setButtonSpecs(r1);
        r0 = r8.au;
        r1 = r8.az;
        r0.setOnToolbarButtonListener(r1);
    L_0x0073:
        return;
    L_0x0074:
        r0 = r8.au;
        r1 = r8.as;
        r1 = r1.b();
        r0.setButtonSpecs(r1);
        goto L_0x0073;
    L_0x0080:
        r2 = r3;
        goto L_0x0030;
    L_0x0082:
        r4 = r3;
        goto L_0x005e;
    L_0x0084:
        r7 = 0;
        goto L_0x0059;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.header.bio.edit.TimelineBioEditFragment.at(com.facebook.timeline.header.bio.edit.TimelineBioEditFragment):void");
    }

    public static void aw(TimelineBioEditFragment timelineBioEditFragment) {
        int length = timelineBioEditFragment.at.getText().toString().length();
        if (length > 101) {
            length = 101 - length;
            timelineBioEditFragment.av.setTextColor(timelineBioEditFragment.aq);
        } else {
            timelineBioEditFragment.av.setTextColor(timelineBioEditFragment.ap);
        }
        timelineBioEditFragment.av.setText(StringFormatUtil.formatStrLocaleSafe("%d / %d", Integer.valueOf(length), Integer.valueOf(101)));
    }

    public final void m11665e(Bundle bundle) {
        bundle.putCharSequence("initial_bio_text", this.at.getText());
        this.ar.m11885a(bundle);
        super.e(bundle);
    }

    public final Tooltip mo543b() {
        Tooltip tooltip = new Tooltip(ao(), 2);
        tooltip.t = -1;
        tooltip.b(ao().getResources().getString(2131235017));
        tooltip.a(Position.ABOVE);
        tooltip.a(new C16664(this));
        tooltip.x = true;
        tooltip.I = new C16675(this);
        return tooltip;
    }
}
