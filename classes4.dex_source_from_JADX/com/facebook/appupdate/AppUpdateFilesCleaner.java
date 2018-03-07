package com.facebook.appupdate;

import com.facebook.selfupdate.AppUpdateLoggerFbImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: friendListOptions */
public class AppUpdateFilesCleaner implements Runnable {
    private final AppUpdateFilesManager f11414a;
    private final AppUpdateLoggerFbImpl f11415b;
    private final AppUpdateOperationFactory f11416c;

    public AppUpdateFilesCleaner(AppUpdateFilesManager appUpdateFilesManager, AppUpdateLoggerFbImpl appUpdateLoggerFbImpl, AppUpdateOperationFactory appUpdateOperationFactory) {
        this.f11414a = appUpdateFilesManager;
        this.f11415b = appUpdateLoggerFbImpl;
        this.f11416c = appUpdateOperationFactory;
    }

    public void run() {
        Preconditions.b();
        Collection arrayList = new ArrayList();
        for (AppUpdateOperation c : this.f11416c.c()) {
            File file = c.c().localFile;
            if (file != null) {
                arrayList.add(file);
            }
        }
        try {
            this.f11414a.a(arrayList);
        } catch (Throwable e) {
            this.f11415b.a("appupdate_error_ioexception_cleaning_files", null, e);
        }
    }
}
