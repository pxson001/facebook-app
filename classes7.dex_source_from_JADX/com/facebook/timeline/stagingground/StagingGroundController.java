package com.facebook.timeline.stagingground;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.Assisted;
import com.facebook.ipc.profile.heisman.CategoryBrowserLauncher;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tagging.data.TaggingProfiles;
import com.facebook.tagging.graphql.utils.MentionsSpannableStringBuilder;
import com.facebook.tagging.ui.MentionsAutoCompleteTextView;
import com.facebook.timeline.tempprofilepic.ExpirationDialogController;
import com.facebook.timeline.tempprofilepic.ExpirationDialogControllerProvider;
import com.facebook.timeline.ui.common.ProfileMediaFragmentLayout;
import com.facebook.timeline.ui.common.ProfilePrivacyView;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.SwitchCompat;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpecCacheProvider;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: fav_photos_add_in_editing_view */
public class StagingGroundController {
    @Inject
    volatile Provider<AllCapsTransformationMethod> f14728a = UltralightRuntime.a;
    @Inject
    volatile Provider<GlyphColorizer> f14729b = UltralightRuntime.a;
    @Inject
    volatile Provider<TaggingProfiles> f14730c = UltralightRuntime.a;
    @Inject
    private StagingGroundProfileImageControllerProvider f14731d;
    @Inject
    private StagingGroundProfileVideoControllerProvider f14732e;
    @Inject
    private TitleBarButtonSpecCacheProvider f14733f;
    @Inject
    public Context f14734g;
    @Inject
    public Provider<CategoryBrowserLauncher> f14735h;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<LayoutInflater> f14736i = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FbErrorReporter> f14737j = UltralightRuntime.b;
    public final ExpirationDialogController f14738k;
    public final StagingGroundAnalyticsLogger f14739l;
    private final String f14740m;
    public String f14741n;
    public StagingGroundProfileMediaController f14742o;
    public View f14743p;
    public boolean f14744q;

    /* compiled from: fav_photos_add_in_editing_view */
    public class C10734 {
        final /* synthetic */ StagingGroundController f14724a;

        C10734(StagingGroundController stagingGroundController) {
            this.f14724a = stagingGroundController;
        }

        public final void m18654a() {
            this.f14724a.f14739l.m18650c(this.f14724a.f14742o.f14827m, this.f14724a.f14742o.f14826l, this.f14724a.m18663e());
        }
    }

    /* compiled from: fav_photos_add_in_editing_view */
    public class C10756 implements OnClickListener {
        final /* synthetic */ StagingGroundController f14727a;

