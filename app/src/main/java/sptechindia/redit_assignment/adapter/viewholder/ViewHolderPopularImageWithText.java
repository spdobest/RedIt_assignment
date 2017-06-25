package sptechindia.redit_assignment.adapter.viewholder;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import sptechindia.redit_assignment.R;
import sptechindia.redit_assignment.model.home.Child;

public class ViewHolderPopularImageWithText extends RecyclerView.ViewHolder {

	private static final String TAG = "ViewHolderPopularImageW";

	@Bind( R.id.profile_image )
	public  CircleImageView    profileImage;
	@Bind( R.id.textViewPopularFeedName )
	public  AppCompatTextView  textViewPopularFeedName;
	@Bind( R.id.textViewPopularTime )
	public  AppCompatTextView  textViewPopularTime;
	@Bind( R.id.textViewTitleImageWithText )
	public  AppCompatTextView  textViewTitleImageWithText;
	@Bind( R.id.imageViewImageWithText )
	public  AppCompatImageView imageViewImageWithText;
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

	public ViewHolderPopularImageWithText( View itemView ) {
		super( itemView );
		ButterKnife.bind( this, itemView );
	}

	public void setdata( Child childData ) {
		this.childData = childData;
	}

	private void updateUi() {
		textViewTitleImageWithText.setText( childData.getData().getTitle() );
		textViewUpDownCount.setText( "" + childData.getData().getViewCount() );
		textViewPopularFeedName.setText( childData.getData().getName() );

		if ( childData != null && childData.getData() != null && childData.getData().getPreview() != null && childData.getData().getPreview().getImages() != null && childData.getData().getPreview().getImages().size() > 0 ) {

			Glide.with( imageViewImageWithText.getContext() ).load( childData.getData().getPreview().getImages().get( 0 ).getSource().getUrl() )
					.thumbnail( 0.5f )
					.crossFade()
					.diskCacheStrategy( DiskCacheStrategy.ALL )
					.into( imageViewImageWithText );
		}
		else {
			Glide.with( imageViewImageWithText.getContext() ).load( childData.getData().getThumbnail() )
					.thumbnail( 0.5f )
					.crossFade()
					.diskCacheStrategy( DiskCacheStrategy.ALL )
					.into( imageViewImageWithText );
		}
	}

}