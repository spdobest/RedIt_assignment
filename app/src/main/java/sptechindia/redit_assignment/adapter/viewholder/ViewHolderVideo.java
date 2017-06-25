package sptechindia.redit_assignment.adapter.viewholder;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.devbrackets.android.exomedia.listener.OnPreparedListener;
import com.devbrackets.android.exomedia.ui.widget.EMVideoView;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import sptechindia.redit_assignment.R;
import sptechindia.redit_assignment.model.ModelVideo;

public class ViewHolderVideo extends RecyclerView.ViewHolder implements MediaPlayer.OnPreparedListener {

	private static final String TAG = "ViewHolderVideo";
	@Bind( R.id.profile_image )
	CircleImageView    profileImage;
	@Bind( R.id.textViewPopularFeedName )
	AppCompatTextView  textViewPopularFeedName;
	@Bind( R.id.textViewPopularTime )
	AppCompatTextView  textViewPopularTime;
	@Bind( R.id.textViewPopularTitle )
	AppCompatTextView  textViewPopularTitle;
	@Bind( R.id.video_view )
	EMVideoView        emVideoView;
	@Bind( R.id.imageViewUp )
	AppCompatImageView imageViewUp;
	@Bind( R.id.textViewUpDownCount )
	AppCompatTextView  textViewUpDownCount;
	@Bind( R.id.imageViewDown )
	AppCompatImageView imageViewDown;
	@Bind( R.id.textViewComments )
	AppCompatTextView  textViewComments;
	@Bind( R.id.textViewShare )
	AppCompatTextView  textViewShare;
	@Bind( R.id.layoutFooterToolbar )
	LinearLayout       layoutFooterToolbar;

	@Bind( R.id.imageViewThumbnail_video )
	AppCompatImageView imageViewThumbnail_video;

	int visiblePosition;
	String thumbNailImage = "http://www.gstatic.com/webp/gallery/1.jpg";
	private ModelVideo modelVideo;

	public ViewHolderVideo( View itemView ) {
		super( itemView );
		ButterKnife.bind( this, itemView );
	}

	public void setData( ModelVideo object ) {
		this.modelVideo = object;
		this.visiblePosition = visiblePosition;
		updateUi();
	}

	public void setupVideoView() {
		String videoUrl = "https://archive.org/download/Popeye_forPresident/Popeye_forPresident_512kb.mp4";
		emVideoView.setVideoURI( Uri.parse( videoUrl ) );
		emVideoView.setOnPreparedListener( new OnPreparedListener() {
			@Override
			public void onPrepared() {
				emVideoView.start();
			}
		} );
	}


	private void updateUi() {
		textViewPopularTitle.setText( modelVideo.videoName );
		textViewUpDownCount.setText( "123" );
		textViewPopularFeedName.setText( modelVideo.videoDesc );


		/*Glide.with( imageViewThumbnail_video.getContext() ).load( thumbNailImage )
				.thumbnail( 0.5f )
				.crossFade()
				.diskCacheStrategy( DiskCacheStrategy.ALL )
				.into( imageViewThumbnail_video );*/

	}

	@Override
	public void onPrepared( MediaPlayer mediaPlayer ) {

	}
}