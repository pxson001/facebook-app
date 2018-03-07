package com.facebook.video.engine;

/* compiled from: composer_updated_story_in_db */
public class SoftReportSender$1 implements Runnable {
    final /* synthetic */ SoftReportSender f18827a;

    public SoftReportSender$1(SoftReportSender softReportSender) {
        this.f18827a = softReportSender;
    }

    public void run() {
        this.f18827a.l = false;
        SoftReportSender.a(this.f18827a);
    }
}
