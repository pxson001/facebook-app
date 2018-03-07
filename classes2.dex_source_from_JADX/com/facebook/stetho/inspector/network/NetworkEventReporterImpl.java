package com.facebook.stetho.inspector.network;

/* compiled from: register_push_no_user */
public class NetworkEventReporterImpl {
    private static NetworkEventReporterImpl f7780a;

    private NetworkEventReporterImpl() {
    }

    public static synchronized NetworkEventReporterImpl m12320b() {
        NetworkEventReporterImpl networkEventReporterImpl;
        synchronized (NetworkEventReporterImpl.class) {
            if (f7780a == null) {
                f7780a = new NetworkEventReporterImpl();
            }
            networkEventReporterImpl = f7780a;
        }
        return networkEventReporterImpl;
    }
}
