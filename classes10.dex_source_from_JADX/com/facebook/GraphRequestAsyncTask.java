package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import java.net.HttpURLConnection;
import java.util.List;

/* compiled from: eventMinutiaePrefilled */
public class GraphRequestAsyncTask extends AsyncTask<Void, Void, List<GraphResponse>> {
    private static final String f13813a = GraphRequestAsyncTask.class.getCanonicalName();
    private final HttpURLConnection f13814b;
    private final GraphRequestBatch f13815c;
    private Exception f13816d;

    protected void onPostExecute(Object obj) {
        super.onPostExecute((List) obj);
        if (this.f13816d != null) {
            Log.d(f13813a, String.format("onPostExecute: exception encountered during request: %s", new Object[]{this.f13816d.getMessage()}));
        }
    }

    public GraphRequestAsyncTask(GraphRequestBatch graphRequestBatch) {
        this(null, graphRequestBatch);
    }

    private GraphRequestAsyncTask(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        this.f13815c = graphRequestBatch;
        this.f13814b = httpURLConnection;
    }

    public String toString() {
        return "{RequestAsyncTask: " + " connection: " + this.f13814b + ", requests: " + this.f13815c + "}";
    }

    protected void onPreExecute() {
        super.onPreExecute();
        if (FacebookSdk.f13773j) {
            Log.d(f13813a, String.format("execute async task: %s", new Object[]{this}));
        }
        if (this.f13815c.f13818b == null) {
            Handler handler;
            if (Thread.currentThread() instanceof HandlerThread) {
                handler = new Handler();
            } else {
                handler = new Handler(Looper.getMainLooper());
            }
            this.f13815c.f13818b = handler;
        }
    }

    protected Object doInBackground(Object[] objArr) {
        try {
            if (this.f13814b == null) {
                return this.f13815c.m14115g();
            }
            return GraphRequest.m14076a(this.f13814b, this.f13815c);
        } catch (Exception e) {
            this.f13816d = e;
            return null;
        }
    }
}
