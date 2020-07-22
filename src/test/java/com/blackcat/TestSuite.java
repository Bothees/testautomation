package com.blackcat;

import com.blackcat.pageobjects.TestEbay;
import com.blackcat.pageobjects.TestFlipKartPagination;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestEbay.class,
    TestFlipKartPagination.class
})

public class TestSuite {
}
