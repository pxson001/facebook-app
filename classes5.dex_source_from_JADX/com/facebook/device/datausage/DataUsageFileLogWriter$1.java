package com.facebook.device.datausage;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: score_text */
class DataUsageFileLogWriter$1 implements Runnable {
    final /* synthetic */ String f2913a;
    final /* synthetic */ DataUsageFileLogWriter f2914b;

    DataUsageFileLogWriter$1(DataUsageFileLogWriter dataUsageFileLogWriter, String str) {
        this.f2914b = dataUsageFileLogWriter;
        this.f2913a = str;
    }

    public void run() {
        try {
            String format = new SimpleDateFormat("MM-dd HH:mm:ss").format(new Date());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(format);
            stringBuilder.append(" : ");
            stringBuilder.append(this.f2913a);
            stringBuilder.append(" : ");
            stringBuilder.append(Thread.currentThread().getName() + "\n");
            Files.b(stringBuilder.toString(), this.f2914b.d, Charsets.UTF_8);
        } catch (IOException e) {
        }
    }
}
