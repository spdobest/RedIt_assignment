package sptechindia.redit_assignment.adapter.viewholder;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.Bind;
import butterknife.ButterKnife;
import sptechindia.redit_assignment.R;

public class ViewHolderImage extends RecyclerView.ViewHolder {

	private static final String TAG = "ViewHolderImage";

	@Bind( R.id.imageViewItem )
	public AppCompatImageView imageViewItem;
	@Bind( R.id.tvImageTitle )
	public AppCompatTextView  tvImageTitle;

	public ViewHolderImage( View itemView ) {
		super( itemView );
		ButterKnife.bind( this, itemView );
	}

	public void setData( Object object ) {
		updateUi();
	}

	private void updateUi() {
		Glide.with( imageViewItem.getContext() ).load( "http://www.gstatic.com/webp/gallery/1.jpg" )
				.thumbnail( 0.5f )
				.crossFade()
				.diskCacheStrategy( DiskCacheStrategy.ALL )
				.into( imageViewItem );
	}
}