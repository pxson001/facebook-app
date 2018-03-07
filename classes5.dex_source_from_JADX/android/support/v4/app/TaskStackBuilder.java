package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: wakelock_power */
public class TaskStackBuilder implements Iterable<Intent> {
    private static final TaskStackBuilderImpl f209a;
    public final ArrayList<Intent> f210b = new ArrayList();
    private final Context f211c;

    /* compiled from: wakelock_power */
    public interface SupportParentable {
        Intent m214a();
    }

    /* compiled from: wakelock_power */
    interface TaskStackBuilderImpl {
    }

    /* compiled from: wakelock_power */
    class TaskStackBuilderImplBase implements TaskStackBuilderImpl {
        TaskStackBuilderImplBase() {
        }
    }

    /* compiled from: wakelock_power */
    class TaskStackBuilderImplHoneycomb implements TaskStackBuilderImpl {
        TaskStackBuilderImplHoneycomb() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f209a = new TaskStackBuilderImplHoneycomb();
        } else {
            f209a = new TaskStackBuilderImplBase();
        }
    }

    private TaskStackBuilder(Context context) {
        this.f211c = context;
    }

    public static TaskStackBuilder m216a(Context context) {
        return new TaskStackBuilder(context);
    }

    public final TaskStackBuilder m218a(Activity activity) {
        Intent a;
        Intent intent = null;
        if (activity instanceof SupportParentable) {
            intent = ((SupportParentable) activity).m214a();
        }
        if (intent == null) {
            a = NavUtils.m117a(activity);
        } else {
            a = intent;
        }
        if (a != null) {
            ComponentName component = a.getComponent();
            if (component == null) {
                component = a.resolveActivity(this.f211c.getPackageManager());
            }
            m215a(component);
            this.f210b.add(a);
        }
        return this;
    }

    private TaskStackBuilder m215a(ComponentName componentName) {
        int size = this.f210b.size();
        try {
            Intent a = NavUtils.m118a(this.f211c, componentName);
            while (a != null) {
                this.f210b.add(size, a);
                a = NavUtils.m118a(this.f211c, a.getComponent());
            }
            return this;
        } catch (Throwable e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public Iterator<Intent> iterator() {
        return this.f210b.iterator();
    }

    public final void m219a() {
        m217a(null);
    }

    private void m217a(Bundle bundle) {
        if (this.f210b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f210b.toArray(new Intent[this.f210b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        Context context = this.f211c;
        Object obj = 1;
        int i = VERSION.SDK_INT;
        if (i >= 16) {
            context.startActivities(intentArr, bundle);
        } else if (i >= 11) {
            context.startActivities(intentArr);
        } else {
            obj = null;
        }
        if (obj == null) {
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            this.f211c.startActivity(intent);
        }
    }
}
