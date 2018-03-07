package com.facebook.datasensitivity;

import android.content.Context;
import android.preference.PreferenceCategory;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.device.datausage.DataUsageSyncer;
import com.facebook.device.datausage.DateProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.progressiveimagequality.datausage.CompressionSavingsStorageHandler;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.inject.Inject;

/* compiled from: a */
public class DataSavingsDebuggingLogsPreference extends PreferenceCategory {
    private final String f11750a = DataSavingsDebuggingLogsPreference.class.getName();
    private final String f11751b = "retreive_employee_logs_for_data_sensitivity";
    private final Context f11752c;
    private final TasksManager f11753d;
    private final ListeningExecutorService f11754e;
    private final DataUsageSyncer f11755f;
    private final CompressionSavingsStorageHandler f11756g;
    private final DateProvider f11757h;
    private final AbstractFbErrorReporter f11758i;

    private static DataSavingsDebuggingLogsPreference m19794b(InjectorLike injectorLike) {
        return new DataSavingsDebuggingLogsPreference((Context) injectorLike.getInstance(Context.class), TasksManager.b(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), DataUsageSyncer.a(injectorLike), CompressionSavingsStorageHandler.a(injectorLike), DateProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public DataSavingsDebuggingLogsPreference(Context context, TasksManager tasksManager, ListeningExecutorService listeningExecutorService, DataUsageSyncer dataUsageSyncer, CompressionSavingsStorageHandler compressionSavingsStorageHandler, DateProvider dateProvider, AbstractFbErrorReporter abstractFbErrorReporter) {
        super(context);
        this.f11752c = context;
        this.f11753d = tasksManager;
        this.f11754e = listeningExecutorService;
        this.f11755f = dataUsageSyncer;
        this.f11756g = compressionSavingsStorageHandler;
        this.f11757h = dateProvider;
        this.f11758i = abstractFbErrorReporter;
    }
}
