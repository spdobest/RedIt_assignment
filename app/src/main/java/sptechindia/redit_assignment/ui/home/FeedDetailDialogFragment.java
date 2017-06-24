package sptechindia.redit_assignment.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import sptechindia.redit_assignment.R;
import sptechindia.redit_assignment.adapter.CommonRecyclerAdapter;
import sptechindia.redit_assignment.base.BaseDialogFragment;
import sptechindia.redit_assignment.controllers.OnRecyclerItemClickListener;
import sptechindia.redit_assignment.model.ModelHeader;
import sptechindia.redit_assignment.model.home.Child;
import sptechindia.redit_assignment.utility.CommonUtils;
import sptechindia.redit_assignment.utility.Constants;
import sptechindia.redit_assignment.utility.Debug;


public class FeedDetailDialogFragment extends BaseDialogFragment implements View.OnClickListener, OnRecyclerItemClickListener {


	public static final String TAG = "FeedDetailDialogFragment";

	AppCompatImageView imageViewBackToolbar;
	AppCompatTextView  textViewTitleToolbarWithBack;
	AppCompatImageView imageViewShare;
	AppCompatImageView imageViewSort;
	Toolbar            toolbarWithTitleAndBack;
	CircleImageView    profileImage;
	AppCompatTextView  textViewPopularFeedName;
	AppCompatTextView  textViewPopularTime;
	AppCompatTextView  textViewPopularTitle;
	AppCompatImageView imageViewPopular;
	AppCompatImageView imageViewUp;
	AppCompatTextView  textViewUpDownCount;
	AppCompatImageView imageViewDown;
	AppCompatTextView  textViewComments;
	AppCompatTextView  textViewShare;
	CoordinatorLayout  coordinateLayoutRootFeedDetails;

	Child childModel;
	int screen = 0;
	BottomSheetDialog mBottomSheetDialog;

	// for bottomsheet
	RecyclerView      recyclerViewComments;
	TextInputLayout   textinputlayoutComment;
	AppCompatEditText edittextEmailForgotPwd;
	AppCompatButton   buttonComment;
	ProgressBar       progressBarComment;


	public static FeedDetailDialogFragment newInstance( int fromWhichScreen, Child child ) {
		Bundle args = new Bundle();
		args.putInt( Constants.BundleKeys.FROM_WHICH_SCREEN, fromWhichScreen );
		args.putSerializable( Constants.BundleKeys.CHILD_OBJECT, child );
		FeedDetailDialogFragment fragmentLogIn = new FeedDetailDialogFragment();

		fragmentLogIn.setArguments( args );
		Debug.showLog( TAG, "From Screen " + fromWhichScreen );
		return fragmentLogIn;
	}

