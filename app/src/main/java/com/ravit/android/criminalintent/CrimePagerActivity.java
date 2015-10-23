package com.ravit.android.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.UUID;

;

/**
 * Created by ravit on 21/10/15.
 */
public class CrimePagerActivity extends FragmentActivity {
	private ViewPager mViewPager;
	private ArrayList<Crime> mCrimes;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mViewPager = new ViewPager(this);
		mViewPager.setId(R.id.viewPager);
		setContentView(mViewPager);

		mCrimes = CrimeLab.get(this).getCrimes();

		FragmentManager fragmentManager = getSupportFragmentManager();
		mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
			@Override
			public Fragment getItem(int position) {
				Crime crime = mCrimes.get(position);
				return CrimeFragment.newInsntance(crime.getId());
			}

			@Override
			public int getCount() {
				return mCrimes.size();
			}
		});

		mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageSelected(int position) {
				Crime crime = mCrimes.get(position);
				if (crime.getTitle() != null) {
					setTitle(crime.getTitle());
				}
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});

		UUID crimeId = (UUID)getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
		for (int i = 0; i < mCrimes.size(); i++) {
			if (mCrimes.get(i).getId().equals(crimeId)) {
				mViewPager.setCurrentItem(i);
				break;
			}
		}
	}
}
