package sptechindia.redit_assignment.utility;

import android.util.Log;

/**
 * Created by sibaprasad on 20/06/17.
 */

public class Debug {

	private static boolean isDebuggable = true;

	public static void showLog(String tag,String message){
		if(isDebuggable)
			Log.i( tag, "showLog : "+message );
	}

}
