package sptechindia.redit_assignment.adapter;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;
import sptechindia.redit_assignment.R;

public class ViewHolderText extends RecyclerView.ViewHolder {

	@Bind( R.id.textViewMessageItem )
	AppCompatTextView textViewMessageItem;

	public ViewHolderText( View itemView ) {
		super( itemView );
		ButterKnife.bind( this, itemView );
	}
}