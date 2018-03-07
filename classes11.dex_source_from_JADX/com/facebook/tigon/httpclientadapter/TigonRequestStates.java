package com.facebook.tigon.httpclientadapter;

import android.util.SparseArray;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.common.FbRequestState;
import com.facebook.tigon.tigonapi.TigonDirectBufferRelease;
import com.facebook.tigon.tigonapi.TigonRequestToken;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.apache.http.client.ResponseHandler;

/* compiled from: not_all_tiles_in_cache */
public class TigonRequestStates {
    public final SparseArray<TigonRequestState> f4993a = new SparseArray();
    private long f4994b = System.nanoTime();

    TigonRequestStates() {
    }

    final synchronized TigonRequestState m6281a(String str, int i, ResponseHandler responseHandler, FlowObserverRequestInfo flowObserverRequestInfo, FbRequestState fbRequestState, SettableFuture settableFuture, TigonDirectBufferRelease tigonDirectBufferRelease, boolean z) {
        TigonRequestState a;
        m6280b();
        TigonHttpClientAdapterImpl.m6237a(i, "initiateRequest", Integer.valueOf(i));
        a = TigonRequestState.m6246a(str, i, responseHandler, flowObserverRequestInfo, fbRequestState, settableFuture, tigonDirectBufferRelease, this.f4993a.size(), z);
        this.f4993a.put(i, a);
        return a;
    }

    private void m6280b() {
        long nanoTime = System.nanoTime();
        if (TimeUnit.NANOSECONDS.toMinutes(nanoTime - this.f4994b) >= 10) {
            this.f4994b = nanoTime;
            boolean z = TigonHttpClientAdapterModule.f4961a;
            for (int i = 0; i < this.f4993a.size(); i++) {
                TigonRequestState tigonRequestState = (TigonRequestState) this.f4993a.valueAt(i);
                if (TigonHttpClientAdapterModule.f4962b) {
                    Integer.valueOf(tigonRequestState.f4974b);
                    Long.valueOf(TimeUnit.NANOSECONDS.toSeconds(nanoTime - tigonRequestState.m6276g()));
                }
                if (TimeUnit.NANOSECONDS.toMinutes(nanoTime - tigonRequestState.m6276g()) >= 10) {
                    tigonRequestState.m6268a(StringFormatUtil.formatStrLocaleSafe("Stale state (%d s)", Long.valueOf(TimeUnit.NANOSECONDS.toSeconds(nanoTime - tigonRequestState.m6276g()))), 2);
                }
            }
        }
    }

    @Nullable
    public final synchronized TigonRequestToken m6282a(int i) {
        TigonRequestToken tigonRequestToken;
        TigonRequestState tigonRequestState = (TigonRequestState) this.f4993a.get(i);
        if (tigonRequestState == null) {
            tigonRequestToken = null;
        } else {
            tigonRequestToken = tigonRequestState.m6275f();
        }
        return tigonRequestToken;
    }

    @Nullable
    final TigonBodyBuffer m6284b(int i) {
        return m6286d(i).m6277h();
    }

    public final synchronized void m6285c(int i) {
        m6286d(i);
        this.f4993a.remove(i);
        if (TigonHttpClientAdapterModule.f4962b) {
            Integer.valueOf(this.f4993a.size());
        }
    }

    final synchronized TigonRequestState m6286d(int i) {
        TigonRequestState tigonRequestState;
        tigonRequestState = (TigonRequestState) this.f4993a.get(i);
        Preconditions.checkState(tigonRequestState != null);
        return tigonRequestState;
    }

    public final String m6283a() {
        int i;
        Builder builder = ImmutableList.builder();
        synchronized (this) {
            for (i = 0; i < this.f4993a.size(); i++) {
                builder.c(this.f4993a.valueAt(i));
            }
        }
        ImmutableList b = builder.b();
        int size = b.size();
        int i2 = 0;
        i = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < size) {
            int i5;
            TigonRequestState tigonRequestState = (TigonRequestState) b.get(i2);
            int i6;
            if (tigonRequestState.m6269a()) {
                i6 = i;
                i = i3;
                i3 = i4 + 1;
                i5 = i6;
            } else if (tigonRequestState.m6271b()) {
                i5 = i3 + 1;
                i3 = i4;
                i6 = i5;
                i5 = i;
                i = i6;
            } else if (tigonRequestState.m6272c()) {
                i5 = i + 1;
                i = i3;
                i3 = i4;
            } else {
                i5 = i;
                i = i3;
                i3 = i4;
            }
            i2++;
            i4 = i3;
            i3 = i;
            i = i5;
        }
        StringBuilder stringBuilder = new StringBuilder("TigonRequestStates:");
        stringBuilder.append(" outstanding(").append(this.f4993a.size()).append(")");
        stringBuilder.append(" waiting(").append(i4).append(")");
        stringBuilder.append(" handling(").append(i3).append(")");
        stringBuilder.append(" handled(").append(i).append(")");
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
