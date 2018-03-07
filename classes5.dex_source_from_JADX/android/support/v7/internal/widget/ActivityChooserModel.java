package android.support.v7.internal.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.support.v4.os.AsyncTaskCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: unit_test2 */
public class ActivityChooserModel extends DataSetObservable {
    public static final String f1054a = ActivityChooserModel.class.getSimpleName();
    private static final Object f1055b = new Object();
    private static final Map<String, ActivityChooserModel> f1056c = new HashMap();
    private final Object f1057d;
    public final List<ActivityResolveInfo> f1058e;
    private final List<HistoricalRecord> f1059f;
    public final Context f1060g;
    public final String f1061h;
    public Intent f1062i;
    private ActivitySorter f1063j;
    private int f1064k;
    private boolean f1065l;
    private boolean f1066m;
    private boolean f1067n;
    public boolean f1068o;
    private OnChooseActivityListener f1069p;

    /* compiled from: unit_test2 */
    public final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        public final ResolveInfo f1047a;
        public float f1048b;
        final /* synthetic */ ActivityChooserModel f1049c;

        public final int compareTo(Object obj) {
            return Float.floatToIntBits(((ActivityResolveInfo) obj).f1048b) - Float.floatToIntBits(this.f1048b);
        }

        public ActivityResolveInfo(ActivityChooserModel activityChooserModel, ResolveInfo resolveInfo) {
            this.f1049c = activityChooserModel;
            this.f1047a = resolveInfo;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.f1048b) + 31;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            if (Float.floatToIntBits(this.f1048b) != Float.floatToIntBits(((ActivityResolveInfo) obj).f1048b)) {
                return false;
            }
            return true;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("resolveInfo:").append(this.f1047a.toString());
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.f1048b));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    /* compiled from: unit_test2 */
    public interface ActivitySorter {
    }

    /* compiled from: unit_test2 */
    public final class HistoricalRecord {
        public final ComponentName f1050a;
        public final long f1051b;
        public final float f1052c;

        public HistoricalRecord(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public HistoricalRecord(ComponentName componentName, long j, float f) {
            this.f1050a = componentName;
            this.f1051b = j;
            this.f1052c = f;
        }

        public final int hashCode() {
            return (((((this.f1050a == null ? 0 : this.f1050a.hashCode()) + 31) * 31) + ((int) (this.f1051b ^ (this.f1051b >>> 32)))) * 31) + Float.floatToIntBits(this.f1052c);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            HistoricalRecord historicalRecord = (HistoricalRecord) obj;
            if (this.f1050a == null) {
                if (historicalRecord.f1050a != null) {
                    return false;
                }
            } else if (!this.f1050a.equals(historicalRecord.f1050a)) {
                return false;
            }
            if (this.f1051b != historicalRecord.f1051b) {
                return false;
            }
            if (Float.floatToIntBits(this.f1052c) != Float.floatToIntBits(historicalRecord.f1052c)) {
                return false;
            }
            return true;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("; activity:").append(this.f1050a);
            stringBuilder.append("; time:").append(this.f1051b);
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.f1052c));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    /* compiled from: unit_test2 */
    public interface OnChooseActivityListener {
        boolean m1567a();
    }

    /* compiled from: unit_test2 */
    final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
        final /* synthetic */ ActivityChooserModel f1053a;

        public PersistHistoryAsyncTask(ActivityChooserModel activityChooserModel) {
            this.f1053a = activityChooserModel;
        }

        public final Object doInBackground(Object[] objArr) {
            int i = 0;
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                OutputStream openFileOutput = this.f1053a.f1060g.openFileOutput(str, 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    newSerializer.setOutput(openFileOutput, null);
                    newSerializer.startDocument("UTF-8", Boolean.valueOf(true));
                    newSerializer.startTag(null, "historical-records");
                    int size = list.size();
                    while (i < size) {
                        HistoricalRecord historicalRecord = (HistoricalRecord) list.remove(0);
                        newSerializer.startTag(null, "historical-record");
                        newSerializer.attribute(null, "activity", historicalRecord.f1050a.flattenToString());
                        newSerializer.attribute(null, "time", String.valueOf(historicalRecord.f1051b));
                        newSerializer.attribute(null, "weight", String.valueOf(historicalRecord.f1052c));
                        newSerializer.endTag(null, "historical-record");
                        i++;
                    }
                    newSerializer.endTag(null, "historical-records");
                    newSerializer.endDocument();
                    this.f1053a.f1065l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Throwable e2) {
                    Log.e(ActivityChooserModel.f1054a, "Error writing historical recrod file: " + this.f1053a.f1061h, e2);
                    this.f1053a.f1065l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (Throwable e22) {
                    Log.e(ActivityChooserModel.f1054a, "Error writing historical recrod file: " + this.f1053a.f1061h, e22);
                    this.f1053a.f1065l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (Throwable e222) {
                    Log.e(ActivityChooserModel.f1054a, "Error writing historical recrod file: " + this.f1053a.f1061h, e222);
                    this.f1053a.f1065l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e5) {
                        }
                    }
                } catch (Throwable th) {
                    this.f1053a.f1065l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e6) {
                        }
                    }
                }
            } catch (Throwable e2222) {
                Log.e(ActivityChooserModel.f1054a, "Error writing historical recrod file: " + str, e2222);
            }
            return null;
        }
    }

    public final int m1576a() {
        int size;
        synchronized (this.f1057d) {
            m1571e();
            size = this.f1058e.size();
        }
        return size;
    }

    public final ResolveInfo m1578a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.f1057d) {
            m1571e();
            resolveInfo = ((ActivityResolveInfo) this.f1058e.get(i)).f1047a;
        }
        return resolveInfo;
    }

    public final int m1577a(ResolveInfo resolveInfo) {
        synchronized (this.f1057d) {
            m1571e();
            List list = this.f1058e;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((ActivityResolveInfo) list.get(i)).f1047a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public final Intent m1579b(int i) {
        synchronized (this.f1057d) {
            if (this.f1062i == null) {
                return null;
            }
            m1571e();
            ActivityResolveInfo activityResolveInfo = (ActivityResolveInfo) this.f1058e.get(i);
            ComponentName componentName = new ComponentName(activityResolveInfo.f1047a.activityInfo.packageName, activityResolveInfo.f1047a.activityInfo.name);
            Intent intent = new Intent(this.f1062i);
            intent.setComponent(componentName);
            if (this.f1069p != null) {
                Intent intent2 = new Intent(intent);
                if (this.f1069p.m1567a()) {
                    return null;
                }
            }
            m1568a(new HistoricalRecord(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public final ResolveInfo m1580b() {
        synchronized (this.f1057d) {
            m1571e();
            if (this.f1058e.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((ActivityResolveInfo) this.f1058e.get(0)).f1047a;
            return resolveInfo;
        }
    }

    public final void m1581c(int i) {
        synchronized (this.f1057d) {
            float f;
            m1571e();
            ActivityResolveInfo activityResolveInfo = (ActivityResolveInfo) this.f1058e.get(i);
            ActivityResolveInfo activityResolveInfo2 = (ActivityResolveInfo) this.f1058e.get(0);
            if (activityResolveInfo2 != null) {
                f = (activityResolveInfo2.f1048b - activityResolveInfo.f1048b) + 5.0f;
            } else {
                f = 1.0f;
            }
            m1568a(new HistoricalRecord(new ComponentName(activityResolveInfo.f1047a.activityInfo.packageName, activityResolveInfo.f1047a.activityInfo.name), System.currentTimeMillis(), f));
        }
    }

    private void m1570d() {
        if (!this.f1066m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.f1067n) {
            this.f1067n = false;
            if (!TextUtils.isEmpty(this.f1061h)) {
                AsyncTaskCompat.m282a(new PersistHistoryAsyncTask(this), this.f1059f, this.f1061h);
            }
        }
    }

    private void m1571e() {
        boolean z = false;
        if (this.f1068o && this.f1062i != null) {
            this.f1068o = false;
            this.f1058e.clear();
            List queryIntentActivities = this.f1060g.getPackageManager().queryIntentActivities(this.f1062i, 0);
            int size = queryIntentActivities.size();
            for (int i = 0; i < size; i++) {
                this.f1058e.add(new ActivityResolveInfo(this, (ResolveInfo) queryIntentActivities.get(i)));
            }
            z = true;
        }
        int h = z | m1573h();
        m1574i();
        if (h != 0) {
            m1572f();
            notifyChanged();
        }
    }

    private boolean m1572f() {
        if (this.f1063j == null || this.f1062i == null || this.f1058e.isEmpty() || this.f1059f.isEmpty()) {
            return false;
        }
        Collections.unmodifiableList(this.f1059f);
        return true;
    }

    private boolean m1573h() {
        if (!this.f1065l || !this.f1067n || TextUtils.isEmpty(this.f1061h)) {
            return false;
        }
        this.f1065l = false;
        this.f1066m = true;
        m1575j();
        return true;
    }

    private boolean m1568a(HistoricalRecord historicalRecord) {
        boolean add = this.f1059f.add(historicalRecord);
        if (add) {
            this.f1067n = true;
            m1574i();
            m1570d();
            m1572f();
            notifyChanged();
        }
        return add;
    }

    private void m1574i() {
        int size = this.f1059f.size() - this.f1064k;
        if (size > 0) {
            this.f1067n = true;
            for (int i = 0; i < size; i++) {
                this.f1059f.remove(0);
            }
        }
    }

    private void m1575j() {
        try {
            InputStream openFileInput = this.f1060g.openFileInput(this.f1061h);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, null);
                int i = 0;
                while (i != 1 && i != 2) {
                    i = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List list = this.f1059f;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            break;
                        } else if (!(next == 3 || next == 4)) {
                            if ("historical-record".equals(newPullParser.getName())) {
                                list.add(new HistoricalRecord(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                            return;
                        } catch (IOException e) {
                            return;
                        }
                    }
                    return;
                }
                throw new XmlPullParserException("Share records file does not start with historical-records tag.");
            } catch (Throwable e2) {
                Log.e(f1054a, "Error reading historical recrod file: " + this.f1061h, e2);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable e22) {
                Log.e(f1054a, "Error reading historical recrod file: " + this.f1061h, e22);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e5) {
                    }
                }
            }
        } catch (FileNotFoundException e6) {
        }
    }
}
