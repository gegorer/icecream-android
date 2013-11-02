package org.gegorer.icecream.test;

import org.gegorer.icecream.ProviderHelper;

import android.database.Cursor;
import android.test.AndroidTestCase;

public class ProviderTest extends AndroidTestCase {
	
	Cursor mCursor;

	@Override
	protected void setUp() throws Exception {
		mCursor = getContext().getContentResolver().query(ProviderHelper.FAMI_URI, null, null, null, null);
		assertTrue(mCursor != null);
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		mCursor = null;
		super.tearDown();
	}

	public void basicTest() {
		int count = mCursor.getCount();
		assertTrue(count > 0);
		for (int i=0; i<count; i++) {
			assertTrue(mCursor.moveToNext());
		}
		assertFalse(mCursor.moveToNext());
	}
}
