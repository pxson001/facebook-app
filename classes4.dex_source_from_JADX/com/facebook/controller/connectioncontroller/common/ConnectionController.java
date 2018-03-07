package com.facebook.controller.connectioncontroller.common;

import com.google.common.base.Predicate;

/* compiled from: min_push_intervals_s_overrides */
public interface ConnectionController<TEdge, TUserInfo> {
    void mo635a();

    void mo636a(int i, TUserInfo tUserInfo);

    void mo637a(ConnectionListener<TEdge> connectionListener);

    void mo638a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder, int i, TUserInfo tUserInfo);

    void mo639a(String str, Predicate<TEdge> predicate);

    void mo640b();

    void mo641b(int i, TUserInfo tUserInfo);

    void mo642b(ConnectionListener<TEdge> connectionListener);

    void mo643c();

    ConnectionState<TEdge> mo644d();

    MutationControllerManager mo645e();
}
