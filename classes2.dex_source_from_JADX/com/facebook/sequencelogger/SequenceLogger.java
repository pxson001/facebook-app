package com.facebook.sequencelogger;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;

@VisibleForTesting
/* compiled from: updated_count */
public interface SequenceLogger {
    <T extends SequenceDefinition> Sequence<T> mo510a(T t);

    <T extends SequenceDefinition> Sequence<T> mo511a(T t, ImmutableMap<String, String> immutableMap);

    <T extends SequenceDefinition> Sequence<T> mo512a(T t, ImmutableMap<String, String> immutableMap, long j);

    <T extends SequenceDefinition> Sequence<T> mo513a(T t, String str, ImmutableMap<String, String> immutableMap, long j);

    <T extends SequenceDefinition> Sequence<T> mo514a(T t, String str, ImmutableMap<String, String> immutableMap, long j, @Nullable Boolean bool);

    <T extends SequenceDefinition> void mo515a(T t, String str);

    void mo516a(String str);

    @Nullable
    <T extends SequenceDefinition> Sequence<T> mo517b(T t, String str);

    <T extends SequenceDefinition> void mo518b(T t);

    <T extends SequenceDefinition> void mo519b(T t, ImmutableMap<String, String> immutableMap);

    <T extends SequenceDefinition> void mo520b(T t, ImmutableMap<String, String> immutableMap, long j);

    <T extends SequenceDefinition> void mo521b(T t, String str, ImmutableMap<String, String> immutableMap, long j);

    <T extends SequenceDefinition> void mo522c(T t);

    <T extends SequenceDefinition> void mo523d(T t);

    @Nullable
    <T extends SequenceDefinition> Sequence<T> mo524e(T t);
}
