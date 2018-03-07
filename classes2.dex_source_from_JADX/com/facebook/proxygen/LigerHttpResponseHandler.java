package com.facebook.proxygen;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.http.common.NetworkException;
import com.facebook.http.observer.HttpFlowStatistics;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.loom.logger.api.LoomLogger;
import com.facebook.proxygen.HTTPRequestError.HTTPRequestStage;
import com.facebook.proxygen.HTTPRequestError.ProxygenError;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.entity.InputStreamEntity;

/* compiled from: node */
public class LigerHttpResponseHandler implements HTTPResponseHandler {
    private final ReadBuffer mBuffer;
    @Nullable
    private ReadBufferInputStream mBufferInputStream;
    private final AbstractFbErrorReporter mErrorReporter;
    private TraceEventHandler mEventHandler;
    private final Object mHeadersArrivedCondition;
    private final String mHostname;
    private final HttpFlowStatistics mHttpFlowStatistics;
    private long mLoomLogId;
    private int mLoomMatchId;
    @Nullable
    private HttpNetworkException mNetworkException;
    private volatile ReadState mReadState;
    private final RequestStatsObserver mRequestStatsObserver;
    @Nullable
    private HttpResponse mResponse;

    /* compiled from: node */
    enum ReadState {
        NO_RESPONSE,
        HEADERS_ARRIVED,
        BODY_ARRIVED,
        RESPONSE_COMPLETED,
        ERROR
    }

    public LigerHttpResponseHandler(String str, ReadBuffer readBuffer, TraceEventHandler traceEventHandler, AbstractFbErrorReporter abstractFbErrorReporter, RequestStatsObserver requestStatsObserver, HttpFlowStatistics httpFlowStatistics, int i, String str2) {
        this(str, readBuffer, traceEventHandler, abstractFbErrorReporter, requestStatsObserver, httpFlowStatistics);
        this.mLoomLogId = (long) i;
        this.mLoomMatchId = -1;
        this.mLoomMatchId = LoomLogger.a(this.mLoomLogId);
        this.mLoomMatchId = LoomLogger.a(this.mLoomMatchId, this.mLoomLogId, str2);
        this.mLoomMatchId = LoomLogger.b(this.mLoomLogId);
    }

    public LigerHttpResponseHandler(String str, ReadBuffer readBuffer, TraceEventHandler traceEventHandler, AbstractFbErrorReporter abstractFbErrorReporter, RequestStatsObserver requestStatsObserver, HttpFlowStatistics httpFlowStatistics) {
        boolean z = true;
        this.mReadState = ReadState.NO_RESPONSE;
        this.mHeadersArrivedCondition = new Object();
        Preconditions.checkState(readBuffer != null);
        if (traceEventHandler == null) {
            z = false;
        }
        Preconditions.checkState(z);
        this.mHostname = str;
        this.mBuffer = readBuffer;
        this.mEventHandler = traceEventHandler;
        this.mErrorReporter = abstractFbErrorReporter;
        this.mRequestStatsObserver = requestStatsObserver;
        this.mHttpFlowStatistics = httpFlowStatistics;
    }

    public HttpResponse getResponse() {
        waitForHeaders();
        Preconditions.checkNotNull(this.mResponse);
        return this.mResponse;
    }

    public void onResponse(int i, @Nullable String str, @Nullable Header[] headerArr) {
        synchronized (this.mHeadersArrivedCondition) {
            try {
                handleOnResponse(i, str, headerArr);
            } catch (Throwable th) {
                logException("error_on_response", th);
            } finally {
                ObjectDetour.c(this.mHeadersArrivedCondition, -1995916295);
            }
        }
    }

    private void handleOnResponse(int i, @Nullable String str, @Nullable Header[] headerArr) {
        int a;
        int i2 = 0;
        verifyState(ReadState.NO_RESPONSE);
        long j = this.mLoomLogId;
        if (LoomLogger.a) {
            a = Logger.a(256, EntryType.NET_RESPONSE, 0, 0, j);
        } else {
            a = -1;
        }
        this.mLoomMatchId = a;
        if (str == null) {
            str = "empty";
        }
        if (headerArr == null) {
            headerArr = new Header[0];
        }
        this.mResponse = new LigerResponse(HttpVersion.HTTP_1_1, i, str);
        while (i2 < headerArr.length) {
            this.mResponse.addHeader(headerArr[i2]);
            i2++;
        }
        long contentLength = getContentLength(this.mResponse);
        this.mBufferInputStream = new ReadBufferInputStream(this.mBuffer);
        HttpEntity inputStreamEntity = new InputStreamEntity(this.mBufferInputStream, contentLength);
        Header firstHeader = this.mResponse.getFirstHeader("Content-Encoding");
        if (firstHeader != null) {
            inputStreamEntity.setContentEncoding(firstHeader.getValue());
        }
        firstHeader = this.mResponse.getFirstHeader("Content-Type");
        if (firstHeader != null) {
            inputStreamEntity.setContentType(firstHeader.getValue());
        }
        this.mResponse.setEntity(inputStreamEntity);
        this.mReadState = ReadState.HEADERS_ARRIVED;
    }