	@Override
	public void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );

		Bundle bundle = getArguments();
		if ( bundle != null ) {
			if ( bundle.containsKey( Constants.BundleKeys.FROM_WHICH_SCREEN ) ) {
				screen = bundle.getInt( Constants.BundleKeys.FROM_WHICH_SCREEN );
			}

			if ( bundle.containsKey( Constants.BundleKeys.CHILD_OBJECT ) ) {
				childModel = ( Child ) bundle.getSerializable( Constants.BundleKeys.CHILD_OBJECT );
			}
		}
	}

	@Override
	public void onAttach( Context context ) {
		super.onAttach( context );
	}

	@Override
	public void setUserVisibleHint( boolean isVisibleToUser ) {
		super.setUserVisibleHint( isVisibleToUser );


	}

	@Nullable
	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
		View rootview = inflater.inflate( R.layout.dialogfragment_feed_details, container, false );
		setLayout( R.layout.dialogfragment_login );
		init( rootview );
		return rootview;
	}

	private void init( View rootview ) {
		coordinateLayoutRootFeedDetails = ( CoordinatorLayout ) rootview.findViewById( R.id.coordinateLayoutRootFeedDetails );
		imageViewBackToolbar = ( AppCompatImageView ) rootview.findViewById( R.id.imageViewBackToolbar );

		textViewTitleToolbarWithBack = ( AppCompatTextView ) rootview.findViewById( R.id.textViewTitleToolbarWithBack );

		imageViewShare = ( AppCompatImageView ) rootview.findViewById( R.id.imageViewShare );

		imageViewSort = ( AppCompatImageView ) rootview.findViewById( R.id.imageViewSort );

		toolbarWithTitleAndBack = ( Toolbar ) rootview.findViewById( R.id.toolbarWithTitleAndBack );

		profileImage = ( CircleImageView ) rootview.findViewById( R.id.profile_image );

		textViewPopularFeedName = ( AppCompatTextView ) rootview.findViewById( R.id.textViewPopularFeedName );

		textViewPopularTime = ( AppCompatTextView ) rootview.findViewById( R.id.textViewPopularTime );

		textViewPopularTitle = ( AppCompatTextView ) rootview.findViewById( R.id.textViewPopularTitle );

		imageViewPopular = ( AppCompatImageView ) rootview.findViewById( R.id.imageViewPopular );

		imageViewUp = ( AppCompatImageView ) rootview.findViewById( R.id.imageViewUp );

		textViewUpDownCount = ( AppCompatTextView ) rootview.findViewById( R.id.textViewUpDownCount );

		imageViewDown = ( AppCompatImageView ) rootview.findViewById( R.id.imageViewDown );

		textViewComments = ( AppCompatTextView ) rootview.findViewById( R.id.textViewComments );

		textViewShare = ( AppCompatTextView ) rootview.findViewById( R.id.textViewShare );

		imageViewShare.setVisibility( View.GONE );
		imageViewSort.setVisibility( View.GONE );
		textViewTitleToolbarWithBack.setText( "Feed Details" );

		imageViewBackToolbar.setOnClickListener( this );
		textViewComments.setOnClickListener( this );
		textViewShare.setOnClickListener( this );
		imageViewDown.setOnClickListener( this );
		imageViewUp.setOnClickListener( this );

		setData();

		if ( screen == Constants.BundleKeys.COMMENT_SCREEN ) {
//			showBottomSheetComment();
		}

	}

	private void setData() {
		if ( childModel != null ) {
			textViewPopularTitle.setText( childModel.getData().getName() );
			textViewUpDownCount.setText( "" + childModel.getData().getViewCount() );
			textViewPopularFeedName.setText( childModel.getData().getTitle() );

			if ( childModel != null && childModel.getData() != null && childModel.getData().getPreview() != null && childModel.getData().getPreview().getImages() != null && childModel.getData().getPreview().getImages().size() > 0 ) {

				Glide.with( imageViewPopular.getContext() ).load( childModel.getData().getPreview().getImages().get( 0 ).getSource().getUrl() )
						.thumbnail( 0.5f )
						.crossFade()
						.diskCacheStrategy( DiskCacheStrategy.ALL )
						.into( imageViewPopular );
			}
			else {
				Glide.with( imageViewPopular.getContext() ).load( "http://www.gstatic.com/webp/gallery/1.jpg" )
						.thumbnail( 0.5f )
						.crossFade()
						.diskCacheStrategy( DiskCacheStrategy.ALL )
						.into( imageViewPopular );
			}
		}
	}


	public void onClick( View view ) {
		switch ( view.getId() ) {
			case R.id.imageViewBackToolbar:
				dismiss();
				break;
			case R.id.imageViewUp:
				CommonUtils.showSnackBar( coordinateLayoutRootFeedDetails, "Ups Successfully", Snackbar.LENGTH_SHORT );
				break;
			case R.id.imageViewDown:
				CommonUtils.showSnackBar( coordinateLayoutRootFeedDetails, "Downs Successfully", Snackbar.LENGTH_SHORT );
				break;
			case R.id.textViewComments:
				showBottomSheetComment();

				break;
			case R.id.textViewShare:
				CommonUtils.showSnackBar( coordinateLayoutRootFeedDetails, "Share Successfully", Snackbar.LENGTH_SHORT );
				break;
		}
	}

	private void showBottomSheetComment() {

		if ( mBottomSheetDialog == null ) {
			mBottomSheetDialog = new BottomSheetDialog( getActivity() );
		}
		//similar
		mBottomSheetDialog.setContentView( R.layout.bottomsheet_comment );
		textinputlayoutComment = ( TextInputLayout ) mBottomSheetDialog.findViewById( R.id.textinputlayoutComment );
		edittextEmailForgotPwd = ( AppCompatEditText ) mBottomSheetDialog.findViewById( R.id.edittextEmailForgotPwd );
		buttonComment = ( AppCompatButton ) mBottomSheetDialog.findViewById( R.id.buttonComment );
		progressBarComment = ( ProgressBar ) mBottomSheetDialog.findViewById( R.id.progressBarComment );
		recyclerViewComments = ( RecyclerView ) mBottomSheetDialog.findViewById( R.id.recyclerViewComments );
		recyclerViewComments.setLayoutManager( new LinearLayoutManager( getActivity(), LinearLayoutManager.VERTICAL, false ) );

		List< Object > listComments = new ArrayList<>();

		for ( int i = 0; i < 10; i++ ) {
			listComments.add( new ModelHeader( "Spm " + i, "Comments " + i, 123 ) );
		}
		CommonRecyclerAdapter commonRecyclerAdapter = new CommonRecyclerAdapter( listComments, Constants.ROW_HEADER, true, this );
		recyclerViewComments.setAdapter( commonRecyclerAdapter );


		buttonComment.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick( View view ) {
				if ( CommonUtils.isValidEmail( edittextEmailForgotPwd.getText().toString().trim() ) ) {
					textinputlayoutComment.setError( "Invalid Email" );
				}
				else {
					buttonComment.setVisibility( View.INVISIBLE );
					progressBarComment.setVisibility( View.VISIBLE );
					new Handler().postDelayed( new Runnable() {
						@Override
						public void run() {
							buttonComment.setVisibility( View.VISIBLE );
							progressBarComment.setVisibility( View.INVISIBLE );
							mBottomSheetDialog.dismiss();


						}
					}, 1000 );
					CommonUtils.showSnackBar( coordinateLayoutRootFeedDetails, "Comment Successfully", Snackbar.LENGTH_SHORT );
				}
			}
		} );

		mBottomSheetDialog.show();
	}

	@Override
	public void onCommentClick( Child child ) {

	}

	@Override
	public void onFeedClick( Child child ) {

	}

	@Override
	public void onShareClick( Child child ) {

	}

	@Override
	public void onUpClick( Child child ) {

	}

	@Override
	public void onDownClick( Child child ) {

	}
}
