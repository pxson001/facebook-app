package com.facebook.messaging.business.commerceui.views.retail;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.attachments.model.LogoImage;
import com.facebook.messaging.business.commerce.model.retail.CommerceBubbleModel;
import com.facebook.messaging.business.commerce.model.retail.CommerceBubbleModelType;
import com.facebook.messaging.business.commerce.model.retail.Receipt;
import com.facebook.messaging.business.commerce.model.retail.ReceiptCancellation;
import com.facebook.messaging.business.commerce.model.retail.RetailAddress;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: null content-disposition */
public class CommerceViewHelpers {
    private Resources f8507a;
    private final int f8508b = ((int) this.f8507a.getDimension(2131433459));
    private final int f8509c = ((int) this.f8507a.getDimension(2131433460));

    public static CommerceViewHelpers m8755b(InjectorLike injectorLike) {
        return new CommerceViewHelpers(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public CommerceViewHelpers(Resources resources) {
        this.f8507a = resources;
    }

    public final boolean m8756a(FbDraweeView fbDraweeView, @Nullable LogoImage logoImage, CallerContext callerContext) {
        Preconditions.checkNotNull(fbDraweeView);
        if (logoImage == null || logoImage.a == null) {
            fbDraweeView.setVisibility(8);
            return false;
        }
        fbDraweeView.setVisibility(0);
        fbDraweeView.a(logoImage.a, callerContext);
        fbDraweeView.setBackgroundResource(2131363763);
        if (logoImage.b <= 0 || logoImage.c <= 0) {
            return false;
        }
        LayoutParams layoutParams = fbDraweeView.getLayoutParams();
        layoutParams.width = Math.min(logoImage.b, this.f8508b);
        layoutParams.height = Math.min(logoImage.c, this.f8509c);
        fbDraweeView.setLayoutParams(layoutParams);
        return true;
    }

    public static void m8754a(View view, View view2, View view3, boolean z) {
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(view2);
        Preconditions.checkNotNull(view3);
        if (z) {
            view2.setVisibility(0);
            view3.setVisibility(8);
        } else {
            view2.setVisibility(8);
            view3.setVisibility(0);
        }
        view.requestLayout();
    }

    @Nullable
    public static String m8753a(@Nullable CommerceBubbleModel commerceBubbleModel) {
        if (commerceBubbleModel != null) {
            if (commerceBubbleModel.b() == CommerceBubbleModelType.RECEIPT) {
                return ((Receipt) commerceBubbleModel).a;
            }
            if (commerceBubbleModel.b() == CommerceBubbleModelType.CANCELLATION) {
                return ((ReceiptCancellation) commerceBubbleModel).b.a;
            }
        }
        return null;
    }

    public static String m8752a(Context context, @Nullable RetailAddress retailAddress) {
        if (retailAddress == null || Strings.isNullOrEmpty(retailAddress.c) || Strings.isNullOrEmpty(retailAddress.d)) {
            return null;
        }
        int i;
        String str = retailAddress.c;
        String str2 = retailAddress.d;
        String str3 = retailAddress.e;
        String str4 = retailAddress.f;
        if (Strings.isNullOrEmpty(str3)) {
            i = 0;
        } else {
            i = 1;
        }
        int i2;
        if (Strings.isNullOrEmpty(str4)) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (i == 0 && r3 == 0) {
            return context.getResources().getString(2131240695, new Object[]{str, str2});
        } else if (i != 0 && r3 == 0) {
            return context.getResources().getString(2131240698, new Object[]{str, str2, str3});
        } else if (i == 0) {
            return context.getResources().getString(2131240699, new Object[]{str, str2, str4});
        } else {
            return context.getResources().getString(2131240700, new Object[]{str, str2, str3, str4});
        }
    }
}
