package com.facebook.proxygen;

import com.facebook.http.observer.ConnectionQuality;
import com.facebook.http.observer.HttpFlowStatistics;
import com.facebook.http.observer.NetworkInfoCollector;
import com.facebook.http.performancelistener.CellTowerInfoHelper;
import org.apache.http.protocol.HttpContext;

/* compiled from: protocol */
public interface TraceEventHandlerFactory {
    TraceEventHandler create(String str, HttpContext httpContext, ConnectionQuality connectionQuality, HttpFlowStatistics httpFlowStatistics, LigerSamplePolicy ligerSamplePolicy, CellTowerInfoHelper cellTowerInfoHelper, NetworkInfoCollector networkInfoCollector);
}
