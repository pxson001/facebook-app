package com.facebook.platform.composer.composer;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.attachments.angora.AngoraAttachmentView;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.feed.rows.sections.attachments.ui.quoteshare.QuoteExpandingEllipsizingTextView;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachment.Builder;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.SharePreview;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.platform.composer.composer.PlatformComposerFragment.C05232;
import com.facebook.platform.composer.composer.PlatformComposerFragment.C05243;
import com.facebook.platform.composer.model.PlatformComposerModel;
import com.facebook.platform.composer.model.PlatformComposition;
import com.facebook.share.model.LinksPreview;
import com.facebook.share.protocol.LinksPreviewParams;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: right_margin */
public class PlatformComposerAttachmentController {
    public static final ImmutableList<GraphQLStoryAttachmentStyle> f3984a = ImmutableList.of(GraphQLStoryAttachmentStyle.FALLBACK);
    private final DefaultBlueServiceOperationFactory f3985b;
    private final ViewerContextManager f3986c;
    public final Resources f3987d;
    private final PlatformComposerAttachmentViewBinder f3988e;
    private final AbstractFbErrorReporter f3989f;
    public final C05232 f3990g;
    public final C05243 f3991h;

    /* compiled from: right_margin */
    class C05042 implements Function<OperationResult, GraphQLStoryAttachment> {
        final /* synthetic */ PlatformComposerAttachmentController f3982a;

        C05042(PlatformComposerAttachmentController platformComposerAttachmentController) {
            this.f3982a = platformComposerAttachmentController;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            LinksPreview linksPreview = null;
            if (operationResult != null) {
                linksPreview = (LinksPreview) operationResult.k();
            }
            return PlatformComposerAttachmentController.m3952a(this.f3982a, SharePreview.a(linksPreview, this.f3982a.f3990g.m4014b().sharePreview));
        }
    }

    /* compiled from: right_margin */
    public class AttachmentBuilder {
        public final Builder f3983a;

        public AttachmentBuilder() {
            this.f3983a = new Builder();
            this.f3983a.q = PlatformComposerAttachmentController.f3984a;
        }

        public final AttachmentBuilder m3949c(String str) {
            this.f3983a.h = GraphQLHelper.a(str);
            return this;
        }

        public final GraphQLStoryAttachment m3948a() {
            return this.f3983a.a();
        }
    }

    @Inject
    public PlatformComposerAttachmentController(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, ViewerContextManager viewerContextManager, Resources resources, PlatformComposerAttachmentViewBinder platformComposerAttachmentViewBinder, AbstractFbErrorReporter abstractFbErrorReporter, @Assisted C05232 c05232, @Assisted C05243 c05243) {
        this.f3985b = defaultBlueServiceOperationFactory;
        this.f3986c = viewerContextManager;
        this.f3987d = resources;
        this.f3988e = platformComposerAttachmentViewBinder;
        this.f3989f = abstractFbErrorReporter;
        this.f3990g = c05232;
        this.f3991h = c05243;
    }

    public final View m3955a(GraphQLStoryAttachment graphQLStoryAttachment, ViewGroup viewGroup) {
        View angoraAttachmentView = new AngoraAttachmentView(viewGroup.getContext());
        PlatformComposerAttachmentViewBinder platformComposerAttachmentViewBinder = this.f3988e;
        angoraAttachmentView.a();
        angoraAttachmentView.setBackgroundDrawable(angoraAttachmentView.getContext().getResources().getDrawable(2130840171));
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        if (!(graphQLStoryAttachment.A() == null || StringUtil.c(graphQLStoryAttachment.A()))) {
            spannableStringBuilder.append(graphQLStoryAttachment.A().trim().replaceAll("\n", " "));
            spannableStringBuilder.setSpan(new StyleSpan(1), 0, spannableStringBuilder.length(), 17);
        }
        if (!(graphQLStoryAttachment.y() == null || StringUtil.c(graphQLStoryAttachment.y()))) {
            if (spannableStringBuilder.length() > 0) {
                spannableStringBuilder.append("\n");
            }
            spannableStringBuilder.append(graphQLStoryAttachment.y());
        }
        angoraAttachmentView.setTitle(spannableStringBuilder);
        if (graphQLStoryAttachment.n() != null) {
            angoraAttachmentView.setContextText(graphQLStoryAttachment.n().a());
        }
        if (!(graphQLStoryAttachment.z() == null || graphQLStoryAttachment.z().gi() == null || graphQLStoryAttachment.z().gi().b() == null || !ImageUtil.a(graphQLStoryAttachment.z().gi()).isAbsolute())) {
            angoraAttachmentView.setSideImageController(platformComposerAttachmentViewBinder.f4002b.a(PlatformComposerAttachmentViewBinder.f4001a).b(ImageUtil.a(graphQLStoryAttachment.z().gi())).s());
        }
        if (m3953g()) {
            return m3950a(m3951a(viewGroup), angoraAttachmentView, viewGroup);
        }
        return angoraAttachmentView;
    }

    private boolean m3953g() {
        return this.f3990g.m4014b().quoteText != null;
    }

