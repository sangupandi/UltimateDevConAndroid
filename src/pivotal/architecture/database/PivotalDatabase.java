package pivotal.architecture.database;

import pivotal.architecture.PivotalApplication;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PivotalDatabase extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 7;

	public PivotalDatabase(Context context, String name) {
		super(context, name, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(final SQLiteDatabase db) {
		Log.d(PivotalApplication.DEBUG_TAG, "onCreate PivotalDatabase");
		db.execSQL(PivotalCreatePeopleTable.DROP);
		db.execSQL(PivotalCreatePeopleTable.CREATE);
		
		db.execSQL(PivotalPeopleTable.DROP);
		db.execSQL(PivotalPeopleTable.CREATE);
		db.execSQL(PivotalPeopleTable.DATA_CREATE);

		db.execSQL(PivotalPeopleView.DROP);
		db.execSQL(PivotalPeopleView.CREATE);
		
		db.execSQL(PivotalTasksTable.DROP);
		db.execSQL(PivotalTasksTable.CREATE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if (oldVersion != newVersion)
			onCreate(db);

	}

}