    public void onBody() {
        try {
            handleBody();
        } catch (Throwable th) {
            logException("error_on_body", th);
        }
    }

    private void handleBody() {
        Preconditions.checkNotNull(this.mBufferInputStream);
        verifyState(ReadState.HEADERS_ARRIVED, ReadState.BODY_ARRIVED);
        this.mBufferInputStream.onBody();
        this.mReadState = ReadState.BODY_ARRIVED;
    }

    public void onEOM() {
        try {
            handleEOM();
        } catch (Throwable th) {
            logException("error_on_eom", th);
        }
    }

    private void handleEOM() {
        int a;
        if (this.mHttpFlowStatistics != null) {
            this.mHttpFlowStatistics.f12002i = "done";
        }
        Preconditions.checkNotNull(this.mBufferInputStream);
        verifyState(ReadState.HEADERS_ARRIVED, ReadState.BODY_ARRIVED);
        this.mReadState = ReadState.RESPONSE_COMPLETED;
        this.mBufferInputStream.onEOM();
        RequestStats requestStats = this.mRequestStatsObserver.getRequestStats();
        long j = this.mLoomLogId;
        if (LoomLogger.a) {
            a = Logger.a(256, EntryType.NET_END, 0, 0, j);
        } else {
            a = -1;
        }
        this.mLoomMatchId = a;
        if (requestStats != null) {
            this.mEventHandler.decorateStatistics(requestStats, this.mLoomLogId);
        }
    }

    public void onError(@Nullable HTTPRequestError hTTPRequestError) {
        synchronized (this.mHeadersArrivedCondition) {
            try {
                handleError(hTTPRequestError);
            } catch (Throwable th) {
                logException("error_on_error", th);
            } finally {
                ObjectDetour.c(this.mHeadersArrivedCondition, -370018738);
            }
        }
    }

    private void handleError(@Nullable HTTPRequestError hTTPRequestError) {
        int a;
        if (hTTPRequestError == null) {
            hTTPRequestError = new HTTPRequestError("Error is null", HTTPRequestStage.Unknown, ProxygenError.Unknown);
        }
        if (this.mHttpFlowStatistics != null) {
            if (hTTPRequestError.mErrCode == ProxygenError.Canceled) {
                this.mHttpFlowStatistics.f12002i = "cancelled";
            } else {
                this.mHttpFlowStatistics.f12002i = "error";
            }
        }
        RequestStats requestStats = this.mRequestStatsObserver.getRequestStats();
        long j = this.mLoomLogId;
        if (LoomLogger.a) {
            a = Logger.a(256, EntryType.NET_ERROR, 0, 0, j);
        } else {
            a = -1;
        }
        this.mLoomMatchId = a;
        if (requestStats != null) {
            this.mEventHandler.decorateStatistics(requestStats, this.mLoomLogId);
        }
        this.mReadState = ReadState.ERROR;
        this.mNetworkException = new HttpNetworkException(hTTPRequestError);
        if (this.mBufferInputStream != null) {
            this.mBufferInputStream.setError(this.mNetworkException);
        }
    }

    private void waitForHeaders() {
        synchronized (this.mHeadersArrivedCondition) {
            while (this.mReadState.compareTo(ReadState.HEADERS_ARRIVED) < 0) {
                try {
                    ObjectDetour.a(this.mHeadersArrivedCondition, 60000, 993321686);
                } catch (InterruptedException e) {
                }
            }
        }
        if (this.mNetworkException != null) {
            throw this.mNetworkException;
        } else if (this.mResponse == null || this.mResponse.getStatusLine() == null) {
            throw new NetworkException(this.mResponse == null ? "null response received at: " + this.mReadState : "null response status line received: " + this.mReadState);
        }
    }

    private long getContentLength(HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader("Content-Length");
        long j = -1;
        if (firstHeader != null) {
            try {
                j = Long.parseLong(firstHeader.getValue());
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }

    private void verifyState(ReadState... readStateArr) {
        boolean z;
        if (this.mReadState != ReadState.ERROR) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        boolean z2 = false;
        for (ReadState readState : readStateArr) {
            int i;
            if (this.mReadState == readState) {
                i = 1;
            } else {
                i = 0;
            }
            z2 |= i;
        }
        Preconditions.checkState(z2);
    }

    private void logException(String str, Throwable th) {
        this.mErrorReporter.m2346a(str, th);
    }
}
