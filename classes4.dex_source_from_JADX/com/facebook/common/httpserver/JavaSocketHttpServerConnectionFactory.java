package com.facebook.common.httpserver;

import com.facebook.common.socketlike.java.JavaSocketLike;
import com.facebook.common.socketlike.java.JavaSocketLikeFactory;
import org.apache.http.HttpServerConnection;
import org.apache.http.impl.DefaultHttpServerConnection;
import org.apache.http.params.HttpParams;

/* compiled from: first_n_feedback_reactions */
public class JavaSocketHttpServerConnectionFactory {
    public final JavaSocketLikeFactory f11564a = new JavaSocketLikeFactory();

    public final HttpServerConnection m12040a(JavaSocketLike javaSocketLike, HttpParams httpParams) {
        javaSocketLike = javaSocketLike;
        HttpServerConnection defaultHttpServerConnection = new DefaultHttpServerConnection();
        defaultHttpServerConnection.bind(javaSocketLike.f11610a, httpParams);
        return defaultHttpServerConnection;
    }
}
