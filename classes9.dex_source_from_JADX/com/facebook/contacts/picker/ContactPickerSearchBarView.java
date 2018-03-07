package com.facebook.contacts.picker;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import com.facebook.contacts.picker.DivebarSearchableContactPickerView.C06642;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: pre_key_id */
public abstract class ContactPickerSearchBarView extends CustomLinearLayout implements FaveditSearchBar {
    public C06642 f6370a;
    public View f6371b = a(2131564219);
    public EditText f6372c = ((EditText) a(2131564835));
    public ImageView f6373d = ((ImageView) a(2131564833));
    public InputMethodManager f6374e = ((InputMethodManager) getContext().getSystemService("input_method"));

    /* compiled from: pre_key_id */
    public class C06561 implements OnFocusChangeListener {
        final /* synthetic */ ContactPickerSearchBarView f6368a;

        public C06561(ContactPickerSearchBarView contactPickerSearchBarView) {
            this.f6368a = contactPickerSearchBarView;
        }

        public void onFocusChange(View view, boolean z) {
            if (this.f6368a.f6370a != null) {
                this.f6368a.f6370a.f6459a.mo262a(view, z);
            }
        }
    }

    /* compiled from: pre_key_id */
    public class C06572 implements TextWatcher {
        final /* synthetic */ ContactPickerSearchBarView f6369a;

        public C06572(ContactPickerSearchBarView contactPickerSearchBarView) {
            this.f6369a = contactPickerSearchBarView;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (this.f6369a.f6370a != null) {
                this.f6369a.f6370a.f6459a.m6829c();
            }
        }
    }

    public abstract void mo259b();

    public ContactPickerSearchBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo259b();
        this.f6372c.setOnFocusChangeListener(new C06561(this));
        this.f6372c.addTextChangedListener(new C06572(this));
    }

    public void setSearchText(String str) {
        this.f6372c.setText(str);
    }

    public void mo260a(OnClickListener onClickListener) {
    }

    public final void mo252c() {
        if (this.f6372c.isFocused()) {
            this.f6371b.requestFocus();
        }
        mo253d();
    }

    public final void mo253d() {
        this.f6374e.hideSoftInputFromWindow(this.f6372c.getWindowToken(), 0);
    }

    public String getSearchText() {
        return this.f6372c.getText().toString();
    }

    public final boolean mo254e() {
        return this.f6372c.isFocused();
    }

    public View getThisView() {
        return this;
    }

    public final boolean mo255f() {
        if (!this.f6372c.hasFocus()) {
            return false;
        }
        this.f6372c.setText("");
        this.f6371b.requestFocus();
        return true;
    }
}
