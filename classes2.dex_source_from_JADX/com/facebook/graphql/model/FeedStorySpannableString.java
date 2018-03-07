package com.facebook.graphql.model;

import android.text.SpannableString;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: is_commerce */
public class FeedStorySpannableString extends SpannableString {
    private WeakReference<TextViewCallback> f23122a;

    /* compiled from: is_commerce */
    public interface TextViewCallback {
    }

    public FeedStorySpannableString(CharSequence charSequence) {
        super(charSequence);
    }

    public final void m31235a(@Nullable TextViewCallback textViewCallback) {
        if (textViewCallback == null) {
            this.f23122a = null;
        } else {
            this.f23122a = new WeakReference(textViewCallback);
        }
    }
}
