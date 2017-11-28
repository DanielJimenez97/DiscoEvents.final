package com.brandi.discoevents;

/**
 * Created by Brandi Werner on 11/28/2017.
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// Runs all unit tests.
@RunWith(Suite.class)
@Suite.SuiteClasses({AddAndRemoveBookMark.class,
        CheckCheckBox.class,CheckCheckBox.class,
        MainActivityCalendar.class,MainActivityTest.class,
        PopUpView.class,TagSearchView.class,TraversToAllEvents.class,
        TraversToBookMark.class,TraversToPopUp.class,TraversToSearchTag.class})

public class TestSuite { }
