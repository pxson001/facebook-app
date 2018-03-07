package com.facebook.messaging.common.ui.widgets.text;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.deliveryreceipt.RowReceiptParticipant;
import com.facebook.ultralight.Inject;
import com.facebook.widget.text.VariableTextLayoutComputer;
import com.facebook.widget.text.VariableTextLayoutView;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: thread.latest_message_id */
public class RowReceiptTextView extends VariableTextLayoutView<Data> {
    @Inject
    public RowReceiptTextViewComputer f1691a;

    /* compiled from: thread.latest_message_id */
    public class Data {
        public final String f1689a;
        public final List<RowReceiptParticipant> f1690b;

        public Data(List<RowReceiptParticipant> list) {
            this.f1689a = null;
            this.f1690b = list;
        }

        public Data(String str) {
            this.f1689a = str;
            this.f1690b = null;
        }

        public final String m1655a() {
            return this.f1689a;
        }

        public final List<RowReceiptParticipant> m1656b() {
            return this.f1690b;
        }
    }

    private static <T extends View> void m1658a(Class<T> cls, T t) {
        m1659a((Object) t, t.getContext());
    }

    private static void m1659a(Object obj, Context context) {
        ((RowReceiptTextView) obj).f1691a = RowReceiptTextViewComputer.m1670b(FbInjector.get(context));
    }

    @Nullable
    protected final CharSequence m1661a(Object obj) {
        Data data = (Data) obj;
        if (data.f1689a != null) {
            return data.f1689a;
        }
        return super.getContentDescription();
    }

    private void m1657a(RowReceiptTextViewComputer rowReceiptTextViewComputer) {
        this.f1691a = rowReceiptTextViewComputer;
    }

    public RowReceiptTextView(Context context) {
        super(context);
        m1660b();
    }

    public RowReceiptTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1660b();
    }

    public RowReceiptTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1660b();
    }

    private void m1660b() {
        m1658a(RowReceiptTextView.class, (View) this);
    }

    protected VariableTextLayoutComputer<Data> getVariableTextLayoutComputer() {
        return this.f1691a;
    }

    public void setText(String str) {
        setData(new Data(str));
    }
}
