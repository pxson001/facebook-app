package com.facebook.adinterfaces.ui;

import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.common.util.StringUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.math.BigDecimal;

/* compiled from: Unsupported view Mentions search result view type */
public abstract class BaseEditableRadioGroupViewController<V extends BaseEditableRadioGroupView, D extends AdInterfacesDataModel> extends BaseAdInterfacesViewController<V, D> {
    public EditableRadioButton f23040a;
    protected InputMethodManager f23041b;
    public TextWatcher f23042c;

    /* compiled from: Unsupported view Mentions search result view type */
    public class C27031 implements OnFocusChangeListener {
        final /* synthetic */ BaseEditableRadioGroupViewController f23060a;

        public C27031(BaseEditableRadioGroupViewController baseEditableRadioGroupViewController) {
            this.f23060a = baseEditableRadioGroupViewController;
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                if (!this.f23060a.f23040a.isChecked()) {
                    this.f23060a.f23040a.toggle();
                }
                this.f23060a.m25013r();
                this.f23060a.m25005a(view);
                return;
            }
            this.f23060a.m25013r();
            this.f23060a.m25012q();
        }
    }

    /* compiled from: Unsupported view Mentions search result view type */
    public class C27042 implements OnEditorActionListener {
        final /* synthetic */ BaseEditableRadioGroupViewController f23061a;

        public C27042(BaseEditableRadioGroupViewController baseEditableRadioGroupViewController) {
            this.f23061a = baseEditableRadioGroupViewController;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 6) {
                this.f23061a.m25012q();
            }
            return false;
        }
    }

    /* compiled from: Unsupported view Mentions search result view type */
    public class C27053 implements OnClickListener {
        final /* synthetic */ BaseEditableRadioGroupViewController f23062a;

        public C27053(BaseEditableRadioGroupViewController baseEditableRadioGroupViewController) {
            this.f23062a = baseEditableRadioGroupViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1198512807);
            this.f23062a.m25005a(view);
            this.f23062a.f23040a.toggle();
            Logger.a(2, EntryType.UI_INPUT_END, 1490806996, a);
        }
    }

    /* compiled from: Unsupported view Mentions search result view type */
    public enum EditableRadioButtonHintType {
        NONE,
        GENERIC,
        DETAIL
    }

    /* compiled from: Unsupported view Mentions search result view type */
    public enum EditableRadioButtonState {
        EMPTY_UNSELECTED,
        EMPTY_SELECTED,
        VALID,
        INVALID,
        HIDDEN
    }

    public abstract TextWatcher mo1018n();

    protected abstract CharSequence mo1019o();

    protected abstract CharSequence mo1020p();

    public BaseEditableRadioGroupViewController(InputMethodManager inputMethodManager) {
        this.f23041b = inputMethodManager;
    }

    public void mo1017a(V v, AdInterfacesCardLayout adInterfacesCardLayout) {
        super.mo982a(v, adInterfacesCardLayout);
        this.f23040a = v.f23058b;
        this.f23040a.setOnEditorActionListenerEditText(new C27042(this));
        this.f23040a.setOnClickListener(new C27053(this));
        this.f23040a.setOnFocusChangeListenerEditText(new C27031(this));
        this.f23042c = mo1018n();
        if (this.f23042c != null) {
            this.f23040a.m25115a(this.f23042c);
        }
    }

    public void mo981a() {
        super.mo981a();
        this.f23040a.setOnFocusChangeListenerEditText(null);
        this.f23040a.setOnClickListener(null);
        this.f23040a.setOnEditorActionListenerEditText(null);
        if (this.f23042c != null) {
            this.f23040a.m25116b(this.f23042c);
        }
        this.f23040a = null;
    }

    protected final void m25005a(View view) {
        view.requestFocus();
        this.f23041b.toggleSoftInput(2, 1);
        this.f23040a.setCursorVisible(true);
    }

    protected final void m25012q() {
        this.f23041b.hideSoftInputFromWindow(this.f23040a.getWindowToken(), 0);
        this.f23040a.setCursorVisible(false);
    }

    protected final EditableRadioButtonState m25003a(String str) {
        if (StringUtil.a(str)) {
            if (this.f23040a.isChecked()) {
                return EditableRadioButtonState.EMPTY_SELECTED;
            }
            return EditableRadioButtonState.EMPTY_UNSELECTED;
        } else if (new BigDecimal(str).equals(BigDecimal.ZERO)) {
            return EditableRadioButtonState.INVALID;
        } else {
            return EditableRadioButtonState.VALID;
        }
    }

    protected final void m25008a(EditableRadioButtonState editableRadioButtonState) {
        switch (editableRadioButtonState) {
            case HIDDEN:
                this.f23040a.setVisibility(8);
                return;
            case EMPTY_UNSELECTED:
                this.f23040a.setVisibility(0);
                this.f23040a.setVisibilityPrefixTextView(8);
                this.f23040a.setVisibilitySuffixTextView(8);
                m25002a(EditableRadioButtonHintType.GENERIC);
                return;
            case EMPTY_SELECTED:
                this.f23040a.setVisibility(0);
                this.f23040a.setVisibilityPrefixTextView(0);
                this.f23040a.setVisibilitySuffixTextView(8);
                m25002a(EditableRadioButtonHintType.DETAIL);
                return;
            case INVALID:
                this.f23040a.setVisibility(0);
                this.f23040a.setVisibilityPrefixTextView(0);
                this.f23040a.setVisibilitySuffixTextView(8);
                m25002a(EditableRadioButtonHintType.NONE);
                return;
            case VALID:
                this.f23040a.setVisibility(0);
                this.f23040a.setVisibilityPrefixTextView(0);
                this.f23040a.setVisibilitySuffixTextView(0);
                m25002a(EditableRadioButtonHintType.NONE);
                return;
            default:
                return;
        }
    }

    private void m25002a(EditableRadioButtonHintType editableRadioButtonHintType) {
        switch (editableRadioButtonHintType) {
            case GENERIC:
                this.f23040a.setHint(mo1019o());
                return;
            case DETAIL:
                this.f23040a.setHint(mo1020p());
                return;
            default:
                this.f23040a.setHint("");
                return;
        }
    }

    public final void m25013r() {
        m25008a(m25003a(this.f23040a.getTextEditText()));
    }
}
