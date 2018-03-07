package com.facebook.feed.rows.pager;

import com.facebook.common.android.ActivityMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewAdapter.PageStyler;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PagerBinderDelegate;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;

/* compiled from: olderThanTimestamp must be greater 0 */
public class PagerBinderAdapterProvider extends AbstractAssistedProvider<PagerBinderAdapter> {
    public final PagerBinderAdapter m6713a(PagerBinderDelegate pagerBinderDelegate, PageStyler pageStyler) {
        return new PagerBinderAdapter(ActivityMethodAutoProvider.b(this), RecyclableViewPoolManager.m6891a((InjectorLike) this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), pagerBinderDelegate, pageStyler);
    }
}
