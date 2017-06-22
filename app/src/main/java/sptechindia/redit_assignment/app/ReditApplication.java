package sptechindia.redit_assignment.app;

import android.app.Application;

import sptechindia.redit_assignment.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by sibaprasad on 20/06/17.
 */

public class ReditApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
	}

	private void setUpFont(){
		CalligraphyConfig.initDefault( new CalligraphyConfig.Builder()
				                               .setDefaultFontPath( "fonts/halvetica.ttf" )
				                               .setFontAttrId( R.attr.fontPath )
				                               .build()
		);
		CalligraphyConfig.initDefault( new CalligraphyConfig.Builder()
				                               .setDefaultFontPath( "fonts/helvetica_neue_ultra_light.ttf" )
				                               .setFontAttrId( R.attr.fontPath )
				                               .build()
		);
		CalligraphyConfig.initDefault( new CalligraphyConfig.Builder()
				                               .setDefaultFontPath( "fonts/HelveticaNeue_BoldExt.otf" )
				                               .setFontAttrId( R.attr.fontPath )
				                               .build()
		);
	}

}