    @Nullable
    private View m3951a(ViewGroup viewGroup) {
        CharSequence charSequence = this.f3990g.m4014b().quoteText;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130906569, viewGroup, false);
        ((QuoteExpandingEllipsizingTextView) inflate.findViewById(2131566532)).setText(charSequence);
        return inflate;
    }

    private View m3950a(View view, View view2, ViewGroup viewGroup) {
        final View frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.addView(view);
        GlyphView glyphView = new GlyphView(viewGroup.getContext());
        glyphView.setImageDrawable(this.f3987d.getDrawable(2130839815));
        glyphView.setGlyphColor(this.f3987d.getColor(2131363626));
        glyphView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PlatformComposerAttachmentController f3981b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1243076304);
                C05243 c05243 = this.f3981b.f3991h;
                if (!(c05243.f4097a.aO.f4188c.m4165q() == null || c05243.f4097a.aO.f4188c.m4165q().quoteText == null)) {
                    PlatformComposerFragment platformComposerFragment = c05243.f4097a;
                    PlatformComposerModel.Builder a2 = c05243.f4097a.aO.m4142a();
                    PlatformComposition.Builder C = c05243.f4097a.aO.f4188c.m4148C();
                    C.f4222u = ComposerShareParams.Builder.a(c05243.f4097a.aO.f4188c.m4165q().linkForShare).b();
                    a2.f4174c = C.m4145b();
                    platformComposerFragment.aO = a2.m4141a();
                }
                frameLayout.setVisibility(8);
                Logger.a(2, EntryType.UI_INPUT_END, -1103466838, a);
            }
        });
        frameLayout.addView(glyphView, new LayoutParams(-2, -2, 21));
        View view3 = frameLayout;
        View linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(view3);
        linearLayout.addView(view2);
        return linearLayout;
    }

    public final ListenableFuture<GraphQLStoryAttachment> m3957b() {
        if (this.f3990g.m4014b().sharePreview != null && !this.f3990g.m4014b().sharePreview.isOverride) {
            return Futures.a(m3952a(this, this.f3990g.m4014b().sharePreview));
        }
        Parcelable a;
        LinksPreviewParams.Builder builder;
        if (this.f3990g.m4014b().shareable != null) {
            builder = new LinksPreviewParams.Builder();
            builder.f8970a = this.f3990g.m4014b().shareable.d();
            builder = builder;
            builder.f8972c = this.f3990g.m4013a();
            a = builder.m10696a();
        } else if (StringUtil.a(this.f3990g.m4014b().linkForShare)) {
            return Futures.a(new IllegalArgumentException("Both the shareable and the link for share are null!"));
        } else {
            builder = new LinksPreviewParams.Builder();
            builder.f8971b = this.f3990g.m4014b().linkForShare;
            builder = builder;
            builder.f8972c = this.f3990g.m4013a();
            a = builder.m10696a();
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("linksPreviewParams", a);
        bundle.putParcelable("overridden_viewer_context", this.f3986c.a());
        return Futures.a(BlueServiceOperationFactoryDetour.a(this.f3985b, "csh_links_preview", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(getClass()), -1617324277).a(), new C05042(this), DirectExecutor.INSTANCE);
    }

    public static GraphQLStoryAttachment m3952a(@Nullable PlatformComposerAttachmentController platformComposerAttachmentController, SharePreview sharePreview) {
        if (sharePreview == null) {
            return (GraphQLStoryAttachment) platformComposerAttachmentController.m3956a(new IllegalArgumentException("sharePreview is null")).get();
        }
        String b = (platformComposerAttachmentController.f3990g.m4015c() == null || StringUtil.c(platformComposerAttachmentController.f3990g.m4015c().b())) ? sharePreview.summary : platformComposerAttachmentController.f3990g.m4015c().b();
        AttachmentBuilder attachmentBuilder = new AttachmentBuilder();
        attachmentBuilder.f3983a.u = sharePreview.title;
        attachmentBuilder = attachmentBuilder;
        attachmentBuilder.f3983a.s = sharePreview.subTitle;
        AttachmentBuilder c = attachmentBuilder.m3949c(b);
        String str = sharePreview.imageUrl;
        Builder builder = c.f3983a;
        GraphQLNode.Builder builder2 = new GraphQLNode.Builder();
        GraphQLImage.Builder builder3 = new GraphQLImage.Builder();
        builder3.g = str;
        builder2.hc = builder3.a();
        builder.t = builder2.a();
        return c.m3948a();
    }

    public final Optional<GraphQLStoryAttachment> m3956a(Throwable th) {
        AbstractFbErrorReporter abstractFbErrorReporter = this.f3989f;
        SoftErrorBuilder a = SoftError.a("composer_feed_attachment_error_fallback", "sessionId: " + this.f3990g.m4013a());
        a.c = th;
        a = a;
        a.e = 1;
        abstractFbErrorReporter.a(a.g());
        return Optional.of(new AttachmentBuilder().m3949c(this.f3987d.getString(2131238361)).m3948a());
    }

    public final View m3954a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(2130906307, viewGroup, false);
        if (m3953g()) {
            return m3950a(m3951a(viewGroup), inflate, viewGroup);
        }
        return inflate;
    }
}
