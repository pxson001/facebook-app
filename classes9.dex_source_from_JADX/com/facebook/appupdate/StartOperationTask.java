package com.facebook.appupdate;

import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.net.Uri;
import com.facebook.appupdate.AppUpdateState.Builder;
import javax.inject.Provider;

/* compiled from: UNEDITED_DATA */
public class StartOperationTask implements AppUpdateTask {
    private final DownloadManager f23826a;
    private final Provider<String> f23827b;
    private final Provider<String> f23828c;

    public StartOperationTask(DownloadManager downloadManager, Provider<String> provider, Provider<String> provider2) {
        this.f23826a = downloadManager;
        this.f23827b = provider;
        this.f23828c = provider2;
    }

    public final AppUpdateTaskResult mo1098a(AppUpdateState appUpdateState) {
        Uri parse = Uri.parse(appUpdateState.releaseInfo.downloadUri);
        Request request = new Request(parse);
        if (parse.getHost().endsWith(".facebook.com")) {
            request.addRequestHeader("Authorization", "OAuth " + ((String) this.f23827b.get()));
        }
        request.addRequestHeader("User-Agent", (String) this.f23828c.get());
        if (appUpdateState.isBackgroundMode) {
            request.setNotificationVisibility(2);
        } else {
            request.setNotificationVisibility(0);
            request.setTitle("Downloading update");
            request.setDescription(appUpdateState.releaseInfo.appName);
        }
        if (appUpdateState.isWifiOnly) {
            request.setAllowedNetworkTypes(2);
        }
        long enqueue = this.f23826a.enqueue(request);
        Builder builder = new Builder(appUpdateState);
        builder.f23806c = 2;
        builder = builder;
        builder.f23807d = enqueue;
        return new AppUpdateTaskResult(builder.m25818a());
    }
}
