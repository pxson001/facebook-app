package com.facebook.nearby.v2.resultlist.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout;
import com.facebook.R;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.CollectionUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nearby.v2.resultlist.views.SetSearchPlacePhotoCarouselAdapter.OnPhotoClickListener;
import com.facebook.resources.ui.EllipsizingTextView;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbImageButton;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.HScrollSpacingItemDecoration;
import java.text.NumberFormat;
import java.util.List;
import javax.inject.Inject;

/* compiled from: delete_call_to_action_key */
public class SetSearchPlaceView extends CustomLinearLayout implements OnPhotoClickListener {
    public static final Accessory f15921b = Accessory.NONE;
    private static final CallerContext f15922c = CallerContext.a(SetSearchPlaceView.class);
    private BetterRecyclerView f15923A;
    private EllipsizingTextView f15924B;
    public LinearLayout f15925C;
    public Accessory f15926D;
    private SetSearchPlacePhotoCarouselAdapter f15927E;
    public SimplePlaceViewListener f15928F;
    private String f15929G;
    public GraphQLSavedState f15930H;
    private double f15931I;
    private int f15932J;
    private String f15933K;
    private String f15934L;
    private Boolean f15935M;
    private String f15936N;
    private String f15937O;
    private String f15938P;
    public CharSequence f15939Q;
    private List<String> f15940R;
    private List<String> f15941S;
    private String f15942T;
    private List<Pair<Integer, Integer>> f15943U;
    public List<CharSequence> f15944V;
    public final OnClickListener f15945W;
    @Inject
    public GlyphColorizer f15946a;
    public ForegroundColorSpan f15947d;
    public ForegroundColorSpan f15948e;
    public ForegroundColorSpan f15949f;
    public String f15950g;
    public String f15951h;
    public ImageSpan f15952i;
    public int f15953j;
    public Drawable f15954k;
    public Drawable f15955l;
    public ViewStub f15956m;
    public ViewStub f15957n;
    public ViewStub f15958o;
    public ViewStub f15959p;
    public ViewStub f15960q;
    public ViewStub f15961r;
    public ViewStub f15962s;
    public ViewStub f15963t;
    private FbDraweeView f15964u;
    public FbImageButton f15965v;
    public EllipsizingTextView f15966w;
    private EllipsizingTextView f15967x;
    private EllipsizingTextView f15968y;
    public EllipsizingTextView f15969z;

    /* compiled from: delete_call_to_action_key */
    public class SimplePlaceViewListener {
        public void mo954a(SetSearchPlaceView setSearchPlaceView, int i) {
        }
    }

    /* compiled from: delete_call_to_action_key */
    class C17061 implements OnClickListener {
        final /* synthetic */ SetSearchPlaceView f15919a;

