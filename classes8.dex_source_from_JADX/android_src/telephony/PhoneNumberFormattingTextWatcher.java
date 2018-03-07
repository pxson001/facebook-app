package android_src.telephony;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import com.facebook.phonenumbers.AsYouTypeFormatter;
import com.facebook.phonenumbers.PhoneNumberUtil;

/* compiled from: location_opt_in_back_button_pressed */
public class PhoneNumberFormattingTextWatcher implements TextWatcher {
    private boolean f10190a = false;
    private boolean f10191b;
    private AsYouTypeFormatter f10192c;

    public PhoneNumberFormattingTextWatcher(String str, Context context) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.f10192c = new AsYouTypeFormatter(str, PhoneNumberUtil.getInstance(context));
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (!this.f10190a && !this.f10191b && i2 > 0 && m11976a(charSequence, i, i2)) {
            m11975a();
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (!this.f10190a && !this.f10191b && i3 > 0 && m11976a(charSequence, i, i3)) {
            m11975a();
        }
    }

    public synchronized void afterTextChanged(Editable editable) {
        boolean z = true;
        synchronized (this) {
            if (this.f10191b) {
                if (editable.length() == 0) {
                    z = false;
                }
                this.f10191b = z;
            } else if (!this.f10190a) {
                Object a = m11974a((CharSequence) editable, Selection.getSelectionEnd(editable));
                if (a != null) {
                    int rememberedPosition = this.f10192c.getRememberedPosition();
                    this.f10190a = true;
                    editable.replace(0, editable.length(), a, 0, a.length());
                    if (a.equals(editable.toString())) {
                        Selection.setSelection(editable, rememberedPosition);
                    }
                    this.f10190a = false;
                }
            }
        }
    }

    private String m11974a(CharSequence charSequence, int i) {
        int i2 = i - 1;
        String str = null;
        this.f10192c.clear();
        int length = charSequence.length();
        int i3 = 0;
        boolean z = false;
        char c = '\u0000';
        while (i3 < length) {
            String str2;
            char charAt = charSequence.charAt(i3);
            if (PhoneNumberUtils.isNonSeparator(charAt)) {
                if (c != '\u0000') {
                    str = m11973a(c, z);
                    z = false;
                }
                c = charAt;
                str2 = str;
            } else {
                str2 = str;
            }
            if (i3 == i2) {
                z = true;
            }
            i3++;
            str = str2;
        }
        if (c != '\u0000') {
            return m11973a(c, z);
        }
        return str;
    }

    private String m11973a(char c, boolean z) {
        return z ? this.f10192c.inputDigitAndRememberPosition(c) : this.f10192c.inputDigit(c);
    }

    private void m11975a() {
        this.f10191b = true;
        this.f10192c.clear();
    }

    private static boolean m11976a(CharSequence charSequence, int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            if (!PhoneNumberUtils.isNonSeparator(charSequence.charAt(i3))) {
                return true;
            }
        }
        return false;
    }
}
