package com.facebook.messaging.sharerendering;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.CommonStoryAttachmentFieldsModel.DescriptionModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAAttachmentStoryFieldsModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.linkhandling.LinkHandlingHelper;
import com.facebook.messaging.xma.SimpleStyleRenderer;
import com.facebook.messaging.xma.SimpleStyleRenderer.ViewHolder;
import javax.inject.Inject;

/* compiled from: qrcode_started */
public class ShareStyleRenderer extends SimpleStyleRenderer<ShareViewHolder> {
    public final Context f4053a;
    public final Lazy<LinkHandlingHelper> f4054b;
    private final AbstractFbErrorReporter f4055c;

    /* compiled from: qrcode_started */
    public class ShareViewHolder extends ViewHolder {
        public final FbDraweeView f4048b = ((FbDraweeView) a(2131563431));
        public final TextView f4049c = ((TextView) a(2131559636));
        public final TextView f4050d = ((TextView) a(2131560628));
        public final TextView f4051e = ((TextView) a(2131563432));
        public final View f4052f = a(2131562429);

        public ShareViewHolder(View view) {
            super(view);
        }
    }

    protected final void m3751a(ViewHolder viewHolder, XMAModel xMAModel) {
        Object obj;
        int i;
        ShareViewHolder shareViewHolder = (ShareViewHolder) viewHolder;
        int i2 = 0;
        final XMAAttachmentStoryFieldsModel c = xMAModel.c();
        shareViewHolder.a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ShareStyleRenderer f4047b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -713564281);
                if (!StringUtil.a(c.n())) {
                    ((LinkHandlingHelper) this.f4047b.f4054b.get()).a(this.f4047b.f4053a, Uri.parse(c.n()));
                }
                Logger.a(2, EntryType.UI_INPUT_END, 778184965, a);
            }
        });
        if (c.aP_() == null || c.aP_().c() == null || c.aP_().c().b() == null) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            shareViewHolder.f4048b.setVisibility(0);
            shareViewHolder.f4048b.a(Uri.parse(c.aP_().c().b()), CallerContext.a(ShareStyleRenderer.class));
        } else {
            shareViewHolder.f4048b.setVisibility(8);
        }
        if (StringUtil.a(c.l())) {
            shareViewHolder.f4049c.setVisibility(8);
        } else {
            shareViewHolder.f4049c.setVisibility(0);
            shareViewHolder.f4049c.setText(c.l());
        }
        m3749a(shareViewHolder, xMAModel, this.f4055c);
        if (c.g() == null || StringUtil.a(c.g().a())) {
            shareViewHolder.f4051e.setVisibility(8);
        } else {
            shareViewHolder.f4051e.setVisibility(0);
            shareViewHolder.f4051e.setText(c.g().a());
        }
        if (shareViewHolder.f4049c.getVisibility() == 0 || shareViewHolder.f4050d.getVisibility() == 0 || shareViewHolder.f4051e.getVisibility() == 0) {
            i = 1;
        } else {
            i = 0;
        }
        View view = shareViewHolder.f4052f;
        if (i == 0) {
            i2 = 8;
        }
        view.setVisibility(i2);
    }

    @Inject
    public ShareStyleRenderer(Context context, Lazy<LinkHandlingHelper> lazy, FbErrorReporter fbErrorReporter) {
        this.f4053a = context;
        this.f4054b = lazy;
        this.f4055c = fbErrorReporter;
    }

    protected final ViewHolder m3752b(ViewGroup viewGroup) {
        return new ShareViewHolder(LayoutInflater.from(this.f4053a).inflate(2130905047, viewGroup, false));
    }

    private static void m3749a(ShareViewHolder shareViewHolder, XMAModel xMAModel, AbstractFbErrorReporter abstractFbErrorReporter) {
        DescriptionModel d = xMAModel.c().d();
        if (d == null || StringUtil.a(d.a())) {
            shareViewHolder.f4050d.setVisibility(8);
            return;
        }
        shareViewHolder.f4050d.setVisibility(0);
        try {
            shareViewHolder.f4050d.setText(d.a());
        } catch (Exception e) {
            shareViewHolder.f4050d.setVisibility(8);
            m3750a(e, xMAModel, abstractFbErrorReporter);
        }
    }

    private static void m3750a(Exception exception, XMAModel xMAModel, AbstractFbErrorReporter abstractFbErrorReporter) {
        abstractFbErrorReporter.a(SoftError.b("ShareStyleRendererNullPointerException", exception.toString() + " Caused by: " + xMAModel.c().d().a() + " XMA ID: " + xMAModel.b()));
    }
}
