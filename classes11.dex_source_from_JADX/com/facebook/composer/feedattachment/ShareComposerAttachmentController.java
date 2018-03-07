package com.facebook.composer.feedattachment;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.attachments.angora.AngoraAttachmentView;
import com.facebook.attachments.angora.GenericAttachmentView;
import com.facebook.attachments.angora.ReshareAttachmentView;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerMutatorImpl;
import com.facebook.composer.activity.TransactionImpl;
import com.facebook.composer.analytics.ComposerAnalyticsEventBuilder;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.gating.ComposerGatekeepers;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbui.widget.text.GlyphWithTextView;
import com.facebook.feed.rows.sections.attachments.ui.quoteshare.QuoteExpandingEllipsizingTextView;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachment.Builder;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesRemovedUrls;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicSetters.SetsRemovedURLs;
import com.facebook.ipc.composer.dataaccessor.ComposerMutator;
import com.facebook.ipc.composer.dataaccessor.ComposerTransaction;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.ComposerShareParams.ProvidesShareParams;
import com.facebook.ipc.composer.intent.ComposerShareParams.SetsShareParams;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.intent.SharePreview;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginAreAttachmentsReadOnlyGetter;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.share.model.ComposerAppAttribution.ProvidesAppAttribution;
import com.facebook.share.model.LinksPreview;
import com.facebook.share.protocol.LinksPreviewParams;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.lang.ref.WeakReference;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: google_play_referrer */
public class ShareComposerAttachmentController<DataProvider extends ProvidesAppAttribution & ProvidesRemovedUrls & ProvidesSessionId & ProvidesConfiguration & ProvidesPluginAreAttachmentsReadOnlyGetter & ProvidesShareParams & ProvidesTargetData, Transaction extends ComposerTransaction & SetsRemovedURLs<Transaction> & SetsShareParams<Transaction>> implements ComposerFeedAttachmentController {
    public static final ImmutableList<GraphQLStoryAttachmentStyle> f6500a = ImmutableList.of(GraphQLStoryAttachmentStyle.FALLBACK);
    public static final ComposerEventOriginator f6501b = ComposerEventOriginator.a(ShareComposerAttachmentController.class);
    private final DefaultBlueServiceOperationFactory f6502c;
    private final ViewerContextManager f6503d;
    public final Resources f6504e;
    private final Provider<Boolean> f6505f;
    private final ComposerFeedAttachmentViewBinder f6506g;
    private final AbstractFbErrorReporter f6507h;
    private final ComposerAnalyticsLogger f6508i;
    public final WeakReference<DataProvider> f6509j;
    public final WeakReference<ComposerMutator<Transaction>> f6510k;
    private final GatekeeperStoreImpl f6511l;
    private final QeAccessor f6512m;

    /* compiled from: google_play_referrer */
    public class C08251 {
        final /* synthetic */ ShareComposerAttachmentController f6494a;

        C08251(ShareComposerAttachmentController shareComposerAttachmentController) {
            this.f6494a = shareComposerAttachmentController;
        }

        public final void m7925a(boolean z) {
            ShareComposerAttachmentController.m7931a(this.f6494a, z);
        }
    }

    /* compiled from: google_play_referrer */
    public class AttachmentBuilder {
        public final Builder f6499a;

        public AttachmentBuilder() {
            this.f6499a = new Builder();
            this.f6499a.q = ShareComposerAttachmentController.f6500a;
        }

        public final AttachmentBuilder m7927c(String str) {
            this.f6499a.h = GraphQLHelper.a(str);
            return this;
        }

        public final GraphQLStoryAttachment m7926a() {
            return this.f6499a.a();
        }
    }