        C17061(SetSearchPlaceView setSearchPlaceView) {
            this.f15919a = setSearchPlaceView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1018399322);
            if (this.f15919a.f15928F != null) {
                SimplePlaceViewListener simplePlaceViewListener = this.f15919a.f15928F;
                this.f15919a.f15925C.indexOfChild(view);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 837250040, a);
        }
    }

    /* compiled from: delete_call_to_action_key */
    public /* synthetic */ class C17072 {
        public static final /* synthetic */ int[] f15920a = new int[GraphQLSavedState.values().length];

        static {
            try {
                f15920a[GraphQLSavedState.NOT_SAVABLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15920a[GraphQLSavedState.ARCHIVED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15920a[GraphQLSavedState.SAVED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: delete_call_to_action_key */
    public enum Accessory {
        NONE(0, 0, 0, 0),
        BOOKMARK(1, 2130839719, 2131361958, 2131361917);
        
        private static SparseArray<Accessory> sValueArray;
        public int mIconResId;
        public int mSelectedColorResId;
        public int mUnselectedColorResId;
        private int mValue;

        public static Accessory fromValue(int i, Accessory accessory) {
            if (sValueArray == null) {
                Accessory[] values = values();
                sValueArray = new SparseArray(values.length);
                for (Accessory accessory2 : values) {
                    sValueArray.put(accessory2.mValue, accessory2);
                }
            }
            return (Accessory) sValueArray.get(i, accessory);
        }

        private Accessory(int i, int i2, int i3, int i4) {
            this.mValue = i;
            this.mIconResId = i2;
            this.mUnselectedColorResId = i3;
            this.mSelectedColorResId = i4;
        }
    }

    public static void m18771a(Object obj, Context context) {
        ((SetSearchPlaceView) obj).f15946a = GlyphColorizer.a(FbInjector.get(context));
    }

    public static void m18770a(View view, boolean z) {
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public SetSearchPlaceView(Context context) {
        this(context, null);
    }

    private SetSearchPlaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private SetSearchPlaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15945W = new C17061(this);
        Class cls = SetSearchPlaceView.class;
        m18771a((Object) this, getContext());
        Resources resources = getResources();
        this.f15947d = new ForegroundColorSpan(resources.getColor(2131361917));
        this.f15948e = new ForegroundColorSpan(resources.getColor(2131361919));
        this.f15949f = new ForegroundColorSpan(resources.getColor(2131361918));
        Drawable a = this.f15946a.a(2130843462, -10972929);
        if (a != null) {
            a.setBounds(0, 0, a.getIntrinsicWidth(), a.getIntrinsicHeight());
            this.f15952i = new ImageSpan(a, 1);
        }
        this.f15950g = resources.getString(2131236703);
        this.f15951h = resources.getString(2131236704);
        this.f15953j = resources.getInteger(2131492918);
        setContentView(2130907065);
        setOrientation(1);
        this.f15966w = (EllipsizingTextView) a(2131567403);
        this.f15956m = (ViewStub) a(2131567400);
        this.f15957n = (ViewStub) a(2131567410);
        this.f15958o = (ViewStub) a(2131567404);
        this.f15959p = (ViewStub) a(2131567406);
        this.f15960q = (ViewStub) a(2131567408);
        this.f15961r = (ViewStub) a(2131567412);
        this.f15962s = (ViewStub) a(2131567414);
        this.f15963t = (ViewStub) a(2131567416);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(2131427416);
        ViewCompat.b(this, 0, dimensionPixelOffset, 0, dimensionPixelOffset);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SetSearchPlaceView, i, 0);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (dimensionPixelOffset = 0; dimensionPixelOffset < indexCount; dimensionPixelOffset++) {
            int index = obtainStyledAttributes.getIndex(dimensionPixelOffset);
            if (index == 1) {
                m18773a(obtainStyledAttributes.getBoolean(index, true));
            } else if (index == 2) {
                m18777b(obtainStyledAttributes.getBoolean(index, false));
            } else if (index == 3) {
                m18778c(obtainStyledAttributes.getBoolean(index, false));
            } else if (index == 4) {
                m18779d(obtainStyledAttributes.getBoolean(index, false));
            } else if (index == 5) {
                m18780e(obtainStyledAttributes.getBoolean(index, false));
            } else if (index == 6) {
                m18781f(obtainStyledAttributes.getBoolean(index, false));
            } else if (index == 7) {
                m18782g(obtainStyledAttributes.getBoolean(index, false));
            } else if (index == 0) {
                m18772a(Accessory.fromValue(obtainStyledAttributes.getInteger(0, -1), f15921b));
            }
        }
        obtainStyledAttributes.recycle();
    }

    public final SetSearchPlaceView m18773a(boolean z) {
        if (z && this.f15964u == null) {
            this.f15964u = (FbDraweeView) this.f15956m.inflate();
            this.f15956m = null;
        }
        if (z) {
            setThumbnailUrl(this.f15929G);
        } else {
            m18770a(this.f15964u, false);
        }
        return this;
    }

    public final SetSearchPlaceView m18772a(Accessory accessory) {
        this.f15926D = accessory;
        boolean z = (this.f15926D == null || Accessory.NONE.equals(this.f15926D)) ? false : true;
        if (z && this.f15965v == null) {
            this.f15965v = (FbImageButton) this.f15957n.inflate();
            this.f15957n = null;
        }
        if (z) {
            this.f15930H = this.f15930H;
            if (this.f15965v != null && Accessory.BOOKMARK.equals(this.f15926D)) {
                if (this.f15930H != null) {
                    FbImageButton fbImageButton;
                    switch (C17072.f15920a[this.f15930H.ordinal()]) {
                        case 1:
                            m18770a(this.f15965v, false);
                            break;
                        case 2:
                        case 3:
                            fbImageButton = this.f15965v;
                            if (this.f15954k == null) {
                                this.f15954k = this.f15946a.a(Accessory.BOOKMARK.mIconResId, getResources().getColor(this.f15926D.mSelectedColorResId));
                            }
                            fbImageButton.setImageDrawable(this.f15954k);
                            m18770a(this.f15965v, true);
                            break;
                        default:
                            fbImageButton = this.f15965v;
                            if (this.f15955l == null) {
                                this.f15955l = this.f15946a.a(Accessory.BOOKMARK.mIconResId, getResources().getColor(this.f15926D.mUnselectedColorResId));
                            }
                            fbImageButton.setImageDrawable(this.f15955l);
                            m18770a(this.f15965v, true);
                            break;
                    }
                }
                m18770a(this.f15965v, false);
            }
            m18770a(this.f15965v, true);
        } else {
            m18770a(this.f15965v, false);
        }
        return this;
    }

    public final SetSearchPlaceView m18777b(boolean z) {
        if (z && this.f15967x == null) {
            this.f15967x = (EllipsizingTextView) this.f15958o.inflate();
            this.f15958o = null;
        }
        if (z) {
            m18774a(this.f15931I, this.f15932J, this.f15933K, this.f15934L, this.f15935M);
        } else {
            m18770a(this.f15967x, false);
        }
        return this;
    }

    public final SetSearchPlaceView m18778c(boolean z) {
        if (z && this.f15968y == null) {
            this.f15968y = (EllipsizingTextView) this.f15959p.inflate();
            this.f15959p = null;
        }
        if (z) {
            m18775a(this.f15936N, this.f15937O, this.f15938P);
        } else {
            m18770a(this.f15968y, false);
        }
        return this;
    }

    public final SetSearchPlaceView m18779d(boolean z) {
        if (z && this.f15969z == null) {
            this.f15969z = (EllipsizingTextView) this.f15960q.inflate();
            this.f15960q = null;
        }
        if (z) {
            this.f15939Q = this.f15939Q;
            if (this.f15969z != null) {
                if (TextUtils.isEmpty(this.f15939Q)) {
                    m18770a(this.f15969z, false);
                } else {
                    this.f15969z.setText(this.f15939Q);
                    m18770a(this.f15969z, true);
                }
            }
        } else {
            m18770a(this.f15969z, false);
        }
        return this;
    }

    public final SetSearchPlaceView m18780e(boolean z) {
        if (z) {
            if (this.f15923A == null) {
                this.f15923A = (BetterRecyclerView) this.f15961r.inflate();
                BetterLinearLayoutManager betterLinearLayoutManager = new BetterLinearLayoutManager(getContext());
                betterLinearLayoutManager.b(0);
                this.f15923A.setLayoutManager(betterLinearLayoutManager);
                this.f15923A.a(new HScrollSpacingItemDecoration(getResources().getDimensionPixelOffset(2131430935)));
                this.f15961r = null;
            }
            if (this.f15927E == null) {
                this.f15927E = new SetSearchPlacePhotoCarouselAdapter(this.f15923A.getContext(), getResources().getDimensionPixelSize(2131430934), this);
            }
            this.f15923A.setAdapter(this.f15927E);
        }
        if (z) {
            setPhotoUrls(this.f15940R);
        } else {
            m18770a(this.f15923A, false);
        }
        return this;
    }

    public final SetSearchPlaceView m18781f(boolean z) {
        if (z && this.f15924B == null) {
            this.f15924B = (EllipsizingTextView) this.f15962s.inflate();
            this.f15962s = null;
        }
        if (z) {
            m18776a(this.f15941S, this.f15942T, this.f15943U);
        } else {
            m18770a(this.f15924B, false);
        }
        return this;
    }

    public final SetSearchPlaceView m18782g(boolean z) {
        if (z && this.f15925C == null) {
            this.f15925C = (SegmentedLinearLayout) this.f15963t.inflate();
            this.f15963t = null;
        }
        if (z) {
            this.f15944V = this.f15944V;
            if (this.f15925C != null) {
                if (CollectionUtil.a(this.f15944V)) {
                    m18770a(this.f15925C, false);
                } else {
                    this.f15925C.removeAllViews();
                    LayoutInflater from = LayoutInflater.from(getContext());
                    int min = Math.min(this.f15944V.size(), this.f15953j);
                    for (int i = 0; i < min; i++) {
                        FbButton fbButton = (FbButton) from.inflate(2130907068, this.f15925C, false);
                        fbButton.setText((CharSequence) this.f15944V.get(i));
                        fbButton.setOnClickListener(this.f15945W);
                        this.f15925C.addView(fbButton);
                    }
                    m18770a(this.f15925C, true);
                }
            }
        } else {
            m18770a(this.f15925C, false);
        }
        return this;
    }

    public void setThumbnailUrl(String str) {
        this.f15929G = str;
        if (this.f15964u == null) {
            return;
        }
        if (TextUtils.isEmpty(this.f15929G)) {
            m18770a(this.f15964u, false);
            return;
        }
        this.f15964u.a(Uri.parse(this.f15929G), f15922c);
        m18770a(this.f15964u, true);
    }

    public final void m18774a(double d, int i, String str, String str2, Boolean bool) {
        this.f15931I = d;
        this.f15932J = i;
        this.f15933K = str;
        this.f15934L = str2;
        this.f15935M = bool;
        if (this.f15967x != null) {
            int length;
            CharSequence spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(StringFormatUtil.formatStrLocaleSafe("%.1f", Double.valueOf(this.f15931I)));
            if (this.f15932J > 0) {
                int length2 = spannableStringBuilder.length();
                length = spannableStringBuilder.length();
                spannableStringBuilder.append("*").append(" (").append(NumberFormat.getNumberInstance().format((long) this.f15932J)).append(")");
                spannableStringBuilder.setSpan(this.f15947d, 0, length2, 18);
                spannableStringBuilder.setSpan(this.f15952i, length, length + 1, 18);
            }
            if (!TextUtils.isEmpty(this.f15933K)) {
                if (spannableStringBuilder.length() > 0) {
                    spannableStringBuilder.append(" • ");
                }
                spannableStringBuilder.append(this.f15933K);
            }
            if (!TextUtils.isEmpty(this.f15934L)) {
                if (spannableStringBuilder.length() > 0) {
                    spannableStringBuilder.append(" • ");
                }
                spannableStringBuilder.append(this.f15934L);
            }
            if (this.f15935M != null) {
                if (spannableStringBuilder.length() > 0) {
                    spannableStringBuilder.append(" • ");
                }
                length = spannableStringBuilder.length();
                spannableStringBuilder.append(this.f15935M.booleanValue() ? this.f15950g : this.f15951h);
                spannableStringBuilder.setSpan(this.f15935M.booleanValue() ? this.f15948e : this.f15949f, length, spannableStringBuilder.length(), 18);
            }
            if (spannableStringBuilder.length() == 0) {
                m18770a(this.f15967x, false);
                return;
            }
            this.f15967x.setText(spannableStringBuilder);
            m18770a(this.f15967x, true);
        }
    }

    public final void m18775a(String str, String str2, String str3) {
        this.f15936N = str;
        this.f15937O = str2;
        this.f15938P = str3;
        if (this.f15968y != null) {
            CharSequence stringBuilder = new StringBuilder();
            if (!TextUtils.isEmpty(this.f15938P)) {
                stringBuilder.append(this.f15938P);
            }
            if (!TextUtils.isEmpty(this.f15936N)) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(" • ");
                }
                stringBuilder.append(this.f15936N);
            }
            if (!TextUtils.isEmpty(this.f15937O)) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(TextUtils.isEmpty(this.f15936N) ? " • " : ", ");
                }
                stringBuilder.append(this.f15937O);
            }
            if (stringBuilder.length() == 0) {
                m18770a(this.f15968y, false);
                return;
            }
            this.f15968y.setText(stringBuilder);
            m18770a(this.f15968y, true);
        }
    }

    public void setPhotoUrls(List<String> list) {
        this.f15940R = list;
        if (this.f15923A == null) {
            return;
        }
        if (CollectionUtil.a(this.f15940R)) {
            m18770a(this.f15923A, false);
            return;
        }
        m18770a(this.f15923A, true);
        SetSearchPlacePhotoCarouselAdapter setSearchPlacePhotoCarouselAdapter = this.f15927E;
        setSearchPlacePhotoCarouselAdapter.f15917d = this.f15940R;
        setSearchPlacePhotoCarouselAdapter.notifyDataSetChanged();
    }

    public final void m18776a(List<String> list, String str, List<Pair<Integer, Integer>> list2) {
        this.f15941S = list;
        this.f15942T = str;
        this.f15943U = list2;
        if (this.f15924B != null) {
            CharSequence spannableStringBuilder = new SpannableStringBuilder();
            if (!TextUtils.isEmpty(this.f15942T)) {
                spannableStringBuilder.append(this.f15942T);
                if (this.f15943U != null) {
                    for (Pair pair : this.f15943U) {
                        spannableStringBuilder.setSpan(new StyleSpan(1), ((Integer) pair.a).intValue(), ((Integer) pair.b).intValue() + ((Integer) pair.a).intValue(), 17);
                    }
                }
            }
            if (CollectionUtil.b(this.f15941S)) {
                int i;
                if (spannableStringBuilder.length() > 0) {
                    spannableStringBuilder.append(" ");
                }
                int size = this.f15941S.size();
                switch (size) {
                    case 1:
                        i = 2131236716;
                        break;
                    case 2:
                        i = 2131236717;
                        break;
                    default:
                        i = 2131236718;
                        break;
                }
                spannableStringBuilder.append(Html.fromHtml(getContext().getString(i, this.f15941S.toArray(new String[size]))));
            }
            if (spannableStringBuilder.length() == 0) {
                m18770a(this.f15924B, false);
                return;
            }
            this.f15924B.setText(spannableStringBuilder);
            m18770a(this.f15924B, true);
        }
    }

    public final void v_(int i) {
        if (this.f15928F != null) {
            this.f15928F.mo954a(this, i);
        }
    }
}
