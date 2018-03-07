package com.facebook.controller.connectioncontroller.common;

import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableSet;

/* compiled from: metaline_2 */
public interface ConnectionStore<TEdge> {

    /* compiled from: metaline_2 */
    public interface ConnectionStoreListener<TEdge> {
        void mo663a();

        void mo664a(int i, int i2, ConnectionState<TEdge> connectionState);

        void mo665a(int i, int i2, ConnectionState<TEdge> connectionState, boolean z);

        void mo666a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder);

        void mo667b();

        void mo668b(int i, int i2, ConnectionState<TEdge> connectionState);
    }

    ConnectionState<TEdge> mo651a();

    ImmutableSet<TEdge> mo652a(String str);

    void mo653a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder, ConnectionPage<TEdge> connectionPage, long j, boolean z);

    void mo654a(ConnectionStoreListener<TEdge> connectionStoreListener);

    void mo655a(String str, Predicate<TEdge> predicate);

    boolean mo656a(GraphQLPersistableNode graphQLPersistableNode);

    boolean mo657a(TEdge tEdge, TEdge tEdge2);

    void mo658b();

    void mo659b(ConnectionStoreListener<TEdge> connectionStoreListener);

    void mo660c();

    void mo661d();
}
