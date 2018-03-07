package com.facebook.saved.controller;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.viewport.ViewportMonitorController;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.saved.data.SavedDashboardItemMutator;
import com.facebook.saved.event.SavedEventBus;
import com.facebook.saved.fragment.SavedItemsListAdapter;
import com.facebook.saved.helper.SavedSectionHelper;
import com.facebook.saved.loader.SavedDashboardEarlyFetcher;
import com.facebook.saved.loader.SavedDashboardItemLoader;
import com.facebook.saved.viewport.SavedItemsVpvLoggerProvider;

/* compiled from: is_async_load */
public class SavedDataAndListStateControllerProvider extends AbstractAssistedProvider<SavedDataAndListStateController> {
    public final SavedDataAndListStateController m9096a(SavedItemsListAdapter savedItemsListAdapter) {
        return new SavedDataAndListStateController(savedItemsListAdapter, SavedSectionHelper.m9180a((InjectorLike) this), SavedDashboardItemLoader.m9235a((InjectorLike) this), SavedDashboardLoadMoreController.m9035a((InjectorLike) this), SavedEventBus.m9122a(this), SavedDashboardItemMutator.m9109a(this), ViewportMonitorController.a(this), (SavedItemsVpvLoggerProvider) getOnDemandAssistedProviderForStaticDi(SavedItemsVpvLoggerProvider.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), SavedDashboardLoadingStateController.m9044a(this), SavedItemsEmptyListViewController.m9097a(this), SavedDashboardNewItemsPillController.m9058a(this), SavedDashboardEarlyFetcher.m9225a((InjectorLike) this), SavedItemsReconnectController.m9101a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
