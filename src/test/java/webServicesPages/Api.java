package webServicesPages;

public class Api {

	public Api() {
		// TODO Auto-generated constructor stub

		
		public static CloseableHttpResponse HttpResponse;
		
		
		public static void get() throws ClientProtocolException, IOException 
		{
			CloseableHttpClient HttpClient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet("https://cmol-api1.creditmantri.in/application/status");
			HttpResponse = HttpClient.execute(httpGet);
			httpGet.addHeader("Content-Type", "application/json");
			
		}
		
		public static void getStatuscode() {
			
			int statusCode=HttpResponse.getStatusLine().getStatusCode();
			System.out.println(statusCode);
		}
		
		public static void getResponseCode(String producttype, String city, String dob, String residentialPincode, String loanAmount, String gender) throws ClientProtocolException, IOException {
			
			CloseableHttpClient HttpClient = HttpClients.createDefault();
			HttpPost httppost = new HttpPost("https://qa-ruleengine-v2.creditmantri.in/run/rules");
			String inut = "{\"productType\":\""+producttype+"\",\"inputs\":{\"city\":\""+city+"\",\"dob\":\""+dob+"\",\"residentialPincode\":\""+residentialPincode+"\",\"loanAmount\":\""+loanAmount+"\",\"gender\":\""+gender+"\"},\"leadId\":4677270,\"userId\":2690193,\"products\":[\"HDFC\", \"DCB\", \"ICICI\",\"INDUSIND\"],\"validationType\":\"full\"}";
			//System.out.println("inut"+inut);
			httppost.setEntity(new StringEntity(inut));
			HttpResponse = HttpClient.execute(httppost);
			httppost.addHeader("Content-Type", "application/json");
			httppost.addHeader("apiVersion", "v2");
			httppost.addHeader("mode","sc");
			
		}
		/*public static void getResponseStatusCode() {
			int statuscode = HttpResponse.getStatusLine().getStatusCode();
			System.out.println(statuscode);
			
		}*/
		

	}

}
