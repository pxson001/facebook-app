package com.facebook.redspace.rx;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.facebook.graphql.executor.RequestSubscriber;
import com.facebook.graphql.executor.RequestSubscription;
import com.facebook.graphql.executor.RequestSubscription.1;
import com.google.common.base.Function;
import rx.subscriptions.Subscriptions;

/* compiled from: PROFILE_FIELD_EXPERIENCE_ITEM_END */
public class RxTextViewBinder {

    /* compiled from: PROFILE_FIELD_EXPERIENCE_ITEM_END */
    public class TextViewTextChangeEventOnSubscribe implements Function<RequestSubscriber<? super String>, Void> {
        public final TextView f12289a;

        public Object apply(Object obj) {
            final RequestSubscriber requestSubscriber = (RequestSubscriber) obj;
            final TextWatcher c14511 = new TextWatcher(this) {
                final /* synthetic */ TextViewTextChangeEventOnSubscribe f12286b;

                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    if (!requestSubscriber.b()) {
                        requestSubscriber.a(editable.toString());
                    }
                }
            };
            this.f12289a.addTextChangedListener(c14511);
            requestSubscriber.a.a(new RequestSubscription(Subscriptions.a(new 1(new Function<Void, Void>(this) {
                final /* synthetic */ TextViewTextChangeEventOnSubscribe f12288b;

                public Object apply(Object obj) {
                    this.f12288b.f12289a.removeTextChangedListener(c14511);
                    return null;
                }
            }))).a);
            return null;
        }

        public TextViewTextChangeEventOnSubscribe(TextView textView) {
            this.f12289a = textView;
        }
    }
}
