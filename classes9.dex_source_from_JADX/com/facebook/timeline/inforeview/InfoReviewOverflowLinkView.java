package com.facebook.timeline.inforeview;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.timeline.protocol.TimelineInfoReviewGraphQLModels.InfoReviewOverflowLinkModel;
import javax.annotation.Nonnull;

/* compiled from: upload_fail_exception */
public class InfoReviewOverflowLinkView extends ContentView {
    private static final CallerContext f864h = CallerContext.a(InfoReviewOverflowLinkView.class);
    private final FbDraweeView f865i = ((FbDraweeView) getView(2131567951));
    public InfoReviewHandler f866j;
    public InfoReviewOverflowLinkModel f867k;

    /* compiled from: upload_fail_exception */
    class C00781 implements OnClickListener {
        final /* synthetic */ InfoReviewOverflowLinkView f863a;

        C00781(InfoReviewOverflowLinkView infoReviewOverflowLinkView) {
            this.f863a = infoReviewOverflowLinkView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -382465248);
            if (!(this.f863a.f866j == null || this.f863a.f867k == null || this.f863a.f867k.c() == null)) {
                this.f863a.f866j.m887a(this.f863a.getContext(), this.f863a.f867k.c());
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1712898804, a);
        }
    }

    public InfoReviewOverflowLinkView(Context context) {
        super(context);
        setContentView(2130907461);
        setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131361920)));
        a(0, 0, 0, getResources().getDimensionPixelSize(2131429884));
        setBorderColor(getResources().getColor(2131363015));
        setTitleTextAppearance(2131625429);
        setThumbnailSize((int) getResources().getDimension(2131429885));
        setOnClickListener(new C00781(this));
    }

    public final void m894a(@Nonnull InfoReviewOverflowLinkModel infoReviewOverflowLinkModel, @Nonnull InfoReviewHandler infoReviewHandler) {
        if (infoReviewOverflowLinkModel.b() == null || infoReviewOverflowLinkModel.c() == null || infoReviewOverflowLinkModel.a() == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.f866j = infoReviewHandler;
        this.f867k = infoReviewOverflowLinkModel;
        setTitleText(infoReviewOverflowLinkModel.b().a());
        this.f865i.a(Uri.parse(infoReviewOverflowLinkModel.a().b()), f864h);
    }
}
