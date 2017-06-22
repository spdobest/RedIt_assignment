package sptechindia.redit_assignment.base;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import sptechindia.redit_assignment.R;

/**
 * Created by sibaprasad on 20/06/17.
 */

public class BaseDialogFragment extends DialogFragment {

	public static final String TAG = "BaseDialogFragment";

	protected String                       mRequestTag;
	protected BaseFragment.ToolbarListener mToolbarListener;
	@Bind( R.id.fragment_layout_container )
	FrameLayout       fragmentLayoutContainer;
	@Bind( R.id.progressbarLoading )
	ProgressBar       progressbarLoading;
	@Bind( R.id.flProgresRoot )
	FrameLayout       flProgresRoot;
	@Bind( R.id.textViewErrorTitle )
	AppCompatTextView textViewErrorTitle;
	@Bind( R.id.rlErrorRoot )
	RelativeLayout    rlErrorRoot;
	private ProgressBar mProgressBar;
	private int         mLayoutId;

	@Override
	public void onStart() {
		super.onStart();
		Dialog dialog = getDialog();
		if ( dialog != null ) {
			dialog.getWindow().setWindowAnimations(
					R.style.styleDialogFragment );
			dialog.getWindow().setLayout( ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT );
			dialog.getWindow().setBackgroundDrawable( new ColorDrawable( Color.TRANSPARENT ) );
		}
	}

	@Override
	public void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		setStyle( STYLE_NO_FRAME, R.style.SplashScreenDialogTheme );
	}

	@Override
	public void onAttach( Context context ) {
		super.onAttach( context );
	}

	@Nullable
	@Override
	public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
		View view = inflater.inflate( R.layout.fragment_base, container, false );
		ButterKnife.bind( this, view );
		inflater.inflate( mLayoutId, fragmentLayoutContainer );
		return view;
	}

	protected void setLayout( int layoutId ) {
		mLayoutId = layoutId;
	}

	@Override
	public void onDestroy() {
		if ( getDialog() != null && getRetainInstance() ) {
			getDialog().setOnDismissListener( null );
		}
		super.onDestroy();
	}

	@Override
	public void onActivityCreated( Bundle savedInstanceState ) {
		super.onActivityCreated( savedInstanceState );
		getDialog().getWindow().getAttributes().windowAnimations = R.style.animationDialog;
	}

	public void showProgress(){
		flProgresRoot.setVisibility( View.VISIBLE );
	}

	public void hideProgress(){
		flProgresRoot.setVisibility( View.VISIBLE );
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mToolbarListener = null;
	}
}
