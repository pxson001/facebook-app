package com.facebook.instantshopping;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.instantshopping.action.InstantShoppingActionUtils;
import com.facebook.instantshopping.fetcher.InstantShoppingDocumentFetcher;
import com.facebook.instantshopping.links.InstantShoppingLinkHandler;
import com.facebook.instantshopping.logging.CatalogLoadSequenceLogger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.model.block.v2.RichDocumentBlocks;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: Sticker */
public class InstantShoppingDocumentManager<T> {
    private static final String f23435a = InstantShoppingDocumentManager.class.getSimpleName();
    private final Map<RichDocumentBlocks, Boolean> f23436b = new HashMap();
    private final Context f23437c;
    private final RichDocumentEventBus f23438d;
    private final AbstractFbErrorReporter f23439e;
    private final InstantShoppingDocumentFetcher f23440f;
    private final CatalogLoadSequenceLogger f23441g;
    private final InstantShoppingLinkHandler f23442h;
    private final InstantShoppingActionUtils f23443i;
    private final QeAccessor f23444j;

    private static InstantShoppingDocumentManager m24770b(InjectorLike injectorLike) {
        return new InstantShoppingDocumentManager((Context) injectorLike.getInstance(Context.class), InstantShoppingDocumentFetcher.a(injectorLike), RichDocumentEventBus.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), CatalogLoadSequenceLogger.m24851a(injectorLike), InstantShoppingLinkHandler.b(injectorLike), InstantShoppingActionUtils.m24796a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public InstantShoppingDocumentManager(Context context, InstantShoppingDocumentFetcher instantShoppingDocumentFetcher, RichDocumentEventBus richDocumentEventBus, AbstractFbErrorReporter abstractFbErrorReporter, CatalogLoadSequenceLogger catalogLoadSequenceLogger, InstantShoppingLinkHandler instantShoppingLinkHandler, InstantShoppingActionUtils instantShoppingActionUtils, QeAccessor qeAccessor) {
        this.f23437c = context;
        this.f23440f = instantShoppingDocumentFetcher;
        this.f23438d = richDocumentEventBus;
        this.f23439e = abstractFbErrorReporter;
        this.f23441g = catalogLoadSequenceLogger;
        this.f23442h = instantShoppingLinkHandler;
        this.f23443i = instantShoppingActionUtils;
        this.f23444j = qeAccessor;
    }
}
