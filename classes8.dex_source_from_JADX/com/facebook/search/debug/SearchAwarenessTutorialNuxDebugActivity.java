package com.facebook.search.debug;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.enums.GraphQLSearchAwarenessTutorialNUXButtonStyle;
import com.facebook.graphql.enums.GraphQLSearchAwarenessTutorialNUXTemplate;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.TutorialNuxCardFieldsFragmentModel;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.TutorialNuxCardFieldsFragmentModel.Builder;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.TutorialNuxCarouselFieldsFragmentModel;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.TutorialNuxConfigurationModel;
import com.facebook.search.quickpromotion.SearchAwarenessTutorialNuxActivity;
import com.facebook.search.quickpromotion.SearchAwarenessTutorialNuxController;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ultralight.Inject;
import com.facebook.widget.text.BetterEditTextView;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: TimeToFirstCardDataLoaded */
public class SearchAwarenessTutorialNuxDebugActivity extends FbFragmentActivity {
    private static final String[] f21816r = new String[]{"FF0991FF", "FF14C7A6", "FFF5156F"};
    public BetterEditTextView f21817A;
    public BetterEditTextView f21818B;
    private FbButton f21819C;
    private FbButton f21820D;
    @Inject
    SearchAwarenessTutorialNuxController f21821p;
    @Inject
    SecureContextHelper f21822q;
    public BetterEditTextView f21823s;
    public BetterEditTextView f21824t;
    public BetterEditTextView f21825u;
    public BetterEditTextView f21826v;
    public BetterEditTextView f21827w;
    public BetterEditTextView f21828x;
    public BetterEditTextView f21829y;
    public BetterEditTextView f21830z;

    /* compiled from: TimeToFirstCardDataLoaded */
    class C23451 implements OnClickListener {
        final /* synthetic */ SearchAwarenessTutorialNuxDebugActivity f21814a;

