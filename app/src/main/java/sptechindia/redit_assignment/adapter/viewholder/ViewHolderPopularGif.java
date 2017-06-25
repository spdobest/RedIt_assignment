package sptechindia.redit_assignment.adapter.viewholder;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import sptechindia.redit_assignment.R;
import sptechindia.redit_assignment.model.home.Child;

public class ViewHolderPopularGif extends RecyclerView.ViewHolder {

	private static final String TAG = "ViewHolderVideo";
	@Bind( R.id.profile_image )
	public  CircleImageView    profileImage;
	@Bind( R.id.textViewPopularFeedName )
	public  AppCompatTextView  textViewPopularFeedName;
	@Bind( R.id.textViewPopularTime )
	public  AppCompatTextView  textViewPopularTime;
	@Bind( R.id.textViewPopularTitle )
	public  AppCompatTextView  textViewPopularTitle;
	@Bind( R.id.imageViewPopular )
	public  AppCompatImageView imageViewPopular;
	@Bind( R.id.imageViewUp )
	public  AppCompatImageView imageViewUp;
	@Bind( R.id.textViewUpDownCount )
	public  AppCompatTextView  textViewUpDownCount;
	@Bind( R.id.imageViewDown )
	public  AppCompatImageView imageViewDown;
	@Bind( R.id.textViewComments )
	public  AppCompatTextView  textViewComments;
	@Bind( R.id.textViewShare )
	public  AppCompatTextView  textViewShare;
	private Child              childData;

	public ViewHolderPopularGif( View itemView ) {
		super( itemView );
		ButterKnife.bind( this, itemView );
	}

	public void setData( Child object ) {
		this.childData = object;
		updateUi();
	}

	private void updateUi() {
		textViewPopularTitle.setText( childData.getData().getTitle() );
		textViewUpDownCount.setText( "" + childData.getData().getViewCount() );
		textViewPopularFeedName.setText( childData.getData().getName() );

		if ( childData != null && childData.getData() != null && childData.getData().getPreview() != null && childData.getData().getPreview().getImages() != null && childData.getData().getPreview().getImages().size() > 0 ) {

			String gifImage = "https://gfycat.com/MixedFrankAlaskankleekai";
			String gifUrl = "http://i.kinja-img.com/gawker-media/image/upload/s--B7tUiM5l--/gf2r69yorbdesguga10i.gif";
		 Glide.with( imageViewPopular.getContext() ).load( childData.getData().getPreview().getImages().get( 0 ).getSource().getUrl() )
					.thumbnail( 0.5f )
					.crossFade()
					.diskCacheStrategy( DiskCacheStrategy.ALL )
					.into( imageViewPopular );

		//	GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget( imageViewPopular);
		//	Glide.with(imageViewPopular.getContext()).load(gifImage).into(imageViewTarget);
		//	Glide.with(imageViewPopular.getContext()).load("http://i.imgur.com/1ALnB2s.gif").asGif().into(imageViewPopular);

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