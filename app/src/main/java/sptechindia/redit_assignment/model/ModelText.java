package sptechindia.redit_assignment.model;

import android.os.Parcel;
import android.os.Parcelable;

import sptechindia.redit_assignment.utility.Constants;

/**
 * Created by sibaprasad on 23/06/17.
 */

public class ModelText /*extends Object implements Parcelable */{

	public String textTitle;
	public int rowType = Constants.ROW_TEXT;

	public ModelText(   ) {

	}

	public ModelText( String textTitle, int rowType ) {
		this.textTitle = textTitle;
		this.rowType = rowType;
	}


	/*@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel( Parcel dest, int flags ) {
		dest.writeString( this.textTitle );
		dest.writeInt( this.rowType );
	}

	protected ModelText( Parcel in ) {
		this.textTitle = in.readString();
		this.rowType = in.readInt();
	}

	public static final Creator< ModelText > CREATOR = new Creator< ModelText >() {
		@Override
		public ModelText createFromParcel( Parcel source ) {
			return new ModelText( source );
		}

		@Override
		public ModelText[] newArray( int size ) {
			return new ModelText[size];
		}
	};*/
}
