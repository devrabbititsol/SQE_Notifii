package com.utilities;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Listeners;

import com.epam.reportportal.testng.ReportPortalTestNGListener;

@Listeners({ReportPortalTestNGListener.class})
public class ReportPortalBaseClass {
	public static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(BaseClass.class);

}
