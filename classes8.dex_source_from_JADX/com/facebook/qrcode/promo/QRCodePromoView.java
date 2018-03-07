package com.facebook.qrcode.promo;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qrcode.promo.constant.QRCodeSource;
import javax.inject.Inject;

/* compiled from: call_site */
public class QRCodePromoView extends ContentView {
    @Inject
    public FbUriIntentHandler f18577h;
    public QRCodeSource f18578i;

    /* compiled from: call_site */
    public class C20561 implements OnClickListener {
        final /* synthetic */ QRCodePromoView f18576a;

        public C20561(QRCodePromoView qRCodePromoView) {
            this.f18576a = qRCodePromoView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1072574283);
            this.f18576a.f18577h.a(this.f18576a.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.dk, this.f18576a.f18578i.value));
            Logger.a(2, EntryType.UI_INPUT_END, -697589733, a);
        }
    }

    public static void m22465a(Object obj, Context context) {
        ((QRCodePromoView) obj).f18577h = FbUriIntentHandler.a(FbInjector.get(context));
    }

    public QRCodePromoView(Context context, QRCodeSource qRCodeSource) {
        super(context);
        Class cls = QRCodePromoView.class;
        m22465a(this, getContext());
        this.f18578i = qRCodeSource;
        setBackgroundResource(2130839797);
        setThumbnailResource(2130840608);
        setThumbnailSize(ThumbnailSize.MEDIUM);
        setTitleText(2131239342);
        setSubtitleText(2131239343);
        setOnClickListener(new C20561(this));
    }

    public void setEntryPoint(QRCodeSource qRCodeSource) {
        this.f18578i = qRCodeSource;
    }
}
