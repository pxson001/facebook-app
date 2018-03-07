package com.facebook.feed.rows.adapter;

import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.feed.rows.core.AdaptersCollection;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.preparer.AdapterPreparer;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: permalink_story */
public class BasicMultiRowAdapterProvider extends AbstractAssistedProvider<BasicMultiRowAdapter> {
    public final BasicMultiRowAdapter m15286a(AdaptersCollection adaptersCollection, AdapterPreparer adapterPreparer, boolean z) {
        return new BasicMultiRowAdapter(adaptersCollection, adapterPreparer, z, FbErrorReporterImpl.m2317a((InjectorLike) this), ListItemRowController.m16554a((InjectorLike) this));
    }
}
