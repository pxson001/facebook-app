package com.facebook.abtest.qe.bugreport;

import com.facebook.abtest.qe.bootstrap.utils.ExperimentData;
import com.facebook.abtest.qe.bootstrap.utils.QuickExperimentUtil;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFile;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFileFormatter;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFileProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import javax.inject.Inject;

/* compiled from: total_posts */
public class QuickExperimentFileProvider implements BugReportFileProvider {
    public final QuickExperimentUtil f1720a;

    @Inject
    public QuickExperimentFileProvider(QuickExperimentUtil quickExperimentUtil) {
        this.f1720a = quickExperimentUtil;
    }

    public List<BugReportFile> getFilesFromWorkerThread(File file) {
        List<BugReportFile> a = Lists.a();
        ImmutableList<ExperimentData> a2 = this.f1720a.m2365a();
        LinkedHashMap d = Maps.d();
        for (ExperimentData experimentData : a2) {
            d.put(experimentData.name, experimentData.m2360c());
        }
        LinkedHashMap linkedHashMap = d;
        if (!linkedHashMap.isEmpty()) {
            a.add(BugReportFileFormatter.m10145a(file, "quick_experiment_pairs.txt", linkedHashMap));
        }
        return a;
    }
}
