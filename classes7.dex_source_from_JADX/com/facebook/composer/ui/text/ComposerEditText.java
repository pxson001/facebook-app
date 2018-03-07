package com.facebook.composer.ui.text;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.facebook.common.invariants.InvariantViolationException;
import com.facebook.composer.metatext.MetaTextSpan;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.tagging.graphql.utils.MentionsUtils;
import com.facebook.tagging.graphql.utils.MentionsUtils.MentionChangeListener;
import com.facebook.tagging.ui.MentionsAutoCompleteTextView;
import java.util.HashSet;
import java.util.Set;

/* compiled from: composer_button_tooltip */
public class ComposerEditText extends MentionsAutoCompleteTextView implements HasUserText, MentionChangeListener {
    public boolean f17107b;
    public final Set<TextWithEntitiesChangedListener> f17108c = new HashSet();
    private final TextWatcher f17109d;
    private View f17110e;
    public boolean f17111f = false;
    private String f17112g;
    private final ForegroundColorSpan f17113h = new ForegroundColorSpan(getHintTextColors().getDefaultColor());
    private Editable f17114i;

    /* compiled from: composer_button_tooltip */
    class C13921 implements OnGlobalLayoutListener {
        final /* synthetic */ ComposerEditText f17105a;

        C13921(ComposerEditText composerEditText) {
            this.f17105a = composerEditText;
        }

        public void onGlobalLayout() {
            Object obj = null;
            ViewParent parent = this.f17105a.getParent();
            while (parent != null) {
                if ((parent instanceof ScrollView) || (parent instanceof RecyclerView)) {
                    obj = 1;
                    break;
                }
                parent = parent.getParent();
            }
            if (obj == null) {
                throw new InvariantViolationException("The wrapper of ComposerTextEdit must be put in a ScrollView or RecyclerView");
            }
            this.f17105a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    /* compiled from: composer_button_tooltip */
    class C13932 implements TextWatcher {
        final /* synthetic */ ComposerEditText f17106a;

        C13932(ComposerEditText composerEditText) {
            this.f17106a = composerEditText;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            GraphQLTextWithEntities textWithEntities = ComposerEditText.getTextWithEntities(this.f17106a);
            for (TextWithEntitiesChangedListener a : this.f17106a.f17108c) {
                a.m21045a(textWithEntities, this.f17106a.f17107b);
            }
            this.f17106a.f17107b = false;
            if (this.f17106a.f17111f) {
                CharSequence userText = this.f17106a.getUserText();
                if (this.f17106a.getText().length() != 0 && userText.length() == 0 && ComposerEditText.getMetaHintIndex(this.f17106a) == -1) {
                    ComposerEditText.m21050d(this.f17106a);
                } else if (ComposerEditText.getMetaHintIndex(this.f17106a) != -1 && userText.length() != 0) {
                    ComposerEditText.getMetaHintIndex(this.f17106a);
                }
            }
        }
    }

    /* compiled from: composer_button_tooltip */
    public interface TextWithEntitiesChangedListener {
        void m21044a(GraphQLTextWithEntities graphQLTextWithEntities);

        void m21045a(GraphQLTextWithEntities graphQLTextWithEntities, boolean z);
    }

    public ComposerEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        getViewTreeObserver().addOnGlobalLayoutListener(new C13921(this));
        setMovementMethod(new ComposerMovementMethod());
        this.f17109d = new C13932(this);
        addTextChangedListener(this.f17109d);
        this.b = this;
    }

    public final void m21061c() {
        if (this.f17111f && this.f17112g != null && !getHint().equals(this.f17112g) && getMetaHintIndex(this) != -1) {
            getMetaHintIndex(this);
        }
    }

    public static void m21050d(ComposerEditText composerEditText) {
        if (composerEditText.getUserText().length() == 0) {
            CharSequence hint = composerEditText.getHint();
            CharSequence spannableStringBuilder = new SpannableStringBuilder(hint);
            composerEditText.f17114i = composerEditText.getText();
            spannableStringBuilder.setSpan(composerEditText.f17113h, 0, hint.length(), 0);
            spannableStringBuilder.append(composerEditText.f17114i);
            composerEditText.setText(spannableStringBuilder);
        }
    }

