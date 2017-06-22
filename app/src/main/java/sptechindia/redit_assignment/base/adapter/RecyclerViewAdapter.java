package sptechindia.redit_assignment.base.adapter;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import sptechindia.redit_assignment.R;
import sptechindia.redit_assignment.base.view.ViewType;

public abstract class RecyclerViewAdapter < E > extends RecyclerView.Adapter< RecyclerView.ViewHolder > {
	private List< E > mList;

	public RecyclerViewAdapter( List< E > objects ) {
		mList = objects;
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType ) {
		switch ( ViewType.valueOf( viewType ) ) {
			case FOOTER:
				View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.include_progress, parent, false );
				return new FooterView( view );

			default:
				throw new RuntimeException( "Invalid adapter view type in " + getClass().getName() );
		}

	}

	@Override
	public void onBindViewHolder( RecyclerView.ViewHolder holder, int position ) {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see android.support.v7.widget.RecyclerView.Adapter#getItemCount()
	 */
	@Override
	public int getItemCount() {
		return mList.size();
	}

	public List< E > getItems() {
		return mList;
	}

	public E getItemAtPosition( int position ) {
		return mList.get( position );
	}

	public abstract void onDestroy();

	public interface LoginPageListener {
		void showLoginPage( int position );
	}

	public interface ItemClickListener {
		void onItemClick( int position, View view );

		void onWishListClick( int position );
	}

	private static class FooterView extends RecyclerViewHolder {
		public FooterView( View view ) {
			super( view );
		}
	}

	public static class EmptyView extends RecyclerViewHolder {

		public AppCompatTextView mEmptyView;

		public EmptyView( View view ) {
			super( view );
			mEmptyView = ( AppCompatTextView ) view.findViewById( R.id.textViewErrorTitle );
		}
	}

	public abstract static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


		public RecyclerViewHolder( View itemView ) {
			super( itemView );
			itemView.setOnClickListener( this );
		}

		@Override
		public void onClick( View v ) {

		}
	}
}