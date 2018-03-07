package com.facebook.places.create;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.crowdsourcing.logging.PlaceCreationAnalyticsLogger.View;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.places.create.NewPlaceCreationFormFragment.ErrorHandlerFormDelegate;
import com.facebook.places.create.network.PlaceCreationErrorParser.InvalidNameException;
import com.facebook.places.create.network.PlaceCreationErrorParser.InvalidPhoneException;
import com.facebook.places.create.network.PlaceCreationErrorParser.InvalidWebsiteException;
import com.facebook.places.create.network.PlaceCreationErrorParser.LocationInaccurateException;
import com.facebook.places.create.network.PlaceCreationErrorParser.SentryFailException;
import com.facebook.places.create.network.PlaceCreationErrorParser.SimilarPlaceException;
import com.facebook.places.create.network.PlaceCreationErrorParser.TooManyPlaceException;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import javax.inject.Inject;

@ContextScoped
/* compiled from: category_browser_invalid_overlays */
public class PlaceCreationErrorHandler {
    private static PlaceCreationErrorHandler f18229e;
    private static final Object f18230f = new Object();
    private final Toaster f18231a;
    private final Context f18232b;
    public final Resources f18233c;
    private final AbstractFbErrorReporter f18234d;

    private static PlaceCreationErrorHandler m22180b(InjectorLike injectorLike) {
        return new PlaceCreationErrorHandler(Toaster.b(injectorLike), (Context) injectorLike.getInstance(Context.class), ResourcesMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    public static PlaceCreationErrorHandler m22174a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PlaceCreationErrorHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f18230f) {
                PlaceCreationErrorHandler placeCreationErrorHandler;
                if (a2 != null) {
                    placeCreationErrorHandler = (PlaceCreationErrorHandler) a2.a(f18230f);
                } else {
                    placeCreationErrorHandler = f18229e;
                }
                if (placeCreationErrorHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m22180b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f18230f, b3);
                        } else {
                            f18229e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = placeCreationErrorHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PlaceCreationErrorHandler(Toaster toaster, Context context, Resources resources, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f18231a = toaster;
        this.f18232b = context;
        this.f18233c = resources;
        this.f18234d = abstractFbErrorReporter;
    }

    public final void m22182a(Throwable th, ErrorHandlerFormDelegate errorHandlerFormDelegate) {
        try {
            throw th;
        } catch (SimilarPlaceException e) {
            m22178a(e, errorHandlerFormDelegate);
        } catch (TooManyPlaceException e2) {
            m22181b();
        } catch (SentryFailException e3) {
            m22181b();
        } catch (InvalidNameException e4) {
            m22177a(e4, errorHandlerFormDelegate);
        } catch (LocationInaccurateException e5) {
            m22175a();
        } catch (InvalidPhoneException e6) {
            m22176a(2131235126);
        } catch (InvalidWebsiteException e7) {
            m22176a(2131235127);
        } catch (Exception e8) {
            m22179a(e8);
        } catch (Exception e82) {
            m22179a(e82);
        } catch (Throwable th2) {
            RuntimeException runtimeException = new RuntimeException(th2);
        }
    }

    private void m22175a() {
        Toaster toaster = this.f18231a;
        ToastBuilder toastBuilder = new ToastBuilder(2131235159);
        toastBuilder.g = PlaceCreationModule.class.getName();
        toaster.b(toastBuilder);
    }

    private void m22179a(Exception exception) {
        this.f18234d.a("PlaceCreationErrorHandler", exception);
        Toaster toaster = this.f18231a;
        ToastBuilder toastBuilder = new ToastBuilder(2131235158);
        toastBuilder.g = PlaceCreationModule.class.getName();
        toaster.b(toastBuilder);
    }

    private void m22178a(final SimilarPlaceException similarPlaceException, final ErrorHandlerFormDelegate errorHandlerFormDelegate) {
        String obj = errorHandlerFormDelegate.f18157a.ap.f18163a.getText().toString();
        Builder builder = new Builder(this.f18232b);
        builder.a(false);
        builder.a(2131235180, new OnClickListener(this) {
            final /* synthetic */ PlaceCreationErrorHandler f18221c;

            public void onClick(DialogInterface dialogInterface, int i) {
                ErrorHandlerFormDelegate errorHandlerFormDelegate = errorHandlerFormDelegate;
                NewPlaceCreationFormFragment.m22138a(errorHandlerFormDelegate.f18157a, similarPlaceException.id, similarPlaceException.name, View.FORM);
            }
        });
        if (obj.compareToIgnoreCase(similarPlaceException.name) == 0) {
            builder.b(this.f18233c.getString(2131235162, new Object[]{similarPlaceException.name}));
        } else {
            builder.b(this.f18233c.getString(2131235163, new Object[]{similarPlaceException.name, obj}));
            builder.c(2131235181, new OnClickListener(this) {
                final /* synthetic */ PlaceCreationErrorHandler f18224c;

                public void onClick(DialogInterface dialogInterface, int i) {
                    ErrorHandlerFormDelegate errorHandlerFormDelegate = errorHandlerFormDelegate;
                    errorHandlerFormDelegate.f18157a.an.add(Long.valueOf(similarPlaceException.id));
                    NewPlaceCreationFormFragment.aG(errorHandlerFormDelegate.f18157a);
                    dialogInterface.dismiss();
                }
            });
        }
        builder.b();
    }

    private void m22181b() {
        Toaster toaster = this.f18231a;
        ToastBuilder toastBuilder = new ToastBuilder(2131235244);
        toastBuilder.g = PlaceCreationModule.class.getName();
        toaster.b(toastBuilder);
    }

    private void m22177a(final InvalidNameException invalidNameException, final ErrorHandlerFormDelegate errorHandlerFormDelegate) {
        CharSequence charSequence;
        Builder builder = new Builder(this.f18232b);
        String string;
        if (StringUtil.a(invalidNameException.suggestion)) {
            switch (invalidNameException.reason) {
                case INVALID_CHARS:
                    string = this.f18233c.getString(2131235166);
                    break;
                case BLACKLIST:
                    string = this.f18233c.getString(2131235168);
                    break;
                case INVALID_CAPS:
                    string = this.f18233c.getString(2131235170);
                    break;
                default:
                    string = this.f18233c.getString(2131235164);
                    break;
            }
            charSequence = string;
            builder.a(2131230756, null);
        } else {
            switch (invalidNameException.reason) {
                case INVALID_CHARS:
                    string = this.f18233c.getString(2131235167, new Object[]{invalidNameException.suggestion});
                    break;
                case BLACKLIST:
                    string = this.f18233c.getString(2131235169, new Object[]{invalidNameException.suggestion});
                    break;
                case INVALID_CAPS:
                    string = this.f18233c.getString(2131235171, new Object[]{invalidNameException.suggestion});
                    break;
                default:
                    string = this.f18233c.getString(2131235165, new Object[]{invalidNameException.suggestion});
                    break;
            }
            Object obj = string;
            builder.a(2131230756, new OnClickListener(this) {
                final /* synthetic */ PlaceCreationErrorHandler f18227c;

                public void onClick(DialogInterface dialogInterface, int i) {
                    ErrorHandlerFormDelegate errorHandlerFormDelegate = errorHandlerFormDelegate;
                    errorHandlerFormDelegate.f18157a.ap.f18163a.setText(invalidNameException.suggestion);
                }
            });
            builder.b(2131230727, null);
        }
        builder.b(charSequence);
        builder.b();
    }

    private void m22176a(int i) {
        new Builder(this.f18232b).a(2131230756, null).b(i).b();
    }
}
