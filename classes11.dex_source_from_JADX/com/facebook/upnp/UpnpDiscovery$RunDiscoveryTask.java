package com.facebook.upnp;

import com.facebook.common.executors.FbAsyncTask;
import com.facebook.http.common.FbHttpRequestProcessor;
import java.net.InetAddress;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: navigation_title */
public class UpnpDiscovery$RunDiscoveryTask extends FbAsyncTask<InetAddress, Void, Void> {
    final /* synthetic */ UpnpDiscovery f5268a;

    public UpnpDiscovery$RunDiscoveryTask(UpnpDiscovery upnpDiscovery) {
        this.f5268a = upnpDiscovery;
    }

    protected final Object m6522a(Object[] objArr) {
        InetAddress[] inetAddressArr = (InetAddress[]) objArr;
        synchronized (UpnpDiscovery.class) {
            if (UpnpDiscovery.k) {
            } else {
                UpnpDiscovery.a(true);
                long a = this.f5268a.j.a();
                UpnpDiscoverySocket upnpDiscoverySocket = new UpnpDiscoverySocket(15, inetAddressArr[0]);
                List<UpnpDevice> linkedList = new LinkedList();
                if (upnpDiscoverySocket.m6523a()) {
                    List<List> b = upnpDiscoverySocket.m6524b();
                    Map treeMap = new TreeMap();
                    for (List a2 : b) {
                        UpnpDevice a3 = UpnpDevice.m6513a(a2);
                        if (a3.m6516a() != null) {
                            if (treeMap.containsKey(a3.m6516a())) {
                                ((UpnpDevice) treeMap.get(a3.m6516a())).m6518a(a3);
                            } else {
                                treeMap.put(a3.m6516a(), a3);
                            }
                        }
                    }
                    for (UpnpDevice upnpDevice : treeMap.values()) {
                        if (upnpDevice.m6517a((FbHttpRequestProcessor) this.f5268a.d.get())) {
                            linkedList.add(upnpDevice);
                        }
                    }
                }
                for (UpnpDevice upnpDevice2 : linkedList) {
                    UpnpDiscovery.a(this.f5268a, upnpDevice2, a);
                    UpnpDiscovery.c();
                    upnpDevice2.f5267g.get("friendlyName");
                    upnpDevice2.f5267g.get("manufacturer");
                    upnpDevice2.f5267g.get("modelName");
                    upnpDevice2.f5267g.get("modelNumber");
                }
                synchronized (UpnpDiscovery.class) {
                    UpnpDiscovery.a(false);
                }
            }
        }
        return null;
    }
}
