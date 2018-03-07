package com.facebook.widget.text;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbEditText;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;
import javax.annotation.Nullable;

/* compiled from: reqs_failed */
public class BetterEditTextView extends FbEditText {
    private OnScrollListener f7452b;
    @Nullable
    public TextInteractionListener f7453c;
    @Nullable
    public OnSelectionChangedListener f7454d;
    private Drawable f7455e;
    private boolean f7456f = false;
    public boolean f7457g = false;
    private boolean f7458h = false;
    private boolean f7459i;
    private OnDeleteKeyListener f7460j;
    private SetTextAwareTextWatcher f7461k;
    private boolean f7462l;

    public BetterEditTextView(Context context) {
        super(context);
    }

    public BetterEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12061a(context, attributeSet);
    }

    public BetterEditTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12061a(context, attributeSet);
    }

    private void m12061a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BetterEditTextView);
        CustomFontHelper.m11814a((TextView) this, FontFamily.fromIndex(obtainStyledAttributes.getInt(0, 0)), FontWeight.fromIndex(obtainStyledAttributes.getInt(1, 6)), getTypeface());
        this.f7456f = obtainStyledAttributes.getBoolean(3, false);
        this.f7455e = obtainStyledAttributes.getDrawable(2);
        if (this.f7455e != null) {
            mo1662b();
        }
        this.f7458h = obtainStyledAttributes.getBoolean(4, false);
        this.f7459i = obtainStyledAttributes.getBoolean(5, false);
        obtainStyledAttributes.recycle();
    }

    public Parcelable onSaveInstanceState() {
        this.f7462l = true;
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        this.f7462l = false;
        return onSaveInstanceState;
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.f7452b = onScrollListener;
    }

    public void setTextInteractionListener(@Nullable TextInteractionListener textInteractionListener) {
        if (textInteractionListener == null) {
            mo1663c();
        } else {
            mo1662b();
        }
        this.f7453c = textInteractionListener;
    }

    public void setOnSelectionChangedListener(@Nullable OnSelectionChangedListener onSelectionChangedListener) {
        this.f7454d = onSelectionChangedListener;
    }

    private void mo1662b() {
        if (this.f7461k == null) {
            this.f7461k = new SetTextAwareTextWatcher(this);
            addTextChangedListener(this.f7461k);
            this.f7457g = false;
        }
    }

    private void mo1663c() {
        if (this.f7461k != null) {
            removeTextChangedListener(this.f7461k);
            this.f7461k = null;
        }
    }

    public void setOnDeleteKeyListener(OnDeleteKeyListener onDeleteKeyListener) {
        this.f7460j = onDeleteKeyListener;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -454387802);
        if (motionEvent.getAction() == 1 && m12065a(motionEvent)) {
            mo1661a();
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        Logger.a(2, EntryType.UI_INPUT_END, -854505688, a);
        return onTouchEvent;
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        this.f7457g = true;
        super.setText(charSequence, bufferType);
    }

    public void mo1661a() {
        setTextWithDispatchToTextInteractionListener("");
    }

    private void setTextWithDispatchToTextInteractionListener(CharSequence charSequence) {
        super.setText(charSequence, BufferType.EDITABLE);
    }

    private boolean m12072d() {
        return this.f7455e != null && this.f7455e == getCompoundDrawables()[2];
    }

    private boolean m12065a(MotionEvent motionEvent) {
        return m12072d() && motionEvent.getX() > ((float) (getWidth() - getCompoundPaddingRight()));
    }

    private void m12063a(CharSequence charSequence) {
        if (this.f7455e != null) {
            if (charSequence.length() <= 0 || (!isFocused() && this.f7456f)) {
                m12074f();
            } else {
                m12073e();
            }
        }
    }

    private void m12073e() {
        setRightDrawable(this.f7455e);
    }

    private void m12074f() {
        setRightDrawable(null);
    }

    private void setRightDrawable(Drawable drawable) {
        Drawable[] compoundDrawables = getCompoundDrawables();
        setCompoundDrawablesWithIntrinsicBounds(compoundDrawables[0], compoundDrawables[1], drawable, compoundDrawables[3]);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection betterInputConnection;
        boolean z = (getImeOptions() & 1073741824) == 1073741824;
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null) {
            betterInputConnection = new BetterInputConnection(this, onCreateInputConnection, true);
        } else {
            betterInputConnection = null;
        }
        if (this.f7458h && !z && m12064a(editorInfo.inputType)) {
            editorInfo.imeOptions &= -1073741825;
        }
        return betterInputConnection;
    }

    private static boolean m12064a(int i) {
        return (131087 & i) == 131073;
    }

    public boolean onTextContextMenuItem(int i) {
        if (!m12070b(i)) {
            return super.onTextContextMenuItem(i);
        }
        ClipData g = m12075g();
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i);
        m12060a(g);
        return onTextContextMenuItem;
    }

    private boolean m12070b(int i) {
        return !this.f7459i && i == 16908322 && VERSION.SDK_INT >= 11;
    }

    @TargetApi(11)
    private ClipData m12075g() {
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        if (!clipboardManager.hasPrimaryClip()) {
            return null;
        }
        ClipData primaryClip = clipboardManager.getPrimaryClip();
        clipboardManager.setPrimaryClip(ClipData.newPlainText(null, primaryClip.getItemAt(0).coerceToText(getContext())));
        return primaryClip;
    }

    @TargetApi(11)
    private void m12060a(ClipData clipData) {
        if (clipData != null) {
            ((ClipboardManager) getContext().getSystemService("clipboard")).setPrimaryClip(clipData);
        }
    }

    protected void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        if (!(this.f7462l || this.f7454d == null)) {
            this.f7454d.a();
        }
        int length = getText().length();
        if (i == i2 && i2 < length) {
            length = m12059a(getText(), i2);
            if (length != i) {
                Selection.setSelection(getEditableText(), length);
            }
        }
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1948212433);
        m12063a(getText());
        super.onFocusChanged(z, i, rect);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1935637503, a);
    }

    private static int m12059a(CharSequence charSequence, int i) {
        if (i == 0) {
            return 0;
        }
        int codePointAt = Character.codePointAt(charSequence, 0);
        int i2 = 0;
        while (i2 < i) {
            int charCount = Character.charCount(codePointAt);
            if (i2 + charCount < i) {
                codePointAt = Character.codePointAt(charSequence, i2 + charCount);
            }
            i2 += charCount;
        }
        return i2;
    }
}
