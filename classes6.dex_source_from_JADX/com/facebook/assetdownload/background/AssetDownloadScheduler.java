package com.facebook.assetdownload.background;

import com.facebook.assetdownload.AssetDownloadConfiguration;
import com.facebook.assetdownload.AssetDownloadConfiguration.ConnectionConstraint;
import com.facebook.assetdownload.repository.AssetDownloadConfigurationRepository;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import java.util.Comparator;
import java.util.TreeSet;
import javax.inject.Inject;

/* compiled from: profile_question_save */
public class AssetDownloadScheduler {
    private final AssetDownloadConfigurationRepository f7295a;
    private final Clock f7296b;
    private TreeSet<AssetDownloadConfiguration> f7297c;
    private TreeSet<AssetDownloadConfiguration> f7298d;
    private boolean f7299e = false;
    private boolean f7300f = false;

    /* compiled from: profile_question_save */
    class ConfigurationPriorityComparator<T> implements Comparator<AssetDownloadConfiguration> {
        public int compare(Object obj, Object obj2) {
            AssetDownloadConfiguration assetDownloadConfiguration = (AssetDownloadConfiguration) obj;
            AssetDownloadConfiguration assetDownloadConfiguration2 = (AssetDownloadConfiguration) obj2;
            int i = assetDownloadConfiguration.mPriority;
            int i2 = assetDownloadConfiguration2.mPriority;
            if (i != i2) {
                return i - i2;
            }
            return assetDownloadConfiguration.mIdentifier.compareToIgnoreCase(assetDownloadConfiguration2.mIdentifier);
        }
    }

    public static AssetDownloadScheduler m10415b(InjectorLike injectorLike) {
        return new AssetDownloadScheduler(AssetDownloadConfigurationRepository.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public AssetDownloadScheduler(AssetDownloadConfigurationRepository assetDownloadConfigurationRepository, Clock clock) {
        this.f7295a = assetDownloadConfigurationRepository;
        this.f7296b = clock;
        this.f7298d = Sets.a(new ConfigurationPriorityComparator());
        this.f7297c = Sets.a(new ConfigurationPriorityComparator());
    }

    public final synchronized AssetDownloadConfiguration m10416a(boolean z) {
        AssetDownloadConfiguration assetDownloadConfiguration;
        AssetDownloadConfiguration assetDownloadConfiguration2;
        m10414a();
        if (!z || this.f7297c.isEmpty()) {
            assetDownloadConfiguration2 = null;
        } else {
            assetDownloadConfiguration2 = (AssetDownloadConfiguration) this.f7297c.last();
        }
        if (this.f7298d.isEmpty()) {
            assetDownloadConfiguration = null;
        } else {
            assetDownloadConfiguration = (AssetDownloadConfiguration) this.f7298d.last();
        }
        if (assetDownloadConfiguration2 == null && assetDownloadConfiguration == null) {
            assetDownloadConfiguration = null;
        } else if (assetDownloadConfiguration2 != null) {
            if (assetDownloadConfiguration == null) {
                assetDownloadConfiguration = assetDownloadConfiguration2;
            } else if (assetDownloadConfiguration2.m10374b() > assetDownloadConfiguration.m10374b()) {
                assetDownloadConfiguration = assetDownloadConfiguration2;
            }
        }
        return assetDownloadConfiguration;
    }

    public final synchronized boolean m10417a(AssetDownloadConfiguration assetDownloadConfiguration) {
        boolean z;
        z = this.f7298d.remove(assetDownloadConfiguration) || this.f7297c.remove(assetDownloadConfiguration);
        return z;
    }

    private void m10414a() {
        if (this.f7297c.isEmpty() && !this.f7299e) {
            ImmutableList a = this.f7295a.a(8, ConnectionConstraint.MUST_BE_WIFI, this.f7296b.a() - 4233600000L, this.f7296b.a() - 259200000, this.f7296b.a());
            this.f7297c.addAll(a);
            this.f7299e = a.isEmpty();
        }
        if (this.f7298d.isEmpty() && !this.f7300f) {
            a = this.f7295a.a(8, ConnectionConstraint.CAN_BE_ANY, this.f7296b.a() - 4233600000L, this.f7296b.a() - 259200000, this.f7296b.a());
            this.f7298d.addAll(a);
            this.f7300f = a.isEmpty();
        }
    }
}
