package sptechindia.redit_assignment.ui.account.register.view;

/**
 * Created by sibaprasad on 20/10/16.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import sptechindia.redit_assignment.R;
import sptechindia.redit_assignment.base.BaseDialogFragment;
import sptechindia.redit_assignment.utility.Constants;

public class SignupDialogFragment extends BaseDialogFragment {

	public static final String TAG = "SignupDialogFragment";

	int fromWhichScreen;


	public static SignupDialogFragment newInstance( int fromWhichScreen, boolean isLoginScreen ) {

		Bundle args = new Bundle();
		args.putInt( Constants.BundleKeys.FROM_WHICH_SCREEN, fromWhichScreen );
		SignupDialogFragment fragmentLogIn = new SignupDialogFragment();
		fragmentLogIn.setArguments( args );
		return fragmentLogIn;
	}

	@Nullable
	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
		View rootview = inflater.inflate( R.layout.dialogfragment_signup, container, false );
		setLayout( R.layout.dialogfragment_signup );
		init( rootview );
		return rootview;// super.onCreateView( inflater, container, savedInstanceState );

	}


	private void init( View rootview ) {

	}
}
