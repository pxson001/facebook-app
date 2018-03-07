package com.facebook.reviews.composer;

import android.content.Context;
import android.content.Intent;
import android.text.Selection;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerFragment;
import com.facebook.composer.attachments.AttachmentUtils;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate.PrivacyUpdatedHandler;
import com.facebook.composer.privacy.common.ComposerSelectablePrivacyDelegateBase.AnalyticsCallback;
import com.facebook.composer.privacy.common.ComposerWidestAudiencePrivacyDelegate;
import com.facebook.composer.privacy.common.ComposerWidestAudiencePrivacyDelegateProvider;
import com.facebook.composer.publish.helpers.OptimisticPostHelper;
import com.facebook.composer.publish.helpers.OptimisticPostHelperProvider;
import com.facebook.composer.publish.helpers.PublishAttachmentsHelper;
import com.facebook.composer.publish.helpers.PublishAttachmentsHelperProvider;
import com.facebook.composer.publish.helpers.PublishReviewHelper;
import com.facebook.composer.publish.helpers.PublishReviewHelperProvider;
import com.facebook.composer.ui.text.ComposerEditText;
import com.facebook.composer.ui.text.ComposerEditText.TextWithEntitiesChangedListener;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.Assisted;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.SerializedComposerPluginConfig;
import com.facebook.ipc.composer.plugin.ComposerPlugin$InstanceState;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.BooleanGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.Getter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.PrivacyDelegateGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginSession;
import com.facebook.ipc.composer.plugin.impl.ComposerPluginDefault;
import com.facebook.ipc.composer.plugin.impl.PluginPrivacyDataProvider;
import com.facebook.photos.upload.operation.UploadOperationFactory;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.reviews.analytics.ReviewsLogger;
import com.facebook.reviews.composer.ComposerRatingView.RatingListener;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: pull_quote_attribution_style */
public final class ReviewComposerPlugin extends ComposerPluginDefault {
    public final PublishAttachmentsHelperProvider f4921a;
    public final PublishReviewHelperProvider f4922b;
    public final OptimisticPostHelperProvider f4923c;
    public final ComposerWidestAudiencePrivacyDelegateProvider f4924d;
    public final PluginPrivacyDataProvider f4925e;
    public final InputMethodManager f4926f;
    public final ReviewLengthController f4927g;
    public final ReviewsLogger f4928h;
    private ComposerRatingView f4929i;
    public ComposerEditText f4930j;
    public TextView f4931k;

    /* compiled from: pull_quote_attribution_style */
    class C06571 implements Getter<String> {
        final /* synthetic */ ReviewComposerPlugin f4910a;

        C06571(ReviewComposerPlugin reviewComposerPlugin) {
            this.f4910a = reviewComposerPlugin;
        }

        public final Object m4831a() {
            return this.f4910a.b.getResources().getString(2131234518);
        }
    }

    /* compiled from: pull_quote_attribution_style */
    class C06582 implements Getter<String> {
        final /* synthetic */ ReviewComposerPlugin f4911a;

        C06582(ReviewComposerPlugin reviewComposerPlugin) {
            this.f4911a = reviewComposerPlugin;
        }

        public final Object m4832a() {
            if (Strings.isNullOrEmpty(this.f4911a.E().f1139a.s().targetName)) {
                return this.f4911a.b.getResources().getString(2131235362);
            }
            return this.f4911a.E().f1139a.s().targetName;
        }
    }

    /* compiled from: pull_quote_attribution_style */
    class C06593 implements BooleanGetter {
        final /* synthetic */ ReviewComposerPlugin f4912c;

        C06593(ReviewComposerPlugin reviewComposerPlugin) {
            this.f4912c = reviewComposerPlugin;
        }

        public final boolean m4833a() {
            return this.f4912c.E().f1139a.Z() != this.f4912c.E().f1139a.o().getInitialRating() || AttachmentUtils.k(this.f4912c.E().f1139a.m());
        }
    }

