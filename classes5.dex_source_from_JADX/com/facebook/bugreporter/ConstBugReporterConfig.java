package com.facebook.bugreporter;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.bugreporter.activity.categorylist.CategoryInfo;
import com.facebook.bugreporter.activity.chooser.ChooserOption;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: android.media.metadata.GENRE */
public class ConstBugReporterConfig implements Parcelable, BugReporterConfig {
    public static final Creator<ConstBugReporterConfig> CREATOR = new C10181();
    private final ImmutableList<CategoryInfo> f10640a;
    private final ImmutableList<ChooserOption> f10641b;

    /* compiled from: android.media.metadata.GENRE */
    final class C10181 implements Creator<ConstBugReporterConfig> {
        C10181() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ConstBugReporterConfig(parcel);
        }

        public final Object[] newArray(int i) {
            return new ConstBugReporterConfig[i];
        }
    }

    public static ConstBugReporterConfig m18663a(BugReporterConfig bugReporterConfig) {
        if (bugReporterConfig instanceof ConstBugReporterConfig) {
            return (ConstBugReporterConfig) bugReporterConfig;
        }
        return new ConstBugReporterConfig(bugReporterConfig);
    }

    private ConstBugReporterConfig(BugReporterConfig bugReporterConfig) {
        this.f10640a = bugReporterConfig.mo1120a();
        this.f10641b = bugReporterConfig.mo1121b();
    }

    public ConstBugReporterConfig(Parcel parcel) {
        this.f10640a = ImmutableList.copyOf(parcel.createTypedArrayList(CategoryInfo.CREATOR));
        this.f10641b = ImmutableList.copyOf(parcel.createTypedArray(ChooserOption.CREATOR));
    }

    public final ImmutableList<CategoryInfo> mo1120a() {
        return this.f10640a;
    }

    public final ImmutableList<ChooserOption> mo1121b() {
        return this.f10641b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f10640a);
        parcel.writeTypedList(this.f10641b);
    }
}
