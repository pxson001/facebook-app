package com.facebook.facerec.job;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.debug.log.BLog;
import com.facebook.facerec.manager.FaceRecManager.TagSuggestFetchCompletedListener;
import com.facebook.facerec.manager.FaceRecManager.TagSuggestFetchCompletedListenerImpl;
import com.facebook.facerec.manager.FaceRecManager.TagSuggestFetchCompletedListenerImpl.C05992;
import com.facebook.facerec.manager.LocalSuggestionsStore;
import com.facebook.facerec.recog.FaceRecMethod;
import com.facebook.facerec.recog.FaceRecParams;
import com.facebook.facerec.recog.FaceRecResponse;
import com.facebook.http.protocol.ApiMethodRunner;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.http.protocol.HttpRequestAbortHandler;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.photos.base.tagging.FaceBox;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: notify_when_processed */
public class TagSuggestFetchJob implements Runnable {
    private final TagSuggestFetchCompletedListenerImpl f9843a;
    private final DefaultAndroidThreadUtil f9844b;
    private final AbstractFbErrorReporter f9845c;
    private final ApiMethodRunnerImpl f9846d;
    public final List<FaceBox> f9847e;
    private final PerformanceLogger f9848f;
    private final LocalSuggestionsStore f9849g;
    private final String f9850h;
    private final long f9851i;
    private HttpRequestAbortHandler f9852j = new HttpRequestAbortHandler();
    private volatile boolean f9853k = false;
    private ReentrantLock f9854l = new ReentrantLock();

    public TagSuggestFetchJob(TagSuggestFetchCompletedListener tagSuggestFetchCompletedListener, AndroidThreadUtil androidThreadUtil, FbErrorReporter fbErrorReporter, ApiMethodRunner apiMethodRunner, List<FaceBox> list, PerformanceLogger performanceLogger, LocalSuggestionsStore localSuggestionsStore, String str, long j) {
        this.f9843a = tagSuggestFetchCompletedListener;
        this.f9844b = androidThreadUtil;
        this.f9845c = fbErrorReporter;
        this.f9846d = apiMethodRunner;
        this.f9847e = list;
        this.f9848f = performanceLogger;
        this.f9849g = localSuggestionsStore;
        this.f9850h = str;
        this.f9851i = j;
    }

    public void run() {
        this.f9844b.b();
        this.f9854l.lock();
        try {
            if (this.f9853k) {
                new StringBuilder().append(this.f9851i).append(": abort request, I'm going home");
                return;
            }
            List<FaceBox> b = m15593b();
            if (b.size() == 0) {
                m15594c();
                m15592a();
                this.f9854l.unlock();
                return;
            }
            for (FaceBox o : b) {
                if (o.m20169o()) {
                    new StringBuilder().append(this.f9851i).append(": suggestions already present, aborting");
                    m15592a();
                    this.f9854l.unlock();
                    return;
                }
            }
            ApiMethodRunnerParams apiMethodRunnerParams = new ApiMethodRunnerParams();
            apiMethodRunnerParams.a(this.f9852j);
            FaceRecParams faceRecParams = new FaceRecParams(this.f9845c, b, this.f9850h);
            try {
                this.f9848f.d(3866625, "FaceRecServerCommunication");
                new StringBuilder("Sending ").append(b.size()).append(" crops for photo ").append(this.f9850h);
                for (FaceBox o2 : b) {
                    Object valueOf;
                    StringBuilder append = new StringBuilder("Crop with width: ").append(o2.m20165k()).append(" height: ").append(o2.m20166l()).append(" byte size: ");
                    if (o2.m20164j() != null) {
                        valueOf = Integer.valueOf(o2.m20164j().length);
                    } else {
                        valueOf = null;
                    }
                    append.append(valueOf);
                }
                List a = m15591a((FaceRecResponse) this.f9846d.a(new FaceRecMethod(this.f9849g, this.f9848f), faceRecParams, apiMethodRunnerParams));
                this.f9848f.c(3866625, "FaceRecServerCommunication");
                this.f9843a.m15620a(a);
            } catch (NullPointerException e) {
                throw e;
            } catch (Throwable e2) {
                this.f9848f.a(3866625, "FaceRecServerCommunication");
                if (!this.f9853k) {
                    BLog.b("TagSuggestFetchJob", "aborting", e2);
                    this.f9845c.a("TagSuggestFetchJob", "FaceRecMethod threw an exception", e2);
                }
                m15594c();
            }
            m15592a();
            this.f9854l.unlock();
        } finally {
            m15592a();
            this.f9854l.unlock();
        }
    }

    private void m15592a() {
        for (FaceBox faceBox : this.f9847e) {
            faceBox.f12774j = null;
        }
    }

    private List<FaceBox> m15593b() {
        List<FaceBox> a = Lists.a();
        for (FaceBox faceBox : this.f9847e) {
            if (faceBox.f12774j != null) {
                a.add(faceBox);
            }
        }
        return a;
    }

    private void m15594c() {
        TagSuggestFetchCompletedListenerImpl tagSuggestFetchCompletedListenerImpl = this.f9843a;
        List a = Lists.a();
        for (FaceBox faceBox : this.f9847e) {
            a.add(new FaceBox(faceBox.f12766b, new ArrayList(), false));
        }
        tagSuggestFetchCompletedListenerImpl.m15620a(a);
    }

    private List<FaceBox> m15591a(FaceRecResponse faceRecResponse) {
        List<FaceBox> a = Lists.a();
        Map map = faceRecResponse.f9951b;
        for (FaceBox faceBox : this.f9847e) {
            String str = faceBox.f12765a;
            if (map.keySet().contains(str)) {
                List list = (List) map.get(str);
                if (list.isEmpty()) {
                    list = new ArrayList();
                }
                a.add(new FaceBox(faceBox.f12766b, list, false));
            } else {
                a.add(new FaceBox(faceBox.f12766b, new ArrayList(), false));
            }
        }
        return a;
    }

    public final void m15595a(boolean z, boolean z2) {
        this.f9844b.b();
        if (this.f9854l.tryLock()) {
            this.f9853k = true;
            new StringBuilder("marking ").append(this.f9851i).append(" to no-op");
            this.f9854l.unlock();
        } else if (this.f9852j == null || !z) {
            new StringBuilder().append(this.f9851i).append(": network request in progress, ignoring abort request");
        } else {
            this.f9852j.a();
            TagSuggestFetchCompletedListenerImpl tagSuggestFetchCompletedListenerImpl = this.f9843a;
            HandlerDetour.a(tagSuggestFetchCompletedListenerImpl.f9880a.f9887e, new C05992(tagSuggestFetchCompletedListenerImpl, z2), -1953852334);
        }
    }
}
