package com.facebook.adspayments;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.adspayments.utils.FieldRequirementSuffix;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.util.StringUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: Unable to get sticker information */
public class PaymentUiUtil {

    /* compiled from: Unable to get sticker information */
    public abstract class AfterChangeTextWatcher implements TextWatcher {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* compiled from: Unable to get sticker information */
    public final class C28311 implements OnClickListener {
        final /* synthetic */ FbFragmentActivity f23577a;

        public C28311(FbFragmentActivity fbFragmentActivity) {
            this.f23577a = fbFragmentActivity;
        }

        public final void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2098217194);
            this.f23577a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -1740088948, a);
        }
    }

    public static void m25553a(View view, boolean z) {
        view.setVisibility(z ? 0 : 8);
    }

    public static void m25552a(TextInputLayout textInputLayout, String str, FieldRequirementSuffix fieldRequirementSuffix, Context context, boolean z) {
        if (z || !StringUtil.a(m25550a(textInputLayout))) {
            textInputLayout.setHint(str);
        } else {
            textInputLayout.setHint(fieldRequirementSuffix.getHint(context, str));
        }
    }

    public static String m25550a(TextInputLayout textInputLayout) {
        return textInputLayout.a.getText().toString();
    }

    public static void m25551a(TextInputLayout textInputLayout, String str) {
        textInputLayout.a.setText(str);
        textInputLayout.setEnabled(StringUtil.a(str));
    }
}
