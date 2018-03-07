package com.facebook.widget.filter;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.common.executors.ThreadPriority;
import com.facebook.widget.filter.CustomFilter.Delayer;
import com.facebook.widget.filter.CustomFilter.FilterListener;
import com.facebook.widget.filter.CustomFilter.FilterResults;
import com.facebook.widget.filter.CustomFilter.FilteringState;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: reshare_education_type */
public abstract class AbstractCustomFilter implements CustomFilter {
    private final FbHandlerThreadFactory f5731a;
    public Handler f5732b;
    public Handler f5733c;
    private Delayer f5734d;
    @GuardedBy("ui thread")
    private int f5735e;
    @GuardedBy("ui thread")
    public int f5736f;
    @GuardedBy("ui thread")
    public FilteringState f5737g = FilteringState.FINISHED;
    public final Object f5738h = new Object();

    /* compiled from: reshare_education_type */
    class RequestArguments {
        CharSequence f5725a;
        FilterListener f5726b;
        FilterResults f5727c;
        int f5728d;
    }

    /* compiled from: reshare_education_type */
    class RequestHandler extends Handler {
        final /* synthetic */ AbstractCustomFilter f5729a;

        public RequestHandler(AbstractCustomFilter abstractCustomFilter, Looper looper) {
            this.f5729a = abstractCustomFilter;
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            switch (i) {
                case -791613427:
                    RequestArguments requestArguments = (RequestArguments) message.obj;
                    try {
                        requestArguments.f5727c = this.f5729a.mo1400b(requestArguments.f5725a);
                    } catch (Throwable e) {
                        requestArguments.f5727c = new FilterResults();
                        Log.w("Filter", "An exception occured during performFiltering()!", e);
                    } finally {
                        Message obtainMessage = this.f5729a.f5733c.obtainMessage(i);
                        obtainMessage.obj = requestArguments;
                        obtainMessage.sendToTarget();
                    }
                    synchronized (this.f5729a.f5738h) {
                        if (this.f5729a.f5732b != null) {
                            this.f5729a.f5732b.sendMessageDelayed(this.f5729a.f5732b.obtainMessage(-559038737), 3000);
                        }
                    }
                    return;
                case -559038737:
                    synchronized (this.f5729a.f5738h) {
                        if (this.f5729a.f5732b != null) {
                            this.f5729a.f5732b.getLooper().quit();
                            this.f5729a.f5732b = null;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: reshare_education_type */
    class ResultsHandler extends Handler {
        final /* synthetic */ AbstractCustomFilter f5730a;

        public ResultsHandler(AbstractCustomFilter abstractCustomFilter) {
            this.f5730a = abstractCustomFilter;
        }

        public void handleMessage(Message message) {
            RequestArguments requestArguments = (RequestArguments) message.obj;
            this.f5730a.mo1399a(requestArguments.f5725a, requestArguments.f5727c);
            if (requestArguments.f5726b != null) {
                requestArguments.f5726b.mo1517a(requestArguments.f5727c != null ? requestArguments.f5727c.f5740b : -1);
            }
            if ((requestArguments.f5728d == this.f5730a.f5736f ? 1 : null) != null && this.f5730a.f5737g != FilteringState.FINISHED) {
                this.f5730a.f5737g = FilteringState.FINISHED;
                if (requestArguments.f5726b != null) {
                    requestArguments.f5726b.mo1518a(this.f5730a.f5737g);
                }
            }
        }
    }

    protected abstract void mo1399a(CharSequence charSequence, FilterResults filterResults);

    protected abstract FilterResults mo1400b(CharSequence charSequence);

    public AbstractCustomFilter(FbHandlerThreadFactory fbHandlerThreadFactory) {
        this.f5731a = fbHandlerThreadFactory;
        this.f5733c = new ResultsHandler(this);
    }

    public final void mo389a(CharSequence charSequence) {
        mo390a(charSequence, null);
    }

    public final void mo390a(CharSequence charSequence, FilterListener filterListener) {
        synchronized (this.f5738h) {
            if (this.f5732b == null) {
                HandlerThread a = this.f5731a.a("Filter", ThreadPriority.BACKGROUND);
                a.start();
                this.f5732b = new RequestHandler(this, a.getLooper());
            }
            long a2 = this.f5734d == null ? 0 : this.f5734d.m8348a();
            Message obtainMessage = this.f5732b.obtainMessage(-791613427);
            RequestArguments requestArguments = new RequestArguments();
            requestArguments.f5725a = charSequence != null ? charSequence.toString() : null;
            requestArguments.f5726b = filterListener;
            int i = this.f5735e;
            this.f5735e = i + 1;
            requestArguments.f5728d = i;
            this.f5736f = requestArguments.f5728d;
            if (this.f5737g != FilteringState.FILTERING) {
                this.f5737g = FilteringState.FILTERING;
                if (filterListener != null) {
                    filterListener.mo1518a(this.f5737g);
                }
            }
            obtainMessage.obj = requestArguments;
            this.f5732b.removeMessages(-791613427);
            this.f5732b.removeMessages(-559038737);
            this.f5732b.sendMessageDelayed(obtainMessage, a2);
        }
    }

    public final void m8342a() {
        this.f5736f = -1;
    }

    public final FilteringState mo391b() {
        return this.f5737g;
    }
}
