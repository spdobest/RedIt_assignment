package sptechindia.redit_assignment.utility;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.DisplayMetrics;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Sibaprasad on 20/10/16.
 */
public class CommonUtils {
	public static final  int    UNBOUNDED = View.MeasureSpec.makeMeasureSpec( 0, View.MeasureSpec.UNSPECIFIED );
	private static final String TAG       = "CommonUtils";

	public static boolean isInternetAvailable( Context ctx ) {
		boolean             isConnected         = false;
		ConnectivityManager connectivityManager = null;
		if ( ctx != null ) {
			connectivityManager = ( ConnectivityManager ) ctx.getSystemService( Context.CONNECTIVITY_SERVICE );
		}
		if ( connectivityManager != null ) {
			NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
			if ( networkInfo != null && networkInfo.isConnected() ) {
				isConnected = true;
			}
		}
		return isConnected;
	}

	public static Bitmap getBitmap( String url ) {
		URL newurl = null;
		try {
			newurl = new URL( url );
		}
		catch ( MalformedURLException e ) {
			e.printStackTrace();
		}
		Bitmap mIcon_val = null;
		try {
			mIcon_val = BitmapFactory.decodeStream( newurl.openConnection().getInputStream() );
		}
		catch ( IOException e ) {
			e.printStackTrace();
		}
		return mIcon_val;
	}

	public static void showOrHideKeyBoard( Context mContext, View rootLayout ) {
		InputMethodManager inputMethodManager =
				( InputMethodManager ) mContext.getSystemService( Context.INPUT_METHOD_SERVICE );
		inputMethodManager.toggleSoftInputFromWindow(
				rootLayout.getApplicationWindowToken(),
				InputMethodManager.SHOW_FORCED, 0 );
	}

	public static void showOrHideSoftKeyBoard( View editView, boolean show ) {
		InputMethodManager imm = ( InputMethodManager ) editView.getContext()
				.getSystemService( Context.INPUT_METHOD_SERVICE );
		if ( show ) {
			imm.showSoftInput( editView, InputMethodManager.SHOW_FORCED );
		}
		else {
			imm.hideSoftInputFromWindow( editView.getWindowToken(), 0 );

		}
		editView.setFocusable( true );
	}

	// CHECK EMAIL ID VALIDATION
	public final static boolean isValidEmail( CharSequence target ) {
		if ( target == null ) {
			return false;
		}
		else {
			return Patterns.EMAIL_ADDRESS.matcher( target ).matches();
		}
	}

	// CHECK PASSWORD VALIDATION
	public final static boolean isValidPassword( String target ) {
		if ( target == null ) {
			return false;
		}
		else {
			if ( target.length() >= 6 ) {
				return true;
			}
			else {
				return false;
			}
		}
	}

	// ================++SET UP TO GET GMAIL =========================
	public static Account getAccount( AccountManager accountManager ) {
		Account[] accounts = accountManager.getAccountsByType( "com.google" );
		Account   account;
		if ( accounts.length > 0 ) {
			account = accounts[0];
		}
		else {
			account = null;
		}
		return account;
	}

	// GET PRIMARY EMAIL ID
	public static String getPrimaryEmailId( Context mContext ) {

		AccountManager accountManager = AccountManager.get( mContext );
		Account        account        = getAccount( accountManager );

		if ( account == null ) {
			return null;
		}
		else {
			return account.name;
		}

       /* String primaryEmailid = "";
        Pattern emailPattern = Patterns.EMAIL_ADDRESS;
        AccountManager manager = (AccountManager) mContext.getSystemService(mContext.ACCOUNT_SERVICE);
        Account[] listAccounts = manager.getAccounts();

        if (listAccounts.length != 0) {
            if (emailPattern.matcher(listAccounts[0].name).matches()) {
                primaryEmailid = listAccounts[0].name;
            }
        }
        return primaryEmailid;*/
	}

	/*GETTING VERSION*/
	public static String getVersion( Context context ) {
		PackageManager packageManager = context.getPackageManager();
		String         versionName    = "";
		try {
			PackageInfo packageInfo = packageManager.getPackageInfo( context.getPackageName(), 0 );
			versionName = packageInfo.versionName;
		}
		catch ( PackageManager.NameNotFoundException e ) {
			e.printStackTrace();
		}
		return versionName;
	}

	public static void justifyListViewHeightBasedOnChildren( ListView listView ) {
		ListAdapter adapter = listView.getAdapter();
		if ( adapter == null ) {
			return;
		}
		ViewGroup vg          = listView;
		int       totalHeight = 0;
		for ( int i = 0; i < adapter.getCount(); i++ ) {
			View listItem = adapter.getView( i, null, vg );
//            listItem.measure(0, 0);
			listItem.measure( UNBOUNDED, UNBOUNDED );
			totalHeight += listItem.getMeasuredHeight();
//            totalHeight += listItem.getMeasuredHeightAndState();

		}
		ViewGroup.LayoutParams par = listView.getLayoutParams();
		par.height = totalHeight + ( listView.getDividerHeight() * ( adapter.getCount() - 1 ) );
		listView.setLayoutParams( par );
		listView.requestLayout();
	}


