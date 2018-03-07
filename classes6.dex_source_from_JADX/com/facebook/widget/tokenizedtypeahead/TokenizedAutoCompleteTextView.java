package com.facebook.widget.tokenizedtypeahead;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.ColorRes;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.QwertyKeyListener;
import android.text.method.TextKeyListener;
import android.text.method.TextKeyListener.Capitalize;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputMethodManager;
import com.facebook.R;
import com.facebook.accessibility.ViewAccessibilityHelper;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.util.MathUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbAutoCompleteTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.user.tiles.UserTileDrawableController;
import com.facebook.widget.filter.CustomFilter.FilterListener;
import com.facebook.widget.filter.CustomFilter.FilteringState;
import com.facebook.widget.filter.CustomFilterable;
import com.facebook.widget.text.TextViewUtils;
import com.facebook.widget.tokenizedtypeahead.BaseTokenSpan.Builder;
import com.facebook.widget.tokenizedtypeahead.TokenPickerEditableUtil.Range;
import com.facebook.widget.tokenizedtypeahead.chips.ContactChipSpan;
import com.facebook.widget.tokenizedtypeahead.chips.ContactChipSpanFactory;
import com.facebook.widget.tokenizedtypeahead.chips.ContactChipToken;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.Token;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.facebook.push.mqtt.ipc.MqttPublishListener */
public class TokenizedAutoCompleteTextView extends FbAutoCompleteTextView implements FilterListener {
    private static final Class<?> f20011b = TokenizedAutoCompleteTextView.class;
    public boolean f20012A;
    private boolean f20013B;
    private Lazy<ContactChipSpanFactory> f20014C;
    private GlyphColorizer f20015D;
    private Drawable f20016E;
    private Drawable[] f20017F;
    private boolean f20018G;
    private TokenSpan f20019H;
    private ViewAccessibilityHelper f20020I;
    private OnInputDoneListener f20021J;
    @Nullable
    private ColorStateList f20022K;
    private GatekeeperStoreImpl f20023L;
    private TokenSpan f20024M;
    private int f20025c;
    private final Rect f20026d = new Rect();
    private final Rect f20027e = new Rect();
    public DropdownMode f20028f = DropdownMode.NORMAL;
    public TextMode f20029g = TextMode.STYLIZED;
    private ClearButtonMode f20030h;
    private AccessoryButtonState f20031i = AccessoryButtonState.NONE;
    private int f20032j;
    @Nullable
    private InputTypeSwitchMode f20033k;
    private TokenPickerEditableUtil f20034l;
    private InputMethodManager f20035m;
    private List<Token> f20036n;
    public boolean f20037o;
    public int f20038p;
    private int f20039q;
    private int f20040r;
    private int f20041s;
    private Integer f20042t;
    private float f20043u;
    private int f20044v;
    private Drawable f20045w;
    private Drawable f20046x;
    public String f20047y;
    public boolean f20048z;

    /* compiled from: com.facebook.push.mqtt.ipc.MqttPublishListener */
    class C15031 implements Runnable {
        final /* synthetic */ TokenizedAutoCompleteTextView f20004a;

        C15031(TokenizedAutoCompleteTextView tokenizedAutoCompleteTextView) {
            this.f20004a = tokenizedAutoCompleteTextView;
        }

        public void run() {
            this.f20004a.requestLayout();
        }
    }

    /* compiled from: com.facebook.push.mqtt.ipc.MqttPublishListener */
    enum AccessoryButtonState {
        NONE,
        CLEAR,
        INPUT_TYPE_SWITCH
    }

    /* compiled from: com.facebook.push.mqtt.ipc.MqttPublishListener */
    public enum ClearButtonMode {
        NEVER,
        WHILE_EDITING,
        ALWAYS
    }

    /* compiled from: com.facebook.push.mqtt.ipc.MqttPublishListener */
    public enum DropdownMode {
        NORMAL,
        NO_DROPDOWN
    }

    /* compiled from: com.facebook.push.mqtt.ipc.MqttPublishListener */
    enum InputTypeSwitchMode {
        TEXT_NO_SUGGESTIONS(655361, 2130840965),
        DIALPAD(131075, 2130840964);
        
        final int drawableResourceId;
        final int inputTypeFlags;

        private InputTypeSwitchMode(int i, int i2) {
            this.inputTypeFlags = i;
            this.drawableResourceId = i2;
        }
    }

    /* compiled from: com.facebook.push.mqtt.ipc.MqttPublishListener */
    public interface OnInputDoneListener {
    }

    /* compiled from: com.facebook.push.mqtt.ipc.MqttPublishListener */
    public enum SelectedTokenHighlightColor {
        BLUE,
        RED
    }

    /* compiled from: com.facebook.push.mqtt.ipc.MqttPublishListener */
    public enum TextMode {
        CHIPS,
        STYLIZED,
        PLAIN_TEXT
    }

