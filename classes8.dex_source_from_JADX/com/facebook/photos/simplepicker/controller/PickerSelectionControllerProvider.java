package com.facebook.photos.simplepicker.controller;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.simplepicker.SimplePickerConfiguration;
import com.facebook.photos.simplepicker.SimplePickerFlowLogger;
import com.facebook.photos.simplepicker.SimplePickerFragment.C03806;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;

/* compiled from: share_menu_dismissed */
public class PickerSelectionControllerProvider extends AbstractAssistedProvider<PickerSelectionController> {
    public final PickerSelectionController m3135a(SimplePickerConfiguration simplePickerConfiguration, C03806 c03806) {
        return new PickerSelectionController(simplePickerConfiguration, c03806, IdBasedLazy.a(this, 3588), SimplePickerFlowLogger.m2934b((InjectorLike) this), IdBasedProvider.a(this, 727), IdBasedProvider.a(this, 4421), (SequenceLogger) SequenceLoggerImpl.a(this), IdBasedSingletonScopeProvider.b(this, 494), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
