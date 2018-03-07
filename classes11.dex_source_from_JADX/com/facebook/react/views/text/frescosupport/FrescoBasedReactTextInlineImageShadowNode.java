package com.facebook.react.views.text.frescosupport;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.react.views.text.ReactTextInlineImageShadowNode;
import com.facebook.react.views.text.TextInlineImageSpan;
import com.facebook.react.views.textfrescosupport.FrescoBasedReactTextInlineImageSpan;
import java.util.Locale;
import javax.annotation.Nullable;

/* compiled from: REQUEST_PENDING */
public class FrescoBasedReactTextInlineImageShadowNode extends ReactTextInlineImageShadowNode {
    @Nullable
    public Uri f11557g;
    public final AbstractDraweeControllerBuilder f11558h;
    @Nullable
    public final Object f11559i;

    public FrescoBasedReactTextInlineImageShadowNode(AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, @Nullable Object obj) {
        this.f11558h = abstractDraweeControllerBuilder;
        this.f11559i = obj;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "src")
    public void setSource(@javax.annotation.Nullable java.lang.String r4) {
        /*
        r3 = this;
        r0 = 0;
        if (r4 == 0) goto L_0x0017;
    L_0x0003:
        r1 = android.net.Uri.parse(r4);	 Catch:{ Exception -> 0x0021 }
        r2 = r1.getScheme();	 Catch:{ Exception -> 0x0025 }
        if (r2 != 0) goto L_0x0023;
    L_0x000d:
        if (r0 != 0) goto L_0x0017;
    L_0x000f:
        r0 = r3.E();
        r0 = m12032a(r0, r4);
    L_0x0017:
        r1 = r3.f11557g;
        if (r0 == r1) goto L_0x001e;
    L_0x001b:
        r3.x();
    L_0x001e:
        r3.f11557g = r0;
        return;
    L_0x0021:
        r1 = move-exception;
        r1 = r0;
    L_0x0023:
        r0 = r1;
        goto L_0x000d;
    L_0x0025:
        r0 = move-exception;
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.frescosupport.FrescoBasedReactTextInlineImageShadowNode.setSource(java.lang.String):void");
    }

    @Nullable
    private Uri m12029P() {
        return this.f11557g;
    }

    @Nullable
    private static Uri m12032a(Context context, @Nullable String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return new Builder().scheme("res").path(String.valueOf(context.getResources().getIdentifier(str.toLowerCase(Locale.getDefault()).replace("-", "_"), "drawable", context.getPackageName()))).build();
    }

    public final boolean m12034s() {
        return true;
    }

    public final TextInlineImageSpan mo316O() {
        return new FrescoBasedReactTextInlineImageSpan(E().getResources(), (int) Math.ceil((double) l()), (int) Math.ceil((double) k()), this.f11557g, this.f11558h, this.f11559i);
    }

    private AbstractDraweeControllerBuilder m12030Q() {
        return this.f11558h;
    }

    @Nullable
    private Object m12031R() {
        return this.f11559i;
    }
}
