package com.facebook.messaging.business.commerceui.views.retail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachmentItem;
import com.facebook.messaging.business.commerce.model.retail.CommerceBubbleModel;
import com.facebook.messaging.business.commerce.model.retail.CommerceBubbleModelType;
import com.facebook.messaging.business.commerce.model.retail.Receipt;
import com.facebook.messaging.business.commerceui.views.CommerceView;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: null ViewerContextUser found when declining payment request id %s */
public class MultiItemReceiptView extends CustomRelativeLayout implements CommerceView {
    private static final CallerContext f8522b = CallerContext.a(MultiItemReceiptView.class);
    @Inject
    public CommerceViewHelpers f8523a;
    private final ReceiptViewModelHelper f8524c;
    private final LinearLayout f8525d;
    private final View f8526e;
    private final View f8527f;
    private final BetterTextView f8528g;
    private final BetterTextView f8529h;
    private final BetterTextView f8530i;
    private final BetterTextView f8531j;
    private final BetterTextView f8532k;
    private final View f8533l;
    private final View f8534m;
    private final FbDraweeView f8535n;
    private final BetterTextView f8536o;
    private final BetterTextView f8537p;
    private final BetterTextView f8538q;
    private final ImmutableList<View> f8539r;

    private static <T extends View> void m8764a(Class<T> cls, T t) {
        m8765a((Object) t, t.getContext());
    }

    private static void m8765a(Object obj, Context context) {
        ((MultiItemReceiptView) obj).f8523a = CommerceViewHelpers.m8755b(FbInjector.get(context));
    }

    private void m8763a(CommerceViewHelpers commerceViewHelpers) {
        this.f8523a = commerceViewHelpers;
    }

    public MultiItemReceiptView(Context context) {
        this(context, null);
    }

