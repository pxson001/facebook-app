package com.facebook.messaging.business.nativesignup.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment.EventListener;
import com.facebook.messaging.business.common.helper.BusinessMessageDialogHelper;
import com.facebook.messaging.business.nativesignup.logging.NativeSignUpLogger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.widget.text.BetterButton;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: msgr_bball_end */
public final class BusinessEmailInputFragment extends FbFragment implements BusinessActivityFragment {
    @Inject
    public NativeSignUpLogger f8976a;
    @Inject
    public BusinessMessageDialogHelper f8977b;
    public EditText f8978c;
    public BetterButton f8979d;
    public ImageView f8980e;

    /* compiled from: msgr_bball_end */
    class C10311 implements Runnable {
        final /* synthetic */ BusinessEmailInputFragment f8972a;

        C10311(BusinessEmailInputFragment businessEmailInputFragment) {
            this.f8972a = businessEmailInputFragment;
        }

        public void run() {
            if (this.f8972a.f8978c.requestFocus()) {
                KeyboardUtils.b(this.f8972a.getContext(), this.f8972a.f8978c);
            }
        }
    }

    /* compiled from: msgr_bball_end */
    public class C10322 implements TextWatcher {
        final /* synthetic */ BusinessEmailInputFragment f8973a;

        public C10322(BusinessEmailInputFragment businessEmailInputFragment) {
            this.f8973a = businessEmailInputFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f8973a.f8979d.setEnabled(BusinessEmailInputFragment.m9224b(charSequence.toString()));
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: msgr_bball_end */
    public class C10333 implements OnClickListener {
        final /* synthetic */ BusinessEmailInputFragment f8974a;

        public C10333(BusinessEmailInputFragment businessEmailInputFragment) {
            this.f8974a = businessEmailInputFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1923253204);
            this.f8974a.f8976a.m9159a("click_request_code_button");
            if (BusinessEmailInputFragment.m9224b(this.f8974a.f8978c.getText().toString())) {
                Intent intent = new Intent();
                intent.putExtra("updated_email", this.f8974a.f8978c.getText().toString());
                this.f8974a.ao().setResult(-1, intent);
                this.f8974a.ao().finish();
            } else {
                this.f8974a.f8977b.m9019a();
            }
            LogUtils.a(-1785498053, a);
        }
    }

    /* compiled from: msgr_bball_end */
    public class C10344 implements OnClickListener {
        final /* synthetic */ BusinessEmailInputFragment f8975a;

        public C10344(BusinessEmailInputFragment businessEmailInputFragment) {
            this.f8975a = businessEmailInputFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1140484506);
            this.f8975a.ao().onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -1241044334, a);
        }
    }

    /* compiled from: msgr_bball_end */
    public class Factory implements com.facebook.messaging.business.common.activity.BusinessActivityFragment.Factory {
        public final String mo307a() {
            return "BusinessEmailInputFragment";
        }

        public final BusinessActivityFragment mo308b() {
            return new BusinessEmailInputFragment();
        }
    }

    public static void m9223a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        BusinessEmailInputFragment businessEmailInputFragment = (BusinessEmailInputFragment) obj;
        NativeSignUpLogger b = NativeSignUpLogger.m9158b(injectorLike);
        BusinessMessageDialogHelper b2 = BusinessMessageDialogHelper.m9018b(injectorLike);
        businessEmailInputFragment.f8976a = b;
        businessEmailInputFragment.f8977b = b2;
    }

    public final void m9232c(Bundle bundle) {
        super.c(bundle);
        Class cls = BusinessEmailInputFragment.class;
        m9223a((Object) this, getContext());
    }

    public final String mo309a(Context context) {
        return "";
    }

    public final void mo311a(EventListener eventListener) {
    }

    public final void mo310a(Parcelable parcelable) {
    }

    public final void m9225G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -519777514);
        super.G();
        this.f8978c.postDelayed(new C10311(this), 200);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1758972778, a);
    }

    public final void m9226H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1644369208);
        super.H();
        KeyboardUtils.a(getContext(), this.T);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2088297486, a);
    }

    public final View m9227a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1462707879);
        View inflate = layoutInflater.inflate(2130903464, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1755412116, a);
        return inflate;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -221917757);
        ao().setRequestedOrientation(1);
        super.mi_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 863176838, a);
    }

    public final void m9230a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f8978c = (EditText) e(2131560091);
        this.f8979d = (BetterButton) e(2131560092);
        this.f8980e = (ImageView) e(2131560079);
        this.f8978c.addTextChangedListener(new C10322(this));
        this.f8979d.setOnClickListener(new C10333(this));
        this.f8980e.setOnClickListener(new C10344(this));
    }

    public static boolean m9224b(String str) {
        if (Strings.isNullOrEmpty(str)) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(str).find();
    }
}
