package com.facebook.widget.viewdiagnostics;

import com.facebook.analytics.logger.HoneyClientEvent;

/* compiled from: question_remove_vote */
public class ViewDiagnostics$ReportEventRunnable implements Runnable {
    final /* synthetic */ ViewDiagnostics f6278a;
    private HoneyClientEvent f6279b;

    public ViewDiagnostics$ReportEventRunnable(ViewDiagnostics viewDiagnostics, HoneyClientEvent honeyClientEvent) {
        this.f6278a = viewDiagnostics;
        this.f6279b = honeyClientEvent;
    }

    public void run() {
        this.f6278a.c.a(this.f6279b);
    }
}
