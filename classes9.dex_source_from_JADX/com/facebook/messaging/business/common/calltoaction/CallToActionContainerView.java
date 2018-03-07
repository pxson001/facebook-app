package com.facebook.messaging.business.common.calltoaction;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.common.calltoaction.model.CallToAction;
import com.facebook.messaging.business.common.calltoaction.model.CallToAction.Type;
import com.facebook.messaging.xma.XMAAction;
import com.facebook.messaging.xma.ui.XMALinearLayout;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: newBuilderForField is only valid for fields with message type. */
public class CallToActionContainerView extends XMALinearLayout {
    private final LayoutInflater f8724b;
    private final OnClickListener f8725c;
    @Nullable
    private List<CallToAction> f8726d;
    @Nullable
    public Uri f8727e;
    @Nullable
    public String f8728f;

    /* compiled from: newBuilderForField is only valid for fields with message type. */
    class C09981 implements OnClickListener {
        final /* synthetic */ CallToActionContainerView f8723a;

        C09981(CallToActionContainerView callToActionContainerView) {
            this.f8723a = callToActionContainerView;
        }

        public void onClick(final View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1223281511);
            Preconditions.checkState(view.getTag() instanceof CallToAction);
            final CallToAction callToAction = (CallToAction) view.getTag();
            this.f8723a.a(new XMAAction("xma_action_cta_clicked", CallToActionXMAHandler.m8933a(callToAction, null, callToAction.a != null ? callToAction.a : this.f8723a.f8727e, this.f8723a.f8728f), new Object(this) {
                final /* synthetic */ C09981 f8722c;

                public final void m8927a() {
                    if (callToAction.b != null && callToAction.b.equals(Type.POSTBACK)) {
                        view.setEnabled(false);
                    }
                }

                public final void m8928b() {
                    if (callToAction.b != null && callToAction.b.equals(Type.POSTBACK) && !callToAction.d) {
                        view.setEnabled(true);
                    }
                }
            }));
            LogUtils.a(-67343628, a);
        }
    }

    public CallToActionContainerView(Context context) {
        this(context, null);
    }

    public CallToActionContainerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CallToActionContainerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(1);
        setGravity(5);
        this.f8724b = LayoutInflater.from(context);
        this.f8725c = new C09981(this);
    }

    public final void m8932a(List<CallToAction> list, Uri uri, String str) {
        this.f8726d = list;
        this.f8727e = uri;
        this.f8728f = str;
        if (this.f8726d == null || this.f8726d.isEmpty()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        int size = this.f8726d.size();
        int childCount = getChildCount();
        for (int i = size; i < childCount; i++) {
            getChildAt(i).setVisibility(8);
        }
        for (int i2 = 0; i2 < size; i2++) {
            BetterTextView betterTextView;
            if (i2 < childCount) {
                View childAt = getChildAt(i2);
                Preconditions.checkState(childAt instanceof BetterTextView);
                betterTextView = (BetterTextView) childAt;
            } else {
                BetterTextView betterTextView2 = (BetterTextView) this.f8724b.inflate(2130906293, this, false);
                addView(betterTextView2);
                betterTextView = betterTextView2;
            }
            CallToAction callToAction = (CallToAction) this.f8726d.get(i2);
            betterTextView.setTag(callToAction);
            betterTextView.setVisibility(0);
            betterTextView.setText(callToAction.b());
            betterTextView.setOnClickListener(this.f8725c);
            betterTextView.setEnabled(true);
        }
    }

    protected void onMeasure(int i, int i2) {
        setOrientation(m8930a(i, i2) ? 1 : 0);
        super.onMeasure(i, i2);
    }

    private boolean m8930a(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 0) {
                measureChild(childAt, i, i2);
                i3 += childAt.getMeasuredWidth();
            }
        }
        if (i3 > size) {
            return true;
        }
        return false;
    }
}
