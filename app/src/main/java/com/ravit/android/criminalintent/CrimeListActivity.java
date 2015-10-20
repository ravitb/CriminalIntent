package com.ravit.android.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by ravit on 11/09/15.
 */
public class CrimeListActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new CrimeListFragment();
	}
}
