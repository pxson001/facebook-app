package com.facebook.instantshopping;

import android.os.Bundle;
import com.facebook.common.util.StringUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.richdocument.RichDocumentDelegate;
import com.facebook.richdocument.RichDocumentFragment;
import javax.annotation.Nullable;

/* compiled from: Sticker request failed */
public class InstantShoppingDocumentFragment extends RichDocumentFragment {
    private InstantShoppingDocumentDelegateImpl am;

    public final RichDocumentDelegate aq() {
        this.am = new InstantShoppingDocumentDelegateImpl();
        return this.am;
    }

    public final void m24769h(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 634196105);
        super.h(bundle);
        InstantShoppingDocumentDelegateImpl instantShoppingDocumentDelegateImpl = this.am;
        if (bundle != null) {
            Object string = bundle.getString("instant_shopping_catalog_session_id");
            if (!StringUtil.c(string)) {
                instantShoppingDocumentDelegateImpl.ak = string;
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2047387547, a);
    }
}
