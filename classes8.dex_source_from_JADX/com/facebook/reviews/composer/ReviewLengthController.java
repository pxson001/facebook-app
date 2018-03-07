package com.facebook.reviews.composer;

import android.content.res.Resources;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.facebook.common.i18n.StringLengthHelper;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTextWithEntities;
import com.facebook.reviews.analytics.ReviewsLogger;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: proxied_app_package_name */
public class ReviewLengthController<DataProvider extends ProvidesTextWithEntities> implements ComposerEventHandler {
    private final WeakReference<DataProvider> f4933a;
    public final Resources f4934b;
    private final ReviewsLogger f4935c;
    private Optional<TextView> f4936d = Absent.INSTANCE;
    public int f4937e;
    private String f4938f;
    private String f4939g;
    private int f4940h;

    /* compiled from: proxied_app_package_name */
    /* synthetic */ class C06661 {
        static final /* synthetic */ int[] f4932a = new int[ComposerEvent.values().length];

        static {
            try {
                f4932a[ComposerEvent.ON_RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4932a[ComposerEvent.ON_STATUS_TEXT_CHANGED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: proxied_app_package_name */
    enum ReviewLengthCategory {
        EMPTY_REVIEW,
        NON_EMPTY_BELOW_THRESHOLD,
        ABOVE_THRESHOLD
    }

    @Inject
    public ReviewLengthController(@Assisted DataProvider dataProvider, @Assisted String str, @Assisted String str2, Resources resources, ReviewsLogger reviewsLogger) {
        this.f4933a = new WeakReference(Preconditions.checkNotNull(dataProvider));
        this.f4938f = str;
        this.f4939g = str2;
        this.f4934b = resources;
        this.f4935c = reviewsLogger;
        m4864d();
    }

    public final void m4866a(TextView textView) {
        m4864d();
        this.f4936d = Optional.of(Preconditions.checkNotNull(textView));
        if (this.f4936d.isPresent()) {
            ((TextView) this.f4936d.get()).setGravity(1);
            ((TextView) this.f4936d.get()).setTextSize((float) SizeUtil.c(this.f4934b, 2131427400));
        }
    }

    public final void m4867a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        switch (C06661.f4932a[composerEvent.ordinal()]) {
            case 1:
                this.f4940h = m4865e();
                break;
            case 2:
                break;
            default:
                return;
        }
        if (this.f4937e > 0) {
            m4861b();
            m4862c(this.f4940h);
            this.f4940h = m4865e();
        }
    }

    @VisibleForTesting
    private void m4861b() {
        if (this.f4936d.isPresent()) {
            int e = m4865e();
            if (m4860a(e)) {
                ((TextView) this.f4936d.get()).setText(new StyledStringBuilder(this.f4934b).a(this.f4934b.getString(2131235360, new Object[]{"[[REVIEW_LENGTH]]", Integer.valueOf(this.f4937e)})).a("[[REVIEW_LENGTH]]", String.valueOf(e), new ForegroundColorSpan(-65536), 33).b());
                ((TextView) this.f4936d.get()).setVisibility(0);
                return;
            }
            ((TextView) this.f4936d.get()).setVisibility(8);
        }
    }

    public final boolean m4868a() {
        return m4860a(m4865e());
    }

    private boolean m4860a(int i) {
        return i > 0 && i < this.f4937e;
    }

    private void m4864d() {
        this.f4937e = this.f4934b.getInteger(2131492906);
    }

    private void m4862c(int i) {
        ReviewLengthCategory d = m4863d(i);
        int e = m4865e();
        if (m4863d(e) != d) {
            this.f4935c.a(this.f4938f, this.f4939g, i, e, this.f4937e);
        }
    }

    private ReviewLengthCategory m4863d(int i) {
        if (i == 0) {
            return ReviewLengthCategory.EMPTY_REVIEW;
        }
        return m4860a(i) ? ReviewLengthCategory.NON_EMPTY_BELOW_THRESHOLD : ReviewLengthCategory.ABOVE_THRESHOLD;
    }

    private int m4865e() {
        return StringLengthHelper.a(((ProvidesTextWithEntities) Preconditions.checkNotNull(this.f4933a.get())).ae().a());
    }
}
