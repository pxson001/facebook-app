package com.facebook.attribution;

/* compiled from: selfupdate_start_operation_task */
class AttributionIdService$1 implements Runnable {
    final /* synthetic */ long f2857a;
    final /* synthetic */ String f2858b;
    final /* synthetic */ AttributionIdService f2859c;

    AttributionIdService$1(AttributionIdService attributionIdService, long j, String str) {
        this.f2859c = attributionIdService;
        this.f2857a = j;
        this.f2858b = str;
    }

    public void run() {
        AttributionIdService.a(this.f2859c, this.f2857a, this.f2858b);
    }
}