        C23451(SearchAwarenessTutorialNuxDebugActivity searchAwarenessTutorialNuxDebugActivity) {
            this.f21814a = searchAwarenessTutorialNuxDebugActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -273540946);
            if (this.f21814a.f21821p.m25951b(SearchAwarenessTutorialNuxDebugActivity.m25305b(this.f21814a.f21823s.getText().toString(), this.f21814a.f21824t.getText().toString(), this.f21814a.f21825u.getText().toString(), this.f21814a.f21826v.getText().toString(), this.f21814a.f21827w.getText().toString(), this.f21814a.f21828x.getText().toString(), this.f21814a.f21829y.getText().toString(), this.f21814a.f21830z.getText().toString(), this.f21814a.f21817A.getText().toString(), this.f21814a.f21818B.getText().toString()))) {
                this.f21814a.f21822q.a(SearchAwarenessTutorialNuxActivity.m25904a(this.f21814a), this.f21814a);
            } else {
                Toast.makeText(this.f21814a, "Configuration failed validation", 0).show();
            }
            LogUtils.a(-969628384, a);
        }
    }

    /* compiled from: TimeToFirstCardDataLoaded */
    class C23462 implements OnClickListener {
        final /* synthetic */ SearchAwarenessTutorialNuxDebugActivity f21815a;

        C23462(SearchAwarenessTutorialNuxDebugActivity searchAwarenessTutorialNuxDebugActivity) {
            this.f21815a = searchAwarenessTutorialNuxDebugActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 727020300);
            this.f21815a.f21823s.setText("");
            this.f21815a.f21824t.setText("");
            this.f21815a.f21825u.setText("");
            this.f21815a.f21826v.setText("");
            this.f21815a.f21827w.setText("");
            this.f21815a.f21828x.setText("");
            this.f21815a.f21829y.setText("");
            this.f21815a.f21830z.setText("");
            this.f21815a.f21817A.setText("");
            this.f21815a.f21818B.setText("");
            Logger.a(2, EntryType.UI_INPUT_END, -1407485560, a);
        }
    }

    private static <T extends Context> void m25303a(Class<T> cls, T t) {
        m25304a((Object) t, (Context) t);
    }

    public static void m25304a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((SearchAwarenessTutorialNuxDebugActivity) obj).m25302a(SearchAwarenessTutorialNuxController.m25941a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    private void m25302a(SearchAwarenessTutorialNuxController searchAwarenessTutorialNuxController, SecureContextHelper secureContextHelper) {
        this.f21821p = searchAwarenessTutorialNuxController;
        this.f21822q = secureContextHelper;
    }

    protected final void m25320b(@Nullable Bundle bundle) {
        super.b(bundle);
        setContentView(2130903329);
        Class cls = SearchAwarenessTutorialNuxDebugActivity.class;
        m25304a((Object) this, (Context) this);
        this.f21823s = (BetterEditTextView) a(2131559441);
        this.f21824t = (BetterEditTextView) a(2131559768);
        this.f21825u = (BetterEditTextView) a(2131559769);
        this.f21826v = (BetterEditTextView) a(2131559770);
        this.f21827w = (BetterEditTextView) a(2131559771);
        this.f21828x = (BetterEditTextView) a(2131559772);
        this.f21829y = (BetterEditTextView) a(2131559773);
        this.f21830z = (BetterEditTextView) a(2131559774);
        this.f21817A = (BetterEditTextView) a(2131559775);
        this.f21818B = (BetterEditTextView) a(2131559776);
        this.f21819C = (FbButton) a(2131559777);
        this.f21820D = (FbButton) a(2131559778);
        this.f21819C.setOnClickListener(new C23451(this));
        this.f21820D.setOnClickListener(new C23462(this));
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1352277572);
        super.onDestroy();
        this.f21819C.setOnClickListener(null);
        this.f21820D.setOnClickListener(null);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 834528523, a);
    }

    public static Intent m25299a(Context context) {
        return new Intent(context, SearchAwarenessTutorialNuxDebugActivity.class);
    }

    private static TutorialNuxConfigurationModel m25305b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        Builder builder = new Builder();
        builder.f8134c = str;
        builder = builder;
        builder.f8139h = str2;
        builder = builder;
        builder.f8132a = str3;
        builder = builder;
        builder.f8133b = m25307b(str6);
        builder = builder;
        builder.f8136e = m25309c(str7);
        builder = builder;
        builder.f8135d = m25311d(str8);
        builder = builder;
        builder.f8137f = m25313e(str9);
        builder = builder;
        builder.f8138g = m25315f(str10);
        builder = builder;
        builder.f8140i = GraphQLSearchAwarenessTutorialNUXTemplate.BASIC;
        TutorialNuxCardFieldsFragmentModel a = builder.m9029a();
        TutorialNuxCarouselFieldsFragmentModel.Builder builder2 = new TutorialNuxCarouselFieldsFragmentModel.Builder();
        builder2.f8150a = GraphQLSearchAwarenessTutorialNUXButtonStyle.DEFAULT;
        builder2 = builder2;
        builder2.f8157h = str4;
        builder2 = builder2;
        builder2.f8159j = str5;
        builder2 = builder2;
        builder2.f8154e = "https://lookaside.facebook.com/assets/1547222318925572/";
        builder2 = builder2;
        builder2.f8153d = "https://lookaside.facebook.com/assets/1504507246518835/";
        builder2 = builder2;
        builder2.f8155f = "https://lookaside.facebook.com/assets/1505070809795626/";
        builder2 = builder2;
        builder2.f8156g = "https://lookaside.facebook.com/assets/1502643223372321/";
        builder2 = builder2;
        builder2.f8151b = ImmutableList.of(a);
        TutorialNuxCarouselFieldsFragmentModel a2 = builder2.m9043a();
        TutorialNuxConfigurationModel.Builder builder3 = new TutorialNuxConfigurationModel.Builder();
        builder3.f8174c = true;
        builder3 = builder3;
        builder3.f8172a = a2;
        return builder3.m9059a();
    }

    private static String m25307b(String str) {
        if (TextUtils.isEmpty(str)) {
            return f21816r[(int) (Math.random() * ((double) f21816r.length))];
        }
        if (str.startsWith("#")) {
            return str.substring(1);
        }
        return str;
    }

    private static String m25309c(String str) {
        return !TextUtils.isEmpty(str) ? str : "https://lookaside.facebook.com/assets/442678635929912/";
    }

    private static String m25311d(String str) {
        return !TextUtils.isEmpty(str) ? str : "https://lookaside.facebook.com/assets/1544405985882709/";
    }

    private static String m25313e(String str) {
        return !TextUtils.isEmpty(str) ? str : "https://lookaside.facebook.com/assets/958872200860045/";
    }

    private static String m25315f(String str) {
        return !TextUtils.isEmpty(str) ? str : "https://lookaside.facebook.com/assets/991821417567505/";
    }
}
