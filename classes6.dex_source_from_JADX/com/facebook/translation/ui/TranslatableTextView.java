package com.facebook.translation.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.facebook.common.i18n.StringLengthHelper;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLTranslatabilityType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: data3 */
public class TranslatableTextView extends CustomLinearLayout {
    private CharSequence f17955a;
    private CharSequence f17956b;
    private String f17957c;
    private FbTextView f17958d;
    private View f17959e;
    private CharSequence f17960f;
    private CharSequence f17961g;
    private Resources f17962h;

    /* compiled from: data3 */
    class C12991 implements OnClickListener {
        final /* synthetic */ TranslatableTextView f17954a;

        C12991(TranslatableTextView translatableTextView) {
            this.f17954a = translatableTextView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1320105171);
            this.f17954a.performClick();
            Logger.a(2, EntryType.UI_INPUT_END, -3638615, a);
        }
    }

    public TranslatableTextView(Context context) {
        super(context);
        m26479a(context);
    }

    public TranslatableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26479a(context);
    }

    public TranslatableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26479a(context);
    }

    private void m26479a(Context context) {
        this.f17962h = context.getResources();
        this.f17957c = context.getString(2131233177);
        this.f17960f = context.getString(2131233175);
        this.f17961g = context.getString(2131233176);
        setContentView(2130907533);
        setOrientation(0);
        this.f17958d = (FbTextView) a(2131559755);
        this.f17958d.setMovementMethod(LinkMovementMethod.getInstance());
        this.f17958d.setOnClickListener(new C12991(this));
    }

    public void setUntranslatedText(CharSequence charSequence) {
        this.f17955a = charSequence;
        this.f17958d.setText(this.f17955a);
    }

    public final void m26482a(CharSequence charSequence, GraphQLTranslatabilityType graphQLTranslatabilityType) {
        CharSequence spannableStringBuilder = new SpannableStringBuilder(charSequence);
        spannableStringBuilder.append('\n');
        spannableStringBuilder.append(m26478a(graphQLTranslatabilityType));
        this.f17956b = spannableStringBuilder;
    }

    public final void m26481a() {
        m26480e();
        CharSequence valueOf = SpannableString.valueOf(this.f17957c);
        valueOf.setSpan(new ForegroundColorSpan(2131361858), 0, StringLengthHelper.a(this.f17957c), 33);
        this.f17958d.setText(new SpannableStringBuilder(this.f17955a).append('\n').append(valueOf));
    }

    public final void m26483b() {
        if (this.f17956b != null) {
            if (this.f17959e == null) {
                this.f17959e = ((ViewStub) a(2131568095)).inflate();
            }
            this.f17958d.setText(this.f17956b);
            this.f17959e.setVisibility(0);
        }
    }

    public final void m26485c() {
        this.f17958d.setText(this.f17955a);
        m26480e();
    }

    public final boolean m26486d() {
        if (this.f17956b == null) {
            return false;
        }
        return StringUtil.a(this.f17958d.getText().toString(), this.f17956b.toString());
    }

    public final boolean m26484b(CharSequence charSequence, GraphQLTranslatabilityType graphQLTranslatabilityType) {
        m26482a(charSequence, graphQLTranslatabilityType);
        if (m26486d()) {
            m26485c();
            return false;
        }
        m26483b();
        return true;
    }

    private void m26480e() {
        if (this.f17959e != null) {
            this.f17959e.setVisibility(8);
        }
    }

    public final void setMovementMethod(MovementMethod movementMethod) {
        this.f17958d.setMovementMethod(movementMethod);
    }

    public TextView getTextView() {
        return this.f17958d;
    }

    public CharSequence getText() {
        return this.f17958d.getText();
    }

    public float getTextSize() {
        return this.f17958d.getTextSize();
    }

    public void setContentDescription(CharSequence charSequence) {
        this.f17958d.setContentDescription(charSequence);
    }

    public CharSequence getContentDescription() {
        return this.f17958d.getContentDescription();
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.f17958d.setOnTouchListener(onTouchListener);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f17958d.setOnClickListener(onClickListener);
    }

    private Spannable m26478a(GraphQLTranslatabilityType graphQLTranslatabilityType) {
        CharSequence charSequence = graphQLTranslatabilityType == GraphQLTranslatabilityType.SEE_CONVERSION ? this.f17961g : this.f17960f;
        Spannable valueOf = SpannableString.valueOf(charSequence);
        valueOf.setSpan(new ForegroundColorSpan(this.f17962h.getColor(2131361858)), 0, charSequence.length(), 33);
        valueOf.setSpan(new AbsoluteSizeSpan(this.f17962h.getDimensionPixelSize(2131428681)), 0, charSequence.length(), 33);
        return valueOf;
    }
}
