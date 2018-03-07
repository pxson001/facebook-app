package com.facebook.funnellogger.beacon;

/* compiled from: dbl */
class BeaconLogger$1 implements Runnable {
    final /* synthetic */ BeaconLogger$BeaconType f14195a;
    final /* synthetic */ BeaconLogger f14196b;

    BeaconLogger$1(BeaconLogger beaconLogger, BeaconLogger$BeaconType beaconLogger$BeaconType) {
        this.f14196b = beaconLogger;
        this.f14195a = beaconLogger$BeaconType;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r7 = this;
        r6 = 0;
        r5 = 1;
        r1 = com.facebook.funnellogger.beacon.BeaconLogger.class;
        monitor-enter(r1);
        r0 = r7.f14195a;	 Catch:{ all -> 0x0065 }
        r0 = r0.beaconIdGenerator;	 Catch:{ all -> 0x0065 }
        if (r0 != 0) goto L_0x001e;
    L_0x000b:
        r0 = r7.f14196b;	 Catch:{ all -> 0x0065 }
        r2 = r7.f14195a;	 Catch:{ all -> 0x0065 }
        r0 = com.facebook.funnellogger.beacon.BeaconLogger.b(r0, r2);	 Catch:{ all -> 0x0065 }
        if (r0 == 0) goto L_0x0050;
    L_0x0015:
        r2 = r7.f14195a;	 Catch:{ all -> 0x0065 }
        r3 = new com.facebook.analytics2.beacon.idgenerator.BeaconIdGenerator;	 Catch:{ all -> 0x0065 }
        r3.<init>(r0);	 Catch:{ all -> 0x0065 }
        r2.beaconIdGenerator = r3;	 Catch:{ all -> 0x0065 }
    L_0x001e:
        monitor-exit(r1);	 Catch:{ all -> 0x0065 }
        r0 = r7.f14195a;
        r0 = r0.beaconIdGenerator;
        r0 = r0.a();
        r2 = r7.f14196b;	 Catch:{ Exception -> 0x0068 }
        r2 = r2.b;	 Catch:{ Exception -> 0x0068 }
        r3 = r7.f14195a;	 Catch:{ Exception -> 0x0068 }
        r3 = r3.name;	 Catch:{ Exception -> 0x0068 }
        r4 = 1;
        r2 = r2.a(r3, r4);	 Catch:{ Exception -> 0x0068 }
        r3 = r2.a();	 Catch:{ Exception -> 0x0068 }
        if (r3 == 0) goto L_0x004f;
    L_0x003a:
        r3 = "beacon_id";
        r4 = com.facebook.analytics2.beacon.idgenerator.BeaconIdGenerator.a(r0);	 Catch:{ Exception -> 0x0068 }
        r2.a(r3, r4);	 Catch:{ Exception -> 0x0068 }
        r3 = "beacon_session_id";
        r0 = com.facebook.analytics2.beacon.idgenerator.BeaconIdGenerator.b(r0);	 Catch:{ Exception -> 0x0068 }
        r2.a(r3, r0);	 Catch:{ Exception -> 0x0068 }
        r2.b();	 Catch:{ Exception -> 0x0068 }
    L_0x004f:
        return;
    L_0x0050:
        r0 = com.facebook.funnellogger.beacon.BeaconLogger.a;	 Catch:{  }
        r2 = "Couldn't create %s beacon directory";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{  }
        r4 = 0;
        r5 = r7.f14195a;	 Catch:{  }
        r5 = r5.name();	 Catch:{  }
        r3[r4] = r5;	 Catch:{  }
        com.facebook.debug.log.BLog.b(r0, r2, r3);	 Catch:{  }
        monitor-exit(r1);	 Catch:{  }
        goto L_0x004f;
    L_0x0065:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;
    L_0x0068:
        r0 = move-exception;
        r1 = com.facebook.funnellogger.beacon.BeaconLogger.a;
        r2 = "Couldn't log %s event";
        r3 = new java.lang.Object[r5];
        r4 = r7.f14195a;
        r4 = r4.name;
        r3[r6] = r4;
        com.facebook.debug.log.BLog.b(r1, r0, r2, r3);
        goto L_0x004f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.funnellogger.beacon.BeaconLogger$1.run():void");
    }
}