        /*
    Snackbar message to show instance message
    PARAMETERS
    snackbarCallback  : to get callback at the calling place on ACTION BUTTON CLICK ,like UNDO , RETRY
    rootlayout : its the rootlayout of SCREEN WHERE we call this method
    message : The snackbar message
    action_name : undo, retry button name
    isAction : if we want to show action button or not
    Snackbar Time
     */

	//SNACKBAR WITH ACTION BUTTON
	public static void showSnackBar( final SnackbarCallback snackbarCallback, final View rootlayout, String message, final String action_name, final int snackbarTime ) {
		Snackbar snackbar = Snackbar
				.make( rootlayout, message, Snackbar.LENGTH_INDEFINITE );
		View snackBarView = snackbar.getView();

		TextView textView = ( TextView ) snackBarView.findViewById( android.support.design.R.id.snackbar_text );
		textView.setTextColor( Color.parseColor( "#000000" ) );

		snackbar.setAction( action_name, new View.OnClickListener() {
			@Override
			public void onClick( View view ) {
				snackbarCallback.onSnackbarActionClick();
			}
		} );

		snackbar.show();
	}

	//SNACKBAR WITHOUT ACTION BUTTON
	public static void showSnackBar( final View rootlayout, String message, final int snackbarTime ) {

		Snackbar snackbar = Snackbar
				.make( rootlayout, message, Snackbar.LENGTH_LONG );
		View     snackBarView = snackbar.getView();
		TextView textView     = ( TextView ) snackBarView.findViewById( android.support.design.R.id.snackbar_text );
		textView.setTextColor( Color.parseColor( "#000000" ) );

		snackbar.show();
	}

	public static float convertDpToPixel( float dp, Context context ) {
		Resources      resources = context.getResources();
		DisplayMetrics metrics   = resources.getDisplayMetrics();
		float          px        = dp * ( ( float ) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT );
		return px;
	}

	/**
	 * This method converts device specific pixels to density independent pixels.
	 *
	 * @param px      A value in px (pixels) unit. Which we need to convert into db
	 * @param context Context to get resources and device specific display metrics
	 * @return A float value to represent dp equivalent to px value
	 */
	public static float convertPixelsToDp( float px, Context context ) {
		Resources      resources = context.getResources();
		DisplayMetrics metrics   = resources.getDisplayMetrics();
		float          dp        = px / ( ( float ) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT );
		return dp;
	}

	public static boolean isLolipop() {
		if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ) {
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean isMarshmallow() {
		if ( Build.VERSION.SDK_INT >= 23 ) {
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean isJellyBean() {
		if ( Build.VERSION.SDK_INT >= 16 ) {
			return true;
		}
		else {
			return false;
		}
	}

	//    =========================SHOWING MESSAGE FOR GEUST USER , FORGOT PASSWORD AND ============
	public static void showMessageForUser( final Activity mContext, String message ) {

/*    AppCompatTextView mTextViewMessageLogin;
    LayoutInflater    inflater = mContext.getLayoutInflater();
    View layout = inflater.inflate(R.layout.include_message_ontop,
            null);

    mTextViewMessageLogin = (AppCompatTextView) layout.findViewById(R.id.mTextViewMessageLogin);
    mTextViewMessageLogin.setText(Html.fromHtml(message));

    Toast toast = new Toast(mContext);
    toast.setGravity(Gravity.FILL_HORIZONTAL|Gravity.TOP, 0, 0);
    toast.setDuration(Toast.LENGTH_LONG);
    toast.setView(layout);
    toast.show();*/
	}

	public static double getProductPriceForCreatOrder( int OfferPrice, int RegularPrice ) {
		double price = 0;
		try {
			if ( OfferPrice != 0 ) {
				price = OfferPrice;
			}
			else {
				if ( RegularPrice != 0 ) {
					price = RegularPrice;
				}
				else {
				}
			}
		}
		catch ( NumberFormatException e ) {
			e.printStackTrace();
		}
		return price;
	}

	public static void setSnappableString( String title, String message, AppCompatTextView appCompatTextView ) {
		SpannableString ss1 = new SpannableString( title + message );
		ss1.setSpan( new RelativeSizeSpan( 2f ), 0, title.length(), 0 ); // set size
		ss1.setSpan( new ForegroundColorSpan( Color.BLACK ), 0, title.length(), 0 );// set color

		appCompatTextView.setText( ss1 );
	}

	public static void setDivider( RecyclerView recyclerView ) {
		DividerItemDecoration dividerItemDecoration = new DividerItemDecoration( recyclerView.getContext()
				, LinearLayoutManager.VERTICAL );
		recyclerView.addItemDecoration( dividerItemDecoration );
	}

	public interface SnackbarCallback {
		void onSnackbarActionClick();
	}

}