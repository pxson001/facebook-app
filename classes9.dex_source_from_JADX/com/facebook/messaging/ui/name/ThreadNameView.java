package com.facebook.messaging.ui.name;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.R;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.text.VariableTextLayoutComputer;
import com.facebook.widget.text.VariableTextLayoutView;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: check_payment_pins */
public class ThreadNameView extends VariableTextLayoutView<ThreadNameViewData> {
    @NamesOnlyThreadNameViewComputer
    @Inject
    volatile Provider<ThreadNameViewComputer> f18247a = UltralightRuntime.a;
    @Inject
    @DefaultThreadNameViewComputer
    volatile Provider<ThreadNameViewComputer> f18248b = UltralightRuntime.a;
    private ThreadNameViewComputer f18249c;

    /* compiled from: check_payment_pins */
    public enum TextOptions {
        USE_THREAD_NAME_IF_AVAILABLE(0),
        USE_PARTICIPANTS_NAMES_ONLY(1);
        
        public final int value;

        private TextOptions(int i) {
            this.value = i;
        }
    }

    private static <T extends View> void m18210a(Class<T> cls, T t) {
        m18211a((Object) t, t.getContext());
    }

    private static void m18211a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ThreadNameView) obj).m18212a(IdBasedProvider.a(fbInjector, 8587), IdBasedProvider.a(fbInjector, 8586));
    }

    @Nullable
    protected final CharSequence m18213a(Object obj) {
        return this.f18249c.m18222a((ThreadNameViewData) obj, -1);
    }

    private void m18212a(Provider<ThreadNameViewComputer> provider, Provider<ThreadNameViewComputer> provider2) {
        this.f18247a = provider;
        this.f18248b = provider2;
    }

    public ThreadNameView(Context context) {
        super(context);
        m18209a(null);
    }

    public ThreadNameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18209a(attributeSet);
    }

    public ThreadNameView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18209a(attributeSet);
    }

    private void m18209a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ThreadNameView);
        int integer = obtainStyledAttributes.getInteger(7, TextOptions.USE_THREAD_NAME_IF_AVAILABLE.value);
        obtainStyledAttributes.recycle();
        m18210a(ThreadNameView.class, (View) this);
        if (integer == TextOptions.USE_THREAD_NAME_IF_AVAILABLE.value || integer != TextOptions.USE_PARTICIPANTS_NAMES_ONLY.value) {
            this.f18249c = (ThreadNameViewComputer) this.f18248b.get();
        } else {
            this.f18249c = (ThreadNameViewComputer) this.f18247a.get();
        }
    }

    protected VariableTextLayoutComputer<ThreadNameViewData> getVariableTextLayoutComputer() {
        return this.f18249c;
    }
}