    @Inject
    public ShareComposerAttachmentController(GatekeeperStore gatekeeperStore, BlueServiceOperationFactory blueServiceOperationFactory, ViewerContextManager viewerContextManager, Resources resources, Provider<Boolean> provider, ComposerFeedAttachmentViewBinder composerFeedAttachmentViewBinder, FbErrorReporter fbErrorReporter, QeAccessor qeAccessor, ComposerAnalyticsLogger composerAnalyticsLogger, @Assisted DataProvider dataProvider, @Assisted ComposerMutator<Transaction> composerMutator) {
        this.f6511l = gatekeeperStore;
        this.f6502c = blueServiceOperationFactory;
        this.f6503d = viewerContextManager;
        this.f6504e = resources;
        this.f6505f = provider;
        this.f6506g = composerFeedAttachmentViewBinder;
        this.f6507h = fbErrorReporter;
        this.f6512m = qeAccessor;
        this.f6508i = composerAnalyticsLogger;
        this.f6509j = new WeakReference(dataProvider);
        this.f6510k = new WeakReference(composerMutator);
    }

    public final List<GraphQLStoryAttachmentStyle> mo194c() {
        return f6500a;
    }

    public final View mo192a(GraphQLStoryAttachment graphQLStoryAttachment, ViewGroup viewGroup) {
        AngoraAttachmentView reshareAttachmentView;
        boolean z = ReshareHelper.m7924a(graphQLStoryAttachment) && this.f6511l.a(ComposerGatekeepers.a) == TriState.YES;
        if (z) {
            reshareAttachmentView = new ReshareAttachmentView(viewGroup.getContext());
        } else {
            reshareAttachmentView = new AngoraAttachmentView(viewGroup.getContext());
        }
        this.f6506g.m7871a(graphQLStoryAttachment, reshareAttachmentView);
        if (z) {
            m7931a(this, true);
            ReshareAttachmentView reshareAttachmentView2 = (ReshareAttachmentView) reshareAttachmentView;
            C08251 c08251 = new C08251(this);
            Preconditions.checkState(ReshareHelper.m7924a(graphQLStoryAttachment));
            CharSequence spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(PropertyHelper.b(graphQLStoryAttachment).trim());
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append(' ');
            spannableStringBuilder.append(PropertyHelper.c(graphQLStoryAttachment));
            spannableStringBuilder.setSpan(new StyleSpan(1), 0, length, 17);
            GenericAttachmentView.a(reshareAttachmentView2.e, spannableStringBuilder);
            reshareAttachmentView2.getActionButton().setVisibility(0);
            GlyphWithTextView glyphWithTextView = reshareAttachmentView2.getActionButton().a;
            glyphWithTextView.setCompoundDrawablePadding(0);
            glyphWithTextView.setImageResource(2130839781);
            glyphWithTextView.setGlyphColor(2131362057);
            glyphWithTextView.setOnClickListener(new ReshareButtonListener(reshareAttachmentView2, c08251));
        }
        if (m7932l()) {
            return m7928a(m7929a(viewGroup), reshareAttachmentView, viewGroup);
        }
        return reshareAttachmentView;
    }

    public final String mo198g() {
        String str;
        ComposerDataProviderImpl composerDataProviderImpl = (ComposerDataProviderImpl) Preconditions.checkNotNull(this.f6509j.get());
        String str2 = "";
        if (((ProvidesShareParams) composerDataProviderImpl).q().shareable != null) {
            str = str2 + "shareable_" + ((ProvidesShareParams) composerDataProviderImpl).q().shareable.d();
        } else if (((ProvidesShareParams) composerDataProviderImpl).q().linkForShare != null) {
            str = str2 + "link_" + ((ProvidesShareParams) composerDataProviderImpl).q().linkForShare;
        } else {
            str = str2 + "share_preview_only";
        }
        if (composerDataProviderImpl.m7424a() != null) {
            return str + ":" + String.valueOf(composerDataProviderImpl.m7424a());
        }
        return str;
    }

    private boolean m7932l() {
        return ((ProvidesShareParams) ((ComposerDataProviderImpl) Preconditions.checkNotNull(this.f6509j.get()))).q().quoteText != null;
    }