    public MultiItemReceiptView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiItemReceiptView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8764a(MultiItemReceiptView.class, (View) this);
        setContentView(2130905596);
        this.f8524c = new ReceiptViewModelHelper(context);
        this.f8525d = (LinearLayout) a(2131564528);
        this.f8526e = a(2131564567);
        this.f8527f = a(2131560071);
        this.f8528g = (BetterTextView) a(2131564568);
        this.f8533l = a(2131560072);
        this.f8534m = a(2131564564);
        this.f8535n = (FbDraweeView) a(2131564569);
        this.f8529h = (BetterTextView) a(2131564534);
        this.f8530i = (BetterTextView) a(2131564535);
        this.f8531j = (BetterTextView) a(2131564536);
        this.f8532k = (BetterTextView) a(2131564537);
        this.f8536o = (BetterTextView) a(2131564565);
        this.f8537p = (BetterTextView) a(2131564566);
        this.f8538q = (BetterTextView) a(2131564533);
        this.f8539r = ImmutableList.of(a(2131564529), a(2131564532));
    }

    public void setModel(CommerceBubbleModel commerceBubbleModel) {
        this.f8524c.m8802a(commerceBubbleModel);
        m8766b();
    }

    public final boolean mo231a() {
        return false;
    }

    private void m8766b() {
        m8770f();
        m8767c();
        m8768d();
        m8769e();
        m8771g();
    }

    private void m8767c() {
        ImmutableList c;
        if (this.f8524c.f8574b != null) {
            c = this.f8524c.f8574b.c();
        } else {
            c = RegularImmutableList.a;
        }
        for (int i = 0; i < this.f8539r.size(); i++) {
            PlatformGenericAttachmentItem platformGenericAttachmentItem;
            if (i < c.size()) {
                platformGenericAttachmentItem = (PlatformGenericAttachmentItem) c.get(i);
            } else {
                platformGenericAttachmentItem = null;
            }
            View view = (View) this.f8539r.get(i);
            if (platformGenericAttachmentItem != null) {
                view.setVisibility(0);
                FbDraweeView fbDraweeView = (FbDraweeView) FindViewUtil.b(view, 2131564574);
                if (platformGenericAttachmentItem.d != null) {
                    fbDraweeView.a(platformGenericAttachmentItem.d, f8522b);
                }
                ((BetterTextView) FindViewUtil.b(view, 2131564570)).setText(platformGenericAttachmentItem.b);
                m8762a(view, platformGenericAttachmentItem);
            } else {
                view.setVisibility(8);
            }
        }
    }

    private void m8768d() {
        ImmutableList c;
        if (this.f8524c.f8574b != null) {
            c = this.f8524c.f8574b.c();
        } else {
            c = null;
        }
        if (c == null || c.size() <= this.f8539r.size()) {
            this.f8538q.setVisibility(8);
            return;
        }
        this.f8538q.setVisibility(0);
        this.f8538q.setText(StringLocaleUtil.a(getResources().getString(2131240661), new Object[]{Integer.valueOf(c.size() - this.f8539r.size())}));
    }

    private static void m8762a(View view, PlatformGenericAttachmentItem platformGenericAttachmentItem) {
        int i = 0;
        BetterTextView betterTextView = (BetterTextView) FindViewUtil.b(view, 2131564571);
        betterTextView.setVisibility(!Strings.isNullOrEmpty(platformGenericAttachmentItem.g) ? 0 : 8);
        betterTextView.setText(!Strings.isNullOrEmpty(platformGenericAttachmentItem.g) ? platformGenericAttachmentItem.g : "");
        betterTextView = (BetterTextView) FindViewUtil.b(view, 2131564572);
        if (Strings.isNullOrEmpty(platformGenericAttachmentItem.h)) {
            i = 8;
        }
        betterTextView.setVisibility(i);
        betterTextView.setText(!Strings.isNullOrEmpty(platformGenericAttachmentItem.h) ? platformGenericAttachmentItem.h : "");
        ((BetterTextView) FindViewUtil.b(view, 2131564573)).setVisibility(8);
    }

    private void m8769e() {
        String str;
        int i;
        int i2 = 0;
        ReceiptViewModelHelper receiptViewModelHelper = this.f8524c;
        if (receiptViewModelHelper.f8574b == null || receiptViewModelHelper.f8574b.b() != CommerceBubbleModelType.RECEIPT) {
            str = null;
        } else {
            str = ((Receipt) receiptViewModelHelper.f8574b).d;
        }
        String str2 = str;
        this.f8530i.setText(str2);
        this.f8530i.setVisibility(!Strings.isNullOrEmpty(str2) ? 0 : 8);
        BetterTextView betterTextView = this.f8529h;
        if (Strings.isNullOrEmpty(str2)) {
            i = 8;
        } else {
            i = 0;
        }
        betterTextView.setVisibility(i);
        str2 = this.f8524c.m8804e();
        this.f8532k.setText(str2);
        betterTextView = this.f8532k;
        if (Strings.isNullOrEmpty(str2)) {
            i = 8;
        } else {
            i = 0;
        }
        betterTextView.setVisibility(i);
        BetterTextView betterTextView2 = this.f8531j;
        if (Strings.isNullOrEmpty(str2)) {
            i2 = 8;
        }
        betterTextView2.setVisibility(i2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m8770f() {
        /*
        r11 = this;
        r7 = 8;
        r3 = 0;
        r0 = r11.f8524c;
        r8 = 0;
        r9 = r0.f8574b;
        if (r9 == 0) goto L_0x001d;
    L_0x000a:
        r9 = r0.f8574b;
        r9 = r9.b();
        r10 = com.facebook.messaging.business.commerce.model.retail.CommerceBubbleModelType.RECEIPT;
        if (r9 != r10) goto L_0x0096;
    L_0x0014:
        r8 = r0.f8573a;
        r9 = 2131240654; // 0x7f0826ce float:1.809765E38 double:1.05297279E-314;
        r8 = r8.getString(r9);
    L_0x001d:
        r4 = r8;
        r0 = r11.f8524c;
        r5 = r0.m8803c();
        r0 = r11.f8539r;
        r0 = r0.get(r3);
        r0 = (android.view.View) r0;
        r0 = r0.getLayoutParams();
        r0 = (android.widget.LinearLayout.LayoutParams) r0;
        r1 = r11.getResources();
        r2 = 2131433461; // 0x7f0b17f5 float:1.8488708E38 double:1.0530680495E-314;
        r1 = r1.getDimension(r2);
        r6 = (int) r1;
        r1 = com.google.common.base.Strings.isNullOrEmpty(r4);
        if (r1 != 0) goto L_0x0080;
    L_0x0044:
        r1 = 1;
        r2 = r1;
    L_0x0046:
        if (r2 == 0) goto L_0x0082;
    L_0x0048:
        r1 = r11.f8528g;
        r1.setVisibility(r3);
        r1 = r11.f8527f;
        r1.setVisibility(r3);
        r1 = r11.f8528g;
        r1.setText(r4);
        r0.setMargins(r6, r6, r6, r3);
    L_0x005a:
        r1 = r11.f8539r;
        r1 = r1.get(r3);
        r1 = (android.view.View) r1;
        r1.setLayoutParams(r0);
        r0 = r11.f8523a;
        r1 = r11.f8535n;
        r4 = f8522b;
        r0.m8756a(r1, r5, r4);
        if (r2 != 0) goto L_0x007a;
    L_0x0070:
        if (r5 == 0) goto L_0x0090;
    L_0x0072:
        r8 = r5.a;
        if (r8 == 0) goto L_0x00c3;
    L_0x0076:
        r8 = 1;
    L_0x0077:
        r0 = r8;
        if (r0 == 0) goto L_0x0090;
    L_0x007a:
        r0 = r11.f8526e;
        r0.setVisibility(r3);
    L_0x007f:
        return;
    L_0x0080:
        r2 = r3;
        goto L_0x0046;
    L_0x0082:
        r1 = r11.f8528g;
        r1.setVisibility(r7);
        r1 = r11.f8527f;
        r1.setVisibility(r7);
        r0.setMargins(r6, r3, r6, r3);
        goto L_0x005a;
    L_0x0090:
        r0 = r11.f8526e;
        r0.setVisibility(r7);
        goto L_0x007f;
    L_0x0096:
        r9 = r0.f8574b;
        r9 = r9.b();
        r10 = com.facebook.messaging.business.commerce.model.retail.CommerceBubbleModelType.CANCELLATION;
        if (r9 != r10) goto L_0x001d;
    L_0x00a0:
        r8 = r0.f8574b;
        r8 = r8.c();
        r8 = r8.size();
        r9 = 1;
        if (r8 != r9) goto L_0x00b8;
    L_0x00ad:
        r8 = r0.f8573a;
        r9 = 2131240655; // 0x7f0826cf float:1.8097651E38 double:1.0529727907E-314;
        r8 = r8.getString(r9);
        goto L_0x001d;
    L_0x00b8:
        r8 = r0.f8573a;
        r9 = 2131240656; // 0x7f0826d0 float:1.8097653E38 double:1.052972791E-314;
        r8 = r8.getString(r9);
        goto L_0x001d;
    L_0x00c3:
        r8 = 0;
        goto L_0x0077;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.commerceui.views.retail.MultiItemReceiptView.f():void");
    }

    private void m8771g() {
        ImmutableList c;
        int i;
        if (this.f8524c.f8574b != null) {
            c = this.f8524c.f8574b.c();
        } else {
            c = null;
        }
        int dimension = (int) getResources().getDimension(2131433461);
        if (this.f8524c.f8574b == null || c == null || this.f8524c.f8574b.b() == CommerceBubbleModelType.CANCELLATION) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            this.f8525d.setPadding(0, 0, 0, 0);
            this.f8533l.setVisibility(0);
            this.f8534m.setVisibility(0);
            this.f8536o.setText(this.f8524c.m8805f());
            this.f8537p.setText(this.f8524c.m8806g());
            LayoutParams layoutParams;
            if (c.size() > this.f8539r.size()) {
                layoutParams = (LayoutParams) this.f8534m.getLayoutParams();
                layoutParams.setMargins(dimension, (int) getResources().getDimension(2131433472), dimension, 0);
                this.f8534m.setLayoutParams(layoutParams);
                return;
            }
            layoutParams = (LayoutParams) this.f8534m.getLayoutParams();
            layoutParams.setMargins(dimension, dimension, dimension, 0);
            this.f8534m.setLayoutParams(layoutParams);
            return;
        }
        this.f8533l.setVisibility(8);
        this.f8534m.setVisibility(8);
        this.f8525d.setPadding(0, 0, 0, dimension);
    }
}
