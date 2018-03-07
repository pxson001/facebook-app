package com.facebook.richdocument;

import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.util.StringUtil;
import javax.annotation.Nullable;

/* compiled from: profile_picture_overlay_birthday */
public abstract class BaseRichDocumentActivity extends FbFragmentActivity {
    private RichDocumentFragment f5036p;

    /* compiled from: profile_picture_overlay_birthday */
    public class C06721 {
        public final /* synthetic */ BaseRichDocumentActivity f5035a;

        C06721(BaseRichDocumentActivity baseRichDocumentActivity) {
            this.f5035a = baseRichDocumentActivity;
        }
    }

    public abstract RichDocumentFragment m5020i();

    public void m5019b(Bundle bundle) {
        super.b(bundle);
        overridePendingTransition(0, 0);
        this.f5036p = m5020i();
        Bundle extras = getIntent().getExtras();
        if (!(StringUtil.c(getIntent().getDataString()) || extras.containsKey("extra_instant_articles_click_url"))) {
            extras.putString("extra_instant_articles_click_url", getIntent().getDataString());
        }
        this.f5036p.g(extras);
        this.f5036p.a(kO_(), "rich_document_fragment");
    }

    protected void onPostCreate(@Nullable Bundle bundle) {
        super.onPostCreate(bundle);
        RichDocumentFragment richDocumentFragment = this.f5036p;
        richDocumentFragment.am.mo251a(new C06721(this));
    }
}
