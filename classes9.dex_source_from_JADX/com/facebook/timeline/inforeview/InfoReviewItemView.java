package com.facebook.timeline.inforeview;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.timeline.event.TimelineHeaderEventBus;
import com.facebook.timeline.protocol.TimelineInfoReviewGraphQLModels.InfoReviewItemFragmentModel;
import javax.annotation.Nonnull;

/* compiled from: upload_full_quality_photo */
public class InfoReviewItemView extends ContentView {
    private static final CallerContext f855h = CallerContext.a(InfoReviewItemView.class);
    private final FbDraweeView f856i;
    private final FbTextView f857j;
    private final FbTextView f858k;
    public InfoReviewHandler f859l;
    public InfoReviewItemFragmentModel f860m;
    public TimelineInfoReviewData f861n;
    public TimelineHeaderEventBus f862o;

    /* compiled from: upload_full_quality_photo */
    class C00761 implements OnClickListener {
        final /* synthetic */ InfoReviewItemView f853a;

        C00761(InfoReviewItemView infoReviewItemView) {
            this.f853a = infoReviewItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 694435135);
            if (!(this.f853a.f859l == null || this.f853a.f860m == null || this.f853a.f860m.dz_() == null)) {
                this.f853a.f859l.m887a(this.f853a.getContext(), this.f853a.f860m.dz_());
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1924945464, a);
        }
    }

    /* compiled from: upload_full_quality_photo */
    class C00772 implements OnClickListener {
        final /* synthetic */ InfoReviewItemView f854a;

        C00772(InfoReviewItemView infoReviewItemView) {
            this.f854a = infoReviewItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1923071328);
            if (!(this.f854a.f859l == null || this.f854a.f860m == null)) {
                this.f854a.f859l.m888a(this.f854a.f860m, this.f854a.f861n, this.f854a.f862o);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -821612522, a);
        }
    }

    public InfoReviewItemView(Context context) {
        this(context, null);
    }

    public InfoReviewItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130907460);
        setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131361920)));
        a(0, 0, 0, getResources().getDimensionPixelSize(2131429884));
        setBorderColor(getResources().getColor(2131363015));
        setThumbnailSize((int) getResources().getDimension(2131429885));
        setMaxLinesFromThumbnailSize(false);
        this.f856i = (FbDraweeView) getView(2131567947);
        this.f857j = (FbTextView) getView(2131567948);
        this.f858k = (FbTextView) getView(2131567949);
        ImageView imageView = (ImageView) getView(2131567950);
        setOnClickListener(new C00761(this));
        imageView.setOnClickListener(new C00772(this));
    }

    public final void m893a(@Nonnull InfoReviewItemFragmentModel infoReviewItemFragmentModel, @Nonnull InfoReviewHandler infoReviewHandler, @Nonnull TimelineInfoReviewData timelineInfoReviewData, @Nonnull TimelineHeaderEventBus timelineHeaderEventBus) {
        if (infoReviewItemFragmentModel.m() == null || infoReviewItemFragmentModel.dz_() == null || infoReviewItemFragmentModel.c() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.f860m = infoReviewItemFragmentModel;
        this.f859l = infoReviewHandler;
        this.f861n = timelineInfoReviewData;
        this.f862o = timelineHeaderEventBus;
        this.f856i.a(Uri.parse(infoReviewItemFragmentModel.c().b()), f855h);
        this.f857j.setText(infoReviewItemFragmentModel.m().a());
        if (infoReviewItemFragmentModel.k() != null) {
            this.f858k.setText(infoReviewItemFragmentModel.k().a());
        }
        if (!this.f861n.f914f.f876i) {
            ((ImageView) getView(2131567950)).setVisibility(8);
        }
    }
}
