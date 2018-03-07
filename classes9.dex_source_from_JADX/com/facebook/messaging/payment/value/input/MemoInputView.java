package com.facebook.messaging.payment.value.input;

import android.content.Context;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.messaging.payment.utils.PaymentViewUtil;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterEditTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: exif_time */
public class MemoInputView extends CustomLinearLayout {
    @Inject
    MemoInputTextWatcher f15437a;
    @Inject
    Lazy<Vibrator> f15438b;
    @Inject
    Lazy<PaymentViewUtil> f15439c;
    public final BetterEditTextView f15440d;
    public Listener f15441e;

    /* compiled from: exif_time */
    public class C18011 {
        final /* synthetic */ MemoInputView f15436a;

        C18011(MemoInputView memoInputView) {
            this.f15436a = memoInputView;
        }

        public final void m15733a() {
            this.f15436a.f15441e.mo626a(this.f15436a.f15440d.getText().toString());
        }

        public final void m15734b() {
            ((PaymentViewUtil) this.f15436a.f15439c.get()).m15543a(this.f15436a.f15440d);
            ((Vibrator) this.f15436a.f15438b.get()).vibrate(50);
        }
    }

    /* compiled from: exif_time */
    public interface Listener {
        void mo626a(String str);
    }

    private static <T extends View> void m15738a(Class<T> cls, T t) {
        m15739a((Object) t, t.getContext());
    }

    private static void m15739a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((MemoInputView) obj).m15737a(new MemoInputTextWatcher(), IdBasedLazy.a(fbInjector, 52), IdBasedLazy.a(fbInjector, 8211));
    }

    public MemoInputView(Context context) {
        this(context, null);
    }

    public MemoInputView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected MemoInputView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15738a(MemoInputView.class, (View) this);
        setContentView(2130905213);
        this.f15440d = (BetterEditTextView) a(2131563802);
    }

    public void setListener(Listener listener) {
        this.f15441e = listener;
        this.f15437a.f15434b = new C18011(this);
        this.f15440d.addTextChangedListener(this.f15437a);
    }

    private void m15737a(MemoInputTextWatcher memoInputTextWatcher, Lazy<Vibrator> lazy, Lazy<PaymentViewUtil> lazy2) {
        this.f15437a = memoInputTextWatcher;
        this.f15438b = lazy;
        this.f15439c = lazy2;
    }

    public void setMemoText(String str) {
        if (!StringUtil.a(this.f15440d.getText().toString(), str)) {
            this.f15440d.setText(str);
        }
    }
}