    private View m7929a(ViewGroup viewGroup) {
        CharSequence charSequence = ((ProvidesShareParams) ((ComposerDataProviderImpl) Preconditions.checkNotNull(this.f6509j.get()))).q().quoteText;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130906569, viewGroup, false);
        ((QuoteExpandingEllipsizingTextView) inflate.findViewById(2131566532)).setText(charSequence);
        return inflate;
    }

    private View m7928a(View view, View view2, ViewGroup viewGroup) {
        if (ComposerSourceType.PLATFORM.equals(((ProvidesConfiguration) ((ComposerDataProviderImpl) Preconditions.checkNotNull(this.f6509j.get()))).o().getSourceType())) {
            final View frameLayout = new FrameLayout(viewGroup.getContext());
            frameLayout.addView(view);
            View imageView = new ImageView(viewGroup.getContext());
            imageView.setImageDrawable(this.f6504e.getDrawable(2130843015));
            int dimensionPixelSize = this.f6504e.getDimensionPixelSize(2131429666);
            if (VERSION.SDK_INT >= 17) {
                imageView.setPaddingRelative(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            } else {
                imageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            }
            imageView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ShareComposerAttachmentController f6496b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -30034395);
                    ComposerDataProviderImpl composerDataProviderImpl = (ComposerDataProviderImpl) Preconditions.checkNotNull(this.f6496b.f6509j.get());
                    ComposerMutatorImpl composerMutatorImpl = (ComposerMutatorImpl) Preconditions.checkNotNull(this.f6496b.f6510k.get());
                    if (((ComposerShareParams) Preconditions.checkNotNull(((ProvidesShareParams) composerDataProviderImpl).q())).quoteText != null) {
                        ((TransactionImpl) composerMutatorImpl.m7626a(ShareComposerAttachmentController.f6501b).m7683a(ComposerShareParams.Builder.a(((ProvidesShareParams) composerDataProviderImpl).q().linkForShare).b())).m7689a();
                    }
                    frameLayout.setVisibility(8);
                    Logger.a(2, EntryType.UI_INPUT_END, -1466621424, a);
                }
            });
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 53);
            layoutParams.setMargins(0, this.f6504e.getDimensionPixelSize(2131429674), 0, 0);
            frameLayout.addView(imageView, layoutParams);
            view = frameLayout;
        }
        View linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(view);
        linearLayout.addView(view2);
        return linearLayout;
    }

    public final ListenableFuture<GraphQLStoryAttachment> mo195d() {
        final ComposerDataProviderImpl composerDataProviderImpl = (ComposerDataProviderImpl) Preconditions.checkNotNull(this.f6509j.get());
        if (Boolean.TRUE.equals(this.f6505f.get())) {
            return Futures.a(new IllegalStateException("User is zero-rated so not fetching attachment"));
        }
        if (((ProvidesShareParams) composerDataProviderImpl).q().sharePreview != null && !((ProvidesShareParams) composerDataProviderImpl).q().sharePreview.isOverride) {
            return Futures.a(m7930a(this, ((ProvidesShareParams) composerDataProviderImpl).q().sharePreview));
        }
        LinksPreviewParams.Builder builder = new LinksPreviewParams.Builder();
        if (((ProvidesShareParams) composerDataProviderImpl).q().shareable != null) {
            builder.a = ((ProvidesShareParams) composerDataProviderImpl).q().shareable.d();
        } else if (StringUtil.a(((ProvidesShareParams) composerDataProviderImpl).q().linkForShare)) {
            return Futures.a(new IllegalArgumentException("Both the shareable and the link for share are null!"));
        } else {
            builder.b = ((ProvidesShareParams) composerDataProviderImpl).q().linkForShare;
        }
        builder.c = ((ProvidesSessionId) composerDataProviderImpl).ab();
        LinksPreviewParams a = builder.a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("linksPreviewParams", a);
        bundle.putParcelable("overridden_viewer_context", this.f6503d.a());
        return Futures.a(BlueServiceOperationFactoryDetour.a(this.f6502c, "csh_links_preview", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(getClass()), 1985818994).a(), new Function<OperationResult, GraphQLStoryAttachment>(this) {
            final /* synthetic */ ShareComposerAttachmentController f6498b;

            @Nullable
            public Object apply(@Nullable Object obj) {
                LinksPreview linksPreview;
                OperationResult operationResult = (OperationResult) obj;
                if (operationResult != null) {
                    linksPreview = (LinksPreview) operationResult.k();
                } else {
                    linksPreview = null;
                }
                SharePreview a = SharePreview.a(linksPreview, ((ProvidesShareParams) composerDataProviderImpl).q().sharePreview);
                TransactionImpl a2 = ((ComposerMutatorImpl) Preconditions.checkNotNull(this.f6498b.f6510k.get())).m7626a(ShareComposerAttachmentController.f6501b);
                ComposerShareParams.Builder builder = new ComposerShareParams.Builder(((ProvidesShareParams) composerDataProviderImpl).q());
                builder.d = a;
                ((TransactionImpl) a2.m7683a(builder.b())).m7689a();
                return ShareComposerAttachmentController.m7930a(this.f6498b, a);
            }
        }, MoreExecutors.a());
    }

    public static GraphQLStoryAttachment m7930a(@Nullable ShareComposerAttachmentController shareComposerAttachmentController, SharePreview sharePreview) {
        if (sharePreview == null) {
            return (GraphQLStoryAttachment) shareComposerAttachmentController.mo193a(new IllegalArgumentException("sharePreview is null")).get();
        }
        ComposerDataProviderImpl composerDataProviderImpl = (ComposerDataProviderImpl) Preconditions.checkNotNull(shareComposerAttachmentController.f6509j.get());
        String b = (composerDataProviderImpl.m7424a() == null || StringUtil.c(composerDataProviderImpl.m7424a().b())) ? sharePreview.summary : composerDataProviderImpl.m7424a().b();
        AttachmentBuilder attachmentBuilder = new AttachmentBuilder();
        attachmentBuilder.f6499a.u = sharePreview.title;
        attachmentBuilder = attachmentBuilder;
        attachmentBuilder.f6499a.s = sharePreview.subTitle;
        AttachmentBuilder c = attachmentBuilder.m7927c(b);
        String str = sharePreview.imageUrl;
        int i = sharePreview.imageWidth;
        int i2 = sharePreview.imageHeight;
        Builder builder = c.f6499a;
        GraphQLMedia.Builder builder2 = new GraphQLMedia.Builder();
        GraphQLImage.Builder builder3 = new GraphQLImage.Builder();
        builder3.g = str;
        builder3 = builder3;
        builder3.h = i;
        builder3 = builder3;
        builder3.d = i2;
        builder2.N = builder3.a();
        builder.l = builder2.a();
        GraphQLStoryAttachment a = c.m7926a();
        if (sharePreview.originalShareActorName == null || sharePreview.reshareMessage == null) {
            return a;
        }
        PropertyHelper.a(a).x = sharePreview.originalShareActorName;
        PropertyHelper.a(a).z = sharePreview.reshareMessage;
        return a;
    }

    public final Optional<GraphQLStoryAttachment> mo193a(Throwable th) {
        ComposerDataProviderImpl composerDataProviderImpl = (ComposerDataProviderImpl) Preconditions.checkNotNull(this.f6509j.get());
        AbstractFbErrorReporter abstractFbErrorReporter = this.f6507h;
        SoftErrorBuilder a = SoftError.a("composer_feed_attachment_error_fallback", "sessionId: " + ((ProvidesSessionId) composerDataProviderImpl).ab());
        a.c = th;
        a = a;
        a.e = 1;
        abstractFbErrorReporter.a(a.g());
        return Optional.of(new AttachmentBuilder().m7927c(this.f6504e.getString(2131234539)).m7926a());
    }

    public final boolean mo196e() {
        ComposerDataProviderImpl composerDataProviderImpl = (ComposerDataProviderImpl) Preconditions.checkNotNull(this.f6509j.get());
        if (((ProvidesShareParams) composerDataProviderImpl).q() == null) {
            return false;
        }
        return (((ProvidesShareParams) composerDataProviderImpl).q().sharePreview == null && ((ProvidesShareParams) composerDataProviderImpl).q().shareable == null && StringUtil.a(((ProvidesShareParams) composerDataProviderImpl).q().linkForShare)) ? false : true;
    }

    public final boolean mo197f() {
        ComposerDataProviderImpl composerDataProviderImpl = (ComposerDataProviderImpl) Preconditions.checkNotNull(this.f6509j.get());
        if (((ProvidesPluginAreAttachmentsReadOnlyGetter) composerDataProviderImpl).ap() != null && ((ProvidesPluginAreAttachmentsReadOnlyGetter) composerDataProviderImpl).ap().a()) {
            return true;
        }
        if (!((ProvidesConfiguration) composerDataProviderImpl).o().isEdit()) {
            boolean z;
            GraphQLEntity graphQLEntity = ((ProvidesShareParams) composerDataProviderImpl).q().shareable;
            if (graphQLEntity != null) {
                int a = GraphQLHelper.a(graphQLEntity);
                z = a == 514783620;
                if (a == -1196289854 && this.f6512m.a(ExperimentsForComposerAbTestModule.C, false)) {
                    z = true;
                }
            } else {
                z = false;
            }
            return (graphQLEntity == null || !z) && ((ProvidesShareParams) composerDataProviderImpl).q().linkForShare == null;
        } else if (StringUtil.a(((ProvidesShareParams) composerDataProviderImpl).q().linkForShare) || ((ProvidesTargetData) composerDataProviderImpl).s().targetType == TargetType.USER || ((ProvidesTargetData) composerDataProviderImpl).s().targetType == TargetType.GROUP || ((ProvidesTargetData) composerDataProviderImpl).s().targetType == TargetType.EVENT) {
            return true;
        } else {
            return !this.f6512m.a(ExperimentsForComposerAbTestModule.D, false);
        }
    }

    public final View mo191a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(2130905288, viewGroup, false);
        if (m7932l()) {
            return m7928a(m7929a(viewGroup), inflate, viewGroup);
        }
        return inflate;
    }

    public final void mo199h() {
        ComposerDataProviderImpl composerDataProviderImpl = (ComposerDataProviderImpl) Preconditions.checkNotNull(this.f6509j.get());
        ComposerMutatorImpl composerMutatorImpl = (ComposerMutatorImpl) Preconditions.checkNotNull(this.f6510k.get());
        String d = (((ProvidesShareParams) composerDataProviderImpl).q() == null || ((ProvidesShareParams) composerDataProviderImpl).q().shareable == null) ? null : ((ProvidesShareParams) composerDataProviderImpl).q().shareable.d();
        this.f6508i.a.a(new ComposerAnalyticsEventBuilder("remove_link_attachment").h(((ProvidesSessionId) composerDataProviderImpl).ab()).m(((ProvidesConfiguration) composerDataProviderImpl).o().isEdit()).t(d).a);
        RemoveShareAttachmentHelper.m7923a(composerDataProviderImpl, composerMutatorImpl);
    }

    public final void mo200i() {
    }

    public final View mo201j() {
        return null;
    }

    public final boolean mo202k() {
        return false;
    }

    public static void m7931a(ShareComposerAttachmentController shareComposerAttachmentController, boolean z) {
        ComposerDataProviderImpl composerDataProviderImpl = (ComposerDataProviderImpl) Preconditions.checkNotNull(shareComposerAttachmentController.f6509j.get());
        if (((ProvidesShareParams) composerDataProviderImpl).q().includeReshareContext != z) {
            TransactionImpl a = ((ComposerMutatorImpl) Preconditions.checkNotNull(shareComposerAttachmentController.f6510k.get())).m7626a(f6501b);
            ComposerShareParams.Builder builder = new ComposerShareParams.Builder(((ProvidesShareParams) composerDataProviderImpl).q());
            builder.a = z;
            ((TransactionImpl) a.m7683a(builder.b())).m7689a();
        }
    }
}
