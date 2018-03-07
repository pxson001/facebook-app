package com.facebook.gk.internal;

import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFile;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFileFormatter;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFileProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: mSrcUrlSmallWebp */
public class GatekeeperFileProvider implements BugReportFileProvider {
    private final GatekeeperStoreImpl f10880a;

    @Inject
    public GatekeeperFileProvider(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f10880a = gatekeeperStoreImpl;
    }

    public List<BugReportFile> getFilesFromWorkerThread(File file) {
        List<BugReportFile> arrayList = new ArrayList();
        Map a = this.f10880a.a();
        if (!a.isEmpty()) {
            arrayList.add(BugReportFileFormatter.a(file, "gatekeeper_pairs.txt", a));
        }
        return arrayList;
    }
}
