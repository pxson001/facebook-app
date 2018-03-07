package com.facebook.richdocument.genesis;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.sequencelogger.AbstractSequenceDefinition;

/* compiled from: possible_dup_places */
public class BlockViewHolderFactoryProvider extends AbstractAssistedProvider<BlockViewHolderFactory> {
    public final BlockViewHolderFactory m5228a(AbstractSequenceDefinition abstractSequenceDefinition) {
        return new BlockViewHolderFactory(IdBasedSingletonScopeProvider.b(this, 3422), new MultiBinderSet(getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$BlockCreator(this)), abstractSequenceDefinition);
    }
}
