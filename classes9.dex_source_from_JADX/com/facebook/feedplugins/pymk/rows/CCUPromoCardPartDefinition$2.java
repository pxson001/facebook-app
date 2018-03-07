package com.facebook.feedplugins.pymk.rows;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.ipc.katana.findfriends.CIFlow;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: TM */
public class CCUPromoCardPartDefinition$2 implements OnClickListener {
    final /* synthetic */ CCUPromoCardPartDefinition f24734a;

    public CCUPromoCardPartDefinition$2(CCUPromoCardPartDefinition cCUPromoCardPartDefinition) {
        this.f24734a = cCUPromoCardPartDefinition;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 484828814);
        this.f24734a.h.m26589a();
        Intent a2 = this.f24734a.f.a(this.f24734a.d, StringFormatUtil.a(FBLinks.dQ, new Object[]{CIFlow.NEWS_FEED_PYMK.value, "INLINE_CARD"}));
        if (a2 != null) {
            this.f24734a.e.a(a2, this.f24734a.d);
        }
        Logger.a(2, EntryType.UI_INPUT_END, 1360045635, a);
    }
}
