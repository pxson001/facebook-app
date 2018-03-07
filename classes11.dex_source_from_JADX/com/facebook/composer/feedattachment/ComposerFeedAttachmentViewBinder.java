package com.facebook.composer.feedattachment;

import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import com.facebook.attachments.angora.AngoraAttachmentView;
import com.facebook.attachments.angora.AttachmentHasLargeImage;
import com.facebook.attachments.angora.AttachmentHasSideImage;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: groupTypes */
public class ComposerFeedAttachmentViewBinder {
    private static final CallerContext f6439a = CallerContext.a(ComposerFeedAttachmentViewBinder.class);
    private final FbDraweeControllerBuilder f6440b;

    public static ComposerFeedAttachmentViewBinder m7870b(InjectorLike injectorLike) {
        return new ComposerFeedAttachmentViewBinder(FbDraweeControllerBuilder.b(injectorLike));
    }

    @Inject
    public ComposerFeedAttachmentViewBinder(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f6440b = fbDraweeControllerBuilder;
    }

    public final void m7871a(GraphQLStoryAttachment graphQLStoryAttachment, AngoraAttachmentView angoraAttachmentView) {
        m7866a(graphQLStoryAttachment, angoraAttachmentView, false);
    }

    private void m7866a(GraphQLStoryAttachment graphQLStoryAttachment, AngoraAttachmentView angoraAttachmentView, boolean z) {
        angoraAttachmentView.a();
        angoraAttachmentView.setTitle(null);
        angoraAttachmentView.setContextText(null);
        angoraAttachmentView.setSideImageController(null);
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
        if (z) {
            m7867a(graphQLStoryAttachment, (AttachmentHasLargeImage) angoraAttachmentView);
        } else {
            m7868a(graphQLStoryAttachment, (AttachmentHasSideImage) angoraAttachmentView);
        }
    }

    private void m7868a(GraphQLStoryAttachment graphQLStoryAttachment, AttachmentHasSideImage attachmentHasSideImage) {
        if (m7869a(graphQLStoryAttachment)) {
            attachmentHasSideImage.setSideImageController(m7865a(ImageUtil.a(GraphQLStoryAttachmentUtil.l(graphQLStoryAttachment))));
        }
    }

    private void m7867a(GraphQLStoryAttachment graphQLStoryAttachment, AttachmentHasLargeImage attachmentHasLargeImage) {
        if (m7869a(graphQLStoryAttachment)) {
            attachmentHasLargeImage.setLargeImageController(m7865a(ImageUtil.a(GraphQLStoryAttachmentUtil.l(graphQLStoryAttachment))));
        }
    }

    private static boolean m7869a(GraphQLStoryAttachment graphQLStoryAttachment) {
        return (GraphQLStoryAttachmentUtil.l(graphQLStoryAttachment) == null || GraphQLStoryAttachmentUtil.l(graphQLStoryAttachment).b() == null || !ImageUtil.a(GraphQLStoryAttachmentUtil.l(graphQLStoryAttachment)).isAbsolute()) ? false : true;
    }

    private DraweeController m7865a(Uri uri) {
        return this.f6440b.a(f6439a).b(uri).s();
    }
}
