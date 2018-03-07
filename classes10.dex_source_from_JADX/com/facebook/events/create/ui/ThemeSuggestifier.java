package com.facebook.events.create.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore.Files;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.events.create.ui.ThemeSuggestifierOptionViewHolder.OnOptionSelectedListener;
import com.facebook.events.ui.themeselector.protocol.EventsThemeSelectorGraphQL;
import com.facebook.events.ui.themeselector.protocol.EventsThemeSelectorGraphQL.EventsThemeSuggestionsString;
import com.facebook.events.ui.themeselector.protocol.EventsThemeSelectorGraphQLModels.EventsThemeSuggestionsModel;
import com.facebook.graphql.calls.EventThemeEventInfoInputData.EventInfo;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.hscrollrecyclerview.HScrollLinearLayoutManager;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: composer_open_sticker_tray */
public class ThemeSuggestifier extends CustomLinearLayout {
    private static final String[] f16401g = new String[]{"date_added", "_data"};
    private static final String f16402h = StringFormatUtil.a("%s = %d AND (LOWER(%s) LIKE '%%dcim%%' or LOWER(%s) LIKE '%%camera%%')", new Object[]{"media_type", Integer.valueOf(1), "_data", "_data"});
    @Inject
    GraphQLQueryExecutor f16403a;
    @Inject
    TasksManager f16404b;
    @Inject
    HScrollLinearLayoutManager f16405c;
    @Inject
    Context f16406d;
    @Inject
    RuntimePermissionsUtil f16407e;
    private final Uri f16408f = Files.getContentUri("external");
    private HScrollRecyclerView f16409i;
    public ThemeSuggestifierAdapter f16410j;
    private FbTextView f16411k;
    public boolean f16412l = true;
    private boolean f16413m;
    private ValueAnimator f16414n;

    /* compiled from: composer_open_sticker_tray */
    class C22871 implements OnClickListener {
        final /* synthetic */ ThemeSuggestifier f16397a;

