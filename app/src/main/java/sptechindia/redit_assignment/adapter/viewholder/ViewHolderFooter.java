package sptechindia.redit_assignment.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

public class ViewHolderFooter extends RecyclerView.ViewHolder {

	private static final String TAG = "ViewHolderFooter";

	public ViewHolderFooter( View itemView ) {
		super( itemView );
		ButterKnife.bind( this, itemView );
	}

	public void setData() {

		updateUi();
	}

	private void updateUi() {

	}
}