    /* compiled from: com.facebook.push.mqtt.ipc.MqttPublishListener */
    class TokenizedInputConnection extends InputConnectionWrapper {
        final /* synthetic */ TokenizedAutoCompleteTextView f20009a;

        public TokenizedInputConnection(TokenizedAutoCompleteTextView tokenizedAutoCompleteTextView, InputConnection inputConnection, boolean z) {
            this.f20009a = tokenizedAutoCompleteTextView;
            super(inputConnection, z);
        }

        public boolean sendKeyEvent(KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 67) {
                return TokenizedAutoCompleteTextView.m28719g(this.f20009a) && TokenizedAutoCompleteTextView.m28726n(this.f20009a) && super.sendKeyEvent(keyEvent);
            } else {
                TokenizedAutoCompleteTextView.m28727o(this.f20009a);
                return super.sendKeyEvent(keyEvent);
            }
        }

        public boolean performEditorAction(int i) {
            StringUtil.a(this.f20009a.getUserEnteredPlainText());
            return super.performEditorAction(i);
        }

        public boolean deleteSurroundingText(int i, int i2) {
            if (i != 1 || i2 != 0) {
                return super.deleteSurroundingText(i, i2);
            }
            if (TokenizedAutoCompleteTextView.m28726n(this.f20009a) && super.sendKeyEvent(new KeyEvent(0, 67)) && super.sendKeyEvent(new KeyEvent(1, 67))) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: com.facebook.push.mqtt.ipc.MqttPublishListener */
    class TokenizerKeyListener extends TextKeyListener {
        final /* synthetic */ TokenizedAutoCompleteTextView f20010a;

        public TokenizerKeyListener(TokenizedAutoCompleteTextView tokenizedAutoCompleteTextView, Capitalize capitalize, boolean z) {
            this.f20010a = tokenizedAutoCompleteTextView;
            super(capitalize, z);
        }

        public boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() == 67) {
                return TokenizedAutoCompleteTextView.m28719g(this.f20010a) && TokenizedAutoCompleteTextView.m28726n(this.f20010a) && super.onKeyDown(view, editable, i, keyEvent);
            } else {
                TokenizedAutoCompleteTextView.m28727o(this.f20010a);
                return super.onKeyDown(view, editable, i, keyEvent);
            }
        }
    }

    public TokenizedAutoCompleteTextView(Context context) {
        super(context);
        m28701a(context, null);
    }

    public TokenizedAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m28701a(context, attributeSet);
    }

    public TokenizedAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m28701a(context, attributeSet);
    }

    private void m28701a(Context context, AttributeSet attributeSet) {
        InjectorLike injectorLike = FbInjector.get(context);
        this.f20034l = TokenPickerEditableUtil.m28694a(injectorLike);
        this.f20035m = InputMethodManagerMethodAutoProvider.b(injectorLike);
        this.f20014C = IdBasedLazy.a(injectorLike, 11771);
        this.f20015D = GlyphColorizer.a(injectorLike);
        this.f20020I = ViewAccessibilityHelper.a(injectorLike);
        this.f20023L = GatekeeperStoreImplMethodAutoProvider.a(injectorLike);
        this.f20036n = new LinkedList();
        m28724l();
        TextViewUtils.c(this);
        setImeOptions(33554438);
        this.f20025c = 0;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TokenizedAutoCompleteTextView);
        this.f20029g = TextMode.values()[obtainStyledAttributes.getInt(0, TextMode.STYLIZED.ordinal())];
        this.f20038p = obtainStyledAttributes.getColor(1, getCurrentTextColor());
        this.f20039q = obtainStyledAttributes.getColor(2, this.f20038p);
        this.f20040r = obtainStyledAttributes.getColor(3, getResources().getColor(2131361864));
        this.f20041s = obtainStyledAttributes.getColor(4, this.f20040r);
        this.f20043u = obtainStyledAttributes.getDimension(5, getTextSize());
        this.f20045w = obtainStyledAttributes.getDrawable(6);
        this.f20046x = obtainStyledAttributes.getDrawable(7);
        this.f20032j = obtainStyledAttributes.getColor(9, 2131361856);
        this.f20016E = obtainStyledAttributes.getDrawable(8);
        setClearButtonMode(ClearButtonMode.values()[obtainStyledAttributes.getInt(10, ClearButtonMode.NEVER.ordinal())]);
        this.f20022K = getResources().getColorStateList(obtainStyledAttributes.getResourceId(11, 2131362255));
        obtainStyledAttributes.recycle();
        setSelectedTokenHighlightColor(SelectedTokenHighlightColor.BLUE);
        setKeyListener(new TokenizerKeyListener(this, Capitalize.NONE, false));
    }

    public Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("text_view_state_key", super.onSaveInstanceState());
        bundle.putString("text_mode_key", this.f20029g.name());
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        Parcelable parcelable2 = bundle.getParcelable("text_view_state_key");
        this.f20029g = TextMode.valueOf(bundle.getString("text_mode_key"));
        super.onRestoreInstanceState(parcelable2);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.f20016E != null) {
            this.f20016E.setAlpha(z ? 255 : 128);
        }
        for (TokenSpan tokenSpan : getPickedTokenSpans()) {
            boolean z2;
            Token token = tokenSpan.f19988f;
            if (z) {
                z2 = false;
            } else {
                z2 = true;
            }
            token.f15079e = z2;
        }
        m28738c();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 66) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 66) {
            return super.onKeyUp(i, keyEvent);
        }
        StringUtil.a(getUserEnteredPlainText());
        return true;
    }

    protected float getTopFadingEdgeStrength() {
        return MathUtil.b(((float) computeVerticalScrollOffset()) / ((float) getVerticalFadingEdgeLength()), 0.0f, 1.0f);
    }

    protected float getBottomFadingEdgeStrength() {
        return MathUtil.b(((float) ((computeVerticalScrollRange() - computeVerticalScrollExtent()) - computeVerticalScrollOffset())) / ((float) getVerticalFadingEdgeLength()), 0.0f, 1.0f);
    }

    protected void performFiltering(CharSequence charSequence, int i) {
        ((CustomFilterable) getAdapter()).mo438a().mo390a(this.f20034l.m28697b(getText()), this);
    }

    public boolean enoughToFilter() {
        if (this.f20028f != DropdownMode.NO_DROPDOWN && getUserEnteredPlainText().length() >= getThreshold()) {
            return true;
        }
        return false;
    }

    protected void replaceText(CharSequence charSequence) {
        clearComposingText();
    }

    public final void mo1517a(int i) {
        super.onFilterComplete(i);
    }

    public final void mo1518a(FilteringState filteringState) {
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 882627361);
        super.onSizeChanged(i, i2, i3, i4);
        CharSequence userEnteredPlainText = getUserEnteredPlainText();
        m28738c();
        Object obj = null;
        if (!this.f20036n.isEmpty()) {
            List<Token> linkedList = new LinkedList(this.f20036n);
            this.f20036n.clear();
            for (Token a2 : linkedList) {
                m28732a(a2);
                m28739d();
            }
            obj = 1;
        }
        m28734a(userEnteredPlainText);
        if (obj != null) {
            post(new C15031(this));
        }
        LogUtils.g(-1254031173, a);
    }

    public CharSequence getUserEnteredPlainText() {
        return this.f20034l.m28697b(getText());
    }

    public final void m28729a() {
        if (!getUserEnteredPlainText().equals("")) {
            m28734a((CharSequence) "");
        }
    }

    public final void m28734a(CharSequence charSequence) {
        CharSequence editableText = getEditableText();
        Range a = TokenPickerEditableUtil.m28693a(editableText);
        if (this.f20028f == DropdownMode.NO_DROPDOWN) {
            clearComposingText();
        }
        if (a != null) {
            QwertyKeyListener.markAsReplaced(editableText, a.f20002a, a.f20003b, "");
            editableText.replace(a.f20002a, a.f20003b, charSequence);
        }
        Selection.setSelection(editableText, editableText.length());
    }

    private void m28702a(Token token, int i) {
        this.f20025c = i;
        if (getMeasuredWidth() == 0) {
            this.f20036n.add(token);
            return;
        }
        m28721i();
        m28734a(m28710b(token, false));
    }

    public final void m28732a(Token token) {
        m28702a(token, 0);
    }

    public final void m28733a(Token token, boolean z) {
        int i = 0;
        Editable editableText = getEditableText();
        TokenSpan[] tokenSpanArr = (TokenSpan[]) editableText.getSpans(0, editableText.length(), TokenSpan.class);
        int length = tokenSpanArr.length;
        while (i < length) {
            TokenSpan tokenSpan = tokenSpanArr[i];
            if (tokenSpan.f19988f.equals(token)) {
                int spanStart = editableText.getSpanStart(tokenSpan);
                int spanEnd = editableText.getSpanEnd(tokenSpan);
                editableText.removeSpan(tokenSpan);
                tokenSpan.mo1520a();
                editableText.replace(spanStart, spanEnd, "");
            }
            i++;
        }
        if (z) {
            m28734a((CharSequence) "");
        }
    }

    public final void m28737b() {
        int i = 0;
        this.f20036n.clear();
        Editable editableText = getEditableText();
        TokenSpan[] tokenSpanArr = (TokenSpan[]) editableText.getSpans(0, editableText.length(), TokenSpan.class);
        int length = tokenSpanArr.length;
        while (i < length) {
            TokenSpan tokenSpan = tokenSpanArr[i];
            editableText.removeSpan(tokenSpan);
            tokenSpan.mo1520a();
            i++;
        }
        editableText.clear();
    }

    private int getDrawablesWidth() {
        int i = 0;
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables[0] != null) {
            i = ((compoundDrawables[0].getBounds().right - compoundDrawables[0].getBounds().left) + getCompoundDrawablePadding()) + 0;
        }
        if (compoundDrawables[2] != null) {
            return i + ((compoundDrawables[2].getBounds().right - compoundDrawables[2].getBounds().left) + getCompoundDrawablePadding());
        }
        return i;
    }

    private CharSequence m28710b(Token token, boolean z) {
        int color;
        TextPaint textPaint;
        int drawablesWidth;
        Object a;
        Builder builder;
        CharSequence spannableString;
        Object obj = token.mo1185b() + " ";
        TextPaint textPaint2 = new TextPaint(getPaint());
        Drawable c = m28713c(token);
        if (!token.mo1195a() && this.f20029g != TextMode.CHIPS) {
            color = getResources().getColor(2131361938);
            textPaint = textPaint2;
        } else if (token.f15077c) {
            textPaint2.setColor(this.f20029g == TextMode.CHIPS ? this.f20041s : this.f20040r);
            textPaint2.setTextSize(this.f20043u);
            drawablesWidth = getDrawablesWidth();
            if (this.f20029g != TextMode.CHIPS) {
                ContactChipSpanFactory contactChipSpanFactory = (ContactChipSpanFactory) this.f20014C.get();
                ContactChipSpan.Builder builder2 = new ContactChipSpan.Builder((UserTileDrawableController) contactChipSpanFactory.f20108a.get(), contactChipSpanFactory.f20109b);
                builder2.f20081c = (ContactChipToken) token;
                builder2 = builder2;
                builder2.f20084f = (getMeasuredWidth() - this.f20025c) - drawablesWidth;
                builder2 = builder2;
                builder2.f20082d = textPaint2;
                builder2 = builder2;
                builder2.f20086h = this.f20022K;
                builder2 = builder2;
                builder2.f20083e = getResources();
                a = builder2.m28749a(getContext());
            } else if (this.f20029g == TextMode.PLAIN_TEXT || token.f15077c) {
                builder = new Builder();
                builder.f19975a = (BaseToken) token;
                builder = builder.m28681a((getMeasuredWidth() - this.f20025c) - drawablesWidth);
                builder.f19976b = textPaint2;
                builder = builder;
                builder.f19977c = getResources();
                builder = builder;
                builder.f19979e = c;
                a = builder.m28683a(getContext());
            } else {
                builder = new Builder();
                builder.f19975a = (BaseToken) token;
                builder = builder.m28681a((getMeasuredWidth() - this.f20025c) - drawablesWidth);
                builder.f19976b = textPaint2;
                builder = builder;
                builder.f19977c = getResources();
                builder = builder;
                builder.f19979e = c;
                builder = builder.m28684b(0).m28682a(z);
                builder.f19982h = this.f20042t;
                a = builder.m28683a(getContext());
            }
            spannableString = new SpannableString(obj);
            spannableString.setSpan(a, 0, obj.length(), 33);
            return spannableString;
        } else if (this.f20029g == TextMode.CHIPS) {
            color = this.f20039q;
            textPaint = textPaint2;
        } else {
            color = this.f20038p;
            textPaint = textPaint2;
        }
        textPaint.setColor(color);
        textPaint2.setTextSize(this.f20043u);
        drawablesWidth = getDrawablesWidth();
        if (this.f20029g != TextMode.CHIPS) {
            if (this.f20029g == TextMode.PLAIN_TEXT) {
            }
            builder = new Builder();
            builder.f19975a = (BaseToken) token;
            builder = builder.m28681a((getMeasuredWidth() - this.f20025c) - drawablesWidth);
            builder.f19976b = textPaint2;
            builder = builder;
            builder.f19977c = getResources();
            builder = builder;
            builder.f19979e = c;
            a = builder.m28683a(getContext());
        } else {
            ContactChipSpanFactory contactChipSpanFactory2 = (ContactChipSpanFactory) this.f20014C.get();
            ContactChipSpan.Builder builder22 = new ContactChipSpan.Builder((UserTileDrawableController) contactChipSpanFactory2.f20108a.get(), contactChipSpanFactory2.f20109b);
            builder22.f20081c = (ContactChipToken) token;
            builder22 = builder22;
            builder22.f20084f = (getMeasuredWidth() - this.f20025c) - drawablesWidth;
            builder22 = builder22;
            builder22.f20082d = textPaint2;
            builder22 = builder22;
            builder22.f20086h = this.f20022K;
            builder22 = builder22;
            builder22.f20083e = getResources();
            a = builder22.m28749a(getContext());
        }
        spannableString = new SpannableString(obj);
        spannableString.setSpan(a, 0, obj.length(), 33);
        return spannableString;
    }

    private Drawable m28713c(Token token) {
        Drawable drawable = this.f20045w;
        if (this.f20029g == TextMode.STYLIZED && ((BaseToken) token).m22652n() != -1) {
            return getResources().getDrawable(((BaseToken) token).m22652n());
        }
        if (this.f20029g == TextMode.PLAIN_TEXT && token.f15077c) {
            return getResources().getDrawable(this.f20044v);
        }
        if (this.f20029g == TextMode.PLAIN_TEXT) {
            return getResources().getDrawable(2130843693);
        }
        return (!token.f15077c || this.f20046x == null) ? drawable : this.f20046x;
    }

    public final void m28738c() {
        m28703a(false);
    }

    public final void m28739d() {
        if (this.f20029g == TextMode.PLAIN_TEXT) {
            Editable editableText = getEditableText();
            if (((TokenSpan[]) editableText.getSpans(0, editableText.length(), TokenSpan.class)).length < 2) {
                m28703a(false);
            } else {
                m28703a(true);
            }
        }
    }

    public final void m28740e() {
        for (TokenSpan tokenSpan : getPickedTokenSpans()) {
            tokenSpan.f19988f.f15077c = false;
        }
        m28738c();
    }

    private void m28703a(boolean z) {
        Spannable editableText = getEditableText();
        TokenSpan[] tokenSpanArr = (TokenSpan[]) editableText.getSpans(0, editableText.length(), TokenSpan.class);
        int selectionStart = Selection.getSelectionStart(editableText);
        int selectionEnd = Selection.getSelectionEnd(editableText);
        r1 = z ? tokenSpanArr.length - 2 : 0;
        while (r1 < tokenSpanArr.length) {
            boolean z2;
            int spanStart = editableText.getSpanStart(tokenSpanArr[r1]);
            int spanEnd = editableText.getSpanEnd(tokenSpanArr[r1]);
            Token token = tokenSpanArr[r1].f19988f;
            if (this.f20029g != TextMode.PLAIN_TEXT || spanEnd >= editableText.length()) {
                z2 = false;
            } else {
                z2 = true;
            }
            CharSequence b = m28710b(token, z2);
            if (spanStart == -1 || spanEnd == -1) {
                throw new IllegalStateException("Token not found in editable");
            }
            editableText.removeSpan(tokenSpanArr[r1]);
            editableText.replace(spanStart, spanEnd, b);
            r1++;
        }
        if (selectionStart != -1 && selectionEnd != -1 && selectionEnd <= editableText.length()) {
            Selection.setSelection(editableText, selectionStart, selectionEnd);
        }
    }

    public void onCommitCompletion(CompletionInfo completionInfo) {
        this.f20037o = true;
        super.onCommitCompletion(completionInfo);
        this.f20037o = false;
    }

    public boolean getIsImmSuggestionClicked() {
        return this.f20037o;
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && this.f20048z && i == 4 && this.f20035m.hideSoftInputFromWindow(getWindowToken(), 0)) {
            return true;
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    public <T extends TokenSpan> T[] getPickedTokenSpans() {
        Editable editableText = getEditableText();
        if (this.f20029g == TextMode.CHIPS) {
            return (TokenSpan[]) editableText.getSpans(0, editableText.length(), ContactChipSpan.class);
        }
        return (TokenSpan[]) editableText.getSpans(0, editableText.length(), BaseTokenSpan.class);
    }

    public ImmutableList<Token> getPickedTokens() {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (TokenSpan tokenSpan : getPickedTokenSpans()) {
            builder.c(tokenSpan.f19988f);
        }
        for (Token c : this.f20036n) {
            builder.c(c);
        }
        return builder.b();
    }

    public void setDropdownMode(DropdownMode dropdownMode) {
        this.f20028f = dropdownMode;
    }

    public void setTextMode(TextMode textMode) {
        this.f20029g = textMode;
        m28738c();
    }

    public TextMode getTextMode() {
        return this.f20029g;
    }

    public void setTokenTextColor(int i) {
        this.f20038p = i;
    }

    public void setSelectedTokenTextColor(int i) {
        this.f20040r = i;
    }

    public void setTokenIconColor(int i) {
        this.f20042t = Integer.valueOf(i);
    }

    public void setChipBackgroundColor(@ColorRes int i) {
        this.f20022K = getResources().getColorStateList(i);
        m28738c();
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        this.f20022K = colorStateList;
        m28738c();
    }

    public final void m28735a(String str) {
        this.f20047y = str;
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (this.f20047y != null) {
            accessibilityEvent.getText().add(this.f20047y);
        } else {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    private int m28718f() {
        int i = 0;
        Editable editableText = getEditableText();
        if (editableText.length() != 0) {
            int length = editableText.length();
            i = length;
            for (TokenSpan tokenSpan : (TokenSpan[]) editableText.getSpans(0, editableText.length(), TokenSpan.class)) {
                if (!tokenSpan.f19988f.mo1195a() && editableText.getSpanStart(tokenSpan) < r1) {
                    i = editableText.getSpanStart(tokenSpan);
                }
            }
        }
        return i;
    }

    public static boolean m28719g(TokenizedAutoCompleteTextView tokenizedAutoCompleteTextView) {
        int selectionStart = tokenizedAutoCompleteTextView.getSelectionStart();
        Editable editableText = tokenizedAutoCompleteTextView.getEditableText();
        if (selectionStart == 0) {
            return true;
        }
        int f;
        if (selectionStart == tokenizedAutoCompleteTextView.getSelectionEnd()) {
            f = tokenizedAutoCompleteTextView.m28718f();
            if (selectionStart > f) {
                tokenizedAutoCompleteTextView.setSelection(f);
                return false;
            }
        }
        TokenSpan[] tokenSpanArr = (TokenSpan[]) editableText.getSpans(selectionStart, tokenizedAutoCompleteTextView.getSelectionEnd(), TokenSpan.class);
        int length = tokenSpanArr.length;
        f = 0;
        while (f < length) {
            if (tokenSpanArr[f].f19988f.mo1195a()) {
                f++;
            } else {
                tokenizedAutoCompleteTextView.setSelection(tokenizedAutoCompleteTextView.m28718f());
                return false;
            }
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1340482683);
        if (m28715c(motionEvent)) {
            Logger.a(2, EntryType.UI_INPUT_END, 431092895, a);
            return true;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (m28704a(motionEvent)) {
            m28738c();
        }
        LogUtils.a(1614194953, a);
        return onTouchEvent;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f20019H != null) {
            this.f20019H.f19988f.f15078d = false;
            this.f20019H = null;
            m28738c();
        }
    }

    private boolean m28704a(MotionEvent motionEvent) {
        boolean z = true;
        if (!isEnabled()) {
            return false;
        }
        boolean z2;
        switch (motionEvent.getAction()) {
            case 0:
                TokenSpan b = m28709b(motionEvent);
                if (b != null) {
                    Token token = b.f19988f;
                    this.f20019H = b;
                    token.f15078d = token.mo1195a();
                } else {
                    z = false;
                }
                return z;
            case 1:
                z2 = false;
                break;
            case 2:
                if (this.f20019H != null && !m28707a(this.f20019H, motionEvent)) {
                    this.f20019H.f19988f.f15078d = false;
                    break;
                }
                return false;
            case 3:
                z2 = true;
                break;
            default:
                return false;
        }
        m28727o(this);
        Editable editableText = getEditableText();
        for (TokenSpan tokenSpan : getPickedTokenSpans()) {
            Token token2 = tokenSpan.f19988f;
            token2.f15078d = false;
            if (z2 || this.f20019H == null || !token2.equals(this.f20019H.f19988f)) {
                token2.f15077c = false;
            } else {
                boolean a = m28706a(tokenSpan, motionEvent.getX(), motionEvent.getY());
                token2.mo1522a(a);
                int spanEnd = editableText.getSpanEnd(tokenSpan);
                if (!(spanEnd == -1 || a)) {
                    boolean z3;
                    if (token2.f15077c || !token2.mo1195a()) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    token2.f15077c = z3;
                    if (token2.f15077c) {
                        setSelection(spanEnd);
                    }
                }
            }
        }
        this.f20019H = null;
        return true;
    }

    private boolean m28706a(TokenSpan tokenSpan, float f, float f2) {
        if (!tokenSpan.f19988f.f15075a) {
            return false;
        }
        Point b = m28736b(tokenSpan.f19988f);
        tokenSpan.mo1521b(this.f20027e);
        if (this.f20027e.contains((int) (f - ((float) b.x)), (int) (f2 - ((float) b.y)))) {
            return true;
        }
        return false;
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = 1;
        super.onTextChanged(charSequence, i, i2, i3);
        if (this.f20030h == ClearButtonMode.WHILE_EDITING) {
            int i5 = i2 > 0 ? 1 : 0;
            if (i3 <= 0) {
                i4 = 0;
            }
            if ((i4 ^ i5) != 0) {
                m28728p();
            }
        }
        if (i2 != i3) {
            m28727o(this);
        }
    }

    @Nullable
    private TokenSpan m28720h() {
        int selectionStart = getSelectionStart();
        Editable editableText = getEditableText();
        for (TokenSpan tokenSpan : getPickedTokenSpans()) {
            if (selectionStart == editableText.getSpanEnd(tokenSpan)) {
                return tokenSpan;
            }
        }
        return null;
    }

    @Nullable
    private TokenSpan m28709b(MotionEvent motionEvent) {
        for (TokenSpan tokenSpan : getPickedTokenSpans()) {
            if (m28707a(tokenSpan, motionEvent)) {
                return tokenSpan;
            }
        }
        return null;
    }

    private boolean m28707a(TokenSpan tokenSpan, MotionEvent motionEvent) {
        tokenSpan.m28687a(this.f20026d);
        return this.f20026d.contains(((int) motionEvent.getX()) + getScrollX(), ((int) motionEvent.getY()) + getScrollY());
    }

    @Nullable
    public final Point m28736b(Token token) {
        for (TokenSpan tokenSpan : getPickedTokenSpans()) {
            if (tokenSpan.f19988f.equals(token)) {
                break;
            }
        }
        TokenSpan tokenSpan2 = null;
        if (tokenSpan2 == null) {
            return null;
        }
        Rect rect = new Rect();
        tokenSpan2.m28687a(rect);
        return new Point(rect.left - getScrollX(), rect.top - getScrollY());
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        return onCreateInputConnection == null ? null : new TokenizedInputConnection(this, onCreateInputConnection, true);
    }

    public void setHideSoftKeyboardOnBackButton(boolean z) {
        this.f20048z = z;
    }

    public void setInputDoneOnEnterKeyUse(boolean z) {
        this.f20012A = z;
    }

    public void setOnInputDoneListener(OnInputDoneListener onInputDoneListener) {
        this.f20021J = onInputDoneListener;
    }

    public void setShowInputTypeSwitchButton(boolean z) {
        if (this.f20013B != z) {
            this.f20013B = z;
            m28721i();
        }
    }

    private void m28721i() {
        if (!this.f20013B && this.f20033k != null) {
            this.f20033k = null;
        } else if (this.f20013B && this.f20033k != InputTypeSwitchMode.DIALPAD) {
            this.f20033k = InputTypeSwitchMode.DIALPAD;
        } else {
            return;
        }
        m28723k();
    }

    private void m28722j() {
        if (this.f20013B && this.f20033k != null) {
            InputTypeSwitchMode[] values = InputTypeSwitchMode.values();
            this.f20033k = values[(this.f20033k.ordinal() + 1) % values.length];
            m28723k();
        }
    }

    private void m28723k() {
        int i;
        if (this.f20033k == null) {
            i = InputTypeSwitchMode.TEXT_NO_SUGGESTIONS.inputTypeFlags;
        } else {
            InputTypeSwitchMode[] values = InputTypeSwitchMode.values();
            i = values[((this.f20033k.ordinal() + values.length) - 1) % values.length].inputTypeFlags;
        }
        int m = m28725m();
        setInputType(i);
        m28724l();
        m28711b(m);
        m28728p();
    }

    private void m28724l() {
        setSingleLine(true);
        setMaxLines(4);
        setHorizontallyScrolling(false);
    }

    @TargetApi(16)
    private int m28725m() {
        if (VERSION.SDK_INT < 16 || getMinHeight() <= 0) {
            return -1;
        }
        return getMinHeight();
    }

    private void m28711b(int i) {
        if (i > 0) {
            setMinHeight(i);
        }
    }

    public static boolean m28726n(TokenizedAutoCompleteTextView tokenizedAutoCompleteTextView) {
        if (tokenizedAutoCompleteTextView.f20029g != TextMode.CHIPS || !tokenizedAutoCompleteTextView.f20023L.a(164, false)) {
            return true;
        }
        if (tokenizedAutoCompleteTextView.f20024M != null) {
            m28727o(tokenizedAutoCompleteTextView);
            return true;
        }
        TokenSpan h = tokenizedAutoCompleteTextView.m28720h();
        if (h == null || !tokenizedAutoCompleteTextView.m28705a(h)) {
            return true;
        }
        return false;
    }

    private boolean m28705a(TokenSpan tokenSpan) {
        if (!this.f20023L.a(164, false) || !(tokenSpan instanceof ContactChipSpan) || tokenSpan == this.f20024M) {
            return false;
        }
        if (this.f20024M != null) {
            m28727o(this);
        }
        Token token = tokenSpan.f19988f;
        if (!token.mo1195a()) {
            return false;
        }
        this.f20024M = tokenSpan;
        setCursorVisible(false);
        token.f15077c = true;
        m28738c();
        return true;
    }

    public static void m28727o(TokenizedAutoCompleteTextView tokenizedAutoCompleteTextView) {
        if (tokenizedAutoCompleteTextView.f20024M != null && tokenizedAutoCompleteTextView.f20023L.a(164, false)) {
            TokenSpan tokenSpan = tokenizedAutoCompleteTextView.f20024M;
            tokenizedAutoCompleteTextView.f20024M = null;
            tokenizedAutoCompleteTextView.setCursorVisible(true);
            tokenSpan.f19988f.f15077c = false;
            tokenizedAutoCompleteTextView.m28738c();
        }
    }

    public void setSelectedTokenHighlightColor(SelectedTokenHighlightColor selectedTokenHighlightColor) {
        switch (selectedTokenHighlightColor) {
            case BLUE:
                this.f20044v = 2130843691;
                return;
            case RED:
                this.f20044v = 2130843692;
                return;
            default:
                return;
        }
    }

    public void setSelectedTokenBackgroundDrawable(int i) {
        this.f20046x = getResources().getDrawable(i);
    }

    public void setClearButtonMode(ClearButtonMode clearButtonMode) {
        Preconditions.checkNotNull(clearButtonMode);
        if (this.f20030h != clearButtonMode) {
            this.f20030h = clearButtonMode;
            m28728p();
        }
    }

    public void setClearButtonDrawable(Drawable drawable) {
        this.f20016E = drawable;
        m28728p();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m28728p() {
        /*
        r5 = this;
        r4 = 0;
        r2 = r5.getCompoundDrawables();
        r0 = 0;
        r1 = com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView.AccessoryButtonState.NONE;
        r5.f20031i = r1;
        r1 = com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView.C15053.f20007b;
        r3 = r5.f20030h;
        r3 = r3.ordinal();
        r1 = r1[r3];
        switch(r1) {
            case 1: goto L_0x003b;
            case 2: goto L_0x0045;
            default: goto L_0x0017;
        };
    L_0x0017:
        r1 = r5.f20031i;
        r3 = com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView.AccessoryButtonState.NONE;
        if (r1 != r3) goto L_0x0035;
    L_0x001d:
        r1 = r5.f20013B;
        if (r1 == 0) goto L_0x0035;
    L_0x0021:
        r1 = r5.f20033k;
        if (r1 == 0) goto L_0x0035;
    L_0x0025:
        r0 = r5.getInputTypeSwitchButtonDrawables();
        r1 = r5.f20033k;
        r1 = r1.ordinal();
        r0 = r0[r1];
        r1 = com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView.AccessoryButtonState.INPUT_TYPE_SWITCH;
        r5.f20031i = r1;
    L_0x0035:
        r1 = 2;
        r1 = r2[r1];
        if (r0 != r1) goto L_0x004e;
    L_0x003a:
        return;
    L_0x003b:
        r1 = r5.getText();
        r1 = com.facebook.common.util.StringUtil.a(r1);
        if (r1 != 0) goto L_0x0017;
    L_0x0045:
        r0 = r5.getClearButtonDrawable();
        r1 = com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView.AccessoryButtonState.CLEAR;
        r5.f20031i = r1;
        goto L_0x0017;
    L_0x004e:
        if (r0 == 0) goto L_0x0061;
    L_0x0050:
        r1 = new com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView$2;
        r1.<init>(r5, r0);
        r0 = r1.getIntrinsicWidth();
        r3 = r1.getIntrinsicHeight();
        r1.setBounds(r4, r4, r0, r3);
        r0 = r1;
    L_0x0061:
        r1 = r2[r4];
        r3 = 1;
        r3 = r2[r3];
        r4 = 3;
        r2 = r2[r4];
        r5.setCompoundDrawables(r1, r3, r0, r2);
        goto L_0x003a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView.p():void");
    }

    private boolean m28715c(MotionEvent motionEvent) {
        if (!isEnabled() || this.f20031i == AccessoryButtonState.NONE) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0 && m28717d(motionEvent)) {
            this.f20020I.a(this, getResources().getString(2131230930));
            this.f20018G = true;
        } else if (action == 2 && !m28717d(motionEvent)) {
            this.f20018G = false;
        }
        if (!this.f20018G) {
            return false;
        }
        if (action == 1) {
            switch (this.f20031i) {
                case CLEAR:
                    setText(null);
                    break;
                case INPUT_TYPE_SWITCH:
                    m28722j();
                    break;
            }
        }
        if (action == 1 || action == 3) {
            this.f20018G = false;
        }
        return true;
    }

    private boolean m28717d(MotionEvent motionEvent) {
        Drawable drawable = getCompoundDrawables()[2];
        return drawable != null && motionEvent.getX() > ((float) ((getWidth() - getPaddingRight()) - drawable.getIntrinsicWidth())) && motionEvent.getY() < ((float) Math.max(getAccessoryButtonHeight(this), drawable.getIntrinsicHeight()));
    }

    @TargetApi(16)
    public static int getAccessoryButtonHeight(TokenizedAutoCompleteTextView tokenizedAutoCompleteTextView) {
        if (VERSION.SDK_INT >= 16 && tokenizedAutoCompleteTextView.getMinHeight() > 0) {
            return tokenizedAutoCompleteTextView.getMinHeight();
        }
        Drawable drawable = tokenizedAutoCompleteTextView.getCompoundDrawables()[2];
        return drawable == null ? 0 : drawable.getIntrinsicHeight();
    }

    private Drawable getClearButtonDrawable() {
        if (this.f20016E == null) {
            this.f20016E = getResources().getDrawable(2130843689);
            this.f20016E = this.f20015D.a(this.f20016E, this.f20032j);
            this.f20016E.setBounds(0, 0, this.f20016E.getIntrinsicWidth(), this.f20016E.getIntrinsicHeight());
        }
        return this.f20016E;
    }

    private Drawable[] getInputTypeSwitchButtonDrawables() {
        if (this.f20017F == null) {
            InputTypeSwitchMode[] values = InputTypeSwitchMode.values();
            this.f20017F = new Drawable[values.length];
            for (int i = 0; i < values.length; i++) {
                Drawable a = this.f20015D.a(getResources().getDrawable(values[i].drawableResourceId), this.f20032j);
                a.setBounds(0, 0, a.getIntrinsicWidth(), a.getIntrinsicHeight());
                this.f20017F[i] = a;
            }
        }
        return this.f20017F;
    }
}
