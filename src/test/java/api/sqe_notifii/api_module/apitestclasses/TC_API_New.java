package api.sqe_notifii.api_module.apitestclasses;

import com.restassured.services.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;import com.utilities.BaseClass;
import com.utilities.ConfigFilesUtility;
import api.sqe_notifii.api_module.apipageclasses.API_Reg_POSTDataset;
import api.sqe_notifii.api_module.apipageclasses.API_QA_GETDataset;
public class TC_API_New extends BaseClass {

	private Logger logger;
	private ConfigFilesUtility configFileObj;

	public TC_API_New() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		logger = Logger.getLogger(TC_API_New.class);
		configFileObj= new ConfigFilesUtility();
		configFileObj.loadPropertyFile("TC_API_New.properties");
	}

	@Test(priority = 1)
	public void doRequest() throws Exception { 
	
		for(int i = 1; i <= configFileObj.getIntProperty("datasetsLength"); i++) {
			boolean isExecutionFlag = true;			
		/*--------------------- POST --------------------- */

			if(isExecutionFlag) {
 			 	Object object = (Object) new API_Reg_POSTDataset();
				Class<?> c = object.getClass();
				String urlParams = (String) c.getField("urlParams" + i).get(object);
				if(urlParams == null) return;
				String headers = (String) c.getField("headers" + i).get(object);
				String body = (String) c.getField("body" + i).get(object);
				String apiName = (String) c.getField("apiName" + i).get(object);
				String datasetResources = (String) c.getField("datasetResources" + i).get(object);
				int reqType = (Integer) c.getField("requestType" + i).get(object);
				int bodyType = (Integer) c.getField("bodyType" + i).get(object);
				String response = APIService.callRequest(configFileObj,apiName, urlParams, headers, reqType, bodyType, body, configFileObj.getProperty("dataset" +i), datasetResources, authenticationData, formurlEncodedData, formData, linkParams, logger);
			}

		/*--------------------- GET --------------------- */

			if(isExecutionFlag) {
 			 	Object object = (Object) new API_QA_GETDataset();
				Class<?> c = object.getClass();
				String urlParams = (String) c.getField("urlParams" + i).get(object);
				if(urlParams == null) return;
				String headers = (String) c.getField("headers" + i).get(object);
				String body = (String) c.getField("body" + i).get(object);
				String apiName = (String) c.getField("apiName" + i).get(object);
				String datasetResources = (String) c.getField("datasetResources" + i).get(object);
				int reqType = (Integer) c.getField("requestType" + i).get(object);
				int bodyType = (Integer) c.getField("bodyType" + i).get(object);
				String response = APIService.callRequest(configFileObj,apiName, urlParams, headers, reqType, bodyType, body, configFileObj.getProperty("dataset" +i), datasetResources, authenticationData, formurlEncodedData, formData, linkParams, logger);
			}
		}
	}}