        C22871(ThemeSuggestifier themeSuggestifier) {
            this.f16397a = themeSuggestifier;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1239154779);
            this.f16397a.f16412l = false;
            ThemeSuggestifier.getThemeSuggestifierAnimator(this.f16397a).reverse();
            Logger.a(2, EntryType.UI_INPUT_END, 1277839444, a);
        }
    }

    /* compiled from: composer_open_sticker_tray */
    class C22882 extends AbstractDisposableFutureCallback<GraphQLResult<EventsThemeSuggestionsModel>> {
        final /* synthetic */ ThemeSuggestifier f16398a;

        C22882(ThemeSuggestifier themeSuggestifier) {
            this.f16398a = themeSuggestifier;
        }

        protected final void m16855a(Object obj) {
            EventsThemeSuggestionsModel eventsThemeSuggestionsModel = (EventsThemeSuggestionsModel) ((GraphQLResult) obj).e;
            if (eventsThemeSuggestionsModel != null && eventsThemeSuggestionsModel.m19864a() != null) {
                this.f16398a.f16410j.m16874a(eventsThemeSuggestionsModel.m19864a().m19859a());
            }
        }

        protected final void m16856a(Throwable th) {
        }
    }

    private static <T extends View> void m16859a(Class<T> cls, T t) {
        m16860a((Object) t, t.getContext());
    }

    private static void m16860a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ThemeSuggestifier) obj).m16858a(GraphQLQueryExecutor.a(fbInjector), TasksManager.b(fbInjector), HScrollLinearLayoutManager.b(fbInjector), (Context) fbInjector.getInstance(Context.class), RuntimePermissionsUtil.b(fbInjector));
    }

    private void m16858a(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, HScrollLinearLayoutManager hScrollLinearLayoutManager, Context context, RuntimePermissionsUtil runtimePermissionsUtil) {
        this.f16403a = graphQLQueryExecutor;
        this.f16404b = tasksManager;
        this.f16405c = hScrollLinearLayoutManager;
        this.f16406d = context;
        this.f16407e = runtimePermissionsUtil;
    }

    public ThemeSuggestifier(Context context) {
        super(context);
        m16864b();
    }

    public ThemeSuggestifier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16864b();
    }

    public ThemeSuggestifier(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16864b();
    }

    private void m16864b() {
        m16859a(ThemeSuggestifier.class, (View) this);
        setContentView(2130904102);
        setOrientation(1);
        this.f16409i = (HScrollRecyclerView) a(2131561430);
        m16865c();
        this.f16410j = new ThemeSuggestifierAdapter(getContext(), Drawable.createFromPath(getPhotoUploadOptionImageUriString()), getContext().getResources().getDrawable(2130839535));
        this.f16405c.b(0);
        this.f16409i.setLayoutManager(this.f16405c);
        this.f16409i.setAdapter(this.f16410j);
    }

    public void setOnOptionSelectedListener(OnOptionSelectedListener onOptionSelectedListener) {
        if (this.f16410j != null) {
            this.f16410j.f16422h = onOptionSelectedListener;
        }
    }

    private void m16865c() {
        this.f16411k = (FbTextView) a(2131561431);
        this.f16411k.setOnClickListener(new C22871(this));
    }

    private EventsThemeSuggestionsString m16863b(String str, String str2) {
        EventsThemeSuggestionsString a = EventsThemeSelectorGraphQL.m19804a();
        a.a("full_width", Integer.valueOf(1));
        a.a("full_height", Integer.valueOf(getResources().getDimensionPixelSize(2131431119)));
        a.a("half_width", Integer.valueOf(1));
        a.a("half_height", Integer.valueOf(getResources().getDimensionPixelSize(2131431119)));
        a.a("count", Integer.valueOf(5));
        if (!(str == null && str2 == null)) {
            EventInfo eventInfo = new EventInfo();
            eventInfo.a(str).b(str2);
            a.a("event_info", eventInfo);
        }
        return a;
    }

    public final void m16866a(String str, String str2) {
        if (!this.f16413m) {
            getThemeSuggestifierAnimator(this).start();
            this.f16413m = true;
        }
        GraphQLRequest a = GraphQLRequest.a(EventsThemeSelectorGraphQL.m19804a()).a(m16863b(str, str2).a).a(GraphQLCachePolicy.c);
        this.f16404b.a("FetchThemesForEvent", this.f16403a.a(a), new C22882(this));
    }

    @Nullable
    private String getPhotoUploadOptionImageUriString() {
        String str = null;
        if (this.f16407e.a("android.permission.READ_EXTERNAL_STORAGE")) {
            Cursor query = this.f16406d.getContentResolver().query(this.f16408f, f16401g, f16402h, null, "date_added DESC LIMIT 1");
            if (query != null) {
                while (query.moveToNext()) {
                    try {
                        str = query.getString(1);
                    } finally {
                        query.close();
                    }
                }
            }
        }
        return str;
    }

    public final boolean m16867a() {
        return this.f16412l;
    }

    public static ValueAnimator getThemeSuggestifierAnimator(ThemeSuggestifier themeSuggestifier) {
        if (themeSuggestifier.f16414n == null) {
            final LayoutParams layoutParams = themeSuggestifier.getLayoutParams();
            themeSuggestifier.f16414n = ValueAnimator.ofInt(new int[]{0, themeSuggestifier.getResources().getDimensionPixelSize(2131431118)});
            themeSuggestifier.f16414n.addUpdateListener(new AnimatorUpdateListener(themeSuggestifier) {
                final /* synthetic */ ThemeSuggestifier f16400b;

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    this.f16400b.setLayoutParams(layoutParams);
                    this.f16400b.requestLayout();
                }
            });
            themeSuggestifier.f16414n.setDuration(300);
        }
        return themeSuggestifier.f16414n;
    }
}
