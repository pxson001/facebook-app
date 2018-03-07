package com.facebook.appdiscovery.lite.ui.rows.sections.baseparts;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.rows.sections.header.ui.HeaderView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;

/* compiled from: selected_shipping_option */
public class HeaderThumbnailClickListenerPartDefintion extends BaseSinglePartDefinition<OnClickListener, Void, AnyEnvironment, HeaderView> {
    public final /* bridge */ /* synthetic */ void m4215a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -635424156);
        ((HeaderView) view).setProfileImageOnClickListener((OnClickListener) obj);
        Logger.a(8, EntryType.MARK_POP, 1632036540, a);
    }

    public final void m4216b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((HeaderView) view).setProfileImageOnClickListener(null);
    }
}
