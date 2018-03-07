package com.facebook.messaging.business.commerceui.views.retail;

import android.content.Context;
import com.facebook.messaging.business.attachments.model.LogoImage;
import com.facebook.messaging.business.commerce.model.retail.CommerceBubbleModel;
import com.facebook.messaging.business.commerce.model.retail.CommerceBubbleModelType;
import com.facebook.messaging.business.commerce.model.retail.Receipt;
import com.facebook.messaging.business.commerce.model.retail.ReceiptCancellation;
import com.facebook.messaging.business.commerce.model.retail.RetailAddress;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: null ViewerContextUser found when canceling payment request id %s */
public class ReceiptViewModelHelper {
    public final Context f8573a;
    @Nullable
    public CommerceBubbleModel f8574b;

    public ReceiptViewModelHelper(Context context) {
        this.f8573a = (Context) Preconditions.checkNotNull(context);
    }

    public final ReceiptViewModelHelper m8802a(CommerceBubbleModel commerceBubbleModel) {
        this.f8574b = (CommerceBubbleModel) Preconditions.checkNotNull(commerceBubbleModel);
        return this;
    }

    @Nullable
    public final LogoImage m8803c() {
        if (this.f8574b != null) {
            if (this.f8574b.b() == CommerceBubbleModelType.RECEIPT) {
                return ((Receipt) this.f8574b).n;
            }
            if (this.f8574b.b() == CommerceBubbleModelType.CANCELLATION && ((ReceiptCancellation) this.f8574b).b != null) {
                return ((ReceiptCancellation) this.f8574b).b.n;
            }
        }
        return null;
    }

    @Nullable
    public final String m8804e() {
        if (this.f8574b == null || this.f8574b.b() != CommerceBubbleModelType.RECEIPT) {
            return null;
        }
        String str;
        Receipt receipt = (Receipt) this.f8574b;
        if (receipt.g != null) {
            String str2;
            RetailAddress retailAddress = receipt.g;
            if (Strings.isNullOrEmpty(retailAddress.a) || Strings.isNullOrEmpty(retailAddress.c) || Strings.isNullOrEmpty(retailAddress.d)) {
                str2 = null;
            } else {
                str2 = retailAddress.a;
                String str3 = retailAddress.b;
                String str4 = retailAddress.c;
                String str5 = retailAddress.d;
                if (Strings.isNullOrEmpty(str3)) {
                    str2 = this.f8573a.getResources().getString(2131240696, new Object[]{str2, str4, str5});
                } else {
                    str2 = this.f8573a.getResources().getString(2131240697, new Object[]{str2, str3, str4, str5});
                }
            }
            str = str2;
        } else {
            str = null;
        }
        return str;
    }

    public final String m8805f() {
        String str = "";
        if (this.f8574b == null || this.f8574b.b() != CommerceBubbleModelType.RECEIPT) {
            return str;
        }
        return this.f8573a.getString(2131240653);
    }

    public final String m8806g() {
        String str = "";
        if (this.f8574b == null || this.f8574b.b() != CommerceBubbleModelType.RECEIPT) {
            return str;
        }
        return ((Receipt) this.f8574b).i;
    }
}
