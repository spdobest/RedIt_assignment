package sptechindia.redit_assignment.utility;

/**
 * Created by sibaprasad on 20/06/17.
 */

public class Constants {


	public static final int ROW_HEADER                  = 1;
	public static final int ROW_FOOTER                  = 2;
	public static final int ROW_POPULAR_IMAGE           = 3;
	public static final int ROW_IMAGE                   = 4;
	public static final int ROW_MESSAGE                 = 5;
	public static final int ROW_TEXT                    = 6;
	public static final int ROW_IMAGE_WITH_TEXT         = 7;
	public static final int ROW_VIDEO                   = 8;
	public static final int ROW_DEFAULT                 = 9;
	public static final int ROW_POPULAR_GIF           = 10;
	public static final int ROW_POPULAR_TEXT            = 11;
	public static final int ROW_POPULAR_IMAGE_WITH_TEXT = 12;

	public static final String TAB_NOTIFICATION = "NOTIFICATION";
	public static final String TAB_MESSAGE      = "MESSAGE";
	public static final String TAB_MODMAIL      = "MOD MAIL";
	public static final String TAB_HOME         = "Home";
	public static final String TAB_POPULAR      = "Popular";

	public static final String TAB_POSTS     = "POSTS";
	public static final String TAB_COMMENTS         = "Comments";
	public static final String TAB_ABOUT      = "About";

	public interface BundleKeys {
		public static final String FROM_WHICH_SCREEN = "fromWhichScreen";
		public static final String USER_NAME         = "userName";
		public static final String USER_ID           = "userId";
		public static final String KEY               = "key";
		public static final String TAB_TITLE         = "tabTitle";


		public static final byte   SPLASH_SCREEN  = 0;
		public static final int    HOME_SCREEN    = 1;
		public static final int    ACCOUNT_SCREEN = 2;
		public static final int    MAIL_SCREEN    = 3;
		public static final int    OTHERS_SCREEN  = 4;
		public static final int    COMMENT_SCREEN = 5;


		public static final String TITLE          = "tabTitle";
		public static final String POSITION       = "position";


		public static final String CHILD_OBJECT = "ChildObject";
	}

	public interface ErrorType {
		public static final byte NO_INTERNET_CONNECTION = 0;
		public static final int  INVALID_EMAIL          = 1;
		public static final int  INVALID_PASSWORD       = 2;
		public static final int  NETWORK_ERROR          = 3;
		public static final int  OTHERS_SCREEN          = 4;
		public static final int  INVALID_MOBILE         = 5;
		public static final int  INVALID_NAME           = 6;
	}

	public interface BottomTab {
		public static final int TAB_HOME        = 0;
		public static final int TAB_COMMUNITIES = 1;
		public static final int TAB_EMAIL       = 2;
		public static final int TAB_PROFILE     = 3;
	}


}