    /* compiled from: pull_quote_attribution_style */
    class C06604 implements BooleanGetter {
        final /* synthetic */ ReviewComposerPlugin f4913c;

        C06604(ReviewComposerPlugin reviewComposerPlugin) {
            this.f4913c = reviewComposerPlugin;
        }

        public final boolean m4834a() {
            return this.f4913c.E().f1139a.Z() != 0;
        }
    }

    /* compiled from: pull_quote_attribution_style */
    class C06615 implements Getter<Intent> {
        final /* synthetic */ ReviewComposerPlugin f4914a;

        C06615(ReviewComposerPlugin reviewComposerPlugin) {
            this.f4914a = reviewComposerPlugin;
        }

        public final Object m4835a() {
            OptimisticPostHelper a = this.f4914a.f4923c.a(this.f4914a.E().f1139a, this.f4914a.q);
            PublishAttachmentsHelper a2 = this.f4914a.f4921a.a(this.f4914a.E().f1139a);
            PublishReviewHelperProvider publishReviewHelperProvider = this.f4914a.f4922b;
            ComposerDataProviderImpl composerDataProviderImpl = this.f4914a.E().f1139a;
            return new PublishReviewHelper(composerDataProviderImpl, a2, a, Integer.valueOf(this.f4914a.E().f1139a.Z()), UploadOperationFactory.b(publishReviewHelperProvider)).a();
        }
    }

    /* compiled from: pull_quote_attribution_style */
    class C06626 implements BooleanGetter {
        final /* synthetic */ ReviewComposerPlugin f4915c;

        C06626(ReviewComposerPlugin reviewComposerPlugin) {
            this.f4915c = reviewComposerPlugin;
        }

        public final boolean m4836a() {
            return this.f4915c.E().f1139a.o().getInitialRating() == 0;
        }
    }

    /* compiled from: pull_quote_attribution_style */
    class C06637 implements PrivacyDelegateGetter {
        final /* synthetic */ ReviewComposerPlugin f4916a;

        C06637(ReviewComposerPlugin reviewComposerPlugin) {
            this.f4916a = reviewComposerPlugin;
        }

        public final ComposerPrivacyDelegate m4837a(PrivacyUpdatedHandler privacyUpdatedHandler, AnalyticsCallback analyticsCallback) {
            ComposerWidestAudiencePrivacyDelegateProvider composerWidestAudiencePrivacyDelegateProvider = this.f4916a.f4924d;
            return new ComposerWidestAudiencePrivacyDelegate(privacyUpdatedHandler, (AbstractFbErrorReporter) FbErrorReporterImpl.a(composerWidestAudiencePrivacyDelegateProvider), TasksManager.b(composerWidestAudiencePrivacyDelegateProvider), PrivacyOperationsClient.a(composerWidestAudiencePrivacyDelegateProvider), IdBasedLazy.a(composerWidestAudiencePrivacyDelegateProvider, 3115), analyticsCallback, this.f4916a.E().f1139a.X(), this.f4916a.f4925e);
        }
    }

    /* compiled from: pull_quote_attribution_style */
    class C06648 implements Getter<String> {
        final /* synthetic */ ReviewComposerPlugin f4917a;

        C06648(ReviewComposerPlugin reviewComposerPlugin) {
            this.f4917a = reviewComposerPlugin;
        }

        public final Object m4838a() {
            return this.f4917a.b.getResources().getString(2131234595);
        }
    }

    /* compiled from: pull_quote_attribution_style */
    class C06659 implements Getter<String> {
        final /* synthetic */ ReviewComposerPlugin f4918a;

        C06659(ReviewComposerPlugin reviewComposerPlugin) {
            this.f4918a = reviewComposerPlugin;
        }

        public final Object m4839a() {
            return this.f4918a.b.getResources().getString(this.f4918a.E().f1139a.o().isEdit() ? 2131234593 : 2131234581);
        }
    }

