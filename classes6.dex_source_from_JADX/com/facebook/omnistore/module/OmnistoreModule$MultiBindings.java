package com.facebook.omnistore.module;

import com.facebook.inject.DeclareMultiBindings;
import com.facebook.omnistore.module.OmnistoreCallbackRegistration.FilteredCallbackMultibindWrapper;
import com.facebook.omnistore.module.OmnistoreIndexerRegistration.IndexerFunctionMultibindWrapper;
import java.util.Set;

@DeclareMultiBindings
/* compiled from: tax */
interface OmnistoreModule$MultiBindings {
    Set<IndexerFunctionMultibindWrapper> getIndexerFunctions();

    @InitiallyRegisteredCallbacks
    Set<FilteredCallbackMultibindWrapper> getInitialCallbacks();

    Set<OmnistoreComponent> getOmnistoreStartupComponents();

    Set<OmnistoreStoredProcedureComponent> getOmnistoreStoredProcedureComponents();
}
