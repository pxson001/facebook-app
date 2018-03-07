package com.facebook.ui.dialogs;

import android.content.Context;
import android.content.ContextWrapper;
import com.facebook.common.util.ContextUtils;

/* compiled from: e4143fa6cdbeb3bfd00dd6ef82f0db33 */
public class DialogContext extends ContextWrapper {
    public DialogContext(Context context) {
        super(context);
    }

    public static boolean m14354a(Context context) {
        return ContextUtils.a(context, DialogContext.class) != null;
    }
}
