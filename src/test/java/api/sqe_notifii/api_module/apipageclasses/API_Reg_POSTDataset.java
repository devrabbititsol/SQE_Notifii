package api.sqe_notifii.api_module.apipageclasses; 

public class API_Reg_POSTDataset{

public static final int datasetLength = 1; 

public static String projectName = "sqe_notifii";

			/*--------Default Dataset-----------*/

public static final String datasetHeader1 = "TC_API_New-Default";

public static final String datasetResources1 = "api/register";
public static final int requestType1 = 2;
public static final int bodyType1 = 3;

 public static String urlParams1  = "[]";

 public static String headers1  = "[]";

 public static String body1  = "{\"raw_text\":\"{     \\\"email\\\": \\\"eve.holt@reqres.in\\\","
 + "     \\\"password\\\": \\\"pistol\\\" }\","
 + "\"raw_id\":1170,"
 + "\"dataset_id\":1470,"
 + "\"raw_type_id\":3}";

}