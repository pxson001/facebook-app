package com.facebook.katana.prefs;

import android.content.Context;
import android.net.Uri;
import android.text.Editable;
import android.widget.Toast;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.SecureContextHelper;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper;
import com.facebook.widget.prefs.OrcaEditTextPreference;

/* compiled from: p2p_mobile_browser_risk_cancel */
public class URIWidgetPreference extends OrcaEditTextPreference {
    public Context f7575a;
    public FbUriIntentHandler f7576b;
    public SecureContextHelper f7577c;

    public URIWidgetPreference(Context context, FbUriIntentHandler fbUriIntentHandler, SecureContextHelper secureContextHelper) {
        super(context);
        this.f7575a = context;
        this.f7576b = fbUriIntentHandler;
        this.f7577c = secureContextHelper;
        setTitle("URI Test Widget");
        setSummary("Test an internal or external URI");
        getEditText().setHint("e.g. fbrpc://... or fb://...");
    }

    public void onDialogClosed(boolean z) {
        if (z) {
            Editable text = getEditText().getText();
            if (text == null) {
                Toast.makeText(this.f7575a, "Error parsing text", 1).show();
                return;
            }
            String obj = text.toString();
            if (NativeThirdPartyUriHelper.a(obj)) {
                this.f7577c.b(NativeThirdPartyUriHelper.a(this.f7575a, Uri.parse(obj)), this.f7575a);
                return;
            }
            if (!this.f7576b.a(this.f7575a, obj)) {
                Toast.makeText(this.f7575a, "Please enter a valid URI", 1).show();
            }
        }
    }
}
