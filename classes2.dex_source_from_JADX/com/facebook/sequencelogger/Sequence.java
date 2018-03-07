package com.facebook.sequencelogger;

import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;

/* compiled from: ui_metrics */
public interface Sequence<T extends SequenceDefinition> {
    Sequence<T> mo610a(String str);

    Sequence<T> mo611a(String str, @Nullable ImmutableMap<String, String> immutableMap, long j);

    Sequence<T> mo612a(String str, @Nullable String str2);

    Sequence<T> mo613a(String str, @Nullable String str2, long j);

    Sequence<T> mo614a(String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap);

    Sequence<T> mo615a(String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j);

    Sequence<T> mo616a(String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j, @Nullable Boolean bool);

    @Nullable
    String mo617a();

    int mo618b();

    Sequence<T> mo619b(String str);

    Sequence<T> mo620b(String str, String str2);

    Sequence<T> mo621b(String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap);

    Sequence<T> mo622b(String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j);

    Sequence<T> mo623b(String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j, @Nullable Boolean bool);

    long mo624c();

    Sequence<T> mo625c(String str);

    Sequence<T> mo626c(String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap);

    Sequence<T> mo627c(String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap, long j);

    boolean mo628c(String str, @Nullable String str2);

    Sequence<T> mo629d(String str);

    Sequence<T> mo630e(String str);

    boolean mo631f(String str);
}
