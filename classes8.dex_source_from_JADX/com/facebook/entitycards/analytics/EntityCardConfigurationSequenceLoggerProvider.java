package com.facebook.entitycards.analytics;

import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.entitycards.model.EntityCardsPagerAdapter;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.google.common.base.Optional;
import java.util.List;

/* compiled from: initial_experiment/ */
public class EntityCardConfigurationSequenceLoggerProvider extends AbstractAssistedProvider<EntityCardConfigurationSequenceLogger> {
    public final EntityCardConfigurationSequenceLogger m12784a(EntityCardsPagerAdapter entityCardsPagerAdapter, String str, String str2, Optional<String> optional, List<String> list) {
        return new EntityCardConfigurationSequenceLogger((SequenceLogger) SequenceLoggerImpl.a(this), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(this), entityCardsPagerAdapter, str, str2, optional, list);
    }
}
