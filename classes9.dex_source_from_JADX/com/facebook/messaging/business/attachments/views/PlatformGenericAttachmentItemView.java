package com.facebook.messaging.business.attachments.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.support.v7.internal.widget.ViewStubCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.attachments.model.LogoImage;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachmentItem;
import com.facebook.messaging.business.common.calltoaction.CallToActionContainerView;
import com.facebook.messaging.business.common.calltoaction.CallToActionXMAHandler;
import com.facebook.messaging.business.common.calltoaction.model.CallToAction;
import com.facebook.messaging.xma.XMAAction;
import com.facebook.messaging.xma.ui.XMALinearLayout;
import com.facebook.orca.threadview.MessageXMACallbackHelper.1;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: object_attachment */
public class PlatformGenericAttachmentItemView extends XMALinearLayout {
    private static final CallerContext f8347b = CallerContext.a(PlatformGenericAttachmentItemView.class);
    private final FbDraweeView f8348c;
    private final View f8349d;
    private final FbDraweeView f8350e;
    private final LinearLayout f8351f;
    private final BetterTextView f8352g;
    private final BetterTextView f8353h;
    private final BetterTextView f8354i;
    private final BetterTextView f8355j;
    private final BetterTextView f8356k;
    private final ViewStubHolder<CallToActionContainerView> f8357l;
    public Uri f8358m;
    public PlatformGenericAttachmentItem f8359n;
    private List<CallToAction> f8360o;
    private LogoImage f8361p;

    /* compiled from: object_attachment */
    class C09451 implements OnClickListener {
        final /* synthetic */ PlatformGenericAttachmentItemView f8346a;

        C09451(PlatformGenericAttachmentItemView platformGenericAttachmentItemView) {
            this.f8346a = platformGenericAttachmentItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1541661145);
            Uri uri = this.f8346a.f8359n.l == null ? this.f8346a.f8358m : this.f8346a.f8359n.l;
            if (uri != null) {
                this.f8346a.a(new XMAAction("xma_action_cta_clicked", CallToActionXMAHandler.m8933a(null, this.f8346a.f8359n.m, uri, this.f8346a.f8359n.a)));
            }
            LogUtils.a(-101103183, a);
        }
    }

    public PlatformGenericAttachmentItemView(Context context) {
        this(context, null);
    }

    public PlatformGenericAttachmentItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    public PlatformGenericAttachmentItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905607);
        setOrientation(1);
        this.f8348c = (FbDraweeView) a(2131564583);
        this.f8349d = a(2131564584);
        this.f8350e = (FbDraweeView) a(2131564585);
        this.f8351f = (LinearLayout) a(2131564586);
        this.f8352g = (BetterTextView) a(2131564587);
        this.f8353h = (BetterTextView) a(2131564588);
        this.f8354i = (BetterTextView) a(2131564589);
        this.f8355j = (BetterTextView) a(2131564590);
        this.f8356k = (BetterTextView) a(2131564591);
        this.f8357l = ViewStubHolder.a((ViewStubCompat) a(2131564592));
        setOnClickListener(new C09451(this));
    }

    public void setFallbackUri(Uri uri) {
        this.f8358m = uri;
    }

    public final void m8646a(PlatformGenericAttachmentItem platformGenericAttachmentItem, @Nullable List<CallToAction> list, @Nullable LogoImage logoImage) {
        Preconditions.checkNotNull(platformGenericAttachmentItem);
        this.f8359n = platformGenericAttachmentItem;
        if (list == null || list.isEmpty()) {
            list = platformGenericAttachmentItem.k;
        }
        this.f8360o = list;
        this.f8361p = logoImage;
        m8644b();
    }

    public final void m8647a(@Nullable 1 1) {
        ((CallToActionContainerView) this.f8357l.a()).setXMACallback(1);
    }

    public void setDescriptionBackgroundColor(int i) {
        this.f8351f.setBackgroundColor(i);
    }

    public final void m8645a() {
        this.f8356k.setVisibility(8);
    }

    private void m8644b() {
        Preconditions.checkNotNull(this.f8359n);
        if (this.f8359n.d != null) {
            this.f8348c.setVisibility(0);
            this.f8348c.setBackgroundResource(2131363811);
            this.f8348c.a(this.f8359n.d, f8347b);
            this.f8349d.setVisibility(0);
        } else {
            this.f8348c.setVisibility(8);
            this.f8349d.setVisibility(8);
        }
        m8641a(this.f8350e, this.f8361p, f8347b);
        m8642a(this.f8352g, this.f8359n.b);
        m8642a(this.f8353h, this.f8359n.g);
        m8642a(this.f8354i, this.f8359n.h);
        m8642a(this.f8355j, this.f8359n.i);
        m8642a(this.f8356k, m8640a(this.f8359n));
        if (this.f8360o == null || this.f8360o.isEmpty()) {
            this.f8357l.e();
            return;
        }
        ((CallToActionContainerView) this.f8357l.a()).m8932a(this.f8360o, this.f8359n.l, this.f8359n.a);
        this.f8357l.f();
    }

    private static void m8641a(FbDraweeView fbDraweeView, LogoImage logoImage, CallerContext callerContext) {
        if (logoImage == null || logoImage.a == null) {
            fbDraweeView.setVisibility(8);
            return;
        }
        fbDraweeView.a(logoImage.a, callerContext);
        fbDraweeView.setVisibility(0);
    }

    private static void m8642a(BetterTextView betterTextView, String str) {
        if (Strings.isNullOrEmpty(str)) {
            betterTextView.setVisibility(8);
            return;
        }
        betterTextView.setVisibility(0);
        betterTextView.setText(str);
    }

    private static String m8640a(PlatformGenericAttachmentItem platformGenericAttachmentItem) {
        if (Strings.isNullOrEmpty(platformGenericAttachmentItem.j)) {
            return platformGenericAttachmentItem.l == null ? null : platformGenericAttachmentItem.l.getHost();
        } else {
            return platformGenericAttachmentItem.j;
        }
    }
}
