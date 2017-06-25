package sptechindia.redit_assignment.adapter.viewholder;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import sptechindia.redit_assignment.R;

public class ViewHolderImageWithText extends RecyclerView.ViewHolder {
	@Bind( R.id.imageViewProfileItem )
	CircleImageView   imageViewProfileItem;
	@Bind( R.id.textViewMessageItem )
	AppCompatTextView textViewMessageItem;
	@Bind( R.id.textViewDescItem )
	AppCompatTextView textViewDescItem;

	public ViewHolderImageWithText( View itemView ) {
		super( itemView );
		ButterKnife.bind( this, itemView );
	}
	public void setData(Object object) {
		updateUi();
	}

	private void updateUi(){

	}
}