        public C10756(StagingGroundController stagingGroundController) {
            this.f14727a = stagingGroundController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    @Inject
    public StagingGroundController(ExpirationDialogControllerProvider expirationDialogControllerProvider, @Assisted long j, @Assisted String str, @Assisted StagingGroundAnalyticsLogger stagingGroundAnalyticsLogger) {
        this.f14738k = expirationDialogControllerProvider.m18776a(j);
        this.f14740m = str;
        this.f14739l = stagingGroundAnalyticsLogger;
    }

    public final void m18658a(final FbFragmentActivity fbFragmentActivity, Bundle bundle, final StagingGroundLaunchConfig stagingGroundLaunchConfig, final ProfileMediaFragmentLayout profileMediaFragmentLayout) {
        MentionsSpannableStringBuilder mentionsSpannableStringBuilder = null;
        if (fbFragmentActivity.getIntent().hasExtra("video_model")) {
            this.f14742o = this.f14732e.m18750a(this.f14739l);
        } else {
            this.f14742o = this.f14731d.m18727a(this.f14740m, this.f14739l);
        }
        TaggingProfiles taggingProfiles = (TaggingProfiles) this.f14730c.get();
        if (bundle != null && bundle.containsKey("captionKey")) {
            CharSequence string = bundle.getString("captionKey");
            if (string != null) {
                mentionsSpannableStringBuilder = MentionsSpannableStringBuilder.a(string, fbFragmentActivity.getResources(), taggingProfiles, null);
            }
        } else if (stagingGroundLaunchConfig.f14769a != null) {
            mentionsSpannableStringBuilder = MentionsSpannableStringBuilder.a(stagingGroundLaunchConfig.f14769a, fbFragmentActivity.getResources(), taggingProfiles);
        }
        if (bundle != null) {
            this.f14744q = bundle.getBoolean("skippedToEditing", false);
        } else {
            this.f14744q = stagingGroundLaunchConfig.f14790v;
        }
        this.f14742o.mo1158a(fbFragmentActivity, bundle, stagingGroundLaunchConfig);
        m18657a(fbFragmentActivity, stagingGroundLaunchConfig);
        ((ProfilePrivacyView) profileMediaFragmentLayout.findViewById(2131567598)).c = stagingGroundLaunchConfig.f14777i;
        m18655a((ViewStub) profileMediaFragmentLayout.findViewById(2131567599), stagingGroundLaunchConfig, mentionsSpannableStringBuilder);
        this.f14742o.mo1157a((View) profileMediaFragmentLayout);
        if (stagingGroundLaunchConfig.f14789u) {
            ((ViewStub) profileMediaFragmentLayout.findViewById(2131567610)).inflate();
            if (bundle != null && bundle.containsKey("postToNewsFeed")) {
                ((SwitchCompat) profileMediaFragmentLayout.findViewById(2131567613)).setChecked(bundle.getBoolean("postToNewsFeed"));
            }
        }
        m18656a(fbFragmentActivity, (ViewStub) profileMediaFragmentLayout.findViewById(2131567609), stagingGroundLaunchConfig.f14787s, stagingGroundLaunchConfig.f14788t);
        this.f14742o.mo1159a(new Object(this) {
            final /* synthetic */ StagingGroundController f14719d;

            public final void m18653a() {
                ViewStub viewStub = (ViewStub) profileMediaFragmentLayout.findViewById(2131567606);
                this.f14719d.f14742o.mo1161b();
                this.f14719d.m18659a(fbFragmentActivity, viewStub, stagingGroundLaunchConfig.f14786r);
            }
        });
    }

    @VisibleForTesting
    private void m18655a(ViewStub viewStub, StagingGroundLaunchConfig stagingGroundLaunchConfig, @Nullable MentionsSpannableStringBuilder mentionsSpannableStringBuilder) {
        if (stagingGroundLaunchConfig.f14784p) {
            int h;
            final MentionsAutoCompleteTextView mentionsAutoCompleteTextView = (MentionsAutoCompleteTextView) viewStub.inflate();
            if (stagingGroundLaunchConfig.f14778j == 0) {
                h = this.f14742o.mo1167h();
            } else {
                h = stagingGroundLaunchConfig.f14778j;
            }
            mentionsAutoCompleteTextView.setHint(h);
            if (mentionsSpannableStringBuilder != null) {
                mentionsAutoCompleteTextView.setText(mentionsSpannableStringBuilder);
                this.f14741n = mentionsAutoCompleteTextView.getEncodedText();
                this.f14742o.f14828n = this.f14741n;
                mentionsAutoCompleteTextView.setSelection(mentionsSpannableStringBuilder.length());
            }
            if (stagingGroundLaunchConfig.f14785q > 0) {
                mentionsAutoCompleteTextView.setFilters(new InputFilter[]{new LengthFilter(stagingGroundLaunchConfig.f14785q)});
            }
            mentionsAutoCompleteTextView.addTextChangedListener(new TextWatcher(this) {
                final /* synthetic */ StagingGroundController f14723b;

                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    this.f14723b.f14741n = mentionsAutoCompleteTextView.getEncodedText();
                    this.f14723b.f14742o.f14828n = this.f14723b.f14741n;
                }

                public void afterTextChanged(Editable editable) {
                }
            });
        }
    }