    @UserScoped
    /* compiled from: pull_quote_attribution_style */
    public class Factory implements com.facebook.ipc.composer.plugin.ComposerPlugin.Factory {
        private static final Object f4919b = new Object();
        private final ReviewComposerPluginProvider f4920a;

        private static Factory m4841b(InjectorLike injectorLike) {
            return new Factory((ReviewComposerPluginProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReviewComposerPluginProvider.class));
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.facebook.reviews.composer.ReviewComposerPlugin.Factory m4840a(com.facebook.inject.InjectorLike r7) {
            /*
            r2 = com.facebook.inject.ScopeSet.a();
            r0 = com.facebook.auth.userscope.UserScope.class;
            r0 = r7.getInstance(r0);
            r0 = (com.facebook.auth.userscope.UserScope) r0;
            r1 = r7.getScopeAwareInjector();
            r1 = r1.b();
            if (r1 != 0) goto L_0x001e;
        L_0x0016:
            r0 = new com.facebook.inject.ProvisioningException;
            r1 = "Called user scoped provider outside of context scope";
            r0.<init>(r1);
            throw r0;
        L_0x001e:
            r3 = r0.a(r1);
            r4 = r3.b();	 Catch:{ all -> 0x006c }
            r1 = f4919b;	 Catch:{ all -> 0x006c }
            r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
            r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
            if (r1 != r5) goto L_0x0035;
        L_0x0030:
            r3.c();
            r0 = 0;
        L_0x0034:
            return r0;
        L_0x0035:
            if (r1 != 0) goto L_0x007c;
        L_0x0037:
            r1 = 4;
            r5 = r2.b(r1);	 Catch:{  }
            r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
            r0 = r6.e();	 Catch:{ all -> 0x0062 }
            r1 = m4841b(r0);	 Catch:{ all -> 0x0062 }
            com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
            if (r1 != 0) goto L_0x0071;
        L_0x004d:
            r0 = f4919b;	 Catch:{  }
            r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
            r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
            r0 = (com.facebook.reviews.composer.ReviewComposerPlugin.Factory) r0;	 Catch:{  }
        L_0x0057:
            if (r0 == 0) goto L_0x007a;
        L_0x0059:
            r2.c(r5);	 Catch:{  }
        L_0x005c:
            r0 = (com.facebook.reviews.composer.ReviewComposerPlugin.Factory) r0;	 Catch:{  }
            r3.c();
            goto L_0x0034;
        L_0x0062:
            r0 = move-exception;
            com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
            throw r0;	 Catch:{  }
        L_0x0067:
            r0 = move-exception;
            r2.c(r5);	 Catch:{  }
            throw r0;	 Catch:{  }
        L_0x006c:
            r0 = move-exception;
            r3.c();
            throw r0;
        L_0x0071:
            r0 = f4919b;	 Catch:{  }
            r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
            r0 = (com.facebook.reviews.composer.ReviewComposerPlugin.Factory) r0;	 Catch:{  }
            goto L_0x0057;
        L_0x007a:
            r0 = r1;
            goto L_0x0059;
        L_0x007c:
            r0 = r1;
            goto L_0x005c;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.reviews.composer.ReviewComposerPlugin.Factory.a(com.facebook.inject.InjectorLike):com.facebook.reviews.composer.ReviewComposerPlugin$Factory");
        }

        @Inject
        public Factory(ReviewComposerPluginProvider reviewComposerPluginProvider) {
            this.f4920a = reviewComposerPluginProvider;
        }

        public final String m4843b() {
            return "ReviewComposerPluginConfig";
        }

        public final ComposerPluginDefault m4842a(SerializedComposerPluginConfig serializedComposerPluginConfig, ComposerPluginSession composerPluginSession, @Nullable ComposerPlugin$InstanceState composerPlugin$InstanceState) {
            ReviewComposerPluginProvider reviewComposerPluginProvider = this.f4920a;
            return new ReviewComposerPlugin(composerPluginSession, (Context) reviewComposerPluginProvider.getInstance(Context.class), (PublishAttachmentsHelperProvider) reviewComposerPluginProvider.getOnDemandAssistedProviderForStaticDi(PublishAttachmentsHelperProvider.class), (PublishReviewHelperProvider) reviewComposerPluginProvider.getOnDemandAssistedProviderForStaticDi(PublishReviewHelperProvider.class), (OptimisticPostHelperProvider) reviewComposerPluginProvider.getOnDemandAssistedProviderForStaticDi(OptimisticPostHelperProvider.class), (ComposerWidestAudiencePrivacyDelegateProvider) reviewComposerPluginProvider.getOnDemandAssistedProviderForStaticDi(ComposerWidestAudiencePrivacyDelegateProvider.class), InputMethodManagerMethodAutoProvider.b(reviewComposerPluginProvider), (ReviewLengthControllerProvider) reviewComposerPluginProvider.getOnDemandAssistedProviderForStaticDi(ReviewLengthControllerProvider.class), ReviewsLogger.a(reviewComposerPluginProvider));
        }
    }

    @Inject
    public ReviewComposerPlugin(@Assisted ComposerPluginSession composerPluginSession, Context context, PublishAttachmentsHelperProvider publishAttachmentsHelperProvider, PublishReviewHelperProvider publishReviewHelperProvider, OptimisticPostHelperProvider optimisticPostHelperProvider, ComposerWidestAudiencePrivacyDelegateProvider composerWidestAudiencePrivacyDelegateProvider, InputMethodManager inputMethodManager, ReviewLengthControllerProvider reviewLengthControllerProvider, ReviewsLogger reviewsLogger) {
        super(context, composerPluginSession);
        this.f4922b = publishReviewHelperProvider;
        this.f4921a = publishAttachmentsHelperProvider;
        this.f4923c = optimisticPostHelperProvider;
        this.f4924d = composerWidestAudiencePrivacyDelegateProvider;
        this.f4925e = new PluginPrivacyDataProvider(composerPluginSession.f1139a);
        this.f4926f = inputMethodManager;
        this.f4927g = reviewLengthControllerProvider.m4869a(composerPluginSession.f1139a, String.valueOf(composerPluginSession.f1139a.s().targetId), composerPluginSession.f1139a.ab());
        this.f4928h = reviewsLogger;
    }

    public final void m4857a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        this.f4927g.m4867a(composerEvent, composerEventOriginator);
    }

    @Nullable
    protected final BooleanGetter aM() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final BooleanGetter m4853T() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final BooleanGetter aK() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final Getter<String> m4846G() {
        return new C06571(this);
    }

    @Nullable
    protected final Getter<String> m4847K() {
        return new C06582(this);
    }

    @Nullable
    protected final BooleanGetter m4848L() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final BooleanGetter m4849N() {
        return new C06593(this);
    }

    @Nullable
    protected final BooleanGetter m4850O() {
        return new C06604(this);
    }

    @Nullable
    protected final BooleanGetter m4851P() {
        return BooleanGetter.b;
    }

    protected final BooleanGetter m4852Q() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final Getter<Intent> m4854V() {
        return new C06615(this);
    }

    @Nullable
    protected final BooleanGetter m4855W() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final BooleanGetter m4856Z() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final BooleanGetter aa() {
        return new C06626(this);
    }

    @Nullable
    protected final PrivacyDelegateGetter ab() {
        return new C06637(this);
    }

    @Nullable
    protected final BooleanGetter ac() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final BooleanGetter ad() {
        return BooleanGetter.a;
    }

    @Nullable
    protected final Getter<String> ag() {
        return new C06648(this);
    }

    @Nullable
    protected final Getter<String> ax() {
        return new C06659(this);
    }

    @Nullable
    protected final Getter<String> ay() {
        return new Getter<String>(this) {
            final /* synthetic */ ReviewComposerPlugin f4903a;

            {
                this.f4903a = r1;
            }

            public final Object m4821a() {
                return this.f4903a.b.getResources().getString(this.f4903a.E().f1139a.o().isEdit() ? 2131234589 : 2131234588);
            }
        };
    }

