package com.facebook.ufiservices.event;

import com.facebook.feed.util.event.FeedEvent;

/* compiled from: http.connection.stalecheck */
public class UfiEvents$LikeClickedEvent extends FeedEvent {
    public final String f10661a;
    public final String f10662b;
    public final String f10663c;
    public final boolean f10664d;
    public final boolean f10665e;
    public final long f10666f = System.nanoTime();
    public final String f10667g;

    public UfiEvents$LikeClickedEvent(String str, String str2, String str3, boolean z, boolean z2, String str4) {
        this.f10661a = str;
        this.f10662b = str2;
        this.f10663c = str3;
        this.f10664d = z;
        this.f10665e = z2;
        this.f10667g = str4;
    }
}
