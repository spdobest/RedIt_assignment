package sptechindia.redit_assignment.utility;

/**
 * Created by sibaprasad on 20/06/17.
 */

public class Constants {

	public interface BundleKeys {
		public static final String FROM_WHICH_SCREEN = "fromWhichScreen";
		public static final String USER_NAME         = "userName";
		public static final String USER_ID           = "userId";
		public static final String KEY               = "key";


		public static final byte SPLASH_SCREEN = 0;
		public static final int HOME_SCREEN = 1;
		public static final int ACCOUNT_SCREEN = 2;
		public static final int MAIL_SCREEN = 3;
		public static final int OTHERS_SCREEN = 4;
	}

	public interface ErrorType{
		public static final byte NO_INTERNET_CONNECTION = 0;
		public static final int INVALID_EMAIL = 1;
		public static final int INVALID_PASSWORD = 2;
		public static final int NETWORK_ERROR = 3;
		public static final int OTHERS_SCREEN = 4;
		public static final int INVALID_MOBILE = 5;
		public static final int INVALID_NAME = 6;
	}
	public interface BottomTab{
		public static final int TAB_HOME = 0;
		public static final int TAB_COMMUNITIES = 1;
		public static final int TAB_EMAIL = 2;
		public static final int TAB_PROFILE = 3;
	}


}