    @Nullable
    protected final Getter<String> az() {
        return new Getter<String>(this) {
            final /* synthetic */ ReviewComposerPlugin f4904a;

            {
                this.f4904a = r1;
            }

            public final Object m4822a() {
                return this.f4904a.b.getResources().getString(2131234597);
            }
        };
    }

    @Nullable
    protected final Getter<String> aB() {
        return new Getter<String>(this) {
            final /* synthetic */ ReviewComposerPlugin f4905a;

            {
                this.f4905a = r1;
            }

            public final Object m4823a() {
                String str = (String) Preconditions.checkNotNull(this.f4905a.E().f1139a.s().targetName);
                return StringLocaleUtil.a(this.f4905a.b.getString(2131235361), new Object[]{str});
            }
        };
    }

    @Nullable
    protected final BooleanGetter aD() {
        return BooleanGetter.b;
    }

    public final boolean m4858a(ViewStub viewStub) {
        viewStub.setLayoutResource(2130906840);
        View inflate = viewStub.inflate();
        this.f4929i = (ComposerRatingView) inflate.findViewById(2131566985);
        this.f4930j = (ComposerEditText) inflate.findViewById(2131563416);
        aP();
        return true;
    }

    private void aP() {
        this.f4930j.setHint((CharSequence) au().a());
        this.f4930j.setIncludeFriends(false);
        this.f4930j.a(new TextWithEntitiesChangedListener(this) {
            final /* synthetic */ ReviewComposerPlugin f4906a;

            {
                this.f4906a = r1;
            }

            public final void m4825a(GraphQLTextWithEntities graphQLTextWithEntities, boolean z) {
                this.f4906a.E().f1140b.a(graphQLTextWithEntities);
            }

            public final void m4824a(GraphQLTextWithEntities graphQLTextWithEntities) {
            }
        });
        if (!StringUtil.a(E().f1139a.ae().a())) {
            this.f4930j.setText(E().f1139a.ae().a());
            int length = this.f4930j.getUserText().length();
            Selection.setSelection(this.f4930j.getText(), length, length);
        }
        if (E().f1139a.Z() > 0) {
            aQ();
        }
        this.f4929i.setRating(Integer.valueOf(E().f1139a.Z()));
        this.f4929i.setPageName(E().f1139a.s().targetName);
        this.f4929i.setOnRatingChangedListener(new RatingListener(this) {
            final /* synthetic */ ReviewComposerPlugin f4907a;

            {
                this.f4907a = r1;
            }

            public final void mo242a(int i) {
                ReviewsLogger reviewsLogger = this.f4907a.f4928h;
                HoneyClientEvent d = ReviewsLogger.d("composer_rating_selector_tapped", String.valueOf(this.f4907a.E().f1139a.s().targetId), this.f4907a.E().f1139a.ab());
                d.a("rating", i);
                reviewsLogger.a.a(d);
            }

            public final void mo243b(int i) {
                ReviewsLogger reviewsLogger = this.f4907a.f4928h;
                HoneyClientEvent d = ReviewsLogger.d("composer_rating_selected", String.valueOf(this.f4907a.E().f1139a.s().targetId), this.f4907a.E().f1139a.ab());
                d.a("rating", i);
                reviewsLogger.a.a(d);
                ReviewComposerPlugin.m4844a(this.f4907a, i);
            }

            public final void mo244c(int i) {
                ReviewsLogger reviewsLogger = this.f4907a.f4928h;
                HoneyClientEvent d = ReviewsLogger.d("composer_popover_rating_selected", String.valueOf(this.f4907a.E().f1139a.s().targetId), this.f4907a.E().f1139a.ab());
                d.a("rating", i);
                reviewsLogger.a.a(d);
                ReviewComposerPlugin.m4844a(this.f4907a, i);
            }

            public final void mo245d(int i) {
                ReviewsLogger reviewsLogger = this.f4907a.f4928h;
                HoneyClientEvent d = ReviewsLogger.d("composer_rating_label_selected", String.valueOf(this.f4907a.E().f1139a.s().targetId), this.f4907a.E().f1139a.ab());
                d.a("rating", i);
                reviewsLogger.a.a(d);
                ReviewComposerPlugin.m4844a(this.f4907a, i);
            }
        });
        m4845b(E().f1139a.Z());
    }

