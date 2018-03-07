package com.facebook.zero.intent;

import android.content.Intent;
import android.net.Uri;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.TriState;
import com.facebook.config.application.Product;
import com.facebook.zero.common.intent.ExternalIntentWhitelistItem;
import com.facebook.zero.util.ZeroUriUtil;
import javax.inject.Inject;

/* compiled from: ु */
public class FbLinkExternalIntentWhitelistItem implements ExternalIntentWhitelistItem {
    private final Product f110a;

    @Inject
    public FbLinkExternalIntentWhitelistItem(Product product) {
        this.f110a = product;
    }

    public final TriState m100a(Intent intent) {
        Uri data = intent.getData();
        if (data != null) {
            if (FacebookUriUtil.a(data)) {
                return TriState.UNSET;
            }
            if (this.f110a == Product.FB4A || this.f110a == Product.MESSENGER) {
                int i;
                if (data == null || !FacebookUriUtil.f(data)) {
                    i = 0;
                } else {
                    String host = data.getHost();
                    if (host == null) {
                        i = 0;
                    } else {
                        for (String str : ZeroUriUtil.f367a) {
                            String str2;
                            if (str2.codePointAt(0) == 46) {
                                str2 = str2.substring(1);
                            }
                            if (host.equals(str2) || host.endsWith("." + str2)) {
                                i = 1;
                                break;
                            }
                        }
                        i = 0;
                    }
                }
                if (i != 0) {
                    return TriState.YES;
                }
            }
        }
        return TriState.UNSET;
    }
}