    public static void m21053e(ComposerEditText composerEditText) {
        CharSequence spannableStringBuilder = new SpannableStringBuilder(composerEditText.getUserText());
        spannableStringBuilder.append(composerEditText.f17114i);
        spannableStringBuilder.removeSpan(composerEditText.f17113h);
        composerEditText.setText(spannableStringBuilder);
    }

    public void setShowPersistentHint(boolean z) {
        this.f17111f = z;
    }

    public static int getMetaHintIndex(ComposerEditText composerEditText) {
        int indexOf;
        Editable text = composerEditText.getText();
        CharSequence hint = composerEditText.getHint();
        if (hint != null) {
            indexOf = text.toString().indexOf(hint.toString());
            if (indexOf != -1) {
                composerEditText.f17112g = hint.toString();
                return indexOf;
            }
        }
        if (composerEditText.f17112g != null) {
            indexOf = text.toString().indexOf(composerEditText.f17112g);
            if (indexOf != -1) {
                return indexOf;
            }
        }
        return -1;
    }

    public final void m21057a() {
        GraphQLTextWithEntities textWithEntities = getTextWithEntities(this);
        for (TextWithEntitiesChangedListener a : this.f17108c) {
            a.m21044a(textWithEntities);
        }
    }

    public final void m21058a(View view) {
        this.f17110e = view;
        setDropDownAnchor(this.f17110e.getId());
    }

    private int getEndIndex() {
        int metaHintIndex = getMetaHintIndex(this);
        if (this.f17111f && metaHintIndex != -1) {
            return metaHintIndex;
        }
        Editable text = getText();
        MetaTextSpan[] metaTextSpanArr = (MetaTextSpan[]) getText().getSpans(0, text.length(), MetaTextSpan.class);
        int length = text.length();
        int length2 = metaTextSpanArr.length;
        int i = 0;
        while (i < length2) {
            int spanStart = text.getSpanStart(metaTextSpanArr[i]);
            if (spanStart == -1 || spanStart >= length) {
                spanStart = length;
            }
            i++;
            length = spanStart;
        }
        return Math.max(0, length);
    }

    public CharSequence getUserText() {
        return getText().subSequence(0, getEndIndex());
    }

    public void setSelection(int i) {
        super.setSelection(Math.min(i, getEndIndex()));
    }

    public void setSelection(int i, int i2) {
        int endIndex = getEndIndex();
        super.setSelection(Math.min(Math.max(0, i), endIndex), Math.min(Math.max(0, i2), endIndex));
    }

    public void extendSelection(int i) {
        super.extendSelection(Math.min(i, getEndIndex()));
    }

    protected void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        int endIndex = getEndIndex();
        if (i2 < 0 || i2 >= endIndex || i < 0 || i >= endIndex) {
            setSelection(i, i2);
        }
    }

    private void m21054f() {
        if (isShown() && !isPopupShowing() && this.f17110e != null) {
            int selectionStart = getSelectionStart();
            Layout layout = getLayout();
            if (layout != null) {
                selectionStart = layout.getLineForOffset(selectionStart);
                selectionStart = layout.getLineAscent(selectionStart) + layout.getLineBaseline(selectionStart);
                int lineHeight = getLineHeight() + getPaddingTop();
                if (getLineCount() == 1 && getHeight() != lineHeight) {
                    selectionStart += (getHeight() - lineHeight) / 2;
                }
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, lineHeight);
                layoutParams.topMargin = selectionStart;
                this.f17110e.setLayoutParams(layoutParams);
            }
        }
    }

    protected void performFiltering(CharSequence charSequence, int i) {
        m21054f();
        super.performFiltering(charSequence, i);
    }

    public final void m21059a(TextWithEntitiesChangedListener textWithEntitiesChangedListener) {
        this.f17108c.add(textWithEntitiesChangedListener);
    }

    public final void m21060b(TextWithEntitiesChangedListener textWithEntitiesChangedListener) {
        this.f17108c.remove(textWithEntitiesChangedListener);
    }

    public boolean onTextContextMenuItem(int i) {
        this.f17107b = 16908322 == i;
        return super.onTextContextMenuItem(i);
    }

    public static GraphQLTextWithEntities getTextWithEntities(ComposerEditText composerEditText) {
        CharSequence userText = composerEditText.getUserText();
        return GraphQLHelper.a(userText.toString(), MentionsUtils.b(new SpannableStringBuilder(userText)), null, null);
    }
}