    public static void m4844a(ReviewComposerPlugin reviewComposerPlugin, int i) {
        reviewComposerPlugin.E().f1140b.a.aU.b(ComposerFragment.cn).a(i).a();
        reviewComposerPlugin.m4845b(i);
        if (StringUtil.a(reviewComposerPlugin.E().f1139a.ae().a())) {
            reviewComposerPlugin.aQ();
        } else {
            reviewComposerPlugin.f4929i.requestFocus();
        }
    }

    private void aQ() {
        this.f4930j.requestFocus();
        this.f4930j.postDelayed(new Runnable(this) {
            final /* synthetic */ ReviewComposerPlugin f4908a;

            {
                this.f4908a = r1;
            }

            public void run() {
                if (!this.f4908a.f4926f.showSoftInput(this.f4908a.f4930j, 0)) {
                    this.f4908a.f4926f.hideSoftInputFromWindow(this.f4908a.f4930j.getWindowToken(), 0);
                    this.f4908a.f4926f.toggleSoftInput(0, 0);
                    this.f4908a.f4926f.showSoftInput(this.f4908a.f4930j, 0);
                }
            }
        }, 100);
    }

    private void m4845b(int i) {
        int i2 = 0;
        int dimensionPixelSize = this.b.getResources().getDimensionPixelSize(2131428032);
        int dimensionPixelSize2 = this.b.getResources().getDimensionPixelSize(2131429689);
        this.f4930j.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
        int i3 = i == 0 ? 1 : 0;
        ComposerEditText composerEditText = this.f4930j;
        if (i3 != 0) {
            i2 = 8;
        }
        composerEditText.setVisibility(i2);
        LayoutParams layoutParams = (LayoutParams) this.f4929i.getLayoutParams();
        layoutParams.weight = i3 != 0 ? 1.0f : 0.0f;
        this.f4929i.setLayoutParams(layoutParams);
    }

