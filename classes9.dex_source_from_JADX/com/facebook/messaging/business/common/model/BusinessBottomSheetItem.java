package com.facebook.messaging.business.common.model;

import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: needs_full_refresh */
public class BusinessBottomSheetItem {
    public final String f8776a;
    public final Drawable f8777b;
    public final String f8778c;
    public final String f8779d;
    public final String f8780e;
    public final OnClickListener f8781f;

    /* compiled from: needs_full_refresh */
    public class BusinessBottomSheetItemBuilder {
        public String f8770a;
        public Drawable f8771b;
        public String f8772c;
        public String f8773d;
        public String f8774e;
        public OnClickListener f8775f;

        public BusinessBottomSheetItemBuilder(String str) {
            this.f8772c = str;
        }
    }

    public BusinessBottomSheetItem(BusinessBottomSheetItemBuilder businessBottomSheetItemBuilder) {
        this.f8776a = businessBottomSheetItemBuilder.f8770a;
        this.f8777b = businessBottomSheetItemBuilder.f8771b;
        this.f8778c = businessBottomSheetItemBuilder.f8772c;
        this.f8779d = businessBottomSheetItemBuilder.f8773d;
        this.f8780e = businessBottomSheetItemBuilder.f8774e;
        this.f8781f = businessBottomSheetItemBuilder.f8775f;
    }
}