    @VisibleForTesting
    private void m18657a(final FbFragmentActivity fbFragmentActivity, StagingGroundLaunchConfig stagingGroundLaunchConfig) {
        if (FbTitleBarUtil.b(fbFragmentActivity)) {
            FbTitleBar fbTitleBar = (FbTitleBar) fbFragmentActivity.findViewById(2131558563);
            fbTitleBar.setTitle(stagingGroundLaunchConfig.f14775g);
            fbTitleBar.setButtonSpecs(this.f14733f.a(stagingGroundLaunchConfig.f14776h).a());
            fbTitleBar.setOnToolbarButtonListener(this.f14742o.mo1153a(fbFragmentActivity, this.f14738k));
            fbTitleBar.setHasBackButton(false);
            fbTitleBar.a(new View.OnClickListener(this) {
                final /* synthetic */ StagingGroundController f14721b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1651963940);
                    fbFragmentActivity.onBackPressed();
                    Logger.a(2, EntryType.UI_INPUT_END, -1070547654, a);
                }
            });
        }
    }

    @VisibleForTesting
    public final void m18659a(FbFragmentActivity fbFragmentActivity, ViewStub viewStub, boolean z) {
        if (z) {
            this.f14743p = viewStub.inflate();
            this.f14742o.mo1162b(this.f14743p);
            this.f14743p.setOnClickListener(this.f14742o.mo1152a(fbFragmentActivity));
        }
    }

    @VisibleForTesting
    private void m18656a(final FbFragmentActivity fbFragmentActivity, ViewStub viewStub, boolean z, boolean z2) {
        if (z || z2) {
            LinearLayout linearLayout = (LinearLayout) viewStub.inflate();
            if (z) {
                ImageWithTextView imageWithTextView = (ImageWithTextView) ((LayoutInflater) this.f14736i.get()).inflate(2130907210, linearLayout, false);
                linearLayout.addView(imageWithTextView);
                this.f14738k.m18774a(imageWithTextView, -7235677);
                this.f14738k.m18775a(imageWithTextView, new C10734(this));
            }
            if (z2) {
                ImageWithTextView imageWithTextView2 = (ImageWithTextView) ((LayoutInflater) this.f14736i.get()).inflate(2130907210, linearLayout, false);
                imageWithTextView2.setImageDrawable(((GlyphColorizer) this.f14729b.get()).a(2130840058, -7235677));
                imageWithTextView2.setTextColor(-7235677);
                linearLayout.addView(imageWithTextView2);
                imageWithTextView2.setText(((AllCapsTransformationMethod) this.f14728a.get()).getTransformation(fbFragmentActivity.getResources().getString(2131237854), imageWithTextView2));
                imageWithTextView2.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ StagingGroundController f14726b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 1873876231);
                        ((CategoryBrowserLauncher) this.f14726b.f14735h.get()).mo340a(fbFragmentActivity, 3);
                        Logger.a(2, EntryType.UI_INPUT_END, -421199303, a);
                    }
                });
            }
        }
    }

    public final String m18661c() {
        return this.f14742o.f14827m;
    }

    public final String m18662d() {
        return this.f14742o.f14826l;
    }

    @Nullable
    public final String m18663e() {
        return this.f14742o.mo1164e();
    }

    final void m18660a(Provider<AllCapsTransformationMethod> provider, Provider<GlyphColorizer> provider2, Provider<TaggingProfiles> provider3, StagingGroundProfileImageControllerProvider stagingGroundProfileImageControllerProvider, StagingGroundProfileVideoControllerProvider stagingGroundProfileVideoControllerProvider, TitleBarButtonSpecCacheProvider titleBarButtonSpecCacheProvider, Context context, Provider<CategoryBrowserLauncher> provider4, com.facebook.inject.Lazy<LayoutInflater> lazy, com.facebook.inject.Lazy<FbErrorReporter> lazy2) {
        this.f14728a = provider;
        this.f14729b = provider2;
        this.f14730c = provider3;
        this.f14731d = stagingGroundProfileImageControllerProvider;
        this.f14732e = stagingGroundProfileVideoControllerProvider;
        this.f14733f = titleBarButtonSpecCacheProvider;
        this.f14734g = context;
        this.f14735h = provider4;
        this.f14736i = lazy;
        this.f14737j = lazy2;
    }
}
