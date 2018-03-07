package com.facebook.search.common.errors;

/* compiled from: ex_code */
public class GraphSearchException extends Exception {
    public final GraphSearchError mError;

    public GraphSearchException(GraphSearchError graphSearchError, Throwable th) {
        super(th);
        this.mError = graphSearchError;
    }

    public GraphSearchException(GraphSearchError graphSearchError, String str) {
        super(str);
        this.mError = graphSearchError;
    }
}
