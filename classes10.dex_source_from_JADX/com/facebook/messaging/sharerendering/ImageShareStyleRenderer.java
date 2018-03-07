package com.facebook.messaging.sharerendering;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAAttachmentStoryFieldsModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.linkhandling.LinkHandlingHelper;
import com.facebook.messaging.xma.SimpleStyleRenderer;
import com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder;
import com.facebook.messaging.xma.XMAContentContainer.LayoutParams;
import com.facebook.messaging.xma.XMAContentContainer.LayoutParams.SizingPreference;
import com.facebook.messaging.xma.ui.ActionLinkBar;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: qrcode_vanity_shown */
public class ImageShareStyleRenderer extends SimpleStyleRenderer<ImageShareViewHolder> {
    public final Context f4043a;
    public final Lazy<LinkHandlingHelper> f4044b;
    private final FbDraweeControllerBuilder f4045c;

    /* compiled from: qrcode_vanity_shown */
    public class ImageShareViewHolder extends ViewHolder {
        public final ImageShareDraweeView f4041b = ((ImageShareDraweeView) a(2131563055));
        public final ActionLinkBar f4042c = ((ActionLinkBar) a(2131563056));

        public ImageShareViewHolder(View view) {
            super(view);
        }
    }

    protected final void m3745a(ViewHolder viewHolder, XMAModel xMAModel) {
        ImageShareViewHolder imageShareViewHolder = (ImageShareViewHolder) viewHolder;
        final XMAAttachmentStoryFieldsModel c = xMAModel.c();
        imageShareViewHolder.a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ImageShareStyleRenderer f4038b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1928052304);
                if (!StringUtil.a(c.n())) {
                    ((LinkHandlingHelper) this.f4038b.f4044b.get()).a(this.f4038b.f4043a, Uri.parse(c.n()));
                }
                Logger.a(2, EntryType.UI_INPUT_END, 946054415, a);
            }
        });
        m3744c(imageShareViewHolder, c);
        imageShareViewHolder.f4042c.setActionLinks(c.a());
        View view = imageShareViewHolder.a;
        if (view.getLayoutParams() instanceof LayoutParams) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (imageShareViewHolder.f4041b.getVisibility() != 8 || imageShareViewHolder.f4042c.getChildCount() <= 0) {
                layoutParams.a = SizingPreference.MATCH_LARGEST_NONTEXT;
            } else {
                layoutParams.a = SizingPreference.MATCH_LARGEST;
            }
            view.setLayoutParams(layoutParams);
        }
    }

    @Inject
    public ImageShareStyleRenderer(Context context, Lazy<LinkHandlingHelper> lazy, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f4043a = context;
        this.f4044b = lazy;
        this.f4045c = fbDraweeControllerBuilder;
    }

    protected final ViewHolder m3746b(ViewGroup viewGroup) {
        return new ImageShareViewHolder(LayoutInflater.from(this.f4043a).inflate(2130904836, viewGroup, false));
    }

    private void m3744c(final ImageShareViewHolder imageShareViewHolder, XMAAttachmentStoryFieldsModel xMAAttachmentStoryFieldsModel) {
        Object obj = null;
        Object obj2 = (xMAAttachmentStoryFieldsModel.aP_() == null || xMAAttachmentStoryFieldsModel.aP_().c() == null || xMAAttachmentStoryFieldsModel.aP_().c().b() == null) ? null : 1;
        Object obj3;
        if (xMAAttachmentStoryFieldsModel.aP_() == null || xMAAttachmentStoryFieldsModel.aP_().d() == null || xMAAttachmentStoryFieldsModel.aP_().d() == null || xMAAttachmentStoryFieldsModel.aP_().d().b() == null) {
            obj3 = null;
        } else {
            obj3 = 1;
        }
        if (!(obj2 == null && r8 == null)) {
            obj = 1;
        }
        if (obj == null) {
            imageShareViewHolder.f4041b.setVisibility(8);
            return;
        }
        Uri parse;
        int c;
        int a;
        if (xMAAttachmentStoryFieldsModel.aP_().d() != null) {
            parse = Uri.parse(xMAAttachmentStoryFieldsModel.aP_().d().b());
            c = xMAAttachmentStoryFieldsModel.aP_().d().c();
            a = xMAAttachmentStoryFieldsModel.aP_().d().a();
        } else {
            parse = Uri.parse(xMAAttachmentStoryFieldsModel.aP_().c().b());
            c = xMAAttachmentStoryFieldsModel.aP_().c().c();
            a = xMAAttachmentStoryFieldsModel.aP_().c().a();
        }
        imageShareViewHolder.f4041b.setVisibility(0);
        if (!(c == 0 || a == 0)) {
            imageShareViewHolder.f4041b.setAspectRatio(((float) c) / ((float) a));
            imageShareViewHolder.f4041b.setImageWidthHint(c);
        }
        imageShareViewHolder.f4041b.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f4045c.b(imageShareViewHolder.f4041b.getController())).b(parse).a(CallerContext.a(ImageShareStyleRenderer.class)).a(new BaseControllerListener(this) {
            final /* synthetic */ ImageShareStyleRenderer f4040b;

            public final void m3743a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
                CloseableImage closeableImage = (CloseableImage) obj;
                if (closeableImage != null) {
                    imageShareViewHolder.f4041b.setImageWidthHint(closeableImage.f());
                    imageShareViewHolder.f4041b.setAspectRatio(((float) closeableImage.f()) / ((float) closeableImage.g()));
                }
            }
        })).s());
    }
}
