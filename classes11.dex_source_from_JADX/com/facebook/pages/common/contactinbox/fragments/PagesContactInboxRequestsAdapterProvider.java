package com.facebook.pages.common.contactinbox.fragments;

import android.content.Context;
import android.view.View.OnClickListener;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.contactinbox.util.PagesContactInboxCache;
import com.facebook.pages.common.contactinbox.util.PagesContactInboxTimeUtils;

/* compiled from: statm */
public class PagesContactInboxRequestsAdapterProvider extends AbstractAssistedProvider<PagesContactInboxRequestsAdapter> {
    public final PagesContactInboxRequestsAdapter m2051a(OnClickListener onClickListener) {
        return new PagesContactInboxRequestsAdapter(PagesContactInboxTimeUtils.m2134b((InjectorLike) this), (TimeFormatUtil) DefaultTimeFormatUtil.a(this), (Context) getInstance(Context.class), PagesContactInboxCache.m2129a((InjectorLike) this), onClickListener);
    }
}