    public final void m4859b(ViewStub viewStub) {
        viewStub.setLayoutResource(2130903427);
        this.f4931k = (TextView) viewStub.inflate();
        this.f4927g.m4866a(this.f4931k);
    }

    @Nullable
    protected final BooleanGetter aF() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final BooleanGetter aG() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final BooleanGetter aJ() {
        return new BooleanGetter(this) {
            final /* synthetic */ ReviewComposerPlugin f4909c;

            {
                this.f4909c = r1;
            }

            public final boolean m4830a() {
                boolean z;
                ReviewComposerPlugin reviewComposerPlugin = this.f4909c;
                if (reviewComposerPlugin.f4927g.m4868a()) {
                    ReviewsLogger reviewsLogger = reviewComposerPlugin.f4928h;
                    reviewsLogger.a.a(ReviewsLogger.d("composer_submit_button_tapped_with_short_review", String.valueOf(reviewComposerPlugin.E().f1139a.s().targetId), reviewComposerPlugin.E().f1139a.ab()));
                    reviewComposerPlugin.f4931k.startAnimation(AnimationUtils.loadAnimation(reviewComposerPlugin.b, 2130968599));
                    z = true;
                } else {
                    z = false;
                }
                return z;
            }
        };
    }

    @Nullable
    protected final BooleanGetter aL() {
        return BooleanGetter.b;
    }
}
