package com.facebook.messaging.business.commerceui.uri;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriIntentBuilder.IUriTemplateIntentBuilder;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.business.common.activity.BusinessActivity;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: num_send_bytes */
public class CommerceUriIntentBuilder extends UriIntentBuilder {
    public final Provider<Boolean> f8403a;

    /* compiled from: num_send_bytes */
    class CommerceViewUriIntentBuilder implements IUriTemplateIntentBuilder {
        final /* synthetic */ CommerceUriIntentBuilder f8402a;

        public CommerceViewUriIntentBuilder(CommerceUriIntentBuilder commerceUriIntentBuilder) {
            this.f8402a = commerceUriIntentBuilder;
        }

        public final Intent m8675a(Context context, Bundle bundle) {
            if (!((Boolean) this.f8402a.f8403a.get()).booleanValue() || bundle.get("product_item_id") == null) {
                return null;
            }
            String l = Long.toString(bundle.getLong("product_item_id"));
            Parcelable bundle2 = new Bundle();
            bundle2.putString("product_item_id", l);
            return BusinessActivity.m8889a(context, "CommerceCheckoutSelectionFragment", bundle2);
        }
    }

    @Inject
    public CommerceUriIntentBuilder(Provider<Boolean> provider) {
        this.f8403a = provider;
        a(StringFormatUtil.formatStrLocaleSafe(MessengerLinks.L, "product_item_id"), new CommerceViewUriIntentBuilder(this));
    }
}
