package com.facebook.fbui.viewdescriptionbuilder.viewspecs;

import android.os.Bundle;
import android.widget.TextView;
import com.facebook.fbui.viewdescriptionbuilder.ViewDescriptionBuilderSpec;

/* compiled from: XMPUtil */
public class TextViewDescriptionSpec implements ViewDescriptionBuilderSpec<TextView> {
    public final void mo1226a(Object obj, Bundle bundle) {
        CharSequence text = ((TextView) obj).getText();
        String str = null;
        if (text != null) {
            str = text.toString();
        }
        String str2 = "textview_text";
        if (str == null) {
            str = "null";
        }
        bundle.putString(str2, str);
    }

    public final Class<TextView> mo1225a() {
        return TextView.class;
    }
}
