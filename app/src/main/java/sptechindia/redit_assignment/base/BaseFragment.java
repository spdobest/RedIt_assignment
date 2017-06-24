package sptechindia.redit_assignment.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import sptechindia.redit_assignment.R;

/**
 * Created by sibaprasad on 20/06/17.
 */
public abstract class BaseFragment extends Fragment {

	protected String          mRequestTag;
	protected ToolbarListener mToolbarListener;
	@Bind( R.id.fragment_layout_container )
	FrameLayout       fragmentLayoutContainer;
	@Bind( R.id.flProgresRoot )
	FrameLayout       flProgresRoot;
	@Bind( R.id.textViewErrorTitle )
	AppCompatTextView textViewErrorTitle;
	@Bind( R.id.rlErrorRoot )
	RelativeLayout    rlErrorRoot;
	ProgressBar progressbarLoading;
	private ProgressBar mProgressBar;
	private int         mLayoutId;

	public BaseFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
	}


	@Override
	public void onAttach( Context context ) {
		super.onAttach( context );
		try {
			mToolbarListener = ( ToolbarListener ) context;
		}
		catch ( ClassCastException e ) {
			throw new ClassCastException( ( ( Activity ) context ).getLocalClassName()
					                              + " must implement ToolbarListener " );
		}
	}


	protected void setEmptyView( AppCompatTextView view ) {
		view.setVisibility( View.VISIBLE );
		view.setText( R.string.data_not_available );
	}

	protected void setEmptyView( TextView view, String message ) {
		view.setText( message );
	}

	protected void hideProgressBar() {
		if ( mProgressBar != null ) {
			mProgressBar.setVisibility( View.GONE );
		}
	}

	protected void showProgressBar() {
		if ( mProgressBar != null ) {
			mProgressBar.setVisibility( View.VISIBLE );
		}
	}




	@Nullable
	@Override
	public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
		View view = inflater.inflate( R.layout.fragment_base, container, false );
		ButterKnife.bind( this, view );
		inflater.inflate( mLayoutId, fragmentLayoutContainer );
		progressbarLoading = ( ProgressBar ) view.findViewById( R.id.progressbarLoading );
		return view;
	}

	protected void setLayout( int layoutId ) {
		mLayoutId = layoutId;
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mToolbarListener = null;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		ButterKnife.unbind( this );
	}

	public abstract void initView(View rootView);

	public abstract void setClickListener();
	public interface ToolbarListener {
		void setToolbarTitle( String title );
		void setToolbarVisibility( int value );
		void setToolbar();
	}
}
